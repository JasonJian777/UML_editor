package editor_mode;

import java.awt.event.MouseEvent;
import editor_line.AsscociationLine;

public class AsscociationMode extends BaseLineMode {
    @Override
    public void myMouseReleased(MouseEvent e) {
        super.myMouseReleased(e);
        if (canCreatLine()) {
            canvas.lineList.add(new AsscociationLine(startPort, endPort));
        }
    }

    @Override
    public String re() {
        return "Asscociation Mode";
    }
}
