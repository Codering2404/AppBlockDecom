package androidx.compose.material;

import androidx.compose.material.AnchoredDraggableKt$restartable$2;
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
@DebugMetadata(c = "androidx.compose.material.AnchoredDraggableKt$restartable$2$1", f = "AnchoredDraggable.kt", l = {743}, m = "emit")
final class AnchoredDraggableKt$restartable$2$1$emit$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f11678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f11679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f11680c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    /* synthetic */ Object f11681d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ AnchoredDraggableKt$restartable$2.AnonymousClass1 f11682f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f11683g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AnchoredDraggableKt$restartable$2$1$emit$1(AnchoredDraggableKt$restartable$2.AnonymousClass1 anonymousClass1, Continuation continuation) {
        super(continuation);
        this.f11682f = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f11681d = obj;
        this.f11683g |= Integer.MIN_VALUE;
        return this.f11682f.emit(null, this);
    }
}
