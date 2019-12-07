package com.ocp8.FunctionalInterface_cap4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BooleanSupplier;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class testStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new testStreams().partitioning();

	}
	
	public void createStreamSources() {
		Stream < String > empty = Stream.empty();// count = 0 
		Stream < Integer > singleElement = Stream.of(1);// count = 1 
		Stream < Integer > fromArray = Stream.of( 1, 2, 3);// count = 2

		List < String > list = Arrays.asList("a", "b", "c"); 
		Stream < String > fromList = list.stream(); 
		Stream < String > fromListParallel = list.parallelStream();

	    Stream < Double > randoms = Stream.generate( Math::random); 
	    Stream < Integer > oddNumbers = Stream.iterate( 1, n -> n + 2);

	}
	
	public void terminalOperations() {
		Stream < String > s = Stream.of("monkey", "gorilla", "bonobo"); 
		System.out.println( s.count()); // 3
		
		Stream < String > ss = Stream.of("monkey", "ape", "bonobo"); 
		Optional < String > min = ss.min(( s1, s2) -> s1. length() - s2.length()); 
		min.ifPresent( System.out::println); // ape

		Stream < String > sss = Stream.of("monkey", "gorilla", "bonobo"); 
		Stream < String > infinite = Stream.generate(() -> "chimp"); 
		sss.findAny().ifPresent( System.out:: println); // monkey 
		infinite.findAny().ifPresent( System.out:: println); // chimp

		
		List < String > list = Arrays.asList("monkey", "2", "chimp"); 
		Stream < String > infinite2 = Stream.generate(() -> "chimp"); 
		Predicate < String > pred = x -> Character.isLetter( x.charAt(0)); 
		System.out.println( list.stream(). anyMatch( pred)); // true 
		System.out.println( list.stream(). allMatch( pred)); // false 
		System.out.println( list.stream(). noneMatch( pred)); // false 
		System.out.println( infinite2.anyMatch( pred)); // true
		
	}
	
	public void reduce() {
		Stream < String > stream = Stream.of("w", "o", "l", "f"); 
		String word = stream.reduce("", (sx, c) -> sx + c); 
		System.out.println( word);// wolf
		
		Stream < String > stream2 = Stream.of("w", "o", "l", "f"); 
		String word2 = stream2.reduce("", String::concat); 
		System.out.println(word2);// wolf
	}
	
	public void primitiveStreams() {
		
	}
	
	public void collecting() {
		Stream < String > stream = Stream.of(" w", "o", "l", "f"); 
		StringBuilder word = stream.collect( StringBuilder::new, StringBuilder::append, StringBuilder::append);
		System.out.println(word);

		Stream < String > stream2 = Stream.of(" w", "o", "l", "f"); 
		TreeSet < String > set = stream2.collect( TreeSet::new, TreeSet::add, TreeSet::addAll); 
		System.out.println(set); // [f, l, o, w]

		Stream < String > stream3 = Stream.of(" w", "o", "l", "f"); 
		TreeSet < String > set3 = stream3.collect( Collectors.toCollection( TreeSet:: new)); 
		System.out.println(set3); // [f, l, o, w] 
		
		//If we didn’t need the set to be sorted, we could make the code even shorter: 
		Stream < String > stream4 = Stream.of(" w", "o", "l", "f"); 
		Set < String > set4 = stream4.collect( Collectors.toSet()); 
		System.out.println(set4); // [f, w, l, o]

		
	}
	
	public void intermediateOperations() {
		Stream < String > s = Stream.of("monkey", "gorilla", "bonobo"); 
		s.filter( x -> x.startsWith("m")).forEach( System.out::print);// monkey

		Stream < String > ss = Stream.of("duck", "duck", "duck", "goose"); 
		ss.distinct().forEach( System.out::print); // duckgoose
		
		Stream < Integer > s3 = Stream.iterate( 1, n -> n + 1); 
		s3.skip(5).limit(2).forEach(System.out::print);// 67

		Stream < String > s4 = Stream.of("monkey", "gorilla", "bonobo"); 
		s4.map( String::length).forEach(System.out::print);// 676
		
		Stream < String > s5 = Stream.of("brown-", "bear-"); 
		s5.sorted().forEach(System.out::print); // bear-brown-
		
		Stream < String > s6 = Stream.of("brown bear-", "grizzly-"); 
		s6.sorted(Comparator.reverseOrder()).forEach(System.out::print); //grizzly-brown bear-

		System.out.println();
		Stream < String > stream = Stream.of("black bear", "brown bear", "grizzly"); 
		long count = stream.filter( s7 -> s7.startsWith("g")).peek(System.out::println).count();// grizzly 
		System.out.println( count);// 1

	}
	
	public void printingStreams() {
		Stream<String> s = Stream.of("a","b","c");
		s.forEach(System.out::println); 
		System.out.println(s.collect(Collectors.toList())); 
		s.peek(System.out::println).count(); 
		s.limit(5).forEach(System.out::println);
	}
	
	public void primitives() {
		Stream < Integer > stream = Stream.of( 1, 2, 3); 
		System.out.println(stream.mapToInt( x -> x).sum());
		
		IntStream intStream = IntStream.of( 1, 2, 3); 
		OptionalDouble avg = intStream.average(); 
		System.out.println( avg.getAsDouble());
		
		DoubleStream random = DoubleStream.generate( Math::random); 
		DoubleStream fractions = DoubleStream.iterate(.5, d -> d / 2); 
		random.limit(3).forEach(System.out::println); 
		System.out.println(); 
		fractions.limit(3).forEach(System.out::println);

		IntStream range = IntStream.range( 1, 6); 
		range.forEach( System.out::println);
		
		IntStream rangeClosed = IntStream.rangeClosed(1, 5); 
		rangeClosed.forEach(System.out::println);

	}
	
	public void functionalInterfacesPrimitives() {
		BooleanSupplier b1 = () -> true; 
		BooleanSupplier b2 = () -> Math.random() > .5; 
		System.out.println( b1.getAsBoolean()); 
		System.out.println( b2.getAsBoolean());

		
	}
	
	public void collectingWithCollectors() {
//		Stream < String > ohMy = Stream.of("lions", "tigers", "bears"); 
//		String result = ohMy.collect( Collectors.joining(", ")); 
//		System.out.println( result); // lions, tigers, bears

//		Stream < String > ohMy = Stream.of("lions", "tigers", "bears"); 
//		Double result = ohMy.collect( Collectors.averagingInt(String::length)); 
//		System.out.println( result); // 5.333333333333333

		Stream < String > ohMy = Stream.of("lions", "tigers", "bears"); 
		TreeSet < String > result = ohMy.filter( s -> s.startsWith("t")).collect( Collectors.toCollection(TreeSet::new)); 
		System.out.println(result); // [tigers]

	}
	
	public void collectingIntoMaps() {
//		Stream < String > ohMy = Stream.of("lions", "tigers", "bears"); 
//		Map < String, Integer > map = ohMy.collect( Collectors.toMap( s -> s, String::length)); 
//		System.out.println( map); // {lions = 5, bears = 5, tigers = 6}
		
		Stream < String > ohMy = Stream.of("lions", "tigers", "bears"); 
		Map < Integer, String > map = ohMy.collect( Collectors.toMap( String::length, k -> k, (s1, s2) -> s1 + "," + s2)); 
		System.out.println( map);// {5 = lions, bears, 6 = tigers} 
		System.out.println( map.getClass());// class. java.util.HashMap

		
	}
	
	public void partitioning() {
		Stream < String > ohMy = Stream.of("lions", "tigers", "bears"); 
//		Map < Integer, List < String > > map = ohMy.collect( Collectors.groupingBy( String::length)); 
//		System.out.println( map); // {5 =[ lions, bears], 6 =[ tigers]}

		Map <Boolean, List < String >> map = ohMy.collect(Collectors.partitioningBy(s -> s.length() <= 5)); 
		System.out.println( map); // {false =[ tigers], true =[ lions, bears]}

		
	}
	
	private static int range( IntStream ints) { 
		IntSummaryStatistics stats = ints.summaryStatistics(); 
		if (stats.getCount() == 0) throw new RuntimeException(); 
			return stats.getMax() - stats.getMin(); 
	}

	

}
