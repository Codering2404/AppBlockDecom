package com.google.firebase.heartbeatinfo;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_HeartBeatResult extends HeartBeatResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f89183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f89184b;

    AutoValue_HeartBeatResult(String str, List list) {
        if (str == null) {
            throw new NullPointerException("Null userAgent");
        }
        this.f89183a = str;
        if (list == null) {
            throw new NullPointerException("Null usedDates");
        }
        this.f89184b = list;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatResult
    public List b() {
        return this.f89184b;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatResult
    public String c() {
        return this.f89183a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof HeartBeatResult) {
            HeartBeatResult heartBeatResult = (HeartBeatResult) obj;
            if (this.f89183a.equals(heartBeatResult.c()) && this.f89184b.equals(heartBeatResult.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f89183a.hashCode() ^ 1000003) * 1000003) ^ this.f89184b.hashCode();
    }

    public String toString() {
        return "HeartBeatResult{userAgent=" + this.f89183a + ", usedDates=" + this.f89184b + "}";
    }
}
