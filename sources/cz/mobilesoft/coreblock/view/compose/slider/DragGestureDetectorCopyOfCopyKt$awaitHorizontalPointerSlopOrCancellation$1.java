package cz.mobilesoft.coreblock.view.compose.slider;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.view.compose.slider.DragGestureDetectorCopyOfCopyKt", f = "DragGestureDetectorCopyOfCopy.kt", l = {123, 164}, m = "awaitHorizontalPointerSlopOrCancellation-gDDlDlE", v = 1)
final class DragGestureDetectorCopyOfCopyKt$awaitHorizontalPointerSlopOrCancellation$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f132007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f132008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f132009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f132010d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f132011f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f132012g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    long f132013h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    long f132014i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    long f132015j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    long f132016k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f132017l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f132018m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f132019n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    float f132020o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    float f132021p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    float f132022q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    float f132023r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    /* synthetic */ Object f132024s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    int f132025t;

    DragGestureDetectorCopyOfCopyKt$awaitHorizontalPointerSlopOrCancellation$1(Continuation continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f132024s = obj;
        this.f132025t |= Integer.MIN_VALUE;
        return DragGestureDetectorCopyOfCopyKt.a(null, 0L, 0, null, this);
    }
}
