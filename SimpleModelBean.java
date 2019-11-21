package testNG;

public class SimpleModelBean implements Comparable<SimpleModelBean> {

    private String aStr;
    private final String aFinalStr;
    private String aFilledStr = "abc";
    private String aFilledStrCopy = "abc";
    private String aFilledStrObjCopy = new String("abc");

    private int i;
    private Integer iObj;

    //Task 2 Exercise 1
    public SimpleModelBean(String aFinalStr) {
        this.aFinalStr = aFinalStr;
    }

    //Task 2 Exercise 2
    public String getaStr() {
        return aStr;
    }

    public String getaFinalStr() {
        return aFinalStr;
    }

    public String getaFilledStr() {
        return aFilledStr;
    }

    public String getaFilledStrCopy() {
        return aFilledStrCopy;
    }

    public String getaFilledStrObjCopy() {
        return aFilledStrObjCopy;
    }

    public int getI() {
        return i;
    }

    public Integer getiObj() {
        return iObj;
    }

    //Task 2 Exercise 7
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SimpleModelBean) {
            SimpleModelBean anotherSimpleModeBean = (SimpleModelBean) obj;
            if (aStr != null && aStr.equals(anotherSimpleModeBean.getaStr()) && i == anotherSimpleModeBean.getI()) {
                return true;
            }
            return false;
        }
        return false;
    }


    //Task 2 Exercise 5
    @Override
    public int compareTo(SimpleModelBean o) {
        if (this.equals(o)) {
            return 0;
        }
        if (this.getaStr().compareTo(o.getaStr()) == 0) {
            return this.i - o.getI();
        } else {
            return this.getaStr().compareTo(o.getaStr());
        }
    }

    //Task 2 Exercise 8
    @Override
    public String toString() {
        return "[aStr=" + getaStr()
                + ",aFinalStr=" + getaFinalStr()
                + ",aFilledStr=" + getaFilledStr()
                + ",aFilledStrCopy=" + getaFilledStrCopy()
                + ",aFilledStrObjCopy=" + getaFilledStrObjCopy()
                + ",i=" + getI()
                + ",iObj=" + getiObj()
                + "]";
    }

    //Task 2 Exercise 9
    public String toString(boolean printClass){
        return printClass ? getClass().getName() : ""
                + " [aStr=" + getaStr()
                + ",aFinalStr=" + getaFinalStr()
                + ",aFilledStr=" + getaFilledStr()
                + ",aFilledStrCopy=" + getaFilledStrCopy()
                + ",aFilledStrObjCopy=" + getaFilledStrObjCopy()
                + ",i=" + getI()
                + ",iObj=" + getiObj()
                + "]";
    }
}
