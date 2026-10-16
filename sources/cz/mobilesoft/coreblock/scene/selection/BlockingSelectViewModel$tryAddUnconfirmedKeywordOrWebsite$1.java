package cz.mobilesoft.coreblock.scene.selection;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.selection.BlockingSelectViewModel", f = "BlockingSelectViewModel.kt", l = {116, 125}, m = "tryAddUnconfirmedKeywordOrWebsite", v = 1)
final class BlockingSelectViewModel$tryAddUnconfirmedKeywordOrWebsite$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f118068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f118069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f118070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    /* synthetic */ Object f118071d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ BlockingSelectViewModel f118072f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f118073g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BlockingSelectViewModel$tryAddUnconfirmedKeywordOrWebsite$1(BlockingSelectViewModel blockingSelectViewModel, Continuation continuation) {
        super(continuation);
        this.f118072f = blockingSelectViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f118071d = obj;
        this.f118073g |= Integer.MIN_VALUE;
        return this.f118072f.Z2(this);
    }
}
