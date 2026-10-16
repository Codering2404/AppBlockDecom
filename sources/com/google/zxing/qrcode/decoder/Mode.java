package com.google.zxing.qrcode.decoder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public enum Mode {
    TERMINATOR(new int[]{0, 0, 0}, 0),
    NUMERIC(new int[]{10, 12, 14}, 1),
    ALPHANUMERIC(new int[]{9, 11, 13}, 2),
    STRUCTURED_APPEND(new int[]{0, 0, 0}, 3),
    BYTE(new int[]{8, 16, 16}, 4),
    ECI(new int[]{0, 0, 0}, 7),
    KANJI(new int[]{8, 10, 12}, 8),
    FNC1_FIRST_POSITION(new int[]{0, 0, 0}, 5),
    FNC1_SECOND_POSITION(new int[]{0, 0, 0}, 9),
    HANZI(new int[]{8, 10, 12}, 13);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f92072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f92073b;

    Mode(int[] iArr, int i3) {
        this.f92072a = iArr;
        this.f92073b = i3;
    }

    public int a() {
        return this.f92073b;
    }

    public int b(Version version) {
        int iF = version.f();
        return this.f92072a[iF <= 9 ? (char) 0 : iF <= 26 ? (char) 1 : (char) 2];
    }
}
