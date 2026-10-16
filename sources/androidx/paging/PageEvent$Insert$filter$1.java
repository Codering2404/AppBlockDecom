package androidx.paging;

import androidx.paging.PageEvent;
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
@DebugMetadata(c = "androidx.paging.PageEvent$Insert", f = "PageEvent.kt", l = {158}, m = "filter")
final class PageEvent$Insert$filter$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f49955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f49956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f49957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f49958d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f49959f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f49960g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f49961h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f49962i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Object f49963j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Object f49964k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Object f49965l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f49966m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f49967n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    /* synthetic */ Object f49968o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final /* synthetic */ PageEvent.Insert f49969p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f49970q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PageEvent$Insert$filter$1(PageEvent.Insert insert, Continuation continuation) {
        super(continuation);
        this.f49969p = insert;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f49968o = obj;
        this.f49970q |= Integer.MIN_VALUE;
        return this.f49969p.a(null, this);
    }
}
