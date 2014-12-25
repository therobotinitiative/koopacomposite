koopacomposite
==============

Koopa Composite Java library for composite pattern
-----
Type safe composite pattern library that supports collection and
map based compositions. The library defines interfaces that can be
used to create the composition components.

Implementation classes are also provided for these interfaces. The
implementation classes are NOT thread safe!
-----
Works in progress. This library is NOT intended for production use yet.
The API might have dramatic changes before the first release version.

Coding Style
-----
- Using the Allman Style to improve the readability of the code.
- CamelCase naming
- Method names takes into account the context (class), example: add instead of addElementIntoSomething
This should be enough. Pretty much follows the normal Java style except for the Allman style which I
personally find much more clearer to read because it does not pack the code
too tight. Code is written once and read many times, this is one ideology that
I try to follow. This is something that should be taken into account only if
you plan to make pull requests or become a contributor for this project. Yeah like
that would ever happen.

When there are enough JUnit tests to test the functionality then this library
can achieve release status. Before that it will stay as snapshot. This is basically
the release plan. This library is so small that there is no need to overshoot this
part of the development.
