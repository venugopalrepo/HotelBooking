package testing.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import testing.models.BookingEntry;

import java.text.ParseException;
import java.util.List;

public class BookingPage extends PageObjectsEnhanced {

    public BookingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#bookings")
    private WebElement bookings;
    @FindBy(css = "#form")
    private WebElement form;
    @FindBy(css = "#firstname")
    private WebElement firstname;
    @FindBy(css = "#lastname")
    private WebElement lastname;
    @FindBy(css = "#totalprice")
    private WebElement totalprice;
    @FindBy(css = "#depositpaid")
    private WebElement depositpaid;
    @FindBy(css = "#checkin")
    private WebElement checkin;
    @FindBy(css = "#checkout")
    private WebElement checkout;
    @FindBy(css = "input[value=' Save ']")
    private WebElement saveButton;
    @FindBy(xpath = "//div[@class='row']")
    private WebElement records;

    private final String recordsPath = "//div[@class='row']";

    public void verifyBookingPageDisplayed() {
        bookings.isDisplayed();
        form.isDisplayed();
    }

    public void enterBookingDetails(String input) throws ParseException {
        BookingEntry.setBookingDetails(input);
        type(firstname, BookingEntry.getFirstname());
        type(lastname, BookingEntry.getSurname());
        type(totalprice, String.valueOf(BookingEntry.getPrice()));
        type(checkin, BookingEntry.getCheckInDate());
        type(checkout, BookingEntry.getCheckOutDate());
        Select isDeposit = new Select(depositpaid);
        isDeposit.selectByVisibleText(String.valueOf(BookingEntry.getIsDeposit()));
    }

    public void submitsBooking() {
        int beforeCount = getDriver().findElements(By.xpath(recordsPath)).size();
        saveButton.click();
        waitUntilNewRecordAdded(beforeCount);
    }

    public void waitUntilNewRecordAdded(int beforeCount) {
        int afterCount = 0;
        for (int i = 0; afterCount <= beforeCount; i++)
            afterCount = getDriver().findElements(By.xpath(recordsPath)).size();
    }

    public void verifyBookingDetailsAsEntered() {
        int matchRow = getMatchedRecordFromOutput();

        List<WebElement> rowContents = getDriver().findElements(By.xpath("//div[@class='row'][" + matchRow + "]/div/p"));

        Assert.assertEquals("Firstname not same as entered", rowContents.get(0).getText(), BookingEntry.getFirstname());
        Assert.assertEquals("Surname not same as entered", rowContents.get(1).getText(), BookingEntry.getSurname());
        Assert.assertEquals("Price not same as entered", rowContents.get(2).getText(), String.valueOf(BookingEntry.getPrice()));
        Assert.assertEquals("IsDeposit not same as entered", rowContents.get(3).getText(), String.valueOf(BookingEntry.getIsDeposit()));
        Assert.assertEquals("CheckInDate not same as entered", rowContents.get(4).getText(), BookingEntry.getCheckInDate());
        Assert.assertEquals("CheckOutDate not same as entered", rowContents.get(5).getText(), BookingEntry.getCheckOutDate());
    }

    public int getMatchedRecordFromOutput() {
        int matchRow = 0;
        int rowCount = getDriver().findElements(By.xpath(recordsPath)).size();
        for (int i = 2; i <= rowCount; i++) {
            List<WebElement> rowContents = getDriver().findElements(By.xpath("//div[@class='row'][" + i + "]/div/p"));
            for (WebElement input : rowContents)
                if (input.getText().equalsIgnoreCase(BookingEntry.getFirstname())) {
                    matchRow = i;
                    break;
                }
        }
        return matchRow;
    }

    public void deleteBooking() {
        int matchRow = getMatchedRecordFromOutput();
        WebElement deleteButton = getDriver().findElement(By.xpath("//div[@class='row'][" + matchRow + "]//input"));
        deleteButton.click();
    }

    public void verifyBookingIsDeleted() {
        int rowCount = getDriver().findElements(By.xpath(recordsPath)).size();
        for (int i = 2; i <= rowCount; i++) {
            List<WebElement> rowContents = getDriver().findElements(By.xpath("//div[@class='row'][" + i + "]/div/p"));
            for (WebElement input : rowContents)
                if (input.getText().equalsIgnoreCase(BookingEntry.getFirstname()))
                    Assert.fail("Booking entry is still not deleted");
        }
    }
}
