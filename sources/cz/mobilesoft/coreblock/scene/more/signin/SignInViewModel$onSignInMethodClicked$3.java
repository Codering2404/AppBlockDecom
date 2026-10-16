package cz.mobilesoft.coreblock.scene.more.signin;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$onSignInMethodClicked$3", f = "SignInViewModel.kt", l = {375, 377}, m = "invokeSuspend", v = 1)
final class SignInViewModel$onSignInMethodClicked$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f110456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SignInViewModel f110457b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SignInViewModel$onSignInMethodClicked$3(SignInViewModel signInViewModel, Continuation continuation) {
        super(2, continuation);
        this.f110457b = signInViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SignInViewModel$onSignInMethodClicked$3(this.f110457b, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0034, code lost:
    
        if (r6.P0(r1, r5) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0055, code lost:
    
        if (r6.P0(r1, r5) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0057, code lost:
    
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r5.f110456a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1b
            if (r1 == r3) goto L17
            if (r1 != r2) goto Lf
            goto L17
        Lf:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L17:
            kotlin.ResultKt.b(r6)
            goto L58
        L1b:
            kotlin.ResultKt.b(r6)
            cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel r6 = r5.f110457b
            android.content.Context r6 = r6.A0()
            boolean r6 = cz.mobilesoft.coreblock.util.NetworkHelperKt.b(r6)
            if (r6 == 0) goto L37
            cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel r6 = r5.f110457b
            cz.mobilesoft.coreblock.scene.more.signin.SignInViewCommand$LaunchAppleSignIn r1 = cz.mobilesoft.coreblock.scene.more.signin.SignInViewCommand.LaunchAppleSignIn.f110407a
            r5.f110456a = r3
            java.lang.Object r6 = cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel.l1(r6, r1, r5)
            if (r6 != r0) goto L58
            goto L57
        L37:
            cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel r6 = r5.f110457b
            cz.mobilesoft.coreblock.scene.more.signin.SignInViewCommand$ShowSnackBar r1 = new cz.mobilesoft.coreblock.scene.more.signin.SignInViewCommand$ShowSnackBar
            cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel r3 = r5.f110457b
            android.content.Context r3 = r3.A0()
            int r4 = cz.mobilesoft.coreblock.R.string.Vk
            java.lang.String r3 = r3.getString(r4)
            java.lang.String r4 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r1.<init>(r3)
            r5.f110456a = r2
            java.lang.Object r6 = cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel.l1(r6, r1, r5)
            if (r6 != r0) goto L58
        L57:
            return r0
        L58:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$onSignInMethodClicked$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((SignInViewModel$onSignInMethodClicked$3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
