package TesterLists;

import java.util.Objects;

public class Occurance {
    private String name;
    private int occurance = 1;

    public Occurance(String name, int occurance) {
        this.name = name;
        this.occurance = occurance;
    }

    public Occurance(String name) {
        this.name = name;
    }

    public Occurance() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOccurance() {
        return occurance;
    }

    public void setOccurance(int occurance) {
        this.occurance = occurance;
    }

    public void setOccurance() {
        this.occurance = this.occurance + 1;
    }

    @Override
    public String toString() {
        return "\n{name=\"" + name + '\"' +
                ", occurance=" + occurance +
                "}";
    }

    @Override

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Occurance that = (Occurance) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

