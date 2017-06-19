#include <vector.hpp>
#include <catch.hpp>


TEST_CASE("Simple tests") {
    Vector wektor1;
    Vector wektor2;

    wektor1.addPoint(1);
    wektor1.addPoint(3);
        
    wektor2.addPoint(2);
    wektor2.addPoint(4);

    SECTION("Adding wektor2 to wektor1") {

        Vector expected;

        expected.addPoint(3);
        expected.addPoint(7);

        wektor1.add(wektor2);
    
        bool result = wektor1.equals(expected);

        REQUIRE(result == true);
    }

     SECTION("Subtract wektor1 from wektor2") {

        Vector expected;

        expected.addPoint(1);
        expected.addPoint(1);
     
        wektor2.subtract(wektor1);
    
        bool result = wektor2.equals(expected);

        REQUIRE(result == true);
       
    }

        SECTION("Multiply wektor2 and wektor1") {

        Vector expected;

        expected.addPoint(2);
        expected.addPoint(12);

        wektor1.multiply(wektor2);

        bool result = wektor1.equals(expected);

        REQUIRE(result == true);


    }
 
        SECTION("Catch Throw") {
            wektor2.addPoint(3);
            REQUIRE_THROWS(wektor2.add(wektor1));
        }
}


SCENARIO("Operations tests") {

    Vector wektor1;
    Vector wektor2;
    Vector wektor3;

    wektor1.addPoint(3);
    wektor1.addPoint(2);

    wektor2.addPoint(5);
    wektor2.addPoint(2);

    wektor3.addPoint(4);
    wektor3.addPoint(3);

    GIVEN("Created Wektors to add") {

        REQUIRE(&wektor1 != NULL);         
        REQUIRE(&wektor2 != NULL);           
        REQUIRE(&wektor3 != NULL);

        WHEN("Multiply Vectors wektor1 and wektor2 and subtract from wektor3") {

            REQUIRE_NOTHROW(wektor1.multiply(wektor2));
            REQUIRE_NOTHROW(wektor1.subtract(wektor3));

            THEN("The result should be [11,1] true") {

                Vector expected;
                expected.addPoint(11);
                expected.addPoint(1);
                REQUIRE(wektor1.equals(expected));
            }
        }
    }
 }
