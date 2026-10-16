package ru.noties.markwon.image;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class ImageSize {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Dimension f147374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Dimension f147375b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Dimension {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f147376a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f147377b;

        public Dimension(float f3, String str) {
            this.f147376a = f3;
            this.f147377b = str;
        }

        public String toString() {
            return "Dimension{value=" + this.f147376a + ", unit='" + this.f147377b + "'}";
        }
    }

    public ImageSize(Dimension dimension, Dimension dimension2) {
        this.f147374a = dimension;
        this.f147375b = dimension2;
    }

    public String toString() {
        return "ImageSize{width=" + this.f147374a + ", height=" + this.f147375b + '}';
    }
}
