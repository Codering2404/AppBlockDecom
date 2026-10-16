package com.google.android.libraries.places.internal;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbwm implements zzbmo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f77103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbmn f77104b;

    zzbwm(List list, zzbmn zzbmnVar) {
        this.f77103a = list;
        this.f77104b = zzbmnVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbmo
    public final void a(zzblu zzbluVar, long j3, List list, List list2) {
        super.a(zzbluVar, 1L, list, list2);
        for (zzbmp zzbmpVar : this.f77103a) {
            if (zzbmpVar.zza() <= zzbluVar.a()) {
                this.f77104b.b();
                zzbmpVar.zzb();
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbmo
    public final void b(zzblv zzblvVar, long j3, List list, List list2) {
        super.b(zzblvVar, j3, list, list2);
        for (zzbmp zzbmpVar : this.f77103a) {
            if (zzbmpVar.zza() <= zzblvVar.a()) {
                this.f77104b.b();
                zzbmpVar.zzb();
            }
        }
    }
}
