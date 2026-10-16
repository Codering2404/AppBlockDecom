package com.facebook.ads.redexgen.core;

import android.net.TrafficStats;
import android.text.TextUtils;
import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Cl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0635Cl implements InterfaceC1599fv {
    public static byte[] A07;
    public static String[] A08 = {"QhNFYJC9gEUd0JRpeTZcIYaCPwaofmcY", "H7lFuH2c6lRKE1KzrEc8woYXA3m4qwgD", "VasthUCsKtAfJQ49O69n9k2VDB8sk6Ry", "CLNAbcda3kskZ9l1P61KK9o7E81JDy0P", "FTSbac7VR6oRDuoXxASKkUBG2ay4Jl1O", "oDWQMCtwqliv6oQHoqRk4BTd2HTxQUcC", "maa7C87UpzAlS2qduOc8uqrscl2NkhxH", ""};
    public static final String A09;
    public InterfaceC1059Tc A00;
    public Executor A01;
    public boolean A02;
    public C1604g0 A03;
    public final InterfaceC1609g5 A04 = new C0643Cu();
    public final InterfaceC1614gA A05;
    public final InterfaceC1615gB A06;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 15 out of bounds for length 11
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.restartVar(DebugInfoParser.java:193)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:141)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    private final InterfaceC1598fu A01(AbstractC1611g7 abstractC1611g7) throws C1612g8 {
        C1612g8 c1612g8;
        String strA07 = A07(220, 7, 86);
        HttpURLConnection httpURLConnection = null;
        C0636Cm c0636CmA05 = null;
        boolean z2 = false;
        try {
            try {
                this.A02 = false;
                HttpURLConnection httpURLConnectionA08 = A08(abstractC1611g7.A05(), XD.A04() ? A09() : null);
                A0H(httpURLConnectionA08, abstractC1611g7);
                A0G(httpURLConnectionA08, abstractC1611g7);
                if (this.A06.AAZ()) {
                    this.A06.ABt(httpURLConnectionA08, abstractC1611g7.A06());
                }
                httpURLConnectionA08.connect();
                this.A02 = true;
                Set<String> setA01 = this.A03.A01();
                Set<String> setA02 = this.A03.A02();
                boolean z3 = (setA01 == null || setA01.isEmpty()) ? false : true;
                if (setA02 != null && !setA02.isEmpty()) {
                    z2 = true;
                }
                if ((httpURLConnectionA08 instanceof HttpsURLConnection) && (z3 || z2)) {
                    try {
                        AbstractC1616gC.A03((HttpsURLConnection) httpURLConnectionA08, setA01, setA02);
                    } catch (CertificateException e3) {
                        this.A00.ABz(strA07, AbstractC1060Td.A1z, new C1061Te(e3));
                    } catch (Exception e4) {
                        this.A00.ABz(strA07, AbstractC1060Td.A1y, new C1061Te(e4));
                    }
                }
                if (httpURLConnectionA08.getDoOutput() && abstractC1611g7.A06() != null) {
                    A00(httpURLConnectionA08, abstractC1611g7.A06());
                }
                C0636Cm c0636CmA06 = httpURLConnectionA08.getDoInput() ? A06(httpURLConnectionA08) : new C0636Cm(httpURLConnectionA08, null);
                if (this.A06.AAZ()) {
                    this.A06.ABu(c0636CmA06);
                }
                if (httpURLConnectionA08 != null) {
                    httpURLConnectionA08.disconnect();
                }
                return c0636CmA06;
            } catch (Throwable th) {
                if (this.A06.AAZ()) {
                    this.A06.ABu(c0636CmA05);
                }
                if (0 != 0) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Exception e5) {
            try {
                try {
                    c0636CmA05 = A05(null);
                } catch (Throwable unused) {
                    if (c0636CmA05 == null || c0636CmA05.A9C() <= 0) {
                        throw new C1612g8(e5, c0636CmA05);
                    }
                    if (this.A06.AAZ()) {
                        this.A06.ABu(c0636CmA05);
                    }
                    if (0 != 0) {
                        httpURLConnection.disconnect();
                    }
                    return c0636CmA05;
                }
            } catch (Exception unused2) {
                Log.e(getClass().getSimpleName(), A07(117, 13, 98), e5);
                if (0 != 0 && c0636CmA05.A9C() > 0) {
                    if (this.A06.AAZ()) {
                        this.A06.ABu(null);
                    }
                    if (0 != 0) {
                        httpURLConnection.disconnect();
                    }
                    return null;
                }
                c1612g8 = new C1612g8(e5, null);
            }
            if (A08[7].length() == 19) {
                throw new RuntimeException();
            }
            A08[5] = "6Q02gTcavt1J3D6llCgnQfsLExV7BLlB";
            if (c0636CmA05 == null || c0636CmA05.A9C() <= 0) {
                c1612g8 = new C1612g8(e5, c0636CmA05);
                throw c1612g8;
            }
            if (this.A06.AAZ()) {
                this.A06.ABu(c0636CmA05);
            }
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            return c0636CmA05;
        }
    }

    public static String A07(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 17);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0A() {
        A07 = new byte[]{59, 57, 102, 107, Ascii.SO, 102, 100, 77, 64, 9, 77, 79, Ascii.RS, 93, 75, 76, 82, Ascii.RS, 42, 99, 121, 42, 100, 101, 126, 42, 107, 42, 124, 107, 102, 99, 110, 42, Framer.STDIN_REQUEST_FRAME_PREFIX, 88, 70, 80, Ascii.US, Ascii.SYN, 80, 75, Framer.EXIT_FRAME_PREFIX, 116, Ascii.ETB, 0, 116, 105, 116, 55, 59, 73, 79, 59, 38, 59, 38, 42, 126, Framer.EXIT_FRAME_PREFIX, 115, 99, 100, 109, 42, 94, 4, 34, 43, 38, 55, 52, 34, 35, 71, 51, 46, 42, 34, 71, 90, 71, 71, 101, 116, 116, 105, 110, 103, 32, 116, 104, 101, 32, 104, 116, 116, 112, 32, 114, 101, 115, 112, 111, 110, 115, 101, 32, 116, 105, 109, 101, 100, 32, 111, 117, 116, 61, Ascii.SYN, 7, 4, Ascii.FS, 1, Ascii.CAN, 83, Ascii.SYN, 1, 1, Ascii.FS, 1, Ascii.ETB, Ascii.SYN, 4, 111, 122, Ascii.SYN, 7, 7, Ascii.ESC, Ascii.RS, Ascii.DC4, Ascii.SYN, 3, Ascii.RS, Ascii.CAN, Ascii.EM, 88, Ascii.SI, 90, 0, 0, 0, 90, 17, Ascii.CAN, 5, Ascii.SUB, 90, 2, 5, Ascii.ESC, Ascii.DC2, Ascii.EM, Ascii.DC4, Ascii.CAN, 19, Ascii.DC2, 19, 76, Ascii.DC4, Ascii.US, Ascii.SYN, 5, 4, Ascii.DC2, 3, 74, 34, 35, Framer.STDOUT_FRAME_PREFIX, 90, 79, 89, 79, 72, 86, Ascii.SUB, Ascii.ETB, 81, Ascii.SUB, Ascii.ETB, 83, Framer.EXIT_FRAME_PREFIX, 100, 100, 96, 62, 96, 98, Ascii.DEL, 104, 105, 88, Ascii.DEL, 99, 100, Ascii.ESC, 7, 7, 3, 93, 3, 1, Ascii.FS, Ascii.VT, 10, 35, Ascii.FS, 1, 7, 41, 34, 51, 48, 40, 53, 44};
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x015a, code lost:
    
        r7 = r29.A00;
        r10 = java.lang.System.currentTimeMillis() - r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0163, code lost:
    
        if (r30.A04 != null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0165, code lost:
    
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0167, code lost:
    
        r7.ABo(r0, r10, 0, r2, 0, new java.util.concurrent.TimeoutException(A07(82, 35, 17)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0182, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0183, code lost:
    
        r2 = r30.A04.length;
     */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 44 out of bounds for length 31
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0150  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.core.InterfaceC1598fu A0J(com.facebook.ads.redexgen.core.AbstractC1611g7 r30) throws com.facebook.ads.redexgen.core.C1612g8 {
        /*
            Method dump skipped, instruction units count: 392
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C0635Cl.A0J(com.facebook.ads.redexgen.X.g7):com.facebook.ads.redexgen.X.fu");
    }

    static {
        A0A();
        A09 = InterfaceC1599fv.class.getSimpleName();
    }

    public C0635Cl(C1604g0 c1604g0, InterfaceC1059Tc interfaceC1059Tc, Executor executor) {
        A0B();
        this.A03 = c1604g0;
        this.A06 = new C0634Ck(c1604g0.A04());
        final InterfaceC1615gB interfaceC1615gB = this.A06;
        this.A05 = new AbstractC0642Ct(interfaceC1615gB) { // from class: com.facebook.ads.redexgen.X.2i
        };
        this.A01 = executor;
        this.A00 = interfaceC1059Tc;
    }

    private final int A00(HttpURLConnection httpURLConnection, byte[] bArr) throws Exception {
        OutputStream outputStreamAGn = null;
        try {
            outputStreamAGn = this.A05.AGn(httpURLConnection);
            if (outputStreamAGn != null) {
                this.A05.AL8(outputStreamAGn, bArr);
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (outputStreamAGn != null) {
                try {
                    outputStreamAGn.close();
                } catch (Exception unused) {
                }
            }
            return responseCode;
        } catch (Throwable th) {
            if (outputStreamAGn != null) {
                try {
                    outputStreamAGn.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    private final InterfaceC1598fu A02(AbstractC1611g7 abstractC1611g7) {
        if (this.A03.A04()) {
            A0C(abstractC1611g7);
        }
        InterfaceC1598fu interfaceC1598fuA01 = null;
        try {
            interfaceC1598fuA01 = A01(abstractC1611g7);
            return interfaceC1598fuA01;
        } catch (C1612g8 hre) {
            this.A05.ADs(hre);
            return interfaceC1598fuA01;
        } catch (Exception e3) {
            this.A05.ADs(new C1612g8(e3, interfaceC1598fuA01));
            return interfaceC1598fuA01;
        }
    }

    private final InterfaceC1598fu A03(String str, C1613g9 c1613g9, C1607g3 c1607g3) {
        return A02(new C0638Co(str, c1613g9, c1607g3));
    }

    private final InterfaceC1598fu A04(String str, String str2, byte[] bArr, C1607g3 c1607g3) {
        return A02(new C0637Cn(str, null, str2, bArr, c1607g3));
    }

    private final C0636Cm A05(HttpURLConnection httpURLConnection) throws Exception {
        InputStream errorStream = null;
        byte[] responseBody = null;
        try {
            errorStream = httpURLConnection.getErrorStream();
            if (errorStream != null) {
                responseBody = this.A05.AHT(errorStream);
            }
            C0636Cm c0636Cm = new C0636Cm(httpURLConnection, responseBody);
            if (errorStream != null) {
                try {
                    errorStream.close();
                } catch (Exception unused) {
                }
            }
            return c0636Cm;
        } catch (Throwable th) {
            if (errorStream != null) {
                try {
                    errorStream.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    private final C0636Cm A06(HttpURLConnection httpURLConnection) throws Exception {
        InputStream inputStreamAGm = null;
        byte[] responseBody = null;
        try {
            inputStreamAGm = this.A05.AGm(httpURLConnection);
            if (inputStreamAGm != null) {
                responseBody = this.A05.AHT(inputStreamAGm);
            }
            C0636Cm c0636Cm = new C0636Cm(httpURLConnection, responseBody);
            if (inputStreamAGm != null) {
                try {
                    inputStreamAGm.close();
                } catch (Exception unused) {
                }
            }
            return c0636Cm;
        } catch (Throwable th) {
            String[] strArr = A08;
            if (strArr[3].charAt(2) != strArr[0].charAt(2)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[3] = "UXNjV4lzV2ywD4tdDbD0LjxSkhTqZWDx";
            strArr2[0] = "ckNMQEffDKJwLTwRJSWHE7UL6GsW6bMO";
            if (inputStreamAGm != null) {
                try {
                    inputStreamAGm.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    private final HttpURLConnection A08(String str, Proxy proxy) throws IOException {
        try {
            new URL(str);
            TrafficStats.setThreadStatsTag(61453);
            return this.A05.AGl(str, proxy);
        } catch (MalformedURLException e3) {
            throw new IllegalArgumentException(str + A07(18, 19, 27), e3);
        }
    }

    public static Proxy A09() {
        Proxy proxy = Proxy.NO_PROXY;
        String property = System.getProperty(A07(192, 14, 1));
        String proxyAddress = System.getProperty(A07(206, 14, 98));
        int port = -1;
        if (proxyAddress != null) {
            try {
                port = Integer.parseInt(proxyAddress);
            } catch (NumberFormatException unused) {
                return proxy;
            }
        }
        if (!TextUtils.isEmpty(property) && port > 0 && port <= 65535) {
            return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(property, port));
        }
        return proxy;
    }

    public static synchronized void A0B() {
        if (CookieHandler.getDefault() == null) {
            CookieHandler.setDefault(new CookieManager());
        }
    }

    private void A0C(AbstractC1611g7 abstractC1611g7) {
        StringBuilder sb = new StringBuilder(A07(182, 10, 43));
        boolean zEquals = abstractC1611g7.A03().equals(EnumC1610g6.A06);
        String strA07 = A07(41, 1, 120);
        if (zEquals) {
            byte[] bArrA06 = abstractC1611g7.A06();
            if (A08[1].charAt(0) == 'l') {
                throw new RuntimeException();
            }
            A08[4] = "MgpsgMtpOSh21D9UNcI3ZUtvoefc4JIC";
            if (bArrA06 != null) {
                sb.append(A07(7, 5, 124));
                sb.append(new String(abstractC1611g7.A06(), Charset.forName(A07(130, 5, 83))));
                sb.append(strA07);
            }
        }
        for (Map.Entry<String, String> entry : abstractC1611g7.A02().A06().entrySet()) {
            sb.append(A07(2, 5, 87));
            sb.append(entry.getKey());
            sb.append(A07(66, 1, 47));
            sb.append(entry.getValue());
            sb.append(strA07);
        }
        sb.append(A07(0, 2, 10));
        sb.append(abstractC1611g7.A05());
        sb.append(strA07);
        String string = sb.toString();
        A0E(string, 1, (string.length() / 4000) + 1);
    }

    private void A0D(AbstractC1611g7 abstractC1611g7, InterfaceC1600fw interfaceC1600fw) {
        this.A04.A6y(this, interfaceC1600fw, this.A01).A04(abstractC1611g7);
        if (this.A03.A04()) {
            A0C(abstractC1611g7);
        }
    }

    private void A0E(String str, int i3, int i4) {
        String str2 = A09 + A07(12, 6, 47) + i3 + A07(65, 1, 96) + i4;
        if (str.length() > 4000) {
            str.substring(0, 4000);
            A0E(str.substring(4000), i3 + 1, i4);
        }
    }

    private void A0F(String str, String str2, byte[] bArr, InterfaceC1600fw interfaceC1600fw, C1607g3 c1607g3) {
        C0637Cn req = new C0637Cn(str, null, str2, bArr, c1607g3);
        A0D(req, interfaceC1600fw);
    }

    private void A0G(HttpURLConnection httpURLConnection, AbstractC1611g7 abstractC1611g7) {
        Map<String, String> mapA06 = abstractC1611g7.A02().A06();
        InterfaceC1597ft interfaceC1597ftA05 = abstractC1611g7.A02().A05();
        for (String str : mapA06.keySet()) {
            httpURLConnection.setRequestProperty(str, mapA06.get(str));
        }
        if (interfaceC1597ftA05 != null) {
            Map<String, String> mapA6g = interfaceC1597ftA05.A6g(this.A03.A03());
            for (String str2 : mapA6g.keySet()) {
                httpURLConnection.setRequestProperty(str2, mapA6g.get(str2));
            }
        }
    }

    private final void A0H(HttpURLConnection httpURLConnection, AbstractC1611g7 abstractC1611g7) throws IOException {
        C1607g3 c1607g3A02 = abstractC1611g7.A02();
        httpURLConnection.setConnectTimeout(c1607g3A02.A00());
        httpURLConnection.setReadTimeout(c1607g3A02.A02());
        this.A05.AH6(httpURLConnection, abstractC1611g7.A03(), abstractC1611g7.A04());
    }

    private final boolean A0I(Throwable th, long j3, AbstractC1611g7 abstractC1611g7) {
        C1607g3 c1607g3A02 = abstractC1611g7.A02();
        long jCurrentTimeMillis = (System.currentTimeMillis() - j3) + 10;
        if (this.A06.AAZ()) {
            String str = A07(67, 15, 118) + jCurrentTimeMillis + A07(42, 7, 69) + c1607g3A02.A00() + A07(49, 7, 10) + c1607g3A02.A02();
        }
        if (this.A02) {
            long jA02 = c1607g3A02.A02();
            if (A08[4].charAt(1) == 'Y') {
                throw new RuntimeException();
            }
            A08[7] = "tgQXMymp9cIZW";
            return jCurrentTimeMillis >= jA02;
        }
        long elapsedTime = c1607g3A02.A00();
        return jCurrentTimeMillis >= elapsedTime;
    }

    public final C1604g0 A0K() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1599fv
    @Deprecated
    public final InterfaceC1598fu AGw(String str, Map<String, String> parameters) {
        return A03(str, new C1613g9(parameters), this.A03.A00());
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1599fv
    @Deprecated
    public final InterfaceC1598fu AGx(String str, byte[] bArr) {
        return A04(str, A07(135, 47, 102), bArr, this.A03.A00());
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1599fv
    public final void AGy(String str, byte[] bArr, InterfaceC1600fw interfaceC1600fw) {
        A0F(str, A07(135, 47, 102), bArr, interfaceC1600fw, this.A03.A00());
    }
}
