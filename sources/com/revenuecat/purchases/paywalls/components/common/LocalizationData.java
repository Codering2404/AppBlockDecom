package com.revenuecat.purchases.paywalls.components.common;

import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeVideoUrls;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

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
@Serializable(with = LocalizationDataSerializer.class)
public interface LocalizationData {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final KSerializer<LocalizationData> serializer() {
            return LocalizationDataSerializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @JvmInline
    public static final class Image implements LocalizationData {
        public static final Companion Companion = new Companion(null);
        private final ThemeImageUrls value;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Image> serializer() {
                return LocalizationData$Image$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        private /* synthetic */ Image(ThemeImageUrls themeImageUrls) {
            this.value = themeImageUrls;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Image m621boximpl(ThemeImageUrls themeImageUrls) {
            return new Image(themeImageUrls);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static ThemeImageUrls m622constructorimpl(ThemeImageUrls value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return value;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m623equalsimpl(ThemeImageUrls themeImageUrls, Object obj) {
            return (obj instanceof Image) && Intrinsics.areEqual(themeImageUrls, ((Image) obj).m627unboximpl());
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m624equalsimpl0(ThemeImageUrls themeImageUrls, ThemeImageUrls themeImageUrls2) {
            return Intrinsics.areEqual(themeImageUrls, themeImageUrls2);
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m625hashCodeimpl(ThemeImageUrls themeImageUrls) {
            return themeImageUrls.hashCode();
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m626toStringimpl(ThemeImageUrls themeImageUrls) {
            return "Image(value=" + themeImageUrls + ')';
        }

        public boolean equals(Object obj) {
            return m623equalsimpl(this.value, obj);
        }

        public final /* synthetic */ ThemeImageUrls getValue() {
            return this.value;
        }

        public int hashCode() {
            return m625hashCodeimpl(this.value);
        }

        public String toString() {
            return m626toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ ThemeImageUrls m627unboximpl() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @JvmInline
    public static final class Text implements LocalizationData {
        public static final Companion Companion = new Companion(null);
        private final String value;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Text> serializer() {
                return LocalizationData$Text$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        private /* synthetic */ Text(String str) {
            this.value = str;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Text m630boximpl(String str) {
            return new Text(str);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static String m631constructorimpl(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return value;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m632equalsimpl(String str, Object obj) {
            return (obj instanceof Text) && Intrinsics.areEqual(str, ((Text) obj).m636unboximpl());
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m633equalsimpl0(String str, String str2) {
            return Intrinsics.areEqual(str, str2);
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m634hashCodeimpl(String str) {
            return str.hashCode();
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m635toStringimpl(String str) {
            return "Text(value=" + str + ')';
        }

        public boolean equals(Object obj) {
            return m632equalsimpl(this.value, obj);
        }

        public final /* synthetic */ String getValue() {
            return this.value;
        }

        public int hashCode() {
            return m634hashCodeimpl(this.value);
        }

        public String toString() {
            return m635toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ String m636unboximpl() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @JvmInline
    public static final class Video implements LocalizationData {
        public static final Companion Companion = new Companion(null);
        private final ThemeVideoUrls value;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Video> serializer() {
                return LocalizationData$Video$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        private /* synthetic */ Video(ThemeVideoUrls themeVideoUrls) {
            this.value = themeVideoUrls;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Video m639boximpl(ThemeVideoUrls themeVideoUrls) {
            return new Video(themeVideoUrls);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static ThemeVideoUrls m640constructorimpl(ThemeVideoUrls value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return value;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m641equalsimpl(ThemeVideoUrls themeVideoUrls, Object obj) {
            return (obj instanceof Video) && Intrinsics.areEqual(themeVideoUrls, ((Video) obj).m645unboximpl());
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m642equalsimpl0(ThemeVideoUrls themeVideoUrls, ThemeVideoUrls themeVideoUrls2) {
            return Intrinsics.areEqual(themeVideoUrls, themeVideoUrls2);
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m643hashCodeimpl(ThemeVideoUrls themeVideoUrls) {
            return themeVideoUrls.hashCode();
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m644toStringimpl(ThemeVideoUrls themeVideoUrls) {
            return "Video(value=" + themeVideoUrls + ')';
        }

        public boolean equals(Object obj) {
            return m641equalsimpl(this.value, obj);
        }

        public final /* synthetic */ ThemeVideoUrls getValue() {
            return this.value;
        }

        public int hashCode() {
            return m643hashCodeimpl(this.value);
        }

        public String toString() {
            return m644toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ ThemeVideoUrls m645unboximpl() {
            return this.value;
        }
    }
}
