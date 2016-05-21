# prime-table

Have you ever needed to do some hardcore prime numbers work?

To teach your kids the multiplication tables of the elite?

Then seek no more for this is what you have been looking for:

### The Amazing Prime Table Multiplication Matrix Thing

## Usage

### Dependencies

[lein](http://leiningen.org)

### Displaying the 10 x 10 prime multiplication table from the terminal

`lein run`

### Displaying a n x n table rom the repl

`(primes-multiplication-table n)`

### Generating a collection of the first n primes

`(primes n)`

### Using prime-table as a library

Just add `[prime-table "0.1.0-SNAPSHOT"]` as a dependency,
require `prime-table.core`, and enjoy

## Considerations

Populating the matrix is speedy (3.8s for a 1000 x 1000 matrix in a quick test)
so the first limitation for scalability is in the printing.
`prime-table` uses tabs for printing the table, so if you print a table with
447 primes or more, you should use other method for printing than `print-matrix`
because the tabs will jump.
In practice, tables of 25 or less primes will probably not be distorted.

## License

Copyright © 2016 Andrés Gómez Urquiza.

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
