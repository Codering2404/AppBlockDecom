package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzajt extends zzajo {
    public final String zza;
    public final zzgwm zzb;

    public zzajt(String str, String str2, List list) {
        super(str);
        zzgtj.zza(!list.isEmpty());
        this.zza = str2;
        zzgwm zzgwmVarZzq = zzgwm.zzq(list);
        this.zzb = zzgwmVarZzq;
    }

    private static List zzb(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(8, 10))));
                return arrayList;
            }
            if (str.length() >= 7) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                return arrayList;
            }
            if (str.length() >= 4) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
            }
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzajt.class == obj.getClass()) {
            zzajt zzajtVar = (zzajt) obj;
            if (Objects.equals(this.zzf, zzajtVar.zzf) && Objects.equals(this.zza, zzajtVar.zza) && this.zzb.equals(zzajtVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zzf.hashCode() + 527;
        String str = this.zza;
        return (((iHashCode * 31) + (str != null ? str.hashCode() : 0)) * 31) + this.zzb.hashCode();
    }

    @Override // com.google.android.gms.internal.ads.zzajo
    public final String toString() {
        String strValueOf = String.valueOf(this.zzb);
        String str = this.zzf;
        int length = String.valueOf(str).length();
        String str2 = this.zza;
        StringBuilder sb = new StringBuilder(length + 14 + String.valueOf(str2).length() + 9 + strValueOf.length());
        sb.append(str);
        sb.append(": description=");
        sb.append(str2);
        sb.append(": values=");
        sb.append(strValueOf);
        return sb.toString();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0181 A[Catch: NumberFormatException | StringIndexOutOfBoundsException -> 0x0203, TryCatch #0 {NumberFormatException | StringIndexOutOfBoundsException -> 0x0203, blocks: (B:69:0x0123, B:82:0x0178, B:84:0x0181, B:86:0x018d, B:102:0x01dc), top: B:113:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x018c  */
    @Override // com.google.android.gms.internal.ads.zzao
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(com.google.android.gms.internal.ads.zzam r7) {
        /*
            Method dump skipped, instruction units count: 650
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzajt.zza(com.google.android.gms.internal.ads.zzam):void");
    }
}
