package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.api.Api;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzxm extends zztn implements RandomAccess, zzyd, zzzo {
    private static final zzxm zza = new zzxm(new float[0], 0, false);
    private float[] zzb;
    private int zzc;

    zzxm() {
        this(new float[10], 0, true);
    }

    private final String zzf(int i3) {
        return "Index:" + i3 + ", Size:" + this.zzc;
    }

    private final void zzg(int i3) {
        if (i3 < 0 || i3 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzf(i3));
        }
    }

    @Override // com.google.android.gms.internal.gtm.zztn, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i3, Object obj) {
        int i4;
        float fFloatValue = ((Float) obj).floatValue();
        zza();
        if (i3 < 0 || i3 > (i4 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzf(i3));
        }
        int i5 = i3 + 1;
        float[] fArr = this.zzb;
        if (i4 < fArr.length) {
            System.arraycopy(fArr, i3, fArr, i5, i4 - i3);
        } else {
            float[] fArr2 = new float[((i4 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i3);
            System.arraycopy(this.zzb, i3, fArr2, i5, this.zzc - i3);
            this.zzb = fArr2;
        }
        this.zzb[i3] = fFloatValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.gtm.zztn, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zzye.zzd;
        collection.getClass();
        if (!(collection instanceof zzxm)) {
            return super.addAll(collection);
        }
        zzxm zzxmVar = (zzxm) collection;
        int i3 = zzxmVar.zzc;
        if (i3 == 0) {
            return false;
        }
        int i4 = this.zzc;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i4 < i3) {
            throw new OutOfMemoryError();
        }
        int i5 = i4 + i3;
        float[] fArr = this.zzb;
        if (i5 > fArr.length) {
            this.zzb = Arrays.copyOf(fArr, i5);
        }
        System.arraycopy(zzxmVar.zzb, 0, this.zzb, this.zzc, zzxmVar.zzc);
        this.zzc = i5;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.gtm.zztn, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzxm)) {
            return super.equals(obj);
        }
        zzxm zzxmVar = (zzxm) obj;
        if (this.zzc != zzxmVar.zzc) {
            return false;
        }
        float[] fArr = zzxmVar.zzb;
        for (int i3 = 0; i3 < this.zzc; i3++) {
            if (Float.floatToIntBits(this.zzb[i3]) != Float.floatToIntBits(fArr[i3])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i3) {
        zzg(i3);
        return Float.valueOf(this.zzb[i3]);
    }

    @Override // com.google.android.gms.internal.gtm.zztn, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iFloatToIntBits = 1;
        for (int i3 = 0; i3 < this.zzc; i3++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.zzb[i3]);
        }
        return iFloatToIntBits;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float fFloatValue = ((Float) obj).floatValue();
        int i3 = this.zzc;
        for (int i4 = 0; i4 < i3; i4++) {
            if (this.zzb[i4] == fFloatValue) {
                return i4;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.gtm.zztn, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i3) {
        zza();
        zzg(i3);
        float[] fArr = this.zzb;
        float f3 = fArr[i3];
        if (i3 < this.zzc - 1) {
            System.arraycopy(fArr, i3 + 1, fArr, i3, (r2 - i3) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f3);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i3, int i4) {
        zza();
        if (i4 < i3) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.zzb;
        System.arraycopy(fArr, i4, fArr, i3, this.zzc - i4);
        this.zzc -= i4 - i3;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.gtm.zztn, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i3, Object obj) {
        float fFloatValue = ((Float) obj).floatValue();
        zza();
        zzg(i3);
        float[] fArr = this.zzb;
        float f3 = fArr[i3];
        fArr[i3] = fFloatValue;
        return Float.valueOf(f3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.gtm.zzyd
    public final /* bridge */ /* synthetic */ zzyd zzd(int i3) {
        if (i3 >= this.zzc) {
            return new zzxm(Arrays.copyOf(this.zzb, i3), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final void zze(float f3) {
        zza();
        int i3 = this.zzc;
        float[] fArr = this.zzb;
        if (i3 == fArr.length) {
            float[] fArr2 = new float[((i3 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i3);
            this.zzb = fArr2;
        }
        float[] fArr3 = this.zzb;
        int i4 = this.zzc;
        this.zzc = i4 + 1;
        fArr3[i4] = f3;
    }

    private zzxm(float[] fArr, int i3, boolean z2) {
        super(z2);
        this.zzb = fArr;
        this.zzc = i3;
    }

    @Override // com.google.android.gms.internal.gtm.zztn, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zze(((Float) obj).floatValue());
        return true;
    }
}
