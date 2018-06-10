import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public class functional {
	public static void main(String[] args) {
		final List<Integer> ls = Arrays.asList(14,32,200,42,10,8,11,51,21,13,47);
//		ls.stream().forEach(num ->System.out.println(  num) );
//		ls.stream().filter(num -> num >40).forEach(num -> System.out.println( num));
		final int sum = ls.stream().
				filter(num -> num >100).
				reduce(0, (a,b) -> a + b);
		final List<Integer> ls2 = ls.stream().filter(num -> num%2==1).collect(Collectors.toList());
		System.out.println((ls.stream().filter(x ->x%2==0).max((x,y)->Integer.compare(x, y))));
		System.out.println(sum);
		
		
		/**
		 * merging two lists with only distinct values
		 */
		final List<pair> lsp = Arrays.asList(new pair(1,5),new pair(2,8),new pair(14,52));
		final List<pair> lsp2 = Arrays.asList(new pair(1,5),new pair(2,8),new pair(14,52));
		
		final List<pair> lsp3 = Stream.concat(lsp.stream(),lsp2.stream()).collect(Collectors.toList());
		//final List<Integer> lsp4 = Stream.of(ls2,ls).forEach(List::addAll);	
		final List<Integer> lsp4 = merge(ls,ls2);
		}
		
		public static<T> List<T> merge(List<T> list1, List<T> list2)
		{
			return Stream.of(list1, list2)
						   .flatMap(x -> x.stream())
						   .collect(Collectors.toList());
		}
		public static<T> List<T> merge2(List<T> list1, List<T> list2)
		{
			return Stream.concat(list1.stream(), list2.stream())
						   .collect(Collectors.toList());
		}
	}

class pair{
	private int id;
	private List<Integer> val;
	public pair(int id, int val) {
		super();
		this.id = id;
		this.val.add(val);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Integer> getVal() {
		return val;
	}
	public void addVal(int val) {
		this.val.add(val);
	}
	public void addVal(List<Integer> val) {
		this.val = val;
	}
}