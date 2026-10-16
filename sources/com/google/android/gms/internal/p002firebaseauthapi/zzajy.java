package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzajy extends zzaka {
    private int zza;
    private final int zzb;
    private final /* synthetic */ zzajv zzc;

    zzajy(zzajv zzajvVar) {
        Objects.requireNonNull(zzajvVar);
        this.zzc = zzajvVar;
        this.zza = 0;
        this.zzb = zzajvVar.zzb();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza < this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final byte zza() {
        int i3 = this.zza;
        if (i3 >= this.zzb) {
            throw new NoSuchElementException();
        }
        this.zza = i3 + 1;
        return this.zzc.zzb(i3);
    }
}
