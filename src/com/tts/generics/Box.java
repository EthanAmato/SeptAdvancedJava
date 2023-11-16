package com.tts.generics;

// Let's create a Generic class called Box. A box is able to hold any type of data inside of it and

// retrieve/change the contents of the box. We can use generics to enforce that a box can contain
// ANY TYPE OF DATA we want -> for example, if we made a Product class, we could create an object of
// a box holding a Product, but could also safely have it hold a String in another instance

// To make a class accept a generic type, we can provide the same angle brackets next to the class name
// with the 'placeholder' type we want to use throughout the class (referring to types like Product, string, etc.)
public class Box<E> {

	// Store an instance variable of Type E - meaning this will be whatever type
	// is specified in the Angle brackets of the instance of our Box:
	private E content;

	public Box(E content) {
		// Set the content instance variable to whatever
		// the user puts in the constructor params. It will
		// be whatever type is inside of the angle brackets...
		this.content = content;
	}

	public E getContent() {
		return this.content;
	}

	public void setContent(E newContent) {
		this.content = newContent;
	}

}
