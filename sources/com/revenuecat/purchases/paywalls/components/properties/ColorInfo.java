package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.ColorAlias;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
@Serializable
public interface ColorInfo {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class Alias implements ColorInfo {
        public static final Companion Companion = new Companion(null);
        private final String value;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Alias> serializer() {
                return ColorInfo$Alias$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        @Deprecated
        public /* synthetic */ Alias(int i3, String str, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, str, serializationConstructorMarker);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Alias) && ColorAlias.m417equalsimpl0(this.value, ((Alias) obj).value);
        }

        /* JADX INFO: renamed from: getValue-671NwFM, reason: not valid java name */
        public final /* synthetic */ String m659getValue671NwFM() {
            return this.value;
        }

        public int hashCode() {
            return ColorAlias.m418hashCodeimpl(this.value);
        }

        public String toString() {
            return "Alias(value=" + ((Object) ColorAlias.m419toStringimpl(this.value)) + ')';
        }

        public /* synthetic */ Alias(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }

        private Alias(int i3, String str, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, ColorInfo$Alias$$serializer.INSTANCE.getDescriptor());
            }
            this.value = str;
        }

        private Alias(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final KSerializer<ColorInfo> serializer() {
            return new SealedClassSerializer("com.revenuecat.purchases.paywalls.components.properties.ColorInfo", Reflection.b(ColorInfo.class), new KClass[]{Reflection.b(Alias.class), Reflection.b(Gradient.Linear.class), Reflection.b(Gradient.Radial.class), Reflection.b(Hex.class)}, new KSerializer[]{ColorInfo$Alias$$serializer.INSTANCE, ColorInfo$Gradient$Linear$$serializer.INSTANCE, ColorInfo$Gradient$Radial$$serializer.INSTANCE, ColorInfo$Hex$$serializer.INSTANCE}, new Annotation[0]);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Gradient extends ColorInfo {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        @SerialName
        public static final class Radial implements Gradient {
            private final List<Point> points;
            public static final Companion Companion = new Companion(null);
            private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(ColorInfo$Gradient$Point$$serializer.INSTANCE)};

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<Radial> serializer() {
                    return ColorInfo$Gradient$Radial$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            @Deprecated
            public /* synthetic */ Radial(int i3, List list, SerializationConstructorMarker serializationConstructorMarker) {
                if (1 != (i3 & 1)) {
                    PluginExceptionsKt.b(i3, 1, ColorInfo$Gradient$Radial$$serializer.INSTANCE.getDescriptor());
                }
                this.points = list;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Radial) && Intrinsics.areEqual(this.points, ((Radial) obj).points);
            }

            public final /* synthetic */ List getPoints() {
                return this.points;
            }

            public int hashCode() {
                return this.points.hashCode();
            }

            public String toString() {
                return "Radial(points=" + this.points + ')';
            }

            public Radial(List<Point> points) {
                Intrinsics.checkNotNullParameter(points, "points");
                this.points = points;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        @SerialName
        public static final class Linear implements Gradient {
            private final float degrees;
            private final List<Point> points;
            public static final Companion Companion = new Companion(null);
            private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(ColorInfo$Gradient$Point$$serializer.INSTANCE)};

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<Linear> serializer() {
                    return ColorInfo$Gradient$Linear$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            public Linear(float f3, List<Point> points) {
                Intrinsics.checkNotNullParameter(points, "points");
                this.degrees = f3;
                this.points = points;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Linear linear, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                KSerializer<Object>[] kSerializerArr = $childSerializers;
                compositeEncoder.s(serialDescriptor, 0, linear.degrees);
                compositeEncoder.C(serialDescriptor, 1, kSerializerArr[1], linear.points);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Linear)) {
                    return false;
                }
                Linear linear = (Linear) obj;
                return Float.compare(this.degrees, linear.degrees) == 0 && Intrinsics.areEqual(this.points, linear.points);
            }

            public final /* synthetic */ float getDegrees() {
                return this.degrees;
            }

            public final /* synthetic */ List getPoints() {
                return this.points;
            }

            public int hashCode() {
                return (Float.hashCode(this.degrees) * 31) + this.points.hashCode();
            }

            public String toString() {
                return "Linear(degrees=" + this.degrees + ", points=" + this.points + ')';
            }

            @Deprecated
            public /* synthetic */ Linear(int i3, float f3, List list, SerializationConstructorMarker serializationConstructorMarker) {
                if (3 != (i3 & 3)) {
                    PluginExceptionsKt.b(i3, 3, ColorInfo$Gradient$Linear$$serializer.INSTANCE.getDescriptor());
                }
                this.degrees = f3;
                this.points = list;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class Point {
            public static final Companion Companion = new Companion(null);
            private final int color;
            private final float percent;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<Point> serializer() {
                    return ColorInfo$Gradient$Point$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            public Point(int i3, float f3) {
                this.color = i3;
                this.percent = f3;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Point point, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                compositeEncoder.C(serialDescriptor, 0, RgbaStringArgbColorIntDeserializer.INSTANCE, Integer.valueOf(point.color));
                compositeEncoder.s(serialDescriptor, 1, point.percent);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Point)) {
                    return false;
                }
                Point point = (Point) obj;
                return this.color == point.color && Float.compare(this.percent, point.percent) == 0;
            }

            public final /* synthetic */ int getColor() {
                return this.color;
            }

            public final /* synthetic */ float getPercent() {
                return this.percent;
            }

            public int hashCode() {
                return (this.color * 31) + Float.hashCode(this.percent);
            }

            public String toString() {
                return "Point(color=" + this.color + ", percent=" + this.percent + ')';
            }

            @Deprecated
            public /* synthetic */ Point(int i3, @Serializable(with = RgbaStringArgbColorIntDeserializer.class) int i4, float f3, SerializationConstructorMarker serializationConstructorMarker) {
                if (3 != (i3 & 3)) {
                    PluginExceptionsKt.b(i3, 3, ColorInfo$Gradient$Point$$serializer.INSTANCE.getDescriptor());
                }
                this.color = i4;
                this.percent = f3;
            }

            @Serializable(with = RgbaStringArgbColorIntDeserializer.class)
            public static /* synthetic */ void getColor$annotations() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class Hex implements ColorInfo {
        public static final Companion Companion = new Companion(null);
        private final int value;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Hex> serializer() {
                return ColorInfo$Hex$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public Hex(int i3) {
            this.value = i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Hex) && this.value == ((Hex) obj).value;
        }

        public final /* synthetic */ int getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "Hex(value=" + this.value + ')';
        }

        @Deprecated
        public /* synthetic */ Hex(int i3, @Serializable(with = RgbaStringArgbColorIntDeserializer.class) int i4, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, ColorInfo$Hex$$serializer.INSTANCE.getDescriptor());
            }
            this.value = i4;
        }

        @Serializable(with = RgbaStringArgbColorIntDeserializer.class)
        public static /* synthetic */ void getValue$annotations() {
        }
    }
}
