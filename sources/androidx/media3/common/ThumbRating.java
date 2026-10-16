package androidx.media3.common;

import androidx.media3.common.util.Util;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ThumbRating extends Rating {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f41101d = Util.y0(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f41102e = Util.y0(2);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f41103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f41104c;

    public boolean equals(Object obj) {
        if (!(obj instanceof ThumbRating)) {
            return false;
        }
        ThumbRating thumbRating = (ThumbRating) obj;
        return this.f41104c == thumbRating.f41104c && this.f41103b == thumbRating.f41103b;
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(this.f41103b), Boolean.valueOf(this.f41104c));
    }
}
