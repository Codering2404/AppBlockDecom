package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.common.util.Hex;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfyq {
    final File zza;
    private final File zzb;
    private final SharedPreferences zzc;
    private final zzbds zzd;

    public zzfyq(Context context, zzbds zzbdsVar) {
        this.zzc = context.getSharedPreferences("pcvmspf", 0);
        File dir = context.getDir("pccache", 0);
        zzfyr.zzd(dir, false);
        this.zzb = dir;
        File dir2 = context.getDir("tmppccache", 0);
        zzfyr.zzd(dir2, true);
        this.zza = dir2;
        this.zzd = zzbdsVar;
    }

    private final File zzd() {
        File file = new File(this.zzb, Integer.toString(this.zzd.zza()));
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    private final String zze() {
        int iZza = this.zzd.zza();
        StringBuilder sb = new StringBuilder(String.valueOf(iZza).length() + 6);
        sb.append("FBAMTD");
        sb.append(iZza);
        return sb.toString();
    }

    private final String zzf() {
        int iZza = this.zzd.zza();
        StringBuilder sb = new StringBuilder(String.valueOf(iZza).length() + 6);
        sb.append("LATMTD");
        sb.append(iZza);
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zza(com.google.android.gms.internal.ads.zzbdu r9, com.google.android.gms.internal.ads.zzfyw r10) {
        /*
            Method dump skipped, instruction units count: 371
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfyq.zza(com.google.android.gms.internal.ads.zzbdu, com.google.android.gms.internal.ads.zzfyw):boolean");
    }

    public final zzfyp zzb(int i3) {
        zzbeb zzbebVarZzc = zzc(1);
        if (zzbebVarZzc == null) {
            return null;
        }
        String strZza = zzbebVarZzc.zza();
        File fileZza = zzfyr.zza(strZza, "pcam.jar", zzd());
        if (!fileZza.exists()) {
            fileZza = zzfyr.zza(strZza, "pcam", zzd());
        }
        return new zzfyp(zzbebVarZzc, fileZza, zzfyr.zza(strZza, "pcbc", zzd()), zzfyr.zza(strZza, "pcopt", zzd()));
    }

    final zzbeb zzc(int i3) {
        String string = i3 == 1 ? this.zzc.getString(zzf(), null) : this.zzc.getString(zze(), null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            byte[] bArrD = Hex.d(string);
            zzida zzidaVar = zzida.zza;
            zzbeb zzbebVarZzg = zzbeb.zzg(zzida.zzt(bArrD, 0, bArrD.length));
            String strZza = zzbebVarZzg.zza();
            File fileZza = zzfyr.zza(strZza, "pcam.jar", zzd());
            if (!fileZza.exists()) {
                fileZza = zzfyr.zza(strZza, "pcam", zzd());
            }
            File fileZza2 = zzfyr.zza(strZza, "pcbc", zzd());
            if (fileZza.exists()) {
                if (fileZza2.exists()) {
                    return zzbebVarZzg;
                }
            }
        } catch (zziet unused) {
        }
        return null;
    }
}
