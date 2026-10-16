package com.google.firebase.installations.remote;

import com.google.firebase.installations.remote.InstallationResponse;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_InstallationResponse extends InstallationResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f89295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f89296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f89297c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TokenResult f89298d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final InstallationResponse.ResponseCode f89299e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends InstallationResponse.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f89300a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f89301b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f89302c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private TokenResult f89303d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private InstallationResponse.ResponseCode f89304e;

        Builder() {
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public InstallationResponse a() {
            return new AutoValue_InstallationResponse(this.f89300a, this.f89301b, this.f89302c, this.f89303d, this.f89304e);
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public InstallationResponse.Builder b(TokenResult tokenResult) {
            this.f89303d = tokenResult;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public InstallationResponse.Builder c(String str) {
            this.f89301b = str;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public InstallationResponse.Builder d(String str) {
            this.f89302c = str;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public InstallationResponse.Builder e(InstallationResponse.ResponseCode responseCode) {
            this.f89304e = responseCode;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public InstallationResponse.Builder f(String str) {
            this.f89300a = str;
            return this;
        }
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public TokenResult b() {
        return this.f89298d;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public String c() {
        return this.f89296b;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public String d() {
        return this.f89297c;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public InstallationResponse.ResponseCode e() {
        return this.f89299e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InstallationResponse) {
            InstallationResponse installationResponse = (InstallationResponse) obj;
            String str = this.f89295a;
            if (str != null ? str.equals(installationResponse.f()) : installationResponse.f() == null) {
                String str2 = this.f89296b;
                if (str2 != null ? str2.equals(installationResponse.c()) : installationResponse.c() == null) {
                    String str3 = this.f89297c;
                    if (str3 != null ? str3.equals(installationResponse.d()) : installationResponse.d() == null) {
                        TokenResult tokenResult = this.f89298d;
                        if (tokenResult != null ? tokenResult.equals(installationResponse.b()) : installationResponse.b() == null) {
                            InstallationResponse.ResponseCode responseCode = this.f89299e;
                            if (responseCode != null ? responseCode.equals(installationResponse.e()) : installationResponse.e() == null) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public String f() {
        return this.f89295a;
    }

    public int hashCode() {
        String str = this.f89295a;
        int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f89296b;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f89297c;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        TokenResult tokenResult = this.f89298d;
        int iHashCode4 = (iHashCode3 ^ (tokenResult == null ? 0 : tokenResult.hashCode())) * 1000003;
        InstallationResponse.ResponseCode responseCode = this.f89299e;
        return iHashCode4 ^ (responseCode != null ? responseCode.hashCode() : 0);
    }

    public String toString() {
        return "InstallationResponse{uri=" + this.f89295a + ", fid=" + this.f89296b + ", refreshToken=" + this.f89297c + ", authToken=" + this.f89298d + ", responseCode=" + this.f89299e + "}";
    }

    private AutoValue_InstallationResponse(String str, String str2, String str3, TokenResult tokenResult, InstallationResponse.ResponseCode responseCode) {
        this.f89295a = str;
        this.f89296b = str2;
        this.f89297c = str3;
        this.f89298d = tokenResult;
        this.f89299e = responseCode;
    }
}
