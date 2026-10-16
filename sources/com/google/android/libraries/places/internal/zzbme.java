package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbme extends zzbmc {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzbmf f76397f;

    /* synthetic */ zzbme(String str, boolean z2, zzbmf zzbmfVar, byte[] bArr) {
        super(str, z2, zzbmfVar, null);
        Preconditions.o(!str.endsWith("-bin"), "ASCII header is named %s.  Only binary headers may end with %s", str, "-bin");
        this.f76397f = (zzbmf) Preconditions.u(zzbmfVar, "marshaller");
    }

    @Override // com.google.android.libraries.places.internal.zzbmc
    final byte[] a(Object obj) {
        return (byte[]) Preconditions.u(this.f76397f.zza(obj), "null marshaller.toAsciiString()");
    }

    @Override // com.google.android.libraries.places.internal.zzbmc
    final Object b(byte[] bArr) {
        return this.f76397f.zzb(bArr);
    }
}
