package org.amazon;

import org.facebook.BaseClass;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks extends BaseClass{
	
	@Before
	private void test1(Scenario s) {
		String name = s.getName();
		System.out.println(name);
	}

	@After
	private void test3(Scenario s) {
		boolean failed = s.isFailed();
		System.out.println(failed);
	}
}
