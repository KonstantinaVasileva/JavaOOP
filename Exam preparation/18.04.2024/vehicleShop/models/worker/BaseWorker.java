package vehicleShop.models.worker;

import vehicleShop.models.tool.Tool;

import java.util.ArrayList;
import java.util.Collection;

import static vehicleShop.common.ExceptionMessages.WORKER_NAME_NULL_OR_EMPTY;
import static vehicleShop.common.ExceptionMessages.WORKER_STRENGTH_LESS_THAN_ZERO;

public abstract class BaseWorker implements Worker {
    private String name;
    private int strength;
    private Collection<Tool> tools;

    public BaseWorker(String name, int strength) {
        setName(name);
        setStrength(strength);
        this.tools = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(WORKER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setStrength(int strength) {
        if (strength < 0) {
            throw new IllegalArgumentException(WORKER_STRENGTH_LESS_THAN_ZERO);
        }
        this.strength = strength;
    }

    @Override
    public void working() {
        strength = Math.max(0, strength - 10);
    }

    @Override
    public void addTool(Tool tool) {
        tools.add(tool);
    }

    @Override
    public boolean canWork() {
        return strength > 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public Collection<Tool> getTools() {
        return tools;
    }
}
