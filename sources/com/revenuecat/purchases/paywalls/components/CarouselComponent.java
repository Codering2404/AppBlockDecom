package com.revenuecat.purchases.paywalls.components;

import com.facebook.internal.Utility;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
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
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.paywalls.components.properties.VerticalAlignment;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.UInt;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.UIntSerializer;

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
public final class CarouselComponent implements PaywallComponent {
    private final AutoAdvancePages autoAdvance;
    private final Background background;
    private final ColorScheme backgroundColor;
    private final Border border;
    private final Integer initialPageIndex;
    private final Boolean loop;
    private final Padding margin;
    private final String name;
    private final List<ComponentOverride<PartialCarouselComponent>> overrides;
    private final Padding padding;
    private final VerticalAlignment pageAlignment;
    private final PageControl pageControl;
    private final Integer pagePeek;
    private final Float pageSpacing;
    private final List<StackComponent> pages;
    private final Shadow shadow;
    private final Shape shape;
    private final Size size;
    private final Boolean visible;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(StackComponent$$serializer.INSTANCE), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new ArrayListSerializer(ComponentOverride.Companion.serializer(PartialCarouselComponent$$serializer.INSTANCE)), null};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class AutoAdvancePages {
        public static final Companion Companion = new Companion(null);
        private final int msTimePerPage;
        private final int msTransitionTime;
        private final TransitionType transitionType;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<AutoAdvancePages> serializer() {
                return CarouselComponent$AutoAdvancePages$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable(with = CarouselTransitionTypeDeserializer.class)
        public enum TransitionType {
            FADE,
            SLIDE;

            public static final Companion Companion = new Companion(null);

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<TransitionType> serializer() {
                    return CarouselTransitionTypeDeserializer.INSTANCE;
                }

                private Companion() {
                }
            }
        }

        @Deprecated
        public /* synthetic */ AutoAdvancePages(int i3, @SerialName int i4, @SerialName int i5, @SerialName TransitionType transitionType, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i3 & 3)) {
                PluginExceptionsKt.b(i3, 3, CarouselComponent$AutoAdvancePages$$serializer.INSTANCE.getDescriptor());
            }
            this.msTimePerPage = i4;
            this.msTransitionTime = i5;
            if ((i3 & 4) == 0) {
                this.transitionType = null;
            } else {
                this.transitionType = transitionType;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(AutoAdvancePages autoAdvancePages, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            compositeEncoder.w(serialDescriptor, 0, autoAdvancePages.msTimePerPage);
            compositeEncoder.w(serialDescriptor, 1, autoAdvancePages.msTransitionTime);
            if (!compositeEncoder.z(serialDescriptor, 2) && autoAdvancePages.transitionType == null) {
                return;
            }
            compositeEncoder.i(serialDescriptor, 2, CarouselTransitionTypeDeserializer.INSTANCE, autoAdvancePages.transitionType);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AutoAdvancePages)) {
                return false;
            }
            AutoAdvancePages autoAdvancePages = (AutoAdvancePages) obj;
            return this.msTimePerPage == autoAdvancePages.msTimePerPage && this.msTransitionTime == autoAdvancePages.msTransitionTime && this.transitionType == autoAdvancePages.transitionType;
        }

        public final /* synthetic */ int getMsTimePerPage() {
            return this.msTimePerPage;
        }

        public final /* synthetic */ int getMsTransitionTime() {
            return this.msTransitionTime;
        }

        public final /* synthetic */ TransitionType getTransitionType() {
            return this.transitionType;
        }

        public int hashCode() {
            int i3 = ((this.msTimePerPage * 31) + this.msTransitionTime) * 31;
            TransitionType transitionType = this.transitionType;
            return i3 + (transitionType == null ? 0 : transitionType.hashCode());
        }

        public String toString() {
            return "AutoAdvancePages(msTimePerPage=" + this.msTimePerPage + ", msTransitionTime=" + this.msTransitionTime + ", transitionType=" + this.transitionType + ')';
        }

        public AutoAdvancePages(int i3, int i4, TransitionType transitionType) {
            this.msTimePerPage = i3;
            this.msTransitionTime = i4;
            this.transitionType = transitionType;
        }

        public /* synthetic */ AutoAdvancePages(int i3, int i4, TransitionType transitionType, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, i4, (i5 & 4) != 0 ? null : transitionType);
        }

        @SerialName
        public static /* synthetic */ void getMsTimePerPage$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getMsTransitionTime$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getTransitionType$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<CarouselComponent> serializer() {
            return CarouselComponent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @Deprecated
    public /* synthetic */ CarouselComponent(int i3, List list, Boolean bool, @SerialName Integer num, @SerialName VerticalAlignment verticalAlignment, Size size, @SerialName Integer num2, @SerialName Float f3, @SerialName ColorScheme colorScheme, Background background, Padding padding, Padding padding2, Shape shape, Border border, Shadow shadow, @SerialName PageControl pageControl, Boolean bool2, @SerialName AutoAdvancePages autoAdvancePages, List list2, String str, SerializationConstructorMarker serializationConstructorMarker) {
        if (9 != (i3 & 9)) {
            PluginExceptionsKt.b(i3, 9, CarouselComponent$$serializer.INSTANCE.getDescriptor());
        }
        this.pages = list;
        if ((i3 & 2) == 0) {
            this.visible = null;
        } else {
            this.visible = bool;
        }
        if ((i3 & 4) == 0) {
            this.initialPageIndex = null;
        } else {
            this.initialPageIndex = num;
        }
        this.pageAlignment = verticalAlignment;
        if ((i3 & 16) == 0) {
            SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
            this.size = new Size(fit, fit);
        } else {
            this.size = size;
        }
        if ((i3 & 32) == 0) {
            this.pagePeek = null;
        } else {
            this.pagePeek = num2;
        }
        if ((i3 & 64) == 0) {
            this.pageSpacing = null;
        } else {
            this.pageSpacing = f3;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
            this.backgroundColor = null;
        } else {
            this.backgroundColor = colorScheme;
        }
        if ((i3 & Function.MAX_NARGS) == 0) {
            this.background = null;
        } else {
            this.background = background;
        }
        if ((i3 & 512) == 0) {
            this.padding = Padding.Companion.getZero();
        } else {
            this.padding = padding;
        }
        if ((i3 & 1024) == 0) {
            this.margin = Padding.Companion.getZero();
        } else {
            this.margin = padding2;
        }
        if ((i3 & 2048) == 0) {
            this.shape = null;
        } else {
            this.shape = shape;
        }
        if ((i3 & 4096) == 0) {
            this.border = null;
        } else {
            this.border = border;
        }
        if ((i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0) {
            this.shadow = null;
        } else {
            this.shadow = shadow;
        }
        if ((i3 & 16384) == 0) {
            this.pageControl = null;
        } else {
            this.pageControl = pageControl;
        }
        if ((32768 & i3) == 0) {
            this.loop = null;
        } else {
            this.loop = bool2;
        }
        if ((65536 & i3) == 0) {
            this.autoAdvance = null;
        } else {
            this.autoAdvance = autoAdvancePages;
        }
        this.overrides = (131072 & i3) == 0 ? CollectionsKt.emptyList() : list2;
        if ((i3 & 262144) == 0) {
            this.name = null;
        } else {
            this.name = str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0051  */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(com.revenuecat.purchases.paywalls.components.CarouselComponent r5, kotlinx.serialization.encoding.CompositeEncoder r6, kotlinx.serialization.descriptors.SerialDescriptor r7) {
        /*
            Method dump skipped, instruction units count: 396
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.paywalls.components.CarouselComponent.write$Self$purchases_defaultsBc8Release(com.revenuecat.purchases.paywalls.components.CarouselComponent, kotlinx.serialization.encoding.CompositeEncoder, kotlinx.serialization.descriptors.SerialDescriptor):void");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CarouselComponent)) {
            return false;
        }
        CarouselComponent carouselComponent = (CarouselComponent) obj;
        return Intrinsics.areEqual(this.pages, carouselComponent.pages) && Intrinsics.areEqual(this.visible, carouselComponent.visible) && Intrinsics.areEqual(this.initialPageIndex, carouselComponent.initialPageIndex) && this.pageAlignment == carouselComponent.pageAlignment && Intrinsics.areEqual(this.size, carouselComponent.size) && Intrinsics.areEqual(this.pagePeek, carouselComponent.pagePeek) && Intrinsics.areEqual((Object) this.pageSpacing, (Object) carouselComponent.pageSpacing) && Intrinsics.areEqual(this.backgroundColor, carouselComponent.backgroundColor) && Intrinsics.areEqual(this.background, carouselComponent.background) && Intrinsics.areEqual(this.padding, carouselComponent.padding) && Intrinsics.areEqual(this.margin, carouselComponent.margin) && Intrinsics.areEqual(this.shape, carouselComponent.shape) && Intrinsics.areEqual(this.border, carouselComponent.border) && Intrinsics.areEqual(this.shadow, carouselComponent.shadow) && Intrinsics.areEqual(this.pageControl, carouselComponent.pageControl) && Intrinsics.areEqual(this.loop, carouselComponent.loop) && Intrinsics.areEqual(this.autoAdvance, carouselComponent.autoAdvance) && Intrinsics.areEqual(this.overrides, carouselComponent.overrides) && Intrinsics.areEqual(this.name, carouselComponent.name);
    }

    public final /* synthetic */ AutoAdvancePages getAutoAdvance() {
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

    public final /* synthetic */ String getName() {
        return this.name;
    }

    public final /* synthetic */ List getOverrides() {
        return this.overrides;
    }

    public final /* synthetic */ Padding getPadding() {
        return this.padding;
    }

    public final /* synthetic */ VerticalAlignment getPageAlignment() {
        return this.pageAlignment;
    }

    public final /* synthetic */ PageControl getPageControl() {
        return this.pageControl;
    }

    public final /* synthetic */ Integer getPagePeek() {
        return this.pagePeek;
    }

    public final /* synthetic */ Float getPageSpacing() {
        return this.pageSpacing;
    }

    public final /* synthetic */ List getPages() {
        return this.pages;
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
        int iHashCode = this.pages.hashCode() * 31;
        Boolean bool = this.visible;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num = this.initialPageIndex;
        int iHashCode3 = (((((iHashCode2 + (num == null ? 0 : num.hashCode())) * 31) + this.pageAlignment.hashCode()) * 31) + this.size.hashCode()) * 31;
        Integer num2 = this.pagePeek;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Float f3 = this.pageSpacing;
        int iHashCode5 = (iHashCode4 + (f3 == null ? 0 : f3.hashCode())) * 31;
        ColorScheme colorScheme = this.backgroundColor;
        int iHashCode6 = (iHashCode5 + (colorScheme == null ? 0 : colorScheme.hashCode())) * 31;
        Background background = this.background;
        int iHashCode7 = (((((iHashCode6 + (background == null ? 0 : background.hashCode())) * 31) + this.padding.hashCode()) * 31) + this.margin.hashCode()) * 31;
        Shape shape = this.shape;
        int iHashCode8 = (iHashCode7 + (shape == null ? 0 : shape.hashCode())) * 31;
        Border border = this.border;
        int iHashCode9 = (iHashCode8 + (border == null ? 0 : border.hashCode())) * 31;
        Shadow shadow = this.shadow;
        int iHashCode10 = (iHashCode9 + (shadow == null ? 0 : shadow.hashCode())) * 31;
        PageControl pageControl = this.pageControl;
        int iHashCode11 = (iHashCode10 + (pageControl == null ? 0 : pageControl.hashCode())) * 31;
        Boolean bool2 = this.loop;
        int iHashCode12 = (iHashCode11 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        AutoAdvancePages autoAdvancePages = this.autoAdvance;
        int iHashCode13 = (((iHashCode12 + (autoAdvancePages == null ? 0 : autoAdvancePages.hashCode())) * 31) + this.overrides.hashCode()) * 31;
        String str = this.name;
        return iHashCode13 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "CarouselComponent(pages=" + this.pages + ", visible=" + this.visible + ", initialPageIndex=" + this.initialPageIndex + ", pageAlignment=" + this.pageAlignment + ", size=" + this.size + ", pagePeek=" + this.pagePeek + ", pageSpacing=" + this.pageSpacing + ", backgroundColor=" + this.backgroundColor + ", background=" + this.background + ", padding=" + this.padding + ", margin=" + this.margin + ", shape=" + this.shape + ", border=" + this.border + ", shadow=" + this.shadow + ", pageControl=" + this.pageControl + ", loop=" + this.loop + ", autoAdvance=" + this.autoAdvance + ", overrides=" + this.overrides + ", name=" + this.name + ')';
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class PageControl {
        public static final Companion Companion = new Companion(null);
        private final Indicator active;
        private final ColorScheme backgroundColor;
        private final Border border;

        /* JADX INFO: renamed from: default, reason: not valid java name */
        private final Indicator f1default;
        private final Padding margin;
        private final Padding padding;
        private final Position position;
        private final Shadow shadow;
        private final Shape shape;
        private final Integer spacing;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<PageControl> serializer() {
                return CarouselComponent$PageControl$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class Indicator {
            public static final Companion Companion = new Companion(null);
            private final ColorScheme color;
            private final int height;
            private final ColorScheme strokeColor;
            private final UInt strokeWidth;
            private final int width;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<Indicator> serializer() {
                    return CarouselComponent$PageControl$Indicator$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            public /* synthetic */ Indicator(int i3, int i4, ColorScheme colorScheme, ColorScheme colorScheme2, UInt uInt, DefaultConstructorMarker defaultConstructorMarker) {
                this(i3, i4, colorScheme, colorScheme2, uInt);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Indicator indicator, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                UIntSerializer uIntSerializer = UIntSerializer.f142909a;
                compositeEncoder.C(serialDescriptor, 0, uIntSerializer, UInt.a(indicator.width));
                compositeEncoder.C(serialDescriptor, 1, uIntSerializer, UInt.a(indicator.height));
                ColorScheme$$serializer colorScheme$$serializer = ColorScheme$$serializer.INSTANCE;
                compositeEncoder.C(serialDescriptor, 2, colorScheme$$serializer, indicator.color);
                if (compositeEncoder.z(serialDescriptor, 3) || indicator.strokeColor != null) {
                    compositeEncoder.i(serialDescriptor, 3, colorScheme$$serializer, indicator.strokeColor);
                }
                if (!compositeEncoder.z(serialDescriptor, 4) && indicator.strokeWidth == null) {
                    return;
                }
                compositeEncoder.i(serialDescriptor, 4, uIntSerializer, indicator.strokeWidth);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Indicator)) {
                    return false;
                }
                Indicator indicator = (Indicator) obj;
                return this.width == indicator.width && this.height == indicator.height && Intrinsics.areEqual(this.color, indicator.color) && Intrinsics.areEqual(this.strokeColor, indicator.strokeColor) && Intrinsics.areEqual(this.strokeWidth, indicator.strokeWidth);
            }

            public final /* synthetic */ ColorScheme getColor() {
                return this.color;
            }

            /* JADX INFO: renamed from: getHeight-pVg5ArA, reason: not valid java name */
            public final /* synthetic */ int m587getHeightpVg5ArA() {
                return this.height;
            }

            public final /* synthetic */ ColorScheme getStrokeColor() {
                return this.strokeColor;
            }

            /* JADX INFO: renamed from: getStrokeWidth-0hXNFcg, reason: not valid java name */
            public final /* synthetic */ UInt m588getStrokeWidth0hXNFcg() {
                return this.strokeWidth;
            }

            /* JADX INFO: renamed from: getWidth-pVg5ArA, reason: not valid java name */
            public final /* synthetic */ int m589getWidthpVg5ArA() {
                return this.width;
            }

            public int hashCode() {
                int iHashCode = ((((this.width * 31) + this.height) * 31) + this.color.hashCode()) * 31;
                ColorScheme colorScheme = this.strokeColor;
                int iHashCode2 = (iHashCode + (colorScheme == null ? 0 : colorScheme.hashCode())) * 31;
                UInt uInt = this.strokeWidth;
                return iHashCode2 + (uInt != null ? UInt.d(uInt.f()) : 0);
            }

            public String toString() {
                return "Indicator(width=" + ((Object) UInt.e(this.width)) + ", height=" + ((Object) UInt.e(this.height)) + ", color=" + this.color + ", strokeColor=" + this.strokeColor + ", strokeWidth=" + this.strokeWidth + ')';
            }

            @Deprecated
            public /* synthetic */ Indicator(int i3, UInt uInt, UInt uInt2, ColorScheme colorScheme, @SerialName ColorScheme colorScheme2, @SerialName UInt uInt3, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
                this(i3, uInt, uInt2, colorScheme, colorScheme2, uInt3, serializationConstructorMarker);
            }

            private Indicator(int i3, int i4, ColorScheme color, ColorScheme colorScheme, UInt uInt) {
                Intrinsics.checkNotNullParameter(color, "color");
                this.width = i3;
                this.height = i4;
                this.color = color;
                this.strokeColor = colorScheme;
                this.strokeWidth = uInt;
            }

            private Indicator(int i3, UInt uInt, UInt uInt2, ColorScheme colorScheme, ColorScheme colorScheme2, UInt uInt3, SerializationConstructorMarker serializationConstructorMarker) {
                if (7 != (i3 & 7)) {
                    PluginExceptionsKt.b(i3, 7, CarouselComponent$PageControl$Indicator$$serializer.INSTANCE.getDescriptor());
                }
                this.width = uInt.f();
                this.height = uInt2.f();
                this.color = colorScheme;
                if ((i3 & 8) == 0) {
                    this.strokeColor = null;
                } else {
                    this.strokeColor = colorScheme2;
                }
                if ((i3 & 16) == 0) {
                    this.strokeWidth = null;
                } else {
                    this.strokeWidth = uInt3;
                }
            }

            public /* synthetic */ Indicator(int i3, int i4, ColorScheme colorScheme, ColorScheme colorScheme2, UInt uInt, int i5, DefaultConstructorMarker defaultConstructorMarker) {
                this(i3, i4, colorScheme, (i5 & 8) != 0 ? null : colorScheme2, (i5 & 16) != 0 ? null : uInt, null);
            }

            @SerialName
            public static /* synthetic */ void getStrokeColor$annotations() {
            }

            @SerialName
            /* JADX INFO: renamed from: getStrokeWidth-0hXNFcg$annotations, reason: not valid java name */
            public static /* synthetic */ void m586getStrokeWidth0hXNFcg$annotations() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable(with = CarouselPageControlPositionDeserializer.class)
        public enum Position {
            TOP,
            BOTTOM;

            public static final Companion Companion = new Companion(null);

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<Position> serializer() {
                    return CarouselPageControlPositionDeserializer.INSTANCE;
                }

                private Companion() {
                }
            }
        }

        @Deprecated
        public /* synthetic */ PageControl(int i3, Position position, Integer num, Padding padding, Padding padding2, @SerialName ColorScheme colorScheme, Shape shape, Border border, Shadow shadow, Indicator indicator, Indicator indicator2, SerializationConstructorMarker serializationConstructorMarker) {
            if (769 != (i3 & 769)) {
                PluginExceptionsKt.b(i3, 769, CarouselComponent$PageControl$$serializer.INSTANCE.getDescriptor());
            }
            this.position = position;
            if ((i3 & 2) == 0) {
                this.spacing = null;
            } else {
                this.spacing = num;
            }
            if ((i3 & 4) == 0) {
                this.padding = Padding.Companion.getZero();
            } else {
                this.padding = padding;
            }
            if ((i3 & 8) == 0) {
                this.margin = Padding.Companion.getZero();
            } else {
                this.margin = padding2;
            }
            if ((i3 & 16) == 0) {
                this.backgroundColor = null;
            } else {
                this.backgroundColor = colorScheme;
            }
            if ((i3 & 32) == 0) {
                this.shape = null;
            } else {
                this.shape = shape;
            }
            if ((i3 & 64) == 0) {
                this.border = null;
            } else {
                this.border = border;
            }
            if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
                this.shadow = null;
            } else {
                this.shadow = shadow;
            }
            this.active = indicator;
            this.f1default = indicator2;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PageControl pageControl, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            compositeEncoder.C(serialDescriptor, 0, CarouselPageControlPositionDeserializer.INSTANCE, pageControl.position);
            if (compositeEncoder.z(serialDescriptor, 1) || pageControl.spacing != null) {
                compositeEncoder.i(serialDescriptor, 1, IntSerializer.f142823a, pageControl.spacing);
            }
            if (compositeEncoder.z(serialDescriptor, 2) || !Intrinsics.areEqual(pageControl.padding, Padding.Companion.getZero())) {
                compositeEncoder.C(serialDescriptor, 2, Padding$$serializer.INSTANCE, pageControl.padding);
            }
            if (compositeEncoder.z(serialDescriptor, 3) || !Intrinsics.areEqual(pageControl.margin, Padding.Companion.getZero())) {
                compositeEncoder.C(serialDescriptor, 3, Padding$$serializer.INSTANCE, pageControl.margin);
            }
            if (compositeEncoder.z(serialDescriptor, 4) || pageControl.backgroundColor != null) {
                compositeEncoder.i(serialDescriptor, 4, ColorScheme$$serializer.INSTANCE, pageControl.backgroundColor);
            }
            if (compositeEncoder.z(serialDescriptor, 5) || pageControl.shape != null) {
                compositeEncoder.i(serialDescriptor, 5, ShapeDeserializer.INSTANCE, pageControl.shape);
            }
            if (compositeEncoder.z(serialDescriptor, 6) || pageControl.border != null) {
                compositeEncoder.i(serialDescriptor, 6, Border$$serializer.INSTANCE, pageControl.border);
            }
            if (compositeEncoder.z(serialDescriptor, 7) || pageControl.shadow != null) {
                compositeEncoder.i(serialDescriptor, 7, Shadow$$serializer.INSTANCE, pageControl.shadow);
            }
            CarouselComponent$PageControl$Indicator$$serializer carouselComponent$PageControl$Indicator$$serializer = CarouselComponent$PageControl$Indicator$$serializer.INSTANCE;
            compositeEncoder.C(serialDescriptor, 8, carouselComponent$PageControl$Indicator$$serializer, pageControl.active);
            compositeEncoder.C(serialDescriptor, 9, carouselComponent$PageControl$Indicator$$serializer, pageControl.f1default);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PageControl)) {
                return false;
            }
            PageControl pageControl = (PageControl) obj;
            return this.position == pageControl.position && Intrinsics.areEqual(this.spacing, pageControl.spacing) && Intrinsics.areEqual(this.padding, pageControl.padding) && Intrinsics.areEqual(this.margin, pageControl.margin) && Intrinsics.areEqual(this.backgroundColor, pageControl.backgroundColor) && Intrinsics.areEqual(this.shape, pageControl.shape) && Intrinsics.areEqual(this.border, pageControl.border) && Intrinsics.areEqual(this.shadow, pageControl.shadow) && Intrinsics.areEqual(this.active, pageControl.active) && Intrinsics.areEqual(this.f1default, pageControl.f1default);
        }

        public final /* synthetic */ Indicator getActive() {
            return this.active;
        }

        public final /* synthetic */ ColorScheme getBackgroundColor() {
            return this.backgroundColor;
        }

        public final /* synthetic */ Border getBorder() {
            return this.border;
        }

        public final /* synthetic */ Indicator getDefault() {
            return this.f1default;
        }

        public final /* synthetic */ Padding getMargin() {
            return this.margin;
        }

        public final /* synthetic */ Padding getPadding() {
            return this.padding;
        }

        public final /* synthetic */ Position getPosition() {
            return this.position;
        }

        public final /* synthetic */ Shadow getShadow() {
            return this.shadow;
        }

        public final /* synthetic */ Shape getShape() {
            return this.shape;
        }

        public final /* synthetic */ Integer getSpacing() {
            return this.spacing;
        }

        public int hashCode() {
            int iHashCode = this.position.hashCode() * 31;
            Integer num = this.spacing;
            int iHashCode2 = (((((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + this.padding.hashCode()) * 31) + this.margin.hashCode()) * 31;
            ColorScheme colorScheme = this.backgroundColor;
            int iHashCode3 = (iHashCode2 + (colorScheme == null ? 0 : colorScheme.hashCode())) * 31;
            Shape shape = this.shape;
            int iHashCode4 = (iHashCode3 + (shape == null ? 0 : shape.hashCode())) * 31;
            Border border = this.border;
            int iHashCode5 = (iHashCode4 + (border == null ? 0 : border.hashCode())) * 31;
            Shadow shadow = this.shadow;
            return ((((iHashCode5 + (shadow != null ? shadow.hashCode() : 0)) * 31) + this.active.hashCode()) * 31) + this.f1default.hashCode();
        }

        public String toString() {
            return "PageControl(position=" + this.position + ", spacing=" + this.spacing + ", padding=" + this.padding + ", margin=" + this.margin + ", backgroundColor=" + this.backgroundColor + ", shape=" + this.shape + ", border=" + this.border + ", shadow=" + this.shadow + ", active=" + this.active + ", default=" + this.f1default + ')';
        }

        public PageControl(Position position, Integer num, Padding padding, Padding margin, ColorScheme colorScheme, Shape shape, Border border, Shadow shadow, Indicator active, Indicator indicator) {
            Intrinsics.checkNotNullParameter(position, "position");
            Intrinsics.checkNotNullParameter(padding, "padding");
            Intrinsics.checkNotNullParameter(margin, "margin");
            Intrinsics.checkNotNullParameter(active, "active");
            Intrinsics.checkNotNullParameter(indicator, "default");
            this.position = position;
            this.spacing = num;
            this.padding = padding;
            this.margin = margin;
            this.backgroundColor = colorScheme;
            this.shape = shape;
            this.border = border;
            this.shadow = shadow;
            this.active = active;
            this.f1default = indicator;
        }

        @SerialName
        public static /* synthetic */ void getBackgroundColor$annotations() {
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ PageControl(Position position, Integer num, Padding padding, Padding padding2, ColorScheme colorScheme, Shape shape, Border border, Shadow shadow, Indicator indicator, Indicator indicator2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            Indicator indicator3;
            Indicator indicator4;
            Shadow shadow2;
            num = (i3 & 2) != 0 ? null : num;
            padding = (i3 & 4) != 0 ? Padding.Companion.getZero() : padding;
            padding2 = (i3 & 8) != 0 ? Padding.Companion.getZero() : padding2;
            colorScheme = (i3 & 16) != 0 ? null : colorScheme;
            shape = (i3 & 32) != 0 ? null : shape;
            border = (i3 & 64) != 0 ? null : border;
            if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
                indicator3 = indicator2;
                indicator4 = indicator;
                shadow2 = null;
            } else {
                indicator3 = indicator2;
                indicator4 = indicator;
                shadow2 = shadow;
            }
            this(position, num, padding, padding2, colorScheme, shape, border, shadow2, indicator4, indicator3);
        }
    }

    public CarouselComponent(List<StackComponent> pages, Boolean bool, Integer num, VerticalAlignment pageAlignment, Size size, Integer num2, Float f3, ColorScheme colorScheme, Background background, Padding padding, Padding margin, Shape shape, Border border, Shadow shadow, PageControl pageControl, Boolean bool2, AutoAdvancePages autoAdvancePages, List<ComponentOverride<PartialCarouselComponent>> overrides, String str) {
        Intrinsics.checkNotNullParameter(pages, "pages");
        Intrinsics.checkNotNullParameter(pageAlignment, "pageAlignment");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        this.pages = pages;
        this.visible = bool;
        this.initialPageIndex = num;
        this.pageAlignment = pageAlignment;
        this.size = size;
        this.pagePeek = num2;
        this.pageSpacing = f3;
        this.backgroundColor = colorScheme;
        this.background = background;
        this.padding = padding;
        this.margin = margin;
        this.shape = shape;
        this.border = border;
        this.shadow = shadow;
        this.pageControl = pageControl;
        this.loop = bool2;
        this.autoAdvance = autoAdvancePages;
        this.overrides = overrides;
        this.name = str;
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

    public /* synthetic */ CarouselComponent(List list, Boolean bool, Integer num, VerticalAlignment verticalAlignment, Size size, Integer num2, Float f3, ColorScheme colorScheme, Background background, Padding padding, Padding padding2, Shape shape, Border border, Shadow shadow, PageControl pageControl, Boolean bool2, AutoAdvancePages autoAdvancePages, List list2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        Size size2;
        Boolean bool3 = (i3 & 2) != 0 ? null : bool;
        Integer num3 = (i3 & 4) != 0 ? null : num;
        if ((i3 & 16) != 0) {
            SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
            size2 = new Size(fit, fit);
        } else {
            size2 = size;
        }
        this(list, bool3, num3, verticalAlignment, size2, (i3 & 32) != 0 ? null : num2, (i3 & 64) != 0 ? null : f3, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : colorScheme, (i3 & Function.MAX_NARGS) != 0 ? null : background, (i3 & 512) != 0 ? Padding.Companion.getZero() : padding, (i3 & 1024) != 0 ? Padding.Companion.getZero() : padding2, (i3 & 2048) != 0 ? null : shape, (i3 & 4096) != 0 ? null : border, (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? null : shadow, (i3 & 16384) != 0 ? null : pageControl, (32768 & i3) != 0 ? null : bool2, (65536 & i3) != 0 ? null : autoAdvancePages, (131072 & i3) != 0 ? CollectionsKt.emptyList() : list2, (i3 & 262144) != 0 ? null : str);
    }
}
