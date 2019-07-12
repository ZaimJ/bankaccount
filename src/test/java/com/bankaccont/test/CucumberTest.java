package com.bankaccont.test;


import com.bankaccont.BankaccountApplication;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:feature",
		plugin ={"pretty","html:src/test/java/com/bankaccount/resources/test/htmlReports"})

@ContextConfiguration(
		classes = BankaccountApplication.class,
		loader = SpringBootContextLoader.class)
@WebAppConfiguration
@SpringBootTest
public class CucumberTest  {
}