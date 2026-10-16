package androidx.media3.decoder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DecoderOutputBuffer extends Buffer {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f42146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f42147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f42148d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Owner<S extends DecoderOutputBuffer> {
        void a(DecoderOutputBuffer decoderOutputBuffer);
    }

    @Override // androidx.media3.decoder.Buffer
    public void f() {
        super.f();
        this.f42146b = 0L;
        this.f42147c = 0;
        this.f42148d = false;
    }

    public abstract void o();
}
