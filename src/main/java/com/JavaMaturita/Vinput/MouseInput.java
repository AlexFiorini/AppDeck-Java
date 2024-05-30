package com.JavaMaturita.Vinput;

public class MouseInput {
    private int dx;
    private int dy;
    private int mouseData;
    private int dwFlags;
    private int time;
    private Object dwExtraInfo;

    public MouseInput(int dx, int dy, int mouseData, int dwFlags, int time, Object dwExtraInfo) {
        this.dx = dx;
        this.dy = dy;
        this.mouseData = mouseData;
        this.dwFlags = dwFlags;
        this.time = time;
        this.dwExtraInfo = dwExtraInfo;
    }

    // Getters and setters can be added here if needed
}