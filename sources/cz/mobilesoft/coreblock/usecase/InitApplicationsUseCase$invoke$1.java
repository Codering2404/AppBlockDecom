package cz.mobilesoft.coreblock.usecase;

import cz.mobilesoft.coreblock.dto.ApplicationDTO;
import cz.mobilesoft.coreblock.usecase.InitApplicationsUseCase;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.usecase.InitApplicationsUseCase$invoke$1", f = "InitApplicationsUseCase.kt", l = {28, 31, 32, 93}, m = "invokeSuspend", v = 1)
final class InitApplicationsUseCase$invoke$1 extends SuspendLambda implements Function2<FlowCollector<? super List<? extends ApplicationDTO>>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f127182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f127183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f127184c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f127185d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f127186f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f127187g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private /* synthetic */ Object f127188h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ InitApplicationsUseCase.Params f127189i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ InitApplicationsUseCase f127190j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitApplicationsUseCase$invoke$1(InitApplicationsUseCase.Params params, InitApplicationsUseCase initApplicationsUseCase, Continuation continuation) {
        super(2, continuation);
        this.f127189i = params;
        this.f127190j = initApplicationsUseCase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable y(InitApplicationsUseCase.Params params, ApplicationDTO applicationDTO) {
        return Boolean.valueOf(!applicationDTO.h() || (StringHelperExtKt.o(applicationDTO.f()) && params.f()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable z(ApplicationDTO applicationDTO) {
        return applicationDTO.e();
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        InitApplicationsUseCase$invoke$1 initApplicationsUseCase$invoke$1 = new InitApplicationsUseCase$invoke$1(this.f127189i, this.f127190j, continuation);
        initApplicationsUseCase$invoke$1.f127188h = obj;
        return initApplicationsUseCase$invoke$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x02a5, code lost:
    
        if (r7.emit(r5, r29) != r8) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01e8, code lost:
    
        r22 = r16;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x013f A[PHI: r0 r1 r2 r3
      0x013f: PHI (r0v19 java.util.Set) = (r0v18 java.util.Set), (r0v33 java.util.Set) binds: [B:41:0x013b, B:11:0x003c] A[DONT_GENERATE, DONT_INLINE]
      0x013f: PHI (r1v10 java.util.List) = (r1v9 java.util.List), (r1v16 java.util.List) binds: [B:41:0x013b, B:11:0x003c] A[DONT_GENERATE, DONT_INLINE]
      0x013f: PHI (r2v6 java.util.Map) = (r2v5 java.util.Map), (r2v10 java.util.Map) binds: [B:41:0x013b, B:11:0x003c] A[DONT_GENERATE, DONT_INLINE]
      0x013f: PHI (r3v11 java.lang.Object) = (r3v10 java.lang.Object), (r3v13 java.lang.Object) binds: [B:41:0x013b, B:11:0x003c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0241  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r30) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 683
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.usecase.InitApplicationsUseCase$invoke$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
        return ((InitApplicationsUseCase$invoke$1) create(flowCollector, continuation)).invokeSuspend(Unit.f139807a);
    }
}
