package com.google.zxing.pdf417.decoder.ec;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class ModulusGF {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ModulusGF f91996f = new ModulusGF(929, 3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f91997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f91998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ModulusPoly f91999c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ModulusPoly f92000d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f92001e;

    private ModulusGF(int i3, int i4) {
        this.f92001e = i3;
        this.f91997a = new int[i3];
        this.f91998b = new int[i3];
        int i5 = 1;
        for (int i6 = 0; i6 < i3; i6++) {
            this.f91997a[i6] = i5;
            i5 = (i5 * i4) % i3;
        }
        for (int i7 = 0; i7 < i3 - 1; i7++) {
            this.f91998b[this.f91997a[i7]] = i7;
        }
        this.f91999c = new ModulusPoly(this, new int[]{0});
        this.f92000d = new ModulusPoly(this, new int[]{1});
    }
}
