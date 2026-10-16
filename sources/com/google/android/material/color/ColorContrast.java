package com.google.android.material.color;

import android.app.Activity;
import android.app.Application;
import android.app.UiModeManager;
import android.app.UiModeManager$ContrastChangeListener;
import android.os.Build;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ColorContrast {
    public static void a(Activity activity, ColorContrastOptions colorContrastOptions) {
        int iB;
        if (c() && (iB = b(activity, colorContrastOptions)) != 0) {
            ThemeUtils.a(activity, iB);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0031 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int b(android.content.Context r3, com.google.android.material.color.ColorContrastOptions r4) {
        /*
            java.lang.String r0 = "uimode"
            java.lang.Object r3 = r3.getSystemService(r0)
            android.app.UiModeManager r3 = (android.app.UiModeManager) r3
            boolean r0 = c()
            r1 = 0
            if (r0 == 0) goto L33
            if (r3 != 0) goto L12
            goto L33
        L12:
            float r3 = com.google.android.material.color.a.a(r3)
            int r0 = r4.b()
            int r4 = r4.a()
            r2 = 1059760811(0x3f2aaaab, float:0.6666667)
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 < 0) goto L28
            if (r4 != 0) goto L31
            goto L32
        L28:
            r2 = 1051372203(0x3eaaaaab, float:0.33333334)
            int r3 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r3 < 0) goto L33
            if (r0 != 0) goto L32
        L31:
            return r4
        L32:
            return r0
        L33:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.color.ColorContrast.b(android.content.Context, com.google.android.material.color.ColorContrastOptions):int");
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 34;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ColorContrastActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set f80517a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ColorContrastOptions f80518b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private UiModeManager$ContrastChangeListener f80519c;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            this.f80517a.remove(activity);
            UiModeManager uiModeManager = (UiModeManager) activity.getSystemService("uimode");
            if (uiModeManager == null || this.f80519c == null || !this.f80517a.isEmpty()) {
                return;
            }
            uiModeManager.removeContrastChangeListener(this.f80519c);
            this.f80519c = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            UiModeManager uiModeManager = (UiModeManager) activity.getSystemService("uimode");
            if (uiModeManager != null && this.f80517a.isEmpty() && this.f80519c == null) {
                this.f80519c = new UiModeManager$ContrastChangeListener() { // from class: com.google.android.material.color.ColorContrast.ColorContrastActivityLifecycleCallbacks.1
                    public void onContrastChanged(float f3) {
                        Iterator it = ColorContrastActivityLifecycleCallbacks.this.f80517a.iterator();
                        while (it.hasNext()) {
                            ((Activity) it.next()).recreate();
                        }
                    }
                };
                uiModeManager.addContrastChangeListener(ContextCompat.getMainExecutor(activity.getApplicationContext()), this.f80519c);
            }
            this.f80517a.add(activity);
            if (uiModeManager != null) {
                ColorContrast.a(activity, this.f80518b);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }
}
