package com.renny.joblogger;

import com.renny.joblogger.component.LogLevelFactory;
import com.renny.joblogger.component.LogOutputComponent;
import com.renny.joblogger.component.OutputLoggerFactory;
import com.renny.joblogger.domain.LoggerEntity;
import com.renny.joblogger.enums.LogLevelTypes;
import com.renny.joblogger.repository.LoggerRepository;
import com.renny.joblogger.rest.JobLogWriter;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.logging.Level;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RennyJobloggerApplication.class)
public class RennyJobloggerApplicationTests {

	@Autowired
	@Qualifier("logToConsoleComponent")
	private LogOutputComponent logToConsole;

	@Autowired
	@Qualifier("logToFileComponent")
	private LogOutputComponent logToFile;

	@Autowired
	@Qualifier("logToDatabaseComponent")
	private LogOutputComponent logToDatabase;

	@Autowired
	private LogLevelFactory logLevelFactory;

	@Autowired
	private OutputLoggerFactory outputLoggerFactory;

	@Autowired
	private LoggerRepository loggerRepository;

	@Test
	public void contextLoads() {
		Assert.assertNotNull(this.logToConsole);
		Assert.assertNotNull(this.logToFile);
		Assert.assertNotNull(this.logToDatabase);
		Assert.assertNotNull(this.logLevelFactory);
		Assert.assertNotNull(this.outputLoggerFactory);
		Assert.assertNotNull(this.loggerRepository);
	}

	@Test
	public void levelShouldNotBeNull(){
		Assert.assertNotNull(this.logLevelFactory.getLogLevel("WARN"));
	}

	@Test
	public void outputShouldNotBeNull(){
		Assert.assertNotNull(this.outputLoggerFactory.getLogOutputComponent("LTC"));
	}

	@Test
	@Sql(statements = {"insert into logger_entity (message) values ('Test message')"})
	public void insertTest(){
		LoggerEntity loggerEntity = this.loggerRepository.findByMessage("Test message");
		Assert.assertThat(loggerEntity.getMessage(), Is.is("Test message"));
	}

}
