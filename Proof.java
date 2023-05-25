package Proof;

import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.methods.walking.impl.Walking;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;

@ScriptManifest(category = Category.MISC, name = "Proof", author = "f4i13rr0r", version = 0)
public class Proof extends AbstractScript {
    @Override
    public void onStart() {
    }

    @Override
    public int onLoop() {
        final Area Draynor = new Area(
                new Tile(3092, 3240, 0),
                new Tile(3097, 3240, 0),
                new Tile(3097, 3246, 0),
                new Tile(3092, 3246, 0));
        final Area Lumbridge = new Area(
                new Tile(3218, 3216, 0),
                new Tile(3224, 3216, 0),
                new Tile(3224, 3221, 0),
                new Tile(3218, 3221, 0));

        while (!Draynor.contains(Players.getLocal())) {
            if (Lumbridge.contains(Players.getLocal())) {
                Walking.walk(Draynor.getRandomTile());
                sleep(1000,9000);
            } else {
                while (!Lumbridge.contains(Players.getLocal())) {
                    if (!Draynor.contains(Players.getLocal())) {
                        Walking.walk(Draynor.getRandomTile());
                        sleep(1000, 9000);
                    } else {
                        break;
                    }
                }
            }
        }
        while (!Lumbridge.contains(Players.getLocal())) {
            if (Draynor.contains(Players.getLocal())) {
                Walking.walk(Lumbridge.getRandomTile());
                sleep(11000,13000);
                while (!Draynor.contains(Players.getLocal())) {
                    if (Lumbridge.contains(Players.getLocal())) {
                        sleep(11000,13000);
                        break;
                    } else {
                        Walking.walk(Lumbridge.getRandomTile());
                        sleep(1000, 9000);
                    }
                }
            }
        }
        return 0;
    }

    @Override
    public void onExit() {
    }
}
