import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class TestFinder {

    @Test
    //tests processing without internet oonnection
    public void processPayload() {

        String payload = readFile("src/test/resources/jsonvat.com.json");
        Finder.processPayload(payload);

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
