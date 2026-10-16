package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ex, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0698Ex {
    public static String[] A05 = {"LpJTwMN2G", "VgMO4aUKUhad1vQS8qeWccWG6TZwybQB", "ACcLkDhyx", "Vz4L8Yk2qa8xi00BpA99exXw347yn2OW", "M93qmyVYUpuFuHp", "Ixo", "WCFkueysi57ip8GEP7BFiSRGMX4T5ofH", "LFY6A3GYQmBEHARGrOHSwwc2jPi1aXj0"};
    public final int A00;
    public final C2163pY A01;
    public final Object A02;
    public final C05307s[] A03;
    public final InterfaceC2020nE[] A04;

    public C0698Ex(C05307s[] c05307sArr, InterfaceC2020nE[] interfaceC2020nEArr, C2163pY c2163pY, Object obj) {
        this.A03 = c05307sArr;
        this.A04 = (InterfaceC2020nE[]) interfaceC2020nEArr.clone();
        this.A01 = c2163pY;
        this.A02 = obj;
        this.A00 = c05307sArr.length;
    }

    public final boolean A00(int i3) {
        return this.A03[i3] != null;
    }

    public final boolean A01(C0698Ex c0698Ex, int i3) {
        if (c0698Ex == null) {
            return false;
        }
        C05307s[] c05307sArr = this.A03;
        if (A05[5].length() == 3) {
            A05[1] = "2a41zxf8OUQisEdMYeAN8aC4JNcLEgEy";
            if (!C5C.A1E(c05307sArr[i3], c0698Ex.A03[i3])) {
                return false;
            }
            InterfaceC2020nE interfaceC2020nE = this.A04[i3];
            InterfaceC2020nE interfaceC2020nE2 = c0698Ex.A04[i3];
            String[] strArr = A05;
            if (strArr[2].length() == strArr[0].length()) {
                A05[4] = "ShAZgc6gkhlm9OR";
                return C5C.A1E(interfaceC2020nE, interfaceC2020nE2);
            }
        }
        throw new RuntimeException();
    }
}
