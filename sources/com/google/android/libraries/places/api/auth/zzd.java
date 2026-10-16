package com.google.android.libraries.places.api.auth;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzd extends zzb {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f74908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f74909c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f74910d;

    /* synthetic */ zzd(boolean z2, String str, String str2, byte[] bArr) {
        this.f74908b = z2;
        this.f74909c = str;
        this.f74910d = str2;
    }

    @Override // com.google.android.libraries.places.api.auth.zzb
    public final boolean a() {
        return this.f74908b;
    }

    @Override // com.google.android.libraries.places.api.auth.zzb
    public final String b() {
        return this.f74909c;
    }

    @Override // com.google.android.libraries.places.api.auth.zzb
    public final String c() {
        return this.f74910d;
    }

    public final boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzb) {
            zzb zzbVar = (zzb) obj;
            if (this.f74908b == zzbVar.a() && ((str = this.f74909c) != null ? str.equals(zzbVar.b()) : zzbVar.b() == null) && ((str2 = this.f74910d) != null ? str2.equals(zzbVar.c()) : zzbVar.c() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f74909c;
        int iHashCode = (str == null ? 0 : str.hashCode()) ^ (((true != this.f74908b ? 1237 : 1231) ^ 1000003) * 1000003);
        String str2 = this.f74910d;
        return (iHashCode * 1000003) ^ (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        boolean z2 = this.f74908b;
        int length = String.valueOf(z2).length();
        String str = this.f74909c;
        int length2 = String.valueOf(str).length();
        String str2 = this.f74910d;
        StringBuilder sb = new StringBuilder(length + 47 + length2 + 26 + String.valueOf(str2).length() + 1);
        sb.append("AppCheckResult{appCheckEnabled=");
        sb.append(z2);
        sb.append(", appCheckToken=");
        sb.append(str);
        sb.append(", appCheckTokenFetchError=");
        sb.append(str2);
        sb.append("}");
        return sb.toString();
    }
}
