package androidx.window.embedding;

import androidx.window.core.SpecificationComputer;
import androidx.window.core.VerificationMode;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SplitAttributes {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f54241c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f54242d = SplitAttributes.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SplitType f54243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LayoutDirection f54244b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private SplitType f54245a = SplitType.f54257e;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private LayoutDirection f54246b = LayoutDirection.f54248d;

        public final SplitAttributes a() {
            return new SplitAttributes(this.f54245a, this.f54246b);
        }

        public final Builder b(LayoutDirection layoutDirection) {
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            this.f54246b = layoutDirection;
            return this;
        }

        public final Builder c(SplitType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.f54245a = type;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LayoutDirection {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Companion f54247c = new Companion(null);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final LayoutDirection f54248d = new LayoutDirection("LOCALE", 0);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final LayoutDirection f54249e = new LayoutDirection("LEFT_TO_RIGHT", 1);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final LayoutDirection f54250f = new LayoutDirection("RIGHT_TO_LEFT", 2);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final LayoutDirection f54251g = new LayoutDirection("TOP_TO_BOTTOM", 3);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final LayoutDirection f54252h = new LayoutDirection("BOTTOM_TO_TOP", 4);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f54253a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f54254b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        private LayoutDirection(String str, int i3) {
            this.f54253a = str;
            this.f54254b = i3;
        }

        public String toString() {
            return this.f54253a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SplitType {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Companion f54255c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final SplitType f54256d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final SplitType f54257e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final SplitType f54258f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f54259a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f54260b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final SplitType a(float f3) {
                SplitType splitType = SplitType.f54256d;
                return f3 == splitType.a() ? splitType : b(f3);
            }

            public final SplitType b(final float f3) {
                SpecificationComputer.Companion companion = SpecificationComputer.f54141a;
                Float fValueOf = Float.valueOf(f3);
                String TAG = SplitAttributes.f54242d;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                Object objA = SpecificationComputer.Companion.b(companion, fValueOf, TAG, VerificationMode.STRICT, null, 4, null).c("Ratio must be in range (0.0, 1.0). Use SplitType.expandContainers() instead of 0 or 1.", new Function1<Float, Boolean>() { // from class: androidx.window.embedding.SplitAttributes$SplitType$Companion$ratio$checkedRatio$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final Boolean c(float f4) {
                        double d3 = f3;
                        return Boolean.valueOf(0.0d <= d3 && d3 <= 1.0d && !ArraysKt.contains(new Float[]{Float.valueOf(0.0f), Float.valueOf(1.0f)}, Float.valueOf(f3)));
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return c(((Number) obj).floatValue());
                    }
                }).a();
                Intrinsics.checkNotNull(objA);
                float fFloatValue = ((Number) objA).floatValue();
                return new SplitType("ratio:" + fFloatValue, fFloatValue);
            }

            private Companion() {
            }
        }

        static {
            Companion companion = new Companion(null);
            f54255c = companion;
            f54256d = new SplitType("expandContainers", 0.0f);
            f54257e = companion.b(0.5f);
            f54258f = new SplitType("hinge", -1.0f);
        }

        public SplitType(String description, float f3) {
            Intrinsics.checkNotNullParameter(description, "description");
            this.f54259a = description;
            this.f54260b = f3;
        }

        public final float a() {
            return this.f54260b;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SplitType)) {
                return false;
            }
            SplitType splitType = (SplitType) obj;
            return this.f54260b == splitType.f54260b && Intrinsics.areEqual(this.f54259a, splitType.f54259a);
        }

        public int hashCode() {
            return this.f54259a.hashCode() + (Float.hashCode(this.f54260b) * 31);
        }

        public String toString() {
            return this.f54259a;
        }
    }

    public SplitAttributes(SplitType splitType, LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(splitType, "splitType");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        this.f54243a = splitType;
        this.f54244b = layoutDirection;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitAttributes)) {
            return false;
        }
        SplitAttributes splitAttributes = (SplitAttributes) obj;
        return Intrinsics.areEqual(this.f54243a, splitAttributes.f54243a) && Intrinsics.areEqual(this.f54244b, splitAttributes.f54244b);
    }

    public int hashCode() {
        return (this.f54243a.hashCode() * 31) + this.f54244b.hashCode();
    }

    public String toString() {
        return SplitAttributes.class.getSimpleName() + ":{splitType=" + this.f54243a + ", layoutDir=" + this.f54244b + " }";
    }
}
