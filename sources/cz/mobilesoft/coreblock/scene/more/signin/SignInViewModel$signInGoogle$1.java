package cz.mobilesoft.coreblock.scene.more.signin;

import android.content.Context;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$signInGoogle$1", f = "SignInViewModel.kt", l = {318, 324, 338, 342}, m = "invokeSuspend", v = 1)
final class SignInViewModel$signInGoogle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f110501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f110502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f110503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f110504d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private /* synthetic */ Object f110505f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ SignInViewModel f110506g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Context f110507h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SignInViewModel$signInGoogle$1(SignInViewModel signInViewModel, Context context, Continuation continuation) {
        super(2, continuation);
        this.f110506g = signInViewModel;
        this.f110507h = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SignInViewState y(SignInViewState signInViewState) {
        return SignInViewState.b(signInViewState, null, null, null, null, null, null, null, false, false, null, null, null, false, false, false, false, false, false, false, true, false, null, 3670015, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SignInViewState z(SignInViewState signInViewState) {
        return SignInViewState.b(signInViewState, null, null, null, null, null, null, null, false, false, null, null, null, false, false, false, false, false, false, false, true, false, null, 3670015, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        SignInViewModel$signInGoogle$1 signInViewModel$signInGoogle$1 = new SignInViewModel$signInGoogle$1(this.f110506g, this.f110507h, continuation);
        signInViewModel$signInGoogle$1.f110505f = obj;
        return signInViewModel$signInGoogle$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x007a, code lost:
    
        if (r10.P0(r2, r9) == r1) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00f7, code lost:
    
        if (r2.P0(r3, r9) == r1) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x012b, code lost:
    
        if (r2.P0(r4, r9) == r1) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00aa A[Catch: Exception -> 0x0038, TryCatch #0 {Exception -> 0x0038, blocks: (B:13:0x0034, B:30:0x00a6, B:32:0x00aa, B:33:0x00b1, B:25:0x0081, B:27:0x008b), top: B:47:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b1 A[Catch: Exception -> 0x0038, TRY_LEAVE, TryCatch #0 {Exception -> 0x0038, blocks: (B:13:0x0034, B:30:0x00a6, B:32:0x00aa, B:33:0x00b1, B:25:0x0081, B:27:0x008b), top: B:47:0x0010 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$signInGoogle$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((SignInViewModel$signInGoogle$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
