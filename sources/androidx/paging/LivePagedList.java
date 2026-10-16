package androidx.paging;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

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
public final class LivePagedList<Key, Value> extends LiveData<PagedList<Value>> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final CoroutineScope f49873l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final PagedList.Config f49874m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final PagedList.BoundaryCallback f49875n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Function0 f49876o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final CoroutineDispatcher f49877p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final CoroutineDispatcher f49878q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private PagedList f49879r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Job f49880s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Function0 f49881t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Runnable f49882u;

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(boolean z2) {
        Job job = this.f49880s;
        if (job == null || z2) {
            if (job != null) {
                Job.DefaultImpls.b(job, null, 1, null);
            }
            this.f49880s = BuildersKt__Builders_commonKt.d(this.f49873l, this.f49878q, null, new LivePagedList$invalidate$1(this, null), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(PagedList pagedList, PagedList pagedList2) {
        pagedList.D(null);
        pagedList2.D(this.f49882u);
    }

    @Override // androidx.lifecycle.LiveData
    protected void l() {
        super.l();
        C(false);
    }
}
