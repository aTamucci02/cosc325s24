import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create the main window (frame)
            JFrame frame = new JFrame("Space Simulation");

            // Create the EclipseDetector and SpaceSimulation instances
            EclipseDetector eclipseDetector = new EclipseDetector();
            SpaceSimulation simulation = new SpaceSimulation(eclipseDetector);

            // Setup the frame
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(simulation); // Add the simulation panel to the frame
            frame.pack(); // Size the frame to fit the preferred sizes of its components
            frame.setLocationRelativeTo(null); // Center the frame on the screen
            frame.setVisible(true); // Display the frame

            // Optionally start the simulation here or through user interaction in
            // SpaceSimulation
            simulation.startSimulation();
        });
    }
}
