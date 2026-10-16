package com.google.android.libraries.places.internal;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzpp implements zzps {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f78412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzmy f78413b;

    private zzpp() {
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzps
    public final /* bridge */ /* synthetic */ zzps a(zzmy zzmyVar) {
        zzmyVar.getClass();
        this.f78413b = zzmyVar;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzps
    public final zzpt zza() {
        zzbig.b(this.f78412a, Context.class);
        zzbig.b(this.f78413b, zzmy.class);
        return new zzpq(this.f78412a, this.f78413b);
    }

    @Override // com.google.android.libraries.places.internal.zzps
    public final /* bridge */ /* synthetic */ zzps zzc(Context context) {
        context.getClass();
        this.f78412a = context;
        return this;
    }

    /* synthetic */ zzpp(byte[] bArr) {
    }
}
