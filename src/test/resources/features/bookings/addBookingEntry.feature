Feature: Add Booking Entry

  @Demo
  Scenario Outline: Add booking entry
    Given user opens the booking system
    And enters the guest booking details <input>
    When submits booking entry
    Then verify booking details is submitted are as entered

    Examples:
      | input                                                                                                |
      | firstname:John~surname:Smith~checkInDate:2022-01-28~checkOutDate:2022-01-30~price:10~isDeposit:true  |
      | firstname:John~surname:Smith~checkInDate:2022-01-28~checkOutDate:2022-01-30~price:10~isDeposit:false |


