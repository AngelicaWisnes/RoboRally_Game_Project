
**PART 1**

Group info:

Members of the group:
 Stefan, Roger, Katarina, Magne, Ingrid
* Name:
  * team2bestteam
* Team lead:
  * Stefan
* Customer conatact:
  * Ingrid
  
Summary: all of us has basic programming knowledge from INF100, INF101 and INF102. Exept from Stefan who has worked with projects before so he has more experience than the rest of us.


**Technical tools:**
* IDE
  * IntelliJ
* Git
  * https://github.com/StefanEllenberger/team2-inf112/
* Project board
  * https://github.com/StefanEllenberger/team2-inf112/projects/1
* Communication 
  * https://inf112-v19.slack.com/messages/GFTEPDZPA/


**PART 2**

**LIST OF REQUIREMENTS:**

We created a list of requirements that would act as a road map for our development, which we will review weekly.

presentation  
-getting something onto the screen  
-finding/creating sprites  
-constructing a board  
-understanding how the camera works with the board
-constructing different tiles that the board will consist of   
-constructing a robot figure to move around the static board, to understand position (x,y)  

cards   
-construct cards that influence the game  
-create stacks for new, old and player cards  
-create logic for all cards, ensuring functionality for all cards was doable

movement  
-creating a class for the robots with movement methods  
-creating a system to run through the different parts of the turns  
-creating a system that takes cards as input and moves robots  
-creating a player with cards and a robot

tiles  
-creating logic for all tiles  
-deciding on a system for tiles to manipulate players  
--is the logic in the player, reacting to the tile type?  
--is the tile affecting change on the player?  
-if former, system for player to assess tile underneath and store needed information  
-if latter, implement system that allows tile/board to affect player

win state  
-create ordered flag tiles   
-create memory in player of which flags have been reached  
-end game if all flags have been reached in order


We decided to not go into too much more detail re: specs, as we would probably change enough things from now until we would start implementing these changes. 
We intend to be agile, and in each meeting will see what has made sense so far of our planning, and what needs to be rethought.  
We consider a game where a player can pull cards, move from tile to tile and reach an end state via flags to be a good MVP, and that is our first major goal to reach for. 



**PART 3**

* Meetings, and frequency of meetings: 
  * 1-2 times a week
* Communication between: 
  * Facebook, Slack
* Labour distribution 
  * Distribute the work in the project board in Github
* Follow-up work:
  * Review in github project board
* Sharing and storing common documents, charts and the codebase
  * Plan what to do in the meetings, write it down in google docs and github project board

**SUMMARY**

Repo:
* What went well:
  * The teamwork and planning
  * Getting the project going and having a program that work as anticipated
* What didn’t work as expected:
  * We had some problem with getting the program to run on all of our computers because of a problem with the mvn-app.iml file. We solved the problem by adding the file to .gitignore. This was our first time using Maven, so there was a slight learning curve there.   
* New activities or tools for next exercise:
  * Create the card-class
  * Create the robot-class

When starting, we drew up some thoughts on what we thought the mechanisms would become, and what order they should be created in, to create a Minimum Viable Product. Initially we set a goal to finish the presentation portion and begin the card portion.


**Week 1:**
There was a bit more work that first anticipated not related to code. Setting up environments, getting familiar with the library, understanding how parts were connected, getting comfortable with Git and working as a team on the same pieces of code. Configurations meant having to reset or move the project, and each member of the team deleted and re-cloned the project at least once. Some code was written on one computer and commit by another, but towards the end of the week (08/02) we felt comfortable using the IDE and Git to pull and push code. We also wrote our first few tests, which were helpful in debugging. We have not yet looked into using pull requests, but hope to in the next week. 

Setting up the initial code for displaying objects on screen went well, we followed a tutorial and tried to learn what each part did. From there, we started working on creating the interfaces and classes for the functionality we needed. We used a Github  Projects board to set up tasks, and worked as groups, pairs and individuals to finish the individual parts. The best work came when we all sat together and could draw plans, divide tasks and ask for help in person. We plan to continue pair programming and working in groups throughout the project. 

We didn't quite reach our sprint target, as the initial setup and base board system was more complex than first anticipated. We did have an inkling going into the week that this would be the case, but we do plan to be more cautious when planning future sprints. 

**Future weeks:**
Our next task is the card and robot systems. Because the functionality of the cards is tied to the robots, these two systems make sense to create at the same time. The main challenge for the card system will be to influence the robot, while the main challenge for the robot will be to read the board and know its position. These two systems will be the only post-its on the Project board for the week, as we think they'll both take a fair bit of planning and work. 

