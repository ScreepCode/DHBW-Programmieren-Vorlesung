# File Templates
> Abkürzungen und Beschreibung könnt ihr setzen wie ihr wollt.
> **Anleitung**: IntelliJ → Settings → Live and Code Templates → + <br>
> **Hinweis**: Die Templates kannst du im besten Fall so übernehmen, natürlich auch anpassen, wenn du weißt, was machst :)
>
> **Mindestens**: Name & Template Inhalt
 


---

> ### Name: Exception <br>
``` java
#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")
public class ${NAME} extends Exception {
    public ${NAME} (){
        super("Message");
    }
    public ${NAME} (String message){
        super(message);
    }
}
```
---