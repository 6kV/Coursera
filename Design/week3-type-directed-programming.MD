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


