# mobile-device-programming

### **Notatki z Kotlina/Java i Android Studio**

---

### **1. Aktywność (Activity)**

- **Definicja:**  
  Aktywność to jeden z głównych komponentów Androida, reprezentujący pojedynczy ekran z interfejsem użytkownika (UI). Każda aplikacja może mieć wiele aktywności, a użytkownik przechodzi między nimi.

- **Przykład:**  
  - Ekran logowania → Aktywność A  
  - Ekran główny → Aktywność B  

- **Kluczowe metody w aktywności:**  
  - `onCreate()` – Wywoływana podczas tworzenia aktywności. Inicjalizacja widoków.
  - `onStart()` – Aktywność staje się widoczna dla użytkownika.
  - `onResume()` – Aktywność przechodzi na pierwszy plan i użytkownik może z nią wchodzić w interakcje.
  - `onPause()` – Aktywność traci fokus, ale wciąż jest widoczna.
  - `onStop()` – Aktywność nie jest już widoczna.
  - `onDestroy()` – Aktywność jest niszczona (np. zamknięcie aplikacji).

---

### **2. Cykl życia aplikacji**

- **Opis:**  
  Cykl życia aplikacji Androida określa stany, przez które przechodzi aplikacja, od uruchomienia aż po zamknięcie. Każdy komponent aplikacji (np. aktywność, fragment) ma swój cykl życia.

- **Schemat cyklu życia aktywności:**  
  1. **Uruchomienie aplikacji:**
     - `onCreate()` → `onStart()` → `onResume()`
  2. **Minimalizacja aplikacji:**
     - `onPause()` → `onStop()`
  3. **Zamknięcie aplikacji:**
     - `onPause()` → `onStop()` → `onDestroy()`

- **Klasa `LifecycleOwner`:**  
  Umożliwia łatwe zarządzanie cyklem życia przy użyciu komponentów AndroidX.

---

### **3. RecyclerView**

- **Definicja:**  
  RecyclerView to zaawansowana i wydajna wersja ListView, używana do wyświetlania dużych zbiorów danych w formie listy, siatki lub innych układów.

- **Cechy:**  
  - Używa **ViewHolder**, aby zminimalizować liczbę wywołań `findViewById` i poprawić wydajność.  
  - Obsługuje recykling widoków, co zmniejsza zużycie pamięci.  
  - Elastyczne zarządzanie układem (LinearLayoutManager, GridLayoutManager, StaggeredGridLayoutManager).

- **Podstawowe komponenty:**  
  1. **Adapter:**  
     Łączy dane z widokami.
  2. **ViewHolder:**  
     Przechowuje odniesienia do widoków, aby poprawić wydajność.
  3. **LayoutManager:**  
     Określa, jak elementy są wyświetlane (np. lista, siatka).

- **Przykład:**  
  ```kotlin
  recyclerView.layoutManager = LinearLayoutManager(context)
  recyclerView.adapter = MyAdapter(dataList)
  ```

---

### **4. Kontekst (Context)**

- **Definicja:**  
  Kontekst to abstrakcyjna klasa, która zapewnia dostęp do zasobów, usług i informacji o stanie aplikacji.

- **Rodzaje kontekstu:**  
  1. **`Activity Context`** – Powiązany z cyklem życia aktywności.  
  2. **`Application Context`** – Żyje przez cały czas działania aplikacji.

- **Przykłady zastosowania:**  
  - Uzyskanie dostępu do zasobów (`context.getResources()`).  
  - Tworzenie nowych widoków (`TextView(context)`).  
  - Startowanie nowych aktywności (`context.startActivity(intent)`).

---

### **5. Intenty**

- **Definicja:**  
  Intenty to obiekty służące do komunikacji między komponentami aplikacji (np. aktywnościami, usługami) lub z innymi aplikacjami.

- **Rodzaje:**
  1. **Explicit Intent (Jawny):**  
     Określasz dokładnie, który komponent ma być uruchomiony.  
     ```kotlin
     val intent = Intent(this, SecondActivity::class.java)
     startActivity(intent)
     ```
  2. **Implicit Intent (Niejawny):**  
     Używany, gdy chcesz wykonać określoną akcję (np. otworzyć przeglądarkę).  
     ```kotlin
     val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://example.com"))
     startActivity(intent)
     ```

- **Dodatki:**  
  Możesz przekazywać dane za pomocą `putExtra`:  
  ```kotlin
  intent.putExtra("key", "value")
  ```

- **Odbieranie danych w nowej aktywności:**  
  ```kotlin
  val value = intent.getStringExtra("key")
  ```

---

### **Podsumowanie**

- **Aktywność** to ekran w aplikacji z własnym cyklem życia.  
- **Cykl życia aplikacji** pozwala zarządzać zachowaniem aplikacji w różnych stanach.  
- **RecyclerView** to wydajny sposób wyświetlania dużych zbiorów danych w różnych układach.  
- **Kontekst** to klasa, która zapewnia dostęp do zasobów i usług systemowych.  
- **Intenty** służą do komunikacji między komponentami aplikacji.

### **Czym jest `Parcelize`?**

`Parcelize` to adnotacja w Kotlinie, która automatycznie generuje implementację interfejsu `Parcelable` dla klasy. W Androidzie `Parcelable` jest mechanizmem pozwalającym na efektywne przesyłanie danych między komponentami aplikacji (np. między aktywnościami, fragmentami lub usługami).

---

### **Jak działa `Parcelable` i `Parcelize`?**

#### **1. `Parcelable` w Androidzie**
- `Parcelable` to interfejs Androida, który umożliwia serializację obiektów do formatu, który może być zapisany i odczytany z `Parcel`.
- Jest szybszy od `Serializable`, ponieważ został zoptymalizowany do użycia w Androidzie.
- Jednak ręczne implementowanie metod `writeToParcel()` i `createFromParcel()` może być żmudne i podatne na błędy.

#### **2. `@Parcelize`**
- Kotlin upraszcza tę pracę dzięki adnotacji `@Parcelize`. Po jej użyciu kompilator automatycznie generuje niezbędny kod dla interfejsu `Parcelable`.
- Klasa oznaczona `@Parcelize` musi być **data class**.

---

### **Jak używać `@Parcelize`?**

#### **Krok 1: Dodanie zależności**
Upewnij się, że masz włączone `kotlin-parcelize` w pliku `build.gradle`:

```kotlin
plugins {
    id 'kotlin-parcelize'
}
```

#### **Krok 2: Oznaczenie klasy adnotacją `@Parcelize`**

Przykład prostej klasy danych:

```kotlin
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: Int,
    val name: String,
    val email: String
) : Parcelable
```

#### **Krok 3: Przesyłanie obiektów między komponentami**

**Wysyłanie obiektu w `Intent`:**
```kotlin
val user = User(1, "Jan Kowalski", "jan.kowalski@example.com")
val intent = Intent(this, SecondActivity::class.java)
intent.putExtra("user_data", user)
startActivity(intent)
```

**Odbieranie obiektu w nowej aktywności:**
```kotlin
val user = intent.getParcelableExtra<User>("user_data")
user?.let {
    println("ID: ${it.id}, Name: ${it.name}, Email: ${it.email}")
}
```

---

### **Zalety `@Parcelize`**

1. **Prostota**:  
   - Adnotacja `@Parcelize` eliminuje konieczność ręcznej implementacji `Parcelable`.

2. **Mniejszy kod**:  
   - Kompilator generuje kod w tle, co minimalizuje ryzyko błędów.

3. **Wydajność**:  
   - `Parcelable` jest bardziej wydajny niż `Serializable`.

4. **Czytelność**:  
   - Klasa z adnotacją `@Parcelize` jest bardziej czytelna i zwięzła.

---

### **Przykłady zastosowania**

1. **Przekazywanie danych między aktywnościami**  
   Idealne, gdy chcesz przekazać złożone obiekty, np. `User`, między różnymi ekranami aplikacji.

2. **Przechowywanie stanu w fragmentach**  
   Możesz użyć `Parcelable` do zapisywania i przywracania stanu fragmentu.

3. **Użycie w `Bundle`**  
   Możesz dodać obiekt jako część `Bundle` i przekazać go do fragmentu.

---

### **Różnice między `Parcelable` i `Serializable`**

| **Cechy**         | **Parcelable**                            | **Serializable**                          |
|--------------------|-------------------------------------------|-------------------------------------------|
| **Wydajność**      | Bardzo wydajne, zoptymalizowane dla Androida | Wolniejsze, bo używa refleksji           |
| **Łatwość użycia** | Ręczna implementacja lub `@Parcelize`     | Proste, ale mniej wydajne                 |
| **Przenośność**    | Działa tylko w Androidzie                | Może być używane w innych platformach Javy|

---
### **Serializacja obiektów – Co to jest?**

**Serializacja** to proces konwersji obiektu w formacie pamięci wewnętrznej (np. w programie) na format, który można przechowywać lub przesyłać, np. jako:
- **Plik** (np. JSON, XML, binarny),
- **Strumień danych** (np. sieciowy lub zapisywany w bazie danych).

W kontekście programowania w Androidzie lub Javie oznacza to zapisanie stanu obiektu tak, aby można go było łatwo odtworzyć w przyszłości lub przesłać między różnymi systemami.

---

### **Dlaczego potrzebujemy serializacji?**

1. **Przechowywanie danych:**
   - Serializacja umożliwia zapisanie obiektu na dysku lub w bazie danych.

2. **Przesyłanie danych:**
   - Obiekty mogą być przesyłane przez sieć (np. HTTP, WebSocket).

3. **Przekazywanie danych w aplikacji:**
   - W Androidzie serializacja jest używana np. do przesyłania danych między aktywnościami czy fragmentami (np. z `Parcelable`).

---

### **Jak działa serializacja w Javie?**

#### **1. Użycie interfejsu `Serializable`**

- Klasa musi implementować interfejs `Serializable`.  
- Nie wymaga ręcznej implementacji metod – Java automatycznie obsługuje ten proces.

**Przykład:**
```java
import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Gettery i settery
}
```

**Zapisywanie obiektu do pliku:**
```java
FileOutputStream fileOut = new FileOutputStream("user.ser");
ObjectOutputStream out = new ObjectOutputStream(fileOut);
out.writeObject(new User("Jan", 25));
out.close();
fileOut.close();
```

**Odczytywanie obiektu z pliku:**
```java
FileInputStream fileIn = new FileInputStream("user.ser");
ObjectInputStream in = new ObjectInputStream(fileIn);
User user = (User) in.readObject();
in.close();
fileIn.close();

System.out.println("Name: " + user.getName() + ", Age: " + user.getAge());
```

---

### **Serializacja w Androidzie**

W Androidzie serializacja obiektów jest realizowana głównie przy pomocy dwóch mechanizmów:
1. **`Serializable`** – Wbudowany w Javę, łatwy w użyciu, ale wolniejszy i mniej wydajny.  
2. **`Parcelable`** – Specjalny interfejs Androida, zoptymalizowany do przesyłania danych w `Intent` lub `Bundle`.

---

### **Różnica między `Serializable` a `Parcelable`**

| **Cechy**          | **Serializable**                          | **Parcelable**                             |
|---------------------|-------------------------------------------|-------------------------------------------|
| **Wydajność**       | Wolniejsze, bo używa refleksji            | Szybsze, zoptymalizowane dla Androida      |
| **Łatwość użycia**  | Proste w implementacji                   | Ręczne kodowanie lub użycie `@Parcelize`   |
| **Przenośność**     | Może być używane poza Androidem          | Działa tylko w Androidzie                 |

---

### **Podsumowanie**

Serializacja pozwala:
1. Zapisywać stan obiektów w formacie zewnętrznym.
2. Przesyłać dane między różnymi komponentami systemu lub siecią.
3. W Androidzie zwykle używa się **`Parcelable`** do przesyłania obiektów między aktywnościami lub fragmentami, ponieważ jest szybsze i wydajniejsze niż klasyczne **`Serializable`**.

**Kompozycja** w kontekście Jetpack Compose w Android Studio to proces, w którym interfejs użytkownika (UI) jest budowany i zarządzany. W odróżnieniu od tradycyjnego podejścia opierającego się na XML, Jetpack Compose używa deklaratywnego modelu opisu UI. Kompozycja jest centralnym mechanizmem, który odpowiada za generowanie, aktualizację i ponowne renderowanie elementów interfejsu w odpowiedzi na zmiany stanu.

### Jak działa kompozycja?

1. **Definiowanie UI za pomocą `@Composable`**:
   - W Jetpack Compose interfejs jest definiowany za pomocą funkcji oznaczonych adnotacją `@Composable`.
   - Funkcja `@Composable` to podstawowy element, który opisuje strukturę i wygląd elementów UI.

   Przykład:
   ```kotlin
   @Composable
   fun Greeting(name: String) {
       Text(text = "Hello, $name!")
   }
   ```

2. **Rekompozycja**:
   - Jeśli dane (stan) używane w funkcji `@Composable` ulegają zmianie, Compose automatycznie przeprowadza **rekompozycję**.
   - Rekompozycja to proces odświeżania tylko tych części UI, które tego wymagają, co poprawia wydajność aplikacji.

   Przykład:
   ```kotlin
   @Composable
   fun Counter() {
       var count by remember { mutableStateOf(0) }
       Button(onClick = { count++ }) {
           Text("Kliknięcia: $count")
       }
   }
   ```
   Gdy użytkownik kliknie przycisk, zmiana stanu `count` wywoła rekompozycję, która odświeży tylko elementy zależne od tego stanu.

3. **Stan (State) i pamiętanie stanu (`remember`)**:
   - Kompozycja w Compose działa w połączeniu z zarządzaniem stanem aplikacji. 
   - Elementy takie jak `remember` i `mutableStateOf` pozwalają na zachowanie stanu wewnątrz funkcji `@Composable`.

4. **Hierarchia UI**:
   - Podczas kompozycji Jetpack Compose buduje hierarchię elementów UI w oparciu o wywołania funkcji `@Composable`. To tworzy tzw. "drzewo kompozycji", które jest dynamicznie zarządzane.

5. **Zalety kompozycji**:
   - **Deklaratywność**: UI jest wyrażane w prosty, czytelny sposób jako funkcje.
   - **Optymalizacja**: Tylko te części drzewa kompozycji, które muszą się zmienić, są odświeżane.
   - **Modularność**: Funkcje `@Composable` można łatwo łączyć i ponownie wykorzystywać.

### Przykład procesu kompozycji
1. Definiujesz komponenty:
   ```kotlin
   @Composable
   fun ProfileScreen() {
       Column {
           Greeting("Jan")
           Button(onClick = { /* obsługa kliknięcia */ }) {
               Text("Kliknij mnie")
           }
       }
   }
   ```

2. `ProfileScreen()` wywołuje inne funkcje `@Composable`, takie jak `Greeting` i `Button`. Jetpack Compose renderuje te elementy na ekranie.

3. Gdy zmienia się stan związany z przyciskiem, tylko ta część interfejsu zostaje odświeżona.

---

### Podsumowanie
Kompozycja w Jetpack Compose to proces:
- Tworzenia hierarchii elementów UI na podstawie funkcji `@Composable`.
- Automatycznego aktualizowania i renderowania UI w odpowiedzi na zmiany stanu.
- Optymalnego zarządzania wydajnością dzięki mechanizmowi rekompozycji.

# Jetpack Compose – Podstawy i Najważniejsze Funkcjonalności

## 1. Czym jest Jetpack Compose?
Jetpack Compose to nowoczesny toolkit UI od Google do budowy interfejsów użytkownika dla aplikacji Android. Jest oparty na zasadach programowania deklaratywnego, co oznacza, że zamiast manipulowania widokami za pomocą XML i kodu, programista opisuje, jak UI powinno wyglądać w odpowiedzi na dane aplikacji.

**Główne cechy Compose:**
- Deklaratywność: interfejs użytkownika jest tworzony jako funkcje Kotlinowe.
- Większa spójność i prostota w stosunku do XML.
- Ścisła integracja z innymi elementami Androida (LiveData, ViewModel).
- Łatwość zarządzania stanem aplikacji.

---

## 2. Jak Działa Jetpack Compose?
Jetpack Compose wykorzystuje funkcje Kotlin oznaczone jako `@Composable`. Te funkcje opisują elementy interfejsu użytkownika, a Compose zarządza ich życiem, aktualizacjami i renderowaniem.

Przykładowa funkcja `@Composable`:
```kotlin
@Composable
fun Greeting(name: String) {
    Text(text = "Hello, $name!")
}
```

**Proces aktualizacji UI w Compose:**
1. **Deklaratywność:** Funkcja jest wywoływana z odpowiednimi danymi.
2. **Rekompozycja:** Jeśli dane się zmienią, Compose odświeży tylko te elementy, które tego wymagają.
3. **Optymalizacja:** Compose minimalizuje ilość operacji renderowania.

### Jak działa `@Composable()`?
`@Composable` to adnotacja w Jetpack Compose, która oznacza funkcje odpowiedzialne za generowanie UI. Funkcja oznaczona tą adnotacją:
- Nie zwraca bezpośrednio UI (np. obiektów View), tylko opisuje strukturę UI.
- Może być wywoływana w innych funkcjach `@Composable`.
- Pozwala Compose na optymalne zarządzanie cyklem życia komponentów i wydajnością.

---

## 3. Kluczowe Elementy Jetpack Compose

### 3.1. `@Composable`
Oznacza funkcję, która tworzy UI. Każda funkcja `@Composable` może być użyta jako budulec innych funkcji.

### 3.2. **`Modifier`**
`Modifier` służy do dodawania stylizacji, logiki układu i obsługi zdarzeń do elementów UI.

Przykład:
```kotlin
Text(
    text = "Przykład Modifikatora",
    modifier = Modifier.padding(16.dp).background(Color.Gray)
)
```

**Najważniejsze właściwości Modifier:**
- `padding()`: dodaje odstępy wewnętrzne.
- `background()`: ustawia tło.
- `clickable()`: dodaje obsługę kliknięcia.
- `fillMaxSize()` / `wrapContentSize()`: zarządza przestrzenią na ekranie.

### 3.3. **State (Stan)**
Jetpack Compose zarządza stanem UI za pomocą mechanizmów takich jak `MutableState` i `remember`.

Przykład:
```kotlin
@Composable
fun Counter() {
    var count by remember { mutableStateOf(0) }

    Button(onClick = { count++ }) {
        Text(text = "Kliknięcia: $count")
    }
}
```

- `remember { mutableStateOf(0) }`: Przechowuje stan wewnątrz funkcji.
- Kiedy `count` się zmienia, Compose automatycznie odświeża funkcję.

### 3.4. **Material Design**
Compose wspiera Material Design, co pozwala szybko budować nowoczesne interfejsy.

Przykład karty z Material Design:
```kotlin
@Composable
fun CardExample() {
    Card(
        modifier = Modifier.padding(16.dp),
        elevation = 8.dp
    ) {
        Text(text = "Jestem kartą!", modifier = Modifier.padding(16.dp))
    }
}
```

---

## 4. Jetpack Compose Lists
Compose oferuje komponenty takie jak `LazyColumn` i `LazyRow`, które pozwalają na wyświetlanie długich list w wydajny sposób (lazy loading).

### **LazyColumn** (Lista pionowa)
```kotlin
@Composable
fun NameList(names: List<String>) {
    LazyColumn {
        items(names) { name ->
            Text(text = name, modifier = Modifier.padding(8.dp))
        }
    }
}
```
- `items()`: Funkcja iteruje po liście i tworzy elementy UI dla każdego elementu.

### **LazyRow** (Lista pozioma)
```kotlin
@Composable
fun HorizontalList(items: List<String>) {
    LazyRow {
        items(items) { item ->
            Text(text = item, modifier = Modifier.padding(8.dp))
        }
    }
}
```

---

## 5. Jetpack Compose Navigation
Compose Navigation pozwala na obsługę nawigacji pomiędzy ekranami w aplikacji.

### Konfiguracja
1. Dodaj zależność do `build.gradle`:
   ```gradle
   implementation "androidx.navigation:navigation-compose:2.7.2"
   ```

2. Zainicjalizuj kontroler nawigacji:
   ```kotlin
   val navController = rememberNavController()
   ```

3. Utwórz `NavHost`:
   ```kotlin
   @Composable
   fun MyApp() {
       val navController = rememberNavController()
       NavHost(navController = navController, startDestination = "home") {
           composable("home") { HomeScreen(navController) }
           composable("details") { DetailsScreen() }
       }
   }
   ```

4. Nawigacja między ekranami:
   ```kotlin
   @Composable
   fun HomeScreen(navController: NavController) {
       Button(onClick = { navController.navigate("details") }) {
           Text("Przejdź do szczegółów")
       }
   }
   ```

---

## 6. Podsumowanie
Jetpack Compose upraszcza tworzenie interfejsów w Androidzie dzięki podejściu deklaratywnemu i integracji z nowoczesnymi wzorcami architektonicznymi (np. MVVM). Kluczowymi elementami są:
- `@Composable` dla budowy UI.
- `Modifier` dla stylizacji i interakcji.
- `LazyColumn` i `LazyRow` do zarządzania listami.
- Jetpack Navigation do zarządzania przejściami między ekranami.

Wykorzystanie tych funkcjonalności umożliwia budowanie przejrzystych i wydajnych aplikacji.


