package cz.mobilesoft.coreblock.scene.insights.usecase;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.usecase.MigrateStatisticsToInsightsUseCase", f = "MigrateStatisticsToInsightsUseCase.kt", l = {34, 35, 95, 97}, m = "invoke", v = 1)
final class MigrateStatisticsToInsightsUseCase$invoke$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f103796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f103797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f103798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f103799d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f103800f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f103801g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f103802h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f103803i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Object f103804j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Object f103805k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Object f103806l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    Object f103807m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    Object f103808n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    Object f103809o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    int f103810p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f103811q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    int f103812r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    int f103813s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    /* synthetic */ Object f103814t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final /* synthetic */ MigrateStatisticsToInsightsUseCase f103815u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    int f103816v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MigrateStatisticsToInsightsUseCase$invoke$1(MigrateStatisticsToInsightsUseCase migrateStatisticsToInsightsUseCase, Continuation continuation) {
        super(continuation);
        this.f103815u = migrateStatisticsToInsightsUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f103814t = obj;
        this.f103816v |= Integer.MIN_VALUE;
        return this.f103815u.c(null, this);
    }
}
