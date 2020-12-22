# Coursera-Scala

SBT : similar to Maven or Ant  
command sbt about to check the version  
build.sbt correspond au pom.xml  

## Week 1
3 paradigms principaux en informatique :
 + Fonctionnelle
 + imperative
 + logique
 
le OO est orthogonal aux 3 paradigmes.

### imperative
+ modifiying mutables variables
+ using assignements
+ control structures such as if-then-else, loops, break

-> instruction sequences as a Von Neumann computer
computer = processeur, memory, bus qui lie les deux (32,64 bits)

theory : one or more datatype
 operations on these types
 law that describe the relationships between values and operations
 
 -> doesn't describe mutation

 ### Functional
 
 + programming without mutables variables, assignements, loops and other imperative control structures
 + focusing in functions
 + functions can be values that are produced, consumed and composed
 + all this becomes easier in a functional language
 
 pkoi ?
  + simpler reasoning principles
  + better modularity
  + // for multicore
  
call by name / call by value  
tailrec  
substiution model  

anonymous function are syntax sugar
interet de la currification ?
(Haskell Brooks Curry)
Scala keeps the names of types and values un different namespaces, so, no, conflict
infix 

persistant data structures
dynamic binding : the code invoked by method call depends on the runtime type of the object that contains the method

trait ( ressemeble interface java)
Any :
 + AnyVal: All primitives
 + AnyRef: Alias Of java.lang.Object
 
 
 Nothing : tout en bas de la hierarchie de classe Scala, sous type de toutes les classes  
 There is no value of type Nothing  
  + signal abnormal termination
  + as an element tpe of empty collection
  
  Null type of null value, sous types de toutes les AnyRef
  
  val x = null // x: Null
  
  type parameters are written in square brackets, e.g []
  2 principal form of polymorphism : subtype and generic
  
  
  Fucntions are treated as objects in scala -> Function[1,B]
  eta expansion?
  
  Covariance
  
  Class Foo[+A] // Covariant Class
  Class Bar[-A] // Contravariant Class
  Class Baz[A] // Invariant Class
  
  Pattern matching
  
  Lists are immutables (# Arrays)
  List are recuesive (# flat on arrays)
  
  x ::xs
  val nums = 1 :: 2 :: 3 :: 4 :: Nil
  Nil.::(4).::(3)
  
  it is possible to decompose list with pattern matching
  1 :: 2 :: xs lists that start with 1 and then 2
  
  
  list ++ list2
  list take n
  list drop n
  list splitAt
  Pair(x,y)
  Tuple
  
  penser au merge avec pattern matching et pari ( qui fait ressortir la symétrie de l'algo)
  Ordering
  Keyword implicit
  

