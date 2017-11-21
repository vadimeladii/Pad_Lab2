package md.utm.fcim.constant;

import java.io.Serializable;

public enum MethodName implements Serializable {
    FILTER("filter"), SORTED("sorted"), ALL("all");

    private String name;

    MethodName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
