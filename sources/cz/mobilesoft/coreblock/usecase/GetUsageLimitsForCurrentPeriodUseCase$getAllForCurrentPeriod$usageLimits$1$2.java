package cz.mobilesoft.coreblock.usecase;

import cz.mobilesoft.coreblock.dto.UrlDto;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.AdultContentWebsiteDao;
import cz.mobilesoft.coreblock.util.helperextension.DatabaseExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.usecase.GetUsageLimitsForCurrentPeriodUseCase$getAllForCurrentPeriod$usageLimits$1$2", f = "GetUsageLimitsForCurrentPeriodUseCase.kt", l = {76}, m = "invokeSuspend", v = 1)
final class GetUsageLimitsForCurrentPeriodUseCase$getAllForCurrentPeriod$usageLimits$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f127140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ GetUsageLimitsForCurrentPeriodUseCase f127141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ UrlDto f127142c;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.usecase.GetUsageLimitsForCurrentPeriodUseCase$getAllForCurrentPeriod$usageLimits$1$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.usecase.GetUsageLimitsForCurrentPeriodUseCase$getAllForCurrentPeriod$usageLimits$1$2$1", f = "GetUsageLimitsForCurrentPeriodUseCase.kt", l = {76}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f127143a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ GetUsageLimitsForCurrentPeriodUseCase f127144b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ UrlDto f127145c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(GetUsageLimitsForCurrentPeriodUseCase getUsageLimitsForCurrentPeriodUseCase, UrlDto urlDto, Continuation continuation) {
            super(1, continuation);
            this.f127144b = getUsageLimitsForCurrentPeriodUseCase;
            this.f127145c = urlDto;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new AnonymousClass1(this.f127144b, this.f127145c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f127143a;
            if (i3 != 0) {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return obj;
            }
            ResultKt.b(obj);
            AdultContentWebsiteDao adultContentWebsiteDaoE = this.f127144b.e();
            String domain = this.f127145c.getDomain();
            this.f127143a = 1;
            Object objM = adultContentWebsiteDaoE.M(domain, this);
            return objM == objF ? objF : objM;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GetUsageLimitsForCurrentPeriodUseCase$getAllForCurrentPeriod$usageLimits$1$2(GetUsageLimitsForCurrentPeriodUseCase getUsageLimitsForCurrentPeriodUseCase, UrlDto urlDto, Continuation continuation) {
        super(2, continuation);
        this.f127141b = getUsageLimitsForCurrentPeriodUseCase;
        this.f127142c = urlDto;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new GetUsageLimitsForCurrentPeriodUseCase$getAllForCurrentPeriod$usageLimits$1$2(this.f127141b, this.f127142c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f127140a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f127141b, this.f127142c, null);
        this.f127140a = 1;
        Object objB = DatabaseExtKt.b(0, 0L, anonymousClass1, this, 3, null);
        return objB == objF ? objF : objB;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((GetUsageLimitsForCurrentPeriodUseCase$getAllForCurrentPeriod$usageLimits$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
