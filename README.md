

```markdown
# Exam Management System

Welcome to the Exam Management System! This system provides APIs for managing exams, including user registration, login, exam paper design, answer paper creation, checking processes, and more.

## Configuration

Before using the system, ensure you configure the following parameters in the `FileUploadServiceImpl` class:

```java
public FileUploadServiceImpl(
    JwtService jwtService,
    CorrectAnswerService correctAnswerService,
    FieldInfoRepository fieldInfoRepository,
    CorrectAnswerForOneSubjectService correctAnswerForOneSubjectService,
    BazaRepository bazaRepository
) {
    this.jwtService = jwtService;
    this.bazaRepository = bazaRepository;
    this.cloudinary = new Cloudinary(ObjectUtils.asMap(
        "cloud_name", "Your_Cloudinary_Name",
        "api_key", "Your_Cloudinary_API_Key",
        "api_secret", "Your_Cloudinary_API_Secret"
    ));
}
```

Additionally, configure the MySQL connection string, username, and password in the `application.properties` file.

## Getting Started

1. **Register a New User**: 
   - Endpoint: `{{base_url}}/user`
   - Request Body:
     ```json
     {
         "email": "a@gmail.com",
         "password": "aaaaaaa"
     }
     ```

2. **Login**:
   - Endpoint: `{{base_url}}/auth/login`

3. **Create Design for Answer Paper**:
   - Endpoint: `{{base_url}}/answerpaperdesign`
   - Request Body:
     ```json
     {
         "name": "Your_Paper_Design_Name"
     }
     ```

4. **Add FieldInfo to Paper Design**:
   - Endpoint: `{{base_url}}/fieldinfo`
   - Request Body:
     ```json
     {
         "fieldname": "Fənn",
         "startterindex": 49,
         "finishindex": 50,
         "answerpaperdesignid": 52,
         "isaffectthescore": true
     }
     ```

5. **Create Baza**:
   - Endpoint: `{{base_url}}/baza`
   - Request Body:
     ```json
     {
         "affectedargumentids": [112, 113],
         "howmanyscorethatwrongaffectedtocorrect": 0
     }
     ```

6. **Create All Permutations of Correct Variant**:
   - Endpoint: `{{base_url}}/correctanswer`
   - Request Body:
     ```json
     {
         "combinationofarguments": "BR",
         "baza_id": 52
     }
     ```

7. **Add Correct Answer for Each Subject**:
   - Endpoint: `{{base_url}}/correctanswerforonesubject`
   - Request Body:
     ```json
     {
         "subjectname": "Riyaziyyat 3 ballıq",
         "correctanswersseriesly": "CAD",
         "scoreforonecorrectanswer": 3,
         "correctanswer_id": 55
     }
     ```

8. **Upload Text File to Cloud**:
   - Endpoint: `{{base_url}}/file/saveinbaza`

9. **Start Checking Process**:
   - Endpoint: `{{base_url}}/result/startchecking/{baza_id}`

## Result Format

The result returned by the system is in the following format:

```json
[
    {
        "Utis kod": "3044264",
        "Ad": "sAHRZA",
        "Soyad": "iSMAYILOV",
        "Cavablar": "DABDADBCBAAACBBCADBBCDDD*CACCDDAABBADCDB",
        "answers": [
            {
                "subjectname": "Riyaziyyat 5 ballıq",
                "correctanswersseriesly": "DCCABB",
                "studentanswerseriesly": "DABDAD",
                "statuswithplusandminus": "+-----",
                "correctAnswer": 1,
                "wrongAnswer": 5,
                "emptyAnswer": 0,
                "score": 3.75
            },
            {
                "subjectname": "Riyaziyyat 4 ballıq",
                "correctanswersseriesly": "CCAB",
                "studentanswerseriesly": "BCBA",
                "statuswithplusandminus": "-+--",
                "correctAnswer": 1,
                "wrongAnswer": 3,
                "emptyAnswer": 0,
                "score": 3.25
            }
        ],
        "Məktəb kod": "01519",
        "Cins": "K",
        "Variant": "B",
        "Ata adı": "VuQAR",
        "Sinif":1}]
