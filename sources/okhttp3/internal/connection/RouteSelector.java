package okhttp3.internal.connection;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal.Util;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class RouteSelector {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Companion f144501i = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Address f144502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RouteDatabase f144503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Call f144504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EventListener f144505d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List f144506e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f144507f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List f144508g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f144509h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(InetSocketAddress inetSocketAddress) {
            Intrinsics.checkNotNullParameter(inetSocketAddress, "<this>");
            InetAddress address = inetSocketAddress.getAddress();
            if (address == null) {
                String hostName = inetSocketAddress.getHostName();
                Intrinsics.checkNotNullExpressionValue(hostName, "hostName");
                return hostName;
            }
            String hostAddress = address.getHostAddress();
            Intrinsics.checkNotNullExpressionValue(hostAddress, "address.hostAddress");
            return hostAddress;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Selection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f144510a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f144511b;

        public Selection(List routes) {
            Intrinsics.checkNotNullParameter(routes, "routes");
            this.f144510a = routes;
        }

        public final List a() {
            return this.f144510a;
        }

        public final boolean b() {
            return this.f144511b < this.f144510a.size();
        }

        public final Route c() {
            if (!b()) {
                throw new NoSuchElementException();
            }
            List list = this.f144510a;
            int i3 = this.f144511b;
            this.f144511b = i3 + 1;
            return (Route) list.get(i3);
        }
    }

    public RouteSelector(Address address, RouteDatabase routeDatabase, Call call, EventListener eventListener) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(routeDatabase, "routeDatabase");
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        this.f144502a = address;
        this.f144503b = routeDatabase;
        this.f144504c = call;
        this.f144505d = eventListener;
        this.f144506e = CollectionsKt.emptyList();
        this.f144508g = CollectionsKt.emptyList();
        this.f144509h = new ArrayList();
        f(address.l(), address.g());
    }

    private final boolean b() {
        return this.f144507f < this.f144506e.size();
    }

    private final Proxy d() throws SocketException, UnknownHostException {
        if (b()) {
            List list = this.f144506e;
            int i3 = this.f144507f;
            this.f144507f = i3 + 1;
            Proxy proxy = (Proxy) list.get(i3);
            e(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f144502a.l().i() + "; exhausted proxy configurations: " + this.f144506e);
    }

    private final void e(Proxy proxy) throws SocketException, UnknownHostException {
        String strI;
        int iN;
        List listA;
        ArrayList arrayList = new ArrayList();
        this.f144508g = arrayList;
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            strI = this.f144502a.l().i();
            iN = this.f144502a.l().n();
        } else {
            SocketAddress proxyAddress = proxy.address();
            if (!(proxyAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("Proxy.address() is not an InetSocketAddress: ", proxyAddress.getClass()).toString());
            }
            Companion companion = f144501i;
            Intrinsics.checkNotNullExpressionValue(proxyAddress, "proxyAddress");
            InetSocketAddress inetSocketAddress = (InetSocketAddress) proxyAddress;
            strI = companion.a(inetSocketAddress);
            iN = inetSocketAddress.getPort();
        }
        if (1 > iN || iN >= 65536) {
            throw new SocketException("No route to " + strI + ':' + iN + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            arrayList.add(InetSocketAddress.createUnresolved(strI, iN));
            return;
        }
        if (Util.i(strI)) {
            listA = CollectionsKt.listOf(InetAddress.getByName(strI));
        } else {
            this.f144505d.n(this.f144504c, strI);
            listA = this.f144502a.c().a(strI);
            if (listA.isEmpty()) {
                throw new UnknownHostException(this.f144502a.c() + " returned no addresses for " + strI);
            }
            this.f144505d.m(this.f144504c, strI, listA);
        }
        Iterator it = listA.iterator();
        while (it.hasNext()) {
            arrayList.add(new InetSocketAddress((InetAddress) it.next(), iN));
        }
    }

    private final void f(HttpUrl httpUrl, Proxy proxy) {
        this.f144505d.p(this.f144504c, httpUrl);
        List listG = g(proxy, httpUrl, this);
        this.f144506e = listG;
        this.f144507f = 0;
        this.f144505d.o(this.f144504c, httpUrl, listG);
    }

    private static final List g(Proxy proxy, HttpUrl httpUrl, RouteSelector routeSelector) {
        if (proxy != null) {
            return CollectionsKt.listOf(proxy);
        }
        URI uriS = httpUrl.s();
        if (uriS.getHost() == null) {
            return Util.w(Proxy.NO_PROXY);
        }
        List<Proxy> proxiesOrNull = routeSelector.f144502a.i().select(uriS);
        List<Proxy> list = proxiesOrNull;
        if (list == null || list.isEmpty()) {
            return Util.w(Proxy.NO_PROXY);
        }
        Intrinsics.checkNotNullExpressionValue(proxiesOrNull, "proxiesOrNull");
        return Util.V(proxiesOrNull);
    }

    public final boolean a() {
        return b() || !this.f144509h.isEmpty();
    }

    public final Selection c() {
        if (!a()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (b()) {
            Proxy proxyD = d();
            Iterator it = this.f144508g.iterator();
            while (it.hasNext()) {
                Route route = new Route(this.f144502a, proxyD, (InetSocketAddress) it.next());
                if (this.f144503b.c(route)) {
                    this.f144509h.add(route);
                } else {
                    arrayList.add(route);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            CollectionsKt.addAll(arrayList, this.f144509h);
            this.f144509h.clear();
        }
        return new Selection(arrayList);
    }
}
