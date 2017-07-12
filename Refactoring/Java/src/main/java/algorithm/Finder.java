package algorithm;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Finder {
    private final List<Person> personList;

    public Finder(List<Person> p) {
        personList = p;
    }

    public PersonsDOBDiff find(FinderType finderType) {

        PersonsDOBDiff personsDOBDiff = new PersonsDOBDiff();

        if (personList.size() <= 1) {
            return personsDOBDiff;
        }

        Collections.sort(personList, Comparator.comparing(Person::getBirthDate));

        int end = 1;

        if (finderType.equals(FinderType.TWO)) {
            end = personList.size() - 1;
        }

        personsDOBDiff.setPersonsDiff(personList, 0, end);

        return personsDOBDiff;

    }

}
