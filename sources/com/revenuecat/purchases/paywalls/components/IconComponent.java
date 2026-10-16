package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.Border$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.MaskShape;
import com.revenuecat.purchases.paywalls.components.properties.MaskShapeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shadow$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.xn.YvFRmou;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
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
@SerialName
@Metadata
@Serializable
public final class IconComponent implements PaywallComponent {
    private final String baseUrl;
    private final ColorScheme color;
    private final Formats formats;
    private final IconBackground iconBackground;
    private final String iconName;
    private final Padding margin;
    private final List<ComponentOverride<PartialIconComponent>> overrides;
    private final Padding padding;
    private final Size size;
    private final Boolean visible;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, null, null, null, new ArrayListSerializer(ComponentOverride.Companion.serializer(PartialIconComponent$$serializer.INSTANCE))};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<IconComponent> serializer() {
            return IconComponent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class Formats {
        public static final Companion Companion = new Companion(null);
        private final String webp;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Formats> serializer() {
                return IconComponent$Formats$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        @Deprecated
        public /* synthetic */ Formats(int i3, String str, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, IconComponent$Formats$$serializer.INSTANCE.getDescriptor());
            }
            this.webp = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Formats) && Intrinsics.areEqual(this.webp, ((Formats) obj).webp);
        }

        public final /* synthetic */ String getWebp() {
            return this.webp;
        }

        public int hashCode() {
            return this.webp.hashCode();
        }

        public String toString() {
            return "Formats(webp=" + this.webp + ')';
        }

        public Formats(String webp) {
            Intrinsics.checkNotNullParameter(webp, "webp");
            this.webp = webp;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class IconBackground {
        public static final Companion Companion = new Companion(null);
        private final Border border;
        private final ColorScheme color;
        private final Shadow shadow;
        private final MaskShape shape;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<IconBackground> serializer() {
                return IconComponent$IconBackground$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        @Deprecated
        public /* synthetic */ IconBackground(int i3, ColorScheme colorScheme, MaskShape maskShape, Border border, Shadow shadow, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i3 & 3)) {
                PluginExceptionsKt.b(i3, 3, IconComponent$IconBackground$$serializer.INSTANCE.getDescriptor());
            }
            this.color = colorScheme;
            this.shape = maskShape;
            if ((i3 & 4) == 0) {
                this.border = null;
            } else {
                this.border = border;
            }
            if ((i3 & 8) == 0) {
                this.shadow = null;
            } else {
                this.shadow = shadow;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(IconBackground iconBackground, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            compositeEncoder.C(serialDescriptor, 0, ColorScheme$$serializer.INSTANCE, iconBackground.color);
            compositeEncoder.C(serialDescriptor, 1, MaskShapeDeserializer.INSTANCE, iconBackground.shape);
            if (compositeEncoder.z(serialDescriptor, 2) || iconBackground.border != null) {
                compositeEncoder.i(serialDescriptor, 2, Border$$serializer.INSTANCE, iconBackground.border);
            }
            if (!compositeEncoder.z(serialDescriptor, 3) && iconBackground.shadow == null) {
                return;
            }
            compositeEncoder.i(serialDescriptor, 3, Shadow$$serializer.INSTANCE, iconBackground.shadow);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IconBackground)) {
                return false;
            }
            IconBackground iconBackground = (IconBackground) obj;
            return Intrinsics.areEqual(this.color, iconBackground.color) && Intrinsics.areEqual(this.shape, iconBackground.shape) && Intrinsics.areEqual(this.border, iconBackground.border) && Intrinsics.areEqual(this.shadow, iconBackground.shadow);
        }

        public final /* synthetic */ Border getBorder() {
            return this.border;
        }

        public final /* synthetic */ ColorScheme getColor() {
            return this.color;
        }

        public final /* synthetic */ Shadow getShadow() {
            return this.shadow;
        }

        public final /* synthetic */ MaskShape getShape() {
            return this.shape;
        }

        public int hashCode() {
            int iHashCode = ((this.color.hashCode() * 31) + this.shape.hashCode()) * 31;
            Border border = this.border;
            int iHashCode2 = (iHashCode + (border == null ? 0 : border.hashCode())) * 31;
            Shadow shadow = this.shadow;
            return iHashCode2 + (shadow != null ? shadow.hashCode() : 0);
        }

        public String toString() {
            return "IconBackground(color=" + this.color + ", shape=" + this.shape + ", border=" + this.border + ", shadow=" + this.shadow + ')';
        }

        public IconBackground(ColorScheme color, MaskShape shape, Border border, Shadow shadow) {
            Intrinsics.checkNotNullParameter(color, "color");
            Intrinsics.checkNotNullParameter(shape, "shape");
            this.color = color;
            this.shape = shape;
            this.border = border;
            this.shadow = shadow;
        }

        public /* synthetic */ IconBackground(ColorScheme colorScheme, MaskShape maskShape, Border border, Shadow shadow, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(colorScheme, maskShape, (i3 & 4) != 0 ? null : border, (i3 & 8) != 0 ? null : shadow);
        }
    }

    @Deprecated
    public /* synthetic */ IconComponent(int i3, @SerialName String str, @SerialName String str2, Formats formats, Boolean bool, Size size, ColorScheme colorScheme, Padding padding, Padding padding2, @SerialName IconBackground iconBackground, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i3 & 7)) {
            PluginExceptionsKt.b(i3, 7, IconComponent$$serializer.INSTANCE.getDescriptor());
        }
        this.baseUrl = str;
        this.iconName = str2;
        this.formats = formats;
        if ((i3 & 8) == 0) {
            this.visible = null;
        } else {
            this.visible = bool;
        }
        if ((i3 & 16) == 0) {
            this.size = new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE);
        } else {
            this.size = size;
        }
        if ((i3 & 32) == 0) {
            this.color = null;
        } else {
            this.color = colorScheme;
        }
        if ((i3 & 64) == 0) {
            this.padding = Padding.Companion.getZero();
        } else {
            this.padding = padding;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
            this.margin = Padding.Companion.getZero();
        } else {
            this.margin = padding2;
        }
        if ((i3 & Function.MAX_NARGS) == 0) {
            this.iconBackground = null;
        } else {
            this.iconBackground = iconBackground;
        }
        if ((i3 & 512) == 0) {
            this.overrides = CollectionsKt.emptyList();
        } else {
            this.overrides = list;
        }
    }

    @SerialName
    public static /* synthetic */ void getBaseUrl$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getIconBackground$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getIconName$annotations() {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(IconComponent iconComponent, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.y(serialDescriptor, 0, iconComponent.baseUrl);
        compositeEncoder.y(serialDescriptor, 1, iconComponent.iconName);
        compositeEncoder.C(serialDescriptor, 2, IconComponent$Formats$$serializer.INSTANCE, iconComponent.formats);
        if (compositeEncoder.z(serialDescriptor, 3) || iconComponent.visible != null) {
            compositeEncoder.i(serialDescriptor, 3, BooleanSerializer.f142767a, iconComponent.visible);
        }
        if (compositeEncoder.z(serialDescriptor, 4) || !Intrinsics.areEqual(iconComponent.size, new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE))) {
            compositeEncoder.C(serialDescriptor, 4, Size$$serializer.INSTANCE, iconComponent.size);
        }
        if (compositeEncoder.z(serialDescriptor, 5) || iconComponent.color != null) {
            compositeEncoder.i(serialDescriptor, 5, ColorScheme$$serializer.INSTANCE, iconComponent.color);
        }
        if (compositeEncoder.z(serialDescriptor, 6) || !Intrinsics.areEqual(iconComponent.padding, Padding.Companion.getZero())) {
            compositeEncoder.C(serialDescriptor, 6, Padding$$serializer.INSTANCE, iconComponent.padding);
        }
        if (compositeEncoder.z(serialDescriptor, 7) || !Intrinsics.areEqual(iconComponent.margin, Padding.Companion.getZero())) {
            compositeEncoder.C(serialDescriptor, 7, Padding$$serializer.INSTANCE, iconComponent.margin);
        }
        if (compositeEncoder.z(serialDescriptor, 8) || iconComponent.iconBackground != null) {
            compositeEncoder.i(serialDescriptor, 8, IconComponent$IconBackground$$serializer.INSTANCE, iconComponent.iconBackground);
        }
        if (!compositeEncoder.z(serialDescriptor, 9) && Intrinsics.areEqual(iconComponent.overrides, CollectionsKt.emptyList())) {
            return;
        }
        compositeEncoder.C(serialDescriptor, 9, kSerializerArr[9], iconComponent.overrides);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IconComponent)) {
            return false;
        }
        IconComponent iconComponent = (IconComponent) obj;
        return Intrinsics.areEqual(this.baseUrl, iconComponent.baseUrl) && Intrinsics.areEqual(this.iconName, iconComponent.iconName) && Intrinsics.areEqual(this.formats, iconComponent.formats) && Intrinsics.areEqual(this.visible, iconComponent.visible) && Intrinsics.areEqual(this.size, iconComponent.size) && Intrinsics.areEqual(this.color, iconComponent.color) && Intrinsics.areEqual(this.padding, iconComponent.padding) && Intrinsics.areEqual(this.margin, iconComponent.margin) && Intrinsics.areEqual(this.iconBackground, iconComponent.iconBackground) && Intrinsics.areEqual(this.overrides, iconComponent.overrides);
    }

    public final /* synthetic */ String getBaseUrl() {
        return this.baseUrl;
    }

    public final /* synthetic */ ColorScheme getColor() {
        return this.color;
    }

    public final /* synthetic */ Formats getFormats() {
        return this.formats;
    }

    public final /* synthetic */ IconBackground getIconBackground() {
        return this.iconBackground;
    }

    public final /* synthetic */ String getIconName() {
        return this.iconName;
    }

    public final /* synthetic */ Padding getMargin() {
        return this.margin;
    }

    public final /* synthetic */ List getOverrides() {
        return this.overrides;
    }

    public final /* synthetic */ Padding getPadding() {
        return this.padding;
    }

    public final /* synthetic */ Size getSize() {
        return this.size;
    }

    public final /* synthetic */ Boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        int iHashCode = ((((this.baseUrl.hashCode() * 31) + this.iconName.hashCode()) * 31) + this.formats.hashCode()) * 31;
        Boolean bool = this.visible;
        int iHashCode2 = (((iHashCode + (bool == null ? 0 : bool.hashCode())) * 31) + this.size.hashCode()) * 31;
        ColorScheme colorScheme = this.color;
        int iHashCode3 = (((((iHashCode2 + (colorScheme == null ? 0 : colorScheme.hashCode())) * 31) + this.padding.hashCode()) * 31) + this.margin.hashCode()) * 31;
        IconBackground iconBackground = this.iconBackground;
        return ((iHashCode3 + (iconBackground != null ? iconBackground.hashCode() : 0)) * 31) + this.overrides.hashCode();
    }

    public String toString() {
        return "IconComponent(baseUrl=" + this.baseUrl + ", iconName=" + this.iconName + ", formats=" + this.formats + ", visible=" + this.visible + ", size=" + this.size + ", color=" + this.color + ", padding=" + this.padding + ", margin=" + this.margin + ", iconBackground=" + this.iconBackground + ", overrides=" + this.overrides + ')';
    }

    public IconComponent(String baseUrl, String iconName, Formats formats, Boolean bool, Size size, ColorScheme colorScheme, Padding padding, Padding padding2, IconBackground iconBackground, List<ComponentOverride<PartialIconComponent>> overrides) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(iconName, "iconName");
        Intrinsics.checkNotNullParameter(formats, "formats");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(padding2, YvFRmou.GjSDjiqBpL);
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        this.baseUrl = baseUrl;
        this.iconName = iconName;
        this.formats = formats;
        this.visible = bool;
        this.size = size;
        this.color = colorScheme;
        this.padding = padding;
        this.margin = padding2;
        this.iconBackground = iconBackground;
        this.overrides = overrides;
    }

    public /* synthetic */ IconComponent(String str, String str2, Formats formats, Boolean bool, Size size, ColorScheme colorScheme, Padding padding, Padding padding2, IconBackground iconBackground, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, formats, (i3 & 8) != 0 ? null : bool, (i3 & 16) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE) : size, (i3 & 32) != 0 ? null : colorScheme, (i3 & 64) != 0 ? Padding.Companion.getZero() : padding, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? Padding.Companion.getZero() : padding2, (i3 & Function.MAX_NARGS) != 0 ? null : iconBackground, (i3 & 512) != 0 ? CollectionsKt.emptyList() : list);
    }
}
