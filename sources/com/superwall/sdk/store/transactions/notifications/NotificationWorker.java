package com.superwall.sdk.store.transactions.notifications;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.superwall.sdk.paywall.view.SuperwallPaywallActivity;
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
public final class NotificationWorker extends Worker {
    private final Context context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationWorker(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
        this.context = context;
    }

    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() {
        NotificationCompat.Builder builderE;
        int iH = getInputData().h("id", 0);
        String strJ = getInputData().j("title");
        String strJ2 = getInputData().j("body");
        NotificationCompat.Builder builderN = new NotificationCompat.Builder(getApplicationContext(), SuperwallPaywallActivity.NOTIFICATION_CHANNEL_ID).B(this.context.getApplicationInfo().icon).n(strJ);
        String strJ3 = getInputData().j("subtitle");
        if (strJ3 == null || (builderE = builderN.E(strJ3)) == null) {
            Intrinsics.checkNotNull(builderN);
        } else {
            builderN = builderE;
        }
        NotificationCompat.Builder builderX = builderN.m(strJ2).x(1);
        Intrinsics.checkNotNullExpressionValue(builderX, "setPriority(...)");
        NotificationManagerCompat notificationManagerCompatD = NotificationManagerCompat.d(getApplicationContext());
        if (ContextCompat.checkSelfPermission(this.context, "android.permission.POST_NOTIFICATIONS") != 0) {
            ListenableWorker.Result resultA = ListenableWorker.Result.a();
            Intrinsics.checkNotNullExpressionValue(resultA, "failure(...)");
            return resultA;
        }
        notificationManagerCompatD.f(iH, builderX.c());
        ListenableWorker.Result resultC = ListenableWorker.Result.c();
        Intrinsics.checkNotNullExpressionValue(resultC, "success(...)");
        return resultC;
    }

    public final Context getContext() {
        return this.context;
    }
}
