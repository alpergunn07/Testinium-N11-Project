package Elements;

import org.openqa.selenium.By;

public class Element {
    public By by;

    public Element(By by) {
        super();
        this.by = by;
    }

    public By getBy() {
        return by;
    }
    public void setBy(By by) {
        this.by = by;
    }
}
