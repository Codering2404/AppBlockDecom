package com.google.firebase.auth.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzn extends zzj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f87990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f87991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f87992c;

    @Override // com.google.firebase.auth.internal.zzj
    public final String b() {
        return this.f87991b;
    }

    @Override // com.google.firebase.auth.internal.zzj
    public final String c() {
        return this.f87992c;
    }

    @Override // com.google.firebase.auth.internal.zzj
    public final String d() {
        return this.f87990a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzj) {
            zzj zzjVar = (zzj) obj;
            String str = this.f87990a;
            if (str != null ? str.equals(zzjVar.d()) : zzjVar.d() == null) {
                String str2 = this.f87991b;
                if (str2 != null ? str2.equals(zzjVar.b()) : zzjVar.b() == null) {
                    String str3 = this.f87992c;
                    if (str3 != null ? str3.equals(zzjVar.c()) : zzjVar.c() == null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f87990a;
        int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f87991b;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f87992c;
        return iHashCode2 ^ (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        return "AttestationResult{recaptchaV2Token=" + this.f87990a + ", playIntegrityToken=" + this.f87991b + ", recaptchaEnterpriseToken=" + this.f87992c + "}";
    }

    public zzn(String str, String str2, String str3) {
        this.f87990a = str;
        this.f87991b = str2;
        this.f87992c = str3;
    }
}
