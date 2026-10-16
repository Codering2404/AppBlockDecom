package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.paywalls.components.properties.CornerRadiuses;
import java.lang.annotation.Annotation;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ObjectSerializer;
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
@Serializable(with = ShapeDeserializer.class)
public interface Shape {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final CornerRadiuses.Percentage pillCornerRadiuses = new CornerRadiuses.Percentage(50);

        private Companion() {
        }

        public final KSerializer<Shape> serializer() {
            return ShapeDeserializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
        @Deprecated
        public static CornerRadiuses getCornerRadiuses(Shape shape) {
            return Shape.super.getCornerRadiuses();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class Pill implements Shape {
        public static final Pill INSTANCE = new Pill();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.paywalls.components.properties.Shape.Pill.1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return new ObjectSerializer("com.revenuecat.purchases.paywalls.components.properties.Shape.Pill", Pill.INSTANCE, new Annotation[0]);
            }
        });

        private Pill() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<Pill> serializer() {
            return get$cachedSerializer();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class Rectangle implements Shape {
        public static final Companion Companion = new Companion(null);
        private final CornerRadiuses corners;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Rectangle> serializer() {
                return Shape$Rectangle$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Rectangle() {
            this((CornerRadiuses) null, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Rectangle rectangle, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            if (!compositeEncoder.z(serialDescriptor, 0) && rectangle.corners == null) {
                return;
            }
            compositeEncoder.i(serialDescriptor, 0, CornerRadiusesSerializer.INSTANCE, rectangle.corners);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Rectangle) && Intrinsics.areEqual(this.corners, ((Rectangle) obj).corners);
        }

        public final /* synthetic */ CornerRadiuses getCorners() {
            return this.corners;
        }

        public int hashCode() {
            CornerRadiuses cornerRadiuses = this.corners;
            if (cornerRadiuses == null) {
                return 0;
            }
            return cornerRadiuses.hashCode();
        }

        public String toString() {
            return "Rectangle(corners=" + this.corners + ')';
        }

        @Deprecated
        public /* synthetic */ Rectangle(int i3, CornerRadiuses cornerRadiuses, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i3 & 1) == 0) {
                this.corners = null;
            } else {
                this.corners = cornerRadiuses;
            }
        }

        public Rectangle(CornerRadiuses cornerRadiuses) {
            this.corners = cornerRadiuses;
        }

        public /* synthetic */ Rectangle(CornerRadiuses cornerRadiuses, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : cornerRadiuses);
        }
    }

    default CornerRadiuses getCornerRadiuses() {
        if (!(this instanceof Rectangle)) {
            return Companion.pillCornerRadiuses;
        }
        CornerRadiuses corners = ((Rectangle) this).getCorners();
        return corners == null ? CornerRadiuses.Dp.Companion.getZero() : corners;
    }
}
