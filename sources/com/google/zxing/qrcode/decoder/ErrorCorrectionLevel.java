package com.google.zxing.qrcode.decoder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public enum ErrorCorrectionLevel {
    L(1),
    M(0),
    Q(3),
    H(2);


    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ErrorCorrectionLevel[] f92055g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f92057a;

    static {
        ErrorCorrectionLevel errorCorrectionLevel = L;
        ErrorCorrectionLevel errorCorrectionLevel2 = M;
        ErrorCorrectionLevel errorCorrectionLevel3 = Q;
        f92055g = new ErrorCorrectionLevel[]{errorCorrectionLevel2, errorCorrectionLevel, H, errorCorrectionLevel3};
    }

    ErrorCorrectionLevel(int i3) {
        this.f92057a = i3;
    }

    public int a() {
        return this.f92057a;
    }
}
