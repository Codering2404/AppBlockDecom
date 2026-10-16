package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzu implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth.AuthStateListener f88075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f88076b;

    @Override // java.lang.Runnable
    public final void run() {
        this.f88075a.a(this.f88076b);
    }
}
