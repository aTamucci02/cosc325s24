import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpaceSimulation extends JPanel implements ActionListener {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private Timer timer;
    private EclipseDetector eclipseDetector;
    private int days = 0;

    public SpaceSimulation(EclipseDetector eclipseDetector) {
        this.eclipseDetector = eclipseDetector;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        timer = new Timer(100, this);

        JButton playButton = new JButton("Play");
        JButton pauseButton = new JButton("Pause");

        playButton.addActionListener(e -> startSimulation());
        pauseButton.addActionListener(e -> stopSimulation());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(playButton);
        buttonPanel.add(pauseButton);

        // Ensure the simulation area itself is not affected by the layout of the
        // buttons
        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void startSimulation() {
        timer.start();
    }

    public void stopSimulation() {
        timer.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateSimulation();
        repaint();
    }

    private void updateSimulation() {
        eclipseDetector.simulateOneDay();
        days++;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawSimulation(g);
        drawDaysCounter(g);
    }

    private void drawSimulation(Graphics g) {
        // Assuming getSun(), getEarth(), and getMoon() are available in EclipseDetector
        CelestialBody sun = eclipseDetector.getSun();
        CelestialBody earth = eclipseDetector.getEarth();
        CelestialBody moon = eclipseDetector.getMoon();

        // Draw Sun
        int sunX = WIDTH / 2 + (int) sun.getX();
        int sunY = HEIGHT / 2 + (int) sun.getY();
        g.setColor(Color.YELLOW);
        g.fillOval(sunX - 25, sunY - 25, 50, 50);

        // Draw Earth
        int earthX = WIDTH / 2 + (int) earth.getX();
        int earthY = HEIGHT / 2 + (int) earth.getY();
        g.setColor(Color.BLUE);
        g.fillOval(earthX - 10, earthY - 10, 20, 20);

        // Draw Moon
        int moonX = WIDTH / 2 + (int) moon.getX();
        int moonY = HEIGHT / 2 + (int) moon.getY();
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(moonX - 5, moonY - 5, 10, 10);
    }

    private void drawDaysCounter(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawString("Day: " + days, 10, 20);
    }
}
