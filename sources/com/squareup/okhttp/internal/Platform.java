package com.squareup.okhttp.internal;

import com.squareup.okhttp.Protocol;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.net.ssl.SSLSocket;
import okio.Buffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class Platform {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Platform f93103a = e();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Android extends Platform {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final OptionalMethod f93104b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final OptionalMethod f93105c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Method f93106d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Method f93107e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final OptionalMethod f93108f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final OptionalMethod f93109g;

        public Android(OptionalMethod optionalMethod, OptionalMethod optionalMethod2, Method method, Method method2, OptionalMethod optionalMethod3, OptionalMethod optionalMethod4) {
            this.f93104b = optionalMethod;
            this.f93105c = optionalMethod2;
            this.f93106d = method;
            this.f93107e = method2;
            this.f93108f = optionalMethod3;
            this.f93109g = optionalMethod4;
        }

        @Override // com.squareup.okhttp.internal.Platform
        public void c(SSLSocket sSLSocket, String str, List list) {
            if (str != null) {
                this.f93104b.e(sSLSocket, Boolean.TRUE);
                this.f93105c.e(sSLSocket, str);
            }
            OptionalMethod optionalMethod = this.f93109g;
            if (optionalMethod == null || !optionalMethod.g(sSLSocket)) {
                return;
            }
            this.f93109g.f(sSLSocket, Platform.b(list));
        }

        @Override // com.squareup.okhttp.internal.Platform
        public void d(Socket socket, InetSocketAddress inetSocketAddress, int i3) throws IOException {
            try {
                socket.connect(inetSocketAddress, i3);
            } catch (AssertionError e3) {
                if (!Util.o(e3)) {
                    throw e3;
                }
                throw new IOException(e3);
            } catch (SecurityException e4) {
                IOException iOException = new IOException("Exception in connect");
                iOException.initCause(e4);
                throw iOException;
            }
        }

        @Override // com.squareup.okhttp.internal.Platform
        public String h(SSLSocket sSLSocket) {
            byte[] bArr;
            OptionalMethod optionalMethod = this.f93108f;
            if (optionalMethod == null || !optionalMethod.g(sSLSocket) || (bArr = (byte[]) this.f93108f.f(sSLSocket, new Object[0])) == null) {
                return null;
            }
            return new String(bArr, Util.f93121c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class JdkWithJettyBootPlatform extends Platform {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Method f93110b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Method f93111c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Method f93112d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Class f93113e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Class f93114f;

        public JdkWithJettyBootPlatform(Method method, Method method2, Method method3, Class cls, Class cls2) {
            this.f93110b = method;
            this.f93111c = method2;
            this.f93112d = method3;
            this.f93113e = cls;
            this.f93114f = cls2;
        }

        @Override // com.squareup.okhttp.internal.Platform
        public void a(SSLSocket sSLSocket) {
            try {
                this.f93112d.invoke(null, sSLSocket);
            } catch (IllegalAccessException | InvocationTargetException unused) {
                throw new AssertionError();
            }
        }

        @Override // com.squareup.okhttp.internal.Platform
        public void c(SSLSocket sSLSocket, String str, List list) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                Protocol protocol = (Protocol) list.get(i3);
                if (protocol != Protocol.HTTP_1_0) {
                    arrayList.add(protocol.toString());
                }
            }
            try {
                this.f93110b.invoke(null, sSLSocket, Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.f93113e, this.f93114f}, new JettyNegoProvider(arrayList)));
            } catch (IllegalAccessException | InvocationTargetException e3) {
                throw new AssertionError(e3);
            }
        }

        @Override // com.squareup.okhttp.internal.Platform
        public String h(SSLSocket sSLSocket) {
            try {
                JettyNegoProvider jettyNegoProvider = (JettyNegoProvider) Proxy.getInvocationHandler(this.f93111c.invoke(null, sSLSocket));
                if (!jettyNegoProvider.f93116b && jettyNegoProvider.f93117c == null) {
                    Internal.f93097a.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
                    return null;
                }
                if (jettyNegoProvider.f93116b) {
                    return null;
                }
                return jettyNegoProvider.f93117c;
            } catch (IllegalAccessException | InvocationTargetException unused) {
                throw new AssertionError();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class JettyNegoProvider implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f93115a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f93116b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f93117c;

        public JettyNegoProvider(List list) {
            this.f93115a = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = Util.f93120b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f93116b = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.f93115a;
            }
            if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof List) {
                    List list = (List) obj2;
                    int size = list.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        if (this.f93115a.contains(list.get(i3))) {
                            String str = (String) list.get(i3);
                            this.f93117c = str;
                            return str;
                        }
                    }
                    String str2 = (String) this.f93115a.get(0);
                    this.f93117c = str2;
                    return str2;
                }
            }
            if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                return method.invoke(this, objArr);
            }
            this.f93117c = (String) objArr[0];
            return null;
        }
    }

    static byte[] b(List list) {
        Buffer buffer = new Buffer();
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            Protocol protocol = (Protocol) list.get(i3);
            if (protocol != Protocol.HTTP_1_0) {
                buffer.writeByte(protocol.toString().length());
                buffer.C0(protocol.toString());
            }
        }
        return buffer.D1();
    }

    private static Platform e() {
        Method method;
        OptionalMethod optionalMethod;
        Method method2;
        try {
            try {
                try {
                    Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
                } catch (ClassNotFoundException unused) {
                    Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
                    Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
                    return new JdkWithJettyBootPlatform(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
                }
            } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                return new Platform();
            }
        } catch (ClassNotFoundException unused3) {
            Class.forName("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
        }
        OptionalMethod optionalMethod2 = new OptionalMethod(null, "setUseSessionTickets", Boolean.TYPE);
        OptionalMethod optionalMethod3 = null;
        OptionalMethod optionalMethod4 = new OptionalMethod(null, "setHostname", String.class);
        try {
            Class<?> cls3 = Class.forName("android.net.TrafficStats");
            method2 = cls3.getMethod("tagSocket", Socket.class);
            try {
                method = cls3.getMethod("untagSocket", Socket.class);
                try {
                    Class.forName("android.net.Network");
                    optionalMethod = new OptionalMethod(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                    try {
                        optionalMethod3 = new OptionalMethod(null, "setAlpnProtocols", byte[].class);
                    } catch (ClassNotFoundException | NoSuchMethodException unused4) {
                    }
                } catch (ClassNotFoundException | NoSuchMethodException unused5) {
                    optionalMethod = null;
                }
            } catch (ClassNotFoundException | NoSuchMethodException unused6) {
                method = null;
                optionalMethod = null;
            }
        } catch (ClassNotFoundException | NoSuchMethodException unused7) {
            method = null;
            optionalMethod = null;
            method2 = null;
        }
        return new Android(optionalMethod2, optionalMethod4, method2, method, optionalMethod, optionalMethod3);
    }

    public static Platform f() {
        return f93103a;
    }

    public void d(Socket socket, InetSocketAddress inetSocketAddress, int i3) {
        socket.connect(inetSocketAddress, i3);
    }

    public String g() {
        return "OkHttp";
    }

    public String h(SSLSocket sSLSocket) {
        return null;
    }

    public void i(String str) {
        System.out.println(str);
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void c(SSLSocket sSLSocket, String str, List list) {
    }
}
