package cz.mobilesoft.coreblock.scene.more.signin;

import androidx.compose.material.ScaffoldState;
import androidx.compose.material.SnackbarDuration;
import androidx.compose.material.SnackbarHostState;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.signin.SignInContentKt$SignInContent$appleSignInLauncher$1$1$2$1", f = "SignInContent.kt", l = {94}, m = "invokeSuspend", v = 1)
final class SignInContentKt$SignInContent$appleSignInLauncher$1$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f110398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ScaffoldState f110399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f110400c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SignInContentKt$SignInContent$appleSignInLauncher$1$1$2$1(ScaffoldState scaffoldState, String str, Continuation continuation) {
        super(2, continuation);
        this.f110399b = scaffoldState;
        this.f110400c = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SignInContentKt$SignInContent$appleSignInLauncher$1$1$2$1(this.f110399b, this.f110400c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f110398a;
        if (i3 == 0) {
            ResultKt.b(obj);
            SnackbarHostState snackbarHostStateB = this.f110399b.b();
            String str = this.f110400c;
            SnackbarDuration snackbarDuration = SnackbarDuration.Short;
            this.f110398a = 1;
            if (SnackbarHostState.e(snackbarHostStateB, str, null, snackbarDuration, this, 2, null) == objF) {
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
        return ((SignInContentKt$SignInContent$appleSignInLauncher$1$1$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
