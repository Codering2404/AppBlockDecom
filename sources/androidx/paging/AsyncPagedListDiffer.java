package androidx.paging;

import androidx.recyclerview.widget.ListUpdateCallback;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
@Metadata
public class AsyncPagedListDiffer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ListUpdateCallback f49534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PagedList f49535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PagedList f49536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f49537d;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class OnCurrentListChangedWrapper<T> implements PagedListListener<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Function2 f49538a;

        public final Function2 a() {
            return this.f49538a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Deprecated
    public interface PagedListListener<T> {
    }

    public PagedList a() {
        PagedList pagedList = this.f49536c;
        return pagedList == null ? this.f49535b : pagedList;
    }

    public int b() {
        PagedList pagedListA = a();
        if (pagedListA != null) {
            return pagedListA.size();
        }
        return 0;
    }

    public final List c() {
        return this.f49537d;
    }

    public final ListUpdateCallback d() {
        ListUpdateCallback listUpdateCallback = this.f49534a;
        if (listUpdateCallback != null) {
            return listUpdateCallback;
        }
        Intrinsics.throwUninitializedPropertyAccessException("updateCallback");
        return null;
    }
}
