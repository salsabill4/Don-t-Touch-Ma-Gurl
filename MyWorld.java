import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class MyWorld extends World
{
    int count = 0;
    int spawnSpeed = 30;
    int randomSpawn = Greenfoot.getRandomNumber(8);
    public couple mainCouple = new couple();
    Counter counter = new Counter();
    HealthBar healthbar = new HealthBar();
    WeaponButton weaponButton = new WeaponButton(counter);
    House house = new House();
    SuperPower superPower = new SuperPower();
    /**
     * Constructor for objects of class MyWorld.
     */
    public MyWorld()
    {
        super(900, 600, 1);
        mainCouple = new couple(weaponButton, superPower);
        addObject(mainCouple, 850, 500);
        addObject(counter, 100,70);
        addObject(healthbar, mainCouple.getX()-5, mainCouple.getY()-50);
        addObject(weaponButton, 800, 100);
        addObject(house, 50, 200);
        addObject(superPower, mainCouple.getX() + 10, mainCouple.getY() - 80);
    }
    public couple getPlayer()
    {
        return mainCouple;
    }
    public void act()
    {
        count++;
        if(count % 600 == 0)
        {
            spawnSpeed--;
        }
        while(Greenfoot.isKeyDown("p")){
            Greenfoot.delay(1);
        }
        spawnZombie();
        
        }
    public void spawnZombie() {
     if (count % spawnSpeed == 0)
        {
        randomSpawn = Greenfoot.getRandomNumber(8);
        switch(randomSpawn) {
            case 0 : addObject(new zombie(mainCouple, counter), 0, 0); break;
            case 1 : addObject(new zombie(mainCouple, counter), getWidth()/2, 0); break;
            case 2 : addObject(new zombie(mainCouple, counter), getWidth(), 0); break;
            case 3 : addObject(new zombie(mainCouple, counter), 0, getHeight()/2); break;
            case 4 : addObject(new zombie(mainCouple, counter), getWidth(), getHeight()/2); break;
            case 5 : addObject(new zombie(mainCouple, counter), 0,getHeight() ); break;
            case 6 : addObject(new zombie(mainCouple, counter), getWidth()/2, getHeight()); break;
            case 7 : addObject(new zombie(mainCouple, counter), getWidth(), getHeight()); break;
        }
    }
}
}


