# 📱 Kloset Manager — Android App

This folder turns your web app into a native Android app with **screenshot blocking**.

## 📂 What's Here

```
kloset-app/
├── www/index.html          ← your app (the web code)
├── package.json            ← dependencies
├── capacitor.config.ts     ← app config (name, ID)
├── BUILD_ANDROID.md        ← 👈 START HERE — full build steps
├── FIREBASE_ANDROID.md     ← Google login setup (required)
└── SCREENSHOT_BLOCK_MainActivity.java  ← screenshot-block code
```

## 🚀 Quick Start

1. Copy this whole `kloset-app` folder to your Mac (Desktop)
2. Open **BUILD_ANDROID.md** and follow step by step
3. Then do **FIREBASE_ANDROID.md** so Google login works

## ⏱️ Time Estimate

- First-time setup (installing tools): ~30-45 min
- Actual build: ~15 min
- Play Store submission: ~30 min + 1-3 day review

## 🔑 Key Facts

- **App name:** Kloset Manager
- **App ID:** com.klosetbykiandka.manager (permanent once published)
- **Screenshot blocking:** YES (via FLAG_SECURE)
- **Needs internet:** Yes (Firebase backend)

## 🔄 Updating Later

When you improve the web app:
1. Replace `www/index.html` with the new version
2. Run `npx cap sync android`
3. Rebuild in Android Studio

---

**Start with BUILD_ANDROID.md** 🌸
