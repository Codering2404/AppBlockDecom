package com.google.android.gms.internal.play_billing;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzbw extends zzbt implements List, RandomAccess {
    private static final zzcl zza = new zzbu(zzcd.zza, 0);
    public static final /* synthetic */ int zzd = 0;

    zzbw() {
    }

    static zzbw zzi(Object[] objArr, int i3) {
        return i3 == 0 ? zzcd.zza : new zzcd(objArr, i3);
    }

    public static zzbw zzj(Collection collection) {
        if (!(collection instanceof zzbt)) {
            Object[] array = collection.toArray();
            int length = array.length;
            zzcc.zza(array, length);
            return zzi(array, length);
        }
        zzbw zzbwVarZzd = ((zzbt) collection).zzd();
        if (!zzbwVarZzd.zzf()) {
            return zzbwVarZzd;
        }
        Object[] array2 = zzbwVarZzd.toArray();
        return zzi(array2, array2.length);
    }

    public static zzbw zzk() {
        return zzcd.zza;
    }

    public static zzbw zzl(Object obj) {
        Object[] objArr = {"inapp"};
        zzcc.zza(objArr, 1);
        return zzi(objArr, 1);
    }

    public static zzbw zzm(Object obj, Object obj2) {
        Object[] objArr = {"subs", "inapp"};
        zzcc.zza(objArr, 2);
        return zzi(objArr, 2);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i3, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i3, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.play_billing.zzbt, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        if (list instanceof RandomAccess) {
            for (int i3 = 0; i3 < size; i3++) {
                if (!Objects.equals(get(i3), list.get(i3))) {
                    return false;
                }
            }
            return true;
        }
        Iterator it = iterator();
        Iterator it2 = list.iterator();
        while (it.hasNext()) {
            if (!it2.hasNext() || !Objects.equals(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int iHashCode = 1;
        for (int i3 = 0; i3 < size; i3++) {
            iHashCode = (iHashCode * 31) + get(i3).hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (obj.equals(get(i3))) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbt, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    @Deprecated
    public final Object remove(int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final Object set(int i3, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.play_billing.zzbt
    int zza(Object[] objArr, int i3) {
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            objArr[i4] = get(i4);
        }
        return size;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbt
    /* JADX INFO: renamed from: zze */
    public final zzck iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public zzbw subList(int i3, int i4) {
        zzbj.zzd(i3, i4, size());
        int i5 = i4 - i3;
        return i5 == size() ? this : i5 == 0 ? zzcd.zza : new zzbv(this, i3, i5);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: zzn, reason: merged with bridge method [inline-methods] */
    public final zzcl listIterator(int i3) {
        zzbj.zzb(i3, size(), "index");
        return isEmpty() ? zza : new zzbu(this, i3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbt
    @Deprecated
    public final zzbw zzd() {
        return this;
    }
}
