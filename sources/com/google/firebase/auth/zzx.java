package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p002firebaseauthapi.zzahv;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzx implements com.google.firebase.auth.internal.zzau, com.google.firebase.auth.internal.zzl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f88081a;

    zzx(FirebaseAuth firebaseAuth) {
        Objects.requireNonNull(firebaseAuth);
        this.f88081a = firebaseAuth;
    }

    @Override // com.google.firebase.auth.internal.zzl
    public final void a(zzahv zzahvVar, FirebaseUser firebaseUser) {
        this.f88081a.C(firebaseUser, zzahvVar, true, true);
    }

    @Override // com.google.firebase.auth.internal.zzau
    public final void zza(Status status) {
        int iO = status.O();
        if (iO == 17011 || iO == 17021 || iO == 17005) {
            this.f88081a.l();
        }
    }
}
