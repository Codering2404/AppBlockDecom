package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.Border$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.FitMode;
import com.revenuecat.purchases.paywalls.components.properties.FitModeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.MaskShape;
import com.revenuecat.purchases.paywalls.components.properties.MaskShapeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shadow$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls$$serializer;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public final class ImageComponent implements PaywallComponent {
    private final Border border;
    private final ColorScheme colorOverlay;
    private final FitMode fitMode;
    private final Padding margin;
    private final MaskShape maskShape;
    private final String overrideSourceLid;
    private final List<ComponentOverride<PartialImageComponent>> overrides;
    private final Padding padding;
    private final Shadow shadow;
    private final Size size;
    private final ThemeImageUrls source;
    private final Boolean visible;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, null, new ArrayListSerializer(ComponentOverride.Companion.serializer(PartialImageComponent$$serializer.INSTANCE))};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<ImageComponent> serializer() {
            return ImageComponent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @Deprecated
    public /* synthetic */ ImageComponent(int i3, ThemeImageUrls themeImageUrls, Boolean bool, Size size, @SerialName String str, @SerialName MaskShape maskShape, @SerialName ColorScheme colorScheme, @SerialName FitMode fitMode, Padding padding, Padding padding2, Border border, Shadow shadow, List list, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, themeImageUrls, bool, size, str, maskShape, colorScheme, fitMode, padding, padding2, border, shadow, (List<ComponentOverride<PartialImageComponent>>) list, serializationConstructorMarker);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(ImageComponent imageComponent, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.C(serialDescriptor, 0, ThemeImageUrls$$serializer.INSTANCE, imageComponent.source);
        if (compositeEncoder.z(serialDescriptor, 1) || imageComponent.visible != null) {
            compositeEncoder.i(serialDescriptor, 1, BooleanSerializer.f142767a, imageComponent.visible);
        }
        if (compositeEncoder.z(serialDescriptor, 2) || !Intrinsics.areEqual(imageComponent.size, new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE))) {
            compositeEncoder.C(serialDescriptor, 2, Size$$serializer.INSTANCE, imageComponent.size);
        }
        if (compositeEncoder.z(serialDescriptor, 3) || imageComponent.overrideSourceLid != null) {
            LocalizationKey$$serializer localizationKey$$serializer = LocalizationKey$$serializer.INSTANCE;
            String str = imageComponent.overrideSourceLid;
            compositeEncoder.i(serialDescriptor, 3, localizationKey$$serializer, str != null ? LocalizationKey.m648boximpl(str) : null);
        }
        if (compositeEncoder.z(serialDescriptor, 4) || imageComponent.maskShape != null) {
            compositeEncoder.i(serialDescriptor, 4, MaskShapeDeserializer.INSTANCE, imageComponent.maskShape);
        }
        if (compositeEncoder.z(serialDescriptor, 5) || imageComponent.colorOverlay != null) {
            compositeEncoder.i(serialDescriptor, 5, ColorScheme$$serializer.INSTANCE, imageComponent.colorOverlay);
        }
        if (compositeEncoder.z(serialDescriptor, 6) || imageComponent.fitMode != FitMode.FIT) {
            compositeEncoder.C(serialDescriptor, 6, FitModeDeserializer.INSTANCE, imageComponent.fitMode);
        }
        if (compositeEncoder.z(serialDescriptor, 7) || !Intrinsics.areEqual(imageComponent.padding, Padding.Companion.getZero())) {
            compositeEncoder.C(serialDescriptor, 7, Padding$$serializer.INSTANCE, imageComponent.padding);
        }
        if (compositeEncoder.z(serialDescriptor, 8) || !Intrinsics.areEqual(imageComponent.margin, Padding.Companion.getZero())) {
            compositeEncoder.C(serialDescriptor, 8, Padding$$serializer.INSTANCE, imageComponent.margin);
        }
        if (compositeEncoder.z(serialDescriptor, 9) || imageComponent.border != null) {
            compositeEncoder.i(serialDescriptor, 9, Border$$serializer.INSTANCE, imageComponent.border);
        }
        if (compositeEncoder.z(serialDescriptor, 10) || imageComponent.shadow != null) {
            compositeEncoder.i(serialDescriptor, 10, Shadow$$serializer.INSTANCE, imageComponent.shadow);
        }
        if (!compositeEncoder.z(serialDescriptor, 11) && Intrinsics.areEqual(imageComponent.overrides, CollectionsKt.emptyList())) {
            return;
        }
        compositeEncoder.C(serialDescriptor, 11, kSerializerArr[11], imageComponent.overrides);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L4
            return r0
        L4:
            boolean r1 = r5 instanceof com.revenuecat.purchases.paywalls.components.ImageComponent
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            com.revenuecat.purchases.paywalls.components.ImageComponent r5 = (com.revenuecat.purchases.paywalls.components.ImageComponent) r5
            com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls r1 = r4.source
            com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls r3 = r5.source
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 != 0) goto L17
            return r2
        L17:
            java.lang.Boolean r1 = r4.visible
            java.lang.Boolean r3 = r5.visible
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 != 0) goto L22
            return r2
        L22:
            com.revenuecat.purchases.paywalls.components.properties.Size r1 = r4.size
            com.revenuecat.purchases.paywalls.components.properties.Size r3 = r5.size
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 != 0) goto L2d
            return r2
        L2d:
            java.lang.String r1 = r4.overrideSourceLid
            java.lang.String r3 = r5.overrideSourceLid
            if (r1 != 0) goto L39
            if (r3 != 0) goto L37
            r1 = r0
            goto L40
        L37:
            r1 = r2
            goto L40
        L39:
            if (r3 != 0) goto L3c
            goto L37
        L3c:
            boolean r1 = com.revenuecat.purchases.paywalls.components.common.LocalizationKey.m651equalsimpl0(r1, r3)
        L40:
            if (r1 != 0) goto L43
            return r2
        L43:
            com.revenuecat.purchases.paywalls.components.properties.MaskShape r1 = r4.maskShape
            com.revenuecat.purchases.paywalls.components.properties.MaskShape r3 = r5.maskShape
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 != 0) goto L4e
            return r2
        L4e:
            com.revenuecat.purchases.paywalls.components.properties.ColorScheme r1 = r4.colorOverlay
            com.revenuecat.purchases.paywalls.components.properties.ColorScheme r3 = r5.colorOverlay
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 != 0) goto L59
            return r2
        L59:
            com.revenuecat.purchases.paywalls.components.properties.FitMode r1 = r4.fitMode
            com.revenuecat.purchases.paywalls.components.properties.FitMode r3 = r5.fitMode
            if (r1 == r3) goto L60
            return r2
        L60:
            com.revenuecat.purchases.paywalls.components.properties.Padding r1 = r4.padding
            com.revenuecat.purchases.paywalls.components.properties.Padding r3 = r5.padding
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 != 0) goto L6b
            return r2
        L6b:
            com.revenuecat.purchases.paywalls.components.properties.Padding r1 = r4.margin
            com.revenuecat.purchases.paywalls.components.properties.Padding r3 = r5.margin
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 != 0) goto L76
            return r2
        L76:
            com.revenuecat.purchases.paywalls.components.properties.Border r1 = r4.border
            com.revenuecat.purchases.paywalls.components.properties.Border r3 = r5.border
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 != 0) goto L81
            return r2
        L81:
            com.revenuecat.purchases.paywalls.components.properties.Shadow r1 = r4.shadow
            com.revenuecat.purchases.paywalls.components.properties.Shadow r3 = r5.shadow
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 != 0) goto L8c
            return r2
        L8c:
            java.util.List<com.revenuecat.purchases.paywalls.components.common.ComponentOverride<com.revenuecat.purchases.paywalls.components.PartialImageComponent>> r1 = r4.overrides
            java.util.List<com.revenuecat.purchases.paywalls.components.common.ComponentOverride<com.revenuecat.purchases.paywalls.components.PartialImageComponent>> r5 = r5.overrides
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r5)
            if (r5 != 0) goto L97
            return r2
        L97:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.paywalls.components.ImageComponent.equals(java.lang.Object):boolean");
    }

    public final /* synthetic */ Border getBorder() {
        return this.border;
    }

    public final /* synthetic */ ColorScheme getColorOverlay() {
        return this.colorOverlay;
    }

    public final /* synthetic */ FitMode getFitMode() {
        return this.fitMode;
    }

    public final /* synthetic */ Padding getMargin() {
        return this.margin;
    }

    public final /* synthetic */ MaskShape getMaskShape() {
        return this.maskShape;
    }

    /* JADX INFO: renamed from: getOverrideSourceLid-sa7TU9Q, reason: not valid java name */
    public final /* synthetic */ String m591getOverrideSourceLidsa7TU9Q() {
        return this.overrideSourceLid;
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

    public final /* synthetic */ Size getSize() {
        return this.size;
    }

    public final /* synthetic */ ThemeImageUrls getSource() {
        return this.source;
    }

    public final /* synthetic */ Boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        int iHashCode = this.source.hashCode() * 31;
        Boolean bool = this.visible;
        int iHashCode2 = (((iHashCode + (bool == null ? 0 : bool.hashCode())) * 31) + this.size.hashCode()) * 31;
        String str = this.overrideSourceLid;
        int iM652hashCodeimpl = (iHashCode2 + (str == null ? 0 : LocalizationKey.m652hashCodeimpl(str))) * 31;
        MaskShape maskShape = this.maskShape;
        int iHashCode3 = (iM652hashCodeimpl + (maskShape == null ? 0 : maskShape.hashCode())) * 31;
        ColorScheme colorScheme = this.colorOverlay;
        int iHashCode4 = (((((((iHashCode3 + (colorScheme == null ? 0 : colorScheme.hashCode())) * 31) + this.fitMode.hashCode()) * 31) + this.padding.hashCode()) * 31) + this.margin.hashCode()) * 31;
        Border border = this.border;
        int iHashCode5 = (iHashCode4 + (border == null ? 0 : border.hashCode())) * 31;
        Shadow shadow = this.shadow;
        return ((iHashCode5 + (shadow != null ? shadow.hashCode() : 0)) * 31) + this.overrides.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImageComponent(source=");
        sb.append(this.source);
        sb.append(", visible=");
        sb.append(this.visible);
        sb.append(", size=");
        sb.append(this.size);
        sb.append(", overrideSourceLid=");
        String str = this.overrideSourceLid;
        sb.append((Object) (str == null ? "null" : LocalizationKey.m653toStringimpl(str)));
        sb.append(", maskShape=");
        sb.append(this.maskShape);
        sb.append(", colorOverlay=");
        sb.append(this.colorOverlay);
        sb.append(", fitMode=");
        sb.append(this.fitMode);
        sb.append(", padding=");
        sb.append(this.padding);
        sb.append(", margin=");
        sb.append(this.margin);
        sb.append(", border=");
        sb.append(this.border);
        sb.append(", shadow=");
        sb.append(this.shadow);
        sb.append(", overrides=");
        sb.append(this.overrides);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ ImageComponent(ThemeImageUrls themeImageUrls, Boolean bool, Size size, String str, MaskShape maskShape, ColorScheme colorScheme, FitMode fitMode, Padding padding, Padding padding2, Border border, Shadow shadow, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(themeImageUrls, bool, size, str, maskShape, colorScheme, fitMode, padding, padding2, border, shadow, list);
    }

    private ImageComponent(int i3, ThemeImageUrls themeImageUrls, Boolean bool, Size size, String str, MaskShape maskShape, ColorScheme colorScheme, FitMode fitMode, Padding padding, Padding padding2, Border border, Shadow shadow, List<ComponentOverride<PartialImageComponent>> list, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i3 & 1)) {
            PluginExceptionsKt.b(i3, 1, ImageComponent$$serializer.INSTANCE.getDescriptor());
        }
        this.source = themeImageUrls;
        if ((i3 & 2) == 0) {
            this.visible = null;
        } else {
            this.visible = bool;
        }
        if ((i3 & 4) == 0) {
            this.size = new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE);
        } else {
            this.size = size;
        }
        if ((i3 & 8) == 0) {
            this.overrideSourceLid = null;
        } else {
            this.overrideSourceLid = str;
        }
        if ((i3 & 16) == 0) {
            this.maskShape = null;
        } else {
            this.maskShape = maskShape;
        }
        if ((i3 & 32) == 0) {
            this.colorOverlay = null;
        } else {
            this.colorOverlay = colorScheme;
        }
        if ((i3 & 64) == 0) {
            this.fitMode = FitMode.FIT;
        } else {
            this.fitMode = fitMode;
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
            this.overrides = CollectionsKt.emptyList();
        } else {
            this.overrides = list;
        }
    }

    private ImageComponent(ThemeImageUrls source, Boolean bool, Size size, String str, MaskShape maskShape, ColorScheme colorScheme, FitMode fitMode, Padding padding, Padding margin, Border border, Shadow shadow, List<ComponentOverride<PartialImageComponent>> overrides) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(fitMode, "fitMode");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        this.source = source;
        this.visible = bool;
        this.size = size;
        this.overrideSourceLid = str;
        this.maskShape = maskShape;
        this.colorOverlay = colorScheme;
        this.fitMode = fitMode;
        this.padding = padding;
        this.margin = margin;
        this.border = border;
        this.shadow = shadow;
        this.overrides = overrides;
    }

    @SerialName
    public static /* synthetic */ void getColorOverlay$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getFitMode$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getMaskShape$annotations() {
    }

    @SerialName
    /* JADX INFO: renamed from: getOverrideSourceLid-sa7TU9Q$annotations, reason: not valid java name */
    public static /* synthetic */ void m590getOverrideSourceLidsa7TU9Q$annotations() {
    }

    public /* synthetic */ ImageComponent(ThemeImageUrls themeImageUrls, Boolean bool, Size size, String str, MaskShape maskShape, ColorScheme colorScheme, FitMode fitMode, Padding padding, Padding padding2, Border border, Shadow shadow, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(themeImageUrls, (i3 & 2) != 0 ? null : bool, (i3 & 4) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE) : size, (i3 & 8) != 0 ? null : str, (i3 & 16) != 0 ? null : maskShape, (i3 & 32) != 0 ? null : colorScheme, (i3 & 64) != 0 ? FitMode.FIT : fitMode, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? Padding.Companion.getZero() : padding, (i3 & Function.MAX_NARGS) != 0 ? Padding.Companion.getZero() : padding2, (i3 & 512) != 0 ? null : border, (i3 & 1024) != 0 ? null : shadow, (i3 & 2048) != 0 ? CollectionsKt.emptyList() : list, null);
    }
}
