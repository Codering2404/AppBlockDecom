package com.revenuecat.purchases.ui.revenuecatui.components.properties;

import androidx.compose.ui.text.font.FontFamily;
import com.revenuecat.purchases.paywalls.DownloadedFontFamily;
import kotlin.Metadata;
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
public interface FontSpec {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Asset implements FontSpec {
        public static final int $stable = 0;
        private final FontFamily fontFamily;

        public Asset(FontFamily fontFamily) {
            Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
            this.fontFamily = fontFamily;
        }

        public static /* synthetic */ Asset copy$default(Asset asset, FontFamily fontFamily, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                fontFamily = asset.fontFamily;
            }
            return asset.copy(fontFamily);
        }

        public final FontFamily component1() {
            return this.fontFamily;
        }

        public final Asset copy(FontFamily fontFamily) {
            Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
            return new Asset(fontFamily);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Asset) && Intrinsics.areEqual(this.fontFamily, ((Asset) obj).fontFamily);
        }

        public final /* synthetic */ FontFamily getFontFamily() {
            return this.fontFamily;
        }

        public int hashCode() {
            return this.fontFamily.hashCode();
        }

        public String toString() {
            return "Asset(fontFamily=" + this.fontFamily + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Downloaded implements FontSpec {
        public static final int $stable = 8;
        private final DownloadedFontFamily downloadedFontFamily;

        public Downloaded(DownloadedFontFamily downloadedFontFamily) {
            Intrinsics.checkNotNullParameter(downloadedFontFamily, "downloadedFontFamily");
            this.downloadedFontFamily = downloadedFontFamily;
        }

        public static /* synthetic */ Downloaded copy$default(Downloaded downloaded, DownloadedFontFamily downloadedFontFamily, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                downloadedFontFamily = downloaded.downloadedFontFamily;
            }
            return downloaded.copy(downloadedFontFamily);
        }

        public final DownloadedFontFamily component1() {
            return this.downloadedFontFamily;
        }

        public final Downloaded copy(DownloadedFontFamily downloadedFontFamily) {
            Intrinsics.checkNotNullParameter(downloadedFontFamily, "downloadedFontFamily");
            return new Downloaded(downloadedFontFamily);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Downloaded) && Intrinsics.areEqual(this.downloadedFontFamily, ((Downloaded) obj).downloadedFontFamily);
        }

        public final /* synthetic */ DownloadedFontFamily getDownloadedFontFamily() {
            return this.downloadedFontFamily;
        }

        public int hashCode() {
            return this.downloadedFontFamily.hashCode();
        }

        public String toString() {
            return "Downloaded(downloadedFontFamily=" + this.downloadedFontFamily + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Generic extends FontSpec {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Monospace implements Generic {
            public static final int $stable = 0;
            public static final Monospace INSTANCE = new Monospace();

            private Monospace() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class SansSerif implements Generic {
            public static final int $stable = 0;
            public static final SansSerif INSTANCE = new SansSerif();

            private SansSerif() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Serif implements Generic {
            public static final int $stable = 0;
            public static final Serif INSTANCE = new Serif();

            private Serif() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Google implements FontSpec {
        public static final int $stable = 0;
        private final String name;

        public Google(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
        }

        public static /* synthetic */ Google copy$default(Google google, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = google.name;
            }
            return google.copy(str);
        }

        public final String component1() {
            return this.name;
        }

        public final Google copy(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new Google(name);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Google) && Intrinsics.areEqual(this.name, ((Google) obj).name);
        }

        public final /* synthetic */ String getName() {
            return this.name;
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public String toString() {
            return "Google(name=" + this.name + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Resource implements FontSpec {
        public static final int $stable = 0;
        private final FontFamily fontFamily;

        public Resource(FontFamily fontFamily) {
            Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
            this.fontFamily = fontFamily;
        }

        public static /* synthetic */ Resource copy$default(Resource resource, FontFamily fontFamily, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                fontFamily = resource.fontFamily;
            }
            return resource.copy(fontFamily);
        }

        public final FontFamily component1() {
            return this.fontFamily;
        }

        public final Resource copy(FontFamily fontFamily) {
            Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
            return new Resource(fontFamily);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Resource) && Intrinsics.areEqual(this.fontFamily, ((Resource) obj).fontFamily);
        }

        public final /* synthetic */ FontFamily getFontFamily() {
            return this.fontFamily;
        }

        public int hashCode() {
            return this.fontFamily.hashCode();
        }

        public String toString() {
            return "Resource(fontFamily=" + this.fontFamily + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class System implements FontSpec {
        public static final int $stable = 0;
        private final String name;

        public System(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
        }

        public static /* synthetic */ System copy$default(System system, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = system.name;
            }
            return system.copy(str);
        }

        public final String component1() {
            return this.name;
        }

        public final System copy(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new System(name);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof System) && Intrinsics.areEqual(this.name, ((System) obj).name);
        }

        public final /* synthetic */ String getName() {
            return this.name;
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public String toString() {
            return "System(name=" + this.name + ')';
        }
    }
}
