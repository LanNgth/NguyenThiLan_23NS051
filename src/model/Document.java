package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Document {
	private List<String> lines;

	public Document() {
		lines = new ArrayList<>();
	}

	public List<String> getLines() {
		return lines;
	}

	public void addLine(String line) {
		lines.add(line);
	}

	public void addLines(List<String> newLines) {
		lines.addAll(newLines);
	}

	public String getAllText() {
		return lines.stream().collect(Collectors.joining("\n"));
	}
}
