### Qu'est ce que le machine learing ?

+ Arthur Samuel (1958) : "The field of study that gives computers the ability to learn without being explicitly programmed"  
+ Tom Mitchel (???) : "A computer is said to learn from experience *E* with respect to some class of tasks *T* and performance measure *P*, if its performance at tasks in *T*, as measured by *P*, improves with experience *E*.

Example: Playing checkers 

+ *E* = the experience of playinh many games of checkers
+ *T* = the task of playing checkers
+ *P* = the probability that the program will win the next game

examples :
Spam, reconnaisance de l'ecriture, recommandations...

2 Type de machine learning :
 
+ **Supervised Learning** : pour chaque jeu de données, on connait la réponse
  - regression : predire un rendement valorisé continu
  - classification : (discrete valued output), exple (0,1)
+ **unsupervised Learning** : allow us to approach problems with little or no idea what our results should look like. (clustering)
  - penser au coktail party program (filtrer son)
  

Le jeu de données : **Training Set**  
h(x) = y => h = **hyothesis**

**Linear regression with one variable** h(x)= O0 + O1 x

l'idée est de **minimiser** 1/2 sum (i from 1 to m) (h(x(i)) - y(i))2 => **squared error function**

***Fonction dérivé*** : mesure l'ampleur du changement de la valeur de la focntion (valeur de sortie) par rapport à un petit changement de son argument (valeur d'entrée)  
En analyse : pente de la tangente au graphe f   
la dérivé partielle d'une fonction de plusieurs variables est sa dérivé par rapport à l'ine de ses variables, les autres étant gardés constantes  

***Gradient Descent*** : algorithme utilisé partout en machine learning  
repeat until convergence 

Oj != Oj - alpha * d/dOj (J(O0,O1))

alpha : learning rate  (taille du pas)

fonction convexe (forme d'un bol) 

## Matrix

dimension d'une matrice : nbre de row * nbre de colonnes
Aij

Vector = n*1 matrix

matrix vector multiplication : A3*2 * A2*1 = A3*1

ce qui est intéressant c'est qu'on peut représenter le linear regression with one variable avec une matrice

[1 prix1]         
[1 prix2]          [O0]  
[1 prix3]     *   [O1]   
[1 prix4]  
[1 prix5] 


inverse and transpose  
Am*m (square matrix)  

inverse A * A-1 = A-1 *  A = I (matrice avec en diagonale que des 1 et le reste des 0)  
matrix transpose => row becomes columns  
