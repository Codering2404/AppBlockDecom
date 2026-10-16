package cz.mobilesoft.coreblock.scene.password;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel$onBackspaceClicked$1", f = "BasePassCodeViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
final class BasePassCodeViewModel$onBackspaceClicked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f111643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BasePassCodeViewModel f111644b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BasePassCodeViewModel$onBackspaceClicked$1(BasePassCodeViewModel basePassCodeViewModel, Continuation continuation) {
        super(2, continuation);
        this.f111644b = basePassCodeViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PassCodeViewState q(PassCodeViewState passCodeViewState) {
        return PassCodeViewState.b(passCodeViewState, null, StringsKt.x1(passCodeViewState.e(), 1), null, false, 0, 0L, null, 125, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BasePassCodeViewModel$onBackspaceClicked$1(this.f111644b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f111643a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (BasePassCodeViewModel.U0(this.f111644b).e().length() > 0) {
            this.f111644b.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.password.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return BasePassCodeViewModel$onBackspaceClicked$1.q((PassCodeViewState) obj2);
                }
            });
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BasePassCodeViewModel$onBackspaceClicked$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
