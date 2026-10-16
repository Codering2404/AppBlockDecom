package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzibf extends zzibg implements Iterable {
    private final ArrayList zza = new ArrayList();

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof zzibf) && ((zzibf) obj).zza.equals(this.zza);
        }
        return true;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.zza.iterator();
    }

    public final void zza(zzibg zzibgVar) {
        this.zza.add(zzibgVar);
    }

    public final int zzb() {
        return this.zza.size();
    }

    public final zzibg zzc(int i3) {
        return (zzibg) this.zza.get(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzibg
    public final String zzd() {
        ArrayList arrayList = this.zza;
        int size = arrayList.size();
        if (size == 1) {
            return ((zzibg) arrayList.get(0)).zzd();
        }
        StringBuilder sb = new StringBuilder(String.valueOf(size).length() + 37);
        sb.append("Array must have size 1, but has size ");
        sb.append(size);
        throw new IllegalStateException(sb.toString());
    }
}
