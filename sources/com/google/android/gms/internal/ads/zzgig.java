package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgig extends zzgix {
    zzgig(zzaxm zzaxmVar, zzght zzghtVar, zzgqh zzgqhVar) {
        super("EX3s5CgykVWHs0pNTwHE120YyOO6kVwj6XxXcnDAUKRtpcEwHZ8iefuHYFjxhN+G", "iYfOB+UFjdSgOmvtOabB6aboS+drDofqdo6l56HlvdE=", zzaxmVar, zzghtVar, zzgqhVar.zza(114));
    }

    @Override // com.google.android.gms.internal.ads.zzgix
    protected final void zza(Method method, zzaxm zzaxmVar) throws IllegalAccessException, InvocationTargetException {
        synchronized (zzaxmVar) {
            zzaxmVar.zza("E");
            zzaxmVar.zzB(0L);
            zzaxmVar.zzV("D");
        }
        Object[] objArr = (Object[]) method.invoke("", null);
        objArr.getClass();
        synchronized (zzaxmVar) {
            zzaxmVar.zza((String) objArr[0]);
            zzaxmVar.zzB(((Long) objArr[1]).longValue());
            zzaxmVar.zzV((String) objArr[2]);
        }
    }
}
