# Vincent Bharata

1. B. Mengelola logika aplikasi dan komunikasi data dengan database
2. A. Menyembunyikan detail implementasi dan menyediakan akses lewat method
3. C. Meng-inject dependency otomatis ke dalam bean
4. A. Agar controller lebih ringan dan fokus pada request/response
5. A. `@Route("/api")`
6. False
7. True
8. True
9. False
10. True
11. Backend berperan sebagai otak dalam suatu aplikasi atau web application untuk mengontrol semua proses yang terjadi.
12. perbedaan class dan object adalah class adalah template untuk membuat object, sedangkan object adalah instance dari class. 
13. inheritance adalah suatu konsep di java dimana class dapat mengambil sifat dan perilaku dari class, sedangkan polymorphism adalah kemampuan suatu object untuk dapat berubah menjadi bentuk lain.
14. untuk mendefinisikan kelas sebagai controller yang menangani permintaan HTTP 
15. keuntungan springboot adalah untuk mempermudah pengembangan aplikasi dengan menggunakan framework spring, serta dapat mempercepat proses pengembangan aplikasi.
16. cara kerja dependency injection adalah dengan cara menginject dependency otomatis ke dalam bean. 
17. mempermudah scale up sistem, mempermudah testing, memisahkan task secara independen
18. jika ada class yang ingin menggunakan service tersebut dengan @Autowired, dependency injection tidak akan berfungsi karena spring tidak mengetahui keberadaan class itu.
19. untuk mengambil parameter dari url, dipakai ketika ingin mengambil data dari url.
20. menggunakan constructor injection dengan @autowired
21. helloservice belum di declare

```java
@RestController
public class HelloController {
    private final HelloService helloService =  new HelloService(); // fixing
    @GetMapping("/hello")
    public String hello() {
        return helloService.sayHello(); // error
    }
}
```
22. tidak menggunakan void karena ini method bukan constructor

```java
public class Person {
    public String name;

    public Person(String name) { //fixing
        this.name = name;
    }
}
```
23. type butuh di definisikan name itu type apa

```java
@RestController
public class GreetController {
    @PostMapping("/greet")
    public String greet(@RequestBody String name) { //fixing
        return "Hello, " + name;
    }
}
```
24. tidak boleh di declare langsung new

```java
@Service
public class InfoService {
    public String getInfo() {
        return "Info OK";
    }
}

// controller
@RestController
public class InfoController {
    @Autowired //fixing
    private InfoService infoService;
    @GetMapping("/info")
    public String get() {
        return infoService.getInfo();
    }
}

```
25. harus diberi anotasi setiap parameter 

```java
@RestController
public class MathController {
    @GetMapping("/add")
    public int addNumbers(@RequestParam int a, @RequestParam int b) { //fixinggit commit
        return a + b;
    }
}

```
