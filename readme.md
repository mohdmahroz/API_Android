# 🐾 Entity Explorer Android App

This Android application fetches data dynamically from a remote API and displays it in a user-friendly interface using Retrofit and RecyclerView. Users can tap on any entity to view detailed information on a separate screen.

---

## 📱 **Features**

✅ Fetches data from REST API using **Retrofit**  
✅ Displays list of entities in a **RecyclerView**  
✅ Uses **dynamic URL endpoints** based on entity type (e.g. animals, plants, etc.)  
✅ Opens a **Details page** to show full information about the selected entity  
✅ Clean, structured code using **models, adapters, and separate activities**

---

## 🔧 **Technical Stack**

- **Language:** Java
- **Networking:** Retrofit with GSON converter
- **UI:** RecyclerView, ConstraintLayout, ScrollView
- **Architecture:** Basic MVVM-ready structure (activities, models, adapters)

---

## 🚀 **How It Works**

1. **Retrofit setup**
    - A `RetrofitClient` singleton instance connects to the base URL.
    - `ApiService` interface defines endpoints with dynamic paths for different entities.

2. **Fetching data**
    - The app calls an endpoint like:
      ```
      https://nit3213api.onrender.com/dashboard/{entity}
      ```
    - `{entity}` is replaced dynamically (e.g. animals, birds).

3. **Displaying data**
    - Data is parsed into a list of `Entity` model objects using GSON.
    - A `RecyclerView` with a custom `EntityAdapter` displays all items.

4. **Details page**
    - When a user taps an entity item, an Intent is fired carrying the selected `Entity` object (using Serializable).
    - The Details page (`DetailScreen.java`) displays all fields like species, scientific name, habitat, diet, conservation status, lifespan, and description.

---

## 📂 **Project Structure**

