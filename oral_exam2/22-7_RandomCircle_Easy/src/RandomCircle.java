import javax.swing.*;
import java.awt.*;

/**
 * The class to represent RandomCircle JFrame and functions
 * @see RandomCircle
 */
public class RandomCircle extends JFrame {
    /**
     * Constructor to initiate and draw random size circle
     */
    public RandomCircle() {
        super("Random Circle");
        JTextArea circleInfo = new JTextArea();
        Circle circle = new Circle();
        circleInfo.setText("The Radius is: " + circle.getRadius() + "\nThe Diameter is: " + circle.getDiameter() + "\nThe Circumference is: " + circle.getCircumference() + "\n The Area is: " + circle.getArea());
        add(circle, BorderLayout.CENTER);
        add(circleInfo, BorderLayout.SOUTH);
    }


    /**
     * Subclass of the RandomCircle to draw a circle
     *
     * @see Circle
     */
    static class Circle extends JPanel {
        /**
         * Stores the radius of the Circle
         */
        private int radius;

        /**
         * Stores the diameter of the Circle
         */
        private int diameter;

        /**
         * Stores the circumference of the Circle
         */
        private int circumference;

        /**
         * Stores the area of the Circle
         */
        private int area;

        /**
         * Constructor to generate a random circle and draws circle Jpanel
         */
        public Circle() {
            radius = (int) (1 + Math.random() * 200);
            diameter = radius * 2;
            circumference = (int) (2 * Math.PI * radius);
            area = (int) (Math.PI * radius * radius);
            setSize(200, 200);
        }

        /**
         * Draws the circle
         * @param g Abstract Graphics class
         */
        public void paintComponent(Graphics g) {
            g.drawOval(0, 0, radius, radius);
            g.setColor(Color.CYAN);
            g.fillOval(0, 0, radius, radius);
        }

        /**
         * Access the circle radius
         *
         * @return radius
         */
        public int getRadius() {
            return radius;
        }

        /**
         * Access the circle diameter
         *
         * @return diameter
         */
        public int getDiameter() {
            return diameter;
        }

        /**
         * Access the circle circumference
         *
         * @return circumference
         */
        public int getCircumference() {
            return circumference;
        }

        /**
         * Access the circle area
         *
         * @return area
         */
        public int getArea() {
            return area;
        }
    }
}

