package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgqw extends zzgry {
    private final String zza;
    private final String zzb;

    /* synthetic */ zzgqw(String str, String str2, byte[] bArr) {
        this.zza = str;
        this.zzb = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzgry) {
            zzgry zzgryVar = (zzgry) obj;
            String str = this.zza;
            if (str != null ? str.equals(zzgryVar.zza()) : zzgryVar.zza() == null) {
                String str2 = this.zzb;
                if (str2 != null ? str2.equals(zzgryVar.zzb()) : zzgryVar.zzb() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zza;
        int iHashCode = str == null ? 0 : str.hashCode();
        String str2 = this.zzb;
        return ((iHashCode ^ 1000003) * 1000003) ^ (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        String str = this.zza;
        int length = String.valueOf(str).length();
        String str2 = this.zzb;
        StringBuilder sb = new StringBuilder(length + 49 + String.valueOf(str2).length() + 1);
        sb.append("OverlayDisplayUpdateRequest{sessionToken=");
        sb.append(str);
        sb.append(", appId=");
        sb.append(str2);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgry
    public final String zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgry
    public final String zzb() {
        return this.zzb;
    }
}
