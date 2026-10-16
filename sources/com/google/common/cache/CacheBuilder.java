package com.google.common.cache;

import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.base.Ticker;
import com.google.common.cache.AbstractCache;
import com.google.common.cache.LocalCache;
import cz.mobilesoft.coreblock.storage.room.dao.cI.KrzujOtzIk;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class CacheBuilder<K, V> {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    static final Supplier f83442q = Suppliers.b(new AbstractCache.StatsCounter() { // from class: com.google.common.cache.CacheBuilder.1
        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void c() {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void a(int i3) {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void b(int i3) {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void d(long j3) {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void e(long j3) {
        }
    });

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    static final CacheStats f83443r = new CacheStats(0, 0, 0, 0, 0, 0);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    static final Supplier f83444s = new Supplier<AbstractCache.StatsCounter>() { // from class: com.google.common.cache.CacheBuilder.2
        @Override // com.google.common.base.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbstractCache.StatsCounter get() {
            return new AbstractCache.SimpleStatsCounter();
        }
    };

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    static final Ticker f83445t = new Ticker() { // from class: com.google.common.cache.CacheBuilder.3
        @Override // com.google.common.base.Ticker
        public long a() {
            return 0L;
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Weigher f83451f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    LocalCache.Strength f83452g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    LocalCache.Strength f83453h;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Equivalence f83457l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    Equivalence f83458m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    RemovalListener f83459n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    Ticker f83460o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f83446a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f83447b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f83448c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f83449d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    long f83450e = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    long f83454i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    long f83455j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    long f83456k = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    Supplier f83461p = f83442q;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class LoggerHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Logger f83462a = Logger.getLogger(CacheBuilder.class.getName());
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum OneWeigher implements Weigher<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.Weigher
        public int a(Object obj, Object obj2) {
            return 1;
        }
    }

    private CacheBuilder() {
    }

    private void c() {
        Preconditions.A(this.f83456k == -1, "refreshAfterWrite requires a LoadingCache");
    }

    private void d() {
        if (this.f83451f == null) {
            Preconditions.A(this.f83450e == -1, "maximumWeight requires weigher");
        } else if (this.f83446a) {
            Preconditions.A(this.f83450e != -1, "weigher requires maximumWeight");
        } else if (this.f83450e == -1) {
            LoggerHolder.f83462a.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
        }
    }

    public static CacheBuilder y() {
        return new CacheBuilder();
    }

    CacheBuilder A(LocalCache.Strength strength) {
        LocalCache.Strength strength2 = this.f83452g;
        Preconditions.D(strength2 == null, "Key strength was already set to %s", strength2);
        this.f83452g = (LocalCache.Strength) Preconditions.t(strength);
        return this;
    }

    CacheBuilder B(LocalCache.Strength strength) {
        LocalCache.Strength strength2 = this.f83453h;
        Preconditions.D(strength2 == null, "Value strength was already set to %s", strength2);
        this.f83453h = (LocalCache.Strength) Preconditions.t(strength);
        return this;
    }

    public CacheBuilder C(Ticker ticker) {
        Preconditions.z(this.f83460o == null);
        this.f83460o = (Ticker) Preconditions.t(ticker);
        return this;
    }

    CacheBuilder D(Equivalence equivalence) {
        Equivalence equivalence2 = this.f83458m;
        Preconditions.D(equivalence2 == null, "value equivalence was already set to %s", equivalence2);
        this.f83458m = (Equivalence) Preconditions.t(equivalence);
        return this;
    }

    public CacheBuilder E() {
        return A(LocalCache.Strength.WEAK);
    }

    public CacheBuilder F(Weigher weigher) {
        Preconditions.z(this.f83451f == null);
        if (this.f83446a) {
            long j3 = this.f83449d;
            Preconditions.C(j3 == -1, "weigher can not be combined with maximum size (%s provided)", j3);
        }
        this.f83451f = (Weigher) Preconditions.t(weigher);
        return this;
    }

    public Cache a() {
        d();
        c();
        return new LocalCache.LocalManualCache(this);
    }

    public LoadingCache b(CacheLoader cacheLoader) {
        d();
        return new LocalCache.LocalLoadingCache(this, cacheLoader);
    }

    public CacheBuilder e(int i3) {
        int i4 = this.f83448c;
        Preconditions.B(i4 == -1, "concurrency level was already set to %s", i4);
        Preconditions.d(i3 > 0);
        this.f83448c = i3;
        return this;
    }

    public CacheBuilder f(long j3, TimeUnit timeUnit) {
        long j4 = this.f83455j;
        Preconditions.C(j4 == -1, "expireAfterAccess was already set to %s ns", j4);
        Preconditions.l(j3 >= 0, "duration cannot be negative: %s %s", j3, timeUnit);
        this.f83455j = timeUnit.toNanos(j3);
        return this;
    }

    public CacheBuilder g(long j3, TimeUnit timeUnit) {
        long j4 = this.f83454i;
        Preconditions.C(j4 == -1, "expireAfterWrite was already set to %s ns", j4);
        Preconditions.l(j3 >= 0, "duration cannot be negative: %s %s", j3, timeUnit);
        this.f83454i = timeUnit.toNanos(j3);
        return this;
    }

    int h() {
        int i3 = this.f83448c;
        if (i3 == -1) {
            return 4;
        }
        return i3;
    }

    long i() {
        long j3 = this.f83455j;
        if (j3 == -1) {
            return 0L;
        }
        return j3;
    }

    long j() {
        long j3 = this.f83454i;
        if (j3 == -1) {
            return 0L;
        }
        return j3;
    }

    int k() {
        int i3 = this.f83447b;
        if (i3 == -1) {
            return 16;
        }
        return i3;
    }

    Equivalence l() {
        return (Equivalence) MoreObjects.a(this.f83457l, m().b());
    }

    LocalCache.Strength m() {
        return (LocalCache.Strength) MoreObjects.a(this.f83452g, LocalCache.Strength.STRONG);
    }

    long n() {
        if (this.f83454i == 0 || this.f83455j == 0) {
            return 0L;
        }
        return this.f83451f == null ? this.f83449d : this.f83450e;
    }

    long o() {
        long j3 = this.f83456k;
        if (j3 == -1) {
            return 0L;
        }
        return j3;
    }

    RemovalListener p() {
        return (RemovalListener) MoreObjects.a(this.f83459n, NullListener.INSTANCE);
    }

    Supplier q() {
        return this.f83461p;
    }

    Ticker r(boolean z2) {
        Ticker ticker = this.f83460o;
        return ticker != null ? ticker : z2 ? Ticker.b() : f83445t;
    }

    Equivalence s() {
        return (Equivalence) MoreObjects.a(this.f83458m, t().b());
    }

    LocalCache.Strength t() {
        return (LocalCache.Strength) MoreObjects.a(this.f83453h, LocalCache.Strength.STRONG);
    }

    public String toString() {
        MoreObjects.ToStringHelper toStringHelperC = MoreObjects.c(this);
        int i3 = this.f83447b;
        if (i3 != -1) {
            toStringHelperC.b("initialCapacity", i3);
        }
        int i4 = this.f83448c;
        if (i4 != -1) {
            toStringHelperC.b("concurrencyLevel", i4);
        }
        long j3 = this.f83449d;
        if (j3 != -1) {
            toStringHelperC.c("maximumSize", j3);
        }
        long j4 = this.f83450e;
        if (j4 != -1) {
            toStringHelperC.c("maximumWeight", j4);
        }
        if (this.f83454i != -1) {
            toStringHelperC.d("expireAfterWrite", this.f83454i + "ns");
        }
        if (this.f83455j != -1) {
            toStringHelperC.d("expireAfterAccess", this.f83455j + "ns");
        }
        LocalCache.Strength strength = this.f83452g;
        if (strength != null) {
            toStringHelperC.d("keyStrength", Ascii.e(strength.toString()));
        }
        LocalCache.Strength strength2 = this.f83453h;
        if (strength2 != null) {
            toStringHelperC.d("valueStrength", Ascii.e(strength2.toString()));
        }
        if (this.f83457l != null) {
            toStringHelperC.k("keyEquivalence");
        }
        if (this.f83458m != null) {
            toStringHelperC.k("valueEquivalence");
        }
        if (this.f83459n != null) {
            toStringHelperC.k("removalListener");
        }
        return toStringHelperC.toString();
    }

    Weigher u() {
        return (Weigher) MoreObjects.a(this.f83451f, OneWeigher.INSTANCE);
    }

    CacheBuilder v(Equivalence equivalence) {
        Equivalence equivalence2 = this.f83457l;
        Preconditions.D(equivalence2 == null, "key equivalence was already set to %s", equivalence2);
        this.f83457l = (Equivalence) Preconditions.t(equivalence);
        return this;
    }

    public CacheBuilder x(long j3) {
        long j4 = this.f83450e;
        Preconditions.C(j4 == -1, "maximum weight was already set to %s", j4);
        long j5 = this.f83449d;
        Preconditions.C(j5 == -1, "maximum size was already set to %s", j5);
        Preconditions.e(j3 >= 0, "maximum weight must not be negative");
        this.f83450e = j3;
        return this;
    }

    public CacheBuilder z(RemovalListener removalListener) {
        Preconditions.z(this.f83459n == null);
        this.f83459n = (RemovalListener) Preconditions.t(removalListener);
        return this;
    }

    public CacheBuilder w(long j3) {
        long j4 = this.f83449d;
        Preconditions.C(j4 == -1, "maximum size was already set to %s", j4);
        long j5 = this.f83450e;
        Preconditions.C(j5 == -1, "maximum weight was already set to %s", j5);
        Preconditions.A(this.f83451f == null, KrzujOtzIk.mthAsZoJS);
        Preconditions.e(j3 >= 0, "maximum size must not be negative");
        this.f83449d = j3;
        return this;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum NullListener implements RemovalListener<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.RemovalListener
        public void a(RemovalNotification removalNotification) {
        }
    }
}
