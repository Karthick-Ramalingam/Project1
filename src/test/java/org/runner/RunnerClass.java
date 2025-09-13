package org.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\feature\\tasks.feature",
						glue = {"org.stepdef","org.amazon"},
						dryRun = false,
						strict = true,
						monochrome = true)
public class RunnerClass {

}
