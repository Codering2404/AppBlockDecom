package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbcc extends zzbdf {
    private final Activity zzh;
    private final View zzi;

    public zzbcc(zzbbs zzbbsVar, String str, String str2, zzaxm zzaxmVar, int i3, int i4, View view, Activity activity) {
        super(zzbbsVar, "9TfyKlP5TIIt3OrlcGubA3YBpCoy+oB4k/WnZndRDloYkwzEaKKPovjffC4zkV4k", "3uxZ+FD025vJO7qOv296UhrdOlNsopGnz6EvxCliHP4=", zzaxmVar, i3, 62);
        this.zzi = view;
        this.zzh = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        View view = this.zzi;
        if (view == null) {
            return;
        }
        Boolean bool = (Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzdy);
        boolean zBooleanValue = bool.booleanValue();
        Object[] objArr = (Object[]) this.zze.invoke(null, view, this.zzh, bool);
        zzaxm zzaxmVar = this.zzd;
        synchronized (zzaxmVar) {
            try {
                zzaxmVar.zzS(((Long) objArr[0]).longValue());
                zzaxmVar.zzT(((Long) objArr[1]).longValue());
                if (zBooleanValue) {
                    zzaxmVar.zzU((String) objArr[2]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
