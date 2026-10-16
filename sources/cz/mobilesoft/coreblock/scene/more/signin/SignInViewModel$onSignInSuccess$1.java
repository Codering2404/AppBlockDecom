package cz.mobilesoft.coreblock.scene.more.signin;

import cz.mobilesoft.coreblock.scene.more.signin.SignInViewCommand;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$onSignInSuccess$1", f = "SignInViewModel.kt", l = {522}, m = "invokeSuspend", v = 1)
final class SignInViewModel$onSignInSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f110458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SignInViewModel f110459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f110460c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SignInViewModel$onSignInSuccess$1(SignInViewModel signInViewModel, String str, Continuation continuation) {
        super(2, continuation);
        this.f110459b = signInViewModel;
        this.f110460c = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SignInViewModel$onSignInSuccess$1(this.f110459b, this.f110460c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f110458a;
        if (i3 == 0) {
            ResultKt.b(obj);
            SignInViewModel signInViewModel = this.f110459b;
            SignInViewCommand.OnSignInSuccess onSignInSuccess = new SignInViewCommand.OnSignInSuccess(this.f110460c);
            this.f110458a = 1;
            if (signInViewModel.P0(onSignInSuccess, this) == objF) {
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
        return ((SignInViewModel$onSignInSuccess$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
