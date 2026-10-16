package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Authenticator;
import com.squareup.okhttp.Challenge;
import com.squareup.okhttp.Credentials;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class AuthenticatorAdapter implements Authenticator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Authenticator f93310a = new AuthenticatorAdapter();

    private InetAddress c(Proxy proxy, HttpUrl httpUrl) {
        return (proxy == null || proxy.type() == Proxy.Type.DIRECT) ? InetAddress.getByName(httpUrl.q()) : ((InetSocketAddress) proxy.address()).getAddress();
    }

    @Override // com.squareup.okhttp.Authenticator
    public Request a(Proxy proxy, Response response) {
        List listM = response.m();
        Request requestW = response.w();
        HttpUrl httpUrlK = requestW.k();
        int size = listM.size();
        for (int i3 = 0; i3 < size; i3++) {
            Challenge challenge = (Challenge) listM.get(i3);
            if ("Basic".equalsIgnoreCase(challenge.b())) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) proxy.address();
                PasswordAuthentication passwordAuthenticationRequestPasswordAuthentication = java.net.Authenticator.requestPasswordAuthentication(inetSocketAddress.getHostName(), c(proxy, httpUrlK), inetSocketAddress.getPort(), httpUrlK.E(), challenge.a(), challenge.b(), httpUrlK.G(), Authenticator.RequestorType.PROXY);
                if (passwordAuthenticationRequestPasswordAuthentication != null) {
                    return requestW.n().h("Proxy-Authorization", Credentials.a(passwordAuthenticationRequestPasswordAuthentication.getUserName(), new String(passwordAuthenticationRequestPasswordAuthentication.getPassword()))).g();
                }
            }
        }
        return null;
    }

    @Override // com.squareup.okhttp.Authenticator
    public Request b(Proxy proxy, Response response) {
        PasswordAuthentication passwordAuthenticationRequestPasswordAuthentication;
        List listM = response.m();
        Request requestW = response.w();
        HttpUrl httpUrlK = requestW.k();
        int size = listM.size();
        for (int i3 = 0; i3 < size; i3++) {
            Challenge challenge = (Challenge) listM.get(i3);
            if ("Basic".equalsIgnoreCase(challenge.b()) && (passwordAuthenticationRequestPasswordAuthentication = java.net.Authenticator.requestPasswordAuthentication(httpUrlK.q(), c(proxy, httpUrlK), httpUrlK.A(), httpUrlK.E(), challenge.a(), challenge.b(), httpUrlK.G(), Authenticator.RequestorType.SERVER)) != null) {
                return requestW.n().h("Authorization", Credentials.a(passwordAuthenticationRequestPasswordAuthentication.getUserName(), new String(passwordAuthenticationRequestPasswordAuthentication.getPassword()))).g();
            }
        }
        return null;
    }
}
