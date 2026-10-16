package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.internal.IdTokenListener;
import com.google.firebase.internal.InternalTokenResult;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzv implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f88077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ InternalTokenResult f88078b;

    zzv(FirebaseAuth firebaseAuth, InternalTokenResult internalTokenResult) {
        this.f88077a = firebaseAuth;
        this.f88078b = internalTokenResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator it = this.f88077a.f87744d.iterator();
        while (it.hasNext()) {
            ((IdTokenListener) it.next()).a(this.f88078b);
        }
        Iterator it2 = this.f88077a.f87742b.iterator();
        while (it2.hasNext()) {
            ((FirebaseAuth.IdTokenListener) it2.next()).a(this.f88077a);
        }
    }
}
