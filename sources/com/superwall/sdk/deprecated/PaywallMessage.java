package com.superwall.sdk.deprecated;

import android.net.Uri;
import java.net.URI;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public abstract class PaywallMessage {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Close extends PaywallMessage {
        public static final Close INSTANCE = new Close();

        private Close() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Custom extends PaywallMessage {
        private final String data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Custom(String data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public static /* synthetic */ Custom copy$default(Custom custom, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = custom.data;
            }
            return custom.copy(str);
        }

        public final String component1() {
            return this.data;
        }

        public final Custom copy(String data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new Custom(data);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Custom) && Intrinsics.areEqual(this.data, ((Custom) obj).data);
        }

        public final String getData() {
            return this.data;
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "Custom(data=" + this.data + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnReady extends PaywallMessage {
        private final String paywallJsVersion;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnReady(String paywallJsVersion) {
            super(null);
            Intrinsics.checkNotNullParameter(paywallJsVersion, "paywallJsVersion");
            this.paywallJsVersion = paywallJsVersion;
        }

        public static /* synthetic */ OnReady copy$default(OnReady onReady, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = onReady.paywallJsVersion;
            }
            return onReady.copy(str);
        }

        public final String component1() {
            return this.paywallJsVersion;
        }

        public final OnReady copy(String paywallJsVersion) {
            Intrinsics.checkNotNullParameter(paywallJsVersion, "paywallJsVersion");
            return new OnReady(paywallJsVersion);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnReady) && Intrinsics.areEqual(this.paywallJsVersion, ((OnReady) obj).paywallJsVersion);
        }

        public final String getPaywallJsVersion() {
            return this.paywallJsVersion;
        }

        public int hashCode() {
            return this.paywallJsVersion.hashCode();
        }

        public String toString() {
            return "OnReady(paywallJsVersion=" + this.paywallJsVersion + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenDeepLink extends PaywallMessage {
        private final Uri url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenDeepLink(Uri url) {
            super(null);
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
        }

        public static /* synthetic */ OpenDeepLink copy$default(OpenDeepLink openDeepLink, Uri uri, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                uri = openDeepLink.url;
            }
            return openDeepLink.copy(uri);
        }

        public final Uri component1() {
            return this.url;
        }

        public final OpenDeepLink copy(Uri url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new OpenDeepLink(url);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OpenDeepLink) && Intrinsics.areEqual(this.url, ((OpenDeepLink) obj).url);
        }

        public final Uri getUrl() {
            return this.url;
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        public String toString() {
            return "OpenDeepLink(url=" + this.url + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenUrl extends PaywallMessage {
        private final URI url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenUrl(URI url) {
            super(null);
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
        }

        public static /* synthetic */ OpenUrl copy$default(OpenUrl openUrl, URI uri, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                uri = openUrl.url;
            }
            return openUrl.copy(uri);
        }

        public final URI component1() {
            return this.url;
        }

        public final OpenUrl copy(URI url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new OpenUrl(url);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OpenUrl) && Intrinsics.areEqual(this.url, ((OpenUrl) obj).url);
        }

        public final URI getUrl() {
            return this.url;
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        public String toString() {
            return "OpenUrl(url=" + this.url + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenUrlInBrowser extends PaywallMessage {
        private final URI url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenUrlInBrowser(URI url) {
            super(null);
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
        }

        public static /* synthetic */ OpenUrlInBrowser copy$default(OpenUrlInBrowser openUrlInBrowser, URI uri, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                uri = openUrlInBrowser.url;
            }
            return openUrlInBrowser.copy(uri);
        }

        public final URI component1() {
            return this.url;
        }

        public final OpenUrlInBrowser copy(URI url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new OpenUrlInBrowser(url);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OpenUrlInBrowser) && Intrinsics.areEqual(this.url, ((OpenUrlInBrowser) obj).url);
        }

        public final URI getUrl() {
            return this.url;
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        public String toString() {
            return "OpenUrlInBrowser(url=" + this.url + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Purchase extends PaywallMessage {
        private final String product;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Purchase(String product) {
            super(null);
            Intrinsics.checkNotNullParameter(product, "product");
            this.product = product;
        }

        public static /* synthetic */ Purchase copy$default(Purchase purchase, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = purchase.product;
            }
            return purchase.copy(str);
        }

        public final String component1() {
            return this.product;
        }

        public final Purchase copy(String product) {
            Intrinsics.checkNotNullParameter(product, "product");
            return new Purchase(product);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Purchase) && Intrinsics.areEqual(this.product, ((Purchase) obj).product);
        }

        public final String getProduct() {
            return this.product;
        }

        public int hashCode() {
            return this.product.hashCode();
        }

        public String toString() {
            return "Purchase(product=" + this.product + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Restore extends PaywallMessage {
        public static final Restore INSTANCE = new Restore();

        private Restore() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TemplateParamsAndUserAttributes extends PaywallMessage {
        public static final TemplateParamsAndUserAttributes INSTANCE = new TemplateParamsAndUserAttributes();

        private TemplateParamsAndUserAttributes() {
            super(null);
        }
    }

    public /* synthetic */ PaywallMessage(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PaywallMessage() {
    }
}
