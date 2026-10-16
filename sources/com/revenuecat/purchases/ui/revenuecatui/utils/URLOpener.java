package com.revenuecat.purchases.ui.revenuecatui.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.net.Uri;
import android.widget.Toast;
import androidx.browser.customtabs.CustomTabsIntent;
import com.revenuecat.purchases.ui.revenuecatui.R;
import com.revenuecat.purchases.ui.revenuecatui.extensions.UrisKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class URLOpener {
    public static final int $stable = 0;
    public static final URLOpener INSTANCE = new URLOpener();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[URLOpeningMethod.values().length];
            try {
                iArr[URLOpeningMethod.IN_APP_BROWSER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[URLOpeningMethod.EXTERNAL_BROWSER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[URLOpeningMethod.DEEP_LINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private URLOpener() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openURL$handleException(Context context, Exception exc) {
        String string = exc instanceof ActivityNotFoundException ? context.getString(R.string.no_browser_cannot_open_link) : context.getString(R.string.cannot_open_link);
        Intrinsics.checkNotNullExpressionValue(string, "if (exception is Activit…_open_link)\n            }");
        Toast.makeText(context, string, 0).show();
        Logger.INSTANCE.e(string, exc);
    }

    public final /* synthetic */ void openURL$revenuecatui_defaultsBc8Release(Context context, String url, URLOpeningMethod method) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        int i3 = WhenMappings.$EnumSwitchMapping$0[method.ordinal()];
        if (i3 != 1) {
            if (i3 == 2 || i3 == 3) {
                UrisKt.openUriOrElse(context, url, new URLOpener$openURL$1(context));
                return;
            }
            return;
        }
        CustomTabsIntent customTabsIntentA = new CustomTabsIntent.Builder().a();
        Intrinsics.checkNotNullExpressionValue(customTabsIntentA, "Builder()\n                    .build()");
        try {
            customTabsIntentA.a(context, Uri.parse(url));
        } catch (ActivityNotFoundException e3) {
            openURL$handleException(context, e3);
        } catch (IllegalArgumentException e4) {
            openURL$handleException(context, e4);
        }
    }
}
