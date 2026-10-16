package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfbq implements zzfck {
    public static final /* synthetic */ int zzb = 0;
    private static final zzfbr zzc = new zzfbr(new JSONArray().toString(), new Bundle(), "");
    final String zza;
    private final zzhcg zzd;
    private final ScheduledExecutorService zze;
    private final zzerw zzf;
    private final Context zzg;
    private final zzfky zzh;
    private final zzerr zzi;
    private final zzdxc zzj;
    private final zzeby zzk;

    zzfbq(zzhcg zzhcgVar, ScheduledExecutorService scheduledExecutorService, String str, zzerw zzerwVar, Context context, zzfky zzfkyVar, zzerr zzerrVar, zzdxc zzdxcVar, zzeby zzebyVar) {
        this.zzd = zzhcgVar;
        this.zze = scheduledExecutorService;
        this.zza = str;
        this.zzf = zzerwVar;
        this.zzg = context;
        this.zzh = zzfkyVar;
        this.zzi = zzerrVar;
        this.zzj = zzdxcVar;
        this.zzk = zzebyVar;
    }

    private final void zzf(List list, Map map) {
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            zzesa zzesaVar = (zzesa) ((Map.Entry) it.next()).getValue();
            String str = zzesaVar.zza;
            list.add(zzh(str, Collections.singletonList(zzesaVar.zze), zzg(str), zzesaVar.zzb, zzesaVar.zzc));
        }
    }

    private final Bundle zzg(String str) {
        Bundle bundle = this.zzh.zzd.f69976n;
        if (bundle != null) {
            return bundle.getBundle(str);
        }
        return null;
    }

    private final zzhbo zzh(final String str, final List list, final Bundle bundle, final boolean z2, final boolean z3) {
        zzhbd zzhbdVar = new zzhbd() { // from class: com.google.android.gms.internal.ads.zzfbl
            @Override // com.google.android.gms.internal.ads.zzhbd
            public final /* synthetic */ ListenableFuture zza() {
                return this.zza.zzd(str, list, bundle, z2, z3);
            }
        };
        zzhcg zzhcgVar = this.zzd;
        zzhbo zzhboVarZzw = zzhbo.zzw(zzhbw.zzf(zzhbdVar, zzhcgVar));
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzck)).booleanValue()) {
            zzhboVarZzw = (zzhbo) zzhbw.zzi(zzhboVarZzw, ((Long) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcd)).longValue(), TimeUnit.MILLISECONDS, this.zze);
        }
        return (zzhbo) zzhbw.zzg(zzhboVarZzw, Throwable.class, new zzgta() { // from class: com.google.android.gms.internal.ads.zzfbm
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj) {
                Throwable th = (Throwable) obj;
                int i3 = zzfbq.zzb;
                String str2 = str;
                int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.c("Error calling adapter: ".concat(String.valueOf(str2)));
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzoA)).booleanValue()) {
                    com.google.android.gms.ads.internal.zzt.l().zzh(th, "rtbSignal.fetchRtbJsonInfo-".concat(String.valueOf(str2)));
                    return null;
                }
                com.google.android.gms.ads.internal.zzt.l().zzg(th, "rtbSignal.fetchRtbJsonInfo-".concat(String.valueOf(str2)));
                return null;
            }
        }, zzhcgVar);
    }

    private final void zzi(zzbxb zzbxbVar, Bundle bundle, List list, zzerz zzerzVar) throws RemoteException {
        zzbxbVar.zze(ObjectWrapper.i5(this.zzg), this.zza, bundle, (Bundle) list.get(0), this.zzh.zzf, zzerzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        zzfky zzfkyVar = this.zzh;
        if (zzfkyVar.zzs) {
            if (!Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcq)).split(",")).contains(com.google.android.gms.ads.nonagon.signalgeneration.zzv.b(com.google.android.gms.ads.nonagon.signalgeneration.zzv.c(zzfkyVar.zzd)))) {
                return zzhbw.zza(zzc);
            }
        }
        return zzhbw.zzf(new zzhbd() { // from class: com.google.android.gms.internal.ads.zzfbo
            @Override // com.google.android.gms.internal.ads.zzhbd
            public final /* synthetic */ ListenableFuture zza() {
                return this.zza.zzc();
            }
        }, this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 32;
    }

    final /* synthetic */ ListenableFuture zzc() {
        final String str;
        zzfbq zzfbqVar;
        String lowerCase = ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzmp)).booleanValue() ? this.zzh.zzg.toLowerCase(Locale.ROOT) : this.zzh.zzg;
        final Bundle bundleZzg = ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzco)).booleanValue() ? this.zzk.zzg() : new Bundle();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzfd)).booleanValue()) {
            int iZzk = com.google.android.gms.ads.internal.zzt.l().zzo().zzi().zzk();
            str = iZzk != 1 ? iZzk != 2 ? "EMPTY" : "INVALID" : "VALID";
        } else {
            str = "";
        }
        final ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = this.zzh.zzw;
        if (jSONArray != null) {
            HashMap map = new HashMap();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("rtb_adapters");
                    String string = (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) ? "" : jSONArrayOptJSONArray.getString(0);
                    if (!TextUtils.isEmpty(string)) {
                        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                        Bundle bundle = new Bundle();
                        if (jSONObjectOptJSONObject != null) {
                            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                            while (itKeys.hasNext()) {
                                String next = itKeys.next();
                                bundle.putString(next, jSONObjectOptJSONObject.optString(next, ""));
                            }
                        }
                        map.put(string, new zzesa(string, true, true, false, bundle));
                    }
                } catch (JSONException e3) {
                    com.google.android.gms.ads.internal.zzt.l().zzg(new JSONException("Malformed RTB adapter config."), "RecursiveRtbAdapterMap.parseAdapters");
                    com.google.android.gms.ads.internal.util.zze.l("Malformed RTB adapter config.", e3);
                }
            }
            zzf(arrayList, map);
            zzfbqVar = this;
        } else if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcx)).booleanValue()) {
            zzfbqVar = this;
            zzf(arrayList, zzfbqVar.zzf.zzd(zzfbqVar.zza, lowerCase));
        } else {
            zzerw zzerwVar = this.zzf;
            for (Map.Entry entry : zzerwVar.zzc(this.zza, lowerCase).entrySet()) {
                String str2 = (String) entry.getKey();
                arrayList.add(zzh(str2, (List) entry.getValue(), zzg(str2), true, true));
            }
            zzfbqVar = this;
            zzf(arrayList, zzerwVar.zzb());
        }
        return zzhbw.zzp(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzfbk
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                int i4 = zzfbq.zzb;
                JSONArray jSONArray2 = new JSONArray();
                for (ListenableFuture listenableFuture : arrayList) {
                    if (((JSONObject) listenableFuture.get()) != null) {
                        jSONArray2.put(listenableFuture.get());
                    }
                }
                String str3 = str;
                Bundle bundle2 = bundleZzg;
                if (jSONArray2.length() != 0) {
                    return new zzfbr(jSONArray2.toString(), bundle2, str3);
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzfd)).booleanValue()) {
                    return new zzfbr(new JSONArray().toString(), bundle2, str3);
                }
                return null;
            }
        }, zzfbqVar.zzd);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0025 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final /* synthetic */ com.google.common.util.concurrent.ListenableFuture zzd(java.lang.String r8, final java.util.List r9, final android.os.Bundle r10, boolean r11, boolean r12) throws android.os.RemoteException {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzcfw r3 = new com.google.android.gms.internal.ads.zzcfw
            r3.<init>()
            r1 = 0
            if (r12 == 0) goto L25
            com.google.android.gms.internal.ads.zzbih r12 = com.google.android.gms.internal.ads.zzbiq.zzcp
            com.google.android.gms.internal.ads.zzbio r0 = com.google.android.gms.ads.internal.client.zzba.c()
            java.lang.Object r12 = r0.zzd(r12)
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 != 0) goto L25
            com.google.android.gms.internal.ads.zzerr r12 = r7.zzi
            r12.zza(r8)
            com.google.android.gms.internal.ads.zzbxb r12 = r12.zzb(r8)
        L23:
            r2 = r12
            goto L34
        L25:
            com.google.android.gms.internal.ads.zzdxc r12 = r7.zzj     // Catch: android.os.RemoteException -> L2c
            com.google.android.gms.internal.ads.zzbxb r12 = r12.zzb(r8)     // Catch: android.os.RemoteException -> L2c
            goto L23
        L2c:
            r0 = move-exception
            r12 = r0
            java.lang.String r0 = "Couldn't create RTB adapter : "
            com.google.android.gms.ads.internal.util.zze.l(r0, r12)
            r2 = r1
        L34:
            if (r2 != 0) goto L4f
            com.google.android.gms.internal.ads.zzbih r9 = com.google.android.gms.internal.ads.zzbiq.zzcf
            com.google.android.gms.internal.ads.zzbio r10 = com.google.android.gms.ads.internal.client.zzba.c()
            java.lang.Object r9 = r10.zzd(r9)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L4e
            com.google.android.gms.internal.ads.zzerz.zzd(r8, r3)
            r1 = r7
            goto Lbb
        L4e:
            throw r1
        L4f:
            com.google.android.gms.internal.ads.zzerz r0 = new com.google.android.gms.internal.ads.zzerz
            com.google.android.gms.common.util.Clock r12 = com.google.android.gms.ads.internal.zzt.o()
            long r4 = r12.a()
            r1 = r8
            r0.<init>(r1, r2, r3, r4)
            com.google.android.gms.internal.ads.zzbih r8 = com.google.android.gms.internal.ads.zzbiq.zzck
            com.google.android.gms.internal.ads.zzbio r12 = com.google.android.gms.ads.internal.client.zzba.c()
            java.lang.Object r8 = r12.zzd(r8)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L8b
            java.util.concurrent.ScheduledExecutorService r8 = r7.zze
            com.google.android.gms.internal.ads.zzfbp r12 = new com.google.android.gms.internal.ads.zzfbp
            r12.<init>()
            com.google.android.gms.internal.ads.zzbih r1 = com.google.android.gms.internal.ads.zzbiq.zzcd
            com.google.android.gms.internal.ads.zzbio r4 = com.google.android.gms.ads.internal.client.zzba.c()
            java.lang.Object r1 = r4.zzd(r1)
            java.lang.Long r1 = (java.lang.Long) r1
            long r4 = r1.longValue()
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.MILLISECONDS
            r8.schedule(r12, r4, r1)
        L8b:
            if (r11 == 0) goto Lb7
            com.google.android.gms.internal.ads.zzbih r8 = com.google.android.gms.internal.ads.zzbiq.zzcr
            com.google.android.gms.internal.ads.zzbio r11 = com.google.android.gms.ads.internal.client.zzba.c()
            java.lang.Object r8 = r11.zzd(r8)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto Lb0
            com.google.android.gms.internal.ads.zzhcg r8 = r7.zzd
            r5 = r0
            com.google.android.gms.internal.ads.zzfbn r0 = new com.google.android.gms.internal.ads.zzfbn
            r1 = r7
            r4 = r9
            r6 = r3
            r3 = r10
            r0.<init>()
            r3 = r6
            r8.submit(r0)
            goto Lbb
        Lb0:
            r1 = r7
            r4 = r9
            r8 = r10
            r7.zzi(r2, r8, r4, r0)
            goto Lbb
        Lb7:
            r1 = r7
            r0.zzb()
        Lbb:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfbq.zzd(java.lang.String, java.util.List, android.os.Bundle, boolean, boolean):com.google.common.util.concurrent.ListenableFuture");
    }

    final /* synthetic */ void zze(zzbxb zzbxbVar, Bundle bundle, List list, zzerz zzerzVar, zzcfw zzcfwVar) {
        try {
            zzi(zzbxbVar, bundle, list, zzerzVar);
        } catch (RemoteException e3) {
            zzcfwVar.zzd(e3);
        }
    }
}
