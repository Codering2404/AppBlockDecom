package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbdo implements zzbdf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f76083a = 525004180;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final zzbgj f76084b;

    zzbdo(zzbdv zzbdvVar, int i3, zzbgj zzbgjVar, boolean z2, boolean z3) {
        this.f76084b = zzbgjVar;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        int i3 = ((zzbdo) obj).f76083a;
        return 0;
    }

    @Override // com.google.android.libraries.places.internal.zzbdf
    public final int zza() {
        return 525004180;
    }

    @Override // com.google.android.libraries.places.internal.zzbdf
    public final zzbgj zzb() {
        return this.f76084b;
    }

    @Override // com.google.android.libraries.places.internal.zzbdf
    public final zzbgk zzc() {
        return this.f76084b.a();
    }

    @Override // com.google.android.libraries.places.internal.zzbdf
    public final boolean zzd() {
        return false;
    }

    @Override // com.google.android.libraries.places.internal.zzbdf
    public final boolean zze() {
        return false;
    }

    @Override // com.google.android.libraries.places.internal.zzbdf
    public final boolean zzf(Object obj) {
        return obj instanceof zzbex;
    }

    @Override // com.google.android.libraries.places.internal.zzbdf
    public final void zzg(Object obj, Object obj2) {
        ((zzbdk) obj).u((zzbdq) obj2);
    }
}
