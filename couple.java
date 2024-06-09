import greenfoot.*; 
import lang.stride.*;
import java.util.*;

/**
 * Write a description of class couple here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class couple extends Actor
{
    /**
     * Act - do whatever the couple wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed = 3;
    int time = 0;
    WeaponButton weaponButton;
    SuperPower superPower;
    int superTimer;
    public couple()
    {
        getImage().scale(80,69);
    }
    public couple(WeaponButton weaponButton, SuperPower superPower)
    {
        this.superPower = superPower;
        this.weaponButton = weaponButton;
        getImage().scale(80,69);
    }
    public void act()
    {
        time++;
        turnAround();
        moveAround();
        fireProjectile();
        hitByZombie();
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        superPowerUsed();
        //setLocation(myWorld.getPlayer().getX()-5, myWorld.getPlayer().getY()-50);
        if(hitByHouse()){
            getWorld().showText("You Win! \n You survived for "+(myWorld.getPlayer().time/60)+" seconds", getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }
    public void turnAround()
    {
        if(Greenfoot.getMouseInfo() !=null)
        turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
    }
    public void moveAround()
    {
        if(Greenfoot.getMouseInfo() !=null)
        turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
        if(Greenfoot.isKeyDown("w"))
        setLocation(getX(),getY() - speed);
        if(Greenfoot.isKeyDown("a"))
        setLocation(getX() - speed, getY());
        if(Greenfoot.isKeyDown("s"))
        setLocation(getX(),getY() + speed);
        if(Greenfoot.isKeyDown("d"))
        setLocation(getX() + speed, getY());
    }
    public void fireProjectile()
    {
        if(Greenfoot.isKeyDown("space") && weaponButton.weaponUpgrade == 1) {
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation());
            projectile.move(25);

        }
        if(Greenfoot.isKeyDown("space") && weaponButton.weaponUpgrade == 2) {
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation() - 10);
            projectile.move(20);
            Projectile projectile2 = new Projectile();
            getWorld().addObject(projectile2, getX(), getY());
            projectile2.setRotation(getRotation() + 10);
            projectile2.move(20);
        }
        if(Greenfoot.isKeyDown("space") && weaponButton.weaponUpgrade == 3) {
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation() - 10);
            projectile.move(20);
            Projectile projectile2 = new Projectile();
            getWorld().addObject(projectile2, getX(), getY());
            projectile2.setRotation(getRotation() + 10);
            projectile2.move(20);
            Projectile projectile3 = new Projectile();
            getWorld().addObject(projectile3, getX(), getY());
            projectile3.setRotation(getRotation());
            projectile3.move(20);
        }
    }
    public void superPowerUsed()
    {
        if(superPower.superCount > 99 && superTimer < 30)
        {
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation() - 60);
            projectile.move(20);
            Projectile projectile2 = new Projectile();
            getWorld().addObject(projectile2, getX(), getY());
            projectile2.setRotation(getRotation() + 60);
            projectile2.move(20);
            Projectile projectile3 = new Projectile();
            getWorld().addObject(projectile3, getX(), getY());
            projectile3.setRotation(getRotation());
            projectile3.move(20);
            Projectile projectile1 = new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            projectile1.setRotation(getRotation() - 180);
            projectile1.move(20);
            Projectile projectile21 = new Projectile();
            getWorld().addObject(projectile2, getX(), getY());
            projectile21.setRotation(getRotation() + 120);
            projectile21.move(20);
            Projectile projectile31 = new Projectile();
            getWorld().addObject(projectile3, getX(), getY());
            projectile31.setRotation(getRotation() - 120);
            projectile31.move(20);
            superTimer++;
        }
        if(superTimer>29)
        {
            superPower.superCount = 0;
        }
    }
    public boolean hitByZombie()
    {
        Actor zombie = getOneObjectAtOffset(0,0, zombie.class);
        if(zombie!=null)
        {
            return true;
        }
        else
        return false;
    }
    public boolean hitByHouse()
    {
        Actor house = getOneObjectAtOffset(0, 0, House.class);
        return house != null;
    }
    
}