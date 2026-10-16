package com.google.zxing.qrcode.encoder;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
import cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class QRCode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Mode f92099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ErrorCorrectionLevel f92100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Version f92101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f92102d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ByteMatrix f92103e;

    public static boolean b(int i3) {
        return i3 >= 0 && i3 < 8;
    }

    public ByteMatrix a() {
        return this.f92103e;
    }

    public void c(ErrorCorrectionLevel errorCorrectionLevel) {
        this.f92100b = errorCorrectionLevel;
    }

    public void d(int i3) {
        this.f92102d = i3;
    }

    public void e(ByteMatrix byteMatrix) {
        this.f92103e = byteMatrix;
    }

    public void f(Mode mode) {
        this.f92099a = mode;
    }

    public void g(Version version) {
        this.f92101c = version;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.f92099a);
        sb.append("\n ecLevel: ");
        sb.append(this.f92100b);
        sb.append("\n version: ");
        sb.append(this.f92101c);
        sb.append("\n maskPattern: ");
        sb.append(this.f92102d);
        if (this.f92103e == null) {
            sb.append("\n matrix: null\n");
        } else {
            sb.append("\n matrix:\n");
            sb.append(this.f92103e);
        }
        sb.append(MrGIhy.IeibKwYCkGDb);
        return sb.toString();
    }
}
