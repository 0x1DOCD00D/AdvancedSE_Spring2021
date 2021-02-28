# Course Project
### Description: you will create and evaluate simulations of a large cloud provider with many datacenters that use different network topologies and load balancing algorithms.
### Grade: 25%.
#### You can obtain this Git repo using the command ```git clone git@bitbucket.org:cs441_spring2019/cloudprovidersimulations.git```. You cannot push your code into this repo, otherwise, your grade for this homework will be ZERO!

## Preliminaries
If you have not already done so as part of your previous course homeworks, you must create your account at [BitBucket](https://bitbucket.org/), a Git repo management system. It is imperative that you use your UIC email account that has the extension @uic.edu. Once you create an account with your UIC address, BibBucket will assign you an academic status that allows you to create private repos. Bitbucket users with free accounts cannot create private repos, which are essential for submitting your homeworks and the course project. Your instructor created a team for this class named [cs441_Spring2019](https://bitbucket.org/cs441_spring2019/). Please contact your TA [Shen Wang](swang224@uic.edu) from your **UIC.EDU** account and they will add you to the team repo as developers, since they already have the admin privileges. Please use your emails from the class registration roster to add you to the team and you will receive an invitation from BitBucket to join the team. Since it is still a large class, please use your UIC email address for communications or Piazza and avoid emails from other accounts like funnybunny1992@gmail.com. If you don't receive a response within 12 hours, please contact us via Piazza, it may be a case that your direct emails went to the spam folder.

In case you have not done so, you will install [IntelliJ](https://www.jetbrains.com/student/) with your academic license, the JDK, the Scala runtime and the IntelliJ Scala plugin, the [Simple Build Toolkit (SBT)](https://www.scala-sbt.org/1.x/docs/index.html) or some other building tool like Maven or Gradle and make sure that you can create, compile, and run Java programs. Please make sure that you can run [Java monitoring tools](https://docs.oracle.com/javase/8/docs/technotes/guides/troubleshoot/tooldescr025.html) or you can choose a newer JDK and tools if you want to use a more recent one.

Please set up your account with [Dockerhub](https://hub.docker.com/) so that you can push your container with the project and your graders can receive it by pulling it from the dockerhub.

## Overview
In this course project, you will loop back to your first homework but at a higher level. Your job is to experiment with creading cloud computing datacenters and running jobs on them using a newer version of the cloud simulator compared to what you used in your first homework. Recall that it is a software package that models the cloud environments and operates cloud models. We will use [CloudSim Plus](http://cloudsimplus.org), a publically available framework for modeling and simulating cloud computing infrastructure and services. You will write your simulations in Scala and specify the dependency on CloudSim Plus in your build.sbt.

CloudSim Plus website contains a wealth of information and for those who haven't done the first homework, here is [your starting point](http://www.cloudbus.org/cloudsim/). You will find an [online course on CloudSim](https://www.superwits.com/library/cloudsim-simulation-framework). and your starting point is to download and configure CloudSim Plus and to run examples that are provided in the Github repo and those that you will find on the main CloudSim Plus website. Those of you who used the older version of CloudSim can [compare it with CloudSim Plus](http://cloudsimplus.org/docs/CloudSim-and-CloudSimPlus-Comparison.html). Those who want to read more about modeling and simulation can find ample resources on the Internet - I recommend the following paper by Any Maria on Introduction to Modeling and Simulation http://acqnotes.com/Attachments/White%20Paper%20Introduction%20to%20Modeling%20and%20Simulation%20by%20Anu%20Maria.pdf. 

## Functionality
Once you installed and configured CloudSim Plus, your job is create simulations where you will evaluate a large cloud provider with many datacenters with different characteristics (e.g., operating systems, costs, devices) and policies. You will form a stream of jobs, dynamically, and feed them into your simulation. You will design your own datacenter with your own network switches and network links. You can organize cloudlets into tasks to accomplish the same job (e.g., a map reduce job where some cloudlets represent mappers and the other cloudlets represent reducers). There are different policies that datacenters can use for allocating Virtual Machines (VMs) to hosts, scheduling them for executions on those hosts, determining how network bandwidth is provisioned, and for scheduling cloudlets to execute on different VMs. Randomly assigning these cloudlets to different datacenters may result in situation where the execution is inefficient and takes a long time. Using a cleverer algorithm like Oktopus may lead to a more efficient cloud provider services.

Consider a snippet of the code below from one of the examples of using CloudSim Plus. In it, a network cloud datacenter is created with network hardware that is used to organize hosts in a connected network. VMs can exchange packets/messages using a chosen network topology. Depending on your simulation construct, you may view different levels of performances.
```java
protected final NetworkDatacenter createDatacenter() {
  final int numberOfHosts = EdgeSwitch.PORTS * AggregateSwitch.PORTS * RootSwitch.PORTS;
  List<Host> hostList = new ArrayList<>(numberOfHosts);
  for (int i = 0; i < numberOfHosts; i++) {
      List<Pe> peList = createPEs(HOST_PES, HOST_MIPS);
      Host host = new NetworkHost(HOST_RAM, HOST_BW, HOST_STORAGE, peList)
                    .setRamProvisioner(new ResourceProvisionerSimple())
                    .setBwProvisioner(new ResourceProvisionerSimple())
                    .setVmScheduler(new VmSchedulerTimeShared());
      hostList.add(host);
  }

  NetworkDatacenter dc =
          new NetworkDatacenter(
                  simulation, hostList, new VmAllocationPolicySimple());
  dc.setSchedulingInterval(SCHEDULING_INTERVAL);
  dc.getCharacteristics()
        .setCostPerSecond(COST)
        .setCostPerMem(COST_PER_MEM)
        .setCostPerStorage(COST_PER_STORAGE)
        .setCostPerBw(COST_PER_BW);
  createNetwork(dc);
  return dc;
}
```

As before, this course project script is written using a retroscripting technique, in which the project outlines are generally and loosely drawn, and the individual students improvise to create the implementation that fits their refined objectives. In doing so, students are expected to stay within the basic requirements of the course project and they are free to experiments. Asking questions is important, so please ask away at Piazza!

Your course project can be divided roughly into five steps. First, you learn how CloudSim Plus is organized and what your building blocks are. I suggest that you load the source code of CloudSim Plus into IntelliJ and explore its classes, interfaces, and dependencies. Second, you design your own cloud provider organization down to rack/cluster organization as we will study in the lecture on cloud infrastructure. You will add various policies and load balancing algorithms as we will study in the corresponding lectures. Next, you will create an implementation of the simulation(s) of your cloud provider using CloudSim Plus. Fourth, you will run multiple simulations with different parameters, statistically analyze the results and report them in your documentation with explanations why some cloud architectures are more efficient than the others in your simulations. Finally, you will create a docker configuration and build a dockerized container using your cloud simulators, and you will upload it to the docker hub using your account.

## Baseline Submission
Your baseline project submission should include the architecture description of your framework with its prototype implementation, a conceptual explanation in the document or in the comments in the source code of the architecture and design choices that you made, and the documentation that describe the build, deployment and the runtime simulation, to be considered for grading. Your project submission should include all your source code for the prototype as well as non-code artifacts (e.g., resource files if applicable), your project should be buildable using SBT or Gradle. Simply copying some programs from open-source projects and modifying them a bit will result in rejecting your submission. Finally, you will provide a link to your docker image on the hub, so that we can easily download and run your simulations.

## Piazza collaboration
You can post questions and replies, statements, comments, discussion, etc. on Piazza. For this homework, feel free to share your ideas, mistakes, code fragments, commands from scripts, and some of your technical solutions with the rest of the class, and you can ask and advise others using Piazza on where resources and sample programs can be found on the internet, how to resolve dependencies and configuration issues. When posting question and answers on Piazza, please select the appropriate folder, i.e., hw2 to ensure that all discussion threads can be easily located. Active participants and problem solvers will receive bonuses from the big brother :-) who is watching your exchanges on Piazza (i.e., your class instructor). 

## Git logistics
**This is a group project,** with at least one and at most five members allowed in a group. Each student can participate in at most one group; enrolling in more than one group will result in the grade zero. Each group will select a group leader who will create a github repository and will invite the other group classmates with the write access to that fork repo. Each submission will include the names of all groupmates in the README.md and all groupmates will receive the same grade for this course project submission. Group leaders with successful submissions and good quality work will receive an additional 2% bonus for their management skills - it applied only to groups with more than two members.

Please follow this naming convention while submitting your work : "Firstname_Lastname_project" without quotes, where the group leader will specify her/his first and last names **exactly as the group leader is registered with the University system**, so that we can easily recognize your submission. I repeat, make sure that you will give the course instructor the read access to *your private project repository*.

## Discussions and submission
You can post questions and replies, statements, comments, discussion, etc. on Piazza. Remember that you cannot share your code and your solutions privately, but you can ask and advise others using Piazza and StackOverflow or some other developer networks where resources and sample programs can be found on the Internet, how to resolve dependencies and configuration issues. Yet, your implementation should be your own and you cannot share it. Alternatively, you cannot copy and paste someone else's implementation and put your name on it. Your submissions will be checked for plagiarism. **Copying code from your classmates or from some sites on the Internet will result in severe academic penalties up to the termination of your enrollment in the University**. When posting question and answers on Piazza, please select the appropriate folder, i.e., **project** to ensure that all discussion threads can be easily located.


## Submission deadline and logistics
Wednesday, May 5, 2021 at 9PM CST via the bitbucket repository. Your submission will include the code for the framework prototype, your documentation with instructions and detailed explanations on how to assemble and deploy your framework both in IntelliJ and CLI SBT, and a document that explains how you built and deployed your framework and what your experiences are. Again, do not forget, please make sure that you will give your instructor the read access to your private forked repository. Your name should be shown in your README.md file and other documents. Your code should compile and run from the command line using the commands like ```sbt clean compile test``` and from the docker image. Naturally, you project should be IntelliJ friendly, i.e., your graders should be able to import your code into IntelliJ and run from there. Use .gitignore to exlude files that should not be pushed into the repo.

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
