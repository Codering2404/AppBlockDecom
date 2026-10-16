package cz.mobilesoft.coreblock.repository;

import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.StrictModeRepository$combineStrictModeStateFlows$extraConfigFlow$1", f = "StrictModeRepository.kt", l = {}, m = "invokeSuspend", v = 1)
final class StrictModeRepository$combineStrictModeStateFlows$extraConfigFlow$1 extends SuspendLambda implements Function4<Long, Long, Boolean, Continuation<? super StrictModeRepository.ExtraConfig>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f98264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ long f98265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ long f98266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    /* synthetic */ boolean f98267d;

    StrictModeRepository$combineStrictModeStateFlows$extraConfigFlow$1(Continuation continuation) {
        super(4, continuation);
    }

    public final Object h(long j3, long j4, boolean z2, Continuation continuation) {
        StrictModeRepository$combineStrictModeStateFlows$extraConfigFlow$1 strictModeRepository$combineStrictModeStateFlows$extraConfigFlow$1 = new StrictModeRepository$combineStrictModeStateFlows$extraConfigFlow$1(continuation);
        strictModeRepository$combineStrictModeStateFlows$extraConfigFlow$1.f98265b = j3;
        strictModeRepository$combineStrictModeStateFlows$extraConfigFlow$1.f98266c = j4;
        strictModeRepository$combineStrictModeStateFlows$extraConfigFlow$1.f98267d = z2;
        return strictModeRepository$combineStrictModeStateFlows$extraConfigFlow$1.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return h(((Number) obj).longValue(), ((Number) obj2).longValue(), ((Boolean) obj3).booleanValue(), (Continuation) obj4);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        long j3 = this.f98265b;
        long j4 = this.f98266c;
        boolean z2 = this.f98267d;
        IntrinsicsKt.f();
        if (this.f98264a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        return new StrictModeRepository.ExtraConfig(j3, j4, z2);
    }
}
