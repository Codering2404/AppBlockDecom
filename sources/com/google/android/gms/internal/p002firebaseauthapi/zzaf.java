package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzaf<E> extends zzai<E> {
    Object[] zza;
    int zzb;
    boolean zzc;

    zzaf(int i3) {
        zzae.zza(4, "initialCapacity");
        this.zza = new Object[4];
        this.zzb = 0;
    }

    public zzaf<E> zza(E e3) {
        zzu.zza(e3);
        Object[] objArr = this.zza;
        int iZza = zzai.zza(objArr.length, this.zzb + 1);
        if (iZza > objArr.length || this.zzc) {
            this.zza = Arrays.copyOf(this.zza, iZza);
            this.zzc = false;
        }
        Object[] objArr2 = this.zza;
        int i3 = this.zzb;
        this.zzb = i3 + 1;
        objArr2[i3] = e3;
        return this;
    }
}
