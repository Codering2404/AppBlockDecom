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
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt", f = "Transformable.kt", l = {337, 339, 385}, m = "detectZoom")
final class TransformableKt$detectZoom$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f6315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f6316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f6317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f6318d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f6319f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    float f6320g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    float f6321h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    float f6322i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    long f6323j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f6324k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f6325l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f6326m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    /* synthetic */ Object f6327n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f6328o;

    TransformableKt$detectZoom$1(Continuation continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f6327n = obj;
        this.f6328o |= Integer.MIN_VALUE;
        return TransformableKt.g(null, false, null, null, this);
    }
}
