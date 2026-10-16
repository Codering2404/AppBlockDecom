package androidx.media3.common;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DeviceInfo {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final DeviceInfo f40568e = new Builder(0).e();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f40569f = Util.y0(0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f40570g = Util.y0(1);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f40571h = Util.y0(2);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f40572i = Util.y0(3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f40573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f40574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f40575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f40576d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f40577a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f40578b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f40579c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f40580d;

        public Builder(int i3) {
            this.f40577a = i3;
        }

        public DeviceInfo e() {
            Assertions.a(this.f40578b <= this.f40579c);
            return new DeviceInfo(this);
        }

        public Builder f(int i3) {
            this.f40579c = i3;
            return this;
        }

        public Builder g(int i3) {
            this.f40578b = i3;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlaybackType {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceInfo)) {
            return false;
        }
        DeviceInfo deviceInfo = (DeviceInfo) obj;
        return this.f40573a == deviceInfo.f40573a && this.f40574b == deviceInfo.f40574b && this.f40575c == deviceInfo.f40575c && Objects.equals(this.f40576d, deviceInfo.f40576d);
    }

    public int hashCode() {
        int i3 = (((((527 + this.f40573a) * 31) + this.f40574b) * 31) + this.f40575c) * 31;
        String str = this.f40576d;
        return i3 + (str == null ? 0 : str.hashCode());
    }

    private DeviceInfo(Builder builder) {
        this.f40573a = builder.f40577a;
        this.f40574b = builder.f40578b;
        this.f40575c = builder.f40579c;
        this.f40576d = builder.f40580d;
    }
}
