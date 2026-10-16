package cz.mobilesoft.coreblock.scene.strictmode3;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel", f = "StrictMode3ViewModel.kt", l = {779, 785}, m = "confirmAccessMethod", v = 1)
final class StrictMode3ViewModel$confirmAccessMethod$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f121238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f121239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f121240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f121241d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    /* synthetic */ Object f121242f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ StrictMode3ViewModel f121243g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f121244h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StrictMode3ViewModel$confirmAccessMethod$1(StrictMode3ViewModel strictMode3ViewModel, Continuation continuation) {
        super(continuation);
        this.f121243g = strictMode3ViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f121242f = obj;
        this.f121244h |= Integer.MIN_VALUE;
        return this.f121243g.S1(null, null, null, null, this);
    }
}
