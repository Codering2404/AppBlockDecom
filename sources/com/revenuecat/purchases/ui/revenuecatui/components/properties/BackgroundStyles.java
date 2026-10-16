package com.revenuecat.purchases.ui.revenuecatui.components.properties;

import androidx.compose.ui.layout.ContentScale;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeVideoUrls;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public interface BackgroundStyles {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @JvmInline
    public static final class Color implements BackgroundStyles {
        private final ColorStyles color;

        private /* synthetic */ Color(ColorStyles colorStyles) {
            this.color = colorStyles;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Color m753boximpl(ColorStyles colorStyles) {
            return new Color(colorStyles);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static ColorStyles m754constructorimpl(ColorStyles color) {
            Intrinsics.checkNotNullParameter(color, "color");
            return color;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m755equalsimpl(ColorStyles colorStyles, Object obj) {
            return (obj instanceof Color) && Intrinsics.areEqual(colorStyles, ((Color) obj).m759unboximpl());
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m756equalsimpl0(ColorStyles colorStyles, ColorStyles colorStyles2) {
            return Intrinsics.areEqual(colorStyles, colorStyles2);
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m757hashCodeimpl(ColorStyles colorStyles) {
            return colorStyles.hashCode();
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m758toStringimpl(ColorStyles colorStyles) {
            return "Color(color=" + colorStyles + ')';
        }

        public boolean equals(Object obj) {
            return m755equalsimpl(this.color, obj);
        }

        public final /* synthetic */ ColorStyles getColor() {
            return this.color;
        }

        public int hashCode() {
            return m757hashCodeimpl(this.color);
        }

        public String toString() {
            return m758toStringimpl(this.color);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ ColorStyles m759unboximpl() {
            return this.color;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Image implements BackgroundStyles {
        public static final int $stable = 0;
        private final ColorStyles colorOverlay;
        private final ContentScale contentScale;
        private final ThemeImageUrls sources;

        public Image(ThemeImageUrls sources, ContentScale contentScale, ColorStyles colorStyles) {
            Intrinsics.checkNotNullParameter(sources, "sources");
            Intrinsics.checkNotNullParameter(contentScale, "contentScale");
            this.sources = sources;
            this.contentScale = contentScale;
            this.colorOverlay = colorStyles;
        }

        public static /* synthetic */ Image copy$default(Image image, ThemeImageUrls themeImageUrls, ContentScale contentScale, ColorStyles colorStyles, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                themeImageUrls = image.sources;
            }
            if ((i3 & 2) != 0) {
                contentScale = image.contentScale;
            }
            if ((i3 & 4) != 0) {
                colorStyles = image.colorOverlay;
            }
            return image.copy(themeImageUrls, contentScale, colorStyles);
        }

        public final ThemeImageUrls component1() {
            return this.sources;
        }

        public final ContentScale component2() {
            return this.contentScale;
        }

        public final ColorStyles component3() {
            return this.colorOverlay;
        }

        public final Image copy(ThemeImageUrls sources, ContentScale contentScale, ColorStyles colorStyles) {
            Intrinsics.checkNotNullParameter(sources, "sources");
            Intrinsics.checkNotNullParameter(contentScale, "contentScale");
            return new Image(sources, contentScale, colorStyles);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Image)) {
                return false;
            }
            Image image = (Image) obj;
            return Intrinsics.areEqual(this.sources, image.sources) && Intrinsics.areEqual(this.contentScale, image.contentScale) && Intrinsics.areEqual(this.colorOverlay, image.colorOverlay);
        }

        public final /* synthetic */ ColorStyles getColorOverlay() {
            return this.colorOverlay;
        }

        public final /* synthetic */ ContentScale getContentScale() {
            return this.contentScale;
        }

        public final /* synthetic */ ThemeImageUrls getSources() {
            return this.sources;
        }

        public int hashCode() {
            int iHashCode = ((this.sources.hashCode() * 31) + this.contentScale.hashCode()) * 31;
            ColorStyles colorStyles = this.colorOverlay;
            return iHashCode + (colorStyles == null ? 0 : colorStyles.hashCode());
        }

        public String toString() {
            return "Image(sources=" + this.sources + ", contentScale=" + this.contentScale + ", colorOverlay=" + this.colorOverlay + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Video implements BackgroundStyles {
        public static final int $stable = 0;
        private final ColorStyles colorOverlay;
        private final ContentScale contentScale;
        private final ThemeImageUrls fallbackImage;
        private final boolean loop;
        private final boolean muteAudio;
        private final ThemeVideoUrls sources;

        public Video(ThemeVideoUrls sources, ThemeImageUrls fallbackImage, boolean z2, boolean z3, ContentScale contentScale, ColorStyles colorStyles) {
            Intrinsics.checkNotNullParameter(sources, "sources");
            Intrinsics.checkNotNullParameter(fallbackImage, "fallbackImage");
            Intrinsics.checkNotNullParameter(contentScale, "contentScale");
            this.sources = sources;
            this.fallbackImage = fallbackImage;
            this.loop = z2;
            this.muteAudio = z3;
            this.contentScale = contentScale;
            this.colorOverlay = colorStyles;
        }

        public static /* synthetic */ Video copy$default(Video video, ThemeVideoUrls themeVideoUrls, ThemeImageUrls themeImageUrls, boolean z2, boolean z3, ContentScale contentScale, ColorStyles colorStyles, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                themeVideoUrls = video.sources;
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
                contentScale = video.contentScale;
            }
            if ((i3 & 32) != 0) {
                colorStyles = video.colorOverlay;
            }
            ContentScale contentScale2 = contentScale;
            ColorStyles colorStyles2 = colorStyles;
            return video.copy(themeVideoUrls, themeImageUrls, z2, z3, contentScale2, colorStyles2);
        }

        public final ThemeVideoUrls component1() {
            return this.sources;
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

        public final ContentScale component5() {
            return this.contentScale;
        }

        public final ColorStyles component6() {
            return this.colorOverlay;
        }

        public final Video copy(ThemeVideoUrls sources, ThemeImageUrls fallbackImage, boolean z2, boolean z3, ContentScale contentScale, ColorStyles colorStyles) {
            Intrinsics.checkNotNullParameter(sources, "sources");
            Intrinsics.checkNotNullParameter(fallbackImage, "fallbackImage");
            Intrinsics.checkNotNullParameter(contentScale, "contentScale");
            return new Video(sources, fallbackImage, z2, z3, contentScale, colorStyles);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Video)) {
                return false;
            }
            Video video = (Video) obj;
            return Intrinsics.areEqual(this.sources, video.sources) && Intrinsics.areEqual(this.fallbackImage, video.fallbackImage) && this.loop == video.loop && this.muteAudio == video.muteAudio && Intrinsics.areEqual(this.contentScale, video.contentScale) && Intrinsics.areEqual(this.colorOverlay, video.colorOverlay);
        }

        public final /* synthetic */ ColorStyles getColorOverlay() {
            return this.colorOverlay;
        }

        public final /* synthetic */ ContentScale getContentScale() {
            return this.contentScale;
        }

        public final /* synthetic */ ThemeImageUrls getFallbackImage() {
            return this.fallbackImage;
        }

        public final /* synthetic */ boolean getLoop() {
            return this.loop;
        }

        public final /* synthetic */ boolean getMuteAudio() {
            return this.muteAudio;
        }

        public final /* synthetic */ ThemeVideoUrls getSources() {
            return this.sources;
        }

        public int hashCode() {
            int iHashCode = ((((((((this.sources.hashCode() * 31) + this.fallbackImage.hashCode()) * 31) + Boolean.hashCode(this.loop)) * 31) + Boolean.hashCode(this.muteAudio)) * 31) + this.contentScale.hashCode()) * 31;
            ColorStyles colorStyles = this.colorOverlay;
            return iHashCode + (colorStyles == null ? 0 : colorStyles.hashCode());
        }

        public String toString() {
            return "Video(sources=" + this.sources + ", fallbackImage=" + this.fallbackImage + ", loop=" + this.loop + ", muteAudio=" + this.muteAudio + ", contentScale=" + this.contentScale + ", colorOverlay=" + this.colorOverlay + ')';
        }
    }
}
