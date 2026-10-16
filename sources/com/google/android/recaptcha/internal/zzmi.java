package com.google.android.recaptcha.internal;

import com.google.android.gms.common.api.Api;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzmi extends zzkr implements RandomAccess, zznk, zzor {
    private static final double[] zza;
    private double[] zzb;
    private int zzc;

    static {
        double[] dArr = new double[0];
        zza = dArr;
        new zzmi(dArr, 0, false);
    }

    zzmi() {
        this(zza, 0, true);
    }

    private static int zzh(int i3) {
        return Math.max(((i3 * 3) / 2) + 1, 10);
    }

    private final String zzi(int i3) {
        return "Index:" + i3 + ", Size:" + this.zzc;
    }

    private final void zzj(int i3) {
        if (i3 < 0 || i3 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzi(i3));
        }
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i3, Object obj) {
        int i4;
        double dDoubleValue = ((Double) obj).doubleValue();
        zza();
        if (i3 < 0 || i3 > (i4 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzi(i3));
        }
        int i5 = i3 + 1;
        double[] dArr = this.zzb;
        int length = dArr.length;
        if (i4 < length) {
            System.arraycopy(dArr, i3, dArr, i5, i4 - i3);
        } else {
            double[] dArr2 = new double[zzh(length)];
            System.arraycopy(this.zzb, 0, dArr2, 0, i3);
            System.arraycopy(this.zzb, i3, dArr2, i5, this.zzc - i3);
            this.zzb = dArr2;
        }
        this.zzb[i3] = dDoubleValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zznl.zzb;
        collection.getClass();
        if (!(collection instanceof zzmi)) {
            return super.addAll(collection);
        }
        zzmi zzmiVar = (zzmi) collection;
        int i3 = zzmiVar.zzc;
        if (i3 == 0) {
            return false;
        }
        int i4 = this.zzc;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i4 < i3) {
            throw new OutOfMemoryError();
        }
        int i5 = i4 + i3;
        double[] dArr = this.zzb;
        if (i5 > dArr.length) {
            this.zzb = Arrays.copyOf(dArr, i5);
        }
        System.arraycopy(zzmiVar.zzb, 0, this.zzb, this.zzc, zzmiVar.zzc);
        this.zzc = i5;
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
        if (!(obj instanceof zzmi)) {
            return super.equals(obj);
        }
        zzmi zzmiVar = (zzmi) obj;
        if (this.zzc != zzmiVar.zzc) {
            return false;
        }
        double[] dArr = zzmiVar.zzb;
        for (int i3 = 0; i3 < this.zzc; i3++) {
            if (Double.doubleToLongBits(this.zzb[i3]) != Double.doubleToLongBits(dArr[i3])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i3) {
        zzj(i3);
        return Double.valueOf(this.zzb[i3]);
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i3 = 1;
        for (int i4 = 0; i4 < this.zzc; i4++) {
            long jDoubleToLongBits = Double.doubleToLongBits(this.zzb[i4]);
            byte[] bArr = zznl.zzb;
            i3 = (i3 * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
        }
        return i3;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        int i3 = this.zzc;
        for (int i4 = 0; i4 < i3; i4++) {
            if (this.zzb[i4] == dDoubleValue) {
                return i4;
            }
        }
        return -1;
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i3) {
        zza();
        zzj(i3);
        double[] dArr = this.zzb;
        double d3 = dArr[i3];
        if (i3 < this.zzc - 1) {
            System.arraycopy(dArr, i3 + 1, dArr, i3, (r3 - i3) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d3);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i3, int i4) {
        zza();
        if (i4 < i3) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.zzb;
        System.arraycopy(dArr, i4, dArr, i3, this.zzc - i4);
        this.zzc -= i4 - i3;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i3, Object obj) {
        double dDoubleValue = ((Double) obj).doubleValue();
        zza();
        zzj(i3);
        double[] dArr = this.zzb;
        double d3 = dArr[i3];
        dArr[i3] = dDoubleValue;
        return Double.valueOf(d3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.recaptcha.internal.zznk
    public final /* bridge */ /* synthetic */ zznk zzd(int i3) {
        if (i3 >= this.zzc) {
            return new zzmi(i3 == 0 ? zza : Arrays.copyOf(this.zzb, i3), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final double zze(int i3) {
        zzj(i3);
        return this.zzb[i3];
    }

    public final void zzf(double d3) {
        zza();
        int i3 = this.zzc;
        int length = this.zzb.length;
        if (i3 == length) {
            double[] dArr = new double[zzh(length)];
            System.arraycopy(this.zzb, 0, dArr, 0, this.zzc);
            this.zzb = dArr;
        }
        double[] dArr2 = this.zzb;
        int i4 = this.zzc;
        this.zzc = i4 + 1;
        dArr2[i4] = d3;
    }

    final void zzg(int i3) {
        int length = this.zzb.length;
        if (i3 <= length) {
            return;
        }
        if (length == 0) {
            this.zzb = new double[Math.max(i3, 10)];
            return;
        }
        while (length < i3) {
            length = zzh(length);
        }
        this.zzb = Arrays.copyOf(this.zzb, length);
    }

    private zzmi(double[] dArr, int i3, boolean z2) {
        super(z2);
        this.zzb = dArr;
        this.zzc = i3;
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzf(((Double) obj).doubleValue());
        return true;
    }
}
