// YOUR NAME: Muhammad Conn
// COLLABORATORS: N/A
// DATE: 02/23/2024

public class Main
{
    //ascii art credit: http://www.oocities.org/spunk1111/bodypart.htm
    //Strings for the ascii art are defined as static finals in the Main class to be accessed by the method later
    static final String ASCII_ART_0 = "    .----.    .----.  ",
    ASCII_ART_1 = "   (  --  \\  /  --  )",
    ASCII_ART_2 = "          |  |        ",
    ASCII_ART_3 = "         _/  \\_      ",
    ASCII_ART_4 = "        (_    _)      ",
    ASCII_ART_5 = "     ,    `--`    ,   ",
    ASCII_ART_6 = "     \\'-.______.-'/  ",
    ASCII_ART_7 = "      \\          /   ",
    ASCII_ART_8 = "       '.--..--.'     ",
    ASCII_ART_9 = "         `\"\"\"\"\"` ",
    ASCII_CREDIT = "   ascii art by: jgs    ";

    //Various strings are defined as static finals to be accessed by the method later
    static final String TITLE_USA = "UNITED STATES OF AMERICA",
            TITLE_EAC = "EMPLOYMENT AUTHORIZATION CARD";
        static final String LABEL_SURNAME = "Surname", LABEL_GIVEN_NAME = "Given Name", LABEL_USCIS_NUM = "USCIS#",
            LABEL_CATEGORY = "Category", LABEL_CARD_NUM = "Card#", LABEL_BIRTH_COUNTRY = "Country of Birth",
            LABEL_TERMS_CONDITIONS = "Terms and Conditions", LABEL_BIRTH_DATE = "Date of Birth",
            LABEL_SEX = "Sex", LABEL_VALID_DATE = "Valid From:", LABEL_EXPIRE_DATE = "Card Expires:",
            LABEL_REENTRY_DISCLAIMER = "NOT VALID FOR REENTRY TO U.S.";
    public static void main(String[] args)
    {

        //DECLARATION SECTION
        //complete fields
        String surname, givenName, category, cardNum, birthCountry, termsAndConditions;
        char sex;

        //parts of fields
        String birthMonth;
        int uscisNum1, uscisNum2, uscisNum3, birthDay, birthYear,
                validDay, validMonth, validYear, expireMonth, expireDay, expireYear;

        //extra vars to help with formatting of Strings (not raw data like above vars)
        String uscisNum, dateOfBirth, validDate, expireDate;

        //INITIALIZATION SECTION
        //We ask the user to input the appropriate information for the
        surname = UtilityBelt.readString("What is the surname?", 0, 50);
        givenName = UtilityBelt.readString("What is the given name?", 0, 50);
        uscisNum1 = UtilityBelt.readInt("What is the first USCIS number?", 0, 999);
        uscisNum2 = UtilityBelt.readInt("What is the second USCIS number?", 0, 999);
        uscisNum3 = UtilityBelt.readInt("What is the third USCIS number?", 0, 999);
        category = UtilityBelt.readString("What is the category number?", 0, 50);
        cardNum = UtilityBelt.readString("What is the card number?", 0, 15);
        birthCountry = UtilityBelt.readString("What is the birth country?", 0, 50);
        termsAndConditions = UtilityBelt.readString("What are the terms and conditions?", 0, 50);;

        birthDay = UtilityBelt.readInt("What is the birth day?", 0, 31);
        birthMonth = UtilityBelt.readString("What is the birth month?", 0, 5);
        birthYear = UtilityBelt.readInt("What is the birth year?", 0, 3000);

        sex = UtilityBelt.readChar("What is the sex?", "M,F"); //note single quotes

        validMonth = UtilityBelt.readInt("What is the validity month?", 0, 12);
        validDay = UtilityBelt.readInt("What is the validity day?", 0, 31);;
        validYear = UtilityBelt.readInt("What is the validity year?", 0, 3000);

        expireMonth = UtilityBelt.readInt("What is the expiry month?", 0, 12);
        expireDay = UtilityBelt.readInt("What is the expiry day?", 0, 31);
        expireYear = UtilityBelt.readInt("What is the expiry year?", 0, 3000);

        //Strings to help clean up long printf's below
        uscisNum = String.format("%03d-%03d-%03d", uscisNum1, uscisNum2, uscisNum3);
        dateOfBirth = String.format("%02d %s %d", birthDay, birthMonth, birthYear);
        //We call on formatDate to format our data information as a day/month/year date
        validDate = formatDate(validDay, validMonth, validYear);
        expireDate = formatDate(expireDay, expireMonth, expireYear);


        //INPUT + CALCULATION SECTION
        //N/A

        System.out.println(formatCard(surname, givenName, category, cardNum, birthCountry, termsAndConditions, sex, uscisNum, dateOfBirth, validDate, expireDate));
    }
    /**Formats a date properly
     * @param month integer for the month of the year
     * @param day integer for the day of the year
     * @param year integer for the year
     * @return returns a string with the date including slashes between numbers
     * @author Muhammad Conn
     */
        
    public static String formatDate(int month, int day, int year)
        {
            return(month + "/" + day + "/" + year);
        }
    /** Draws employment card with ascii art using format strings and includes provided parameters for personal info
     * @param surname string for the subject's last name,
     * @param givenName string for the subject's first name
     * @param category string for the subject's categorization 
     * @param cardNum string for the subject's card number
     * @param birthCountry string for the subject's country of origin
     * @param termsAndConditions string for special terms of the card
     * @param sex string for the subject's sex
     * @param uscisNum int for the subject's USCIS number
     * @param dateOfBirth string for the subject's date of birth
     * @param validDate string for the card's validity date
     * @param expireDate string for the card's expiry date
     * @return returns a formatted string displaying the card with ascii art and the provided info
     *      author Muhammad Conn
     */
    public static String formatCard(String surname, String givenName,
    String category, String cardNum, String birthCountry, 
    String termsAndConditions, char sex, String uscisNum, 
    String dateOfBirth, String validDate, String expireDate)
        {
            return(String.format("╔══════════════════════════════════════════════════════════════════════╗%n")+
                String.format("║%35s%35s║%n", Main.TITLE_USA, "")+
                String.format("║%60s%10s║%n", TITLE_EAC, "")+
                String.format("║%-25s%-45s║%n", "", LABEL_SURNAME)+
                String.format("║%-25s%-45s║%n", "", surname)+
                String.format("║%-25s%-45s║%n", Main.ASCII_ART_0, LABEL_GIVEN_NAME)+
                String.format("║%-25s%-45s║%n", Main.ASCII_ART_1, givenName)+
                String.format("║%-25s%-15s%-15s%-15s║%n", Main.ASCII_ART_2, LABEL_USCIS_NUM, LABEL_CATEGORY, LABEL_CARD_NUM)+
                String.format("║%-25s%-15s%-15s%-15s║%n", Main.ASCII_ART_3, uscisNum, category, cardNum)+
                String.format("║%-25s%-45s║%n", Main.ASCII_ART_4, LABEL_BIRTH_COUNTRY)+
                String.format("║%-25s%-45s║%n", Main.ASCII_ART_5, birthCountry)+
                String.format("║%-25s%-45s║%n", Main.ASCII_ART_6, LABEL_TERMS_CONDITIONS)+
                String.format("║%-25s%-45s║%n", Main.ASCII_ART_7, termsAndConditions)+
                String.format("║%-25s%-15s%-30s║%n", Main.ASCII_ART_8, LABEL_BIRTH_DATE, LABEL_SEX)+ 
                String.format("║%-25s%-15s%-30s║%n", Main.ASCII_ART_9, dateOfBirth, sex)+
                String.format("║%-25s%-15s%-30s║%n", "", LABEL_VALID_DATE, validDate)+
                String.format("║%-25s%-15s%-30s║%n", "", LABEL_EXPIRE_DATE, expireDate)+
                String.format("║%-25s%-45s║%n", Main.ASCII_CREDIT, LABEL_REENTRY_DISCLAIMER)+
                String.format("╚══════════════════════════════════════════════════════════════════════╝%n"));
        }
}
