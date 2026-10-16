package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoInfo;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class AsynchronousMediaCodecBufferEnqueuer implements MediaCodecBufferEnqueuer {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ArrayDeque f44211g = new ArrayDeque();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Object f44212h = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediaCodec f44213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HandlerThread f44214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f44215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicReference f44216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConditionVariable f44217e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f44218f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class MessageParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f44220a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f44221b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f44222c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final MediaCodec.CryptoInfo f44223d = new MediaCodec.CryptoInfo();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f44224e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f44225f;

        MessageParams() {
        }

        public void a(int i3, int i4, int i5, long j3, int i6) {
            this.f44220a = i3;
            this.f44221b = i4;
            this.f44222c = i5;
            this.f44224e = j3;
            this.f44225f = i6;
        }
    }

    public AsynchronousMediaCodecBufferEnqueuer(MediaCodec mediaCodec, HandlerThread handlerThread) {
        this(mediaCodec, handlerThread, new ConditionVariable());
    }

    private void c() {
        this.f44217e.d();
        ((Handler) Assertions.e(this.f44215c)).obtainMessage(3).sendToTarget();
        this.f44217e.a();
    }

    private static void g(CryptoInfo cryptoInfo, MediaCodec.CryptoInfo cryptoInfo2) {
        cryptoInfo2.numSubSamples = cryptoInfo.f42129f;
        cryptoInfo2.numBytesOfClearData = i(cryptoInfo.f42127d, cryptoInfo2.numBytesOfClearData);
        cryptoInfo2.numBytesOfEncryptedData = i(cryptoInfo.f42128e, cryptoInfo2.numBytesOfEncryptedData);
        cryptoInfo2.key = (byte[]) Assertions.e(h(cryptoInfo.f42125b, cryptoInfo2.key));
        cryptoInfo2.iv = (byte[]) Assertions.e(h(cryptoInfo.f42124a, cryptoInfo2.iv));
        cryptoInfo2.mode = cryptoInfo.f42126c;
        if (Util.f41609a >= 24) {
            cryptoInfo2.setPattern(new MediaCodec.CryptoInfo.Pattern(cryptoInfo.f42130g, cryptoInfo.f42131h));
        }
    }

    private static byte[] h(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < bArr.length) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private static int[] i(int[] iArr, int[] iArr2) {
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < iArr.length) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void j(android.os.Message r9) {
        /*
            r8 = this;
            int r2 = r9.what
            r3 = 1
            if (r2 == r3) goto L43
            r3 = 2
            if (r2 == r3) goto L2e
            r3 = 3
            r4 = 0
            if (r2 == r3) goto L28
            r3 = 4
            if (r2 == r3) goto L20
            java.util.concurrent.atomic.AtomicReference r2 = r8.f44216d
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            int r1 = r9.what
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r3.<init>(r1)
            androidx.compose.animation.core.h.a(r2, r4, r3)
            goto L57
        L20:
            java.lang.Object r1 = r9.obj
            android.os.Bundle r1 = (android.os.Bundle) r1
            r8.m(r1)
            goto L57
        L28:
            androidx.media3.common.util.ConditionVariable r1 = r8.f44217e
            r1.f()
            goto L57
        L2e:
            java.lang.Object r1 = r9.obj
            r7 = r1
            androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecBufferEnqueuer$MessageParams r7 = (androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecBufferEnqueuer.MessageParams) r7
            int r1 = r7.f44220a
            int r2 = r7.f44221b
            android.media.MediaCodec$CryptoInfo r3 = r7.f44223d
            long r4 = r7.f44224e
            int r6 = r7.f44225f
            r0 = r8
            r0.l(r1, r2, r3, r4, r6)
        L41:
            r4 = r7
            goto L57
        L43:
            java.lang.Object r0 = r9.obj
            r7 = r0
            androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecBufferEnqueuer$MessageParams r7 = (androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecBufferEnqueuer.MessageParams) r7
            int r1 = r7.f44220a
            int r2 = r7.f44221b
            int r3 = r7.f44222c
            long r4 = r7.f44224e
            int r6 = r7.f44225f
            r0 = r8
            r0.k(r1, r2, r3, r4, r6)
            goto L41
        L57:
            if (r4 == 0) goto L5c
            p(r4)
        L5c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecBufferEnqueuer.j(android.os.Message):void");
    }

    private void k(int i3, int i4, int i5, long j3, int i6) {
        try {
            this.f44213a.queueInputBuffer(i3, i4, i5, j3, i6);
        } catch (RuntimeException e3) {
            androidx.compose.animation.core.h.a(this.f44216d, null, e3);
        }
    }

    private void l(int i3, int i4, MediaCodec.CryptoInfo cryptoInfo, long j3, int i5) {
        try {
            synchronized (f44212h) {
                this.f44213a.queueSecureInputBuffer(i3, i4, cryptoInfo, j3, i5);
            }
        } catch (RuntimeException e3) {
            androidx.compose.animation.core.h.a(this.f44216d, null, e3);
        }
    }

    private void m(Bundle bundle) {
        try {
            this.f44213a.setParameters(bundle);
        } catch (RuntimeException e3) {
            androidx.compose.animation.core.h.a(this.f44216d, null, e3);
        }
    }

    private void n() {
        ((Handler) Assertions.e(this.f44215c)).removeCallbacksAndMessages(null);
        c();
    }

    private static MessageParams o() {
        ArrayDeque arrayDeque = f44211g;
        synchronized (arrayDeque) {
            try {
                if (arrayDeque.isEmpty()) {
                    return new MessageParams();
                }
                return (MessageParams) arrayDeque.removeFirst();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void p(MessageParams messageParams) {
        ArrayDeque arrayDeque = f44211g;
        synchronized (arrayDeque) {
            arrayDeque.add(messageParams);
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public void a() {
        RuntimeException runtimeException = (RuntimeException) this.f44216d.getAndSet(null);
        if (runtimeException != null) {
            throw runtimeException;
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public void d(int i3, int i4, int i5, long j3, int i6) {
        a();
        MessageParams messageParamsO = o();
        messageParamsO.a(i3, i4, i5, j3, i6);
        ((Handler) Util.k(this.f44215c)).obtainMessage(1, messageParamsO).sendToTarget();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public void e(int i3, int i4, CryptoInfo cryptoInfo, long j3, int i5) {
        a();
        MessageParams messageParamsO = o();
        messageParamsO.a(i3, i4, 0, j3, i5);
        g(cryptoInfo, messageParamsO.f44223d);
        ((Handler) Util.k(this.f44215c)).obtainMessage(2, messageParamsO).sendToTarget();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public void f(Bundle bundle) {
        a();
        ((Handler) Util.k(this.f44215c)).obtainMessage(4, bundle).sendToTarget();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public void flush() {
        if (this.f44218f) {
            try {
                n();
            } catch (InterruptedException e3) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e3);
            }
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public void shutdown() {
        if (this.f44218f) {
            flush();
            this.f44214b.quit();
        }
        this.f44218f = false;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public void start() {
        if (this.f44218f) {
            return;
        }
        this.f44214b.start();
        this.f44215c = new Handler(this.f44214b.getLooper()) { // from class: androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecBufferEnqueuer.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                AsynchronousMediaCodecBufferEnqueuer.this.j(message);
            }
        };
        this.f44218f = true;
    }

    AsynchronousMediaCodecBufferEnqueuer(MediaCodec mediaCodec, HandlerThread handlerThread, ConditionVariable conditionVariable) {
        this.f44213a = mediaCodec;
        this.f44214b = handlerThread;
        this.f44217e = conditionVariable;
        this.f44216d = new AtomicReference();
    }
}
