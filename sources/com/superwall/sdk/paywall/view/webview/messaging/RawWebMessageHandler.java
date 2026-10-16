package com.superwall.sdk.paywall.view.webview.messaging;

import android.webkit.JavascriptInterface;
import android.webkit.WebViewClient;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.misc.MainScope;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

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
public final class RawWebMessageHandler extends WebViewClient {
    private final WebEventDelegate delegate;
    private final MainScope mainScope;

    public /* synthetic */ RawWebMessageHandler(WebEventDelegate webEventDelegate, MainScope mainScope, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(webEventDelegate, (i3 & 2) != 0 ? new MainScope(null, 1, null) : mainScope);
    }

    @JavascriptInterface
    public final void postMessage(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        Logger logger = Logger.INSTANCE;
        LogLevel logLevel = LogLevel.debug;
        LogScope logScope = LogScope.paywallView;
        Logger.debug$default(logger, logLevel, logScope, "Did Receive Message", MapsKt.hashMapOf(TuplesKt.a("message", message)), (Throwable) null, 16, (Object) null);
        byte[] bytes = message.getBytes(Charsets.f140510b);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        Object wrappedPaywallMessages = PaywallMessageKt.parseWrappedPaywallMessages(StringsKt.B(bytes));
        if (Result.e(wrappedPaywallMessages) != null) {
            Logger.debug$default(logger, LogLevel.warn, logScope, "Invalid WrappedPaywallEvent", MapsKt.hashMapOf(TuplesKt.a("message", message)), (Throwable) null, 16, (Object) null);
            return;
        }
        WrappedPaywallMessages wrappedPaywallMessages2 = (WrappedPaywallMessages) wrappedPaywallMessages;
        Logger.debug$default(logger, logLevel, logScope, "Body Converted", MapsKt.hashMapOf(TuplesKt.a("message", message), TuplesKt.a("events", wrappedPaywallMessages2)), (Throwable) null, 16, (Object) null);
        Iterator<T> it = wrappedPaywallMessages2.getPayload().getMessages().iterator();
        while (it.hasNext()) {
            BuildersKt__Builders_commonKt.d(this.mainScope, null, null, new RawWebMessageHandler$postMessage$1$1$1(this, (PaywallMessage) it.next(), null), 3, null);
        }
    }

    public RawWebMessageHandler(WebEventDelegate delegate, MainScope mainScope) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(mainScope, "mainScope");
        this.delegate = delegate;
        this.mainScope = mainScope;
    }
}
