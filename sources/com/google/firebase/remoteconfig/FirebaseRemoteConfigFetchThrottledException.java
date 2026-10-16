package com.google.firebase.remoteconfig;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class FirebaseRemoteConfigFetchThrottledException extends FirebaseRemoteConfigException {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f89647b;

    public FirebaseRemoteConfigFetchThrottledException(long j3) {
        this("Fetch was throttled.", j3);
    }

    public FirebaseRemoteConfigFetchThrottledException(String str, long j3) {
        super(str);
        this.f89647b = j3;
    }
}
