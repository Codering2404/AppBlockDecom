package cz.mobilesoft.coreblock.scene.quickblock.timer;

import cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao;
import cz.mobilesoft.coreblock.storage.room.entity.core.QuickBlockTimerHistory;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewModel$startBlocking$1", f = "QuickBlockTimeSelectViewModel.kt", l = {112}, m = "invokeSuspend", v = 1)
final class QuickBlockTimeSelectViewModel$startBlocking$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f114304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f114305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f114306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ QuickBlockTimeSelectViewModel f114307d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    QuickBlockTimeSelectViewModel$startBlocking$1(long j3, QuickBlockTimeSelectViewModel quickBlockTimeSelectViewModel, Continuation continuation) {
        super(1, continuation);
        this.f114306c = j3;
        this.f114307d = quickBlockTimeSelectViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new QuickBlockTimeSelectViewModel$startBlocking$1(this.f114306c, this.f114307d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f114305b;
        if (i3 == 0) {
            ResultKt.b(obj);
            QuickBlockTimerHistory quickBlockTimerHistory = new QuickBlockTimerHistory(0, this.f114306c, 0, 5, null);
            QuickBlockTimerHistoryDao quickBlockTimerHistoryDaoD1 = this.f114307d.d1();
            this.f114304a = SpillingKt.a(quickBlockTimerHistory);
            this.f114305b = 1;
            if (quickBlockTimerHistoryDaoD1.J(quickBlockTimerHistory, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((QuickBlockTimeSelectViewModel$startBlocking$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
