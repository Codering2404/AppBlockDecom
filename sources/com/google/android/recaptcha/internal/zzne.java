package com.google.android.recaptcha.internal;

import com.google.android.gms.common.api.Api;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzne extends zzkr implements RandomAccess, zzni, zzor {
    private static final int[] zza;
    private static final zzne zzb;
    private int[] zzc;
    private int zzd;

    static {
        int[] iArr = new int[0];
        zza = iArr;
        zzb = new zzne(iArr, 0, false);
    }

    zzne() {
        this(zza, 0, true);
    }

    public static zzne zzf() {
        return zzb;
    }

    private static int zzj(int i3) {
        return Math.max(((i3 * 3) / 2) + 1, 10);
    }

    private final String zzk(int i3) {
        return "Index:" + i3 + ", Size:" + this.zzd;
    }

    private final void zzl(int i3) {
        if (i3 < 0 || i3 >= this.zzd) {
            throw new IndexOutOfBoundsException(zzk(i3));
        }
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i3, Object obj) {
        int i4;
        int iIntValue = ((Integer) obj).intValue();
        zza();
        if (i3 < 0 || i3 > (i4 = this.zzd)) {
            throw new IndexOutOfBoundsException(zzk(i3));
        }
        int i5 = i3 + 1;
        int[] iArr = this.zzc;
        int length = iArr.length;
        if (i4 < length) {
            System.arraycopy(iArr, i3, iArr, i5, i4 - i3);
        } else {
            int[] iArr2 = new int[zzj(length)];
            System.arraycopy(this.zzc, 0, iArr2, 0, i3);
            System.arraycopy(this.zzc, i3, iArr2, i5, this.zzd - i3);
            this.zzc = iArr2;
        }
        this.zzc[i3] = iIntValue;
        this.zzd++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zznl.zzb;
        collection.getClass();
        if (!(collection instanceof zzne)) {
            return super.addAll(collection);
        }
        zzne zzneVar = (zzne) collection;
        int i3 = zzneVar.zzd;
        if (i3 == 0) {
            return false;
        }
        int i4 = this.zzd;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i4 < i3) {
            throw new OutOfMemoryError();
        }
        int i5 = i4 + i3;
        int[] iArr = this.zzc;
        if (i5 > iArr.length) {
            this.zzc = Arrays.copyOf(iArr, i5);
        }
        System.arraycopy(zzneVar.zzc, 0, this.zzc, this.zzd, zzneVar.zzd);
        this.zzd = i5;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzne)) {
            return super.equals(obj);
        }
        zzne zzneVar = (zzne) obj;
        if (this.zzd != zzneVar.zzd) {
            return false;
        }
        int[] iArr = zzneVar.zzc;
        for (int i3 = 0; i3 < this.zzd; i3++) {
            if (this.zzc[i3] != iArr[i3]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i3) {
        zzl(i3);
        return Integer.valueOf(this.zzc[i3]);
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i3 = 1;
        for (int i4 = 0; i4 < this.zzd; i4++) {
            i3 = (i3 * 31) + this.zzc[i4];
        }
        return i3;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i3 = this.zzd;
        for (int i4 = 0; i4 < i3; i4++) {
            if (this.zzc[i4] == iIntValue) {
                return i4;
            }
        }
        return -1;
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i3) {
        zza();
        zzl(i3);
        int[] iArr = this.zzc;
        int i4 = iArr[i3];
        if (i3 < this.zzd - 1) {
            System.arraycopy(iArr, i3 + 1, iArr, i3, (r2 - i3) - 1);
        }
        this.zzd--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i4);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i3, int i4) {
        zza();
        if (i4 < i3) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.zzc;
        System.arraycopy(iArr, i4, iArr, i3, this.zzd - i4);
        this.zzd -= i4 - i3;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i3, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        zza();
        zzl(i3);
        int[] iArr = this.zzc;
        int i4 = iArr[i3];
        iArr[i3] = iIntValue;
        return Integer.valueOf(i4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzd;
    }

    public final int zze(int i3) {
        zzl(i3);
        return this.zzc[i3];
    }

    @Override // com.google.android.recaptcha.internal.zznk
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final zzni zzd(int i3) {
        if (i3 >= this.zzd) {
            return new zzne(i3 == 0 ? zza : Arrays.copyOf(this.zzc, i3), this.zzd, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.recaptcha.internal.zzni
    public final void zzh(int i3) {
        zza();
        int i4 = this.zzd;
        int length = this.zzc.length;
        if (i4 == length) {
            int[] iArr = new int[zzj(length)];
            System.arraycopy(this.zzc, 0, iArr, 0, this.zzd);
            this.zzc = iArr;
        }
        int[] iArr2 = this.zzc;
        int i5 = this.zzd;
        this.zzd = i5 + 1;
        iArr2[i5] = i3;
    }

    final void zzi(int i3) {
        int length = this.zzc.length;
        if (i3 <= length) {
            return;
        }
        if (length == 0) {
            this.zzc = new int[Math.max(i3, 10)];
            return;
        }
        while (length < i3) {
            length = zzj(length);
        }
        this.zzc = Arrays.copyOf(this.zzc, length);
    }

    private zzne(int[] iArr, int i3, boolean z2) {
        super(z2);
        this.zzc = iArr;
        this.zzd = i3;
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzh(((Integer) obj).intValue());
        return true;
    }
}
