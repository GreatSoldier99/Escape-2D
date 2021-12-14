import greenfoot.*;

/**
 * WeaponFactory. Esta clase administra la creación de armas utilizadas por los personajes jugables y no-jugables.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WeaponFactory extends Actor{
    
    public static Weapon buildWeapon(String weapon, int direction, int keyWeapon){
        switch(weapon){
            case "Pistol":
                return new Pistol(direction, keyWeapon);
            case "AssaultRifle":
                return new AssaultRifle(direction, keyWeapon); 
            default:
                return null;
        }
    }
}