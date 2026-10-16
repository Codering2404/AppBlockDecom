package com.google.android.gms.internal.ads;

import android.content.pm.ApkChecksum;
import android.content.pm.PackageManager$OnChecksumsReadyListener;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzazk implements PackageManager$OnChecksumsReadyListener {
    final zzhcp zza = zzhcp.zze();

    public final void onChecksumsReady(List list) {
        int size;
        int i3;
        if (list == null) {
            this.zza.zza("");
            return;
        }
        try {
            size = list.size();
        } catch (Throwable unused) {
        }
        for (i3 = 0; i3 < size; i3++) {
            ApkChecksum apkChecksumA = k.a(list.get(i3));
            if (apkChecksumA.getType() == 8) {
                zzhcp zzhcpVar = this.zza;
                zzgzh zzgzhVarZzi = zzgzh.zzn().zzi();
                byte[] value = apkChecksumA.getValue();
                zzhcpVar.zza(zzgzhVarZzi.zzj(value, 0, value.length));
                return;
            }
            this.zza.zza("");
        }
        this.zza.zza("");
    }
}
