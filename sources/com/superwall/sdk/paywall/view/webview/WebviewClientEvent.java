package com.superwall.sdk.paywall.view.webview;

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
public abstract class WebviewClientEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LoadingFallback extends WebviewClientEvent {
        public static final LoadingFallback INSTANCE = new LoadingFallback();

        private LoadingFallback() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnError extends WebviewClientEvent {
        private final WebviewError webviewError;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnError(WebviewError webviewError) {
            super(null);
            Intrinsics.checkNotNullParameter(webviewError, "webviewError");
            this.webviewError = webviewError;
        }

        public static /* synthetic */ OnError copy$default(OnError onError, WebviewError webviewError, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                webviewError = onError.webviewError;
            }
            return onError.copy(webviewError);
        }

        public final WebviewError component1() {
            return this.webviewError;
        }

        public final OnError copy(WebviewError webviewError) {
            Intrinsics.checkNotNullParameter(webviewError, "webviewError");
            return new OnError(webviewError);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnError) && Intrinsics.areEqual(this.webviewError, ((OnError) obj).webviewError);
        }

        public final WebviewError getWebviewError() {
            return this.webviewError;
        }

        public int hashCode() {
            return this.webviewError.hashCode();
        }

        public String toString() {
            return "OnError(webviewError=" + this.webviewError + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPageFinished extends WebviewClientEvent {
        private final String url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnPageFinished(String url) {
            super(null);
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
        }

        public static /* synthetic */ OnPageFinished copy$default(OnPageFinished onPageFinished, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = onPageFinished.url;
            }
            return onPageFinished.copy(str);
        }

        public final String component1() {
            return this.url;
        }

        public final OnPageFinished copy(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new OnPageFinished(url);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnPageFinished) && Intrinsics.areEqual(this.url, ((OnPageFinished) obj).url);
        }

        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        public String toString() {
            return "OnPageFinished(url=" + this.url + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnResourceError extends WebviewClientEvent {
        private final WebviewError webviewError;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnResourceError(WebviewError webviewError) {
            super(null);
            Intrinsics.checkNotNullParameter(webviewError, "webviewError");
            this.webviewError = webviewError;
        }

        public static /* synthetic */ OnResourceError copy$default(OnResourceError onResourceError, WebviewError webviewError, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                webviewError = onResourceError.webviewError;
            }
            return onResourceError.copy(webviewError);
        }

        public final WebviewError component1() {
            return this.webviewError;
        }

        public final OnResourceError copy(WebviewError webviewError) {
            Intrinsics.checkNotNullParameter(webviewError, "webviewError");
            return new OnResourceError(webviewError);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnResourceError) && Intrinsics.areEqual(this.webviewError, ((OnResourceError) obj).webviewError);
        }

        public final WebviewError getWebviewError() {
            return this.webviewError;
        }

        public int hashCode() {
            return this.webviewError.hashCode();
        }

        public String toString() {
            return "OnResourceError(webviewError=" + this.webviewError + ")";
        }
    }

    public /* synthetic */ WebviewClientEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private WebviewClientEvent() {
    }
}
