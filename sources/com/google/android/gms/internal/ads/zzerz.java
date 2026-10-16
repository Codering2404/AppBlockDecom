package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzerz extends zzbxd {
    private final String zza;
    private final zzbxb zzb;
    private final zzcfw zzc;
    private final JSONObject zzd;
    private final long zze;
    private boolean zzf;

    public zzerz(String str, zzbxb zzbxbVar, zzcfw zzcfwVar, long j3) {
        JSONObject jSONObject = new JSONObject();
        this.zzd = jSONObject;
        this.zzf = false;
        this.zzc = zzcfwVar;
        this.zza = str;
        this.zzb = zzbxbVar;
        this.zze = j3;
        try {
            jSONObject.put("adapter_version", zzbxbVar.zzf().toString());
            jSONObject.put("sdk_version", zzbxbVar.zzg().toString());
            jSONObject.put("name", str);
        } catch (RemoteException | NullPointerException | JSONException unused) {
        }
    }

    public static synchronized void zzd(String str, zzcfw zzcfwVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", str);
                jSONObject.put("signal_error", "Adapter failed to instantiate");
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcl)).booleanValue()) {
                    jSONObject.put("signal_error_code", 1);
                }
                zzcfwVar.zzc(jSONObject);
            } catch (JSONException unused) {
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized void zzh(String str, int i3) {
        try {
            if (this.zzf) {
                return;
            }
            try {
                JSONObject jSONObject = this.zzd;
                jSONObject.put("signal_error", str);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcm)).booleanValue()) {
                    jSONObject.put("latency", com.google.android.gms.ads.internal.zzt.o().a() - this.zze);
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcl)).booleanValue()) {
                    jSONObject.put("signal_error_code", i3);
                }
            } catch (JSONException unused) {
            }
            this.zzc.zzc(this.zzd);
            this.zzf = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzb() {
        if (this.zzf) {
            return;
        }
        try {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcl)).booleanValue()) {
                this.zzd.put("signal_error_code", 0);
            }
        } catch (JSONException unused) {
        }
        this.zzc.zzc(this.zzd);
        this.zzf = true;
    }

    public final synchronized void zzc() {
        zzh("Signal collection timeout.", 3);
    }

    @Override // com.google.android.gms.internal.ads.zzbxe
    public final synchronized void zze(String str) throws RemoteException {
        if (this.zzf) {
            return;
        }
        if (str == null) {
            zzf("Adapter returned null signals");
            return;
        }
        try {
            JSONObject jSONObject = this.zzd;
            jSONObject.put("signals", str);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcm)).booleanValue()) {
                jSONObject.put("latency", com.google.android.gms.ads.internal.zzt.o().a() - this.zze);
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcl)).booleanValue()) {
                jSONObject.put("signal_error_code", 0);
            }
        } catch (JSONException unused) {
        }
        this.zzc.zzc(this.zzd);
        this.zzf = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbxe
    public final synchronized void zzf(String str) throws RemoteException {
        zzh(str, 2);
    }

    @Override // com.google.android.gms.internal.ads.zzbxe
    public final synchronized void zzg(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        zzh(zzeVar.f69852b, 2);
    }
}
