package test;
import algorithm.FinderType;
import algorithm.Finder;
import algorithm.Person;
import algorithm.PersonsDOBDiff;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FinderTests {

	Person sue = new Person();
	Person greg = new Person();
	Person sarah = new Person();
	Person mike = new Person();

	@Before
	public void setup() {
		sue.setName("Sue");
		sue.setBirthDate(new Date(50, 0, 1));
		greg.setName("Greg");
		greg.setBirthDate(new Date(52, 5, 1));
		sarah.setName("Sarah");
		sarah.setBirthDate(new Date(82, 0, 1));
		mike.setName("Mike");
		mike.setBirthDate(new Date(79, 0, 1));
	}

	@Test
	public void Returns_Empty_Results_When_Given_Empty_List() {
		List<Person> list = new ArrayList<>();
		Finder finder = new Finder(list);

		PersonsDOBDiff result = finder.find(FinderType.ONE);
		assertEquals(null, result.getYounger());

		assertEquals(null, result.getOlder());
	}

	@Test
	public void Returns_Empty_Results_When_Given_One_Person() {
		List<Person> list = new ArrayList<>();
		list.add(sue);

		Finder finder = new Finder(list);

		PersonsDOBDiff result = finder.find(FinderType.ONE);

		assertEquals(null, result.getYounger());
		assertEquals(null, result.getOlder());
	}

	@Test
	public void Returns_Closest_Two_For_Two_People() {
		List<Person> list = new ArrayList<>();
		list.add(sue);
		list.add(greg);
		Finder finder = new Finder(list);

		PersonsDOBDiff result = finder.find(FinderType.ONE);

		assertEquals(sue, result.getYounger());
		assertEquals(greg, result.getOlder());
	}

	@Test
	public void Returns_Furthest_Two_For_Two_People() {
		List<Person> list = new ArrayList<>();
		list.add(mike);
		list.add(greg);

		Finder finder = new Finder(list);

		PersonsDOBDiff result = finder.find(FinderType.TWO);

		assertEquals(greg, result.getYounger());
		assertEquals(mike, result.getOlder());
	}

	@Test
	public void Returns_Furthest_Two_For_Four_People() {
		List<Person> list = new ArrayList<>();
		list.add(sue);
		list.add(sarah);
		list.add(mike);
		list.add(greg);
		Finder finder = new Finder(list);

		PersonsDOBDiff result = finder.find(FinderType.TWO);

		assertEquals(sue, result.getYounger());
		assertEquals(sarah, result.getOlder());
	}

	@Test
	public void Returns_Closest_Two_For_Four_People() {
		List<Person> list = new ArrayList<>();
		list.add(sue);
		list.add(sarah);
		list.add(mike);
		list.add(greg);

		Finder finder = new Finder(list);

		PersonsDOBDiff result = finder.find(FinderType.ONE);

		assertEquals(sue, result.getYounger());
		assertEquals(greg, result.getOlder());
	}

}
