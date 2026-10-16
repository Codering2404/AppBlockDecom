package androidx.media3.extractor.text.pgs;

import android.graphics.Bitmap;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.SubtitleParser;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class PgsParser implements SubtitleParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ParsableByteArray f47126a = new ParsableByteArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ParsableByteArray f47127b = new ParsableByteArray();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CueBuilder f47128c = new CueBuilder();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Inflater f47129d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CueBuilder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ParsableByteArray f47130a = new ParsableByteArray();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int[] f47131b = new int[Function.MAX_NARGS];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f47132c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f47133d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f47134e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f47135f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f47136g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f47137h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f47138i;

        /* JADX INFO: Access modifiers changed from: private */
        public void e(ParsableByteArray parsableByteArray, int i3) {
            int iK;
            if (i3 < 4) {
                return;
            }
            parsableByteArray.X(3);
            int i4 = i3 - 4;
            if ((parsableByteArray.H() & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
                if (i4 < 7 || (iK = parsableByteArray.K()) < 4) {
                    return;
                }
                this.f47137h = parsableByteArray.P();
                this.f47138i = parsableByteArray.P();
                this.f47130a.S(iK - 4);
                i4 = i3 - 11;
            }
            int iF = this.f47130a.f();
            int iG = this.f47130a.g();
            if (iF >= iG || i4 <= 0) {
                return;
            }
            int iMin = Math.min(i4, iG - iF);
            parsableByteArray.l(this.f47130a.e(), iF, iMin);
            this.f47130a.W(iF + iMin);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(ParsableByteArray parsableByteArray, int i3) {
            if (i3 < 19) {
                return;
            }
            this.f47133d = parsableByteArray.P();
            this.f47134e = parsableByteArray.P();
            parsableByteArray.X(11);
            this.f47135f = parsableByteArray.P();
            this.f47136g = parsableByteArray.P();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(ParsableByteArray parsableByteArray, int i3) {
            if (i3 % 5 != 2) {
                return;
            }
            parsableByteArray.X(2);
            Arrays.fill(this.f47131b, 0);
            int i4 = i3 / 5;
            for (int i5 = 0; i5 < i4; i5++) {
                int iH = parsableByteArray.H();
                int iH2 = parsableByteArray.H();
                int iH3 = parsableByteArray.H();
                int iH4 = parsableByteArray.H();
                double d3 = iH2;
                double d4 = iH3 - 128;
                double d5 = iH4 - 128;
                this.f47131b[iH] = (Util.r((int) ((d3 - (0.34414d * d5)) - (d4 * 0.71414d)), 0, 255) << 8) | (parsableByteArray.H() << 24) | (Util.r((int) ((1.402d * d4) + d3), 0, 255) << 16) | Util.r((int) (d3 + (d5 * 1.772d)), 0, 255);
            }
            this.f47132c = true;
        }

        public Cue d() {
            int iH;
            if (this.f47133d == 0 || this.f47134e == 0 || this.f47137h == 0 || this.f47138i == 0 || this.f47130a.g() == 0 || this.f47130a.f() != this.f47130a.g() || !this.f47132c) {
                return null;
            }
            this.f47130a.W(0);
            int i3 = this.f47137h * this.f47138i;
            int[] iArr = new int[i3];
            int i4 = 0;
            while (i4 < i3) {
                int iH2 = this.f47130a.H();
                if (iH2 != 0) {
                    iH = i4 + 1;
                    iArr[i4] = this.f47131b[iH2];
                } else {
                    int iH3 = this.f47130a.H();
                    if (iH3 != 0) {
                        iH = ((iH3 & 64) == 0 ? iH3 & 63 : ((iH3 & 63) << 8) | this.f47130a.H()) + i4;
                        Arrays.fill(iArr, i4, iH, (iH3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0 ? this.f47131b[0] : this.f47131b[this.f47130a.H()]);
                    }
                }
                i4 = iH;
            }
            return new Cue.Builder().f(Bitmap.createBitmap(iArr, this.f47137h, this.f47138i, Bitmap.Config.ARGB_8888)).k(this.f47135f / this.f47133d).l(0).h(this.f47136g / this.f47134e, 0).i(0).n(this.f47137h / this.f47133d).g(this.f47138i / this.f47134e).a();
        }

        public void h() {
            this.f47133d = 0;
            this.f47134e = 0;
            this.f47135f = 0;
            this.f47136g = 0;
            this.f47137h = 0;
            this.f47138i = 0;
            this.f47130a.S(0);
            this.f47132c = false;
        }
    }

    private static Cue d(ParsableByteArray parsableByteArray, CueBuilder cueBuilder) {
        int iG = parsableByteArray.g();
        int iH = parsableByteArray.H();
        int iP = parsableByteArray.P();
        int iF = parsableByteArray.f() + iP;
        Cue cueD = null;
        if (iF > iG) {
            parsableByteArray.W(iG);
            return null;
        }
        if (iH != 128) {
            switch (iH) {
                case 20:
                    cueBuilder.g(parsableByteArray, iP);
                    break;
                case 21:
                    cueBuilder.e(parsableByteArray, iP);
                    break;
                case 22:
                    cueBuilder.f(parsableByteArray, iP);
                    break;
            }
        } else {
            cueD = cueBuilder.d();
            cueBuilder.h();
        }
        parsableByteArray.W(iF);
        return cueD;
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public void a(byte[] bArr, int i3, int i4, SubtitleParser.OutputOptions outputOptions, Consumer consumer) {
        this.f47126a.U(bArr, i4 + i3);
        this.f47126a.W(i3);
        if (this.f47129d == null) {
            this.f47129d = new Inflater();
        }
        if (Util.L0(this.f47126a, this.f47127b, this.f47129d)) {
            this.f47126a.U(this.f47127b.e(), this.f47127b.g());
        }
        this.f47128c.h();
        ArrayList arrayList = new ArrayList();
        while (this.f47126a.a() >= 3) {
            Cue cueD = d(this.f47126a, this.f47128c);
            if (cueD != null) {
                arrayList.add(cueD);
            }
        }
        consumer.accept(new CuesWithTiming(arrayList, -9223372036854775807L, -9223372036854775807L));
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public int c() {
        return 2;
    }
}
