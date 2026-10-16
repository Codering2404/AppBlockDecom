package com.google.android.libraries.places.internal;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzmc implements zzmm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f78185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzmp f78186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzmz f78187c;

    private zzmc() {
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzmm
    public final /* bridge */ /* synthetic */ zzmm a(zzmz zzmzVar) {
        this.f78187c = zzmzVar;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzmm
    public final /* bridge */ /* synthetic */ zzmm b(zzmp zzmpVar) {
        this.f78186b = zzmpVar;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzmm
    public final zzmn zza() {
        zzbig.b(this.f78185a, Context.class);
        zzbig.b(this.f78186b, zzmp.class);
        zzbig.b(this.f78187c, zzmz.class);
        return new zzmd(this.f78185a, this.f78186b, this.f78187c);
    }

    @Override // com.google.android.libraries.places.internal.zzmm
    public final /* bridge */ /* synthetic */ zzmm zzd(Context context) {
        context.getClass();
        this.f78185a = context;
        return this;
    }

    /* synthetic */ zzmc(byte[] bArr) {
    }
}
