package cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput;

import cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.StrictModeEmailInputBottomSheetViewCommand;
import cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.StrictModeEmailInputBottomSheetViewEvent;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.StrictModeEmailInputBottomSheetKt$StrictModeEmailInputBottomSheet$4$1", f = "StrictModeEmailInputBottomSheet.kt", l = {}, m = "invokeSuspend", v = 1)
final class StrictModeEmailInputBottomSheetKt$StrictModeEmailInputBottomSheet$4$1 extends SuspendLambda implements Function2<StrictModeEmailInputBottomSheetViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f121854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f121855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function1 f121856c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function0 f121857d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function1 f121858f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StrictModeEmailInputBottomSheetKt$StrictModeEmailInputBottomSheet$4$1(Function1 function1, Function0 function0, Function1 function12, Continuation continuation) {
        super(2, continuation);
        this.f121856c = function1;
        this.f121857d = function0;
        this.f121858f = function12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        StrictModeEmailInputBottomSheetKt$StrictModeEmailInputBottomSheet$4$1 strictModeEmailInputBottomSheetKt$StrictModeEmailInputBottomSheet$4$1 = new StrictModeEmailInputBottomSheetKt$StrictModeEmailInputBottomSheet$4$1(this.f121856c, this.f121857d, this.f121858f, continuation);
        strictModeEmailInputBottomSheetKt$StrictModeEmailInputBottomSheet$4$1.f121855b = obj;
        return strictModeEmailInputBottomSheetKt$StrictModeEmailInputBottomSheet$4$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(StrictModeEmailInputBottomSheetViewCommand strictModeEmailInputBottomSheetViewCommand, Continuation continuation) {
        return ((StrictModeEmailInputBottomSheetKt$StrictModeEmailInputBottomSheet$4$1) create(strictModeEmailInputBottomSheetViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        StrictModeEmailInputBottomSheetViewCommand strictModeEmailInputBottomSheetViewCommand = (StrictModeEmailInputBottomSheetViewCommand) this.f121855b;
        IntrinsicsKt.f();
        if (this.f121854a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (!(strictModeEmailInputBottomSheetViewCommand instanceof StrictModeEmailInputBottomSheetViewCommand.ApprovalEmailSet)) {
            throw new NoWhenBranchMatchedException();
        }
        this.f121856c.invoke(((StrictModeEmailInputBottomSheetViewCommand.ApprovalEmailSet) strictModeEmailInputBottomSheetViewCommand).a());
        this.f121857d.invoke();
        this.f121858f.invoke(StrictModeEmailInputBottomSheetViewEvent.OnDismiss.f121860a);
        return Unit.f139807a;
    }
}
