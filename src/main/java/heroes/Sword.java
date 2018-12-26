package heroes;

import org.springframework.stereotype.Component;

import static heroes.WeaponType.SHORT_DISTANCE;

/**
 * @author Evgeny Borisov
 */
@Component
@BrightArmy
public class Sword implements Weapon {
    @Override
    public void kick(Character owner, Character enemy) {
        System.out.println("Sword kick you");
    }

    @Override
    public WeaponType getType() {
        return SHORT_DISTANCE;
    }
}
