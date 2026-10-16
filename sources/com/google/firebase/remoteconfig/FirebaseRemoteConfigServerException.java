package com.google.firebase.remoteconfig;

import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class FirebaseRemoteConfigServerException extends FirebaseRemoteConfigException {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f89648b;

    public FirebaseRemoteConfigServerException(int i3, String str) {
        super(str);
        this.f89648b = i3;
    }

    public int a() {
        return this.f89648b;
    }

    public FirebaseRemoteConfigServerException(int i3, String str, Throwable th) {
        super(str, th);
        this.f89648b = i3;
    }

    public FirebaseRemoteConfigServerException(String str, FirebaseRemoteConfigException.Code code) {
        super(str, code);
        this.f89648b = -1;
    }

    public FirebaseRemoteConfigServerException(int i3, String str, FirebaseRemoteConfigException.Code code) {
        super(str, code);
        this.f89648b = i3;
    }
}
