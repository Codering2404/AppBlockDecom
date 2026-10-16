package com.google.firebase.auth.internal;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.internal.p002firebaseauthapi.zzahv;
import com.google.firebase.FirebaseApp;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzca {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f87957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zzaq f87958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f87959c;

    public zzca(FirebaseApp firebaseApp) {
        this(firebaseApp.l(), new zzaq(firebaseApp));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e() {
        return this.f87957a > 0 && !this.f87959c;
    }

    public final void b() {
        this.f87958b.b();
    }

    public final void c(zzahv zzahvVar) {
        if (zzahvVar == null) {
            return;
        }
        long jZza = zzahvVar.zza();
        if (jZza <= 0) {
            jZza = 3600;
        }
        long jZzb = zzahvVar.zzb() + (jZza * 1000);
        zzaq zzaqVar = this.f87958b;
        zzaqVar.f87876b = jZzb;
        zzaqVar.f87877c = -1L;
        if (e()) {
            this.f87958b.c();
        }
    }

    public zzca(Context context, zzaq zzaqVar) {
        this.f87959c = false;
        this.f87957a = 0;
        this.f87958b = zzaqVar;
        BackgroundDetector.c((Application) context.getApplicationContext());
        BackgroundDetector.b().a(new zzcd(this));
    }
}
