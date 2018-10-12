package preRule;

import java.util.List;
import java.util.function.Function;

/**
 * 
 * @author Matthias Webhofer
 * @since 1.2
 *
 */
@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
public class StatementLambdaToExpressionRule {
	public Function<Function, Function> f = (Function function) -> {
		return function.compose(function);
	};

	private Function<Function, Function> g = (Function function) -> function.compose(function);

	private String elementString;

	private void testMethod(List<Integer> list) {
		list.stream().map(element -> element * 2);
		list.stream().map(element -> {
			element *= 2;
			element += 1;
			return element;
		});
		list.stream().map(element -> {
			return element * 2;
		});
		list.stream().map(element -> // I don't want to break anything
		{
			return element * 2;
		});
		list.forEach(element -> {
			doSomething(element);
		});
		list.forEach(element -> {
			elementString = element.toString();
		});
		list.forEach(element -> {
			new Integer(1);
		});
		list.forEach(element -> {
			doSomething(element);
			return;
		});
		
		/*
		 * Saving comments
		 */
		
		list.forEach(element -> {
			// save me
			new Integer(1);
		});
		
		list.forEach(element -> {
			new Integer(1);
			// save trailing comment
		});
		
		list.forEach(element -> {
			new Integer(1);
			
		}// save lambda-exp trailing comment 
		);
		
		list.forEach(element -> {
			//save me
			doSomething(element);
			return;
		});
		
		list.forEach(element -> {
			new Integer(1);
		}
		 
		// i'm here
		);
	}

	private void doSomething(int element) {
		System.out.println(element);
	}
}
