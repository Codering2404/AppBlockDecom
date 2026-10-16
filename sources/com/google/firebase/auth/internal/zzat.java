package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzat implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f87884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzaq f87885b;

    public zzat(zzaq zzaqVar, String str) {
        Objects.requireNonNull(zzaqVar);
        this.f87885b = zzaqVar;
        this.f87884a = Preconditions.g(str);
    }

    @Override // java.lang.Runnable
    public final void run() {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(FirebaseApp.n(this.f87884a));
        if (firebaseAuth.c() != null) {
            Task taskA = firebaseAuth.a(true);
            zzaq.f87874h.g("Token refreshing started", new Object[0]);
            taskA.addOnFailureListener(new zzas(this));
        }
    }
}
