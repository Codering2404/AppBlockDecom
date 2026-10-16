package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.FirebaseNetworkException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzas implements OnFailureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzat f87883a;

    public zzas(zzat zzatVar) {
        Objects.requireNonNull(zzatVar);
        this.f87883a = zzatVar;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        if (exc instanceof FirebaseNetworkException) {
            zzaq.f87874h.g("Failure to refresh token; scheduling refresh after failure", new Object[0]);
            this.f87883a.f87885b.d();
        }
    }
}
