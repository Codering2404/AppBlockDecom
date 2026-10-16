package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Api;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzali extends zzajp<Integer> implements zzalm<Integer>, RandomAccess {
    private static final int[] zza;
    private int[] zzb;
    private int zzc;

    static {
        int[] iArr = new int[0];
        zza = iArr;
        new zzali(iArr, 0, false);
    }

    zzali() {
        this(zza, 0, true);
    }

    private static int zze(int i3) {
        return Math.max(((i3 * 3) / 2) + 1, 10);
    }

    private final String zzf(int i3) {
        return "Index:" + i3 + ", Size:" + this.zzc;
    }

    private final void zzg(int i3) {
        if (i3 < 0 || i3 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzf(i3));
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajp, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i3, Object obj) {
        int i4;
        int iIntValue = ((Integer) obj).intValue();
        zza();
        if (i3 < 0 || i3 > (i4 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzf(i3));
        }
        int[] iArr = this.zzb;
        if (i4 < iArr.length) {
            System.arraycopy(iArr, i3, iArr, i3 + 1, i4 - i3);
        } else {
            int[] iArr2 = new int[zze(iArr.length)];
            System.arraycopy(this.zzb, 0, iArr2, 0, i3);
            System.arraycopy(this.zzb, i3, iArr2, i3 + 1, this.zzc - i3);
            this.zzb = iArr2;
        }
        this.zzb[i3] = iIntValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajp, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        zza();
        zzalh.zza(collection);
        if (!(collection instanceof zzali)) {
            return super.addAll(collection);
        }
        zzali zzaliVar = (zzali) collection;
        int i3 = zzaliVar.zzc;
        if (i3 == 0) {
            return false;
        }
        int i4 = this.zzc;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i4 < i3) {
            throw new OutOfMemoryError();
        }
        int i5 = i4 + i3;
        int[] iArr = this.zzb;
        if (i5 > iArr.length) {
            this.zzb = Arrays.copyOf(iArr, i5);
        }
        System.arraycopy(zzaliVar.zzb, 0, this.zzb, this.zzc, zzaliVar.zzc);
        this.zzc = i5;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajp, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzali)) {
            return super.equals(obj);
        }
        zzali zzaliVar = (zzali) obj;
        if (this.zzc != zzaliVar.zzc) {
            return false;
        }
        int[] iArr = zzaliVar.zzb;
        for (int i3 = 0; i3 < this.zzc; i3++) {
            if (this.zzb[i3] != iArr[i3]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i3) {
        return Integer.valueOf(zzb(i3));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajp, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i3 = 1;
        for (int i4 = 0; i4 < this.zzc; i4++) {
            i3 = (i3 * 31) + this.zzb[i4];
        }
        return i3;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.zzb[i3] == iIntValue) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajp, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i3) {
        zza();
        zzg(i3);
        int[] iArr = this.zzb;
        int i4 = iArr[i3];
        if (i3 < this.zzc - 1) {
            System.arraycopy(iArr, i3 + 1, iArr, i3, (r2 - i3) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i4);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i3, int i4) {
        zza();
        if (i4 < i3) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.zzb;
        System.arraycopy(iArr, i4, iArr, i3, this.zzc - i4);
        this.zzc -= i4 - i3;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajp, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i3, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        zza();
        zzg(i3);
        int[] iArr = this.zzb;
        int i4 = iArr[i3];
        iArr[i3] = iIntValue;
        return Integer.valueOf(i4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalm
    public final /* synthetic */ zzalm<Integer> zza(int i3) {
        if (i3 >= this.zzc) {
            return new zzali(i3 == 0 ? zza : Arrays.copyOf(this.zzb, i3), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final int zzb(int i3) {
        zzg(i3);
        return this.zzb[i3];
    }

    public final void zzc(int i3) {
        zza();
        int i4 = this.zzc;
        int[] iArr = this.zzb;
        if (i4 == iArr.length) {
            int[] iArr2 = new int[zze(iArr.length)];
            System.arraycopy(this.zzb, 0, iArr2, 0, this.zzc);
            this.zzb = iArr2;
        }
        int[] iArr3 = this.zzb;
        int i5 = this.zzc;
        this.zzc = i5 + 1;
        iArr3[i5] = i3;
    }

    final void zzd(int i3) {
        int[] iArr = this.zzb;
        if (i3 <= iArr.length) {
            return;
        }
        if (iArr.length == 0) {
            this.zzb = new int[Math.max(i3, 10)];
            return;
        }
        int length = iArr.length;
        while (length < i3) {
            length = zze(length);
        }
        this.zzb = Arrays.copyOf(this.zzb, length);
    }

    private zzali(int[] iArr, int i3, boolean z2) {
        super(z2);
        this.zzb = iArr;
        this.zzc = i3;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajp, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        zzc(((Integer) obj).intValue());
        return true;
    }
}
