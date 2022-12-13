package d11;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
	
	public static final int AMOUNT_OF_ROUNDS = 20;
	public static final int EXTENDED_AMOUNT_OF_ROUNDS = 10000;
	private List<Monkey> monkeyList;
	
	public void computePartOne() {
//		monkeyList = InputParser.getTestData();
		monkeyList = InputParser.getProductionData();
		for (int step = 0; step < AMOUNT_OF_ROUNDS; step++) {
			for (Monkey monkey : monkeyList) {
				for (Present present : monkey.getPresentList()) {
					monkey.increaseInspectedPresents();
					present.increaseWorryLevel(monkey.getOperation(), monkey.getOperationValue());
					present.divideWorryLevelByThree();
					movePresentToAnotherMonkey(monkey, present);
				}
			}
			for (Monkey m : monkeyList) {
				int round = step + 1;
				System.out.println("After R: " + round + ", " + m + "IPN: " + m.getInspectedPresent() +
						"," +
						" have currently: " + m.getPresentList());
			}
			List<Long> collect = monkeyList.stream()
					.map(it -> it.getInspectedPresent())
					.sorted(Comparator.reverseOrder())
					.collect(Collectors.toList());
			System.out.println(collect.get(0) * collect.get(1));
		}

//		System.out.println("DONE");
	
	}
	
	
	public void computePartTwo() {
//		monkeyList = InputParser.getTestData();
		monkeyList = InputParser.getProductionData();
		long worryLevelDivisible = calculateWorryLevelDivisible(monkeyList);
		for (int step = 0; step < EXTENDED_AMOUNT_OF_ROUNDS; step++) {
			for (Monkey monkey : monkeyList) {
				for (Present present : monkey.getPresentList()) {
					monkey.increaseInspectedPresents();
					present.increaseWorryLevel(monkey.getOperation(), monkey.getOperationValue());
					present.handleWorryLevel(worryLevelDivisible);
					movePresentToAnotherMonkey(monkey, present);
				}
			}
			for (Monkey m : monkeyList) {
				int round = step + 1;
				System.out.println("After R: " + round + ", " + m + "IPN: " + m.getInspectedPresent() +
						"," +
						" have currently: " + m.getPresentList());
			}
			List<Long> collect =
					monkeyList.stream().map(it -> it.getInspectedPresent()).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
			System.out.println(collect.get(0) * collect.get(1));
		}

//		System.out.println("DONE");
	
	}
	
	
	private void movePresentToAnotherMonkey(Monkey monkey, Present present) {
		if (present.getWorryLevel() % monkey.getDivisibleValue() == 0) {
			monkey.removePresent(present);
			monkeyList.get(monkey.getTestPositiveOutput()).addPresent(present);
		} else {
			monkey.removePresent(present);
			monkeyList.get(monkey.getTestNegativeOutput()).addPresent(present);
		}
	}
	
	private long calculateWorryLevelDivisible(List<Monkey> monkeyList) {
		double output = 1;
		for (Monkey monkey : monkeyList) {
			output *= monkey.getDivisibleValue();
		}
		return (long) output;
		
	}
}
