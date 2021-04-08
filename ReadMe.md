__Prolog-swi__ learner support for IntelliJ family  (IDEA,WEBSTORM...)
***
> Basic prolog syntax analysis  

![alt syntax](src/main/resources/guidePics/syntax.png)
The plugin has its parser and lexer to give you hints when the code you write doesn't follow the prolog syntax
> Highlighter for predicates/ predicates reference, atom, constant....  

![alt syntax](src/main/resources/guidePics/highlighter.png)

> Go to implementation  

![alt syntax](src/main/resources/guidePics/goto.png)
right click on referenced predicate name to see its implementation or hold command/ctrl + click the referenced predicate name.  
the plugin will identify the predicates *with the different amount of parameters* and navigate to the predicate which has same parameter numbers as you chose.
> Commenter 

![alt syntax](src/main/resources/guidePics/commenter.png)
batch commenter, select lines and hold command/ctrl + "/" 
> Auto formatting</ul>  

this helps you add spaces around UNIFY and other operators and indent composed predicated to make your code looks pretty  

###local installation
if u can't find it at plugin marketplace yet, download [PrologPlugin](src/main/resources/distribution/PrologPlugin-1.0-SNAPSHOT.zip) and installed it at your IDE by disk-installation