package com.google.android.gms.internal.ads;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgla {
    private final File zza;
    private final zzfxb zzb;
    private final zzgqh zzc;

    public zzgla(File file, zzfxb zzfxbVar, zzgqh zzgqhVar) {
        this.zza = file;
        this.zzb = zzfxbVar;
        this.zzc = zzgqhVar;
    }

    public final boolean zza(byte[] bArr) {
        boolean zZza;
        try {
            File file = this.zza;
            zzgzt.zzb(file);
            zzgzt.zza(bArr, file);
            zZza = this.zzb.zza(file);
        } catch (IOException | GeneralSecurityException e3) {
            this.zzc.zzd(2027, e3);
            zZza = false;
        }
        try {
            this.zza.delete();
        } catch (SecurityException unused) {
        }
        return zZza;
    }
}
