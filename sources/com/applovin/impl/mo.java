package com.applovin.impl;

import com.applovin.impl.qo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class mo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f61916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f61917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final qo.a f61918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f61919d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f61920e;

    public mo(boolean z2, String str, int i3, byte[] bArr, int i4, int i5, byte[] bArr2) {
        b1.a((bArr2 == null) ^ (i3 == 0));
        this.f61916a = z2;
        this.f61917b = str;
        this.f61919d = i3;
        this.f61920e = bArr2;
        this.f61918c = new qo.a(a(str), bArr, i4, i5);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static int a(String str) {
        if (str == null) {
            return 1;
        }
        byte b3 = -1;
        switch (str.hashCode()) {
            case 3046605:
                if (str.equals("cbc1")) {
                    b3 = 0;
                }
                break;
            case 3046671:
                if (str.equals("cbcs")) {
                    b3 = 1;
                }
                break;
            case 3049879:
                if (str.equals("cenc")) {
                    b3 = 2;
                }
                break;
            case 3049895:
                if (str.equals("cens")) {
                    b3 = 3;
                }
                break;
        }
        switch (b3) {
            case 0:
            case 1:
                return 2;
            default:
                oc.d("TrackEncryptionBox", "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.");
            case 2:
            case 3:
                return 1;
        }
    }
}
