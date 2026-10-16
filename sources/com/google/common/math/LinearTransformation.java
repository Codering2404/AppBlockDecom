package com.google.common.math;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class LinearTransformation {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class LinearTransformationBuilder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class NaNLinearTransformation extends LinearTransformation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final NaNLinearTransformation f85311a = new NaNLinearTransformation();

        private NaNLinearTransformation() {
        }

        public String toString() {
            return "NaN";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class RegularLinearTransformation extends LinearTransformation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final double f85312a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final double f85313b;

        public String toString() {
            return String.format("y = %g * x + %g", Double.valueOf(this.f85312a), Double.valueOf(this.f85313b));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class VerticalLinearTransformation extends LinearTransformation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final double f85314a;

        public String toString() {
            return String.format("x = %g", Double.valueOf(this.f85314a));
        }
    }
}
