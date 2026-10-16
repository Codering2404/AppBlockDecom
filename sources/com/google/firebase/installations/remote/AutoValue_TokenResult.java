package com.google.firebase.installations.remote;

import com.google.firebase.installations.remote.TokenResult;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_TokenResult extends TokenResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f89305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f89306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TokenResult.ResponseCode f89307c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends TokenResult.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f89308a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f89309b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private TokenResult.ResponseCode f89310c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private byte f89311d;

        Builder() {
        }

        @Override // com.google.firebase.installations.remote.TokenResult.Builder
        public TokenResult a() {
            if (this.f89311d == 1) {
                return new AutoValue_TokenResult(this.f89308a, this.f89309b, this.f89310c);
            }
            throw new IllegalStateException("Missing required properties: tokenExpirationTimestamp");
        }

        @Override // com.google.firebase.installations.remote.TokenResult.Builder
        public TokenResult.Builder b(TokenResult.ResponseCode responseCode) {
            this.f89310c = responseCode;
            return this;
        }

        @Override // com.google.firebase.installations.remote.TokenResult.Builder
        public TokenResult.Builder c(String str) {
            this.f89308a = str;
            return this;
        }

        @Override // com.google.firebase.installations.remote.TokenResult.Builder
        public TokenResult.Builder d(long j3) {
            this.f89309b = j3;
            this.f89311d = (byte) (this.f89311d | 1);
            return this;
        }
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public TokenResult.ResponseCode b() {
        return this.f89307c;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public String c() {
        return this.f89305a;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public long d() {
        return this.f89306b;
    }

    public boolean equals(Object obj) {
        TokenResult.ResponseCode responseCode;
        if (obj == this) {
            return true;
        }
        if (obj instanceof TokenResult) {
            TokenResult tokenResult = (TokenResult) obj;
            String str = this.f89305a;
            if (str != null ? str.equals(tokenResult.c()) : tokenResult.c() == null) {
                if (this.f89306b == tokenResult.d() && ((responseCode = this.f89307c) != null ? responseCode.equals(tokenResult.b()) : tokenResult.b() == null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f89305a;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j3 = this.f89306b;
        int i3 = (((iHashCode ^ 1000003) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003;
        TokenResult.ResponseCode responseCode = this.f89307c;
        return i3 ^ (responseCode != null ? responseCode.hashCode() : 0);
    }

    public String toString() {
        return "TokenResult{token=" + this.f89305a + ", tokenExpirationTimestamp=" + this.f89306b + ", responseCode=" + this.f89307c + "}";
    }

    private AutoValue_TokenResult(String str, long j3, TokenResult.ResponseCode responseCode) {
        this.f89305a = str;
        this.f89306b = j3;
        this.f89307c = responseCode;
    }
}
