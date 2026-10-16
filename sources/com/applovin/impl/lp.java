package com.applovin.impl;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.exoplayer2.common.base.Charsets;
import com.applovin.impl.a5;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class lp extends ek {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ah f61260o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f61261p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final int f61262q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final int f61263r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final String f61264s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final float f61265t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final int f61266u;

    public lp(List list) {
        super("Tx3gDecoder");
        this.f61260o = new ah();
        if (list.size() != 1 || (((byte[]) list.get(0)).length != 48 && ((byte[]) list.get(0)).length != 53)) {
            this.f61262q = 0;
            this.f61263r = -1;
            this.f61264s = "sans-serif";
            this.f61261p = false;
            this.f61265t = 0.85f;
            this.f61266u = -1;
            return;
        }
        byte[] bArr = (byte[]) list.get(0);
        this.f61262q = bArr[24];
        this.f61263r = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
        this.f61264s = "Serif".equals(xp.a(bArr, 43, bArr.length - 43)) ? "serif" : "sans-serif";
        int i3 = bArr[25] * Ascii.DC4;
        this.f61266u = i3;
        boolean z2 = (bArr[0] & 32) != 0;
        this.f61261p = z2;
        if (z2) {
            this.f61265t = xp.a(((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i3, 0.0f, 0.95f);
        } else {
            this.f61265t = 0.85f;
        }
    }

    private void a(ah ahVar, SpannableStringBuilder spannableStringBuilder) throws pl {
        a(ahVar.a() >= 12);
        int iC = ahVar.C();
        int iC2 = ahVar.C();
        ahVar.g(2);
        int iW = ahVar.w();
        ahVar.g(1);
        int iJ = ahVar.j();
        if (iC2 > spannableStringBuilder.length()) {
            oc.d("Tx3gDecoder", "Truncating styl end (" + iC2 + ") to cueText.length() (" + spannableStringBuilder.length() + ").");
            iC2 = spannableStringBuilder.length();
        }
        int i3 = iC2;
        if (iC < i3) {
            b(spannableStringBuilder, iW, this.f61262q, iC, i3, 0);
            a(spannableStringBuilder, iJ, this.f61263r, iC, i3, 0);
            return;
        }
        oc.d("Tx3gDecoder", "Ignoring styl with start (" + iC + ") >= end (" + i3 + ").");
    }

    private static void b(SpannableStringBuilder spannableStringBuilder, int i3, int i4, int i5, int i6, int i7) {
        if (i3 != i4) {
            int i8 = i7 | 33;
            boolean z2 = (i3 & 1) != 0;
            boolean z3 = (i3 & 2) != 0;
            if (z2) {
                if (z3) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i5, i6, i8);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i5, i6, i8);
                }
            } else if (z3) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i5, i6, i8);
            }
            boolean z4 = (i3 & 4) != 0;
            if (z4) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i5, i6, i8);
            }
            if (z4 || z2 || z3) {
                return;
            }
            spannableStringBuilder.setSpan(new StyleSpan(0), i5, i6, i8);
        }
    }

    private static void a(boolean z2) throws pl {
        if (!z2) {
            throw new pl("Unexpected subtitle format.");
        }
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, int i3, int i4, int i5, int i6, int i7) {
        if (i3 != i4) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i3 >>> 8) | ((i3 & 255) << 24)), i5, i6, i7 | 33);
        }
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, String str, int i3, int i4) {
        if (str != "sans-serif") {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), i3, i4, 16711713);
        }
    }

    @Override // com.applovin.impl.ek
    protected nl a(byte[] bArr, int i3, boolean z2) throws pl {
        this.f61260o.a(bArr, i3);
        String strA = a(this.f61260o);
        if (strA.isEmpty()) {
            return mp.f61921b;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strA);
        b(spannableStringBuilder, this.f61262q, 0, 0, spannableStringBuilder.length(), 16711680);
        a(spannableStringBuilder, this.f61263r, -1, 0, spannableStringBuilder.length(), 16711680);
        a(spannableStringBuilder, this.f61264s, 0, spannableStringBuilder.length());
        float fA = this.f61265t;
        while (this.f61260o.a() >= 8) {
            int iD = this.f61260o.d();
            int iJ = this.f61260o.j();
            int iJ2 = this.f61260o.j();
            if (iJ2 == 1937013100) {
                a(this.f61260o.a() >= 2);
                int iC = this.f61260o.C();
                for (int i4 = 0; i4 < iC; i4++) {
                    a(this.f61260o, spannableStringBuilder);
                }
            } else if (iJ2 == 1952608120 && this.f61261p) {
                a(this.f61260o.a() >= 2);
                fA = xp.a(this.f61260o.C() / this.f61266u, 0.0f, 0.95f);
            }
            this.f61260o.f(iD + iJ);
        }
        return new mp(new a5.b().a(spannableStringBuilder).a(fA, 0).a(0).a());
    }

    private static String a(ah ahVar) throws pl {
        char cF;
        a(ahVar.a() >= 2);
        int iC = ahVar.C();
        if (iC == 0) {
            return "";
        }
        if (ahVar.a() >= 2 && ((cF = ahVar.f()) == 65279 || cF == 65534)) {
            return ahVar.a(iC, Charsets.UTF_16);
        }
        return ahVar.a(iC, Charsets.UTF_8);
    }
}
