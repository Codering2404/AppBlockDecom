package com.borax12.materialdaterangepicker;

import android.content.Context;
import android.database.ContentObserver;
import android.os.SystemClock;
import android.os.Vibrator;
import android.provider.Settings;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class HapticFeedbackController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f65661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ContentObserver f65662b = new ContentObserver(null) { // from class: com.borax12.materialdaterangepicker.HapticFeedbackController.1
        @Override // android.database.ContentObserver
        public void onChange(boolean z2) {
            HapticFeedbackController hapticFeedbackController = HapticFeedbackController.this;
            hapticFeedbackController.f65664d = HapticFeedbackController.d(hapticFeedbackController.f65661a);
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Vibrator f65663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f65664d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f65665e;

    public HapticFeedbackController(Context context) {
        this.f65661a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "haptic_feedback_enabled", 0) == 1;
    }

    private boolean e(Context context) {
        return context.getPackageManager().checkPermission("android.permission.VIBRATE", context.getPackageName()) == 0;
    }

    public void f() {
        if (e(this.f65661a)) {
            this.f65663c = (Vibrator) this.f65661a.getSystemService("vibrator");
        }
        this.f65664d = d(this.f65661a);
        this.f65661a.getContentResolver().registerContentObserver(Settings.System.getUriFor("haptic_feedback_enabled"), false, this.f65662b);
    }

    public void g() {
        this.f65663c = null;
        this.f65661a.getContentResolver().unregisterContentObserver(this.f65662b);
    }

    public void h() {
        if (this.f65663c == null || !this.f65664d) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (jUptimeMillis - this.f65665e >= 125) {
            this.f65663c.vibrate(50L);
            this.f65665e = jUptimeMillis;
        }
    }
}
