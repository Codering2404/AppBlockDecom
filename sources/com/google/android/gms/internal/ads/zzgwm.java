package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzgwm extends zzgwi implements List, RandomAccess {
    private static final zzgzb zza = new zzgwk(zzgyh.zza, 0);
    public static final /* synthetic */ int zzd = 0;

    zzgwm() {
    }

    public static zzgwm zzi() {
        return zzgyh.zza;
    }

    public static zzgwm zzj(Object obj) {
        Object[] objArr = {obj};
        zzgyf.zza(objArr, 1);
        return zzt(objArr, 1);
    }

    public static zzgwm zzk(Object obj, Object obj2) {
        Object[] objArr = {obj, obj2};
        zzgyf.zza(objArr, 2);
        return zzt(objArr, 2);
    }

    public static zzgwm zzl(Object obj, Object obj2, Object obj3) {
        Object[] objArr = {obj, obj2, obj3};
        zzgyf.zza(objArr, 3);
        return zzt(objArr, 3);
    }

    public static zzgwm zzm(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        Object[] objArr = {obj, obj2, obj3, obj4, obj5};
        zzgyf.zza(objArr, 5);
        return zzt(objArr, 5);
    }

    public static zzgwm zzn(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        Object[] objArr = {obj, obj2, obj3, obj4, obj5, obj6};
        zzgyf.zza(objArr, 6);
        return zzt(objArr, 6);
    }

    @SafeVarargs
    public static zzgwm zzo(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object... objArr) {
        int length = objArr.length;
        int i3 = length + 12;
        Object[] objArr2 = new Object[i3];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        objArr2[6] = obj7;
        objArr2[7] = obj8;
        objArr2[8] = obj9;
        objArr2[9] = obj10;
        objArr2[10] = obj11;
        objArr2[11] = obj12;
        System.arraycopy(objArr, 0, objArr2, 12, length);
        zzgyf.zza(objArr2, i3);
        return zzt(objArr2, i3);
    }

    public static zzgwm zzp(Iterable iterable) {
        iterable.getClass();
        return zzq((Collection) iterable);
    }

    public static zzgwm zzq(Collection collection) {
        if (!(collection instanceof zzgwi)) {
            Object[] array = collection.toArray();
            int length = array.length;
            zzgyf.zza(array, length);
            return zzt(array, length);
        }
        zzgwm zzgwmVarZze = ((zzgwi) collection).zze();
        if (!zzgwmVarZze.zzf()) {
            return zzgwmVarZze;
        }
        Object[] array2 = zzgwmVarZze.toArray();
        return zzt(array2, array2.length);
    }

    public static zzgwm zzr(Object[] objArr) {
        if (objArr.length == 0) {
            return zzgyh.zza;
        }
        Object[] objArr2 = (Object[]) objArr.clone();
        int length = objArr2.length;
        zzgyf.zza(objArr2, length);
        return zzt(objArr2, length);
    }

    public static zzgwm zzs(Comparator comparator, Iterable iterable) {
        Object[] array = (iterable instanceof Collection ? (Collection) iterable : zzgxm.zza(((zzgwm) iterable).listIterator(0))).toArray();
        int length = array.length;
        zzgyf.zza(array, length);
        Arrays.sort(array, comparator);
        return zzt(array, length);
    }

    static zzgwm zzt(Object[] objArr, int i3) {
        return i3 == 0 ? zzgyh.zza : new zzgyh(objArr, i3);
    }

    public static zzgwj zzv(int i3) {
        zzgvi.zzb(i3, "expectedSize");
        return new zzgwj(i3);
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

    @Override // com.google.android.gms.internal.ads.zzgwi, java.util.AbstractCollection, java.util.Collection
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

    @Override // com.google.android.gms.internal.ads.zzgwi, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
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

    @Override // com.google.android.gms.internal.ads.zzgwi
    /* JADX INFO: renamed from: zza */
    public final zzgza iterator() {
        return listIterator(0);
    }

    @Override // com.google.android.gms.internal.ads.zzgwi
    int zzg(Object[] objArr, int i3) {
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            objArr[i3 + i4] = get(i4);
        }
        return i3 + size;
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public zzgwm subList(int i3, int i4) {
        zzgtj.zzo(i3, i4, size());
        int i5 = i4 - i3;
        return i5 == size() ? this : i5 == 0 ? zzgyh.zza : new zzgwl(this, i3, i5);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: zzu, reason: merged with bridge method [inline-methods] */
    public final zzgzb listIterator(int i3) {
        zzgtj.zzn(i3, size(), "index");
        return isEmpty() ? zza : new zzgwk(this, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzgwi
    @Deprecated
    public final zzgwm zze() {
        return this;
    }
}
