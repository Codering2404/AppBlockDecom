package androidx.media3.decoder;

import androidx.media3.common.util.Assertions;
import androidx.media3.decoder.DecoderException;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.DecoderOutputBuffer;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SimpleDecoder<I extends DecoderInputBuffer, O extends DecoderOutputBuffer, E extends DecoderException> implements Decoder<I, O, E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Thread f42149a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final DecoderInputBuffer[] f42153e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final DecoderOutputBuffer[] f42154f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f42155g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f42156h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private DecoderInputBuffer f42157i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private DecoderException f42158j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f42159k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f42160l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f42161m;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f42150b = new Object();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f42162n = -9223372036854775807L;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayDeque f42151c = new ArrayDeque();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ArrayDeque f42152d = new ArrayDeque();

    protected SimpleDecoder(DecoderInputBuffer[] decoderInputBufferArr, DecoderOutputBuffer[] decoderOutputBufferArr) {
        this.f42153e = decoderInputBufferArr;
        this.f42155g = decoderInputBufferArr.length;
        for (int i3 = 0; i3 < this.f42155g; i3++) {
            this.f42153e[i3] = i();
        }
        this.f42154f = decoderOutputBufferArr;
        this.f42156h = decoderOutputBufferArr.length;
        for (int i4 = 0; i4 < this.f42156h; i4++) {
            this.f42154f[i4] = j();
        }
        Thread thread = new Thread("ExoPlayer:SimpleDecoder") { // from class: androidx.media3.decoder.SimpleDecoder.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                SimpleDecoder.this.v();
            }
        };
        this.f42149a = thread;
        thread.start();
    }

    private boolean h() {
        return !this.f42151c.isEmpty() && this.f42156h > 0;
    }

    private boolean m() {
        DecoderException decoderExceptionK;
        synchronized (this.f42150b) {
            while (!this.f42160l && !h()) {
                try {
                    this.f42150b.wait();
                } finally {
                }
            }
            if (this.f42160l) {
                return false;
            }
            DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) this.f42151c.removeFirst();
            DecoderOutputBuffer[] decoderOutputBufferArr = this.f42154f;
            int i3 = this.f42156h - 1;
            this.f42156h = i3;
            DecoderOutputBuffer decoderOutputBuffer = decoderOutputBufferArr[i3];
            boolean z2 = this.f42159k;
            this.f42159k = false;
            if (decoderInputBuffer.i()) {
                decoderOutputBuffer.e(4);
            } else {
                decoderOutputBuffer.f42146b = decoderInputBuffer.f42140g;
                if (decoderInputBuffer.j()) {
                    decoderOutputBuffer.e(134217728);
                }
                if (!p(decoderInputBuffer.f42140g)) {
                    decoderOutputBuffer.f42148d = true;
                }
                try {
                    decoderExceptionK = l(decoderInputBuffer, decoderOutputBuffer, z2);
                } catch (OutOfMemoryError e3) {
                    decoderExceptionK = k(e3);
                } catch (RuntimeException e4) {
                    decoderExceptionK = k(e4);
                }
                if (decoderExceptionK != null) {
                    synchronized (this.f42150b) {
                        this.f42158j = decoderExceptionK;
                    }
                    return false;
                }
            }
            synchronized (this.f42150b) {
                try {
                    if (this.f42159k) {
                        decoderOutputBuffer.o();
                    } else if (decoderOutputBuffer.f42148d) {
                        this.f42161m++;
                        decoderOutputBuffer.o();
                    } else {
                        decoderOutputBuffer.f42147c = this.f42161m;
                        this.f42161m = 0;
                        this.f42152d.addLast(decoderOutputBuffer);
                    }
                    s(decoderInputBuffer);
                } finally {
                }
            }
            return true;
        }
    }

    private void q() {
        if (h()) {
            this.f42150b.notify();
        }
    }

    private void r() throws DecoderException {
        DecoderException decoderException = this.f42158j;
        if (decoderException != null) {
            throw decoderException;
        }
    }

    private void s(DecoderInputBuffer decoderInputBuffer) {
        decoderInputBuffer.f();
        DecoderInputBuffer[] decoderInputBufferArr = this.f42153e;
        int i3 = this.f42155g;
        this.f42155g = i3 + 1;
        decoderInputBufferArr[i3] = decoderInputBuffer;
    }

    private void u(DecoderOutputBuffer decoderOutputBuffer) {
        decoderOutputBuffer.f();
        DecoderOutputBuffer[] decoderOutputBufferArr = this.f42154f;
        int i3 = this.f42156h;
        this.f42156h = i3 + 1;
        decoderOutputBufferArr[i3] = decoderOutputBuffer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        do {
            try {
            } catch (InterruptedException e3) {
                throw new IllegalStateException(e3);
            }
        } while (m());
    }

    @Override // androidx.media3.decoder.Decoder
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final void b(DecoderInputBuffer decoderInputBuffer) {
        synchronized (this.f42150b) {
            r();
            Assertions.a(decoderInputBuffer == this.f42157i);
            this.f42151c.addLast(decoderInputBuffer);
            q();
            this.f42157i = null;
        }
    }

    @Override // androidx.media3.decoder.Decoder
    public final void e(long j3) {
        synchronized (this.f42150b) {
            try {
                Assertions.g(this.f42155g == this.f42153e.length || this.f42159k);
                this.f42162n = j3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media3.decoder.Decoder
    public final void flush() {
        synchronized (this.f42150b) {
            try {
                this.f42159k = true;
                this.f42161m = 0;
                DecoderInputBuffer decoderInputBuffer = this.f42157i;
                if (decoderInputBuffer != null) {
                    s(decoderInputBuffer);
                    this.f42157i = null;
                }
                while (!this.f42151c.isEmpty()) {
                    s((DecoderInputBuffer) this.f42151c.removeFirst());
                }
                while (!this.f42152d.isEmpty()) {
                    ((DecoderOutputBuffer) this.f42152d.removeFirst()).o();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected abstract DecoderInputBuffer i();

    protected abstract DecoderOutputBuffer j();

    protected abstract DecoderException k(Throwable th);

    protected abstract DecoderException l(DecoderInputBuffer decoderInputBuffer, DecoderOutputBuffer decoderOutputBuffer, boolean z2);

    @Override // androidx.media3.decoder.Decoder
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public final DecoderInputBuffer f() {
        DecoderInputBuffer decoderInputBuffer;
        synchronized (this.f42150b) {
            r();
            Assertions.g(this.f42157i == null);
            int i3 = this.f42155g;
            if (i3 == 0) {
                decoderInputBuffer = null;
            } else {
                DecoderInputBuffer[] decoderInputBufferArr = this.f42153e;
                int i4 = i3 - 1;
                this.f42155g = i4;
                decoderInputBuffer = decoderInputBufferArr[i4];
            }
            this.f42157i = decoderInputBuffer;
        }
        return decoderInputBuffer;
    }

    @Override // androidx.media3.decoder.Decoder
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public final DecoderOutputBuffer a() {
        synchronized (this.f42150b) {
            try {
                r();
                if (this.f42152d.isEmpty()) {
                    return null;
                }
                return (DecoderOutputBuffer) this.f42152d.removeFirst();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected final boolean p(long j3) {
        boolean z2;
        synchronized (this.f42150b) {
            long j4 = this.f42162n;
            z2 = j4 == -9223372036854775807L || j3 >= j4;
        }
        return z2;
    }

    @Override // androidx.media3.decoder.Decoder
    public void release() {
        synchronized (this.f42150b) {
            this.f42160l = true;
            this.f42150b.notify();
        }
        try {
            this.f42149a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    protected void t(DecoderOutputBuffer decoderOutputBuffer) {
        synchronized (this.f42150b) {
            u(decoderOutputBuffer);
            q();
        }
    }

    protected final void w(int i3) {
        Assertions.g(this.f42155g == this.f42153e.length);
        for (DecoderInputBuffer decoderInputBuffer : this.f42153e) {
            decoderInputBuffer.p(i3);
        }
    }
}
