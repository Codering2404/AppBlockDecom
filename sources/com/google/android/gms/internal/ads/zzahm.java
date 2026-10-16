package com.google.android.gms.internal.ads;

import android.util.Base64;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzahm {
    public static final /* synthetic */ int zza = 0;
    private static final zzhaf zzb = zzhaf.zzb(0, 2, 1);
    private static final zzhaf zzc = zzhaf.zzc(0, 2, 1, 3, 4);
    private static final zzhaf zzd = zzhaf.zzd(0, 2, 1, 5, 3, 4);
    private static final zzhaf zze = zzhaf.zze(0, 2, 1, 6, 5, 3, 4);
    private static final zzhaf zzf = zzhaf.zze(0, 2, 1, 7, 5, 6, 3, 4);

    public static zzhaf zza(int i3) {
        if (i3 == 3) {
            return zzb;
        }
        if (i3 == 5) {
            return zzc;
        }
        if (i3 == 6) {
            return zzd;
        }
        if (i3 == 7) {
            return zze;
        }
        if (i3 != 8) {
            return null;
        }
        return zzf;
    }

    public static zzap zzb(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            String str = (String) list.get(i3);
            String str2 = zzfl.zza;
            String[] strArrSplit = str.split("=", 2);
            if (strArrSplit.length != 2) {
                zzeg.zzc("VorbisUtil", "Failed to parse Vorbis comment: ".concat(str));
            } else if (strArrSplit[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(zzajc.zzb(new zzet(Base64.decode(strArrSplit[1], 0))));
                } catch (RuntimeException e3) {
                    zzeg.zzd("VorbisUtil", "Failed to parse vorbis picture", e3);
                }
            } else {
                arrayList.add(new zzajy(strArrSplit[0], strArrSplit[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzap(arrayList);
    }
}
