package androidx.paging;

import androidx.paging.PagedList;
import kotlin.Metadata;

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
public final class AsyncPagedListDiffer$pagedListCallback$1 extends PagedList.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AsyncPagedListDiffer f49540a;

    @Override // androidx.paging.PagedList.Callback
    public void a(int i3, int i4) {
        this.f49540a.d().c(i3, i4, null);
    }

    @Override // androidx.paging.PagedList.Callback
    public void b(int i3, int i4) {
        this.f49540a.d().a(i3, i4);
    }

    @Override // androidx.paging.PagedList.Callback
    public void c(int i3, int i4) {
        this.f49540a.d().b(i3, i4);
    }
}
