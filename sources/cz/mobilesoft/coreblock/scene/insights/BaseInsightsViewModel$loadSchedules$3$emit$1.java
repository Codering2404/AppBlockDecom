package cz.mobilesoft.coreblock.scene.insights;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.BaseInsightsViewModel$loadSchedules$3", f = "BaseInsightsViewModel.kt", l = {95}, m = "emit", v = 1)
final class BaseInsightsViewModel$loadSchedules$3$emit$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f102498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f102499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f102500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f102501d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f102502f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f102503g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f102504h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f102505i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Object f102506j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Object f102507k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Object f102508l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    Object f102509m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f102510n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f102511o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    int f102512p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f102513q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    int f102514r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    int f102515s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    int f102516t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    int f102517u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    int f102518v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    /* synthetic */ Object f102519w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    final /* synthetic */ BaseInsightsViewModel$loadSchedules$3 f102520x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    int f102521y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseInsightsViewModel$loadSchedules$3$emit$1(BaseInsightsViewModel$loadSchedules$3 baseInsightsViewModel$loadSchedules$3, Continuation continuation) {
        super(continuation);
        this.f102520x = baseInsightsViewModel$loadSchedules$3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f102519w = obj;
        this.f102521y |= Integer.MIN_VALUE;
        return this.f102520x.emit(null, this);
    }
}
