package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import project.W3CActionsBase;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Activity8 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void SetUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get("https://v1.training-support.net/selenium");
    }

    @Test
    public void todoListTest() {


        Dimension dims = driver.manage().window().getSize();
        Point start = new Point((int) (dims.getWidth() * 0.5), (int) (dims.getHeight() * 0.8));
        Point end = new Point((int) (dims.getWidth() * 0.5), (int) (dims.getHeight() * 0.6));

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text=\"Get Started!\"]"))).click();

        W3CActionsBase.doSwipe(driver, start, end, 50);
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text=\"To-Do List\"]"))).click();

        int initialSize = driver.findElements(AppiumBy.xpath("//android.widget.TextView")).size();
        driver.findElement(AppiumBy.xpath("//android.webkit.WebView[@text=\"Todo List\"]/android.view.View/android.view.View/android.view.View[1]/android.widget.EditText")).sendKeys("Add tasks to list");
        addTask();
        driver.findElement(AppiumBy.xpath("//android.webkit.WebView[@text=\"Todo List\"]/android.view.View/android.view.View/android.view.View[1]/android.widget.EditText")).sendKeys("Get number of tasks");
        addTask();
        driver.findElement(AppiumBy.xpath("//android.webkit.WebView[@text=\"Todo List\"]/android.view.View/android.view.View/android.view.View[1]/android.widget.EditText")).sendKeys("Clear the list");
        addTask();
        //tasks count
        List<WebElement> tasks = driver.findElements(AppiumBy.xpath("//android.widget.TextView"));
        Assert.assertEquals(tasks.size(), initialSize + 3);

        //Striking tasks
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Add tasks to list\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Get number of tasks\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Clear the list\"]")).click();

        //Clearing task
        driver.findElement(AppiumBy.xpath(
                "//android.widget.TextView[@text=' Clear List']")).click();
        List<WebElement> taskAfterClearing = driver.findElements(AppiumBy.xpath("//android.webkit.WebView[@text=\"Todo List\"]/android.view.View/android.view.View/android.view.View[2]"));
        //Assertion
        Assert.assertEquals(taskAfterClearing.size(), 1);
    }

    public void addTask() {
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Add Task\"]")).click();
    }
=======
        package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import project.W3CActionsBase;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

    public class Activity8 {

        AndroidDriver driver;
        WebDriverWait wait;

        @BeforeClass
        public void SetUp() throws MalformedURLException {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("Android");
            options.setAutomationName("UiAutomator2");
            options.setAppPackage("com.android.chrome");
            options.setAppActivity("com.google.android.apps.chrome.Main");
            options.noReset();

            URL serverURL = new URL("http://localhost:4723/wd/hub");

            driver = new AndroidDriver(serverURL, options);
            wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            driver.get("https://v1.training-support.net/selenium");
        }

        @Test
        public void todoListTest() {


            Dimension dims = driver.manage().window().getSize();
            Point start = new Point((int) (dims.getWidth() * 0.5), (int) (dims.getHeight() * 0.8));
            Point end = new Point((int) (dims.getWidth() * 0.5), (int) (dims.getHeight() * 0.6));

            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text=\"Get Started!\"]"))).click();

            W3CActionsBase.doSwipe(driver, start, end, 50);
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text=\"To-Do List\"]"))).click();

            int initialSize = driver.findElements(AppiumBy.xpath("//android.widget.TextView")).size();
            driver.findElement(AppiumBy.xpath("//android.webkit.WebView[@text=\"Todo List\"]/android.view.View/android.view.View/android.view.View[1]/android.widget.EditText")).sendKeys("Add tasks to list");
            addTask();
            driver.findElement(AppiumBy.xpath("//android.webkit.WebView[@text=\"Todo List\"]/android.view.View/android.view.View/android.view.View[1]/android.widget.EditText")).sendKeys("Get number of tasks");
            addTask();
            driver.findElement(AppiumBy.xpath("//android.webkit.WebView[@text=\"Todo List\"]/android.view.View/android.view.View/android.view.View[1]/android.widget.EditText")).sendKeys("Clear the list");
            addTask();
            //tasks count
            List<WebElement> tasks = driver.findElements(AppiumBy.xpath("//android.widget.TextView"));
            Assert.assertEquals(tasks.size(), initialSize + 3);

            //Striking tasks
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Add tasks to list\"]")).click();
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Get number of tasks\"]")).click();
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Clear the list\"]")).click();

            //Clearing task
            driver.findElement(AppiumBy.xpath(
                    "//android.widget.TextView[@text=' Clear List']")).click();
            List<WebElement> taskAfterClearing = driver.findElements(AppiumBy.xpath("//android.webkit.WebView[@text=\"Todo List\"]/android.view.View/android.view.View/android.view.View[2]"));
            //Assertion
            Assert.assertEquals(taskAfterClearing.size(), 1);
        }

        public void addTask() {
            driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Add Task\"]")).click();
        }
>>>>>>> ba516736694e7ba5527f451f2ec93784e0f7532b
    }