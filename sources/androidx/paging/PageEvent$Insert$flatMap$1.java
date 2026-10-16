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
@DebugMetadata(c = "androidx.paging.PageEvent$Insert", f = "PageEvent.kt", l = {140}, m = "flatMap")
final class PageEvent$Insert$flatMap$1<R> extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f49971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f49972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f49973c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f49974d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f49975f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f49976g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f49977h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f49978i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Object f49979j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Object f49980k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Object f49981l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f49982m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f49983n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    /* synthetic */ Object f49984o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final /* synthetic */ PageEvent.Insert f49985p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f49986q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PageEvent$Insert$flatMap$1(PageEvent.Insert insert, Continuation continuation) {
        super(continuation);
        this.f49985p = insert;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f49984o = obj;
        this.f49986q |= Integer.MIN_VALUE;
        return this.f49985p.c(null, this);
    }
}
