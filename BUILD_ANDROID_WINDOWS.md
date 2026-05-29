# 📱 Building the Android App on WINDOWS — Step by Step

Your web app → native Android app with **screenshot blocking**. Windows works fully for Android.

---

## ✅ Prerequisites (install on Windows, one-time)

### 1. Node.js
- Download from **nodejs.org** → get the **LTS** version → run installer (accept defaults)
- Verify: open **Command Prompt** (search "cmd" in Start menu) and type:
  ```
  node --version
  ```
  You should see something like `v20.x`

### 2. Android Studio
- Download from **developer.android.com/studio** → install
- Open it once → let it auto-download the SDK on first launch (takes a few min)

### 3. Java JDK (usually comes with Android Studio)
- Android Studio bundles its own Java, so you likely don't need a separate install

---

## 🚀 Build Steps (Command Prompt)

### Step 1: Open the project folder
Unzip `kloset-app` somewhere easy, like `C:\kloset-app`. Then in Command Prompt:
```
cd C:\kloset-app
```
(adjust path to where you unzipped it)

### Step 2: Install Capacitor
```
npm install
```
Wait ~1-2 min.

### Step 3: Add Android platform
```
npx cap add android
```
Creates the `android\` folder.

### Step 4: Add screenshot blocking
1. In File Explorer, go to:
   ```
   kloset-app\android\app\src\main\java\com\klosetbykiandka\manager\
   ```
2. Open `MainActivity.java` in Notepad (or VS Code)
3. Open `SCREENSHOT_BLOCK_MainActivity.java` (in your kloset-app folder)
4. Copy the Java code (the `package...}` part, skip comment lines)
5. REPLACE everything in `MainActivity.java` → Save

### Step 5: Sync
```
npx cap sync android
```

### Step 6: Open in Android Studio
```
npx cap open android
```
Android Studio opens. Wait for "Gradle sync" (bottom bar) to finish — first time takes 2-5 min.

---

## 📦 Make the APK

### Test APK (for your own phone):
1. Android Studio menu: **Build → Build Bundle(s) / APK(s) → Build APK(s)**
2. Wait → popup "APK(s) generated" → click **locate**
3. Find `app-debug.apk` → transfer to your Android phone (USB, email, or Google Drive)
4. On phone: tap the APK → allow "install from unknown sources" → install
5. **Test screenshots:** try to screenshot → it saves BLACK ✅

### Play Store AAB (signed):
1. **Build → Generate Signed Bundle / APK**
2. Choose **Android App Bundle**
3. **Create new** keystore (first time):
   - Pick a save location for the `.jks` file (⚠️ BACK IT UP — needed for every update)
   - Set + WRITE DOWN the passwords
   - Fill name/org fields
4. Choose **release** → Finish
5. Find the `.aab` → upload to Play Console

---

## 🏪 Play Store Submission

1. **play.google.com/console** → pay one-time $25 (if not done)
2. **Create app** → name "Kloset Manager"
3. **Production → Create release** → upload `.aab`
4. Fill: store listing, screenshots, icon, content rating, privacy policy, data safety
5. Submit → review takes 1-3 days

---

## ⚠️ Critical: Firebase Setup (or Google login fails)

See **FIREBASE_ANDROID.md** — you MUST register the app's SHA-1 in Firebase.

### Getting SHA-1 on Windows:
In Command Prompt:
```
cd C:\kloset-app\android
gradlew signingReport
```
(note: `gradlew` not `./gradlew` on Windows)

Copy the **SHA1** under "Variant: debug" → add to Firebase.

---

## 🆘 Common Windows Issues

| Problem | Fix |
|---------|-----|
| `npx` not recognized | Reinstall Node.js, reopen Command Prompt |
| `gradlew` not recognized | Make sure you `cd` into the `android` folder first |
| Gradle sync fails | Android Studio → File → Sync Project with Gradle Files |
| JAVA_HOME error | Android Studio → Settings → Build → Build Tools → Gradle → set Gradle JDK to the bundled one |
| White screen in app | Verify `www\index.html` exists, re-run `npx cap sync android` |

---

## Next: iOS (Later, on Your Mac)

iOS needs Xcode (Mac only). When you're back on your Mac, we'll do iOS — it reuses this same project.
