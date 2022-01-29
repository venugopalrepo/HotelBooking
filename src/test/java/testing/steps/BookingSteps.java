package testing.steps;

import net.thucydides.core.annotations.Step;
import testing.pages.BookingPage;
import testing.utility.Session;

import java.text.ParseException;

public class BookingSteps {
    public BookingPage bookingPage;

    @Step
    public void openBookingPage() {
        bookingPage.openAt(Session.getBaseUrl());
        bookingPage.getDriver().manage().window().maximize();
    }

    @Step
    public void verifyBookingPageDisplayed() {
        bookingPage.verifyBookingPageDisplayed();
    }

    @Step
    public void entersGuestBookingDetails(String input) throws ParseException {
        bookingPage.enterBookingDetails(input);
    }

    @Step
    public void submitsBooking() throws InterruptedException {
        bookingPage.submitsBooking();
    }

    @Step
    public void verifyBookingDetailsAsEntered() {
        bookingPage.verifyBookingDetailsAsEntered();
    }

    @Step
    public void deleteBooking() throws InterruptedException {
        bookingPage.deleteBooking();
    }

    @Step
    public void verifyBookingIsDeleted() {
        bookingPage.verifyBookingIsDeleted();
    }

}
