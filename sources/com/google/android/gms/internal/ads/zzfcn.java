package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfcn {
    private final Context zza;
    private final Set zzb;
    private final Executor zzc;
    private final zzfqg zzd;

    public zzfcn(Context context, Executor executor, Set set, zzfqg zzfqgVar) {
        this.zza = context;
        this.zzc = executor;
        this.zzb = set;
        this.zzd = zzfqgVar;
    }

    public final ListenableFuture zza(final Object obj, final Bundle bundle) {
        zzfpw zzfpwVarZzn = zzfpw.zzn(this.zza, 8);
        zzfpwVarZzn.zza();
        Set<zzfck> set = this.zzb;
        final ArrayList arrayList = new ArrayList(set.size());
        List arrayList2 = new ArrayList();
        zzbih zzbihVar = zzbiq.zzni;
        if (!((String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbihVar)).isEmpty()) {
            arrayList2 = Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbihVar)).split(","));
        }
        final Bundle bundle2 = new Bundle();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcN)).booleanValue() && bundle != null) {
            long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.o().currentTimeMillis();
            if (obj instanceof Bundle) {
                bundle.putLong(zzdyu.CLIENT_SIGNALS_START.zza(), jCurrentTimeMillis);
            } else {
                bundle.putLong(zzdyu.GMS_SIGNALS_START.zza(), jCurrentTimeMillis);
            }
        }
        for (final zzfck zzfckVar : set) {
            if (!arrayList2.contains(String.valueOf(zzfckVar.zzb()))) {
                final long jA = com.google.android.gms.ads.internal.zzt.o().a();
                ListenableFuture listenableFutureZza = zzfckVar.zza();
                listenableFutureZza.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfcl
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        long jA2 = com.google.android.gms.ads.internal.zzt.o().a() - jA;
                        boolean zBooleanValue = ((Boolean) zzbks.zza.zze()).booleanValue();
                        Bundle bundle3 = bundle2;
                        zzfck zzfckVar2 = zzfckVar;
                        if (zBooleanValue) {
                            String strZza = zzgua.zza(zzfckVar2.getClass().getCanonicalName());
                            StringBuilder sb = new StringBuilder(strZza.length() + 25 + String.valueOf(jA2).length());
                            sb.append("Signal runtime (ms) : ");
                            sb.append(strZza);
                            sb.append(" = ");
                            sb.append(jA2);
                            com.google.android.gms.ads.internal.util.zze.k(sb.toString());
                        }
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcN)).booleanValue()) {
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcT)).booleanValue()) {
                                synchronized (this.zza) {
                                    int iZzb = zzfckVar2.zzb();
                                    StringBuilder sb2 = new StringBuilder(String.valueOf(iZzb).length() + 3);
                                    sb2.append("sig");
                                    sb2.append(iZzb);
                                    bundle3.putLong(sb2.toString(), jA2);
                                }
                            }
                        }
                    }
                }, zzcfr.zzh);
                arrayList.add(listenableFutureZza);
            }
        }
        ListenableFuture listenableFutureZza2 = zzhbw.zzp(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzfcm
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                Object obj2;
                Bundle bundle3;
                Iterator it = arrayList.iterator();
                while (true) {
                    obj2 = obj;
                    if (!it.hasNext()) {
                        break;
                    }
                    zzfci zzfciVar = (zzfci) ((ListenableFuture) it.next()).get();
                    if (zzfciVar != null) {
                        zzfciVar.zza(obj2);
                    }
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcN)).booleanValue() && (bundle3 = bundle) != null) {
                    Bundle bundle4 = bundle2;
                    long jCurrentTimeMillis2 = com.google.android.gms.ads.internal.zzt.o().currentTimeMillis();
                    if (obj2 instanceof Bundle) {
                        bundle3.putLong(zzdyu.CLIENT_SIGNALS_END.zza(), jCurrentTimeMillis2);
                        bundle3.putBundle("client_sig_latency_key", bundle4);
                        return obj2;
                    }
                    bundle3.putLong(zzdyu.GMS_SIGNALS_END.zza(), jCurrentTimeMillis2);
                    bundle3.putBundle("gms_sig_latency_key", bundle4);
                }
                return obj2;
            }
        }, this.zzc);
        if (zzfqj.zza()) {
            zzfqf.zzd(listenableFutureZza2, this.zzd, zzfpwVarZzn);
        }
        return listenableFutureZza2;
    }
}
