package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbts extends zzbsn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbqa f76868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbpb f76869b;

    /* synthetic */ zzbts(zzbqa zzbqaVar, zzbpb zzbpbVar, byte[] bArr) {
        this.f76868a = zzbqaVar;
        this.f76869b = zzbpbVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbsn
    protected final zzbqa d() {
        return this.f76868a;
    }

    @Override // com.google.android.libraries.places.internal.zzbsn, com.google.android.libraries.places.internal.zzbpo
    public final zzbpl e(zzbml zzbmlVar, zzbmg zzbmgVar, zzbis zzbisVar, zzbje[] zzbjeVarArr) {
        return new zzbtr(this, this.f76868a.e(zzbmlVar, zzbmgVar, zzbisVar, zzbjeVarArr));
    }

    final /* synthetic */ zzbpb f() {
        return this.f76869b;
    }
}
