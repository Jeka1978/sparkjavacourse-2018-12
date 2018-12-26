package heroes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static heroes.WeaponType.LONG_DISTANCE;
import static heroes.WeaponType.SHORT_DISTANCE;

/**
 * @author Evgeny Borisov
 */
@Service
@Scope("prototype")
public class Elf implements Character {
    private int distance = 3;
    private Map<WeaponType, List<Weapon>> weapons;
    private Weapon currentWeapon;
    private DataFactory dataFactory = new DataFactory();


    @Autowired
    @BrightArmy
    public Elf(List<Weapon> weapons) {
        this.weapons = weapons.stream().collect(Collectors.groupingBy(Weapon::getType));
        this.currentWeapon = dataFactory.getRandomWeapon(this.weapons.get(LONG_DISTANCE));
    }

    @Override
    public void fight(Character enemy) {

        currentWeapon.kick(this, enemy);
        if (distance > 0) {
            currentWeapon = dataFactory.getRandomWeapon(this.weapons.get(LONG_DISTANCE));
        } else {
            currentWeapon = dataFactory.getRandomWeapon(this.weapons.get(SHORT_DISTANCE));
        }
        distance--;

    }
}
