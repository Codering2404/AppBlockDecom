package com.google.android.libraries.places.internal;

import com.facebook.internal.ServerProtocol;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbse extends zzbmy {
    private static final zzbsd A;
    private static String B;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final Logger f76760s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final Set f76761t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String f76762u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final String f76763v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final String f76764w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    static final boolean f76765x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    static final boolean f76766y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    protected static final boolean f76767z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final zzbnh f76768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Random f76769c = new Random();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected volatile zzbru f76770d = zzbrw.INSTANCE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicReference f76771e = new AtomicReference();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f76772f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f76773g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f76774h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzbwo f76775i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f76776j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final zzbnx f76777k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final zzbmx f76778l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Stopwatch f76779m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected boolean f76780n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f76781o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Executor f76782p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f76783q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private zzbmu f76784r;

    static {
        Logger logger = Logger.getLogger(zzbse.class.getName());
        f76760s = logger;
        f76761t = Collections.unmodifiableSet(new HashSet(Arrays.asList("clientLanguage", "percentage", "clientHostname", "serviceConfig")));
        String property = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        f76762u = property;
        String property2 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi_localhost", "false");
        f76763v = property2;
        String property3 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_service_config", "false");
        f76764w = property3;
        f76765x = Boolean.parseBoolean(property);
        f76766y = Boolean.parseBoolean(property2);
        f76767z = Boolean.parseBoolean(property3);
        zzbsd zzbsdVar = null;
        try {
            try {
                try {
                    zzbsd zzbsdVar2 = (zzbsd) Class.forName("io.grpc.internal.JndiResourceResolverFactory", true, zzbse.class.getClassLoader()).asSubclass(zzbsd.class).getConstructor(null).newInstance(null);
                    if (zzbsdVar2.zzb() != null) {
                        logger.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "getResourceResolverFactory", "JndiResourceResolverFactory not available, skipping.", zzbsdVar2.zzb());
                    } else {
                        zzbsdVar = zzbsdVar2;
                    }
                } catch (Exception e3) {
                    f76760s.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "getResourceResolverFactory", "Can't construct JndiResourceResolverFactory, skipping.", (Throwable) e3);
                }
            } catch (Exception e4) {
                f76760s.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "getResourceResolverFactory", "Can't find JndiResourceResolverFactory ctor, skipping.", (Throwable) e4);
            }
        } catch (ClassCastException e5) {
            f76760s.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "getResourceResolverFactory", "Unable to cast JndiResourceResolverFactory, skipping.", (Throwable) e5);
        } catch (ClassNotFoundException e6) {
            f76760s.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "getResourceResolverFactory", "Unable to find JndiResourceResolverFactory, skipping.", (Throwable) e6);
        }
        A = zzbsdVar;
    }

    protected zzbse(String str, String str2, zzbmr zzbmrVar, zzbzx zzbzxVar, Stopwatch stopwatch, boolean z2) {
        Preconditions.u(zzbmrVar, "args");
        URI uriCreate = URI.create("//".concat(String.valueOf((String) Preconditions.u(str2, "name"))));
        Preconditions.m(uriCreate.getHost() != null, "Invalid DNS name: %s", str2);
        this.f76772f = (String) Preconditions.v(uriCreate.getAuthority(), "nameUri (%s) doesn't have an authority", uriCreate);
        this.f76773g = uriCreate.getHost();
        if (uriCreate.getPort() == -1) {
            this.f76774h = zzbmrVar.a();
        } else {
            this.f76774h = uriCreate.getPort();
        }
        this.f76768b = (zzbnh) Preconditions.u(zzbmrVar.b(), "proxyDetector");
        Executor executorF = zzbmrVar.f();
        if (executorF != null) {
            this.f76775i = new zzbsk(executorF);
        } else {
            this.f76775i = zzbzz.a(zzbzxVar);
        }
        long nanos = 0;
        if (!z2) {
            String property = System.getProperty("networkaddress.cache.ttl");
            long j3 = 30;
            if (property != null) {
                try {
                    j3 = Long.parseLong(property);
                } catch (NumberFormatException unused) {
                    f76760s.logp(Level.WARNING, "io.grpc.internal.DnsNameResolver", "getNetworkAddressCacheTtlNanos", "Property({0}) valid is not valid number format({1}), fall back to default({2})", new Object[]{"networkaddress.cache.ttl", property, 30L});
                }
            }
            nanos = j3 > 0 ? TimeUnit.SECONDS.toNanos(j3) : j3;
        }
        this.f76776j = nanos;
        this.f76779m = (Stopwatch) Preconditions.u(stopwatch, "stopwatch");
        this.f76777k = (zzbnx) Preconditions.u(zzbmrVar.c(), "syncContext");
        this.f76778l = (zzbmx) Preconditions.u(zzbmrVar.e(), "serviceConfigParser");
    }

    private final void m() {
        if (this.f76783q || this.f76781o) {
            return;
        }
        if (this.f76780n) {
            long j3 = this.f76776j;
            if (j3 != 0 && (j3 <= 0 || this.f76779m.e(TimeUnit.NANOSECONDS) <= j3)) {
                return;
            }
        }
        this.f76783q = true;
        this.f76782p.execute(new zzbsb(this, this.f76784r));
    }

    private static String n() {
        if (B == null) {
            try {
                B = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException e3) {
                throw new RuntimeException(e3);
            }
        }
        return B;
    }

    @Override // com.google.android.libraries.places.internal.zzbmy
    public final String a() {
        return this.f76772f;
    }

    @Override // com.google.android.libraries.places.internal.zzbmy
    public final void b(zzbmu zzbmuVar) {
        Preconditions.A(this.f76784r == null, "already started");
        this.f76782p = (Executor) this.f76775i.zza();
        this.f76784r = (zzbmu) Preconditions.u(zzbmuVar, "listener");
        m();
    }

    @Override // com.google.android.libraries.places.internal.zzbmy
    public final void c() {
        if (this.f76781o) {
            return;
        }
        this.f76781o = true;
        Executor executor = this.f76782p;
        if (executor != null) {
            this.f76775i.zzb(executor);
            this.f76782p = null;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbmy
    public final void d() {
        Preconditions.A(this.f76784r != null, "not started");
        m();
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x01d9 A[LOOP:2: B:67:0x012f->B:110:0x01d9, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0262 A[Catch: Exception -> 0x0047, TRY_ENTER, TryCatch #4 {Exception -> 0x0047, blocks: (B:4:0x0018, B:5:0x0025, B:7:0x002b, B:10:0x004a, B:137:0x0262, B:138:0x026f), top: B:143:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01d8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0191 A[Catch: RuntimeException -> 0x015d, TryCatch #3 {RuntimeException -> 0x015d, blocks: (B:69:0x0139, B:70:0x0141, B:72:0x0147, B:75:0x0160, B:77:0x0168, B:79:0x016e, B:80:0x0172, B:82:0x0178, B:86:0x0189, B:88:0x0191, B:93:0x019e, B:96:0x01ab, B:98:0x01b3, B:100:0x01b9, B:101:0x01bd, B:103:0x01c3, B:105:0x01cf, B:111:0x01dc, B:112:0x01eb), top: B:141:0x0139 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01ab A[Catch: RuntimeException -> 0x015d, TryCatch #3 {RuntimeException -> 0x015d, blocks: (B:69:0x0139, B:70:0x0141, B:72:0x0147, B:75:0x0160, B:77:0x0168, B:79:0x016e, B:80:0x0172, B:82:0x0178, B:86:0x0189, B:88:0x0191, B:93:0x019e, B:96:0x01ab, B:98:0x01b3, B:100:0x01b9, B:101:0x01bd, B:103:0x01c3, B:105:0x01cf, B:111:0x01dc, B:112:0x01eb), top: B:141:0x0139 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final com.google.android.libraries.places.internal.zzbrv e(boolean r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 650
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbse.e(boolean):com.google.android.libraries.places.internal.zzbrv");
    }

    final /* synthetic */ zzbka f() {
        zzbng zzbngVarA = this.f76768b.a(InetSocketAddress.createUnresolved(this.f76773g, this.f76774h));
        if (zzbngVarA == null) {
            return null;
        }
        return new zzbka(Collections.singletonList(zzbngVarA), zzbio.f76249c);
    }

    final /* synthetic */ String h() {
        return this.f76773g;
    }

    final /* synthetic */ long i() {
        return this.f76776j;
    }

    final /* synthetic */ zzbnx j() {
        return this.f76777k;
    }

    final /* synthetic */ Stopwatch k() {
        return this.f76779m;
    }

    final /* synthetic */ void l(boolean z2) {
        this.f76783q = false;
    }
}
