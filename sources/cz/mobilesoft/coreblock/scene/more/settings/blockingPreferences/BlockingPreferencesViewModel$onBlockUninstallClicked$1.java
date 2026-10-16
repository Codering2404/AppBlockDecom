package cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences;

import cz.mobilesoft.coreblock.enums.StrictModeTitleAlternatives;
import cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewCommand;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$onBlockUninstallClicked$1", f = "BlockingPreferencesViewModel.kt", l = {254}, m = "invokeSuspend", v = 1)
final class BlockingPreferencesViewModel$onBlockUninstallClicked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f108123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BlockingPreferencesViewModel f108124b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BlockingPreferencesViewModel$onBlockUninstallClicked$1(BlockingPreferencesViewModel blockingPreferencesViewModel, Continuation continuation) {
        super(2, continuation);
        this.f108124b = blockingPreferencesViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BlockingPreferencesViewModel$onBlockUninstallClicked$1(this.f108124b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f108123a;
        if (i3 == 0) {
            ResultKt.b(obj);
            BlockingPreferencesViewModel blockingPreferencesViewModel = this.f108124b;
            String string = this.f108124b.A0().getString(StrictModeTitleAlternatives.Companion.a());
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            BlockingPreferencesViewCommand.ShowSnackBar showSnackBar = new BlockingPreferencesViewCommand.ShowSnackBar(string);
            this.f108123a = 1;
            if (blockingPreferencesViewModel.P0(showSnackBar, this) == objF) {
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
        return ((BlockingPreferencesViewModel$onBlockUninstallClicked$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
