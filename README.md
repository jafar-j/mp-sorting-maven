# mp-sorting-maven

An exploration of sorting in Java.

Authors

* Jafar Jarrar
* Samuel A. Rebelsky (starter code)

Acknowledgements

* claude.ai for brainstorming and analyzing ideas for part 3 of the project.

This code may be found at <https://github.com/USERNAME/mp-sorting-maven>. The original code may be found at <https://github.com/Grinnell-CSC207/mp-sorting-maven>.

Description of custom sorting algorithm
It is a combination of bubble sort and insertion sort, where bubble sort is performed n / 8 times on an array of size n, and insertion sort is performed until the array has been fully sorted. This combination reduces runtime even though it is not a significant reduction because the bubble sort steps reduce the number of times that insertion sort will be performed. I thought that bubble sort and insertion sort compliment one another, since bubble sort would push smaller elements to the left of the array, and insertion sort runs longer if larger elements are towards the left of the array. So having bubble sort push smaller elements to the left would reduce the number of swaps that insertion sort would perform to get elements in their right positions.

Notes on using Copilot (or other AI)
I used claude.ai to generate ideas for implementing this part of the project and analyzing the time complexities of different ideas that I had in order to find the most efficient implementation (although it isn't really that efficient overall).

It was phenominal brainstorming ideas with the AI. I gave the AI ideas and asked it to compare the runtimes between them, and it gave me an analysis as well as a visualizer to see how my algorithm would work (not in terms of code) and how much the runtime would be reduced. I decided on performing the bubble sort algorithm n / 8 times due to the AI's help in the comparison of the n / 2, n / 4, and n / 8 iterations. According to the AI, running the bubble sort algorithm n / 8 times would provide the best balance between bubble sort and insertion sort.

_This section is optional_
