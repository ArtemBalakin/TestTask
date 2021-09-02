package Fonts;
/**
 * @author Artem Balakin (03.09.2021)
 * Перечисление шрифтов
 */

public enum FontNames {
    TIMES_NEW_ROMAN("Times New Roman"),
    ARIAL("Arial"),
    CALIBRI("Calibri");

    private final String fontName;

     FontNames(String fontName) {
        this.fontName = fontName;
    }

    public String getFontName() {
        return fontName;
    }
}
