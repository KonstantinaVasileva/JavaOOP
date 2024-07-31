package OOP.Polymorphism.Exercise.Calculator;

import java.util.Stack;

public class MS implements Operation{

    private Stack<Integer> memory;
    public MS(Stack<Integer> memory) {
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {
        memory.push(operand);
    }

    @Override
    public int getResult() {
        return memory.pop();
    }

    @Override
    public boolean isCompleted() {
        return false;
    }
}
