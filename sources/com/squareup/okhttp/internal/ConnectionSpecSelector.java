package com.squareup.okhttp.internal;

import com.squareup.okhttp.ConnectionSpec;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class ConnectionSpecSelector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f93047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f93048b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f93049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f93050d;

    public ConnectionSpecSelector(List list) {
        this.f93047a = list;
    }

    private boolean c(SSLSocket sSLSocket) {
        for (int i3 = this.f93048b; i3 < this.f93047a.size(); i3++) {
            if (((ConnectionSpec) this.f93047a.get(i3)).g(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public ConnectionSpec a(SSLSocket sSLSocket) throws UnknownServiceException {
        ConnectionSpec connectionSpec;
        int i3 = this.f93048b;
        int size = this.f93047a.size();
        while (true) {
            if (i3 >= size) {
                connectionSpec = null;
                break;
            }
            connectionSpec = (ConnectionSpec) this.f93047a.get(i3);
            if (connectionSpec.g(sSLSocket)) {
                this.f93048b = i3 + 1;
                break;
            }
            i3++;
        }
        if (connectionSpec != null) {
            this.f93049c = c(sSLSocket);
            Internal.f93098b.b(connectionSpec, sSLSocket, this.f93050d);
            return connectionSpec;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f93050d + ", modes=" + this.f93047a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean b(IOException iOException) {
        this.f93050d = true;
        if (!this.f93049c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z2 = iOException instanceof SSLHandshakeException;
        if ((z2 && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z2 || (iOException instanceof SSLProtocolException);
    }
}
