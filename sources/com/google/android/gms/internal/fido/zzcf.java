package com.google.android.gms.internal.fido;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzcf extends zzby implements Set {

    @CheckForNull
    private transient zzcc zza;

    zzcf() {
    }

    private static zzcf zzf(int i3, Object... objArr) {
        if (i3 == 0) {
            return zzcu.zza;
        }
        if (i3 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return new zzcz(obj);
        }
        int iZzh = zzh(i3);
        Object[] objArr2 = new Object[iZzh];
        int i4 = iZzh - 1;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < i3; i7++) {
            Object obj2 = objArr[i7];
            zzcr.zza(obj2, i7);
            int iHashCode = obj2.hashCode();
            int iZza = zzbx.zza(iHashCode);
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
            Objects.requireNonNull(obj4);
            return new zzcz(obj4);
        }
        if (zzh(i6) < iZzh / 2) {
            return zzf(i6, objArr);
        }
        if (i6 <= 0) {
            objArr = Arrays.copyOf(objArr, i6);
        }
        return new zzcu(objArr, i5, objArr2, i4, i6);
    }

    static int zzh(int i3) {
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

    public static zzcf zzk() {
        return zzcu.zza;
    }

    public static zzcf zzl(Object obj) {
        return new zzcz("FIDO");
    }

    public static zzcf zzm(Object obj, Object obj2) {
        return zzf(2, obj, obj2);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzcf) && zzg() && ((zzcf) obj).zzg() && hashCode() != obj.hashCode()) {
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
        return zzcy.zza(this);
    }

    @Override // com.google.android.gms.internal.fido.zzby, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zzd */
    public abstract zzdc iterator();

    boolean zzg() {
        return false;
    }

    public zzcc zzi() {
        zzcc zzccVar = this.zza;
        if (zzccVar != null) {
            return zzccVar;
        }
        zzcc zzccVarZzj = zzj();
        this.zza = zzccVarZzj;
        return zzccVarZzj;
    }

    zzcc zzj() {
        Object[] array = toArray();
        int i3 = zzcc.zzd;
        return zzcc.zzh(array, array.length);
    }
}
