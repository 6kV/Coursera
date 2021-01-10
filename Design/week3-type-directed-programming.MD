### implicit 

```scala
def sort[A](xs: List[A])(***implicit*** ord: Ordering[A]): List[A] = 
```


=> The compiler infers the argument ***value*** based on its ***expected type***. (contrairement au val x = 42 ou scala infere le type à partir de la valeur, là, on infére la val à partir du type)  

```scala
scala> implicit val x: Int = 0
scala> def f(implicit n: Int) = print(n)
scala> f
       0
```

### Context Bounds

un peu de sucre syntaxique 

```scala
def printSorted[A](as: List[A])(implicit ev1: Ordering[A]): Unit = {
  println(sort(as))
}
```
peut être réécri comme ça :

```scala
def printSorted[A: Ordering](as: List[A]): Unit = {
  println(sort(as))
}
```

### Implicit query

```scala
scala> implicitly[Ordering[Int]]
res0: Ordering[Int] = scala.math.Ordering$Int$@73564ab0
```

La classe Ordering est un ***typeclass***  

Type classes provide a form of polymorphism: they can be used to implement algorithms that can be applied to various types. The compiler selects the type class implementation for a specific type at compile-time.

A type class definition is a trait that takes type parameters and defines operations that apply to these types. Generally, a type class definition is accompanied by laws, checking that implementations of their operations are correct.

 + implicit definitions can also take implicit parameters
 + an arbitrary number of implicit definitions can be chained until a terminal definition is reached
 
 ### implicit conversion 
 
 They make it possible to automatically convert an expression of a given type to an expression of a different type.

```scala

object Json {
  import scala.language.implicitConversions
  implicit def stringToJson(s: String): Json = JString(s)
  implicit def intToJson(n: Int): Json = JNumber(n)
  ...
}
```

### extension method 

```scala

case class Duration(value: Int, unit: TimeUnit)

object Duration {

  object Syntax {
    import scala.language.implicitConversions
    implicit class HasSeconds(n: Int) {
      def seconds: Duration = Duration(n, TimeUnit.Second)
    }
  }

}
```


