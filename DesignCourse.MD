# Week 1 : For Expressions & Monads
### For Expressions
- For expressions used as Queries

```scala
val books: List[Book] = List(new Book("hello", List("nizar","c")), new Book("test", List("a","b")))

for (b <- books; a <-b.authors if a == "nizar" ) yield b.title
```
