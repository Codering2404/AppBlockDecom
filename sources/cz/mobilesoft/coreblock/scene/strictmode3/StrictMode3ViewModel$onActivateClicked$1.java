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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel", f = "StrictMode3ViewModel.kt", l = {675, 680, 688, 698}, m = "onActivateClicked", v = 1)
final class StrictMode3ViewModel$onActivateClicked$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f121300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f121301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f121302c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    /* synthetic */ Object f121303d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ StrictMode3ViewModel f121304f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f121305g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StrictMode3ViewModel$onActivateClicked$1(StrictMode3ViewModel strictMode3ViewModel, Continuation continuation) {
        super(continuation);
        this.f121304f = strictMode3ViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f121303d = obj;
        this.f121305g |= Integer.MIN_VALUE;
        return this.f121304f.r2(this);
    }
}
