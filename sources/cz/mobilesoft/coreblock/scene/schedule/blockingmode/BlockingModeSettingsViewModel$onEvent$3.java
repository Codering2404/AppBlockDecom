package cz.mobilesoft.coreblock.scene.schedule.blockingmode;

import cz.mobilesoft.coreblock.scene.schedule.blockingmode.BlockingModeSettingsViewCommand;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.blockingmode.BlockingModeSettingsViewModel$onEvent$3", f = "BlockingModeSettingsViewModel.kt", l = {89}, m = "invokeSuspend", v = 1)
final class BlockingModeSettingsViewModel$onEvent$3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f115070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BlockingModeSettingsViewModel f115071b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BlockingModeSettingsViewModel$onEvent$3(BlockingModeSettingsViewModel blockingModeSettingsViewModel, Continuation continuation) {
        super(1, continuation);
        this.f115071b = blockingModeSettingsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new BlockingModeSettingsViewModel$onEvent$3(this.f115071b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f115070a;
        if (i3 == 0) {
            ResultKt.b(obj);
            BlockingModeSettingsViewModel blockingModeSettingsViewModel = this.f115071b;
            BlockingModeSettingsViewCommand.ShowAllowlistDisabledDialog showAllowlistDisabledDialog = BlockingModeSettingsViewCommand.ShowAllowlistDisabledDialog.f115058a;
            this.f115070a = 1;
            if (blockingModeSettingsViewModel.P0(showAllowlistDisabledDialog, this) == objF) {
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
        return ((BlockingModeSettingsViewModel$onEvent$3) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
