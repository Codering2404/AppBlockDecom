package com.google.android.gms.internal.measurement;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzae implements Iterable, zzao, zzak {
    final SortedMap zza;
    final Map zzb;

    public zzae() {
        this.zza = new TreeMap();
        this.zzb = new TreeMap();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzae)) {
            return false;
        }
        zzae zzaeVar = (zzae) obj;
        if (zzh() != zzaeVar.zzh()) {
            return false;
        }
        SortedMap sortedMap = this.zza;
        if (sortedMap.isEmpty()) {
            return zzaeVar.zza.isEmpty();
        }
        for (int iIntValue = ((Integer) sortedMap.firstKey()).intValue(); iIntValue <= ((Integer) sortedMap.lastKey()).intValue(); iIntValue++) {
            if (!zzl(iIntValue).equals(zzaeVar.zzl(iIntValue))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.zza.hashCode() * 31;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new zzad(this);
    }

    public final String toString() {
        return zzs(",");
    }

    public final List zzb() {
        ArrayList arrayList = new ArrayList(zzh());
        for (int i3 = 0; i3 < zzh(); i3++) {
            arrayList.add(zzl(i3));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final String zzc() {
        return zzs(",");
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final zzao zzcA(String str, zzg zzgVar, List list) {
        return ("concat".equals(str) || "every".equals(str) || "filter".equals(str) || "forEach".equals(str) || "indexOf".equals(str) || "join".equals(str) || "lastIndexOf".equals(str) || "map".equals(str) || "pop".equals(str) || "push".equals(str) || "reduce".equals(str) || "reduceRight".equals(str) || "reverse".equals(str) || "shift".equals(str) || "slice".equals(str) || "some".equals(str) || "sort".equals(str) || "splice".equals(str) || InAppPurchaseConstants.METHOD_TO_STRING.equals(str) || "unshift".equals(str)) ? zzba.zza(str, this, zzgVar, list) : zzak.zzu(this, new zzas(str), zzgVar, list);
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Double zzd() {
        SortedMap sortedMap = this.zza;
        return sortedMap.size() == 1 ? zzl(0).zzd() : sortedMap.size() <= 0 ? Double.valueOf(0.0d) : Double.valueOf(Double.NaN);
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Boolean zze() {
        return Boolean.TRUE;
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Iterator zzf() {
        return new zzac(this, this.zza.keySet().iterator(), this.zzb.keySet().iterator());
    }

    public final Iterator zzg() {
        return this.zza.keySet().iterator();
    }

    public final int zzh() {
        SortedMap sortedMap = this.zza;
        if (sortedMap.isEmpty()) {
            return 0;
        }
        return ((Integer) sortedMap.lastKey()).intValue() + 1;
    }

    public final int zzi() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzak
    public final boolean zzj(String str) {
        return "length".equals(str) || this.zzb.containsKey(str);
    }

    @Override // com.google.android.gms.internal.measurement.zzak
    public final zzao zzk(String str) {
        zzao zzaoVar;
        return "length".equals(str) ? new zzah(Double.valueOf(zzh())) : (!zzj(str) || (zzaoVar = (zzao) this.zzb.get(str)) == null) ? zzao.zzf : zzaoVar;
    }

    public final zzao zzl(int i3) {
        zzao zzaoVar;
        if (i3 < zzh()) {
            return (!zzo(i3) || (zzaoVar = (zzao) this.zza.get(Integer.valueOf(i3))) == null) ? zzao.zzf : zzaoVar;
        }
        throw new IndexOutOfBoundsException("Attempting to get element outside of current array");
    }

    @Override // com.google.android.gms.internal.measurement.zzak
    public final void zzm(String str, zzao zzaoVar) {
        if (zzaoVar == null) {
            this.zzb.remove(str);
        } else {
            this.zzb.put(str, zzaoVar);
        }
    }

    @RequiresNonNull
    public final void zzn(int i3, zzao zzaoVar) {
        if (i3 > 32468) {
            throw new IllegalStateException("Array too large");
        }
        if (i3 < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 21);
            sb.append("Out of bounds index: ");
            sb.append(i3);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (zzaoVar == null) {
            this.zza.remove(Integer.valueOf(i3));
        } else {
            this.zza.put(Integer.valueOf(i3), zzaoVar);
        }
    }

    public final boolean zzo(int i3) {
        if (i3 >= 0) {
            SortedMap sortedMap = this.zza;
            if (i3 <= ((Integer) sortedMap.lastKey()).intValue()) {
                return sortedMap.containsKey(Integer.valueOf(i3));
            }
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 21);
        sb.append("Out of bounds index: ");
        sb.append(i3);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final void zzp() {
        this.zza.clear();
    }

    public final void zzq(int i3, zzao zzaoVar) {
        if (i3 < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 21);
            sb.append("Invalid value index: ");
            sb.append(i3);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i3 >= zzh()) {
            zzn(i3, zzaoVar);
            return;
        }
        SortedMap sortedMap = this.zza;
        for (int iIntValue = ((Integer) sortedMap.lastKey()).intValue(); iIntValue >= i3; iIntValue--) {
            Integer numValueOf = Integer.valueOf(iIntValue);
            zzao zzaoVar2 = (zzao) sortedMap.get(numValueOf);
            if (zzaoVar2 != null) {
                zzn(iIntValue + 1, zzaoVar2);
                sortedMap.remove(numValueOf);
            }
        }
        zzn(i3, zzaoVar);
    }

    public final void zzr(int i3) {
        SortedMap sortedMap = this.zza;
        int iIntValue = ((Integer) sortedMap.lastKey()).intValue();
        if (i3 > iIntValue || i3 < 0) {
            return;
        }
        sortedMap.remove(Integer.valueOf(i3));
        if (i3 == iIntValue) {
            int i4 = i3 - 1;
            Integer numValueOf = Integer.valueOf(i4);
            if (sortedMap.containsKey(numValueOf) || i4 < 0) {
                return;
            }
            sortedMap.put(numValueOf, zzao.zzf);
            return;
        }
        while (true) {
            i3++;
            if (i3 > ((Integer) sortedMap.lastKey()).intValue()) {
                return;
            }
            Integer numValueOf2 = Integer.valueOf(i3);
            zzao zzaoVar = (zzao) sortedMap.get(numValueOf2);
            if (zzaoVar != null) {
                sortedMap.put(Integer.valueOf(i3 - 1), zzaoVar);
                sortedMap.remove(numValueOf2);
            }
        }
    }

    public final String zzs(String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        if (!this.zza.isEmpty()) {
            int i3 = 0;
            while (true) {
                str2 = str == null ? "" : str;
                if (i3 >= zzh()) {
                    break;
                }
                zzao zzaoVarZzl = zzl(i3);
                sb.append(str2);
                if (!(zzaoVarZzl instanceof zzat) && !(zzaoVarZzl instanceof zzam)) {
                    sb.append(zzaoVarZzl.zzc());
                }
                i3++;
            }
            sb.delete(0, str2.length());
        }
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final zzao zzt() {
        zzae zzaeVar = new zzae();
        for (Map.Entry entry : this.zza.entrySet()) {
            if (entry.getValue() instanceof zzak) {
                zzaeVar.zza.put((Integer) entry.getKey(), (zzao) entry.getValue());
            } else {
                zzaeVar.zza.put((Integer) entry.getKey(), ((zzao) entry.getValue()).zzt());
            }
        }
        return zzaeVar;
    }

    public zzae(List list) {
        this();
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                zzn(i3, (zzao) list.get(i3));
            }
        }
    }
}
