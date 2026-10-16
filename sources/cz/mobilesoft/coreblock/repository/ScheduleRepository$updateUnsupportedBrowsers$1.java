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
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.ScheduleRepository", f = "ScheduleRepository.kt", l = {629, 630, 633, 658, 659, 661}, m = "updateUnsupportedBrowsers", v = 1)
final class ScheduleRepository$updateUnsupportedBrowsers$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f98177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f98178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f98179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f98180d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f98181f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f98182g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f98183h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    /* synthetic */ Object f98184i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ ScheduleRepository f98185j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f98186k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleRepository$updateUnsupportedBrowsers$1(ScheduleRepository scheduleRepository, Continuation continuation) {
        super(continuation);
        this.f98185j = scheduleRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f98184i = obj;
        this.f98186k |= Integer.MIN_VALUE;
        return this.f98185j.Z(0L, false, this);
    }
}
