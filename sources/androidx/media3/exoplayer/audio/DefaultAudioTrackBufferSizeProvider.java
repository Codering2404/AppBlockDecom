package androidx.media3.exoplayer.audio;

import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.audio.DefaultAudioSink;
import com.google.common.primitives.Ints;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class DefaultAudioTrackBufferSizeProvider implements DefaultAudioSink.AudioTrackBufferSizeProvider {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final int f43853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final int f43854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final int f43855d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final int f43856e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final int f43857f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f43858g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f43859h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f43860a = 250000;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f43861b = 750000;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f43862c = 4;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f43863d = 250000;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f43864e = 50000000;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f43865f = 2;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f43866g = 4;

        public DefaultAudioTrackBufferSizeProvider h() {
            return new DefaultAudioTrackBufferSizeProvider(this);
        }
    }

    protected DefaultAudioTrackBufferSizeProvider(Builder builder) {
        this.f43853b = builder.f43860a;
        this.f43854c = builder.f43861b;
        this.f43855d = builder.f43862c;
        this.f43856e = builder.f43863d;
        this.f43857f = builder.f43864e;
        this.f43858g = builder.f43865f;
        this.f43859h = builder.f43866g;
    }

    protected static int b(int i3, int i4, int i5) {
        return Ints.d(((((long) i3) * ((long) i4)) * ((long) i5)) / 1000000);
    }

    protected static int d(int i3) {
        if (i3 == 20) {
            return 63750;
        }
        if (i3 == 30) {
            return 2250000;
        }
        switch (i3) {
            case 5:
                return 80000;
            case 6:
                return 768000;
            case 7:
                return 192000;
            case 8:
                return 2250000;
            case 9:
                return 40000;
            case 10:
                return 100000;
            case 11:
                return 16000;
            case 12:
                return 7000;
            default:
                switch (i3) {
                    case 14:
                        return 3062500;
                    case 15:
                        return 8000;
                    case 16:
                        return 256000;
                    case 17:
                        return 336000;
                    case 18:
                        return 768000;
                    default:
                        throw new IllegalArgumentException();
                }
        }
    }

    @Override // androidx.media3.exoplayer.audio.DefaultAudioSink.AudioTrackBufferSizeProvider
    public int a(int i3, int i4, int i5, int i6, int i7, int i8, double d3) {
        return (((Math.max(i3, (int) (((double) c(i3, i4, i5, i6, i7, i8)) * d3)) + i6) - 1) / i6) * i6;
    }

    protected int c(int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i5 == 0) {
            return g(i3, i7, i6);
        }
        if (i5 == 1) {
            return e(i4);
        }
        if (i5 == 2) {
            return f(i4, i8);
        }
        throw new IllegalArgumentException();
    }

    protected int e(int i3) {
        return Ints.d((((long) this.f43857f) * ((long) d(i3))) / 1000000);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected int f(int r4, int r5) {
        /*
            r3 = this;
            int r0 = r3.f43856e
            r1 = 5
            r2 = 8
            if (r4 != r1) goto Lb
            int r1 = r3.f43858g
        L9:
            int r0 = r0 * r1
            goto L10
        Lb:
            if (r4 != r2) goto L10
            int r1 = r3.f43859h
            goto L9
        L10:
            r1 = -1
            if (r5 == r1) goto L1a
            java.math.RoundingMode r4 = java.math.RoundingMode.CEILING
            int r4 = com.google.common.math.IntMath.d(r5, r2, r4)
            goto L1e
        L1a:
            int r4 = d(r4)
        L1e:
            long r0 = (long) r0
            long r4 = (long) r4
            long r0 = r0 * r4
            r4 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = r0 / r4
            int r4 = com.google.common.primitives.Ints.d(r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.audio.DefaultAudioTrackBufferSizeProvider.f(int, int):int");
    }

    protected int g(int i3, int i4, int i5) {
        return Util.r(i3 * this.f43855d, b(this.f43853b, i4, i5), b(this.f43854c, i4, i5));
    }
}
