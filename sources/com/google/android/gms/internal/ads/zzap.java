package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzap {
    private final zzao[] zza;

    public zzap(long j3, zzao... zzaoVarArr) {
        this.zza = zzaoVarArr;
    }

    private static final zzao zzh(zzao zzaoVar, Class cls, zzgtk zzgtkVar) {
        if (!cls.isAssignableFrom(zzaoVar.getClass())) {
            return null;
        }
        zzao zzaoVar2 = (zzao) cls.cast(zzaoVar);
        if (zzgtkVar.zza(zzaoVar2)) {
            return zzaoVar2;
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && zzap.class == obj.getClass() && Arrays.equals(this.zza, ((zzap) obj).zza);
    }

    public final int hashCode() {
        return (Arrays.hashCode(this.zza) * 31) + Long.hashCode(-9223372036854775807L);
    }

    public final String toString() {
        String string = Arrays.toString(this.zza);
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 8);
        sb.append("entries=");
        sb.append(string);
        sb.append("");
        return sb.toString();
    }

    public final int zza() {
        return this.zza.length;
    }

    public final zzao zzb(int i3) {
        return this.zza[i3];
    }

    public final zzao zzc(Class cls, zzgtk zzgtkVar) {
        for (zzao zzaoVar : this.zza) {
            zzao zzaoVarZzh = zzh(zzaoVar, cls, zzgtkVar);
            if (zzaoVarZzh != null) {
                return zzaoVarZzh;
            }
        }
        return null;
    }

    public final zzgwm zzd(Class cls) {
        int i3 = zzgwm.zzd;
        zzgwj zzgwjVar = new zzgwj();
        for (zzao zzaoVar : this.zza) {
            if (cls.isAssignableFrom(zzaoVar.getClass())) {
                zzgwjVar.zzf((zzao) cls.cast(zzaoVar));
            }
        }
        return zzgwjVar.zzi();
    }

    public final zzgwm zze(Class cls, zzgtk zzgtkVar) {
        int i3 = zzgwm.zzd;
        zzgwj zzgwjVar = new zzgwj();
        for (zzao zzaoVar : this.zza) {
            zzao zzaoVarZzh = zzh(zzaoVar, cls, zzgtkVar);
            if (zzaoVarZzh != null) {
                zzgwjVar.zzf(zzaoVarZzh);
            }
        }
        return zzgwjVar.zzi();
    }

    public final zzap zzf(zzap zzapVar) {
        return zzapVar == null ? this : zzg(zzapVar.zza);
    }

    public final zzap zzg(zzao... zzaoVarArr) {
        int length = zzaoVarArr.length;
        if (length == 0) {
            return this;
        }
        zzao[] zzaoVarArr2 = this.zza;
        String str = zzfl.zza;
        int length2 = zzaoVarArr2.length;
        Object[] objArrCopyOf = Arrays.copyOf(zzaoVarArr2, length2 + length);
        System.arraycopy(zzaoVarArr, 0, objArrCopyOf, length2, length);
        return new zzap(-9223372036854775807L, (zzao[]) objArrCopyOf);
    }

    public zzap(List list) {
        this.zza = (zzao[]) list.toArray(new zzao[0]);
    }
}
