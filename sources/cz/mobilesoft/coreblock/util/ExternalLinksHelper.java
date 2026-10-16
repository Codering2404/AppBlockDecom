package cz.mobilesoft.coreblock.util;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
public final class ExternalLinksHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExternalLinksHelper f127866a = new ExternalLinksHelper();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f127867b = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.util.m
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ExternalLinksHelper.h();
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f127868c = 8;

    private ExternalLinksHelper() {
    }

    public static /* synthetic */ void f(ExternalLinksHelper externalLinksHelper, Context context, boolean z2, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = AnswersSenderHelper.f127775a.d();
        }
        if ((i3 & 2) != 0) {
            function0 = null;
        }
        externalLinksHelper.e(context, z2, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String h() {
        return "https://play.google.com/store/account/subscriptions?package=" + LockieApplication.f95360f;
    }

    public final String b() {
        return (String) f127867b.getValue();
    }

    public final void c(Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(uri, "uri");
        try {
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            CustomTabColorSchemeParams customTabColorSchemeParamsA = new CustomTabColorSchemeParams.Builder().b(ContextCompat.getColor(context, R.color.f95448c)).a();
            Intrinsics.checkNotNullExpressionValue(customTabColorSchemeParamsA, "build(...)");
            builder.h(customTabColorSchemeParamsA);
            CustomTabsIntent customTabsIntentA = builder.a();
            Intrinsics.checkNotNullExpressionValue(customTabsIntentA, "build(...)");
            customTabsIntentA.a(context, uri);
        } catch (Exception e3) {
            CrashHelper.j(e3);
            try {
                context.startActivity(new Intent("android.intent.action.VIEW", uri));
            } catch (Exception e4) {
                CrashHelper.j(e4);
            }
        }
    }

    public final void d(Context context, String url) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
            intent.setFlags(268468224);
            context.startActivity(intent);
        } catch (Exception e3) {
            CrashHelper.j(e3);
        }
    }

    public final void e(Context context, boolean z2, Function0 function0) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        String packageName = context.getPackageName();
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName));
        intent.addFlags(1208483840);
        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + packageName));
        intent2.setFlags(1208483840);
        if (!z2) {
            intent = intent2;
        }
        try {
            try {
                context.startActivity(intent);
                if (function0 != null) {
                    function0.invoke();
                }
            } catch (ActivityNotFoundException unused) {
                context.startActivity(intent2);
                if (function0 != null) {
                    function0.invoke();
                }
            }
        } catch (Throwable th) {
            if (function0 != null) {
                function0.invoke();
            }
            throw th;
        }
    }

    public final boolean g(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(b())));
            return true;
        } catch (Exception e3) {
            CrashHelper.j(e3);
            return false;
        }
    }
}
