package androidx.media3.extractor.ts;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class H262Reader implements ElementaryStreamReader {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final double[] f47431r = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f47432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TrackOutput f47433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final UserDataReader f47434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f47435d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ParsableByteArray f47436e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final NalUnitTargetBuffer f47437f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean[] f47438g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final CsdBuffer f47439h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f47440i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f47441j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f47442k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f47443l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f47444m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f47445n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f47446o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f47447p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f47448q;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CsdBuffer {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final byte[] f47449e = {0, 0, 1};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f47450a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f47451b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f47452c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f47453d;

        public CsdBuffer(int i3) {
            this.f47453d = new byte[i3];
        }

        public void a(byte[] bArr, int i3, int i4) {
            if (this.f47450a) {
                int i5 = i4 - i3;
                byte[] bArr2 = this.f47453d;
                int length = bArr2.length;
                int i6 = this.f47451b;
                if (length < i6 + i5) {
                    this.f47453d = Arrays.copyOf(bArr2, (i6 + i5) * 2);
                }
                System.arraycopy(bArr, i3, this.f47453d, this.f47451b, i5);
                this.f47451b += i5;
            }
        }

        public boolean b(int i3, int i4) {
            if (this.f47450a) {
                int i5 = this.f47451b - i4;
                this.f47451b = i5;
                if (this.f47452c != 0 || i3 != 181) {
                    this.f47450a = false;
                    return true;
                }
                this.f47452c = i5;
            } else if (i3 == 179) {
                this.f47450a = true;
            }
            byte[] bArr = f47449e;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void c() {
            this.f47450a = false;
            this.f47451b = 0;
            this.f47452c = 0;
        }
    }

    public H262Reader(String str) {
        this(null, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.util.Pair b(androidx.media3.extractor.ts.H262Reader.CsdBuffer r8, java.lang.String r9, java.lang.String r10) {
        /*
            byte[] r0 = r8.f47453d
            int r1 = r8.f47451b
            byte[] r0 = java.util.Arrays.copyOf(r0, r1)
            r1 = 4
            r2 = r0[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            r3 = 5
            r4 = r0[r3]
            r5 = r4 & 255(0xff, float:3.57E-43)
            r6 = 6
            r6 = r0[r6]
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r1
            int r5 = r5 >> r1
            r2 = r2 | r5
            r4 = r4 & 15
            int r4 = r4 << 8
            r4 = r4 | r6
            r5 = 7
            r6 = r0[r5]
            r6 = r6 & 240(0xf0, float:3.36E-43)
            int r6 = r6 >> r1
            r7 = 2
            if (r6 == r7) goto L3e
            r7 = 3
            if (r6 == r7) goto L38
            if (r6 == r1) goto L30
            r1 = 1065353216(0x3f800000, float:1.0)
            goto L44
        L30:
            int r1 = r4 * 121
            float r1 = (float) r1
            int r6 = r2 * 100
        L35:
            float r6 = (float) r6
            float r1 = r1 / r6
            goto L44
        L38:
            int r1 = r4 * 16
            float r1 = (float) r1
            int r6 = r2 * 9
            goto L35
        L3e:
            int r1 = r4 * 4
            float r1 = (float) r1
            int r6 = r2 * 3
            goto L35
        L44:
            androidx.media3.common.Format$Builder r6 = new androidx.media3.common.Format$Builder
            r6.<init>()
            androidx.media3.common.Format$Builder r9 = r6.f0(r9)
            androidx.media3.common.Format$Builder r9 = r9.U(r10)
            java.lang.String r10 = "video/mpeg2"
            androidx.media3.common.Format$Builder r9 = r9.u0(r10)
            androidx.media3.common.Format$Builder r9 = r9.B0(r2)
            androidx.media3.common.Format$Builder r9 = r9.d0(r4)
            androidx.media3.common.Format$Builder r9 = r9.q0(r1)
            java.util.List r10 = java.util.Collections.singletonList(r0)
            androidx.media3.common.Format$Builder r9 = r9.g0(r10)
            androidx.media3.common.Format r9 = r9.N()
            r10 = r0[r5]
            r10 = r10 & 15
            int r10 = r10 + (-1)
            if (r10 < 0) goto L9c
            double[] r1 = androidx.media3.extractor.ts.H262Reader.f47431r
            int r2 = r1.length
            if (r10 >= r2) goto L9c
            r1 = r1[r10]
            int r8 = r8.f47452c
            int r8 = r8 + 9
            r8 = r0[r8]
            r10 = r8 & 96
            int r10 = r10 >> r3
            r8 = r8 & 31
            if (r10 == r8) goto L94
            double r3 = (double) r10
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r3 = r3 + r5
            int r8 = r8 + 1
            double r5 = (double) r8
            double r3 = r3 / r5
            double r1 = r1 * r3
        L94:
            r3 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r3 = r3 / r1
            long r0 = (long) r3
            goto L9e
        L9c:
            r0 = 0
        L9e:
            java.lang.Long r8 = java.lang.Long.valueOf(r0)
            android.util.Pair r8 = android.util.Pair.create(r9, r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.H262Reader.b(androidx.media3.extractor.ts.H262Reader$CsdBuffer, java.lang.String, java.lang.String):android.util.Pair");
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0144  */
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
    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(androidx.media3.common.util.ParsableByteArray r20) {
        /*
            Method dump skipped, instruction units count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.H262Reader.a(androidx.media3.common.util.ParsableByteArray):void");
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void c() {
        NalUnitUtil.c(this.f47438g);
        this.f47439h.c();
        NalUnitTargetBuffer nalUnitTargetBuffer = this.f47437f;
        if (nalUnitTargetBuffer != null) {
            nalUnitTargetBuffer.d();
        }
        this.f47440i = 0L;
        this.f47441j = false;
        this.f47444m = -9223372036854775807L;
        this.f47446o = -9223372036854775807L;
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
    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void d(boolean z2) {
        Assertions.i(this.f47433b);
        if (z2) {
            boolean z3 = this.f47447p;
            this.f47433b.g(this.f47446o, z3 ? 1 : 0, (int) (this.f47440i - this.f47445n), 0, null);
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f47432a = trackIdGenerator.b();
        this.f47433b = extractorOutput.d(trackIdGenerator.c(), 2);
        UserDataReader userDataReader = this.f47434c;
        if (userDataReader != null) {
            userDataReader.b(extractorOutput, trackIdGenerator);
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void f(long j3, int i3) {
        this.f47444m = j3;
    }

    H262Reader(UserDataReader userDataReader, String str) {
        this.f47434c = userDataReader;
        this.f47435d = str;
        this.f47438g = new boolean[4];
        this.f47439h = new CsdBuffer(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        if (userDataReader != null) {
            this.f47437f = new NalUnitTargetBuffer(178, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
            this.f47436e = new ParsableByteArray();
        } else {
            this.f47437f = null;
            this.f47436e = null;
        }
        this.f47444m = -9223372036854775807L;
        this.f47446o = -9223372036854775807L;
    }
}
