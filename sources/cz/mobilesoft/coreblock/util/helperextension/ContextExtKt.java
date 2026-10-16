package cz.mobilesoft.coreblock.util.helperextension;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import androidx.activity.result.ActivityResultLauncher;
import cz.mobilesoft.coreblock.util.CrashHelper;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public final class ContextExtKt {
    public static final void a(Context context, String label, String item) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(item, "item");
        ClipboardManager clipboardManager = (ClipboardManager) context.getApplicationContext().getSystemService("clipboard");
        ClipData clipDataNewPlainText = ClipData.newPlainText(label, item);
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(clipDataNewPlainText);
        }
    }

    public static final Activity b(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        Context baseContext = ((ContextWrapper) context).getBaseContext();
        Intrinsics.checkNotNullExpressionValue(baseContext, "getBaseContext(...)");
        return b(baseContext);
    }

    public static final Vibrator c(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (Build.VERSION.SDK_INT < 31) {
            Object systemService = context.getSystemService("vibrator");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
            return (Vibrator) systemService;
        }
        Object systemService2 = context.getSystemService("vibrator_manager");
        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.os.VibratorManager");
        Vibrator defaultVibrator = c.a(systemService2).getDefaultVibrator();
        Intrinsics.checkNotNull(defaultVibrator);
        return defaultVibrator;
    }

    public static final Locale d(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Locale locale = context.getResources().getConfiguration().getLocales().get(0);
        Intrinsics.checkNotNullExpressionValue(locale, "get(...)");
        return locale;
    }

    public static final PendingIntent e(Context context, int i3, Intent intent, int i4) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (Build.VERSION.SDK_INT < 34) {
            PendingIntent activity = PendingIntent.getActivity(context, i3, intent, i4);
            Intrinsics.checkNotNull(activity);
            return activity;
        }
        ActivityOptions pendingIntentCreatorBackgroundActivityStartMode = ActivityOptions.makeBasic().setPendingIntentCreatorBackgroundActivityStartMode(1);
        Intrinsics.checkNotNullExpressionValue(pendingIntentCreatorBackgroundActivityStartMode, "setPendingIntentCreatorB…undActivityStartMode(...)");
        PendingIntent activity2 = PendingIntent.getActivity(context, i3, intent, i4, pendingIntentCreatorBackgroundActivityStartMode.toBundle());
        Intrinsics.checkNotNull(activity2);
        return activity2;
    }

    public static final boolean f(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        String language = d(context).getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
        return StringsKt.U(language, "en", false, 2, null);
    }

    public static final void g(ActivityResultLauncher activityResultLauncher, Object obj) {
        Intrinsics.checkNotNullParameter(activityResultLauncher, "<this>");
        try {
            activityResultLauncher.b(obj);
        } catch (IllegalStateException e3) {
            CrashHelper.j(e3);
        }
    }

    public static final void h(Context context, BroadcastReceiver receiver, IntentFilter filter, int i3) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        Intrinsics.checkNotNullParameter(filter, "filter");
        if (Build.VERSION.SDK_INT >= 33) {
            context.registerReceiver(receiver, filter, i3);
        } else {
            context.registerReceiver(receiver, filter);
        }
    }

    public static final void i(Context context, long j3) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Vibrator vibratorC = c(context);
        if (vibratorC.hasVibrator()) {
            vibratorC.vibrate(VibrationEffect.createOneShot(j3, -1));
        }
    }

    public static final void j(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (Build.VERSION.SDK_INT < 29) {
            i(context, 15L);
            return;
        }
        Vibrator vibratorC = c(context);
        VibrationEffect vibrationEffectCreatePredefined = VibrationEffect.createPredefined(2);
        Intrinsics.checkNotNullExpressionValue(vibrationEffectCreatePredefined, "createPredefined(...)");
        vibratorC.vibrate(vibrationEffectCreatePredefined);
    }
}
