package com.google.firebase.heartbeatinfo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class SdkHeartBeatResult implements Comparable<SdkHeartBeatResult> {
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(SdkHeartBeatResult sdkHeartBeatResult) {
        return b() < sdkHeartBeatResult.b() ? -1 : 1;
    }

    public abstract long b();

    public abstract String c();
}
