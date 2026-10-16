package androidx.compose.foundation.gestures;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.foundation.gestures.UpdatableAnimationState", f = "UpdatableAnimationState.kt", l = {102, 153}, m = "animateToZero")
final class UpdatableAnimationState$animateToZero$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f6414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f6415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f6416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    float f6417d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    /* synthetic */ Object f6418f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ UpdatableAnimationState f6419g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f6420h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UpdatableAnimationState$animateToZero$1(UpdatableAnimationState updatableAnimationState, Continuation continuation) {
        super(continuation);
        this.f6419g = updatableAnimationState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f6418f = obj;
        this.f6420h |= Integer.MIN_VALUE;
        return this.f6419g.h(null, null, this);
    }
}
