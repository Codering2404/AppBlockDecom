package com.revenuecat.purchases.paywalls.components;

import com.facebook.internal.Utility;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.BackgroundDeserializer;
import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
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
import com.revenuecat.purchases.paywalls.components.properties.FlexDistribution;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shadow$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.ShapeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
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
@SerialName
@Metadata
@Serializable
public final class StackComponent implements PaywallComponent {
    private final Background background;
    private final ColorScheme backgroundColor;
    private final Badge badge;
    private final Border border;
    private final List<PaywallComponent> components;
    private final Dimension dimension;
    private final Padding margin;
    private final String name;
    private final Overflow overflow;
    private final List<ComponentOverride<PartialStackComponent>> overrides;
    private final Padding padding;
    private final Shadow shadow;
    private final Shape shape;
    private final Size size;
    private final Float spacing;
    private final Boolean visible;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(new PaywallComponentSerializer()), null, new SealedClassSerializer("com.revenuecat.purchases.paywalls.components.properties.Dimension", Reflection.b(Dimension.class), new KClass[]{Reflection.b(Dimension.Horizontal.class), Reflection.b(Dimension.Vertical.class), Reflection.b(Dimension.ZLayer.class)}, new KSerializer[]{Dimension$Horizontal$$serializer.INSTANCE, Dimension$Vertical$$serializer.INSTANCE, Dimension$ZLayer$$serializer.INSTANCE}, new Annotation[0]), null, null, null, null, null, null, null, null, null, null, null, new ArrayListSerializer(ComponentOverride.Companion.serializer(PartialStackComponent$$serializer.INSTANCE)), null};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<StackComponent> serializer() {
            return StackComponent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable(with = StackOverflowDeserializer.class)
    public enum Overflow {
        NONE,
        SCROLL;

        public static final Companion Companion = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Overflow> serializer() {
                return StackOverflowDeserializer.INSTANCE;
            }

            private Companion() {
            }
        }
    }

    @Deprecated
    public /* synthetic */ StackComponent(int i3, List list, Boolean bool, Dimension dimension, Size size, Float f3, @SerialName ColorScheme colorScheme, Background background, Padding padding, Padding padding2, Shape shape, Border border, Shadow shadow, Badge badge, Overflow overflow, List list2, String str, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i3 & 1)) {
            PluginExceptionsKt.b(i3, 1, StackComponent$$serializer.INSTANCE.getDescriptor());
        }
        this.components = list;
        if ((i3 & 2) == 0) {
            this.visible = null;
        } else {
            this.visible = bool;
        }
        if ((i3 & 4) == 0) {
            this.dimension = new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START);
        } else {
            this.dimension = dimension;
        }
        if ((i3 & 8) == 0) {
            this.size = new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE);
        } else {
            this.size = size;
        }
        if ((i3 & 16) == 0) {
            this.spacing = null;
        } else {
            this.spacing = f3;
        }
        if ((i3 & 32) == 0) {
            this.backgroundColor = null;
        } else {
            this.backgroundColor = colorScheme;
        }
        if ((i3 & 64) == 0) {
            this.background = null;
        } else {
            this.background = background;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
            this.padding = Padding.Companion.getZero();
        } else {
            this.padding = padding;
        }
        if ((i3 & Function.MAX_NARGS) == 0) {
            this.margin = Padding.Companion.getZero();
        } else {
            this.margin = padding2;
        }
        if ((i3 & 512) == 0) {
            this.shape = null;
        } else {
            this.shape = shape;
        }
        if ((i3 & 1024) == 0) {
            this.border = null;
        } else {
            this.border = border;
        }
        if ((i3 & 2048) == 0) {
            this.shadow = null;
        } else {
            this.shadow = shadow;
        }
        if ((i3 & 4096) == 0) {
            this.badge = null;
        } else {
            this.badge = badge;
        }
        if ((i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0) {
            this.overflow = null;
        } else {
            this.overflow = overflow;
        }
        this.overrides = (i3 & 16384) == 0 ? CollectionsKt.emptyList() : list2;
        if ((i3 & 32768) == 0) {
            this.name = null;
        } else {
            this.name = str;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(StackComponent stackComponent, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.C(serialDescriptor, 0, kSerializerArr[0], stackComponent.components);
        if (compositeEncoder.z(serialDescriptor, 1) || stackComponent.visible != null) {
            compositeEncoder.i(serialDescriptor, 1, BooleanSerializer.f142767a, stackComponent.visible);
        }
        if (compositeEncoder.z(serialDescriptor, 2) || !Intrinsics.areEqual(stackComponent.dimension, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START))) {
            compositeEncoder.C(serialDescriptor, 2, kSerializerArr[2], stackComponent.dimension);
        }
        if (compositeEncoder.z(serialDescriptor, 3) || !Intrinsics.areEqual(stackComponent.size, new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE))) {
            compositeEncoder.C(serialDescriptor, 3, Size$$serializer.INSTANCE, stackComponent.size);
        }
        if (compositeEncoder.z(serialDescriptor, 4) || stackComponent.spacing != null) {
            compositeEncoder.i(serialDescriptor, 4, FloatSerializer.f142814a, stackComponent.spacing);
        }
        if (compositeEncoder.z(serialDescriptor, 5) || stackComponent.backgroundColor != null) {
            compositeEncoder.i(serialDescriptor, 5, ColorScheme$$serializer.INSTANCE, stackComponent.backgroundColor);
        }
        if (compositeEncoder.z(serialDescriptor, 6) || stackComponent.background != null) {
            compositeEncoder.i(serialDescriptor, 6, BackgroundDeserializer.INSTANCE, stackComponent.background);
        }
        if (compositeEncoder.z(serialDescriptor, 7) || !Intrinsics.areEqual(stackComponent.padding, Padding.Companion.getZero())) {
            compositeEncoder.C(serialDescriptor, 7, Padding$$serializer.INSTANCE, stackComponent.padding);
        }
        if (compositeEncoder.z(serialDescriptor, 8) || !Intrinsics.areEqual(stackComponent.margin, Padding.Companion.getZero())) {
            compositeEncoder.C(serialDescriptor, 8, Padding$$serializer.INSTANCE, stackComponent.margin);
        }
        if (compositeEncoder.z(serialDescriptor, 9) || stackComponent.shape != null) {
            compositeEncoder.i(serialDescriptor, 9, ShapeDeserializer.INSTANCE, stackComponent.shape);
        }
        if (compositeEncoder.z(serialDescriptor, 10) || stackComponent.border != null) {
            compositeEncoder.i(serialDescriptor, 10, Border$$serializer.INSTANCE, stackComponent.border);
        }
        if (compositeEncoder.z(serialDescriptor, 11) || stackComponent.shadow != null) {
            compositeEncoder.i(serialDescriptor, 11, Shadow$$serializer.INSTANCE, stackComponent.shadow);
        }
        if (compositeEncoder.z(serialDescriptor, 12) || stackComponent.badge != null) {
            compositeEncoder.i(serialDescriptor, 12, Badge$$serializer.INSTANCE, stackComponent.badge);
        }
        if (compositeEncoder.z(serialDescriptor, 13) || stackComponent.overflow != null) {
            compositeEncoder.i(serialDescriptor, 13, StackOverflowDeserializer.INSTANCE, stackComponent.overflow);
        }
        if (compositeEncoder.z(serialDescriptor, 14) || !Intrinsics.areEqual(stackComponent.overrides, CollectionsKt.emptyList())) {
            compositeEncoder.C(serialDescriptor, 14, kSerializerArr[14], stackComponent.overrides);
        }
        if (!compositeEncoder.z(serialDescriptor, 15) && stackComponent.name == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 15, StringSerializer.f142891a, stackComponent.name);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StackComponent)) {
            return false;
        }
        StackComponent stackComponent = (StackComponent) obj;
        return Intrinsics.areEqual(this.components, stackComponent.components) && Intrinsics.areEqual(this.visible, stackComponent.visible) && Intrinsics.areEqual(this.dimension, stackComponent.dimension) && Intrinsics.areEqual(this.size, stackComponent.size) && Intrinsics.areEqual((Object) this.spacing, (Object) stackComponent.spacing) && Intrinsics.areEqual(this.backgroundColor, stackComponent.backgroundColor) && Intrinsics.areEqual(this.background, stackComponent.background) && Intrinsics.areEqual(this.padding, stackComponent.padding) && Intrinsics.areEqual(this.margin, stackComponent.margin) && Intrinsics.areEqual(this.shape, stackComponent.shape) && Intrinsics.areEqual(this.border, stackComponent.border) && Intrinsics.areEqual(this.shadow, stackComponent.shadow) && Intrinsics.areEqual(this.badge, stackComponent.badge) && this.overflow == stackComponent.overflow && Intrinsics.areEqual(this.overrides, stackComponent.overrides) && Intrinsics.areEqual(this.name, stackComponent.name);
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

    public final /* synthetic */ List getComponents() {
        return this.components;
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

    public final /* synthetic */ Overflow getOverflow() {
        return this.overflow;
    }

    public final /* synthetic */ List getOverrides() {
        return this.overrides;
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
        int iHashCode = this.components.hashCode() * 31;
        Boolean bool = this.visible;
        int iHashCode2 = (((((iHashCode + (bool == null ? 0 : bool.hashCode())) * 31) + this.dimension.hashCode()) * 31) + this.size.hashCode()) * 31;
        Float f3 = this.spacing;
        int iHashCode3 = (iHashCode2 + (f3 == null ? 0 : f3.hashCode())) * 31;
        ColorScheme colorScheme = this.backgroundColor;
        int iHashCode4 = (iHashCode3 + (colorScheme == null ? 0 : colorScheme.hashCode())) * 31;
        Background background = this.background;
        int iHashCode5 = (((((iHashCode4 + (background == null ? 0 : background.hashCode())) * 31) + this.padding.hashCode()) * 31) + this.margin.hashCode()) * 31;
        Shape shape = this.shape;
        int iHashCode6 = (iHashCode5 + (shape == null ? 0 : shape.hashCode())) * 31;
        Border border = this.border;
        int iHashCode7 = (iHashCode6 + (border == null ? 0 : border.hashCode())) * 31;
        Shadow shadow = this.shadow;
        int iHashCode8 = (iHashCode7 + (shadow == null ? 0 : shadow.hashCode())) * 31;
        Badge badge = this.badge;
        int iHashCode9 = (iHashCode8 + (badge == null ? 0 : badge.hashCode())) * 31;
        Overflow overflow = this.overflow;
        int iHashCode10 = (((iHashCode9 + (overflow == null ? 0 : overflow.hashCode())) * 31) + this.overrides.hashCode()) * 31;
        String str = this.name;
        return iHashCode10 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "StackComponent(components=" + this.components + ", visible=" + this.visible + ", dimension=" + this.dimension + ", size=" + this.size + ", spacing=" + this.spacing + ", backgroundColor=" + this.backgroundColor + ", background=" + this.background + ", padding=" + this.padding + ", margin=" + this.margin + ", shape=" + this.shape + ", border=" + this.border + ", shadow=" + this.shadow + ", badge=" + this.badge + ", overflow=" + this.overflow + ", overrides=" + this.overrides + ", name=" + this.name + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StackComponent(List<? extends PaywallComponent> components, Boolean bool, Dimension dimension, Size size, Float f3, ColorScheme colorScheme, Background background, Padding padding, Padding margin, Shape shape, Border border, Shadow shadow, Badge badge, Overflow overflow, List<ComponentOverride<PartialStackComponent>> overrides, String str) {
        Intrinsics.checkNotNullParameter(components, "components");
        Intrinsics.checkNotNullParameter(dimension, "dimension");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        this.components = components;
        this.visible = bool;
        this.dimension = dimension;
        this.size = size;
        this.spacing = f3;
        this.backgroundColor = colorScheme;
        this.background = background;
        this.padding = padding;
        this.margin = margin;
        this.shape = shape;
        this.border = border;
        this.shadow = shadow;
        this.badge = badge;
        this.overflow = overflow;
        this.overrides = overrides;
        this.name = str;
    }

    @SerialName
    public static /* synthetic */ void getBackgroundColor$annotations() {
    }

    public /* synthetic */ StackComponent(List list, Boolean bool, Dimension dimension, Size size, Float f3, ColorScheme colorScheme, Background background, Padding padding, Padding padding2, Shape shape, Border border, Shadow shadow, Badge badge, Overflow overflow, List list2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i3 & 2) != 0 ? null : bool, (i3 & 4) != 0 ? new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START) : dimension, (i3 & 8) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE) : size, (i3 & 16) != 0 ? null : f3, (i3 & 32) != 0 ? null : colorScheme, (i3 & 64) != 0 ? null : background, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? Padding.Companion.getZero() : padding, (i3 & Function.MAX_NARGS) != 0 ? Padding.Companion.getZero() : padding2, (i3 & 512) != 0 ? null : shape, (i3 & 1024) != 0 ? null : border, (i3 & 2048) != 0 ? null : shadow, (i3 & 4096) != 0 ? null : badge, (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? null : overflow, (i3 & 16384) != 0 ? CollectionsKt.emptyList() : list2, (i3 & 32768) != 0 ? null : str);
    }
}
