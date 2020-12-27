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
