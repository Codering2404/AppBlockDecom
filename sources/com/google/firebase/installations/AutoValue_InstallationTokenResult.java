package com.google.firebase.installations;

import com.google.firebase.installations.InstallationTokenResult;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_InstallationTokenResult extends InstallationTokenResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f89215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f89216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f89217c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends InstallationTokenResult.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f89218a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Long f89219b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Long f89220c;

        Builder() {
        }

        @Override // com.google.firebase.installations.InstallationTokenResult.Builder
        public InstallationTokenResult a() {
            String str = "";
            if (this.f89218a == null) {
                str = " token";
            }
            if (this.f89219b == null) {
                str = str + " tokenExpirationTimestamp";
            }
            if (this.f89220c == null) {
                str = str + " tokenCreationTimestamp";
            }
            if (str.isEmpty()) {
                return new AutoValue_InstallationTokenResult(this.f89218a, this.f89219b.longValue(), this.f89220c.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.installations.InstallationTokenResult.Builder
        public InstallationTokenResult.Builder b(String str) {
            if (str == null) {
                throw new NullPointerException("Null token");
            }
            this.f89218a = str;
            return this;
        }

        @Override // com.google.firebase.installations.InstallationTokenResult.Builder
        public InstallationTokenResult.Builder c(long j3) {
            this.f89220c = Long.valueOf(j3);
            return this;
        }

        @Override // com.google.firebase.installations.InstallationTokenResult.Builder
        public InstallationTokenResult.Builder d(long j3) {
            this.f89219b = Long.valueOf(j3);
            return this;
        }
    }

    @Override // com.google.firebase.installations.InstallationTokenResult
    public String b() {
        return this.f89215a;
    }

    @Override // com.google.firebase.installations.InstallationTokenResult
    public long c() {
        return this.f89217c;
    }

    @Override // com.google.firebase.installations.InstallationTokenResult
    public long d() {
        return this.f89216b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InstallationTokenResult) {
            InstallationTokenResult installationTokenResult = (InstallationTokenResult) obj;
            if (this.f89215a.equals(installationTokenResult.b()) && this.f89216b == installationTokenResult.d() && this.f89217c == installationTokenResult.c()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.f89215a.hashCode() ^ 1000003) * 1000003;
        long j3 = this.f89216b;
        long j4 = this.f89217c;
        return ((iHashCode ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)));
    }

    public String toString() {
        return "InstallationTokenResult{token=" + this.f89215a + ", tokenExpirationTimestamp=" + this.f89216b + ", tokenCreationTimestamp=" + this.f89217c + "}";
    }

    private AutoValue_InstallationTokenResult(String str, long j3, long j4) {
        this.f89215a = str;
        this.f89216b = j3;
        this.f89217c = j4;
    }
}
