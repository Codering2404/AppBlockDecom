package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzalu {
    public static String zza(List list) {
        Iterator it = list.iterator();
        String str = null;
        boolean z2 = false;
        while (it.hasNext()) {
            String str2 = ((zzaml) it.next()).zza.zzg.zzp;
            if (zzas.zzb(str2)) {
                return "video/mp4";
            }
            if (zzas.zza(str2)) {
                z2 = true;
            } else if (zzas.zzc(str2)) {
                if (Objects.equals(str2, "image/heic")) {
                    str = "image/heif";
                } else if (Objects.equals(str2, "image/avif")) {
                    str = "image/avif";
                }
            }
        }
        return z2 ? "audio/mp4" : str != null ? str : "application/mp4";
    }
}
