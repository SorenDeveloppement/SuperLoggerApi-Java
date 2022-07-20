package fr.galaglow.superloggerapi;

import fr.galaglow.superloggerapi.utils.SurroundKey;

public class SuperLogger {
	
	public String prefix;
	public SurroundKey surroundKey;
	public String args;
	
	public  SuperLogger(String prefix, SurroundKey surroundKey,  String args) {
		
		this.prefix = prefix;
		this.surroundKey = surroundKey;
		this.args = args;
		
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
			System.out.println(backSlash + prefix + backSlash + args);
		} else if (surroundKey.equals(SurroundKey.SLASH)) {
			System.out.println(slash + prefix + slash + args);
		} else if (surroundKey.equals(SurroundKey.BAR)) {
			System.out.println(bar + prefix + bar + args);
		} else if (surroundKey.equals(SurroundKey.PARENTHESES)) {
			System.out.println(openedPar + prefix + closedPar + args);
		}  else if (surroundKey.equals(SurroundKey.HOOKS)) {
			System.out.println(openedHooks + prefix + closedHooks + args);
		} else if (surroundKey.equals(SurroundKey.HUGS)) {
			System.out.println(openedHugs + prefix + closedHugs + args);
		} else {
			System.out.println(doublePoint + prefix + doublePoint + args);
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
	
	public void setPrefix(String newPrefix) {
		this.prefix = newPrefix;
	}
	
	public void setSurroundKey(SurroundKey newSurroundKey) {
		this.surroundKey = newSurroundKey;
	}
	
	public void setArgs(String newArgs) {
		this.args = newArgs;
	}

}
