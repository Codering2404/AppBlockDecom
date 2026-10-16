package com.google.android.gms.fido.fido2.api.common;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public enum EC2Algorithm implements Algorithm {
    ED256(-260),
    ED512(-261),
    ED25519(-8),
    ES256(-7),
    ECDH_HKDF_256(-25),
    ES384(-35),
    ES512(-36);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f72510a;

    EC2Algorithm(int i3) {
        this.f72510a = i3;
    }

    @Override // com.google.android.gms.fido.fido2.api.common.Algorithm
    public int a() {
        return this.f72510a;
    }
}
