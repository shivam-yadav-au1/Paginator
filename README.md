### Paginator Api which is used add Paginator in java project.

### How to use this paginator api

1.Create object of DefaultPaginator class in your class where  you want to use paginator and pass list object in its constructor.

```java
public YourClassName{
  private DefaultPaginator defaultPaginator;

  public YourClassName(){
    defaultPaginator = new DefaultPaginator(listOfStudents);
  }
}

```

2.Generate  setter and getter of paginator in your class.

```java
public DefaultPaginator getPaginator() {
  return paginator;
}

public void setPaginator(DefaultPaginator paginator) {
  this.paginator = paginator;
}
```

3.Then call method refresh() and next() from where you are inserting item to list.

```java
public String addStudent(){
  defaultPaginator.refresh();
  defaultPaginator.next();
  return "";
}
```

4. Now you can use previous() and next() method from your jsf page.

```html
<h:commandButton action="#{YourClassName.defaultPaginator.previous}" value="Previous"></h:commandButton>
	<h:commandButton action="#{YourClassName.defaultPaginator.next}" value="Next"></h:commandButton>
```
