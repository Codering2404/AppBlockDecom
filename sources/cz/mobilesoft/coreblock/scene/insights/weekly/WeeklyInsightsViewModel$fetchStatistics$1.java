package cz.mobilesoft.coreblock.scene.insights.weekly;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel", f = "WeeklyInsightsViewModel.kt", l = {223, 245, 257, 276, 288, 300, 308}, m = "fetchStatistics", v = 1)
final class WeeklyInsightsViewModel$fetchStatistics$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f103941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f103942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f103943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f103944d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f103945f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f103946g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f103947h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f103948i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Object f103949j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    /* synthetic */ Object f103950k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ WeeklyInsightsViewModel f103951l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f103952m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WeeklyInsightsViewModel$fetchStatistics$1(WeeklyInsightsViewModel weeklyInsightsViewModel, Continuation continuation) {
        super(continuation);
        this.f103951l = weeklyInsightsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f103950k = obj;
        this.f103952m |= Integer.MIN_VALUE;
        return this.f103951l.H1(this);
    }
}
