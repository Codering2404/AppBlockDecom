package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzglz {
    private final zzaux zza;
    private final long zzb;
    private final long zzc;
    private final String zzd;

    private zzglz(zzaux zzauxVar, long j3, long j4, String str) {
        this.zza = zzauxVar;
        this.zzb = j3;
        this.zzc = j4;
        this.zzd = str;
    }

    static /* synthetic */ zzglz zza(zzaux zzauxVar, byte[] bArr, boolean z2) throws zzauv, zzauz {
        zzauxVar.zza();
        zzauxVar.zzb(bArr);
        List list = (List) zzauxVar.zzc(Optional.empty());
        long jLongValue = ((Long) list.get(0)).longValue();
        long jLongValue2 = ((Long) list.get(1)).longValue();
        long jLongValue3 = ((Long) list.get(2)).longValue();
        zzauxVar.zzd(jLongValue, Optional.empty());
        String strZza = zzgea.zza(zzava.zza(), false);
        int length = strZza.length();
        String str = true != z2 ? "" : "-s";
        StringBuilder sb = new StringBuilder(length + 12 + str.length());
        sb.append("3.878096153.");
        sb.append(strZza);
        sb.append(str);
        return new zzglz(zzauxVar, jLongValue2, jLongValue3, sb.toString());
    }

    final /* synthetic */ String zzb(Map map) {
        return zzgea.zza((byte[]) this.zza.zzd(this.zzb, Optional.of(map)), true);
    }

    final /* synthetic */ void zzc(Map map) throws zzauv, zzauz {
        this.zza.zzd(this.zzc, Optional.of(map));
    }

    final /* synthetic */ String zzd() {
        return this.zzd;
    }
}
