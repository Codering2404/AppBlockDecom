package com.facebook.ads.redexgen.core;

import android.net.Uri;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class AF implements InterfaceC2144pF {
    public static String[] A04 = {"wbGAhFLyG1O1BXRQkdAsuvRwjcG0JvdY", "WIGHUXkmdMwjKtYrGQHAEajnCcLVhsJc", "71g9TI5vzncmEyYDsqHRZQ5IIDSVhuCU", "Of7gEliA8dohBLU5UePsnNPr9luYUKIX", "Ip7oB5coOYYSe2wQ3nHh7WYhGK", "mFyxGR7YA7Uh54mquru9LT9AFg", "iYrL5ZFnNwboLBDSkDK7D5rnh7HwI2GN", "DEMvAgZEfGNSxO1Scy7Mz579azioI4xU"};
    public long A00;
    public boolean A01;
    public final C5W A02;
    public final InterfaceC2144pF A03;

    public AF(InterfaceC2144pF interfaceC2144pF, C5W c5w) {
        this.A03 = (InterfaceC2144pF) AbstractC04323y.A01(interfaceC2144pF);
        this.A02 = (C5W) AbstractC04323y.A01(c5w);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2144pF
    public final void A43(InterfaceC04795t interfaceC04795t) {
        AbstractC04323y.A01(interfaceC04795t);
        this.A03.A43(interfaceC04795t);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2144pF
    public final Map<String, List<String>> A8t() {
        return this.A03.A8t();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2144pF
    public final Uri A9P() {
        return this.A03.A9P();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2144pF
    public final long AGi(C04685i c04685i) throws IOException {
        this.A00 = this.A03.AGi(c04685i);
        if (this.A00 == 0) {
            return 0L;
        }
        long j3 = c04685i.A03;
        String[] strArr = A04;
        if (strArr[4].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[2] = "8JYiy7Q3QOgUU9IJtNo1oEeVZYLkhQA2";
        strArr2[1] = "C3hXJiAszWGMEEgz1C8EzdfpsF4hhGij";
        if (j3 == -1 && this.A00 != -1) {
            c04685i = c04685i.A05(0L, this.A00);
        }
        this.A01 = true;
        this.A02.AGk(c04685i);
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2144pF
    public final void close() throws IOException {
        try {
            this.A03.close();
        } finally {
            if (this.A01) {
                this.A01 = false;
                this.A02.close();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC03882c
    public final int read(byte[] bArr, int i3, int i4) throws IOException {
        if (this.A00 != 0) {
            int i5 = this.A03.read(bArr, i3, i4);
            if (i5 > 0) {
                this.A02.write(bArr, i3, i5);
                if (this.A00 != -1) {
                    this.A00 -= (long) i5;
                }
            }
            return i5;
        }
        String[] strArr = A04;
        if (strArr[4].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[0] = "tTmOA5hODgmGBNxF0mS11dvWTNwifcB6";
        strArr2[3] = "mpSZqupnUd3dBB1VIyplsxMvqiIWybTS";
        return -1;
    }
}
