package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhdk implements zzhed {
    private final InputStream zza;

    private zzhdk(InputStream inputStream) {
        this.zza = inputStream;
    }

    public static zzhed zza(byte[] bArr) {
        return new zzhdk(new ByteArrayInputStream(bArr));
    }

    @Override // com.google.android.gms.internal.ads.zzhed
    public final zzhsz zzb() throws IOException {
        try {
            return zzhsz.zzg(this.zza, zzido.zza());
        } finally {
            this.zza.close();
        }
    }
}
