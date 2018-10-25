package net.Visuals;

import java.util.ArrayList;
import java.util.List;

public class VisualObjectGroup extends ArrayList<VisualObject> {

    public void changePos(int dX, int dY) {
        for (VisualObject visualObject : this) {
            visualObject.x += dX;
            visualObject.y += dY;
        }
    }

    public void addTo(List<VisualObject> placeToAddTo) {
        for (VisualObject visualObject : this) {
            placeToAddTo.add(visualObject);
        }
    }

}
