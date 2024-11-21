# Warsztaty statystyka i analiza danych

## Pierwsze zajęcia

**Poziom istotności** - szansa na odzrucenie hipotezy zerowej 
**$\alpha$ = poziom swobody (istotności)**

**R-squared** dopasowanie danych do modelu od 0 do 1

p-value > $\alpha$ ok

p-value < $\alpha$ odrzuć $H_0$ (hipotezę zerową)


## Drugie zajęcia - Rozkłady

[materiały z strony](https://pbiecek.github.io/Przewodnik/Programowanie/generatory_2.html)

### Dystrybuanta

prawdopodopieństwo że w punkcie $x_0$ moja zmienna przyjme wartość mniejszą niż to $x_0$

Maksymalna wartość dystrybuanty to pole pod wykresem danej funkcji opisujące zjawisko

#### Zapis dystrybuanty  dla $x_0$

$$ 
P(x_0)
$$

---
### Zadania w R

```R
x = seq(from=-10, to=10, by=0.01) #tworzy rozkład wartości
curve(dnorm(x, 0,1), xlim=c(-10,10), ylim=c(0, 1.05)) # rysowanie wykresu
curve(dnorm(x, 2, 0.5), col="red", add=T) # add=T dodaje do porzedniego wykresu
curve(pnorm(x, 0,1),col="green", add=T)

x1 = pnorm(-1, 0,1) # punkt, wartość oczekiwana (maksimum),parametr rozkładu
```
**kwantyl** to wartość na osi $x$ od której oznacza się pole destrybuanty

```R
#liczenie kwantylu dla dystrybuanty 0.05
x2=qnorm(0.05, 0, 1) #kwantyl
pnorm(x2, 0, 1) #sprawdzenie dystrybuanty
```
### Wykres normalności 
zapisywanie wykresu funkcji w postaci liniowej przez dobór odpowiedniej osi

```R
set.seed(1234) 
x=runif(100,-2,2) #losowanie zbioru
x0=runif(1000,-2,2) #losowanie zbioru
qqnorm(x) #rozkład normalny
qqnorm(x0)

shapiro.test(x0) #test na wykres normalny
```

### Zapis wykresu do pdf

```R
> pdf("wykres.pdf")
> qqnorm(x2) # funkcja wykresu
> dev.off()
```
---
## Trzecie zajęcia

### Średnia rozkładu

### Mediana rozkłądu

### Rozkłady skośności
- lewostronny
- prawostronny

### Miara koncentracji (kurtoza)
Ustalony wzg rozkłau normalnego
- klasyczna kurtoza dla rozkładu normalnego wynoci $k = 3$
- kurtoza poprawiona $k' = k - 3$

---

```R
# 10 liczb losowych z rozkładu normalnego o rozkładzie 1

x = rnorm(10,0,1)

# średnia
sr = mean(x)
# lub
sr1=sum(x)/length(x)
```
---

### Kiedy nie liczymy średniej?
- gdy rozkład nie przypomina rozkładu normalnego
- gdy nie jest symetryczny
- gdy nie jest jedno modalny (ma dwa piki)
- gdy ma dużo na końcach

**Liczymy wtedy mediane:**


```R
median(x)

x = sort(x, decreasing=T)
(x[5]+x[6])/2

```
---

### Odczylenie standardowe
 $$
s = \sqrt{\dfrac{\sum_{i=1}^{n}{(x_i-\bar{x})^2}}{n}}
 $$

---
```R
ods = sd(x) # !!! estymator z próby na 

# OCHYLENIE STANDARDOWE DLA NASZEJ PRÓBY
s = sqrt(sum((a - mean(a)^2))/length(x))

```
## Zamiast liczenia odczylenia (gdy nie jest to rozkład normalny)
### Obliczanie zakresu międzykwartylowego

```R
IQR(x)
```

### Wyznaczanie kwantylu rozkładu

``` R
quantile(x, 0.25, type=1)
```
### Pakiet moments

```R
library(moments)
skeweness(x)
kurtosis(x) # obliczanie kurtozy
```

## Struktury danych

### Ramka danych

```R
# TWORZENIE RAMKI DANYCH

# trzy wektory
b1 = c(1:7)
b2 = rnorm(7)
b3 = c(18:11)

# SPRAWDZENIE CZY JEST WARTOŚCIĄ NUMERYCZNĄ 
is.numeric(b3)

ramka1 = data.frame(cbind(b1, b2, b3))
ramka2 = data.frame(rbind(b1, b2, b3))


ramka4 = stack(ramka1)

# ----- import danych -----

dane1=read_excel("Zanieczyszczenia.xls", col_names=F)
x1=dane1$...1
x2=dane1$...2
x3=dane1$,..3

# przekształcenie do ramki danych
as.data.frame()

```

### Macierze 

```R
y = matrix(data = dataVec, nrow = nrow, ncol = ncol, byrow = byrow)
y2 = y*2 # mnożenie wszystkich elementów macierzy

y3 = y%*%y2 # mnożenie macierzy

```


## Czwarte zajęcia 

### Modele liniowe

**Pojęcia:**

- metoda najmniejszych kwadratów (rozkład reszt ma być rozkładem normalnym)
- **Fitted value** - wartość z modelu
- **Reszta:**  $e_i = y_i - y_{fitted}$ 
- metoda największej wiarygodności
- test studenta - Hipoteza robiona dla każdego parametru
- test walda (test serii) 


### **Czy model jest liniowy względem zmiennej czy parametru?**
**model:**
$$y = \beta_0 \cdot x_0 + \beta_1 \cdot x_1 + ... +\beta_i \cdot x_i $$
**Sprawdzamy:**
$$\dfrac{\delta}{\delta}=$$

>Dane nie mogą układać się w lej !!! Wtedy błąd odchylenia wzrasta
 
**Obserwacja wpływowa** - najdalsza wartość $x$ od średniej danych ($x_{śr}$), należy rozważyć istotność tej dane

**Dane o dużych resztach** mają największy wpływ na model

**Reszty pokazują przypadki**

```R 
moel=lm(y~x)
summary(model)

Call:
lm(formula = y ~ x)

Residuals:
    Min      1Q  Median      3Q     Max 
-1.7333 -1.1333 -0.3833  0.7417  3.1167 

Coefficients:
             Estimate Std. Error t value Pr(>|t|)    
(Intercept) -87.51667    5.93694  -14.74 1.71e-09 ***
x             3.45000    0.09114   37.85 1.09e-14 ***
---
Signif. codes:  0 ‘***’ 0.001 ‘**’ 0.01 ‘*’ 0.05 ‘.’ 0.1 ‘ ’ 1

Residual standard error: 1.525 on 13 degrees of freedom
Multiple R-squared:  0.991,     Adjusted R-squared:  0.9903 
F-statistic:  1433 on 1 and 13 DF,  p-value: 1.091e-14

```
**Estymatory** tzw *'szacowacze'* opisujące parametry $\beta$

***t-value*** wartość statystyczna rozkładu studenta

# Piąte zajęcia

```R

m = matrix(1:16, nrow=4)

m
#      [,1] [,2] [,3] [,4]
# [1,]    1    5    9   13
# [2,]    2    6   10   14
# [3,]    3    7   11   15
# [4,]    4    8   12   16
 dim(m)

# [1] 4 4
 diag(m)

# [1]  1  6 11 16
 det(m)

# [1] 0
 tr(m)

# [1] 34
```

### Diagonalne

``` R

m = matrix(1:16, nrow=4)

m

    #  [,1] [,2] [,3] [,4]
# [1,]    1    5    9   13
# [2,]    2    6   10   14
# [3,]    3    7   11   15
# [4,]    4    8   12   16
 dim(m)

# [1] 4 4
 diag(m)

# [1]  1  6 11 16
 det(m)

# [1] 0
 tr(m)

# [1] 34

```

### Powtórzenia
```R

> rep(2,9)

[1] 2 2 2 2 2 2 2 2 2
> rep(c(2,4),3)

[1] 2 4 2 4 2 4
> rep(c(2:4),3)

[1] 2 3 4 2 3 4 2 3 4
> m2 = matrix(rep(c(2:4),3), nrow=3)

> m2

     [,1] [,2] [,3]
[1,]    2    2    2
[2,]    3    3    3
[3,]    4    4    4
> det(m2)

[1] 0

```
### Równanie modelu

 $$
    y = b_0 + b_1 \cdot x + \dots +\varepsilon
 $$

>!!! decyzja o wyłączeniu danych nieistotnych decydujemy my 

x - zmienne nie zależne
y - zmienne zależne

>!!! jeśli $x_i$ jest zależne w jakiś sposób od $x_j$ to model nie będzie dokładny, w takiej sytuacji mówimy o zależności cech


***!!!! Zadania domowe wysyłać  na adress: wojciech.nowak@uwr.edu.pl***

```R
core(states1) #tworzenie macierzy koleracji danych 
```
```
Coefficients:
             Estimate Std. Error t value Pr(>|t|)    
(Intercept) 1.235e+00  3.866e+00   0.319   0.7510    
Population  2.237e-04  9.052e-05   2.471   0.0173 *  
Illiteracy  4.143e+00  8.744e-01   4.738 2.19e-05 ***
Income      6.442e-05  6.837e-04   0.094   0.9253    
Frost       5.813e-04  1.005e-02   0.058   0.9541    
---
Signif. codes:  0 ‘***’ 0.001 ‘**’ 0.01 ‘*’ 0.05 ‘.’ 0.1 ‘ ’ 1

Residual standard error: 2.535 on 45 degrees of freedom
Multiple R-squared:  0.567,     Adjusted R-squared:  0.5285 
F-statistic: 14.73 on 4 and 45 DF,  p-value: 9.133e-08
```
$\alpha = 0.05$


### **Patrzymy na Pr(>|t|)**
Population i Illiteracy są poniżej 5%, dlatego odrzucamy $H_0$
gdzie zakładamy, że ich $\beta$ są zerowo, co znaczy, że są istotne dla modelu

### **Patrzymy na p-value** 
jest ono mniejsze niż $\alpha$ odrzuccamy $H_0$ dla modelu

***po stworzeniu modelu jedynie dla koleracji Murder z Population i Illiteracy R-squared się zmniejsza, model staje się dokładniejszy, lepszy***

funkcja `AIC()` zwraca jakość modelu, mniejszy jest lepszy
>---
>```R
>model0=lm(Murder~Population+Illiteracy+Income+Frost, data=states1)
>
>AIC(model0)
>
># [1] 241.6429
>model1=lm(Murder~Income+Frost, data=states1)
>
>model2=lm(Murder~Population+Illiteracy, data=states1)
>
>AIC(model1)
>
># [1] 261.4597
>AIC(model2)
>
># [1] 237.6565
>
>```
>---

## Szóste zajęcia

$adj~R^2=1-\dfrac{(1-R^2)(N-1)}{N-p-1}$

### Wyciąganie reszt z modelu

- reszty surowe
>---
>``` R   
>   r_s = residuals(model)
>   SSe = sum(r_s^2) # suma kwadratu reszt
>  
>   df = n - k -1
>   # n - obserwacje
>   # k - ilość predykcji 
>   
>   MSE = SSe/df # w modelach regresyjnych dzielenie sumy kwadratu 
>
>   SSE = sqrt(MSE) # SSE wykorzystujemy do standaryzowania reszt
>```
>---
- **reszty standaryzowane**
```R    
r_stand = rstandard(model)
```
- **reszty studentyzowane**
```R
r_stud = rstudent(model)
```

>### Liczenie reszt standardowych
>```R 
>r_stand = residuals(model) / SSE 
> # lub
> hat = hatvalues(model)
> r_stand = r_s / (SSE*sqrt(1-hat))
>```
> **Reszta standaryzowana** nie powinna być większa niż $2$
>
>---
### Zmienne o dużym $x$ chcą być wpływowe
*efekt dźwigni*

### Duże reszty 
*większe reszty zakłócają model*

### Dystans hook'a

*hat*

>---
>```R 
> influencePlot(model) # robi wykres wpływu danej na model, większe koło większy wpływ 
>
>```
>---

### Test NCV

>---
>```R
>ncvTest(model)
>```
> ---

### Test Durbina Wotsona

>---
>```R
>durbinWatsonTest(model)
>```
> Sprawdza korelacje reszt modelu, korelacja pomiędzy sąsiednimi danymi powinny wynosić zero
> 
> **Załóżenia:**
> - model ma wyraz wolny
> - przynajmniej 15 prób
>
>---


## Siódme zajęcia 

>---
>```R
> sklep1 = dane1$sklep1
> sklep2 = dane1$sklep2
> sapiro.tet(sklep1)
> sapiro.test(sklep2)
>```
>---

#### Test studenta

>---
>```R
> var.test(sklep1, sklep2)
>```
>---

$p-value~<~\alpha$ musimy odrzucić hipoteze zerową

> - test sudenta tylko dy ilość wariancj jest różna
> - test welsha stosujemy gdy nie ma równej ilości wariancji

### TEST Manna-Whitneya
*test sumerarny* **test pierwszego wyboru jesli nie są spełnione założenia numeralne"

*hipoteza 0* dystrybuanty/mediany są takie same