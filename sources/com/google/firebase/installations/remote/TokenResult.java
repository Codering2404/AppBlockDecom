package com.google.firebase.installations.remote;

import com.google.firebase.installations.remote.AutoValue_TokenResult;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class TokenResult {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public abstract TokenResult a();

        public abstract Builder b(ResponseCode responseCode);

        public abstract Builder c(String str);

        public abstract Builder d(long j3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum ResponseCode {
        OK,
        BAD_CONFIG,
        AUTH_ERROR
    }

    public static Builder a() {
        return new AutoValue_TokenResult.Builder().d(0L);
    }

    public abstract ResponseCode b();

    public abstract String c();

    public abstract long d();
}
