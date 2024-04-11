public abstract class CelestialBody {
    protected String name;
    protected double x, y; // Position in 2D space
    protected double orbitRadius;
    protected double angle;

    public CelestialBody(String name, double orbitRadius) {
        this.name = name;
        this.orbitRadius = orbitRadius;
        this.x = 0;
        this.y = 0;
        this.angle = 0;
    }

    public abstract void updatePosition();

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
