package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class H263Reader implements ElementaryStreamReader {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final float[] f47454m = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final UserDataReader f47455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f47456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ParsableByteArray f47457c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final NalUnitTargetBuffer f47460f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private SampleReader f47461g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f47462h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f47463i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private TrackOutput f47464j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f47465k;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean[] f47458d = new boolean[4];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CsdBuffer f47459e = new CsdBuffer(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f47466l = -9223372036854775807L;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CsdBuffer {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final byte[] f47467f = {0, 0, 1};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f47468a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f47469b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f47470c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f47471d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte[] f47472e;

        public CsdBuffer(int i3) {
            this.f47472e = new byte[i3];
        }

        public void a(byte[] bArr, int i3, int i4) {
            if (this.f47468a) {
                int i5 = i4 - i3;
                byte[] bArr2 = this.f47472e;
                int length = bArr2.length;
                int i6 = this.f47470c;
                if (length < i6 + i5) {
                    this.f47472e = Arrays.copyOf(bArr2, (i6 + i5) * 2);
                }
                System.arraycopy(bArr, i3, this.f47472e, this.f47470c, i5);
                this.f47470c += i5;
            }
        }

        public boolean b(int i3, int i4) {
            int i5 = this.f47469b;
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            if (i5 != 4) {
                                throw new IllegalStateException();
                            }
                            if (i3 == 179 || i3 == 181) {
                                this.f47470c -= i4;
                                this.f47468a = false;
                                return true;
                            }
                        } else if ((i3 & 240) != 32) {
                            Log.i("H263Reader", "Unexpected start code value");
                            c();
                        } else {
                            this.f47471d = this.f47470c;
                            this.f47469b = 4;
                        }
                    } else if (i3 > 31) {
                        Log.i("H263Reader", "Unexpected start code value");
                        c();
                    } else {
                        this.f47469b = 3;
                    }
                } else if (i3 != 181) {
                    Log.i("H263Reader", "Unexpected start code value");
                    c();
                } else {
                    this.f47469b = 2;
                }
            } else if (i3 == 176) {
                this.f47469b = 1;
                this.f47468a = true;
            }
            byte[] bArr = f47467f;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void c() {
            this.f47468a = false;
            this.f47470c = 0;
            this.f47469b = 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SampleReader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TrackOutput f47473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f47474b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f47475c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f47476d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f47477e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f47478f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f47479g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f47480h;

        public SampleReader(TrackOutput trackOutput) {
            this.f47473a = trackOutput;
        }

        public void a(byte[] bArr, int i3, int i4) {
            if (this.f47475c) {
                int i5 = this.f47478f;
                int i6 = (i3 + 1) - i5;
                if (i6 >= i4) {
                    this.f47478f = i5 + (i4 - i3);
                } else {
                    this.f47476d = ((bArr[i6] & 192) >> 6) == 0;
                    this.f47475c = false;
                }
            }
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
        public void b(long j3, int i3, boolean z2) {
            Assertions.g(this.f47480h != -9223372036854775807L);
            if (this.f47477e == 182 && z2 && this.f47474b) {
                this.f47473a.g(this.f47480h, this.f47476d ? 1 : 0, (int) (j3 - this.f47479g), i3, null);
            }
            if (this.f47477e != 179) {
                this.f47479g = j3;
            }
        }

        public void c(int i3, long j3) {
            this.f47477e = i3;
            this.f47476d = false;
            this.f47474b = i3 == 182 || i3 == 179;
            this.f47475c = i3 == 182;
            this.f47478f = 0;
            this.f47480h = j3;
        }

        public void d() {
            this.f47474b = false;
            this.f47475c = false;
            this.f47476d = false;
            this.f47477e = -1;
        }
    }

    H263Reader(UserDataReader userDataReader, String str) {
        this.f47455a = userDataReader;
        this.f47456b = str;
        if (userDataReader != null) {
            this.f47460f = new NalUnitTargetBuffer(178, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
            this.f47457c = new ParsableByteArray();
        } else {
            this.f47460f = null;
            this.f47457c = null;
        }
    }

    private static Format b(CsdBuffer csdBuffer, int i3, String str, String str2) {
        byte[] bArrCopyOf = Arrays.copyOf(csdBuffer.f47472e, csdBuffer.f47470c);
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArrCopyOf);
        parsableBitArray.s(i3);
        parsableBitArray.s(4);
        parsableBitArray.q();
        parsableBitArray.r(8);
        if (parsableBitArray.g()) {
            parsableBitArray.r(4);
            parsableBitArray.r(3);
        }
        int iH = parsableBitArray.h(4);
        float f3 = 1.0f;
        if (iH == 15) {
            int iH2 = parsableBitArray.h(8);
            int iH3 = parsableBitArray.h(8);
            if (iH3 == 0) {
                Log.i("H263Reader", "Invalid aspect ratio");
            } else {
                f3 = iH2 / iH3;
            }
        } else {
            float[] fArr = f47454m;
            if (iH < fArr.length) {
                f3 = fArr[iH];
            } else {
                Log.i("H263Reader", "Invalid aspect ratio");
            }
        }
        if (parsableBitArray.g()) {
            parsableBitArray.r(2);
            parsableBitArray.r(1);
            if (parsableBitArray.g()) {
                parsableBitArray.r(15);
                parsableBitArray.q();
                parsableBitArray.r(15);
                parsableBitArray.q();
                parsableBitArray.r(15);
                parsableBitArray.q();
                parsableBitArray.r(3);
                parsableBitArray.r(11);
                parsableBitArray.q();
                parsableBitArray.r(15);
                parsableBitArray.q();
            }
        }
        if (parsableBitArray.h(2) != 0) {
            Log.i("H263Reader", "Unhandled video object layer shape");
        }
        parsableBitArray.q();
        int iH4 = parsableBitArray.h(16);
        parsableBitArray.q();
        if (parsableBitArray.g()) {
            if (iH4 == 0) {
                Log.i("H263Reader", "Invalid vop_increment_time_resolution");
            } else {
                int i4 = 0;
                for (int i5 = iH4 - 1; i5 > 0; i5 >>= 1) {
                    i4++;
                }
                parsableBitArray.r(i4);
            }
        }
        parsableBitArray.q();
        int iH5 = parsableBitArray.h(13);
        parsableBitArray.q();
        int iH6 = parsableBitArray.h(13);
        parsableBitArray.q();
        parsableBitArray.q();
        return new Format.Builder().f0(str).U(str2).u0("video/mp4v-es").B0(iH5).d0(iH6).q0(f3).g0(Collections.singletonList(bArrCopyOf)).N();
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void a(ParsableByteArray parsableByteArray) {
        Assertions.i(this.f47461g);
        Assertions.i(this.f47464j);
        int iF = parsableByteArray.f();
        int iG = parsableByteArray.g();
        byte[] bArrE = parsableByteArray.e();
        this.f47462h += (long) parsableByteArray.a();
        this.f47464j.b(parsableByteArray, parsableByteArray.a());
        while (true) {
            int iE = NalUnitUtil.e(bArrE, iF, iG, this.f47458d);
            if (iE == iG) {
                break;
            }
            int i3 = iE + 3;
            int i4 = parsableByteArray.e()[i3] & 255;
            int i5 = iE - iF;
            int i6 = 0;
            if (!this.f47465k) {
                if (i5 > 0) {
                    this.f47459e.a(bArrE, iF, iE);
                }
                if (this.f47459e.b(i4, i5 < 0 ? -i5 : 0)) {
                    TrackOutput trackOutput = this.f47464j;
                    CsdBuffer csdBuffer = this.f47459e;
                    trackOutput.c(b(csdBuffer, csdBuffer.f47471d, (String) Assertions.e(this.f47463i), this.f47456b));
                    this.f47465k = true;
                }
            }
            this.f47461g.a(bArrE, iF, iE);
            NalUnitTargetBuffer nalUnitTargetBuffer = this.f47460f;
            if (nalUnitTargetBuffer != null) {
                if (i5 > 0) {
                    nalUnitTargetBuffer.a(bArrE, iF, iE);
                } else {
                    i6 = -i5;
                }
                if (this.f47460f.b(i6)) {
                    NalUnitTargetBuffer nalUnitTargetBuffer2 = this.f47460f;
                    ((ParsableByteArray) Util.k(this.f47457c)).U(this.f47460f.f47636d, NalUnitUtil.L(nalUnitTargetBuffer2.f47636d, nalUnitTargetBuffer2.f47637e));
                    ((UserDataReader) Util.k(this.f47455a)).a(this.f47466l, this.f47457c);
                }
                if (i4 == 178 && parsableByteArray.e()[iE + 2] == 1) {
                    this.f47460f.e(i4);
                }
            }
            int i7 = iG - iE;
            this.f47461g.b(this.f47462h - ((long) i7), i7, this.f47465k);
            this.f47461g.c(i4, this.f47466l);
            iF = i3;
        }
        if (!this.f47465k) {
            this.f47459e.a(bArrE, iF, iG);
        }
        this.f47461g.a(bArrE, iF, iG);
        NalUnitTargetBuffer nalUnitTargetBuffer3 = this.f47460f;
        if (nalUnitTargetBuffer3 != null) {
            nalUnitTargetBuffer3.a(bArrE, iF, iG);
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void c() {
        NalUnitUtil.c(this.f47458d);
        this.f47459e.c();
        SampleReader sampleReader = this.f47461g;
        if (sampleReader != null) {
            sampleReader.d();
        }
        NalUnitTargetBuffer nalUnitTargetBuffer = this.f47460f;
        if (nalUnitTargetBuffer != null) {
            nalUnitTargetBuffer.d();
        }
        this.f47462h = 0L;
        this.f47466l = -9223372036854775807L;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void d(boolean z2) {
        Assertions.i(this.f47461g);
        if (z2) {
            this.f47461g.b(this.f47462h, 0, this.f47465k);
            this.f47461g.d();
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f47463i = trackIdGenerator.b();
        TrackOutput trackOutputD = extractorOutput.d(trackIdGenerator.c(), 2);
        this.f47464j = trackOutputD;
        this.f47461g = new SampleReader(trackOutputD);
        UserDataReader userDataReader = this.f47455a;
        if (userDataReader != null) {
            userDataReader.b(extractorOutput, trackIdGenerator);
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void f(long j3, int i3) {
        this.f47466l = j3;
    }
}
