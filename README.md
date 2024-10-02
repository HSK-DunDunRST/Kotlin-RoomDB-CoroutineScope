## 예제 RoomDB 프로젝트

이 Android 애플리케이션은 **Room 데이터베이스**를 사용하여 데이터 영속성과 간단한 텍스트 데이터의 표시를 시연합니다. 사용자는 제목과 내용을 포함한 데이터 항목을 삽입, 표시 및 삭제할 수 있습니다.

## 주요 기능
- 제목과 내용을 입력하여 새로운 데이터 항목 추가.
- 저장된 모든 데이터를 동적 레이아웃으로 표시.
- 개별 데이터 항목 삭제.
- 각 항목에 추가된 날짜 및 시간 자동 표시.
- 기본 UI 상호작용 및 소프트 키보드 처리.

## 라이브러리 및 종속성
이 프로젝트는 다음의 Android 라이브러리를 사용합니다:
- **Room 데이터베이스**: 로컬 데이터베이스 저장을 위한 Android Jetpack 구성 요소의 일부.
- **코루틴**: UI 스레드를 차단하지 않고 효율적으로 백그라운드 작업(데이터 삽입, 가져오기, 삭제)을 관리.
- **뷰 바인딩**: 뷰 접근 및 상호작용을 간소화.

## 프로젝트 구조

### 1. `MainActivity.kt`
다음 작업을 처리합니다:
- Room 데이터베이스 초기화.
- 사용자가 "삽입" 버튼을 클릭할 때 새 항목을 데이터베이스에 삽입.
- 활동이 생성될 때 데이터베이스에 저장된 모든 항목 표시.
- 특정 항목에 연결된 "삭제" 버튼을 클릭할 때 개별 항목 삭제.

### 2. `AppDatabase.kt`
데이터베이스 구조를 정의하며, 다음을 포함합니다:
- **DataEntity**: 테이블의 데이터 모델로 각 행을 나타내며 `id`, `title`, `content`, `date` 열이 포함됨.
- **DataDao**: 데이터베이스와 상호작용하는 메서드를 정의하는 데이터 접근 객체(DAO)로 `insert`, `selectAll`, `deleteById` 등을 포함.

### 3. `DataEntity.kt`
Room 데이터베이스에서 사용되는 테이블 구조를 나타내는 데이터 클래스입니다. 다음 필드를 포함합니다:
- `id`: 자동 생성되는 기본 키.
- `title`: 항목의 제목을 포함하는 문자열.
- `content`: 항목의 내용을 포함하는 문자열.
- `date`: 항목이 추가된 날짜 및 시간을 나타내는 문자열.

### 4. `ActivityMainBinding`
**뷰 바인딩**에 의해 자동으로 생성된 클래스이며, `activity_main.xml`에 선언된 뷰를 Kotlin 코드와 연결합니다.

## 사용 방법

1. 리포지토리를 클론합니다:
    ```
    git clone https://github.com/your-username/example_roomdb.git
    ```

2. Android Studio에서 프로젝트를 엽니다.

3. 에뮬레이터 또는 실제 기기에서 **Android API 레벨 26 (Oreo)** 이상으로 프로젝트를 빌드하고 실행합니다.

4. 앱이 실행되면:
   - 각 필드에 제목과 내용을 입력합니다.
   - **삽입** 버튼을 클릭하여 Room 데이터베이스에 데이터를 저장합니다.
   - 저장된 데이터가 입력 필드 아래에 표시됩니다.
   - 항목을 삭제하려면 해당 항목에 연결된 **삭제** 버튼을 클릭합니다.

## Room 데이터베이스 설정

이 프로젝트의 Room 데이터베이스는 `Room.databaseBuilder()` 메서드를 사용하여 싱글턴으로 초기화됩니다. `DataDao` 인터페이스는 데이터 삽입, 쿼리 및 삭제를 위한 SQL 작업을 정의합니다.

```kotlin
appDatabase = Room.databaseBuilder(
    applicationContext,
    AppDatabase::class.java, "example-room-db"
).build()
```

## 요구 사항
- Android Studio Flamingo 이상.
- JDK 17 이상.
- Android API 레벨 26 (Oreo) 이상.


---

