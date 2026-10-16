package com.applovin.impl;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class h1 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ArrayDeque f60080h = new ArrayDeque();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Object f60081i = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediaCodec f60082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HandlerThread f60083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f60084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicReference f60085d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final c4 f60086e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f60087f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f60088g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            h1.this.a(message);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f60090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f60091b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f60092c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final MediaCodec.CryptoInfo f60093d = new MediaCodec.CryptoInfo();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f60094e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f60095f;

        b() {
        }

        public void a(int i3, int i4, int i5, long j3, int i6) {
            this.f60090a = i3;
            this.f60091b = i4;
            this.f60092c = i5;
            this.f60094e = j3;
            this.f60095f = i6;
        }
    }

    public h1(MediaCodec mediaCodec, HandlerThread handlerThread, boolean z2) {
        this(mediaCodec, handlerThread, z2, new c4());
    }

    private void c() {
        ((Handler) xp.a(this.f60084c)).removeCallbacksAndMessages(null);
        a();
        e();
    }

    private static b d() {
        ArrayDeque arrayDeque = f60080h;
        synchronized (arrayDeque) {
            try {
                if (arrayDeque.isEmpty()) {
                    return new b();
                }
                return (b) arrayDeque.removeFirst();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void e() {
        RuntimeException runtimeException = (RuntimeException) this.f60085d.getAndSet(null);
        if (runtimeException != null) {
            throw runtimeException;
        }
    }

    private static boolean f() {
        String lowerCase = Ascii.toLowerCase(xp.f65029c);
        return lowerCase.contains("samsung") || lowerCase.contains("motorola");
    }

    public void b() {
        if (this.f60088g) {
            try {
                c();
            } catch (InterruptedException e3) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e3);
            }
        }
    }

    public void g() {
        if (this.f60088g) {
            b();
            this.f60083b.quit();
        }
        this.f60088g = false;
    }

    public void h() {
        if (this.f60088g) {
            return;
        }
        this.f60083b.start();
        this.f60084c = new a(this.f60083b.getLooper());
        this.f60088g = true;
    }

    public void i() {
        a();
    }

    h1(MediaCodec mediaCodec, HandlerThread handlerThread, boolean z2, c4 c4Var) {
        this.f60082a = mediaCodec;
        this.f60083b = handlerThread;
        this.f60086e = c4Var;
        this.f60085d = new AtomicReference();
        this.f60087f = z2 || f();
    }

    private void a() {
        this.f60086e.c();
        ((Handler) xp.a(this.f60084c)).obtainMessage(2).sendToTarget();
        this.f60086e.a();
    }

    private static void a(z4 z4Var, MediaCodec.CryptoInfo cryptoInfo) {
        cryptoInfo.numSubSamples = z4Var.f65355f;
        cryptoInfo.numBytesOfClearData = a(z4Var.f65353d, cryptoInfo.numBytesOfClearData);
        cryptoInfo.numBytesOfEncryptedData = a(z4Var.f65354e, cryptoInfo.numBytesOfEncryptedData);
        cryptoInfo.key = (byte[]) b1.a(a(z4Var.f65351b, cryptoInfo.key));
        cryptoInfo.iv = (byte[]) b1.a(a(z4Var.f65350a, cryptoInfo.iv));
        cryptoInfo.mode = z4Var.f65352c;
        if (xp.f65027a >= 24) {
            cryptoInfo.setPattern(new MediaCodec.CryptoInfo.Pattern(z4Var.f65356g, z4Var.f65357h));
        }
    }

    public void b(int i3, int i4, int i5, long j3, int i6) {
        e();
        b bVarD = d();
        bVarD.a(i3, i4, i5, j3, i6);
        ((Handler) xp.a(this.f60084c)).obtainMessage(0, bVarD).sendToTarget();
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 != null && bArr2.length >= bArr.length) {
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    private static int[] a(int[] iArr, int[] iArr2) {
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 != null && iArr2.length >= iArr.length) {
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            return iArr2;
        }
        return Arrays.copyOf(iArr, iArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        b bVar;
        int i3 = message.what;
        if (i3 == 0) {
            bVar = (b) message.obj;
            a(bVar.f60090a, bVar.f60091b, bVar.f60092c, bVar.f60094e, bVar.f60095f);
        } else if (i3 != 1) {
            if (i3 != 2) {
                a(new IllegalStateException(String.valueOf(message.what)));
            } else {
                this.f60086e.e();
            }
            bVar = null;
        } else {
            bVar = (b) message.obj;
            a(bVar.f60090a, bVar.f60091b, bVar.f60093d, bVar.f60094e, bVar.f60095f);
        }
        if (bVar != null) {
            a(bVar);
        }
    }

    private void a(int i3, int i4, int i5, long j3, int i6) {
        try {
            this.f60082a.queueInputBuffer(i3, i4, i5, j3, i6);
        } catch (RuntimeException e3) {
            a(e3);
        }
    }

    private void a(int i3, int i4, MediaCodec.CryptoInfo cryptoInfo, long j3, int i5) {
        try {
            if (this.f60087f) {
                synchronized (f60081i) {
                    this.f60082a.queueSecureInputBuffer(i3, i4, cryptoInfo, j3, i5);
                }
                return;
            }
            this.f60082a.queueSecureInputBuffer(i3, i4, cryptoInfo, j3, i5);
        } catch (RuntimeException e3) {
            a(e3);
        }
    }

    public void a(int i3, int i4, z4 z4Var, long j3, int i5) {
        e();
        b bVarD = d();
        bVarD.a(i3, i4, 0, j3, i5);
        a(z4Var, bVarD.f60093d);
        ((Handler) xp.a(this.f60084c)).obtainMessage(1, bVarD).sendToTarget();
    }

    void a(RuntimeException runtimeException) {
        this.f60085d.set(runtimeException);
    }

    private static void a(b bVar) {
        ArrayDeque arrayDeque = f60080h;
        synchronized (arrayDeque) {
            arrayDeque.add(bVar);
        }
    }
}
