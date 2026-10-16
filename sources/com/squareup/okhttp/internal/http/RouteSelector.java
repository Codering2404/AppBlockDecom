package com.squareup.okhttp.internal.http;

import com.revenuecat.purchases.common.Constants;
import com.squareup.okhttp.Address;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.RouteDatabase;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class RouteSelector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Address f93409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RouteDatabase f93410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Proxy f93411c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private InetSocketAddress f93412d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List f93413e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f93414f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List f93415g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f93416h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f93417i;

    public RouteSelector(Address address, RouteDatabase routeDatabase) {
        List list = Collections.EMPTY_LIST;
        this.f93413e = list;
        this.f93415g = list;
        this.f93417i = new ArrayList();
        this.f93409a = address;
        this.f93410b = routeDatabase;
        l(address.m(), address.g());
    }

    static String b(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        return address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
    }

    private boolean d() {
        return this.f93416h < this.f93415g.size();
    }

    private boolean e() {
        return !this.f93417i.isEmpty();
    }

    private boolean f() {
        return this.f93414f < this.f93413e.size();
    }

    private InetSocketAddress h() throws SocketException {
        if (d()) {
            List list = this.f93415g;
            int i3 = this.f93416h;
            this.f93416h = i3 + 1;
            return (InetSocketAddress) list.get(i3);
        }
        throw new SocketException("No route to " + this.f93409a.k() + "; exhausted inet socket addresses: " + this.f93415g);
    }

    private Route i() {
        return (Route) this.f93417i.remove(0);
    }

    private Proxy j() throws SocketException {
        if (f()) {
            List list = this.f93413e;
            int i3 = this.f93414f;
            this.f93414f = i3 + 1;
            Proxy proxy = (Proxy) list.get(i3);
            k(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f93409a.k() + "; exhausted proxy configurations: " + this.f93413e);
    }

    private void k(Proxy proxy) throws SocketException {
        String strK;
        int iL;
        this.f93415g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            strK = this.f93409a.k();
            iL = this.f93409a.l();
        } else {
            SocketAddress socketAddressAddress = proxy.address();
            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
            strK = b(inetSocketAddress);
            iL = inetSocketAddress.getPort();
        }
        if (iL < 1 || iL > 65535) {
            throw new SocketException("No route to " + strK + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + iL + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.f93415g.add(InetSocketAddress.createUnresolved(strK, iL));
        } else {
            List listA = this.f93409a.d().a(strK);
            int size = listA.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.f93415g.add(new InetSocketAddress((InetAddress) listA.get(i3), iL));
            }
        }
        this.f93416h = 0;
    }

    private void l(HttpUrl httpUrl, Proxy proxy) {
        if (proxy != null) {
            this.f93413e = Collections.singletonList(proxy);
        } else {
            this.f93413e = new ArrayList();
            List<Proxy> listSelect = this.f93409a.h().select(httpUrl.F());
            if (listSelect != null) {
                this.f93413e.addAll(listSelect);
            }
            List list = this.f93413e;
            Proxy proxy2 = Proxy.NO_PROXY;
            list.removeAll(Collections.singleton(proxy2));
            this.f93413e.add(proxy2);
        }
        this.f93414f = 0;
    }

    public void a(Route route, IOException iOException) {
        if (route.b().type() != Proxy.Type.DIRECT && this.f93409a.h() != null) {
            this.f93409a.h().connectFailed(this.f93409a.m().F(), route.b().address(), iOException);
        }
        this.f93410b.b(route);
    }

    public boolean c() {
        return d() || f() || e();
    }

    public Route g() throws SocketException {
        if (!d()) {
            if (!f()) {
                if (e()) {
                    return i();
                }
                throw new NoSuchElementException();
            }
            this.f93411c = j();
        }
        InetSocketAddress inetSocketAddressH = h();
        this.f93412d = inetSocketAddressH;
        Route route = new Route(this.f93409a, this.f93411c, inetSocketAddressH);
        if (!this.f93410b.c(route)) {
            return route;
        }
        this.f93417i.add(route);
        return g();
    }
}
