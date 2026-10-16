package com.google.accompanist.web;

import android.webkit.WebView;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import com.google.accompanist.web.WebContent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

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
public final class WebViewKt {
    /* JADX WARN: Removed duplicated region for block: B:108:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02f8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final com.google.accompanist.web.WebViewState r23, androidx.compose.ui.Modifier r24, boolean r25, com.google.accompanist.web.WebViewNavigator r26, kotlin.jvm.functions.Function1 r27, kotlin.jvm.functions.Function1 r28, com.google.accompanist.web.AccompanistWebViewClient r29, com.google.accompanist.web.AccompanistWebChromeClient r30, kotlin.jvm.functions.Function1 r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instruction units count: 772
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.accompanist.web.WebViewKt.a(com.google.accompanist.web.WebViewState, androidx.compose.ui.Modifier, boolean, com.google.accompanist.web.WebViewNavigator, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, com.google.accompanist.web.AccompanistWebViewClient, com.google.accompanist.web.AccompanistWebChromeClient, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WebView b(MutableState mutableState) {
        return (WebView) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(MutableState mutableState, WebView webView) {
        mutableState.setValue(webView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1 d(State state) {
        return (Function1) state.getValue();
    }

    public static final WebViewNavigator h(CoroutineScope coroutineScope, Composer composer, int i3, int i4) {
        composer.F(1602323198);
        if ((i4 & 1) != 0) {
            composer.F(773894976);
            composer.F(-492369756);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.l(EmptyCoroutineContext.f139889a, composer));
                composer.w(compositionScopedCoroutineScopeCanceller);
                objG = compositionScopedCoroutineScopeCanceller;
            }
            composer.Y();
            coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objG).a();
            composer.Y();
        }
        if (ComposerKt.M()) {
            ComposerKt.U(1602323198, i3, -1, "com.google.accompanist.web.rememberWebViewNavigator (WebView.kt:411)");
        }
        composer.F(1157296644);
        boolean Z = composer.Z(coroutineScope);
        Object objG2 = composer.G();
        if (Z || objG2 == Composer.f23746a.a()) {
            objG2 = new WebViewNavigator(coroutineScope);
            composer.w(objG2);
        }
        composer.Y();
        WebViewNavigator webViewNavigator = (WebViewNavigator) objG2;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.Y();
        return webViewNavigator;
    }

    public static final WebViewState i(String url, Map map, Composer composer, int i3, int i4) {
        Intrinsics.checkNotNullParameter(url, "url");
        composer.F(1238013775);
        if ((i4 & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        if (ComposerKt.M()) {
            ComposerKt.U(1238013775, i3, -1, "com.google.accompanist.web.rememberWebViewState (WebView.kt:438)");
        }
        composer.F(511388516);
        boolean Z = composer.Z(url) | composer.Z(map);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new WebViewState(new WebContent.Url(url, map));
            composer.w(objG);
        }
        composer.Y();
        WebViewState webViewState = (WebViewState) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.Y();
        return webViewState;
    }

    public static final WebContent.Url j(WebContent webContent, String url) {
        Intrinsics.checkNotNullParameter(webContent, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        return webContent instanceof WebContent.Url ? WebContent.Url.c((WebContent.Url) webContent, url, null, 2, null) : new WebContent.Url(url, null, 2, null);
    }
}
