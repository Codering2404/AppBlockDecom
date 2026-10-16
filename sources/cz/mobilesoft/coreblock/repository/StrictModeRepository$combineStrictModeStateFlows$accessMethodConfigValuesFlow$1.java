package cz.mobilesoft.coreblock.repository;

import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function5;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.StrictModeRepository$combineStrictModeStateFlows$accessMethodConfigValuesFlow$1", f = "StrictModeRepository.kt", l = {}, m = "invokeSuspend", v = 1)
final class StrictModeRepository$combineStrictModeStateFlows$accessMethodConfigValuesFlow$1 extends SuspendLambda implements Function5<Long, Set<Long>, Long, String, Continuation<? super StrictModeRepository.AccessMethodConfigValues>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f98259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ long f98260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ Object f98261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    /* synthetic */ long f98262d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    /* synthetic */ Object f98263f;

    StrictModeRepository$combineStrictModeStateFlows$accessMethodConfigValuesFlow$1(Continuation continuation) {
        super(5, continuation);
    }

    public final Object h(long j3, Set set, long j4, String str, Continuation continuation) {
        StrictModeRepository$combineStrictModeStateFlows$accessMethodConfigValuesFlow$1 strictModeRepository$combineStrictModeStateFlows$accessMethodConfigValuesFlow$1 = new StrictModeRepository$combineStrictModeStateFlows$accessMethodConfigValuesFlow$1(continuation);
        strictModeRepository$combineStrictModeStateFlows$accessMethodConfigValuesFlow$1.f98260b = j3;
        strictModeRepository$combineStrictModeStateFlows$accessMethodConfigValuesFlow$1.f98261c = set;
        strictModeRepository$combineStrictModeStateFlows$accessMethodConfigValuesFlow$1.f98262d = j4;
        strictModeRepository$combineStrictModeStateFlows$accessMethodConfigValuesFlow$1.f98263f = str;
        return strictModeRepository$combineStrictModeStateFlows$accessMethodConfigValuesFlow$1.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.jvm.functions.Function5
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return h(((Number) obj).longValue(), (Set) obj2, ((Number) obj3).longValue(), (String) obj4, (Continuation) obj5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        long j3 = this.f98260b;
        Set set = (Set) this.f98261c;
        long j4 = this.f98262d;
        String str = (String) this.f98263f;
        IntrinsicsKt.f();
        if (this.f98259a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        return new StrictModeRepository.AccessMethodConfigValues(j3, CollectionsKt.toLongArray(set), j4, str);
    }
}
