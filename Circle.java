import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


public class Circle {
	private double x = 500;
	private double y = 500;
	private double s = .5;
	private double direction = 85;
	private Color col = Color.red;
	private int radius = 30;
	
	public Circle(){
		
	}
	public Circle(double xPos, double yPos,double speed){
		x = xPos;
		y = yPos;
		s = speed;
	}
	
	public Circle(double xPos, double yPos,double speed,Color c){
		x = xPos;
		y = yPos;
		s = speed;
		col = c;
	}
	
	public Point getCenter(){
		Point c = new Point();
		c.x = (int)x+(radius/2);
		c.y = (int)y+(radius/2);
		return c;
	}
	
	public int getRadius(){
		return radius;
	}
	
	public boolean collide(Circle obj){
		if(getCenter().distance(obj.getCenter()) > obj.getRadius()+getRadius()){
			return false;
		}
		return true;
	}
	public void setSpeed(double speed){
		s = speed;
	}
	
	public void setPos(double xPos, double yPos){
		x = xPos;
		y = yPos;
	}
	
	public void move() {
		y += Math.sin(Math.toRadians(360-direction)) * s;
		x += Math.cos(Math.toRadians(360-direction)) * s;
	}
	public void followPlayer(double mouseX, double mouseY){
		double deltaY = mouseY - y;
		double deltaX = mouseX - x;
		direction = 360 - Math.atan2(deltaY, deltaX) * 180 / Math.PI;
	}
	public void draw(Graphics window){
		window.setColor(col);
		window.fillOval((int)x, (int)y, radius, radius);
	}

}
