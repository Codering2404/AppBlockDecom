package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgqu extends zzgrv {
    private final int zza;
    private final String zzb;
    private final int zzc;

    /* synthetic */ zzgqu(int i3, String str, int i4, byte[] bArr) {
        this.zza = i3;
        this.zzb = str;
        this.zzc = i4;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzgrv) {
            zzgrv zzgrvVar = (zzgrv) obj;
            if (this.zza == zzgrvVar.zza() && ((str = this.zzb) != null ? str.equals(zzgrvVar.zzb()) : zzgrvVar.zzb() == null) && this.zzc == zzgrvVar.zzc()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zzb;
        return (((str == null ? 0 : str.hashCode()) ^ ((this.zza ^ 1000003) * 1000003)) * 1000003) ^ this.zzc;
    }

    public final String toString() {
        int i3 = this.zza;
        int length = String.valueOf(i3).length();
        String str = this.zzb;
        int length2 = String.valueOf(str).length();
        int i4 = this.zzc;
        StringBuilder sb = new StringBuilder(length + 46 + length2 + 9 + String.valueOf(i4).length() + 1);
        sb.append("OverlayDisplayState{statusCode=");
        sb.append(i3);
        sb.append(", sessionToken=");
        sb.append(str);
        sb.append(", uiMode=");
        sb.append(i4);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgrv
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgrv
    public final String zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgrv
    public final int zzc() {
        return this.zzc;
    }
}
