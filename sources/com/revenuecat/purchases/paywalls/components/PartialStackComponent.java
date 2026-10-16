package com.revenuecat.purchases.paywalls.components;

import com.facebook.internal.Utility;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.BackgroundDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Badge;
import com.revenuecat.purchases.paywalls.components.properties.Badge$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.Border$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.Dimension$Horizontal$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Dimension$Vertical$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Dimension$ZLayer$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shadow$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.ShapeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.lang.annotation.Annotation;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

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
public final class PartialStackComponent implements PartialComponent {
    private final Background background;
    private final ColorScheme backgroundColor;
    private final Badge badge;
    private final Border border;
    private final Dimension dimension;
    private final Padding margin;
    private final String name;
    private final StackComponent.Overflow overflow;
    private final Padding padding;
    private final Shadow shadow;
    private final Shape shape;
    private final Size size;
    private final Float spacing;
    private final Boolean visible;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, new SealedClassSerializer("com.revenuecat.purchases.paywalls.components.properties.Dimension", Reflection.b(Dimension.class), new KClass[]{Reflection.b(Dimension.Horizontal.class), Reflection.b(Dimension.Vertical.class), Reflection.b(Dimension.ZLayer.class)}, new KSerializer[]{Dimension$Horizontal$$serializer.INSTANCE, Dimension$Vertical$$serializer.INSTANCE, Dimension$ZLayer$$serializer.INSTANCE}, new Annotation[0]), null, null, null, null, null, null, null, null, null, null, null, null};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<PartialStackComponent> serializer() {
            return PartialStackComponent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public PartialStackComponent() {
        this((Boolean) null, (Dimension) null, (Size) null, (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (String) null, 16383, (DefaultConstructorMarker) null);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PartialStackComponent partialStackComponent, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        if (compositeEncoder.z(serialDescriptor, 0) || !Intrinsics.areEqual(partialStackComponent.visible, Boolean.TRUE)) {
            compositeEncoder.i(serialDescriptor, 0, BooleanSerializer.f142767a, partialStackComponent.visible);
        }
        if (compositeEncoder.z(serialDescriptor, 1) || partialStackComponent.dimension != null) {
            compositeEncoder.i(serialDescriptor, 1, kSerializerArr[1], partialStackComponent.dimension);
        }
        if (compositeEncoder.z(serialDescriptor, 2) || partialStackComponent.size != null) {
            compositeEncoder.i(serialDescriptor, 2, Size$$serializer.INSTANCE, partialStackComponent.size);
        }
        if (compositeEncoder.z(serialDescriptor, 3) || partialStackComponent.spacing != null) {
            compositeEncoder.i(serialDescriptor, 3, FloatSerializer.f142814a, partialStackComponent.spacing);
        }
        if (compositeEncoder.z(serialDescriptor, 4) || partialStackComponent.backgroundColor != null) {
            compositeEncoder.i(serialDescriptor, 4, ColorScheme$$serializer.INSTANCE, partialStackComponent.backgroundColor);
        }
        if (compositeEncoder.z(serialDescriptor, 5) || partialStackComponent.background != null) {
            compositeEncoder.i(serialDescriptor, 5, BackgroundDeserializer.INSTANCE, partialStackComponent.background);
        }
        if (compositeEncoder.z(serialDescriptor, 6) || partialStackComponent.padding != null) {
            compositeEncoder.i(serialDescriptor, 6, Padding$$serializer.INSTANCE, partialStackComponent.padding);
        }
        if (compositeEncoder.z(serialDescriptor, 7) || partialStackComponent.margin != null) {
            compositeEncoder.i(serialDescriptor, 7, Padding$$serializer.INSTANCE, partialStackComponent.margin);
        }
        if (compositeEncoder.z(serialDescriptor, 8) || partialStackComponent.shape != null) {
            compositeEncoder.i(serialDescriptor, 8, ShapeDeserializer.INSTANCE, partialStackComponent.shape);
        }
        if (compositeEncoder.z(serialDescriptor, 9) || partialStackComponent.border != null) {
            compositeEncoder.i(serialDescriptor, 9, Border$$serializer.INSTANCE, partialStackComponent.border);
        }
        if (compositeEncoder.z(serialDescriptor, 10) || partialStackComponent.shadow != null) {
            compositeEncoder.i(serialDescriptor, 10, Shadow$$serializer.INSTANCE, partialStackComponent.shadow);
        }
        if (compositeEncoder.z(serialDescriptor, 11) || partialStackComponent.badge != null) {
            compositeEncoder.i(serialDescriptor, 11, Badge$$serializer.INSTANCE, partialStackComponent.badge);
        }
        if (compositeEncoder.z(serialDescriptor, 12) || partialStackComponent.overflow != null) {
            compositeEncoder.i(serialDescriptor, 12, StackOverflowDeserializer.INSTANCE, partialStackComponent.overflow);
        }
        if (!compositeEncoder.z(serialDescriptor, 13) && partialStackComponent.name == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 13, StringSerializer.f142891a, partialStackComponent.name);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PartialStackComponent)) {
            return false;
        }
        PartialStackComponent partialStackComponent = (PartialStackComponent) obj;
        return Intrinsics.areEqual(this.visible, partialStackComponent.visible) && Intrinsics.areEqual(this.dimension, partialStackComponent.dimension) && Intrinsics.areEqual(this.size, partialStackComponent.size) && Intrinsics.areEqual((Object) this.spacing, (Object) partialStackComponent.spacing) && Intrinsics.areEqual(this.backgroundColor, partialStackComponent.backgroundColor) && Intrinsics.areEqual(this.background, partialStackComponent.background) && Intrinsics.areEqual(this.padding, partialStackComponent.padding) && Intrinsics.areEqual(this.margin, partialStackComponent.margin) && Intrinsics.areEqual(this.shape, partialStackComponent.shape) && Intrinsics.areEqual(this.border, partialStackComponent.border) && Intrinsics.areEqual(this.shadow, partialStackComponent.shadow) && Intrinsics.areEqual(this.badge, partialStackComponent.badge) && this.overflow == partialStackComponent.overflow && Intrinsics.areEqual(this.name, partialStackComponent.name);
    }

    public final /* synthetic */ Background getBackground() {
        return this.background;
    }

    public final /* synthetic */ ColorScheme getBackgroundColor() {
        return this.backgroundColor;
    }

    public final /* synthetic */ Badge getBadge() {
        return this.badge;
    }

    public final /* synthetic */ Border getBorder() {
        return this.border;
    }

    public final /* synthetic */ Dimension getDimension() {
        return this.dimension;
    }

    public final /* synthetic */ Padding getMargin() {
        return this.margin;
    }

    public final /* synthetic */ String getName() {
        return this.name;
    }

    public final /* synthetic */ StackComponent.Overflow getOverflow() {
        return this.overflow;
    }

    public final /* synthetic */ Padding getPadding() {
        return this.padding;
    }

    public final /* synthetic */ Shadow getShadow() {
        return this.shadow;
    }

    public final /* synthetic */ Shape getShape() {
        return this.shape;
    }

    public final /* synthetic */ Size getSize() {
        return this.size;
    }

    public final /* synthetic */ Float getSpacing() {
        return this.spacing;
    }

    public final /* synthetic */ Boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        Boolean bool = this.visible;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Dimension dimension = this.dimension;
        int iHashCode2 = (iHashCode + (dimension == null ? 0 : dimension.hashCode())) * 31;
        Size size = this.size;
        int iHashCode3 = (iHashCode2 + (size == null ? 0 : size.hashCode())) * 31;
        Float f3 = this.spacing;
        int iHashCode4 = (iHashCode3 + (f3 == null ? 0 : f3.hashCode())) * 31;
        ColorScheme colorScheme = this.backgroundColor;
        int iHashCode5 = (iHashCode4 + (colorScheme == null ? 0 : colorScheme.hashCode())) * 31;
        Background background = this.background;
        int iHashCode6 = (iHashCode5 + (background == null ? 0 : background.hashCode())) * 31;
        Padding padding = this.padding;
        int iHashCode7 = (iHashCode6 + (padding == null ? 0 : padding.hashCode())) * 31;
        Padding padding2 = this.margin;
        int iHashCode8 = (iHashCode7 + (padding2 == null ? 0 : padding2.hashCode())) * 31;
        Shape shape = this.shape;
        int iHashCode9 = (iHashCode8 + (shape == null ? 0 : shape.hashCode())) * 31;
        Border border = this.border;
        int iHashCode10 = (iHashCode9 + (border == null ? 0 : border.hashCode())) * 31;
        Shadow shadow = this.shadow;
        int iHashCode11 = (iHashCode10 + (shadow == null ? 0 : shadow.hashCode())) * 31;
        Badge badge = this.badge;
        int iHashCode12 = (iHashCode11 + (badge == null ? 0 : badge.hashCode())) * 31;
        StackComponent.Overflow overflow = this.overflow;
        int iHashCode13 = (iHashCode12 + (overflow == null ? 0 : overflow.hashCode())) * 31;
        String str = this.name;
        return iHashCode13 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "PartialStackComponent(visible=" + this.visible + ", dimension=" + this.dimension + ", size=" + this.size + ", spacing=" + this.spacing + ", backgroundColor=" + this.backgroundColor + ", background=" + this.background + ", padding=" + this.padding + ", margin=" + this.margin + ", shape=" + this.shape + ", border=" + this.border + ", shadow=" + this.shadow + ", badge=" + this.badge + ", overflow=" + this.overflow + ", name=" + this.name + ')';
    }

    @Deprecated
    public /* synthetic */ PartialStackComponent(int i3, Boolean bool, Dimension dimension, Size size, Float f3, @SerialName ColorScheme colorScheme, Background background, Padding padding, Padding padding2, Shape shape, Border border, Shadow shadow, Badge badge, StackComponent.Overflow overflow, String str, SerializationConstructorMarker serializationConstructorMarker) {
        this.visible = (i3 & 1) == 0 ? Boolean.TRUE : bool;
        if ((i3 & 2) == 0) {
            this.dimension = null;
        } else {
            this.dimension = dimension;
        }
        if ((i3 & 4) == 0) {
            this.size = null;
        } else {
            this.size = size;
        }
        if ((i3 & 8) == 0) {
            this.spacing = null;
        } else {
            this.spacing = f3;
        }
        if ((i3 & 16) == 0) {
            this.backgroundColor = null;
        } else {
            this.backgroundColor = colorScheme;
        }
        if ((i3 & 32) == 0) {
            this.background = null;
        } else {
            this.background = background;
        }
        if ((i3 & 64) == 0) {
            this.padding = null;
        } else {
            this.padding = padding;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
            this.margin = null;
        } else {
            this.margin = padding2;
        }
        if ((i3 & Function.MAX_NARGS) == 0) {
            this.shape = null;
        } else {
            this.shape = shape;
        }
        if ((i3 & 512) == 0) {
            this.border = null;
        } else {
            this.border = border;
        }
        if ((i3 & 1024) == 0) {
            this.shadow = null;
        } else {
            this.shadow = shadow;
        }
        if ((i3 & 2048) == 0) {
            this.badge = null;
        } else {
            this.badge = badge;
        }
        if ((i3 & 4096) == 0) {
            this.overflow = null;
        } else {
            this.overflow = overflow;
        }
        if ((i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0) {
            this.name = null;
        } else {
            this.name = str;
        }
    }

    public PartialStackComponent(Boolean bool, Dimension dimension, Size size, Float f3, ColorScheme colorScheme, Background background, Padding padding, Padding padding2, Shape shape, Border border, Shadow shadow, Badge badge, StackComponent.Overflow overflow, String str) {
        this.visible = bool;
        this.dimension = dimension;
        this.size = size;
        this.spacing = f3;
        this.backgroundColor = colorScheme;
        this.background = background;
        this.padding = padding;
        this.margin = padding2;
        this.shape = shape;
        this.border = border;
        this.shadow = shadow;
        this.badge = badge;
        this.overflow = overflow;
        this.name = str;
    }

    @SerialName
    public static /* synthetic */ void getBackgroundColor$annotations() {
    }

    public /* synthetic */ PartialStackComponent(Boolean bool, Dimension dimension, Size size, Float f3, ColorScheme colorScheme, Background background, Padding padding, Padding padding2, Shape shape, Border border, Shadow shadow, Badge badge, StackComponent.Overflow overflow, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? Boolean.TRUE : bool, (i3 & 2) != 0 ? null : dimension, (i3 & 4) != 0 ? null : size, (i3 & 8) != 0 ? null : f3, (i3 & 16) != 0 ? null : colorScheme, (i3 & 32) != 0 ? null : background, (i3 & 64) != 0 ? null : padding, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : padding2, (i3 & Function.MAX_NARGS) != 0 ? null : shape, (i3 & 512) != 0 ? null : border, (i3 & 1024) != 0 ? null : shadow, (i3 & 2048) != 0 ? null : badge, (i3 & 4096) != 0 ? null : overflow, (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? null : str);
    }
}
