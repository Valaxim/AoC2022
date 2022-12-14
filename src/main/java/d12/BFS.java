package d12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class BFS {
	private int dijkstra(final Square start, final Square end, final List<Square> squares) {
		final PriorityQueue<Square> queue = new PriorityQueue<>();
		queue.offer(start);
		final Map<Square, Integer> distances = new HashMap<>();
		distances.put(start, 0);
		while (!queue.isEmpty()) {
			final Square current = queue.poll();
			final int dist = distances.get(current);
			final List<Square> neighbours = current.getNeighbours(squares);
			for (final Square n : neighbours) {
				int ndist = dist;
				ndist++;
				if (ndist < distances.getOrDefault(n, Integer.MAX_VALUE)) {
					distances.put(n, ndist);
					queue.add(n);
				}
			}
		}
		
		return distances.entrySet().stream().filter(e -> e.getKey().equals(end)).collect(Collectors.toList()).stream()
				.map(Map.Entry::getValue).mapToInt(d -> d).min().orElse(Integer.MAX_VALUE);
	}
	
	private List<Square> getSquares(final List<String> input) {
		final List<Square> squares = new ArrayList<>();
		for (int y = 0; y < input.size(); y++) {
			final String line = input.get(y);
			for (int x = 0; x < line.length(); x++) {
				final char height = line.charAt(x);
				final Square s = new Square(x, y, height);
				if (height == 'S') {
					s.setHeight('a');
					s.setStart(true);
				} else if (height == 'E') {
					s.setHeight('z');
					s.setEnd(true);
				}
				squares.add(s);
			}
			
		}
		return squares;
	}
	
	private List<Square> getSquaresForMultipleStarts(final List<String> input) {
		final List<Square> squares = new ArrayList<>();
		for (int y = 0; y < input.size(); y++) {
			final String line = input.get(y);
			for (int x = 0; x < line.length(); x++) {
				final char height = line.charAt(x);
				final Square s = new Square(x, y, height);
				if (height == 'S' || height == 'a') {
					s.setHeight('a');
					s.setStart(true);
				} else if (height == 'E') {
					s.setHeight('z');
					s.setEnd(true);
				}
				squares.add(s);
			}
			
		}
		return squares;
	}
	public String runPart1(final List<String> input) {
		final List<Square> squares = getSquares(input);
		final Square start = squares.stream().filter(Square::isStart).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("No start square found"));
		final Square end = squares.stream().filter(Square::isEnd).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("No end square found"));
		return String.valueOf(dijkstra(start, end, squares));
	}
	
	public String runPart2(final List<String> input) {
		final List<Square> squares = getSquaresForMultipleStarts(input);
		final List<Square> startList = squares.stream().filter(Square::isStart).collect(Collectors.toList());
		final Square end = squares.stream().filter(Square::isEnd).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("No end square found"));
		List<Integer> output = new ArrayList<>();
		for (Square square: startList) {
			output.add(dijkstra(square, end, squares));
		}
		
		return String.valueOf(output.stream().mapToInt(it -> it).min().orElse(Integer.MAX_VALUE));
	}
	
}
