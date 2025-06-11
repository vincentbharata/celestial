
class Hewann {

    String nama;

    void kaki() {
        System.out.println(nama + "berkaki 5");
    }
}

class Kucing extends Hewann {

    void suara() {
        System.out.println(nama + "meong!");
    }

    void suara2() {
        System.out.println(nama + "cukuruk!");
    }
}

public class Hewan {

    public static void main(String[] args) {
        Kucing pet = new Kucing();
        pet.nama = "Milo ";
        pet.kaki();
        pet.suara();
        pet.nama = "buwung ";
        pet.kaki();
        pet.suara2();
    }
}
