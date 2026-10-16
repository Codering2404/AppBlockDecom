package cz.mobilesoft.coreblock.scene.troubleshooting;

import cz.mobilesoft.coreblock.enums.HelpItemResultLauncher;
import cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewCommand;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackActivity$CommandProcessor$1$1", f = "TroubleshootingStackActivity.kt", l = {}, m = "invokeSuspend", v = 1)
final class TroubleshootingStackActivity$CommandProcessor$1$1 extends SuspendLambda implements Function2<TroubleshootingStackViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f122967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f122968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TroubleshootingStackActivity f122969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ HelpItemResultLauncher f122970d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TroubleshootingStackActivity$CommandProcessor$1$1(TroubleshootingStackActivity troubleshootingStackActivity, HelpItemResultLauncher helpItemResultLauncher, Continuation continuation) {
        super(2, continuation);
        this.f122969c = troubleshootingStackActivity;
        this.f122970d = helpItemResultLauncher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        TroubleshootingStackActivity$CommandProcessor$1$1 troubleshootingStackActivity$CommandProcessor$1$1 = new TroubleshootingStackActivity$CommandProcessor$1$1(this.f122969c, this.f122970d, continuation);
        troubleshootingStackActivity$CommandProcessor$1$1.f122968b = obj;
        return troubleshootingStackActivity$CommandProcessor$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(TroubleshootingStackViewCommand troubleshootingStackViewCommand, Continuation continuation) {
        return ((TroubleshootingStackActivity$CommandProcessor$1$1) create(troubleshootingStackViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        TroubleshootingStackViewCommand troubleshootingStackViewCommand = (TroubleshootingStackViewCommand) this.f122968b;
        IntrinsicsKt.f();
        if (this.f122967a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (Intrinsics.areEqual(troubleshootingStackViewCommand, TroubleshootingStackViewCommand.Finish.f122983a)) {
            this.f122969c.finish();
        } else {
            if (!(troubleshootingStackViewCommand instanceof TroubleshootingStackViewCommand.ShowHelpItem)) {
                throw new NoWhenBranchMatchedException();
            }
            ((TroubleshootingStackViewCommand.ShowHelpItem) troubleshootingStackViewCommand).a().invoke(this.f122970d);
        }
        return Unit.f139807a;
    }
}
