package androidx.media3.extractor.ts;

import android.util.SparseArray;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.container.ParsableNalUnitBitArray;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class H264Reader implements ElementaryStreamReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SeiReader f47481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f47482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f47483c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f47484d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f47488h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f47490j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TrackOutput f47491k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private SampleReader f47492l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f47493m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f47495o;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean[] f47489i = new boolean[3];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final NalUnitTargetBuffer f47485e = new NalUnitTargetBuffer(7, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final NalUnitTargetBuffer f47486f = new NalUnitTargetBuffer(8, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final NalUnitTargetBuffer f47487g = new NalUnitTargetBuffer(6, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f47494n = -9223372036854775807L;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final ParsableByteArray f47496p = new ParsableByteArray();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SampleReader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TrackOutput f47497a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f47498b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f47499c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final SparseArray f47500d = new SparseArray();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final SparseArray f47501e = new SparseArray();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ParsableNalUnitBitArray f47502f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private byte[] f47503g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f47504h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f47505i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f47506j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f47507k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private long f47508l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private SliceHeaderData f47509m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private SliceHeaderData f47510n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private boolean f47511o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private long f47512p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private long f47513q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private boolean f47514r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private boolean f47515s;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static final class SliceHeaderData {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private boolean f47516a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private boolean f47517b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private NalUnitUtil.SpsData f47518c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f47519d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private int f47520e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private int f47521f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private int f47522g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private boolean f47523h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private boolean f47524i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            private boolean f47525j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private boolean f47526k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            private int f47527l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            private int f47528m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            private int f47529n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            private int f47530o;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            private int f47531p;

            private SliceHeaderData() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean c(SliceHeaderData sliceHeaderData) {
                int i3;
                int i4;
                int i5;
                boolean z2;
                if (!this.f47516a) {
                    return false;
                }
                if (!sliceHeaderData.f47516a) {
                    return true;
                }
                NalUnitUtil.SpsData spsData = (NalUnitUtil.SpsData) Assertions.i(this.f47518c);
                NalUnitUtil.SpsData spsData2 = (NalUnitUtil.SpsData) Assertions.i(sliceHeaderData.f47518c);
                return (this.f47521f == sliceHeaderData.f47521f && this.f47522g == sliceHeaderData.f47522g && this.f47523h == sliceHeaderData.f47523h && (!this.f47524i || !sliceHeaderData.f47524i || this.f47525j == sliceHeaderData.f47525j) && (((i3 = this.f47519d) == (i4 = sliceHeaderData.f47519d) || (i3 != 0 && i4 != 0)) && (((i5 = spsData.f41747n) != 0 || spsData2.f41747n != 0 || (this.f47528m == sliceHeaderData.f47528m && this.f47529n == sliceHeaderData.f47529n)) && ((i5 != 1 || spsData2.f41747n != 1 || (this.f47530o == sliceHeaderData.f47530o && this.f47531p == sliceHeaderData.f47531p)) && (z2 = this.f47526k) == sliceHeaderData.f47526k && (!z2 || this.f47527l == sliceHeaderData.f47527l))))) ? false : true;
            }

            public void b() {
                this.f47517b = false;
                this.f47516a = false;
            }

            public boolean d() {
                if (!this.f47517b) {
                    return false;
                }
                int i3 = this.f47520e;
                return i3 == 7 || i3 == 2;
            }

            public void e(NalUnitUtil.SpsData spsData, int i3, int i4, int i5, int i6, boolean z2, boolean z3, boolean z4, boolean z5, int i7, int i8, int i9, int i10, int i11) {
                this.f47518c = spsData;
                this.f47519d = i3;
                this.f47520e = i4;
                this.f47521f = i5;
                this.f47522g = i6;
                this.f47523h = z2;
                this.f47524i = z3;
                this.f47525j = z4;
                this.f47526k = z5;
                this.f47527l = i7;
                this.f47528m = i8;
                this.f47529n = i9;
                this.f47530o = i10;
                this.f47531p = i11;
                this.f47516a = true;
                this.f47517b = true;
            }

            public void f(int i3) {
                this.f47520e = i3;
                this.f47517b = true;
            }
        }

        public SampleReader(TrackOutput trackOutput, boolean z2, boolean z3) {
            this.f47497a = trackOutput;
            this.f47498b = z2;
            this.f47499c = z3;
            this.f47509m = new SliceHeaderData();
            this.f47510n = new SliceHeaderData();
            byte[] bArr = new byte[ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD];
            this.f47503g = bArr;
            this.f47502f = new ParsableNalUnitBitArray(bArr, 0, 0);
            g();
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        private void d(int i3) {
            long j3 = this.f47513q;
            if (j3 != -9223372036854775807L) {
                long j4 = this.f47506j;
                long j5 = this.f47512p;
                if (j4 == j5) {
                    return;
                }
                int i4 = (int) (j4 - j5);
                this.f47497a.g(j3, this.f47514r ? 1 : 0, i4, i3, null);
            }
        }

        private void h() {
            boolean zD = this.f47498b ? this.f47510n.d() : this.f47515s;
            boolean z2 = this.f47514r;
            int i3 = this.f47505i;
            boolean z3 = true;
            if (i3 != 5 && (!zD || i3 != 1)) {
                z3 = false;
            }
            this.f47514r = z2 | z3;
        }

        /* JADX WARN: Removed duplicated region for block: B:53:0x0109  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x010c  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0110  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0123  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0129  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x0161  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(byte[] r24, int r25, int r26) {
            /*
                Method dump skipped, instruction units count: 426
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.H264Reader.SampleReader.a(byte[], int, int):void");
        }

        public boolean b(long j3, int i3, boolean z2) {
            if (this.f47505i == 9 || (this.f47499c && this.f47510n.c(this.f47509m))) {
                if (z2 && this.f47511o) {
                    d(i3 + ((int) (j3 - this.f47506j)));
                }
                this.f47512p = this.f47506j;
                this.f47513q = this.f47508l;
                this.f47514r = false;
                this.f47511o = true;
            }
            h();
            this.f47505i = 24;
            return this.f47514r;
        }

        public boolean c() {
            return this.f47499c;
        }

        public void e(NalUnitUtil.PpsData ppsData) {
            this.f47501e.append(ppsData.f41731a, ppsData);
        }

        public void f(NalUnitUtil.SpsData spsData) {
            this.f47500d.append(spsData.f41737d, spsData);
        }

        public void g() {
            this.f47507k = false;
            this.f47511o = false;
            this.f47510n.b();
        }

        public void i(long j3, int i3, long j4, boolean z2) {
            this.f47505i = i3;
            this.f47508l = j4;
            this.f47506j = j3;
            this.f47515s = z2;
            if (!this.f47498b || i3 != 1) {
                if (!this.f47499c) {
                    return;
                }
                if (i3 != 5 && i3 != 1 && i3 != 2) {
                    return;
                }
            }
            SliceHeaderData sliceHeaderData = this.f47509m;
            this.f47509m = this.f47510n;
            this.f47510n = sliceHeaderData;
            sliceHeaderData.b();
            this.f47504h = 0;
            this.f47507k = true;
        }
    }

    public H264Reader(SeiReader seiReader, boolean z2, boolean z3, String str) {
        this.f47481a = seiReader;
        this.f47482b = z2;
        this.f47483c = z3;
        this.f47484d = str;
    }

    private void b() {
        Assertions.i(this.f47491k);
        Util.k(this.f47492l);
    }

    private void g(long j3, int i3, int i4, long j4) {
        if (!this.f47493m || this.f47492l.c()) {
            this.f47485e.b(i4);
            this.f47486f.b(i4);
            if (this.f47493m) {
                if (this.f47485e.c()) {
                    NalUnitTargetBuffer nalUnitTargetBuffer = this.f47485e;
                    NalUnitUtil.SpsData spsDataC = NalUnitUtil.C(nalUnitTargetBuffer.f47636d, 3, nalUnitTargetBuffer.f47637e);
                    this.f47481a.f(spsDataC.f41753t);
                    this.f47492l.f(spsDataC);
                    this.f47485e.d();
                } else if (this.f47486f.c()) {
                    NalUnitTargetBuffer nalUnitTargetBuffer2 = this.f47486f;
                    this.f47492l.e(NalUnitUtil.A(nalUnitTargetBuffer2.f47636d, 3, nalUnitTargetBuffer2.f47637e));
                    this.f47486f.d();
                }
            } else if (this.f47485e.c() && this.f47486f.c()) {
                ArrayList arrayList = new ArrayList();
                NalUnitTargetBuffer nalUnitTargetBuffer3 = this.f47485e;
                arrayList.add(Arrays.copyOf(nalUnitTargetBuffer3.f47636d, nalUnitTargetBuffer3.f47637e));
                NalUnitTargetBuffer nalUnitTargetBuffer4 = this.f47486f;
                arrayList.add(Arrays.copyOf(nalUnitTargetBuffer4.f47636d, nalUnitTargetBuffer4.f47637e));
                NalUnitTargetBuffer nalUnitTargetBuffer5 = this.f47485e;
                NalUnitUtil.SpsData spsDataC2 = NalUnitUtil.C(nalUnitTargetBuffer5.f47636d, 3, nalUnitTargetBuffer5.f47637e);
                NalUnitTargetBuffer nalUnitTargetBuffer6 = this.f47486f;
                NalUnitUtil.PpsData ppsDataA = NalUnitUtil.A(nalUnitTargetBuffer6.f47636d, 3, nalUnitTargetBuffer6.f47637e);
                this.f47491k.c(new Format.Builder().f0(this.f47490j).U(this.f47484d).u0("video/avc").S(CodecSpecificDataUtil.d(spsDataC2.f41734a, spsDataC2.f41735b, spsDataC2.f41736c)).B0(spsDataC2.f41739f).d0(spsDataC2.f41740g).T(new ColorInfo.Builder().d(spsDataC2.f41750q).c(spsDataC2.f41751r).e(spsDataC2.f41752s).g(spsDataC2.f41742i + 8).b(spsDataC2.f41743j + 8).a()).q0(spsDataC2.f41741h).g0(arrayList).l0(spsDataC2.f41753t).N());
                this.f47493m = true;
                this.f47481a.f(spsDataC2.f41753t);
                this.f47492l.f(spsDataC2);
                this.f47492l.e(ppsDataA);
                this.f47485e.d();
                this.f47486f.d();
            }
        }
        if (this.f47487g.b(i4)) {
            NalUnitTargetBuffer nalUnitTargetBuffer7 = this.f47487g;
            this.f47496p.U(this.f47487g.f47636d, NalUnitUtil.L(nalUnitTargetBuffer7.f47636d, nalUnitTargetBuffer7.f47637e));
            this.f47496p.W(4);
            this.f47481a.c(j4, this.f47496p);
        }
        if (this.f47492l.b(j3, i3, this.f47493m)) {
            this.f47495o = false;
        }
    }

    private void h(byte[] bArr, int i3, int i4) {
        if (!this.f47493m || this.f47492l.c()) {
            this.f47485e.a(bArr, i3, i4);
            this.f47486f.a(bArr, i3, i4);
        }
        this.f47487g.a(bArr, i3, i4);
        this.f47492l.a(bArr, i3, i4);
    }

    private void i(long j3, int i3, long j4) {
        if (!this.f47493m || this.f47492l.c()) {
            this.f47485e.e(i3);
            this.f47486f.e(i3);
        }
        this.f47487g.e(i3);
        this.f47492l.i(j3, i3, j4, this.f47495o);
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void a(ParsableByteArray parsableByteArray) {
        int i3;
        b();
        int iF = parsableByteArray.f();
        int iG = parsableByteArray.g();
        byte[] bArrE = parsableByteArray.e();
        this.f47488h += (long) parsableByteArray.a();
        this.f47491k.b(parsableByteArray, parsableByteArray.a());
        while (true) {
            int iE = NalUnitUtil.e(bArrE, iF, iG, this.f47489i);
            if (iE == iG) {
                h(bArrE, iF, iG);
                return;
            }
            int iJ = NalUnitUtil.j(bArrE, iE);
            if (iE <= 0 || bArrE[iE - 1] != 0) {
                i3 = 3;
            } else {
                iE--;
                i3 = 4;
            }
            int i4 = iE;
            int i5 = i3;
            int i6 = i4 - iF;
            if (i6 > 0) {
                h(bArrE, iF, i4);
            }
            int i7 = iG - i4;
            long j3 = this.f47488h - ((long) i7);
            g(j3, i7, i6 < 0 ? -i6 : 0, this.f47494n);
            i(j3, iJ, this.f47494n);
            iF = i4 + i5;
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void c() {
        this.f47488h = 0L;
        this.f47495o = false;
        this.f47494n = -9223372036854775807L;
        NalUnitUtil.c(this.f47489i);
        this.f47485e.d();
        this.f47486f.d();
        this.f47487g.d();
        this.f47481a.b();
        SampleReader sampleReader = this.f47492l;
        if (sampleReader != null) {
            sampleReader.g();
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void d(boolean z2) {
        b();
        if (z2) {
            this.f47481a.e();
            g(this.f47488h, 0, 0, this.f47494n);
            i(this.f47488h, 9, this.f47494n);
            g(this.f47488h, 0, 0, this.f47494n);
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f47490j = trackIdGenerator.b();
        TrackOutput trackOutputD = extractorOutput.d(trackIdGenerator.c(), 2);
        this.f47491k = trackOutputD;
        this.f47492l = new SampleReader(trackOutputD, this.f47482b, this.f47483c);
        this.f47481a.d(extractorOutput, trackIdGenerator);
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void f(long j3, int i3) {
        this.f47494n = j3;
        this.f47495o |= (i3 & 2) != 0;
    }
}
