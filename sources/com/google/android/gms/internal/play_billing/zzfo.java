package com.google.android.gms.internal.play_billing;

import com.google.android.gms.common.api.Api;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfo extends zzeh implements RandomAccess, zzfz {
    private static final float[] zza;
    private float[] zzb;
    private int zzc;

    static {
        float[] fArr = new float[0];
        zza = fArr;
        new zzfo(fArr, 0, false);
    }

    zzfo() {
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

    @Override // com.google.android.gms.internal.play_billing.zzeh, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i3, Object obj) {
        int i4;
        float fFloatValue = ((Float) obj).floatValue();
        zza();
        if (i3 < 0 || i3 > (i4 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzi(i3));
        }
        int i5 = i3 + 1;
        float[] fArr = this.zzb;
        int length = fArr.length;
        if (i4 < length) {
            System.arraycopy(fArr, i3, fArr, i5, i4 - i3);
        } else {
            float[] fArr2 = new float[zzh(length)];
            System.arraycopy(this.zzb, 0, fArr2, 0, i3);
            System.arraycopy(this.zzb, i3, fArr2, i5, this.zzc - i3);
            this.zzb = fArr2;
        }
        this.zzb[i3] = fFloatValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.play_billing.zzeh, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zzga.zzb;
        collection.getClass();
        if (!(collection instanceof zzfo)) {
            return super.addAll(collection);
        }
        zzfo zzfoVar = (zzfo) collection;
        int i3 = zzfoVar.zzc;
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
        System.arraycopy(zzfoVar.zzb, 0, this.zzb, this.zzc, zzfoVar.zzc);
        this.zzc = i5;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.play_billing.zzeh, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfo)) {
            return super.equals(obj);
        }
        zzfo zzfoVar = (zzfo) obj;
        if (this.zzc != zzfoVar.zzc) {
            return false;
        }
        float[] fArr = zzfoVar.zzb;
        for (int i3 = 0; i3 < this.zzc; i3++) {
            if (Float.floatToIntBits(this.zzb[i3]) != Float.floatToIntBits(fArr[i3])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i3) {
        zzj(i3);
        return Float.valueOf(this.zzb[i3]);
    }

    @Override // com.google.android.gms.internal.play_billing.zzeh, java.util.AbstractList, java.util.Collection, java.util.List
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

    @Override // com.google.android.gms.internal.play_billing.zzeh, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i3) {
        zza();
        zzj(i3);
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

    @Override // com.google.android.gms.internal.play_billing.zzeh, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i3, Object obj) {
        float fFloatValue = ((Float) obj).floatValue();
        zza();
        zzj(i3);
        float[] fArr = this.zzb;
        float f3 = fArr[i3];
        fArr[i3] = fFloatValue;
        return Float.valueOf(f3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfz
    public final /* bridge */ /* synthetic */ zzfz zzd(int i3) {
        if (i3 >= this.zzc) {
            return new zzfo(i3 == 0 ? zza : Arrays.copyOf(this.zzb, i3), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final float zze(int i3) {
        zzj(i3);
        return this.zzb[i3];
    }

    public final void zzf(float f3) {
        zza();
        int i3 = this.zzc;
        int length = this.zzb.length;
        if (i3 == length) {
            float[] fArr = new float[zzh(length)];
            System.arraycopy(this.zzb, 0, fArr, 0, this.zzc);
            this.zzb = fArr;
        }
        float[] fArr2 = this.zzb;
        int i4 = this.zzc;
        this.zzc = i4 + 1;
        fArr2[i4] = f3;
    }

    final void zzg(int i3) {
        int length = this.zzb.length;
        if (i3 <= length) {
            return;
        }
        if (length == 0) {
            this.zzb = new float[Math.max(i3, 10)];
            return;
        }
        while (length < i3) {
            length = zzh(length);
        }
        this.zzb = Arrays.copyOf(this.zzb, length);
    }

    private zzfo(float[] fArr, int i3, boolean z2) {
        super(z2);
        this.zzb = fArr;
        this.zzc = i3;
    }

    @Override // com.google.android.gms.internal.play_billing.zzeh, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzf(((Float) obj).floatValue());
        return true;
    }
}
