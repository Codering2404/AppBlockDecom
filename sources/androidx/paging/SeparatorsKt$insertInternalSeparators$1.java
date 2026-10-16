package androidx.paging;

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
@DebugMetadata(c = "androidx.paging.SeparatorsKt", f = "Separators.kt", l = {82}, m = "insertInternalSeparators")
final class SeparatorsKt$insertInternalSeparators$1<R, T extends R> extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f50626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f50627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f50628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f50629d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f50630f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f50631g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f50632h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    /* synthetic */ Object f50633i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f50634j;

    SeparatorsKt$insertInternalSeparators$1(Continuation continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50633i = obj;
        this.f50634j |= Integer.MIN_VALUE;
        return SeparatorsKt.c(null, null, this);
    }
}
