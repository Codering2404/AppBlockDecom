package com.google.android.gms.internal.ads;

import com.applovin.impl.mediation.nativeAds.xNe.qRMDmh;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zziga extends zzicm implements RandomAccess {
    private static final Object[] zza;
    private static final zziga zzb;
    private Object[] zzc;
    private int zzd;

    static {
        Object[] objArr = new Object[0];
        zza = objArr;
        zzb = new zziga(objArr, 0, false);
    }

    zziga() {
        this(zza, 0, true);
    }

    public static zziga zzd() {
        return zzb;
    }

    private static int zzf(int i3) {
        return Math.max(((i3 * 3) / 2) + 1, 10);
    }

    private final void zzg(int i3) {
        if (i3 < 0 || i3 >= this.zzd) {
            throw new IndexOutOfBoundsException(zzi(i3));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzicm, java.util.AbstractList, java.util.List
    public final void add(int i3, Object obj) {
        int i4;
        zzdW();
        if (i3 < 0 || i3 > (i4 = this.zzd)) {
            throw new IndexOutOfBoundsException(zzi(i3));
        }
        int i5 = i3 + 1;
        Object[] objArr = this.zzc;
        int length = objArr.length;
        if (i4 < length) {
            System.arraycopy(objArr, i3, objArr, i5, i4 - i3);
        } else {
            Object[] objArr2 = new Object[zzf(length)];
            System.arraycopy(this.zzc, 0, objArr2, 0, i3);
            System.arraycopy(this.zzc, i3, objArr2, i5, this.zzd - i3);
            this.zzc = objArr2;
        }
        this.zzc[i3] = obj;
        this.zzd++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzicm, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int i3 = this.zzd;
        if (i3 != list.size()) {
            return false;
        }
        if (!(obj instanceof zziga)) {
            for (int i4 = 0; i4 < i3; i4++) {
                if (!this.zzc[i4].equals(list.get(i4))) {
                    return false;
                }
            }
            return true;
        }
        zziga zzigaVar = (zziga) obj;
        for (int i5 = 0; i5 < i3; i5++) {
            if (!this.zzc[i5].equals(zzigaVar.zzc[i5])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i3) {
        zzg(i3);
        return this.zzc[i3];
    }

    @Override // com.google.android.gms.internal.ads.zzicm, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i3 = this.zzd;
        int iHashCode = 1;
        for (int i4 = 0; i4 < i3; i4++) {
            iHashCode = (iHashCode * 31) + this.zzc[i4].hashCode();
        }
        return iHashCode;
    }

    @Override // com.google.android.gms.internal.ads.zzicm, java.util.AbstractList, java.util.List
    public final Object remove(int i3) {
        zzdW();
        zzg(i3);
        Object[] objArr = this.zzc;
        Object obj = objArr[i3];
        if (i3 < this.zzd - 1) {
            System.arraycopy(objArr, i3 + 1, objArr, i3, (r2 - i3) - 1);
        }
        this.zzd--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // com.google.android.gms.internal.ads.zzicm, java.util.AbstractList, java.util.List
    public final Object set(int i3, Object obj) {
        zzdW();
        zzg(i3);
        Object[] objArr = this.zzc;
        Object obj2 = objArr[i3];
        objArr[i3] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzd;
    }

    final void zze(int i3) {
        int length = this.zzc.length;
        if (i3 <= length) {
            return;
        }
        if (length == 0) {
            this.zzc = new Object[Math.max(i3, 10)];
            return;
        }
        while (length < i3) {
            length = zzf(length);
        }
        this.zzc = Arrays.copyOf(this.zzc, length);
    }

    @Override // com.google.android.gms.internal.ads.zzieq, com.google.android.gms.internal.ads.zzieg
    public final /* bridge */ /* synthetic */ zzieq zzh(int i3) {
        if (i3 >= this.zzd) {
            return new zziga(i3 == 0 ? zza : Arrays.copyOf(this.zzc, i3), this.zzd, true);
        }
        throw new IllegalArgumentException();
    }

    private zziga(Object[] objArr, int i3, boolean z2) {
        super(z2);
        this.zzc = objArr;
        this.zzd = i3;
    }

    private final String zzi(int i3) {
        int i4 = this.zzd;
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 13 + String.valueOf(i4).length());
        sb.append(qRMDmh.hvEqWLkMuzK);
        sb.append(i3);
        sb.append(", Size:");
        sb.append(i4);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzicm, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        zzdW();
        int i3 = this.zzd;
        int length = this.zzc.length;
        if (i3 == length) {
            this.zzc = Arrays.copyOf(this.zzc, zzf(length));
        }
        Object[] objArr = this.zzc;
        int i4 = this.zzd;
        this.zzd = i4 + 1;
        objArr[i4] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
