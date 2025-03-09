## Example RoomDB 프로젝트

이 Android 애플리케이션은 **Room Database**를 사용한 데이터 영구 저장 및 기본적인 텍스트 데이터 표시 기능을 시연합니다.  
사용자는 제목과 내용을 입력하여 데이터를 추가하고, 저장된 데이터를 조회 및 삭제할 수 있습니다.

---

## 주요 기능
**데이터 추가**: 제목과 내용을 입력하여 새로운 데이터를 저장할 수 있습니다.  
**데이터 조회**: 저장된 모든 데이터를 동적으로 표시합니다.  
**데이터 삭제**: 개별 항목을 삭제할 수 있습니다.  
**날짜 및 시간 표시**: 각 데이터가 추가된 시점을 자동으로 저장합니다.  
**기본적인 UI 인터랙션**: 부드러운 키보드 조작 및 사용자 경험 개선 기능을 포함합니다.  

---

## 사용된 라이브러리 및 종속성
이 프로젝트에서는 다음의 Android 라이브러리를 사용합니다.  

**Room Database**: Android Jetpack의 일부로, 로컬 데이터 저장을 위한 ORM 라이브러리입니다.  
**Coroutines**: UI 스레드를 차단하지 않고 백그라운드 작업(데이터 삽입, 조회, 삭제)을 수행합니다.  
**View Binding**: XML 레이아웃과 Kotlin 코드 간의 상호작용을 간소화합니다.  

---

## 요구 사항
- **Android Studio Flamingo** 이상  
- **JDK 17** 이상  
- **Android API Level 26 (Oreo)** 이상  

---

## 프로젝트 구조

### 1️⃣ `MainActivity.kt`
주요 기능:  
- Room 데이터베이스 초기화  
- 사용자가 "추가" 버튼을 클릭하면 데이터를 데이터베이스에 삽입  
- 액티비티 생성 시 저장된 데이터를 화면에 표시  
- "삭제" 버튼을 클릭하면 해당 데이터 항목 삭제  

### 2️⃣ `AppDatabase.kt`
데이터베이스 구조 정의:  
- **DataEntity**: `id`, `title`, `content`, `date` 컬럼을 포함하는 데이터 모델  
- **DataDao**: 데이터 삽입(`insert`), 조회(`selectAll`), 삭제(`deleteById`) 기능을 정의하는 DAO 인터페이스  

### 3️⃣ `DataEntity.kt`
Room 데이터베이스에서 사용되는 데이터 테이블을 나타내는 데이터 클래스입니다.  
- `id`: 자동 생성되는 기본 키  
- `title`: 데이터의 제목  
- `content`: 데이터의 내용  
- `date`: 데이터가 추가된 날짜 및 시간  

### 4️⃣ `ActivityMainBinding`
**View Binding**을 사용하여 `activity_main.xml`에 정의된 UI 요소를 Kotlin 코드에서 쉽게 사용할 수 있도록 합니다.  

---

## Room Database 설정

이 프로젝트의 Room 데이터베이스는 싱글톤으로 초기화되며, `Room.databaseBuilder()`를 사용하여 생성됩니다.  
`DataDao` 인터페이스를 통해 데이터 삽입, 조회, 삭제와 같은 SQL 연산을 수행합니다.  

```kotlin
appDatabase = Room.databaseBuilder(
    applicationContext,
    AppDatabase::class.java, "example-room-db"
).build()
```

---
