package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbn {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static zbn f71258d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Storage f71259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    GoogleSignInAccount f71260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    GoogleSignInOptions f71261c;

    private zbn(Context context) {
        Storage storageB = Storage.b(context);
        this.f71259a = storageB;
        this.f71260b = storageB.c();
        this.f71261c = storageB.d();
    }

    public static synchronized zbn a(Context context) {
        return d(context.getApplicationContext());
    }

    private static synchronized zbn d(Context context) {
        zbn zbnVar = f71258d;
        if (zbnVar != null) {
            return zbnVar;
        }
        zbn zbnVar2 = new zbn(context);
        f71258d = zbnVar2;
        return zbnVar2;
    }

    public final synchronized void b() {
        this.f71259a.a();
        this.f71260b = null;
        this.f71261c = null;
    }

    public final synchronized void c(GoogleSignInOptions googleSignInOptions, GoogleSignInAccount googleSignInAccount) {
        this.f71259a.f(googleSignInAccount, googleSignInOptions);
        this.f71260b = googleSignInAccount;
        this.f71261c = googleSignInOptions;
    }
}
