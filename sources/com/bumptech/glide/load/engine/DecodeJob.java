package com.bumptech.glide.load.engine;

import android.os.Process;
import android.util.Log;
import androidx.core.util.Pools;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.GlideExperiments;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.GlideTrace;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class DecodeJob<R> implements DataFetcherGenerator.FetcherReadyCallback, Runnable, Comparable<DecodeJob<?>>, FactoryPools.Poolable {
    public static final Option J = Option.e("glide_thread_priority_override");
    private Key A;
    private Key B;
    private Object C;
    private DataSource D;
    private DataFetcher E;
    private volatile DataFetcherGenerator F;
    private volatile boolean G;
    private volatile boolean H;
    private boolean I;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final DiskCacheProvider f66356d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Pools.Pool f66357f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private GlideContext f66360i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Key f66361j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Priority f66362k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private EngineKey f66363l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f66364m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f66365n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private DiskCacheStrategy f66366o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Options f66367p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Callback f66368q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f66369r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Stage f66370s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private RunReason f66371t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f66372u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f66373v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Object f66374w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private GlideExperiments f66375x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Supplier f66376y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Thread f66377z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DecodeHelper f66353a = new DecodeHelper();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f66354b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final StateVerifier f66355c = StateVerifier.a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final DeferredEncodeManager f66358g = new DeferredEncodeManager();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ReleaseManager f66359h = new ReleaseManager();

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.DecodeJob$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f66378a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f66379b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f66380c;

        static {
            int[] iArr = new int[EncodeStrategy.values().length];
            f66380c = iArr;
            try {
                iArr[EncodeStrategy.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f66380c[EncodeStrategy.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Stage.values().length];
            f66379b = iArr2;
            try {
                iArr2[Stage.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f66379b[Stage.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f66379b[Stage.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f66379b[Stage.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f66379b[Stage.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[RunReason.values().length];
            f66378a = iArr3;
            try {
                iArr3[RunReason.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f66378a[RunReason.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f66378a[RunReason.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface Callback<R> {
        void b(Resource resource, DataSource dataSource, boolean z2);

        void c(GlideException glideException);

        void e(DecodeJob decodeJob);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class DecodeCallback<Z> implements DecodePath.DecodeCallback<Z> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DataSource f66381a;

        DecodeCallback(DataSource dataSource) {
            this.f66381a = dataSource;
        }

        @Override // com.bumptech.glide.load.engine.DecodePath.DecodeCallback
        public Resource a(Resource resource) {
            return DecodeJob.this.v(this.f66381a, resource);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class DeferredEncodeManager<Z> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Key f66383a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ResourceEncoder f66384b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private LockedResource f66385c;

        DeferredEncodeManager() {
        }

        void a() {
            this.f66383a = null;
            this.f66384b = null;
            this.f66385c = null;
        }

        void b(DiskCacheProvider diskCacheProvider, Options options) {
            GlideTrace.a("DecodeJob.encode");
            try {
                diskCacheProvider.a().a(this.f66383a, new DataCacheWriter(this.f66384b, this.f66385c, options));
            } finally {
                this.f66385c.g();
                GlideTrace.e();
            }
        }

        boolean c() {
            return this.f66385c != null;
        }

        void d(Key key, ResourceEncoder resourceEncoder, LockedResource lockedResource) {
            this.f66383a = key;
            this.f66384b = resourceEncoder;
            this.f66385c = lockedResource;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface DiskCacheProvider {
        DiskCache a();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ReleaseManager {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f66386a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f66387b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f66388c;

        ReleaseManager() {
        }

        private boolean a(boolean z2) {
            return (this.f66388c || z2 || this.f66387b) && this.f66386a;
        }

        synchronized boolean b() {
            this.f66387b = true;
            return a(false);
        }

        synchronized boolean c() {
            this.f66388c = true;
            return a(false);
        }

        synchronized boolean d(boolean z2) {
            this.f66386a = true;
            return a(z2);
        }

        synchronized void e() {
            this.f66387b = false;
            this.f66386a = false;
            this.f66388c = false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum RunReason {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum Stage {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    DecodeJob(DiskCacheProvider diskCacheProvider, Pools.Pool pool) {
        this.f66356d = diskCacheProvider;
        this.f66357f = pool;
    }

    private void A() {
        this.f66377z = Thread.currentThread();
        this.f66372u = LogTime.b();
        boolean zB = false;
        while (!this.H && this.F != null && !(zB = this.F.b())) {
            this.f66370s = k(this.f66370s);
            this.F = j();
            if (this.f66370s == Stage.SOURCE) {
                y(RunReason.SWITCH_TO_SOURCE_SERVICE);
                return;
            }
        }
        if ((this.f66370s == Stage.FINISHED || this.H) && !zB) {
            s();
        }
    }

    private Resource B(Object obj, DataSource dataSource, LoadPath loadPath) {
        Options optionsL = l(dataSource);
        DataRewinder dataRewinderL = this.f66360i.i().l(obj);
        try {
            return loadPath.a(dataRewinderL, optionsL, this.f66364m, this.f66365n, new DecodeCallback(dataSource));
        } finally {
            dataRewinderL.b();
        }
    }

    private void C() {
        int i3 = AnonymousClass1.f66378a[this.f66371t.ordinal()];
        if (i3 == 1) {
            this.f66370s = k(Stage.INITIALIZE);
            this.F = j();
            A();
        } else if (i3 == 2) {
            A();
        } else {
            if (i3 == 3) {
                i();
                return;
            }
            throw new IllegalStateException("Unrecognized run reason: " + this.f66371t);
        }
    }

    private void D() {
        Throwable th;
        this.f66355c.c();
        if (!this.G) {
            this.G = true;
            return;
        }
        if (this.f66354b.isEmpty()) {
            th = null;
        } else {
            List list = this.f66354b;
            th = (Throwable) list.get(list.size() - 1);
        }
        throw new IllegalStateException("Already notified", th);
    }

    private Resource g(DataFetcher dataFetcher, Object obj, DataSource dataSource) {
        if (obj == null) {
            dataFetcher.b();
            return null;
        }
        try {
            long jB = LogTime.b();
            Resource resourceH = h(obj, dataSource);
            if (Log.isLoggable("DecodeJob", 2)) {
                o("Decoded result " + resourceH, jB);
            }
            return resourceH;
        } finally {
            dataFetcher.b();
        }
    }

    private Resource h(Object obj, DataSource dataSource) {
        return B(obj, dataSource, this.f66353a.h(obj.getClass()));
    }

    private void i() {
        Supplier supplier;
        if (Log.isLoggable("DecodeJob", 2)) {
            p("Retrieved data", this.f66372u, "data: " + this.C + ", cache key: " + this.A + ", fetcher: " + this.E);
        }
        Resource resourceG = null;
        if (this.f66375x.a(GlideBuilder.OverrideGlideThreadPriority.class) && (supplier = this.f66376y) != null && supplier.get() != null) {
            try {
                Process.setThreadPriority(Process.myTid(), ((Integer) this.f66376y.get()).intValue());
            } catch (IllegalArgumentException | SecurityException e3) {
                this.f66376y = null;
                if (Log.isLoggable("DecodeJob", 2)) {
                    Log.v("DecodeJob", "Failed to set thread priority; using default priority for any subsequent jobs.", e3);
                }
            }
        }
        try {
            resourceG = g(this.E, this.C, this.D);
        } catch (GlideException e4) {
            e4.i(this.B, this.D);
            this.f66354b.add(e4);
        }
        if (resourceG != null) {
            r(resourceG, this.D, this.I);
        } else {
            A();
        }
    }

    private DataFetcherGenerator j() {
        int i3 = AnonymousClass1.f66379b[this.f66370s.ordinal()];
        if (i3 == 1) {
            return new ResourceCacheGenerator(this.f66353a, this);
        }
        if (i3 == 2) {
            return new DataCacheGenerator(this.f66353a, this);
        }
        if (i3 == 3) {
            return new SourceGenerator(this.f66353a, this);
        }
        if (i3 == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.f66370s);
    }

    private Stage k(Stage stage) {
        int i3 = AnonymousClass1.f66379b[stage.ordinal()];
        if (i3 == 1) {
            return this.f66366o.a() ? Stage.DATA_CACHE : k(Stage.DATA_CACHE);
        }
        if (i3 == 2) {
            return this.f66373v ? Stage.FINISHED : Stage.SOURCE;
        }
        if (i3 == 3 || i3 == 4) {
            return Stage.FINISHED;
        }
        if (i3 == 5) {
            return this.f66366o.b() ? Stage.RESOURCE_CACHE : k(Stage.RESOURCE_CACHE);
        }
        throw new IllegalArgumentException("Unrecognized stage: " + stage);
    }

    private Options l(DataSource dataSource) {
        Options options = this.f66367p;
        boolean z2 = dataSource == DataSource.RESOURCE_DISK_CACHE || this.f66353a.x();
        Option option = Downsampler.f66855j;
        Boolean bool = (Boolean) options.c(option);
        if (bool != null && (!bool.booleanValue() || z2)) {
            return options;
        }
        Options options2 = new Options();
        options2.d(this.f66367p);
        options2.f(option, Boolean.valueOf(z2));
        return options2;
    }

    private int m() {
        return this.f66362k.ordinal();
    }

    private void o(String str, long j3) {
        p(str, j3, null);
    }

    private void p(String str, long j3, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(LogTime.a(j3));
        sb.append(", load key: ");
        sb.append(this.f66363l);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb.toString());
    }

    private void q(Resource resource, DataSource dataSource, boolean z2) {
        if (this.f66375x.a(GlideBuilder.OverrideGlideThreadPriority.class)) {
            z();
        }
        D();
        this.f66368q.b(resource, dataSource, z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void r(Resource resource, DataSource dataSource, boolean z2) {
        LockedResource lockedResource;
        GlideTrace.a("DecodeJob.notifyEncodeAndRelease");
        try {
            if (resource instanceof Initializable) {
                ((Initializable) resource).initialize();
            }
            if (this.f66358g.c()) {
                resource = LockedResource.e(resource);
                lockedResource = resource;
            } else {
                lockedResource = 0;
            }
            q(resource, dataSource, z2);
            this.f66370s = Stage.ENCODE;
            try {
                if (this.f66358g.c()) {
                    this.f66358g.b(this.f66356d, this.f66367p);
                }
                t();
                GlideTrace.e();
            } finally {
                if (lockedResource != 0) {
                    lockedResource.g();
                }
            }
        } catch (Throwable th) {
            GlideTrace.e();
            throw th;
        }
    }

    private void s() {
        if (this.f66375x.a(GlideBuilder.OverrideGlideThreadPriority.class)) {
            z();
        }
        D();
        this.f66368q.c(new GlideException("Failed to load resource", new ArrayList(this.f66354b)));
        u();
    }

    private void t() {
        if (this.f66359h.b()) {
            x();
        }
    }

    private void u() {
        if (this.f66359h.c()) {
            x();
        }
    }

    private void x() {
        this.f66359h.e();
        this.f66358g.a();
        this.f66353a.a();
        this.G = false;
        this.f66360i = null;
        this.f66361j = null;
        this.f66367p = null;
        this.f66362k = null;
        this.f66363l = null;
        this.f66368q = null;
        this.f66370s = null;
        this.F = null;
        this.f66377z = null;
        this.A = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.f66372u = 0L;
        this.H = false;
        this.f66374w = null;
        this.f66354b.clear();
        this.f66357f.b(this);
    }

    private void y(RunReason runReason) {
        this.f66371t = runReason;
        this.f66368q.e(this);
    }

    private void z() {
        if (!this.f66375x.a(GlideBuilder.OverrideGlideThreadPriority.class)) {
            throw new IllegalStateException("OverrideGlideThreadPriority experiment is not enabled.");
        }
        Supplier supplier = this.f66376y;
        if (supplier == null || supplier.get() == null) {
            return;
        }
        try {
            Process.setThreadPriority(Process.myTid(), 9);
        } catch (IllegalArgumentException | SecurityException e3) {
            this.f66376y = null;
            if (Log.isLoggable("DecodeJob", 2)) {
                Log.v("DecodeJob", "Failed to set thread priority; using default priority for any subsequent jobs.", e3);
            }
        }
    }

    boolean E() {
        Stage stageK = k(Stage.INITIALIZE);
        return stageK == Stage.RESOURCE_CACHE || stageK == Stage.DATA_CACHE;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void a(Key key, Exception exc, DataFetcher dataFetcher, DataSource dataSource) {
        dataFetcher.b();
        GlideException glideException = new GlideException("Fetching data failed", exc);
        glideException.j(key, dataSource, dataFetcher.a());
        this.f66354b.add(glideException);
        if (Thread.currentThread() != this.f66377z) {
            y(RunReason.SWITCH_TO_SOURCE_SERVICE);
        } else {
            A();
        }
    }

    public void b() {
        this.H = true;
        DataFetcherGenerator dataFetcherGenerator = this.F;
        if (dataFetcherGenerator != null) {
            dataFetcherGenerator.cancel();
        }
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void c() {
        y(RunReason.SWITCH_TO_SOURCE_SERVICE);
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    public StateVerifier d() {
        return this.f66355c;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void e(Key key, Object obj, DataFetcher dataFetcher, DataSource dataSource, Key key2) {
        this.A = key;
        this.C = obj;
        this.E = dataFetcher;
        this.D = dataSource;
        this.B = key2;
        this.I = key != this.f66353a.c().get(0);
        if (Thread.currentThread() != this.f66377z) {
            y(RunReason.DECODE_DATA);
            return;
        }
        GlideTrace.a("DecodeJob.decodeFromRetrievedData");
        try {
            i();
        } finally {
            GlideTrace.e();
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public int compareTo(DecodeJob decodeJob) {
        int iM = m() - decodeJob.m();
        return iM == 0 ? this.f66369r - decodeJob.f66369r : iM;
    }

    DecodeJob n(GlideContext glideContext, Object obj, EngineKey engineKey, Key key, int i3, int i4, Class cls, Class cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map map, boolean z2, boolean z3, boolean z4, Options options, Callback callback, int i5) {
        this.f66353a.v(glideContext, obj, key, i3, i4, diskCacheStrategy, cls, cls2, priority, options, map, z2, z3, this.f66356d);
        this.f66360i = glideContext;
        this.f66361j = key;
        this.f66362k = priority;
        this.f66363l = engineKey;
        this.f66364m = i3;
        this.f66365n = i4;
        this.f66366o = diskCacheStrategy;
        this.f66373v = z4;
        this.f66367p = options;
        this.f66368q = callback;
        this.f66369r = i5;
        this.f66371t = RunReason.INITIALIZE;
        this.f66374w = obj;
        this.f66375x = glideContext.g();
        this.f66376y = (Supplier) options.c(J);
        return this;
    }

    @Override // java.lang.Runnable
    public void run() {
        GlideTrace.c("DecodeJob#run(reason=%s, model=%s)", this.f66371t, this.f66374w);
        DataFetcher dataFetcher = this.E;
        try {
            try {
                if (this.H) {
                    s();
                    if (dataFetcher != null) {
                        dataFetcher.b();
                    }
                    GlideTrace.e();
                    return;
                }
                C();
                if (dataFetcher != null) {
                    dataFetcher.b();
                }
                GlideTrace.e();
            } catch (Throwable th) {
                if (dataFetcher != null) {
                    dataFetcher.b();
                }
                GlideTrace.e();
                throw th;
            }
        } catch (CallbackException e3) {
            throw e3;
        } catch (Throwable th2) {
            if (Log.isLoggable("DecodeJob", 3)) {
                Log.d("DecodeJob", "DecodeJob threw unexpectedly, isCancelled: " + this.H + ", stage: " + this.f66370s, th2);
            }
            if (this.f66370s != Stage.ENCODE) {
                this.f66354b.add(th2);
                s();
            }
            if (!this.H) {
                throw th2;
            }
            throw th2;
        }
    }

    Resource v(DataSource dataSource, Resource resource) {
        Resource resourceA;
        Transformation transformation;
        EncodeStrategy encodeStrategyB;
        Key dataCacheKey;
        Class<?> cls = resource.get().getClass();
        ResourceEncoder resourceEncoderN = null;
        if (dataSource != DataSource.RESOURCE_DISK_CACHE) {
            Transformation transformationS = this.f66353a.s(cls);
            transformation = transformationS;
            resourceA = transformationS.a(this.f66360i, resource, this.f66364m, this.f66365n);
        } else {
            resourceA = resource;
            transformation = null;
        }
        if (!resource.equals(resourceA)) {
            resource.a();
        }
        if (this.f66353a.w(resourceA)) {
            resourceEncoderN = this.f66353a.n(resourceA);
            encodeStrategyB = resourceEncoderN.b(this.f66367p);
        } else {
            encodeStrategyB = EncodeStrategy.NONE;
        }
        ResourceEncoder resourceEncoder = resourceEncoderN;
        if (!this.f66366o.d(!this.f66353a.y(this.A), dataSource, encodeStrategyB)) {
            return resourceA;
        }
        if (resourceEncoder == null) {
            throw new Registry.NoResultEncoderAvailableException(resourceA.get().getClass());
        }
        int i3 = AnonymousClass1.f66380c[encodeStrategyB.ordinal()];
        if (i3 == 1) {
            dataCacheKey = new DataCacheKey(this.A, this.f66361j);
        } else {
            if (i3 != 2) {
                throw new IllegalArgumentException("Unknown strategy: " + encodeStrategyB);
            }
            dataCacheKey = new ResourceCacheKey(this.f66353a.b(), this.A, this.f66361j, this.f66364m, this.f66365n, transformation, cls, this.f66367p);
        }
        LockedResource lockedResourceE = LockedResource.e(resourceA);
        this.f66358g.d(dataCacheKey, resourceEncoder, lockedResourceE);
        return lockedResourceE;
    }

    void w(boolean z2) {
        if (this.f66359h.d(z2)) {
            x();
        }
    }
}
