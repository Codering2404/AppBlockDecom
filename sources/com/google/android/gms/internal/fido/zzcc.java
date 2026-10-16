package com.google.android.gms.internal.fido;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzcc extends zzby implements List, RandomAccess {
    private static final zzdd zza = new zzbz(zzct.zza, 0);
    public static final /* synthetic */ int zzd = 0;

    zzcc() {
    }

    static zzcc zzh(Object[] objArr, int i3) {
        return i3 == 0 ? zzct.zza : new zzct(objArr, i3);
    }

    public static zzcc zzi(Object[] objArr) {
        if (objArr.length == 0) {
            return zzct.zza;
        }
        Object[] objArr2 = (Object[]) objArr.clone();
        int length = objArr2.length;
        zzcr.zzb(objArr2, length);
        return zzh(objArr2, length);
    }

    public static zzcc zzj(Object obj) {
        Object[] objArr = {obj};
        zzcr.zzb(objArr, 1);
        return zzh(objArr, 1);
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

    @Override // com.google.android.gms.internal.fido.zzby, java.util.AbstractCollection, java.util.Collection
    public boolean contains(@CheckForNull Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(@CheckForNull Object obj) {
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
                if (!zzbk.zza(get(i3), list.get(i3))) {
                    return false;
                }
            }
            return true;
        }
        Iterator it = iterator();
        Iterator it2 = list.iterator();
        while (it.hasNext()) {
            if (!it2.hasNext() || !zzbk.zza(it.next(), it2.next())) {
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

    public int indexOf(@CheckForNull Object obj) {
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

    @Override // com.google.android.gms.internal.fido.zzby, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    public int lastIndexOf(@CheckForNull Object obj) {
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

    @Override // com.google.android.gms.internal.fido.zzby
    int zza(Object[] objArr, int i3) {
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            objArr[i4] = get(i4);
        }
        return size;
    }

    @Override // com.google.android.gms.internal.fido.zzby
    /* JADX INFO: renamed from: zzd */
    public final zzdc iterator() {
        return listIterator(0);
    }

    public zzcc zzf() {
        return size() <= 1 ? this : new zzca(this);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public zzcc subList(int i3, int i4) {
        zzbm.zze(i3, i4, size());
        int i5 = i4 - i3;
        return i5 == size() ? this : i5 == 0 ? zzct.zza : new zzcb(this, i3, i5);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: zzk, reason: merged with bridge method [inline-methods] */
    public final zzdd listIterator(int i3) {
        zzbm.zzb(i3, size(), "index");
        return isEmpty() ? zza : new zzbz(this, i3);
    }
}
