package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzff {
    final /* synthetic */ zzfg zza;
    private int zzb;
    private final ByteArrayOutputStream zzc = new ByteArrayOutputStream();

    public zzff(zzfg zzfgVar) {
        this.zza = zzfgVar;
    }

    public final int zza() {
        return this.zzb;
    }

    public final boolean zzb(zzez zzezVar) {
        Preconditions.m(zzezVar);
        int i3 = this.zzb + 1;
        this.zza.zzw();
        if (i3 > zzcv.zzg()) {
            return false;
        }
        String strZza = this.zza.zza(zzezVar, false);
        if (strZza == null) {
            this.zza.zzz().zzb(zzezVar, "Error formatting hit");
            return true;
        }
        byte[] bytes = strZza.getBytes();
        int length = bytes.length;
        this.zza.zzw();
        if (length > zzcv.zzf()) {
            this.zza.zzz().zzb(zzezVar, "Hit size exceeds the maximum size limit");
            return true;
        }
        if (this.zzc.size() > 0) {
            length++;
        }
        int size = this.zzc.size() + length;
        this.zza.zzw();
        if (size > ((Integer) zzew.zzA.zzb()).intValue()) {
            return false;
        }
        try {
            if (this.zzc.size() > 0) {
                this.zzc.write(zzfg.zza);
            }
            this.zzc.write(bytes);
            this.zzb++;
            return true;
        } catch (IOException e3) {
            this.zza.zzJ("Failed to write payload when batching hits", e3);
            return true;
        }
    }

    public final byte[] zzc() {
        return this.zzc.toByteArray();
    }
}
