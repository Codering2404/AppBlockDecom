package com.google.android.gms.fido.fido2.api.common;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public enum RSAAlgorithm implements Algorithm {
    RS256(-257),
    RS384(-258),
    RS512(-259),
    LEGACY_RS1(-262),
    PS256(-37),
    PS384(-38),
    PS512(-39),
    RS1(-65535);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f72614a;

    RSAAlgorithm(int i3) {
        this.f72614a = i3;
    }

    @Override // com.google.android.gms.fido.fido2.api.common.Algorithm
    public int a() {
        return this.f72614a;
    }
}
