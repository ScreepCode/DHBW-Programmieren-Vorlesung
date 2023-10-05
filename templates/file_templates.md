# File Templates
> Abkürzungen und Beschreibung könnt ihr setzen wie ihr wollt. 
> 
> **Anleitung**: IntelliJ → Settings → Live and Code Templates → + 
> 
> **Hinweis**: Die Templates kannst du so übernehmen, natürlich auch anpassen, wenn du weißt, was machst :)
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

> ### Name: EnumCustom <br>
``` java
#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")
public enum ${NAME} {

    A("A"),
    B("B");

    private final String name;

    ${NAME}(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s", name);
    }
}
```
---