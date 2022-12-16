package d07;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	
	private record Directory(String name, List<File> files) {
	}
	
	private record File(String name, long size) {
	}
	
	private Map<String, Directory> directoryMap = new HashMap<>();
	private Directory currentDirectory;
	
	private static final long TOTAL_DISC_SPACE = 70000000;
	private static final long UPDATE_SIZE = 30000000;
	
	public void compute(List<String> input) {
		performAllInstructions(input);
	}
	
	private void performAllInstructions(List<String> input) {
		Directory rootDirectory = new Directory("/", new ArrayList<>());
		directoryMap.put("/", rootDirectory);
		currentDirectory = rootDirectory;
		
		for (String instruction : input) {
			if (instruction.startsWith("$ cd")) {
				changeDirectory(instruction);
			} else if (instruction.startsWith("$ ls")) {
				showDirectory(instruction);
			} else {
				createFile(instruction);
			}
		}
	}
	
	
	private void changeDirectory(String instruction) {
		
		String directoryName = instruction.replace("$ cd ", StringUtils.EMPTY).trim();
		if (directoryName.equals("..")) {
			currentDirectory = directoryMap.getOrDefault(currentDirectory.name().substring(0, currentDirectory.name().lastIndexOf("/")), currentDirectory);
		} else {
			String fullPath = currentDirectory.name() + "/" + directoryName;
			currentDirectory = directoryMap.getOrDefault(fullPath, currentDirectory);
		}
	}
	
	private void createDirectory(String instruction) {
		String directoryName = instruction.replace("dir ", StringUtils.EMPTY).trim();
		Directory directory = new Directory(currentDirectory.name() + "/" + directoryName, new ArrayList<>());
		directoryMap.put(directory.name(), directory);
	}
	
	private void createFile(String instruction) {
		if (instruction.startsWith("dir")) {
			createDirectory(instruction);
		} else {
			String[] split = instruction.split(StringUtils.SPACE);
			File file = new File(split[1], Long.parseLong(split[0]));
			currentDirectory.files().add(file);
		}
	}
	
	public long findSumOfAllDirectoryBelow100kSpace() {
		Map<String, Long> stringLongMap = calculateAllDirectory();
		return stringLongMap.values().stream()
				.filter(it -> it.longValue() < 100_000)
				.mapToLong(Long::intValue)
				.sum();
	}
	
	private Map<String, Long> calculateAllDirectory() {
		Map<String, Long> directorySize = new HashMap<>();
		
		for (var item : directoryMap.values()) {
			long sum = 0L;
			for (var item2 : directoryMap.values()) {
				if (item2.name().startsWith(item.name())) {
					sum += item2.files()
							.stream()
							.map(File::size)
							.mapToLong(Long::intValue)
							.sum();
				}
			}
//			System.out.println("Item directory: " + item.name() + " has sum: " + sum);
			directorySize.put(item.name(), sum);
		}
		return directorySize;
	}
	
	public long findSmallestDirectoryToDelete() {
		Map<String, Long> allDirectorySizes = calculateAllDirectory();
		Long currentlyUsedSpace = calculateAllDirectory().get("/");
		
		return allDirectorySizes.values().stream()
				.mapToLong(Long::longValue)
				.filter(it -> TOTAL_DISC_SPACE - currentlyUsedSpace + it > UPDATE_SIZE)
				.min()
				.orElse(-1);
		
	}
	
	// to high 17187447
	private void showDirectory(String instruction) {
		// do nothing
	}
	
	
}
