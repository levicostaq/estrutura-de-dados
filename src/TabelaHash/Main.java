package TabelaHash;

public class Main {
    public static void main(String[] args) {
        HashFechado tab = new HashFechado(8);

        tab.add(30);
        tab.add(13);
        tab.add(35);
        tab.add(21);
        tab.add(18);
        tab.add(47);
        tab.add(14);

        System.out.println(tab);
    }
}
