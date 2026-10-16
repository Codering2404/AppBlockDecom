package com.revenuecat.purchases.paywalls.components;

import com.facebook.internal.Utility;
import com.revenuecat.purchases.FontAlias;
import com.revenuecat.purchases.FontAlias$$serializer;
import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.FontWeight;
import com.revenuecat.purchases.paywalls.components.properties.FontWeightDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignmentDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
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
import kotlinx.serialization.internal.IntSerializer;
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
public final class TextComponent implements PaywallComponent {
    private final ColorScheme backgroundColor;
    private final ColorScheme color;
    private final String fontName;
    private final int fontSize;
    private final FontWeight fontWeight;
    private final Integer fontWeightInt;
    private final HorizontalAlignment horizontalAlignment;
    private final Padding margin;
    private final String name;
    private final List<ComponentOverride<PartialTextComponent>> overrides;
    private final Padding padding;
    private final Size size;
    private final String text;
    private final Boolean visible;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, null, null, new ArrayListSerializer(ComponentOverride.Companion.serializer(PartialTextComponent$$serializer.INSTANCE)), null};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<TextComponent> serializer() {
            return TextComponent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @Deprecated
    public /* synthetic */ TextComponent(int i3, @SerialName String str, ColorScheme colorScheme, Boolean bool, @SerialName ColorScheme colorScheme2, @SerialName String str2, @SerialName FontWeight fontWeight, @SerialName Integer num, @SerialName @Serializable(with = FontSizeSerializer.class) int i4, @SerialName HorizontalAlignment horizontalAlignment, Size size, Padding padding, Padding padding2, List list, String str3, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, colorScheme, bool, colorScheme2, str2, fontWeight, num, i4, horizontalAlignment, size, padding, padding2, (List<ComponentOverride<PartialTextComponent>>) list, str3, serializationConstructorMarker);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(TextComponent textComponent, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.C(serialDescriptor, 0, LocalizationKey$$serializer.INSTANCE, LocalizationKey.m648boximpl(textComponent.text));
        ColorScheme$$serializer colorScheme$$serializer = ColorScheme$$serializer.INSTANCE;
        compositeEncoder.C(serialDescriptor, 1, colorScheme$$serializer, textComponent.color);
        if (compositeEncoder.z(serialDescriptor, 2) || textComponent.visible != null) {
            compositeEncoder.i(serialDescriptor, 2, BooleanSerializer.f142767a, textComponent.visible);
        }
        if (compositeEncoder.z(serialDescriptor, 3) || textComponent.backgroundColor != null) {
            compositeEncoder.i(serialDescriptor, 3, colorScheme$$serializer, textComponent.backgroundColor);
        }
        if (compositeEncoder.z(serialDescriptor, 4) || textComponent.fontName != null) {
            FontAlias$$serializer fontAlias$$serializer = FontAlias$$serializer.INSTANCE;
            String str = textComponent.fontName;
            compositeEncoder.i(serialDescriptor, 4, fontAlias$$serializer, str != null ? FontAlias.m433boximpl(str) : null);
        }
        if (compositeEncoder.z(serialDescriptor, 5) || textComponent.fontWeight != FontWeight.REGULAR) {
            compositeEncoder.C(serialDescriptor, 5, FontWeightDeserializer.INSTANCE, textComponent.fontWeight);
        }
        if (compositeEncoder.z(serialDescriptor, 6) || textComponent.fontWeightInt != null) {
            compositeEncoder.i(serialDescriptor, 6, IntSerializer.f142823a, textComponent.fontWeightInt);
        }
        if (compositeEncoder.z(serialDescriptor, 7) || textComponent.fontSize != 15) {
            compositeEncoder.C(serialDescriptor, 7, FontSizeSerializer.INSTANCE, Integer.valueOf(textComponent.fontSize));
        }
        if (compositeEncoder.z(serialDescriptor, 8) || textComponent.horizontalAlignment != HorizontalAlignment.CENTER) {
            compositeEncoder.C(serialDescriptor, 8, HorizontalAlignmentDeserializer.INSTANCE, textComponent.horizontalAlignment);
        }
        if (compositeEncoder.z(serialDescriptor, 9) || !Intrinsics.areEqual(textComponent.size, new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE))) {
            compositeEncoder.C(serialDescriptor, 9, Size$$serializer.INSTANCE, textComponent.size);
        }
        if (compositeEncoder.z(serialDescriptor, 10) || !Intrinsics.areEqual(textComponent.padding, Padding.Companion.getZero())) {
            compositeEncoder.C(serialDescriptor, 10, Padding$$serializer.INSTANCE, textComponent.padding);
        }
        if (compositeEncoder.z(serialDescriptor, 11) || !Intrinsics.areEqual(textComponent.margin, Padding.Companion.getZero())) {
            compositeEncoder.C(serialDescriptor, 11, Padding$$serializer.INSTANCE, textComponent.margin);
        }
        if (compositeEncoder.z(serialDescriptor, 12) || !Intrinsics.areEqual(textComponent.overrides, CollectionsKt.emptyList())) {
            compositeEncoder.C(serialDescriptor, 12, kSerializerArr[12], textComponent.overrides);
        }
        if (!compositeEncoder.z(serialDescriptor, 13) && textComponent.name == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 13, StringSerializer.f142891a, textComponent.name);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0042  */
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
            boolean r1 = r5 instanceof com.revenuecat.purchases.paywalls.components.TextComponent
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            com.revenuecat.purchases.paywalls.components.TextComponent r5 = (com.revenuecat.purchases.paywalls.components.TextComponent) r5
            java.lang.String r1 = r4.text
            java.lang.String r3 = r5.text
            boolean r1 = com.revenuecat.purchases.paywalls.components.common.LocalizationKey.m651equalsimpl0(r1, r3)
            if (r1 != 0) goto L17
            return r2
        L17:
            com.revenuecat.purchases.paywalls.components.properties.ColorScheme r1 = r4.color
            com.revenuecat.purchases.paywalls.components.properties.ColorScheme r3 = r5.color
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 != 0) goto L22
            return r2
        L22:
            java.lang.Boolean r1 = r4.visible
            java.lang.Boolean r3 = r5.visible
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 != 0) goto L2d
            return r2
        L2d:
            com.revenuecat.purchases.paywalls.components.properties.ColorScheme r1 = r4.backgroundColor
            com.revenuecat.purchases.paywalls.components.properties.ColorScheme r3 = r5.backgroundColor
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 != 0) goto L38
            return r2
        L38:
            java.lang.String r1 = r4.fontName
            java.lang.String r3 = r5.fontName
            if (r1 != 0) goto L44
            if (r3 != 0) goto L42
            r1 = r0
            goto L4b
        L42:
            r1 = r2
            goto L4b
        L44:
            if (r3 != 0) goto L47
            goto L42
        L47:
            boolean r1 = com.revenuecat.purchases.FontAlias.m436equalsimpl0(r1, r3)
        L4b:
            if (r1 != 0) goto L4e
            return r2
        L4e:
            com.revenuecat.purchases.paywalls.components.properties.FontWeight r1 = r4.fontWeight
            com.revenuecat.purchases.paywalls.components.properties.FontWeight r3 = r5.fontWeight
            if (r1 == r3) goto L55
            return r2
        L55:
            java.lang.Integer r1 = r4.fontWeightInt
            java.lang.Integer r3 = r5.fontWeightInt
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 != 0) goto L60
            return r2
        L60:
            int r1 = r4.fontSize
            int r3 = r5.fontSize
            if (r1 == r3) goto L67
            return r2
        L67:
            com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment r1 = r4.horizontalAlignment
            com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment r3 = r5.horizontalAlignment
            if (r1 == r3) goto L6e
            return r2
        L6e:
            com.revenuecat.purchases.paywalls.components.properties.Size r1 = r4.size
            com.revenuecat.purchases.paywalls.components.properties.Size r3 = r5.size
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 != 0) goto L79
            return r2
        L79:
            com.revenuecat.purchases.paywalls.components.properties.Padding r1 = r4.padding
            com.revenuecat.purchases.paywalls.components.properties.Padding r3 = r5.padding
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 != 0) goto L84
            return r2
        L84:
            com.revenuecat.purchases.paywalls.components.properties.Padding r1 = r4.margin
            com.revenuecat.purchases.paywalls.components.properties.Padding r3 = r5.margin
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 != 0) goto L8f
            return r2
        L8f:
            java.util.List<com.revenuecat.purchases.paywalls.components.common.ComponentOverride<com.revenuecat.purchases.paywalls.components.PartialTextComponent>> r1 = r4.overrides
            java.util.List<com.revenuecat.purchases.paywalls.components.common.ComponentOverride<com.revenuecat.purchases.paywalls.components.PartialTextComponent>> r3 = r5.overrides
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 != 0) goto L9a
            return r2
        L9a:
            java.lang.String r1 = r4.name
            java.lang.String r5 = r5.name
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r5)
            if (r5 != 0) goto La5
            return r2
        La5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.paywalls.components.TextComponent.equals(java.lang.Object):boolean");
    }

    public final /* synthetic */ ColorScheme getBackgroundColor() {
        return this.backgroundColor;
    }

    public final /* synthetic */ ColorScheme getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: getFontName-ARcRonI, reason: not valid java name */
    public final /* synthetic */ String m607getFontNameARcRonI() {
        return this.fontName;
    }

    public final /* synthetic */ int getFontSize() {
        return this.fontSize;
    }

    public final /* synthetic */ FontWeight getFontWeight() {
        return this.fontWeight;
    }

    public final /* synthetic */ Integer getFontWeightInt() {
        return this.fontWeightInt;
    }

    public final /* synthetic */ HorizontalAlignment getHorizontalAlignment() {
        return this.horizontalAlignment;
    }

    public final /* synthetic */ Padding getMargin() {
        return this.margin;
    }

    public final /* synthetic */ String getName() {
        return this.name;
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

    /* JADX INFO: renamed from: getText-z7Tp-4o, reason: not valid java name */
    public final /* synthetic */ String m608getTextz7Tp4o() {
        return this.text;
    }

    public final /* synthetic */ Boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        int iM652hashCodeimpl = ((LocalizationKey.m652hashCodeimpl(this.text) * 31) + this.color.hashCode()) * 31;
        Boolean bool = this.visible;
        int iHashCode = (iM652hashCodeimpl + (bool == null ? 0 : bool.hashCode())) * 31;
        ColorScheme colorScheme = this.backgroundColor;
        int iHashCode2 = (iHashCode + (colorScheme == null ? 0 : colorScheme.hashCode())) * 31;
        String str = this.fontName;
        int iM437hashCodeimpl = (((iHashCode2 + (str == null ? 0 : FontAlias.m437hashCodeimpl(str))) * 31) + this.fontWeight.hashCode()) * 31;
        Integer num = this.fontWeightInt;
        int iHashCode3 = (((((((((((((iM437hashCodeimpl + (num == null ? 0 : num.hashCode())) * 31) + this.fontSize) * 31) + this.horizontalAlignment.hashCode()) * 31) + this.size.hashCode()) * 31) + this.padding.hashCode()) * 31) + this.margin.hashCode()) * 31) + this.overrides.hashCode()) * 31;
        String str2 = this.name;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TextComponent(text=");
        sb.append((Object) LocalizationKey.m653toStringimpl(this.text));
        sb.append(", color=");
        sb.append(this.color);
        sb.append(", visible=");
        sb.append(this.visible);
        sb.append(", backgroundColor=");
        sb.append(this.backgroundColor);
        sb.append(", fontName=");
        String str = this.fontName;
        sb.append((Object) (str == null ? "null" : FontAlias.m438toStringimpl(str)));
        sb.append(", fontWeight=");
        sb.append(this.fontWeight);
        sb.append(", fontWeightInt=");
        sb.append(this.fontWeightInt);
        sb.append(", fontSize=");
        sb.append(this.fontSize);
        sb.append(", horizontalAlignment=");
        sb.append(this.horizontalAlignment);
        sb.append(", size=");
        sb.append(this.size);
        sb.append(", padding=");
        sb.append(this.padding);
        sb.append(", margin=");
        sb.append(this.margin);
        sb.append(", overrides=");
        sb.append(this.overrides);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ TextComponent(String str, ColorScheme colorScheme, Boolean bool, ColorScheme colorScheme2, String str2, FontWeight fontWeight, Integer num, int i3, HorizontalAlignment horizontalAlignment, Size size, Padding padding, Padding padding2, List list, String str3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, colorScheme, bool, colorScheme2, str2, fontWeight, num, i3, horizontalAlignment, size, padding, padding2, list, str3);
    }

    private TextComponent(int i3, String str, ColorScheme colorScheme, Boolean bool, ColorScheme colorScheme2, String str2, FontWeight fontWeight, Integer num, int i4, HorizontalAlignment horizontalAlignment, Size size, Padding padding, Padding padding2, List<ComponentOverride<PartialTextComponent>> list, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i3 & 3)) {
            PluginExceptionsKt.b(i3, 3, TextComponent$$serializer.INSTANCE.getDescriptor());
        }
        this.text = str;
        this.color = colorScheme;
        if ((i3 & 4) == 0) {
            this.visible = null;
        } else {
            this.visible = bool;
        }
        if ((i3 & 8) == 0) {
            this.backgroundColor = null;
        } else {
            this.backgroundColor = colorScheme2;
        }
        if ((i3 & 16) == 0) {
            this.fontName = null;
        } else {
            this.fontName = str2;
        }
        if ((i3 & 32) == 0) {
            this.fontWeight = FontWeight.REGULAR;
        } else {
            this.fontWeight = fontWeight;
        }
        if ((i3 & 64) == 0) {
            this.fontWeightInt = null;
        } else {
            this.fontWeightInt = num;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
            this.fontSize = 15;
        } else {
            this.fontSize = i4;
        }
        if ((i3 & Function.MAX_NARGS) == 0) {
            this.horizontalAlignment = HorizontalAlignment.CENTER;
        } else {
            this.horizontalAlignment = horizontalAlignment;
        }
        if ((i3 & 512) == 0) {
            this.size = new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE);
        } else {
            this.size = size;
        }
        if ((i3 & 1024) == 0) {
            this.padding = Padding.Companion.getZero();
        } else {
            this.padding = padding;
        }
        if ((i3 & 2048) == 0) {
            this.margin = Padding.Companion.getZero();
        } else {
            this.margin = padding2;
        }
        this.overrides = (i3 & 4096) == 0 ? CollectionsKt.emptyList() : list;
        if ((i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0) {
            this.name = null;
        } else {
            this.name = str3;
        }
    }

    @SerialName
    public static /* synthetic */ void getBackgroundColor$annotations() {
    }

    @SerialName
    /* JADX INFO: renamed from: getFontName-ARcRonI$annotations, reason: not valid java name */
    public static /* synthetic */ void m605getFontNameARcRonI$annotations() {
    }

    @SerialName
    @Serializable(with = FontSizeSerializer.class)
    public static /* synthetic */ void getFontSize$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getFontWeight$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getFontWeightInt$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getHorizontalAlignment$annotations() {
    }

    @SerialName
    /* JADX INFO: renamed from: getText-z7Tp-4o$annotations, reason: not valid java name */
    public static /* synthetic */ void m606getTextz7Tp4o$annotations() {
    }

    private TextComponent(String text, ColorScheme color, Boolean bool, ColorScheme colorScheme, String str, FontWeight fontWeight, Integer num, int i3, HorizontalAlignment horizontalAlignment, Size size, Padding padding, Padding margin, List<ComponentOverride<PartialTextComponent>> overrides, String str2) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        Intrinsics.checkNotNullParameter(horizontalAlignment, "horizontalAlignment");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        this.text = text;
        this.color = color;
        this.visible = bool;
        this.backgroundColor = colorScheme;
        this.fontName = str;
        this.fontWeight = fontWeight;
        this.fontWeightInt = num;
        this.fontSize = i3;
        this.horizontalAlignment = horizontalAlignment;
        this.size = size;
        this.padding = padding;
        this.margin = margin;
        this.overrides = overrides;
        this.name = str2;
    }

    public /* synthetic */ TextComponent(String str, ColorScheme colorScheme, Boolean bool, ColorScheme colorScheme2, String str2, FontWeight fontWeight, Integer num, int i3, HorizontalAlignment horizontalAlignment, Size size, Padding padding, Padding padding2, List list, String str3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, colorScheme, (i4 & 4) != 0 ? null : bool, (i4 & 8) != 0 ? null : colorScheme2, (i4 & 16) != 0 ? null : str2, (i4 & 32) != 0 ? FontWeight.REGULAR : fontWeight, (i4 & 64) != 0 ? null : num, (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? 15 : i3, (i4 & Function.MAX_NARGS) != 0 ? HorizontalAlignment.CENTER : horizontalAlignment, (i4 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE) : size, (i4 & 1024) != 0 ? Padding.Companion.getZero() : padding, (i4 & 2048) != 0 ? Padding.Companion.getZero() : padding2, (i4 & 4096) != 0 ? CollectionsKt.emptyList() : list, (i4 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? null : str3, null);
    }
}
