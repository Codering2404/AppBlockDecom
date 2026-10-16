package com.google.android.gms.internal.ads;

import android.os.AsyncTask;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzfwu extends AsyncTask {
    private zzfwv zza;
    protected final zzfwm zzd;

    public zzfwu(zzfwm zzfwmVar) {
        this.zzd = zzfwmVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        zzfwv zzfwvVar = this.zza;
        if (zzfwvVar != null) {
            zzfwvVar.zzb(this);
        }
    }

    public final void zzb(zzfwv zzfwvVar) {
        this.zza = zzfwvVar;
    }
}
