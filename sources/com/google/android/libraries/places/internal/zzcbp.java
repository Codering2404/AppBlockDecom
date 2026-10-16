package com.google.android.libraries.places.internal;

import com.facebook.GraphRequest;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.api.Api;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.EOFException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.URI;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.Deque;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcbp implements zzbqa, zzcau, zzccb {
    private static final Map R;
    private static final Logger S;
    static final boolean T;
    private boolean A;
    private boolean B;
    private final SocketFactory C;
    private SSLSocketFactory D;
    private HostnameVerifier E;
    private Socket F;
    private int G;
    private final Deque H;
    private final zzcch I;
    private zzbue J;
    private final Runnable K;
    private final int L;
    private final zzcal M;
    private final Map N;
    private final zzbte O;
    final zzbki P;
    int Q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Socket f77420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SSLSession f77421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InetSocketAddress f77422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f77423d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f77424e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Random f77425f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Supplier f77426g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f77427h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzcdl f77428i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private zzbwc f77429j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private zzcav f77430k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private zzccd f77431l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Object f77432m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final zzbku f77433n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f77434o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Map f77435p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Executor f77436q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final zzbzq f77437r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final ScheduledExecutorService f77438s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int f77439t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f77440u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private zzcbn f77441v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private zzbio f77442w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private zzbnp f77443x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f77444y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private zzbtd f77445z;

    static {
        EnumMap enumMap = new EnumMap(zzccv.class);
        zzccv zzccvVar = zzccv.NO_ERROR;
        zzbnp zzbnpVar = zzbnp.f76495l;
        enumMap.put(zzccvVar, zzbnpVar.e("No error: A GRPC status of OK should have been sent"));
        enumMap.put(zzccv.PROTOCOL_ERROR, zzbnpVar.e("Protocol error"));
        enumMap.put(zzccv.INTERNAL_ERROR, zzbnpVar.e("Internal error"));
        enumMap.put(zzccv.FLOW_CONTROL_ERROR, zzbnpVar.e("Flow control error"));
        enumMap.put(zzccv.STREAM_CLOSED, zzbnpVar.e("Stream closed"));
        enumMap.put(zzccv.FRAME_TOO_LARGE, zzbnpVar.e("Frame too large"));
        enumMap.put(zzccv.REFUSED_STREAM, zzbnp.f76496m.e("Refused stream"));
        enumMap.put(zzccv.CANCEL, zzbnp.f76489f.e(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED));
        enumMap.put(zzccv.COMPRESSION_ERROR, zzbnpVar.e("Compression error"));
        enumMap.put(zzccv.CONNECT_ERROR, zzbnpVar.e("Connect error"));
        enumMap.put(zzccv.ENHANCE_YOUR_CALM, zzbnp.f76493j.e("Enhance your calm"));
        enumMap.put(zzccv.INADEQUATE_SECURITY, zzbnp.f76492i.e("Inadequate security"));
        R = Collections.unmodifiableMap(enumMap);
        S = Logger.getLogger(zzcbp.class.getName());
        T = zzbsz.j("GRPC_ENABLE_PER_RPC_AUTHORITY_CHECK", false);
        try {
            Class.forName("javax.net.ssl.X509ExtendedTrustManager").getMethod("checkServerTrusted", X509Certificate[].class, String.class, Socket.class);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
        }
    }

    public zzcbp(zzcbc zzcbcVar, InetSocketAddress inetSocketAddress, String str, String str2, zzbio zzbioVar, zzbki zzbkiVar, Runnable runnable, zzbiu zzbiuVar) {
        Supplier supplier = zzbsz.f76837r;
        zzcdh zzcdhVar = new zzcdh();
        this.f77425f = new Random();
        Object obj = new Object();
        this.f77432m = obj;
        this.f77435p = new HashMap();
        this.G = 0;
        this.H = new LinkedList();
        this.N = new zzcbo(null);
        this.O = new zzcbh(this);
        this.Q = 30000;
        this.f77422c = (InetSocketAddress) Preconditions.u(inetSocketAddress, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        this.f77423d = str;
        this.f77439t = 4194304;
        this.f77427h = 65535;
        this.f77436q = (Executor) Preconditions.u(zzcbcVar.f77375b, "executor");
        this.f77437r = new zzbzq(zzcbcVar.f77375b);
        this.f77438s = (ScheduledExecutorService) Preconditions.u(zzcbcVar.f77377d, "scheduledExecutorService");
        this.f77434o = 3;
        this.C = SocketFactory.getDefault();
        this.D = zzcbcVar.f77379g;
        this.E = zzccl.f77563a;
        this.I = (zzcch) Preconditions.u(zzcbcVar.f77380h, "connectionSpec");
        this.f77426g = (Supplier) Preconditions.u(supplier, "stopwatchFactory");
        this.f77428i = (zzcdl) Preconditions.u(zzcdhVar, "variant");
        StringBuilder sb = new StringBuilder();
        if (str2 != null) {
            sb.append(str2);
            sb.append(' ');
        }
        sb.append("grpc-java-okhttp/1.77.0-SNAPSHOT");
        this.f77424e = sb.toString();
        this.P = zzbkiVar;
        this.K = (Runnable) Preconditions.u(runnable, "tooManyPingsRunnable");
        this.L = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.M = zzcbcVar.f77378f.a();
        this.f77433n = zzbku.a(zzcbp.class, inetSocketAddress.toString());
        zzbim zzbimVarB = zzbio.b();
        zzbimVarB.a(zzbsr.f76801b, zzbioVar);
        this.f77442w = zzbimVarB.c();
        synchronized (obj) {
        }
    }

    private final void G(zzcbg zzcbgVar) {
        Preconditions.A(zzcbgVar.B().N() == -1, "StreamId already assigned");
        this.f77435p.put(Integer.valueOf(this.f77434o), zzcbgVar);
        M(zzcbgVar);
        zzcbgVar.B().J(this.f77434o);
        if (zzcbgVar.C() == zzbmj.UNARY || zzcbgVar.C() == zzbmj.SERVER_STREAMING) {
            zzcbgVar.r();
        } else {
            this.f77430k.zze();
        }
        int i3 = this.f77434o;
        if (i3 < 2147483645) {
            this.f77434o = i3 + 2;
        } else {
            this.f77434o = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            a0(Api.BaseClientBuilder.API_PRIORITY_OTHER, zzccv.NO_ERROR, zzbnp.f76496m.e("Stream ids exhausted"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public final boolean X() {
        boolean z2 = false;
        while (true) {
            Deque deque = this.H;
            if (deque.isEmpty() || this.f77435p.size() >= this.G) {
                break;
            }
            G((zzcbg) deque.poll());
            z2 = true;
        }
        return z2;
    }

    private static String I(zzcfv zzcfvVar) throws EOFException {
        zzcff zzcffVar = new zzcff();
        while (zzcfvVar.A2(zzcffVar, 1L) != -1) {
            if (zzcffVar.z(zzcffVar.zzb() - 1) == 10) {
                return zzcffVar.K(Long.MAX_VALUE);
            }
        }
        throw new EOFException("\\n not found: ".concat(String.valueOf(zzcffVar.z1(zzcffVar.zzb()).g())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public final void a0(int i3, zzccv zzccvVar, zzbnp zzbnpVar) {
        synchronized (this.f77432m) {
            try {
                if (this.f77443x == null) {
                    this.f77443x = zzbnpVar;
                    this.f77429j.a(zzbnpVar);
                }
                if (zzccvVar != null && !this.f77444y) {
                    this.f77444y = true;
                    this.f77430k.Z(0, zzccvVar, new byte[0]);
                }
                Iterator it = this.f77435p.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    if (((Integer) entry.getKey()).intValue() > i3) {
                        it.remove();
                        ((zzcbg) entry.getValue()).B().x(zzbnpVar, zzbpm.REFUSED, false, new zzbmg());
                        L((zzcbg) entry.getValue());
                    }
                }
                Deque<zzcbg> deque = this.H;
                for (zzcbg zzcbgVar : deque) {
                    zzcbgVar.B().x(zzbnpVar, zzbpm.MISCARRIED, true, new zzbmg());
                    L(zzcbgVar);
                }
                deque.clear();
                K();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void K() {
        if (this.f77443x == null || !this.f77435p.isEmpty() || !this.H.isEmpty() || this.A) {
            return;
        }
        this.A = true;
        zzbue zzbueVar = this.J;
        if (zzbueVar != null) {
            zzbueVar.d();
        }
        zzbtd zzbtdVar = this.f77445z;
        if (zzbtdVar != null) {
            zzbtdVar.c(N());
            this.f77445z = null;
        }
        if (!this.f77444y) {
            this.f77444y = true;
            this.f77430k.Z(0, zzccv.NO_ERROR, new byte[0]);
        }
        this.f77430k.close();
    }

    private final void L(zzcbg zzcbgVar) {
        if (this.B && this.H.isEmpty() && this.f77435p.isEmpty()) {
            this.B = false;
            zzbue zzbueVar = this.J;
            if (zzbueVar != null) {
                zzbueVar.c();
            }
        }
        if (zzcbgVar.o()) {
            this.O.a(zzcbgVar, false);
        }
    }

    private final void M(zzcbg zzcbgVar) {
        if (!this.B) {
            this.B = true;
            zzbue zzbueVar = this.J;
            if (zzbueVar != null) {
                zzbueVar.b();
            }
        }
        if (zzcbgVar.o()) {
            this.O.a(zzcbgVar, true);
        }
    }

    private final zzbnp N() {
        synchronized (this.f77432m) {
            try {
                zzbnp zzbnpVar = this.f77443x;
                if (zzbnpVar != null) {
                    return zzbnpVar;
                }
                return zzbnp.f76496m.e("Connection closed");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static zzbnp W(zzccv zzccvVar) {
        zzbnp zzbnpVar = (zzbnp) R.get(zzccvVar);
        if (zzbnpVar != null) {
            return zzbnpVar;
        }
        zzbnp zzbnpVar2 = zzbnp.f76490g;
        int i3 = zzccvVar.f77621a;
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 26);
        sb.append("Unknown http2 error code: ");
        sb.append(i3);
        return zzbnpVar2.e(sb.toString());
    }

    final /* synthetic */ void A(Socket socket) {
        this.F = socket;
    }

    final /* synthetic */ void B(int i3) {
        this.G = i3;
    }

    final /* synthetic */ zzcch C() {
        return this.I;
    }

    final /* synthetic */ zzbue D() {
        return this.J;
    }

    final /* synthetic */ Runnable E() {
        return this.K;
    }

    final /* synthetic */ int F() {
        return this.L;
    }

    final boolean O() {
        return this.D == null;
    }

    final void P(zzcbg zzcbgVar, String str) {
        zzbnp zzbnpVar;
        zzbnp zzbnpVar2 = this.f77443x;
        if (zzbnpVar2 != null) {
            zzcbgVar.B().x(zzbnpVar2, zzbpm.MISCARRIED, true, new zzbmg());
            return;
        }
        if ((this.F instanceof SSLSocket) && !str.equals(this.f77423d)) {
            Map map = this.N;
            if (map.containsKey(str)) {
                zzbnpVar = (zzbnp) map.get(str);
            } else {
                zzbnp zzbnpVarE = this.E.verify(str, ((SSLSocket) this.F).getSession()) ? zzbnp.f76488e : zzbnp.f76496m.e(String.format("HostNameVerifier verification failed for authority '%s'", str));
                if (!zzbnpVarE.j() && !T) {
                    S.logp(Level.WARNING, "io.grpc.okhttp.OkHttpClientTransport", "verifyAuthority", String.format("HostNameVerifier verification failed for authority '%s'. This will be an error in the future.", str));
                }
                if (zzbnpVarE.j()) {
                    zzbnpVarE = zzbnp.f76496m.e(String.format("Could not verify authority '%s' for the rpc with no X509TrustManager available", str));
                }
                map.put(str, zzbnpVarE);
                zzbnpVar = zzbnpVarE;
            }
            if (!zzbnpVar.j() && T) {
                zzcbgVar.B().x(zzbnpVar, zzbpm.PROCESSED, true, new zzbmg());
                return;
            }
        }
        if (this.f77435p.size() < this.G) {
            G(zzcbgVar);
        } else {
            this.H.add(zzcbgVar);
            M(zzcbgVar);
        }
    }

    final void Q(zzcbg zzcbgVar) {
        this.H.remove(zzcbgVar);
        L(zzcbgVar);
    }

    final String R() {
        String str = this.f77423d;
        URI uriB = zzbsz.b(str);
        return uriB.getHost() != null ? uriB.getHost() : str;
    }

    final int S() {
        URI uriB = zzbsz.b(this.f77423d);
        return uriB.getPort() != -1 ? uriB.getPort() : this.f77422c.getPort();
    }

    final void T(int i3, zzbnp zzbnpVar, zzbpm zzbpmVar, boolean z2, zzccv zzccvVar, zzbmg zzbmgVar) {
        synchronized (this.f77432m) {
            try {
                zzcbg zzcbgVar = (zzcbg) this.f77435p.remove(Integer.valueOf(i3));
                if (zzcbgVar != null) {
                    if (zzccvVar != null) {
                        this.f77430k.G(i3, zzccv.CANCEL);
                    }
                    if (zzbnpVar != null) {
                        zzcbf zzcbfVarB = zzcbgVar.B();
                        if (zzbmgVar == null) {
                            zzbmgVar = new zzbmg();
                        }
                        zzcbfVarB.x(zzbnpVar, zzbpmVar, z2, zzbmgVar);
                    }
                    if (!X()) {
                        K();
                    }
                    L(zzcbgVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    final boolean U(int i3) {
        boolean z2;
        synchronized (this.f77432m) {
            z2 = false;
            if (i3 < this.f77434o && (i3 & 1) == 1) {
                z2 = true;
            }
        }
        return z2;
    }

    final zzcbg V(int i3) {
        zzcbg zzcbgVar;
        synchronized (this.f77432m) {
            zzcbgVar = (zzcbg) this.f77435p.get(Integer.valueOf(i3));
        }
        return zzcbgVar;
    }

    final /* synthetic */ Socket Y(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, String str, String str2) throws zzbnq {
        Socket socketCreateSocket;
        int i3;
        String strSubstring;
        try {
            socketCreateSocket = inetSocketAddress2.getAddress() != null ? this.C.createSocket(inetSocketAddress2.getAddress(), inetSocketAddress2.getPort()) : this.C.createSocket(inetSocketAddress2.getHostName(), inetSocketAddress2.getPort());
            try {
                socketCreateSocket.setTcpNoDelay(true);
                socketCreateSocket.setSoTimeout(this.Q);
                zzcfv zzcfvVarB = zzcfl.b(socketCreateSocket);
                zzcfg zzcfgVarD = zzcfl.d(zzcfl.a(socketCreateSocket));
                zzcdm zzcdmVar = new zzcdm();
                zzcdmVar.a("https");
                zzcdmVar.b(inetSocketAddress.getHostName());
                zzcdmVar.c(inetSocketAddress.getPort());
                zzcdn zzcdnVarE = zzcdmVar.e();
                zzcdo zzcdoVar = new zzcdo();
                zzcdoVar.a(zzcdnVarE);
                String strA = zzcdnVarE.a();
                int iB = zzcdnVarE.b();
                StringBuilder sb = new StringBuilder(String.valueOf(strA).length() + 1 + String.valueOf(iB).length());
                sb.append(strA);
                sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
                sb.append(iB);
                zzcdoVar.b("Host", sb.toString());
                zzcdoVar.b(GraphRequest.USER_AGENT_HEADER, this.f77424e);
                if (str != null && str2 != null) {
                    try {
                        StringBuilder sb2 = new StringBuilder(str.length() + 1 + str2.length());
                        sb2.append(str);
                        sb2.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
                        sb2.append(str2);
                        byte[] bytes = sb2.toString().getBytes("ISO-8859-1");
                        zzcfj zzcfjVar = zzcfj.f77742d;
                        String strF = zzcfi.b(bytes).f();
                        StringBuilder sb3 = new StringBuilder(strF.length() + 6);
                        sb3.append("Basic ");
                        sb3.append(strF);
                        zzcdoVar.b("Proxy-Authorization", sb3.toString());
                    } catch (UnsupportedEncodingException unused) {
                        throw new AssertionError();
                    }
                }
                zzcdp zzcdpVarC = zzcdoVar.c();
                zzcdn zzcdnVarA = zzcdpVarC.a();
                zzcfgVarD.zzH(String.format(Locale.US, "CONNECT %s:%d HTTP/1.1", zzcdnVarA.a(), Integer.valueOf(zzcdnVarA.b()))).zzH("\r\n");
                int iA = zzcdpVarC.b().a();
                for (int i4 = 0; i4 < iA; i4++) {
                    zzcfgVarD.zzH(zzcdpVarC.b().b(i4)).zzH(": ").zzH(zzcdpVarC.b().c(i4)).zzH("\r\n");
                }
                zzcfgVarD.zzH("\r\n");
                zzcfgVarD.flush();
                String strI = I(zzcfvVarB);
                if (strI.startsWith("HTTP/1.")) {
                    i3 = 9;
                    if (strI.length() < 9 || strI.charAt(8) != ' ') {
                        throw new ProtocolException("Unexpected status line: ".concat(strI));
                    }
                    int iCharAt = strI.charAt(7) - '0';
                    if (iCharAt != 0 && iCharAt != 1) {
                        throw new ProtocolException("Unexpected status line: ".concat(strI));
                    }
                    zzccs zzccsVar = zzccs.HTTP_1_0;
                } else {
                    if (!strI.startsWith("ICY ")) {
                        throw new ProtocolException("Unexpected status line: ".concat(strI));
                    }
                    zzccs zzccsVar2 = zzccs.HTTP_1_0;
                    i3 = 4;
                }
                int i5 = i3 + 3;
                if (strI.length() < i5) {
                    throw new ProtocolException("Unexpected status line: ".concat(strI));
                }
                try {
                    int i6 = Integer.parseInt(strI.substring(i3, i5));
                    if (strI.length() <= i5) {
                        strSubstring = "";
                    } else {
                        if (strI.charAt(i5) != ' ') {
                            throw new ProtocolException("Unexpected status line: ".concat(strI));
                        }
                        strSubstring = strI.substring(i3 + 4);
                    }
                    while (!I(zzcfvVarB).equals("")) {
                    }
                    if (i6 >= 200 && i6 < 300) {
                        socketCreateSocket.setSoTimeout(0);
                        return socketCreateSocket;
                    }
                    zzcff zzcffVar = new zzcff();
                    try {
                        socketCreateSocket.shutdownOutput();
                        zzcfvVarB.A2(zzcffVar, 1024L);
                    } catch (IOException e3) {
                        String string = e3.toString();
                        StringBuilder sb4 = new StringBuilder(String.valueOf(string).length() + 21);
                        sb4.append("Unable to read body: ");
                        sb4.append(string);
                        zzcffVar.N(sb4.toString());
                    }
                    try {
                        socketCreateSocket.close();
                    } catch (IOException unused2) {
                    }
                    throw new zzbnq(zzbnp.f76496m.e(String.format(Locale.US, "Response returned from proxy was not successful (expected 2xx, got %d %s). Response body:\n%s", Integer.valueOf(i6), strSubstring, zzcffVar.F())), null);
                } catch (NumberFormatException unused3) {
                    throw new ProtocolException("Unexpected status line: ".concat(strI));
                }
            } catch (IOException e4) {
                e = e4;
                if (socketCreateSocket != null) {
                    zzbsz.h(socketCreateSocket);
                }
                throw new zzbnq(zzbnp.f76496m.e("Failed trying to connect with proxy").d(e), null);
            }
        } catch (IOException e5) {
            e = e5;
            socketCreateSocket = null;
        }
    }

    final /* synthetic */ void Z(zzccv zzccvVar, String str) {
        a0(0, zzccvVar, W(zzccvVar).f(str));
    }

    @Override // com.google.android.libraries.places.internal.zzbwd
    public final void a(zzbnp zzbnpVar) {
        synchronized (this.f77432m) {
            try {
                if (this.f77443x != null) {
                    return;
                }
                this.f77443x = zzbnpVar;
                this.f77429j.a(zzbnpVar);
                K();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbwd
    public final Runnable b(zzbwc zzbwcVar) throws Throwable {
        this.f77429j = (zzbwc) Preconditions.u(zzbwcVar, "listener");
        zzcat zzcatVarA = zzcat.a(this.f77437r, this, ColorExtractionConstants.MAX_PIXEL_SAMPLES);
        zzcar zzcarVar = new zzcar(zzcatVarA, this.f77428i.a(zzcfl.d(zzcatVarA), true));
        synchronized (this.f77432m) {
            try {
                zzcav zzcavVar = new zzcav(this, zzcarVar);
                this.f77430k = zzcavVar;
                this.f77431l = new zzccd(this, zzcavVar);
            } catch (Throwable th) {
                th = th;
                while (true) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        CountDownLatch countDownLatch2 = new CountDownLatch(1);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        this.f77437r.execute(new zzcbk(this, countDownLatch, cyclicBarrier, zzcatVarA, countDownLatch2));
        this.f77436q.execute(new zzcbl(this, cyclicBarrier, countDownLatch2));
        try {
            synchronized (this.f77432m) {
                this.f77430k.zzd();
                zzcdk zzcdkVar = new zzcdk();
                zzcdkVar.a(7, 0, this.f77427h);
                this.f77430k.T0(zzcdkVar);
            }
            countDownLatch.countDown();
            this.f77437r.execute(new zzcbm(this));
            return null;
        } catch (Throwable th3) {
            countDownLatch.countDown();
            throw th3;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbwd
    public final void c(zzbnp zzbnpVar) {
        a(zzbnpVar);
        synchronized (this.f77432m) {
            try {
                Iterator it = this.f77435p.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    it.remove();
                    ((zzcbg) entry.getValue()).B().x(zzbnpVar, zzbpm.PROCESSED, false, new zzbmg());
                    L((zzcbg) entry.getValue());
                }
                Deque<zzcbg> deque = this.H;
                for (zzcbg zzcbgVar : deque) {
                    zzcbgVar.B().x(zzbnpVar, zzbpm.MISCARRIED, true, new zzbmg());
                    L(zzcbgVar);
                }
                deque.clear();
                K();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    final /* synthetic */ Socket c0() {
        return this.f77420a;
    }

    @Override // com.google.android.libraries.places.internal.zzcau
    public final void d(Throwable th) {
        Preconditions.u(th, "failureCause");
        a0(0, zzccv.INTERNAL_ERROR, zzbnp.f76496m.d(th));
    }

    final /* synthetic */ void d0(Socket socket) {
        this.f77420a = socket;
    }

    @Override // com.google.android.libraries.places.internal.zzbpo
    public final /* bridge */ /* synthetic */ zzbpl e(zzbml zzbmlVar, zzbmg zzbmgVar, zzbis zzbisVar, zzbje[] zzbjeVarArr) {
        zzcbg zzcbgVar;
        Preconditions.u(zzbmlVar, GraphRequest.BATCH_METHOD_PARAM);
        Preconditions.u(zzbmgVar, "headers");
        zzcaa zzcaaVarA = zzcaa.a(zzbjeVarArr, this.f77442w, zzbmgVar);
        Object obj = this.f77432m;
        synchronized (obj) {
            zzcbgVar = new zzcbg(zzbmlVar, zzbmgVar, this.f77430k, this, this.f77431l, obj, this.f77439t, this.f77427h, this.f77423d, this.f77424e, zzcaaVarA, this.M, zzbisVar, false);
        }
        return zzcbgVar;
    }

    final /* synthetic */ SSLSession e0() {
        return this.f77421b;
    }

    final /* synthetic */ InetSocketAddress f() {
        return this.f77422c;
    }

    final /* synthetic */ void f0(SSLSession sSLSession) {
        this.f77421b = sSLSession;
    }

    final /* synthetic */ int g() {
        return this.f77427h;
    }

    final /* synthetic */ zzcdl h() {
        return this.f77428i;
    }

    final /* synthetic */ zzbwc i() {
        return this.f77429j;
    }

    final /* synthetic */ zzcav j() {
        return this.f77430k;
    }

    final /* synthetic */ zzccd k() {
        return this.f77431l;
    }

    final /* synthetic */ Object l() {
        return this.f77432m;
    }

    final /* synthetic */ Map m() {
        return this.f77435p;
    }

    final /* synthetic */ Executor n() {
        return this.f77436q;
    }

    final /* synthetic */ int o() {
        return this.f77440u;
    }

    final /* synthetic */ void p(int i3) {
        this.f77440u = i3;
    }

    final /* synthetic */ zzcbn q() {
        return this.f77441v;
    }

    final /* synthetic */ void r(zzcbn zzcbnVar) {
        this.f77441v = zzcbnVar;
    }

    final /* synthetic */ zzbio s() {
        return this.f77442w;
    }

    final /* synthetic */ void t(zzbio zzbioVar) {
        this.f77442w = zzbioVar;
    }

    public final String toString() {
        return MoreObjects.c(this).c("logId", this.f77433n.c()).d(IntegrityManager.INTEGRITY_TYPE_ADDRESS, this.f77422c).toString();
    }

    final /* synthetic */ zzbnp u() {
        return this.f77443x;
    }

    final /* synthetic */ zzbtd v() {
        return this.f77445z;
    }

    final /* synthetic */ void w(zzbtd zzbtdVar) {
        this.f77445z = null;
    }

    final /* synthetic */ SocketFactory x() {
        return this.C;
    }

    final /* synthetic */ SSLSocketFactory y() {
        return this.D;
    }

    final /* synthetic */ HostnameVerifier z() {
        return this.E;
    }

    @Override // com.google.android.libraries.places.internal.zzbkz
    public final zzbku zzc() {
        return this.f77433n;
    }

    @Override // com.google.android.libraries.places.internal.zzbqa
    public final zzbio zzf() {
        return this.f77442w;
    }

    @Override // com.google.android.libraries.places.internal.zzccb
    public final zzcca[] zzm() {
        zzcca[] zzccaVarArr;
        synchronized (this.f77432m) {
            try {
                Map map = this.f77435p;
                zzccaVarArr = new zzcca[map.size()];
                Iterator it = map.values().iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    zzccaVarArr[i3] = ((zzcbg) it.next()).B().O();
                    i3++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzccaVarArr;
    }
}
