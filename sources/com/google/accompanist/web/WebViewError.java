package com.google.accompanist.web;

import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class WebViewError {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WebResourceRequest f68884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WebResourceError f68885b;

    public WebViewError(WebResourceRequest webResourceRequest, WebResourceError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.f68884a = webResourceRequest;
        this.f68885b = error;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebViewError)) {
            return false;
        }
        WebViewError webViewError = (WebViewError) obj;
        return Intrinsics.areEqual(this.f68884a, webViewError.f68884a) && Intrinsics.areEqual(this.f68885b, webViewError.f68885b);
    }

    public int hashCode() {
        WebResourceRequest webResourceRequest = this.f68884a;
        return ((webResourceRequest == null ? 0 : webResourceRequest.hashCode()) * 31) + this.f68885b.hashCode();
    }

    public String toString() {
        return "WebViewError(request=" + this.f68884a + ", error=" + this.f68885b + ')';
    }
}
