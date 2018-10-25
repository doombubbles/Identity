package net;

import net.Visuals.Player;
import net.Visuals.VisualObject;

public class MovementLogic {

    public static boolean wouldOverlap(Player player, int dX, int dY, VisualObject visualObject) {
        return wouldOverlap(player, dX, dY, visualObject, false);
    }

    public static boolean wouldOverlap(Player player, int dX, int dY, VisualObject visualObject, boolean ignoreSolid) {
        if (!ignoreSolid && !visualObject.solid) {
            return false;
        }

        int newPlayerX = player.x + dX;
        int newPlayerY = player.y + dY;

        int spaceBetweenX = Math.abs(newPlayerX - visualObject.x);
        int spaceBetweenY = Math.abs(newPlayerY - visualObject.y);

        if (spaceBetweenX < (player.width + visualObject.width) / 2 &&
                spaceBetweenY < (player.height + visualObject.height) / 2) {
            return true;
        }
        return false;
    }


}
