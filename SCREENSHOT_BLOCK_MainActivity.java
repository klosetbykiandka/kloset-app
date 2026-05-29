// ═══════════════════════════════════════════════════════════════
// SCREENSHOT BLOCKING — MainActivity.java reference
// ═══════════════════════════════════════════════════════════════
//
// After you run `npx cap add android`, Capacitor creates this file at:
//   android/app/src/main/java/com/klosetbykiandka/manager/MainActivity.java
//
// REPLACE the entire contents of that file with the code below.
// The key line is FLAG_SECURE — it blocks screenshots AND screen recording
// AND hides the app content in the app-switcher preview.
//
// ═══════════════════════════════════════════════════════════════

package com.klosetbykiandka.manager;

import android.os.Bundle;
import android.view.WindowManager;
import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 🔒 Block screenshots and screen recording (protects boutique designs)
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        );
    }
}

// ═══════════════════════════════════════════════════════════════
// THAT'S IT. One flag = screenshots blocked across the whole app.
//
// When someone tries to screenshot:
//   - The screenshot saves as a BLACK image
//   - Screen recording shows black
//   - App preview in recent-apps switcher is hidden
//
// NOTE: This is OS-level. It cannot be bypassed by normal users.
// (Only a rooted device with special tools could, which is rare.)
// ═══════════════════════════════════════════════════════════════
