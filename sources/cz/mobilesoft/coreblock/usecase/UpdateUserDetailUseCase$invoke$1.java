package cz.mobilesoft.coreblock.usecase;

import cz.mobilesoft.coreblock.usecase.UpdateUserDetailUseCase;
import cz.mobilesoft.coreblock.util.DataState;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.usecase.UpdateUserDetailUseCase$invoke$1", f = "UpdateUserDetailUseCase.kt", l = {16, 19, 20, 26, 27, 30}, m = "invokeSuspend", v = 1)
final class UpdateUserDetailUseCase$invoke$1 extends SuspendLambda implements Function2<FlowCollector<? super DataState<? extends Unit>>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f127483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f127484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private /* synthetic */ Object f127485c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ UpdateUserDetailUseCase.Params f127486d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UpdateUserDetailUseCase$invoke$1(UpdateUserDetailUseCase.Params params, Continuation continuation) {
        super(2, continuation);
        this.f127486d = params;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        UpdateUserDetailUseCase$invoke$1 updateUserDetailUseCase$invoke$1 = new UpdateUserDetailUseCase$invoke$1(this.f127486d, continuation);
        updateUserDetailUseCase$invoke$1.f127485c = obj;
        return updateUserDetailUseCase$invoke$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00bf, code lost:
    
        if (r0.emit(r10, r9) != r1) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00e9, code lost:
    
        if (r0.emit(r3, r9) == r1) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084 A[PHI: r10
      0x0084: PHI (r10v10 java.lang.Object) = (r10v9 java.lang.Object), (r10v0 java.lang.Object) binds: [B:20:0x0081, B:8:0x0027] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c2  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.usecase.UpdateUserDetailUseCase$invoke$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
        return ((UpdateUserDetailUseCase$invoke$1) create(flowCollector, continuation)).invokeSuspend(Unit.f139807a);
    }
}
