package cz.mobilesoft.coreblock.usecase;

import com.revenuecat.purchases.CustomerInfo;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.storage.datastore.entity.AutoTrialVariant;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function6;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.usecase.CheckAutoTrialEligibilityUseCase$invoke$1", f = "CheckAutoTrialEligibilityUseCase.kt", l = {}, m = "invokeSuspend", v = 1)
final class CheckAutoTrialEligibilityUseCase$invoke$1 extends SuspendLambda implements Function6<PremiumState, CustomerInfo, Boolean, AutoTrialVariant, Boolean, Continuation<? super Boolean>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f126979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f126980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ Object f126981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    /* synthetic */ boolean f126982d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    /* synthetic */ Object f126983f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    /* synthetic */ boolean f126984g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ CheckAutoTrialEligibilityUseCase f126985h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CheckAutoTrialEligibilityUseCase$invoke$1(CheckAutoTrialEligibilityUseCase checkAutoTrialEligibilityUseCase, Continuation continuation) {
        super(6, continuation);
        this.f126985h = checkAutoTrialEligibilityUseCase;
    }

    public final Object h(PremiumState premiumState, CustomerInfo customerInfo, boolean z2, AutoTrialVariant autoTrialVariant, boolean z3, Continuation continuation) {
        CheckAutoTrialEligibilityUseCase$invoke$1 checkAutoTrialEligibilityUseCase$invoke$1 = new CheckAutoTrialEligibilityUseCase$invoke$1(this.f126985h, continuation);
        checkAutoTrialEligibilityUseCase$invoke$1.f126980b = premiumState;
        checkAutoTrialEligibilityUseCase$invoke$1.f126981c = customerInfo;
        checkAutoTrialEligibilityUseCase$invoke$1.f126982d = z2;
        checkAutoTrialEligibilityUseCase$invoke$1.f126983f = autoTrialVariant;
        checkAutoTrialEligibilityUseCase$invoke$1.f126984g = z3;
        return checkAutoTrialEligibilityUseCase$invoke$1.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        PremiumState premiumState = (PremiumState) this.f126980b;
        CustomerInfo customerInfo = (CustomerInfo) this.f126981c;
        boolean z2 = this.f126982d;
        AutoTrialVariant autoTrialVariant = (AutoTrialVariant) this.f126983f;
        boolean z3 = this.f126984g;
        IntrinsicsKt.f();
        if (this.f126979a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        boolean zG = false;
        if (autoTrialVariant != AutoTrialVariant.Off && !z2 && !premiumState.g() && customerInfo != null) {
            zG = this.f126985h.g(customerInfo, z3);
        }
        return Boxing.a(zG);
    }

    @Override // kotlin.jvm.functions.Function6
    public /* bridge */ /* synthetic */ Object k(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return h((PremiumState) obj, (CustomerInfo) obj2, ((Boolean) obj3).booleanValue(), (AutoTrialVariant) obj4, ((Boolean) obj5).booleanValue(), (Continuation) obj6);
    }
}
