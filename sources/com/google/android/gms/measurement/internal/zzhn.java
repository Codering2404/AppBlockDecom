package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhn implements com.google.android.gms.internal.measurement.zzr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzht f73841a;

    zzhn(zzht zzhtVar) {
        Objects.requireNonNull(zzhtVar);
        this.f73841a = zzhtVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void zza(int i3, String str, List list, boolean z2, boolean z3) {
        int i4 = i3 - 1;
        zzgs zzgsVarU = i4 != 0 ? i4 != 1 ? i4 != 3 ? i4 != 4 ? this.f73841a.f73997a.a().u() : z2 ? this.f73841a.f73997a.a().s() : !z3 ? this.f73841a.f73997a.a().t() : this.f73841a.f73997a.a().r() : this.f73841a.f73997a.a().w() : z2 ? this.f73841a.f73997a.a().p() : !z3 ? this.f73841a.f73997a.a().q() : this.f73841a.f73997a.a().o() : this.f73841a.f73997a.a().v();
        int size = list.size();
        if (size == 1) {
            zzgsVarU.b(str, list.get(0));
            return;
        }
        if (size == 2) {
            zzgsVarU.c(str, list.get(0), list.get(1));
        } else if (size != 3) {
            zzgsVarU.a(str);
        } else {
            zzgsVarU.d(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
