package cz.mobilesoft.coreblock.scene.more.signin;

import androidx.lifecycle.Observer;
import cz.mobilesoft.coreblock.repository.AcademyRepository;
import cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$startSync$3;
import cz.mobilesoft.coreblock.util.FailedWithError;
import cz.mobilesoft.coreblock.util.Success;
import cz.mobilesoft.coreblock.util.ViewModelState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$startSync$3", f = "SignInViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
final class SignInViewModel$startSync$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f110558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SignInViewModel f110559b;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$startSync$3$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass1 implements Observer<ViewModelState> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SignInViewModel f110560a;

        AnonymousClass1(SignInViewModel signInViewModel) {
            this.f110560a = signInViewModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final SignInViewState d(ViewModelState viewModelState, SignInViewState updateState) {
            Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
            return SignInViewState.b(updateState, null, null, null, null, null, null, viewModelState, false, false, null, null, null, false, false, false, false, false, false, false, false, false, null, 4194239, null);
        }

        @Override // androidx.lifecycle.Observer
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(final ViewModelState value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.f110560a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.signin.r3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SignInViewModel$startSync$3.AnonymousClass1.d(value, (SignInViewState) obj);
                }
            });
            if ((value instanceof Success) || (value instanceof FailedWithError)) {
                AcademyRepository.f97249a.m().o(this);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SignInViewModel$startSync$3(SignInViewModel signInViewModel, Continuation continuation) {
        super(2, continuation);
        this.f110559b = signInViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SignInViewModel$startSync$3(this.f110559b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f110558a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        AcademyRepository.f97249a.m().k(new AnonymousClass1(this.f110559b));
        AcademyRepository.q(null, 1, null);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((SignInViewModel$startSync$3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
