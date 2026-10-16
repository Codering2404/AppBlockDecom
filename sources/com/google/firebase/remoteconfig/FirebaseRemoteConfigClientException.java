package com.google.firebase.remoteconfig;

import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class FirebaseRemoteConfigClientException extends FirebaseRemoteConfigException {
    public FirebaseRemoteConfigClientException(String str) {
        super(str);
    }

    public FirebaseRemoteConfigClientException(String str, Throwable th) {
        super(str, th);
    }

    public FirebaseRemoteConfigClientException(String str, FirebaseRemoteConfigException.Code code) {
        super(str, code);
    }

    public FirebaseRemoteConfigClientException(String str, Throwable th, FirebaseRemoteConfigException.Code code) {
        super(str, th, code);
    }
}
