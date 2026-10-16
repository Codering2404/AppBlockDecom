package androidx.glance.state;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.glance.state.GlanceState", f = "GlanceStateDefinition.kt", l = {122, 122}, m = "updateValue")
final class GlanceState$updateValue$1<T> extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f39721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f39722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ GlanceState f39723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f39724d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GlanceState$updateValue$1(GlanceState glanceState, Continuation continuation) {
        super(continuation);
        this.f39723c = glanceState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f39722b = obj;
        this.f39724d |= Integer.MIN_VALUE;
        return this.f39723c.e(null, null, null, null, this);
    }
}
