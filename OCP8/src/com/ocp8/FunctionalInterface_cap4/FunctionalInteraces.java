package com.ocp8.FunctionalInterface_cap4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalInteraces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FunctionalInteraces().testOptional();
		
		Optional <Double> opt = average( 90, 100); 
		if (opt.isPresent())
			System.out.println( opt.get()); // 95.0
			
	}
	
	public void Supplier() {
//		Supplier < LocalDate > s1 = LocalDate:: now; 
//		Supplier < LocalDate > s2 = () -> LocalDate.now();
//		
//		LocalDate d1 = s1. get(); 
//		LocalDate d2 = s2. get(); 
//		System.out.println( d1); 
//		System.out.println( d2);
		
//		Supplier <StringBuilder> s1 = StringBuilder:: new; 
//		Supplier <StringBuilder> s2 = () -> new StringBuilder(); 
//		System.out.println( s1.get()); 
//		System.out.println( s2.get());
		
		Supplier <ArrayList <String>> s1 = ArrayList < String >:: new; 
		ArrayList <String> a1 = s1.get(); 
		System.out.println(a1);

	}
	
	public void Comsumer() {
		Consumer < String > c1 = System.out:: println; 
		Consumer < String > c2 = x -> System.out.println( x); 
		c1. accept("Annie"); 
		c2. accept("Annie");
		
//		biconsumer
		Map <String, Integer> map = new HashMap<>(); 
		BiConsumer < String, Integer > b1 = map:: put; 
		BiConsumer < String, Integer > b2 = (k, v) -> map.put( k, v); 
		b1.accept("chicken", 7); 
		b2.accept("chick", 1); 
		System.out.println( map);
	}
	
	public void Predicate() {
		Predicate <String> p1 = String::isEmpty; 
		Predicate <String> p2 = x -> x.isEmpty(); 
		System.out.println(p1.test("")); 
		System.out.println(p2.test(""));

		BiPredicate <String, String> b1 = String::startsWith; 
		BiPredicate <String, String> b2 = (string, prefix) -> string.startsWith(prefix); 
		System.out.println(b1.test("chicken", "chick")); 
		System.out.println(b2.test("chicken", "chick"));

		Predicate <String> egg = s -> s.contains("egg");
		Predicate <String> brown = s -> s.contains("brown");		

		Predicate <String> brownEggs = egg.and(brown); 
		Predicate <String> otherEggs = egg.and(brown.negate());
		
		System.out.println(brownEggs.test("egg brown"));
		
	}
	
	public void Function() {
		Function <String, Integer> f1 = String::length; 
		Function <String, Integer> f2 = x -> x.length(); 
		System.out.println( f1.apply("cluck"));// 5 
		System.out.println( f2.apply("cluck"));// 5

		BiFunction <String, String, String> b1 = String::concat; 
		BiFunction <String, String, String> b2 = (string, toAdd) -> string.concat(toAdd); 
		System.out.println( b1.apply("baby ", "chick")); // baby chick 
		System.out.println( b2.apply("baby ", "chick")); // baby chick
		
	}
	
	public void unaryBinaryOperator() {
		UnaryOperator <String> u1 = String::toUpperCase; 
		UnaryOperator <String> u2 = x -> x.toUpperCase(); 
		System.out.println( u1.apply("chirp")); 
		System.out.println( u2.apply("chirp"));

		BinaryOperator <String> b1 = String:: concat; 
		BinaryOperator <String> b2 = (string, toAdd) -> string.concat(toAdd); 
		System.out.println( b1.apply("baby ", "chick")); // baby chick 
		System.out.println( b2.apply("baby ", "chick")); // baby chick

	}
	
	public static Optional<Double> average(int...scores){
		if (scores.length == 0) 
			return Optional.empty(); 
		
		int sum = 0; 
		for (int score: scores) sum += score;
			return Optional.of(( double) sum / scores.length);


	}
	
	public void testOptional() {
		Optional < Double > opt = average(90,100); 
		
		System.out.println( opt.orElse( Double.NaN)); 
		System.out.println( opt.orElseGet(() -> Math.random())); 
		System.out.println( opt.orElseThrow(() -> new IllegalStateException()));
		
	}

}




