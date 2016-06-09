# "States and Capitals" Quiz
![Screenshot of "States and Capitals Quiz"](http://www.globalnerdy.com/wordpress/wp-content/uploads/2016/06/states-and-capitals-quiz.jpg)

* The second time I helped a friend with his Java homework and ended up doing the whole thing. ([Here's the repo for the first time I helped him](https://github.com/AccordionGuy/SortedFileWords))
* This application presents the user with the names of U.S. states and asks him/hero to name their capitals. If the user answers correctly, the user should be presented with a pop-up window that displays the state's flag. I went a little bit beyond the spec; see the notes below. Once again, my friend got full marks!
* Written in Java 8 using NetBeans and JavaFX. This is the second Java project of *any* size that I've worked on since about 2000.

## Introduction
![Can of "Brawndo" with the caption "It's got iterators!"](http://www.globalnerdy.com/wordpress/wp-content/uploads/2016/06/its-got-iterators.jpg)

Fresh off the success with [the last assignment I did for him](https://github.com/AccordionGuy/SortedFileWords), my friend with the Java
community college course asked for my help with another assignment. This time,
it was a "states and capitals" quiz, where the user gets presented with the name
of a state and is asked to type in the name of its capital. If the user answers
correctly, s/he is presented with a pop-up window that displays the state flag.

I didn't see any spec for what the user should be presented with for a wrong answer,
so I decided that the application should show a pop-up window that displayed a
"sad face" graphic.

Finally, I made use of an iterator to "step through" the set of states and
capitals which were stored in a hashmap. I worried that using it might have been
beyond the scope of the assignment, but it greatly simplified the code, and my
friend got full marks.

This is the result of an evening's work, which included a fair bit of Googling
("Java has iterators, right?").

## License
This code is released under the MIT license. Simply put, you're free to use this in your own projects, both personal and commercial, as long as
you include the MIT license text in your code. It would be nice if you mentioned my name somewhere in your documentation or credits if
you use this code, but it's not legally necessary. It would be nice, though.
