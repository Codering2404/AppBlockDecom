package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgiq extends zzgix {
    private final Context zza;

    zzgiq(zzaxm zzaxmVar, zzght zzghtVar, Context context, zzgqh zzgqhVar) {
        super("3M3UhsCX904mgMNqBuNkdZnNfpzyG+gyZSwZ0bLvpAGWwKiqhbJpzMhUN7osaI5H", "IGzPM7qLPT4nT5FsUvAD7EHpaGrgx3eqTo88eWb+Mf4=", zzaxmVar, zzghtVar, zzgqhVar.zza(119));
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzgix
    protected final void zza(Method method, zzaxm zzaxmVar) throws IllegalAccessException, InvocationTargetException {
        Object[] objArr = (Object[]) method.invoke("", this.zza);
        objArr.getClass();
        synchronized (zzaxmVar) {
            zzaxmVar.zzc(((Long) objArr[0]).longValue());
            zzaxmVar.zzP(((Long) objArr[1]).longValue());
        }
    }
}
