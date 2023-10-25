package components.composite;

import java.util.ArrayList;
import java.util.List;

public class BigBump implements BumpComponent {
    private List<BumpComponent> components = new ArrayList<>();
    private int hitChance = 70;
    private int points = 40;

    public void addComponent(BumpComponent bumpComponent) {
        components.add(bumpComponent);
    }

    @Override
    public void hit() {

    }

    @Override
    public int getHitChance() {
        return 0;
    }

    @Override
    public int calculatePoints() {
        int result = this.points;
        for (BumpComponent component: components) {
            result += component.calculatePoints();
        }
        return result;
    }
}