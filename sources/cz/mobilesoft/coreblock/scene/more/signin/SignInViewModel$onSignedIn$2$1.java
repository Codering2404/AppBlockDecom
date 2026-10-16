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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$onSignedIn$2$1", f = "SignInViewModel.kt", l = {606, 606}, m = "invokeSuspend", v = 1)
final class SignInViewModel$onSignedIn$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f110470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f110471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ SignInViewModel f110472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ SignInViewState f110473d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SignInViewModel$onSignedIn$2$1(SignInViewModel signInViewModel, SignInViewState signInViewState, Continuation continuation) {
        super(2, continuation);
        this.f110472c = signInViewModel;
        this.f110473d = signInViewState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SignInViewModel$onSignedIn$2$1(this.f110472c, this.f110473d, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0048, code lost:
    
        if (r1.P0(r3, r4) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.f110471b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r5)
            goto L4b
        L12:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L1a:
            java.lang.Object r1 = r4.f110470a
            cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel r1 = (cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel) r1
            kotlin.ResultKt.b(r5)
            goto L34
        L22:
            kotlin.ResultKt.b(r5)
            cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel r1 = r4.f110472c
            cz.mobilesoft.coreblock.scene.more.signin.SignInViewState r5 = r4.f110473d
            r4.f110470a = r1
            r4.f110471b = r3
            java.lang.Object r5 = cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel.m1(r1, r5, r4)
            if (r5 != r0) goto L34
            goto L4a
        L34:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            cz.mobilesoft.coreblock.scene.more.signin.SignInViewCommand$OnFinish r3 = new cz.mobilesoft.coreblock.scene.more.signin.SignInViewCommand$OnFinish
            r3.<init>(r5)
            r5 = 0
            r4.f110470a = r5
            r4.f110471b = r2
            java.lang.Object r5 = cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel.l1(r1, r3, r4)
            if (r5 != r0) goto L4b
        L4a:
            return r0
        L4b:
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$onSignedIn$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((SignInViewModel$onSignedIn$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
