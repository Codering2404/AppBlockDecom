package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzah<E> extends zzag<E> implements List<E>, RandomAccess {
    private static final zzax<Object> zza = new zzaj(zzap.zza, 0);

    zzah() {
    }

    static <E> zzah<E> zzb(Object[] objArr, int i3) {
        return i3 == 0 ? (zzah<E>) zzap.zza : new zzap(objArr, i3);
    }

    public static <E> zzak<E> zzf() {
        return new zzak<>();
    }

    public static <E> zzah<E> zzg() {
        return (zzah<E>) zzap.zza;
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i3, E e3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i3, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzag, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == zzu.zza(this)) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i3 = 0; i3 < size; i3++) {
                        if (Objects.equals(get(i3), list.get(i3))) {
                        }
                    }
                    return true;
                }
                int size2 = size();
                Iterator<E> it = list.iterator();
                int i4 = 0;
                while (true) {
                    if (i4 < size2) {
                        if (!it.hasNext()) {
                            break;
                        }
                        E e3 = get(i4);
                        i4++;
                        if (!Objects.equals(e3, it.next())) {
                            break;
                        }
                    } else if (!it.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i3 = 1;
        for (int i4 = 0; i4 < size; i4++) {
            i3 = ~(~((i3 * 31) + get(i4).hashCode()));
        }
        return i3;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
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

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzag, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
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
    public /* synthetic */ ListIterator listIterator() {
        return (zzax) listIterator(0);
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i3, E e3) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzag
    int zza(Object[] objArr, int i3) {
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            objArr[i3 + i4] = get(i4);
        }
        return i3 + size;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzag
    /* JADX INFO: renamed from: zzd */
    public final zzay<E> iterator() {
        return (zzax) listIterator();
    }

    @Override // java.util.List
    public /* synthetic */ ListIterator listIterator(int i3) {
        zzu.zzb(i3, size());
        return isEmpty() ? zza : new zzaj(this, i3);
    }

    static <E> zzah<E> zza(Object[] objArr) {
        return zzb(objArr, objArr.length);
    }

    public static <E> zzah<E> zza(E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10) {
        Object[] objArr = {e3, e4, e5, e6, e7, e8, e9, e10};
        for (int i3 = 0; i3 < 8; i3++) {
            if (objArr[i3] == null) {
                throw new NullPointerException("at index " + i3);
            }
        }
        return zzb(objArr, 8);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public zzah<E> subList(int i3, int i4) {
        zzu.zza(i3, i4, size());
        int i5 = i4 - i3;
        if (i5 == size()) {
            return this;
        }
        if (i5 == 0) {
            return (zzah<E>) zzap.zza;
        }
        return new zzam(this, i3, i5);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzag
    @Deprecated
    public final zzah<E> zzc() {
        return this;
    }
}
