package cz.mobilesoft.coreblock.service.worker;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.service.worker.AppInitWorker", f = "AppInitWorker.kt", l = {296, 303}, m = "initQuickBlockProfile", v = 1)
final class AppInitWorker$initQuickBlockProfile$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f123820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f123821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f123822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f123823d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    /* synthetic */ Object f123824f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ AppInitWorker f123825g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f123826h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppInitWorker$initQuickBlockProfile$1(AppInitWorker appInitWorker, Continuation continuation) {
        super(continuation);
        this.f123825g = appInitWorker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f123824f = obj;
        this.f123826h |= Integer.MIN_VALUE;
        return this.f123825g.R(null, null, this);
    }
}
