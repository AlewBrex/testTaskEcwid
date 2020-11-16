import java.io.*;
import java.util.BitSet;

public class ParsingFile implements CountIpAddress
{
    private final String loadFolder = "W:/testEcwid/ipAddresses";

    @Override
    public Long countIp()
    {
        long count = 0;
        File file = new File(loadFolder);
        BitSet[][][][] set = new BitSet[256][256][256][256];

        for (int i = 0; i < 256; i++)
        {
            for (int j = 0; j < 256; j++)
            {
                for (int k = 0; k < 256; k++)
                {
                    for (int l = 0; l < 256; l++)
                    {
                        set[i][j][k][l] = new BitSet(256);
                    }
                }
            }
        }

        try(FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader))
        {
            String string = bufferedReader.readLine();
            while (!string.isBlank())
            {
                String[] strings = string.split("\\u002E");
                if (strings.length == 4)
                {
                    int first = Integer.parseInt(strings[0]);
                    int second = Integer.parseInt(strings[1]);
                    int third = Integer.parseInt(strings[2]);
                    int fourth = Integer.parseInt(strings[3]);
                    if(!set[first][second][third][fourth].get(fourth))
                    {
                        set[first][second][third][fourth].set(fourth);
                        count++;
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return count;
    }
}