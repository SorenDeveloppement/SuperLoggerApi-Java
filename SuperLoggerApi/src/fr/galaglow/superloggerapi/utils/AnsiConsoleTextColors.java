package fr.galaglow.superloggerapi.utils;

public enum AnsiConsoleTextColors {
	
	BASIC("\033[0;37m "),
	
	BLACK("\033[0;30m "),

	RED("\u001B[31m"),

    GREEN("\033[0;32m "),

    YELLOW("\033[0;33m "),

    BLUE("\033[0;34m "), 
    
    MAGENTA("\033[0;35m "),

    CYAN("\033[0;36m "),

    WHITE("\033[0;37m ");
	
	private final String ansiColor;

	AnsiConsoleTextColors(String aColor) {
		this.ansiColor = aColor;
	}
	
	public String getAnsiColor() {
        return ansiColor;
    }

}
