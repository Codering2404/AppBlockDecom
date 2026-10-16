package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbma extends zzbmc {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzbmb f76391f;

    /* synthetic */ zzbma(String str, boolean z2, zzbmb zzbmbVar, byte[] bArr) {
        super(str, false, zzbmbVar, null);
        Preconditions.o(!str.endsWith("-bin"), "ASCII header is named %s.  Only binary headers may end with %s", str, "-bin");
        this.f76391f = (zzbmb) Preconditions.u(zzbmbVar, "marshaller");
    }

    @Override // com.google.android.libraries.places.internal.zzbmc
    final byte[] a(Object obj) {
        return ((String) Preconditions.u(this.f76391f.zzb(obj), "null marshaller.toAsciiString()")).getBytes(StandardCharsets.US_ASCII);
    }

    @Override // com.google.android.libraries.places.internal.zzbmc
    final Object b(byte[] bArr) {
        return this.f76391f.zza(new String(bArr, StandardCharsets.US_ASCII));
    }
}
