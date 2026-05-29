# 🔥 Firebase Setup for Android (REQUIRED for Google Login)

Your app uses Google Sign-In. On Android, Google login **will fail** unless you register the app's fingerprint with Firebase. This is a one-time setup.

---

## Why This Is Needed

Google Sign-In on native Android verifies your app's identity using a **SHA-1 fingerprint** (a unique code from your signing key). Without registering it, Google blocks the login.

---

## Step 1: Get Your SHA-1 Fingerprint

### For testing (debug key):
In Terminal:
```bash
cd ~/Desktop/kloset-app/android
./gradlew signingReport
```
Look for the **SHA1** line under "Variant: debug" — copy it (looks like `A1:B2:C3:...`).

### For Play Store (release key):
After you create your keystore (.jks), run:
```bash
keytool -list -v -keystore /path/to/your-keystore.jks -alias your-alias-name
```
Enter your keystore password → copy the **SHA1** value.

⚠️ You'll need BOTH eventually (debug for testing, release for the published app). Also, when you upload to Play Store, Google generates its OWN signing key — get that SHA-1 from Play Console → Setup → App integrity → App signing key certificate.

---

## Step 2: Add to Firebase

1. **Firebase Console** → your project (klosetbykiandka)
2. Tap the **⚙️ gear → Project settings**
3. Scroll to **Your apps** → tap **Add app** → choose **Android** (robot icon)
4. **Android package name:** `com.klosetbykiandka.manager`
   (must match EXACTLY)
5. **App nickname:** Kloset Android (optional)
6. **Debug signing certificate SHA-1:** paste the SHA-1 from Step 1
7. Tap **Register app**

## Step 3: Download google-services.json

1. Firebase gives you a **`google-services.json`** file → download it
2. Place it in your project at:
   ```
   kloset-app/android/app/google-services.json
   ```

## Step 4: Verify Gradle Has Google Services

Capacitor usually adds this automatically, but verify:

In `android/build.gradle` (project-level), under dependencies:
```
classpath 'com.google.gms:google-services:4.4.2'
```

In `android/app/build.gradle` (app-level), at the very BOTTOM:
```
apply plugin: 'com.google.gms.google-services'
```

If they're missing, add them, then re-sync.

---

## Step 5: Add Authorized Domain

Your app loads from the bundled HTML, but Firebase Auth still checks domains:
1. Firebase → **Authentication → Settings → Authorized domains**
2. Make sure `localhost` is there (it usually is by default)

---

## After This

Rebuild the app (`npx cap sync android` → rebuild in Android Studio). Google login should now work on the device.

---

## 🆘 If Google Login Still Fails

- Double-check the package name matches exactly: `com.klosetbykiandka.manager`
- Make sure you added the RIGHT SHA-1 (debug vs release)
- For Play Store builds, add Google's app-signing SHA-1 too
- `google-services.json` must be in `android/app/` folder
