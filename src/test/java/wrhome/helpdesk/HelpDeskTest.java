package wrhome.helpdesk;

import helpers.TestValues;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import wrhome.core.BaseSeleniumTest;
import wrhome.core.TestListener;

import static helpers.StringModifier.getUniqueString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(TestListener.class)
public class HelpDeskTest extends BaseSeleniumTest {

    @Test
    public void testCheckTicket(){
        String title = getUniqueString(TestValues.TEST_TITLE);

        TicketPage ticketPage = new MainPage().createTicket(title, TestValues.TEST_BODY, TestValues.TEST_EMAIL)
                .openLoginPage()
                .auth(TestValues.TEST_LOGIN, TestValues.TEST_PASSWORD)
                .findTicket(title);
        assertTrue(ticketPage.getTitle().contains(title));
        assertEquals(ticketPage.getBody(), TestValues.TEST_BODY);
        assertEquals(ticketPage.getEmail(), TestValues.TEST_EMAIL);

//        System.out.println(ticketPage.getTitle().contains(title));
//        System.out.println(ticketPage.getBody().equals(TestValues.TEST_BODY));
//        System.out.println(ticketPage.getEmail().equals(TestValues.TEST_EMAIL));
    }

}
