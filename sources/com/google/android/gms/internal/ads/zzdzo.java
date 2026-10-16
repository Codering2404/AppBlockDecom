package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdzo implements zzfpl {
    private final zzdzg zzb;
    private final Clock zzc;
    private final Map zza = new HashMap();
    private final Map zzd = new HashMap();

    public zzdzo(zzdzg zzdzgVar, Set set, Clock clock) {
        this.zzb = zzdzgVar;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzdzn zzdznVar = (zzdzn) it.next();
            this.zzd.put(zzdznVar.zzc(), zzdznVar);
        }
        this.zzc = clock;
    }

    private final void zze(zzfpe zzfpeVar, boolean z2) {
        zzdzn zzdznVar = (zzdzn) this.zzd.get(zzfpeVar);
        if (zzdznVar == null) {
            return;
        }
        String str = true != z2 ? "f." : "s.";
        Map map = this.zza;
        zzfpe zzfpeVarZzb = zzdznVar.zzb();
        if (map.containsKey(zzfpeVarZzb)) {
            long jA = this.zzc.a() - ((Long) map.get(zzfpeVarZzb)).longValue();
            zzdzg zzdzgVar = this.zzb;
            String strZza = zzdznVar.zza();
            Map mapZzc = zzdzgVar.zzc();
            StringBuilder sb = new StringBuilder(String.valueOf(jA).length() + 2);
            sb.append(str);
            sb.append(jA);
            mapZzc.put("label.".concat(strZza), sb.toString());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfpl
    public final void zzdM(zzfpe zzfpeVar, String str) {
        this.zza.put(zzfpeVar, Long.valueOf(this.zzc.a()));
    }

    @Override // com.google.android.gms.internal.ads.zzfpl
    public final void zzdN(zzfpe zzfpeVar, String str, Throwable th) {
        Map map = this.zza;
        if (map.containsKey(zzfpeVar)) {
            long jA = this.zzc.a() - ((Long) map.get(zzfpeVar)).longValue();
            this.zzb.zzc().put("task.".concat(String.valueOf(str)), "f.".concat(String.valueOf(Long.toString(jA))));
        }
        if (this.zzd.containsKey(zzfpeVar)) {
            zze(zzfpeVar, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfpl
    public final void zzdO(zzfpe zzfpeVar, String str) {
        Map map = this.zza;
        if (map.containsKey(zzfpeVar)) {
            long jA = this.zzc.a() - ((Long) map.get(zzfpeVar)).longValue();
            this.zzb.zzc().put("task.".concat(String.valueOf(str)), "s.".concat(String.valueOf(Long.toString(jA))));
        }
        if (this.zzd.containsKey(zzfpeVar)) {
            zze(zzfpeVar, true);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfpl
    public final void zzdL(zzfpe zzfpeVar, String str) {
    }
}
