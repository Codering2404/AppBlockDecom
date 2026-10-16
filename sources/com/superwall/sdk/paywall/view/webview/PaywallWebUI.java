package com.superwall.sdk.paywall.view.webview;

import android.view.View;
import android.view.ViewGroup;
import com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

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
public interface PaywallWebUI {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface OnScrollChangeListener {
        void onScrollChanged(int i3, int i4, int i5, int i6);
    }

    void attach(ViewGroup viewGroup);

    void destroyView();

    void detach(ViewGroup viewGroup);

    void enableBackgroundRendering();

    void evaluate(String str, Function1<? super String, Unit> function1);

    PaywallUIDelegate getDelegate();

    PaywallMessageHandler getMessageHandler();

    OnScrollChangeListener getOnScrollChangeListener();

    void onPause();

    void onResume();

    void onView(Function1<? super View, Unit> function1);

    void scrollBy(int i3, int i4);

    void scrollTo(int i3, int i4);

    void setDelegate(PaywallUIDelegate paywallUIDelegate);

    void setOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener);

    /* JADX INFO: renamed from: setup-MkQ7Bds, reason: not valid java name */
    void mo1339setupMkQ7Bds(String str, Function2<? super Boolean, ? super Integer, Unit> function2);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
        public static void onPause(PaywallWebUI paywallWebUI) {
        }

        public static void onResume(PaywallWebUI paywallWebUI) {
        }
    }
}
