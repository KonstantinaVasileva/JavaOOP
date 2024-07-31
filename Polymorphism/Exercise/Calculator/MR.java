package OOP.Polymorphism.Exercise.Calculator;

import java.util.Stack;

public class MR implements Operation{
    private Stack<Integer> memory;

    public MR(Stack<Integer> memory) {
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {

    }

    @Override
    public int getResult() {
        return memory.pop();
    }

    @Override
    public boolean isCompleted() {
        return true;
    }
}
