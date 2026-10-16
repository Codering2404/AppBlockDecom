package com.applovin.impl;

import android.util.Pair;
import android.util.SparseArray;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.impl.ij;
import com.applovin.impl.qo;
import com.applovin.impl.x6;
import com.facebook.AccessTokenManager;
import com.facebook.stetho.dumpapp.Framer;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.view.screen.ohO.MHoiDDglUlPJC;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class xc implements j8 {

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final n8 f64895b0 = new n8() { // from class: com.applovin.impl.p80
        @Override // com.applovin.impl.n8
        public final j8[] a() {
            return xc.g();
        }
    };

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private static final byte[] f64896c0 = {Framer.STDOUT_FRAME_PREFIX, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, Framer.STDIN_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private static final byte[] f64897d0 = xp.c("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private static final byte[] f64898e0 = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private static final UUID f64899f0 = new UUID(72057594037932032L, -9223371306706625679L);

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private static final Map f64900g0;
    private long A;
    private long B;
    private qc C;
    private qc D;
    private boolean E;
    private boolean F;
    private int G;
    private long H;
    private long I;
    private int J;
    private int K;
    private int[] L;
    private int M;
    private int N;
    private int O;
    private int P;
    private boolean Q;
    private int R;
    private int S;
    private int T;
    private boolean U;
    private boolean V;
    private boolean W;
    private int X;
    private byte Y;
    private boolean Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o7 f64901a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private l8 f64902a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zp f64903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SparseArray f64904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f64905d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ah f64906e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ah f64907f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ah f64908g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ah f64909h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ah f64910i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ah f64911j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ah f64912k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ah f64913l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final ah f64914m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final ah f64915n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ByteBuffer f64916o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f64917p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f64918q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f64919r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f64920s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f64921t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private c f64922u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f64923v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f64924w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long f64925x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f64926y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private long f64927z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class b implements n7 {
        private b() {
        }

        @Override // com.applovin.impl.n7
        public void a(int i3, int i4, k8 k8Var) throws ch {
            xc.this.a(i3, i4, k8Var);
        }

        @Override // com.applovin.impl.n7
        public int b(int i3) {
            return xc.this.e(i3);
        }

        @Override // com.applovin.impl.n7
        public boolean c(int i3) {
            return xc.this.f(i3);
        }

        @Override // com.applovin.impl.n7
        public void a(int i3) throws ch {
            xc.this.c(i3);
        }

        @Override // com.applovin.impl.n7
        public void a(int i3, double d3) {
            xc.this.a(i3, d3);
        }

        @Override // com.applovin.impl.n7
        public void a(int i3, long j3) throws ch {
            xc.this.a(i3, j3);
        }

        @Override // com.applovin.impl.n7
        public void a(int i3, long j3, long j4) throws ch {
            xc.this.a(i3, j3, j4);
        }

        @Override // com.applovin.impl.n7
        public void a(int i3, String str) throws ch {
            xc.this.a(i3, str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class c {
        public int A;
        public int B;
        public int C;
        public float D;
        public float E;
        public float F;
        public float G;
        public float H;
        public float I;
        public float J;
        public float K;
        public float L;
        public float M;
        public byte[] N;
        public int O;
        public int P;
        public int Q;
        public long R;
        public long S;
        public d T;
        public boolean U;
        public boolean V;
        private String W;
        public qo X;
        public int Y;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f64929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f64930b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f64931c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f64932d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f64933e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f64934f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f64935g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f64936h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public byte[] f64937i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public qo.a f64938j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public byte[] f64939k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public x6 f64940l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f64941m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f64942n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f64943o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f64944p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f64945q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f64946r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public float f64947s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public float f64948t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public float f64949u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public byte[] f64950v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f64951w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public boolean f64952x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f64953y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f64954z;

        private c() {
            this.f64941m = -1;
            this.f64942n = -1;
            this.f64943o = -1;
            this.f64944p = -1;
            this.f64945q = 0;
            this.f64946r = -1;
            this.f64947s = 0.0f;
            this.f64948t = 0.0f;
            this.f64949u = 0.0f;
            this.f64950v = null;
            this.f64951w = -1;
            this.f64952x = false;
            this.f64953y = -1;
            this.f64954z = -1;
            this.A = -1;
            this.B = 1000;
            this.C = 200;
            this.D = -1.0f;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = -1.0f;
            this.H = -1.0f;
            this.I = -1.0f;
            this.J = -1.0f;
            this.K = -1.0f;
            this.L = -1.0f;
            this.M = -1.0f;
            this.O = 1;
            this.P = -1;
            this.Q = 8000;
            this.R = 0L;
            this.S = 0L;
            this.V = true;
            this.W = "eng";
        }

        public void c() {
            d dVar = this.T;
            if (dVar != null) {
                dVar.a(this);
            }
        }

        public void d() {
            d dVar = this.T;
            if (dVar != null) {
                dVar.a();
            }
        }

        private byte[] b() {
            if (this.D == -1.0f || this.E == -1.0f || this.F == -1.0f || this.G == -1.0f || this.H == -1.0f || this.I == -1.0f || this.J == -1.0f || this.K == -1.0f || this.L == -1.0f || this.M == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            byteBufferOrder.put((byte) 0);
            byteBufferOrder.putShort((short) ((this.D * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.E * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.F * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.G * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.H * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.I * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.J * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.K * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) (this.L + 0.5f));
            byteBufferOrder.putShort((short) (this.M + 0.5f));
            byteBufferOrder.putShort((short) this.B);
            byteBufferOrder.putShort((short) this.C);
            return bArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            b1.a(this.X);
        }

        private byte[] a(String str) throws ch {
            byte[] bArr = this.f64939k;
            if (bArr != null) {
                return bArr;
            }
            throw ch.a("Missing CodecPrivate for codec " + str, null);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:199:0x03fc  */
        /* JADX WARN: Removed duplicated region for block: B:204:0x0411  */
        /* JADX WARN: Removed duplicated region for block: B:205:0x0413  */
        /* JADX WARN: Removed duplicated region for block: B:208:0x0420  */
        /* JADX WARN: Removed duplicated region for block: B:209:0x0432  */
        /* JADX WARN: Removed duplicated region for block: B:256:0x04e7  */
        /* JADX WARN: Removed duplicated region for block: B:273:0x0537  */
        /* JADX WARN: Removed duplicated region for block: B:4:0x0015  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(com.applovin.impl.l8 r19, int r20) throws com.applovin.impl.ch {
            /*
                Method dump skipped, instruction units count: 1606
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.xc.c.a(com.applovin.impl.l8, int):void");
        }

        private static boolean b(ah ahVar) throws ch {
            try {
                int iR = ahVar.r();
                if (iR == 1) {
                    return true;
                }
                if (iR == 65534) {
                    ahVar.f(24);
                    if (ahVar.s() == xc.f64899f0.getMostSignificantBits()) {
                        if (ahVar.s() == xc.f64899f0.getLeastSignificantBits()) {
                            return true;
                        }
                    }
                }
                return false;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ch.a("Error parsing MS/ACM codec private", null);
            }
        }

        private static Pair a(ah ahVar) throws ch {
            try {
                ahVar.g(16);
                long jP = ahVar.p();
                if (jP == 1482049860) {
                    return new Pair("video/divx", null);
                }
                if (jP == 859189832) {
                    return new Pair("video/3gpp", null);
                }
                if (jP == 826496599) {
                    byte[] bArrC = ahVar.c();
                    for (int iD = ahVar.d() + 20; iD < bArrC.length - 4; iD++) {
                        if (bArrC[iD] == 0 && bArrC[iD + 1] == 0 && bArrC[iD + 2] == 1 && bArrC[iD + 3] == 15) {
                            return new Pair("video/wvc1", Collections.singletonList(Arrays.copyOfRange(bArrC, iD, bArrC.length)));
                        }
                    }
                    throw ch.a("Failed to find FourCC VC1 initialization data", null);
                }
                oc.d("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair("video/x-unknown", null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ch.a("Error parsing FourCC private data", null);
            }
        }

        private static List a(byte[] bArr) throws ch {
            int i3;
            int i4;
            try {
                if (bArr[0] == 2) {
                    int i5 = 0;
                    int i6 = 1;
                    while (true) {
                        i3 = bArr[i6] & 255;
                        if (i3 != 255) {
                            break;
                        }
                        i5 += 255;
                        i6++;
                    }
                    int i7 = i6 + 1;
                    int i8 = i5 + i3;
                    int i9 = 0;
                    while (true) {
                        i4 = bArr[i7] & 255;
                        if (i4 != 255) {
                            break;
                        }
                        i9 += 255;
                        i7++;
                    }
                    int i10 = i7 + 1;
                    int i11 = i9 + i4;
                    if (bArr[i10] == 1) {
                        byte[] bArr2 = new byte[i8];
                        System.arraycopy(bArr, i10, bArr2, 0, i8);
                        int i12 = i10 + i8;
                        if (bArr[i12] == 3) {
                            int i13 = i12 + i11;
                            if (bArr[i13] == 5) {
                                byte[] bArr3 = new byte[bArr.length - i13];
                                System.arraycopy(bArr, i13, bArr3, 0, bArr.length - i13);
                                ArrayList arrayList = new ArrayList(2);
                                arrayList.add(bArr2);
                                arrayList.add(bArr3);
                                return arrayList;
                            }
                            throw ch.a("Error parsing vorbis codec private", null);
                        }
                        throw ch.a("Error parsing vorbis codec private", null);
                    }
                    throw ch.a("Error parsing vorbis codec private", null);
                }
                throw ch.a("Error parsing vorbis codec private", null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ch.a("Error parsing vorbis codec private", null);
            }
        }
    }

    static {
        HashMap map = new HashMap();
        map.put("htc_video_rotA-000", 0);
        map.put("htc_video_rotA-090", 90);
        map.put("htc_video_rotA-180", Integer.valueOf(SensibleDefaults.X_OFFSET));
        map.put("htc_video_rotA-270", 270);
        f64900g0 = Collections.unmodifiableMap(map);
    }

    public xc() {
        this(0);
    }

    private void b(int i3) throws ch {
        if (this.f64922u != null) {
            return;
        }
        throw ch.a("Element " + i3 + " must be in a TrackEntry", null);
    }

    private c d(int i3) throws ch {
        b(i3);
        return this.f64922u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ j8[] g() {
        return new j8[]{new xc()};
    }

    private void h() {
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = false;
        this.V = false;
        this.W = false;
        this.X = 0;
        this.Y = (byte) 0;
        this.Z = false;
        this.f64911j.d(0);
    }

    @Override // com.applovin.impl.j8
    public final void a() {
    }

    protected void c(int i3) throws ch {
        e();
        if (i3 == 160) {
            if (this.G != 2) {
                return;
            }
            int i4 = 0;
            for (int i5 = 0; i5 < this.K; i5++) {
                i4 += this.L[i5];
            }
            c cVar = (c) this.f64904c.get(this.M);
            cVar.a();
            int i6 = 0;
            while (i6 < this.K) {
                long j3 = this.H + ((long) ((cVar.f64933e * i6) / 1000));
                int i7 = this.O;
                if (i6 == 0 && !this.Q) {
                    i7 |= 1;
                }
                int i8 = this.L[i6];
                int i9 = i4 - i8;
                a(cVar, j3, i7, i8, i9);
                i6++;
                i4 = i9;
            }
            this.G = 0;
            return;
        }
        if (i3 == 174) {
            c cVar2 = (c) b1.b(this.f64922u);
            String str = cVar2.f64930b;
            if (str == null) {
                throw ch.a("CodecId is missing in TrackEntry element", null);
            }
            if (a(str)) {
                cVar2.a(this.f64902a0, cVar2.f64931c);
                this.f64904c.put(cVar2.f64931c, cVar2);
            }
            this.f64922u = null;
            return;
        }
        if (i3 == 19899) {
            int i10 = this.f64924w;
            if (i10 != -1) {
                long j4 = this.f64925x;
                if (j4 != -1) {
                    if (i10 == 475249515) {
                        this.f64927z = j4;
                        return;
                    }
                    return;
                }
            }
            throw ch.a("Mandatory element SeekID or SeekPosition not found", null);
        }
        if (i3 == 25152) {
            b(i3);
            c cVar3 = this.f64922u;
            if (cVar3.f64936h) {
                if (cVar3.f64938j == null) {
                    throw ch.a("Encrypted Track found but ContentEncKeyID was not found", null);
                }
                cVar3.f64940l = new x6(new x6.b(t2.f63860a, "video/webm", this.f64922u.f64938j.f62661b));
                return;
            }
            return;
        }
        if (i3 == 28032) {
            b(i3);
            c cVar4 = this.f64922u;
            if (cVar4.f64936h && cVar4.f64937i != null) {
                throw ch.a("Combining encryption and compression is not supported", null);
            }
            return;
        }
        if (i3 == 357149030) {
            if (this.f64919r == -9223372036854775807L) {
                this.f64919r = 1000000L;
            }
            long j5 = this.f64920s;
            if (j5 != -9223372036854775807L) {
                this.f64921t = a(j5);
                return;
            }
            return;
        }
        if (i3 == 374648427) {
            if (this.f64904c.size() == 0) {
                throw ch.a("No valid tracks were found", null);
            }
            this.f64902a0.c();
        } else {
            if (i3 != 475249515) {
                return;
            }
            if (!this.f64923v) {
                this.f64902a0.a(a(this.C, this.D));
                this.f64923v = true;
            }
            this.C = null;
            this.D = null;
        }
    }

    protected int e(int i3) {
        switch (i3) {
            case 131:
            case 136:
            case ModuleDescriptor.MODULE_VERSION /* 155 */:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 238:
            case 241:
            case 251:
            case 16871:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 21998:
            case 22186:
            case 22203:
            case 25188:
            case 30321:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 21358:
            case 2274716:
                return 3;
            case 160:
            case 166:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 16868:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30113:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 165:
            case 16877:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
            case 30323:
            case 30324:
            case 30325:
                return 5;
            default:
                return 0;
        }
    }

    protected boolean f(int i3) {
        return i3 == 357149030 || i3 == 524531317 || i3 == 475249515 || i3 == 374648427;
    }

    public xc(int i3) {
        this(new z5(), i3);
    }

    private void a(int i3) throws ch {
        if (this.C == null || this.D == null) {
            throw ch.a("Element " + i3 + " must be in a Cues", null);
        }
    }

    private void e() {
        b1.b(this.f64902a0);
    }

    private int f() {
        int i3 = this.S;
        h();
        return i3;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f64955a = new byte[10];

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f64956b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f64957c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f64958d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f64959e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f64960f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f64961g;

        public void a(c cVar) {
            if (this.f64957c > 0) {
                cVar.X.a(this.f64958d, this.f64959e, this.f64960f, this.f64961g, cVar.f64938j);
                this.f64957c = 0;
            }
        }

        public void a() {
            this.f64956b = false;
            this.f64957c = 0;
        }

        public void a(c cVar, long j3, int i3, int i4, int i5) {
            if (this.f64956b) {
                int i6 = this.f64957c;
                int i7 = i6 + 1;
                this.f64957c = i7;
                if (i6 == 0) {
                    this.f64958d = j3;
                    this.f64959e = i3;
                    this.f64960f = 0;
                }
                this.f64960f += i4;
                this.f64961g = i5;
                if (i7 >= 16) {
                    a(cVar);
                }
            }
        }

        public void a(k8 k8Var) {
            if (this.f64956b) {
                return;
            }
            k8Var.c(this.f64955a, 0, 10);
            k8Var.b();
            if (k.b(this.f64955a) == 0) {
                return;
            }
            this.f64956b = true;
        }
    }

    xc(o7 o7Var, int i3) {
        this.f64918q = -1L;
        this.f64919r = -9223372036854775807L;
        this.f64920s = -9223372036854775807L;
        this.f64921t = -9223372036854775807L;
        this.f64927z = -1L;
        this.A = -1L;
        this.B = -9223372036854775807L;
        this.f64901a = o7Var;
        o7Var.a(new b());
        this.f64905d = (i3 & 1) == 0;
        this.f64903b = new zp();
        this.f64904c = new SparseArray();
        this.f64908g = new ah(4);
        this.f64909h = new ah(ByteBuffer.allocate(4).putInt(-1).array());
        this.f64910i = new ah(4);
        this.f64906e = new ah(yf.f65192a);
        this.f64907f = new ah(4);
        this.f64911j = new ah();
        this.f64912k = new ah();
        this.f64913l = new ah(8);
        this.f64914m = new ah();
        this.f64915n = new ah();
        this.L = new int[1];
    }

    protected void a(int i3, int i4, k8 k8Var) throws ch {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        long j3;
        int i11;
        int i12;
        int i13;
        k8 k8Var2 = k8Var;
        int i14 = 1;
        int i15 = 0;
        if (i3 != 161 && i3 != 163) {
            if (i3 == 165) {
                if (this.G != 2) {
                    return;
                }
                a((c) this.f64904c.get(this.M), this.P, k8Var2, i4);
                return;
            }
            if (i3 == 16877) {
                a(d(i3), k8Var2, i4);
                return;
            }
            if (i3 == 16981) {
                b(i3);
                byte[] bArr = new byte[i4];
                this.f64922u.f64937i = bArr;
                k8Var2.d(bArr, 0, i4);
                return;
            }
            if (i3 == 18402) {
                byte[] bArr2 = new byte[i4];
                k8Var2.d(bArr2, 0, i4);
                d(i3).f64938j = new qo.a(1, bArr2, 0, 0);
                return;
            }
            if (i3 == 21419) {
                Arrays.fill(this.f64910i.c(), (byte) 0);
                k8Var2.d(this.f64910i.c(), 4 - i4, i4);
                this.f64910i.f(0);
                this.f64924w = (int) this.f64910i.y();
                return;
            }
            if (i3 == 25506) {
                b(i3);
                byte[] bArr3 = new byte[i4];
                this.f64922u.f64939k = bArr3;
                k8Var2.d(bArr3, 0, i4);
                return;
            }
            if (i3 == 30322) {
                b(i3);
                byte[] bArr4 = new byte[i4];
                this.f64922u.f64950v = bArr4;
                k8Var2.d(bArr4, 0, i4);
                return;
            }
            throw ch.a("Unexpected id: " + i3, null);
        }
        int i16 = 8;
        if (this.G == 0) {
            this.M = (int) this.f64903b.a(k8Var2, false, true, 8);
            this.N = this.f64903b.a();
            this.I = -9223372036854775807L;
            this.G = 1;
            this.f64908g.d(0);
        }
        c cVar = (c) this.f64904c.get(this.M);
        if (cVar != null) {
            cVar.a();
            if (this.G == 1) {
                a(k8Var2, 3);
                int i17 = (this.f64908g.c()[2] & 6) >> 1;
                if (i17 == 0) {
                    this.K = 1;
                    int[] iArrA = a(this.L, 1);
                    this.L = iArrA;
                    iArrA[0] = (i4 - this.N) - 3;
                } else {
                    a(k8Var2, 4);
                    int i18 = (this.f64908g.c()[3] & 255) + 1;
                    this.K = i18;
                    int[] iArrA2 = a(this.L, i18);
                    this.L = iArrA2;
                    if (i17 == 2) {
                        int i19 = (i4 - this.N) - 4;
                        int i20 = this.K;
                        Arrays.fill(iArrA2, 0, i20, i19 / i20);
                    } else {
                        if (i17 != 1) {
                            if (i17 == 3) {
                                int i21 = 0;
                                int i22 = 0;
                                int i23 = 4;
                                while (true) {
                                    int i24 = this.K - i14;
                                    if (i21 < i24) {
                                        this.L[i21] = i15;
                                        int i25 = i23 + 1;
                                        a(k8Var2, i25);
                                        int i26 = i14;
                                        if (this.f64908g.c()[i23] == 0) {
                                            throw ch.a("No valid varint length mask found", null);
                                        }
                                        int i27 = i15;
                                        while (true) {
                                            if (i27 >= i16) {
                                                i8 = i15;
                                                i9 = i16;
                                                i10 = i21;
                                                j3 = 0;
                                                break;
                                            }
                                            i9 = i16;
                                            int i28 = i26 << (7 - i27);
                                            i8 = i15;
                                            if ((this.f64908g.c()[i23] & i28) != 0) {
                                                int i29 = i25 + i27;
                                                a(k8Var2, i29);
                                                j3 = this.f64908g.c()[i23] & 255 & (~i28);
                                                while (i25 < i29) {
                                                    j3 = (j3 << i9) | ((long) (this.f64908g.c()[i25] & 255));
                                                    i25++;
                                                    i21 = i21;
                                                }
                                                i10 = i21;
                                                if (i10 > 0) {
                                                    j3 -= (1 << ((i27 * 7) + 6)) - 1;
                                                    i23 = i29;
                                                } else {
                                                    i25 = i29;
                                                }
                                            } else {
                                                i27++;
                                                k8Var2 = k8Var;
                                                i15 = i8;
                                                i16 = i9;
                                            }
                                        }
                                        i23 = i25;
                                        if (j3 < -2147483648L || j3 > 2147483647L) {
                                            break;
                                        }
                                        int i30 = (int) j3;
                                        int[] iArr = this.L;
                                        if (i10 != 0) {
                                            i30 += iArr[i10 - 1];
                                        }
                                        iArr[i10] = i30;
                                        i22 += i30;
                                        i21 = i10 + 1;
                                        k8Var2 = k8Var;
                                        i14 = i26;
                                        i15 = i8;
                                        i16 = i9;
                                    } else {
                                        i6 = i14;
                                        i7 = i15;
                                        this.L[i24] = ((i4 - this.N) - i23) - i22;
                                        break;
                                    }
                                }
                                throw ch.a("EBML lacing sample size out of range.", null);
                            }
                            throw ch.a("Unexpected lacing value: " + i17, null);
                        }
                        int i31 = 0;
                        int i32 = 0;
                        int i33 = 4;
                        while (true) {
                            i11 = this.K - 1;
                            if (i31 >= i11) {
                                break;
                            }
                            this.L[i31] = 0;
                            while (true) {
                                i12 = i33 + 1;
                                a(k8Var2, i12);
                                int i34 = this.f64908g.c()[i33] & 255;
                                int[] iArr2 = this.L;
                                i13 = iArr2[i31] + i34;
                                iArr2[i31] = i13;
                                if (i34 != 255) {
                                    break;
                                } else {
                                    i33 = i12;
                                }
                            }
                            i32 += i13;
                            i31++;
                            i33 = i12;
                        }
                        this.L[i11] = ((i4 - this.N) - i33) - i32;
                    }
                }
                i6 = 1;
                i7 = 0;
                this.H = this.B + a((this.f64908g.c()[i7] << 8) | (this.f64908g.c()[i6] & 255));
                this.O = (cVar.f64932d == 2 || (i3 == 163 && (this.f64908g.c()[2] & 128) == 128)) ? i6 : i7;
                this.G = 2;
                this.J = i7;
                i5 = 163;
            } else {
                i5 = 163;
            }
            if (i3 == i5) {
                while (true) {
                    int i35 = this.J;
                    if (i35 < this.K) {
                        int iA = a(k8Var, cVar, this.L[i35]);
                        c cVar2 = cVar;
                        a(cVar2, this.H + ((long) ((this.J * cVar.f64933e) / 1000)), this.O, iA, 0);
                        this.J++;
                        cVar = cVar2;
                    } else {
                        this.G = 0;
                        return;
                    }
                }
            } else {
                while (true) {
                    int i36 = this.J;
                    if (i36 >= this.K) {
                        return;
                    }
                    int[] iArr3 = this.L;
                    iArr3[i36] = a(k8Var, cVar, iArr3[i36]);
                    this.J++;
                }
            }
        } else {
            k8Var2.a(i4 - this.N);
            this.G = 0;
        }
    }

    private ij a(qc qcVar, qc qcVar2) {
        int i3;
        if (this.f64918q != -1 && this.f64921t != -9223372036854775807L && qcVar != null && qcVar.a() != 0 && qcVar2 != null && qcVar2.a() == qcVar.a()) {
            int iA = qcVar.a();
            int[] iArrCopyOf = new int[iA];
            long[] jArrCopyOf = new long[iA];
            long[] jArrCopyOf2 = new long[iA];
            long[] jArrCopyOf3 = new long[iA];
            int i4 = 0;
            for (int i5 = 0; i5 < iA; i5++) {
                jArrCopyOf3[i5] = qcVar.a(i5);
                jArrCopyOf[i5] = this.f64918q + qcVar2.a(i5);
            }
            while (true) {
                i3 = iA - 1;
                if (i4 >= i3) {
                    break;
                }
                int i6 = i4 + 1;
                iArrCopyOf[i4] = (int) (jArrCopyOf[i6] - jArrCopyOf[i4]);
                jArrCopyOf2[i4] = jArrCopyOf3[i6] - jArrCopyOf3[i4];
                i4 = i6;
            }
            iArrCopyOf[i3] = (int) ((this.f64918q + this.f64917p) - jArrCopyOf[i3]);
            long j3 = this.f64921t - jArrCopyOf3[i3];
            jArrCopyOf2[i3] = j3;
            if (j3 <= 0) {
                oc.d("MatroskaExtractor", MHoiDDglUlPJC.gAoDFdSZNbn + j3);
                iArrCopyOf = Arrays.copyOf(iArrCopyOf, i3);
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i3);
                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i3);
                jArrCopyOf3 = Arrays.copyOf(jArrCopyOf3, i3);
            }
            return new g3(iArrCopyOf, jArrCopyOf, jArrCopyOf2, jArrCopyOf3);
        }
        return new ij.b(this.f64921t);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a4 A[PHI: r13
      0x00a4: PHI (r13v4 int) = (r13v3 int), (r13v6 int) binds: [B:25:0x0088, B:30:0x0095] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.applovin.impl.xc.c r9, long r10, int r12, int r13, int r14) {
        /*
            r8 = this;
            com.applovin.impl.xc$d r0 = r9.T
            r7 = 1
            if (r0 == 0) goto Lf
            r1 = r9
            r2 = r10
            r4 = r12
            r5 = r13
            r6 = r14
            r0.a(r1, r2, r4, r5, r6)
            goto Lb1
        Lf:
            r1 = r9
            r2 = r10
            r4 = r12
            r5 = r13
            r6 = r14
            java.lang.String r9 = r1.f64930b
            java.lang.String r10 = "S_TEXT/UTF8"
            boolean r9 = r10.equals(r9)
            if (r9 != 0) goto L28
            java.lang.String r9 = r1.f64930b
            java.lang.String r10 = "S_TEXT/ASS"
            boolean r9 = r10.equals(r9)
            if (r9 == 0) goto L44
        L28:
            int r9 = r8.K
            java.lang.String r10 = "MatroskaExtractor"
            if (r9 <= r7) goto L34
            java.lang.String r9 = "Skipping subtitle sample in laced block."
            com.applovin.impl.oc.d(r10, r9)
            goto L44
        L34:
            long r11 = r8.I
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r9 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r9 != 0) goto L46
            java.lang.String r9 = "Skipping subtitle sample with no duration."
            com.applovin.impl.oc.d(r10, r9)
        L44:
            r13 = r5
            goto L85
        L46:
            java.lang.String r9 = r1.f64930b
            com.applovin.impl.ah r10 = r8.f64912k
            byte[] r10 = r10.c()
            a(r9, r11, r10)
            com.applovin.impl.ah r9 = r8.f64912k
            int r9 = r9.d()
        L57:
            com.applovin.impl.ah r10 = r8.f64912k
            int r10 = r10.e()
            if (r9 >= r10) goto L72
            com.applovin.impl.ah r10 = r8.f64912k
            byte[] r10 = r10.c()
            r10 = r10[r9]
            if (r10 != 0) goto L6f
            com.applovin.impl.ah r10 = r8.f64912k
            r10.e(r9)
            goto L72
        L6f:
            int r9 = r9 + 1
            goto L57
        L72:
            com.applovin.impl.qo r9 = r1.X
            com.applovin.impl.ah r10 = r8.f64912k
            int r11 = r10.e()
            r9.a(r10, r11)
            com.applovin.impl.ah r9 = r8.f64912k
            int r9 = r9.e()
            int r13 = r5 + r9
        L85:
            r9 = 268435456(0x10000000, float:2.524355E-29)
            r9 = r9 & r4
            if (r9 == 0) goto La4
            int r9 = r8.K
            if (r9 <= r7) goto L95
            r9 = -268435457(0xffffffffefffffff, float:-1.5845632E29)
            r12 = r4 & r9
        L93:
            r4 = r13
            goto La6
        L95:
            com.applovin.impl.ah r9 = r8.f64915n
            int r9 = r9.e()
            com.applovin.impl.qo r10 = r1.X
            com.applovin.impl.ah r11 = r8.f64915n
            r12 = 2
            r10.a(r11, r9, r12)
            int r13 = r13 + r9
        La4:
            r12 = r4
            goto L93
        La6:
            com.applovin.impl.qo r0 = r1.X
            com.applovin.impl.qo$a r9 = r1.f64938j
            r1 = r2
            r5 = r6
            r6 = r9
            r3 = r12
            r0.a(r1, r3, r4, r5, r6)
        Lb1:
            r8.F = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.xc.a(com.applovin.impl.xc$c, long, int, int, int):void");
    }

    private static int[] a(int[] iArr, int i3) {
        if (iArr == null) {
            return new int[i3];
        }
        return iArr.length >= i3 ? iArr : new int[Math.max(iArr.length * 2, i3)];
    }

    protected void a(int i3, double d3) {
        if (i3 == 181) {
            d(i3).Q = (int) d3;
            return;
        }
        if (i3 != 17545) {
            switch (i3) {
                case 21969:
                    d(i3).D = (float) d3;
                    break;
                case 21970:
                    d(i3).E = (float) d3;
                    break;
                case 21971:
                    d(i3).F = (float) d3;
                    break;
                case 21972:
                    d(i3).G = (float) d3;
                    break;
                case 21973:
                    d(i3).H = (float) d3;
                    break;
                case 21974:
                    d(i3).I = (float) d3;
                    break;
                case 21975:
                    d(i3).J = (float) d3;
                    break;
                case 21976:
                    d(i3).K = (float) d3;
                    break;
                case 21977:
                    d(i3).L = (float) d3;
                    break;
                case 21978:
                    d(i3).M = (float) d3;
                    break;
                default:
                    switch (i3) {
                        case 30323:
                            d(i3).f64947s = (float) d3;
                            break;
                        case 30324:
                            d(i3).f64948t = (float) d3;
                            break;
                        case 30325:
                            d(i3).f64949u = (float) d3;
                            break;
                    }
                    break;
            }
            return;
        }
        this.f64920s = (long) d3;
    }

    private static byte[] a(long j3, String str, long j4) {
        b1.a(j3 != -9223372036854775807L);
        int i3 = (int) (j3 / 3600000000L);
        long j5 = j3 - (((long) (i3 * AccessTokenManager.TOKEN_EXTEND_RETRY_SECONDS)) * 1000000);
        int i4 = (int) (j5 / 60000000);
        long j6 = j5 - (((long) (i4 * 60)) * 1000000);
        int i5 = (int) (j6 / 1000000);
        return xp.c(String.format(Locale.US, str, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf((int) ((j6 - (((long) i5) * 1000000)) / j4))));
    }

    protected void a(c cVar, k8 k8Var, int i3) {
        if (cVar.f64935g != 1685485123 && cVar.f64935g != 1685480259) {
            k8Var.a(i3);
            return;
        }
        byte[] bArr = new byte[i3];
        cVar.N = bArr;
        k8Var.d(bArr, 0, i3);
    }

    protected void a(c cVar, int i3, k8 k8Var, int i4) {
        if (i3 == 4 && "V_VP9".equals(cVar.f64930b)) {
            this.f64915n.d(i4);
            k8Var.d(this.f64915n.c(), 0, i4);
        } else {
            k8Var.a(i4);
        }
    }

    @Override // com.applovin.impl.j8
    public final void a(l8 l8Var) {
        this.f64902a0 = l8Var;
    }

    protected void a(int i3, long j3) throws ch {
        if (i3 == 20529) {
            if (j3 == 0) {
                return;
            }
            throw ch.a("ContentEncodingOrder " + j3 + " not supported", null);
        }
        if (i3 == 20530) {
            if (j3 == 1) {
                return;
            }
            throw ch.a("ContentEncodingScope " + j3 + " not supported", null);
        }
        switch (i3) {
            case 131:
                d(i3).f64932d = (int) j3;
                return;
            case 136:
                d(i3).V = j3 == 1;
                return;
            case ModuleDescriptor.MODULE_VERSION /* 155 */:
                this.I = a(j3);
                return;
            case 159:
                d(i3).O = (int) j3;
                return;
            case 176:
                d(i3).f64941m = (int) j3;
                return;
            case 179:
                a(i3);
                this.C.a(a(j3));
                return;
            case 186:
                d(i3).f64942n = (int) j3;
                return;
            case 215:
                d(i3).f64931c = (int) j3;
                return;
            case 231:
                this.B = a(j3);
                return;
            case 238:
                this.P = (int) j3;
                return;
            case 241:
                if (this.E) {
                    return;
                }
                a(i3);
                this.D.a(j3);
                this.E = true;
                return;
            case 251:
                this.Q = true;
                return;
            case 16871:
                d(i3).f64935g = (int) j3;
                return;
            case 16980:
                if (j3 == 3) {
                    return;
                }
                throw ch.a("ContentCompAlgo " + j3 + " not supported", null);
            case 17029:
                if (j3 < 1 || j3 > 2) {
                    throw ch.a("DocTypeReadVersion " + j3 + " not supported", null);
                }
                return;
            case 17143:
                if (j3 == 1) {
                    return;
                }
                throw ch.a("EBMLReadVersion " + j3 + " not supported", null);
            case 18401:
                if (j3 == 5) {
                    return;
                }
                throw ch.a("ContentEncAlgo " + j3 + " not supported", null);
            case 18408:
                if (j3 == 1) {
                    return;
                }
                throw ch.a("AESSettingsCipherMode " + j3 + " not supported", null);
            case 21420:
                this.f64925x = j3 + this.f64918q;
                return;
            case 21432:
                int i4 = (int) j3;
                b(i3);
                if (i4 == 0) {
                    this.f64922u.f64951w = 0;
                    return;
                }
                if (i4 == 1) {
                    this.f64922u.f64951w = 2;
                    return;
                } else if (i4 == 3) {
                    this.f64922u.f64951w = 1;
                    return;
                } else {
                    if (i4 != 15) {
                        return;
                    }
                    this.f64922u.f64951w = 3;
                    return;
                }
            case 21680:
                d(i3).f64943o = (int) j3;
                return;
            case 21682:
                d(i3).f64945q = (int) j3;
                return;
            case 21690:
                d(i3).f64944p = (int) j3;
                return;
            case 21930:
                d(i3).U = j3 == 1;
                return;
            case 21998:
                d(i3).f64934f = (int) j3;
                return;
            case 22186:
                d(i3).R = j3;
                return;
            case 22203:
                d(i3).S = j3;
                return;
            case 25188:
                d(i3).P = (int) j3;
                return;
            case 30321:
                b(i3);
                int i5 = (int) j3;
                if (i5 == 0) {
                    this.f64922u.f64946r = 0;
                    return;
                }
                if (i5 == 1) {
                    this.f64922u.f64946r = 1;
                    return;
                } else if (i5 == 2) {
                    this.f64922u.f64946r = 2;
                    return;
                } else {
                    if (i5 != 3) {
                        return;
                    }
                    this.f64922u.f64946r = 3;
                    return;
                }
            case 2352003:
                d(i3).f64933e = (int) j3;
                return;
            case 2807729:
                this.f64919r = j3;
                return;
            default:
                switch (i3) {
                    case 21945:
                        b(i3);
                        int i6 = (int) j3;
                        if (i6 == 1) {
                            this.f64922u.A = 2;
                            return;
                        } else {
                            if (i6 != 2) {
                                return;
                            }
                            this.f64922u.A = 1;
                            return;
                        }
                    case 21946:
                        b(i3);
                        int iB = r3.b((int) j3);
                        if (iB != -1) {
                            this.f64922u.f64954z = iB;
                            return;
                        }
                        return;
                    case 21947:
                        b(i3);
                        this.f64922u.f64952x = true;
                        int iA = r3.a((int) j3);
                        if (iA != -1) {
                            this.f64922u.f64953y = iA;
                            return;
                        }
                        return;
                    case 21948:
                        d(i3).B = (int) j3;
                        return;
                    case 21949:
                        d(i3).C = (int) j3;
                        return;
                    default:
                        return;
                }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static boolean a(String str) {
        str.getClass();
        byte b3 = -1;
        switch (str.hashCode()) {
            case -2095576542:
                if (str.equals("V_MPEG4/ISO/AP")) {
                    b3 = 0;
                }
                break;
            case -2095575984:
                if (str.equals("V_MPEG4/ISO/SP")) {
                    b3 = 1;
                }
                break;
            case -1985379776:
                if (str.equals("A_MS/ACM")) {
                    b3 = 2;
                }
                break;
            case -1784763192:
                if (str.equals("A_TRUEHD")) {
                    b3 = 3;
                }
                break;
            case -1730367663:
                if (str.equals("A_VORBIS")) {
                    b3 = 4;
                }
                break;
            case -1482641358:
                if (str.equals("A_MPEG/L2")) {
                    b3 = 5;
                }
                break;
            case -1482641357:
                if (str.equals("A_MPEG/L3")) {
                    b3 = 6;
                }
                break;
            case -1373388978:
                if (str.equals("V_MS/VFW/FOURCC")) {
                    b3 = 7;
                }
                break;
            case -933872740:
                if (str.equals("S_DVBSUB")) {
                    b3 = 8;
                }
                break;
            case -538363189:
                if (str.equals("V_MPEG4/ISO/ASP")) {
                    b3 = 9;
                }
                break;
            case -538363109:
                if (str.equals("V_MPEG4/ISO/AVC")) {
                    b3 = 10;
                }
                break;
            case -425012669:
                if (str.equals("S_VOBSUB")) {
                    b3 = Ascii.VT;
                }
                break;
            case -356037306:
                if (str.equals("A_DTS/LOSSLESS")) {
                    b3 = Ascii.FF;
                }
                break;
            case 62923557:
                if (str.equals("A_AAC")) {
                    b3 = Ascii.CR;
                }
                break;
            case 62923603:
                if (str.equals("A_AC3")) {
                    b3 = Ascii.SO;
                }
                break;
            case 62927045:
                if (str.equals("A_DTS")) {
                    b3 = Ascii.SI;
                }
                break;
            case 82318131:
                if (str.equals("V_AV1")) {
                    b3 = Ascii.DLE;
                }
                break;
            case 82338133:
                if (str.equals("V_VP8")) {
                    b3 = 17;
                }
                break;
            case 82338134:
                if (str.equals("V_VP9")) {
                    b3 = Ascii.DC2;
                }
                break;
            case 99146302:
                if (str.equals("S_HDMV/PGS")) {
                    b3 = 19;
                }
                break;
            case 444813526:
                if (str.equals("V_THEORA")) {
                    b3 = Ascii.DC4;
                }
                break;
            case 542569478:
                if (str.equals("A_DTS/EXPRESS")) {
                    b3 = Ascii.NAK;
                }
                break;
            case 635596514:
                if (str.equals("A_PCM/FLOAT/IEEE")) {
                    b3 = Ascii.SYN;
                }
                break;
            case 725948237:
                if (str.equals("A_PCM/INT/BIG")) {
                    b3 = Ascii.ETB;
                }
                break;
            case 725957860:
                if (str.equals("A_PCM/INT/LIT")) {
                    b3 = Ascii.CAN;
                }
                break;
            case 738597099:
                if (str.equals("S_TEXT/ASS")) {
                    b3 = Ascii.EM;
                }
                break;
            case 855502857:
                if (str.equals("V_MPEGH/ISO/HEVC")) {
                    b3 = Ascii.SUB;
                }
                break;
            case 1422270023:
                if (str.equals("S_TEXT/UTF8")) {
                    b3 = Ascii.ESC;
                }
                break;
            case 1809237540:
                if (str.equals("V_MPEG2")) {
                    b3 = Ascii.FS;
                }
                break;
            case 1950749482:
                if (str.equals("A_EAC3")) {
                    b3 = Ascii.GS;
                }
                break;
            case 1950789798:
                if (str.equals("A_FLAC")) {
                    b3 = Ascii.RS;
                }
                break;
            case 1951062397:
                if (str.equals("A_OPUS")) {
                    b3 = Ascii.US;
                }
                break;
        }
        switch (b3) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
                return true;
            default:
                return false;
        }
    }

    private boolean a(th thVar, long j3) {
        if (this.f64926y) {
            this.A = j3;
            thVar.f63943a = this.f64927z;
            this.f64926y = false;
            return true;
        }
        if (this.f64923v) {
            long j4 = this.A;
            if (j4 != -1) {
                thVar.f63943a = j4;
                this.A = -1L;
                return true;
            }
        }
        return false;
    }

    @Override // com.applovin.impl.j8
    public final int a(k8 k8Var, th thVar) {
        this.F = false;
        boolean zA = true;
        while (zA && !this.F) {
            zA = this.f64901a.a(k8Var);
            if (zA && a(thVar, k8Var.f())) {
                return 1;
            }
        }
        if (zA) {
            return 0;
        }
        for (int i3 = 0; i3 < this.f64904c.size(); i3++) {
            c cVar = (c) this.f64904c.valueAt(i3);
            cVar.a();
            cVar.c();
        }
        return -1;
    }

    private void a(k8 k8Var, int i3) {
        if (this.f64908g.e() >= i3) {
            return;
        }
        if (this.f64908g.b() < i3) {
            ah ahVar = this.f64908g;
            ahVar.a(Math.max(ahVar.b() * 2, i3));
        }
        k8Var.d(this.f64908g.c(), this.f64908g.e(), i3 - this.f64908g.e());
        this.f64908g.e(i3);
    }

    private long a(long j3) throws ch {
        long j4 = this.f64919r;
        if (j4 != -9223372036854775807L) {
            return xp.c(j3, j4, 1000L);
        }
        throw ch.a("Can't scale timecode prior to timecodeScale being set.", null);
    }

    @Override // com.applovin.impl.j8
    public void a(long j3, long j4) {
        this.B = -9223372036854775807L;
        this.G = 0;
        this.f64901a.reset();
        this.f64903b.b();
        h();
        for (int i3 = 0; i3 < this.f64904c.size(); i3++) {
            ((c) this.f64904c.valueAt(i3)).d();
        }
    }

    private static void a(String str, long j3, byte[] bArr) {
        byte[] bArrA;
        int i3;
        str.getClass();
        if (str.equals("S_TEXT/ASS")) {
            bArrA = a(j3, "%01d:%02d:%02d:%02d", 10000L);
            i3 = 21;
        } else if (str.equals("S_TEXT/UTF8")) {
            bArrA = a(j3, "%02d:%02d:%02d,%03d", 1000L);
            i3 = 19;
        } else {
            throw new IllegalArgumentException();
        }
        System.arraycopy(bArrA, 0, bArr, i3, bArrA.length);
    }

    protected void a(int i3, long j3, long j4) throws ch {
        e();
        if (i3 == 160) {
            this.Q = false;
            return;
        }
        if (i3 == 174) {
            this.f64922u = new c();
            return;
        }
        if (i3 == 187) {
            this.E = false;
            return;
        }
        if (i3 == 19899) {
            this.f64924w = -1;
            this.f64925x = -1L;
            return;
        }
        if (i3 == 20533) {
            d(i3).f64936h = true;
            return;
        }
        if (i3 == 21968) {
            d(i3).f64952x = true;
            return;
        }
        if (i3 == 408125543) {
            long j5 = this.f64918q;
            if (j5 != -1 && j5 != j3) {
                throw ch.a("Multiple Segment elements not supported", null);
            }
            this.f64918q = j3;
            this.f64917p = j4;
            return;
        }
        if (i3 != 475249515) {
            if (i3 == 524531317 && !this.f64923v) {
                if (this.f64905d && this.f64927z != -1) {
                    this.f64926y = true;
                    return;
                } else {
                    this.f64902a0.a(new ij.b(this.f64921t));
                    this.f64923v = true;
                    return;
                }
            }
            return;
        }
        this.C = new qc();
        this.D = new qc();
    }

    protected void a(int i3, String str) throws ch {
        if (i3 == 134) {
            d(i3).f64930b = str;
            return;
        }
        if (i3 != 17026) {
            if (i3 == 21358) {
                d(i3).f64929a = str;
                return;
            } else {
                if (i3 != 2274716) {
                    return;
                }
                d(i3).W = str;
                return;
            }
        }
        if ("webm".equals(str) || "matroska".equals(str)) {
            return;
        }
        throw ch.a("DocType " + str + " not supported", null);
    }

    private int a(k8 k8Var, c cVar, int i3) throws ch {
        int i4;
        if ("S_TEXT/UTF8".equals(cVar.f64930b)) {
            a(k8Var, f64896c0, i3);
            return f();
        }
        if ("S_TEXT/ASS".equals(cVar.f64930b)) {
            a(k8Var, f64898e0, i3);
            return f();
        }
        qo qoVar = cVar.X;
        if (!this.U) {
            if (cVar.f64936h) {
                this.O &= -1073741825;
                boolean z2 = this.V;
                int i5 = ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                if (!z2) {
                    k8Var.d(this.f64908g.c(), 0, 1);
                    this.R++;
                    if ((this.f64908g.c()[0] & 128) != 128) {
                        this.Y = this.f64908g.c()[0];
                        this.V = true;
                    } else {
                        throw ch.a("Extension bit is set in signal byte", null);
                    }
                }
                byte b3 = this.Y;
                if ((b3 & 1) == 1) {
                    boolean z3 = (b3 & 2) == 2;
                    this.O |= 1073741824;
                    if (!this.Z) {
                        k8Var.d(this.f64913l.c(), 0, 8);
                        this.R += 8;
                        this.Z = true;
                        byte[] bArrC = this.f64908g.c();
                        if (!z3) {
                            i5 = 0;
                        }
                        bArrC[0] = (byte) (i5 | 8);
                        this.f64908g.f(0);
                        qoVar.a(this.f64908g, 1, 1);
                        this.S++;
                        this.f64913l.f(0);
                        qoVar.a(this.f64913l, 8, 1);
                        this.S += 8;
                    }
                    if (z3) {
                        if (!this.W) {
                            k8Var.d(this.f64908g.c(), 0, 1);
                            this.R++;
                            this.f64908g.f(0);
                            this.X = this.f64908g.w();
                            this.W = true;
                        }
                        int i6 = this.X * 4;
                        this.f64908g.d(i6);
                        k8Var.d(this.f64908g.c(), 0, i6);
                        this.R += i6;
                        short s2 = (short) ((this.X / 2) + 1);
                        int i7 = (s2 * 6) + 2;
                        ByteBuffer byteBuffer = this.f64916o;
                        if (byteBuffer == null || byteBuffer.capacity() < i7) {
                            this.f64916o = ByteBuffer.allocate(i7);
                        }
                        this.f64916o.position(0);
                        this.f64916o.putShort(s2);
                        int i8 = 0;
                        int i9 = 0;
                        while (true) {
                            i4 = this.X;
                            if (i8 >= i4) {
                                break;
                            }
                            int iA = this.f64908g.A();
                            if (i8 % 2 == 0) {
                                this.f64916o.putShort((short) (iA - i9));
                            } else {
                                this.f64916o.putInt(iA - i9);
                            }
                            i8++;
                            i9 = iA;
                        }
                        int i10 = (i3 - this.R) - i9;
                        if (i4 % 2 == 1) {
                            this.f64916o.putInt(i10);
                        } else {
                            this.f64916o.putShort((short) i10);
                            this.f64916o.putInt(0);
                        }
                        this.f64914m.a(this.f64916o.array(), i7);
                        qoVar.a(this.f64914m, i7, 1);
                        this.S += i7;
                    }
                }
            } else {
                byte[] bArr = cVar.f64937i;
                if (bArr != null) {
                    this.f64911j.a(bArr, bArr.length);
                }
            }
            if (cVar.f64934f > 0) {
                this.O |= 268435456;
                this.f64915n.d(0);
                this.f64908g.d(4);
                this.f64908g.c()[0] = (byte) ((i3 >> 24) & 255);
                this.f64908g.c()[1] = (byte) ((i3 >> 16) & 255);
                this.f64908g.c()[2] = (byte) ((i3 >> 8) & 255);
                this.f64908g.c()[3] = (byte) (i3 & 255);
                qoVar.a(this.f64908g, 4, 2);
                this.S += 4;
            }
            this.U = true;
        }
        int iE = i3 + this.f64911j.e();
        if (!"V_MPEG4/ISO/AVC".equals(cVar.f64930b) && !"V_MPEGH/ISO/HEVC".equals(cVar.f64930b)) {
            if (cVar.T != null) {
                b1.b(this.f64911j.e() == 0);
                cVar.T.a(k8Var);
            }
            while (true) {
                int i11 = this.R;
                if (i11 >= iE) {
                    break;
                }
                int iA2 = a(k8Var, qoVar, iE - i11);
                this.R += iA2;
                this.S += iA2;
            }
        } else {
            byte[] bArrC2 = this.f64907f.c();
            bArrC2[0] = 0;
            bArrC2[1] = 0;
            bArrC2[2] = 0;
            int i12 = cVar.Y;
            int i13 = 4 - i12;
            while (this.R < iE) {
                int i14 = this.T;
                if (i14 == 0) {
                    a(k8Var, bArrC2, i13, i12);
                    this.R += i12;
                    this.f64907f.f(0);
                    this.T = this.f64907f.A();
                    this.f64906e.f(0);
                    qoVar.a(this.f64906e, 4);
                    this.S += 4;
                } else {
                    int iA3 = a(k8Var, qoVar, i14);
                    this.R += iA3;
                    this.S += iA3;
                    this.T -= iA3;
                }
            }
        }
        if ("A_VORBIS".equals(cVar.f64930b)) {
            this.f64909h.f(0);
            qoVar.a(this.f64909h, 4);
            this.S += 4;
        }
        return f();
    }

    private void a(k8 k8Var, byte[] bArr, int i3) {
        int length = bArr.length + i3;
        if (this.f64912k.b() < length) {
            this.f64912k.a(Arrays.copyOf(bArr, length + i3));
        } else {
            System.arraycopy(bArr, 0, this.f64912k.c(), 0, bArr.length);
        }
        k8Var.d(this.f64912k.c(), bArr.length, i3);
        this.f64912k.f(0);
        this.f64912k.e(length);
    }

    private int a(k8 k8Var, qo qoVar, int i3) {
        int iA = this.f64911j.a();
        if (iA > 0) {
            int iMin = Math.min(i3, iA);
            qoVar.a(this.f64911j, iMin);
            return iMin;
        }
        return qoVar.a((f5) k8Var, i3, false);
    }

    private void a(k8 k8Var, byte[] bArr, int i3, int i4) {
        int iMin = Math.min(i4, this.f64911j.a());
        k8Var.d(bArr, i3 + iMin, i4 - iMin);
        if (iMin > 0) {
            this.f64911j.a(bArr, i3, iMin);
        }
    }

    @Override // com.applovin.impl.j8
    public final boolean a(k8 k8Var) {
        return new mk().b(k8Var);
    }
}
