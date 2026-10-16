package androidx.media3.exoplayer.analytics;

import android.media.metrics.LogSessionId;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class PlayerId {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final PlayerId f43489d = new PlayerId("");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f43490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LogSessionIdApi31 f43491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f43492c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class LogSessionIdApi31 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LogSessionId f43493a = LogSessionId.LOG_SESSION_ID_NONE;

        public void a(LogSessionId logSessionId) {
            Assertions.g(this.f43493a.equals(LogSessionId.LOG_SESSION_ID_NONE));
            this.f43493a = logSessionId;
        }
    }

    public PlayerId(String str) {
        this.f43490a = str;
        this.f43491b = Util.f41609a >= 31 ? new LogSessionIdApi31() : null;
        this.f43492c = new Object();
    }

    public synchronized LogSessionId a() {
        return ((LogSessionIdApi31) Assertions.e(this.f43491b)).f43493a;
    }

    public synchronized void b(LogSessionId logSessionId) {
        ((LogSessionIdApi31) Assertions.e(this.f43491b)).a(logSessionId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayerId)) {
            return false;
        }
        PlayerId playerId = (PlayerId) obj;
        return Objects.equals(this.f43490a, playerId.f43490a) && Objects.equals(this.f43491b, playerId.f43491b) && Objects.equals(this.f43492c, playerId.f43492c);
    }

    public int hashCode() {
        return Objects.hash(this.f43490a, this.f43491b, this.f43492c);
    }
}
