package editor_mode;

import java.awt.event.MouseEvent;
import editor_line.CompositionLine;

public class CompositionMode extends BaseLineMode {
    @Override
    public void myMouseReleased(MouseEvent e) {
        super.myMouseReleased(e);
        if (canCreatLine()) {
            canvas.lineList.add(new CompositionLine(startPort, endPort));
        }
    }

    @Override
    public String re() {
        return "Composition Mode";
    }
}
