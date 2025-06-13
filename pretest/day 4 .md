## 📄 **PRE-TEST** – _Java Spring Boot & Spring Security_

### ✳️ Bagian 1: Pilihan Ganda (Dasar)

1. Apa anotasi yang digunakan untuk mendefinisikan sebuah REST controller?

   - A. `@Service`
   - B. `@Component`
   - C. `@RestController` 
   - D. `@Repository`
   jawaban: C.

2. Di Spring, anotasi apa yang digunakan untuk menyuntikkan dependency ke dalam class?

   - A. `@Autowired`
   - B. `@Injectable`
   - C. `@Import`
   - D. `@Mapper`
   jawaban: A. 

3. Di lapisan arsitektur Spring, Service berfungsi untuk:

   - A. Menangani permintaan HTTP
   - B. Menyimpan data ke database langsung
   - C. Menyimpan log aplikasi
   - D. Menyimpan logika bisnis
   Jawaban: D.

4. Class model di Java Spring biasanya digunakan untuk:

   - A. Menyimpan konfigurasi Spring
   - B. Menyimpan logika controller
   - C. Menyimpan struktur data (seperti data user, produk, dll.)
   - D. Mengatur pemetaan URL
   Jawaban: C.

5. Jika kita ingin membuat method yang bisa diakses oleh endpoint `/hello`, anotasi apa yang digunakan?

   - A. `@RestEndpoint("/hello")`
   - B. `@Path("/hello")`
   - C. `@GetMapping("/hello")`
   - D. `@Route("/hello")`
    Jawaban: C. 
---

### ✳️ Bagian 2: Benar / Salah

6. `@Service` digunakan untuk menandai class sebagai lapisan Controller.
jawaban: salah
7. Kita bisa membuat class model tanpa anotasi apapun jika hanya digunakan sebagai POJO.
Jawaban: benar
8. `@Autowired` bisa digunakan di constructor maupun field.
Jawaban: benar
9. Spring Boot membutuhkan file `application.yml` agar bisa berjalan.
jawaban: salah
10. `@GetMapping` hanya bisa digunakan di class dengan anotasi `@Service`.
jawaban: salah

---

### ✳️ Bagian 3: Isian Singkat

11. Anotasi apa yang digunakan agar method bisa menangani permintaan POST?
jawaban: @PostMapping
12. Apa nama file konfigurasi default di Spring Boot?
Jawaban: application.properties
13. Apa yang dimaksud dengan Dependency Injection?
jawaban: Membuat depedency kedalam object secara langsung
14. Bagaimana cara mendeklarasikan class `UserService` agar dikenali Spring sebagai Service?
jawaban: memakai @Service
15. Apa perbedaan `@RestController` dan `@Controller`?
jawaban: @RestController menggabungkan @Controller dan @ResponseBody, sedangkan @Controller tidak menggabungkan @ResponseBody.
---

### ✳️ Bagian 4: Perbaiki Kode / Output

16. Perbaiki kode berikut agar dapat dijalankan sebagai Controller:

```java
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
```
Jawaban:
```java
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
```

17. Perbaiki kesalahan pada model berikut:

```java
public class Product {
    private String name;
    private int price;
}
```
Jawaban:
```java
public class Product {
    private String name;
    private int price;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
}
```

18. Apa output dari method berikut?

```java
@GetMapping("/sum")
public int sum() {
    return 2 + 3;
}
```
Jawaban: 5

19. Kode service berikut error. Apa yang salah?

```java
@Service
public class UserService {
    private UserRepository userRepository;
}
```
Jawaban: 
```java
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
}
```
kurang @Autowired untuk inject 

20. Apa masalah pada potongan kode berikut?

```java
@RestController
public class BookController {

    @GetMapping
    public String listBooks() {
        return "books";
    }
}
```
Jawaban: 
```java
@RestController
public class BookController {

    @GetMapping("/books")
    public String listBooks() {
        return "books";
    }
}
```
tidak ada mapping

---

### 🔐 Bagian 5: Spring Security

#### Pilihan Ganda

21. Apa anotasi yang digunakan untuk mengaktifkan Spring Security di aplikasi Spring Boot?

- A. `@EnableSecurity`
- B. `@SpringSecurity`
- C. `@EnableWebSecurity`
- D. `@ActivateSecurity`
Jawbaan: C.

22. Komponen mana yang bertugas mengatur izin akses berdasarkan role atau otorisasi di Spring Security?

- A. `SecurityConfig`
- B. `UserDetailsService`
- C. `AuthenticationManager`
- D. `HttpSecurity`
Jawaban: D.

23. Untuk membuat otentikasi berbasis user login yang dikustomisasi, interface apa yang harus diimplementasi?

- A. `UserRepository`
- B. `UserSecurity`
- C. `UserDetailsService`
- D. `SecurityService`
Jawaban: C.

#### Benar / Salah

24. Spring Security hanya bisa digunakan untuk REST API yang menggunakan JWT.
Jawaban: Salah
25. `@PreAuthorize("hasRole('ADMIN')")` digunakan untuk membatasi method agar hanya bisa diakses oleh pengguna dengan role ADMIN.
Jawaban: Benar
26. `BCryptPasswordEncoder` digunakan untuk mengenkripsi password agar tidak disimpan dalam bentuk plain text.
Jawaban: Benar

#### Isian Singkat

27. Apa class konfigurasi yang umum dibuat untuk menyesuaikan aturan login, logout, dan authorization di Spring Security?
Jawaban: SecurityConfig
28. Apa anotasi yang digunakan agar method hanya bisa diakses jika pengguna memiliki hak tertentu?
Jawaban: PreAuthorize

#### Perbaiki Kode / Analisis

29. Perbaiki potongan konfigurasi ini:

```java
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
        .antMatchers("/admin").hasRole("ADMIN")
        .anyRequest().authenticated()
        .and()
        .formLogin();
    return http.build();
}
```
Jawaban: 
```java
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/admin").hasRole("ADMIN")
            .anyRequest().authenticated()
        )
        .formLogin(Customizer.withDefaults());
    return http.build();
}
```

30. Apa yang salah dengan konfigurasi login berikut?

```java
http
  .authorizeHttpRequests()
  .anyRequest().permitAll()
  .and()
  .formLogin();
```

Jawaban:
```java
http
  .authorizeHttpRequests(auth -> auth
      .requestMatchers("/admin").hasRole("ADMIN")
      .anyRequest().authenticated()
  )
  .formLogin(Customizer.withDefaults());
```
.anyRequest().permitAll() menyatakan semua request diizinkan tanpa otentikasi. Namun, setelah itu ada .formLogin(); yang menunjukkan harus ada authentikasi.

---
