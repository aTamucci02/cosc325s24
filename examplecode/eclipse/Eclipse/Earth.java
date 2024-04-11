public class Earth extends CelestialBody {
    public Earth(double orbitRadius) {
        super("Earth", orbitRadius);
    }

    @Override
    public void updatePosition() {
        angle += 0.01; // Increment angle for each day
        x = orbitRadius * Math.cos(angle);
        y = orbitRadius * Math.sin(angle);
    }
}
