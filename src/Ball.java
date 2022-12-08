import java.awt.*;

public class Ball {

    private int x; int y; int width; int height;

    private double velocityX, velocityY, velocity1D;

    private double launchVelocityX, launchVelocityY, launchVelocity1D;

    public int initialPosX, initialPosY;
    public int mouseX, mouseY;
    public boolean canMove = false;

    public Ball(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    int count = 0;
    public void updatePos(){
        if (canMove){

            if (count == 0){//Make sure this portion only runs after mouse release
                count = 1;
                //Calculate starting velocity of the ball
                velocityX = (double) (mouseX - initialPosX)/-10;
                velocityY = (double) (mouseY - initialPosY)/-10;
                launchVelocityX = velocityX;
                launchVelocityY = velocityY;
                //Convert to a number using Pythagorean theory
                velocity1D = Math.sqrt(Math.pow(velocityX, 2) + Math.pow(velocityY, 2));
                if (velocity1D > 1) velocity1D = 1; //Cap velocity at 1
                launchVelocity1D = velocity1D;
            }

            //Calculate direction of the ball (down = +, up = -)
            double dirX = velocityX / Math.abs(velocityX);
            double dirY = velocityY / Math.abs(velocityY);

            //Subtract the friction from the velocity
            float friction = 0.007f;
            velocity1D = velocity1D - friction;
            //Check if the ball has stopped
            if (!(velocity1D > 0)){
                velocity1D = 0;
                velocityX = 0;
                velocityY = 0;
                reset();
            } else {
                //Calculate new velocity after adding friction
                velocityX = (velocity1D/launchVelocity1D) * Math.abs(launchVelocityX) * dirX;
                velocityY = (velocity1D/launchVelocity1D) * Math.abs(launchVelocityY) * dirY;
            }
            //Check for collisions (yes it's lazy but I'm tired)
            if (x+velocityX < 0 || x+width+velocityX>1000){
                velocityX = -velocityX;
            }
            else if (y+velocityY < 0 || y+height+velocityY>=1000){
                velocityY = -velocityY;
            }

            x += velocityX;
            y += velocityY;
        }
    }

    public void reset(){
        canMove = false;
        count = 0;
    }

    public void draw(Graphics g){
        g.fillOval(x, y, width, height);
    }


}
