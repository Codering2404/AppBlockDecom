package com.google.firebase.heartbeatinfo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public interface HeartBeatInfo {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum HeartBeat {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f89197a;

        HeartBeat(int i3) {
            this.f89197a = i3;
        }

        public int b() {
            return this.f89197a;
        }
    }

    HeartBeat b(String str);
}
