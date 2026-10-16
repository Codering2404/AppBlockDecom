package androidx.media3.exoplayer.util;

import android.os.SystemClock;
import androidx.media3.common.util.Assertions;
import androidx.media3.exoplayer.upstream.Loader;
import com.applovin.exoplayer2.common.base.Ascii;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.ConcurrentModificationException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class SntpClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f45648a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f45649b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f45650c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f45651d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f45652e = "time.android.com";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f45653f = 1000;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static long f45654g = -9223372036854775807L;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static long f45655h = -9223372036854775807L;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface InitializationCallback {
        void a(IOException iOException);

        void onInitialized();
    }

    private static void h(byte b3, byte b4, int i3, long j3) throws IOException {
        if (b3 == 3) {
            throw new IOException("SNTP: Unsynchronized server");
        }
        if (b4 != 4 && b4 != 5) {
            throw new IOException("SNTP: Untrusted mode: " + ((int) b4));
        }
        if (i3 != 0 && i3 <= 15) {
            if (j3 == 0) {
                throw new IOException("SNTP: Zero transmitTime");
            }
        } else {
            throw new IOException("SNTP: Untrusted stratum: " + i3);
        }
    }

    public static String i() {
        String str;
        synchronized (f45649b) {
            str = f45652e;
        }
        return str;
    }

    public static int j() {
        int i3;
        synchronized (f45649b) {
            i3 = f45653f;
        }
        return i3;
    }

    public static boolean k() {
        boolean z2;
        synchronized (f45649b) {
            try {
                if (f45655h != -9223372036854775807L && f45654g != -9223372036854775807L) {
                    f45650c = f45650c && SystemClock.elapsedRealtime() - f45655h < f45654g;
                }
                z2 = f45650c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long l() {
        DatagramSocket datagramSocket = new DatagramSocket();
        try {
            datagramSocket.setSoTimeout(j());
            InetAddress[] allByName = InetAddress.getAllByName(i());
            int length = allByName.length;
            SocketTimeoutException socketTimeoutException = null;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                byte[] bArr = new byte[48];
                DatagramPacket datagramPacket = new DatagramPacket(bArr, 48, allByName[i3], 123);
                bArr[0] = Ascii.ESC;
                long jCurrentTimeMillis = System.currentTimeMillis();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                o(bArr, 40, jCurrentTimeMillis);
                datagramSocket.send(datagramPacket);
                try {
                    datagramSocket.receive(new DatagramPacket(bArr, 48));
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    long j3 = jCurrentTimeMillis + (jElapsedRealtime2 - jElapsedRealtime);
                    byte b3 = bArr[0];
                    int i5 = bArr[1] & 255;
                    long jN = n(bArr, 24);
                    long jN2 = n(bArr, 32);
                    long jN3 = n(bArr, 40);
                    h((byte) ((b3 >> 6) & 3), (byte) (b3 & 7), i5, jN3);
                    long j4 = (j3 + (((jN2 - jN) + (jN3 - j3)) / 2)) - jElapsedRealtime2;
                    datagramSocket.close();
                    return j4;
                } catch (SocketTimeoutException e3) {
                    if (socketTimeoutException == null) {
                        socketTimeoutException = e3;
                    } else {
                        socketTimeoutException.addSuppressed(e3);
                    }
                    int i6 = i4 + 1;
                    if (i4 >= 10) {
                        throw ((SocketTimeoutException) Assertions.e(socketTimeoutException));
                    }
                    i3++;
                    i4 = i6;
                }
            }
            throw ((SocketTimeoutException) Assertions.e(socketTimeoutException));
        } finally {
        }
    }

    private static long m(byte[] bArr, int i3) {
        int i4 = bArr[i3];
        int i5 = bArr[i3 + 1];
        int i6 = bArr[i3 + 2];
        int i7 = bArr[i3 + 3];
        if ((i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 128) {
            i4 = (i4 & 127) + ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 128) {
            i5 = (i5 & 127) + ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i6 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 128) {
            i6 = (i6 & 127) + ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i7 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 128) {
            i7 = (i7 & 127) + ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        return (((long) i4) << 24) + (((long) i5) << 16) + (((long) i6) << 8) + ((long) i7);
    }

    private static long n(byte[] bArr, int i3) {
        long jM = m(bArr, i3);
        long jM2 = m(bArr, i3 + 4);
        if (jM == 0 && jM2 == 0) {
            return 0L;
        }
        return ((jM - 2208988800L) * 1000) + ((jM2 * 1000) / 4294967296L);
    }

    private static void o(byte[] bArr, int i3, long j3) {
        if (j3 == 0) {
            Arrays.fill(bArr, i3, i3 + 8, (byte) 0);
            return;
        }
        long j4 = j3 / 1000;
        long j5 = j3 - (j4 * 1000);
        bArr[i3] = (byte) (r2 >> 24);
        bArr[i3 + 1] = (byte) (r2 >> 16);
        bArr[i3 + 2] = (byte) (r2 >> 8);
        bArr[i3 + 3] = (byte) (j4 + 2208988800L);
        long j6 = (j5 * 4294967296L) / 1000;
        bArr[i3 + 4] = (byte) (j6 >> 24);
        bArr[i3 + 5] = (byte) (j6 >> 16);
        bArr[i3 + 6] = (byte) (j6 >> 8);
        bArr[i3 + 7] = (byte) (Math.random() * 255.0d);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class NtpTimeLoadable implements Loader.Loadable {
        @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
        public void a() {
            synchronized (SntpClient.f45648a) {
                synchronized (SntpClient.f45649b) {
                    if (SntpClient.f45650c) {
                        return;
                    }
                    long jL = SntpClient.l();
                    synchronized (SntpClient.f45649b) {
                        long unused = SntpClient.f45655h = SystemClock.elapsedRealtime();
                        long unused2 = SntpClient.f45651d = jL;
                        boolean unused3 = SntpClient.f45650c = true;
                    }
                }
            }
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
        public void c() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class NtpTimeCallback implements Loader.Callback<Loader.Loadable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InitializationCallback f45656a;

        @Override // androidx.media3.exoplayer.upstream.Loader.Callback
        public Loader.LoadErrorAction g(Loader.Loadable loadable, long j3, long j4, IOException iOException, int i3) {
            InitializationCallback initializationCallback = this.f45656a;
            if (initializationCallback != null) {
                initializationCallback.a(iOException);
            }
            return Loader.f45536f;
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.Callback
        public void t(Loader.Loadable loadable, long j3, long j4) {
            if (this.f45656a != null) {
                if (SntpClient.k()) {
                    this.f45656a.onInitialized();
                } else {
                    this.f45656a.a(new IOException(new ConcurrentModificationException()));
                }
            }
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.Callback
        public void v(Loader.Loadable loadable, long j3, long j4, boolean z2) {
        }
    }
}
