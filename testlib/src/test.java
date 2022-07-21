import fr.galaglow.superloggerapi.SuperLogger;
import fr.galaglow.superloggerapi.reader.LogReader;
import fr.galaglow.superloggerapi.utils.AnsiConsoleTextColors;
import fr.galaglow.superloggerapi.utils.SurroundKey;

import java.util.Arrays;

public class test {

    public static void main(String[] args) {
        SuperLogger logger = new SuperLogger("tamereenslip", SurroundKey.BAR, "log ta mere en slip de guerre", AnsiConsoleTextColors.BLACK, "testtamere/");
        logger.log();

        logger.setArgs("log ta mere en sl");
        logger.log();

        LogReader lReader = new LogReader("testtamere/", "mere");

        System.out.println(lReader.checkWordInFile());
    }

}
