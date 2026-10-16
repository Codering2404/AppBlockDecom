package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgev implements zzgfa {
    private final byte[] zza;

    public zzgev(byte[] bArr) {
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzgfa
    public final /* synthetic */ void zza(Object obj, OutputStream outputStream) throws IOException {
        outputStream.write((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgfa
    public final /* bridge */ /* synthetic */ Object zzb(InputStream inputStream) {
        try {
            return zzgzm.zza(inputStream);
        } catch (IOException e3) {
            throw new zzgew("Cannot read bytes.", e3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgfa
    public final /* synthetic */ Object zzc() {
        return this.zza;
    }
}
