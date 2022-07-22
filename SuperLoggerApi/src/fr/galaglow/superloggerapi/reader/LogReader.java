package fr.galaglow.superloggerapi.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import fr.galaglow.superloggerapi.SuperLogger;
import fr.galaglow.superloggerapi.utils.Pair;

public class LogReader {

	private  String path, toSearch;
	private  final List<File> files;
	private final HashMap<String, String>checkedTrue;

	private final File folder;

	public LogReader(String path, String wordToSearch) {
		this.files = new ArrayList<>();
		this.path = path;
		this.toSearch = wordToSearch;
		this.folder = new File(this.path);
		this.checkedTrue = new HashMap<String, String>();
	}

	public void getFileExtension() {
		for (File file : Objects.requireNonNull(folder.listFiles())) {
			if (file.isFile()) {
				if (file.getAbsolutePath().endsWith(SuperLogger.FILE_EXTENSION)) {
					files.add(file);
					// System.out.println(file + "  |||||  " + file.getAbsolutePath());
				}
			}
		}
	}

	public HashMap<String, String> checkWordInFile() {
		getFileExtension();

		try {
			for (File file : files) {
				String line;
				final BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(file.toPath()), StandardCharsets.UTF_8));
				line = reader.readLine();
				while(line != null) {
					// System.out.println(checkedTrue);
					if (line.contains(this.toSearch)) {
						checkedTrue.put(file.getName(), line);
					}
					line = reader.readLine();
				}
			}
			return checkedTrue ;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getPath() {
		return path;
	}

	public String getWordToSearch() {
		return toSearch;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setWordToSearch(String wordToSearch) {
		this.toSearch = wordToSearch;
	}

}