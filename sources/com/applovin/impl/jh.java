package com.applovin.impl;

import android.graphics.Bitmap;
import com.applovin.impl.a5;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class jh extends ek {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ah f60745o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final ah f60746p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final a f60747q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Inflater f60748r;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ah f60749a = new ah();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int[] f60750b = new int[Function.MAX_NARGS];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f60751c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f60752d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f60753e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f60754f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f60755g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f60756h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f60757i;

        /* JADX INFO: Access modifiers changed from: private */
        public void b(ah ahVar, int i3) {
            if (i3 < 19) {
                return;
            }
            this.f60752d = ahVar.C();
            this.f60753e = ahVar.C();
            ahVar.g(11);
            this.f60754f = ahVar.C();
            this.f60755g = ahVar.C();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(ah ahVar, int i3) {
            if (i3 % 5 != 2) {
                return;
            }
            ahVar.g(2);
            Arrays.fill(this.f60750b, 0);
            int i4 = i3 / 5;
            for (int i5 = 0; i5 < i4; i5++) {
                int iW = ahVar.w();
                int iW2 = ahVar.w();
                int iW3 = ahVar.w();
                int iW4 = ahVar.w();
                double d3 = iW2;
                double d4 = iW3 - 128;
                double d5 = iW4 - 128;
                this.f60750b[iW] = (xp.a((int) ((d3 - (0.34414d * d5)) - (d4 * 0.71414d)), 0, 255) << 8) | (ahVar.w() << 24) | (xp.a((int) ((1.402d * d4) + d3), 0, 255) << 16) | xp.a((int) (d3 + (d5 * 1.772d)), 0, 255);
            }
            this.f60751c = true;
        }

        public a5 a() {
            int iW;
            if (this.f60752d == 0 || this.f60753e == 0 || this.f60756h == 0 || this.f60757i == 0 || this.f60749a.e() == 0 || this.f60749a.d() != this.f60749a.e() || !this.f60751c) {
                return null;
            }
            this.f60749a.f(0);
            int i3 = this.f60756h * this.f60757i;
            int[] iArr = new int[i3];
            int i4 = 0;
            while (i4 < i3) {
                int iW2 = this.f60749a.w();
                if (iW2 != 0) {
                    iW = i4 + 1;
                    iArr[i4] = this.f60750b[iW2];
                } else {
                    int iW3 = this.f60749a.w();
                    if (iW3 != 0) {
                        iW = ((iW3 & 64) == 0 ? iW3 & 63 : ((iW3 & 63) << 8) | this.f60749a.w()) + i4;
                        Arrays.fill(iArr, i4, iW, (iW3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0 ? 0 : this.f60750b[this.f60749a.w()]);
                    }
                }
                i4 = iW;
            }
            return new a5.b().a(Bitmap.createBitmap(iArr, this.f60756h, this.f60757i, Bitmap.Config.ARGB_8888)).b(this.f60754f / this.f60752d).b(0).a(this.f60755g / this.f60753e, 0).a(0).d(this.f60756h / this.f60752d).a(this.f60757i / this.f60753e).a();
        }

        public void b() {
            this.f60752d = 0;
            this.f60753e = 0;
            this.f60754f = 0;
            this.f60755g = 0;
            this.f60756h = 0;
            this.f60757i = 0;
            this.f60749a.d(0);
            this.f60751c = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ah ahVar, int i3) {
            int iZ;
            if (i3 < 4) {
                return;
            }
            ahVar.g(3);
            int i4 = i3 - 4;
            if ((ahVar.w() & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
                if (i4 < 7 || (iZ = ahVar.z()) < 4) {
                    return;
                }
                this.f60756h = ahVar.C();
                this.f60757i = ahVar.C();
                this.f60749a.d(iZ - 4);
                i4 = i3 - 11;
            }
            int iD = this.f60749a.d();
            int iE = this.f60749a.e();
            if (iD >= iE || i4 <= 0) {
                return;
            }
            int iMin = Math.min(i4, iE - iD);
            ahVar.a(this.f60749a.c(), iD, iMin);
            this.f60749a.f(iD + iMin);
        }
    }

    public jh() {
        super("PgsDecoder");
        this.f60745o = new ah();
        this.f60746p = new ah();
        this.f60747q = new a();
    }

    @Override // com.applovin.impl.ek
    protected nl a(byte[] bArr, int i3, boolean z2) {
        this.f60745o.a(bArr, i3);
        a(this.f60745o);
        this.f60747q.b();
        ArrayList arrayList = new ArrayList();
        while (this.f60745o.a() >= 3) {
            a5 a5VarA = a(this.f60745o, this.f60747q);
            if (a5VarA != null) {
                arrayList.add(a5VarA);
            }
        }
        return new kh(Collections.unmodifiableList(arrayList));
    }

    private void a(ah ahVar) {
        if (ahVar.a() <= 0 || ahVar.g() != 120) {
            return;
        }
        if (this.f60748r == null) {
            this.f60748r = new Inflater();
        }
        if (xp.a(ahVar, this.f60746p, this.f60748r)) {
            ahVar.a(this.f60746p.c(), this.f60746p.e());
        }
    }

    private static a5 a(ah ahVar, a aVar) {
        int iE = ahVar.e();
        int iW = ahVar.w();
        int iC = ahVar.C();
        int iD = ahVar.d() + iC;
        a5 a5VarA = null;
        if (iD > iE) {
            ahVar.f(iE);
            return null;
        }
        if (iW != 128) {
            switch (iW) {
                case 20:
                    aVar.c(ahVar, iC);
                    break;
                case 21:
                    aVar.a(ahVar, iC);
                    break;
                case 22:
                    aVar.b(ahVar, iC);
                    break;
            }
        } else {
            a5VarA = aVar.a();
            aVar.b();
        }
        ahVar.f(iD);
        return a5VarA;
    }
}
