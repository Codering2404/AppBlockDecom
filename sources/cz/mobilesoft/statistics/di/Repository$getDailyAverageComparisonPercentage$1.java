package cz.mobilesoft.statistics.di;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.statistics.di.Repository", f = "Repository.kt", l = {286, 287}, m = "getDailyAverageComparisonPercentage", v = 1)
final class Repository$getDailyAverageComparisonPercentage$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f133605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f133606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f133607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f133608d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f133609f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    long f133610g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    long f133611h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    long f133612i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    /* synthetic */ Object f133613j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ Repository f133614k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f133615l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Repository$getDailyAverageComparisonPercentage$1(Repository repository, Continuation continuation) {
        super(continuation);
        this.f133614k = repository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f133613j = obj;
        this.f133615l |= Integer.MIN_VALUE;
        return this.f133614k.t(null, null, 0L, 0L, 0L, 0L, this);
    }
}
