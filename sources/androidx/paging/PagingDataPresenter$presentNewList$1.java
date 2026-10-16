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
@DebugMetadata(c = "androidx.paging.PagingDataPresenter", f = "PagingDataPresenter.kt", l = {478}, m = "presentNewList")
final class PagingDataPresenter$presentNewList$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f50374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f50375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f50376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f50377d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f50378f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f50379g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f50380h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f50381i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    boolean f50382j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    /* synthetic */ Object f50383k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ PagingDataPresenter f50384l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f50385m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PagingDataPresenter$presentNewList$1(PagingDataPresenter pagingDataPresenter, Continuation continuation) {
        super(continuation);
        this.f50384l = pagingDataPresenter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50383k = obj;
        this.f50385m |= Integer.MIN_VALUE;
        return this.f50384l.r(null, 0, 0, false, null, null, null, this);
    }
}
