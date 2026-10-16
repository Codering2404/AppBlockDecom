package com.applovin.impl;

import com.applovin.impl.e9;
import com.applovin.impl.gl;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class sg extends gl {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final byte[] f63709o = {79, 112, 117, 115, 72, 101, 97, 100};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f63710n;

    sg() {
    }

    private long a(byte[] bArr) {
        int i3;
        byte b3 = bArr[0];
        int i4 = b3 & 255;
        int i5 = b3 & 3;
        if (i5 != 0) {
            i3 = 2;
            if (i5 != 1 && i5 != 2) {
                i3 = bArr[1] & 63;
            }
        } else {
            i3 = 1;
        }
        int i6 = i4 >> 3;
        int i7 = i6 & 3;
        return ((long) i3) * ((long) (i6 >= 16 ? 2500 << i7 : i6 >= 12 ? ColorExtractionConstants.MAX_PIXEL_SAMPLES << (i6 & 1) : i7 == 3 ? 60000 : ColorExtractionConstants.MAX_PIXEL_SAMPLES << i7));
    }

    public static boolean b(ah ahVar) {
        int iA = ahVar.a();
        byte[] bArr = f63709o;
        if (iA < bArr.length) {
            return false;
        }
        byte[] bArr2 = new byte[bArr.length];
        ahVar.a(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // com.applovin.impl.gl
    protected long a(ah ahVar) {
        return b(a(ahVar.c()));
    }

    @Override // com.applovin.impl.gl
    protected boolean a(ah ahVar, long j3, gl.b bVar) {
        if (!this.f63710n) {
            byte[] bArrCopyOf = Arrays.copyOf(ahVar.c(), ahVar.e());
            bVar.f60010a = new e9.b().f("audio/opus").c(tg.b(bArrCopyOf)).n(48000).a(tg.a(bArrCopyOf)).a();
            this.f63710n = true;
            return true;
        }
        b1.a(bVar.f60010a);
        boolean z2 = ahVar.j() == 1332770163;
        ahVar.f(0);
        return z2;
    }

    @Override // com.applovin.impl.gl
    protected void a(boolean z2) {
        super.a(z2);
        if (z2) {
            this.f63710n = false;
        }
    }
}
