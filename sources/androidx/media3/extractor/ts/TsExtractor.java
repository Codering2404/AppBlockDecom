package androidx.media3.extractor.ts;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.SubtitleTranscodingExtractorOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class TsExtractor implements Extractor {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final ExtractorsFactory f47706v = new ExtractorsFactory() { // from class: androidx.media3.extractor.ts.f
        @Override // androidx.media3.extractor.ExtractorsFactory
        public final Extractor[] f() {
            return TsExtractor.b();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f47707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f47708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f47709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f47710d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ParsableByteArray f47711e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SparseIntArray f47712f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TsPayloadReader.Factory f47713g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final SubtitleParser.Factory f47714h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final SparseArray f47715i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final SparseBooleanArray f47716j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final SparseBooleanArray f47717k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final TsDurationReader f47718l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private TsBinarySearchSeeker f47719m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ExtractorOutput f47720n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f47721o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f47722p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f47723q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f47724r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private TsPayloadReader f47725s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f47726t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f47727u;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    public TsExtractor(int i3, SubtitleParser.Factory factory) {
        this(1, i3, factory, new TimestampAdjuster(0L), new DefaultTsPayloadReaderFactory(0), 112800);
    }

    private boolean A(int i3) {
        return this.f47707a == 2 || this.f47722p || !this.f47717k.get(i3, false);
    }

    public static /* synthetic */ Extractor[] b() {
        return new Extractor[]{new TsExtractor(1, SubtitleParser.Factory.f46959a)};
    }

    static /* synthetic */ int m(TsExtractor tsExtractor) {
        int i3 = tsExtractor.f47721o;
        tsExtractor.f47721o = i3 + 1;
        return i3;
    }

    private boolean w(ExtractorInput extractorInput) {
        byte[] bArrE = this.f47711e.e();
        if (9400 - this.f47711e.f() < 188) {
            int iA = this.f47711e.a();
            if (iA > 0) {
                System.arraycopy(bArrE, this.f47711e.f(), bArrE, 0, iA);
            }
            this.f47711e.U(bArrE, iA);
        }
        while (this.f47711e.a() < 188) {
            int iG = this.f47711e.g();
            int i3 = extractorInput.read(bArrE, iG, 9400 - iG);
            if (i3 == -1) {
                return false;
            }
            this.f47711e.V(iG + i3);
        }
        return true;
    }

    private int x() throws ParserException {
        int iF = this.f47711e.f();
        int iG = this.f47711e.g();
        int iA = TsUtil.a(this.f47711e.e(), iF, iG);
        this.f47711e.W(iA);
        int i3 = iA + 188;
        if (i3 <= iG) {
            this.f47726t = 0;
            return i3;
        }
        int i4 = this.f47726t + (iA - iF);
        this.f47726t = i4;
        if (this.f47707a != 2 || i4 <= 376) {
            return i3;
        }
        throw ParserException.a("Cannot find sync byte. Most likely not a Transport Stream.", null);
    }

    private void y(long j3) {
        if (this.f47723q) {
            return;
        }
        this.f47723q = true;
        if (this.f47718l.b() == -9223372036854775807L) {
            this.f47720n.n(new SeekMap.Unseekable(this.f47718l.b()));
            return;
        }
        TsBinarySearchSeeker tsBinarySearchSeeker = new TsBinarySearchSeeker(this.f47718l.c(), this.f47718l.b(), j3, this.f47727u, this.f47709c);
        this.f47719m = tsBinarySearchSeeker;
        this.f47720n.n(tsBinarySearchSeeker.b());
    }

    private void z() {
        this.f47716j.clear();
        this.f47715i.clear();
        SparseArray sparseArrayB = this.f47713g.b();
        int size = sparseArrayB.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f47715i.put(sparseArrayB.keyAt(i3), (TsPayloadReader) sparseArrayB.valueAt(i3));
        }
        this.f47715i.put(0, new SectionReader(new PatReader()));
        this.f47725s = null;
    }

    @Override // androidx.media3.extractor.Extractor
    public void a(long j3, long j4) {
        TsBinarySearchSeeker tsBinarySearchSeeker;
        Assertions.g(this.f47707a != 2);
        int size = this.f47710d.size();
        for (int i3 = 0; i3 < size; i3++) {
            TimestampAdjuster timestampAdjuster = (TimestampAdjuster) this.f47710d.get(i3);
            boolean z2 = timestampAdjuster.f() == -9223372036854775807L;
            if (!z2) {
                long jD = timestampAdjuster.d();
                z2 = (jD == -9223372036854775807L || jD == 0 || jD == j4) ? false : true;
            }
            if (z2) {
                timestampAdjuster.i(j4);
            }
        }
        if (j4 != 0 && (tsBinarySearchSeeker = this.f47719m) != null) {
            tsBinarySearchSeeker.h(j4);
        }
        this.f47711e.S(0);
        this.f47712f.clear();
        for (int i4 = 0; i4 < this.f47715i.size(); i4++) {
            ((TsPayloadReader) this.f47715i.valueAt(i4)).c();
        }
        this.f47726t = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
    
        r1 = r1 + 1;
     */
    @Override // androidx.media3.extractor.Extractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean g(androidx.media3.extractor.ExtractorInput r7) {
        /*
            r6 = this;
            androidx.media3.common.util.ParsableByteArray r0 = r6.f47711e
            byte[] r0 = r0.e()
            r1 = 940(0x3ac, float:1.317E-42)
            r2 = 0
            r7.m(r0, r2, r1)
            r1 = r2
        Ld:
            r3 = 188(0xbc, float:2.63E-43)
            if (r1 >= r3) goto L29
            r3 = r2
        L12:
            r4 = 5
            if (r3 >= r4) goto L24
            int r4 = r3 * 188
            int r4 = r4 + r1
            r4 = r0[r4]
            r5 = 71
            if (r4 == r5) goto L21
            int r1 = r1 + 1
            goto Ld
        L21:
            int r3 = r3 + 1
            goto L12
        L24:
            r7.k(r1)
            r7 = 1
            return r7
        L29:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.TsExtractor.g(androidx.media3.extractor.ExtractorInput):boolean");
    }

    @Override // androidx.media3.extractor.Extractor
    public void h(ExtractorOutput extractorOutput) {
        if ((this.f47708b & 1) == 0) {
            extractorOutput = new SubtitleTranscodingExtractorOutput(extractorOutput, this.f47714h);
        }
        this.f47720n = extractorOutput;
    }

    @Override // androidx.media3.extractor.Extractor
    public int j(ExtractorInput extractorInput, PositionHolder positionHolder) throws ParserException {
        int i3;
        long length = extractorInput.getLength();
        boolean z2 = this.f47707a == 2;
        if (this.f47722p) {
            if (length != -1 && !z2 && !this.f47718l.d()) {
                return this.f47718l.e(extractorInput, positionHolder, this.f47727u);
            }
            y(length);
            if (this.f47724r) {
                this.f47724r = false;
                a(0L, 0L);
                if (extractorInput.getPosition() != 0) {
                    positionHolder.f46210a = 0L;
                    return 1;
                }
            }
            TsBinarySearchSeeker tsBinarySearchSeeker = this.f47719m;
            if (tsBinarySearchSeeker != null && tsBinarySearchSeeker.d()) {
                return this.f47719m.c(extractorInput, positionHolder);
            }
        }
        if (!w(extractorInput)) {
            for (int i4 = 0; i4 < this.f47715i.size(); i4++) {
                TsPayloadReader tsPayloadReader = (TsPayloadReader) this.f47715i.valueAt(i4);
                if (tsPayloadReader instanceof PesReader) {
                    PesReader pesReader = (PesReader) tsPayloadReader;
                    if (pesReader.d(z2)) {
                        pesReader.a(new ParsableByteArray(), 1);
                    }
                }
            }
            return -1;
        }
        int iX = x();
        int iG = this.f47711e.g();
        if (iX > iG) {
            return 0;
        }
        int iQ = this.f47711e.q();
        if ((8388608 & iQ) != 0) {
            this.f47711e.W(iX);
            return 0;
        }
        int i5 = (4194304 & iQ) != 0 ? 1 : 0;
        int i6 = (2096896 & iQ) >> 8;
        boolean z3 = (iQ & 32) != 0;
        TsPayloadReader tsPayloadReader2 = (iQ & 16) != 0 ? (TsPayloadReader) this.f47715i.get(i6) : null;
        if (tsPayloadReader2 == null) {
            this.f47711e.W(iX);
            return 0;
        }
        if (this.f47707a != 2) {
            int i7 = iQ & 15;
            i3 = 0;
            int i8 = this.f47712f.get(i6, i7 - 1);
            this.f47712f.put(i6, i7);
            if (i8 == i7) {
                this.f47711e.W(iX);
                return 0;
            }
            if (i7 != ((i8 + 1) & 15)) {
                tsPayloadReader2.c();
            }
        } else {
            i3 = 0;
        }
        if (z3) {
            int iH = this.f47711e.H();
            i5 |= (this.f47711e.H() & 64) != 0 ? 2 : i3;
            this.f47711e.X(iH - 1);
        }
        boolean z4 = this.f47722p;
        if (A(i6)) {
            this.f47711e.V(iX);
            tsPayloadReader2.a(this.f47711e, i5);
            this.f47711e.V(iG);
        }
        if (this.f47707a != 2 && !z4 && this.f47722p && length != -1) {
            this.f47724r = true;
        }
        this.f47711e.W(iX);
        return i3;
    }

    public TsExtractor(int i3, int i4, SubtitleParser.Factory factory, TimestampAdjuster timestampAdjuster, TsPayloadReader.Factory factory2, int i5) {
        this.f47713g = (TsPayloadReader.Factory) Assertions.e(factory2);
        this.f47709c = i5;
        this.f47707a = i3;
        this.f47708b = i4;
        this.f47714h = factory;
        if (i3 == 1 || i3 == 2) {
            this.f47710d = Collections.singletonList(timestampAdjuster);
        } else {
            ArrayList arrayList = new ArrayList();
            this.f47710d = arrayList;
            arrayList.add(timestampAdjuster);
        }
        this.f47711e = new ParsableByteArray(new byte[9400], 0);
        this.f47716j = new SparseBooleanArray();
        this.f47717k = new SparseBooleanArray();
        this.f47715i = new SparseArray();
        this.f47712f = new SparseIntArray();
        this.f47718l = new TsDurationReader(i5);
        this.f47720n = ExtractorOutput.m8;
        this.f47727u = -1;
        z();
    }

    @Override // androidx.media3.extractor.Extractor
    public void release() {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class PatReader implements SectionPayloadReader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ParsableBitArray f47728a = new ParsableBitArray(new byte[4]);

        public PatReader() {
        }

        @Override // androidx.media3.extractor.ts.SectionPayloadReader
        public void a(ParsableByteArray parsableByteArray) {
            if (parsableByteArray.H() == 0 && (parsableByteArray.H() & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
                parsableByteArray.X(6);
                int iA = parsableByteArray.a() / 4;
                for (int i3 = 0; i3 < iA; i3++) {
                    parsableByteArray.k(this.f47728a, 4);
                    int iH = this.f47728a.h(16);
                    this.f47728a.r(3);
                    if (iH == 0) {
                        this.f47728a.r(13);
                    } else {
                        int iH2 = this.f47728a.h(13);
                        if (TsExtractor.this.f47715i.get(iH2) == null) {
                            TsExtractor.this.f47715i.put(iH2, new SectionReader(TsExtractor.this.new PmtReader(iH2)));
                            TsExtractor.m(TsExtractor.this);
                        }
                    }
                }
                if (TsExtractor.this.f47707a != 2) {
                    TsExtractor.this.f47715i.remove(0);
                }
            }
        }

        @Override // androidx.media3.extractor.ts.SectionPayloadReader
        public void b(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class PmtReader implements SectionPayloadReader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ParsableBitArray f47730a = new ParsableBitArray(new byte[5]);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final SparseArray f47731b = new SparseArray();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final SparseIntArray f47732c = new SparseIntArray();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f47733d;

        public PmtReader(int i3) {
            this.f47733d = i3;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0063  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private androidx.media3.extractor.ts.TsPayloadReader.EsInfo c(androidx.media3.common.util.ParsableByteArray r17, int r18) {
            /*
                Method dump skipped, instruction units count: 235
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.TsExtractor.PmtReader.c(androidx.media3.common.util.ParsableByteArray, int):androidx.media3.extractor.ts.TsPayloadReader$EsInfo");
        }

        @Override // androidx.media3.extractor.ts.SectionPayloadReader
        public void a(ParsableByteArray parsableByteArray) {
            TimestampAdjuster timestampAdjuster;
            if (parsableByteArray.H() != 2) {
                return;
            }
            if (TsExtractor.this.f47707a == 1 || TsExtractor.this.f47707a == 2 || TsExtractor.this.f47721o == 1) {
                timestampAdjuster = (TimestampAdjuster) TsExtractor.this.f47710d.get(0);
            } else {
                timestampAdjuster = new TimestampAdjuster(((TimestampAdjuster) TsExtractor.this.f47710d.get(0)).d());
                TsExtractor.this.f47710d.add(timestampAdjuster);
            }
            if ((parsableByteArray.H() & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
                return;
            }
            parsableByteArray.X(1);
            int iP = parsableByteArray.P();
            int i3 = 3;
            parsableByteArray.X(3);
            parsableByteArray.k(this.f47730a, 2);
            this.f47730a.r(3);
            int i4 = 13;
            TsExtractor.this.f47727u = this.f47730a.h(13);
            parsableByteArray.k(this.f47730a, 2);
            int i5 = 4;
            this.f47730a.r(4);
            parsableByteArray.X(this.f47730a.h(12));
            if (TsExtractor.this.f47707a == 2 && TsExtractor.this.f47725s == null) {
                TsPayloadReader.EsInfo esInfo = new TsPayloadReader.EsInfo(21, null, 0, null, Util.f41614f);
                TsExtractor tsExtractor = TsExtractor.this;
                tsExtractor.f47725s = tsExtractor.f47713g.a(21, esInfo);
                if (TsExtractor.this.f47725s != null) {
                    TsExtractor.this.f47725s.b(timestampAdjuster, TsExtractor.this.f47720n, new TsPayloadReader.TrackIdGenerator(iP, 21, Utility.DEFAULT_STREAM_BUFFER_SIZE));
                }
            }
            this.f47731b.clear();
            this.f47732c.clear();
            int iA = parsableByteArray.a();
            while (iA > 0) {
                parsableByteArray.k(this.f47730a, 5);
                int iH = this.f47730a.h(8);
                this.f47730a.r(i3);
                int iH2 = this.f47730a.h(i4);
                this.f47730a.r(i5);
                int iH3 = this.f47730a.h(12);
                TsPayloadReader.EsInfo esInfoC = c(parsableByteArray, iH3);
                if (iH == 6 || iH == 5) {
                    iH = esInfoC.f47738a;
                }
                iA -= iH3 + 5;
                int i6 = TsExtractor.this.f47707a == 2 ? iH : iH2;
                if (!TsExtractor.this.f47716j.get(i6)) {
                    TsPayloadReader tsPayloadReaderA = (TsExtractor.this.f47707a == 2 && iH == 21) ? TsExtractor.this.f47725s : TsExtractor.this.f47713g.a(iH, esInfoC);
                    if (TsExtractor.this.f47707a != 2 || iH2 < this.f47732c.get(i6, Utility.DEFAULT_STREAM_BUFFER_SIZE)) {
                        this.f47732c.put(i6, iH2);
                        this.f47731b.put(i6, tsPayloadReaderA);
                    }
                }
                i3 = 3;
                i5 = 4;
                i4 = 13;
            }
            int size = this.f47732c.size();
            for (int i7 = 0; i7 < size; i7++) {
                int iKeyAt = this.f47732c.keyAt(i7);
                int iValueAt = this.f47732c.valueAt(i7);
                TsExtractor.this.f47716j.put(iKeyAt, true);
                TsExtractor.this.f47717k.put(iValueAt, true);
                TsPayloadReader tsPayloadReader = (TsPayloadReader) this.f47731b.valueAt(i7);
                if (tsPayloadReader != null) {
                    if (tsPayloadReader != TsExtractor.this.f47725s) {
                        tsPayloadReader.b(timestampAdjuster, TsExtractor.this.f47720n, new TsPayloadReader.TrackIdGenerator(iP, iKeyAt, Utility.DEFAULT_STREAM_BUFFER_SIZE));
                    }
                    TsExtractor.this.f47715i.put(iValueAt, tsPayloadReader);
                }
            }
            if (TsExtractor.this.f47707a == 2) {
                if (TsExtractor.this.f47722p) {
                    return;
                }
                TsExtractor.this.f47720n.q();
                TsExtractor.this.f47721o = 0;
                TsExtractor.this.f47722p = true;
                return;
            }
            TsExtractor.this.f47715i.remove(this.f47733d);
            TsExtractor tsExtractor2 = TsExtractor.this;
            tsExtractor2.f47721o = tsExtractor2.f47707a == 1 ? 0 : TsExtractor.this.f47721o - 1;
            if (TsExtractor.this.f47721o == 0) {
                TsExtractor.this.f47720n.q();
                TsExtractor.this.f47722p = true;
            }
        }

        @Override // androidx.media3.extractor.ts.SectionPayloadReader
        public void b(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        }
    }
}
