package com.google.zxing.datamatrix.encoder;

import com.google.zxing.Dimension;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class SymbolInfo {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final SymbolInfo[] f91887i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static SymbolInfo[] f91888j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f91889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f91890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f91891c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f91892d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f91893e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f91894f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f91895g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f91896h;

    static {
        SymbolInfo[] symbolInfoArr = {new SymbolInfo(false, 3, 5, 8, 8, 1), new SymbolInfo(false, 5, 7, 10, 10, 1), new SymbolInfo(true, 5, 7, 16, 6, 1), new SymbolInfo(false, 8, 10, 12, 12, 1), new SymbolInfo(true, 10, 11, 14, 6, 2), new SymbolInfo(false, 12, 12, 14, 14, 1), new SymbolInfo(true, 16, 14, 24, 10, 1), new SymbolInfo(false, 18, 14, 16, 16, 1), new SymbolInfo(false, 22, 18, 18, 18, 1), new SymbolInfo(true, 22, 18, 16, 10, 2), new SymbolInfo(false, 30, 20, 20, 20, 1), new SymbolInfo(true, 32, 24, 16, 14, 2), new SymbolInfo(false, 36, 24, 22, 22, 1), new SymbolInfo(false, 44, 28, 24, 24, 1), new SymbolInfo(true, 49, 28, 22, 14, 2), new SymbolInfo(false, 62, 36, 14, 14, 4), new SymbolInfo(false, 86, 42, 16, 16, 4), new SymbolInfo(false, 114, 48, 18, 18, 4), new SymbolInfo(false, 144, 56, 20, 20, 4), new SymbolInfo(false, 174, 68, 22, 22, 4), new SymbolInfo(false, 204, 84, 24, 24, 4, 102, 42), new SymbolInfo(false, 280, 112, 14, 14, 16, 140, 56), new SymbolInfo(false, 368, 144, 16, 16, 16, 92, 36), new SymbolInfo(false, 456, 192, 18, 18, 16, 114, 48), new SymbolInfo(false, 576, 224, 20, 20, 16, 144, 56), new SymbolInfo(false, 696, 272, 22, 22, 16, 174, 68), new SymbolInfo(false, 816, 336, 24, 24, 16, 136, 56), new SymbolInfo(false, 1050, 408, 18, 18, 36, 175, 68), new SymbolInfo(false, 1304, 496, 20, 20, 36, 163, 62), new DataMatrixSymbolInfo144()};
        f91887i = symbolInfoArr;
        f91888j = symbolInfoArr;
    }

    public SymbolInfo(boolean z2, int i3, int i4, int i5, int i6, int i7) {
        this(z2, i3, i4, i5, i6, i7, i3, i4);
    }

    private int e() {
        int i3 = this.f91894f;
        int i4 = 1;
        if (i3 != 1) {
            i4 = 2;
            if (i3 != 2 && i3 != 4) {
                if (i3 == 16) {
                    return 4;
                }
                if (i3 == 36) {
                    return 6;
                }
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
        }
        return i4;
    }

    private int k() {
        int i3 = this.f91894f;
        if (i3 == 1 || i3 == 2) {
            return 1;
        }
        if (i3 == 4) {
            return 2;
        }
        if (i3 == 16) {
            return 4;
        }
        if (i3 == 36) {
            return 6;
        }
        throw new IllegalStateException("Cannot handle this number of data regions");
    }

    public static SymbolInfo l(int i3, SymbolShapeHint symbolShapeHint, Dimension dimension, Dimension dimension2, boolean z2) {
        for (SymbolInfo symbolInfo : f91888j) {
            if (!(symbolShapeHint == SymbolShapeHint.FORCE_SQUARE && symbolInfo.f91889a) && ((symbolShapeHint != SymbolShapeHint.FORCE_RECTANGLE || symbolInfo.f91889a) && ((dimension == null || (symbolInfo.j() >= dimension.b() && symbolInfo.i() >= dimension.a())) && ((dimension2 == null || (symbolInfo.j() <= dimension2.b() && symbolInfo.i() <= dimension2.a())) && i3 <= symbolInfo.f91890b)))) {
                return symbolInfo;
            }
        }
        if (z2) {
            throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: ".concat(String.valueOf(i3)));
        }
        return null;
    }

    public final int a() {
        return this.f91890b;
    }

    public int b(int i3) {
        return this.f91895g;
    }

    public final int c() {
        return this.f91891c;
    }

    public final int d(int i3) {
        return this.f91896h;
    }

    public int f() {
        return this.f91890b / this.f91895g;
    }

    public final int g() {
        return k() * this.f91893e;
    }

    public final int h() {
        return e() * this.f91892d;
    }

    public final int i() {
        return g() + (k() << 1);
    }

    public final int j() {
        return h() + (e() << 1);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f91889a ? "Rectangular Symbol:" : "Square Symbol:");
        sb.append(" data region ");
        sb.append(this.f91892d);
        sb.append('x');
        sb.append(this.f91893e);
        sb.append(", symbol size ");
        sb.append(j());
        sb.append('x');
        sb.append(i());
        sb.append(", symbol data size ");
        sb.append(h());
        sb.append('x');
        sb.append(g());
        sb.append(", codewords ");
        sb.append(this.f91890b);
        sb.append('+');
        sb.append(this.f91891c);
        return sb.toString();
    }

    SymbolInfo(boolean z2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.f91889a = z2;
        this.f91890b = i3;
        this.f91891c = i4;
        this.f91892d = i5;
        this.f91893e = i6;
        this.f91894f = i7;
        this.f91895g = i8;
        this.f91896h = i9;
    }
}
