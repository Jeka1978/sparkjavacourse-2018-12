package heroes;

import org.springframework.stereotype.Component;

import static heroes.WeaponType.SHORT_DISTANCE;

/**
 * @author Evgeny Borisov
 */
@Component
@BrightArmy
@DarkArmy
public class Knife implements Weapon {
    @Override
    public void kick(Character owner, Character enemy) {
        System.out.println("Knife kick you");
    }

    @Override
    public WeaponType getType() {
        return SHORT_DISTANCE;
    }
}
