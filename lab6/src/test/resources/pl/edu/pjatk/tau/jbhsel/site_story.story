Scenario: User is trying to login with wrong login and password
Given user is on Login page
When user inserts login: Marek in login field
Then user inserts password: Warek in password field
When user clicks button with login option
Then site responds failed login text in new site

