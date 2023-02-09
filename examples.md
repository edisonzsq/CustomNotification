## Examples of Interface and Abstract Class in real life

### Fillable

```java
interface Fillable{
    void setCapacity(int ml);
    int getCapacity();
}

abstract class Bowl implements Fillable{
    abstract void fillFood();
}

abstract class Cup implements Fillable{
    abstract void fillWater();
}
```

### Touchable

```java
interface Touchable {
    void detectTouchPosition();
}

abstract class MobileDevice implements Touchable{
    abstract String getBrand();
    abstract String getModel();
}

abstract class Kiosk implements Touchable{
    abstract Dimension getDimension();
}

interface Dimension{
    int getHeight();
    int getWidth();
}
```

