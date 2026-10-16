package androidx.media3.common;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface VideoGraph {
    void f(SurfaceInfo surfaceInfo);

    VideoFrameProcessor h(int i3);

    void initialize();

    boolean j();

    void l(int i3);

    void release();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Listener {
        default void a(VideoFrameProcessingException videoFrameProcessingException) {
        }

        default void c(long j3) {
        }

        default void e(float f3) {
        }

        default void k(long j3) {
        }

        default void d(int i3, int i4) {
        }
    }
}
