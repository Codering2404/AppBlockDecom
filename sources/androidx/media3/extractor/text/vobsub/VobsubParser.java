package androidx.media3.extractor.text.vobsub;

import android.graphics.Bitmap;
import android.graphics.Rect;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.SubtitleParser;
import com.google.common.collect.ImmutableList;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class VobsubParser implements SubtitleParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ParsableByteArray f47261a = new ParsableByteArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ParsableByteArray f47262b = new ParsableByteArray();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CueBuilder f47263c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Inflater f47264d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CueBuilder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f47266b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f47267c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int[] f47268d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f47269e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f47270f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Rect f47271g;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int[] f47265a = new int[4];

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f47272h = -1;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f47273i = -1;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static final class Run {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f47274a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f47275b;

            private Run() {
            }
        }

        private static int b(int[] iArr, int i3) {
            return (i3 < 0 || i3 >= iArr.length) ? iArr[0] : iArr[i3];
        }

        private static int c(String str) {
            try {
                return Integer.parseInt(str, 16);
            } catch (RuntimeException unused) {
                return 0;
            }
        }

        private void d(int[] iArr, ParsableByteArray parsableByteArray, int i3) {
            while (parsableByteArray.f() < i3 && parsableByteArray.a() > 0) {
                switch (parsableByteArray.H()) {
                    case 0:
                    case 1:
                    case 2:
                        break;
                    case 3:
                        if (!g(iArr, parsableByteArray)) {
                            return;
                        }
                        break;
                    case 4:
                        if (!e(parsableByteArray)) {
                            return;
                        }
                        break;
                    case 5:
                        if (!f(parsableByteArray)) {
                            return;
                        }
                        break;
                    case 6:
                        if (!h(parsableByteArray)) {
                            return;
                        }
                        break;
                    default:
                        return;
                }
            }
        }

        private boolean e(ParsableByteArray parsableByteArray) {
            if (parsableByteArray.a() < 2 || !this.f47267c) {
                return false;
            }
            int iH = parsableByteArray.H();
            int iH2 = parsableByteArray.H();
            int[] iArr = this.f47265a;
            iArr[3] = n(iArr[3], iH >> 4);
            int[] iArr2 = this.f47265a;
            iArr2[2] = n(iArr2[2], iH & 15);
            int[] iArr3 = this.f47265a;
            iArr3[1] = n(iArr3[1], iH2 >> 4);
            int[] iArr4 = this.f47265a;
            iArr4[0] = n(iArr4[0], iH2 & 15);
            return true;
        }

        private boolean f(ParsableByteArray parsableByteArray) {
            if (parsableByteArray.a() < 6) {
                return false;
            }
            int iH = parsableByteArray.H();
            int iH2 = parsableByteArray.H();
            int i3 = (iH << 4) | (iH2 >> 4);
            int iH3 = ((iH2 & 15) << 8) | parsableByteArray.H();
            int iH4 = parsableByteArray.H();
            int iH5 = parsableByteArray.H();
            this.f47271g = new Rect(i3, (iH4 << 4) | (iH5 >> 4), iH3 + 1, (parsableByteArray.H() | ((iH5 & 15) << 8)) + 1);
            return true;
        }

        private boolean g(int[] iArr, ParsableByteArray parsableByteArray) {
            if (parsableByteArray.a() < 2) {
                return false;
            }
            int iH = parsableByteArray.H();
            int iH2 = parsableByteArray.H();
            this.f47265a[3] = b(iArr, iH >> 4);
            this.f47265a[2] = b(iArr, iH & 15);
            this.f47265a[1] = b(iArr, iH2 >> 4);
            this.f47265a[0] = b(iArr, iH2 & 15);
            this.f47267c = true;
            return true;
        }

        private boolean h(ParsableByteArray parsableByteArray) {
            if (parsableByteArray.a() < 4) {
                return false;
            }
            this.f47272h = parsableByteArray.P();
            this.f47273i = parsableByteArray.P();
            return true;
        }

        private void j(ParsableBitArray parsableBitArray, boolean z2, Rect rect, int[] iArr) {
            int iWidth = rect.width();
            int iHeight = rect.height();
            int i3 = !z2 ? 1 : 0;
            int i4 = i3 * iWidth;
            Run run = new Run();
            while (true) {
                int i5 = 0;
                do {
                    k(parsableBitArray, iWidth, run);
                    int iMin = Math.min(run.f47275b, iWidth - i5);
                    if (iMin > 0) {
                        int i6 = i4 + iMin;
                        Arrays.fill(iArr, i4, i6, this.f47265a[run.f47274a]);
                        i5 += iMin;
                        i4 = i6;
                    }
                } while (i5 < iWidth);
                i3 += 2;
                if (i3 >= iHeight) {
                    return;
                }
                i4 = i3 * iWidth;
                parsableBitArray.c();
            }
        }

        private static void k(ParsableBitArray parsableBitArray, int i3, Run run) {
            int iH = 0;
            for (int i4 = 1; iH < i4 && i4 <= 64; i4 <<= 2) {
                if (parsableBitArray.b() < 4) {
                    run.f47274a = -1;
                    run.f47275b = 0;
                    return;
                }
                iH = (iH << 4) | parsableBitArray.h(4);
            }
            run.f47274a = iH & 3;
            if (iH >= 4) {
                i3 = iH >> 2;
            }
            run.f47275b = i3;
        }

        private static int n(int i3, int i4) {
            return (i3 & 16777215) | ((i4 * 17) << 24);
        }

        public Cue a(ParsableByteArray parsableByteArray) {
            Rect rect;
            if (this.f47268d == null || !this.f47266b || !this.f47267c || (rect = this.f47271g) == null || this.f47272h == -1 || this.f47273i == -1 || rect.width() < 2 || this.f47271g.height() < 2) {
                return null;
            }
            Rect rect2 = this.f47271g;
            int[] iArr = new int[rect2.width() * rect2.height()];
            ParsableBitArray parsableBitArray = new ParsableBitArray();
            parsableByteArray.W(this.f47272h);
            parsableBitArray.m(parsableByteArray);
            j(parsableBitArray, true, rect2, iArr);
            parsableByteArray.W(this.f47273i);
            parsableBitArray.m(parsableByteArray);
            j(parsableBitArray, false, rect2, iArr);
            return new Cue.Builder().f(Bitmap.createBitmap(iArr, rect2.width(), rect2.height(), Bitmap.Config.ARGB_8888)).k(rect2.left / this.f47269e).l(0).h(rect2.top / this.f47270f, 0).i(0).n(rect2.width() / this.f47269e).g(rect2.height() / this.f47270f).a();
        }

        public void i(String str) {
            for (String str2 : Util.h1(str.trim(), "\\r?\\n")) {
                if (str2.startsWith("palette: ")) {
                    String[] strArrH1 = Util.h1(str2.substring(9), ",");
                    this.f47268d = new int[strArrH1.length];
                    for (int i3 = 0; i3 < strArrH1.length; i3++) {
                        this.f47268d[i3] = c(strArrH1[i3].trim());
                    }
                } else if (str2.startsWith("size: ")) {
                    String[] strArrH12 = Util.h1(str2.substring(6).trim(), "x");
                    if (strArrH12.length == 2) {
                        try {
                            this.f47269e = Integer.parseInt(strArrH12[0]);
                            this.f47270f = Integer.parseInt(strArrH12[1]);
                            this.f47266b = true;
                        } catch (RuntimeException e3) {
                            Log.j("VobsubParser", "Parsing IDX failed", e3);
                        }
                    }
                }
            }
        }

        public void l(ParsableByteArray parsableByteArray) {
            int[] iArr = this.f47268d;
            if (iArr == null || !this.f47266b) {
                return;
            }
            parsableByteArray.X(parsableByteArray.P() - 2);
            d(iArr, parsableByteArray, parsableByteArray.P());
        }

        public void m() {
            this.f47267c = false;
            this.f47271g = null;
            this.f47272h = -1;
            this.f47273i = -1;
        }
    }

    public VobsubParser(List list) {
        CueBuilder cueBuilder = new CueBuilder();
        this.f47263c = cueBuilder;
        cueBuilder.i(new String((byte[]) list.get(0), StandardCharsets.UTF_8));
    }

    private Cue d() {
        if (this.f47264d == null) {
            this.f47264d = new Inflater();
        }
        if (Util.L0(this.f47261a, this.f47262b, this.f47264d)) {
            this.f47261a.U(this.f47262b.e(), this.f47262b.g());
        }
        this.f47263c.m();
        int iA = this.f47261a.a();
        if (iA < 2 || this.f47261a.P() != iA) {
            return null;
        }
        this.f47263c.l(this.f47261a);
        return this.f47263c.a(this.f47261a);
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public void a(byte[] bArr, int i3, int i4, SubtitleParser.OutputOptions outputOptions, Consumer consumer) {
        this.f47261a.U(bArr, i4 + i3);
        this.f47261a.W(i3);
        Cue cueD = d();
        consumer.accept(new CuesWithTiming(cueD != null ? ImmutableList.z(cueD) : ImmutableList.y(), -9223372036854775807L, 5000000L));
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public int c() {
        return 2;
    }
}
