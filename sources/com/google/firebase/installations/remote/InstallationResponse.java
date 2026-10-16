package com.google.firebase.installations.remote;

import com.google.firebase.installations.remote.AutoValue_InstallationResponse;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class InstallationResponse {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public abstract InstallationResponse a();

        public abstract Builder b(TokenResult tokenResult);

        public abstract Builder c(String str);

        public abstract Builder d(String str);

        public abstract Builder e(ResponseCode responseCode);

        public abstract Builder f(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum ResponseCode {
        OK,
        BAD_CONFIG
    }

    public static Builder a() {
        return new AutoValue_InstallationResponse.Builder();
    }

    public abstract TokenResult b();

    public abstract String c();

    public abstract String d();

    public abstract ResponseCode e();

    public abstract String f();
}
