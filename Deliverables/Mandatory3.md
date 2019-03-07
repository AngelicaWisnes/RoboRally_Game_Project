**PART 1**

* The roles in the team have worked very well so far - those roles being a team leader and a customer contact, as well as all five members being developers. The team leader discusses with the team what our next tasks should be, suggests structures and packages, and the team as a whole decides on what tasks each person should finish, who should work together, etc. The role of customer contact takes responsibility for the deliverables, so she makes sure everyone knows the specifications, contributes to the written task, and finally combines the deliverable into a finished MD-file. There are other roles that we could use depending on the method being used (Kanban/Scrum), but we feel comfortable in the roles we have chosen and do not feel any more roles would be beneficial. We all have ownership of the product, which is important both in motivation and quality. 

* Our method of working together; where we meet for 4-6 hours once a week and help each other reach our goals, has proven itself to be incredibly effective. We can discuss structure, quickly ask questions and get clarifications, work together on difficult tasks, and make sure we work as efficiently as possible.
* We set short-term goals and create manageable tasks, which allow us to plan, develop and test a new functionality in a short time-span. This allows us to be flexible when it comes to new functionality.
* We write tests as we develop, making sure invariants are kept and functionality works as intended. For some elements (visual, etc) we do manual testing - an example being that we included functionality for moving the robot free using the keyboard, so that we didn’t have to rely on the cards to test if the robot is moved by the board as we intended.

* We are very happy with our group! We have managed to find times where everyone can meet and work together, the dynamics work well and we have an open and including atmosphere when working together. We ask each other for help, and help each other all the time.

* We still use Slack, and we use it in the right way (only group-related questions),  and everyone gets notifications on their phone.
    * We talk to each other in the meetings in a positive and constructive way 


* [Retrospective](https://github.com/inf112-v19/The_Terminators/blob/master/Deliverables/Retrospective.pdf) 

* [Meetings](https://github.com/inf112-v19/The_Terminators/blob/master/Deliverables/Meetings.md)

* Codebase
    * We usually program together in pairs, so not everyone get to commit as often, but everyone contributes to the code. Not all work can be connected directly to a commit. Examples on this is one group member that has made all the different maps we will use later on. 
    * Note on commits: When using branching, every time one merges the branch onto master, all commits are added, as well as an extra commit that handles the merging of the branches. This is why there are several similar “Merge branch master of…”, but these are created by Git. 
    * GitHub’s Insights/Contributers-statistics are not accurate in regards to who has commited and when. Note that sometimes Magne’s commits are credited to “=” instead of his name. 
    
    
* Regarding LibGDX, the group leader has done the most research and taught the rest of the group. A couple of the group members have done some research as well. We share this information in the weekly meetings, so that we are all up to speed on the project status and the technologies in use. Further we have had some great reviews regarding the basic principle and functions that LibGDX offers compared to other libraries (examples: camera and view). In addition the group members have learned a lot from each other while pair-programming. If someone’s not sure about something, we explain and show what is going on before moving on. 





**PART 2**

* Based on the requirements from the customer we have made a card-generator that generates all types of movement-cards with different priority and then shuffles them. We can make it hand out 9 cards and then choose the 5 we want. This is not implemented how we would like it to be in the end, but it works now. We designed the cards in Photoshop.
	
* We still use the arrow-keys to move the robot, but some of the board-mechanics is available for use now (Rotators and Conveyors). We have placed damage and health on the “playerboard” but this do not fully cooperate with the player yet, but tests can confirm this works.

* We have worked in a way where the plan is to get the basics working at first, because the end-product is so precise, our plan is to get the mechanics to work separately, and then make them work together. This way of working may be more time-consuming in the start, but as things start to fall in place and getting connected, our thought is that we will save some time later on as most of the mechanism is already finished..

* We have always worked towards the requirements from the customer, but because we have a goal that is in our opinion very precise, we work  with a philosophy where every mechanic should be in place before moving on to the next one. This is because we sooner or later will meet problems if we do not solve this in a way that fulfills our goals. 
	
* Every requirement we have started on is fulfilled. As how we interpret the requirements, our program will more or less be fully functional when the requirements are done.

* Our priority from last time was at least to generate cards to the player, and make the robot move accordingly from the specifics from the program-cards. We have done a lot here, but we have rapidly met problems that have been overseen. We have also seen a lot of potential for improvements, and made these changes regularly. 

* Since last time we have done a lot. Compared to last time, our game now implements an own-designed map from Tiled. We have changed the camera to show the player-cards as well as the board. 1 player now gets 5 cards.



**PART 3**

* We have done a variety between test driven programming, and “try-fail”, and then making tests. We do not commit/push when the code does not compile.

**Project setup documentation**
* We have been very good at placing the classes in different “self explaining” packages. This makes the repositories very neat, and it is easy to know where to find the classes. We have also made different interfaces like IRobot and ITile. Then we have an AbstractTile followed by the many different type of tiles. The class diagram gives a good overhead view of the project and how the different parts interact. We have used Screens to show the different screens the game might show (Menu, Game, Settings, etc) and Views to handle the display of all visual elements. These setup of these Views is to take an object of the class that it creates a View for, and displays it on the screen. This keeps the Models and Views separate, similar to how the MVC architectural pattern separates responsibilities. 

**Code quality and testing**
* We have focused on making good tests, if not immediately. We have made all the classes/functions and variables with describing names. As well as a lot of refactoring in cases of uncertainty and ambiguities. We have also written helper functions, such as     keyboardMoveRobot(), so we can move the robot around without using cards to test the board and robot mechanics. 

**Comments**
* As per the Agile Software Development [page 23] we consider unit tests to be documentation, as have thus focused on writing readable code and keeping comments to areas we feel need extra explanation, as well as all abstract methods in abstract classes and interfaces.
 
* [Class diagram](https://github.com/inf112-v19/The_Terminators/blob/master/Deliverables/Class_Diagram.pdf)

