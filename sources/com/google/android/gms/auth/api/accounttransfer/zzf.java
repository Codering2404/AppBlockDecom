package com.google.android.gms.auth.api.accounttransfer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzf extends zzj {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzg f71005b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzf(zzg zzgVar, zzl zzlVar) {
        super(zzlVar);
        this.f71005b = zzgVar;
    }

    @Override // com.google.android.gms.internal.auth.zzan, com.google.android.gms.internal.auth.zzat
    public final void zzc(DeviceMetaData deviceMetaData) {
        this.f71005b.f71010d.setResult(deviceMetaData);
    }
}
