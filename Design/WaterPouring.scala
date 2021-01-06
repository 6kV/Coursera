package quickcheck

class WaterPouring(capacity: Vector[Int]) {

  // On peut remplir un verre d'eau
  // vider un verre d'eau
  // transférer d'un verre à l'autre jusqu'a ce que le premier verre est vide
  // ou le second est plein

  type Glass = Int
  type State = Vector[Int]

  // On crée des paths jusqu'a trouver un state qui a la valeur de remplissage de verre voulu

  val initialState = capacity map (_ => 0)

  // Moves

  trait Move{
    def change(state: State) : State
  }
  case class Empty(glass: Glass) extends Move {
    override def change(state: State): State = state updated(glass,0)
  }
  case class Fill(glass: Glass) extends Move {
    override def change(state: State): State = state updated(glass,capacity(glass))
  }
  case class Pour(from: Glass, to: Glass) extends Move {
    override def change(state: State): State = {
      val amount = state(from) min (capacity(to) - state(to))
      state updated (from, state(from) - amount) updated (to, state(to) + amount )
    }
  }

  // renvoie un Range
  val glasses: Range = capacity.indices

  val moves = (for (g <- glasses) yield Empty(g)) ++
   (for (g <- glasses) yield Fill(g)) ++
   (for (from <- glasses; to <- glasses if ( from != to)) yield Pour(from,to))


  class Path(history: List[Move]){
    def endState: State = (history foldRight initialState )(_ change _)
    def extend(move: Move): Path = new Path(move :: history)

    override def toString: String = (history.reverse mkString "") + " ---> " + endState
  }

  val initialPath : Path = new Path(Nil)

  def from(paths: Set[Path], explored: Set[State]) : Stream[Set[Path]] =
    if ( paths.isEmpty) Stream.empty
    else {
      // states
      val more = for {
        path <- paths
        next <- moves map path.extend
        if  !(explored contains next.endState)
      } yield next

      paths #:: from(more, explored ++ (more map (x => x.endState) ))
    }

  val pathSets = from(Set(initialPath), Set())

  def solution(target: Int): Stream[Path] =
    for {
      pathSet <- pathSets
      path <- pathSet
      if path.endState contains  target
    } yield path
}
