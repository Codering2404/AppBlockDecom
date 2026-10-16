package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgvt extends AbstractMap implements Serializable {
    private static final Object zzd = new Object();
    transient int[] zza;
    transient Object[] zzb;
    transient Object[] zzc;
    private transient Object zze;
    private transient int zzf;
    private transient int zzg;
    private transient Set zzh;
    private transient Set zzi;
    private transient Collection zzj;

    zzgvt() {
        zza(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzA, reason: merged with bridge method [inline-methods] */
    public final int[] zzl() {
        int[] iArr = this.zza;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzB, reason: merged with bridge method [inline-methods] */
    public final Object[] zzm() {
        Object[] objArr = this.zzb;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzC, reason: merged with bridge method [inline-methods] */
    public final Object[] zzn() {
        Object[] objArr = this.zzc;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    private final void zzv(int i3) {
        this.zzf = ((32 - Integer.numberOfLeadingZeros(i3)) & 31) | (this.zzf & (-32));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzw, reason: merged with bridge method [inline-methods] */
    public final int zzh() {
        return (1 << (this.zzf & 31)) - 1;
    }

    private final int zzx(int i3, int i4, int i5, int i6) {
        int i7 = i4 - 1;
        Object objZza = zzgvu.zza(i4);
        if (i6 != 0) {
            zzgvu.zzc(objZza, i5 & i7, i6 + 1);
        }
        Object obj = this.zze;
        Objects.requireNonNull(obj);
        int[] iArrZzl = zzl();
        for (int i8 = 0; i8 <= i3; i8++) {
            int iZzb = zzgvu.zzb(obj, i8);
            while (iZzb != 0) {
                int i9 = iZzb - 1;
                int i10 = iArrZzl[i9];
                int i11 = ((~i3) & i10) | i8;
                int i12 = i11 & i7;
                int iZzb2 = zzgvu.zzb(objZza, i12);
                zzgvu.zzc(objZza, i12, iZzb);
                iArrZzl[i9] = ((~i7) & i11) | (iZzb2 & i7);
                iZzb = i10 & i3;
            }
        }
        this.zze = objZza;
        zzv(i7);
        return i7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzy, reason: merged with bridge method [inline-methods] */
    public final int zzi(Object obj) {
        if (zzb()) {
            return -1;
        }
        int iZzb = zzgwf.zzb(obj);
        int iZzh = zzh();
        Object obj2 = this.zze;
        Objects.requireNonNull(obj2);
        int iZzb2 = zzgvu.zzb(obj2, iZzb & iZzh);
        if (iZzb2 != 0) {
            int i3 = ~iZzh;
            int i4 = iZzb & i3;
            do {
                int i5 = iZzb2 - 1;
                int i6 = zzl()[i5];
                if ((i6 & i3) == i4 && Objects.equals(obj, zzm()[i5])) {
                    return i5;
                }
                iZzb2 = i6 & iZzh;
            } while (iZzb2 != 0);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzz, reason: merged with bridge method [inline-methods] */
    public final Object zzj(Object obj) {
        if (!zzb()) {
            int iZzh = zzh();
            Object obj2 = this.zze;
            Objects.requireNonNull(obj2);
            int iZze = zzgvu.zze(obj, null, iZzh, obj2, zzl(), zzm(), null);
            if (iZze != -1) {
                Object obj3 = zzn()[iZze];
                zze(iZze, iZzh);
                this.zzg--;
                zzd();
                return obj3;
            }
        }
        return zzd;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (zzb()) {
            return;
        }
        zzd();
        Map mapZzc = zzc();
        if (mapZzc != null) {
            this.zzf = zzhah.zzc(size(), 3, 1073741823);
            mapZzc.clear();
            this.zze = null;
            this.zzg = 0;
            return;
        }
        Arrays.fill(zzm(), 0, this.zzg, (Object) null);
        Arrays.fill(zzn(), 0, this.zzg, (Object) null);
        Object obj = this.zze;
        Objects.requireNonNull(obj);
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
        Arrays.fill(zzl(), 0, this.zzg, 0);
        this.zzg = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Map mapZzc = zzc();
        return mapZzc != null ? mapZzc.containsKey(obj) : zzi(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        Map mapZzc = zzc();
        if (mapZzc != null) {
            return mapZzc.containsValue(obj);
        }
        for (int i3 = 0; i3 < this.zzg; i3++) {
            if (Objects.equals(obj, zzn()[i3])) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        Set set = this.zzi;
        if (set != null) {
            return set;
        }
        zzgvo zzgvoVar = new zzgvo(this, null);
        this.zzi = zzgvoVar;
        return zzgvoVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Map mapZzc = zzc();
        if (mapZzc != null) {
            return mapZzc.get(obj);
        }
        int iZzi = zzi(obj);
        if (iZzi == -1) {
            return null;
        }
        return zzn()[iZzi];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        Set set = this.zzh;
        if (set != null) {
            return set;
        }
        zzgvq zzgvqVar = new zzgvq(this, null);
        this.zzh = zzgvqVar;
        return zzgvqVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        int i3;
        if (zzb()) {
            zzgtj.zzj(zzb(), "Arrays already allocated");
            int i4 = this.zzf;
            int iMax = Math.max(i4 + 1, 2);
            int iHighestOneBit = Integer.highestOneBit(iMax);
            if (iMax > iHighestOneBit && (iHighestOneBit = iHighestOneBit + iHighestOneBit) <= 0) {
                iHighestOneBit = 1073741824;
            }
            int iMax2 = Math.max(4, iHighestOneBit);
            this.zze = zzgvu.zza(iMax2);
            zzv(iMax2 - 1);
            this.zza = new int[i4];
            this.zzb = new Object[i4];
            this.zzc = new Object[i4];
        }
        Map mapZzc = zzc();
        if (mapZzc != null) {
            return mapZzc.put(obj, obj2);
        }
        int[] iArrZzl = zzl();
        Object[] objArrZzm = zzm();
        Object[] objArrZzn = zzn();
        int i5 = this.zzg;
        int i6 = i5 + 1;
        int iZzb = zzgwf.zzb(obj);
        int iZzh = zzh();
        int i7 = iZzb & iZzh;
        Object obj3 = this.zze;
        Objects.requireNonNull(obj3);
        int iZzb2 = zzgvu.zzb(obj3, i7);
        if (iZzb2 == 0) {
            if (i6 > iZzh) {
                iZzh = zzx(iZzh, zzgvu.zzd(iZzh), iZzb, i5);
            } else {
                Object obj4 = this.zze;
                Objects.requireNonNull(obj4);
                zzgvu.zzc(obj4, i7, i6);
            }
            i3 = 1;
        } else {
            int i8 = ~iZzh;
            int i9 = iZzb & i8;
            int i10 = 0;
            while (true) {
                int i11 = iZzb2 - 1;
                int i12 = iArrZzl[i11];
                i3 = 1;
                int i13 = i12 & i8;
                if (i13 == i9 && Objects.equals(obj, objArrZzm[i11])) {
                    Object obj5 = objArrZzn[i11];
                    objArrZzn[i11] = obj2;
                    return obj5;
                }
                int i14 = i12 & iZzh;
                i10++;
                if (i14 != 0) {
                    iZzb2 = i14;
                } else {
                    if (i10 >= 9) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap(zzh() + 1, 1.0f);
                        int iZzf = zzf();
                        while (iZzf >= 0) {
                            linkedHashMap.put(zzm()[iZzf], zzn()[iZzf]);
                            iZzf = zzg(iZzf);
                        }
                        this.zze = linkedHashMap;
                        this.zza = null;
                        this.zzb = null;
                        this.zzc = null;
                        zzd();
                        return linkedHashMap.put(obj, obj2);
                    }
                    if (i6 > iZzh) {
                        iZzh = zzx(iZzh, zzgvu.zzd(iZzh), iZzb, i5);
                    } else {
                        iArrZzl[i11] = (i6 & iZzh) | i13;
                    }
                }
            }
        }
        int length = zzl().length;
        if (i6 > length) {
            int i15 = i3;
            int iMin = Math.min(1073741823, (Math.max(i15, length >>> 1) + length) | i15);
            if (iMin != length) {
                this.zza = Arrays.copyOf(zzl(), iMin);
                this.zzb = Arrays.copyOf(zzm(), iMin);
                this.zzc = Arrays.copyOf(zzn(), iMin);
            }
        }
        zzl()[i5] = (~iZzh) & iZzb;
        zzm()[i5] = obj;
        zzn()[i5] = obj2;
        this.zzg = i6;
        zzd();
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        Map mapZzc = zzc();
        if (mapZzc != null) {
            return mapZzc.remove(obj);
        }
        Object objZzj = zzj(obj);
        if (objZzj == zzd) {
            return null;
        }
        return objZzj;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        Map mapZzc = zzc();
        return mapZzc != null ? mapZzc.size() : this.zzg;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        Collection collection = this.zzj;
        if (collection != null) {
            return collection;
        }
        zzgvs zzgvsVar = new zzgvs(this, null);
        this.zzj = zzgvsVar;
        return zzgvsVar;
    }

    final void zza(int i3) {
        this.zzf = zzhah.zzc(i3, 1, 1073741823);
    }

    final boolean zzb() {
        return this.zze == null;
    }

    final Map zzc() {
        Object obj = this.zze;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    final void zzd() {
        this.zzf += 32;
    }

    final void zze(int i3, int i4) {
        Object obj = this.zze;
        Objects.requireNonNull(obj);
        int[] iArrZzl = zzl();
        Object[] objArrZzm = zzm();
        Object[] objArrZzn = zzn();
        int size = size();
        int i5 = size - 1;
        if (i3 >= i5) {
            objArrZzm[i3] = null;
            objArrZzn[i3] = null;
            iArrZzl[i3] = 0;
            return;
        }
        int i6 = i3 + 1;
        Object obj2 = objArrZzm[i5];
        objArrZzm[i3] = obj2;
        objArrZzn[i3] = objArrZzn[i5];
        objArrZzm[i5] = null;
        objArrZzn[i5] = null;
        iArrZzl[i3] = iArrZzl[i5];
        iArrZzl[i5] = 0;
        int iZzb = zzgwf.zzb(obj2) & i4;
        int iZzb2 = zzgvu.zzb(obj, iZzb);
        if (iZzb2 == size) {
            zzgvu.zzc(obj, iZzb, i6);
            return;
        }
        while (true) {
            int i7 = iZzb2 - 1;
            int i8 = iArrZzl[i7];
            int i9 = i8 & i4;
            if (i9 == size) {
                iArrZzl[i7] = (i8 & (~i4)) | (i4 & i6);
                return;
            }
            iZzb2 = i9;
        }
    }

    final int zzf() {
        return isEmpty() ? -1 : 0;
    }

    final int zzg(int i3) {
        int i4 = i3 + 1;
        if (i4 < this.zzg) {
            return i4;
        }
        return -1;
    }

    final /* synthetic */ Object zzk() {
        Object obj = this.zze;
        Objects.requireNonNull(obj);
        return obj;
    }

    final /* synthetic */ Object zzo(int i3) {
        return zzm()[i3];
    }

    final /* synthetic */ Object zzp(int i3) {
        return zzn()[i3];
    }

    final /* synthetic */ void zzq(int i3, Object obj) {
        zzn()[i3] = obj;
    }

    final /* synthetic */ int zzs() {
        return this.zzf;
    }

    final /* synthetic */ int zzt() {
        return this.zzg;
    }

    final /* synthetic */ void zzu(int i3) {
        this.zzg = i3;
    }

    zzgvt(int i3) {
        zza(8);
    }
}
