package com.revenuecat.purchases.paywalls.components;

import com.facebook.internal.Utility;
import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.BackgroundDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.Border$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shadow$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.ShapeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.VerticalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.VerticalAlignmentDeserializer;
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
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.IntSerializer;
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
public final class PartialCarouselComponent implements PartialComponent {
    public static final Companion Companion = new Companion(null);
    private final CarouselComponent.AutoAdvancePages autoAdvance;
    private final Background background;
    private final ColorScheme backgroundColor;
    private final Border border;
    private final Integer initialPageIndex;
    private final Boolean loop;
    private final Padding margin;
    private final Padding padding;
    private final VerticalAlignment pageAlignment;
    private final CarouselComponent.PageControl pageControl;
    private final Integer pagePeek;
    private final Float pageSpacing;
    private final Shadow shadow;
    private final Shape shape;
    private final Size size;
    private final Boolean visible;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<PartialCarouselComponent> serializer() {
            return PartialCarouselComponent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public PartialCarouselComponent() {
        this((Boolean) null, (Integer) null, (VerticalAlignment) null, (Size) null, (Integer) null, (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (CarouselComponent.PageControl) null, (Boolean) null, (CarouselComponent.AutoAdvancePages) null, 65535, (DefaultConstructorMarker) null);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PartialCarouselComponent partialCarouselComponent, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        if (compositeEncoder.z(serialDescriptor, 0) || partialCarouselComponent.visible != null) {
            compositeEncoder.i(serialDescriptor, 0, BooleanSerializer.f142767a, partialCarouselComponent.visible);
        }
        if (compositeEncoder.z(serialDescriptor, 1) || partialCarouselComponent.initialPageIndex != null) {
            compositeEncoder.i(serialDescriptor, 1, IntSerializer.f142823a, partialCarouselComponent.initialPageIndex);
        }
        if (compositeEncoder.z(serialDescriptor, 2) || partialCarouselComponent.pageAlignment != null) {
            compositeEncoder.i(serialDescriptor, 2, VerticalAlignmentDeserializer.INSTANCE, partialCarouselComponent.pageAlignment);
        }
        if (compositeEncoder.z(serialDescriptor, 3) || partialCarouselComponent.size != null) {
            compositeEncoder.i(serialDescriptor, 3, Size$$serializer.INSTANCE, partialCarouselComponent.size);
        }
        if (compositeEncoder.z(serialDescriptor, 4) || partialCarouselComponent.pagePeek != null) {
            compositeEncoder.i(serialDescriptor, 4, IntSerializer.f142823a, partialCarouselComponent.pagePeek);
        }
        if (compositeEncoder.z(serialDescriptor, 5) || partialCarouselComponent.pageSpacing != null) {
            compositeEncoder.i(serialDescriptor, 5, FloatSerializer.f142814a, partialCarouselComponent.pageSpacing);
        }
        if (compositeEncoder.z(serialDescriptor, 6) || partialCarouselComponent.backgroundColor != null) {
            compositeEncoder.i(serialDescriptor, 6, ColorScheme$$serializer.INSTANCE, partialCarouselComponent.backgroundColor);
        }
        if (compositeEncoder.z(serialDescriptor, 7) || partialCarouselComponent.background != null) {
            compositeEncoder.i(serialDescriptor, 7, BackgroundDeserializer.INSTANCE, partialCarouselComponent.background);
        }
        if (compositeEncoder.z(serialDescriptor, 8) || partialCarouselComponent.padding != null) {
            compositeEncoder.i(serialDescriptor, 8, Padding$$serializer.INSTANCE, partialCarouselComponent.padding);
        }
        if (compositeEncoder.z(serialDescriptor, 9) || partialCarouselComponent.margin != null) {
            compositeEncoder.i(serialDescriptor, 9, Padding$$serializer.INSTANCE, partialCarouselComponent.margin);
        }
        if (compositeEncoder.z(serialDescriptor, 10) || partialCarouselComponent.shape != null) {
            compositeEncoder.i(serialDescriptor, 10, ShapeDeserializer.INSTANCE, partialCarouselComponent.shape);
        }
        if (compositeEncoder.z(serialDescriptor, 11) || partialCarouselComponent.border != null) {
            compositeEncoder.i(serialDescriptor, 11, Border$$serializer.INSTANCE, partialCarouselComponent.border);
        }
        if (compositeEncoder.z(serialDescriptor, 12) || partialCarouselComponent.shadow != null) {
            compositeEncoder.i(serialDescriptor, 12, Shadow$$serializer.INSTANCE, partialCarouselComponent.shadow);
        }
        if (compositeEncoder.z(serialDescriptor, 13) || partialCarouselComponent.pageControl != null) {
            compositeEncoder.i(serialDescriptor, 13, CarouselComponent$PageControl$$serializer.INSTANCE, partialCarouselComponent.pageControl);
        }
        if (compositeEncoder.z(serialDescriptor, 14) || partialCarouselComponent.loop != null) {
            compositeEncoder.i(serialDescriptor, 14, BooleanSerializer.f142767a, partialCarouselComponent.loop);
        }
        if (!compositeEncoder.z(serialDescriptor, 15) && partialCarouselComponent.autoAdvance == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 15, CarouselComponent$AutoAdvancePages$$serializer.INSTANCE, partialCarouselComponent.autoAdvance);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PartialCarouselComponent)) {
            return false;
        }
        PartialCarouselComponent partialCarouselComponent = (PartialCarouselComponent) obj;
        return Intrinsics.areEqual(this.visible, partialCarouselComponent.visible) && Intrinsics.areEqual(this.initialPageIndex, partialCarouselComponent.initialPageIndex) && this.pageAlignment == partialCarouselComponent.pageAlignment && Intrinsics.areEqual(this.size, partialCarouselComponent.size) && Intrinsics.areEqual(this.pagePeek, partialCarouselComponent.pagePeek) && Intrinsics.areEqual((Object) this.pageSpacing, (Object) partialCarouselComponent.pageSpacing) && Intrinsics.areEqual(this.backgroundColor, partialCarouselComponent.backgroundColor) && Intrinsics.areEqual(this.background, partialCarouselComponent.background) && Intrinsics.areEqual(this.padding, partialCarouselComponent.padding) && Intrinsics.areEqual(this.margin, partialCarouselComponent.margin) && Intrinsics.areEqual(this.shape, partialCarouselComponent.shape) && Intrinsics.areEqual(this.border, partialCarouselComponent.border) && Intrinsics.areEqual(this.shadow, partialCarouselComponent.shadow) && Intrinsics.areEqual(this.pageControl, partialCarouselComponent.pageControl) && Intrinsics.areEqual(this.loop, partialCarouselComponent.loop) && Intrinsics.areEqual(this.autoAdvance, partialCarouselComponent.autoAdvance);
    }

    public final /* synthetic */ CarouselComponent.AutoAdvancePages getAutoAdvance() {
        return this.autoAdvance;
    }

    public final /* synthetic */ Background getBackground() {
        return this.background;
    }

    public final /* synthetic */ ColorScheme getBackgroundColor() {
        return this.backgroundColor;
    }

    public final /* synthetic */ Border getBorder() {
        return this.border;
    }

    public final /* synthetic */ Integer getInitialPageIndex() {
        return this.initialPageIndex;
    }

    public final /* synthetic */ Boolean getLoop() {
        return this.loop;
    }

    public final /* synthetic */ Padding getMargin() {
        return this.margin;
    }

    public final /* synthetic */ Padding getPadding() {
        return this.padding;
    }

    public final /* synthetic */ VerticalAlignment getPageAlignment() {
        return this.pageAlignment;
    }

    public final /* synthetic */ CarouselComponent.PageControl getPageControl() {
        return this.pageControl;
    }

    public final /* synthetic */ Integer getPagePeek() {
        return this.pagePeek;
    }

    public final /* synthetic */ Float getPageSpacing() {
        return this.pageSpacing;
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

    public final /* synthetic */ Boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        Boolean bool = this.visible;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Integer num = this.initialPageIndex;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        VerticalAlignment verticalAlignment = this.pageAlignment;
        int iHashCode3 = (iHashCode2 + (verticalAlignment == null ? 0 : verticalAlignment.hashCode())) * 31;
        Size size = this.size;
        int iHashCode4 = (iHashCode3 + (size == null ? 0 : size.hashCode())) * 31;
        Integer num2 = this.pagePeek;
        int iHashCode5 = (iHashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Float f3 = this.pageSpacing;
        int iHashCode6 = (iHashCode5 + (f3 == null ? 0 : f3.hashCode())) * 31;
        ColorScheme colorScheme = this.backgroundColor;
        int iHashCode7 = (iHashCode6 + (colorScheme == null ? 0 : colorScheme.hashCode())) * 31;
        Background background = this.background;
        int iHashCode8 = (iHashCode7 + (background == null ? 0 : background.hashCode())) * 31;
        Padding padding = this.padding;
        int iHashCode9 = (iHashCode8 + (padding == null ? 0 : padding.hashCode())) * 31;
        Padding padding2 = this.margin;
        int iHashCode10 = (iHashCode9 + (padding2 == null ? 0 : padding2.hashCode())) * 31;
        Shape shape = this.shape;
        int iHashCode11 = (iHashCode10 + (shape == null ? 0 : shape.hashCode())) * 31;
        Border border = this.border;
        int iHashCode12 = (iHashCode11 + (border == null ? 0 : border.hashCode())) * 31;
        Shadow shadow = this.shadow;
        int iHashCode13 = (iHashCode12 + (shadow == null ? 0 : shadow.hashCode())) * 31;
        CarouselComponent.PageControl pageControl = this.pageControl;
        int iHashCode14 = (iHashCode13 + (pageControl == null ? 0 : pageControl.hashCode())) * 31;
        Boolean bool2 = this.loop;
        int iHashCode15 = (iHashCode14 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        CarouselComponent.AutoAdvancePages autoAdvancePages = this.autoAdvance;
        return iHashCode15 + (autoAdvancePages != null ? autoAdvancePages.hashCode() : 0);
    }

    public String toString() {
        return "PartialCarouselComponent(visible=" + this.visible + ", initialPageIndex=" + this.initialPageIndex + ", pageAlignment=" + this.pageAlignment + ", size=" + this.size + ", pagePeek=" + this.pagePeek + ", pageSpacing=" + this.pageSpacing + ", backgroundColor=" + this.backgroundColor + ", background=" + this.background + ", padding=" + this.padding + ", margin=" + this.margin + ", shape=" + this.shape + ", border=" + this.border + ", shadow=" + this.shadow + ", pageControl=" + this.pageControl + ", loop=" + this.loop + ", autoAdvance=" + this.autoAdvance + ')';
    }

    @Deprecated
    public /* synthetic */ PartialCarouselComponent(int i3, Boolean bool, @SerialName Integer num, @SerialName VerticalAlignment verticalAlignment, Size size, @SerialName Integer num2, @SerialName Float f3, @SerialName ColorScheme colorScheme, Background background, Padding padding, Padding padding2, Shape shape, Border border, Shadow shadow, @SerialName CarouselComponent.PageControl pageControl, Boolean bool2, @SerialName CarouselComponent.AutoAdvancePages autoAdvancePages, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i3 & 1) == 0) {
            this.visible = null;
        } else {
            this.visible = bool;
        }
        if ((i3 & 2) == 0) {
            this.initialPageIndex = null;
        } else {
            this.initialPageIndex = num;
        }
        if ((i3 & 4) == 0) {
            this.pageAlignment = null;
        } else {
            this.pageAlignment = verticalAlignment;
        }
        if ((i3 & 8) == 0) {
            this.size = null;
        } else {
            this.size = size;
        }
        if ((i3 & 16) == 0) {
            this.pagePeek = null;
        } else {
            this.pagePeek = num2;
        }
        if ((i3 & 32) == 0) {
            this.pageSpacing = null;
        } else {
            this.pageSpacing = f3;
        }
        if ((i3 & 64) == 0) {
            this.backgroundColor = null;
        } else {
            this.backgroundColor = colorScheme;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
            this.background = null;
        } else {
            this.background = background;
        }
        if ((i3 & Function.MAX_NARGS) == 0) {
            this.padding = null;
        } else {
            this.padding = padding;
        }
        if ((i3 & 512) == 0) {
            this.margin = null;
        } else {
            this.margin = padding2;
        }
        if ((i3 & 1024) == 0) {
            this.shape = null;
        } else {
            this.shape = shape;
        }
        if ((i3 & 2048) == 0) {
            this.border = null;
        } else {
            this.border = border;
        }
        if ((i3 & 4096) == 0) {
            this.shadow = null;
        } else {
            this.shadow = shadow;
        }
        if ((i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0) {
            this.pageControl = null;
        } else {
            this.pageControl = pageControl;
        }
        if ((i3 & 16384) == 0) {
            this.loop = null;
        } else {
            this.loop = bool2;
        }
        if ((i3 & 32768) == 0) {
            this.autoAdvance = null;
        } else {
            this.autoAdvance = autoAdvancePages;
        }
    }

    public PartialCarouselComponent(Boolean bool, Integer num, VerticalAlignment verticalAlignment, Size size, Integer num2, Float f3, ColorScheme colorScheme, Background background, Padding padding, Padding padding2, Shape shape, Border border, Shadow shadow, CarouselComponent.PageControl pageControl, Boolean bool2, CarouselComponent.AutoAdvancePages autoAdvancePages) {
        this.visible = bool;
        this.initialPageIndex = num;
        this.pageAlignment = verticalAlignment;
        this.size = size;
        this.pagePeek = num2;
        this.pageSpacing = f3;
        this.backgroundColor = colorScheme;
        this.background = background;
        this.padding = padding;
        this.margin = padding2;
        this.shape = shape;
        this.border = border;
        this.shadow = shadow;
        this.pageControl = pageControl;
        this.loop = bool2;
        this.autoAdvance = autoAdvancePages;
    }

    @SerialName
    public static /* synthetic */ void getAutoAdvance$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getBackgroundColor$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getInitialPageIndex$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getPageAlignment$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getPageControl$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getPagePeek$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getPageSpacing$annotations() {
    }

    public /* synthetic */ PartialCarouselComponent(Boolean bool, Integer num, VerticalAlignment verticalAlignment, Size size, Integer num2, Float f3, ColorScheme colorScheme, Background background, Padding padding, Padding padding2, Shape shape, Border border, Shadow shadow, CarouselComponent.PageControl pageControl, Boolean bool2, CarouselComponent.AutoAdvancePages autoAdvancePages, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : bool, (i3 & 2) != 0 ? null : num, (i3 & 4) != 0 ? null : verticalAlignment, (i3 & 8) != 0 ? null : size, (i3 & 16) != 0 ? null : num2, (i3 & 32) != 0 ? null : f3, (i3 & 64) != 0 ? null : colorScheme, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : background, (i3 & Function.MAX_NARGS) != 0 ? null : padding, (i3 & 512) != 0 ? null : padding2, (i3 & 1024) != 0 ? null : shape, (i3 & 2048) != 0 ? null : border, (i3 & 4096) != 0 ? null : shadow, (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? null : pageControl, (i3 & 16384) != 0 ? null : bool2, (i3 & 32768) != 0 ? null : autoAdvancePages);
    }
}
