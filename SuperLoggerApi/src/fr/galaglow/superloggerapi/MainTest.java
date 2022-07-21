package fr.galaglow.superloggerapi;


import fr.galaglow.superloggerapi.utils.AnsiConsoleTextColors;
import fr.galaglow.superloggerapi.utils.SurroundKey;

public class MainTest {

	public static void main(String[] args)  {
		SuperLogger logger = new SuperLogger("TESTPREFIX", SurroundKey.HUGS, "test 2 test", AnsiConsoleTextColors.RED, "test/");
		logger.log();
	}

}
