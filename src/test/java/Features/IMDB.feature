@IMDB
  Feature: IMDB Test Cases

   // @SearchingMovie
    Scenario: User search movie from menu
      Given User at mainpage
      When User accept cookies
      When User click menu button
      When User click Oscar option from Award&Evetns menu
      When User click 2020 from Event History menu
      When User click 2020
      When User click parazit movie
      When User get Director Writer and Stars name
      Then User back mainpage

      @WritingMovieName
      Scenario: User write movie name in searchbox
        Given User at mainpage
        When User accept cookies
        When User click searchbox
        When User write movie name and click search
        When User get Director Writer and Stars name from movie page
        When User compares them in the first case
        When User click gallery
        Then User verify that links to photos are correct