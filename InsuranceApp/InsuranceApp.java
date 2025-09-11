package InsuranceApp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InsuranceApp {
	public static void main(String[] args) {
		List<Policy> policies = Arrays.asList(new Policy("P001", "Alice Smith", 1500),
				new Policy("P002", "Bob Johnson", 800), new Policy("P003", "Charlie Smith", 2200),
				new Policy("P004", "David Lee", 1200), new Policy("P005", "Eve Davis", 1800),
				new Policy("P006", "Frank Miller", 2500), new Policy("P007", "Grace Lee", 900));

		// 1. Filter Policies by Premium Amount > 1200
		List<Policy> filteredByPremium = policies.stream().filter(p -> p.getPremiumAmount() > 1200)
				.collect(Collectors.toList());
		System.out.println("Policies with premium > 1200:");
		filteredByPremium.forEach(System.out::println);

		// 2. Sort Policies by Holder Name
		List<Policy> sortedByName = policies.stream().sorted(Comparator.comparing(Policy::getHolderName))
				.collect(Collectors.toList());
		System.out.println("Policies sorted by holder name:");
		sortedByName.forEach(System.out::println);

		// 3. Compute Total Premium
		double totalPremium = policies.stream().mapToDouble(Policy::getPremiumAmount).sum();
		System.out.println("Total premium amount : " + totalPremium);

		// 4. Print Policy Details
		System.out.println("\nAll policy details:");
		policies.forEach(p -> System.out.println(p));

		// 5. Filter Policies by Premium Range 1000 - 2000
		List<Policy> filteredRange = policies.stream()
				.filter(p -> p.getPremiumAmount() >= 1000 && p.getPremiumAmount() <= 2000).collect(Collectors.toList());
		System.out.println("\nPolicies with premium between 1000 and 2000:");
		filteredRange.forEach(System.out::println);

		// 6. Find Policy with Highest Premium
		policies.stream().max(Comparator.comparing(Policy::getPremiumAmount))
				.ifPresent(p -> System.out.println("\nHighest Premium : " + p));

		// 7. Group Policies by Holder Name Initial
		Map<Character, List<Policy>> groupedByInitial = policies.stream()
				.collect(Collectors.groupingBy(p -> p.getHolderName().charAt(0)));
		System.out.println("\nPolicies grouped by holder name initial:");
		groupedByInitial.forEach((initial, list) -> {
			System.out.println(initial + " : " + list);
		});

		// 8. Compute Average Premium
		double averagePremium = policies.stream().mapToDouble(Policy::getPremiumAmount).average().orElse(0);
		System.out.println("\nAverage Premium : " + averagePremium);

		// 9. Sort Policies by Premium and Print
		System.out.println("\nPolicies sorted by premium amount:");
		policies.stream().sorted(Comparator.comparing(Policy::getPremiumAmount)).forEach(p -> System.out.println(p));

		// 10. Check If Any Policy Exceeds 2000
		boolean anyAbove2000 = policies.stream().anyMatch(p -> p.getPremiumAmount() > 2000);
		System.out.println("\nAny policy with premium > 2000? :" + anyAbove2000);

		// 11. Count Policies for Each Premium Range
		Map<String, Long> premiumRanges = policies.stream().collect(Collectors.groupingBy(p -> {
			if (p.getPremiumAmount() <= 1000)
				return "0-1000";
			else if (p.getPremiumAmount() <= 2000)
				return "1001-2000";
			else
				return "2001+";
		}, Collectors.counting()));
		System.out.println("\nCount of policies by premium range:");
		premiumRanges.forEach((range, count) -> System.out.println(range + " : " + count));

		// 12. Extract Unique Holder Names
		Set<String> uniqueHolderNames = policies.stream().map(Policy::getHolderName).collect(Collectors.toSet());
		System.out.println("\nUnique holder names:");
		uniqueHolderNames.forEach(System.out::println);

		// 13. Find Policies by Holder Name Substring "Smith"
		List<Policy> smithPolicies = policies.stream().filter(p -> p.getHolderName().toLowerCase().contains("smith"))
				.collect(Collectors.toList());
		System.out.println("\nPolicies where holder's name contains 'Smith':");
		smithPolicies.forEach(System.out::println);

		// 14. Create a Map of Policy Numbers to Premium Amounts
		Map<String, Double> policyMap = policies.stream()
				.collect(Collectors.toMap(Policy::getHolderName, Policy::getPremiumAmount));
		System.out.println("\nMap of policy numbers to premium amounts:");
		policyMap.forEach((name, amount) -> System.out.println(name + " : " + amount));

		// 15. Finding Most Frequent Words in a Text Corpus
		String text = "Hello world hello Java Java hello world code code code java";
		int topN = 3;
		Map<String, Long> wordCount = Arrays.stream(text.toLowerCase().split("\\W+"))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("\nTop " + topN + " most frequent words:");
		wordCount.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
				.limit(topN).forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

		// 16. Finding the Second Most Repeated Word
		Optional<String> secondMost = wordCount.entrySet().stream()
				.sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder())).skip(1)
				.map(Map.Entry::getKey).findFirst();
		System.out.println("\nSecond most repeated word:");
		secondMost.ifPresent(System.out::println);
	}
}
