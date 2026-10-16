package androidx.media3.exoplayer.source.chunk;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.SampleQueue;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.exoplayer.source.SequenceableLoader;
import androidx.media3.exoplayer.source.chunk.ChunkSource;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.Loader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ChunkSampleStream<T extends ChunkSource> implements SampleStream, SequenceableLoader, Loader.Callback<Chunk>, Loader.ReleaseCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f45103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f45104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Format[] f45105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ChunkSource f45106d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SequenceableLoader.Callback f45107f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MediaSourceEventListener.EventDispatcher f45108g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final LoadErrorHandlingPolicy f45109h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Loader f45110i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ChunkHolder f45111j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ArrayList f45112k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final List f45113l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final SampleQueue f45114m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final SampleQueue[] f45115n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final BaseMediaChunkOutput f45116o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Chunk f45117p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Format f45118q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ReleaseCallback f45119r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f45120s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f45121t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f45122u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private BaseMediaChunk f45123v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f45124w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f45125x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    boolean f45126y;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ReleaseCallback<T extends ChunkSource> {
        void a(ChunkSampleStream chunkSampleStream);
    }

    private void A(int i3) {
        Assertions.g(!this.f45110i.i());
        int size = this.f45112k.size();
        while (true) {
            if (i3 >= size) {
                i3 = -1;
                break;
            } else if (!D(i3)) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 == -1) {
            return;
        }
        long j3 = C().f45099h;
        BaseMediaChunk baseMediaChunkB = B(i3);
        if (this.f45112k.isEmpty()) {
            this.f45120s = this.f45121t;
        }
        this.f45126y = false;
        this.f45108g.v(this.f45103a, baseMediaChunkB.f45098g, j3);
    }

    private BaseMediaChunk B(int i3) {
        BaseMediaChunk baseMediaChunk = (BaseMediaChunk) this.f45112k.get(i3);
        ArrayList arrayList = this.f45112k;
        Util.X0(arrayList, i3, arrayList.size());
        this.f45122u = Math.max(this.f45122u, this.f45112k.size());
        int i4 = 0;
        this.f45114m.s(baseMediaChunk.g(0));
        while (true) {
            SampleQueue[] sampleQueueArr = this.f45115n;
            if (i4 >= sampleQueueArr.length) {
                return baseMediaChunk;
            }
            SampleQueue sampleQueue = sampleQueueArr[i4];
            i4++;
            sampleQueue.s(baseMediaChunk.g(i4));
        }
    }

    private BaseMediaChunk C() {
        return (BaseMediaChunk) this.f45112k.get(r0.size() - 1);
    }

    private boolean D(int i3) {
        int iA;
        BaseMediaChunk baseMediaChunk = (BaseMediaChunk) this.f45112k.get(i3);
        if (this.f45114m.A() > baseMediaChunk.g(0)) {
            return true;
        }
        int i4 = 0;
        do {
            SampleQueue[] sampleQueueArr = this.f45115n;
            if (i4 >= sampleQueueArr.length) {
                return false;
            }
            iA = sampleQueueArr[i4].A();
            i4++;
        } while (iA <= baseMediaChunk.g(i4));
        return true;
    }

    private boolean E(Chunk chunk) {
        return chunk instanceof BaseMediaChunk;
    }

    private void G() {
        int iM = M(this.f45114m.A(), this.f45122u - 1);
        while (true) {
            int i3 = this.f45122u;
            if (i3 > iM) {
                return;
            }
            this.f45122u = i3 + 1;
            H(i3);
        }
    }

    private void H(int i3) {
        BaseMediaChunk baseMediaChunk = (BaseMediaChunk) this.f45112k.get(i3);
        Format format = baseMediaChunk.f45095d;
        if (!format.equals(this.f45118q)) {
            this.f45108g.j(this.f45103a, format, baseMediaChunk.f45096e, baseMediaChunk.f45097f, baseMediaChunk.f45098g);
        }
        this.f45118q = format;
    }

    private int M(int i3, int i4) {
        do {
            i4++;
            if (i4 >= this.f45112k.size()) {
                return this.f45112k.size() - 1;
            }
        } while (((BaseMediaChunk) this.f45112k.get(i4)).g(0) <= i3);
        return i4 - 1;
    }

    private void N() {
        this.f45114m.R();
        for (SampleQueue sampleQueue : this.f45115n) {
            sampleQueue.R();
        }
    }

    boolean F() {
        return this.f45120s != -9223372036854775807L;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Callback
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public void v(Chunk chunk, long j3, long j4, boolean z2) {
        this.f45117p = null;
        this.f45123v = null;
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk.f45092a, chunk.f45093b, chunk.e(), chunk.d(), j3, j4, chunk.b());
        this.f45109h.c(chunk.f45092a);
        this.f45108g.l(loadEventInfo, chunk.f45094c, this.f45103a, chunk.f45095d, chunk.f45096e, chunk.f45097f, chunk.f45098g, chunk.f45099h);
        if (z2) {
            return;
        }
        if (F()) {
            N();
        } else if (E(chunk)) {
            B(this.f45112k.size() - 1);
            if (this.f45112k.isEmpty()) {
                this.f45120s = this.f45121t;
            }
        }
        this.f45107f.h(this);
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Callback
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public void t(Chunk chunk, long j3, long j4) {
        this.f45117p = null;
        this.f45106d.c(chunk);
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk.f45092a, chunk.f45093b, chunk.e(), chunk.d(), j3, j4, chunk.b());
        this.f45109h.c(chunk.f45092a);
        this.f45108g.n(loadEventInfo, chunk.f45094c, this.f45103a, chunk.f45095d, chunk.f45096e, chunk.f45097f, chunk.f45098g, chunk.f45099h);
        this.f45107f.h(this);
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Callback
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public Loader.LoadErrorAction g(Chunk chunk, long j3, long j4, IOException iOException, int i3) {
        Loader.LoadErrorAction loadErrorActionG;
        long jB = chunk.b();
        boolean zE = E(chunk);
        int size = this.f45112k.size() - 1;
        boolean z2 = (jB != 0 && zE && D(size)) ? false : true;
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk.f45092a, chunk.f45093b, chunk.e(), chunk.d(), j3, j4, jB);
        LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo = new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(chunk.f45094c, this.f45103a, chunk.f45095d, chunk.f45096e, chunk.f45097f, Util.t1(chunk.f45098g), Util.t1(chunk.f45099h)), iOException, i3);
        if (!this.f45106d.a(chunk, z2, loadErrorInfo, this.f45109h)) {
            loadErrorActionG = null;
        } else if (z2) {
            loadErrorActionG = Loader.f45536f;
            if (zE) {
                Assertions.g(B(size) == chunk);
                if (this.f45112k.isEmpty()) {
                    this.f45120s = this.f45121t;
                }
            }
        } else {
            Log.i("ChunkSampleStream", "Ignoring attempt to cancel non-cancelable load.");
            loadErrorActionG = null;
        }
        if (loadErrorActionG == null) {
            long jA = this.f45109h.a(loadErrorInfo);
            loadErrorActionG = jA != -9223372036854775807L ? Loader.g(false, jA) : Loader.f45537g;
        }
        boolean zC = loadErrorActionG.c();
        this.f45108g.p(loadEventInfo, chunk.f45094c, this.f45103a, chunk.f45095d, chunk.f45096e, chunk.f45097f, chunk.f45098g, chunk.f45099h, iOException, !zC);
        if (!zC) {
            this.f45117p = null;
            this.f45109h.c(chunk.f45092a);
            this.f45107f.h(this);
        }
        return loadErrorActionG;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Callback
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public void p(Chunk chunk, long j3, long j4, int i3) {
        this.f45108g.s(i3 == 0 ? new LoadEventInfo(chunk.f45092a, chunk.f45093b, j3) : new LoadEventInfo(chunk.f45092a, chunk.f45093b, chunk.e(), chunk.d(), j3, j4, chunk.b()), chunk.f45094c, this.f45103a, chunk.f45095d, chunk.f45096e, chunk.f45097f, chunk.f45098g, chunk.f45099h, i3);
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public boolean a() {
        return this.f45110i.i();
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public boolean b(LoadingInfo loadingInfo) {
        List list;
        long j3;
        if (this.f45126y || this.f45110i.i() || this.f45110i.h()) {
            return false;
        }
        boolean zF = F();
        if (zF) {
            list = Collections.EMPTY_LIST;
            j3 = this.f45120s;
        } else {
            list = this.f45113l;
            j3 = C().f45099h;
        }
        this.f45106d.e(loadingInfo, j3, list, this.f45111j);
        ChunkHolder chunkHolder = this.f45111j;
        boolean z2 = chunkHolder.f45102b;
        Chunk chunk = chunkHolder.f45101a;
        chunkHolder.a();
        if (z2) {
            this.f45120s = -9223372036854775807L;
            this.f45126y = true;
            return true;
        }
        if (chunk == null) {
            return false;
        }
        this.f45117p = chunk;
        if (E(chunk)) {
            BaseMediaChunk baseMediaChunk = (BaseMediaChunk) chunk;
            if (zF) {
                long j4 = baseMediaChunk.f45098g;
                long j5 = this.f45120s;
                if (j4 < j5) {
                    this.f45114m.X(j5);
                    for (SampleQueue sampleQueue : this.f45115n) {
                        sampleQueue.X(this.f45120s);
                    }
                    if (this.f45124w) {
                        Format format = baseMediaChunk.f45095d;
                        this.f45125x = !MimeTypes.a(format.f40632o, format.f40628k);
                    }
                }
                this.f45124w = false;
                this.f45120s = -9223372036854775807L;
            }
            baseMediaChunk.i(this.f45116o);
            this.f45112k.add(baseMediaChunk);
        } else if (chunk instanceof InitializationChunk) {
            ((InitializationChunk) chunk).f(this.f45116o);
        }
        this.f45110i.n(chunk, this, this.f45109h.b(chunk.f45094c));
        return true;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public long c() {
        if (F()) {
            return this.f45120s;
        }
        if (this.f45126y) {
            return Long.MIN_VALUE;
        }
        return C().f45099h;
    }

    @Override // androidx.media3.exoplayer.source.SampleStream
    public void d() throws IOException {
        this.f45110i.j();
        this.f45114m.K();
        if (this.f45110i.i()) {
            return;
        }
        this.f45106d.d();
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public long e() {
        if (this.f45126y) {
            return Long.MIN_VALUE;
        }
        if (F()) {
            return this.f45120s;
        }
        long jMax = this.f45121t;
        BaseMediaChunk baseMediaChunkC = C();
        if (!baseMediaChunkC.f()) {
            if (this.f45112k.size() > 1) {
                baseMediaChunkC = (BaseMediaChunk) this.f45112k.get(r2.size() - 2);
            } else {
                baseMediaChunkC = null;
            }
        }
        if (baseMediaChunkC != null) {
            jMax = Math.max(jMax, baseMediaChunkC.f45099h);
        }
        return Math.max(jMax, this.f45114m.x());
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public void f(long j3) {
        if (this.f45110i.h() || F()) {
            return;
        }
        if (!this.f45110i.i()) {
            int iF = this.f45106d.f(j3, this.f45113l);
            if (iF < this.f45112k.size()) {
                A(iF);
                return;
            }
            return;
        }
        Chunk chunk = (Chunk) Assertions.e(this.f45117p);
        if (!(E(chunk) && D(this.f45112k.size() - 1)) && this.f45106d.b(j3, chunk, this.f45113l)) {
            this.f45110i.e();
            if (E(chunk)) {
                this.f45123v = (BaseMediaChunk) chunk;
            }
        }
    }

    @Override // androidx.media3.exoplayer.source.SampleStream
    public int h(long j3) throws Throwable {
        if (F()) {
            return 0;
        }
        int iC = this.f45114m.C(j3, this.f45126y);
        BaseMediaChunk baseMediaChunk = this.f45123v;
        if (baseMediaChunk != null) {
            iC = Math.min(iC, baseMediaChunk.g(0) - this.f45114m.A());
        }
        this.f45114m.a0(iC);
        G();
        return iC;
    }

    @Override // androidx.media3.exoplayer.source.SampleStream
    public boolean isReady() {
        return !F() && this.f45114m.I(this.f45126y);
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.ReleaseCallback
    public void m() {
        this.f45114m.P();
        for (SampleQueue sampleQueue : this.f45115n) {
            sampleQueue.P();
        }
        this.f45106d.release();
        ReleaseCallback releaseCallback = this.f45119r;
        if (releaseCallback != null) {
            releaseCallback.a(this);
        }
    }

    @Override // androidx.media3.exoplayer.source.SampleStream
    public int n(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i3) {
        if (F()) {
            return -3;
        }
        BaseMediaChunk baseMediaChunk = this.f45123v;
        if (baseMediaChunk != null && baseMediaChunk.g(0) <= this.f45114m.A()) {
            return -3;
        }
        G();
        return this.f45114m.O(formatHolder, decoderInputBuffer, i3, this.f45126y);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public final class EmbeddedSampleStream implements SampleStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SampleQueue f45127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f45128b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f45129c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ChunkSampleStream f45130d;

        private void a() {
            if (this.f45129c) {
                return;
            }
            this.f45130d.f45108g.j(this.f45130d.f45104b[this.f45128b], this.f45130d.f45105c[this.f45128b], 0, null, this.f45130d.f45121t);
            this.f45129c = true;
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public int h(long j3) throws Throwable {
            if (this.f45130d.F()) {
                return 0;
            }
            int iC = this.f45127a.C(j3, this.f45130d.f45126y);
            if (this.f45130d.f45123v != null) {
                iC = Math.min(iC, this.f45130d.f45123v.g(this.f45128b + 1) - this.f45127a.A());
            }
            this.f45127a.a0(iC);
            if (iC > 0) {
                a();
            }
            return iC;
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public boolean isReady() {
            return !this.f45130d.F() && this.f45127a.I(this.f45130d.f45126y);
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public int n(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i3) {
            if (this.f45130d.F()) {
                return -3;
            }
            if (this.f45130d.f45123v != null && this.f45130d.f45123v.g(this.f45128b + 1) <= this.f45127a.A()) {
                return -3;
            }
            a();
            return this.f45127a.O(formatHolder, decoderInputBuffer, i3, this.f45130d.f45126y);
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public void d() {
        }
    }
}
