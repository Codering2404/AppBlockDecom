package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzepd {
    private final Clock zza;
    private final zzepf zzb;
    private final zzfsc zzc;
    private final LinkedHashMap zzd = new LinkedHashMap();
    private final boolean zze = ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhN)).booleanValue();
    private final zzelx zzf;
    private boolean zzg;
    private long zzh;
    private long zzi;

    public zzepd(Clock clock, zzepf zzepfVar, zzelx zzelxVar, zzfsc zzfscVar) {
        this.zza = clock;
        this.zzb = zzepfVar;
        this.zzf = zzelxVar;
        this.zzc = zzfscVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzq, reason: merged with bridge method [inline-methods] */
    public final synchronized boolean zzi(zzfkf zzfkfVar) {
        zzepc zzepcVar = (zzepc) this.zzd.get(zzfkfVar);
        if (zzepcVar == null) {
            return false;
        }
        return zzepcVar.zzc == 8;
    }

    public final synchronized void zza() {
        this.zzi = this.zza.a();
    }

    public final synchronized void zzb() {
        this.zzh = this.zza.a() - this.zzi;
    }

    public final synchronized void zzc(List list) {
        this.zzi = this.zza.a();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzfkf zzfkfVar = (zzfkf) it.next();
            String str = zzfkfVar.zzw;
            if (!TextUtils.isEmpty(str)) {
                this.zzd.put(zzfkfVar, new zzepc(str, zzfkfVar.zzaf, Api.BaseClientBuilder.API_PRIORITY_OTHER, 0L, null));
            }
        }
    }

    public final synchronized void zzd(zzfkf zzfkfVar) {
        try {
            this.zzh = this.zza.a() - this.zzi;
            if (zzfkfVar != null) {
                this.zzf.zzi(zzfkfVar);
            }
            this.zzg = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    final synchronized ListenableFuture zze(zzfkq zzfkqVar, zzfkf zzfkfVar, ListenableFuture listenableFuture, zzfry zzfryVar) {
        zzfki zzfkiVar = zzfkqVar.zzb.zzb;
        long jA = this.zza.a();
        String str = zzfkfVar.zzw;
        if (str != null) {
            this.zzd.put(zzfkfVar, new zzepc(str, zzfkfVar.zzaf, 9, 0L, null));
            zzhbw.zzr(listenableFuture, new zzepb(this, jA, zzfkiVar, zzfkfVar, str, zzfryVar, zzfkqVar), zzcfr.zzh);
        }
        return listenableFuture;
    }

    public final synchronized void zzf(zzfkf zzfkfVar) {
        zzepc zzepcVar = (zzepc) this.zzd.get(zzfkfVar);
        if (zzepcVar == null || this.zzg) {
            return;
        }
        zzepcVar.zzc = 8;
    }

    public final synchronized String zzg() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            Iterator it = this.zzd.entrySet().iterator();
            while (it.hasNext()) {
                zzepc zzepcVar = (zzepc) ((Map.Entry) it.next()).getValue();
                if (zzepcVar.zzc != Integer.MAX_VALUE) {
                    arrayList.add(zzepcVar.toString());
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return TextUtils.join("_", arrayList);
    }

    public final synchronized long zzh() {
        return this.zzh;
    }

    final /* synthetic */ Clock zzj() {
        return this.zza;
    }

    final /* synthetic */ zzepf zzk() {
        return this.zzb;
    }

    final /* synthetic */ zzfsc zzl() {
        return this.zzc;
    }

    final /* synthetic */ LinkedHashMap zzm() {
        return this.zzd;
    }

    final /* synthetic */ boolean zzn() {
        return this.zze;
    }

    final /* synthetic */ zzelx zzo() {
        return this.zzf;
    }

    final /* synthetic */ boolean zzp() {
        return this.zzg;
    }
}
