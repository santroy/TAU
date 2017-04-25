package pl.edu.pjatk.tau;


import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.SilentStepMonitor;
import org.jbehave.web.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class SiteStories extends JUnitStories {

    private WebDriverProvider driverProvider =
            new TypeWebDriverProvider(PhantomJSDriver.class);
    private WebDriverSteps lifecycleSteps =
            new PerStoryWebDriverSteps(driverProvider); // or PerStoryWebDriverSteps(driverProvider)
    private Pages pages = new Pages(driverProvider);
    private SeleniumContext context = new SeleniumContext();
    private ContextView contextView = new LocalFrameContextView().sized(500, 100);

    public SiteStories() {

        System.setProperty("takesScreenshot", "true");
        System.setProperty(
                //PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/opt/tp/phantomjs-2.1.1-linux-x86_64/bin/phantomjs"); // LINUX
                //PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:/PhantomJS/phantomjs-2.1.1-windows/bin/phantomjs.exe"); // WINDOWS
        		//PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "E:\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe"); // WINDOWS
                PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/tmp/phantomjs"); // LINUX (/linux/phantomjs /tmp/phantomjs

        //System.setProperty("webdriver.chrome.driver", "/chromedriver/chromedriver.exe"); // /..../chromedriver/chromedriver
        //driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driverProvider.initialize();
    }

    @Override
    public Configuration configuration() {
        Class<? extends Embeddable> embeddableClass = this.getClass();
        return new SeleniumConfiguration()
                .useSeleniumContext(context)
                .useWebDriverProvider(driverProvider)
                .useStepMonitor(new SeleniumStepMonitor(contextView, context, new SilentStepMonitor()))
                .useStoryLoader(new LoadFromClasspath(embeddableClass))
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withCodeLocation(codeLocationFromClass(embeddableClass))
                        .withDefaultFormats()
                        .withFormats(Format.CONSOLE, Format.HTML, Format.HTML_TEMPLATE));
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        Configuration configuration = configuration();
        return new InstanceStepsFactory(configuration,
                new SiteSteps(pages),
                lifecycleSteps,
                new WebDriverScreenshotOnFailure(driverProvider, configuration.storyReporterBuilder()));
    }
    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(
                codeLocationFromClass(this.getClass()).getFile(),
                asList("**/*.story"), null);
    }

}