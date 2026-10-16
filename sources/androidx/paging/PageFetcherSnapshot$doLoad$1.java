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
@DebugMetadata(c = "androidx.paging.PageFetcherSnapshot", f = "PageFetcherSnapshot.kt", l = {647, 658, 415, 424, 679, 720, 472, 741, 495, 521, 752}, m = "doLoad")
final class PageFetcherSnapshot$doLoad$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f50145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f50146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f50147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f50148d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f50149f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f50150g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f50151h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f50152i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Object f50153j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Object f50154k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Object f50155l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f50156m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f50157n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    /* synthetic */ Object f50158o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final /* synthetic */ PageFetcherSnapshot f50159p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f50160q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PageFetcherSnapshot$doLoad$1(PageFetcherSnapshot pageFetcherSnapshot, Continuation continuation) {
        super(continuation);
        this.f50159p = pageFetcherSnapshot;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50158o = obj;
        this.f50160q |= Integer.MIN_VALUE;
        return this.f50159p.t(null, null, this);
    }
}
