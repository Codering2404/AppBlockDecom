package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfzj extends zzfzp {
    private final String zzb;
    private final int zzc;
    private final int zzd;

    /* synthetic */ zzfzj(String str, boolean z2, int i3, zzfzh zzfzhVar, int i4, byte[] bArr) {
        this.zzb = str;
        this.zzc = i3;
        this.zzd = i4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfzp) {
            zzfzp zzfzpVar = (zzfzp) obj;
            if (this.zzb.equals(zzfzpVar.zza())) {
                zzfzpVar.zzb();
                int i3 = this.zzc;
                int iZzd = zzfzpVar.zzd();
                if (i3 == 0) {
                    throw null;
                }
                if (i3 == iZzd) {
                    zzfzpVar.zzc();
                    int i4 = this.zzd;
                    int iZze = zzfzpVar.zze();
                    if (i4 == 0) {
                        throw null;
                    }
                    if (iZze == 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zzb.hashCode() ^ 1000003;
        int i3 = this.zzc;
        if (i3 == 0) {
            throw null;
        }
        int i4 = (((iHashCode * 1000003) ^ 1237) * 1000003) ^ i3;
        if (this.zzd != 0) {
            return (i4 * (-721379959)) ^ 1;
        }
        throw null;
    }

    public final String toString() {
        int i3 = this.zzc;
        String str = i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? "null" : "NO_CHECKS" : "SKIP_SECURITY_CHECK" : "SKIP_COMPLIANCE_CHECK" : "ALL_CHECKS";
        String str2 = this.zzd == 1 ? "READ_AND_WRITE" : "null";
        String str3 = this.zzb;
        StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 73 + str.length() + 52 + str2.length() + 1);
        sb.append("FileComplianceOptions{fileOwner=");
        sb.append(str3);
        sb.append(", hasDifferentDmaOwner=false, fileChecks=");
        sb.append(str);
        sb.append(", multipleProductIdGroupsResolver=null, filePurpose=");
        sb.append(str2);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final String zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final boolean zzb() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final zzfzh zzc() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final int zze() {
        return this.zzd;
    }
}
