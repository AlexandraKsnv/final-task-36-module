package org.example;

public class TestParameterDto {
    private String elementXpath;
    private String expectedTitle;
    private String expectedUrl;

    public TestParameterDto(String elementXpath, String expectedTitle, String expectedUrl) {
        this.elementXpath = elementXpath;
        this.expectedTitle = expectedTitle;
        this.expectedUrl = expectedUrl;
    }

    public String getElementXpath() {
        return elementXpath;
    }

    public String getExpectedTitle() {
        return expectedTitle;
    }

    public String getExpectedUrl() {
        return expectedUrl;
    }

    @Override
    public String toString() {
        return "TestParameterDto{" +
                "elementXpath='" + elementXpath + '\'' +
                ", expectedTitle='" + expectedTitle + '\'' +
                ", expectedUrl='" + expectedUrl + '\'' +
                '}';
    }
}
