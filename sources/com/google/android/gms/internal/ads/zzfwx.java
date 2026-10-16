package com.google.android.gms.internal.ads;

import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfwx extends zzfwt {
    public zzfwx(zzfwm zzfwmVar, HashSet hashSet, JSONObject jSONObject, long j3) {
        super(zzfwmVar, hashSet, jSONObject, j3);
    }

    private final void zzc(String str) {
        zzfvi zzfviVarZza = zzfvi.zza();
        if (zzfviVarZza != null) {
            for (zzfuo zzfuoVar : zzfviVarZza.zze()) {
                if (((zzfwt) this).zza.contains(zzfuoVar.zzh())) {
                    zzfuoVar.zzg().zzi(str, this.zzc);
                }
            }
        }
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzfwu, android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        zzc(str);
        super.onPostExecute(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzfwu
    /* JADX INFO: renamed from: zza */
    public final void onPostExecute(String str) {
        zzc(str);
        super.onPostExecute(str);
    }
}
