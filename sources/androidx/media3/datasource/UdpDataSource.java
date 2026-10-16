package androidx.media3.datasource;

import android.net.Uri;
import androidx.media3.common.util.Assertions;
import com.facebook.ads.AdError;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class UdpDataSource extends BaseDataSource {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f41995e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final byte[] f41996f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final DatagramPacket f41997g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Uri f41998h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private DatagramSocket f41999i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MulticastSocket f42000j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private InetAddress f42001k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f42002l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f42003m;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class UdpDataSourceException extends DataSourceException {
        public UdpDataSourceException(Throwable th, int i3) {
            super(th, i3);
        }
    }

    public UdpDataSource() {
        this(AdError.SERVER_ERROR_CODE);
    }

    @Override // androidx.media3.datasource.DataSource
    public long b(DataSpec dataSpec) throws UdpDataSourceException {
        Uri uri = dataSpec.f41829a;
        this.f41998h = uri;
        String str = (String) Assertions.e(uri.getHost());
        int port = this.f41998h.getPort();
        p(dataSpec);
        try {
            this.f42001k = InetAddress.getByName(str);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.f42001k, port);
            if (this.f42001k.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(inetSocketAddress);
                this.f42000j = multicastSocket;
                multicastSocket.joinGroup(this.f42001k);
                this.f41999i = this.f42000j;
            } else {
                this.f41999i = new DatagramSocket(inetSocketAddress);
            }
            this.f41999i.setSoTimeout(this.f41995e);
            this.f42002l = true;
            q(dataSpec);
            return -1L;
        } catch (IOException e3) {
            throw new UdpDataSourceException(e3, AdError.INTERNAL_ERROR_CODE);
        } catch (SecurityException e4) {
            throw new UdpDataSourceException(e4, AdError.INTERNAL_ERROR_2006);
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public void close() {
        this.f41998h = null;
        MulticastSocket multicastSocket = this.f42000j;
        if (multicastSocket != null) {
            try {
                multicastSocket.leaveGroup((InetAddress) Assertions.e(this.f42001k));
            } catch (IOException unused) {
            }
            this.f42000j = null;
        }
        DatagramSocket datagramSocket = this.f41999i;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.f41999i = null;
        }
        this.f42001k = null;
        this.f42003m = 0;
        if (this.f42002l) {
            this.f42002l = false;
            o();
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public Uri getUri() {
        return this.f41998h;
    }

    @Override // androidx.media3.common.DataReader
    public int read(byte[] bArr, int i3, int i4) throws UdpDataSourceException {
        if (i4 == 0) {
            return 0;
        }
        if (this.f42003m == 0) {
            try {
                ((DatagramSocket) Assertions.e(this.f41999i)).receive(this.f41997g);
                int length = this.f41997g.getLength();
                this.f42003m = length;
                n(length);
            } catch (SocketTimeoutException e3) {
                throw new UdpDataSourceException(e3, AdError.CACHE_ERROR_CODE);
            } catch (IOException e4) {
                throw new UdpDataSourceException(e4, AdError.INTERNAL_ERROR_CODE);
            }
        }
        int length2 = this.f41997g.getLength();
        int i5 = this.f42003m;
        int iMin = Math.min(i5, i4);
        System.arraycopy(this.f41996f, length2 - i5, bArr, i3, iMin);
        this.f42003m -= iMin;
        return iMin;
    }

    public UdpDataSource(int i3) {
        this(i3, 8000);
    }

    public UdpDataSource(int i3, int i4) {
        super(true);
        this.f41995e = i4;
        byte[] bArr = new byte[i3];
        this.f41996f = bArr;
        this.f41997g = new DatagramPacket(bArr, 0, i3);
    }
}
