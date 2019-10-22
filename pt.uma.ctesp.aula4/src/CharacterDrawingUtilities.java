public class CharacterDrawingUtilities {
    public static void drawElement(char character) {
        System.out.print(character);
    }

    public static void drawNewLine() {
        System.out.println("");
    }

    public static void drawHorizontalSegmentWith(char character, int line) {
        for (int i = 0; i < line; i++) {
            drawElement(character);
        }
    }

    public static void drawFilledRectangleWith(char character, int height, int width) {
        for (int i = 0; i < height; i++) {
            drawHorizontalSegmentWith(character, width);
            drawNewLine();
        }
    }

    public static void drawEmptyRectangleWith(char character, int height, int width) {
        for (int i = 0; i < height; i++) {
            if (i == 0 || i == height - 1) {
                drawHorizontalSegmentWith(character, width);
                drawNewLine();
            } else {
                drawElement(character);
                drawHorizontalSegmentWith(' ', width - 2);
                drawElement(character);
                drawNewLine();
            }
        }
    }
}
