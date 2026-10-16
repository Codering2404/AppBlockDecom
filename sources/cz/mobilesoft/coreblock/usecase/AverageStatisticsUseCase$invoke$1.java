package cz.mobilesoft.coreblock.usecase;

import cz.mobilesoft.coreblock.usecase.AverageStatisticsUseCase;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.usecase.AverageStatisticsUseCase$invoke$1", f = "AverageStatisticsUseCase.kt", l = {35, 38, 39, 41}, m = "invokeSuspend", v = 1)
final class AverageStatisticsUseCase$invoke$1 extends SuspendLambda implements Function2<FlowCollector<? super AverageStatisticsUseCase.AverageStatistics>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f126931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f126932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f126933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f126934d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f126935f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    long f126936g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    long f126937h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f126938i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private /* synthetic */ Object f126939j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ AverageStatisticsUseCase f126940k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AverageStatisticsUseCase$invoke$1(AverageStatisticsUseCase averageStatisticsUseCase, Continuation continuation) {
        super(2, continuation);
        this.f126940k = averageStatisticsUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        AverageStatisticsUseCase$invoke$1 averageStatisticsUseCase$invoke$1 = new AverageStatisticsUseCase$invoke$1(this.f126940k, continuation);
        averageStatisticsUseCase$invoke$1.f126939j = obj;
        return averageStatisticsUseCase$invoke$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x01f2, code lost:
    
        if (r7.emit(r0, r20) != r8) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01bd  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 504
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.usecase.AverageStatisticsUseCase$invoke$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
        return ((AverageStatisticsUseCase$invoke$1) create(flowCollector, continuation)).invokeSuspend(Unit.f139807a);
    }
}
