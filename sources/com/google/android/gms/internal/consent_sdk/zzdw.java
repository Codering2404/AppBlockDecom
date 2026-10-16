package com.google.android.gms.internal.consent_sdk;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzdw extends zzds implements Set {
    private transient zzdv zza;

    zzdw() {
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

    public static zzdw zzi() {
        return zzdz.zza;
    }

    public static zzdw zzj(Object obj, Object obj2, Object obj3, Object obj4) {
        return zzm(4, "IABTCF_TCString", "IABGPP_HDR_GppString", "IABGPP_GppSID", "IABUSPrivacy_String");
    }

    public static zzdw zzk(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return zzm(5, "UMP_CoMoAdStoragePurposeConsentStatus", "UMP_CoMoAdUserDataPurposeConsentStatus", "UMP_CoMoAdPersonalizationPurposeConsentStatus", "UMP_CoMoAnalyticsStoragePurposeConsentStatus", "IABTCF_gdprApplies");
    }

    private static zzdw zzm(int i3, Object... objArr) {
        if (i3 == 0) {
            return zzdz.zza;
        }
        if (i3 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return new zzea(obj);
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
            int iZza = zzdr.zza(iHashCode);
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
            return new zzea(obj4);
        }
        if (zzf(i6) < iZzf / 2) {
            return zzm(i6, objArr);
        }
        if (i6 < 3) {
            objArr = Arrays.copyOf(objArr, i6);
        }
        return new zzdz(objArr, i5, objArr2, i4, i6);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzdw) && zzl() && ((zzdw) obj).zzl() && hashCode() != obj.hashCode()) {
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

    @Override // com.google.android.gms.internal.consent_sdk.zzds, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zzd */
    public abstract zzeb iterator();

    public final zzdv zzg() {
        zzdv zzdvVar = this.zza;
        if (zzdvVar != null) {
            return zzdvVar;
        }
        zzdv zzdvVarZzh = zzh();
        this.zza = zzdvVarZzh;
        return zzdvVarZzh;
    }

    zzdv zzh() {
        Object[] array = toArray();
        int i3 = zzdv.zzd;
        return zzdv.zzg(array, array.length);
    }

    boolean zzl() {
        return false;
    }
}
