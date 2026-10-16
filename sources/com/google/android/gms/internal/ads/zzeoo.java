package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzeoo {
    private final zzhcp zzc;
    private zzepe zzf;
    private final String zzh;
    private final int zzi;
    private final zzepd zzj;
    private zzfkf zzk;
    private final Map zza = new HashMap();
    private final List zzb = new ArrayList();
    private final List zzd = new ArrayList();
    private final Set zze = new HashSet();
    private int zzg = Api.BaseClientBuilder.API_PRIORITY_OTHER;
    private boolean zzl = false;

    zzeoo(zzfkq zzfkqVar, zzepd zzepdVar, zzhcp zzhcpVar) {
        this.zzi = zzfkqVar.zzb.zzb.zzr;
        this.zzj = zzepdVar;
        this.zzc = zzhcpVar;
        this.zzh = zzepk.zzb(zzfkqVar);
        List list = zzfkqVar.zzb.zza;
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.zza.put((zzfkf) list.get(i3), Integer.valueOf(i3));
        }
        this.zzb.addAll(list);
    }

    private final synchronized boolean zze() {
        if (this.zzl) {
            return false;
        }
        List list = this.zzb;
        if (!list.isEmpty() && ((zzfkf) list.get(0)).zzav && !this.zzd.isEmpty()) {
            return false;
        }
        if (!zzd()) {
            List list2 = this.zzd;
            if (list2.size() < this.zzi) {
                if (zzf(false)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final synchronized boolean zzf(boolean z2) {
        try {
            for (zzfkf zzfkfVar : this.zzb) {
                Integer num = (Integer) this.zza.get(zzfkfVar);
                int iIntValue = num != null ? num.intValue() : Api.BaseClientBuilder.API_PRIORITY_OTHER;
                if (z2 || !this.zze.contains(zzfkfVar.zzat)) {
                    int i3 = this.zzg;
                    if (iIntValue < i3) {
                        return true;
                    }
                    if (iIntValue > i3) {
                        break;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized boolean zzg() {
        try {
            Iterator it = this.zzd.iterator();
            while (it.hasNext()) {
                Integer num = (Integer) this.zza.get((zzfkf) it.next());
                if ((num != null ? num.intValue() : Api.BaseClientBuilder.API_PRIORITY_OTHER) < this.zzg) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized boolean zzh() {
        if (!zzf(true)) {
            if (!zzg()) {
                return false;
            }
        }
        return true;
    }

    private final synchronized void zzi() {
        this.zzj.zzd(this.zzk);
        zzepe zzepeVar = this.zzf;
        if (zzepeVar != null) {
            this.zzc.zza(zzepeVar);
        } else {
            this.zzc.zzb(new zzeph(3, this.zzh));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        if (r2.zzav == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
    
        r6.zzl = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0031, code lost:
    
        if (android.text.TextUtils.isEmpty(r3) != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0033, code lost:
    
        r4.add(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0036, code lost:
    
        r6.zzd.add(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0042, code lost:
    
        return (com.google.android.gms.internal.ads.zzfkf) r1.remove(r0);
     */
    @javax.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final synchronized com.google.android.gms.internal.ads.zzfkf zza() {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.zze()     // Catch: java.lang.Throwable -> L2b
            if (r0 == 0) goto L43
            r0 = 0
        L8:
            java.util.List r1 = r6.zzb     // Catch: java.lang.Throwable -> L2b
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L2b
            if (r0 >= r2) goto L43
            java.lang.Object r2 = r1.get(r0)     // Catch: java.lang.Throwable -> L2b
            com.google.android.gms.internal.ads.zzfkf r2 = (com.google.android.gms.internal.ads.zzfkf) r2     // Catch: java.lang.Throwable -> L2b
            java.lang.String r3 = r2.zzat     // Catch: java.lang.Throwable -> L2b
            java.util.Set r4 = r6.zze     // Catch: java.lang.Throwable -> L2b
            boolean r5 = r4.contains(r3)     // Catch: java.lang.Throwable -> L2b
            if (r5 == 0) goto L23
            int r0 = r0 + 1
            goto L8
        L23:
            boolean r5 = r2.zzav     // Catch: java.lang.Throwable -> L2b
            if (r5 == 0) goto L2d
            r5 = 1
            r6.zzl = r5     // Catch: java.lang.Throwable -> L2b
            goto L2d
        L2b:
            r0 = move-exception
            goto L46
        L2d:
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L2b
            if (r5 != 0) goto L36
            r4.add(r3)     // Catch: java.lang.Throwable -> L2b
        L36:
            java.util.List r3 = r6.zzd     // Catch: java.lang.Throwable -> L2b
            r3.add(r2)     // Catch: java.lang.Throwable -> L2b
            java.lang.Object r0 = r1.remove(r0)     // Catch: java.lang.Throwable -> L2b
            com.google.android.gms.internal.ads.zzfkf r0 = (com.google.android.gms.internal.ads.zzfkf) r0     // Catch: java.lang.Throwable -> L2b
            monitor-exit(r6)
            return r0
        L43:
            monitor-exit(r6)
            r0 = 0
            return r0
        L46:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L2b
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeoo.zza():com.google.android.gms.internal.ads.zzfkf");
    }

    final synchronized void zzb(zzepe zzepeVar, zzfkf zzfkfVar) {
        this.zzl = false;
        this.zzd.remove(zzfkfVar);
        if (zzd()) {
            zzepeVar.zzm();
            return;
        }
        Integer num = (Integer) this.zza.get(zzfkfVar);
        int iIntValue = num != null ? num.intValue() : Api.BaseClientBuilder.API_PRIORITY_OTHER;
        if (iIntValue > this.zzg) {
            this.zzj.zzf(zzfkfVar);
            return;
        }
        if (this.zzf != null) {
            this.zzj.zzf(this.zzk);
        }
        this.zzg = iIntValue;
        this.zzf = zzepeVar;
        this.zzk = zzfkfVar;
        if (zzh()) {
            return;
        }
        zzi();
    }

    final synchronized void zzc(Throwable th, zzfkf zzfkfVar) {
        this.zzl = false;
        this.zzd.remove(zzfkfVar);
        this.zze.remove(zzfkfVar.zzat);
        if (zzd() || zzh()) {
            return;
        }
        zzi();
    }

    final synchronized boolean zzd() {
        return this.zzc.isDone();
    }
}
