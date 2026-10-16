package cz.mobilesoft.coreblock.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.ScheduleRepository", f = "ScheduleRepository.kt", l = {474, 482, 483, 505, 506, 510}, m = "updateIntervals", v = 1)
final class ScheduleRepository$updateIntervals$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f98163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f98164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f98165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f98166d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f98167f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f98168g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    /* synthetic */ Object f98169h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ ScheduleRepository f98170i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f98171j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleRepository$updateIntervals$1(ScheduleRepository scheduleRepository, Continuation continuation) {
        super(continuation);
        this.f98170i = scheduleRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f98169h = obj;
        this.f98171j |= Integer.MIN_VALUE;
        return this.f98170i.W(0L, null, this);
    }
}
