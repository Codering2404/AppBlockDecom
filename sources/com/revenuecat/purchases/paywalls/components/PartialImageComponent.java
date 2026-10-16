package com.revenuecat.purchases.paywalls.components;

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
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls$$serializer;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
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
public final class PartialImageComponent implements PartialComponent {
    public static final Companion Companion = new Companion(null);
    private final Border border;
    private final ColorScheme colorOverlay;
    private final FitMode fitMode;
    private final Padding margin;
    private final MaskShape maskShape;
    private final String overrideSourceLid;
    private final Padding padding;
    private final Shadow shadow;
    private final Size size;
    private final ThemeImageUrls source;
    private final Boolean visible;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<PartialImageComponent> serializer() {
            return PartialImageComponent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @Deprecated
    public /* synthetic */ PartialImageComponent(int i3, Boolean bool, ThemeImageUrls themeImageUrls, Size size, @SerialName String str, @SerialName FitMode fitMode, @SerialName MaskShape maskShape, @SerialName ColorScheme colorScheme, Padding padding, Padding padding2, Border border, Shadow shadow, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, bool, themeImageUrls, size, str, fitMode, maskShape, colorScheme, padding, padding2, border, shadow, serializationConstructorMarker);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PartialImageComponent partialImageComponent, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        if (compositeEncoder.z(serialDescriptor, 0) || !Intrinsics.areEqual(partialImageComponent.visible, Boolean.TRUE)) {
            compositeEncoder.i(serialDescriptor, 0, BooleanSerializer.f142767a, partialImageComponent.visible);
        }
        if (compositeEncoder.z(serialDescriptor, 1) || partialImageComponent.source != null) {
            compositeEncoder.i(serialDescriptor, 1, ThemeImageUrls$$serializer.INSTANCE, partialImageComponent.source);
        }
        if (compositeEncoder.z(serialDescriptor, 2) || partialImageComponent.size != null) {
            compositeEncoder.i(serialDescriptor, 2, Size$$serializer.INSTANCE, partialImageComponent.size);
        }
        if (compositeEncoder.z(serialDescriptor, 3) || partialImageComponent.overrideSourceLid != null) {
            LocalizationKey$$serializer localizationKey$$serializer = LocalizationKey$$serializer.INSTANCE;
            String str = partialImageComponent.overrideSourceLid;
            compositeEncoder.i(serialDescriptor, 3, localizationKey$$serializer, str != null ? LocalizationKey.m648boximpl(str) : null);
        }
        if (compositeEncoder.z(serialDescriptor, 4) || partialImageComponent.fitMode != null) {
            compositeEncoder.i(serialDescriptor, 4, FitModeDeserializer.INSTANCE, partialImageComponent.fitMode);
        }
        if (compositeEncoder.z(serialDescriptor, 5) || partialImageComponent.maskShape != null) {
            compositeEncoder.i(serialDescriptor, 5, MaskShapeDeserializer.INSTANCE, partialImageComponent.maskShape);
        }
        if (compositeEncoder.z(serialDescriptor, 6) || partialImageComponent.colorOverlay != null) {
            compositeEncoder.i(serialDescriptor, 6, ColorScheme$$serializer.INSTANCE, partialImageComponent.colorOverlay);
        }
        if (compositeEncoder.z(serialDescriptor, 7) || partialImageComponent.padding != null) {
            compositeEncoder.i(serialDescriptor, 7, Padding$$serializer.INSTANCE, partialImageComponent.padding);
        }
        if (compositeEncoder.z(serialDescriptor, 8) || partialImageComponent.margin != null) {
            compositeEncoder.i(serialDescriptor, 8, Padding$$serializer.INSTANCE, partialImageComponent.margin);
        }
        if (compositeEncoder.z(serialDescriptor, 9) || partialImageComponent.border != null) {
            compositeEncoder.i(serialDescriptor, 9, Border$$serializer.INSTANCE, partialImageComponent.border);
        }
        if (!compositeEncoder.z(serialDescriptor, 10) && partialImageComponent.shadow == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 10, Shadow$$serializer.INSTANCE, partialImageComponent.shadow);
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
            boolean r1 = r5 instanceof com.revenuecat.purchases.paywalls.components.PartialImageComponent
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            com.revenuecat.purchases.paywalls.components.PartialImageComponent r5 = (com.revenuecat.purchases.paywalls.components.PartialImageComponent) r5
            java.lang.Boolean r1 = r4.visible
            java.lang.Boolean r3 = r5.visible
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 != 0) goto L17
            return r2
        L17:
            com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls r1 = r4.source
            com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls r3 = r5.source
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
            com.revenuecat.purchases.paywalls.components.properties.FitMode r1 = r4.fitMode
            com.revenuecat.purchases.paywalls.components.properties.FitMode r3 = r5.fitMode
            if (r1 == r3) goto L4a
            return r2
        L4a:
            com.revenuecat.purchases.paywalls.components.properties.MaskShape r1 = r4.maskShape
            com.revenuecat.purchases.paywalls.components.properties.MaskShape r3 = r5.maskShape
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 != 0) goto L55
            return r2
        L55:
            com.revenuecat.purchases.paywalls.components.properties.ColorScheme r1 = r4.colorOverlay
            com.revenuecat.purchases.paywalls.components.properties.ColorScheme r3 = r5.colorOverlay
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 != 0) goto L60
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
            com.revenuecat.purchases.paywalls.components.properties.Shadow r5 = r5.shadow
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r5)
            if (r5 != 0) goto L8c
            return r2
        L8c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.paywalls.components.PartialImageComponent.equals(java.lang.Object):boolean");
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
    public final /* synthetic */ String m593getOverrideSourceLidsa7TU9Q() {
        return this.overrideSourceLid;
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
        Boolean bool = this.visible;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        ThemeImageUrls themeImageUrls = this.source;
        int iHashCode2 = (iHashCode + (themeImageUrls == null ? 0 : themeImageUrls.hashCode())) * 31;
        Size size = this.size;
        int iHashCode3 = (iHashCode2 + (size == null ? 0 : size.hashCode())) * 31;
        String str = this.overrideSourceLid;
        int iM652hashCodeimpl = (iHashCode3 + (str == null ? 0 : LocalizationKey.m652hashCodeimpl(str))) * 31;
        FitMode fitMode = this.fitMode;
        int iHashCode4 = (iM652hashCodeimpl + (fitMode == null ? 0 : fitMode.hashCode())) * 31;
        MaskShape maskShape = this.maskShape;
        int iHashCode5 = (iHashCode4 + (maskShape == null ? 0 : maskShape.hashCode())) * 31;
        ColorScheme colorScheme = this.colorOverlay;
        int iHashCode6 = (iHashCode5 + (colorScheme == null ? 0 : colorScheme.hashCode())) * 31;
        Padding padding = this.padding;
        int iHashCode7 = (iHashCode6 + (padding == null ? 0 : padding.hashCode())) * 31;
        Padding padding2 = this.margin;
        int iHashCode8 = (iHashCode7 + (padding2 == null ? 0 : padding2.hashCode())) * 31;
        Border border = this.border;
        int iHashCode9 = (iHashCode8 + (border == null ? 0 : border.hashCode())) * 31;
        Shadow shadow = this.shadow;
        return iHashCode9 + (shadow != null ? shadow.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PartialImageComponent(visible=");
        sb.append(this.visible);
        sb.append(", source=");
        sb.append(this.source);
        sb.append(", size=");
        sb.append(this.size);
        sb.append(", overrideSourceLid=");
        String str = this.overrideSourceLid;
        sb.append((Object) (str == null ? "null" : LocalizationKey.m653toStringimpl(str)));
        sb.append(", fitMode=");
        sb.append(this.fitMode);
        sb.append(", maskShape=");
        sb.append(this.maskShape);
        sb.append(", colorOverlay=");
        sb.append(this.colorOverlay);
        sb.append(", padding=");
        sb.append(this.padding);
        sb.append(", margin=");
        sb.append(this.margin);
        sb.append(", border=");
        sb.append(this.border);
        sb.append(", shadow=");
        sb.append(this.shadow);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ PartialImageComponent(Boolean bool, ThemeImageUrls themeImageUrls, Size size, String str, FitMode fitMode, MaskShape maskShape, ColorScheme colorScheme, Padding padding, Padding padding2, Border border, Shadow shadow, DefaultConstructorMarker defaultConstructorMarker) {
        this(bool, themeImageUrls, size, str, fitMode, maskShape, colorScheme, padding, padding2, border, shadow);
    }

    private PartialImageComponent(int i3, Boolean bool, ThemeImageUrls themeImageUrls, Size size, String str, FitMode fitMode, MaskShape maskShape, ColorScheme colorScheme, Padding padding, Padding padding2, Border border, Shadow shadow, SerializationConstructorMarker serializationConstructorMarker) {
        this.visible = (i3 & 1) == 0 ? Boolean.TRUE : bool;
        if ((i3 & 2) == 0) {
            this.source = null;
        } else {
            this.source = themeImageUrls;
        }
        if ((i3 & 4) == 0) {
            this.size = null;
        } else {
            this.size = size;
        }
        if ((i3 & 8) == 0) {
            this.overrideSourceLid = null;
        } else {
            this.overrideSourceLid = str;
        }
        if ((i3 & 16) == 0) {
            this.fitMode = null;
        } else {
            this.fitMode = fitMode;
        }
        if ((i3 & 32) == 0) {
            this.maskShape = null;
        } else {
            this.maskShape = maskShape;
        }
        if ((i3 & 64) == 0) {
            this.colorOverlay = null;
        } else {
            this.colorOverlay = colorScheme;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
            this.padding = null;
        } else {
            this.padding = padding;
        }
        if ((i3 & Function.MAX_NARGS) == 0) {
            this.margin = null;
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
    }

    private PartialImageComponent(Boolean bool, ThemeImageUrls themeImageUrls, Size size, String str, FitMode fitMode, MaskShape maskShape, ColorScheme colorScheme, Padding padding, Padding padding2, Border border, Shadow shadow) {
        this.visible = bool;
        this.source = themeImageUrls;
        this.size = size;
        this.overrideSourceLid = str;
        this.fitMode = fitMode;
        this.maskShape = maskShape;
        this.colorOverlay = colorScheme;
        this.padding = padding;
        this.margin = padding2;
        this.border = border;
        this.shadow = shadow;
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
    public static /* synthetic */ void m592getOverrideSourceLidsa7TU9Q$annotations() {
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ PartialImageComponent(Boolean bool, ThemeImageUrls themeImageUrls, Size size, String str, FitMode fitMode, MaskShape maskShape, ColorScheme colorScheme, Padding padding, Padding padding2, Border border, Shadow shadow, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        Boolean bool2 = (i3 & 1) != 0 ? Boolean.TRUE : bool;
        ThemeImageUrls themeImageUrls2 = (i3 & 2) != 0 ? null : themeImageUrls;
        Size size2 = (i3 & 4) != 0 ? null : size;
        String str2 = (i3 & 8) != 0 ? null : str;
        FitMode fitMode2 = (i3 & 16) != 0 ? null : fitMode;
        MaskShape maskShape2 = (i3 & 32) != 0 ? null : maskShape;
        ColorScheme colorScheme2 = (i3 & 64) != 0 ? null : colorScheme;
        Padding padding3 = (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : padding;
        Padding padding4 = (i3 & Function.MAX_NARGS) != 0 ? null : padding2;
        Border border2 = (i3 & 512) != 0 ? null : border;
        this(bool2, themeImageUrls2, size2, str2, fitMode2, maskShape2, colorScheme2, padding3, padding4, border2, (i3 & 1024) == 0 ? shadow : null, null);
    }
}
