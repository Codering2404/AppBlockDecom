package com.google.android.gms.internal.fido;

import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhg extends zzhp {
    private final zzcc zza;
    private final int zzb;

    zzhg(zzcc zzccVar) throws zzhf {
        zzccVar.getClass();
        this.zza = zzccVar;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            zzcc zzccVar2 = this.zza;
            if (i3 >= zzccVar2.size()) {
                break;
            }
            int iZzb = ((zzhp) zzccVar2.get(i3)).zzb();
            if (i4 < iZzb) {
                i4 = iZzb;
            }
            i3++;
        }
        int i5 = i4 + 1;
        this.zzb = i5;
        if (i5 > 8) {
            throw new zzhf("Exceeded cutoff limit for max depth of cbor value");
        }
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzhp zzhpVar = (zzhp) obj;
        if (zzhp.zzd((byte) -128) != zzhpVar.zza()) {
            return zzhp.zzd((byte) -128) - zzhpVar.zza();
        }
        zzhg zzhgVar = (zzhg) zzhpVar;
        zzcc zzccVar = this.zza;
        int size = zzccVar.size();
        zzcc zzccVar2 = zzhgVar.zza;
        if (size != zzccVar2.size()) {
            return zzccVar.size() - zzccVar2.size();
        }
        int i3 = 0;
        while (true) {
            zzcc zzccVar3 = this.zza;
            if (i3 >= zzccVar3.size()) {
                return 0;
            }
            int iCompareTo = ((zzhp) zzccVar3.get(i3)).compareTo((zzhp) zzhgVar.zza.get(i3));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            i3++;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzhg.class == obj.getClass()) {
            return this.zza.equals(((zzhg) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(zzhp.zzd((byte) -128)), this.zza});
    }

    public final String toString() {
        if (this.zza.isEmpty()) {
            return "[]";
        }
        ArrayList arrayList = new ArrayList();
        zzcc zzccVar = this.zza;
        int size = zzccVar.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add(((zzhp) zzccVar.get(i3)).toString().replace("\n", "\n  "));
        }
        zzbd zzbdVarZza = zzbd.zza(",\n  ");
        StringBuilder sb = new StringBuilder("[\n  ");
        zzbdVarZza.zzc(sb, arrayList.iterator());
        sb.append("\n]");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.fido.zzhp
    protected final int zza() {
        return zzhp.zzd((byte) -128);
    }

    @Override // com.google.android.gms.internal.fido.zzhp
    protected final int zzb() {
        return this.zzb;
    }
}
