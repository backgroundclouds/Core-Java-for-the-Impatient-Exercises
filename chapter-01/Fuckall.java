//Exercise 16
//16. A "Quine" is a program that, without reading any input or file, prints its own source code. Write such a program in Java, using a text block.
public class Fuckall { public static void main(String[] a){ String s = """
public class Fuckall { public static void main(String[] a){ String s = %1$c%1$c%1$c
%2$s%1$c%1$c%1$c; System.out.printf(s, 34, s); } static String fuckall = %1$c%1$c%1$c
(__)         
(..)_____    
(oo)    /|
  | |--/ | * 
  w w w  w   
%1$c%1$c%1$c; }"""; System.out.printf(s, 34, s); } static String fuckall = """
(__)         
(..)_____    
(oo)    /|
  | |--/ | * 
  w w w  w   
"""; }