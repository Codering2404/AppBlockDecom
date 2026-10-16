package androidx.media3.extractor.text.tx3g;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.SubtitleParser;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.common.cache.LSNn.vfptEEmYY;
import com.google.common.collect.ImmutableList;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
public final class Tx3gParser implements SubtitleParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ParsableByteArray f47254a = new ParsableByteArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f47255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f47256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f47257d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f47258e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f47259f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f47260g;

    public Tx3gParser(List list) {
        if (list.size() != 1 || (((byte[]) list.get(0)).length != 48 && ((byte[]) list.get(0)).length != 53)) {
            this.f47256c = 0;
            this.f47257d = -1;
            this.f47258e = "sans-serif";
            this.f47255b = false;
            this.f47259f = 0.85f;
            this.f47260g = -1;
            return;
        }
        byte[] bArr = (byte[]) list.get(0);
        this.f47256c = bArr[24];
        this.f47257d = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
        this.f47258e = "Serif".equals(Util.L(bArr, 43, bArr.length - 43)) ? "serif" : "sans-serif";
        int i3 = bArr[25] * Ascii.DC4;
        this.f47260g = i3;
        boolean z2 = (bArr[0] & 32) != 0;
        this.f47255b = z2;
        if (z2) {
            this.f47259f = Util.q(((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i3, 0.0f, 0.95f);
        } else {
            this.f47259f = 0.85f;
        }
    }

    private void d(ParsableByteArray parsableByteArray, SpannableStringBuilder spannableStringBuilder) {
        Assertions.a(parsableByteArray.a() >= 12);
        int iP = parsableByteArray.P();
        int iP2 = parsableByteArray.P();
        parsableByteArray.X(2);
        int iH = parsableByteArray.H();
        parsableByteArray.X(1);
        int iQ = parsableByteArray.q();
        if (iP2 > spannableStringBuilder.length()) {
            Log.i("Tx3gParser", "Truncating styl end (" + iP2 + ") to cueText.length() (" + spannableStringBuilder.length() + ").");
            iP2 = spannableStringBuilder.length();
        }
        int i3 = iP2;
        if (iP < i3) {
            f(spannableStringBuilder, iH, this.f47256c, iP, i3, 0);
            e(spannableStringBuilder, iQ, this.f47257d, iP, i3, 0);
            return;
        }
        Log.i("Tx3gParser", "Ignoring styl with start (" + iP + ") >= end (" + i3 + ").");
    }

    private static void e(SpannableStringBuilder spannableStringBuilder, int i3, int i4, int i5, int i6, int i7) {
        if (i3 != i4) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i3 >>> 8) | ((i3 & 255) << 24)), i5, i6, i7 | 33);
        }
    }

    private static void f(SpannableStringBuilder spannableStringBuilder, int i3, int i4, int i5, int i6, int i7) {
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

    private static String h(ParsableByteArray parsableByteArray) {
        Assertions.a(parsableByteArray.a() >= 2);
        int iP = parsableByteArray.P();
        if (iP == 0) {
            return "";
        }
        int iF = parsableByteArray.f();
        Charset charsetR = parsableByteArray.R();
        int iF2 = iP - (parsableByteArray.f() - iF);
        if (charsetR == null) {
            charsetR = StandardCharsets.UTF_8;
        }
        return parsableByteArray.F(iF2, charsetR);
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public void a(byte[] bArr, int i3, int i4, SubtitleParser.OutputOptions outputOptions, Consumer consumer) {
        this.f47254a.U(bArr, i4 + i3);
        this.f47254a.W(i3);
        String strH = h(this.f47254a);
        if (strH.isEmpty()) {
            consumer.accept(new CuesWithTiming(ImmutableList.y(), -9223372036854775807L, -9223372036854775807L));
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strH);
        f(spannableStringBuilder, this.f47256c, 0, 0, spannableStringBuilder.length(), 16711680);
        e(spannableStringBuilder, this.f47257d, -1, 0, spannableStringBuilder.length(), 16711680);
        g(spannableStringBuilder, this.f47258e, 0, spannableStringBuilder.length());
        float fQ = this.f47259f;
        while (this.f47254a.a() >= 8) {
            int iF = this.f47254a.f();
            int iQ = this.f47254a.q();
            int iQ2 = this.f47254a.q();
            if (iQ2 == 1937013100) {
                Assertions.a(this.f47254a.a() >= 2);
                int iP = this.f47254a.P();
                for (int i5 = 0; i5 < iP; i5++) {
                    d(this.f47254a, spannableStringBuilder);
                }
            } else if (iQ2 == 1952608120 && this.f47255b) {
                Assertions.a(this.f47254a.a() >= 2);
                fQ = Util.q(this.f47254a.P() / this.f47260g, 0.0f, 0.95f);
            }
            this.f47254a.W(iF + iQ);
        }
        consumer.accept(new CuesWithTiming(ImmutableList.z(new Cue.Builder().o(spannableStringBuilder).h(fQ, 0).i(0).a()), -9223372036854775807L, -9223372036854775807L));
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public int c() {
        return 2;
    }

    private static void g(SpannableStringBuilder spannableStringBuilder, String str, int i3, int i4) {
        if (str != vfptEEmYY.NyVnVqWcZyP) {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), i3, i4, 16711713);
        }
    }
}
