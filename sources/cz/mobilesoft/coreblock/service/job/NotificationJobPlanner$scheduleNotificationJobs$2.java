package cz.mobilesoft.coreblock.service.job;

import android.content.Context;
import cz.mobilesoft.coreblock.util.notifications.NotificationHelper;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.service.job.NotificationJobPlanner$scheduleNotificationJobs$2", f = "NotificationStatisticsWeekComparisonJob.kt", l = {}, m = "invokeSuspend", v = 1)
final class NotificationJobPlanner$scheduleNotificationJobs$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f123387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Integer f123388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f123389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f123390d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Pair f123391f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NotificationJobPlanner$scheduleNotificationJobs$2(Integer num, Context context, long j3, Pair pair, Continuation continuation) {
        super(2, continuation);
        this.f123388b = num;
        this.f123389c = context;
        this.f123390d = j3;
        this.f123391f = pair;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new NotificationJobPlanner$scheduleNotificationJobs$2(this.f123388b, this.f123389c, this.f123390d, this.f123391f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f123387a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        Integer num = this.f123388b;
        if (num == null) {
            return null;
        }
        Context context = this.f123389c;
        long j3 = this.f123390d;
        Pair pair = this.f123391f;
        NotificationHelper.f128940a.D(context, j3, num.intValue(), pair);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((NotificationJobPlanner$scheduleNotificationJobs$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
