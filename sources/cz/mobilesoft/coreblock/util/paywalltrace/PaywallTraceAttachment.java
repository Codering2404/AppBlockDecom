package cz.mobilesoft.coreblock.util.paywalltrace;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.FrameLayout;
import androidx.compose.ui.platform.ComposeView;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.superwall.sdk.Superwall;
import com.superwall.sdk.paywall.view.PaywallView;
import cz.mobilesoft.coreblock.BuildConfig;
import cz.mobilesoft.coreblock.util.paywalltrace.PaywallTraceAttachment;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PaywallTraceAttachment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PaywallTraceAttachment f128979a = new PaywallTraceAttachment();

    private PaywallTraceAttachment() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
        try {
            PaywallView paywallView = Superwall.Companion.getInstance().getPaywallView();
            if (paywallView != null && paywallView.findViewWithTag("paywall_trace_overlay") == null) {
                if (ViewTreeLifecycleOwner.a(paywallView) == null) {
                    Log.w("SuperwallPaywall", "No lifecycle owner in Superwall paywall view, skipping trace overlay");
                    return;
                }
                Context context = paywallView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                ComposeView composeView = new ComposeView(context, null, 0, 6, null);
                composeView.setTag("paywall_trace_overlay");
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 8388661;
                composeView.setLayoutParams(layoutParams);
                composeView.setContent(ComposableSingletons$PaywallTraceAttachmentKt.f128962a.c());
                paywallView.addView(composeView);
            }
        } catch (Throwable th) {
            Log.w("SuperwallPaywall", "Could not attach paywall trace overlay to Superwall paywall", th);
        }
    }

    public final void b() {
        if (BuildConfig.f95357b.booleanValue()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: i2.g
                @Override // java.lang.Runnable
                public final void run() {
                    PaywallTraceAttachment.c();
                }
            });
        }
    }
}
