package com.google.android.play.core.install;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zza extends InstallState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f82941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f82942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f82943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f82944d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f82945e;

    zza(int i3, long j3, long j4, int i4, String str) {
        this.f82941a = i3;
        this.f82942b = j3;
        this.f82943c = j4;
        this.f82944d = i4;
        if (str == null) {
            throw new NullPointerException("Null packageName");
        }
        this.f82945e = str;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final long a() {
        return this.f82942b;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final int b() {
        return this.f82944d;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final int c() {
        return this.f82941a;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final String d() {
        return this.f82945e;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final long e() {
        return this.f82943c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InstallState) {
            InstallState installState = (InstallState) obj;
            if (this.f82941a == installState.c() && this.f82942b == installState.a() && this.f82943c == installState.e() && this.f82944d == installState.b() && this.f82945e.equals(installState.d())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i3 = this.f82941a ^ 1000003;
        long j3 = this.f82942b;
        long j4 = this.f82943c;
        return (((((((i3 * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ ((int) ((j4 >>> 32) ^ j4))) * 1000003) ^ this.f82944d) * 1000003) ^ this.f82945e.hashCode();
    }

    public final String toString() {
        return "InstallState{installStatus=" + this.f82941a + ", bytesDownloaded=" + this.f82942b + ", totalBytesToDownload=" + this.f82943c + ", installErrorCode=" + this.f82944d + ", packageName=" + this.f82945e + "}";
    }
}
