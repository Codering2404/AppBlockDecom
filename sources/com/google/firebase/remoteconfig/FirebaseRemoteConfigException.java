package com.google.firebase.remoteconfig;

import com.google.firebase.FirebaseException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class FirebaseRemoteConfigException extends FirebaseException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Code f89639a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Code {
        UNKNOWN(0),
        CONFIG_UPDATE_STREAM_ERROR(1),
        CONFIG_UPDATE_MESSAGE_INVALID(2),
        CONFIG_UPDATE_NOT_FETCHED(3),
        CONFIG_UPDATE_UNAVAILABLE(4);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f89646a;

        Code(int i3) {
            this.f89646a = i3;
        }
    }

    public FirebaseRemoteConfigException(String str) {
        super(str);
        this.f89639a = Code.UNKNOWN;
    }

    public FirebaseRemoteConfigException(String str, Throwable th) {
        super(str, th);
        this.f89639a = Code.UNKNOWN;
    }

    public FirebaseRemoteConfigException(String str, Code code) {
        super(str);
        this.f89639a = code;
    }

    public FirebaseRemoteConfigException(String str, Throwable th, Code code) {
        super(str, th);
        this.f89639a = code;
    }
}
