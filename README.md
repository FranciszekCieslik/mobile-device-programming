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

Kompozycja
