package wrhome.helpdesk;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import wrhome.core.BaseSeleniumPage;

public class TicketsPage extends BaseSeleniumPage {

    @FindBy(id = "search_query")
    private WebElement searchField;

    @FindBy(xpath = "//div[@class='tickettitle']")
    private WebElement ticket;

    public TicketsPage() {
        PageFactory.initElements(driver, this);
    }

    public TicketPage findTicket(String str) {
        searchField.sendKeys(str, Keys.ENTER);
        ticket.click();
        return new TicketPage();
    }
}
