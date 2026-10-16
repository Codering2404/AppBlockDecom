package cz.mobilesoft.coreblock.scene.schedule.customcombination;

import cz.mobilesoft.coreblock.enums.StrictModeTitleAlternatives;
import cz.mobilesoft.coreblock.scene.schedule.customcombination.CustomCombinationViewCommand;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.customcombination.CustomCombinationViewModel$onOpenCondition$1", f = "CustomCombinationViewModel.kt", l = {203}, m = "invokeSuspend", v = 1)
final class CustomCombinationViewModel$onOpenCondition$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f116313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ CustomCombinationViewModel f116314b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CustomCombinationViewModel$onOpenCondition$1(CustomCombinationViewModel customCombinationViewModel, Continuation continuation) {
        super(1, continuation);
        this.f116314b = customCombinationViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new CustomCombinationViewModel$onOpenCondition$1(this.f116314b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f116313a;
        if (i3 == 0) {
            ResultKt.b(obj);
            CustomCombinationViewModel customCombinationViewModel = this.f116314b;
            String string = this.f116314b.A0().getString(StrictModeTitleAlternatives.Companion.a());
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomCombinationViewCommand.ShowSnackbar showSnackbar = new CustomCombinationViewCommand.ShowSnackbar(string);
            this.f116313a = 1;
            if (customCombinationViewModel.P0(showSnackbar, this) == objF) {
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
        return ((CustomCombinationViewModel$onOpenCondition$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
