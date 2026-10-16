package com.google.zxing.datamatrix.encoder;

import com.google.zxing.Dimension;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class EncoderContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f91874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SymbolShapeHint f91875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Dimension f91876c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Dimension f91877d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final StringBuilder f91878e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f91879f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f91880g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private SymbolInfo f91881h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f91882i;

    EncoderContext(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder sb = new StringBuilder(bytes.length);
        int length = bytes.length;
        for (int i3 = 0; i3 < length; i3++) {
            char c3 = (char) (bytes[i3] & 255);
            if (c3 == '?' && str.charAt(i3) != '?') {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
            sb.append(c3);
        }
        this.f91874a = sb.toString();
        this.f91875b = SymbolShapeHint.FORCE_NONE;
        this.f91878e = new StringBuilder(str.length());
        this.f91880g = -1;
    }

    private int h() {
        return this.f91874a.length() - this.f91882i;
    }

    public int a() {
        return this.f91878e.length();
    }

    public StringBuilder b() {
        return this.f91878e;
    }

    public char c() {
        return this.f91874a.charAt(this.f91879f);
    }

    public String d() {
        return this.f91874a;
    }

    public int e() {
        return this.f91880g;
    }

    public int f() {
        return h() - this.f91879f;
    }

    public SymbolInfo g() {
        return this.f91881h;
    }

    public boolean i() {
        return this.f91879f < h();
    }

    public void j() {
        this.f91880g = -1;
    }

    public void k() {
        this.f91881h = null;
    }

    public void l(Dimension dimension, Dimension dimension2) {
        this.f91876c = dimension;
        this.f91877d = dimension2;
    }

    public void m(int i3) {
        this.f91882i = i3;
    }

    public void n(SymbolShapeHint symbolShapeHint) {
        this.f91875b = symbolShapeHint;
    }

    public void o(int i3) {
        this.f91880g = i3;
    }

    public void p() {
        q(a());
    }

    public void q(int i3) {
        SymbolInfo symbolInfo = this.f91881h;
        if (symbolInfo == null || i3 > symbolInfo.a()) {
            this.f91881h = SymbolInfo.l(i3, this.f91875b, this.f91876c, this.f91877d, true);
        }
    }

    public void r(char c3) {
        this.f91878e.append(c3);
    }

    public void s(String str) {
        this.f91878e.append(str);
    }
}
