package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgis extends zzgix {
    private final Context zza;
    private final Map zzb;

    zzgis(zzaxm zzaxmVar, zzght zzghtVar, Map map, Context context, zzgqh zzgqhVar) {
        super("LdJAK+tGLa5RtfoE4Vj1lf7WBx7tLt5NokheHxJZ8WRPF5i3vkHONYq7jawQpmfE", "i59R9TSjiUVrKRVh1QlIoomNztzQtHmvvEjkodMX8Xo=", zzaxmVar, zzghtVar, zzgqhVar.zza(120));
        this.zza = context;
        this.zzb = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzgix
    protected final void zza(Method method, zzaxm zzaxmVar) throws IllegalAccessException, InvocationTargetException {
        Long lValueOf = -1L;
        try {
            if (Build.VERSION.SDK_INT >= 30) {
                Long l3 = (Long) method.invoke("", this.zza);
                if (l3 == null) {
                    throw null;
                }
                lValueOf = l3;
            } else {
                ListenableFuture listenableFuture = (ListenableFuture) this.zzb.get("gs");
                if (listenableFuture != null && listenableFuture.isDone()) {
                    lValueOf = Long.valueOf(((zzaym) listenableFuture.get()).zze());
                }
            }
        } catch (InterruptedException | ExecutionException unused) {
        }
        synchronized (zzaxmVar) {
            zzaxmVar.zzR(lValueOf.longValue());
        }
    }
}
