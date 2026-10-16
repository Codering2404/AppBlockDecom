package com.google.android.gms.internal.ads;

import coil.target.Yb.oUcQRqOVfOC;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfd extends IllegalStateException {
    public final int zza;
    public final int zzb;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzfd.class == obj.getClass()) {
            zzfd zzfdVar = (zzfd) obj;
            if (this.zza == zzfdVar.zza && this.zzb == zzfdVar.zzb) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zza + 527) * 31) + this.zzb;
    }

    public zzfd(int i3, int i4) {
        String string;
        if (i3 == 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 46);
            sb.append("Player stuck buffering and not loading for ");
            sb.append(i4);
            sb.append(" ms");
            string = sb.toString();
        } else if (i3 == 1) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(i4).length() + 47);
            sb2.append(oUcQRqOVfOC.sqFsLPpjggDwO);
            sb2.append(i4);
            sb2.append(" ms");
            string = sb2.toString();
        } else if (i3 == 2) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(i4).length() + 45);
            sb3.append("Player stuck playing with no progress for ");
            sb3.append(i4);
            sb3.append(" ms");
            string = sb3.toString();
        } else if (i3 != 3) {
            StringBuilder sb4 = new StringBuilder(String.valueOf(i4).length() + 31);
            sb4.append("Player stuck suppressed for ");
            sb4.append(i4);
            sb4.append(" ms");
            string = sb4.toString();
        } else {
            StringBuilder sb5 = new StringBuilder(String.valueOf(i4).length() + 43);
            sb5.append("Player stuck playing without ending for ");
            sb5.append(i4);
            sb5.append(" ms");
            string = sb5.toString();
        }
        super(string);
        this.zza = i3;
        this.zzb = i4;
    }
}
