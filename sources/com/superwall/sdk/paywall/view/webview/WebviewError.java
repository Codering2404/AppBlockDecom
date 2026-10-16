package com.superwall.sdk.paywall.view.webview;

import com.applovin.impl.privacy.consentFlow.as.KLAQHFCRAUejH;
import java.util.List;
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
public abstract class WebviewError {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AllUrlsFailed extends WebviewError {
        private final List<String> urls;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AllUrlsFailed(List<String> urls) {
            super(null);
            Intrinsics.checkNotNullParameter(urls, "urls");
            this.urls = urls;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AllUrlsFailed copy$default(AllUrlsFailed allUrlsFailed, List list, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                list = allUrlsFailed.urls;
            }
            return allUrlsFailed.copy(list);
        }

        public final List<String> component1() {
            return this.urls;
        }

        public final AllUrlsFailed copy(List<String> urls) {
            Intrinsics.checkNotNullParameter(urls, "urls");
            return new AllUrlsFailed(urls);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AllUrlsFailed) && Intrinsics.areEqual(this.urls, ((AllUrlsFailed) obj).urls);
        }

        public final List<String> getUrls() {
            return this.urls;
        }

        public int hashCode() {
            return this.urls.hashCode();
        }

        public String toString() {
            return "All paywall URLs have failed to load.";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class MaxAttemptsReached extends WebviewError {
        private final List<String> urls;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MaxAttemptsReached(List<String> urls) {
            super(null);
            Intrinsics.checkNotNullParameter(urls, "urls");
            this.urls = urls;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MaxAttemptsReached copy$default(MaxAttemptsReached maxAttemptsReached, List list, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                list = maxAttemptsReached.urls;
            }
            return maxAttemptsReached.copy(list);
        }

        public final List<String> component1() {
            return this.urls;
        }

        public final MaxAttemptsReached copy(List<String> urls) {
            Intrinsics.checkNotNullParameter(urls, "urls");
            return new MaxAttemptsReached(urls);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof MaxAttemptsReached) && Intrinsics.areEqual(this.urls, ((MaxAttemptsReached) obj).urls);
        }

        public final List<String> getUrls() {
            return this.urls;
        }

        public int hashCode() {
            return this.urls.hashCode();
        }

        public String toString() {
            return "The webview has attempted to load too many times.";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NetworkError extends WebviewError {
        private final int code;
        private final String description;
        private final String url;

        public static /* synthetic */ NetworkError copy$default(NetworkError networkError, int i3, String str, String str2, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i3 = networkError.code;
            }
            if ((i4 & 2) != 0) {
                str = networkError.description;
            }
            if ((i4 & 4) != 0) {
                str2 = networkError.url;
            }
            return networkError.copy(i3, str, str2);
        }

        public final int component1() {
            return this.code;
        }

        public final String component2() {
            return this.description;
        }

        public final String component3() {
            return this.url;
        }

        public final NetworkError copy(int i3, String description, String url) {
            Intrinsics.checkNotNullParameter(description, "description");
            Intrinsics.checkNotNullParameter(url, "url");
            return new NetworkError(i3, description, url);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof NetworkError)) {
                return false;
            }
            NetworkError networkError = (NetworkError) obj;
            return this.code == networkError.code && Intrinsics.areEqual(this.description, networkError.description) && Intrinsics.areEqual(this.url, networkError.url);
        }

        public final int getCode() {
            return this.code;
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.code) * 31) + this.description.hashCode()) * 31) + this.url.hashCode();
        }

        public String toString() {
            return "The network failed with error code: " + this.code + " - " + this.description + " - " + this.url + " .";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NetworkError(int i3, String str, String url) {
            super(null);
            Intrinsics.checkNotNullParameter(str, KLAQHFCRAUejH.vpOauCLRUTDe);
            Intrinsics.checkNotNullParameter(url, "url");
            this.code = i3;
            this.description = str;
            this.url = url;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NoUrls extends WebviewError {
        public static final NoUrls INSTANCE = new NoUrls();

        private NoUrls() {
            super(null);
        }

        public String toString() {
            return "There were no paywall URLs provided.";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Timeout extends WebviewError {
        private final String msg;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Timeout(String msg) {
            super(null);
            Intrinsics.checkNotNullParameter(msg, "msg");
            this.msg = msg;
        }

        public static /* synthetic */ Timeout copy$default(Timeout timeout, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = timeout.msg;
            }
            return timeout.copy(str);
        }

        public final String component1() {
            return this.msg;
        }

        public final Timeout copy(String msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            return new Timeout(msg);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Timeout) && Intrinsics.areEqual(this.msg, ((Timeout) obj).msg);
        }

        public final String getMsg() {
            return this.msg;
        }

        public int hashCode() {
            return this.msg.hashCode();
        }

        public String toString() {
            return "Paywall loading reached specified timeout";
        }
    }

    public /* synthetic */ WebviewError(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private WebviewError() {
    }
}
