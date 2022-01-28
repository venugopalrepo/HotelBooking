package testing.definitions;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import testing.steps.BookingSteps;

import java.text.ParseException;

public class BookingDefinitions {

    @Steps
    BookingSteps bookingSteps;

    @Given("^user opens the booking system$")
    public void openBookingSystem() {
        bookingSteps.openBookingPage();
        bookingSteps.verifyBookingPageDisplayed();
    }

    @Given("^enters the guest booking details (.*)$")
    public void entersGuestBookingDetails(String input) throws ParseException {
        bookingSteps.entersGuestBookingDetails(input);
    }

    @When("^submits booking entry$")
    public void submitsBooking() throws InterruptedException {
        bookingSteps.submitsBooking();
    }

    @Then("verify booking details is submitted are as entered")
    public void verifyBookingDetailsAsEntered() {
        bookingSteps.verifyBookingDetailsAsEntered();
    }

    @Given("^user created a booking entry for (.*)$")
    public void createBooking(String input) throws Exception {
        bookingSteps.openBookingPage();
        bookingSteps.verifyBookingPageDisplayed();
        bookingSteps.entersGuestBookingDetails(input);
        bookingSteps.submitsBooking();
        bookingSteps.verifyBookingDetailsAsEntered();
    }

    @When("^requests to delete the booking entry$")
    public void deleteBooking() throws InterruptedException {
        bookingSteps.deleteBooking();
    }

    @Then("verify the booking details are deleted")
    public void verifyBookingIsDeleted() {
        bookingSteps.verifyBookingIsDeleted();
    }

}
