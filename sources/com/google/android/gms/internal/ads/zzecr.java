package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.os.RemoteException;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.sdk.AppLovinMediationProvider;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzecr implements zzedt, zzecc {
    private final zzedc zza;
    private final zzedu zzb;
    private final zzecd zzc;
    private final zzecm zzd;
    private final zzecb zze;
    private final zzedo zzf;
    private final zzecy zzg;
    private final zzecy zzh;
    private final String zzi;
    private final Context zzj;

    @Nullable
    private final String zzk;
    private JSONObject zzp;
    private boolean zzs;
    private int zzt;
    private boolean zzu;
    private final Map zzl = new HashMap();
    private final Map zzm = new HashMap();
    private final Map zzn = new HashMap();
    private String zzo = JsonUtils.EMPTY_JSON;
    private long zzq = Long.MAX_VALUE;
    private zzecn zzr = zzecn.NONE;
    private zzecq zzv = zzecq.UNKNOWN;
    private long zzw = 0;
    private String zzx = "";

    zzecr(zzedc zzedcVar, zzedu zzeduVar, zzecd zzecdVar, Context context, VersionInfoParcel versionInfoParcel, zzecm zzecmVar, zzedo zzedoVar, zzecy zzecyVar, zzecy zzecyVar2, @Nullable String str) {
        this.zza = zzedcVar;
        this.zzb = zzeduVar;
        this.zzc = zzecdVar;
        this.zze = new zzecb(context);
        this.zzi = versionInfoParcel.f70149a;
        this.zzk = str;
        this.zzd = zzecmVar;
        this.zzf = zzedoVar;
        this.zzg = zzecyVar;
        this.zzh = zzecyVar2;
        this.zzj = context;
        com.google.android.gms.ads.internal.zzt.s().a(this);
    }

    private final synchronized void zzA(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            zzt(jSONObject.optBoolean("isTestMode", false), false);
            zzu((zzecn) Enum.valueOf(zzecn.class, jSONObject.optString("gesture", "NONE")), false);
            this.zzo = jSONObject.optString("networkExtras", JsonUtils.EMPTY_JSON);
            this.zzq = jSONObject.optLong("networkExtrasExpirationSecs", Long.MAX_VALUE);
        } catch (JSONException unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d A[Catch: all -> 0x0027, TryCatch #0 {all -> 0x0027, blocks: (B:3:0x0001, B:6:0x0006, B:8:0x000a, B:10:0x001c, B:15:0x0029, B:20:0x0038, B:16:0x002d, B:18:0x0033), top: B:27:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final synchronized void zzt(boolean r2, boolean r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.zzs     // Catch: java.lang.Throwable -> L27
            if (r0 != r2) goto L6
            goto L3d
        L6:
            r1.zzs = r2     // Catch: java.lang.Throwable -> L27
            if (r2 == 0) goto L2d
            com.google.android.gms.internal.ads.zzbih r2 = com.google.android.gms.internal.ads.zzbiq.zzkD     // Catch: java.lang.Throwable -> L27
            com.google.android.gms.internal.ads.zzbio r0 = com.google.android.gms.ads.internal.client.zzba.c()     // Catch: java.lang.Throwable -> L27
            java.lang.Object r2 = r0.zzd(r2)     // Catch: java.lang.Throwable -> L27
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch: java.lang.Throwable -> L27
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> L27
            if (r2 == 0) goto L29
            com.google.android.gms.ads.internal.util.zzax r2 = com.google.android.gms.ads.internal.zzt.s()     // Catch: java.lang.Throwable -> L27
            boolean r2 = r2.k()     // Catch: java.lang.Throwable -> L27
            if (r2 != 0) goto L2d
            goto L29
        L27:
            r2 = move-exception
            goto L3f
        L29:
            r1.zzx()     // Catch: java.lang.Throwable -> L27
            goto L36
        L2d:
            boolean r2 = r1.zzs()     // Catch: java.lang.Throwable -> L27
            if (r2 != 0) goto L36
            r1.zzy()     // Catch: java.lang.Throwable -> L27
        L36:
            if (r3 == 0) goto L3d
            r1.zzz()     // Catch: java.lang.Throwable -> L27
            monitor-exit(r1)
            return
        L3d:
            monitor-exit(r1)
            return
        L3f:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L27
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzecr.zzt(boolean, boolean):void");
    }

    private final synchronized void zzu(zzecn zzecnVar, boolean z2) {
        try {
            if (this.zzr != zzecnVar) {
                if (zzs()) {
                    zzy();
                }
                this.zzr = zzecnVar;
                if (zzs()) {
                    zzx();
                }
                if (z2) {
                    zzz();
                }
            }
        } finally {
        }
    }

    private final synchronized JSONObject zzv() throws JSONException {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            for (Map.Entry entry : this.zzl.entrySet()) {
                JSONArray jSONArray = new JSONArray();
                for (zzecf zzecfVar : (List) entry.getValue()) {
                    if (zzecfVar.zzc()) {
                        jSONArray.put(zzecfVar.zzg());
                    }
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put((String) entry.getKey(), jSONArray);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return jSONObject;
    }

    private final void zzw() {
        this.zzu = true;
        this.zzd.zza();
        this.zza.zzl(this);
        this.zzb.zza(this);
        this.zzc.zza(this);
        this.zzf.zzb(this);
        zzbih zzbihVar = zzbiq.zzkS;
        if (!TextUtils.isEmpty((CharSequence) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbihVar))) {
            this.zzg.zza(PreferenceManager.getDefaultSharedPreferences(this.zzj), Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbihVar)).split(",")));
        }
        zzbih zzbihVar2 = zzbiq.zzkT;
        if (!TextUtils.isEmpty((CharSequence) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbihVar2))) {
            this.zzh.zza(this.zzj.getSharedPreferences(AppLovinMediationProvider.ADMOB, 0), Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbihVar2)).split(",")));
        }
        zzA(com.google.android.gms.ads.internal.zzt.l().zzo().zzH());
        this.zzx = com.google.android.gms.ads.internal.zzt.l().zzo().zzN();
    }

    private final synchronized void zzx() {
        int iOrdinal = this.zzr.ordinal();
        if (iOrdinal == 1) {
            this.zzb.zzb();
        } else {
            if (iOrdinal != 2) {
                return;
            }
            this.zzc.zzb();
        }
    }

    private final synchronized void zzy() {
        int iOrdinal = this.zzr.ordinal();
        if (iOrdinal == 1) {
            this.zzb.zzc();
        } else {
            if (iOrdinal != 2) {
                return;
            }
            this.zzc.zzc();
        }
    }

    private final void zzz() {
        com.google.android.gms.ads.internal.zzt.l().zzo().c(zzh());
    }

    public final void zza() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzko)).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkD)).booleanValue() && com.google.android.gms.ads.internal.zzt.l().zzo().zzJ()) {
                zzw();
                return;
            }
            String strZzH = com.google.android.gms.ads.internal.zzt.l().zzo().zzH();
            if (TextUtils.isEmpty(strZzH)) {
                return;
            }
            try {
                if (new JSONObject(strZzH).optBoolean("isTestMode", false)) {
                    zzw();
                }
            } catch (JSONException unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzb(boolean r2) {
        /*
            r1 = this;
            boolean r0 = r1.zzu
            if (r0 != 0) goto La
            if (r2 == 0) goto L14
            r1.zzw()
            goto Lc
        La:
            if (r2 == 0) goto L14
        Lc:
            boolean r2 = r1.zzs
            if (r2 != 0) goto L14
            r1.zzx()
            return
        L14:
            boolean r2 = r1.zzs()
            if (r2 != 0) goto L1d
            r1.zzy()
        L1d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzecr.zzb(boolean):void");
    }

    public final void zzc(boolean z2) {
        if (!this.zzu && z2) {
            zzw();
        }
        zzt(z2, true);
    }

    public final synchronized boolean zzd() {
        return this.zzs;
    }

    public final void zze(zzecn zzecnVar) {
        zzu(zzecnVar, true);
    }

    public final zzecn zzf() {
        return this.zzr;
    }

    public final synchronized String zzg() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzko)).booleanValue() && zzs()) {
            if (this.zzq < com.google.android.gms.ads.internal.zzt.o().currentTimeMillis() / 1000) {
                this.zzo = JsonUtils.EMPTY_JSON;
                this.zzq = Long.MAX_VALUE;
                return "";
            }
            if (!this.zzo.equals(JsonUtils.EMPTY_JSON)) {
                return this.zzo;
            }
        }
        return "";
    }

    public final synchronized String zzh() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            jSONObject.put("isTestMode", this.zzs);
            jSONObject.put("gesture", this.zzr);
            if (this.zzq > com.google.android.gms.ads.internal.zzt.o().currentTimeMillis() / 1000) {
                jSONObject.put("networkExtras", this.zzo);
                jSONObject.put("networkExtrasExpirationSecs", this.zzq);
            }
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public final synchronized void zzi(String str, long j3) {
        this.zzo = str;
        this.zzq = j3;
        zzz();
    }

    public final synchronized void zzj(String str) {
        this.zzx = str;
        com.google.android.gms.ads.internal.zzt.l().zzo().i(this.zzx);
    }

    public final synchronized void zzk(String str, zzecf zzecfVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzko)).booleanValue() && zzs()) {
            if (this.zzt >= ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkq)).intValue()) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.f("Maximum number of ad requests stored reached. Dropping the current request.");
                return;
            }
            Map map = this.zzl;
            if (!map.containsKey(str)) {
                map.put(str, new ArrayList());
            }
            this.zzt++;
            ((List) map.get(str)).add(zzecfVar);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkM)).booleanValue()) {
                String strZzd = zzecfVar.zzd();
                this.zzm.put(strZzd, zzecfVar);
                Map map2 = this.zzn;
                if (map2.containsKey(strZzd)) {
                    List list = (List) map2.get(strZzd);
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((zzcfw) it.next()).zzc(zzecfVar);
                    }
                    list.clear();
                }
            }
        }
    }

    public final synchronized void zzl(long j3) {
        this.zzw += j3;
    }

    public final boolean zzm() {
        return this.zzw < ((Long) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkJ)).longValue();
    }

    public final synchronized ListenableFuture zzn(String str) {
        zzcfw zzcfwVar;
        try {
            zzcfwVar = new zzcfw();
            Map map = this.zzm;
            if (map.containsKey(str)) {
                zzcfwVar.zzc((zzecf) map.get(str));
            } else {
                Map map2 = this.zzn;
                if (!map2.containsKey(str)) {
                    map2.put(str, new ArrayList());
                }
                ((List) map2.get(str)).add(zzcfwVar);
            }
        } catch (Throwable th) {
            throw th;
        }
        return zzcfwVar;
    }

    public final synchronized void zzo(com.google.android.gms.ads.internal.client.zzdk zzdkVar, zzecq zzecqVar) {
        if (!zzs()) {
            try {
                zzdkVar.zze(zzfma.zzd(18, null, null));
                return;
            } catch (RemoteException unused) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.f("Ad inspector cannot be opened because the device is not in test mode. See https://developers.google.com/admob/android/test-ads#enable_test_devices for more information.");
                return;
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzko)).booleanValue()) {
            this.zzv = zzecqVar;
            this.zza.zzm(zzdkVar, new zzbql(this), new zzbqe(this.zzf), new zzbpr(this));
            return;
        } else {
            try {
                zzdkVar.zze(zzfma.zzd(1, null, null));
                return;
            } catch (RemoteException unused2) {
                int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.f("Ad inspector had an internal error.");
                return;
            }
        }
    }

    public final synchronized void zzp(JSONObject jSONObject) {
        this.zzp = jSONObject;
    }

    public final boolean zzq() {
        return this.zzp != null;
    }

    public final synchronized JSONObject zzr() {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("platform", "ANDROID");
                String str = this.zzk;
                if (!TextUtils.isEmpty(str)) {
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
                    sb.append("afma-sdk-a-v");
                    sb.append(str);
                    jSONObject.put("sdkVersion", sb.toString());
                }
                jSONObject.put("internalSdkVersion", this.zzi);
                jSONObject.put("osVersion", Build.VERSION.RELEASE);
                jSONObject.put("adapters", this.zzd.zzb());
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkP)).booleanValue()) {
                    String strZzu = com.google.android.gms.ads.internal.zzt.l().zzu();
                    if (!TextUtils.isEmpty(strZzu)) {
                        jSONObject.put("plugin", strZzu);
                    }
                }
                if (this.zzq < com.google.android.gms.ads.internal.zzt.o().currentTimeMillis() / 1000) {
                    this.zzo = JsonUtils.EMPTY_JSON;
                }
                jSONObject.put("networkExtras", this.zzo);
                jSONObject.put("adSlots", zzv());
                jSONObject.put("appInfo", this.zze.zza());
                String strZzd = com.google.android.gms.ads.internal.zzt.l().zzo().zzi().zzd();
                if (!TextUtils.isEmpty(strZzd)) {
                    jSONObject.put("cld", new JSONObject(strZzd));
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkE)).booleanValue() && (jSONObject2 = this.zzp) != null) {
                    String string = jSONObject2.toString();
                    StringBuilder sb2 = new StringBuilder(string.length() + 13);
                    sb2.append("Server data: ");
                    sb2.append(string);
                    String string2 = sb2.toString();
                    int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.a(string2);
                    jSONObject.put("serverData", this.zzp);
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkD)).booleanValue()) {
                    jSONObject.put("openAction", this.zzv);
                    jSONObject.put("gesture", this.zzr);
                }
                jSONObject.put("isGamRegisteredTestDevice", com.google.android.gms.ads.internal.zzt.s().k());
                com.google.android.gms.ads.internal.zzt.g();
                com.google.android.gms.ads.internal.client.zzay.a();
                jSONObject.put("isSimulator", com.google.android.gms.ads.internal.util.client.zzf.F());
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkR)).booleanValue()) {
                    jSONObject.put("uiStorage", new JSONObject(this.zzx));
                }
                if (!TextUtils.isEmpty((CharSequence) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkT))) {
                    jSONObject.put("gmaDisk", this.zzh.zzb());
                }
                if (!TextUtils.isEmpty((CharSequence) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkS))) {
                    jSONObject.put("userDisk", this.zzg.zzb());
                }
            } catch (JSONException e3) {
                com.google.android.gms.ads.internal.zzt.l().zzh(e3, "Inspector.toJson");
                int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.g("Ad inspector encountered an error", e3);
            }
        } catch (Throwable th) {
            throw th;
        }
        return jSONObject;
    }

    public final synchronized boolean zzs() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkD)).booleanValue()) {
            return this.zzs || com.google.android.gms.ads.internal.zzt.s().k();
        }
        return this.zzs;
    }
}
