package cz.mobilesoft.appblock.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import cz.mobilesoft.appblock.LockPref;
import cz.mobilesoft.coreblock.util.runnability.InitHelper;
import cz.mobilesoft.coreblock.util.runnability.JobHelper;
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
public final class UserPresentReceiver extends BroadcastReceiver {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Intent intent, Context context) {
        if (Intrinsics.areEqual("android.intent.action.USER_PRESENT", intent.getAction())) {
            if (LockPref.b(context) <= 20) {
                Log.i(ScreenReceiver.class.toString(), "ACTION_USER_PRESENT - NOT START ACTION");
            } else {
                Log.i(ScreenReceiver.class.toString(), "ACTION_USER_PRESENT - START ACTION");
                JobHelper.p();
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        InitHelper.h(new InitHelper.OnInitializedListener() { // from class: cz.mobilesoft.appblock.service.v1
            @Override // cz.mobilesoft.coreblock.util.runnability.InitHelper.OnInitializedListener
            public final void onInitialized() {
                UserPresentReceiver.b(intent, context);
            }
        });
    }
}
