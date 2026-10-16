package cz.mobilesoft.coreblock.scene.more.academy;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.academy.BaseAcademyLessonsViewModel$startLesson$1", f = "BaseAcademyLessonsViewModel.kt", l = {50, 54, 55}, m = "invokeSuspend", v = 1)
final class BaseAcademyLessonsViewModel$startLesson$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f106056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f106057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BaseAcademyLessonsViewModel f106058c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f106059d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function0 f106060f;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.academy.BaseAcademyLessonsViewModel$startLesson$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.academy.BaseAcademyLessonsViewModel$startLesson$1$1", f = "BaseAcademyLessonsViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f106061a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0 f106062b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Function0 function0, Continuation continuation) {
            super(2, continuation);
            this.f106062b = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f106062b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f106061a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.f106062b.invoke();
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseAcademyLessonsViewModel$startLesson$1(BaseAcademyLessonsViewModel baseAcademyLessonsViewModel, long j3, Function0 function0, Continuation continuation) {
        super(1, continuation);
        this.f106058c = baseAcademyLessonsViewModel;
        this.f106059d = j3;
        this.f106060f = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new BaseAcademyLessonsViewModel$startLesson$1(this.f106058c, this.f106059d, this.f106060f, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0085  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r9.f106057b
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L2f
            if (r1 == r4) goto L2b
            if (r1 == r3) goto L22
            if (r1 != r2) goto L1a
            java.lang.Object r0 = r9.f106056a
            cz.mobilesoft.coreblock.rest.ApiResponse r0 = (cz.mobilesoft.coreblock.rest.ApiResponse) r0
            kotlin.ResultKt.b(r10)
            goto L86
        L1a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L22:
            java.lang.Object r1 = r9.f106056a
            cz.mobilesoft.coreblock.rest.ApiResponse r1 = (cz.mobilesoft.coreblock.rest.ApiResponse) r1
            kotlin.ResultKt.b(r10)
            r10 = r1
            goto L6f
        L2b:
            kotlin.ResultKt.b(r10)
            goto L53
        L2f:
            kotlin.ResultKt.b(r10)
            cz.mobilesoft.coreblock.scene.more.academy.BaseAcademyLessonsViewModel r10 = r9.f106058c
            cz.mobilesoft.coreblock.util.livedata.FreshLiveData r10 = r10.J0()
            cz.mobilesoft.coreblock.util.Loading r1 = cz.mobilesoft.coreblock.util.Loading.f127895a
            r10.n(r1)
            cz.mobilesoft.coreblock.rest.RestClient r10 = cz.mobilesoft.coreblock.rest.RestClient.f98457a
            cz.mobilesoft.coreblock.rest.ApiInterface r1 = r10.t()
            cz.mobilesoft.coreblock.scene.more.academy.BaseAcademyLessonsViewModel$startLesson$1$response$1 r6 = new cz.mobilesoft.coreblock.scene.more.academy.BaseAcademyLessonsViewModel$startLesson$1$response$1
            long r7 = r9.f106059d
            r6.<init>(r7, r5)
            r9.f106057b = r4
            java.lang.Object r10 = r10.H(r1, r6, r9)
            if (r10 != r0) goto L53
            goto L84
        L53:
            cz.mobilesoft.coreblock.rest.ApiResponse r10 = (cz.mobilesoft.coreblock.rest.ApiResponse) r10
            boolean r1 = r10 instanceof cz.mobilesoft.coreblock.rest.ApiResponse.Data
            if (r1 == 0) goto L88
            cz.mobilesoft.coreblock.repository.AcademyRepository r1 = cz.mobilesoft.coreblock.repository.AcademyRepository.f97249a
            r4 = r10
            cz.mobilesoft.coreblock.rest.ApiResponse$Data r4 = (cz.mobilesoft.coreblock.rest.ApiResponse.Data) r4
            java.lang.Object r4 = r4.c()
            java.util.List r4 = (java.util.List) r4
            r9.f106056a = r10
            r9.f106057b = r3
            java.lang.Object r1 = r1.r(r4, r9)
            if (r1 != r0) goto L6f
            goto L84
        L6f:
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.c()
            cz.mobilesoft.coreblock.scene.more.academy.BaseAcademyLessonsViewModel$startLesson$1$1 r3 = new cz.mobilesoft.coreblock.scene.more.academy.BaseAcademyLessonsViewModel$startLesson$1$1
            kotlin.jvm.functions.Function0 r4 = r9.f106060f
            r3.<init>(r4, r5)
            r9.f106056a = r10
            r9.f106057b = r2
            java.lang.Object r1 = kotlinx.coroutines.BuildersKt.g(r1, r3, r9)
            if (r1 != r0) goto L85
        L84:
            return r0
        L85:
            r0 = r10
        L86:
            r10 = r0
            goto Lb8
        L88:
            boolean r0 = r10 instanceof cz.mobilesoft.coreblock.rest.ApiResponse.Error
            if (r0 == 0) goto Lb8
            r0 = r10
            cz.mobilesoft.coreblock.rest.ApiResponse$Error r0 = (cz.mobilesoft.coreblock.rest.ApiResponse.Error) r0
            cz.mobilesoft.coreblock.rest.response.ErrorBody r0 = r0.d()
            if (r0 == 0) goto L9e
            int r0 = r0.getCode()
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.Boxing.d(r0)
            goto L9f
        L9e:
            r0 = r5
        L9f:
            if (r0 != 0) goto La2
            goto Laa
        La2:
            int r1 = r0.intValue()
            r2 = 307(0x133, float:4.3E-43)
            if (r1 == r2) goto Lb5
        Laa:
            if (r0 != 0) goto Lad
            goto Lb8
        Lad:
            int r0 = r0.intValue()
            r1 = 310(0x136, float:4.34E-43)
            if (r0 != r1) goto Lb8
        Lb5:
            cz.mobilesoft.coreblock.repository.AcademyRepository.q(r5, r4, r5)
        Lb8:
            cz.mobilesoft.coreblock.scene.more.academy.BaseAcademyLessonsViewModel r0 = r9.f106058c
            cz.mobilesoft.coreblock.util.livedata.FreshLiveData r0 = r0.J0()
            cz.mobilesoft.coreblock.util.ViewModelState r10 = r10.b()
            r0.n(r10)
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.academy.BaseAcademyLessonsViewModel$startLesson$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((BaseAcademyLessonsViewModel$startLesson$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
