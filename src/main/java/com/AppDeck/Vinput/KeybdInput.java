package com.AppDeck.Vinput;

public class KeybdInput {
    private int wVk;
    private int wScan;
    private int dwFlags;
    private int time;
    private Object dwExtraInfo;

    public KeybdInput(int wVk, int wScan, int dwFlags, int time, Object dwExtraInfo) {
        this.wVk = wVk;
        this.wScan = wScan;
        this.dwFlags = dwFlags;
        this.time = time;
        this.dwExtraInfo = dwExtraInfo;
    }

    public int getwVk() {
        return wVk;
    }

    public int getwScan() {
        return wScan;
    }

    public int getDwFlags() {
        return dwFlags;
    }

    public int getTime() {
        return time;
    }

    public Object getDwExtraInfo() {
        return dwExtraInfo;
    }
}