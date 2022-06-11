package executor;

import io.cucumber.core.cli.Main;
import metadata.PropertyLoader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * This class handles the execution of the glue defined under 'executor',
 * manages before test scenarios, report generation plugin
 *
 * @author Gayathri Gamage
 * Date 11 June 2022
 */
public class CucumberIT {

    /**
     * This method includes all the prerequisite steps need to be run
     * prior to actual test methods
     *
     * @throws IOException when errors occur while accessing the property files
     */
    @BeforeAll
    static void preparePrerequisite() throws IOException {
        PropertyLoader.readProperties();
    }

    /**
     * This method initializes the execution of tests
     * Manages thread count
     * Manages reporting plugin
     */
    @Test
    void executor() {
        Main.run(new String[]{
                "--threads", "1",
                "-p", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
                "-g", "stepdefs", "src/main/resources/features"
        }, CucumberIT.class.getClassLoader());
    }
}
