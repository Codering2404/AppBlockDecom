package com.google.android.gms.internal.ads;

import androidx.datastore.preferences.core.SfRj.rnFwbPAQmQTnL;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcuq implements zzbeq {
    private zzcku zza;
    private final Executor zzb;
    private final zzcuc zzc;
    private final Clock zzd;
    private boolean zze = false;
    private boolean zzf = false;
    private final zzcuf zzg = new zzcuf();

    public zzcuq(Executor executor, zzcuc zzcucVar, Clock clock) {
        this.zzb = executor;
        this.zzc = zzcucVar;
        this.zzd = clock;
    }

    public final void zza(zzcku zzckuVar) {
        this.zza = zzckuVar;
    }

    public final void zzb() {
        this.zze = false;
    }

    public final void zzd() {
        this.zze = true;
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzbeq
    public final void zzdj(zzbep zzbepVar) {
        boolean z2 = this.zzf ? false : zzbepVar.zzj;
        zzcuf zzcufVar = this.zzg;
        zzcufVar.zza = z2;
        zzcufVar.zzd = this.zzd.a();
        zzcufVar.zzf = zzbepVar;
        if (this.zze) {
            zzg();
        }
    }

    public final void zze(boolean z2) {
        this.zzf = z2;
    }

    final /* synthetic */ void zzf(JSONObject jSONObject) {
        String string = jSONObject.toString();
        StringBuilder sb = new StringBuilder(string.length() + 31);
        sb.append("Calling AFMA_updateActiveView(");
        sb.append(string);
        sb.append(")");
        String string2 = sb.toString();
        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.a(string2);
        this.zza.zzb("AFMA_updateActiveView", jSONObject);
    }

    private final void zzg() {
        try {
            final JSONObject jSONObjectZzb = this.zzc.zzb(this.zzg);
            if (this.zza != null) {
                this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcup
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zzf(jSONObjectZzb);
                    }
                });
            }
        } catch (JSONException e3) {
            com.google.android.gms.ads.internal.util.zze.l(rnFwbPAQmQTnL.FhMrzOnAxKCA, e3);
        }
    }
}
