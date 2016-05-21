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
require `prime-table.core`
and enjoy

### Sample output
` 	2	3	5	7	11	13	17	19	23	29
2	4	6	10	14	22	26	34	38	46	58
3	6	9	15	21	33	39	51	57	69	87
5	10	15	25	35	55	65	85	95	115	145
7	14	21	35	49	77	91	119	133	161	203
11	22	33	55	77	121	143	187	209	253	319
13	26	39	65	91	143	169	221	247	299	377
17	34	51	85	119	187	221	289	323	391	493
19	38	57	95	133	209	247	323	361	437	551
23	46	69	115	161	253	299	391	437	529	667
29	58	87	145	203	319	377	493	551	667	841`

## License

Copyright © 2016 Andrés Gómez Urquiza.

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
