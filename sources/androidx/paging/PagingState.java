package androidx.paging;

import androidx.paging.PagingSource;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

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
public final class PagingState<Key, Value> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f50502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f50503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PagingConfig f50504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f50505d;

    public PagingState(List pages, Integer num, PagingConfig config, int i3) {
        Intrinsics.checkNotNullParameter(pages, "pages");
        Intrinsics.checkNotNullParameter(config, "config");
        this.f50502a = pages;
        this.f50503b = num;
        this.f50504c = config;
        this.f50505d = i3;
    }

    public final Object b(int i3) {
        List list = this.f50502a;
        if ((list instanceof Collection) && list.isEmpty()) {
            return null;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!((PagingSource.LoadResult.Page) it.next()).b().isEmpty()) {
                int size = i3 - this.f50505d;
                int i4 = 0;
                while (i4 < CollectionsKt.getLastIndex(f()) && size > CollectionsKt.getLastIndex(((PagingSource.LoadResult.Page) f().get(i4)).b())) {
                    size -= ((PagingSource.LoadResult.Page) f().get(i4)).b().size();
                    i4++;
                }
                for (PagingSource.LoadResult.Page page : this.f50502a) {
                    if (!page.b().isEmpty()) {
                        List list2 = this.f50502a;
                        ListIterator listIterator = list2.listIterator(list2.size());
                        while (listIterator.hasPrevious()) {
                            PagingSource.LoadResult.Page page2 = (PagingSource.LoadResult.Page) listIterator.previous();
                            if (!page2.b().isEmpty()) {
                                return size < 0 ? CollectionsKt.first(page.b()) : (i4 != CollectionsKt.getLastIndex(this.f50502a) || size <= CollectionsKt.getLastIndex(((PagingSource.LoadResult.Page) CollectionsKt.last(this.f50502a)).b())) ? ((PagingSource.LoadResult.Page) this.f50502a.get(i4)).b().get(size) : CollectionsKt.last(page2.b());
                            }
                        }
                        throw new NoSuchElementException("List contains no element matching the predicate.");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }
        return null;
    }

    public final PagingSource.LoadResult.Page c(int i3) {
        List list = this.f50502a;
        if ((list instanceof Collection) && list.isEmpty()) {
            return null;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!((PagingSource.LoadResult.Page) it.next()).b().isEmpty()) {
                int size = i3 - this.f50505d;
                int i4 = 0;
                while (i4 < CollectionsKt.getLastIndex(f()) && size > CollectionsKt.getLastIndex(((PagingSource.LoadResult.Page) f().get(i4)).b())) {
                    size -= ((PagingSource.LoadResult.Page) f().get(i4)).b().size();
                    i4++;
                }
                return size < 0 ? (PagingSource.LoadResult.Page) CollectionsKt.first(this.f50502a) : (PagingSource.LoadResult.Page) this.f50502a.get(i4);
            }
        }
        return null;
    }

    public final Integer d() {
        return this.f50503b;
    }

    public final PagingConfig e() {
        return this.f50504c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PagingState)) {
            return false;
        }
        PagingState pagingState = (PagingState) obj;
        return Intrinsics.areEqual(this.f50502a, pagingState.f50502a) && Intrinsics.areEqual(this.f50503b, pagingState.f50503b) && Intrinsics.areEqual(this.f50504c, pagingState.f50504c) && this.f50505d == pagingState.f50505d;
    }

    public final List f() {
        return this.f50502a;
    }

    public int hashCode() {
        int iHashCode = this.f50502a.hashCode();
        Integer num = this.f50503b;
        return iHashCode + (num != null ? num.hashCode() : 0) + this.f50504c.hashCode() + Integer.hashCode(this.f50505d);
    }

    public String toString() {
        return "PagingState(pages=" + this.f50502a + ", anchorPosition=" + this.f50503b + ", config=" + this.f50504c + ", leadingPlaceholderCount=" + this.f50505d + ')';
    }
}
