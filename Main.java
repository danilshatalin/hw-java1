import java.util.*;

public class Notebook {
    private String model;
    private int RAM;
    private int storage;
    private String operatingSystem;
    private String color;

    public Notebook(String model, int RAM, int storage, String operatingSystem, String color) {
        this.model = model;
        this.RAM = RAM;
        this.storage = storage;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    // Геттеры и сеттеры для полей класса

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "model='" + model + '\'' +
                ", RAM=" + RAM +
                ", storage=" + storage +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        // Создание ноутбуков
        Notebook notebook1 = new Notebook("Model 1", 8, 512, "Windows", "Black");
        Notebook notebook2 = new Notebook("Model 2", 16, 1024, "MacOS", "Silver");
        Notebook notebook3 = new Notebook("Model 3", 16, 512, "Linux", "Red");
        Notebook notebook4 = new Notebook("Model 4", 12, 256, "Windows", "Blue");
        Notebook notebook5 = new Notebook("Model 5", 8, 1024, "Windows", "Black");

        Set<Notebook> notebooks = new HashSet<>();
        notebooks.add(notebook1);
        notebooks.add(notebook2);
        notebooks.add(notebook3);
        notebooks.add(notebook4);
        notebooks.add(notebook5);

        // Запрос критерия фильтрации у пользователя
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");

        int filterOption = scanner.nextInt();
        Map<String, Object> filterParams = new HashMap<>();

        // Запрос минимальных значений для указанных критериев
        switch (filterOption) {
            case 1:
                System.out.println("Введите минимальный объем ОЗУ:");
                int minRAM = scanner.nextInt();
                filterParams.put("RAM", minRAM);
                break;
            case 2:
                System.out.println("Введите минимальный объем ЖД:");
                int minStorage = scanner.nextInt();
                filterParams.put("storage", minStorage);
                break;
            case 3:
                System.out.println("Введите требуемую операционную систему:");
                String os = scanner.next();
                filterParams.put("operatingSystem", os);
                break;
            case 4:
                System.out.println("Введите требуемый цвет:");
                String color = scanner.next();
                filterParams.put("color", color);
                break;
            default:
                System.out.println("Некорректный выбор критерия.");
                return;
        }

        // Фильтрация ноутбуков и вывод подходящих
        Set<Notebook> filteredNotebooks = filterNotebooks(notebooks, filterParams);
        System.out.println("Подходящие ноутбуки:");
        for (Notebook notebook : filteredNotebooks) {
            System.out.println(notebook);
        }
    }

    private static Set<Notebook> filterNotebooks(Set<Notebook> notebooks, Map<String, Object> filterParams) {
        Set<Notebook> filteredNotebooks = new HashSet<>();

        for (Notebook notebook : notebooks) {
            boolean meetsCriteria = true;

            for (Map.Entry<String, Object> entry : filterParams.entrySet()) {
                String field = entry.getKey();
                Object value = entry.getValue();

                if (field.equals("RAM")) {
                    if (notebook.getRAM() < (int) value) {
                        meetsCriteria = false;
                        break;
                    }
                } else if (field.equals("storage")) {
                    if (notebook.getStorage() < (int) value) {
                        meetsCriteria = false;
                        break;
                    }
                } else if (field.equals("operatingSystem")) {
                    if (!notebook.getOperatingSystem().equals(value)) {
                        meetsCriteria = false;
                        break;
                    }
                } else if (field.equals("color")) {
                    if (!notebook.getColor().equals(value)) {
                        meetsCriteria = false;
                        break;
                    }
                }
            }

            if (meetsCriteria) {
                filteredNotebooks.add(notebook);
            }
        }

        return filteredNotebooks;
    }
}
