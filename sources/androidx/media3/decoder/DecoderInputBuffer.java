package androidx.media3.decoder;

import androidx.media3.common.Format;
import androidx.media3.common.MediaLibraryInfo;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class DecoderInputBuffer extends Buffer {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Format f42136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CryptoInfo f42137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ByteBuffer f42138d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f42139f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f42140g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ByteBuffer f42141h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f42142i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f42143j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface BufferReplacementMode {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class InsufficientCapacityException extends IllegalStateException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f42144a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f42145b;

        public InsufficientCapacityException(int i3, int i4) {
            super("Buffer too small (" + i3 + " < " + i4 + ")");
            this.f42144a = i3;
            this.f42145b = i4;
        }
    }

    static {
        MediaLibraryInfo.a("media3.decoder");
    }

    public DecoderInputBuffer(int i3) {
        this(i3, 0);
    }

    private ByteBuffer o(int i3) {
        int i4 = this.f42142i;
        if (i4 == 1) {
            return ByteBuffer.allocate(i3);
        }
        if (i4 == 2) {
            return ByteBuffer.allocateDirect(i3);
        }
        ByteBuffer byteBuffer = this.f42138d;
        throw new InsufficientCapacityException(byteBuffer == null ? 0 : byteBuffer.capacity(), i3);
    }

    public static DecoderInputBuffer s() {
        return new DecoderInputBuffer(0);
    }

    @Override // androidx.media3.decoder.Buffer
    public void f() {
        super.f();
        ByteBuffer byteBuffer = this.f42138d;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.f42141h;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.f42139f = false;
    }

    public void p(int i3) {
        int i4 = i3 + this.f42143j;
        ByteBuffer byteBuffer = this.f42138d;
        if (byteBuffer == null) {
            this.f42138d = o(i4);
            return;
        }
        int iCapacity = byteBuffer.capacity();
        int iPosition = byteBuffer.position();
        int i5 = i4 + iPosition;
        if (iCapacity >= i5) {
            this.f42138d = byteBuffer;
            return;
        }
        ByteBuffer byteBufferO = o(i5);
        byteBufferO.order(byteBuffer.order());
        if (iPosition > 0) {
            byteBuffer.flip();
            byteBufferO.put(byteBuffer);
        }
        this.f42138d = byteBufferO;
    }

    public final void q() {
        ByteBuffer byteBuffer = this.f42138d;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.f42141h;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    public final boolean r() {
        return g(1073741824);
    }

    public void t(int i3) {
        ByteBuffer byteBuffer = this.f42141h;
        if (byteBuffer == null || byteBuffer.capacity() < i3) {
            this.f42141h = ByteBuffer.allocate(i3);
        } else {
            this.f42141h.clear();
        }
    }

    public DecoderInputBuffer(int i3, int i4) {
        this.f42137c = new CryptoInfo();
        this.f42142i = i3;
        this.f42143j = i4;
    }
}
