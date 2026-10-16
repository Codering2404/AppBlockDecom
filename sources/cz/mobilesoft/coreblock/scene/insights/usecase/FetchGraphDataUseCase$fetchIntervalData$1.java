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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.usecase.FetchGraphDataUseCase", f = "FetchGraphDataUseCase.kt", l = {96}, m = "fetchIntervalData", v = 1)
final class FetchGraphDataUseCase$fetchIntervalData$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f103740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f103741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f103742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f103743d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f103744f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f103745g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f103746h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f103747i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    /* synthetic */ Object f103748j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ FetchGraphDataUseCase f103749k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f103750l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FetchGraphDataUseCase$fetchIntervalData$1(FetchGraphDataUseCase fetchGraphDataUseCase, Continuation continuation) {
        super(continuation);
        this.f103749k = fetchGraphDataUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f103748j = obj;
        this.f103750l |= Integer.MIN_VALUE;
        return this.f103749k.e(null, 0, null, false, this);
    }
}
