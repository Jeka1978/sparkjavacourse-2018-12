package heroes;

import java.util.List;
import java.util.Random;

/**
 * @author Evgeny Borisov
 */
public class DataFactory {
    private Random random = new Random();
    public Weapon getRandomWeapon(List<Weapon> weapons) {
        return weapons.get(random.nextInt(weapons.size()));
    }
}
