package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzidl extends zzicm implements RandomAccess, zzieh, zzify {
    private static final double[] zza;
    private static final zzidl zzb;
    private double[] zzc;
    private int zzd;

    static {
        double[] dArr = new double[0];
        zza = dArr;
        zzb = new zzidl(dArr, 0, false);
    }

    zzidl() {
        this(zza, 0, true);
    }

    public static zzidl zzd() {
        return zzb;
    }

    private static int zzj(int i3) {
        return Math.max(((i3 * 3) / 2) + 1, 10);
    }

    private final void zzk(int i3) {
        if (i3 < 0 || i3 >= this.zzd) {
            throw new IndexOutOfBoundsException(zzl(i3));
        }
    }

    private final String zzl(int i3) {
        int i4 = this.zzd;
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 13 + String.valueOf(i4).length());
        sb.append("Index:");
        sb.append(i3);
        sb.append(", Size:");
        sb.append(i4);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzicm, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i3, Object obj) {
        int i4;
        double dDoubleValue = ((Double) obj).doubleValue();
        zzdW();
        if (i3 < 0 || i3 > (i4 = this.zzd)) {
            throw new IndexOutOfBoundsException(zzl(i3));
        }
        int i5 = i3 + 1;
        double[] dArr = this.zzc;
        int length = dArr.length;
        if (i4 < length) {
            System.arraycopy(dArr, i3, dArr, i5, i4 - i3);
        } else {
            double[] dArr2 = new double[zzj(length)];
            System.arraycopy(this.zzc, 0, dArr2, 0, i3);
            System.arraycopy(this.zzc, i3, dArr2, i5, this.zzd - i3);
            this.zzc = dArr2;
        }
        this.zzc[i3] = dDoubleValue;
        this.zzd++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzicm, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zzdW();
        collection.getClass();
        if (!(collection instanceof zzidl)) {
            return super.addAll(collection);
        }
        zzidl zzidlVar = (zzidl) collection;
        int i3 = zzidlVar.zzd;
        if (i3 == 0) {
            return false;
        }
        int i4 = this.zzd;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i4 < i3) {
            throw new OutOfMemoryError();
        }
        int i5 = i4 + i3;
        double[] dArr = this.zzc;
        if (i5 > dArr.length) {
            this.zzc = Arrays.copyOf(dArr, i5);
        }
        System.arraycopy(zzidlVar.zzc, 0, this.zzc, this.zzd, zzidlVar.zzd);
        this.zzd = i5;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.ads.zzicm, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzidl)) {
            return super.equals(obj);
        }
        zzidl zzidlVar = (zzidl) obj;
        if (this.zzd != zzidlVar.zzd) {
            return false;
        }
        double[] dArr = zzidlVar.zzc;
        for (int i3 = 0; i3 < this.zzd; i3++) {
            if (Double.doubleToLongBits(this.zzc[i3]) != Double.doubleToLongBits(dArr[i3])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i3) {
        zzk(i3);
        return Double.valueOf(this.zzc[i3]);
    }

    @Override // com.google.android.gms.internal.ads.zzicm, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i3 = 1;
        for (int i4 = 0; i4 < this.zzd; i4++) {
            long jDoubleToLongBits = Double.doubleToLongBits(this.zzc[i4]);
            byte[] bArr = zzier.zza;
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
        int i3 = this.zzd;
        for (int i4 = 0; i4 < i3; i4++) {
            if (this.zzc[i4] == dDoubleValue) {
                return i4;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzicm, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i3) {
        zzdW();
        zzk(i3);
        double[] dArr = this.zzc;
        double d3 = dArr[i3];
        if (i3 < this.zzd - 1) {
            System.arraycopy(dArr, i3 + 1, dArr, i3, (r3 - i3) - 1);
        }
        this.zzd--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d3);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i3, int i4) {
        zzdW();
        if (i4 < i3) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.zzc;
        System.arraycopy(dArr, i4, dArr, i3, this.zzd - i4);
        this.zzd -= i4 - i3;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzicm, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i3, Object obj) {
        double dDoubleValue = ((Double) obj).doubleValue();
        zzdW();
        zzk(i3);
        double[] dArr = this.zzc;
        double d3 = dArr[i3];
        dArr[i3] = dDoubleValue;
        return Double.valueOf(d3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzieq, com.google.android.gms.internal.ads.zzieg
    /* JADX INFO: renamed from: zze */
    public final zzieh zzh(int i3) {
        if (i3 >= this.zzd) {
            return new zzidl(i3 == 0 ? zza : Arrays.copyOf(this.zzc, i3), this.zzd, true);
        }
        throw new IllegalArgumentException();
    }

    public final double zzf(int i3) {
        zzk(i3);
        return this.zzc[i3];
    }

    public final void zzg(double d3) {
        zzdW();
        int i3 = this.zzd;
        int length = this.zzc.length;
        if (i3 == length) {
            double[] dArr = new double[zzj(length)];
            System.arraycopy(this.zzc, 0, dArr, 0, this.zzd);
            this.zzc = dArr;
        }
        double[] dArr2 = this.zzc;
        int i4 = this.zzd;
        this.zzd = i4 + 1;
        dArr2[i4] = d3;
    }

    final void zzi(int i3) {
        int length = this.zzc.length;
        if (i3 <= length) {
            return;
        }
        if (length == 0) {
            this.zzc = new double[Math.max(i3, 10)];
            return;
        }
        while (length < i3) {
            length = zzj(length);
        }
        this.zzc = Arrays.copyOf(this.zzc, length);
    }

    private zzidl(double[] dArr, int i3, boolean z2) {
        super(z2);
        this.zzc = dArr;
        this.zzd = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzicm, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzg(((Double) obj).doubleValue());
        return true;
    }
}
