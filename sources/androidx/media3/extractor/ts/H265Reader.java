package androidx.media3.extractor.ts;

import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import com.google.common.base.Preconditions;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class H265Reader implements ElementaryStreamReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SeiReader f47532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f47533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f47534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TrackOutput f47535d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SampleReader f47536e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f47537f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f47544m;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean[] f47538g = new boolean[3];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final NalUnitTargetBuffer f47539h = new NalUnitTargetBuffer(32, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final NalUnitTargetBuffer f47540i = new NalUnitTargetBuffer(33, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final NalUnitTargetBuffer f47541j = new NalUnitTargetBuffer(34, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final NalUnitTargetBuffer f47542k = new NalUnitTargetBuffer(39, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final NalUnitTargetBuffer f47543l = new NalUnitTargetBuffer(40, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f47545n = -9223372036854775807L;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ParsableByteArray f47546o = new ParsableByteArray();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SampleReader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TrackOutput f47547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f47548b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f47549c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f47550d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f47551e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f47552f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f47553g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f47554h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f47555i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f47556j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private long f47557k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private long f47558l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private boolean f47559m;

        public SampleReader(TrackOutput trackOutput) {
            this.f47547a = trackOutput;
        }

        private static boolean b(int i3) {
            return (32 <= i3 && i3 <= 35) || i3 == 39;
        }

        private static boolean c(int i3) {
            return i3 < 32 || i3 == 40;
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
            long j3 = this.f47558l;
            if (j3 != -9223372036854775807L) {
                long j4 = this.f47548b;
                long j5 = this.f47557k;
                if (j4 == j5) {
                    return;
                }
                int i4 = (int) (j4 - j5);
                this.f47547a.g(j3, this.f47559m ? 1 : 0, i4, i3, null);
            }
        }

        public void a(long j3, int i3, boolean z2) {
            if (this.f47556j && this.f47553g) {
                this.f47559m = this.f47549c;
                this.f47556j = false;
            } else if (this.f47554h || this.f47553g) {
                if (z2 && this.f47555i) {
                    d(i3 + ((int) (j3 - this.f47548b)));
                }
                this.f47557k = this.f47548b;
                this.f47558l = this.f47551e;
                this.f47559m = this.f47549c;
                this.f47555i = true;
            }
        }

        public void e(byte[] bArr, int i3, int i4) {
            if (this.f47552f) {
                int i5 = this.f47550d;
                int i6 = (i3 + 2) - i5;
                if (i6 >= i4) {
                    this.f47550d = i5 + (i4 - i3);
                } else {
                    this.f47553g = (bArr[i6] & 128) != 0;
                    this.f47552f = false;
                }
            }
        }

        public void f() {
            this.f47552f = false;
            this.f47553g = false;
            this.f47554h = false;
            this.f47555i = false;
            this.f47556j = false;
        }

        public void g(long j3, int i3, int i4, long j4, boolean z2) {
            this.f47553g = false;
            this.f47554h = false;
            this.f47551e = j4;
            this.f47550d = 0;
            this.f47548b = j3;
            if (!c(i4)) {
                if (this.f47555i && !this.f47556j) {
                    if (z2) {
                        d(i3);
                    }
                    this.f47555i = false;
                }
                if (b(i4)) {
                    this.f47554h = !this.f47556j;
                    this.f47556j = true;
                }
            }
            boolean z3 = i4 >= 16 && i4 <= 21;
            this.f47549c = z3;
            this.f47552f = z3 || i4 <= 9;
        }
    }

    public H265Reader(SeiReader seiReader, String str) {
        this.f47532a = seiReader;
        this.f47533b = str;
    }

    private void b() {
        Assertions.i(this.f47535d);
        Util.k(this.f47536e);
    }

    private void g(long j3, int i3, int i4, long j4) {
        this.f47536e.a(j3, i3, this.f47537f);
        if (!this.f47537f) {
            this.f47539h.b(i4);
            this.f47540i.b(i4);
            this.f47541j.b(i4);
            if (this.f47539h.c() && this.f47540i.c() && this.f47541j.c()) {
                Format formatI = i(this.f47534c, this.f47539h, this.f47540i, this.f47541j, this.f47533b);
                this.f47535d.c(formatI);
                Preconditions.z(formatI.f40634q != -1);
                this.f47532a.f(formatI.f40634q);
                this.f47537f = true;
            }
        }
        if (this.f47542k.b(i4)) {
            NalUnitTargetBuffer nalUnitTargetBuffer = this.f47542k;
            this.f47546o.U(this.f47542k.f47636d, NalUnitUtil.L(nalUnitTargetBuffer.f47636d, nalUnitTargetBuffer.f47637e));
            this.f47546o.X(5);
            this.f47532a.c(j4, this.f47546o);
        }
        if (this.f47543l.b(i4)) {
            NalUnitTargetBuffer nalUnitTargetBuffer2 = this.f47543l;
            this.f47546o.U(this.f47543l.f47636d, NalUnitUtil.L(nalUnitTargetBuffer2.f47636d, nalUnitTargetBuffer2.f47637e));
            this.f47546o.X(5);
            this.f47532a.c(j4, this.f47546o);
        }
    }

    private void h(byte[] bArr, int i3, int i4) {
        this.f47536e.e(bArr, i3, i4);
        if (!this.f47537f) {
            this.f47539h.a(bArr, i3, i4);
            this.f47540i.a(bArr, i3, i4);
            this.f47541j.a(bArr, i3, i4);
        }
        this.f47542k.a(bArr, i3, i4);
        this.f47543l.a(bArr, i3, i4);
    }

    private static Format i(String str, NalUnitTargetBuffer nalUnitTargetBuffer, NalUnitTargetBuffer nalUnitTargetBuffer2, NalUnitTargetBuffer nalUnitTargetBuffer3, String str2) {
        int i3 = nalUnitTargetBuffer.f47637e;
        byte[] bArr = new byte[nalUnitTargetBuffer2.f47637e + i3 + nalUnitTargetBuffer3.f47637e];
        System.arraycopy(nalUnitTargetBuffer.f47636d, 0, bArr, 0, i3);
        System.arraycopy(nalUnitTargetBuffer2.f47636d, 0, bArr, nalUnitTargetBuffer.f47637e, nalUnitTargetBuffer2.f47637e);
        System.arraycopy(nalUnitTargetBuffer3.f47636d, 0, bArr, nalUnitTargetBuffer.f47637e + nalUnitTargetBuffer2.f47637e, nalUnitTargetBuffer3.f47637e);
        NalUnitUtil.H265SpsData h265SpsDataU = NalUnitUtil.u(nalUnitTargetBuffer2.f47636d, 3, nalUnitTargetBuffer2.f47637e, null);
        NalUnitUtil.H265ProfileTierLevel h265ProfileTierLevel = h265SpsDataU.f41709c;
        return new Format.Builder().f0(str).U(str2).u0("video/hevc").S(h265ProfileTierLevel != null ? CodecSpecificDataUtil.g(h265ProfileTierLevel.f41683a, h265ProfileTierLevel.f41684b, h265ProfileTierLevel.f41685c, h265ProfileTierLevel.f41686d, h265ProfileTierLevel.f41687e, h265ProfileTierLevel.f41688f) : null).B0(h265SpsDataU.f41714h).d0(h265SpsDataU.f41715i).T(new ColorInfo.Builder().d(h265SpsDataU.f41718l).c(h265SpsDataU.f41719m).e(h265SpsDataU.f41720n).g(h265SpsDataU.f41711e + 8).b(h265SpsDataU.f41712f + 8).a()).q0(h265SpsDataU.f41716j).l0(h265SpsDataU.f41717k).m0(h265SpsDataU.f41708b + 1).g0(Collections.singletonList(bArr)).N();
    }

    private void j(long j3, int i3, int i4, long j4) {
        this.f47536e.g(j3, i3, i4, j4, this.f47537f);
        if (!this.f47537f) {
            this.f47539h.e(i4);
            this.f47540i.e(i4);
            this.f47541j.e(i4);
        }
        this.f47542k.e(i4);
        this.f47543l.e(i4);
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void a(ParsableByteArray parsableByteArray) {
        int i3;
        b();
        while (parsableByteArray.a() > 0) {
            int iF = parsableByteArray.f();
            int iG = parsableByteArray.g();
            byte[] bArrE = parsableByteArray.e();
            this.f47544m += (long) parsableByteArray.a();
            this.f47535d.b(parsableByteArray, parsableByteArray.a());
            while (iF < iG) {
                int iE = NalUnitUtil.e(bArrE, iF, iG, this.f47538g);
                if (iE == iG) {
                    h(bArrE, iF, iG);
                    return;
                }
                int i4 = NalUnitUtil.i(bArrE, iE);
                if (iE <= 0 || bArrE[iE - 1] != 0) {
                    i3 = 3;
                } else {
                    iE--;
                    i3 = 4;
                }
                int i5 = iE;
                int i6 = i3;
                int i7 = i5 - iF;
                if (i7 > 0) {
                    h(bArrE, iF, i5);
                }
                int i8 = iG - i5;
                long j3 = this.f47544m - ((long) i8);
                g(j3, i8, i7 < 0 ? -i7 : 0, this.f47545n);
                j(j3, i8, i4, this.f47545n);
                iF = i5 + i6;
            }
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void c() {
        this.f47544m = 0L;
        this.f47545n = -9223372036854775807L;
        NalUnitUtil.c(this.f47538g);
        this.f47539h.d();
        this.f47540i.d();
        this.f47541j.d();
        this.f47542k.d();
        this.f47543l.d();
        this.f47532a.b();
        SampleReader sampleReader = this.f47536e;
        if (sampleReader != null) {
            sampleReader.f();
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void d(boolean z2) {
        b();
        if (z2) {
            this.f47532a.e();
            g(this.f47544m, 0, 0, this.f47545n);
            j(this.f47544m, 0, 48, this.f47545n);
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f47534c = trackIdGenerator.b();
        TrackOutput trackOutputD = extractorOutput.d(trackIdGenerator.c(), 2);
        this.f47535d = trackOutputD;
        this.f47536e = new SampleReader(trackOutputD);
        this.f47532a.d(extractorOutput, trackIdGenerator);
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void f(long j3, int i3) {
        this.f47545n = j3;
    }
}
