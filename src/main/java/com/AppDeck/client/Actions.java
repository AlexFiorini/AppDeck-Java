package com.AppDeck.client;

import java.io.IOException;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.platform.win32.BaseTSD.ULONG_PTR;
import com.AppDeck.Vinput.Input;
import com.AppDeck.Vinput.KeybdInput;

import static com.AppDeck.Vinput.InputConstants.*;

public class Actions {

    public static void startApp(String path) throws IOException {
        if(!isProcessRunning(path)) {
            Runtime.getRuntime().exec(path);
        } else {
            maximizeWindow(path);
        }

    }

    public static void maximizeWindow(String windowTitle) {
        User32 user32 = User32.INSTANCE;
        WinDef.HWND hwnd = user32.FindWindow(null, windowTitle);
        if (hwnd != null) {
            user32.ShowWindow(hwnd, User32.SW_MAXIMIZE);
            user32.SetForegroundWindow(hwnd);
        }
    }

    public static boolean isProcessRunning(String processName) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("tasklist");
        Process process = processBuilder.start();
        try (java.util.Scanner scanner = new java.util.Scanner(process.getInputStream())) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(processName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void mediaAction(Button button) throws IllegalArgumentException {
        int action;
        switch (button.getAction()) {
            case "VolumeUp":
                action=VK_VOLUME_UP;
                break;
            case "VolumeDown":
                action=VK_VOLUME_DOWN;
                break;
            case "VolumeMute":
                action=VK_VOLUME_MUTE;
                break;
            case "PlayPause":
                action=VK_MEDIA_PLAY_PAUSE;
                break;
            case "Skip":
                action=VK_MEDIA_NEXT_TRACK;
                break;
            case "Previous":
                action=VK_MEDIA_PREV_TRACK;
                break;
            default:
                throw new IllegalArgumentException("Errore");
        }
        KeybdInput keybdInput = createKeybdInput(action, 0);
        sendInput(createKeyboard(keybdInput.getwVk(), keybdInput.getDwFlags()));
    }

    public static void sendInput(Input input) {
        User32 user32 = User32.INSTANCE;
        WinUser.INPUT inputStruct = new WinUser.INPUT();
        inputStruct.type = new WinDef.DWORD(WinUser.INPUT.INPUT_KEYBOARD);

        if (input.getKeybdInput() != null) {
            KeybdInput keybdInput = input.getKeybdInput();
            inputStruct.input.setType("ki");
            inputStruct.input.ki.wVk = new WinDef.WORD(keybdInput.getwVk());
            inputStruct.input.ki.dwFlags = new WinDef.DWORD(keybdInput.getDwFlags());
            inputStruct.input.ki.time = new WinDef.DWORD(0);
            inputStruct.input.ki.dwExtraInfo = new ULONG_PTR(0);

            user32.SendInput(new WinDef.DWORD(1), (WinUser.INPUT[]) inputStruct.toArray(1), inputStruct.size());
        }
    }
}
