package com.google.android.gms.internal.maps;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzba extends zzaw implements Set {

    @CheckForNull
    private transient zzaz zza;

    zzba() {
    }

    static int zzf(int i3) {
        int iMax = Math.max(i3, 2);
        if (iMax >= 751619276) {
            if (iMax < 1073741824) {
                return 1073741824;
            }
            throw new IllegalArgumentException("collection too large");
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1);
        do {
            iHighestOneBit += iHighestOneBit;
        } while (((double) iHighestOneBit) * 0.7d < iMax);
        return iHighestOneBit;
    }

    @SafeVarargs
    public static zzba zzi(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object... objArr) {
        Object[] objArr2 = {"ADMINISTRATIVE_AREA_LEVEL_1", "ADMINISTRATIVE_AREA_LEVEL_2", "COUNTRY", "LOCALITY", "POSTAL_CODE", "SCHOOL_DISTRICT"};
        System.arraycopy(objArr, 0, objArr2, 6, 0);
        return zzk(6, objArr2);
    }

    private static zzba zzk(int i3, Object... objArr) {
        if (i3 == 0) {
            return zzbd.zza;
        }
        if (i3 == 1) {
            Object obj = objArr[0];
            obj.getClass();
            return new zzbe(obj);
        }
        int iZzf = zzf(i3);
        Object[] objArr2 = new Object[iZzf];
        int i4 = iZzf - 1;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < i3; i7++) {
            Object obj2 = objArr[i7];
            if (obj2 == null) {
                throw new NullPointerException("at index " + i7);
            }
            int iHashCode = obj2.hashCode();
            int iZza = zzav.zza(iHashCode);
            while (true) {
                int i8 = iZza & i4;
                Object obj3 = objArr2[i8];
                if (obj3 == null) {
                    objArr[i6] = obj2;
                    objArr2[i8] = obj2;
                    i5 += iHashCode;
                    i6++;
                    break;
                }
                if (!obj3.equals(obj2)) {
                    iZza++;
                }
            }
        }
        Arrays.fill(objArr, i6, i3, (Object) null);
        if (i6 == 1) {
            Object obj4 = objArr[0];
            obj4.getClass();
            return new zzbe(obj4);
        }
        if (zzf(i6) < iZzf / 2) {
            return zzk(i6, objArr);
        }
        if (i6 < 4) {
            objArr = Arrays.copyOf(objArr, i6);
        }
        return new zzbd(objArr, i5, objArr2, i4, i6);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzba) && zzj() && ((zzba) obj).zzj() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    return containsAll(set);
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode += next != null ? next.hashCode() : 0;
        }
        return iHashCode;
    }

    @Override // com.google.android.gms.internal.maps.zzaw, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zzd */
    public abstract zzbf iterator();

    public final zzaz zzg() {
        zzaz zzazVar = this.zza;
        if (zzazVar != null) {
            return zzazVar;
        }
        zzaz zzazVarZzh = zzh();
        this.zza = zzazVarZzh;
        return zzazVarZzh;
    }

    zzaz zzh() {
        Object[] array = toArray();
        int i3 = zzaz.zzd;
        return zzaz.zzg(array, array.length);
    }

    boolean zzj() {
        return false;
    }
}
