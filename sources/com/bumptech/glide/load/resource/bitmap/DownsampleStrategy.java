package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.Option;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class DownsampleStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DownsampleStrategy f66839a = new AtLeast();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DownsampleStrategy f66840b = new AtMost();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final DownsampleStrategy f66841c = new FitCenter();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final DownsampleStrategy f66842d = new CenterInside();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final DownsampleStrategy f66843e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final DownsampleStrategy f66844f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final DownsampleStrategy f66845g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Option f66846h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final boolean f66847i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class AtLeast extends DownsampleStrategy {
        AtLeast() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i3, int i4, int i5, int i6) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i3, int i4, int i5, int i6) {
            if (Math.min(i4 / i6, i3 / i5) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r1);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class AtMost extends DownsampleStrategy {
        AtMost() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i3, int i4, int i5, int i6) {
            return SampleSizeRounding.MEMORY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i3, int i4, int i5, int i6) {
            int iCeil = (int) Math.ceil(Math.max(i4 / i6, i3 / i5));
            return 1.0f / (r2 << (Math.max(1, Integer.highestOneBit(iCeil)) >= iCeil ? 0 : 1));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class CenterInside extends DownsampleStrategy {
        CenterInside() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i3, int i4, int i5, int i6) {
            return b(i3, i4, i5, i6) == 1.0f ? SampleSizeRounding.QUALITY : DownsampleStrategy.f66841c.a(i3, i4, i5, i6);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i3, int i4, int i5, int i6) {
            return Math.min(1.0f, DownsampleStrategy.f66841c.b(i3, i4, i5, i6));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class CenterOutside extends DownsampleStrategy {
        CenterOutside() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i3, int i4, int i5, int i6) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i3, int i4, int i5, int i6) {
            return Math.max(i5 / i3, i6 / i4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class FitCenter extends DownsampleStrategy {
        FitCenter() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i3, int i4, int i5, int i6) {
            return DownsampleStrategy.f66847i ? SampleSizeRounding.QUALITY : SampleSizeRounding.MEMORY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i3, int i4, int i5, int i6) {
            if (DownsampleStrategy.f66847i) {
                return Math.min(i5 / i3, i6 / i4);
            }
            if (Math.max(i4 / i6, i3 / i5) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class None extends DownsampleStrategy {
        None() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i3, int i4, int i5, int i6) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i3, int i4, int i5, int i6) {
            return 1.0f;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum SampleSizeRounding {
        MEMORY,
        QUALITY
    }

    static {
        CenterOutside centerOutside = new CenterOutside();
        f66843e = centerOutside;
        f66844f = new None();
        f66845g = centerOutside;
        f66846h = Option.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", centerOutside);
        f66847i = true;
    }

    public abstract SampleSizeRounding a(int i3, int i4, int i5, int i6);

    public abstract float b(int i3, int i4, int i5, int i6);
}
