package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public enum zzcae {
    GOAWAY("goaway"),
    SUBCHANNEL_SHUTDOWN("subchannel shutdown"),
    CONNECTION_RESET("connection reset"),
    CONNECTION_TIMED_OUT("connection timed out"),
    CONNECTION_ABORTED("connection aborted"),
    SOCKET_ERROR("socket error"),
    UNKNOWN("unknown");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f77325a;

    zzcae(String str) {
        this.f77325a = str;
    }

    public final String a(String str) {
        return this.f77325a;
    }
}
