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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.InsightsViewModel", f = "InsightsViewModel.kt", l = {726, 755, 766, 772, 785, 802, 814, 829, 839, 848, 864, 872, 884, 902}, m = "updateInsightsData", v = 1)
final class InsightsViewModel$updateInsightsData$1 extends ContinuationImpl {
    Object A;
    Object B;
    int C;
    int D;
    /* synthetic */ Object E;
    final /* synthetic */ InsightsViewModel F;
    int G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f102886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f102887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f102888c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f102889d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f102890f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f102891g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f102892h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f102893i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Object f102894j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Object f102895k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Object f102896l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    Object f102897m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    Object f102898n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    Object f102899o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    Object f102900p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    Object f102901q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    Object f102902r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    Object f102903s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    Object f102904t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    Object f102905u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    Object f102906v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    Object f102907w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    Object f102908x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    Object f102909y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    Object f102910z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InsightsViewModel$updateInsightsData$1(InsightsViewModel insightsViewModel, Continuation continuation) {
        super(continuation);
        this.F = insightsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.E = obj;
        this.G |= Integer.MIN_VALUE;
        return this.F.G2(null, 0, null, 0, null, null, null, this);
    }
}
