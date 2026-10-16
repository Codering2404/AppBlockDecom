package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzimc extends zzimf implements zzaup {
    protected final String zza = "moov";

    public zzimc(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzaup
    public final String zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaup
    public final void zzb(zzimg zzimgVar, ByteBuffer byteBuffer, long j3, zzaum zzaumVar) throws IOException {
        zzimgVar.zzc();
        byteBuffer.remaining();
        byteBuffer.remaining();
        this.zzc = zzimgVar;
        this.zze = zzimgVar.zzc();
        zzimgVar.zzd(zzimgVar.zzc() + j3);
        this.zzf = zzimgVar.zzc();
        this.zzb = zzaumVar;
    }
}
