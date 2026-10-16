package androidx.paging;

import androidx.paging.LegacyPageFetcher;
import androidx.paging.PagedList;
import androidx.paging.PagingSource;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
@Metadata
public final class PagedStorage<T> extends AbstractList<T> implements LegacyPageFetcher.KeyProvider<Object>, PlaceholderPaddedList<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f50296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f50297c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f50298d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f50300g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f50301h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f50295a = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f50299f = true;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Callback {
        void a(int i3, int i4);

        void b(int i3, int i4);

        void d(int i3, int i4, int i5);

        void e(int i3, int i4, int i5);

        void g(int i3);
    }

    private final void s(int i3, PagingSource.LoadResult.Page page, int i4, int i5, boolean z2) {
        this.f50296b = i3;
        this.f50295a.clear();
        this.f50295a.add(page);
        this.f50297c = i4;
        this.f50298d = i5;
        this.f50300g = page.b().size();
        this.f50299f = z2;
        this.f50301h = page.b().size() / 2;
    }

    private final boolean t(int i3, int i4, int i5) {
        return a() > i3 && this.f50295a.size() > 2 && a() - ((PagingSource.LoadResult.Page) this.f50295a.get(i5)).b().size() >= i4;
    }

    public final boolean A(boolean z2, int i3, int i4, Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        int i5 = 0;
        while (v(i3, i4)) {
            int size = ((PagingSource.LoadResult.Page) this.f50295a.remove(0)).b().size();
            i5 += size;
            this.f50300g = a() - size;
        }
        this.f50301h = RangesKt.f(this.f50301h - i5, 0);
        if (i5 > 0) {
            if (z2) {
                int iD = d();
                this.f50296b = d() + i5;
                callback.a(iD, i5);
            } else {
                this.f50298d += i5;
                callback.b(d(), i5);
            }
        }
        return i5 > 0;
    }

    @Override // androidx.paging.PlaceholderPaddedList
    public int a() {
        return this.f50300g;
    }

    @Override // androidx.paging.LegacyPageFetcher.KeyProvider
    public Object b() {
        if (!this.f50299f || f() > 0) {
            return ((PagingSource.LoadResult.Page) CollectionsKt.last(this.f50295a)).f();
        }
        return null;
    }

    @Override // androidx.paging.PlaceholderPaddedList
    public int d() {
        return this.f50296b;
    }

    @Override // androidx.paging.LegacyPageFetcher.KeyProvider
    public Object e() {
        if (!this.f50299f || d() + this.f50298d > 0) {
            return ((PagingSource.LoadResult.Page) CollectionsKt.first(this.f50295a)).g();
        }
        return null;
    }

    @Override // androidx.paging.PlaceholderPaddedList
    public int f() {
        return this.f50297c;
    }

    public final void g(PagingSource.LoadResult.Page page, Callback callback) {
        Intrinsics.checkNotNullParameter(page, "page");
        int size = page.b().size();
        if (size == 0) {
            return;
        }
        this.f50295a.add(page);
        this.f50300g = a() + size;
        int iMin = Math.min(f(), size);
        int i3 = size - iMin;
        if (iMin != 0) {
            this.f50297c = f() - iMin;
        }
        if (callback != null) {
            callback.d((d() + a()) - size, iMin, i3);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i3) {
        int iD = i3 - d();
        if (i3 >= 0 && i3 < size()) {
            if (iD < 0 || iD >= a()) {
                return null;
            }
            return getItem(iD);
        }
        throw new IndexOutOfBoundsException("Index: " + i3 + ", Size: " + size());
    }

    @Override // androidx.paging.PlaceholderPaddedList
    public Object getItem(int i3) {
        int size = this.f50295a.size();
        int i4 = 0;
        while (i4 < size) {
            int size2 = ((PagingSource.LoadResult.Page) this.f50295a.get(i4)).b().size();
            if (size2 > i3) {
                break;
            }
            i3 -= size2;
            i4++;
        }
        return ((PagingSource.LoadResult.Page) this.f50295a.get(i4)).b().get(i3);
    }

    @Override // androidx.paging.PlaceholderPaddedList
    public int getSize() {
        return d() + a() + f();
    }

    public final Object h() {
        return CollectionsKt.first(((PagingSource.LoadResult.Page) CollectionsKt.first(this.f50295a)).b());
    }

    public final int l() {
        return d() + this.f50301h;
    }

    public final Object n() {
        return CollectionsKt.last(((PagingSource.LoadResult.Page) CollectionsKt.last(this.f50295a)).b());
    }

    public final int o() {
        return d() + (a() / 2);
    }

    public final PagingState p(PagedList.Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (this.f50295a.isEmpty()) {
            return null;
        }
        List list = CollectionsKt.toList(this.f50295a);
        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.List<androidx.paging.PagingSource.LoadResult.Page<kotlin.Any, T of androidx.paging.PagedStorage>>");
        return new PagingState(list, Integer.valueOf(l()), new PagingConfig(config.f50270a, config.f50271b, config.f50272c, config.f50273d, config.f50274e, 0, 32, null), d());
    }

    public final void q(int i3, PagingSource.LoadResult.Page page, int i4, int i5, Callback callback, boolean z2) {
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(callback, "callback");
        s(i3, page, i4, i5, z2);
        callback.g(size());
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ Object remove(int i3) {
        return x(i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return "leading " + d() + ", dataCount " + a() + ", trailing " + f() + ' ' + CollectionsKt.joinToString$default(this.f50295a, " ", null, null, 0, null, null, 62, null);
    }

    public final boolean u(int i3, int i4) {
        return t(i3, i4, this.f50295a.size() - 1);
    }

    public final boolean v(int i3, int i4) {
        return t(i3, i4, 0);
    }

    public final void w(PagingSource.LoadResult.Page page, Callback callback) {
        Intrinsics.checkNotNullParameter(page, "page");
        int size = page.b().size();
        if (size == 0) {
            return;
        }
        this.f50295a.add(0, page);
        this.f50300g = a() + size;
        int iMin = Math.min(d(), size);
        int i3 = size - iMin;
        if (iMin != 0) {
            this.f50296b = d() - iMin;
        }
        this.f50298d -= i3;
        if (callback != null) {
            callback.e(d(), iMin, i3);
        }
    }

    public /* bridge */ Object x(int i3) {
        return super.remove(i3);
    }

    public final boolean y(int i3, int i4, int i5) {
        return a() + i5 > i3 && this.f50295a.size() > 1 && a() >= i4;
    }

    public final boolean z(boolean z2, int i3, int i4, Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        int i5 = 0;
        while (u(i3, i4)) {
            List list = this.f50295a;
            int size = ((PagingSource.LoadResult.Page) list.remove(list.size() - 1)).b().size();
            i5 += size;
            this.f50300g = a() - size;
        }
        this.f50301h = RangesKt.k(this.f50301h, a() - 1);
        if (i5 > 0) {
            int iD = d() + a();
            if (z2) {
                this.f50297c = f() + i5;
                callback.a(iD, i5);
            } else {
                callback.b(iD, i5);
            }
        }
        return i5 > 0;
    }
}
