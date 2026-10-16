package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzy implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f88082a;

    zzy(FirebaseAuth firebaseAuth) {
        this.f88082a = firebaseAuth;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator it = this.f88082a.f87743c.iterator();
        while (it.hasNext()) {
            ((FirebaseAuth.AuthStateListener) it.next()).a(this.f88082a);
        }
    }
}
