package cz.mobilesoft.coreblock.scene.schedule.blockingmode;

import androidx.compose.runtime.MutableState;
import cz.mobilesoft.coreblock.scene.schedule.blockingmode.BlockingModeSettingsViewCommand;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.blockingmode.BlockingModeSettingsScreenKt$CommandProcessor$1$1", f = "BlockingModeSettingsScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class BlockingModeSettingsScreenKt$CommandProcessor$1$1 extends SuspendLambda implements Function2<BlockingModeSettingsViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f115051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f115052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function1 f115053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ MutableState f115054d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function0 f115055f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BlockingModeSettingsScreenKt$CommandProcessor$1$1(Function1 function1, MutableState mutableState, Function0 function0, Continuation continuation) {
        super(2, continuation);
        this.f115053c = function1;
        this.f115054d = mutableState;
        this.f115055f = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        BlockingModeSettingsScreenKt$CommandProcessor$1$1 blockingModeSettingsScreenKt$CommandProcessor$1$1 = new BlockingModeSettingsScreenKt$CommandProcessor$1$1(this.f115053c, this.f115054d, this.f115055f, continuation);
        blockingModeSettingsScreenKt$CommandProcessor$1$1.f115052b = obj;
        return blockingModeSettingsScreenKt$CommandProcessor$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(BlockingModeSettingsViewCommand blockingModeSettingsViewCommand, Continuation continuation) {
        return ((BlockingModeSettingsScreenKt$CommandProcessor$1$1) create(blockingModeSettingsViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        BlockingModeSettingsViewCommand blockingModeSettingsViewCommand = (BlockingModeSettingsViewCommand) this.f115052b;
        IntrinsicsKt.f();
        if (this.f115051a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (blockingModeSettingsViewCommand instanceof BlockingModeSettingsViewCommand.OnContinueClicked) {
            this.f115053c.invoke(((BlockingModeSettingsViewCommand.OnContinueClicked) blockingModeSettingsViewCommand).a());
        } else if (blockingModeSettingsViewCommand instanceof BlockingModeSettingsViewCommand.ShowAllowlistDisabledDialog) {
            this.f115054d.setValue(Boxing.a(true));
        } else {
            if (!(blockingModeSettingsViewCommand instanceof BlockingModeSettingsViewCommand.OpenPremiumActivity)) {
                throw new NoWhenBranchMatchedException();
            }
            this.f115055f.invoke();
        }
        return Unit.f139807a;
    }
}
