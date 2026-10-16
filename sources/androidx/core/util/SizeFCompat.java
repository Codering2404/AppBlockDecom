package androidx.core.util;

import android.util.SizeF;
import com.facebook.appevents.internal.ViewHierarchyConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class SizeFCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f34356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f34357b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Api21Impl {
        static SizeF a(SizeFCompat sizeFCompat) {
            Preconditions.h(sizeFCompat);
            return new SizeF(sizeFCompat.b(), sizeFCompat.a());
        }

        static SizeFCompat b(SizeF sizeF) {
            Preconditions.h(sizeF);
            return new SizeFCompat(sizeF.getWidth(), sizeF.getHeight());
        }
    }

    public SizeFCompat(float f3, float f4) {
        this.f34356a = Preconditions.c(f3, ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
        this.f34357b = Preconditions.c(f4, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
    }

    public static SizeFCompat d(SizeF sizeF) {
        return Api21Impl.b(sizeF);
    }

    public float a() {
        return this.f34357b;
    }

    public float b() {
        return this.f34356a;
    }

    public SizeF c() {
        return Api21Impl.a(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SizeFCompat)) {
            return false;
        }
        SizeFCompat sizeFCompat = (SizeFCompat) obj;
        return sizeFCompat.f34356a == this.f34356a && sizeFCompat.f34357b == this.f34357b;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f34356a) ^ Float.floatToIntBits(this.f34357b);
    }

    public String toString() {
        return this.f34356a + "x" + this.f34357b;
    }
}
