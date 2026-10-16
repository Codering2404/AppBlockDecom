package cz.mobilesoft.coreblock.scene.dashboard.blocking;

import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$handlePossibleFutureUsageLimitReset$1", f = "BlockingScreenViewModel.kt", l = {715}, m = "invokeSuspend", v = 1)
final class BlockingScreenViewModel$handlePossibleFutureUsageLimitReset$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f99709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f99710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f99711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ BlockingScreenViewModel f99712d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BlockingScreenViewModel$handlePossibleFutureUsageLimitReset$1(BlockingScreenViewModel blockingScreenViewModel, Continuation continuation) {
        super(2, continuation);
        this.f99712d = blockingScreenViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BlockingScreenViewModel$handlePossibleFutureUsageLimitReset$1(this.f99712d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f99711c;
        if (i3 == 0) {
            ResultKt.b(obj);
            Calendar calendar = Calendar.getInstance();
            TimeHelperExt timeHelperExt = TimeHelperExt.f128663a;
            calendar.setTimeInMillis(timeHelperExt.f());
            calendar.add(11, 1);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 1);
            long timeInMillis = calendar.getTimeInMillis() - timeHelperExt.f();
            if (timeInMillis > 0) {
                this.f99709a = SpillingKt.a(calendar);
                this.f99710b = timeInMillis;
                this.f99711c = 1;
                if (DelayKt.b(timeInMillis, this) == objF) {
                    return objF;
                }
            }
            return Unit.f139807a;
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        this.f99712d.B2();
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BlockingScreenViewModel$handlePossibleFutureUsageLimitReset$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
