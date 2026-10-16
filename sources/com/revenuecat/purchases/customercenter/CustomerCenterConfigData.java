package com.revenuecat.purchases.customercenter;

import androidx.appcompat.app.jE.vxrlPPpdv;
import androidx.media3.common.JBEE.bfIdKSjLOVjG;
import com.facebook.AuthenticationTokenClaims;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer;
import com.revenuecat.purchases.paywalls.PaywallColor;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallLegacyComponentInteraction;
import com.sun.jna.Function;
import java.lang.annotation.Annotation;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
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
@Metadata
@Serializable
public final class CustomerCenterConfigData {
    public static final Companion Companion = new Companion(null);
    private final Appearance appearance;
    private final String lastPublishedAppVersion;
    private final Localization localization;
    private final Map<Screen.ScreenType, Screen> screens;
    private final Support support;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class Appearance {
        public static final Companion Companion = new Companion(null);
        private final ColorInformation dark;
        private final ColorInformation light;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class ColorInformation {
            public static final Companion Companion = new Companion(null);
            private final PaywallColor accentColor;
            private final PaywallColor backgroundColor;
            private final PaywallColor buttonBackgroundColor;
            private final PaywallColor buttonTextColor;
            private final PaywallColor textColor;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<ColorInformation> serializer() {
                    return CustomerCenterConfigData$Appearance$ColorInformation$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            public ColorInformation() {
                this((PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, 31, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ ColorInformation copy$default(ColorInformation colorInformation, PaywallColor paywallColor, PaywallColor paywallColor2, PaywallColor paywallColor3, PaywallColor paywallColor4, PaywallColor paywallColor5, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    paywallColor = colorInformation.accentColor;
                }
                if ((i3 & 2) != 0) {
                    paywallColor2 = colorInformation.textColor;
                }
                if ((i3 & 4) != 0) {
                    paywallColor3 = colorInformation.backgroundColor;
                }
                if ((i3 & 8) != 0) {
                    paywallColor4 = colorInformation.buttonTextColor;
                }
                if ((i3 & 16) != 0) {
                    paywallColor5 = colorInformation.buttonBackgroundColor;
                }
                PaywallColor paywallColor6 = paywallColor5;
                PaywallColor paywallColor7 = paywallColor3;
                return colorInformation.copy(paywallColor, paywallColor2, paywallColor7, paywallColor4, paywallColor6);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(ColorInformation colorInformation, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                if (compositeEncoder.z(serialDescriptor, 0) || colorInformation.accentColor != null) {
                    compositeEncoder.i(serialDescriptor, 0, PaywallColor.Serializer.INSTANCE, colorInformation.accentColor);
                }
                if (compositeEncoder.z(serialDescriptor, 1) || colorInformation.textColor != null) {
                    compositeEncoder.i(serialDescriptor, 1, PaywallColor.Serializer.INSTANCE, colorInformation.textColor);
                }
                if (compositeEncoder.z(serialDescriptor, 2) || colorInformation.backgroundColor != null) {
                    compositeEncoder.i(serialDescriptor, 2, PaywallColor.Serializer.INSTANCE, colorInformation.backgroundColor);
                }
                if (compositeEncoder.z(serialDescriptor, 3) || colorInformation.buttonTextColor != null) {
                    compositeEncoder.i(serialDescriptor, 3, PaywallColor.Serializer.INSTANCE, colorInformation.buttonTextColor);
                }
                if (!compositeEncoder.z(serialDescriptor, 4) && colorInformation.buttonBackgroundColor == null) {
                    return;
                }
                compositeEncoder.i(serialDescriptor, 4, PaywallColor.Serializer.INSTANCE, colorInformation.buttonBackgroundColor);
            }

            public final PaywallColor component1() {
                return this.accentColor;
            }

            public final PaywallColor component2() {
                return this.textColor;
            }

            public final PaywallColor component3() {
                return this.backgroundColor;
            }

            public final PaywallColor component4() {
                return this.buttonTextColor;
            }

            public final PaywallColor component5() {
                return this.buttonBackgroundColor;
            }

            public final ColorInformation copy(PaywallColor paywallColor, PaywallColor paywallColor2, PaywallColor paywallColor3, PaywallColor paywallColor4, PaywallColor paywallColor5) {
                return new ColorInformation(paywallColor, paywallColor2, paywallColor3, paywallColor4, paywallColor5);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ColorInformation)) {
                    return false;
                }
                ColorInformation colorInformation = (ColorInformation) obj;
                return Intrinsics.areEqual(this.accentColor, colorInformation.accentColor) && Intrinsics.areEqual(this.textColor, colorInformation.textColor) && Intrinsics.areEqual(this.backgroundColor, colorInformation.backgroundColor) && Intrinsics.areEqual(this.buttonTextColor, colorInformation.buttonTextColor) && Intrinsics.areEqual(this.buttonBackgroundColor, colorInformation.buttonBackgroundColor);
            }

            public final PaywallColor getAccentColor() {
                return this.accentColor;
            }

            public final PaywallColor getBackgroundColor() {
                return this.backgroundColor;
            }

            public final PaywallColor getButtonBackgroundColor() {
                return this.buttonBackgroundColor;
            }

            public final PaywallColor getButtonTextColor() {
                return this.buttonTextColor;
            }

            public final PaywallColor getTextColor() {
                return this.textColor;
            }

            public int hashCode() {
                PaywallColor paywallColor = this.accentColor;
                int iHashCode = (paywallColor == null ? 0 : paywallColor.hashCode()) * 31;
                PaywallColor paywallColor2 = this.textColor;
                int iHashCode2 = (iHashCode + (paywallColor2 == null ? 0 : paywallColor2.hashCode())) * 31;
                PaywallColor paywallColor3 = this.backgroundColor;
                int iHashCode3 = (iHashCode2 + (paywallColor3 == null ? 0 : paywallColor3.hashCode())) * 31;
                PaywallColor paywallColor4 = this.buttonTextColor;
                int iHashCode4 = (iHashCode3 + (paywallColor4 == null ? 0 : paywallColor4.hashCode())) * 31;
                PaywallColor paywallColor5 = this.buttonBackgroundColor;
                return iHashCode4 + (paywallColor5 != null ? paywallColor5.hashCode() : 0);
            }

            public String toString() {
                return "ColorInformation(accentColor=" + this.accentColor + ", textColor=" + this.textColor + ", backgroundColor=" + this.backgroundColor + ", buttonTextColor=" + this.buttonTextColor + ", buttonBackgroundColor=" + this.buttonBackgroundColor + ')';
            }

            @Deprecated
            public /* synthetic */ ColorInformation(int i3, @SerialName @Serializable(with = PaywallColor.Serializer.class) PaywallColor paywallColor, @SerialName @Serializable(with = PaywallColor.Serializer.class) PaywallColor paywallColor2, @SerialName @Serializable(with = PaywallColor.Serializer.class) PaywallColor paywallColor3, @SerialName @Serializable(with = PaywallColor.Serializer.class) PaywallColor paywallColor4, @SerialName @Serializable(with = PaywallColor.Serializer.class) PaywallColor paywallColor5, SerializationConstructorMarker serializationConstructorMarker) {
                if ((i3 & 1) == 0) {
                    this.accentColor = null;
                } else {
                    this.accentColor = paywallColor;
                }
                if ((i3 & 2) == 0) {
                    this.textColor = null;
                } else {
                    this.textColor = paywallColor2;
                }
                if ((i3 & 4) == 0) {
                    this.backgroundColor = null;
                } else {
                    this.backgroundColor = paywallColor3;
                }
                if ((i3 & 8) == 0) {
                    this.buttonTextColor = null;
                } else {
                    this.buttonTextColor = paywallColor4;
                }
                if ((i3 & 16) == 0) {
                    this.buttonBackgroundColor = null;
                } else {
                    this.buttonBackgroundColor = paywallColor5;
                }
            }

            public ColorInformation(PaywallColor paywallColor, PaywallColor paywallColor2, PaywallColor paywallColor3, PaywallColor paywallColor4, PaywallColor paywallColor5) {
                this.accentColor = paywallColor;
                this.textColor = paywallColor2;
                this.backgroundColor = paywallColor3;
                this.buttonTextColor = paywallColor4;
                this.buttonBackgroundColor = paywallColor5;
            }

            public /* synthetic */ ColorInformation(PaywallColor paywallColor, PaywallColor paywallColor2, PaywallColor paywallColor3, PaywallColor paywallColor4, PaywallColor paywallColor5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this((i3 & 1) != 0 ? null : paywallColor, (i3 & 2) != 0 ? null : paywallColor2, (i3 & 4) != 0 ? null : paywallColor3, (i3 & 8) != 0 ? null : paywallColor4, (i3 & 16) != 0 ? null : paywallColor5);
            }

            @SerialName
            @Serializable(with = PaywallColor.Serializer.class)
            public static /* synthetic */ void getAccentColor$annotations() {
            }

            @SerialName
            @Serializable(with = PaywallColor.Serializer.class)
            public static /* synthetic */ void getBackgroundColor$annotations() {
            }

            @SerialName
            @Serializable(with = PaywallColor.Serializer.class)
            public static /* synthetic */ void getButtonBackgroundColor$annotations() {
            }

            @SerialName
            @Serializable(with = PaywallColor.Serializer.class)
            public static /* synthetic */ void getButtonTextColor$annotations() {
            }

            @SerialName
            @Serializable(with = PaywallColor.Serializer.class)
            public static /* synthetic */ void getTextColor$annotations() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Appearance> serializer() {
                return CustomerCenterConfigData$Appearance$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Appearance() {
            this((ColorInformation) null, (ColorInformation) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }

        public static /* synthetic */ Appearance copy$default(Appearance appearance, ColorInformation colorInformation, ColorInformation colorInformation2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                colorInformation = appearance.light;
            }
            if ((i3 & 2) != 0) {
                colorInformation2 = appearance.dark;
            }
            return appearance.copy(colorInformation, colorInformation2);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Appearance appearance, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            if (compositeEncoder.z(serialDescriptor, 0) || appearance.light != null) {
                compositeEncoder.i(serialDescriptor, 0, CustomerCenterConfigData$Appearance$ColorInformation$$serializer.INSTANCE, appearance.light);
            }
            if (!compositeEncoder.z(serialDescriptor, 1) && appearance.dark == null) {
                return;
            }
            compositeEncoder.i(serialDescriptor, 1, CustomerCenterConfigData$Appearance$ColorInformation$$serializer.INSTANCE, appearance.dark);
        }

        public final ColorInformation component1() {
            return this.light;
        }

        public final ColorInformation component2() {
            return this.dark;
        }

        public final Appearance copy(ColorInformation colorInformation, ColorInformation colorInformation2) {
            return new Appearance(colorInformation, colorInformation2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Appearance)) {
                return false;
            }
            Appearance appearance = (Appearance) obj;
            return Intrinsics.areEqual(this.light, appearance.light) && Intrinsics.areEqual(this.dark, appearance.dark);
        }

        public final ColorInformation getDark() {
            return this.dark;
        }

        public final ColorInformation getLight() {
            return this.light;
        }

        public int hashCode() {
            ColorInformation colorInformation = this.light;
            int iHashCode = (colorInformation == null ? 0 : colorInformation.hashCode()) * 31;
            ColorInformation colorInformation2 = this.dark;
            return iHashCode + (colorInformation2 != null ? colorInformation2.hashCode() : 0);
        }

        public String toString() {
            return "Appearance(light=" + this.light + ", dark=" + this.dark + ')';
        }

        @Deprecated
        public /* synthetic */ Appearance(int i3, ColorInformation colorInformation, ColorInformation colorInformation2, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i3 & 1) == 0) {
                this.light = null;
            } else {
                this.light = colorInformation;
            }
            if ((i3 & 2) == 0) {
                this.dark = null;
            } else {
                this.dark = colorInformation2;
            }
        }

        public Appearance(ColorInformation colorInformation, ColorInformation colorInformation2) {
            this.light = colorInformation;
            this.dark = colorInformation2;
        }

        public /* synthetic */ Appearance(ColorInformation colorInformation, ColorInformation colorInformation2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : colorInformation, (i3 & 2) != 0 ? null : colorInformation2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<CustomerCenterConfigData> serializer() {
            return CustomerCenterConfigData$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class HelpPath {
        private final String actionIdentifier;
        private final PathDetail.FeedbackSurvey feedbackSurvey;
        private final String id;
        private final OpenMethod openMethod;
        private final PathDetail.PromotionalOffer promotionalOffer;
        private final String title;
        private final PathType type;
        private final String url;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, null, PathType.Companion.serializer(), null, null, null, OpenMethod.Companion.serializer(), null};

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<HelpPath> serializer() {
                return CustomerCenterConfigData$HelpPath$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public enum OpenMethod {
            IN_APP,
            EXTERNAL;

            public static final Companion Companion = new Companion(null);
            private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.customercenter.CustomerCenterConfigData.HelpPath.OpenMethod.Companion.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer<Object> invoke() {
                    return EnumsKt.b("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.HelpPath.OpenMethod", OpenMethod.values());
                }
            });

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private final /* synthetic */ KSerializer get$cachedSerializer() {
                    return (KSerializer) OpenMethod.$cachedSerializer$delegate.getValue();
                }

                public final KSerializer<OpenMethod> serializer() {
                    return get$cachedSerializer();
                }

                private Companion() {
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static abstract class PathDetail {
            public static final Companion Companion = new Companion(null);
            private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.customercenter.CustomerCenterConfigData.HelpPath.PathDetail.Companion.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer<Object> invoke() {
                    return new SealedClassSerializer("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.HelpPath.PathDetail", Reflection.b(PathDetail.class), new KClass[]{Reflection.b(FeedbackSurvey.class), Reflection.b(PromotionalOffer.class)}, new KSerializer[]{CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$$serializer.INSTANCE, CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer.INSTANCE}, new Annotation[0]);
                }
            });

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private final /* synthetic */ KSerializer get$cachedSerializer() {
                    return (KSerializer) PathDetail.$cachedSerializer$delegate.getValue();
                }

                public final KSerializer<PathDetail> serializer() {
                    return get$cachedSerializer();
                }

                private Companion() {
                }
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @Serializable
            public static final class FeedbackSurvey extends PathDetail {
                private final List<Option> options;
                private final String title;
                public static final Companion Companion = new Companion(null);
                private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$Option$$serializer.INSTANCE)};

                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    public final KSerializer<FeedbackSurvey> serializer() {
                        return CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$$serializer.INSTANCE;
                    }

                    private Companion() {
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @Serializable
                public static final class Option {
                    public static final Companion Companion = new Companion(null);
                    private final String id;
                    private final PromotionalOffer promotionalOffer;
                    private final String title;

                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    @Metadata
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        public final KSerializer<Option> serializer() {
                            return CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$Option$$serializer.INSTANCE;
                        }

                        private Companion() {
                        }
                    }

                    @Deprecated
                    public /* synthetic */ Option(int i3, String str, String str2, @SerialName PromotionalOffer promotionalOffer, SerializationConstructorMarker serializationConstructorMarker) {
                        if (3 != (i3 & 3)) {
                            PluginExceptionsKt.b(i3, 3, CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$Option$$serializer.INSTANCE.getDescriptor());
                        }
                        this.id = str;
                        this.title = str2;
                        if ((i3 & 4) == 0) {
                            this.promotionalOffer = null;
                        } else {
                            this.promotionalOffer = promotionalOffer;
                        }
                    }

                    public static /* synthetic */ Option copy$default(Option option, String str, String str2, PromotionalOffer promotionalOffer, int i3, Object obj) {
                        if ((i3 & 1) != 0) {
                            str = option.id;
                        }
                        if ((i3 & 2) != 0) {
                            str2 = option.title;
                        }
                        if ((i3 & 4) != 0) {
                            promotionalOffer = option.promotionalOffer;
                        }
                        return option.copy(str, str2, promotionalOffer);
                    }

                    @JvmStatic
                    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Option option, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                        compositeEncoder.y(serialDescriptor, 0, option.id);
                        compositeEncoder.y(serialDescriptor, 1, option.title);
                        if (!compositeEncoder.z(serialDescriptor, 2) && option.promotionalOffer == null) {
                            return;
                        }
                        compositeEncoder.i(serialDescriptor, 2, CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer.INSTANCE, option.promotionalOffer);
                    }

                    public final String component1() {
                        return this.id;
                    }

                    public final String component2() {
                        return this.title;
                    }

                    public final PromotionalOffer component3() {
                        return this.promotionalOffer;
                    }

                    public final Option copy(String id, String title, PromotionalOffer promotionalOffer) {
                        Intrinsics.checkNotNullParameter(id, "id");
                        Intrinsics.checkNotNullParameter(title, "title");
                        return new Option(id, title, promotionalOffer);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (!(obj instanceof Option)) {
                            return false;
                        }
                        Option option = (Option) obj;
                        return Intrinsics.areEqual(this.id, option.id) && Intrinsics.areEqual(this.title, option.title) && Intrinsics.areEqual(this.promotionalOffer, option.promotionalOffer);
                    }

                    public final String getId() {
                        return this.id;
                    }

                    public final PromotionalOffer getPromotionalOffer() {
                        return this.promotionalOffer;
                    }

                    public final String getTitle() {
                        return this.title;
                    }

                    public int hashCode() {
                        int iHashCode = ((this.id.hashCode() * 31) + this.title.hashCode()) * 31;
                        PromotionalOffer promotionalOffer = this.promotionalOffer;
                        return iHashCode + (promotionalOffer == null ? 0 : promotionalOffer.hashCode());
                    }

                    public String toString() {
                        return "Option(id=" + this.id + ", title=" + this.title + ", promotionalOffer=" + this.promotionalOffer + ')';
                    }

                    public Option(String id, String title, PromotionalOffer promotionalOffer) {
                        Intrinsics.checkNotNullParameter(id, "id");
                        Intrinsics.checkNotNullParameter(title, "title");
                        this.id = id;
                        this.title = title;
                        this.promotionalOffer = promotionalOffer;
                    }

                    public /* synthetic */ Option(String str, String str2, PromotionalOffer promotionalOffer, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                        this(str, str2, (i3 & 4) != 0 ? null : promotionalOffer);
                    }

                    @SerialName
                    public static /* synthetic */ void getPromotionalOffer$annotations() {
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                @Deprecated
                public /* synthetic */ FeedbackSurvey(int i3, String str, List list, SerializationConstructorMarker serializationConstructorMarker) {
                    super(i3, serializationConstructorMarker);
                    if (3 != (i3 & 3)) {
                        PluginExceptionsKt.b(i3, 3, CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$$serializer.INSTANCE.getDescriptor());
                    }
                    this.title = str;
                    this.options = list;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ FeedbackSurvey copy$default(FeedbackSurvey feedbackSurvey, String str, List list, int i3, Object obj) {
                    if ((i3 & 1) != 0) {
                        str = feedbackSurvey.title;
                    }
                    if ((i3 & 2) != 0) {
                        list = feedbackSurvey.options;
                    }
                    return feedbackSurvey.copy(str, list);
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(FeedbackSurvey feedbackSurvey, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                    PathDetail.write$Self(feedbackSurvey, compositeEncoder, serialDescriptor);
                    KSerializer<Object>[] kSerializerArr = $childSerializers;
                    compositeEncoder.y(serialDescriptor, 0, feedbackSurvey.title);
                    compositeEncoder.C(serialDescriptor, 1, kSerializerArr[1], feedbackSurvey.options);
                }

                public final String component1() {
                    return this.title;
                }

                public final List<Option> component2() {
                    return this.options;
                }

                public final FeedbackSurvey copy(String title, List<Option> options) {
                    Intrinsics.checkNotNullParameter(title, "title");
                    Intrinsics.checkNotNullParameter(options, "options");
                    return new FeedbackSurvey(title, options);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof FeedbackSurvey)) {
                        return false;
                    }
                    FeedbackSurvey feedbackSurvey = (FeedbackSurvey) obj;
                    return Intrinsics.areEqual(this.title, feedbackSurvey.title) && Intrinsics.areEqual(this.options, feedbackSurvey.options);
                }

                public final List<Option> getOptions() {
                    return this.options;
                }

                public final String getTitle() {
                    return this.title;
                }

                public int hashCode() {
                    return (this.title.hashCode() * 31) + this.options.hashCode();
                }

                public String toString() {
                    return "FeedbackSurvey(title=" + this.title + ", options=" + this.options + ')';
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public FeedbackSurvey(String title, List<Option> options) {
                    super(null);
                    Intrinsics.checkNotNullParameter(title, "title");
                    Intrinsics.checkNotNullParameter(options, "options");
                    this.title = title;
                    this.options = options;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @Serializable
            public static final class PromotionalOffer extends PathDetail {
                private static final KSerializer<Object>[] $childSerializers;
                public static final Companion Companion = new Companion(null);
                private final String androidOfferId;
                private final Map<String, CrossProductPromotion> crossProductPromotions;
                private final boolean eligible;
                private final Map<String, String> productMapping;
                private final String subtitle;
                private final String title;

                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    public final KSerializer<PromotionalOffer> serializer() {
                        return CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer.INSTANCE;
                    }

                    private Companion() {
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @Serializable
                public static final class CrossProductPromotion {
                    public static final Companion Companion = new Companion(null);
                    private final String storeOfferIdentifier;
                    private final String targetProductId;

                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    @Metadata
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        public final KSerializer<CrossProductPromotion> serializer() {
                            return CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$CrossProductPromotion$$serializer.INSTANCE;
                        }

                        private Companion() {
                        }
                    }

                    @Deprecated
                    public /* synthetic */ CrossProductPromotion(int i3, @SerialName String str, @SerialName String str2, SerializationConstructorMarker serializationConstructorMarker) {
                        if (3 != (i3 & 3)) {
                            PluginExceptionsKt.b(i3, 3, CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$CrossProductPromotion$$serializer.INSTANCE.getDescriptor());
                        }
                        this.storeOfferIdentifier = str;
                        this.targetProductId = str2;
                    }

                    @JvmStatic
                    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(CrossProductPromotion crossProductPromotion, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                        compositeEncoder.y(serialDescriptor, 0, crossProductPromotion.storeOfferIdentifier);
                        compositeEncoder.y(serialDescriptor, 1, crossProductPromotion.targetProductId);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (!(obj instanceof CrossProductPromotion)) {
                            return false;
                        }
                        CrossProductPromotion crossProductPromotion = (CrossProductPromotion) obj;
                        return Intrinsics.areEqual(this.storeOfferIdentifier, crossProductPromotion.storeOfferIdentifier) && Intrinsics.areEqual(this.targetProductId, crossProductPromotion.targetProductId);
                    }

                    public final String getStoreOfferIdentifier() {
                        return this.storeOfferIdentifier;
                    }

                    public final String getTargetProductId() {
                        return this.targetProductId;
                    }

                    public int hashCode() {
                        return (this.storeOfferIdentifier.hashCode() * 31) + this.targetProductId.hashCode();
                    }

                    public String toString() {
                        return "CrossProductPromotion(storeOfferIdentifier=" + this.storeOfferIdentifier + ", targetProductId=" + this.targetProductId + ')';
                    }

                    public CrossProductPromotion(String storeOfferIdentifier, String targetProductId) {
                        Intrinsics.checkNotNullParameter(storeOfferIdentifier, "storeOfferIdentifier");
                        Intrinsics.checkNotNullParameter(targetProductId, "targetProductId");
                        this.storeOfferIdentifier = storeOfferIdentifier;
                        this.targetProductId = targetProductId;
                    }

                    @SerialName
                    public static /* synthetic */ void getStoreOfferIdentifier$annotations() {
                    }

                    @SerialName
                    public static /* synthetic */ void getTargetProductId$annotations() {
                    }
                }

                static {
                    StringSerializer stringSerializer = StringSerializer.f142891a;
                    $childSerializers = new KSerializer[]{null, null, null, null, new LinkedHashMapSerializer(stringSerializer, stringSerializer), new LinkedHashMapSerializer(stringSerializer, CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$CrossProductPromotion$$serializer.INSTANCE)};
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                @Deprecated
                public /* synthetic */ PromotionalOffer(int i3, @SerialName String str, boolean z2, String str2, String str3, @SerialName Map map, @SerialName Map map2, SerializationConstructorMarker serializationConstructorMarker) {
                    super(i3, serializationConstructorMarker);
                    if (31 != (i3 & 31)) {
                        PluginExceptionsKt.b(i3, 31, CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer.INSTANCE.getDescriptor());
                    }
                    this.androidOfferId = str;
                    this.eligible = z2;
                    this.title = str2;
                    this.subtitle = str3;
                    this.productMapping = map;
                    if ((i3 & 32) == 0) {
                        this.crossProductPromotions = MapsKt.emptyMap();
                    } else {
                        this.crossProductPromotions = map2;
                    }
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ PromotionalOffer copy$default(PromotionalOffer promotionalOffer, String str, boolean z2, String str2, String str3, Map map, Map map2, int i3, Object obj) {
                    if ((i3 & 1) != 0) {
                        str = promotionalOffer.androidOfferId;
                    }
                    if ((i3 & 2) != 0) {
                        z2 = promotionalOffer.eligible;
                    }
                    if ((i3 & 4) != 0) {
                        str2 = promotionalOffer.title;
                    }
                    if ((i3 & 8) != 0) {
                        str3 = promotionalOffer.subtitle;
                    }
                    if ((i3 & 16) != 0) {
                        map = promotionalOffer.productMapping;
                    }
                    if ((i3 & 32) != 0) {
                        map2 = promotionalOffer.crossProductPromotions;
                    }
                    Map map3 = map;
                    Map map4 = map2;
                    return promotionalOffer.copy(str, z2, str2, str3, map3, map4);
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PromotionalOffer promotionalOffer, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                    PathDetail.write$Self(promotionalOffer, compositeEncoder, serialDescriptor);
                    KSerializer<Object>[] kSerializerArr = $childSerializers;
                    compositeEncoder.y(serialDescriptor, 0, promotionalOffer.androidOfferId);
                    compositeEncoder.x(serialDescriptor, 1, promotionalOffer.eligible);
                    compositeEncoder.y(serialDescriptor, 2, promotionalOffer.title);
                    compositeEncoder.y(serialDescriptor, 3, promotionalOffer.subtitle);
                    compositeEncoder.C(serialDescriptor, 4, kSerializerArr[4], promotionalOffer.productMapping);
                    if (!compositeEncoder.z(serialDescriptor, 5) && Intrinsics.areEqual(promotionalOffer.crossProductPromotions, MapsKt.emptyMap())) {
                        return;
                    }
                    compositeEncoder.C(serialDescriptor, 5, kSerializerArr[5], promotionalOffer.crossProductPromotions);
                }

                public final String component1() {
                    return this.androidOfferId;
                }

                public final boolean component2() {
                    return this.eligible;
                }

                public final String component3() {
                    return this.title;
                }

                public final String component4() {
                    return this.subtitle;
                }

                public final Map<String, String> component5() {
                    return this.productMapping;
                }

                public final Map<String, CrossProductPromotion> component6() {
                    return this.crossProductPromotions;
                }

                public final PromotionalOffer copy(String androidOfferId, boolean z2, String title, String subtitle, Map<String, String> productMapping, Map<String, CrossProductPromotion> crossProductPromotions) {
                    Intrinsics.checkNotNullParameter(androidOfferId, "androidOfferId");
                    Intrinsics.checkNotNullParameter(title, "title");
                    Intrinsics.checkNotNullParameter(subtitle, "subtitle");
                    Intrinsics.checkNotNullParameter(productMapping, "productMapping");
                    Intrinsics.checkNotNullParameter(crossProductPromotions, "crossProductPromotions");
                    return new PromotionalOffer(androidOfferId, z2, title, subtitle, productMapping, crossProductPromotions);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof PromotionalOffer)) {
                        return false;
                    }
                    PromotionalOffer promotionalOffer = (PromotionalOffer) obj;
                    return Intrinsics.areEqual(this.androidOfferId, promotionalOffer.androidOfferId) && this.eligible == promotionalOffer.eligible && Intrinsics.areEqual(this.title, promotionalOffer.title) && Intrinsics.areEqual(this.subtitle, promotionalOffer.subtitle) && Intrinsics.areEqual(this.productMapping, promotionalOffer.productMapping) && Intrinsics.areEqual(this.crossProductPromotions, promotionalOffer.crossProductPromotions);
                }

                public final String getAndroidOfferId() {
                    return this.androidOfferId;
                }

                public final Map<String, CrossProductPromotion> getCrossProductPromotions() {
                    return this.crossProductPromotions;
                }

                public final boolean getEligible() {
                    return this.eligible;
                }

                public final Map<String, String> getProductMapping() {
                    return this.productMapping;
                }

                public final String getSubtitle() {
                    return this.subtitle;
                }

                public final String getTitle() {
                    return this.title;
                }

                public int hashCode() {
                    return (((((((((this.androidOfferId.hashCode() * 31) + Boolean.hashCode(this.eligible)) * 31) + this.title.hashCode()) * 31) + this.subtitle.hashCode()) * 31) + this.productMapping.hashCode()) * 31) + this.crossProductPromotions.hashCode();
                }

                public String toString() {
                    return "PromotionalOffer(androidOfferId=" + this.androidOfferId + ", eligible=" + this.eligible + ", title=" + this.title + ", subtitle=" + this.subtitle + ", productMapping=" + this.productMapping + ", crossProductPromotions=" + this.crossProductPromotions + ')';
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ PromotionalOffer copy$default(PromotionalOffer promotionalOffer, String str, boolean z2, String str2, String str3, Map map, int i3, Object obj) {
                    if ((i3 & 1) != 0) {
                        str = promotionalOffer.androidOfferId;
                    }
                    if ((i3 & 2) != 0) {
                        z2 = promotionalOffer.eligible;
                    }
                    if ((i3 & 4) != 0) {
                        str2 = promotionalOffer.title;
                    }
                    if ((i3 & 8) != 0) {
                        str3 = promotionalOffer.subtitle;
                    }
                    if ((i3 & 16) != 0) {
                        map = promotionalOffer.productMapping;
                    }
                    Map map2 = map;
                    String str4 = str2;
                    return promotionalOffer.copy(str, z2, str4, str3, map2);
                }

                @Deprecated
                public final PromotionalOffer copy(String androidOfferId, boolean z2, String title, String subtitle, Map<String, String> productMapping) {
                    Intrinsics.checkNotNullParameter(androidOfferId, "androidOfferId");
                    Intrinsics.checkNotNullParameter(title, "title");
                    Intrinsics.checkNotNullParameter(subtitle, "subtitle");
                    Intrinsics.checkNotNullParameter(productMapping, "productMapping");
                    return copy(androidOfferId, z2, title, subtitle, productMapping, MapsKt.emptyMap());
                }

                public /* synthetic */ PromotionalOffer(String str, boolean z2, String str2, String str3, Map map, Map map2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                    this(str, z2, str2, str3, map, (i3 & 32) != 0 ? MapsKt.emptyMap() : map2);
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public PromotionalOffer(String androidOfferId, boolean z2, String title, String subtitle, Map<String, String> productMapping, Map<String, CrossProductPromotion> crossProductPromotions) {
                    super(null);
                    Intrinsics.checkNotNullParameter(androidOfferId, "androidOfferId");
                    Intrinsics.checkNotNullParameter(title, "title");
                    Intrinsics.checkNotNullParameter(subtitle, "subtitle");
                    Intrinsics.checkNotNullParameter(productMapping, "productMapping");
                    Intrinsics.checkNotNullParameter(crossProductPromotions, "crossProductPromotions");
                    this.androidOfferId = androidOfferId;
                    this.eligible = z2;
                    this.title = title;
                    this.subtitle = subtitle;
                    this.productMapping = productMapping;
                    this.crossProductPromotions = crossProductPromotions;
                }

                /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
                @Deprecated
                public PromotionalOffer(String androidOfferId, boolean z2, String title, String subtitle, Map<String, String> productMapping) {
                    this(androidOfferId, z2, title, subtitle, productMapping, MapsKt.emptyMap());
                    Intrinsics.checkNotNullParameter(androidOfferId, "androidOfferId");
                    Intrinsics.checkNotNullParameter(title, "title");
                    Intrinsics.checkNotNullParameter(subtitle, "subtitle");
                    Intrinsics.checkNotNullParameter(productMapping, "productMapping");
                }

                @SerialName
                public static /* synthetic */ void getAndroidOfferId$annotations() {
                }

                @SerialName
                public static /* synthetic */ void getCrossProductPromotions$annotations() {
                }

                @SerialName
                public static /* synthetic */ void getProductMapping$annotations() {
                }
            }

            public /* synthetic */ PathDetail(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private PathDetail() {
            }

            @Deprecated
            public /* synthetic */ PathDetail(int i3, SerializationConstructorMarker serializationConstructorMarker) {
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self(PathDetail pathDetail, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public enum PathType {
            MISSING_PURCHASE,
            REFUND_REQUEST,
            CHANGE_PLANS,
            CANCEL,
            CUSTOM_URL,
            CUSTOM_ACTION,
            UNKNOWN;

            public static final Companion Companion = new Companion(null);
            private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.customercenter.CustomerCenterConfigData.HelpPath.PathType.Companion.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer<Object> invoke() {
                    return EnumsKt.b("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.HelpPath.PathType", PathType.values());
                }
            });

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private final /* synthetic */ KSerializer get$cachedSerializer() {
                    return (KSerializer) PathType.$cachedSerializer$delegate.getValue();
                }

                public final KSerializer<PathType> serializer() {
                    return get$cachedSerializer();
                }

                private Companion() {
                }
            }
        }

        @Deprecated
        public /* synthetic */ HelpPath(int i3, String str, String str2, PathType pathType, @SerialName PathDetail.PromotionalOffer promotionalOffer, @SerialName PathDetail.FeedbackSurvey feedbackSurvey, String str3, @SerialName OpenMethod openMethod, @SerialName String str4, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i3 & 7)) {
                PluginExceptionsKt.b(i3, 7, CustomerCenterConfigData$HelpPath$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.title = str2;
            this.type = pathType;
            if ((i3 & 8) == 0) {
                this.promotionalOffer = null;
            } else {
                this.promotionalOffer = promotionalOffer;
            }
            if ((i3 & 16) == 0) {
                this.feedbackSurvey = null;
            } else {
                this.feedbackSurvey = feedbackSurvey;
            }
            if ((i3 & 32) == 0) {
                this.url = null;
            } else {
                this.url = str3;
            }
            if ((i3 & 64) == 0) {
                this.openMethod = null;
            } else {
                this.openMethod = openMethod;
            }
            if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
                this.actionIdentifier = null;
            } else {
                this.actionIdentifier = str4;
            }
        }

        public static /* synthetic */ HelpPath copy$default(HelpPath helpPath, String str, String str2, PathType pathType, PathDetail.PromotionalOffer promotionalOffer, PathDetail.FeedbackSurvey feedbackSurvey, String str3, OpenMethod openMethod, String str4, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = helpPath.id;
            }
            if ((i3 & 2) != 0) {
                str2 = helpPath.title;
            }
            if ((i3 & 4) != 0) {
                pathType = helpPath.type;
            }
            if ((i3 & 8) != 0) {
                promotionalOffer = helpPath.promotionalOffer;
            }
            if ((i3 & 16) != 0) {
                feedbackSurvey = helpPath.feedbackSurvey;
            }
            if ((i3 & 32) != 0) {
                str3 = helpPath.url;
            }
            if ((i3 & 64) != 0) {
                openMethod = helpPath.openMethod;
            }
            if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
                str4 = helpPath.actionIdentifier;
            }
            OpenMethod openMethod2 = openMethod;
            String str5 = str4;
            PathDetail.FeedbackSurvey feedbackSurvey2 = feedbackSurvey;
            String str6 = str3;
            return helpPath.copy(str, str2, pathType, promotionalOffer, feedbackSurvey2, str6, openMethod2, str5);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(HelpPath helpPath, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            compositeEncoder.y(serialDescriptor, 0, helpPath.id);
            compositeEncoder.y(serialDescriptor, 1, helpPath.title);
            compositeEncoder.C(serialDescriptor, 2, kSerializerArr[2], helpPath.type);
            if (compositeEncoder.z(serialDescriptor, 3) || helpPath.promotionalOffer != null) {
                compositeEncoder.i(serialDescriptor, 3, CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer.INSTANCE, helpPath.promotionalOffer);
            }
            if (compositeEncoder.z(serialDescriptor, 4) || helpPath.feedbackSurvey != null) {
                compositeEncoder.i(serialDescriptor, 4, CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$$serializer.INSTANCE, helpPath.feedbackSurvey);
            }
            if (compositeEncoder.z(serialDescriptor, 5) || helpPath.url != null) {
                compositeEncoder.i(serialDescriptor, 5, StringSerializer.f142891a, helpPath.url);
            }
            if (compositeEncoder.z(serialDescriptor, 6) || helpPath.openMethod != null) {
                compositeEncoder.i(serialDescriptor, 6, kSerializerArr[6], helpPath.openMethod);
            }
            if (!compositeEncoder.z(serialDescriptor, 7) && helpPath.actionIdentifier == null) {
                return;
            }
            compositeEncoder.i(serialDescriptor, 7, StringSerializer.f142891a, helpPath.actionIdentifier);
        }

        public final String component1() {
            return this.id;
        }

        public final String component2() {
            return this.title;
        }

        public final PathType component3() {
            return this.type;
        }

        public final PathDetail.PromotionalOffer component4() {
            return this.promotionalOffer;
        }

        public final PathDetail.FeedbackSurvey component5() {
            return this.feedbackSurvey;
        }

        public final String component6() {
            return this.url;
        }

        public final OpenMethod component7() {
            return this.openMethod;
        }

        public final String component8() {
            return this.actionIdentifier;
        }

        public final HelpPath copy(String id, String title, PathType type, PathDetail.PromotionalOffer promotionalOffer, PathDetail.FeedbackSurvey feedbackSurvey, String str, OpenMethod openMethod, String str2) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(type, "type");
            return new HelpPath(id, title, type, promotionalOffer, feedbackSurvey, str, openMethod, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof HelpPath)) {
                return false;
            }
            HelpPath helpPath = (HelpPath) obj;
            return Intrinsics.areEqual(this.id, helpPath.id) && Intrinsics.areEqual(this.title, helpPath.title) && this.type == helpPath.type && Intrinsics.areEqual(this.promotionalOffer, helpPath.promotionalOffer) && Intrinsics.areEqual(this.feedbackSurvey, helpPath.feedbackSurvey) && Intrinsics.areEqual(this.url, helpPath.url) && this.openMethod == helpPath.openMethod && Intrinsics.areEqual(this.actionIdentifier, helpPath.actionIdentifier);
        }

        public final String getActionIdentifier() {
            return this.actionIdentifier;
        }

        public final PathDetail.FeedbackSurvey getFeedbackSurvey() {
            return this.feedbackSurvey;
        }

        public final String getId() {
            return this.id;
        }

        public final OpenMethod getOpenMethod() {
            return this.openMethod;
        }

        public final PathDetail.PromotionalOffer getPromotionalOffer() {
            return this.promotionalOffer;
        }

        public final String getTitle() {
            return this.title;
        }

        public final PathType getType() {
            return this.type;
        }

        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            int iHashCode = ((((this.id.hashCode() * 31) + this.title.hashCode()) * 31) + this.type.hashCode()) * 31;
            PathDetail.PromotionalOffer promotionalOffer = this.promotionalOffer;
            int iHashCode2 = (iHashCode + (promotionalOffer == null ? 0 : promotionalOffer.hashCode())) * 31;
            PathDetail.FeedbackSurvey feedbackSurvey = this.feedbackSurvey;
            int iHashCode3 = (iHashCode2 + (feedbackSurvey == null ? 0 : feedbackSurvey.hashCode())) * 31;
            String str = this.url;
            int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
            OpenMethod openMethod = this.openMethod;
            int iHashCode5 = (iHashCode4 + (openMethod == null ? 0 : openMethod.hashCode())) * 31;
            String str2 = this.actionIdentifier;
            return iHashCode5 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "HelpPath(id=" + this.id + ", title=" + this.title + ", type=" + this.type + ", promotionalOffer=" + this.promotionalOffer + ", feedbackSurvey=" + this.feedbackSurvey + ", url=" + this.url + ", openMethod=" + this.openMethod + ", actionIdentifier=" + this.actionIdentifier + ')';
        }

        public HelpPath(String id, String title, PathType type, PathDetail.PromotionalOffer promotionalOffer, PathDetail.FeedbackSurvey feedbackSurvey, String str, OpenMethod openMethod, String str2) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(type, "type");
            this.id = id;
            this.title = title;
            this.type = type;
            this.promotionalOffer = promotionalOffer;
            this.feedbackSurvey = feedbackSurvey;
            this.url = str;
            this.openMethod = openMethod;
            this.actionIdentifier = str2;
        }

        public /* synthetic */ HelpPath(String str, String str2, PathType pathType, PathDetail.PromotionalOffer promotionalOffer, PathDetail.FeedbackSurvey feedbackSurvey, String str3, OpenMethod openMethod, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, pathType, (i3 & 8) != 0 ? null : promotionalOffer, (i3 & 16) != 0 ? null : feedbackSurvey, (i3 & 32) != 0 ? null : str3, (i3 & 64) != 0 ? null : openMethod, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : str4);
        }

        @SerialName
        public static /* synthetic */ void getActionIdentifier$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getFeedbackSurvey$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getOpenMethod$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getPromotionalOffer$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class Localization {
        private static final KSerializer<Object>[] $childSerializers;
        public static final Companion Companion = new Companion(null);
        private final String locale;
        private final Map<String, String> localizedStrings;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public enum CommonLocalizedString {
            NO_THANKS,
            NO_SUBSCRIPTIONS_FOUND,
            TRY_CHECK_RESTORE,
            RESTORE_PURCHASES,
            CANCEL,
            BILLING_CYCLE,
            CURRENT_PRICE,
            EXPIRED,
            EXPIRES,
            NEXT_BILLING_DATE,
            REFUND_CANCELED,
            REFUND_ERROR_GENERIC,
            REFUND_GRANTED,
            REFUND_STATUS,
            SUB_EARLIEST_EXPIRATION,
            SUB_EARLIEST_RENEWAL,
            SUB_EXPIRED,
            CONTACT_SUPPORT,
            DEFAULT_BODY,
            DEFAULT_SUBJECT,
            DISMISS,
            UPDATE_WARNING_TITLE,
            UPDATE_WARNING_DESCRIPTION,
            UPDATE_WARNING_UPDATE,
            UPDATE_WARNING_IGNORE,
            PLEASE_CONTACT_SUPPORT,
            APPLE_SUBSCRIPTION_MANAGE,
            GOOGLE_SUBSCRIPTION_MANAGE,
            AMAZON_SUBSCRIPTION_MANAGE,
            PLATFORM_MISMATCH,
            GOING_TO_CHECK_PURCHASES,
            CHECK_PAST_PURCHASES,
            PURCHASES_RECOVERED,
            PURCHASES_RECOVERED_EXPLANATION,
            PURCHASES_NOT_RECOVERED,
            PURCHASES_NOT_FOUND,
            PURCHASES_RESTORING,
            MANAGE_SUBSCRIPTION,
            YOU_HAVE_PROMO,
            YOU_HAVE_LIFETIME,
            WEB_SUBSCRIPTION_MANAGE,
            FREE,
            NEVER,
            FREE_TRIAL_THEN_PRICE,
            SINGLE_PAYMENT_THEN_PRICE,
            DISCOUNTED_RECURRING_THEN_PRICE,
            FREE_TRIAL_SINGLE_PAYMENT_THEN_PRICE,
            FREE_TRIAL_DISCOUNTED_THEN_PRICE,
            DISCOUNTED_RECURRING_PAYMENT_THEN_PRICE,
            FREE_TRIAL_DISCOUNTED_RECURRING_PAYMENT_THEN_PRICE,
            DONE,
            RENEWS_ON_DATE_FOR_PRICE,
            RENEWS_ON_DATE,
            PURCHASE_INFO_EXPIRED_ON_DATE,
            PURCHASE_INFO_EXPIRES_ON_DATE,
            ACTIVE,
            BADGE_CANCELLED,
            BADGE_FREE_TRIAL,
            BADGE_FREE_TRIAL_CANCELLED,
            BADGE_LIFETIME,
            APP_STORE,
            MAC_APP_STORE,
            GOOGLE_PLAY_STORE,
            AMAZON_STORE,
            GALAXY_STORE,
            WEB_STORE,
            UNKNOWN_STORE,
            TEST_STORE,
            CARD_STORE_PROMOTIONAL,
            RESUBSCRIBE,
            TYPE_SUBSCRIPTION,
            TYPE_ONE_TIME_PURCHASE,
            BUY_SUBSCRIPTION,
            LAST_CHARGE_WAS,
            NEXT_BILLING_DATE_ON,
            SEE_ALL_VIRTUAL_CURRENCIES,
            VIRTUAL_CURRENCY_BALANCES_SCREEN_HEADER,
            NO_VIRTUAL_CURRENCY_BALANCES_FOUND,
            SUPPORT_TICKET_CREATE,
            EMAIL,
            ENTER_EMAIL,
            DESCRIPTION,
            SENT,
            SUPPORT_TICKET_FAILED,
            SUBMIT_TICKET,
            INVALID_EMAIL_ERROR,
            CHARACTERS_REMAINING;

            public static final Companion Companion = new Companion(null);
            private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Localization.CommonLocalizedString.Companion.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer<Object> invoke() {
                    return EnumsKt.a("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Localization.CommonLocalizedString", CommonLocalizedString.values(), new String[]{"no_thanks", "no_subscriptions_found", "try_check_restore", PaywallLegacyComponentInteraction.Value.RESTORE_PURCHASES, "cancel", "billing_cycle", "current_price", "expired", "expires", "next_billing_date", "refund_canceled", "refund_error_generic", "refund_granted", "refund_status", "sub_earliest_expiration", "sub_earliest_renewal", "sub_expired", "contact_support", "default_body", "default_subject", "dismiss", "update_warning_title", "update_warning_description", "update_warning_update", "update_warning_ignore", "please_contact_support", "apple_subscription_manage", "google_subscription_manage", "amazon_subscription_manage", "platform_mismatch", "going_to_check_purchases", "check_past_purchases", "purchases_recovered", "purchases_recovered_explanation", "purchases_not_recovered", "purchases_not_found", "purchases_restoring", "manage_subscription", "you_have_promo", "you_have_lifetime", "web_subscription_manage", "free", "never", "free_trial_then_price", "single_payment_then_price", "discounted_recurring_then_price", "free_trial_single_payment_then_price", "free_trial_discounted_then_price", "discounted_recurring_payment_then_price", "free_trial_discounted_recurring_payment_then_price", "done", "renews_on_date_for_price", "renews_on_date", "purchase_info_expired_on_date", "purchase_info_expires_on_date", "active", "badge_cancelled", "badge_free_trial", "badge_free_trial_cancelled", "badge_lifetime", "app_store", "mac_app_store", "google_play_store", "amazon_store", "galaxy_store", "web_store", "unknown_store", "test_store", "card_store_promotional", "resubscribe", "type_subscription", "type_one_time_purchase", "buy_subscription", "last_charge_was", "next_billing_date_on", "see_all_virtual_currencies", "virtual_currency_balances_screen_header", "no_virtual_currency_balances_found", "support_ticket_create", AuthenticationTokenClaims.JSON_KEY_EMAIL, "enter_email", "description", "sent", "support_ticket_failed", "submit_ticket", "invalid_email_error", "characters_remaining"}, new Annotation[][]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, null);
                }
            });

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private final /* synthetic */ KSerializer get$cachedSerializer() {
                    return (KSerializer) CommonLocalizedString.$cachedSerializer$delegate.getValue();
                }

                public final KSerializer<CommonLocalizedString> serializer() {
                    return get$cachedSerializer();
                }

                private Companion() {
                }
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[CommonLocalizedString.values().length];
                    try {
                        iArr[CommonLocalizedString.NO_THANKS.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[CommonLocalizedString.NO_SUBSCRIPTIONS_FOUND.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[CommonLocalizedString.TRY_CHECK_RESTORE.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[CommonLocalizedString.RESTORE_PURCHASES.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[CommonLocalizedString.CANCEL.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    try {
                        iArr[CommonLocalizedString.BILLING_CYCLE.ordinal()] = 6;
                    } catch (NoSuchFieldError unused6) {
                    }
                    try {
                        iArr[CommonLocalizedString.CURRENT_PRICE.ordinal()] = 7;
                    } catch (NoSuchFieldError unused7) {
                    }
                    try {
                        iArr[CommonLocalizedString.EXPIRED.ordinal()] = 8;
                    } catch (NoSuchFieldError unused8) {
                    }
                    try {
                        iArr[CommonLocalizedString.EXPIRES.ordinal()] = 9;
                    } catch (NoSuchFieldError unused9) {
                    }
                    try {
                        iArr[CommonLocalizedString.NEXT_BILLING_DATE.ordinal()] = 10;
                    } catch (NoSuchFieldError unused10) {
                    }
                    try {
                        iArr[CommonLocalizedString.REFUND_CANCELED.ordinal()] = 11;
                    } catch (NoSuchFieldError unused11) {
                    }
                    try {
                        iArr[CommonLocalizedString.REFUND_ERROR_GENERIC.ordinal()] = 12;
                    } catch (NoSuchFieldError unused12) {
                    }
                    try {
                        iArr[CommonLocalizedString.REFUND_GRANTED.ordinal()] = 13;
                    } catch (NoSuchFieldError unused13) {
                    }
                    try {
                        iArr[CommonLocalizedString.REFUND_STATUS.ordinal()] = 14;
                    } catch (NoSuchFieldError unused14) {
                    }
                    try {
                        iArr[CommonLocalizedString.SUB_EARLIEST_EXPIRATION.ordinal()] = 15;
                    } catch (NoSuchFieldError unused15) {
                    }
                    try {
                        iArr[CommonLocalizedString.SUB_EARLIEST_RENEWAL.ordinal()] = 16;
                    } catch (NoSuchFieldError unused16) {
                    }
                    try {
                        iArr[CommonLocalizedString.SUB_EXPIRED.ordinal()] = 17;
                    } catch (NoSuchFieldError unused17) {
                    }
                    try {
                        iArr[CommonLocalizedString.CONTACT_SUPPORT.ordinal()] = 18;
                    } catch (NoSuchFieldError unused18) {
                    }
                    try {
                        iArr[CommonLocalizedString.DEFAULT_BODY.ordinal()] = 19;
                    } catch (NoSuchFieldError unused19) {
                    }
                    try {
                        iArr[CommonLocalizedString.DEFAULT_SUBJECT.ordinal()] = 20;
                    } catch (NoSuchFieldError unused20) {
                    }
                    try {
                        iArr[CommonLocalizedString.DISMISS.ordinal()] = 21;
                    } catch (NoSuchFieldError unused21) {
                    }
                    try {
                        iArr[CommonLocalizedString.UPDATE_WARNING_TITLE.ordinal()] = 22;
                    } catch (NoSuchFieldError unused22) {
                    }
                    try {
                        iArr[CommonLocalizedString.UPDATE_WARNING_DESCRIPTION.ordinal()] = 23;
                    } catch (NoSuchFieldError unused23) {
                    }
                    try {
                        iArr[CommonLocalizedString.UPDATE_WARNING_UPDATE.ordinal()] = 24;
                    } catch (NoSuchFieldError unused24) {
                    }
                    try {
                        iArr[CommonLocalizedString.UPDATE_WARNING_IGNORE.ordinal()] = 25;
                    } catch (NoSuchFieldError unused25) {
                    }
                    try {
                        iArr[CommonLocalizedString.PLATFORM_MISMATCH.ordinal()] = 26;
                    } catch (NoSuchFieldError unused26) {
                    }
                    try {
                        iArr[CommonLocalizedString.PLEASE_CONTACT_SUPPORT.ordinal()] = 27;
                    } catch (NoSuchFieldError unused27) {
                    }
                    try {
                        iArr[CommonLocalizedString.APPLE_SUBSCRIPTION_MANAGE.ordinal()] = 28;
                    } catch (NoSuchFieldError unused28) {
                    }
                    try {
                        iArr[CommonLocalizedString.GOOGLE_SUBSCRIPTION_MANAGE.ordinal()] = 29;
                    } catch (NoSuchFieldError unused29) {
                    }
                    try {
                        iArr[CommonLocalizedString.AMAZON_SUBSCRIPTION_MANAGE.ordinal()] = 30;
                    } catch (NoSuchFieldError unused30) {
                    }
                    try {
                        iArr[CommonLocalizedString.GOING_TO_CHECK_PURCHASES.ordinal()] = 31;
                    } catch (NoSuchFieldError unused31) {
                    }
                    try {
                        iArr[CommonLocalizedString.CHECK_PAST_PURCHASES.ordinal()] = 32;
                    } catch (NoSuchFieldError unused32) {
                    }
                    try {
                        iArr[CommonLocalizedString.PURCHASES_RECOVERED.ordinal()] = 33;
                    } catch (NoSuchFieldError unused33) {
                    }
                    try {
                        iArr[CommonLocalizedString.PURCHASES_RECOVERED_EXPLANATION.ordinal()] = 34;
                    } catch (NoSuchFieldError unused34) {
                    }
                    try {
                        iArr[CommonLocalizedString.PURCHASES_NOT_RECOVERED.ordinal()] = 35;
                    } catch (NoSuchFieldError unused35) {
                    }
                    try {
                        iArr[CommonLocalizedString.PURCHASES_NOT_FOUND.ordinal()] = 36;
                    } catch (NoSuchFieldError unused36) {
                    }
                    try {
                        iArr[CommonLocalizedString.PURCHASES_RESTORING.ordinal()] = 37;
                    } catch (NoSuchFieldError unused37) {
                    }
                    try {
                        iArr[CommonLocalizedString.MANAGE_SUBSCRIPTION.ordinal()] = 38;
                    } catch (NoSuchFieldError unused38) {
                    }
                    try {
                        iArr[CommonLocalizedString.YOU_HAVE_PROMO.ordinal()] = 39;
                    } catch (NoSuchFieldError unused39) {
                    }
                    try {
                        iArr[CommonLocalizedString.YOU_HAVE_LIFETIME.ordinal()] = 40;
                    } catch (NoSuchFieldError unused40) {
                    }
                    try {
                        iArr[CommonLocalizedString.WEB_SUBSCRIPTION_MANAGE.ordinal()] = 41;
                    } catch (NoSuchFieldError unused41) {
                    }
                    try {
                        iArr[CommonLocalizedString.FREE.ordinal()] = 42;
                    } catch (NoSuchFieldError unused42) {
                    }
                    try {
                        iArr[CommonLocalizedString.NEVER.ordinal()] = 43;
                    } catch (NoSuchFieldError unused43) {
                    }
                    try {
                        iArr[CommonLocalizedString.FREE_TRIAL_THEN_PRICE.ordinal()] = 44;
                    } catch (NoSuchFieldError unused44) {
                    }
                    try {
                        iArr[CommonLocalizedString.SINGLE_PAYMENT_THEN_PRICE.ordinal()] = 45;
                    } catch (NoSuchFieldError unused45) {
                    }
                    try {
                        iArr[CommonLocalizedString.DISCOUNTED_RECURRING_THEN_PRICE.ordinal()] = 46;
                    } catch (NoSuchFieldError unused46) {
                    }
                    try {
                        iArr[CommonLocalizedString.FREE_TRIAL_SINGLE_PAYMENT_THEN_PRICE.ordinal()] = 47;
                    } catch (NoSuchFieldError unused47) {
                    }
                    try {
                        iArr[CommonLocalizedString.FREE_TRIAL_DISCOUNTED_THEN_PRICE.ordinal()] = 48;
                    } catch (NoSuchFieldError unused48) {
                    }
                    try {
                        iArr[CommonLocalizedString.DISCOUNTED_RECURRING_PAYMENT_THEN_PRICE.ordinal()] = 49;
                    } catch (NoSuchFieldError unused49) {
                    }
                    try {
                        iArr[CommonLocalizedString.FREE_TRIAL_DISCOUNTED_RECURRING_PAYMENT_THEN_PRICE.ordinal()] = 50;
                    } catch (NoSuchFieldError unused50) {
                    }
                    try {
                        iArr[CommonLocalizedString.DONE.ordinal()] = 51;
                    } catch (NoSuchFieldError unused51) {
                    }
                    try {
                        iArr[CommonLocalizedString.RENEWS_ON_DATE_FOR_PRICE.ordinal()] = 52;
                    } catch (NoSuchFieldError unused52) {
                    }
                    try {
                        iArr[CommonLocalizedString.RENEWS_ON_DATE.ordinal()] = 53;
                    } catch (NoSuchFieldError unused53) {
                    }
                    try {
                        iArr[CommonLocalizedString.PURCHASE_INFO_EXPIRED_ON_DATE.ordinal()] = 54;
                    } catch (NoSuchFieldError unused54) {
                    }
                    try {
                        iArr[CommonLocalizedString.PURCHASE_INFO_EXPIRES_ON_DATE.ordinal()] = 55;
                    } catch (NoSuchFieldError unused55) {
                    }
                    try {
                        iArr[CommonLocalizedString.ACTIVE.ordinal()] = 56;
                    } catch (NoSuchFieldError unused56) {
                    }
                    try {
                        iArr[CommonLocalizedString.BADGE_CANCELLED.ordinal()] = 57;
                    } catch (NoSuchFieldError unused57) {
                    }
                    try {
                        iArr[CommonLocalizedString.BADGE_FREE_TRIAL.ordinal()] = 58;
                    } catch (NoSuchFieldError unused58) {
                    }
                    try {
                        iArr[CommonLocalizedString.BADGE_FREE_TRIAL_CANCELLED.ordinal()] = 59;
                    } catch (NoSuchFieldError unused59) {
                    }
                    try {
                        iArr[CommonLocalizedString.BADGE_LIFETIME.ordinal()] = 60;
                    } catch (NoSuchFieldError unused60) {
                    }
                    try {
                        iArr[CommonLocalizedString.APP_STORE.ordinal()] = 61;
                    } catch (NoSuchFieldError unused61) {
                    }
                    try {
                        iArr[CommonLocalizedString.MAC_APP_STORE.ordinal()] = 62;
                    } catch (NoSuchFieldError unused62) {
                    }
                    try {
                        iArr[CommonLocalizedString.GOOGLE_PLAY_STORE.ordinal()] = 63;
                    } catch (NoSuchFieldError unused63) {
                    }
                    try {
                        iArr[CommonLocalizedString.AMAZON_STORE.ordinal()] = 64;
                    } catch (NoSuchFieldError unused64) {
                    }
                    try {
                        iArr[CommonLocalizedString.GALAXY_STORE.ordinal()] = 65;
                    } catch (NoSuchFieldError unused65) {
                    }
                    try {
                        iArr[CommonLocalizedString.WEB_STORE.ordinal()] = 66;
                    } catch (NoSuchFieldError unused66) {
                    }
                    try {
                        iArr[CommonLocalizedString.UNKNOWN_STORE.ordinal()] = 67;
                    } catch (NoSuchFieldError unused67) {
                    }
                    try {
                        iArr[CommonLocalizedString.TEST_STORE.ordinal()] = 68;
                    } catch (NoSuchFieldError unused68) {
                    }
                    try {
                        iArr[CommonLocalizedString.CARD_STORE_PROMOTIONAL.ordinal()] = 69;
                    } catch (NoSuchFieldError unused69) {
                    }
                    try {
                        iArr[CommonLocalizedString.RESUBSCRIBE.ordinal()] = 70;
                    } catch (NoSuchFieldError unused70) {
                    }
                    try {
                        iArr[CommonLocalizedString.TYPE_SUBSCRIPTION.ordinal()] = 71;
                    } catch (NoSuchFieldError unused71) {
                    }
                    try {
                        iArr[CommonLocalizedString.TYPE_ONE_TIME_PURCHASE.ordinal()] = 72;
                    } catch (NoSuchFieldError unused72) {
                    }
                    try {
                        iArr[CommonLocalizedString.BUY_SUBSCRIPTION.ordinal()] = 73;
                    } catch (NoSuchFieldError unused73) {
                    }
                    try {
                        iArr[CommonLocalizedString.LAST_CHARGE_WAS.ordinal()] = 74;
                    } catch (NoSuchFieldError unused74) {
                    }
                    try {
                        iArr[CommonLocalizedString.NEXT_BILLING_DATE_ON.ordinal()] = 75;
                    } catch (NoSuchFieldError unused75) {
                    }
                    try {
                        iArr[CommonLocalizedString.SEE_ALL_VIRTUAL_CURRENCIES.ordinal()] = 76;
                    } catch (NoSuchFieldError unused76) {
                    }
                    try {
                        iArr[CommonLocalizedString.VIRTUAL_CURRENCY_BALANCES_SCREEN_HEADER.ordinal()] = 77;
                    } catch (NoSuchFieldError unused77) {
                    }
                    try {
                        iArr[CommonLocalizedString.NO_VIRTUAL_CURRENCY_BALANCES_FOUND.ordinal()] = 78;
                    } catch (NoSuchFieldError unused78) {
                    }
                    try {
                        iArr[CommonLocalizedString.SUPPORT_TICKET_CREATE.ordinal()] = 79;
                    } catch (NoSuchFieldError unused79) {
                    }
                    try {
                        iArr[CommonLocalizedString.EMAIL.ordinal()] = 80;
                    } catch (NoSuchFieldError unused80) {
                    }
                    try {
                        iArr[CommonLocalizedString.ENTER_EMAIL.ordinal()] = 81;
                    } catch (NoSuchFieldError unused81) {
                    }
                    try {
                        iArr[CommonLocalizedString.DESCRIPTION.ordinal()] = 82;
                    } catch (NoSuchFieldError unused82) {
                    }
                    try {
                        iArr[CommonLocalizedString.SENT.ordinal()] = 83;
                    } catch (NoSuchFieldError unused83) {
                    }
                    try {
                        iArr[CommonLocalizedString.SUPPORT_TICKET_FAILED.ordinal()] = 84;
                    } catch (NoSuchFieldError unused84) {
                    }
                    try {
                        iArr[CommonLocalizedString.SUBMIT_TICKET.ordinal()] = 85;
                    } catch (NoSuchFieldError unused85) {
                    }
                    try {
                        iArr[CommonLocalizedString.INVALID_EMAIL_ERROR.ordinal()] = 86;
                    } catch (NoSuchFieldError unused86) {
                    }
                    try {
                        iArr[CommonLocalizedString.CHARACTERS_REMAINING.ordinal()] = 87;
                    } catch (NoSuchFieldError unused87) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            public final String getDefaultValue() {
                switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                    case 1:
                        return "No, thanks";
                    case 2:
                        return "No Subscriptions found";
                    case 3:
                        return "We can try checking your Apple account for any previous purchases";
                    case 4:
                        return "Restore purchases";
                    case 5:
                        return "Cancel";
                    case 6:
                        return "Billing cycle";
                    case 7:
                        return "Current price";
                    case 8:
                        return "Expired";
                    case 9:
                        return "Expires";
                    case 10:
                        return "Next billing date";
                    case 11:
                        return "Refund canceled";
                    case 12:
                        return "An error occurred while processing the refund request. Please try again.";
                    case 13:
                        return "Refund granted successfully!";
                    case 14:
                        return "Refund status";
                    case 15:
                        return "This is your subscription with the earliest expiration date.";
                    case 16:
                        return "This is your subscription with the earliest billing date.";
                    case 17:
                        return "This subscription has expired.";
                    case 18:
                        return "Contact support";
                    case 19:
                        return "Please describe your issue or question.";
                    case 20:
                        return "Support Request";
                    case 21:
                        return "Dismiss";
                    case 22:
                        return "Update available";
                    case 23:
                        return "Downloading the latest version of the app may help solve the problem.";
                    case 24:
                        return "Update";
                    case 25:
                        return "Continue";
                    case 26:
                        return "Platform mismatch";
                    case 27:
                        return "Please contact support to manage your subscription.";
                    case 28:
                        return "You can manage your subscription by using the App Store app on an Apple device.";
                    case 29:
                        return "You have an active subscription from the Google Play Store";
                    case 30:
                        return "You have an active subscription from the Amazon Appstore. You can manage your subscription in the Amazon Appstore app.";
                    case 31:
                        return "Let's take a look! We're going to check your account for missing purchases.";
                    case 32:
                        return "Check past purchases";
                    case 33:
                        return "Purchases restored";
                    case 34:
                        return "We restored your past purchases and applied them to your account.";
                    case 35:
                        return "We could not find any purchases with your account. If you think this is an error, please contact support.";
                    case 36:
                        return "No past purchases";
                    case 37:
                        return "Restoring...";
                    case 38:
                        return "Manage your subscription";
                    case 39:
                        return "You've been granted a subscription that doesn't renew";
                    case 40:
                        return "Your active lifetime subscription";
                    case 41:
                        return "You have an active subscription that was purchased on the web. You can manage your subscription using the button below.";
                    case 42:
                        return "Free";
                    case 43:
                        return "Never";
                    case 44:
                        return "First {{ sub_offer_duration }} free, then {{ price }}";
                    case 45:
                        return "{{ sub_offer_duration }} for {{ sub_offer_price }}, then {{ price }}";
                    case 46:
                        return "{{ sub_offer_price }} during {{ sub_offer_duration }}, then {{ price }}";
                    case 47:
                        return "Try {{ sub_offer_duration }} for free, then {{ sub_offer_duration_2 }} for {{ sub_offer_price_2 }}, and {{ price }} thereafter";
                    case 48:
                        return "Try {{ sub_offer_duration }} for free, then {{ sub_offer_price_2 }} during {{ sub_offer_duration_2 }}, and {{ price }} thereafter";
                    case 49:
                        return "{{ discounted_recurring_payment_price_per_period }} for {{ discounted_recurring_payment_cycles }} periods, then {{ price }}";
                    case 50:
                        return "Try {{ sub_offer_duration }} for free, then {{ discounted_recurring_payment_price_per_period }} for {{ discounted_recurring_payment_cycles }} periods, and {{ price }} thereafter";
                    case 51:
                        return "Done";
                    case 52:
                        return "Your next charge is {{ price }} on {{ date }}.";
                    case 53:
                        return "Renews on {{ date }}";
                    case 54:
                        return "Expired on {{ date }}";
                    case 55:
                        return "Expires on {{ date }}";
                    case 56:
                        return "Active";
                    case 57:
                        return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED;
                    case 58:
                        return "Free Trial";
                    case 59:
                        return "Cancelled Trial";
                    case 60:
                        return "Lifetime";
                    case 61:
                        return "App Store";
                    case 62:
                        return "Mac App Store";
                    case 63:
                        return "Google Play Store";
                    case 64:
                        return "Amazon Store";
                    case 65:
                        return "Galaxy Store";
                    case 66:
                        return "Web";
                    case 67:
                        return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                    case 68:
                        return "Test Store";
                    case 69:
                        return "Via Support";
                    case 70:
                        return "Resubscribe";
                    case 71:
                        return "Subscription";
                    case 72:
                        return "One time purchase";
                    case 73:
                        return "Buy Subscription";
                    case 74:
                        return "Last charge: {{ price }}";
                    case 75:
                        return "Next billing date: {{ date }}";
                    case 76:
                        return "See all in-app currencies";
                    case 77:
                        return "In-App Currencies";
                    case 78:
                        return "It doesn't look like you've purchased any in-app currencies.";
                    case 79:
                        return "Create a support ticket";
                    case 80:
                        return "Email";
                    case 81:
                        return "Enter your email";
                    case 82:
                        return "Description";
                    case 83:
                        return "Message sent";
                    case 84:
                        return "Failed to send, please try again.";
                    case 85:
                        return "Submit ticket";
                    case 86:
                        return "Please enter a valid email address";
                    case 87:
                        return "{{ count }} characters";
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Localization> serializer() {
                return CustomerCenterConfigData$Localization$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public enum VariableName {
            PRICE("price"),
            SUB_OFFER_DURATION("sub_offer_duration"),
            SUB_OFFER_DURATION_2("sub_offer_duration_2"),
            SUB_OFFER_PRICE("sub_offer_price"),
            SUB_OFFER_PRICE_2("sub_offer_price_2"),
            DISCOUNTED_RECURRING_PAYMENT_PRICE_PER_PERIOD("discounted_recurring_payment_price_per_period"),
            DISCOUNTED_RECURRING_PAYMENT_CYCLES("discounted_recurring_payment_cycles");

            private final String identifier;
            public static final Companion Companion = new Companion(null);
            private static final Lazy<Map<String, VariableName>> valueMap$delegate = LazyKt.b(new Function0<Map<String, ? extends VariableName>>() { // from class: com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Localization$VariableName$Companion$valueMap$2
                @Override // kotlin.jvm.functions.Function0
                public final Map<String, CustomerCenterConfigData.Localization.VariableName> invoke() {
                    CustomerCenterConfigData.Localization.VariableName[] variableNameArrValues = CustomerCenterConfigData.Localization.VariableName.values();
                    LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(variableNameArrValues.length), 16));
                    for (CustomerCenterConfigData.Localization.VariableName variableName : variableNameArrValues) {
                        linkedHashMap.put(variableName.getIdentifier(), variableName);
                    }
                    return linkedHashMap;
                }
            });

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private final Map<String, VariableName> getValueMap() {
                    return (Map) VariableName.valueMap$delegate.getValue();
                }

                public final VariableName valueOfIdentifier(String identifier) {
                    Intrinsics.checkNotNullParameter(identifier, "identifier");
                    return getValueMap().get(identifier);
                }

                private Companion() {
                }
            }

            VariableName(String str) {
                this.identifier = str;
            }

            public final String getIdentifier() {
                return this.identifier;
            }
        }

        static {
            StringSerializer stringSerializer = StringSerializer.f142891a;
            $childSerializers = new KSerializer[]{null, new LinkedHashMapSerializer(stringSerializer, stringSerializer)};
        }

        @Deprecated
        public /* synthetic */ Localization(int i3, String str, @SerialName Map map, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i3 & 3)) {
                PluginExceptionsKt.b(i3, 3, CustomerCenterConfigData$Localization$$serializer.INSTANCE.getDescriptor());
            }
            this.locale = str;
            this.localizedStrings = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Localization copy$default(Localization localization, String str, Map map, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = localization.locale;
            }
            if ((i3 & 2) != 0) {
                map = localization.localizedStrings;
            }
            return localization.copy(str, map);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Localization localization, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            compositeEncoder.y(serialDescriptor, 0, localization.locale);
            compositeEncoder.C(serialDescriptor, 1, kSerializerArr[1], localization.localizedStrings);
        }

        public final String commonLocalizedString(CommonLocalizedString key) {
            Intrinsics.checkNotNullParameter(key, "key");
            Map<String, String> map = this.localizedStrings;
            String lowerCase = key.name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            String str = map.get(lowerCase);
            return str == null ? key.getDefaultValue() : str;
        }

        public final String component1() {
            return this.locale;
        }

        public final Map<String, String> component2() {
            return this.localizedStrings;
        }

        public final Localization copy(String locale, Map<String, String> localizedStrings) {
            Intrinsics.checkNotNullParameter(locale, "locale");
            Intrinsics.checkNotNullParameter(localizedStrings, "localizedStrings");
            return new Localization(locale, localizedStrings);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Localization)) {
                return false;
            }
            Localization localization = (Localization) obj;
            return Intrinsics.areEqual(this.locale, localization.locale) && Intrinsics.areEqual(this.localizedStrings, localization.localizedStrings);
        }

        public final String getLocale() {
            return this.locale;
        }

        public final Map<String, String> getLocalizedStrings() {
            return this.localizedStrings;
        }

        public int hashCode() {
            return (this.locale.hashCode() * 31) + this.localizedStrings.hashCode();
        }

        public String toString() {
            return "Localization(locale=" + this.locale + ", localizedStrings=" + this.localizedStrings + ')';
        }

        public Localization(String locale, Map<String, String> localizedStrings) {
            Intrinsics.checkNotNullParameter(locale, "locale");
            Intrinsics.checkNotNullParameter(localizedStrings, "localizedStrings");
            this.locale = locale;
            this.localizedStrings = localizedStrings;
        }

        @SerialName
        public static /* synthetic */ void getLocalizedStrings$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class Screen {
        private final ScreenOffering offering;
        private final List<HelpPath> paths;
        private final String subtitle;
        private final String title;
        private final ScreenType type;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {ScreenType.Companion.serializer(), null, null, null, null};

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Screen> serializer() {
                return CustomerCenterConfigData$Screen$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public enum ScreenType {
            MANAGEMENT,
            NO_ACTIVE,
            UNKNOWN;

            public static final Companion Companion = new Companion(null);
            private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Screen.ScreenType.Companion.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer<Object> invoke() {
                    return EnumsKt.b("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Screen.ScreenType", ScreenType.values());
                }
            });

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private final /* synthetic */ KSerializer get$cachedSerializer() {
                    return (KSerializer) ScreenType.$cachedSerializer$delegate.getValue();
                }

                public final KSerializer<ScreenType> serializer() {
                    return get$cachedSerializer();
                }

                private Companion() {
                }
            }
        }

        @Deprecated
        public /* synthetic */ Screen(int i3, ScreenType screenType, String str, @Serializable(with = EmptyStringToNullSerializer.class) String str2, @Serializable(with = HelpPathsSerializer.class) List list, ScreenOffering screenOffering, SerializationConstructorMarker serializationConstructorMarker) {
            if (11 != (i3 & 11)) {
                PluginExceptionsKt.b(i3, 11, CustomerCenterConfigData$Screen$$serializer.INSTANCE.getDescriptor());
            }
            this.type = screenType;
            this.title = str;
            if ((i3 & 4) == 0) {
                this.subtitle = null;
            } else {
                this.subtitle = str2;
            }
            this.paths = list;
            if ((i3 & 16) == 0) {
                this.offering = null;
            } else {
                this.offering = screenOffering;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Screen copy$default(Screen screen, ScreenType screenType, String str, String str2, List list, ScreenOffering screenOffering, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                screenType = screen.type;
            }
            if ((i3 & 2) != 0) {
                str = screen.title;
            }
            if ((i3 & 4) != 0) {
                str2 = screen.subtitle;
            }
            if ((i3 & 8) != 0) {
                list = screen.paths;
            }
            if ((i3 & 16) != 0) {
                screenOffering = screen.offering;
            }
            ScreenOffering screenOffering2 = screenOffering;
            String str3 = str2;
            return screen.copy(screenType, str, str3, list, screenOffering2);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Screen screen, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            compositeEncoder.C(serialDescriptor, 0, $childSerializers[0], screen.type);
            compositeEncoder.y(serialDescriptor, 1, screen.title);
            if (compositeEncoder.z(serialDescriptor, 2) || screen.subtitle != null) {
                compositeEncoder.i(serialDescriptor, 2, EmptyStringToNullSerializer.INSTANCE, screen.subtitle);
            }
            compositeEncoder.C(serialDescriptor, 3, HelpPathsSerializer.INSTANCE, screen.paths);
            if (!compositeEncoder.z(serialDescriptor, 4) && screen.offering == null) {
                return;
            }
            compositeEncoder.i(serialDescriptor, 4, CustomerCenterConfigData$ScreenOffering$$serializer.INSTANCE, screen.offering);
        }

        public final ScreenType component1() {
            return this.type;
        }

        public final String component2() {
            return this.title;
        }

        public final String component3() {
            return this.subtitle;
        }

        public final List<HelpPath> component4() {
            return this.paths;
        }

        public final ScreenOffering component5() {
            return this.offering;
        }

        public final Screen copy(ScreenType type, String title, String str, List<HelpPath> paths, ScreenOffering screenOffering) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(paths, "paths");
            return new Screen(type, title, str, paths, screenOffering);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Screen)) {
                return false;
            }
            Screen screen = (Screen) obj;
            return this.type == screen.type && Intrinsics.areEqual(this.title, screen.title) && Intrinsics.areEqual(this.subtitle, screen.subtitle) && Intrinsics.areEqual(this.paths, screen.paths) && Intrinsics.areEqual(this.offering, screen.offering);
        }

        public final ScreenOffering getOffering() {
            return this.offering;
        }

        public final List<HelpPath> getPaths() {
            return this.paths;
        }

        public final String getSubtitle() {
            return this.subtitle;
        }

        public final String getTitle() {
            return this.title;
        }

        public final ScreenType getType() {
            return this.type;
        }

        public int hashCode() {
            int iHashCode = ((this.type.hashCode() * 31) + this.title.hashCode()) * 31;
            String str = this.subtitle;
            int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.paths.hashCode()) * 31;
            ScreenOffering screenOffering = this.offering;
            return iHashCode2 + (screenOffering != null ? screenOffering.hashCode() : 0);
        }

        public String toString() {
            return "Screen(type=" + this.type + ", title=" + this.title + ", subtitle=" + this.subtitle + ", paths=" + this.paths + ", offering=" + this.offering + ')';
        }

        public Screen(ScreenType type, String title, String str, List<HelpPath> paths, ScreenOffering screenOffering) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(paths, "paths");
            this.type = type;
            this.title = title;
            this.subtitle = str;
            this.paths = paths;
            this.offering = screenOffering;
        }

        public /* synthetic */ Screen(ScreenType screenType, String str, String str2, List list, ScreenOffering screenOffering, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(screenType, str, (i3 & 4) != 0 ? null : str2, list, (i3 & 16) != 0 ? null : screenOffering);
        }

        @Serializable(with = HelpPathsSerializer.class)
        public static /* synthetic */ void getPaths$annotations() {
        }

        @Serializable(with = EmptyStringToNullSerializer.class)
        public static /* synthetic */ void getSubtitle$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class ScreenOffering {
        private final String buttonText;
        private final String offeringId;
        private final ScreenOfferingType type;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {ScreenOfferingType.Companion.serializer(), null, null};

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<ScreenOffering> serializer() {
                return CustomerCenterConfigData$ScreenOffering$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public enum ScreenOfferingType {
            CURRENT("CURRENT"),
            SPECIFIC("SPECIFIC");

            private final String value;
            public static final Companion Companion = new Companion(null);
            private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.customercenter.CustomerCenterConfigData.ScreenOffering.ScreenOfferingType.Companion.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer<Object> invoke() {
                    return EnumsKt.a("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.ScreenOffering.ScreenOfferingType", ScreenOfferingType.values(), new String[]{"CURRENT", "SPECIFIC"}, new Annotation[][]{null, null}, null);
                }
            });

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private final /* synthetic */ KSerializer get$cachedSerializer() {
                    return (KSerializer) ScreenOfferingType.$cachedSerializer$delegate.getValue();
                }

                public final KSerializer<ScreenOfferingType> serializer() {
                    return get$cachedSerializer();
                }

                private Companion() {
                }
            }

            ScreenOfferingType(String str) {
                this.value = str;
            }

            public final String getValue() {
                return this.value;
            }
        }

        @Deprecated
        public /* synthetic */ ScreenOffering(int i3, ScreenOfferingType screenOfferingType, @SerialName String str, @SerialName String str2, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, CustomerCenterConfigData$ScreenOffering$$serializer.INSTANCE.getDescriptor());
            }
            this.type = screenOfferingType;
            if ((i3 & 2) == 0) {
                this.offeringId = null;
            } else {
                this.offeringId = str;
            }
            if ((i3 & 4) == 0) {
                this.buttonText = null;
            } else {
                this.buttonText = str2;
            }
        }

        public static /* synthetic */ ScreenOffering copy$default(ScreenOffering screenOffering, ScreenOfferingType screenOfferingType, String str, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                screenOfferingType = screenOffering.type;
            }
            if ((i3 & 2) != 0) {
                str = screenOffering.offeringId;
            }
            if ((i3 & 4) != 0) {
                str2 = screenOffering.buttonText;
            }
            return screenOffering.copy(screenOfferingType, str, str2);
        }

        @SerialName
        public static /* synthetic */ void getButtonText$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getOfferingId$annotations() {
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(ScreenOffering screenOffering, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            compositeEncoder.C(serialDescriptor, 0, $childSerializers[0], screenOffering.type);
            if (compositeEncoder.z(serialDescriptor, 1) || screenOffering.offeringId != null) {
                compositeEncoder.i(serialDescriptor, 1, StringSerializer.f142891a, screenOffering.offeringId);
            }
            if (!compositeEncoder.z(serialDescriptor, 2) && screenOffering.buttonText == null) {
                return;
            }
            compositeEncoder.i(serialDescriptor, 2, StringSerializer.f142891a, screenOffering.buttonText);
        }

        public final ScreenOfferingType component1() {
            return this.type;
        }

        public final String component2() {
            return this.offeringId;
        }

        public final String component3() {
            return this.buttonText;
        }

        public final ScreenOffering copy(ScreenOfferingType type, String str, String str2) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new ScreenOffering(type, str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ScreenOffering)) {
                return false;
            }
            ScreenOffering screenOffering = (ScreenOffering) obj;
            return this.type == screenOffering.type && Intrinsics.areEqual(this.offeringId, screenOffering.offeringId) && Intrinsics.areEqual(this.buttonText, screenOffering.buttonText);
        }

        public final String getButtonText() {
            return this.buttonText;
        }

        public final String getOfferingId() {
            return this.offeringId;
        }

        public final ScreenOfferingType getType() {
            return this.type;
        }

        public int hashCode() {
            int iHashCode = this.type.hashCode() * 31;
            String str = this.offeringId;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.buttonText;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "ScreenOffering(type=" + this.type + ", offeringId=" + this.offeringId + ", buttonText=" + this.buttonText + ')';
        }

        public ScreenOffering(ScreenOfferingType screenOfferingType, String str, String str2) {
            Intrinsics.checkNotNullParameter(screenOfferingType, vxrlPPpdv.mjRNjAESPdjRgMw);
            this.type = screenOfferingType;
            this.offeringId = str;
            this.buttonText = str2;
        }

        public /* synthetic */ ScreenOffering(ScreenOfferingType screenOfferingType, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(screenOfferingType, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class Support {
        public static final Companion Companion = new Companion(null);
        private final Boolean displayVirtualCurrencies;
        private final String email;
        private final Boolean shouldWarnCustomerToUpdate;
        private final SupportTickets supportTickets;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Support> serializer() {
                return CustomerCenterConfigData$Support$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class SupportTickets {
            private final boolean allowCreation;
            private final CustomerDetails customerDetails;
            private final CustomerType customerType;
            public static final Companion Companion = new Companion(null);
            private static final KSerializer<Object>[] $childSerializers = {null, null, CustomerType.Companion.serializer()};

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<SupportTickets> serializer() {
                    return CustomerCenterConfigData$Support$SupportTickets$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @Serializable
            public static final class CustomerDetails {
                public static final Companion Companion = new Companion(null);
                private final boolean activeEntitlements;
                private final boolean appUserId;
                private final boolean attConsent;
                private final boolean country;
                private final boolean deviceVersion;
                private final boolean email;
                private final boolean facebookAnonId;
                private final boolean idfa;
                private final boolean idfv;
                private final boolean ip;
                private final boolean lastOpened;
                private final boolean lastSeenAppVersion;
                private final boolean totalSpent;
                private final boolean userSince;

                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    public final KSerializer<CustomerDetails> serializer() {
                        return CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer.INSTANCE;
                    }

                    private Companion() {
                    }
                }

                public CustomerDetails() {
                    this(false, false, false, false, false, false, false, false, false, false, false, false, false, false, 16383, (DefaultConstructorMarker) null);
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(CustomerDetails customerDetails, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                    if (compositeEncoder.z(serialDescriptor, 0) || customerDetails.activeEntitlements) {
                        compositeEncoder.x(serialDescriptor, 0, customerDetails.activeEntitlements);
                    }
                    if (compositeEncoder.z(serialDescriptor, 1) || customerDetails.appUserId) {
                        compositeEncoder.x(serialDescriptor, 1, customerDetails.appUserId);
                    }
                    if (compositeEncoder.z(serialDescriptor, 2) || customerDetails.attConsent) {
                        compositeEncoder.x(serialDescriptor, 2, customerDetails.attConsent);
                    }
                    if (compositeEncoder.z(serialDescriptor, 3) || customerDetails.country) {
                        compositeEncoder.x(serialDescriptor, 3, customerDetails.country);
                    }
                    if (compositeEncoder.z(serialDescriptor, 4) || customerDetails.deviceVersion) {
                        compositeEncoder.x(serialDescriptor, 4, customerDetails.deviceVersion);
                    }
                    if (compositeEncoder.z(serialDescriptor, 5) || customerDetails.email) {
                        compositeEncoder.x(serialDescriptor, 5, customerDetails.email);
                    }
                    if (compositeEncoder.z(serialDescriptor, 6) || customerDetails.facebookAnonId) {
                        compositeEncoder.x(serialDescriptor, 6, customerDetails.facebookAnonId);
                    }
                    if (compositeEncoder.z(serialDescriptor, 7) || customerDetails.idfa) {
                        compositeEncoder.x(serialDescriptor, 7, customerDetails.idfa);
                    }
                    if (compositeEncoder.z(serialDescriptor, 8) || customerDetails.idfv) {
                        compositeEncoder.x(serialDescriptor, 8, customerDetails.idfv);
                    }
                    if (compositeEncoder.z(serialDescriptor, 9) || customerDetails.ip) {
                        compositeEncoder.x(serialDescriptor, 9, customerDetails.ip);
                    }
                    if (compositeEncoder.z(serialDescriptor, 10) || customerDetails.lastOpened) {
                        compositeEncoder.x(serialDescriptor, 10, customerDetails.lastOpened);
                    }
                    if (compositeEncoder.z(serialDescriptor, 11) || customerDetails.lastSeenAppVersion) {
                        compositeEncoder.x(serialDescriptor, 11, customerDetails.lastSeenAppVersion);
                    }
                    if (compositeEncoder.z(serialDescriptor, 12) || customerDetails.totalSpent) {
                        compositeEncoder.x(serialDescriptor, 12, customerDetails.totalSpent);
                    }
                    if (compositeEncoder.z(serialDescriptor, 13) || customerDetails.userSince) {
                        compositeEncoder.x(serialDescriptor, 13, customerDetails.userSince);
                    }
                }

                public final boolean component1() {
                    return this.activeEntitlements;
                }

                public final boolean component10() {
                    return this.ip;
                }

                public final boolean component11() {
                    return this.lastOpened;
                }

                public final boolean component12() {
                    return this.lastSeenAppVersion;
                }

                public final boolean component13() {
                    return this.totalSpent;
                }

                public final boolean component14() {
                    return this.userSince;
                }

                public final boolean component2() {
                    return this.appUserId;
                }

                public final boolean component3() {
                    return this.attConsent;
                }

                public final boolean component4() {
                    return this.country;
                }

                public final boolean component5() {
                    return this.deviceVersion;
                }

                public final boolean component6() {
                    return this.email;
                }

                public final boolean component7() {
                    return this.facebookAnonId;
                }

                public final boolean component8() {
                    return this.idfa;
                }

                public final boolean component9() {
                    return this.idfv;
                }

                public final CustomerDetails copy(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
                    return new CustomerDetails(z2, z3, z4, z5, z6, z7, z8, z9, z10, z11, z12, z13, z14, z15);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof CustomerDetails)) {
                        return false;
                    }
                    CustomerDetails customerDetails = (CustomerDetails) obj;
                    return this.activeEntitlements == customerDetails.activeEntitlements && this.appUserId == customerDetails.appUserId && this.attConsent == customerDetails.attConsent && this.country == customerDetails.country && this.deviceVersion == customerDetails.deviceVersion && this.email == customerDetails.email && this.facebookAnonId == customerDetails.facebookAnonId && this.idfa == customerDetails.idfa && this.idfv == customerDetails.idfv && this.ip == customerDetails.ip && this.lastOpened == customerDetails.lastOpened && this.lastSeenAppVersion == customerDetails.lastSeenAppVersion && this.totalSpent == customerDetails.totalSpent && this.userSince == customerDetails.userSince;
                }

                public final boolean getActiveEntitlements() {
                    return this.activeEntitlements;
                }

                public final boolean getAppUserId() {
                    return this.appUserId;
                }

                public final boolean getAttConsent() {
                    return this.attConsent;
                }

                public final boolean getCountry() {
                    return this.country;
                }

                public final boolean getDeviceVersion() {
                    return this.deviceVersion;
                }

                public final boolean getEmail() {
                    return this.email;
                }

                public final boolean getFacebookAnonId() {
                    return this.facebookAnonId;
                }

                public final boolean getIdfa() {
                    return this.idfa;
                }

                public final boolean getIdfv() {
                    return this.idfv;
                }

                public final boolean getIp() {
                    return this.ip;
                }

                public final boolean getLastOpened() {
                    return this.lastOpened;
                }

                public final boolean getLastSeenAppVersion() {
                    return this.lastSeenAppVersion;
                }

                public final boolean getTotalSpent() {
                    return this.totalSpent;
                }

                public final boolean getUserSince() {
                    return this.userSince;
                }

                public int hashCode() {
                    return (((((((((((((((((((((((((Boolean.hashCode(this.activeEntitlements) * 31) + Boolean.hashCode(this.appUserId)) * 31) + Boolean.hashCode(this.attConsent)) * 31) + Boolean.hashCode(this.country)) * 31) + Boolean.hashCode(this.deviceVersion)) * 31) + Boolean.hashCode(this.email)) * 31) + Boolean.hashCode(this.facebookAnonId)) * 31) + Boolean.hashCode(this.idfa)) * 31) + Boolean.hashCode(this.idfv)) * 31) + Boolean.hashCode(this.ip)) * 31) + Boolean.hashCode(this.lastOpened)) * 31) + Boolean.hashCode(this.lastSeenAppVersion)) * 31) + Boolean.hashCode(this.totalSpent)) * 31) + Boolean.hashCode(this.userSince);
                }

                public String toString() {
                    return "CustomerDetails(activeEntitlements=" + this.activeEntitlements + ", appUserId=" + this.appUserId + ", attConsent=" + this.attConsent + ", country=" + this.country + ", deviceVersion=" + this.deviceVersion + ", email=" + this.email + ", facebookAnonId=" + this.facebookAnonId + ", idfa=" + this.idfa + ", idfv=" + this.idfv + ", ip=" + this.ip + ", lastOpened=" + this.lastOpened + ", lastSeenAppVersion=" + this.lastSeenAppVersion + ", totalSpent=" + this.totalSpent + ", userSince=" + this.userSince + ')';
                }

                @Deprecated
                public /* synthetic */ CustomerDetails(int i3, @SerialName boolean z2, @SerialName boolean z3, @SerialName boolean z4, boolean z5, @SerialName boolean z6, boolean z7, @SerialName boolean z8, boolean z9, boolean z10, boolean z11, @SerialName boolean z12, @SerialName boolean z13, @SerialName boolean z14, @SerialName boolean z15, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((i3 & 1) == 0) {
                        this.activeEntitlements = false;
                    } else {
                        this.activeEntitlements = z2;
                    }
                    if ((i3 & 2) == 0) {
                        this.appUserId = false;
                    } else {
                        this.appUserId = z3;
                    }
                    if ((i3 & 4) == 0) {
                        this.attConsent = false;
                    } else {
                        this.attConsent = z4;
                    }
                    if ((i3 & 8) == 0) {
                        this.country = false;
                    } else {
                        this.country = z5;
                    }
                    if ((i3 & 16) == 0) {
                        this.deviceVersion = false;
                    } else {
                        this.deviceVersion = z6;
                    }
                    if ((i3 & 32) == 0) {
                        this.email = false;
                    } else {
                        this.email = z7;
                    }
                    if ((i3 & 64) == 0) {
                        this.facebookAnonId = false;
                    } else {
                        this.facebookAnonId = z8;
                    }
                    if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
                        this.idfa = false;
                    } else {
                        this.idfa = z9;
                    }
                    if ((i3 & Function.MAX_NARGS) == 0) {
                        this.idfv = false;
                    } else {
                        this.idfv = z10;
                    }
                    if ((i3 & 512) == 0) {
                        this.ip = false;
                    } else {
                        this.ip = z11;
                    }
                    if ((i3 & 1024) == 0) {
                        this.lastOpened = false;
                    } else {
                        this.lastOpened = z12;
                    }
                    if ((i3 & 2048) == 0) {
                        this.lastSeenAppVersion = false;
                    } else {
                        this.lastSeenAppVersion = z13;
                    }
                    if ((i3 & 4096) == 0) {
                        this.totalSpent = false;
                    } else {
                        this.totalSpent = z14;
                    }
                    if ((i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0) {
                        this.userSince = false;
                    } else {
                        this.userSince = z15;
                    }
                }

                public CustomerDetails(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
                    this.activeEntitlements = z2;
                    this.appUserId = z3;
                    this.attConsent = z4;
                    this.country = z5;
                    this.deviceVersion = z6;
                    this.email = z7;
                    this.facebookAnonId = z8;
                    this.idfa = z9;
                    this.idfv = z10;
                    this.ip = z11;
                    this.lastOpened = z12;
                    this.lastSeenAppVersion = z13;
                    this.totalSpent = z14;
                    this.userSince = z15;
                }

                @SerialName
                public static /* synthetic */ void getActiveEntitlements$annotations() {
                }

                @SerialName
                public static /* synthetic */ void getAppUserId$annotations() {
                }

                @SerialName
                public static /* synthetic */ void getAttConsent$annotations() {
                }

                @SerialName
                public static /* synthetic */ void getDeviceVersion$annotations() {
                }

                @SerialName
                public static /* synthetic */ void getFacebookAnonId$annotations() {
                }

                @SerialName
                public static /* synthetic */ void getLastOpened$annotations() {
                }

                @SerialName
                public static /* synthetic */ void getLastSeenAppVersion$annotations() {
                }

                @SerialName
                public static /* synthetic */ void getTotalSpent$annotations() {
                }

                @SerialName
                public static /* synthetic */ void getUserSince$annotations() {
                }

                public /* synthetic */ CustomerDetails(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i3 & 1) != 0 ? false : z2, (i3 & 2) != 0 ? false : z3, (i3 & 4) != 0 ? false : z4, (i3 & 8) != 0 ? false : z5, (i3 & 16) != 0 ? false : z6, (i3 & 32) != 0 ? false : z7, (i3 & 64) != 0 ? false : z8, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? false : z9, (i3 & Function.MAX_NARGS) != 0 ? false : z10, (i3 & 512) != 0 ? false : z11, (i3 & 1024) != 0 ? false : z12, (i3 & 2048) != 0 ? false : z13, (i3 & 4096) != 0 ? false : z14, (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? false : z15);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @Serializable
            public enum CustomerType {
                NOT_ACTIVE,
                NONE,
                ALL,
                ACTIVE;

                public static final Companion Companion = new Companion(null);
                private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Support.SupportTickets.CustomerType.Companion.1
                    @Override // kotlin.jvm.functions.Function0
                    public final KSerializer<Object> invoke() {
                        return EnumsKt.a("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Support.SupportTickets.CustomerType", CustomerType.values(), new String[]{"not_active", IntegrityManager.INTEGRITY_TYPE_NONE, "all", "active"}, new Annotation[][]{null, null, null, null}, null);
                    }
                });

                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private final /* synthetic */ KSerializer get$cachedSerializer() {
                        return (KSerializer) CustomerType.$cachedSerializer$delegate.getValue();
                    }

                    public final KSerializer<CustomerType> serializer() {
                        return get$cachedSerializer();
                    }

                    private Companion() {
                    }
                }
            }

            public SupportTickets() {
                this(false, (CustomerDetails) null, (CustomerType) null, 7, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ SupportTickets copy$default(SupportTickets supportTickets, boolean z2, CustomerDetails customerDetails, CustomerType customerType, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    z2 = supportTickets.allowCreation;
                }
                if ((i3 & 2) != 0) {
                    customerDetails = supportTickets.customerDetails;
                }
                if ((i3 & 4) != 0) {
                    customerType = supportTickets.customerType;
                }
                return supportTickets.copy(z2, customerDetails, customerType);
            }

            @SerialName
            public static /* synthetic */ void getAllowCreation$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getCustomerDetails$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getCustomerType$annotations() {
            }

            /* JADX WARN: Removed duplicated region for block: B:13:0x0045  */
            @kotlin.jvm.JvmStatic
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Support.SupportTickets r23, kotlinx.serialization.encoding.CompositeEncoder r24, kotlinx.serialization.descriptors.SerialDescriptor r25) {
                /*
                    r0 = r23
                    r1 = r24
                    r2 = r25
                    kotlinx.serialization.KSerializer<java.lang.Object>[] r3 = com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Support.SupportTickets.$childSerializers
                    r4 = 0
                    boolean r5 = r1.z(r2, r4)
                    if (r5 == 0) goto L10
                    goto L14
                L10:
                    boolean r5 = r0.allowCreation
                    if (r5 == 0) goto L19
                L14:
                    boolean r5 = r0.allowCreation
                    r1.x(r2, r4, r5)
                L19:
                    r4 = 1
                    boolean r5 = r1.z(r2, r4)
                    if (r5 == 0) goto L21
                    goto L45
                L21:
                    com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Support$SupportTickets$CustomerDetails r5 = r0.customerDetails
                    com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Support$SupportTickets$CustomerDetails r6 = new com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Support$SupportTickets$CustomerDetails
                    r21 = 16383(0x3fff, float:2.2957E-41)
                    r22 = 0
                    r7 = 0
                    r8 = 0
                    r9 = 0
                    r10 = 0
                    r11 = 0
                    r12 = 0
                    r13 = 0
                    r14 = 0
                    r15 = 0
                    r16 = 0
                    r17 = 0
                    r18 = 0
                    r19 = 0
                    r20 = 0
                    r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
                    boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
                    if (r5 != 0) goto L4c
                L45:
                    com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer r5 = com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer.INSTANCE
                    com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Support$SupportTickets$CustomerDetails r6 = r0.customerDetails
                    r1.C(r2, r4, r5, r6)
                L4c:
                    r4 = 2
                    boolean r5 = r1.z(r2, r4)
                    if (r5 == 0) goto L54
                    goto L5a
                L54:
                    com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Support$SupportTickets$CustomerType r5 = r0.customerType
                    com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Support$SupportTickets$CustomerType r6 = com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Support.SupportTickets.CustomerType.NOT_ACTIVE
                    if (r5 == r6) goto L63
                L5a:
                    r3 = r3[r4]
                    kotlinx.serialization.SerializationStrategy r3 = (kotlinx.serialization.SerializationStrategy) r3
                    com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Support$SupportTickets$CustomerType r0 = r0.customerType
                    r1.C(r2, r4, r3, r0)
                L63:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Support.SupportTickets.write$Self$purchases_defaultsBc8Release(com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Support$SupportTickets, kotlinx.serialization.encoding.CompositeEncoder, kotlinx.serialization.descriptors.SerialDescriptor):void");
            }

            public final boolean allowsActiveCustomers() {
                CustomerType customerType = this.customerType;
                return customerType == CustomerType.ALL || customerType == CustomerType.ACTIVE;
            }

            public final boolean allowsNonActiveCustomers() {
                CustomerType customerType = this.customerType;
                return customerType == CustomerType.ALL || customerType == CustomerType.NOT_ACTIVE;
            }

            public final boolean component1() {
                return this.allowCreation;
            }

            public final CustomerDetails component2() {
                return this.customerDetails;
            }

            public final CustomerType component3() {
                return this.customerType;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof SupportTickets)) {
                    return false;
                }
                SupportTickets supportTickets = (SupportTickets) obj;
                return this.allowCreation == supportTickets.allowCreation && Intrinsics.areEqual(this.customerDetails, supportTickets.customerDetails) && this.customerType == supportTickets.customerType;
            }

            public final boolean getAllowCreation() {
                return this.allowCreation;
            }

            public final CustomerDetails getCustomerDetails() {
                return this.customerDetails;
            }

            public final CustomerType getCustomerType() {
                return this.customerType;
            }

            public int hashCode() {
                return (((Boolean.hashCode(this.allowCreation) * 31) + this.customerDetails.hashCode()) * 31) + this.customerType.hashCode();
            }

            public String toString() {
                return "SupportTickets(allowCreation=" + this.allowCreation + ", customerDetails=" + this.customerDetails + ", customerType=" + this.customerType + ')';
            }

            @Deprecated
            public /* synthetic */ SupportTickets(int i3, @SerialName boolean z2, @SerialName CustomerDetails customerDetails, @SerialName CustomerType customerType, SerializationConstructorMarker serializationConstructorMarker) {
                this.allowCreation = (i3 & 1) == 0 ? false : z2;
                if ((i3 & 2) == 0) {
                    this.customerDetails = new CustomerDetails(false, false, false, false, false, false, false, false, false, false, false, false, false, false, 16383, (DefaultConstructorMarker) null);
                } else {
                    this.customerDetails = customerDetails;
                }
                this.customerType = (i3 & 4) == 0 ? CustomerType.NOT_ACTIVE : customerType;
            }

            public final SupportTickets copy(boolean z2, CustomerDetails customerDetails, CustomerType customerType) {
                Intrinsics.checkNotNullParameter(customerDetails, "customerDetails");
                Intrinsics.checkNotNullParameter(customerType, bfIdKSjLOVjG.ZSlgEjxupoRKb);
                return new SupportTickets(z2, customerDetails, customerType);
            }

            public SupportTickets(boolean z2, CustomerDetails customerDetails, CustomerType customerType) {
                Intrinsics.checkNotNullParameter(customerDetails, "customerDetails");
                Intrinsics.checkNotNullParameter(customerType, "customerType");
                this.allowCreation = z2;
                this.customerDetails = customerDetails;
                this.customerType = customerType;
            }

            public /* synthetic */ SupportTickets(boolean z2, CustomerDetails customerDetails, CustomerType customerType, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this((i3 & 1) != 0 ? false : z2, (i3 & 2) != 0 ? new CustomerDetails(false, false, false, false, false, false, false, false, false, false, false, false, false, false, 16383, (DefaultConstructorMarker) null) : customerDetails, (i3 & 4) != 0 ? CustomerType.NOT_ACTIVE : customerType);
            }
        }

        public Support() {
            this((String) null, (Boolean) null, (Boolean) null, (SupportTickets) null, 15, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Support copy$default(Support support, String str, Boolean bool, Boolean bool2, SupportTickets supportTickets, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = support.email;
            }
            if ((i3 & 2) != 0) {
                bool = support.shouldWarnCustomerToUpdate;
            }
            if ((i3 & 4) != 0) {
                bool2 = support.displayVirtualCurrencies;
            }
            if ((i3 & 8) != 0) {
                supportTickets = support.supportTickets;
            }
            return support.copy(str, bool, bool2, supportTickets);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Support support, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            if (compositeEncoder.z(serialDescriptor, 0) || support.email != null) {
                compositeEncoder.i(serialDescriptor, 0, EmptyStringToNullSerializer.INSTANCE, support.email);
            }
            if (compositeEncoder.z(serialDescriptor, 1) || support.shouldWarnCustomerToUpdate != null) {
                compositeEncoder.i(serialDescriptor, 1, BooleanSerializer.f142767a, support.shouldWarnCustomerToUpdate);
            }
            if (compositeEncoder.z(serialDescriptor, 2) || support.displayVirtualCurrencies != null) {
                compositeEncoder.i(serialDescriptor, 2, BooleanSerializer.f142767a, support.displayVirtualCurrencies);
            }
            if (!compositeEncoder.z(serialDescriptor, 3)) {
                if (Intrinsics.areEqual(support.supportTickets, new SupportTickets(false, (SupportTickets.CustomerDetails) null, (SupportTickets.CustomerType) null, 7, (DefaultConstructorMarker) null))) {
                    return;
                }
            }
            compositeEncoder.C(serialDescriptor, 3, CustomerCenterConfigData$Support$SupportTickets$$serializer.INSTANCE, support.supportTickets);
        }

        public final String component1() {
            return this.email;
        }

        public final Boolean component2() {
            return this.shouldWarnCustomerToUpdate;
        }

        public final Boolean component3() {
            return this.displayVirtualCurrencies;
        }

        public final SupportTickets component4() {
            return this.supportTickets;
        }

        public final Support copy(String str, Boolean bool, Boolean bool2, SupportTickets supportTickets) {
            Intrinsics.checkNotNullParameter(supportTickets, "supportTickets");
            return new Support(str, bool, bool2, supportTickets);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Support)) {
                return false;
            }
            Support support = (Support) obj;
            return Intrinsics.areEqual(this.email, support.email) && Intrinsics.areEqual(this.shouldWarnCustomerToUpdate, support.shouldWarnCustomerToUpdate) && Intrinsics.areEqual(this.displayVirtualCurrencies, support.displayVirtualCurrencies) && Intrinsics.areEqual(this.supportTickets, support.supportTickets);
        }

        public final Boolean getDisplayVirtualCurrencies() {
            return this.displayVirtualCurrencies;
        }

        public final String getEmail() {
            return this.email;
        }

        public final Boolean getShouldWarnCustomerToUpdate() {
            return this.shouldWarnCustomerToUpdate;
        }

        public final SupportTickets getSupportTickets() {
            return this.supportTickets;
        }

        public int hashCode() {
            String str = this.email;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            Boolean bool = this.shouldWarnCustomerToUpdate;
            int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.displayVirtualCurrencies;
            return ((iHashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31) + this.supportTickets.hashCode();
        }

        public String toString() {
            return "Support(email=" + this.email + ", shouldWarnCustomerToUpdate=" + this.shouldWarnCustomerToUpdate + ", displayVirtualCurrencies=" + this.displayVirtualCurrencies + ", supportTickets=" + this.supportTickets + ')';
        }

        @Deprecated
        public /* synthetic */ Support(int i3, @Serializable(with = EmptyStringToNullSerializer.class) String str, @SerialName Boolean bool, @SerialName Boolean bool2, @SerialName SupportTickets supportTickets, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i3 & 1) == 0) {
                this.email = null;
            } else {
                this.email = str;
            }
            if ((i3 & 2) == 0) {
                this.shouldWarnCustomerToUpdate = null;
            } else {
                this.shouldWarnCustomerToUpdate = bool;
            }
            if ((i3 & 4) == 0) {
                this.displayVirtualCurrencies = null;
            } else {
                this.displayVirtualCurrencies = bool2;
            }
            if ((i3 & 8) != 0) {
                this.supportTickets = supportTickets;
                return;
            }
            this.supportTickets = new SupportTickets(false, (SupportTickets.CustomerDetails) null, (SupportTickets.CustomerType) null, 7, (DefaultConstructorMarker) null);
        }

        public Support(String str, Boolean bool, Boolean bool2, SupportTickets supportTickets) {
            Intrinsics.checkNotNullParameter(supportTickets, "supportTickets");
            this.email = str;
            this.shouldWarnCustomerToUpdate = bool;
            this.displayVirtualCurrencies = bool2;
            this.supportTickets = supportTickets;
        }

        public /* synthetic */ Support(String str, Boolean bool, Boolean bool2, SupportTickets supportTickets, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : bool, (i3 & 4) != 0 ? null : bool2, (i3 & 8) != 0 ? new SupportTickets(false, (SupportTickets.CustomerDetails) null, (SupportTickets.CustomerType) null, 7, (DefaultConstructorMarker) null) : supportTickets);
        }

        @SerialName
        public static /* synthetic */ void getDisplayVirtualCurrencies$annotations() {
        }

        @Serializable(with = EmptyStringToNullSerializer.class)
        public static /* synthetic */ void getEmail$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getShouldWarnCustomerToUpdate$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getSupportTickets$annotations() {
        }
    }

    @Deprecated
    public /* synthetic */ CustomerCenterConfigData(int i3, @Serializable(with = ScreenMapSerializer.class) Map map, Appearance appearance, Localization localization, Support support, @SerialName @Serializable(with = EmptyStringToNullSerializer.class) String str, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i3 & 15)) {
            PluginExceptionsKt.b(i3, 15, CustomerCenterConfigData$$serializer.INSTANCE.getDescriptor());
        }
        this.screens = map;
        this.appearance = appearance;
        this.localization = localization;
        this.support = support;
        if ((i3 & 16) == 0) {
            this.lastPublishedAppVersion = null;
        } else {
            this.lastPublishedAppVersion = str;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CustomerCenterConfigData copy$default(CustomerCenterConfigData customerCenterConfigData, Map map, Appearance appearance, Localization localization, Support support, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            map = customerCenterConfigData.screens;
        }
        if ((i3 & 2) != 0) {
            appearance = customerCenterConfigData.appearance;
        }
        if ((i3 & 4) != 0) {
            localization = customerCenterConfigData.localization;
        }
        if ((i3 & 8) != 0) {
            support = customerCenterConfigData.support;
        }
        if ((i3 & 16) != 0) {
            str = customerCenterConfigData.lastPublishedAppVersion;
        }
        String str2 = str;
        Localization localization2 = localization;
        return customerCenterConfigData.copy(map, appearance, localization2, support, str2);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(CustomerCenterConfigData customerCenterConfigData, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.C(serialDescriptor, 0, ScreenMapSerializer.INSTANCE, customerCenterConfigData.screens);
        compositeEncoder.C(serialDescriptor, 1, CustomerCenterConfigData$Appearance$$serializer.INSTANCE, customerCenterConfigData.appearance);
        compositeEncoder.C(serialDescriptor, 2, CustomerCenterConfigData$Localization$$serializer.INSTANCE, customerCenterConfigData.localization);
        compositeEncoder.C(serialDescriptor, 3, CustomerCenterConfigData$Support$$serializer.INSTANCE, customerCenterConfigData.support);
        if (!compositeEncoder.z(serialDescriptor, 4) && customerCenterConfigData.lastPublishedAppVersion == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 4, EmptyStringToNullSerializer.INSTANCE, customerCenterConfigData.lastPublishedAppVersion);
    }

    public final Map<Screen.ScreenType, Screen> component1() {
        return this.screens;
    }

    public final Appearance component2() {
        return this.appearance;
    }

    public final Localization component3() {
        return this.localization;
    }

    public final Support component4() {
        return this.support;
    }

    public final String component5() {
        return this.lastPublishedAppVersion;
    }

    public final CustomerCenterConfigData copy(Map<Screen.ScreenType, Screen> screens, Appearance appearance, Localization localization, Support support, String str) {
        Intrinsics.checkNotNullParameter(screens, "screens");
        Intrinsics.checkNotNullParameter(appearance, "appearance");
        Intrinsics.checkNotNullParameter(localization, "localization");
        Intrinsics.checkNotNullParameter(support, "support");
        return new CustomerCenterConfigData(screens, appearance, localization, support, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomerCenterConfigData)) {
            return false;
        }
        CustomerCenterConfigData customerCenterConfigData = (CustomerCenterConfigData) obj;
        return Intrinsics.areEqual(this.screens, customerCenterConfigData.screens) && Intrinsics.areEqual(this.appearance, customerCenterConfigData.appearance) && Intrinsics.areEqual(this.localization, customerCenterConfigData.localization) && Intrinsics.areEqual(this.support, customerCenterConfigData.support) && Intrinsics.areEqual(this.lastPublishedAppVersion, customerCenterConfigData.lastPublishedAppVersion);
    }

    public final Appearance getAppearance() {
        return this.appearance;
    }

    public final String getLastPublishedAppVersion() {
        return this.lastPublishedAppVersion;
    }

    public final Localization getLocalization() {
        return this.localization;
    }

    public final Screen getManagementScreen() {
        return this.screens.get(Screen.ScreenType.MANAGEMENT);
    }

    public final Screen getNoActiveScreen() {
        return this.screens.get(Screen.ScreenType.NO_ACTIVE);
    }

    public final Map<Screen.ScreenType, Screen> getScreens() {
        return this.screens;
    }

    public final Support getSupport() {
        return this.support;
    }

    public int hashCode() {
        int iHashCode = ((((((this.screens.hashCode() * 31) + this.appearance.hashCode()) * 31) + this.localization.hashCode()) * 31) + this.support.hashCode()) * 31;
        String str = this.lastPublishedAppVersion;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "CustomerCenterConfigData(screens=" + this.screens + ", appearance=" + this.appearance + ", localization=" + this.localization + ", support=" + this.support + ", lastPublishedAppVersion=" + this.lastPublishedAppVersion + ')';
    }

    public CustomerCenterConfigData(Map<Screen.ScreenType, Screen> screens, Appearance appearance, Localization localization, Support support, String str) {
        Intrinsics.checkNotNullParameter(screens, "screens");
        Intrinsics.checkNotNullParameter(appearance, "appearance");
        Intrinsics.checkNotNullParameter(localization, "localization");
        Intrinsics.checkNotNullParameter(support, "support");
        this.screens = screens;
        this.appearance = appearance;
        this.localization = localization;
        this.support = support;
        this.lastPublishedAppVersion = str;
    }

    public /* synthetic */ CustomerCenterConfigData(Map map, Appearance appearance, Localization localization, Support support, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, appearance, localization, support, (i3 & 16) != 0 ? null : str);
    }

    @SerialName
    @Serializable(with = EmptyStringToNullSerializer.class)
    public static /* synthetic */ void getLastPublishedAppVersion$annotations() {
    }

    @Serializable(with = ScreenMapSerializer.class)
    public static /* synthetic */ void getScreens$annotations() {
    }
}
