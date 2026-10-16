package androidx.media3.extractor.mp4;

import androidx.media3.common.Format;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Track {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f46819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f46820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f46821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f46822d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f46823e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f46824f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Format f46825g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f46826h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long[] f46827i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long[] f46828j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f46829k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final TrackEncryptionBox[] f46830l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Transformation {
    }

    public Track(int i3, int i4, long j3, long j4, long j5, long j6, Format format, int i5, TrackEncryptionBox[] trackEncryptionBoxArr, int i6, long[] jArr, long[] jArr2) {
        this.f46819a = i3;
        this.f46820b = i4;
        this.f46821c = j3;
        this.f46822d = j4;
        this.f46823e = j5;
        this.f46824f = j6;
        this.f46825g = format;
        this.f46826h = i5;
        this.f46830l = trackEncryptionBoxArr;
        this.f46829k = i6;
        this.f46827i = jArr;
        this.f46828j = jArr2;
    }

    public Track a(Format format) {
        return new Track(this.f46819a, this.f46820b, this.f46821c, this.f46822d, this.f46823e, this.f46824f, format, this.f46826h, this.f46830l, this.f46829k, this.f46827i, this.f46828j);
    }

    public TrackEncryptionBox b(int i3) {
        TrackEncryptionBox[] trackEncryptionBoxArr = this.f46830l;
        if (trackEncryptionBoxArr == null) {
            return null;
        }
        return trackEncryptionBoxArr[i3];
    }
}
