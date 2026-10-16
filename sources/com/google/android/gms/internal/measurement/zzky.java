package com.google.android.gms.internal.measurement;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzky extends zzku implements RandomAccess, zzmh, zznt {
    private static final boolean[] zza;
    private boolean[] zzb;
    private int zzc;

    static {
        boolean[] zArr = new boolean[0];
        zza = zArr;
        new zzky(zArr, 0, false);
    }

    zzky() {
        this(zza, 0, true);
    }

    private static int zzh(int i3) {
        return Math.max(((i3 * 3) / 2) + 1, 10);
    }

    private final void zzi(int i3) {
        if (i3 < 0 || i3 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzj(i3));
        }
    }

    private final String zzj(int i3) {
        return zzkw.zza(this.zzc, i3, Ascii.CR, "Index:", ", Size:");
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i3, Object obj) {
        int i4;
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        zzcF();
        if (i3 < 0 || i3 > (i4 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzj(i3));
        }
        int i5 = i3 + 1;
        boolean[] zArr = this.zzb;
        int length = zArr.length;
        if (i4 < length) {
            System.arraycopy(zArr, i3, zArr, i5, i4 - i3);
        } else {
            boolean[] zArr2 = new boolean[zzh(length)];
            System.arraycopy(this.zzb, 0, zArr2, 0, i3);
            System.arraycopy(this.zzb, i3, zArr2, i5, this.zzc - i3);
            this.zzb = zArr2;
        }
        this.zzb[i3] = zBooleanValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zzcF();
        byte[] bArr = zzmp.zzb;
        collection.getClass();
        if (!(collection instanceof zzky)) {
            return super.addAll(collection);
        }
        zzky zzkyVar = (zzky) collection;
        int i3 = zzkyVar.zzc;
        if (i3 == 0) {
            return false;
        }
        int i4 = this.zzc;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i4 < i3) {
            throw new OutOfMemoryError();
        }
        int i5 = i4 + i3;
        boolean[] zArr = this.zzb;
        if (i5 > zArr.length) {
            this.zzb = Arrays.copyOf(zArr, i5);
        }
        System.arraycopy(zzkyVar.zzb, 0, this.zzb, this.zzc, zzkyVar.zzc);
        this.zzc = i5;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzky)) {
            return super.equals(obj);
        }
        zzky zzkyVar = (zzky) obj;
        if (this.zzc != zzkyVar.zzc) {
            return false;
        }
        boolean[] zArr = zzkyVar.zzb;
        for (int i3 = 0; i3 < this.zzc; i3++) {
            if (this.zzb[i3] != zArr[i3]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i3) {
        zzi(i3);
        return Boolean.valueOf(this.zzb[i3]);
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iZzb = 1;
        for (int i3 = 0; i3 < this.zzc; i3++) {
            iZzb = (iZzb * 31) + zzmp.zzb(this.zzb[i3]);
        }
        return iZzb;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        int i3 = this.zzc;
        for (int i4 = 0; i4 < i3; i4++) {
            if (this.zzb[i4] == zBooleanValue) {
                return i4;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i3) {
        zzcF();
        zzi(i3);
        boolean[] zArr = this.zzb;
        boolean z2 = zArr[i3];
        if (i3 < this.zzc - 1) {
            System.arraycopy(zArr, i3 + 1, zArr, i3, (r2 - i3) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z2);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i3, int i4) {
        zzcF();
        if (i4 < i3) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.zzb;
        System.arraycopy(zArr, i4, zArr, i3, this.zzc - i4);
        this.zzc -= i4 - i3;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i3, Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        zzcF();
        zzi(i3);
        boolean[] zArr = this.zzb;
        boolean z2 = zArr[i3];
        zArr[i3] = zBooleanValue;
        return Boolean.valueOf(z2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzmo, com.google.android.gms.internal.measurement.zzmh
    /* JADX INFO: renamed from: zzd */
    public final zzmh zzg(int i3) {
        if (i3 >= this.zzc) {
            return new zzky(i3 == 0 ? zza : Arrays.copyOf(this.zzb, i3), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final boolean zze(int i3) {
        zzi(i3);
        return this.zzb[i3];
    }

    public final void zzf(boolean z2) {
        zzcF();
        int i3 = this.zzc;
        int length = this.zzb.length;
        if (i3 == length) {
            boolean[] zArr = new boolean[zzh(length)];
            System.arraycopy(this.zzb, 0, zArr, 0, this.zzc);
            this.zzb = zArr;
        }
        boolean[] zArr2 = this.zzb;
        int i4 = this.zzc;
        this.zzc = i4 + 1;
        zArr2[i4] = z2;
    }

    private zzky(boolean[] zArr, int i3, boolean z2) {
        super(z2);
        this.zzb = zArr;
        this.zzc = i3;
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzf(((Boolean) obj).booleanValue());
        return true;
    }
}
