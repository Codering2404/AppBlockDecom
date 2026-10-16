package com.superwall.sdk.store.transactions.notifications;

import android.content.Context;
import androidx.work.WorkManager;
import com.superwall.sdk.dependencies.DeviceHelperFactory;
import com.superwall.sdk.models.paywall.LocalNotification;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "com.superwall.sdk.store.transactions.notifications.NotificationScheduler$Companion$scheduleNotifications$1", f = "NotificationScheduler.kt", l = {56}, m = "invokeSuspend")
final class NotificationScheduler$Companion$scheduleNotifications$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $applySandboxScaling;
    final /* synthetic */ boolean $cancelExisting;
    final /* synthetic */ Context $context;
    final /* synthetic */ DeviceHelperFactory $factory;
    final /* synthetic */ List<LocalNotification> $notifications;
    final /* synthetic */ WorkManager $workManager;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    boolean Z$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NotificationScheduler$Companion$scheduleNotifications$1(List<LocalNotification> list, boolean z2, Context context, DeviceHelperFactory deviceHelperFactory, boolean z3, WorkManager workManager, Continuation<? super NotificationScheduler$Companion$scheduleNotifications$1> continuation) {
        super(2, continuation);
        this.$notifications = list;
        this.$cancelExisting = z2;
        this.$context = context;
        this.$factory = deviceHelperFactory;
        this.$applySandboxScaling = z3;
        this.$workManager = workManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotificationScheduler$Companion$scheduleNotifications$1(this.$notifications, this.$cancelExisting, this.$context, this.$factory, this.$applySandboxScaling, this.$workManager, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0089, code lost:
    
        if (((java.lang.Boolean) r10).booleanValue() == false) goto L20;
     */
    /* JADX WARN: Path cross not found for [B:20:0x008c, B:9:0x004e], limit reached: 37 */
    /* JADX WARN: Path cross not found for [B:9:0x004e, B:20:0x008c], limit reached: 37 */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x017b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x005c -> B:20:0x008c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0080 -> B:17:0x0083). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 382
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.store.transactions.notifications.NotificationScheduler$Companion$scheduleNotifications$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NotificationScheduler$Companion$scheduleNotifications$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
