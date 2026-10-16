package com.google.android.gms.ads.internal.client;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfe extends zzbm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzff f69938a;

    /* synthetic */ zzfe(zzff zzffVar, byte[] bArr) {
        Objects.requireNonNull(zzffVar);
        this.f69938a = zzffVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final void zze(zzm zzmVar) {
        zzi(zzmVar, 1);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final String zzf() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final boolean zzg() {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final String zzh() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final void zzi(zzm zzmVar, int i3) {
        com.google.android.gms.ads.internal.util.client.zzo.c("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        com.google.android.gms.ads.internal.util.client.zzf.f70162b.post(new zzfd(this));
    }
}
