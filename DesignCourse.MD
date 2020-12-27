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
