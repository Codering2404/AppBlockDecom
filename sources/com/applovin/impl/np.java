package com.applovin.impl;

import android.net.Uri;
import com.facebook.ads.AdError;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class np extends a2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f62118e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final byte[] f62119f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final DatagramPacket f62120g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Uri f62121h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private DatagramSocket f62122i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MulticastSocket f62123j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private InetAddress f62124k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private InetSocketAddress f62125l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f62126m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f62127n;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class a extends i5 {
        public a(Throwable th, int i3) {
            super(th, i3);
        }
    }

    public np() {
        this(AdError.SERVER_ERROR_CODE);
    }

    @Override // com.applovin.impl.h5
    public long a(k5 k5Var) throws a {
        Uri uri = k5Var.f60912a;
        this.f62121h = uri;
        String host = uri.getHost();
        int port = this.f62121h.getPort();
        b(k5Var);
        try {
            this.f62124k = InetAddress.getByName(host);
            this.f62125l = new InetSocketAddress(this.f62124k, port);
            if (this.f62124k.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(this.f62125l);
                this.f62123j = multicastSocket;
                multicastSocket.joinGroup(this.f62124k);
                this.f62122i = this.f62123j;
            } else {
                this.f62122i = new DatagramSocket(this.f62125l);
            }
            this.f62122i.setSoTimeout(this.f62118e);
            this.f62126m = true;
            c(k5Var);
            return -1L;
        } catch (IOException e3) {
            throw new a(e3, AdError.INTERNAL_ERROR_CODE);
        } catch (SecurityException e4) {
            throw new a(e4, AdError.INTERNAL_ERROR_2006);
        }
    }

    @Override // com.applovin.impl.h5
    public Uri c() {
        return this.f62121h;
    }

    @Override // com.applovin.impl.h5
    public void close() {
        this.f62121h = null;
        MulticastSocket multicastSocket = this.f62123j;
        if (multicastSocket != null) {
            try {
                multicastSocket.leaveGroup(this.f62124k);
            } catch (IOException unused) {
            }
            this.f62123j = null;
        }
        DatagramSocket datagramSocket = this.f62122i;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.f62122i = null;
        }
        this.f62124k = null;
        this.f62125l = null;
        this.f62127n = 0;
        if (this.f62126m) {
            this.f62126m = false;
            g();
        }
    }

    public np(int i3) {
        this(i3, 8000);
    }

    public np(int i3, int i4) {
        super(true);
        this.f62118e = i4;
        byte[] bArr = new byte[i3];
        this.f62119f = bArr;
        this.f62120g = new DatagramPacket(bArr, 0, i3);
    }

    @Override // com.applovin.impl.f5
    public int a(byte[] bArr, int i3, int i4) throws a {
        if (i4 == 0) {
            return 0;
        }
        if (this.f62127n == 0) {
            try {
                this.f62122i.receive(this.f62120g);
                int length = this.f62120g.getLength();
                this.f62127n = length;
                d(length);
            } catch (SocketTimeoutException e3) {
                throw new a(e3, AdError.CACHE_ERROR_CODE);
            } catch (IOException e4) {
                throw new a(e4, AdError.INTERNAL_ERROR_CODE);
            }
        }
        int length2 = this.f62120g.getLength();
        int i5 = this.f62127n;
        int iMin = Math.min(i5, i4);
        System.arraycopy(this.f62119f, length2 - i5, bArr, i3, iMin);
        this.f62127n -= iMin;
        return iMin;
    }
}
