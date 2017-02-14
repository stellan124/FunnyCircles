import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;


public class CircleGroup {
	private ArrayList<Circle> ray = new ArrayList<Circle>();
	private Point followPoint = new Point(0,0);
	public CircleGroup(){
		
	}
	
	public CircleGroup(int n){
		addRandomCircles(n);
	}
	
	public void addRandomCircle(){
		Color random = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
		ray.add(new Circle(Math.random()*1920,Math.random()*1080,Math.random()*3+.3,random));
	}
	
	public void addRandomCircles(int num){
		for(int i = 0;i < num;i++){
			addRandomCircle();
		}
	}
	
	public void addRandomCircle(int num, double s){
		for(int i = 0; i < num; i++){
			Color random = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
			ray.add(new Circle(Math.random()*1920,Math.random()*1080,s,random));
		}
	}

	public void stayOutOfCircle(Circle obj){
		for(int i = 0;i < ray.size();i++){
			if(ray.get(i).collide(obj)){
				ray.get(i).setPos(Math.random()*1920,Math.random()*1080);
			}
		}
	}
	
	public void setGroupSpeed(double s){
		for(int i = 0; i < ray.size();i++){
			ray.get(i).setSpeed(s);
		}
	}
	
	public void followPoint(int mouseX, int mouseY){
		followPoint.x = mouseX;
		followPoint.y = mouseY;
	}
	
	public void moveGroup(){
		for(int i = 0; i < ray.size();i++){
			ray.get(i).move();
			ray.get(i).followPlayer(followPoint.x, followPoint.y);
		}
	}
	
	public void drawGroup(Graphics window){
		for(int i = 0;i < ray.size();i++){
			ray.get(i).draw(window);
		}
	}
}
