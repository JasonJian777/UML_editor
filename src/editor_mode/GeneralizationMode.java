package editor_mode;

import java.awt.event.MouseEvent;
import editor_line.GeneralizationLine;

public class GeneralizationMode extends BaseLineMode {
    @Override
    public void myMouseReleased(MouseEvent e) {
        super.myMouseReleased(e);
        if (canCreatLine()) {
            canvas.lineList.add(new GeneralizationLine(startPort, endPort));
        }
    }

    @Override
    public String re() {
        return "Generalization Mode";
    }
}
