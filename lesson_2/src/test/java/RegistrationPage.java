import org.openqa.selenium.By;

public class RegistrationPage {
    public static final By HEADER = By.xpath(".//*[text()='Student Registration Form']");
    public static final By FIRST_NAME_FIELD = By.id("firstName");
    public static final By LAST_NAME_FIELD = By.id("lastName");
    public static final By EMAIL_FIELD = By.id("userEmail");
    public static final String GENDER_RADIO_BUTTON = ".//label[text()='%s']/ancestor::div[contains(@class,'custom-radio')]";
    public static final String GENDER_RADIO_INPUT = ".//label[text()='%s']/ancestor::div[contains(@class,'custom-radio')]/input";
    public static final By MOBILE_NUMBER = By.id("userNumber");
    public static final By BIRTH_FIELD = By.id("dateOfBirthInput");
    public static final By CALENDAR_MONTH_LIST = By.cssSelector(".react-datepicker__month-select");
    public static final By CALENDAR_YEAR_LIST = By.cssSelector(".react-datepicker__year-select");
    public static final String CALENDAR_DAYS_CONTAINER = "(.//div[text()='%s' and contains(@class,'react-datepicker__day')])[1]";
    public static final By SUBJECT_FIELD_INPUT = By.cssSelector("#subjectsContainer #subjectsInput");
    public static final String SUBJECT_FIELD_BY_NUMBER = "(.//div[contains(@class,'subjects-auto-complete__multi-value__label')]) [%s]";
    public static final String HOBBIES_CHECKBOX = ".//label[text()='%s']/ancestor::div[contains(@class,' custom-checkbox')]";
    public static final String HOBBIES_CHECKBOX_INPUT = ".//label[text()='%s']/ancestor::div[contains(@class,' custom-checkbox')]/input";
    public static final By UPLOAD_BUTTON = By.id("uploadPicture");
    public static final By CURRENT_ADDRESS_AREA = By.id("currentAddress");
    public static final By STATE = By.id("state");
    public static final By CITY = By.id("city");
    public static final By STATE_DROPDOWN_LIST = By.cssSelector("#state #react-select-3-input");
    public static final By CITY_DROPDOWN_LIST = By.cssSelector("#city #react-select-4-input");
    public static final By SUBMIT_BUTTON = By.id("submit");
}