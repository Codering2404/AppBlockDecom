package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcbx implements zzcam {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzcff f77475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f77476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f77477c;

    zzcbx(zzcff zzcffVar, int i3) {
        this.f77475a = zzcffVar;
        this.f77476b = i3;
    }

    @Override // com.google.android.libraries.places.internal.zzcam
    public final void a(byte b3) {
        this.f77475a.a(b3);
        this.f77476b--;
        this.f77477c++;
    }

    final zzcff b() {
        return this.f77475a;
    }

    @Override // com.google.android.libraries.places.internal.zzcam
    public final void zza(byte[] bArr, int i3, int i4) {
        this.f77475a.g0(bArr, i3, i4);
        this.f77476b -= i4;
        this.f77477c += i4;
    }

    @Override // com.google.android.libraries.places.internal.zzcam
    public final int zzc() {
        return this.f77476b;
    }

    @Override // com.google.android.libraries.places.internal.zzcam
    public final int zzd() {
        return this.f77477c;
    }
}
