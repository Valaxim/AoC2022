package d11;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InputParser {
	
	public static List<Monkey> getTestData() {
		List<Monkey> monkeyList = new CopyOnWriteArrayList<>();
		
		Monkey monkey0 = new Monkey(0, Monkey.Operation.MULTIPLE, 19, 23, 2, 3);
		monkey0.addPresent(new Present(79));
		monkey0.addPresent(new Present(98));
		monkeyList.add(monkey0);
		
		Monkey monkey1 = new Monkey(1, Monkey.Operation.ADD, 6, 19, 2, 0);
		monkey1.addPresent(new Present(54));
		monkey1.addPresent(new Present(65));
		monkey1.addPresent(new Present(75));
		monkey1.addPresent(new Present(74));
		monkeyList.add(monkey1);
		
		Monkey monkey2 = new Monkey(2, Monkey.Operation.SQUARE, null, 13, 1, 3);
		monkey2.addPresent(new Present(79));
		monkey2.addPresent(new Present(60));
		monkey2.addPresent(new Present(97));
		monkeyList.add(monkey2);
		
		Monkey monkey3 = new Monkey(3, Monkey.Operation.ADD, 3, 17, 0, 1);
		monkey3.addPresent(new Present(74));
		monkeyList.add(monkey3);
		
		return monkeyList;
	}
	
	public static List<Monkey> getProductionData() {
		List<Monkey> monkeyList = new CopyOnWriteArrayList<>();
		Monkey monkey0 = new Monkey(0, Monkey.Operation.MULTIPLE,
				13, 19, 2, 7);
		monkey0.addPresent(new Present(75));
		monkey0.addPresent(new Present(75));
		monkey0.addPresent(new Present(98));
		monkey0.addPresent(new Present(97));
		monkey0.addPresent(new Present(79));
		monkey0.addPresent(new Present(97));
		monkey0.addPresent(new Present(64));
		monkeyList.add(monkey0);
		
		Monkey monkey1 = new Monkey(1, Monkey.Operation.ADD,
				2, 3, 4, 5);
		monkey1.addPresent(new Present(50));
		monkey1.addPresent(new Present(99));
		monkey1.addPresent(new Present(80));
		monkey1.addPresent(new Present(84));
		monkey1.addPresent(new Present(65));
		monkey1.addPresent(new Present(95));
		monkeyList.add(monkey1);
		
		Monkey monkey2 = new Monkey(2, Monkey.Operation.ADD,
				1, 11, 7, 3);
		monkey2.addPresent(new Present(96));
		monkey2.addPresent(new Present(74));
		monkey2.addPresent(new Present(68));
		monkey2.addPresent(new Present(96));
		monkey2.addPresent(new Present(56));
		monkey2.addPresent(new Present(71));
		monkey2.addPresent(new Present(75));
		monkey2.addPresent(new Present(53));
		monkeyList.add(monkey2);
		
		Monkey monkey3 = new Monkey(3, Monkey.Operation.ADD,
				8, 17, 6, 1);
		monkey3.addPresent(new Present(83));
		monkey3.addPresent(new Present(96));
		monkey3.addPresent(new Present(86));
		monkey3.addPresent(new Present(58));
		monkey3.addPresent(new Present(92));
		monkeyList.add(monkey3);
		
		Monkey monkey4 = new Monkey(4, Monkey.Operation.SQUARE,
				null, 5, 0, 5);
		monkey4.addPresent(new Present(99));
		monkeyList.add(monkey4);
		
		Monkey monkey5 = new Monkey(5, Monkey.Operation.ADD,
				4, 2, 2, 0);
		monkey5.addPresent(new Present(60));
		monkey5.addPresent(new Present(54));
		monkey5.addPresent(new Present(83));
		monkeyList.add(monkey5);
		
		Monkey monkey6 = new Monkey(6, Monkey.Operation.MULTIPLE,
				17, 13, 4, 1);
		monkey6.addPresent(new Present(77));
		monkey6.addPresent(new Present(67));
		monkeyList.add(monkey6);
		
		Monkey monkey7 = new Monkey(7, Monkey.Operation.ADD,
				5, 7, 3, 6);
		monkey7.addPresent(new Present(95));
		monkey7.addPresent(new Present(65));
		monkey7.addPresent(new Present(58));
		monkey7.addPresent(new Present(76));
		monkeyList.add(monkey7);
		
		return monkeyList;
	}
}