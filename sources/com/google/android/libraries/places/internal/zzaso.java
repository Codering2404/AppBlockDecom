package com.google.android.libraries.places.internal;

import com.google.common.collect.ImmutableList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzaso implements zzbiy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzcez f75789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class f75790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Class f75791c;

    zzaso(zzcez zzcezVar, int i3, Class cls, Class cls2) {
        this.f75789a = zzcezVar;
        this.f75790b = cls;
        this.f75791c = cls2;
    }

    @Override // com.google.android.libraries.places.internal.zzbiy
    public final zzbix a(zzbml zzbmlVar, zzbis zzbisVar, zzbit zzbitVar) {
        try {
            ImmutableList immutableList = (ImmutableList) this.f75789a.zzb();
            zzasp.b(zzbmlVar, this.f75790b, true);
            zzasp.b(zzbmlVar, this.f75791c, false);
            return new zzatp(new zzatk(zzbitVar, zzbmlVar, zzbisVar, 2, immutableList));
        } catch (zzbnq e3) {
            return new zzaty(zzbnp.b(e3));
        }
    }
}
