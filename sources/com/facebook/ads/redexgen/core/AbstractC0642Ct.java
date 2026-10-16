package com.facebook.ads.redexgen.core;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ct, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC0642Ct implements InterfaceC1614gA {
    public static byte[] A01;
    public final InterfaceC1615gB A00;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 25);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{108, -114, -114, -112, -101, -97, 88, 110, -109, -116, -99, -98, -112, -97, -42, -11, 7, -3, -9, -26, -7, 5, 9, -7, 7, 8, -36, -11, 2, -8, 0, -7, 6, -62, 3, 2, -39, 6, 6, 3, 6, -126, -82, -83, -77, -92, -83, -77, 108, -109, -72, -81, -92, -126, -127, 115, 90, 101};
    }

    public AbstractC0642Ct(InterfaceC1615gB interfaceC1615gB) {
        this.A00 = interfaceC1615gB;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1614gA
    public final boolean ADs(C1612g8 c1612g8) {
        InterfaceC1598fu interfaceC1598fuA00 = c1612g8.A00();
        if (this.A00.AAZ()) {
            Log.e(AbstractC0642Ct.class.getSimpleName(), A00(14, 27, 123), c1612g8);
        }
        if (interfaceC1598fuA00 != null && interfaceC1598fuA00.A9C() > 0) {
            return true;
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1614gA
    public final HttpURLConnection AGl(String str, Proxy proxy) throws IOException {
        URL url = new URL(str);
        if (proxy == null) {
            return (HttpURLConnection) url.openConnection();
        }
        return (HttpURLConnection) url.openConnection(proxy);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1614gA
    public final InputStream AGm(HttpURLConnection httpURLConnection) throws IOException {
        return httpURLConnection.getInputStream();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1614gA
    public final OutputStream AGn(HttpURLConnection httpURLConnection) throws IOException {
        return httpURLConnection.getOutputStream();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1614gA
    public final void AH6(HttpURLConnection httpURLConnection, EnumC1610g6 enumC1610g6, String str) throws IOException {
        httpURLConnection.setRequestMethod(enumC1610g6.A03());
        httpURLConnection.setDoOutput(enumC1610g6.A05());
        httpURLConnection.setDoInput(enumC1610g6.A04());
        if (str != null) {
            httpURLConnection.setRequestProperty(A00(41, 12, 38), str);
        }
        httpURLConnection.setRequestProperty(A00(0, 14, 18), A00(53, 5, 20));
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1614gA
    public final byte[] AHT(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[16384];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i3 = inputStream.read(bArr);
            if (i3 != -1) {
                byteArrayOutputStream.write(bArr, 0, i3);
            } else {
                byteArrayOutputStream.flush();
                byte[] data = byteArrayOutputStream.toByteArray();
                return data;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1614gA
    public final void AL8(OutputStream outputStream, byte[] bArr) throws IOException {
        outputStream.write(bArr);
    }
}
