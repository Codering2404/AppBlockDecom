package androidx.media3.exoplayer;

import androidx.media3.common.util.Assertions;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class LoadingInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f43121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f43122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f43123c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f43124a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f43125b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f43126c;

        public LoadingInfo d() {
            return new LoadingInfo(this);
        }

        public Builder e(long j3) {
            Assertions.a(j3 >= 0 || j3 == -9223372036854775807L);
            this.f43126c = j3;
            return this;
        }

        public Builder f(long j3) {
            this.f43124a = j3;
            return this;
        }

        public Builder g(float f3) {
            Assertions.a(f3 > 0.0f || f3 == -3.4028235E38f);
            this.f43125b = f3;
            return this;
        }

        public Builder() {
            this.f43124a = -9223372036854775807L;
            this.f43125b = -3.4028235E38f;
            this.f43126c = -9223372036854775807L;
        }

        private Builder(LoadingInfo loadingInfo) {
            this.f43124a = loadingInfo.f43121a;
            this.f43125b = loadingInfo.f43122b;
            this.f43126c = loadingInfo.f43123c;
        }
    }

    public Builder a() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoadingInfo)) {
            return false;
        }
        LoadingInfo loadingInfo = (LoadingInfo) obj;
        return this.f43121a == loadingInfo.f43121a && this.f43122b == loadingInfo.f43122b && this.f43123c == loadingInfo.f43123c;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.f43121a), Float.valueOf(this.f43122b), Long.valueOf(this.f43123c));
    }

    private LoadingInfo(Builder builder) {
        this.f43121a = builder.f43124a;
        this.f43122b = builder.f43125b;
        this.f43123c = builder.f43126c;
    }
}
