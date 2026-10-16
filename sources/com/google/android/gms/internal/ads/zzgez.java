package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgez implements zzgfa {
    private final zzifp zza;

    public zzgez(zzifp zzifpVar) {
        this.zza = zzifpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgfa
    public final /* synthetic */ void zza(Object obj, OutputStream outputStream) throws IOException {
        ((zzifp) obj).zzaO(outputStream);
    }

    @Override // com.google.android.gms.internal.ads.zzgfa
    public final /* bridge */ /* synthetic */ Object zzb(InputStream inputStream) {
        try {
            return (zzifp) this.zza.zzbd().zza(inputStream, zzido.zza());
        } catch (zziet e3) {
            throw new zzgew("Cannot read proto.", e3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgfa
    public final /* synthetic */ Object zzc() {
        return this.zza;
    }
}
