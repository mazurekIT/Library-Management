###BOOK LIBRARY MANAGEMENT PLATFORM

This is project that I did at the request of Cognifide.

### Instructions

All instructions are  contained in a 'instructions.md' file.

### About application

Application is a backend REST API which reads information from JSON file. Application after running works on http://localhost:8080/.
With given endpoints it's possible to get information about:
- book with given 'isbn' number (/api/book/{ISBN)  
- list of books which have 'category' (/api/category/{categoryName}/books)
- list of books which contains one of give words of 'phrase' (/api/search?q={phrase})
- list of authors rating in descending order of the average rating (/api/rating)

### Author
Mateusz Mazurek - https://github.com/mazurekIT/