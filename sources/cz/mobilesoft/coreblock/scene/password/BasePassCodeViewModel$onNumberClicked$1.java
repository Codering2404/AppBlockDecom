package cz.mobilesoft.coreblock.scene.password;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel$onNumberClicked$1", f = "BasePassCodeViewModel.kt", l = {78}, m = "invokeSuspend", v = 1)
final class BasePassCodeViewModel$onNumberClicked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f111651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f111652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BasePassCodeViewModel f111653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f111654d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BasePassCodeViewModel$onNumberClicked$1(BasePassCodeViewModel basePassCodeViewModel, int i3, Continuation continuation) {
        super(2, continuation);
        this.f111653c = basePassCodeViewModel;
        this.f111654d = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PassCodeViewState q(String str, PassCodeViewState passCodeViewState) {
        return PassCodeViewState.b(passCodeViewState, null, str, null, false, 0, 0L, null, 125, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BasePassCodeViewModel$onNumberClicked$1(this.f111653c, this.f111654d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f111652b;
        if (i3 == 0) {
            ResultKt.b(obj);
            if (this.f111653c.f111632o) {
                return Unit.f139807a;
            }
            PassCodeViewState passCodeViewStateU0 = BasePassCodeViewModel.U0(this.f111653c);
            if (passCodeViewStateU0.e().length() < 8) {
                final String str = passCodeViewStateU0.e() + this.f111654d;
                this.f111653c.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.password.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return BasePassCodeViewModel$onNumberClicked$1.q(str, (PassCodeViewState) obj2);
                    }
                });
                return Unit.f139807a;
            }
            BasePassCodeViewModel basePassCodeViewModel = this.f111653c;
            this.f111651a = SpillingKt.a(passCodeViewStateU0);
            this.f111652b = 1;
            if (basePassCodeViewModel.d1(false, this) == objF) {
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
        return ((BasePassCodeViewModel$onNumberClicked$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
