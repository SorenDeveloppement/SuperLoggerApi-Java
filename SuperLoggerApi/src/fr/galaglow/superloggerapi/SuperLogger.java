package fr.galaglow.superloggerapi;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import fr.galaglow.superloggerapi.utils.AnsiConsoleTextColors;
import fr.galaglow.superloggerapi.utils.SurroundKey;

public class SuperLogger {
	
	public String prefix, args, path;
	public SurroundKey surroundKey;
	public AnsiConsoleTextColors aColor;
	
	public static final String FILE_EXTENSION = ".slog";
	
	public  SuperLogger(String prefix, SurroundKey surroundKey,  String args, AnsiConsoleTextColors aColor, String path) {
		
		this.prefix = prefix;
		this.surroundKey = surroundKey;
		this.args = args;
		this.aColor = aColor;
		this.path = path;
		
		System.out.println("Thanks for using SuperLoggerApi !");
		
	}
	
	public void log() {
		
		String backSlash = "\\";
		String slash = "//";
		String bar = "||";
		String openedPar = "((";
		String closedPar = "))";
		String openedHooks = "[[";
		String closedHooks = "]]";
		String openedHugs = "{{";
		String closedHugs = "}}";
		String doublePoint = "::";
		
		if (surroundKey.equals(SurroundKey.BACK_SLASH)) {
			System.out.println(this.aColor + backSlash + prefix + backSlash + args + "\u001B[0m");
			logInFile(backSlash, backSlash);
		} else if (surroundKey.equals(SurroundKey.SLASH)) {
			System.out.println(this.aColor + slash + prefix + slash + args + "\u001B[0m");
			logInFile(slash, slash);
		} else if (surroundKey.equals(SurroundKey.BAR)) {
			System.out.println(this.aColor + bar + prefix + bar + args + "\u001B[0m");
			logInFile(bar, bar);
		} else if (surroundKey.equals(SurroundKey.PARENTHESES)) {
			System.out.println(this.aColor + openedPar + prefix + closedPar + args + "\u001B[0m");
			logInFile(openedPar, closedPar);
		}  else if (surroundKey.equals(SurroundKey.HOOKS)) {
			System.out.println(this.aColor + openedHooks + prefix + closedHooks + args + "\u001B[0m");
			logInFile(openedHooks, closedHooks);
		} else if (surroundKey.equals(SurroundKey.HUGS)) {
			System.out.println(this.aColor + openedHugs + prefix + closedHugs + args + "\u001B[0m");
			logInFile(openedHugs, closedHugs);
		} else {
			System.out.println(this.aColor + doublePoint + prefix + doublePoint + args + "\u001B[0m");
			logInFile(doublePoint, doublePoint);
		}
		
	}
	
	@SuppressWarnings("deprecation")
	public void logInFile(String sKey1, String sKey2) {
		
		Date date = new Date();
		
		 final File dir = new File(this.path + date.getDay() + "-" + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds() + FILE_EXTENSION);
		
		 try {
		      if (dir.createNewFile()) {
		    	  System.out.println("File created: " + dir.getName());
		      }
		    } catch (IOException e) {
		    	System.out.println("An error occurred.");
		    	e.printStackTrace();
		    }
		 
		 try {
			 FileWriter logWriter = new FileWriter(this.path + date.getDay() + "-" + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds() + FILE_EXTENSION);
			 logWriter.write(sKey1 + prefix + sKey2 + args + "\u001B[0m");
			 logWriter.close();
			 System.out.println("Successfully wrote to the file.");
		 } catch (IOException e) {
		    	System.out.println("An error occurred during the wrote to the file.");
		    	e.printStackTrace();
		 }
		
	}
	
	public String getPrefix() {
		return prefix;
	}
	
	public SurroundKey getSurroundKey() {
		return surroundKey;
	}
	
	public String getArgs() {
		return args;
	}
	
	public AnsiConsoleTextColors getColor() {
		return aColor;
	}
	
	public String getLogFilePath() {
		return path;
	}
	
	public void setPrefix(String newPrefix) {
		this.prefix = newPrefix;
	}
	
	public void setSurroundKey(SurroundKey newSurroundKey) {
		this.surroundKey = newSurroundKey;
	}
	
	public void setArgs(String newArgs) {
		this.args = newArgs;
	}
	
	public void setColor(AnsiConsoleTextColors newAColor) {
		this.aColor = newAColor;
	}
	
	public void setNewLogFilePath(String newPath) {
		this.path = newPath;
	}

}
