package com.revenuecat.purchases.paywalls.components;

import androidx.datastore.preferences.core.SfRj.rnFwbPAQmQTnL;
import com.revenuecat.purchases.paywalls.components.IconComponent;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
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
public final class PartialIconComponent implements PartialComponent {
    public static final Companion Companion = new Companion(null);
    private final String baseUrl;
    private final ColorScheme color;
    private final IconComponent.Formats formats;
    private final IconComponent.IconBackground iconBackground;
    private final String iconName;
    private final Padding margin;
    private final Padding padding;
    private final Size size;
    private final Boolean visible;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<PartialIconComponent> serializer() {
            return PartialIconComponent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public PartialIconComponent() {
        this((Boolean) null, (String) null, (String) null, (IconComponent.Formats) null, (Size) null, (ColorScheme) null, (Padding) null, (Padding) null, (IconComponent.IconBackground) null, 511, (DefaultConstructorMarker) null);
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
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PartialIconComponent partialIconComponent, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        if (compositeEncoder.z(serialDescriptor, 0) || !Intrinsics.areEqual(partialIconComponent.visible, Boolean.TRUE)) {
            compositeEncoder.i(serialDescriptor, 0, BooleanSerializer.f142767a, partialIconComponent.visible);
        }
        if (compositeEncoder.z(serialDescriptor, 1) || partialIconComponent.baseUrl != null) {
            compositeEncoder.i(serialDescriptor, 1, StringSerializer.f142891a, partialIconComponent.baseUrl);
        }
        if (compositeEncoder.z(serialDescriptor, 2) || partialIconComponent.iconName != null) {
            compositeEncoder.i(serialDescriptor, 2, StringSerializer.f142891a, partialIconComponent.iconName);
        }
        if (compositeEncoder.z(serialDescriptor, 3) || partialIconComponent.formats != null) {
            compositeEncoder.i(serialDescriptor, 3, IconComponent$Formats$$serializer.INSTANCE, partialIconComponent.formats);
        }
        if (compositeEncoder.z(serialDescriptor, 4) || partialIconComponent.size != null) {
            compositeEncoder.i(serialDescriptor, 4, Size$$serializer.INSTANCE, partialIconComponent.size);
        }
        if (compositeEncoder.z(serialDescriptor, 5) || partialIconComponent.color != null) {
            compositeEncoder.i(serialDescriptor, 5, ColorScheme$$serializer.INSTANCE, partialIconComponent.color);
        }
        if (compositeEncoder.z(serialDescriptor, 6) || partialIconComponent.padding != null) {
            compositeEncoder.i(serialDescriptor, 6, Padding$$serializer.INSTANCE, partialIconComponent.padding);
        }
        if (compositeEncoder.z(serialDescriptor, 7) || partialIconComponent.margin != null) {
            compositeEncoder.i(serialDescriptor, 7, Padding$$serializer.INSTANCE, partialIconComponent.margin);
        }
        if (!compositeEncoder.z(serialDescriptor, 8) && partialIconComponent.iconBackground == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 8, IconComponent$IconBackground$$serializer.INSTANCE, partialIconComponent.iconBackground);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PartialIconComponent)) {
            return false;
        }
        PartialIconComponent partialIconComponent = (PartialIconComponent) obj;
        return Intrinsics.areEqual(this.visible, partialIconComponent.visible) && Intrinsics.areEqual(this.baseUrl, partialIconComponent.baseUrl) && Intrinsics.areEqual(this.iconName, partialIconComponent.iconName) && Intrinsics.areEqual(this.formats, partialIconComponent.formats) && Intrinsics.areEqual(this.size, partialIconComponent.size) && Intrinsics.areEqual(this.color, partialIconComponent.color) && Intrinsics.areEqual(this.padding, partialIconComponent.padding) && Intrinsics.areEqual(this.margin, partialIconComponent.margin) && Intrinsics.areEqual(this.iconBackground, partialIconComponent.iconBackground);
    }

    public final /* synthetic */ String getBaseUrl() {
        return this.baseUrl;
    }

    public final /* synthetic */ ColorScheme getColor() {
        return this.color;
    }

    public final /* synthetic */ IconComponent.Formats getFormats() {
        return this.formats;
    }

    public final /* synthetic */ IconComponent.IconBackground getIconBackground() {
        return this.iconBackground;
    }

    public final /* synthetic */ String getIconName() {
        return this.iconName;
    }

    public final /* synthetic */ Padding getMargin() {
        return this.margin;
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
        Boolean bool = this.visible;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.baseUrl;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.iconName;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        IconComponent.Formats formats = this.formats;
        int iHashCode4 = (iHashCode3 + (formats == null ? 0 : formats.hashCode())) * 31;
        Size size = this.size;
        int iHashCode5 = (iHashCode4 + (size == null ? 0 : size.hashCode())) * 31;
        ColorScheme colorScheme = this.color;
        int iHashCode6 = (iHashCode5 + (colorScheme == null ? 0 : colorScheme.hashCode())) * 31;
        Padding padding = this.padding;
        int iHashCode7 = (iHashCode6 + (padding == null ? 0 : padding.hashCode())) * 31;
        Padding padding2 = this.margin;
        int iHashCode8 = (iHashCode7 + (padding2 == null ? 0 : padding2.hashCode())) * 31;
        IconComponent.IconBackground iconBackground = this.iconBackground;
        return iHashCode8 + (iconBackground != null ? iconBackground.hashCode() : 0);
    }

    @Deprecated
    public /* synthetic */ PartialIconComponent(int i3, Boolean bool, @SerialName String str, @SerialName String str2, IconComponent.Formats formats, Size size, ColorScheme colorScheme, Padding padding, Padding padding2, @SerialName IconComponent.IconBackground iconBackground, SerializationConstructorMarker serializationConstructorMarker) {
        this.visible = (i3 & 1) == 0 ? Boolean.TRUE : bool;
        if ((i3 & 2) == 0) {
            this.baseUrl = null;
        } else {
            this.baseUrl = str;
        }
        if ((i3 & 4) == 0) {
            this.iconName = null;
        } else {
            this.iconName = str2;
        }
        if ((i3 & 8) == 0) {
            this.formats = null;
        } else {
            this.formats = formats;
        }
        if ((i3 & 16) == 0) {
            this.size = null;
        } else {
            this.size = size;
        }
        if ((i3 & 32) == 0) {
            this.color = null;
        } else {
            this.color = colorScheme;
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
            this.iconBackground = null;
        } else {
            this.iconBackground = iconBackground;
        }
    }

    public String toString() {
        return rnFwbPAQmQTnL.abVnRqDGogP + this.visible + ", baseUrl=" + this.baseUrl + ", iconName=" + this.iconName + ", formats=" + this.formats + ", size=" + this.size + ", color=" + this.color + ", padding=" + this.padding + ", margin=" + this.margin + ", iconBackground=" + this.iconBackground + ')';
    }

    public PartialIconComponent(Boolean bool, String str, String str2, IconComponent.Formats formats, Size size, ColorScheme colorScheme, Padding padding, Padding padding2, IconComponent.IconBackground iconBackground) {
        this.visible = bool;
        this.baseUrl = str;
        this.iconName = str2;
        this.formats = formats;
        this.size = size;
        this.color = colorScheme;
        this.padding = padding;
        this.margin = padding2;
        this.iconBackground = iconBackground;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ PartialIconComponent(java.lang.Boolean r2, java.lang.String r3, java.lang.String r4, com.revenuecat.purchases.paywalls.components.IconComponent.Formats r5, com.revenuecat.purchases.paywalls.components.properties.Size r6, com.revenuecat.purchases.paywalls.components.properties.ColorScheme r7, com.revenuecat.purchases.paywalls.components.properties.Padding r8, com.revenuecat.purchases.paywalls.components.properties.Padding r9, com.revenuecat.purchases.paywalls.components.IconComponent.IconBackground r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r1 = this;
            r12 = r11 & 1
            if (r12 == 0) goto L6
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
        L6:
            r12 = r11 & 2
            r0 = 0
            if (r12 == 0) goto Lc
            r3 = r0
        Lc:
            r12 = r11 & 4
            if (r12 == 0) goto L11
            r4 = r0
        L11:
            r12 = r11 & 8
            if (r12 == 0) goto L16
            r5 = r0
        L16:
            r12 = r11 & 16
            if (r12 == 0) goto L1b
            r6 = r0
        L1b:
            r12 = r11 & 32
            if (r12 == 0) goto L20
            r7 = r0
        L20:
            r12 = r11 & 64
            if (r12 == 0) goto L25
            r8 = r0
        L25:
            r12 = r11 & 128(0x80, float:1.8E-43)
            if (r12 == 0) goto L2a
            r9 = r0
        L2a:
            r11 = r11 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L39
            r12 = r0
            r10 = r8
            r11 = r9
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
            goto L43
        L39:
            r12 = r10
            r11 = r9
            r9 = r7
            r10 = r8
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
        L43:
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.paywalls.components.PartialIconComponent.<init>(java.lang.Boolean, java.lang.String, java.lang.String, com.revenuecat.purchases.paywalls.components.IconComponent$Formats, com.revenuecat.purchases.paywalls.components.properties.Size, com.revenuecat.purchases.paywalls.components.properties.ColorScheme, com.revenuecat.purchases.paywalls.components.properties.Padding, com.revenuecat.purchases.paywalls.components.properties.Padding, com.revenuecat.purchases.paywalls.components.IconComponent$IconBackground, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
