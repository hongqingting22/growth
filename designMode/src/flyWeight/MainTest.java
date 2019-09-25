package flyWeight;


public class MainTest {

    public static void main(String[] args) {
        showMemInfo();

        PlantManager manager = new PlantManager();

        manager.displayPlants();

        showMemInfo();
    }

    public static void showMemInfo(){
        long maxMemory = Runtime.getRuntime().maxMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();
        long used = totalMemory - freeMemory;

        System.out.println(maxMemory);
        System.out.println(totalMemory);
        System.out.println(freeMemory);
        System.out.println(used);
        System.out.println(System.currentTimeMillis());
    }
}
