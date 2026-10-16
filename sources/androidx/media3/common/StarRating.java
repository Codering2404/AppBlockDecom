package androidx.media3.common;

import androidx.media3.common.util.Util;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class StarRating extends Rating {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f41086d = Util.y0(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f41087e = Util.y0(2);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f41088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f41089c;

    public boolean equals(Object obj) {
        if (!(obj instanceof StarRating)) {
            return false;
        }
        StarRating starRating = (StarRating) obj;
        return this.f41088b == starRating.f41088b && this.f41089c == starRating.f41089c;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f41088b), Float.valueOf(this.f41089c));
    }
}
