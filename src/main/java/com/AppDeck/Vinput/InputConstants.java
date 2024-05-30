package com.AppDeck.Vinput;

public class InputConstants {
    public static final int WHEEL_DELTA = 120;
    public static final int XBUTTON1 = 0x0001;
    public static final int XBUTTON2 = 0x0002;
    public static final int MOUSEEVENTF_ABSOLUTE = 0x8000;
    public static final int MOUSEEVENTF_HWHEEL = 0x01000;
    public static final int MOUSEEVENTF_MOVE = 0x0001;
    public static final int MOUSEEVENTF_MOVE_NOCOALESCE = 0x2000;
    public static final int MOUSEEVENTF_LEFTDOWN = 0x0002;
    public static final int MOUSEEVENTF_LEFTUP = 0x0004;
    public static final int MOUSEEVENTF_RIGHTDOWN = 0x0008;
    public static final int MOUSEEVENTF_RIGHTUP = 0x0010;
    public static final int MOUSEEVENTF_MIDDLEDOWN = 0x0020;
    public static final int MOUSEEVENTF_MIDDLEUP = 0x0040;
    public static final int MOUSEEVENTF_VIRTUALDESK = 0x4000;
    public static final int MOUSEEVENTF_WHEEL = 0x0800;
    public static final int MOUSEEVENTF_XDOWN = 0x0080;
    public static final int MOUSEEVENTF_XUP = 0x0100;

    public static final int VK_LBUTTON = 0x01;              // Left mouse button
    public static final int VK_RBUTTON = 0x02;              // Right mouse button
    public static final int VK_CANCEL = 0x03;               // Control-break processing
    public static final int VK_MBUTTON = 0x04;              // Middle mouse button (three-button mouse)
    public static final int VK_XBUTTON1 = 0x05;             // X1 mouse button
    public static final int VK_XBUTTON2 = 0x06;             // X2 mouse button
    public static final int VK_BACK = 0x08;                 // BACKSPACE key
    public static final int VK_TAB = 0x09;                  // TAB key
    public static final int VK_CLEAR = 0x0C;                // CLEAR key
    public static final int VK_RETURN = 0x0D;               // ENTER key
    public static final int VK_SHIFT = 0x10;                // SHIFT key
    public static final int VK_CONTROL = 0x11;              // CTRL key
    public static final int VK_MENU = 0x12;                 // ALT key
    public static final int VK_PAUSE = 0x13;                // PAUSE key
    public static final int VK_CAPITAL = 0x14;              // CAPS LOCK key
    public static final int VK_KANA = 0x15;                 // IME Kana mode
    public static final int VK_HANGUL = 0x15;               // IME Hangul mode
    public static final int VK_JUNJA = 0x17;                // IME Junja mode
    public static final int VK_FINAL = 0x18;                // IME final mode
    public static final int VK_HANJA = 0x19;                // IME Hanja mode
    public static final int VK_KANJI = 0x19;                // IME Kanji mode
    public static final int VK_ESCAPE = 0x1B;               // ESC key
    public static final int VK_CONVERT = 0x1C;              // IME convert
    public static final int VK_NONCONVERT = 0x1D;           // IME nonconvert
    public static final int VK_ACCEPT = 0x1E;               // IME accept
    public static final int VK_MODECHANGE = 0x1F;           // IME mode change request
    public static final int VK_SPACE = 0x20;                // SPACEBAR
    public static final int VK_PRIOR = 0x21;                // PAGE UP key
    public static final int VK_NEXT = 0x22;                 // PAGE DOWN key
    public static final int VK_END = 0x23;                  // END key
    public static final int VK_HOME = 0x24;                 // HOME key
    public static final int VK_LEFT = 0x25;                 // LEFT ARROW key
    public static final int VK_UP = 0x26;                   // UP ARROW key
    public static final int VK_RIGHT = 0x27;                // RIGHT ARROW key
    public static final int VK_DOWN = 0x28;                 // DOWN ARROW key
    public static final int VK_SELECT = 0x29;               // SELECT key
    public static final int VK_PRINT = 0x2A;                // PRINT key
    public static final int VK_EXECUTE = 0x2B;              // EXECUTE key
    public static final int VK_SNAPSHOT = 0x2C;             // PRINT SCREEN key
    public static final int VK_INSERT = 0x2D;               // INS key
    public static final int VK_DELETE = 0x2E;               // DEL key
    public static final int VK_HELP = 0x2F;                 // HELP key
    public static final int VK_LWIN = 0x5B;                 // Left Windows key (Natural keyboard)
    public static final int VK_RWIN = 0x5C;                 // Right Windows key (Natural keyboard)
    public static final int VK_APPS = 0x5D;                 // Applications key (Natural keyboard)
    public static final int VK_SLEEP = 0x5F;                // Computer Sleep key
    public static final int VK_NUMPAD0 = 0x60;              // Numeric keypad 0 key
    public static final int VK_NUMPAD1 = 0x61;              // Numeric keypad 1 key
    public static final int VK_NUMPAD2 = 0x62;              // Numeric keypad 2 key
    public static final int VK_NUMPAD3 = 0x63;              // Numeric keypad 3 key
    public static final int VK_NUMPAD4 = 0x64;              // Numeric keypad 4 key
    public static final int VK_NUMPAD5 = 0x65;              // Numeric keypad 5 key
    public static final int VK_NUMPAD6 = 0x66;              // Numeric keypad 6 key
    public static final int VK_NUMPAD7 = 0x67;              // Numeric keypad 7 key
    public static final int VK_NUMPAD8 = 0x68;              // Numeric keypad 8 key
    public static final int VK_NUMPAD9 = 0x69;              // Numeric keypad 9 key
    public static final int VK_MULTIPLY = 0x6A;             // Multiply key
    public static final int VK_ADD = 0x6B;                  // Add key
    public static final int VK_SEPARATOR = 0x6C;            // Separator key
    public static final int VK_SUBTRACT = 0x6D;             // Subtract key
    public static final int VK_DECIMAL = 0x6E;              // Decimal key
    public static final int VK_DIVIDE = 0x6F;               // Divide key
    public static final int VK_F1 = 0x70;                   // F1 key
    public static final int VK_F2 = 0x71;                   // F2 key
    public static final int VK_F3 = 0x72;                   // F3 key
    public static final int VK_F4 = 0x73;                   // F4 key
    public static final int VK_F5 = 0x74;                   // F5 key
    public static final int VK_F6 = 0x75;                   // F6 key
    public static final int VK_F7 = 0x76;                   // F7 key
    public static final int VK_F8 = 0x77;                   // F8 key
    public static final int VK_F9 = 0x78;                   // F9 key
    public static final int VK_F10 = 0x79;                  // F10 key
    public static final int VK_F11 = 0x7A;                  // F11 key
    public static final int VK_F12 = 0x7B;                  // F12 key
    public static final int VK_F13 = 0x7C;                  // F13 key
    public static final int VK_F14 = 0x7D;                  // F14 key
    public static final int VK_F15 = 0x7E;                  // F15 key
    public static final int VK_F16 = 0x7F;                  // F16 key
    public static final int VK_F17 = 0x80;                  // F17 key
    public static final int VK_F18 = 0x81;                  // F18 key
    public static final int VK_F19 = 0x82;                  // F19 key
    public static final int VK_F20 = 0x83;                  // F20 key
    public static final int VK_F21 = 0x84;                  // F21 key
    public static final int VK_F22 = 0x85;                  // F22 key
    public static final int VK_F23 = 0x86;                  // F23 key
    public static final int VK_F24 = 0x87;                  // F24 key
    public static final int VK_NUMLOCK = 0x90;              // NUM LOCK key
    public static final int VK_SCROLL = 0x91;               // SCROLL LOCK key
    public static final int VK_LSHIFT = 0xA0;               // Left SHIFT key
    public static final int VK_RSHIFT = 0xA1;               // Right SHIFT key
    public static final int VK_LCONTROL = 0xA2;             // Left CONTROL key
    public static final int VK_RCONTROL = 0xA3;             // Right CONTROL key
    public static final int VK_LMENU = 0xA4;                // Left MENU key
    public static final int VK_RMENU = 0xA5;                // Right MENU key
    public static final int VK_BROWSER_BACK = 0xA6;         // Browser Back key
    public static final int VK_BROWSER_FORWARD = 0xA7;      // Browser Forward key
    public static final int VK_BROWSER_REFRESH = 0xA8;      // Browser Refresh key
    public static final int VK_BROWSER_STOP = 0xA9;         // Browser Stop key
    public static final int VK_BROWSER_SEARCH = 0xAA;       // Browser Search key
    public static final int VK_BROWSER_FAVORITES = 0xAB;    // Browser Favorites key
    public static final int VK_BROWSER_HOME = 0xAC;         // Browser Start and Home key
    public static final int VK_VOLUME_MUTE = 0xAD;          // Volume Mute key
    public static final int VK_VOLUME_DOWN = 0xAE;          // Volume Down key
    public static final int VK_VOLUME_UP = 0xAF;            // Volume Up key
    public static final int VK_MEDIA_NEXT_TRACK = 0xB0;     // Next Track key
    public static final int VK_MEDIA_PREV_TRACK = 0xB1;     // Previous Track key
    public static final int VK_MEDIA_STOP = 0xB2;           // Stop Media key
    public static final int VK_MEDIA_PLAY_PAUSE = 0xB3;     // Play/Pause Media key
    public static final int VK_LAUNCH_MAIL = 0xB4;          // Start Mail key
    public static final int VK_LAUNCH_MEDIA_SELECT = 0xB5;  // Select Media key
    public static final int VK_LAUNCH_APP1 = 0xB6;          // Start Application 1 key
    public static final int VK_LAUNCH_APP2 = 0xB7;          // Start Application 2 key
    public static final int VK_OEM_1 = 0xBA;                // Used for miscellaneous characters; it can vary by keyboard.
    public static final int VK_OEM_PLUS = 0xBB;             // For any country/region, the '+' key
    public static final int VK_OEM_COMMA = 0xBC;            // For any country/region, the ',' key
    public static final int VK_OEM_MINUS = 0xBD;            // For any country/region, the '-' key
    public static final int VK_OEM_PERIOD = 0xBE;           // For any country/region, the '.' key
    public static final int VK_OEM_2 = 0xBF;                // Used for miscellaneous characters; it can vary by keyboard.
    public static final int VK_OEM_3 = 0xC0;                // Used for miscellaneous characters; it can vary by keyboard.
    public static final int VK_OEM_4 = 0xDB;                // Used for miscellaneous characters; it can vary by keyboard.
    public static final int VK_OEM_5 = 0xDC;                // Used for miscellaneous characters; it can vary by keyboard.
    public static final int VK_OEM_6 = 0xDD;                // Used for miscellaneous characters; it can vary by keyboard.
    public static final int VK_OEM_7 = 0xDE;                // Used for miscellaneous characters; it can vary by keyboard.
    public static final int VK_OEM_8 = 0xDF;                // Used for miscellaneous characters; it can vary by keyboard.
    public static final int VK_OEM_102 = 0xE2;              // Either the angle bracket key or the backslash key on the RT 102-key keyboard
    public static final int VK_PROCESSKEY = 0xE5;           // IME PROCESS key
    public static final int VK_PACKET = 0xE7;               // Used to pass Unicode characters as if they were keystrokes. The VK_PACKET key is the low word of a 32-bit Virtual Key value used for non-keyboard input methods. For more information, see Remark in KEYBDINPUT, SendInput, WM_KEYDOWN, and WM_KEYUP
    public static final int VK_ATTN = 0xF6;                 // Attn key
    public static final int VK_CRSEL = 0xF7;                // CrSel key
    public static final int VK_EXSEL = 0xF8;                // ExSel key
    public static final int VK_EREOF = 0xF9;                // Erase EOF key
    public static final int VK_PLAY = 0xFA;                 // Play key
    public static final int VK_ZOOM = 0xFB;                 // Zoom key
    public static final int VK_PA1 = 0xFD;                  // PA1 key
    public static final int VK_OEM_CLEAR = 0xFE;            // Clear key

    public static final int KEYEVENTF_EXTENDEDKEY = 0x0001;
    public static final int KEYEVENTF_KEYUP = 0x0002;
    public static final int KEYEVENTF_SCANCODE = 0x0008;
    public static final int KEYEVENTF_UNICODE = 0x0004;

    public static final int KEY_0 = 0x30;
    public static final int KEY_1 = 0x31;
    public static final int KEY_2 = 0x32;
    public static final int KEY_3 = 0x33;
    public static final int KEY_4 = 0x34;
    public static final int KEY_5 = 0x35;
    public static final int KEY_6 = 0x36;
    public static final int KEY_7 = 0x37;
    public static final int KEY_8 = 0x38;
    public static final int KEY_9 = 0x39;
    public static final int KEY_A = 0x41;
    public static final int KEY_B = 0x42;
    public static final int KEY_C = 0x43;
    public static final int KEY_D = 0x44;
    public static final int KEY_E = 0x45;
    public static final int KEY_F = 0x46;
    public static final int KEY_G = 0x47;
    public static final int KEY_H = 0x48;
    public static final int KEY_I = 0x49;
    public static final int KEY_J = 0x4A;
    public static final int KEY_K = 0x4B;
    public static final int KEY_L = 0x4C;
    public static final int KEY_M = 0x4D;
    public static final int KEY_N = 0x4E;
    public static final int KEY_O = 0x4F;
    public static final int KEY_P = 0x50;
    public static final int KEY_Q = 0x51;
    public static final int KEY_R = 0x52;
    public static final int KEY_S = 0x53;
    public static final int KEY_T = 0x54;
    public static final int KEY_U = 0x55;
    public static final int KEY_V = 0x56;
    public static final int KEY_W = 0x57;
    public static final int KEY_X = 0x58;
    public static final int KEY_Y = 0x59;
    public static final int KEY_Z = 0x5A;

    public static MouseInput createMouseInput(int flags, int x, int y, int data) {
        return new MouseInput(x, y, data, flags, 0, null);
    }

    public static KeybdInput createKeybdInput(int code, int flags) {
        return new KeybdInput(code, code, flags, 0, null);
    }

    public static HardwareInput createHardwareInput(int message, int parameter) {
        return new HardwareInput(message & 0xFFFFFFFF, parameter & 0xFFFF, (parameter >> 16) & 0xFFFF);
    }

    public static Input createMouse(int flags, int x, int y, int data) {
        return new Input(createMouseInput(flags, x, y, data));
    }

    public static Input createKeyboard(int code, int flags) {
        return new Input(createKeybdInput(code, flags));
    }

    public static Input createHardware(int message, int parameter) {
        return new Input(createHardwareInput(message, parameter));
    }
}