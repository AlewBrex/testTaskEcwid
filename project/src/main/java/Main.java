public class Main
{
    public static void main(String[] args)
    {
        long start = System.currentTimeMillis();
//        int processor = Runtime.getRuntime().availableProcessors();
        CountIpAddress countIpAddress = new ParsingFile();
        long count = countIpAddress.countIp();

        System.out.println("Количество уникальных Ip4 адресов = " + count);
        System.out.println("Время на поиск = " + (System.currentTimeMillis() - start) + "ms");
    }
}