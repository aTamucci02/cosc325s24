public class EclipseDetector {
    private CelestialBody sun;
    private CelestialBody earth;
    private CelestialBody moon;

    public EclipseDetector() {
        sun = new Sun(0); // Sun at the center
        earth = new Earth(200);
        moon = new Moon(earth, 50);
    }

    public void simulateOneDay() {
        earth.updatePosition();
        moon.updatePosition();
        // Add logic to detect alignment for eclipse
    }

    public CelestialBody getSun() {
        return sun;
    }

    public CelestialBody getEarth() {
        return earth;
    }

    public CelestialBody getMoon() {
        return moon;
    }

    // Method to check alignment for eclipse
    public boolean checkForEclipse() {
        // Simplified logic to check for eclipse
        return Math.abs(earth.getX() - moon.getX()) < 10 && Math.abs(earth.getY() - moon.getY()) < 10;
    }
}
