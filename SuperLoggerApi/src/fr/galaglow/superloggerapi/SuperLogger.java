package fr.galaglow.superloggerapi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.galaglow.superloggerapi.utils.AnsiConsoleTextColors;
import fr.galaglow.superloggerapi.utils.SurroundKey;

public class SuperLogger {

	private String prefix, args, path;
	private SurroundKey surroundKey;
	private AnsiConsoleTextColors aColor;

	private Date date = new Date();

	private final File folder;
	private final File file;

	private final List<String> lines;

	private BufferedWriter bw;
	private BufferedReader br;

	public static final String FILE_EXTENSION = ".slog";

	public SuperLogger(String prefix, SurroundKey surroundKey,  String args, AnsiConsoleTextColors aColor, String path) {

		this.prefix = prefix;
		this.surroundKey = surroundKey;
		this.args = args;
		this.aColor = aColor;
		this.path = path;
		this.lines = new ArrayList<>();
		this.folder = new File(this.path);
		this.file = new File(folder.getAbsolutePath(), date.getDate() + "-" + date.getMonth() + "-"+ date.getYear() + "_" +  date.getHours() + "h" + FILE_EXTENSION);

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

		switch (surroundKey) {
		case BACK_SLASH:
			System.out.println(this.aColor.getAnsiColor() + backSlash + prefix + backSlash + args + "\033[0;37m");
			logInFile(backSlash, backSlash);
			break;
		case SLASH:
			System.out.println(this.aColor.getAnsiColor() + slash + prefix + slash + args + " \033[0;37m");
			logInFile(slash, slash);
			break;
		case BAR:
			System.out.println(this.aColor.getAnsiColor() + bar + prefix + bar + args +" \033[0;37m");
			logInFile(bar, bar);
			break;
		case PARENTHESES:
			System.out.println(this.aColor.getAnsiColor() + openedPar + prefix + closedPar + args + " \033[0;37m");
			logInFile(openedPar, closedPar);
		case HOOKS:
			System.out.println(this.aColor.getAnsiColor() + openedHooks + prefix + closedHooks + args +" \033[0;37m");
			logInFile(openedHooks, closedHooks);
			break;
		case HUGS:
			System.out.println(this.aColor.getAnsiColor() + openedHugs + prefix + closedHugs + args + " \033[0;37m");
			logInFile(openedHugs, closedHugs);
			break;
		case DOUBLE_POINT:
			System.out.println(this.aColor.getAnsiColor() + doublePoint + prefix + doublePoint + args +" \033[0;37m");
			logInFile(doublePoint, doublePoint);
		default:
			System.out.println(this.aColor.getAnsiColor() + openedHooks + prefix + closedHooks + args +" \033[0;37m");
			logInFile(openedHooks, closedHooks);
			break;
		}

	}

	private void resetBufferedReader() {
		try {
			this.br.close();
			this.br = new BufferedReader(new InputStreamReader(Files.newInputStream(this.file.toPath()), StandardCharsets.UTF_8));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public void logInFile(String sKey1, String sKey2) {
		try {	        
			if(!folder.exists()) {
				folder.mkdir();
			}

			if(!file.exists()) {
				try {
					file.createNewFile();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			try {
				this.br = new BufferedReader(new InputStreamReader(Files.newInputStream(file.toPath()), StandardCharsets.UTF_8));

				String line;
				line = br.readLine();

				while(line != null) {
					lines.add(line);
					line = br.readLine();
				}

				lines.add(sKey1 + prefix + sKey2 + args);

				this.bw =  new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(file.toPath()), StandardCharsets.UTF_8));

				for(String l : lines) {
					bw.write(l);
					bw.newLine();
				}
				this.resetBufferedReader();
				bw.flush();

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error during the creation of the file / folder");
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
