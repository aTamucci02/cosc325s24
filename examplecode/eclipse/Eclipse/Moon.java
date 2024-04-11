public class Moon extends CelestialBody {
    private CelestialBody earth;

    public Moon(CelestialBody earth, double orbitRadius) {
        super("Moon", orbitRadius);
        this.earth = earth;
    }

    @Override
    public void updatePosition() {
        angle += 0.03; // Increment angle for each day
        x = earth.getX() + orbitRadius * Math.cos(angle);
        y = earth.getY() + orbitRadius * Math.sin(angle);
    }
}
