package cz.mobilesoft.coreblock.service.job;

import android.content.Context;
import android.util.Log;
import cz.mobilesoft.coreblock.scene.streaks.StreakNudgePlanner;
import cz.mobilesoft.coreblock.util.notifications.NotificationHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.service.job.StreakNudgeNotificationJob$onRunJob$1", f = "StreakNudgeNotificationJob.kt", l = {56}, m = "invokeSuspend", v = 1)
final class StreakNudgeNotificationJob$onRunJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f123472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ StreakNudgeNotificationJob f123473b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreakNudgeNotificationJob$onRunJob$1(StreakNudgeNotificationJob streakNudgeNotificationJob, Continuation continuation) {
        super(2, continuation);
        this.f123473b = streakNudgeNotificationJob;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StreakNudgeNotificationJob$onRunJob$1(this.f123473b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        StreakNudgeNotificationJob$onRunJob$1 streakNudgeNotificationJob$onRunJob$1;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f123472a;
        if (i3 == 0) {
            ResultKt.b(obj);
            StreakNudgePlanner streakNudgePlannerZ = this.f123473b.z();
            this.f123472a = 1;
            streakNudgeNotificationJob$onRunJob$1 = this;
            obj = StreakNudgePlanner.e(streakNudgePlannerZ, 0L, null, streakNudgeNotificationJob$onRunJob$1, 3, null);
            if (obj == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            streakNudgeNotificationJob$onRunJob$1 = this;
        }
        Integer num = (Integer) obj;
        if (num == null) {
            Log.d("StreakNudgeNotificationJob", "No streak nudge is due");
            return Unit.f139807a;
        }
        NotificationHelper notificationHelper = NotificationHelper.f128940a;
        Context contextC = streakNudgeNotificationJob$onRunJob$1.f123473b.c();
        Intrinsics.checkNotNullExpressionValue(contextC, "access$getContext(...)");
        notificationHelper.I(contextC, num.intValue());
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StreakNudgeNotificationJob$onRunJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
