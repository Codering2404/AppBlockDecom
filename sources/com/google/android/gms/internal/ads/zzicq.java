package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzicq extends zzicm implements RandomAccess, zzieg, zzify {
    private static final boolean[] zza;
    private static final zzicq zzb;
    private boolean[] zzc;
    private int zzd;

    static {
        boolean[] zArr = new boolean[0];
        zza = zArr;
        zzb = new zzicq(zArr, 0, false);
    }

    zzicq() {
        this(zza, 0, true);
    }

    public static zzicq zzd() {
        return zzb;
    }

    private static int zzi(int i3) {
        return Math.max(((i3 * 3) / 2) + 1, 10);
    }

    private final void zzj(int i3) {
        if (i3 < 0 || i3 >= this.zzd) {
            throw new IndexOutOfBoundsException(zzk(i3));
        }
    }

    private final String zzk(int i3) {
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
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        zzdW();
        if (i3 < 0 || i3 > (i4 = this.zzd)) {
            throw new IndexOutOfBoundsException(zzk(i3));
        }
        int i5 = i3 + 1;
        boolean[] zArr = this.zzc;
        int length = zArr.length;
        if (i4 < length) {
            System.arraycopy(zArr, i3, zArr, i5, i4 - i3);
        } else {
            boolean[] zArr2 = new boolean[zzi(length)];
            System.arraycopy(this.zzc, 0, zArr2, 0, i3);
            System.arraycopy(this.zzc, i3, zArr2, i5, this.zzd - i3);
            this.zzc = zArr2;
        }
        this.zzc[i3] = zBooleanValue;
        this.zzd++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzicm, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zzdW();
        collection.getClass();
        if (!(collection instanceof zzicq)) {
            return super.addAll(collection);
        }
        zzicq zzicqVar = (zzicq) collection;
        int i3 = zzicqVar.zzd;
        if (i3 == 0) {
            return false;
        }
        int i4 = this.zzd;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i4 < i3) {
            throw new OutOfMemoryError();
        }
        int i5 = i4 + i3;
        boolean[] zArr = this.zzc;
        if (i5 > zArr.length) {
            this.zzc = Arrays.copyOf(zArr, i5);
        }
        System.arraycopy(zzicqVar.zzc, 0, this.zzc, this.zzd, zzicqVar.zzd);
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
        if (!(obj instanceof zzicq)) {
            return super.equals(obj);
        }
        zzicq zzicqVar = (zzicq) obj;
        if (this.zzd != zzicqVar.zzd) {
            return false;
        }
        boolean[] zArr = zzicqVar.zzc;
        for (int i3 = 0; i3 < this.zzd; i3++) {
            if (this.zzc[i3] != zArr[i3]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i3) {
        zzj(i3);
        return Boolean.valueOf(this.zzc[i3]);
    }

    @Override // com.google.android.gms.internal.ads.zzicm, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iZza = 1;
        for (int i3 = 0; i3 < this.zzd; i3++) {
            iZza = (iZza * 31) + zzier.zza(this.zzc[i3]);
        }
        return iZza;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        int i3 = this.zzd;
        for (int i4 = 0; i4 < i3; i4++) {
            if (this.zzc[i4] == zBooleanValue) {
                return i4;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzicm, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i3) {
        zzdW();
        zzj(i3);
        boolean[] zArr = this.zzc;
        boolean z2 = zArr[i3];
        if (i3 < this.zzd - 1) {
            System.arraycopy(zArr, i3 + 1, zArr, i3, (r2 - i3) - 1);
        }
        this.zzd--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z2);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i3, int i4) {
        zzdW();
        if (i4 < i3) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.zzc;
        System.arraycopy(zArr, i4, zArr, i3, this.zzd - i4);
        this.zzd -= i4 - i3;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzicm, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i3, Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        zzdW();
        zzj(i3);
        boolean[] zArr = this.zzc;
        boolean z2 = zArr[i3];
        zArr[i3] = zBooleanValue;
        return Boolean.valueOf(z2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzieq, com.google.android.gms.internal.ads.zzieg
    /* JADX INFO: renamed from: zze */
    public final zzieg zzh(int i3) {
        if (i3 >= this.zzd) {
            return new zzicq(i3 == 0 ? zza : Arrays.copyOf(this.zzc, i3), this.zzd, true);
        }
        throw new IllegalArgumentException();
    }

    public final boolean zzf(int i3) {
        zzj(i3);
        return this.zzc[i3];
    }

    public final void zzg(boolean z2) {
        zzdW();
        int i3 = this.zzd;
        int length = this.zzc.length;
        if (i3 == length) {
            boolean[] zArr = new boolean[zzi(length)];
            System.arraycopy(this.zzc, 0, zArr, 0, this.zzd);
            this.zzc = zArr;
        }
        boolean[] zArr2 = this.zzc;
        int i4 = this.zzd;
        this.zzd = i4 + 1;
        zArr2[i4] = z2;
    }

    private zzicq(boolean[] zArr, int i3, boolean z2) {
        super(z2);
        this.zzc = zArr;
        this.zzd = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzicm, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzg(((Boolean) obj).booleanValue());
        return true;
    }
}
