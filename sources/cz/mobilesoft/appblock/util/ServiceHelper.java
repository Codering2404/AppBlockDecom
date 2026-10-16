package cz.mobilesoft.appblock.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import cz.mobilesoft.appblock.service.LockServiceInAccessibilityProcess;
import cz.mobilesoft.appblock.service.LockServiceV2;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.runnability.RunnabilityHelper;
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
public final class ServiceHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ServiceHelper f95139a = new ServiceHelper();

    private ServiceHelper() {
    }

    private final boolean a() {
        return RunnabilityHelper.f129617a.M();
    }

    public final void b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            context.startActivity(intent);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public final void c(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            activity.startActivity(intent);
            activity.finish();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public final boolean d(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return cz.mobilesoft.coreblock.util.runnability.ServiceHelper.h(context, a() ? LockServiceInAccessibilityProcess.class : LockServiceV2.class);
    }

    public final void e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        CoroutinesHelperExtKt.d(new ServiceHelper$openAppAndFinish$1(context, null));
    }

    public final void f(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (a()) {
            LockServiceInAccessibilityProcess.c0(context, null);
        } else {
            LockServiceV2.c0(context, null);
        }
    }

    public final void g(Context context, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (a()) {
            LockServiceInAccessibilityProcess.c0(context, bundle);
        } else {
            LockServiceV2.c0(context, bundle);
        }
    }

    public final void h(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (a()) {
            LockServiceInAccessibilityProcess.e0(context);
            if (cz.mobilesoft.coreblock.util.runnability.ServiceHelper.h(context, LockServiceV2.class)) {
                return;
            }
            LockServiceV2.e0(context);
            return;
        }
        LockServiceV2.e0(context);
        if (cz.mobilesoft.coreblock.util.runnability.ServiceHelper.h(context, LockServiceInAccessibilityProcess.class)) {
            return;
        }
        LockServiceInAccessibilityProcess.e0(context);
    }
}
