import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class TestFinder {

    @Test
    //tests processing without internet oonnection
    public void getSortedCountries() {

        String payload = readFile("src/test/resources/jsonvat.com.json");
        List<Country> countries =  Finder.getSortedCountries(payload);
        assertEquals("LU", countries.get(0).getCountry_code());
        assertEquals("HU", countries.get(countries.size()-1).getCountry_code());

    }

    private static String readFile(String path) {
        String outPut = "";
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                outPut=outPut + (sCurrentLine) + "\n";
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return outPut;
    }
}
