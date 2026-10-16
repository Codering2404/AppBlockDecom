package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgwo {
    Object[] zza;
    int zzb;
    zzgwn zzc;

    public zzgwo() {
        this(4);
    }

    private final void zze(int i3) {
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i4 = i3 + i3;
        if (i4 > length) {
            this.zza = Arrays.copyOf(objArr, zzgwh.zze(length, i4));
        }
    }

    private final zzgwp zzf(boolean z2) {
        zzgwn zzgwnVar;
        zzgwn zzgwnVar2;
        if (z2 && (zzgwnVar2 = this.zzc) != null) {
            throw zzgwnVar2.zza();
        }
        zzgym zzgymVarZzk = zzgym.zzk(this.zzb, this.zza, this);
        if (!z2 || (zzgwnVar = this.zzc) == null) {
            return zzgymVarZzk;
        }
        throw zzgwnVar.zza();
    }

    public final zzgwo zza(Object obj, Object obj2) {
        zze(this.zzb + 1);
        zzgvi.zza(obj, obj2);
        Object[] objArr = this.zza;
        int i3 = this.zzb;
        int i4 = i3 + i3;
        objArr[i4] = obj;
        objArr[i4 + 1] = obj2;
        this.zzb = i3 + 1;
        return this;
    }

    public final zzgwo zzb(Iterable iterable) {
        if (iterable instanceof Collection) {
            zze(this.zzb + ((Collection) iterable).size());
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            zza(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public final zzgwp zzc() {
        return zzf(true);
    }

    public final zzgwp zzd() {
        return zzf(false);
    }

    zzgwo(int i3) {
        this.zza = new Object[i3 + i3];
        this.zzb = 0;
    }
}
