import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class zombie extends Actor
{
    /**
     * Act - do whatever the zombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int animateImage = 0;
    int animateSpeed = 5;
    int count;
    int health = 2;
    couple couple;
    Counter counter;
    public zombie (couple mainCouple, Counter counter)
    {
        this.counter = counter;
        couple = mainCouple;
        setImage("skeleton-idle_16.png");
        getImage().scale(80,80);
    }
    public void act()
    {
        count++;
        animate();
        moveAround();
        hitbyProjectile();
    }
    public void animate ()
    {
    if(count % animateSpeed == 0)
        {
        if(animateImage > 16){
            animateImage = 0;
        }
            setImage("skeleton-move_" + animateImage + ".png");
            animateImage++;
            getImage().scale(80,80); 
        }
    }
    public void moveAround()
    {
        move(1);
        turnTowards(couple.getX(), couple.getY());
    }
    public void hitbyProjectile()
    {
        Actor projectile = getOneIntersectingObject(Projectile.class);
        if(projectile !=null)
        {
            health--;
            getWorld().removeObject(projectile);
        }
        if(health ==0)
        {
            counter.score++;
            counter.money+=5;
            getWorld().removeObject(this);
        }
    }
}

