package com.google.android.gms.internal.ads;

import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzfzw implements Closeable {
    public static zzgai zza() {
        return new zzgai();
    }

    public static zzgai zzb(zzgub<Integer> zzgubVar, zzgub<Integer> zzgubVar2, zzfzy zzfzyVar) {
        return new zzgai(zzgubVar, zzgubVar2, zzfzyVar);
    }

    public static zzgai zzc(final int i3, zzfzy zzfzyVar) {
        return new zzgai(new zzgub() { // from class: com.google.android.gms.internal.ads.zzfzv
            @Override // com.google.android.gms.internal.ads.zzgub
            public final /* synthetic */ Object zza() {
                return Integer.valueOf(i3);
            }
        }, zzfzu.zza, zzfzyVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer zzf() {
        return -1;
    }
}
