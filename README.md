# 🎨 Art Space
 
Aplicación Android desarrollada con **Jetpack Compose** como parte del codelab
[*Art Space: Compose Basics*](https://developer.android.com/codelabs/basic-android-kotlin-compose-art-space)
de Android Developers.
 
La app simula una pequeña galería de arte: muestra una imagen, su título,
artista y año, y permite navegar entre varias obras usando los botones
**Previous** y **Next**.
 
## ✨ Características
 
- Construida 100% con Jetpack Compose (sin XML de layouts).
- Estado manejado con `remember` / `mutableIntStateOf`.
- Navegación circular entre obras (al llegar a la última, vuelve a la primera y viceversa).
- Textos externalizados en `strings.xml` para facilitar traducciones.
- Diseño responsive con `Surface`, `Column` y `Row`.
## 📸 Capturas de pantalla
 
| Obra 1 | Obra 2 | Obra 3 |
|:---:|:---:|:---:|
| <img width="1280" height="1920" alt="artwork1" src="https://github.com/user-attachments/assets/9de035c5-9a88-4470-93cc-370302bc5ea4" /> | <img width="1280" height="1920" alt="artwork2" src="https://github.com/user-attachments/assets/55e295ef-87c6-4961-825a-d58b36a4c5a7" /> | <img width="1280" height="1920" alt="artwork3" src="https://github.com/user-attachments/assets/48227cbd-efa7-4f9a-902d-bd8a3a5293dd" /> |
| Bahía de Sídney | Golden Gate entre nubes | Luna creciente al atardecer |
 
## 🛠️ Tecnologías
 
- Kotlin
- Jetpack Compose
- Material 3
## 🚀 Cómo correrlo
 
1. Clona el repositorio:
```bash
   git clone https://github.com/JordyMacias/App-ArtSpace.git
```
2. Ábrelo en **Android Studio**.
3. Espera a que Gradle sincronice las dependencias.
4. Ejecuta la app en un emulador o dispositivo físico con el botón ▶️ **Run**.
## 📂 Estructura principal
 
```
app/
 └── src/main/
      ├── java/com/example/artspace/
      │    └── MainActivity.kt
      └── res/
           ├── drawable/       # artwork1.jpg, artwork2.jpg, artwork3.jpg
           └── values/
                └── strings.xml
```
 
## 📄 Licencia
 
Proyecto realizado con fines educativos, basado en el codelab oficial de
Android Developers.
