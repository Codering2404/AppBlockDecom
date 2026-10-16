package cz.mobilesoft.coreblock.storage.room.dao.blocking;

import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao_Impl$setUsageLimit$2", f = "UsageLimitDao_Impl.kt", l = {170}, m = "invokeSuspend", v = 1)
final class UsageLimitDao_Impl$setUsageLimit$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f125297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ UsageLimitDao_Impl f125298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f125299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f125300d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ UsageLimit.PeriodType f125301f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ UsageLimit.LimitType f125302g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UsageLimitDao_Impl$setUsageLimit$2(UsageLimitDao_Impl usageLimitDao_Impl, long j3, long j4, UsageLimit.PeriodType periodType, UsageLimit.LimitType limitType, Continuation continuation) {
        super(1, continuation);
        this.f125298b = usageLimitDao_Impl;
        this.f125299c = j3;
        this.f125300d = j4;
        this.f125301f = periodType;
        this.f125302g = limitType;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new UsageLimitDao_Impl$setUsageLimit$2(this.f125298b, this.f125299c, this.f125300d, this.f125301f, this.f125302g, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f125297a;
        if (i3 == 0) {
            ResultKt.b(obj);
            UsageLimitDao_Impl usageLimitDao_Impl = this.f125298b;
            long j3 = this.f125299c;
            long j4 = this.f125300d;
            UsageLimit.PeriodType periodType = this.f125301f;
            UsageLimit.LimitType limitType = this.f125302g;
            this.f125297a = 1;
            if (super/*cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao*/.a0(j3, j4, periodType, limitType, this) == objF) {
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
        return ((UsageLimitDao_Impl$setUsageLimit$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
