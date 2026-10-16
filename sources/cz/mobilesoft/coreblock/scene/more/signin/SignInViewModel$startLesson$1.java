package cz.mobilesoft.coreblock.scene.more.signin;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$startLesson$1", f = "SignInViewModel.kt", l = {635, 639, 640}, m = "invokeSuspend", v = 1)
final class SignInViewModel$startLesson$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f110541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f110542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f110543c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function0 f110544d;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$startLesson$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$startLesson$1$1", f = "SignInViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f110545a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0 f110546b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Function0 function0, Continuation continuation) {
            super(2, continuation);
            this.f110546b = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f110546b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f110545a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.f110546b.invoke();
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SignInViewModel$startLesson$1(long j3, Function0 function0, Continuation continuation) {
        super(1, continuation);
        this.f110543c = j3;
        this.f110544d = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new SignInViewModel$startLesson$1(this.f110543c, this.f110544d, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0080, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r10, r3, r9) != r0) goto L38;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r9.f110542b
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L2f
            if (r1 == r4) goto L2b
            if (r1 == r3) goto L23
            if (r1 != r2) goto L1b
            java.lang.Object r0 = r9.f110541a
            cz.mobilesoft.coreblock.rest.ApiResponse r0 = (cz.mobilesoft.coreblock.rest.ApiResponse) r0
            kotlin.ResultKt.b(r10)
            goto Lb2
        L1b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L23:
            java.lang.Object r1 = r9.f110541a
            cz.mobilesoft.coreblock.rest.ApiResponse r1 = (cz.mobilesoft.coreblock.rest.ApiResponse) r1
            kotlin.ResultKt.b(r10)
            goto L69
        L2b:
            kotlin.ResultKt.b(r10)
            goto L48
        L2f:
            kotlin.ResultKt.b(r10)
            cz.mobilesoft.coreblock.rest.RestClient r10 = cz.mobilesoft.coreblock.rest.RestClient.f98457a
            cz.mobilesoft.coreblock.rest.ApiInterface r1 = r10.t()
            cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$startLesson$1$response$1 r6 = new cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$startLesson$1$response$1
            long r7 = r9.f110543c
            r6.<init>(r7, r5)
            r9.f110542b = r4
            java.lang.Object r10 = r10.H(r1, r6, r9)
            if (r10 != r0) goto L48
            goto L82
        L48:
            r1 = r10
            cz.mobilesoft.coreblock.rest.ApiResponse r1 = (cz.mobilesoft.coreblock.rest.ApiResponse) r1
            boolean r10 = r1 instanceof cz.mobilesoft.coreblock.rest.ApiResponse.Data
            if (r10 == 0) goto L83
            cz.mobilesoft.coreblock.repository.AcademyRepository r10 = cz.mobilesoft.coreblock.repository.AcademyRepository.f97249a
            r4 = r1
            cz.mobilesoft.coreblock.rest.ApiResponse$Data r4 = (cz.mobilesoft.coreblock.rest.ApiResponse.Data) r4
            java.lang.Object r4 = r4.c()
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r1)
            r9.f110541a = r6
            r9.f110542b = r3
            java.lang.Object r10 = r10.r(r4, r9)
            if (r10 != r0) goto L69
            goto L82
        L69:
            kotlinx.coroutines.MainCoroutineDispatcher r10 = kotlinx.coroutines.Dispatchers.c()
            cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$startLesson$1$1 r3 = new cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$startLesson$1$1
            kotlin.jvm.functions.Function0 r4 = r9.f110544d
            r3.<init>(r4, r5)
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.a(r1)
            r9.f110541a = r1
            r9.f110542b = r2
            java.lang.Object r10 = kotlinx.coroutines.BuildersKt.g(r10, r3, r9)
            if (r10 != r0) goto Lb2
        L82:
            return r0
        L83:
            boolean r10 = r1 instanceof cz.mobilesoft.coreblock.rest.ApiResponse.Error
            if (r10 == 0) goto Lb2
            cz.mobilesoft.coreblock.rest.ApiResponse$Error r1 = (cz.mobilesoft.coreblock.rest.ApiResponse.Error) r1
            cz.mobilesoft.coreblock.rest.response.ErrorBody r10 = r1.d()
            if (r10 == 0) goto L98
            int r10 = r10.getCode()
            java.lang.Integer r10 = kotlin.coroutines.jvm.internal.Boxing.d(r10)
            goto L99
        L98:
            r10 = r5
        L99:
            if (r10 != 0) goto L9c
            goto La4
        L9c:
            int r0 = r10.intValue()
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto Laf
        La4:
            if (r10 != 0) goto La7
            goto Lb2
        La7:
            int r10 = r10.intValue()
            r0 = 310(0x136, float:4.34E-43)
            if (r10 != r0) goto Lb2
        Laf:
            cz.mobilesoft.coreblock.repository.AcademyRepository.q(r5, r4, r5)
        Lb2:
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$startLesson$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((SignInViewModel$startLesson$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
