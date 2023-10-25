package components.composite;

public interface BumpComponent {
    void hit();
    int getHitChance();
    int calculatePoints();
}