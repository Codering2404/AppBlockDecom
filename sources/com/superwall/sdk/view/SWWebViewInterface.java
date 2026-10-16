package com.superwall.sdk.view;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.superwall.sdk.deprecated.PaywallMessage;
import com.superwall.sdk.deprecated.PaywallMessagesKt;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import java.util.Map;
import kotlin.ExceptionsKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class SWWebViewInterface {
    private final Context context;
    private final PaywallMessageDelegate delegate;

    public SWWebViewInterface(PaywallMessageDelegate delegate, Context context) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.delegate = delegate;
    }

    @JavascriptInterface
    public final void postMessage(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.superwallCore, "SWWebViewInterface: " + message, (Map) null, (Throwable) null, 24, (Object) null);
        try {
            for (PaywallMessage paywallMessage : PaywallMessagesKt.parseWrappedPaywallMessages(message).getPayload().getMessages()) {
                Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.superwallCore, "SWWebViewInterface:" + paywallMessage.getClass().getSimpleName(), (Map) null, (Throwable) null, 24, (Object) null);
                this.delegate.didReceiveMessage(paywallMessage);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.superwallCore, "SWWebViewInterface: Error parsing message" + th + " - " + ExceptionsKt.b(th), (Map) null, (Throwable) null, 24, (Object) null);
        }
    }
}
