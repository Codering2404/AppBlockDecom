package androidx.media3.common;

import android.media.AudioAttributes;
import androidx.media3.common.util.Util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class AudioAttributes {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AudioAttributes f40518g = new Builder().a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f40519h = Util.y0(0);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f40520i = Util.y0(1);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f40521j = Util.y0(2);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f40522k = Util.y0(3);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f40523l = Util.y0(4);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f40524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f40525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f40526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f40527d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f40528e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AudioAttributesV21 f40529f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Api29 {
        public static void a(AudioAttributes.Builder builder, int i3) {
            builder.setAllowedCapturePolicy(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Api32 {
        public static void a(AudioAttributes.Builder builder, int i3) {
            builder.setSpatializationBehavior(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class AudioAttributesV21 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final android.media.AudioAttributes f40530a;

        private AudioAttributesV21(AudioAttributes audioAttributes) {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(audioAttributes.f40524a).setFlags(audioAttributes.f40525b).setUsage(audioAttributes.f40526c);
            int i3 = Util.f41609a;
            if (i3 >= 29) {
                Api29.a(usage, audioAttributes.f40527d);
            }
            if (i3 >= 32) {
                Api32.a(usage, audioAttributes.f40528e);
            }
            this.f40530a = usage.build();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f40531a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f40532b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f40533c = 1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f40534d = 1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f40535e = 0;

        public AudioAttributes a() {
            return new AudioAttributes(this.f40531a, this.f40532b, this.f40533c, this.f40534d, this.f40535e);
        }
    }

    public AudioAttributesV21 a() {
        if (this.f40529f == null) {
            this.f40529f = new AudioAttributesV21();
        }
        return this.f40529f;
    }

    public int b() {
        if ((this.f40525b & 1) == 1) {
            return 1;
        }
        switch (this.f40526c) {
        }
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && AudioAttributes.class == obj.getClass()) {
            AudioAttributes audioAttributes = (AudioAttributes) obj;
            if (this.f40524a == audioAttributes.f40524a && this.f40525b == audioAttributes.f40525b && this.f40526c == audioAttributes.f40526c && this.f40527d == audioAttributes.f40527d && this.f40528e == audioAttributes.f40528e) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((527 + this.f40524a) * 31) + this.f40525b) * 31) + this.f40526c) * 31) + this.f40527d) * 31) + this.f40528e;
    }

    private AudioAttributes(int i3, int i4, int i5, int i6, int i7) {
        this.f40524a = i3;
        this.f40525b = i4;
        this.f40526c = i5;
        this.f40527d = i6;
        this.f40528e = i7;
    }
}
