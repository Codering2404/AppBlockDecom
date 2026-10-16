package androidx.media3.transformer;

import androidx.media3.common.util.Assertions;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class VideoEncoderSettings {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final VideoEncoderSettings f48597j = new Builder().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f48598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f48599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f48600c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f48601d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f48602e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f48603f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f48604g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f48605h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f48606i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface BitrateMode {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f48607a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f48608b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f48609c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f48610d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f48611e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f48612f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f48613g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f48614h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f48615i;

        public VideoEncoderSettings a() {
            Assertions.h(!this.f48615i || this.f48607a == -1, "Bitrate can not be set if enabling high quality targeting.");
            Assertions.h(!this.f48615i || this.f48608b == 1, "Bitrate mode must be VBR if enabling high quality targeting.");
            return new VideoEncoderSettings(this.f48607a, this.f48608b, this.f48609c, this.f48610d, this.f48611e, this.f48612f, this.f48613g, this.f48614h, this.f48615i);
        }

        public Builder b(boolean z2) {
            this.f48615i = z2;
            return this;
        }

        public Builder c(int i3) {
            this.f48607a = i3;
            return this;
        }

        public Builder d(int i3, int i4) {
            this.f48609c = i3;
            this.f48610d = i4;
            return this;
        }

        public Builder() {
            this.f48607a = -1;
            this.f48608b = 1;
            this.f48609c = -1;
            this.f48610d = -1;
            this.f48611e = 1.0f;
            this.f48612f = -1;
            this.f48613g = -1;
            this.f48614h = -1L;
        }

        private Builder(VideoEncoderSettings videoEncoderSettings) {
            this.f48607a = videoEncoderSettings.f48598a;
            this.f48608b = videoEncoderSettings.f48599b;
            this.f48609c = videoEncoderSettings.f48600c;
            this.f48610d = videoEncoderSettings.f48601d;
            this.f48611e = videoEncoderSettings.f48602e;
            this.f48612f = videoEncoderSettings.f48603f;
            this.f48613g = videoEncoderSettings.f48604g;
            this.f48614h = videoEncoderSettings.f48605h;
            this.f48615i = videoEncoderSettings.f48606i;
        }
    }

    public Builder a() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoEncoderSettings)) {
            return false;
        }
        VideoEncoderSettings videoEncoderSettings = (VideoEncoderSettings) obj;
        return this.f48598a == videoEncoderSettings.f48598a && this.f48599b == videoEncoderSettings.f48599b && this.f48600c == videoEncoderSettings.f48600c && this.f48601d == videoEncoderSettings.f48601d && this.f48602e == videoEncoderSettings.f48602e && this.f48603f == videoEncoderSettings.f48603f && this.f48604g == videoEncoderSettings.f48604g && this.f48605h == videoEncoderSettings.f48605h && this.f48606i == videoEncoderSettings.f48606i;
    }

    public int hashCode() {
        int iFloatToIntBits = (((((((((((((217 + this.f48598a) * 31) + this.f48599b) * 31) + this.f48600c) * 31) + this.f48601d) * 31) + Float.floatToIntBits(this.f48602e)) * 31) + this.f48603f) * 31) + this.f48604g) * 31;
        long j3 = this.f48605h;
        return ((iFloatToIntBits + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.f48606i ? 1 : 0);
    }

    private VideoEncoderSettings(int i3, int i4, int i5, int i6, float f3, int i7, int i8, long j3, boolean z2) {
        this.f48598a = i3;
        this.f48599b = i4;
        this.f48600c = i5;
        this.f48601d = i6;
        this.f48602e = f3;
        this.f48603f = i7;
        this.f48604g = i8;
        this.f48605h = j3;
        this.f48606i = z2;
    }
}
