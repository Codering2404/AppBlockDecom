package com.superwall.sdk.paywall.view.webview;

import android.webkit.WebView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class WebviewChecker {
    public static final WebviewChecker INSTANCE = new WebviewChecker();
    private static final Lazy webviewExists$delegate = LazyKt.b(new Function0() { // from class: com.superwall.sdk.paywall.view.webview.u
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Boolean.valueOf(WebviewChecker.webviewExists_delegate$lambda$1());
        }
    });

    private WebviewChecker() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean webviewExists_delegate$lambda$1() {
        try {
            return WebView.getCurrentWebViewPackage() != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final boolean getWebviewExists() {
        return ((Boolean) webviewExists$delegate.getValue()).booleanValue();
    }
}
