## 📄 Pretest Spring Boot Security & Unit Testing\*\*

### ✅ **A. Pilihan Ganda (12 Soal)**

1. Apa tujuan utama dari Spring Security?
jawaban: melindungi aplikasi dari kerentanan keamanan melalui autentikasi dan autorisasi.
2. Apa anotasi untuk mengaktifkan Web Security di Spring Boot?
jawaban: @EnableWebSecurity
3. Apa fungsi `HttpSecurity` dalam konfigurasi Spring Security?
jawaban: untuk konfigurasi keamanan http.
4. Apa itu prinsip _Authentication Principal_ dalam Spring Security?
jawaban: untuk mengidentifikasi user di sistem.
5. Apa peran dari anotasi `@PreAuthorize("hasRole('ADMIN')")`?
jawaban: membatasi akses kepada role admin saja
6. Apa fungsi dari class `UserDetails` di Spring Security?
jawbaan: menyimpan informasi detail user
7. Apa itu BCrypt?
jawaban: salah satu algoritma hashing  
8. Library utama yang digunakan untuk testing unit di Spring Boot adalah:
jawaban: JUnit
9. Apa kegunaan dari `@MockBean` dalam Spring Boot Test?
jawaban: mengganti bean dengan mock untuk testing
10. Apa yang dilakukan oleh anotasi `@WithMockUser`?
jawaban: mengganti mock dengan mock user
11. Apa perbedaan mendasar antara `@WebMvcTest` dan `@SpringBootTest`?
jawaban: `@WebMvcTest` hanya untuk testing controller, sedangkan `@SpringBootTest` untuk testing keseluruhan
12. Apa tujuan dari anotasi `@BeforeEach` dalam unit test?
jawaban: menjalankan kode sebelum menjalankan setiap test

---

### ✅ **B. Benar/Salah (5 Soal)**

13. `BCryptPasswordEncoder` menghasilkan hash yang sama untuk password yang sama.
Jawaban: Salah
14. Spring Security dapat digunakan untuk endpoint berbasis REST API maupun form login.
Jawban: Benar
15. `@WebMvcTest` bisa digunakan untuk menguji layer service dan repository.
Jawaban: Salah
16. `Principal` adalah representasi dari user yang sedang login.
Jawaban: Benar
17. `@MockBean` dan `@Mock` memiliki efek yang sama dalam Spring Boot Test.
Jawaban: Salah
---

### ✅ **C. Isian Singkat (5 Soal)**

18. Apa peran dari `AuthenticationManager` dalam Spring Security?
Jawaban: mengelola proses autentikasi
19. Jelaskan apa yang dilakukan oleh `PasswordEncoder` dan kenapa penting?
Jawaban: mengenkripsi password dengan hashing untuk keamanan data
20. Apa yang dimaksud dengan "authorization" dalam konteks aplikasi?
Jawaban: menentukan akses user ke aplikasi
21. Apa itu _test double_, dan apa perbedaannya dengan _mock_ di unit test?
Jawaban: _test double_ adalah replikasi objek yang digunakan untuk testing, sedangkan _mock_ adalah replikasi objek yang digunakan untuk menguji perilaku interaksi
22. Dalam pengujian REST API Spring Boot, apa fungsi utama `MockMvc`?
Jawaban: test REST API dengan mock object

---

### ✅ **D. Koreksi Kode (8 Soal)**

Perhatikan kode berikut dan jelaskan apa yang salah.

23.

```java
@Autowired
private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
```
Jawaban: harus menggunakan bean
```java
 @Bean
    public PasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder();}
```

24.

```java
@WithMockUser(username = "user", roles = "USER")
@Test
void testAccessAdminEndpoint() {
    mockMvc.perform(get("/admin")).andExpect(status().isOk());
}
```
Jawaban: harus menggunakan @WithMockUser dengan role yang sesuai
```java
@WithMockUser(username = "admin", roles = "ADMIN")
@Test
void testAccessAdminEndpoint() {
    mockMvc.perform(get("/admin")).andExpect(status().isOk());
}
```

25.

```java
@Mock
UserService userService = new UserServiceImpl();
```
Jawaban: tidak bisa inisialisasi manual jika pake @Mock
```java
@Mock
private UserService userService;
```

26.

```java
@SpringBootTest
@WebMvcTest
public class MyTest {
}
```
Jawaban: tidak bisa menggunakan @SpringBootTest dan @WebMvcTest secara bersamaan
```java
@SpringBootTest
public class MyTest {
}
```

27.

```java
@Test
void testPasswordHash() {
    PasswordEncoder encoder = new BCryptPasswordEncoder();
    assertEquals("mypassword", encoder.encode("mypassword"));
}
```
Jawaban: BCrypt menggunakan salt sehingga tidak bisa asserEquals
```java
@Test
void testPasswordHash() {
    PasswordEncoder encoder = new BCryptPasswordEncoder();
    String encoded = encoder.encode("mypassword");
    assertTrue(encoder.matches("mypassword", encoded));
}
```

28.

```java
@Test
void testUnauthorizedAccess() {
    mockMvc.perform(get("/secure-data"))
           .andExpect(status().isOk());
}
```
Jawaban: tidak bisa menggunakan mockMvc untuk mengakses endpoint yang memerlukan autentikasi
```java
@Test
void testUnauthorizedAccess() {
    mockMvc.perform(get("/secure-data"))
           .andExpect(status().isUnauthorized());
}
```

29.

```java
@BeforeAll
void setup() {
    MockitoAnnotations.openMocks(this);
}
```
Jawaban: metode dengan @BeforeAll harus static 
```java
@BeforeAll
static void setup() {
    MockitoAnnotations.openMocks(MyTestClass.class); 
}
```

30.

```java
@Test
void testLogin() {
    when(authService.login("user", "pass")).thenReturn(null);
    assertNotNull(authService.login("user", "pass"));
}
```
Jawaban: mock mengembalikan null, tapi kemudian berharap nilainya tidak null.
``` java
@Test
void testLogin() {
    User mockUser = new User("user", "pass"); 
    when(authService.login("user", "pass")).thenReturn(mockUser);
    assertNotNull(authService.login("user", "pass"));
}

```
