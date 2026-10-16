package com.revenuecat.purchases.paywalls.components.common;

import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.FitMode;
import com.revenuecat.purchases.paywalls.components.properties.FitModeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ThemeVideoUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeVideoUrls$$serializer;
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
@Metadata
@Serializable(with = BackgroundDeserializer.class)
public interface Background {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class Color implements Background {
        public static final Companion Companion = new Companion(null);
        private final ColorScheme value;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Color> serializer() {
                return Background$Color$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        @Deprecated
        public /* synthetic */ Color(int i3, ColorScheme colorScheme, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, Background$Color$$serializer.INSTANCE.getDescriptor());
            }
            this.value = colorScheme;
        }

        public static /* synthetic */ Color copy$default(Color color, ColorScheme colorScheme, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                colorScheme = color.value;
            }
            return color.copy(colorScheme);
        }

        public final ColorScheme component1() {
            return this.value;
        }

        public final Color copy(ColorScheme value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new Color(value);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Color) && Intrinsics.areEqual(this.value, ((Color) obj).value);
        }

        public final /* synthetic */ ColorScheme getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "Color(value=" + this.value + ')';
        }

        public Color(ColorScheme value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final KSerializer<Background> serializer() {
            return BackgroundDeserializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class Unknown implements Background {
        public static final Companion Companion = new Companion(null);
        private final String type;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Unknown> serializer() {
                return Background$Unknown$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        @Deprecated
        public /* synthetic */ Unknown(int i3, String str, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, Background$Unknown$$serializer.INSTANCE.getDescriptor());
            }
            this.type = str;
        }

        public static /* synthetic */ Unknown copy$default(Unknown unknown, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = unknown.type;
            }
            return unknown.copy(str);
        }

        public final String component1() {
            return this.type;
        }

        public final Unknown copy(String type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new Unknown(type);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Unknown) && Intrinsics.areEqual(this.type, ((Unknown) obj).type);
        }

        public final /* synthetic */ String getType() {
            return this.type;
        }

        public int hashCode() {
            return this.type.hashCode();
        }

        public String toString() {
            return "Unknown(type=" + this.type + ')';
        }

        public Unknown(String type) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class Image implements Background {
        public static final Companion Companion = new Companion(null);
        private final ColorScheme colorOverlay;
        private final FitMode fitMode;
        private final ThemeImageUrls value;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Image> serializer() {
                return Background$Image$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        @Deprecated
        public /* synthetic */ Image(int i3, ThemeImageUrls themeImageUrls, @SerialName FitMode fitMode, @SerialName ColorScheme colorScheme, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, Background$Image$$serializer.INSTANCE.getDescriptor());
            }
            this.value = themeImageUrls;
            if ((i3 & 2) == 0) {
                this.fitMode = FitMode.FILL;
            } else {
                this.fitMode = fitMode;
            }
            if ((i3 & 4) == 0) {
                this.colorOverlay = null;
            } else {
                this.colorOverlay = colorScheme;
            }
        }

        public static /* synthetic */ Image copy$default(Image image, ThemeImageUrls themeImageUrls, FitMode fitMode, ColorScheme colorScheme, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                themeImageUrls = image.value;
            }
            if ((i3 & 2) != 0) {
                fitMode = image.fitMode;
            }
            if ((i3 & 4) != 0) {
                colorScheme = image.colorOverlay;
            }
            return image.copy(themeImageUrls, fitMode, colorScheme);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Image image, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            compositeEncoder.C(serialDescriptor, 0, ThemeImageUrls$$serializer.INSTANCE, image.value);
            if (compositeEncoder.z(serialDescriptor, 1) || image.fitMode != FitMode.FILL) {
                compositeEncoder.C(serialDescriptor, 1, FitModeDeserializer.INSTANCE, image.fitMode);
            }
            if (!compositeEncoder.z(serialDescriptor, 2) && image.colorOverlay == null) {
                return;
            }
            compositeEncoder.i(serialDescriptor, 2, ColorScheme$$serializer.INSTANCE, image.colorOverlay);
        }

        public final ThemeImageUrls component1() {
            return this.value;
        }

        public final FitMode component2() {
            return this.fitMode;
        }

        public final ColorScheme component3() {
            return this.colorOverlay;
        }

        public final Image copy(ThemeImageUrls value, FitMode fitMode, ColorScheme colorScheme) {
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(fitMode, "fitMode");
            return new Image(value, fitMode, colorScheme);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Image)) {
                return false;
            }
            Image image = (Image) obj;
            return Intrinsics.areEqual(this.value, image.value) && this.fitMode == image.fitMode && Intrinsics.areEqual(this.colorOverlay, image.colorOverlay);
        }

        public final /* synthetic */ ColorScheme getColorOverlay() {
            return this.colorOverlay;
        }

        public final /* synthetic */ FitMode getFitMode() {
            return this.fitMode;
        }

        public final /* synthetic */ ThemeImageUrls getValue() {
            return this.value;
        }

        public int hashCode() {
            int iHashCode = ((this.value.hashCode() * 31) + this.fitMode.hashCode()) * 31;
            ColorScheme colorScheme = this.colorOverlay;
            return iHashCode + (colorScheme == null ? 0 : colorScheme.hashCode());
        }

        public String toString() {
            return "Image(value=" + this.value + ", fitMode=" + this.fitMode + ", colorOverlay=" + this.colorOverlay + ')';
        }

        public Image(ThemeImageUrls value, FitMode fitMode, ColorScheme colorScheme) {
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(fitMode, "fitMode");
            this.value = value;
            this.fitMode = fitMode;
            this.colorOverlay = colorScheme;
        }

        public /* synthetic */ Image(ThemeImageUrls themeImageUrls, FitMode fitMode, ColorScheme colorScheme, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(themeImageUrls, (i3 & 2) != 0 ? FitMode.FILL : fitMode, (i3 & 4) != 0 ? null : colorScheme);
        }

        @SerialName
        public static /* synthetic */ void getColorOverlay$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getFitMode$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class Video implements Background {
        public static final Companion Companion = new Companion(null);
        private final ColorScheme colorOverlay;
        private final ThemeImageUrls fallbackImage;
        private final FitMode fitMode;
        private final boolean loop;
        private final boolean muteAudio;
        private final ThemeVideoUrls value;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Video> serializer() {
                return Background$Video$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        @Deprecated
        public /* synthetic */ Video(int i3, ThemeVideoUrls themeVideoUrls, @SerialName ThemeImageUrls themeImageUrls, boolean z2, @SerialName boolean z3, @SerialName FitMode fitMode, @SerialName ColorScheme colorScheme, SerializationConstructorMarker serializationConstructorMarker) {
            if (15 != (i3 & 15)) {
                PluginExceptionsKt.b(i3, 15, Background$Video$$serializer.INSTANCE.getDescriptor());
            }
            this.value = themeVideoUrls;
            this.fallbackImage = themeImageUrls;
            this.loop = z2;
            this.muteAudio = z3;
            if ((i3 & 16) == 0) {
                this.fitMode = FitMode.FILL;
            } else {
                this.fitMode = fitMode;
            }
            if ((i3 & 32) == 0) {
                this.colorOverlay = null;
            } else {
                this.colorOverlay = colorScheme;
            }
        }

        public static /* synthetic */ Video copy$default(Video video, ThemeVideoUrls themeVideoUrls, ThemeImageUrls themeImageUrls, boolean z2, boolean z3, FitMode fitMode, ColorScheme colorScheme, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                themeVideoUrls = video.value;
            }
            if ((i3 & 2) != 0) {
                themeImageUrls = video.fallbackImage;
            }
            if ((i3 & 4) != 0) {
                z2 = video.loop;
            }
            if ((i3 & 8) != 0) {
                z3 = video.muteAudio;
            }
            if ((i3 & 16) != 0) {
                fitMode = video.fitMode;
            }
            if ((i3 & 32) != 0) {
                colorScheme = video.colorOverlay;
            }
            FitMode fitMode2 = fitMode;
            ColorScheme colorScheme2 = colorScheme;
            return video.copy(themeVideoUrls, themeImageUrls, z2, z3, fitMode2, colorScheme2);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Video video, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            compositeEncoder.C(serialDescriptor, 0, ThemeVideoUrls$$serializer.INSTANCE, video.value);
            compositeEncoder.C(serialDescriptor, 1, ThemeImageUrls$$serializer.INSTANCE, video.fallbackImage);
            compositeEncoder.x(serialDescriptor, 2, video.loop);
            compositeEncoder.x(serialDescriptor, 3, video.muteAudio);
            if (compositeEncoder.z(serialDescriptor, 4) || video.fitMode != FitMode.FILL) {
                compositeEncoder.C(serialDescriptor, 4, FitModeDeserializer.INSTANCE, video.fitMode);
            }
            if (!compositeEncoder.z(serialDescriptor, 5) && video.colorOverlay == null) {
                return;
            }
            compositeEncoder.i(serialDescriptor, 5, ColorScheme$$serializer.INSTANCE, video.colorOverlay);
        }

        public final ThemeVideoUrls component1() {
            return this.value;
        }

        public final ThemeImageUrls component2() {
            return this.fallbackImage;
        }

        public final boolean component3() {
            return this.loop;
        }

        public final boolean component4() {
            return this.muteAudio;
        }

        public final FitMode component5() {
            return this.fitMode;
        }

        public final ColorScheme component6() {
            return this.colorOverlay;
        }

        public final Video copy(ThemeVideoUrls value, ThemeImageUrls fallbackImage, boolean z2, boolean z3, FitMode fitMode, ColorScheme colorScheme) {
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(fallbackImage, "fallbackImage");
            Intrinsics.checkNotNullParameter(fitMode, "fitMode");
            return new Video(value, fallbackImage, z2, z3, fitMode, colorScheme);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Video)) {
                return false;
            }
            Video video = (Video) obj;
            return Intrinsics.areEqual(this.value, video.value) && Intrinsics.areEqual(this.fallbackImage, video.fallbackImage) && this.loop == video.loop && this.muteAudio == video.muteAudio && this.fitMode == video.fitMode && Intrinsics.areEqual(this.colorOverlay, video.colorOverlay);
        }

        public final /* synthetic */ ColorScheme getColorOverlay() {
            return this.colorOverlay;
        }

        public final /* synthetic */ ThemeImageUrls getFallbackImage() {
            return this.fallbackImage;
        }

        public final /* synthetic */ FitMode getFitMode() {
            return this.fitMode;
        }

        public final /* synthetic */ boolean getLoop() {
            return this.loop;
        }

        public final /* synthetic */ boolean getMuteAudio() {
            return this.muteAudio;
        }

        public final /* synthetic */ ThemeVideoUrls getValue() {
            return this.value;
        }

        public int hashCode() {
            int iHashCode = ((((((((this.value.hashCode() * 31) + this.fallbackImage.hashCode()) * 31) + Boolean.hashCode(this.loop)) * 31) + Boolean.hashCode(this.muteAudio)) * 31) + this.fitMode.hashCode()) * 31;
            ColorScheme colorScheme = this.colorOverlay;
            return iHashCode + (colorScheme == null ? 0 : colorScheme.hashCode());
        }

        public String toString() {
            return "Video(value=" + this.value + ", fallbackImage=" + this.fallbackImage + ", loop=" + this.loop + ", muteAudio=" + this.muteAudio + ", fitMode=" + this.fitMode + ", colorOverlay=" + this.colorOverlay + ')';
        }

        public Video(ThemeVideoUrls value, ThemeImageUrls fallbackImage, boolean z2, boolean z3, FitMode fitMode, ColorScheme colorScheme) {
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(fallbackImage, "fallbackImage");
            Intrinsics.checkNotNullParameter(fitMode, "fitMode");
            this.value = value;
            this.fallbackImage = fallbackImage;
            this.loop = z2;
            this.muteAudio = z3;
            this.fitMode = fitMode;
            this.colorOverlay = colorScheme;
        }

        public /* synthetic */ Video(ThemeVideoUrls themeVideoUrls, ThemeImageUrls themeImageUrls, boolean z2, boolean z3, FitMode fitMode, ColorScheme colorScheme, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(themeVideoUrls, themeImageUrls, z2, z3, (i3 & 16) != 0 ? FitMode.FILL : fitMode, (i3 & 32) != 0 ? null : colorScheme);
        }

        @SerialName
        public static /* synthetic */ void getColorOverlay$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getFallbackImage$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getFitMode$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getMuteAudio$annotations() {
        }
    }
}
