package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.internal.zzav;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzr implements zzav {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ FirebaseUser f88072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f88073b;

    @Override // com.google.firebase.auth.internal.zzav
    public final void zza() {
        if (this.f88073b.f87746f == null || !this.f88073b.f87746f.j0().equalsIgnoreCase(this.f88072a.j0())) {
            return;
        }
        this.f88073b.T();
    }

    @Override // com.google.firebase.auth.internal.zzau
    public final void zza(Status status) {
        if (status.O() == 17011 || status.O() == 17021 || status.O() == 17005) {
            this.f88073b.l();
        }
    }
}
