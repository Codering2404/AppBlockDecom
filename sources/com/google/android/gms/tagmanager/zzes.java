package com.google.android.gms.tagmanager;

import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.internal.gtm.zzrr;
import com.google.android.gms.internal.gtm.zzrz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzes {
    private zzrr zzf;
    private final Set zza = new HashSet();
    private final Map zzb = new HashMap();
    private final Map zzd = new HashMap();
    private final Map zzc = new HashMap();
    private final Map zze = new HashMap();

    public final zzrr zza() {
        return this.zzf;
    }

    public final Map zzb() {
        return this.zzd;
    }

    public final Map zzc() {
        return this.zzb;
    }

    public final Map zzd() {
        return this.zze;
    }

    public final Map zze() {
        return this.zzc;
    }

    public final Set zzf() {
        return this.zza;
    }

    public final void zzg(zzrz zzrzVar, zzrr zzrrVar) {
        List arrayList = (List) this.zzb.get(zzrzVar);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.zzb.put(zzrzVar, arrayList);
        }
        arrayList.add(zzrrVar);
    }

    public final void zzh(zzrz zzrzVar, String str) {
        List arrayList = (List) this.zzd.get(zzrzVar);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.zzd.put(zzrzVar, arrayList);
        }
        arrayList.add(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN);
    }

    public final void zzi(zzrz zzrzVar, zzrr zzrrVar) {
        List arrayList = (List) this.zzc.get(zzrzVar);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.zzc.put(zzrzVar, arrayList);
        }
        arrayList.add(zzrrVar);
    }

    public final void zzj(zzrz zzrzVar, String str) {
        List arrayList = (List) this.zze.get(zzrzVar);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.zze.put(zzrzVar, arrayList);
        }
        arrayList.add(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN);
    }

    public final void zzk(zzrz zzrzVar) {
        this.zza.add(zzrzVar);
    }

    public final void zzl(zzrr zzrrVar) {
        this.zzf = zzrrVar;
    }
}
