Feature: Example Feature
  Binance UI test scenarios

  @smoke
  Scenario: CASE-1 Exporting listed coins to excel
    Given I navigate to binance homepage
    When  I click the "Piyasalar" from page
    And   I click the "Tüm Kriptolar" from page
    And   I click the "Tümü" from page
    Then  The first 3 pages of the listed coins are exported to excel

  @smoke
  Scenario:CASE-2 Verify login error with invalid user
    Given I navigate to binance homepage
    When I click "Spot" from the "Al-Sat" menu at the top of the homepage
    And  I click the login button on the page that opens
    And  I write "mete" in the email field On the login page
    And  I click the "İleri" button on the login screen
    Then I check the "Lütfen geçerli bir e-posta veya telefon numarası girin" warning message on the screen

  @somoke
  Scenario:CASE-3 Verify that the links under About us are working
    Given I navigate to binance homepage
    When I check that 3 randomly clicked pages are opened under "Hakkımızda"

  @smoke
  Scenario:CASE-4 Verify that the links under About us are work
    Given I navigate to binance homepage
    When  I click the "Piyasalar" from page
    And  I click the "Spot Piyasalar" from page
    And  I click the "USDT" from page
    Then I checked that the "USDT" page is opened properly



