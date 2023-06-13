import java.sql.Array;
import java.util.*;
import java.util.random.RandomGenerator;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        ArrayList<Integer> al = new ArrayList<Integer>();
        System.out.println("Задание 1:");
        for (int i = 0; i < 30; i++) {
            al.add(random.nextInt(1000));
        }
        for (int i = 0; i < al.size(); i++) {
            if(al.get(i) % 2 == 0){
                al.remove(i);
            }
        }
        for (int i = 0; i < al.size(); i++) {
            System.out.print(" " + al.get(i));
        }
        System.out.println("\n\nЗадание 2:");
        System.out.println("Минимальное: " + Collections.min(al));
        System.out.println("Максимальное: " + Collections.max(al));
        Integer mednum = 0;
        for (int i = 0; i < al.size(); i++) {
            mednum += al.get(i);
        }
        System.out.println("Среднее: " + mednum/al.size());
        System.out.println("\n\nЗадание 3:");
        ArrayList<String> planets = new ArrayList<String>(Arrays.asList("Нептун","Уран","Сатурн", "Юпитер", "Марс", "Земля", "Венера", "Меркурий"));
        ArrayList<String> randomplanets = new ArrayList<String>();
        Map<String,Integer> numrepplanet;
        numrepplanet = new HashMap<String, Integer>();
        for (int i = 0; i < 8; i++) {
            numrepplanet.put(planets.get(i),0);
        }
        for (int i = 0; i < 50; i++) {

            randomplanets.add(planets.get(random.nextInt(8)));
        }
        for (int i = 0; i < 50; i++) {
            numrepplanet.replace(randomplanets.get(i),numrepplanet.get(randomplanets.get(i))  + 1);
        }

        for(Map.Entry<String, Integer> item : numrepplanet.entrySet()){

            System.out.printf(" %s  : %d \n", item.getKey(), item.getValue());
        }
    }
}
