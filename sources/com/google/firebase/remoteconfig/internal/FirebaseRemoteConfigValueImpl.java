package com.google.firebase.remoteconfig.internal;

import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class FirebaseRemoteConfigValueImpl implements FirebaseRemoteConfigValue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f89796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f89797b;

    FirebaseRemoteConfigValueImpl(String str, int i3) {
        this.f89796a = str;
        this.f89797b = i3;
    }

    private void b() {
        if (this.f89796a == null) {
            throw new IllegalArgumentException("Value is null, and cannot be converted to the desired type.");
        }
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
    public String a() {
        if (this.f89797b == 0) {
            return "";
        }
        b();
        return this.f89796a;
    }
}
