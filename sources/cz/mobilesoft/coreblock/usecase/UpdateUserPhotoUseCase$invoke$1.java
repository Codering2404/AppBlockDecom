package cz.mobilesoft.coreblock.usecase;

import cz.mobilesoft.coreblock.usecase.UpdateUserPhotoUseCase;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.usecase.UpdateUserPhotoUseCase$invoke$1", f = "UpdateUserPhotoUseCase.kt", l = {27, 30, 39, 49, 52}, m = "invokeSuspend", v = 1)
final class UpdateUserPhotoUseCase$invoke$1 extends SuspendLambda implements Function2<FlowCollector<? super DataState<? extends Unit>>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f127500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f127501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f127502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f127503d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f127504f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f127505g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private /* synthetic */ Object f127506h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ UpdateUserPhotoUseCase.Params f127507i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ UpdateUserPhotoUseCase f127508j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UpdateUserPhotoUseCase$invoke$1(UpdateUserPhotoUseCase.Params params, UpdateUserPhotoUseCase updateUserPhotoUseCase, Continuation continuation) {
        super(2, continuation);
        this.f127507i = params;
        this.f127508j = updateUserPhotoUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        UpdateUserPhotoUseCase$invoke$1 updateUserPhotoUseCase$invoke$1 = new UpdateUserPhotoUseCase$invoke$1(this.f127507i, this.f127508j, continuation);
        updateUserPhotoUseCase$invoke$1.f127506h = obj;
        return updateUserPhotoUseCase$invoke$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0091, code lost:
    
        if (r7 == r2) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0132, code lost:
    
        if (r1.emit(r4, r16) == r2) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0173, code lost:
    
        if (r1.emit(r10, r16) == r2) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0135  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 383
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.usecase.UpdateUserPhotoUseCase$invoke$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
        return ((UpdateUserPhotoUseCase$invoke$1) create(flowCollector, continuation)).invokeSuspend(Unit.f139807a);
    }
}
