package com.superwall.sdk.paywall.view;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
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
public final class PaywallActivityLauncherKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean canPresentPaywall(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        if (activity.isFinishing() || activity.isDestroyed()) {
            return false;
        }
        return !(activity instanceof LifecycleOwner) || ((LifecycleOwner) activity).getLifecycle().getCurrentState().b(Lifecycle.State.f39950d);
    }

    public static final Object launchPaywallActivity(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        boolean z2 = context instanceof Activity;
        if (z2 && !canPresentPaywall((Activity) context)) {
            Result.Companion companion = Result.f139772b;
            return Result.b(ResultKt.a(new PaywallActivityLaunchException("The presenter Activity is no longer started or is finishing.", null, 2, null)));
        }
        if (!z2) {
            intent.addFlags(268435456);
        }
        try {
            context.startActivity(intent);
            Result.Companion companion2 = Result.f139772b;
            return Result.b(Unit.f139807a);
        } catch (ActivityNotFoundException e3) {
            Result.Companion companion3 = Result.f139772b;
            return Result.b(ResultKt.a(new PaywallActivityLaunchException("SuperwallPaywallActivity is unavailable in the merged Android manifest.", e3)));
        } catch (RuntimeException e4) {
            Result.Companion companion4 = Result.f139772b;
            return Result.b(ResultKt.a(new PaywallActivityLaunchException("Android failed to launch SuperwallPaywallActivity.", e4)));
        }
    }
}
