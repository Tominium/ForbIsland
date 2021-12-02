import Graphics.MainMenuFrame;
import com.formdev.flatlaf.intellijthemes.FlatDraculaIJTheme;


public class Runner {
    public static void main(String args[]) {
        FlatDraculaIJTheme.setup();
        MainMenuFrame graphicWindow = new MainMenuFrame();
    }
}
