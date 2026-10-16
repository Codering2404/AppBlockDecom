package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzatx {
    long zza;
    final String zzb;
    final String zzc;
    final long zzd;
    final long zze;
    final long zzf;
    final long zzg;
    final List zzh;

    private zzatx(String str, String str2, long j3, long j4, long j5, long j6, List list) {
        this.zzb = str;
        this.zzc = true == "".equals(str2) ? null : str2;
        this.zzd = j3;
        this.zze = j4;
        this.zzf = j5;
        this.zzg = j6;
        this.zzh = list;
    }

    static zzatx zza(zzaty zzatyVar) throws IOException {
        if (zzaua.zzi(zzatyVar) != 538247942) {
            throw new IOException();
        }
        String strZzm = zzaua.zzm(zzatyVar);
        String strZzm2 = zzaua.zzm(zzatyVar);
        long jZzk = zzaua.zzk(zzatyVar);
        long jZzk2 = zzaua.zzk(zzatyVar);
        long jZzk3 = zzaua.zzk(zzatyVar);
        long jZzk4 = zzaua.zzk(zzatyVar);
        int iZzi = zzaua.zzi(zzatyVar);
        if (iZzi < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(iZzi).length() + 20);
            sb.append("readHeaderList size=");
            sb.append(iZzi);
            throw new IOException(sb.toString());
        }
        List arrayList = iZzi == 0 ? Collections.EMPTY_LIST : new ArrayList();
        for (int i3 = 0; i3 < iZzi; i3++) {
            arrayList.add(new zzasw(zzaua.zzm(zzatyVar).intern(), zzaua.zzm(zzatyVar).intern()));
        }
        return new zzatx(strZzm, strZzm2, jZzk, jZzk2, jZzk3, jZzk4, arrayList);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    zzatx(String str, zzasn zzasnVar) {
        String str2 = zzasnVar.zzb;
        long j3 = zzasnVar.zzc;
        long j4 = zzasnVar.zzd;
        long j5 = zzasnVar.zze;
        long j6 = zzasnVar.zzf;
        List arrayList = zzasnVar.zzh;
        if (arrayList == null) {
            Map map = zzasnVar.zzg;
            arrayList = new ArrayList(map.size());
            for (Map.Entry entry : map.entrySet()) {
                arrayList.add(new zzasw((String) entry.getKey(), (String) entry.getValue()));
            }
        }
        this(str, str2, j3, j4, j5, j6, arrayList);
    }
}
