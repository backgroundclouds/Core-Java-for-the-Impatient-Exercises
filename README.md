# Core Java for the Impatient (3rd Edition) - Exercises

This repository contains my personal solutions and selected exercises from *Core Java for the Impatient (3rd Edition)* by Cay S. Horstmann. 

Rather than a complete chapter-by-chapter answer key, this is a curated collection of periodic progress and practice as I work through the text and solidify my understanding of Java fundamentals.

## Repository Structure

Exercises are organized by chapter. Each file corresponds to a specific exercise from the textbook.

* `/chapter-01`: Fundamental Programming Structures (Completed)
* *(More chapters will be added periodically)*

## Running the Code

All exercises are written as standalone Java classes. You can compile and run them directly from your command line. 

To run a specific exercise, navigate to its directory, compile the `.java` file, and execute the compiled class:

```bash
cd chapter-01
javac Exercise1.java
java Exercise1 <optional arguments>
```

*Note: If an exercise relies on standard input (like a `Scanner`), simply follow the on-screen prompts or pass a text file in via standard redirection (e.g., `java Exercise20 < testInput.txt`).*

## About the Quine (Exercise 16)
Exercise 16 challenges the reader to write a "Quine"—a program that prints its own source code without reading any external files. You can find my implementation of this utilizing Java Text Blocks in `Exercise16.java`.