# 📱 Building the Android App (APK) — Step by Step

Your app → native Android app with **screenshot blocking**. Follow each step exactly.

---

## ✅ Prerequisites (install on your Mac, one-time)

### 1. Node.js
Check if installed — open **Terminal** and run:
```bash
node --version
```
- If you see a version (e.g. `v20.x`) → ✓ skip to step 2
- If "command not found" → download from **nodejs.org** (LTS version), install, reopen Terminal

### 2. Android Studio
Download from **developer.android.com/studio** → install → open it once → let it finish downloading the SDK components (it does this automatically on first launch).

---

## 🚀 Build Steps

### Step 1: Open the project folder in Terminal
Copy the `kloset-app` folder to your Mac (e.g. Desktop). Then:
```bash
cd ~/Desktop/kloset-app
```

### Step 2: Install Capacitor
```bash
npm install
```
Wait for it to finish (~1 min).

### Step 3: Add the Android platform
```bash
npx cap add android
```
This creates the `android/` folder with the native project.

### Step 4: Add screenshot blocking
1. In Finder, navigate to:
   ```
   kloset-app/android/app/src/main/java/com/klosetbykiandka/manager/
   ```
2. Open `MainActivity.java` in any text editor
3. Open the file `SCREENSHOT_BLOCK_MainActivity.java` (in your kloset-app folder)
4. Copy the Java code (the `package ... }` part, skip the comments)
5. Paste it — REPLACE everything in `MainActivity.java`
6. Save

### Step 5: Sync
```bash
npx cap sync android
```

### Step 6: Open in Android Studio
```bash
npx cap open android
```
Android Studio launches with your project. Wait for "Gradle sync" to finish (bottom bar, ~2-5 min first time).

---

## 📦 Make the APK

### To test on your own phone (quick):
1. In Android Studio top menu: **Build → Build Bundle(s) / APK(s) → Build APK(s)**
2. Wait → a popup says "APK(s) generated" → click **locate**
3. That `.apk` file → copy to your Android phone → tap to install
4. Test screenshot blocking: try to screenshot → it'll be black ✅

### To publish on Play Store:
You need a **signed AAB** (Android App Bundle):
1. **Build → Generate Signed Bundle / APK**
2. Choose **Android App Bundle**
3. Create a new keystore (FIRST TIME):
   - Click **Create new**
   - Choose a path to save the `.jks` file (⚠️ BACK THIS UP — you need it for every update)
   - Set passwords (write them down safely)
   - Fill name/org fields
4. Click through → **release** build variant → Finish
5. The `.aab` file is generated → upload to Play Console

---

## 🏪 Play Store Submission

1. Go to **play.google.com/console**
2. **Create app** → fill name "Kloset Manager", language, etc.
3. Upload your `.aab` under **Production → Create release**
4. Fill required sections: store listing (description, screenshots, icon), content rating, privacy policy, data safety
5. Submit for review (~1-3 days)

---

## ⚠️ Important Notes

- **App ID** is `com.klosetbykiandka.manager` — this is permanent once published
- **Keep your keystore (.jks) file safe** — losing it means you can't update the app
- **Internet required** — the app uses Firebase (online). It won't work fully offline.
- **Updates:** When you change the web app, just replace `www/index.html`, run `npx cap sync android`, rebuild

---

## 🆘 Common Issues

| Problem | Fix |
|---------|-----|
| "Gradle sync failed" | Let Android Studio download SDK; File → Sync Project with Gradle Files |
| "SDK not found" | Android Studio → Settings → Languages & Frameworks → Android SDK → install |
| App shows white screen | Check `www/index.html` exists; re-run `npx cap sync android` |
| Google login fails | Add your app's SHA-1 to Firebase (see FIREBASE_ANDROID.md) |

---

## Next: After Android Works

Once the APK runs and screenshot-blocking works, we'll do iOS (similar process, needs Xcode).
