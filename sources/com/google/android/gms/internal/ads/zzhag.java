package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.Spliterators;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhag extends AbstractList implements RandomAccess, Serializable {
    final int[] zza;
    final int zzb;
    final int zzc;

    zzhag(int[] iArr, int i3, int i4) {
        this.zza = iArr;
        this.zzb = i3;
        this.zzc = i4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return (obj instanceof Integer) && zzhah.zzi(this.zza, ((Integer) obj).intValue(), this.zzb, this.zzc) != -1;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzhag)) {
            return super.equals(obj);
        }
        zzhag zzhagVar = (zzhag) obj;
        int i3 = this.zzc;
        int i4 = this.zzb;
        int i5 = zzhagVar.zzc;
        int i6 = zzhagVar.zzb;
        int i7 = i3 - i4;
        if (i5 - i6 != i7) {
            return false;
        }
        for (int i8 = 0; i8 < i7; i8++) {
            if (this.zza[i4 + i8] != zzhagVar.zza[i6 + i8]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i3) {
        int i4 = this.zzc;
        int i5 = this.zzb;
        zzgtj.zzm(i3, i4 - i5, "index");
        return Integer.valueOf(this.zza[i5 + i3]);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iHashCode = 1;
        for (int i3 = this.zzb; i3 < this.zzc; i3++) {
            iHashCode = (iHashCode * 31) + Integer.hashCode(this.zza[i3]);
        }
        return iHashCode;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int[] iArr = this.zza;
        int iIntValue = ((Integer) obj).intValue();
        int i3 = this.zzb;
        int iZzi = zzhah.zzi(iArr, iIntValue, i3, this.zzc);
        if (iZzi >= 0) {
            return iZzi - i3;
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj instanceof Integer) {
            int[] iArr = this.zza;
            int iIntValue = ((Integer) obj).intValue();
            int i3 = this.zzb;
            int i4 = this.zzc - 1;
            while (true) {
                if (i4 < i3) {
                    i4 = -1;
                    break;
                }
                if (iArr[i4] == iIntValue) {
                    break;
                }
                i4--;
            }
            if (i4 >= 0) {
                return i4 - i3;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i3, Object obj) {
        int i4 = this.zzc;
        int i5 = this.zzb;
        Integer num = (Integer) obj;
        zzgtj.zzm(i3, i4 - i5, "index");
        int[] iArr = this.zza;
        int i6 = i5 + i3;
        int i7 = iArr[i6];
        num.getClass();
        iArr[i6] = num.intValue();
        return Integer.valueOf(i7);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc - this.zzb;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return Spliterators.spliterator(this.zza, this.zzb, this.zzc, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i3, int i4) {
        int i5 = this.zzc;
        int i6 = this.zzb;
        zzgtj.zzo(i3, i4, i5 - i6);
        return i3 == i4 ? Collections.EMPTY_LIST : new zzhag(this.zza, i3 + i6, i6 + i4);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        int i3 = this.zzc;
        int i4 = this.zzb;
        StringBuilder sb = new StringBuilder((i3 - i4) * 5);
        sb.append('[');
        int[] iArr = this.zza;
        sb.append(iArr[i4]);
        while (true) {
            i4++;
            if (i4 >= i3) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            sb.append(iArr[i4]);
        }
    }
}
