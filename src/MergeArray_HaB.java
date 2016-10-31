public class MergeArray_HaB{
    public static main (String[] args) {
        
    }
}

class Rectangle extends JComponent{
    int height = 0;
    int width = 0;
    static int incrementX = 150;
    int posX = 0;
    int posY = 100;
    Rectangle2D.Double rectangle;
    public Rectangle() {
        height = (int)(Math.random()*100+10);
        width = 25;
        rectangle = new Rectangle2D.Double( incrementX, posY, width, height);
        posX +=  incrementX + width + 10;
        
    }
    
    public Rectangle(int width, int height) {
        this.height = height;
        this.width = width;
        rectangle = new Rectangle2D.Double( incrementX, posY, width, height);
        posX += width + 10;
    }
    
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.GREEN);
        g2.fill(rectangle);
    }
    
    int newPosX = 0;
    public void move(int posX) {
        newPosX = posX;
        while (newPosX < posX) {
            new java.util.Timer().schedule(
                                           new java.util.TimerTask() {
                @Override
                public void run() {
                    toMove();
                }
            },
                                           1000
                                           );
        }
        
    }
    
    private void toMove() {
        System.out.println("Moving")
        posX+= 5;
        rectangle = new Rectangle2D.Double( posX, posY, width, height);
        
    }
    
    
    
    
    
}
