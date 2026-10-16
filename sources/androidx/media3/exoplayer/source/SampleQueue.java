package androidx.media3.exoplayer.source;

import androidx.media3.common.DataReader;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.source.SampleQueue;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.extractor.TrackOutput;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class SampleQueue implements TrackOutput {
    private Format A;
    private Format B;
    private long C;
    private boolean E;
    private long F;
    private boolean G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SampleDataQueue f44878a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final DrmSessionManager f44881d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final DrmSessionEventListener.EventDispatcher f44882e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private UpstreamFormatChangedListener f44883f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Format f44884g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private DrmSession f44885h;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f44893p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f44894q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f44895r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f44896s;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f44900w;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f44903z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SampleExtrasHolder f44879b = new SampleExtrasHolder();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f44886i = 1000;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long[] f44887j = new long[1000];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long[] f44888k = new long[1000];

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long[] f44891n = new long[1000];

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int[] f44890m = new int[1000];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int[] f44889l = new int[1000];

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private TrackOutput.CryptoData[] f44892o = new TrackOutput.CryptoData[1000];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SpannedData f44880c = new SpannedData(new Consumer() { // from class: androidx.media3.exoplayer.source.g0
        @Override // androidx.media3.common.util.Consumer
        public final void accept(Object obj) {
            ((SampleQueue.SharedSampleMetadata) obj).f44908b.release();
        }
    });

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f44897t = Long.MIN_VALUE;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f44898u = Long.MIN_VALUE;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f44899v = Long.MIN_VALUE;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f44902y = true;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f44901x = true;
    private boolean D = true;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SampleExtrasHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f44904a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f44905b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public TrackOutput.CryptoData f44906c;

        SampleExtrasHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SharedSampleMetadata {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Format f44907a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DrmSessionManager.DrmSessionReference f44908b;

        private SharedSampleMetadata(Format format, DrmSessionManager.DrmSessionReference drmSessionReference) {
            this.f44907a = format;
            this.f44908b = drmSessionReference;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface UpstreamFormatChangedListener {
        void h(Format format);
    }

    protected SampleQueue(Allocator allocator, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        this.f44881d = drmSessionManager;
        this.f44882e = eventDispatcher;
        this.f44878a = new SampleDataQueue(allocator);
    }

    private int B(int i3) {
        int i4 = this.f44895r + i3;
        int i5 = this.f44886i;
        return i4 < i5 ? i4 : i4 - i5;
    }

    private boolean F() {
        return this.f44896s != this.f44893p;
    }

    private boolean J(int i3) {
        DrmSession drmSession = this.f44885h;
        if (drmSession == null || drmSession.getState() == 4) {
            return true;
        }
        return (this.f44890m[i3] & 1073741824) == 0 && this.f44885h.b();
    }

    private void L(Format format, FormatHolder formatHolder) {
        Format format2 = this.f44884g;
        boolean z2 = format2 == null;
        DrmInitData drmInitData = format2 == null ? null : format2.f40636s;
        this.f44884g = format;
        DrmInitData drmInitData2 = format.f40636s;
        DrmSessionManager drmSessionManager = this.f44881d;
        formatHolder.f43108b = drmSessionManager != null ? format.c(drmSessionManager.c(format)) : format;
        formatHolder.f43107a = this.f44885h;
        if (this.f44881d == null) {
            return;
        }
        if (z2 || !Objects.equals(drmInitData, drmInitData2)) {
            DrmSession drmSession = this.f44885h;
            DrmSession drmSessionB = this.f44881d.b(this.f44882e, format);
            this.f44885h = drmSessionB;
            formatHolder.f43107a = drmSessionB;
            if (drmSession != null) {
                drmSession.g(this.f44882e);
            }
        }
    }

    private synchronized int M(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z2, boolean z3, SampleExtrasHolder sampleExtrasHolder) {
        try {
            decoderInputBuffer.f42139f = false;
            if (!F()) {
                if (!z3 && !this.f44900w) {
                    Format format = this.B;
                    if (format == null || (!z2 && format == this.f44884g)) {
                        return -3;
                    }
                    L((Format) Assertions.e(format), formatHolder);
                    return -5;
                }
                decoderInputBuffer.n(4);
                decoderInputBuffer.f42140g = Long.MIN_VALUE;
                return -4;
            }
            Format format2 = ((SharedSampleMetadata) this.f44880c.e(A())).f44907a;
            if (!z2 && format2 == this.f44884g) {
                int iB = B(this.f44896s);
                if (!J(iB)) {
                    decoderInputBuffer.f42139f = true;
                    return -3;
                }
                decoderInputBuffer.n(this.f44890m[iB]);
                if (this.f44896s == this.f44893p - 1 && (z3 || this.f44900w)) {
                    decoderInputBuffer.e(536870912);
                }
                decoderInputBuffer.f42140g = this.f44891n[iB];
                sampleExtrasHolder.f44904a = this.f44889l[iB];
                sampleExtrasHolder.f44905b = this.f44888k[iB];
                sampleExtrasHolder.f44906c = this.f44892o[iB];
                return -4;
            }
            L(format2, formatHolder);
            return -5;
        } catch (Throwable th) {
            throw th;
        }
    }

    private void Q() {
        DrmSession drmSession = this.f44885h;
        if (drmSession != null) {
            drmSession.g(this.f44882e);
            this.f44885h = null;
            this.f44884g = null;
        }
    }

    private synchronized void T() {
        this.f44896s = 0;
        this.f44878a.o();
    }

    private synchronized boolean Y(Format format) {
        try {
            this.f44902y = false;
            if (Objects.equals(format, this.B)) {
                return false;
            }
            if (this.f44880c.g() || !((SharedSampleMetadata) this.f44880c.f()).f44907a.equals(format)) {
                this.B = format;
            } else {
                this.B = ((SharedSampleMetadata) this.f44880c.f()).f44907a;
            }
            boolean z2 = this.D;
            Format format2 = this.B;
            this.D = z2 & MimeTypes.a(format2.f40632o, format2.f40628k);
            this.E = false;
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized boolean i(long j3) {
        if (this.f44893p == 0) {
            return j3 > this.f44898u;
        }
        if (y() >= j3) {
            return false;
        }
        r(this.f44894q + k(j3));
        return true;
    }

    private synchronized void j(long j3, int i3, long j4, int i4, TrackOutput.CryptoData cryptoData) {
        try {
            int i5 = this.f44893p;
            if (i5 > 0) {
                int iB = B(i5 - 1);
                Assertions.a(this.f44888k[iB] + ((long) this.f44889l[iB]) <= j4);
            }
            this.f44900w = (536870912 & i3) != 0;
            this.f44899v = Math.max(this.f44899v, j3);
            int iB2 = B(this.f44893p);
            this.f44891n[iB2] = j3;
            this.f44888k[iB2] = j4;
            this.f44889l[iB2] = i4;
            this.f44890m[iB2] = i3;
            this.f44892o[iB2] = cryptoData;
            this.f44887j[iB2] = this.C;
            if (this.f44880c.g() || !((SharedSampleMetadata) this.f44880c.f()).f44907a.equals(this.B)) {
                Format format = (Format) Assertions.e(this.B);
                DrmSessionManager drmSessionManager = this.f44881d;
                this.f44880c.a(E(), new SharedSampleMetadata(format, drmSessionManager != null ? drmSessionManager.d(this.f44882e, format) : DrmSessionManager.DrmSessionReference.f44062a));
            }
            int i6 = this.f44893p + 1;
            this.f44893p = i6;
            int i7 = this.f44886i;
            if (i6 == i7) {
                int i8 = i7 + 1000;
                long[] jArr = new long[i8];
                long[] jArr2 = new long[i8];
                long[] jArr3 = new long[i8];
                int[] iArr = new int[i8];
                int[] iArr2 = new int[i8];
                TrackOutput.CryptoData[] cryptoDataArr = new TrackOutput.CryptoData[i8];
                int i9 = this.f44895r;
                int i10 = i7 - i9;
                System.arraycopy(this.f44888k, i9, jArr2, 0, i10);
                System.arraycopy(this.f44891n, this.f44895r, jArr3, 0, i10);
                System.arraycopy(this.f44890m, this.f44895r, iArr, 0, i10);
                System.arraycopy(this.f44889l, this.f44895r, iArr2, 0, i10);
                System.arraycopy(this.f44892o, this.f44895r, cryptoDataArr, 0, i10);
                System.arraycopy(this.f44887j, this.f44895r, jArr, 0, i10);
                int i11 = this.f44895r;
                System.arraycopy(this.f44888k, 0, jArr2, i10, i11);
                System.arraycopy(this.f44891n, 0, jArr3, i10, i11);
                System.arraycopy(this.f44890m, 0, iArr, i10, i11);
                System.arraycopy(this.f44889l, 0, iArr2, i10, i11);
                System.arraycopy(this.f44892o, 0, cryptoDataArr, i10, i11);
                System.arraycopy(this.f44887j, 0, jArr, i10, i11);
                this.f44888k = jArr2;
                this.f44891n = jArr3;
                this.f44890m = iArr;
                this.f44889l = iArr2;
                this.f44892o = cryptoDataArr;
                this.f44887j = jArr;
                this.f44895r = 0;
                this.f44886i = i8;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private int k(long j3) {
        int i3 = this.f44893p;
        int iB = B(i3 - 1);
        while (i3 > this.f44896s && this.f44891n[iB] >= j3) {
            i3--;
            iB--;
            if (iB == -1) {
                iB = this.f44886i - 1;
            }
        }
        return i3;
    }

    public static SampleQueue l(Allocator allocator, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        return new SampleQueue(allocator, (DrmSessionManager) Assertions.e(drmSessionManager), (DrmSessionEventListener.EventDispatcher) Assertions.e(eventDispatcher));
    }

    private synchronized long m(long j3, boolean z2, boolean z3) throws Throwable {
        Throwable th;
        try {
            try {
                int i3 = this.f44893p;
                if (i3 != 0) {
                    long[] jArr = this.f44891n;
                    int i4 = this.f44895r;
                    if (j3 >= jArr[i4]) {
                        if (z3) {
                            try {
                                int i5 = this.f44896s;
                                if (i5 != i3) {
                                    i3 = i5 + 1;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                throw th;
                            }
                        }
                        int iU = u(i4, i3, j3, z2);
                        if (iU == -1) {
                            return -1L;
                        }
                        return o(iU);
                    }
                }
                return -1L;
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
            throw th;
        }
    }

    private synchronized long n() {
        int i3 = this.f44893p;
        if (i3 == 0) {
            return -1L;
        }
        return o(i3);
    }

    private long o(int i3) {
        this.f44898u = Math.max(this.f44898u, z(i3));
        this.f44893p -= i3;
        int i4 = this.f44894q + i3;
        this.f44894q = i4;
        int i5 = this.f44895r + i3;
        this.f44895r = i5;
        int i6 = this.f44886i;
        if (i5 >= i6) {
            this.f44895r = i5 - i6;
        }
        int i7 = this.f44896s - i3;
        this.f44896s = i7;
        if (i7 < 0) {
            this.f44896s = 0;
        }
        this.f44880c.d(i4);
        if (this.f44893p != 0) {
            return this.f44888k[this.f44895r];
        }
        int i8 = this.f44895r;
        if (i8 == 0) {
            i8 = this.f44886i;
        }
        int i9 = i8 - 1;
        return this.f44888k[i9] + ((long) this.f44889l[i9]);
    }

    private long r(int i3) {
        int iE = E() - i3;
        boolean z2 = false;
        Assertions.a(iE >= 0 && iE <= this.f44893p - this.f44896s);
        int i4 = this.f44893p - iE;
        this.f44893p = i4;
        this.f44899v = Math.max(this.f44898u, z(i4));
        if (iE == 0 && this.f44900w) {
            z2 = true;
        }
        this.f44900w = z2;
        this.f44880c.c(i3);
        int i5 = this.f44893p;
        if (i5 == 0) {
            return 0L;
        }
        int iB = B(i5 - 1);
        return this.f44888k[iB] + ((long) this.f44889l[iB]);
    }

    private int t(int i3, int i4, long j3, boolean z2) {
        for (int i5 = 0; i5 < i4; i5++) {
            if (this.f44891n[i3] >= j3) {
                return i5;
            }
            i3++;
            if (i3 == this.f44886i) {
                i3 = 0;
            }
        }
        if (z2) {
            return i4;
        }
        return -1;
    }

    private int u(int i3, int i4, long j3, boolean z2) {
        int i5 = -1;
        for (int i6 = 0; i6 < i4; i6++) {
            long j4 = this.f44891n[i3];
            if (j4 > j3) {
                break;
            }
            if (!z2 || (this.f44890m[i3] & 1) != 0) {
                if (j4 == j3) {
                    return i6;
                }
                i5 = i6;
            }
            i3++;
            if (i3 == this.f44886i) {
                i3 = 0;
            }
        }
        return i5;
    }

    private long z(int i3) {
        long jMax = Long.MIN_VALUE;
        if (i3 == 0) {
            return Long.MIN_VALUE;
        }
        int iB = B(i3 - 1);
        for (int i4 = 0; i4 < i3; i4++) {
            jMax = Math.max(jMax, this.f44891n[iB]);
            if ((this.f44890m[iB] & 1) != 0) {
                return jMax;
            }
            iB--;
            if (iB == -1) {
                iB = this.f44886i - 1;
            }
        }
        return jMax;
    }

    public final int A() {
        return this.f44894q + this.f44896s;
    }

    public final synchronized int C(long j3, boolean z2) throws Throwable {
        Throwable th;
        try {
            try {
                int iB = B(this.f44896s);
                if (!F() || j3 < this.f44891n[iB]) {
                    return 0;
                }
                if (j3 <= this.f44899v || !z2) {
                    int iU = u(iB, this.f44893p - this.f44896s, j3, true);
                    if (iU == -1) {
                        return 0;
                    }
                    return iU;
                }
                try {
                    return this.f44893p - this.f44896s;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
        throw th;
    }

    public final synchronized Format D() {
        return this.f44902y ? null : this.B;
    }

    public final int E() {
        return this.f44894q + this.f44893p;
    }

    protected final void G() {
        this.f44903z = true;
    }

    public final synchronized boolean H() {
        return this.f44900w;
    }

    public synchronized boolean I(boolean z2) {
        Format format;
        boolean z3 = true;
        if (F()) {
            if (((SharedSampleMetadata) this.f44880c.e(A())).f44907a != this.f44884g) {
                return true;
            }
            return J(B(this.f44896s));
        }
        if (!z2 && !this.f44900w && ((format = this.B) == null || format == this.f44884g)) {
            z3 = false;
        }
        return z3;
    }

    public void K() throws DrmSession.DrmSessionException {
        DrmSession drmSession = this.f44885h;
        if (drmSession != null && drmSession.getState() == 1) {
            throw ((DrmSession.DrmSessionException) Assertions.e(this.f44885h.getError()));
        }
    }

    public void N() {
        q();
        Q();
    }

    public int O(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i3, boolean z2) {
        int iM = M(formatHolder, decoderInputBuffer, (i3 & 2) != 0, z2, this.f44879b);
        if (iM == -4 && !decoderInputBuffer.i()) {
            boolean z3 = (i3 & 1) != 0;
            if ((i3 & 4) == 0) {
                if (z3) {
                    this.f44878a.f(decoderInputBuffer, this.f44879b);
                } else {
                    this.f44878a.m(decoderInputBuffer, this.f44879b);
                }
            }
            if (!z3) {
                this.f44896s++;
            }
        }
        return iM;
    }

    public void P() {
        S(true);
        Q();
    }

    public final void R() {
        S(false);
    }

    public void S(boolean z2) {
        this.f44878a.n();
        this.f44893p = 0;
        this.f44894q = 0;
        this.f44895r = 0;
        this.f44896s = 0;
        this.f44901x = true;
        this.f44897t = Long.MIN_VALUE;
        this.f44898u = Long.MIN_VALUE;
        this.f44899v = Long.MIN_VALUE;
        this.f44900w = false;
        this.f44880c.b();
        if (z2) {
            this.A = null;
            this.B = null;
            this.f44902y = true;
            this.D = true;
        }
    }

    public final synchronized boolean U(int i3) {
        T();
        int i4 = this.f44894q;
        if (i3 >= i4 && i3 <= this.f44893p + i4) {
            this.f44897t = Long.MIN_VALUE;
            this.f44896s = i3 - i4;
            return true;
        }
        return false;
    }

    public final synchronized boolean V(long j3, boolean z2) throws Throwable {
        SampleQueue sampleQueue;
        long j4;
        int iU;
        try {
            try {
                T();
                int iB = B(this.f44896s);
                if (!F() || j3 < this.f44891n[iB] || (j3 > this.f44899v && !z2)) {
                    return false;
                }
                if (this.D) {
                    sampleQueue = this;
                    j4 = j3;
                    iU = sampleQueue.t(iB, this.f44893p - this.f44896s, j4, z2);
                } else {
                    sampleQueue = this;
                    j4 = j3;
                    iU = sampleQueue.u(iB, sampleQueue.f44893p - sampleQueue.f44896s, j4, true);
                }
                if (iU == -1) {
                    return false;
                }
                sampleQueue.f44897t = j4;
                sampleQueue.f44896s += iU;
                return true;
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        throw th;
    }

    public final void W(long j3) {
        if (this.F != j3) {
            this.F = j3;
            G();
        }
    }

    public final void X(long j3) {
        this.f44897t = j3;
    }

    public final void Z(UpstreamFormatChangedListener upstreamFormatChangedListener) {
        this.f44883f = upstreamFormatChangedListener;
    }

    @Override // androidx.media3.extractor.TrackOutput
    public final void a(ParsableByteArray parsableByteArray, int i3, int i4) {
        this.f44878a.q(parsableByteArray, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void a0(int r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 < 0) goto Le
            int r0 = r2.f44896s     // Catch: java.lang.Throwable -> Lc
            int r0 = r0 + r3
            int r1 = r2.f44893p     // Catch: java.lang.Throwable -> Lc
            if (r0 > r1) goto Le
            r0 = 1
            goto Lf
        Lc:
            r3 = move-exception
            goto L19
        Le:
            r0 = 0
        Lf:
            androidx.media3.common.util.Assertions.a(r0)     // Catch: java.lang.Throwable -> Lc
            int r0 = r2.f44896s     // Catch: java.lang.Throwable -> Lc
            int r0 = r0 + r3
            r2.f44896s = r0     // Catch: java.lang.Throwable -> Lc
            monitor-exit(r2)
            return
        L19:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> Lc
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.SampleQueue.a0(int):void");
    }

    @Override // androidx.media3.extractor.TrackOutput
    public final void c(Format format) {
        Format formatV = v(format);
        this.f44903z = false;
        this.A = format;
        boolean zY = Y(formatV);
        UpstreamFormatChangedListener upstreamFormatChangedListener = this.f44883f;
        if (upstreamFormatChangedListener == null || !zY) {
            return;
        }
        upstreamFormatChangedListener.h(formatV);
    }

    @Override // androidx.media3.extractor.TrackOutput
    public final int f(DataReader dataReader, int i3, boolean z2, int i4) {
        return this.f44878a.p(dataReader, i3, z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0053  */
    @Override // androidx.media3.extractor.TrackOutput
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g(long r12, int r14, int r15, int r16, androidx.media3.extractor.TrackOutput.CryptoData r17) {
        /*
            r11 = this;
            boolean r1 = r11.f44903z
            if (r1 == 0) goto Lf
            androidx.media3.common.Format r1 = r11.A
            java.lang.Object r1 = androidx.media3.common.util.Assertions.i(r1)
            androidx.media3.common.Format r1 = (androidx.media3.common.Format) r1
            r11.c(r1)
        Lf:
            r1 = r14 & 1
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L17
            r4 = r3
            goto L18
        L17:
            r4 = r2
        L18:
            boolean r5 = r11.f44901x
            if (r5 == 0) goto L21
            if (r4 != 0) goto L1f
            goto L64
        L1f:
            r11.f44901x = r2
        L21:
            long r5 = r11.F
            long r5 = r5 + r12
            boolean r7 = r11.D
            if (r7 == 0) goto L53
            long r7 = r11.f44897t
            int r7 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r7 >= 0) goto L2f
            goto L64
        L2f:
            if (r1 != 0) goto L53
            boolean r1 = r11.E
            if (r1 != 0) goto L4f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r7 = "Overriding unexpected non-sync sample for format: "
            r1.append(r7)
            androidx.media3.common.Format r7 = r11.B
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            java.lang.String r7 = "SampleQueue"
            androidx.media3.common.util.Log.i(r7, r1)
            r11.E = r3
        L4f:
            r1 = r14 | 1
            r3 = r1
            goto L54
        L53:
            r3 = r14
        L54:
            boolean r1 = r11.G
            if (r1 == 0) goto L65
            if (r4 == 0) goto L64
            boolean r1 = r11.i(r5)
            if (r1 != 0) goto L61
            goto L64
        L61:
            r11.G = r2
            goto L65
        L64:
            return
        L65:
            androidx.media3.exoplayer.source.SampleDataQueue r1 = r11.f44878a
            long r1 = r1.e()
            long r7 = (long) r15
            long r1 = r1 - r7
            r7 = r16
            long r7 = (long) r7
            long r1 = r1 - r7
            r9 = r5
            r4 = r1
            r1 = r9
            r0 = r11
            r6 = r15
            r7 = r17
            r0.j(r1, r3, r4, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.SampleQueue.g(long, int, int, int, androidx.media3.extractor.TrackOutput$CryptoData):void");
    }

    public final void p(long j3, boolean z2, boolean z3) {
        this.f44878a.b(m(j3, z2, z3));
    }

    public final void q() {
        this.f44878a.b(n());
    }

    public final void s(int i3) {
        this.f44878a.c(r(i3));
    }

    protected Format v(Format format) {
        return (this.F == 0 || format.f40637t == Long.MAX_VALUE) ? format : format.b().y0(format.f40637t + this.F).N();
    }

    public final int w() {
        return this.f44894q;
    }

    public final synchronized long x() {
        return this.f44899v;
    }

    public final synchronized long y() {
        return Math.max(this.f44898u, z(this.f44896s));
    }
}
