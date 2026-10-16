package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcqr extends com.google.android.gms.ads.internal.client.zzcx {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private final zzdxc zzc;
    private final zzelu zzd;
    private final zzerw zze;
    private final zzebw zzf;
    private final zzcdz zzg;
    private final zzdxh zzh;
    private final zzecr zzi;
    private final zzblk zzj;
    private final zzfqj zzk;
    private final zzflu zzl;
    private final zzdae zzm;
    private final zzdzl zzn;
    private final zzedy zzo;
    private boolean zzp = false;
    private final Long zzq = Long.valueOf(com.google.android.gms.ads.internal.zzt.o().a());

    zzcqr(Context context, VersionInfoParcel versionInfoParcel, zzdxc zzdxcVar, zzelu zzeluVar, zzerw zzerwVar, zzebw zzebwVar, zzcdz zzcdzVar, zzdxh zzdxhVar, zzecr zzecrVar, zzblk zzblkVar, zzfqj zzfqjVar, zzflu zzfluVar, zzdae zzdaeVar, zzdzl zzdzlVar, zzedy zzedyVar) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = zzdxcVar;
        this.zzd = zzeluVar;
        this.zze = zzerwVar;
        this.zzf = zzebwVar;
        this.zzg = zzcdzVar;
        this.zzh = zzdxhVar;
        this.zzi = zzecrVar;
        this.zzj = zzblkVar;
        this.zzk = zzfqjVar;
        this.zzl = zzfluVar;
        this.zzm = zzdaeVar;
        this.zzn = zzdzlVar;
        this.zzo = zzedyVar;
    }

    final void zzb() {
        if (com.google.android.gms.ads.internal.zzt.l().zzo().zzJ()) {
            String strZzL = com.google.android.gms.ads.internal.zzt.l().zzo().zzL();
            if (com.google.android.gms.ads.internal.zzt.s().e(this.zza, strZzL, this.zzb.f70149a)) {
                return;
            }
            com.google.android.gms.ads.internal.zzt.l().zzo().zzK(false);
            com.google.android.gms.ads.internal.zzt.l().zzo().g("");
        }
    }

    final /* synthetic */ void zzc() {
        zzfmd.zza(this.zza, true);
    }

    final /* synthetic */ void zzd() {
        com.google.android.gms.ads.internal.zzt.r().zza(this.zza, this.zzn);
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final synchronized void zze() {
        if (this.zzp) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Mobile ads is initialized already.");
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzdi)).booleanValue()) {
            com.google.android.gms.ads.internal.client.zzay.c();
        }
        Context context = this.zza;
        zzbiq.zza(context);
        com.google.android.gms.ads.internal.zzt.l().zze(context, this.zzb, this.zzn);
        this.zzm.zzc();
        com.google.android.gms.ads.internal.zzt.n().zza(context);
        this.zzp = true;
        this.zzf.zzc();
        this.zze.zza();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzeV)).booleanValue()) {
            this.zzh.zza();
        }
        this.zzi.zza();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkD)).booleanValue()) {
            zzcfr.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcqq
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzb();
                }
            });
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzmr)).booleanValue()) {
            zzcfr.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcqn
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzx();
                }
            });
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzdT)).booleanValue()) {
            zzcfr.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcql
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzc();
                }
            });
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzfA)).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzfB)).booleanValue()) {
                zzcfr.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcqm
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zzd();
                    }
                });
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzfO)).booleanValue()) {
            final zzedy zzedyVar = this.zzo;
            zzhcg zzhcgVar = zzcfr.zzf;
            Objects.requireNonNull(zzedyVar);
            zzhcgVar.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcqk
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzedyVar.zza();
                }
            });
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final synchronized void zzf(float f3) {
        com.google.android.gms.ads.internal.zzt.m().a(f3);
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final synchronized void zzg(String str) {
        Context context = this.zza;
        zzbiq.zza(context);
        if (!TextUtils.isEmpty(str)) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzeT)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.p().a(context, this.zzb, str, null, this.zzk, null, null, this.zzi.zzs());
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final synchronized void zzh(boolean z2) {
        com.google.android.gms.ads.internal.zzt.m().c(z2);
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzi(IObjectWrapper iObjectWrapper, String str) {
        if (iObjectWrapper == null) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.c("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) ObjectWrapper.h5(iObjectWrapper);
        if (context == null) {
            int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.c("Context is null. Failed to open debug menu.");
        } else {
            com.google.android.gms.ads.internal.util.zzat zzatVar = new com.google.android.gms.ads.internal.util.zzat(context);
            zzatVar.c(str);
            zzatVar.d(this.zzb.f70149a);
            zzatVar.b();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzj(String str, IObjectWrapper iObjectWrapper) {
        String strC0;
        Runnable runnable;
        Context context = this.zza;
        zzbiq.zza(context);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzfa)).booleanValue()) {
            try {
                com.google.android.gms.ads.internal.zzt.g();
                strC0 = com.google.android.gms.ads.internal.util.zzs.c0(context);
            } catch (RemoteException | RuntimeException e3) {
                com.google.android.gms.ads.internal.zzt.l().zzg(e3, "NonagonMobileAdsSettingManager_AppId");
                strC0 = "";
            }
        } else {
            strC0 = "";
        }
        boolean z2 = true;
        String str2 = true == TextUtils.isEmpty(strC0) ? str : strC0;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzeT)).booleanValue();
        zzbih zzbihVar = zzbiq.zzbD;
        boolean zBooleanValue2 = zBooleanValue | ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbihVar)).booleanValue();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbihVar)).booleanValue()) {
            final Runnable runnable2 = (Runnable) ObjectWrapper.h5(iObjectWrapper);
            runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzcqo
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzhcg zzhcgVar = zzcfr.zzf;
                    final zzcqr zzcqrVar = this.zza;
                    final Runnable runnable3 = runnable2;
                    zzhcgVar.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcqp
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            zzcqrVar.zzy(runnable3);
                        }
                    });
                }
            };
        } else {
            runnable = null;
            z2 = zBooleanValue2;
        }
        Runnable runnable3 = runnable;
        if (z2) {
            com.google.android.gms.ads.internal.zzt.p().a(this.zza, this.zzb, str2, runnable3, this.zzk, this.zzn, this.zzq, this.zzi.zzs());
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final synchronized float zzk() {
        return com.google.android.gms.ads.internal.zzt.m().b();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final synchronized boolean zzl() {
        return com.google.android.gms.ads.internal.zzt.m().d();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final String zzm() {
        return this.zzb.f70149a;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzn(String str) {
        this.zze.zze(str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzo(zzbvc zzbvcVar) throws RemoteException {
        this.zzl.zzc(zzbvcVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzp(zzbrw zzbrwVar) throws RemoteException {
        this.zzf.zzb(zzbrwVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final List zzq() throws RemoteException {
        return this.zzf.zzd();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzr(com.google.android.gms.ads.internal.client.zzfr zzfrVar) throws RemoteException {
        this.zzg.zzb(this.zza, zzfrVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzs() {
        this.zzf.zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzt(com.google.android.gms.ads.internal.client.zzdk zzdkVar) throws RemoteException {
        this.zzi.zzo(zzdkVar, zzecq.API);
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzu(boolean z2) throws RemoteException {
        try {
            zzgch.zza(this.zza).zzb(z2);
        } catch (IOException e3) {
            throw new RemoteException(e3.getMessage());
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzv(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkP)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.l().zzt(str);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final synchronized void zzw() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzdh)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.v().zzc();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzdi)).booleanValue()) {
                com.google.android.gms.ads.internal.client.zzay.d();
            }
        }
    }

    final /* synthetic */ void zzx() {
        this.zzj.zza(new zzcac());
    }

    final /* synthetic */ void zzy(Runnable runnable) {
        Preconditions.f("Adapters must be initialized on the main thread.");
        Map mapZzf = com.google.android.gms.ads.internal.zzt.l().zzo().zzi().zzf();
        if (mapZzf.isEmpty()) {
            return;
        }
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable th) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.g("Could not initialize rewarded ads.", th);
                return;
            }
        }
        if (this.zzc.zzc()) {
            HashMap map = new HashMap();
            Iterator it = mapZzf.values().iterator();
            while (it.hasNext()) {
                for (zzbuv zzbuvVar : ((zzbuw) it.next()).zza) {
                    String str = zzbuvVar.zzb;
                    for (String str2 : zzbuvVar.zza) {
                        if (!map.containsKey(str2)) {
                            map.put(str2, new ArrayList());
                        }
                        if (str != null) {
                            ((List) map.get(str2)).add(str);
                        }
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : map.entrySet()) {
                String str3 = (String) entry.getKey();
                try {
                    zzelv zzelvVarZza = this.zzd.zza(str3, jSONObject);
                    if (zzelvVarZza != null) {
                        zzflw zzflwVar = (zzflw) zzelvVarZza.zzb;
                        if (!zzflwVar.zzn() && zzflwVar.zzq()) {
                            zzflwVar.zzr(this.zza, (zzeni) zzelvVarZza.zzc, (List) entry.getValue());
                            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 45);
                            sb.append("Initialized rewarded video mediation adapter ");
                            sb.append(str3);
                            String string = sb.toString();
                            int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
                            com.google.android.gms.ads.internal.util.client.zzo.a(string);
                        }
                    }
                } catch (zzflf e3) {
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str3).length() + 56);
                    sb2.append("Failed to initialize rewarded video mediation adapter \"");
                    sb2.append(str3);
                    sb2.append("\"");
                    String string2 = sb2.toString();
                    int i5 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.g(string2, e3);
                }
            }
        }
    }
}
