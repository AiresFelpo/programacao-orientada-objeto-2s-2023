public class Main {
    public static void main(String[] args) {
        Carro carro = new Carro("Toyota", "Corolla", 2022, 4);
        Moto moto = new Moto("Honda", "CBR 600", 2021, 600);

        carro.acelerar();
        carro.frear();
        System.out.println("Carro: " + carro.getMarca() + " " + carro.getModelo());

        moto.acelerar();
        moto.frear();
        System.out.println("Moto: " + moto.getMarca() + " " + moto.getModelo());
    }
}
