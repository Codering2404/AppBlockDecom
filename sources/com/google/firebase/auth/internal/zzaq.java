package com.google.firebase.auth.internal;

import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.util.DefaultClock;
import com.google.firebase.FirebaseApp;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaq {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Logger f87874h = new Logger("TokenRefresher", "FirebaseAuth:");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FirebaseApp f87875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile long f87876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile long f87877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f87878d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HandlerThread f87879e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Handler f87880f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Runnable f87881g;

    public zzaq(FirebaseApp firebaseApp) {
        f87874h.g("Initializing TokenRefresher", new Object[0]);
        FirebaseApp firebaseApp2 = (FirebaseApp) Preconditions.m(firebaseApp);
        this.f87875a = firebaseApp2;
        HandlerThread handlerThread = new HandlerThread("TokenRefresher", 10);
        this.f87879e = handlerThread;
        handlerThread.start();
        this.f87880f = new com.google.android.gms.internal.p002firebaseauthapi.zze(this.f87879e.getLooper());
        this.f87881g = new zzat(this, firebaseApp2.o());
        this.f87878d = 300000L;
    }

    public final void b() {
        this.f87880f.removeCallbacks(this.f87881g);
    }

    public final void c() {
        f87874h.g("Scheduling refresh for " + (this.f87876b - this.f87878d), new Object[0]);
        b();
        this.f87877c = Math.max((this.f87876b - DefaultClock.c().currentTimeMillis()) - this.f87878d, 0L) / 1000;
        this.f87880f.postDelayed(this.f87881g, this.f87877c * 1000);
    }

    final void d() {
        int i3 = (int) this.f87877c;
        this.f87877c = (i3 == 30 || i3 == 60 || i3 == 120 || i3 == 240 || i3 == 480) ? 2 * this.f87877c : i3 != 960 ? 30L : 960L;
        this.f87876b = DefaultClock.c().currentTimeMillis() + (this.f87877c * 1000);
        f87874h.g("Scheduling refresh for " + this.f87876b, new Object[0]);
        this.f87880f.postDelayed(this.f87881g, this.f87877c * 1000);
    }
}
