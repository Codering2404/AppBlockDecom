package cz.mobilesoft.coreblock.usecase;

import cz.mobilesoft.coreblock.usecase.BackdoorCodeUseCase;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.usecase.BackdoorCodeUseCase$invoke$1", f = "BackdoorCodeUseCase.kt", l = {16, 18, 21, 32}, m = "invokeSuspend", v = 1)
final class BackdoorCodeUseCase$invoke$1 extends SuspendLambda implements Function2<FlowCollector<? super DataState<? extends Boolean>>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f126945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f126946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private /* synthetic */ Object f126947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ BackdoorCodeUseCase.Params f126948d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BackdoorCodeUseCase$invoke$1(BackdoorCodeUseCase.Params params, Continuation continuation) {
        super(2, continuation);
        this.f126948d = params;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        BackdoorCodeUseCase$invoke$1 backdoorCodeUseCase$invoke$1 = new BackdoorCodeUseCase$invoke$1(this.f126948d, continuation);
        backdoorCodeUseCase$invoke$1.f126947c = obj;
        return backdoorCodeUseCase$invoke$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x007e, code lost:
    
        if (r0.emit(r2, r10) == r1) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00dd, code lost:
    
        if (r0.emit(r2, r10) == r1) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0081  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.usecase.BackdoorCodeUseCase$invoke$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
        return ((BackdoorCodeUseCase$invoke$1) create(flowCollector, continuation)).invokeSuspend(Unit.f139807a);
    }
}
