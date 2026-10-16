package androidx.media3.exoplayer.offline;

import androidx.media3.common.util.Assertions;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Download {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DownloadRequest f44370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f44371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f44372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f44373d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f44374e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f44375f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f44376g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final DownloadProgress f44377h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface FailureReason {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public Download(DownloadRequest downloadRequest, int i3, long j3, long j4, long j5, int i4, int i5) {
        this(downloadRequest, i3, j3, j4, j5, i4, i5, new DownloadProgress());
    }

    public long a() {
        return this.f44377h.f44427a;
    }

    public float b() {
        return this.f44377h.f44428b;
    }

    public boolean c() {
        int i3 = this.f44371b;
        return i3 == 3 || i3 == 4;
    }

    public Download(DownloadRequest downloadRequest, int i3, long j3, long j4, long j5, int i4, int i5, DownloadProgress downloadProgress) {
        Assertions.e(downloadProgress);
        boolean z2 = false;
        Assertions.a((i5 == 0) == (i3 != 4));
        if (i4 != 0) {
            if (i3 != 2 && i3 != 0) {
                z2 = true;
            }
            Assertions.a(z2);
        }
        this.f44370a = downloadRequest;
        this.f44371b = i3;
        this.f44372c = j3;
        this.f44373d = j4;
        this.f44374e = j5;
        this.f44375f = i4;
        this.f44376g = i5;
        this.f44377h = downloadProgress;
    }
}
