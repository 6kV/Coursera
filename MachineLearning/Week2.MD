### Linear regression with multiple variables (multivariate)

Week 1, on a fait une regression linéaire avec une seule variable, imaginons que nous avons plusieurs mnt => nbre de chambres, années de construction, étage...

les variables (nbre de chambre...), on appelle ça aussi **features**  

 - n : nombre de feature
 - x(i) : vecteur (ligne d'un training exple)
 - x(i)(j)
 
 l'équation à résoudre devient par exple :   
 
 h(x) = O0 + O1 x1 + O2 x2 + O3 x3 + O4 x4  
      = O(transpose) X
 
 ### Gradient descent for multiple variables
 
 repeat until convergence
 {
   - θ0 := θ0 − α1 m ∑ i=1m (hθ(x(i))−y(i)) x0(i)   
   - 0θ1:= θ1 − α1 m ∑ i=1m (hθ(x(i))−y(i)) x1(i)   
   - 0θ2:= θ2 − α1 m ∑ i=1m (hθ(x(i))−y(i)) x2(i)  
   
}
 
