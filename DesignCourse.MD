# Week 1 : For Expressions & Monads
### For Expressions
- For expressions used as Queries

```scala
val books: List[Book] = List(new Book("hello", List("nizar","c")), new Book("test", List("a","b")))

for (b <- books; a <-b.authors if a == "nizar" ) yield b.title
```
### Translation of For

map, flatmap & filter => can be expressed using For expression  
Scala compiler will transform For expression to a combination of map,flatmap & filter

```scala
val n = 10
(1 until n ) flatMap( i => (1 to i).withFilter( j => isPrime(i+j)).map(j => (i,j)))

for ( i <- 1 until n;
      j <- 1 until i if isPrime(i+j)) yield (i,j)
```

withFilter c'est la même chose que filter mais ça économise des allocations mémoires intermédiaires  

Les For Expressions ne sont pas limités au collections, elle s'applique à toutes les structures avec map, flatmap et withFilter. (even your own types)

See : ScalaQuery & Slick

### Functional Random Generators
See : ScalaCheck

### Monads

Monad : Data Structure that implements map, flatmap and they should have some algebric laws

```scala
trait Monad[T]{
  def flatMap[U](f : T => Monad[U]) : Monad[U]
}

def unit[T](x: T): Monad[T]
```
Monad => 2 operations : flatmap & unit  
sometimes flatmap is called bind

List, Set, Option, Generator are monads  
map can be expressed by flatmap and unit 
```scala
m map f ==  m flatmap ( f andThen unit)
```
Monads Law : 
 + Associativity
 + Left Unit : unit(x) flatmap f == f(x) 
 + Right Unit : m flatmap unit == m 
 
 
 Associativity is important for For expression : we can inline nested For Expression
 Right Unit => For ( x <- m ) yield x == m
 
 # Week 2 : Lazy Evaluation
 
 ###  Structural Induction on Trees
 Induction Structurelle (ou récursivité Structurelle) : est une méthode de preuve utilisé en logique mathématique, en informatique, en théorie des graphes... Elle est utilisé pour prouver qu'une proposition P(x) est valable pour tout x d'une sorte de strucutre définie de maniére récursive comme des formules, des graphes...   
 
 Pour prouver l'induction structurelle sur un Tree
 P(1) 
 si T a des sous arbres s1,s1,... sn alors P(s1) P(s2)... p(sn) impliquent P(T)
 
 ### Stream
 Stream (flux) évalué à la demande  
 avoid computing the tail of sequence until it is needed for the evaluation result (which might be never)

```scala
(1 to 1000).toStream           res: Stream[Int] = Stream(1,?)
```

On peut utiliser toutes les méthodes de list sur les Stream
:: devient #::

: => (call by name) utilisé pour les stream :)

### Lazy Evaluation

Haskell use by default Lazy evaluation  
Scala use by default struct evaluation  

```scala
def expr = {
    val x = { print("x"); 1 }  
    lazy val y = { print("y"); 2 }  
    def z = { print("z"); 3 }  
    z + y + x + z + y + x
 }
```

this will print xzyz

### Computing with Infinete sequences

faisable grace aux Lazy evaluation
