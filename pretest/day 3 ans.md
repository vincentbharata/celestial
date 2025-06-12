## Day 3 - Vincent

1. b. `@Entity`
2. c. Menyediakan endpoint berbasis REST
3. a. Menangani request GET ke endpoint `/user`
4. d. `fetch()`
5. a. `@ManyToOne`
6. c. `application.properties`
7. b. `@Autowired`
8. c. `@Query`
9. b. Mengambil data JSON dari body request
10. c. Mengambil data dari path endpoint
11. True
12. True
13. False
14. True
15. False
16. `@RestController` mengembalikan data sebagai JSON/XML sedangkan `@Controller`mengembalikan view
17. membuat value secara otomatis seperti user id
18. untuk memisahkan entity database
19. membuat query secara otomatis berdasarkan nama method
20. menyesuaikan nama kolom di database jika berbeda dari nama field
21. Belum menggunakan `@Id`, dan belum ada `@GeneratedValue`
```java
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
```
22. parameter `name` tidak ada anotasi seperti `@RequestParam`
```java
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }
}
```
23. dibuat satu customer bisa punya banyak order. Di class Customer, gunakan anotasi @OneToMany, dan di class Order menggunakan @ManyToOne untuk menunjukkan bahwa tiap order hanya dimiliki oleh satu customer.
24. output: User ID: 123
@PathVariable menangkap bagian {id} dari URL dan memasukkannya ke parameter.
25. menggunakan custom exception
