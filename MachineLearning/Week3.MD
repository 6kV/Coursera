### Logistic regression

For supervised machine learning, classification (true, false, 0, 1), linear regression is not efficient
use instead logistic regression


 + g(z) = 1 / 1 + e^(-z) => logistic function or sigmoid function
 + hO(x) = g(Ot X)
 
 hO(x) devient une probabilité entre 0 et 1   
 hO(x) = P(y=1 | x;O) = probabilité que y = 1 sachant X parametrized by theta  
 
 **Decision Boudary** c'est le hO(x) = 0.5, ce qui sépare le monde >=0.5 et < 0.5
 
 ### Cost Function
 
 exponenetielle = exp => la seule fonction avec la propriété **f = f'** avec **f(0) = 1**
 si on déssine la tangente à n'importe quelle point x , la distance entre x et x1 (intersection de la tangente avec l'axe des abscisse) est toujours égale à 1
 
 la réciproque de exp est logarithme.

We cannot use the same cost function that we use for linear regression because the Logistic Function will cause the output to be wavy, causing many local optima. In other words, it will not be a convex function.

+ Cost(hO(x),y) = -log(hO(x)) if y =1
+ Cost(hO(x),y) = -log(1-h0(x)) if y= 0

