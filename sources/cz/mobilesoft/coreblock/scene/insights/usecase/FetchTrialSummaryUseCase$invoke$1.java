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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.usecase.FetchTrialSummaryUseCase", f = "FetchTrialSummaryUseCase.kt", l = {29, 46, 55, 57, 63}, m = "invoke", v = 1)
final class FetchTrialSummaryUseCase$invoke$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f103766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f103767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f103768c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f103769d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f103770f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f103771g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f103772h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f103773i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    long f103774j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    long f103775k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    long f103776l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    /* synthetic */ Object f103777m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final /* synthetic */ FetchTrialSummaryUseCase f103778n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f103779o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FetchTrialSummaryUseCase$invoke$1(FetchTrialSummaryUseCase fetchTrialSummaryUseCase, Continuation continuation) {
        super(continuation);
        this.f103778n = fetchTrialSummaryUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f103777m = obj;
        this.f103779o |= Integer.MIN_VALUE;
        return this.f103778n.c(null, this);
    }
}
