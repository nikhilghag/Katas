package algorithm;

import java.util.List;

public class PersonsDOBDiff {
    private Person younger;
    private Person older;

    public Person getYounger() {
        return younger;
    }

    public Person getOlder() {
        return older;
    }

    public void setPersonsDiff(List<Person> personList, int start, int end) {
        this.younger = personList.get(start);
        this.older = personList.get(end);
    }
}
