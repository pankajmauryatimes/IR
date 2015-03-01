Tyler Kemme
CS ID: tpkemme

This information retrieval application contains a PageRankInvertedIndex, an inverted index created using the PageRank algorithm.

We also implemented pseudo relevant feedback into the current working project.  Pseudo relevant feedback is where after you've found retrievals for a certain query, you take the first n number of retrievals and include them again in a new search.  The idea is that you are taking the first n most relevant documents and including them into your search to get more relevant results.  Obviously, the number of documents you choose to re-include into the query changes the results you get.  For instance, if you do pseudo relevant feedback with only one document, the new results are most likely going to be very similar to that specific document instead of your original query.  Also, if you do pseudo relevant feedback on many documents, you results may be just as relevant as they were originally.  Generally, pseudo relevant feedback works the best when there are not a lot of documents being put into the query but each document is not exactly the same as the others.

My algorithm for pseudo relevant feedback was relatively simple to implement.  After the vsr presents the first round of retrievals, it checks to see if the pseudofeedback flag is set.  If it is, it iterates through the retrievals and adds the first n documents to the list of good documents.  After it has done this, it will obtain a new set of retrievals using the modified query and present the results immediately after the original results.


+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

This code supplies "miniature" pedagogical Java implementations of
information retrieval, spidering, and other IR and text-processing
software.  It is being released for educational and research purposes only under
the GNU General Public License (see http://www.gnu.org/copyleft/gpl.html).

It was developed for an introductory course on "Intelligent Information
Retrieval and Web Search".  See:

http://www.cs.utexas.edu/users/mooney/ir-course/ 

for more information and introductory documentation (especially see the Project
assignment descriptions).

Copyleft: Raymond J. Mooney, 2001
  
