Scribble
========

Scribble is desgined to be a family of languages designed such that you can scribble them on an iPhone, iPad or iPod touch device without having to switch into the modal character insertion panel - i.e. you can write more of the language using just the characters on the main keyboard of the iOS device. Scribble languages need to meet these criteria:

1. Easy to write on an iOS touchscreen device without a physical keyboard.
2. Provide a REPL.
3. Compile down to an existing language.

The use case for Scribble languages is simple: to use as a calculator, to simply try out an algorithm and for other rapid prototyping needs on a handheld device.

This particular implementation of Scribble runs on top of Ruby on the Java Virtual Machine. It uses the JRuby JSR 223 implementation to wrap around a REPL.

It is currently very primitive but offers the following syntactical changes from Ruby:

* gt, lt, gte, lte, eq - these are substituted for operators
* add and times in place of + and *
* variable allocation using !
* one-place lambda creation using ,,

What does the code look like then?

    [1,2,3,4,5].map ,, x plus x

is equivalent to

    [1,2,3,4,5].map do |x| x + x end

But requires a lot fewer keystrokes on iOS devices. Assigning variables is done like this:

    a ! 5

And comparison is done using the plain text operators:

    5 gt 1

This will be documented and developed further, but in the spirit of [Why Day](http://whyday.org/) I wanted to put it out there quickly.

Implementation status
---------------------

* Syntax designed - check!
* Simple regex parser written - check!
* Simple REPL implemented - check!
* Compiler implemented
* Extract as much functionality into separate Ruby module