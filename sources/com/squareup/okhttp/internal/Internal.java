package com.squareup.okhttp.internal;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.ConnectionSpec;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.internal.http.StreamAllocation;
import com.squareup.okhttp.internal.io.RealConnection;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class Internal {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f93097a = Logger.getLogger(OkHttpClient.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Internal f93098b;

    public abstract void a(Headers.Builder builder, String str);

    public abstract void b(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z2);

    public abstract boolean c(ConnectionPool connectionPool, RealConnection realConnection);

    public abstract RealConnection d(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation);

    public abstract InternalCache e(OkHttpClient okHttpClient);

    public abstract void f(ConnectionPool connectionPool, RealConnection realConnection);

    public abstract RouteDatabase g(ConnectionPool connectionPool);
}
