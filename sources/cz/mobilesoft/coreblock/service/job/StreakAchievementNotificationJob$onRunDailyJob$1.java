package cz.mobilesoft.coreblock.service.job;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.service.job.StreakAchievementNotificationJob$onRunDailyJob$1", f = "StreakAchievementNotificationJob.kt", l = {47, 60}, m = "invokeSuspend", v = 1)
final class StreakAchievementNotificationJob$onRunDailyJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f123459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f123460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ StreakAchievementNotificationJob f123461c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreakAchievementNotificationJob$onRunDailyJob$1(StreakAchievementNotificationJob streakAchievementNotificationJob, Continuation continuation) {
        super(2, continuation);
        this.f123461c = streakAchievementNotificationJob;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StreakAchievementNotificationJob$onRunDailyJob$1(this.f123461c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x008d, code lost:
    
        if (r1.Z(r3, r11) == r0) goto L23;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r11.f123460b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L25
            if (r1 == r3) goto L20
            if (r1 != r2) goto L18
            java.lang.Object r0 = r11.f123459a
            java.lang.Integer r0 = (java.lang.Integer) r0
            kotlin.ResultKt.b(r12)
            r8 = r11
            goto L90
        L18:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L20:
            kotlin.ResultKt.b(r12)
            r8 = r11
            goto L3d
        L25:
            kotlin.ResultKt.b(r12)
            cz.mobilesoft.coreblock.service.job.StreakAchievementNotificationJob r12 = r11.f123461c
            cz.mobilesoft.coreblock.scene.streaks.StreakAchievementNotificationPlanner r4 = cz.mobilesoft.coreblock.service.job.StreakAchievementNotificationJob.B(r12)
            r11.f123460b = r3
            r5 = 0
            r7 = 0
            r9 = 3
            r10 = 0
            r8 = r11
            java.lang.Object r12 = cz.mobilesoft.coreblock.scene.streaks.StreakAchievementNotificationPlanner.c(r4, r5, r7, r8, r9, r10)
            if (r12 != r0) goto L3d
            goto L8f
        L3d:
            java.lang.Integer r12 = (java.lang.Integer) r12
            java.lang.String r1 = "StreakAchievementNotificationJob"
            if (r12 != 0) goto L4b
            java.lang.String r12 = "No milestone to congratulate"
            android.util.Log.d(r1, r12)
            kotlin.Unit r12 = kotlin.Unit.f139807a
            return r12
        L4b:
            cz.mobilesoft.coreblock.service.job.StreakAchievementNotificationJob r3 = r8.f123461c
            android.content.Context r3 = cz.mobilesoft.coreblock.service.job.StreakAchievementNotificationJob.A(r3)
            androidx.core.app.NotificationManagerCompat r3 = androidx.core.app.NotificationManagerCompat.d(r3)
            boolean r3 = r3.a()
            if (r3 != 0) goto L63
            java.lang.String r12 = "Notifications are off, leaving the milestone to the app"
            android.util.Log.d(r1, r12)
            kotlin.Unit r12 = kotlin.Unit.f139807a
            return r12
        L63:
            cz.mobilesoft.coreblock.util.notifications.NotificationHelper r1 = cz.mobilesoft.coreblock.util.notifications.NotificationHelper.f128940a
            cz.mobilesoft.coreblock.service.job.StreakAchievementNotificationJob r3 = r8.f123461c
            android.content.Context r3 = cz.mobilesoft.coreblock.service.job.StreakAchievementNotificationJob.A(r3)
            java.lang.String r4 = "access$getContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            int r4 = r12.intValue()
            r1.H(r3, r4)
            cz.mobilesoft.coreblock.service.job.StreakAchievementNotificationJob r1 = r8.f123461c
            cz.mobilesoft.coreblock.storage.datastore.StreakDataStore r1 = cz.mobilesoft.coreblock.service.job.StreakAchievementNotificationJob.C(r1)
            int r3 = r12.intValue()
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.a(r12)
            r8.f123459a = r12
            r8.f123460b = r2
            java.lang.Object r12 = r1.Z(r3, r11)
            if (r12 != r0) goto L90
        L8f:
            return r0
        L90:
            kotlin.Unit r12 = kotlin.Unit.f139807a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.job.StreakAchievementNotificationJob$onRunDailyJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StreakAchievementNotificationJob$onRunDailyJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
