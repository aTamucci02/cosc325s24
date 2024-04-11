public class Sun extends CelestialBody {
    public Sun(double orbitRadius) {
        super("Sun", orbitRadius);
    }

    @Override
    public void updatePosition() {
        // Sun's position remains constant in this model
    }
}
