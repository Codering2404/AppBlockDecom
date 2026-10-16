package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzana<E> extends zzajp<E> implements RandomAccess {
    private static final Object[] zza;
    private static final zzana<Object> zzb;
    private E[] zzc;
    private int zzd;

    static {
        Object[] objArr = new Object[0];
        zza = objArr;
        zzb = new zzana<>(objArr, 0, false);
    }

    zzana() {
        this(zza, 0, true);
    }

    private static int zzb(int i3) {
        return Math.max(((i3 * 3) / 2) + 1, 10);
    }

    private final String zzc(int i3) {
        return "Index:" + i3 + ", Size:" + this.zzd;
    }

    public static <E> zzana<E> zzd() {
        return (zzana<E>) zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajp, java.util.AbstractList, java.util.List
    public final void add(int i3, E e3) {
        int i4;
        zza();
        if (i3 < 0 || i3 > (i4 = this.zzd)) {
            throw new IndexOutOfBoundsException(zzc(i3));
        }
        E[] eArr = this.zzc;
        if (i4 < eArr.length) {
            System.arraycopy(eArr, i3, eArr, i3 + 1, i4 - i3);
        } else {
            E[] eArr2 = (E[]) new Object[zzb(eArr.length)];
            System.arraycopy(this.zzc, 0, eArr2, 0, i3);
            System.arraycopy(this.zzc, i3, eArr2, i3 + 1, this.zzd - i3);
            this.zzc = eArr2;
        }
        this.zzc[i3] = e3;
        this.zzd++;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i3) {
        zzd(i3);
        return this.zzc[i3];
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajp, java.util.AbstractList, java.util.List
    public final E remove(int i3) {
        zza();
        zzd(i3);
        E[] eArr = this.zzc;
        E e3 = eArr[i3];
        if (i3 < this.zzd - 1) {
            System.arraycopy(eArr, i3 + 1, eArr, i3, (r2 - i3) - 1);
        }
        this.zzd--;
        ((AbstractList) this).modCount++;
        return e3;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajp, java.util.AbstractList, java.util.List
    public final E set(int i3, E e3) {
        zza();
        zzd(i3);
        E[] eArr = this.zzc;
        E e4 = eArr[i3];
        eArr[i3] = e3;
        ((AbstractList) this).modCount++;
        return e4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalm
    public final /* synthetic */ zzalm zza(int i3) {
        if (i3 >= this.zzd) {
            return new zzana(i3 == 0 ? zza : Arrays.copyOf(this.zzc, i3), this.zzd, true);
        }
        throw new IllegalArgumentException();
    }

    private zzana(E[] eArr, int i3, boolean z2) {
        super(z2);
        this.zzc = eArr;
        this.zzd = i3;
    }

    private final void zzd(int i3) {
        if (i3 < 0 || i3 >= this.zzd) {
            throw new IndexOutOfBoundsException(zzc(i3));
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajp, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e3) {
        zza();
        int i3 = this.zzd;
        E[] eArr = this.zzc;
        if (i3 == eArr.length) {
            this.zzc = (E[]) Arrays.copyOf(this.zzc, zzb(eArr.length));
        }
        E[] eArr2 = this.zzc;
        int i4 = this.zzd;
        this.zzd = i4 + 1;
        eArr2[i4] = e3;
        ((AbstractList) this).modCount++;
        return true;
    }
}
