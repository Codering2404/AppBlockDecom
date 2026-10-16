package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzidv extends zzicm implements RandomAccess, zziel, zzify {
    private static final float[] zza;
    private static final zzidv zzb;
    private float[] zzc;
    private int zzd;

    static {
        float[] fArr = new float[0];
        zza = fArr;
        zzb = new zzidv(fArr, 0, false);
    }

    zzidv() {
        this(zza, 0, true);
    }

    public static zzidv zzd() {
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
        float fFloatValue = ((Float) obj).floatValue();
        zzdW();
        if (i3 < 0 || i3 > (i4 = this.zzd)) {
            throw new IndexOutOfBoundsException(zzl(i3));
        }
        int i5 = i3 + 1;
        float[] fArr = this.zzc;
        int length = fArr.length;
        if (i4 < length) {
            System.arraycopy(fArr, i3, fArr, i5, i4 - i3);
        } else {
            float[] fArr2 = new float[zzj(length)];
            System.arraycopy(this.zzc, 0, fArr2, 0, i3);
            System.arraycopy(this.zzc, i3, fArr2, i5, this.zzd - i3);
            this.zzc = fArr2;
        }
        this.zzc[i3] = fFloatValue;
        this.zzd++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzicm, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zzdW();
        collection.getClass();
        if (!(collection instanceof zzidv)) {
            return super.addAll(collection);
        }
        zzidv zzidvVar = (zzidv) collection;
        int i3 = zzidvVar.zzd;
        if (i3 == 0) {
            return false;
        }
        int i4 = this.zzd;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i4 < i3) {
            throw new OutOfMemoryError();
        }
        int i5 = i4 + i3;
        float[] fArr = this.zzc;
        if (i5 > fArr.length) {
            this.zzc = Arrays.copyOf(fArr, i5);
        }
        System.arraycopy(zzidvVar.zzc, 0, this.zzc, this.zzd, zzidvVar.zzd);
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
        if (!(obj instanceof zzidv)) {
            return super.equals(obj);
        }
        zzidv zzidvVar = (zzidv) obj;
        if (this.zzd != zzidvVar.zzd) {
            return false;
        }
        float[] fArr = zzidvVar.zzc;
        for (int i3 = 0; i3 < this.zzd; i3++) {
            if (Float.floatToIntBits(this.zzc[i3]) != Float.floatToIntBits(fArr[i3])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i3) {
        zzk(i3);
        return Float.valueOf(this.zzc[i3]);
    }

    @Override // com.google.android.gms.internal.ads.zzicm, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iFloatToIntBits = 1;
        for (int i3 = 0; i3 < this.zzd; i3++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.zzc[i3]);
        }
        return iFloatToIntBits;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float fFloatValue = ((Float) obj).floatValue();
        int i3 = this.zzd;
        for (int i4 = 0; i4 < i3; i4++) {
            if (this.zzc[i4] == fFloatValue) {
                return i4;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzicm, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i3) {
        zzdW();
        zzk(i3);
        float[] fArr = this.zzc;
        float f3 = fArr[i3];
        if (i3 < this.zzd - 1) {
            System.arraycopy(fArr, i3 + 1, fArr, i3, (r2 - i3) - 1);
        }
        this.zzd--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f3);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i3, int i4) {
        zzdW();
        if (i4 < i3) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.zzc;
        System.arraycopy(fArr, i4, fArr, i3, this.zzd - i4);
        this.zzd -= i4 - i3;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzicm, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i3, Object obj) {
        float fFloatValue = ((Float) obj).floatValue();
        zzdW();
        zzk(i3);
        float[] fArr = this.zzc;
        float f3 = fArr[i3];
        fArr[i3] = fFloatValue;
        return Float.valueOf(f3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzieq, com.google.android.gms.internal.ads.zzieg
    /* JADX INFO: renamed from: zze */
    public final zziel zzh(int i3) {
        if (i3 >= this.zzd) {
            return new zzidv(i3 == 0 ? zza : Arrays.copyOf(this.zzc, i3), this.zzd, true);
        }
        throw new IllegalArgumentException();
    }

    public final float zzf(int i3) {
        zzk(i3);
        return this.zzc[i3];
    }

    public final void zzg(float f3) {
        zzdW();
        int i3 = this.zzd;
        int length = this.zzc.length;
        if (i3 == length) {
            float[] fArr = new float[zzj(length)];
            System.arraycopy(this.zzc, 0, fArr, 0, this.zzd);
            this.zzc = fArr;
        }
        float[] fArr2 = this.zzc;
        int i4 = this.zzd;
        this.zzd = i4 + 1;
        fArr2[i4] = f3;
    }

    final void zzi(int i3) {
        int length = this.zzc.length;
        if (i3 <= length) {
            return;
        }
        if (length == 0) {
            this.zzc = new float[Math.max(i3, 10)];
            return;
        }
        while (length < i3) {
            length = zzj(length);
        }
        this.zzc = Arrays.copyOf(this.zzc, length);
    }

    private zzidv(float[] fArr, int i3, boolean z2) {
        super(z2);
        this.zzc = fArr;
        this.zzd = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzicm, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzg(((Float) obj).floatValue());
        return true;
    }
}
