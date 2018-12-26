package heroes;

import org.springframework.stereotype.Component;

import static heroes.WeaponType.LONG_DISTANCE;

/**
 * @author Evgeny Borisov
 */
@Component
@BrightArmy
public class Bow implements Weapon {
    @Override
    public void kick(Character owner, Character enemy) {
        System.out.println("Bow kick you");
    }

    @Override
    public WeaponType getType() {
        return LONG_DISTANCE;
    }
}
