# HOLO-01 Web Prototype

A browser-based prototype for testing the HOLO-01 visual workspace, camera hand tracking, pinch selection, air-swipe navigation, and the voice wake word.

## Deploy to Vercel

1. Create a GitHub repository and upload the contents of this folder.
2. In Vercel, choose **Add New → Project** and import that repository.
3. Keep the framework preset as **Other**.
4. Leave the build command and output directory empty/default; this is a static site.
5. Deploy. Open the HTTPS deployment in Chrome on the Galaxy A07.
6. Allow camera access, then press **ENABLE CAMERA**. Press **ENABLE VOICE WAKE** to test the spoken wake word.

## What this web prototype can test

- Live front-camera access while the website is open.
- MediaPipe hand landmark tracking.
- Open-palm activation, pinch selection, and air-swipe panel switching.
- A 3D-styled spatial interface rendered on the phone screen.
- Browser speech recognition for the wake word “HOLO”, where supported.

## Important limits

This is a **website prototype**, not an Android system controller. A website cannot invoke Android's Home/Back/Recents system navigation, control other apps, keep the camera running in the background, or display an interface over other apps. The app cards are in-page demonstrations, not the real ChatGPT/WhatsApp application windows. Those capabilities require a native Android app and Android permissions/services.

The website requires HTTPS and camera/microphone permission. Gesture tracking runs only while this page is open and active. Browser speech recognition availability varies by browser and device. No camera video is uploaded by this page; the hand-tracking model is loaded from public CDNs and processed in the browser.
