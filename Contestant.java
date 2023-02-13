import java.lang.Math;
public class Contestant {

    private String name; // name of the contestant
    private double strength; // strength of the contestant
    private double health; // health of the contestant
    private boolean isAlive; // if the contestant is alive
    private double maxHealth; // maximum health of constestant

    public Contestant(String name, double strength, double health){
        this.name = name;
        this.strength = strength;
        this.health = health;
        this.isAlive = true;
        this.maxHealth = health;

    }
    // action functions
    public void die(){
        setAlive(false);
    }

    public void attack(Contestant otherPlayer, double multiplier){
        
        System.out.print(getName() + " --> ");
        otherPlayer.receiveDamage(this.strength * multiplier);
        
    }

    public void receiveDamage(Double damage){
        if (damage.equals(0.0)){
            System.out.println(name + ", but they missed! (" + +getHealth()+"/"+ getMaxHealth()+")");
        }
        else if (damage.equals(this.strength * 2.0)){
            setHealth(Math.floor((this.health - damage) * 10) / 10);
            System.out.println(name + " with a critical hit! (" + +getHealth()+"/"+ getMaxHealth()+")");
            
            
        }
        else{
        setHealth(Math.floor((this.health - damage) * 10) / 10);
        System.out.println(name + ", receiving " + Math.floor(damage*100)/100 + " damage! (" +getHealth()+"/"+ getMaxHealth()+")");
        }
        if (getHealth() <= 0.0){
            this.die();
            }
        
    }


    // getters and setters for attributes
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getStrength() {
        return strength;
    }
    public void setStrength(double strength) {
        this.strength = strength;
    }
    public double getHealth() {
        return health;
    }
    public void setHealth(double health) {
        this.health = health;
    }
    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
    public boolean getAlive(){
        return isAlive;
    }
    public double getMaxHealth() {
        return maxHealth;
    }
    public String toString(){
        return getName();
    }

}
