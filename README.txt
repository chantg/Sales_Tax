Coding Problem: Sales Tax
My solution parses the input into its parts and checks if the object is in TaxExempt. I compiled the text file TaxExempt from this github repository https://github.com/CurtisGrayeBabin/List-of-all-Foods, https://www.drugs.com/drug_information.html top 40 searched drugs, and from the Bureau of Industry and Security Comprehensive List of Basic Medical Supplies https://www.bis.doc.gov/index.php/documents/product-guidance. If given more time I would have had a crawler compile book title from Project Gutenburg. For book it just looks for the word book.

I store these words in a nested ArrayList where the index of the ArrayList correlates to the alphabet from 0 - 25. It's more memory intensive but helps with recall time when searching for words.

Installing:
This program requires a java development kit the most recent download is found here https://www.oracle.com/technetwork/java/javase/downloads/index.html. Add the Path Directory to your PATH Environment Variable. 

In tester there contains tester.java which uses JUnit for unit testing. I wrote it with Eclipse but there's no reason it wont work in another IDE using JUnit. To compile tester.java outside of an IDE four jar files are necessary; 
junit-jupiter-api-5.6.0-M1.jar 	https://search.maven.org/search?q=g:org.junit.jupiter%20AND%20v:5.5.2
junit-4.13-rc-2.jar    https://repo1.maven.org/maven2/junit/junit/4.13-rc-2/
apiguardian-api-1.0.0.jar   https://mvnrepository.com/artifact/org.apiguardian/apiguardian-api/1.0.0
opentest4j-1.0.0-M1.jar  https://jar-download.com/artifacts/org.junit.jupiter/junit-jupiter-api/5.0.0/source-code

All packages are also attatched in the tester folder.

Running:
Script to compile all relevent files.

javac Tech_Chlg.java Purchase.java Sales.java ExemptItems.java tester.java

Running Tech_Chlg with no arguments runs the program on the three given text files. Any text file for input must be kept in the same directory as Sales.java.

Running Tech_Chlg with a text file name as an argument uses that file as input.