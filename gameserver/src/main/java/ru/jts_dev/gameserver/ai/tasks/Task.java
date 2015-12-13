package ru.jts_dev.gameserver.ai.tasks;

import ru.jts_dev.gameserver.ai.AiObject;
import ru.jts_dev.gameserver.ai.AiVariablesHolder;
import ru.jts_dev.gameserver.ai.Weights;

/**
 * @author Java-man
 */
public abstract class Task {
    protected TaskState state;

    protected Task() {
    }

    public void start() {
        System.out.println(">>> Starting task: " + this.getClass().getSimpleName());
        this.state = TaskState.Running;
    }

    public abstract void reset();

    public abstract void act(AiObject aiObject, AiVariablesHolder aiVariablesHolder);

    protected void succeed() {
        System.out.println(">>> Task: " + this.getClass().getSimpleName() + " SUCCEEDED");
        this.state = TaskState.Success;
    }

    protected void fail() {
        System.out.println(">>> Task: " + this.getClass().getSimpleName() + " FAILED");
        this.state = TaskState.Failure;
    }

    public boolean isSuccess() {
        return state == TaskState.Success;
    }

    public boolean isFailure() {
        return state == TaskState.Failure;
    }

    public boolean isRunning() {
        return state == TaskState.Running;
    }

    public TaskState getState() {
        return state;
    }

    public boolean isMeetRequirements(final AiObject aiObject) {
        return true;
    }

    public int getWeight() {
        return Weights.NO_WEIGHT;
    }

    public enum TaskState {
        Success,
        Failure,
        Running
    }
}