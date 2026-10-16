package cz.mobilesoft.coreblock.scene.password;

import cz.mobilesoft.coreblock.scene.password.PassCodeViewCommand;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.password.PassCodeScreenKt$CommandProcessor$1$1", f = "PassCodeScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class PassCodeScreenKt$CommandProcessor$1$1 extends SuspendLambda implements Function2<PassCodeViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f111672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f111673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function1 f111674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function0 f111675d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PassCodeScreenKt$CommandProcessor$1$1(Function1 function1, Function0 function0, Continuation continuation) {
        super(2, continuation);
        this.f111674c = function1;
        this.f111675d = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        PassCodeScreenKt$CommandProcessor$1$1 passCodeScreenKt$CommandProcessor$1$1 = new PassCodeScreenKt$CommandProcessor$1$1(this.f111674c, this.f111675d, continuation);
        passCodeScreenKt$CommandProcessor$1$1.f111673b = obj;
        return passCodeScreenKt$CommandProcessor$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(PassCodeViewCommand passCodeViewCommand, Continuation continuation) {
        return ((PassCodeScreenKt$CommandProcessor$1$1) create(passCodeViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        PassCodeViewCommand passCodeViewCommand = (PassCodeViewCommand) this.f111673b;
        IntrinsicsKt.f();
        if (this.f111672a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (passCodeViewCommand instanceof PassCodeViewCommand.OnSuccess) {
            this.f111674c.invoke(((PassCodeViewCommand.OnSuccess) passCodeViewCommand).a());
        } else {
            if (!(passCodeViewCommand instanceof PassCodeViewCommand.OnShowUnlockDialog)) {
                throw new NoWhenBranchMatchedException();
            }
            this.f111675d.invoke();
        }
        return Unit.f139807a;
    }
}
