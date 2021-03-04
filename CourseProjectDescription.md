# Course Project
### Description: you will design and implement a prototype of your proposed framework.
### Grade: 50%.

## Preliminaries
In case you have not done so, you will install [IntelliJ](https://www.jetbrains.com/student/) with your academic license, the JDK, the Scala runtime and the IntelliJ Scala plugin, the [Simple Build Toolkit (SBT)](https://www.scala-sbt.org/1.x/docs/index.html) or some other building tool like Maven or Gradle and make sure that you can create, compile, and run Java programs. Please make sure that you can run [Java monitoring tools](https://docs.oracle.com/javase/8/docs/technotes/guides/troubleshoot/tooldescr025.html) or you can choose a newer JDK and tools if you want to use a more recent one.

## Baseline Submission
Your baseline project submission should include the architecture description of your framework with its prototype implementation, a conceptual explanation in the document or in the comments in the source code of the architecture and design choices that you made, and the documentation that describe the build, deployment and the runtime simulation, to be considered for grading. Your project submission should include all your source code for the prototype as well as non-code artifacts (e.g., resource files if applicable), your project should be buildable using SBT or Gradle. Simply copying some programs from open-source projects and modifying them a bit will result in rejecting your submission. 

## Piazza collaboration
You can post questions and replies, statements, comments, discussion, etc. on Piazza. For this homework, feel free to share your ideas, mistakes, code fragments, commands from scripts, and some of your technical solutions with the rest of the class, and you can ask and advise others using Piazza on where resources and sample programs can be found on the internet, how to resolve dependencies and configuration issues. When posting question and answers on Piazza, please select the appropriate folder, i.e., **project** to ensure that all discussion threads can be easily located. Active participants and problem solvers will receive bonuses from the big brother :-) who is watching your exchanges on Piazza (i.e., your class instructor). 

## Git logistics
**This is a group project,** with at least one and at most five members allowed in a group. Each student can participate in at most one group; enrolling in more than one group will result in the grade zero. Each group will select a group leader who will create a github repository and will invite the other group classmates with the write access to that repo. Each submission will include the names of all groupmates in the README.md and all groupmates will receive the same grade for this course project submission. Group leaders with successful submissions and good quality work will receive an additional 2% bonus for their management skills - it applied only to groups with more than two members.

Please follow this naming convention while submitting your work : "Firstname_Lastname_project" without quotes, where the group leader will specify her/his first and last names **exactly as the group leader is registered with the University system**, so that we can easily recognize your submission. I repeat, make sure that you will give the course instructor the read access to *your private project repository*.

## Discussions and submission
You can post questions and replies, statements, comments, discussion, etc. on Piazza. Remember that you cannot share your code and your solutions privately, but you can ask and advise others using Piazza and StackOverflow or some other developer networks where resources and sample programs can be found on the Internet, how to resolve dependencies and configuration issues. Yet, your implementation should be your own. Alternatively, you cannot copy and paste someone else's implementation and put your name on it. Your submissions will be checked for plagiarism. **Copying code from your classmates or from some sites on the Internet and passing it as yours will result in severe academic penalties up to the termination of your enrollment in the University**. However it is perfectly fine to use other frameworks and libraries as dependencies in your course project implementation. When posting question and answers on Piazza, please select the appropriate folder, i.e., **project** to ensure that all discussion threads can be easily located.


## Submission deadline and logistics
Wednesday, May 5, 2021 at 9PM CST via the bitbucket repository. Your submission will include the code for the framework prototype, your documentation with instructions and detailed explanations on how to assemble and deploy your framework both in IntelliJ and CLI SBT, and a document that explains how you built and deployed your framework and what your experiences are. Again, do not forget, please make sure that you will give your instructor the read access to your private  repository. Your name should be shown in your README.md file and other documents. Your code should compile and run from the command line using the commands like ```sbt clean compile test``` and from the docker image. Naturally, you project should be IntelliJ friendly, i.e., your graders should be able to import your code into IntelliJ and run from there. Use .gitignore to exlude files that should not be pushed into the repo.

## Evaluation criteria
- the maximum grade for this project is 50% with the bonus up to 2% for being the group leader for a group with three or four members. Points are subtracted from this maximum grade: for example, saying that 2% is lost if some requirement is not completed means that the resulting grade will be 50%-2% => 48%; if the core functionality does not work, no bonus points will be given;
- the code does not work in that it does not produce a correct output or crashes: up to 40% lost;
- not having tests that test the functionality of your framework: up to 50% lost;
- missing essential comments and explanations from the source code that you wrote: up to 40% lost;
- no instructions in README.md on how to download and install and run your framework: up to 50% lost;
- shallow analysis of the framework requirements or simply no analysis of the framework design and its rationale: up to 25% lost;
- your code does not have sufficient comments or your accompanying documents do not contain a description of how you designed and implemented the framework: up to 20% lost;
- the documentation exists but it is insufficient to understand how you planned your framework and how you chose its various dependencies: up to 20% lost;
- the minimum grade for this course project cannot be less than zero.

That's it, folks!
