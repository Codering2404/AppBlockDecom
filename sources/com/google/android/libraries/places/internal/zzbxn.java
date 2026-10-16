package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbxn implements zzbnh {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f77161e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Supplier f77162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Logger f77158b = Logger.getLogger(zzbxn.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final zzbxl f77160d = new zzbxl();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Supplier f77159c = new zzbxm();

    public zzbxn() {
        Supplier supplier = f77159c;
        zzbxl zzbxlVar = f77160d;
        this.f77162a = (Supplier) Preconditions.t(supplier);
    }

    private final zzbng c(InetSocketAddress inetSocketAddress) {
        try {
            URI uri = new URI("https", null, inetSocketAddress.getHostString(), inetSocketAddress.getPort(), null, null, null);
            ProxySelector proxySelector = (ProxySelector) this.f77162a.get();
            if (proxySelector == null) {
                f77158b.logp(Level.FINE, "io.grpc.internal.ProxyDetectorImpl", "detectProxy", "proxy selector is null, so continuing without proxy lookup");
                return null;
            }
            List<Proxy> listSelect = proxySelector.select(uri);
            if (listSelect.size() > 1) {
                f77158b.logp(Level.WARNING, "io.grpc.internal.ProxyDetectorImpl", "detectProxy", "More than 1 proxy detected, gRPC will select the first one");
            }
            Proxy proxy = listSelect.get(0);
            if (proxy.type() == Proxy.Type.DIRECT) {
                return null;
            }
            InetSocketAddress inetSocketAddress2 = (InetSocketAddress) proxy.address();
            PasswordAuthentication passwordAuthenticationA = zzbxl.a(inetSocketAddress2.getHostString(), inetSocketAddress2.getAddress(), inetSocketAddress2.getPort(), "https", "", null);
            if (inetSocketAddress2.isUnresolved()) {
                inetSocketAddress2 = new InetSocketAddress(InetAddress.getByName(inetSocketAddress2.getHostName()), inetSocketAddress2.getPort());
            }
            zzbkh zzbkhVarE = zzbki.e();
            zzbkhVarE.b(inetSocketAddress);
            zzbkhVarE.a(inetSocketAddress2);
            if (passwordAuthenticationA == null) {
                return zzbkhVarE.e();
            }
            zzbkhVarE.c(passwordAuthenticationA.getUserName());
            zzbkhVarE.d(passwordAuthenticationA.getPassword() != null ? new String(passwordAuthenticationA.getPassword()) : null);
            return zzbkhVarE.e();
        } catch (URISyntaxException e3) {
            f77158b.logp(Level.WARNING, "io.grpc.internal.ProxyDetectorImpl", "detectProxy", "Failed to construct URI for proxy lookup, proceeding without proxy", (Throwable) e3);
            return null;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbnh
    public final zzbng a(SocketAddress socketAddress) {
        if (socketAddress instanceof InetSocketAddress) {
            return c((InetSocketAddress) socketAddress);
        }
        return null;
    }
}
