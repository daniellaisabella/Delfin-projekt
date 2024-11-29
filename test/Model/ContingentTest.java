package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContingentTest {

    @Test
    void testCalculateContingentPassive() {

        //Arrange
        MembershipType type = MembershipType.PASSIVE;

        //Act
        double result = Contingent.calculateContingent(type);

        //Assert
        assertEquals(500.0, result, "The fee for passive membership should be 500 kr.");
    }

    @Test
    void testCalculateContingentActiveJunior() {

        //Arrange
        MembershipType type = MembershipType.ACTIVE_JUNIOR;

        //Act
        double result = Contingent.calculateContingent(type);

        //Assert
        assertEquals(1000.0, result, "The fee for active junior membership should be 1000 kr.");
    }

    @Test
    void testCalculateContingentActiveSenior() {

        //Arrange
        MembershipType type = MembershipType.ACTIVE_SENIOR;

        //Act
        double result = Contingent.calculateContingent(type);

        //Assert
        assertEquals(1600.0, result, "The fee for active senior membership should be 1600 kr.");
    }

    @Test
    void testCalculateContingentActiveRetiree() {

        //Arrange
        MembershipType type = MembershipType.ACTIVE_RETIREE;

        //Act
        double result = Contingent.calculateContingent(type);

        //Assert
        assertEquals(1200.0, result, "The fee for active retirees membership should be 1200 kr.");

    }
    }
