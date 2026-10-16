package androidx.compose.ui.graphics.layer;

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
@DebugMetadata(c = "androidx.compose.ui.graphics.layer.LayerSnapshotV22", f = "LayerSnapshot.android.kt", l = {225}, m = "toBitmap")
final class LayerSnapshotV22$toBitmap$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f26238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f26239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f26240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f26241d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f26242f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    /* synthetic */ Object f26243g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ LayerSnapshotV22 f26244h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f26245i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LayerSnapshotV22$toBitmap$1(LayerSnapshotV22 layerSnapshotV22, Continuation continuation) {
        super(continuation);
        this.f26244h = layerSnapshotV22;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f26243g = obj;
        this.f26245i |= Integer.MIN_VALUE;
        return this.f26244h.a(null, this);
    }
}
