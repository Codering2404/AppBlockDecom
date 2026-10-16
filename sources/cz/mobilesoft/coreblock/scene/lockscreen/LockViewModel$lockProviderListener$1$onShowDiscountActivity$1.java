package cz.mobilesoft.coreblock.scene.lockscreen;

import cz.mobilesoft.coreblock.enums.RevenueCatPlacement;
import cz.mobilesoft.coreblock.scene.lockscreen.LockViewCommand;
import cz.mobilesoft.coreblock.scene.premium.enums.DiscountSource;
import kotlin.Metadata;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.lockscreen.LockViewModel$lockProviderListener$1$onShowDiscountActivity$1", f = "LockViewModel.kt", l = {70}, m = "invokeSuspend", v = 1)
final class LockViewModel$lockProviderListener$1$onShowDiscountActivity$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f105501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LockViewModel f105502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ RevenueCatPlacement f105503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ DiscountSource f105504d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockViewModel$lockProviderListener$1$onShowDiscountActivity$1(LockViewModel lockViewModel, RevenueCatPlacement revenueCatPlacement, DiscountSource discountSource, Continuation continuation) {
        super(2, continuation);
        this.f105502b = lockViewModel;
        this.f105503c = revenueCatPlacement;
        this.f105504d = discountSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LockViewModel$lockProviderListener$1$onShowDiscountActivity$1(this.f105502b, this.f105503c, this.f105504d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f105501a;
        if (i3 == 0) {
            ResultKt.b(obj);
            LockViewModel lockViewModel = this.f105502b;
            LockViewCommand.ShowPremiumDiscountCommand showPremiumDiscountCommand = new LockViewCommand.ShowPremiumDiscountCommand(this.f105503c, this.f105504d);
            this.f105501a = 1;
            if (lockViewModel.P0(showPremiumDiscountCommand, this) == objF) {
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

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LockViewModel$lockProviderListener$1$onShowDiscountActivity$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
