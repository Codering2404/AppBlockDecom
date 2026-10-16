package com.google.firebase.installations;

import com.google.firebase.installations.AutoValue_InstallationTokenResult;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class InstallationTokenResult {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public abstract InstallationTokenResult a();

        public abstract Builder b(String str);

        public abstract Builder c(long j3);

        public abstract Builder d(long j3);
    }

    public static Builder a() {
        return new AutoValue_InstallationTokenResult.Builder();
    }

    public abstract String b();

    public abstract long c();

    public abstract long d();
}
