Feature: Delete Booking Entry

  @Demo
  Scenario Outline: Delete booking entry
    Given user created a booking entry for <input>
    When requests to delete the booking entry
    Then verify the booking details are deleted

    Examples:
      | input                                                                                               |
      | firstname:John~surname:Smith~checkInDate:2022-01-28~checkOutDate:2022-01-30~price:10~isDeposit:true |


