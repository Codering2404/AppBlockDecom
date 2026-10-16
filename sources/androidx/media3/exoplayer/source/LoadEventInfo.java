package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.datasource.DataSpec;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class LoadEventInfo {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final AtomicLong f44704h = new AtomicLong();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f44705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataSpec f44706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f44707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f44708d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f44709e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f44710f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f44711g;

    public LoadEventInfo(long j3, DataSpec dataSpec, long j4) {
        this(j3, dataSpec, dataSpec.f41829a, Collections.EMPTY_MAP, j4, 0L, 0L);
    }

    public static long a() {
        return f44704h.getAndIncrement();
    }

    public LoadEventInfo(long j3, DataSpec dataSpec, Uri uri, Map map, long j4, long j5, long j6) {
        this.f44705a = j3;
        this.f44706b = dataSpec;
        this.f44707c = uri;
        this.f44708d = map;
        this.f44709e = j4;
        this.f44710f = j5;
        this.f44711g = j6;
    }
}
