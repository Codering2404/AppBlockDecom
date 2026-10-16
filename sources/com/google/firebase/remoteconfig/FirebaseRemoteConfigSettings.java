package com.google.firebase.remoteconfig;

import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class FirebaseRemoteConfigSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f89649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f89650b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f89651a = 60;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f89652b = ConfigFetchHandler.f89713j;

        public FirebaseRemoteConfigSettings c() {
            return new FirebaseRemoteConfigSettings(this);
        }

        public Builder d(long j3) {
            if (j3 >= 0) {
                this.f89652b = j3;
                return this;
            }
            throw new IllegalArgumentException("Minimum interval between fetches has to be a non-negative number. " + j3 + " is an invalid argument");
        }
    }

    public long a() {
        return this.f89649a;
    }

    public long b() {
        return this.f89650b;
    }

    private FirebaseRemoteConfigSettings(Builder builder) {
        this.f89649a = builder.f89651a;
        this.f89650b = builder.f89652b;
    }
}
