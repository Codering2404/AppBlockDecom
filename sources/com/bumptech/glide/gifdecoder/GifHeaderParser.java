package com.bumptech.glide.gifdecoder;

import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class GifHeaderParser {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ByteBuffer f66196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private GifHeader f66197c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f66195a = new byte[Function.MAX_NARGS];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f66198d = 0;

    private boolean b() {
        return this.f66197c.f66183b != 0;
    }

    private int d() {
        try {
            return this.f66196b.get() & 255;
        } catch (Exception unused) {
            this.f66197c.f66183b = 1;
            return 0;
        }
    }

    private void e() {
        this.f66197c.f66185d.f66171a = n();
        this.f66197c.f66185d.f66172b = n();
        this.f66197c.f66185d.f66173c = n();
        this.f66197c.f66185d.f66174d = n();
        int iD = d();
        boolean z2 = (iD & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0;
        int iPow = (int) Math.pow(2.0d, (iD & 7) + 1);
        GifFrame gifFrame = this.f66197c.f66185d;
        gifFrame.f66175e = (iD & 64) != 0;
        if (z2) {
            gifFrame.f66181k = g(iPow);
        } else {
            gifFrame.f66181k = null;
        }
        this.f66197c.f66185d.f66180j = this.f66196b.position();
        r();
        if (b()) {
            return;
        }
        GifHeader gifHeader = this.f66197c;
        gifHeader.f66184c++;
        gifHeader.f66186e.add(gifHeader.f66185d);
    }

    private void f() {
        int iD = d();
        this.f66198d = iD;
        if (iD <= 0) {
            return;
        }
        int i3 = 0;
        int i4 = 0;
        while (true) {
            try {
                i4 = this.f66198d;
                if (i3 >= i4) {
                    return;
                }
                i4 -= i3;
                this.f66196b.get(this.f66195a, i3, i4);
                i3 += i4;
            } catch (Exception e3) {
                if (Log.isLoggable("GifHeaderParser", 3)) {
                    Log.d("GifHeaderParser", "Error Reading Block n: " + i3 + " count: " + i4 + " blockSize: " + this.f66198d, e3);
                }
                this.f66197c.f66183b = 1;
                return;
            }
        }
    }

    private int[] g(int i3) {
        byte[] bArr = new byte[i3 * 3];
        int[] iArr = null;
        try {
            this.f66196b.get(bArr);
            iArr = new int[Function.MAX_NARGS];
            int i4 = 0;
            int i5 = 0;
            while (i4 < i3) {
                int i6 = bArr[i5] & 255;
                int i7 = i5 + 2;
                int i8 = bArr[i5 + 1] & 255;
                i5 += 3;
                int i9 = i4 + 1;
                iArr[i4] = (i8 << 8) | (i6 << 16) | (-16777216) | (bArr[i7] & 255);
                i4 = i9;
            }
            return iArr;
        } catch (BufferUnderflowException e3) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e3);
            }
            this.f66197c.f66183b = 1;
            return iArr;
        }
    }

    private void h() {
        i(Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    private void i(int i3) {
        boolean z2 = false;
        while (!z2 && !b() && this.f66197c.f66184c <= i3) {
            int iD = d();
            if (iD == 33) {
                int iD2 = d();
                if (iD2 == 1) {
                    q();
                } else if (iD2 == 249) {
                    this.f66197c.f66185d = new GifFrame();
                    j();
                } else if (iD2 == 254) {
                    q();
                } else if (iD2 != 255) {
                    q();
                } else {
                    f();
                    StringBuilder sb = new StringBuilder();
                    for (int i4 = 0; i4 < 11; i4++) {
                        sb.append((char) this.f66195a[i4]);
                    }
                    if (sb.toString().equals("NETSCAPE2.0")) {
                        m();
                    } else {
                        q();
                    }
                }
            } else if (iD == 44) {
                GifHeader gifHeader = this.f66197c;
                if (gifHeader.f66185d == null) {
                    gifHeader.f66185d = new GifFrame();
                }
                e();
            } else if (iD != 59) {
                this.f66197c.f66183b = 1;
            } else {
                z2 = true;
            }
        }
    }

    private void j() {
        d();
        int iD = d();
        GifFrame gifFrame = this.f66197c.f66185d;
        int i3 = (iD & 28) >> 2;
        gifFrame.f66177g = i3;
        if (i3 == 0) {
            gifFrame.f66177g = 1;
        }
        gifFrame.f66176f = (iD & 1) != 0;
        int iN = n();
        if (iN < 2) {
            iN = 10;
        }
        GifFrame gifFrame2 = this.f66197c.f66185d;
        gifFrame2.f66179i = iN * 10;
        gifFrame2.f66178h = d();
        d();
    }

    private void k() {
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < 6; i3++) {
            sb.append((char) d());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.f66197c.f66183b = 1;
            return;
        }
        l();
        if (!this.f66197c.f66189h || b()) {
            return;
        }
        GifHeader gifHeader = this.f66197c;
        gifHeader.f66182a = g(gifHeader.f66190i);
        GifHeader gifHeader2 = this.f66197c;
        gifHeader2.f66193l = gifHeader2.f66182a[gifHeader2.f66191j];
    }

    private void l() {
        this.f66197c.f66187f = n();
        this.f66197c.f66188g = n();
        int iD = d();
        GifHeader gifHeader = this.f66197c;
        gifHeader.f66189h = (iD & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0;
        gifHeader.f66190i = (int) Math.pow(2.0d, (iD & 7) + 1);
        this.f66197c.f66191j = d();
        this.f66197c.f66192k = d();
    }

    private void m() {
        do {
            f();
            byte[] bArr = this.f66195a;
            if (bArr[0] == 1) {
                this.f66197c.f66194m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.f66198d <= 0) {
                return;
            }
        } while (!b());
    }

    private int n() {
        return this.f66196b.getShort();
    }

    private void o() {
        this.f66196b = null;
        Arrays.fill(this.f66195a, (byte) 0);
        this.f66197c = new GifHeader();
        this.f66198d = 0;
    }

    private void q() {
        int iD;
        do {
            iD = d();
            this.f66196b.position(Math.min(this.f66196b.position() + iD, this.f66196b.limit()));
        } while (iD > 0);
    }

    private void r() {
        d();
        q();
    }

    public void a() {
        this.f66196b = null;
        this.f66197c = null;
    }

    public GifHeader c() {
        if (this.f66196b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (b()) {
            return this.f66197c;
        }
        k();
        if (!b()) {
            h();
            GifHeader gifHeader = this.f66197c;
            if (gifHeader.f66184c < 0) {
                gifHeader.f66183b = 1;
            }
        }
        return this.f66197c;
    }

    public GifHeaderParser p(ByteBuffer byteBuffer) {
        o();
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f66196b = byteBufferAsReadOnlyBuffer;
        byteBufferAsReadOnlyBuffer.position(0);
        this.f66196b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }
}
