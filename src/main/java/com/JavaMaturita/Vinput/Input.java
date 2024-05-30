package com.JavaMaturita.Vinput;

public class Input {
    private MouseInput mouseInput;
    private KeybdInput keybdInput;
    private HardwareInput hardwareInput;

    public Input(MouseInput mouseInput) {
        this.mouseInput = mouseInput;
    }

    public Input(KeybdInput keybdInput) {
        this.keybdInput = keybdInput;
    }

    public Input(HardwareInput hardwareInput) {
        this.hardwareInput = hardwareInput;
    }

    public KeybdInput getKeybdInput() {
        return keybdInput;
    }

    // Getters and setters can be added here if needed
}