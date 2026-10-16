package com.google.android.libraries.places.internal;

import java.net.Authenticator;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbxl {
    zzbxl() {
    }

    public static final PasswordAuthentication a(String str, InetAddress inetAddress, int i3, String str2, String str3, String str4) {
        URL url;
        try {
            url = new URL("https", str, i3, "");
        } catch (MalformedURLException unused) {
            int i4 = zzbxn.f77161e;
            zzbxn.f77158b.logp(Level.WARNING, "io.grpc.internal.ProxyDetectorImpl$1", "requestPasswordAuthentication", "failed to create URL for Authenticator: {0} {1}", new Object[]{"https", str});
            url = null;
        }
        return Authenticator.requestPasswordAuthentication(str, inetAddress, i3, "https", "", null, url, Authenticator.RequestorType.PROXY);
    }
}
