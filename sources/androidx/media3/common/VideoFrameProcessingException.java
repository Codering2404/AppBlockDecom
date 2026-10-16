package androidx.media3.common;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class VideoFrameProcessingException extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f41253a;

    public VideoFrameProcessingException(String str) {
        this(str, -9223372036854775807L);
    }

    public static VideoFrameProcessingException a(Exception exc) {
        return b(exc, -9223372036854775807L);
    }

    public static VideoFrameProcessingException b(Exception exc, long j3) {
        return exc instanceof VideoFrameProcessingException ? (VideoFrameProcessingException) exc : new VideoFrameProcessingException(exc, j3);
    }

    public VideoFrameProcessingException(String str, long j3) {
        super(str);
        this.f41253a = j3;
    }

    public VideoFrameProcessingException(String str, Throwable th) {
        this(str, th, -9223372036854775807L);
    }

    public VideoFrameProcessingException(String str, Throwable th, long j3) {
        super(str, th);
        this.f41253a = j3;
    }

    public VideoFrameProcessingException(Throwable th) {
        this(th, -9223372036854775807L);
    }

    public VideoFrameProcessingException(Throwable th, long j3) {
        super(th);
        this.f41253a = j3;
    }
}
