package androidx.paging;

import androidx.paging.PageEvent;
import androidx.paging.PagingDataEvent;
import androidx.paging.ViewportHint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

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
public final class PageStore<T> implements PlaceholderPaddedList<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f50249f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final PageStore f50250g = new PageStore(PageEvent.Insert.f49947g.e());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f50251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f50252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f50253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f50254d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PageStore a(PageEvent.Insert insert) {
            if (insert != null) {
                return new PageStore(insert);
            }
            PageStore pageStore = PageStore.f50250g;
            Intrinsics.checkNotNull(pageStore, "null cannot be cast to non-null type androidx.paging.PageStore<T of androidx.paging.PageStore.Companion.initial>");
            return pageStore;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f50255a;

        static {
            int[] iArr = new int[LoadType.values().length];
            try {
                iArr[LoadType.REFRESH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadType.PREPEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LoadType.APPEND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f50255a = iArr;
        }
    }

    public PageStore(List pages, int i3, int i4) {
        Intrinsics.checkNotNullParameter(pages, "pages");
        this.f50251a = CollectionsKt.toMutableList((Collection) pages);
        this.f50252b = i(pages);
        this.f50253c = i3;
        this.f50254d = i4;
    }

    private final void e(int i3) {
        if (i3 < 0 || i3 >= getSize()) {
            throw new IndexOutOfBoundsException("Index: " + i3 + ", Size: " + getSize());
        }
    }

    private final PagingDataEvent g(PageEvent.Drop drop) {
        int iH = h(new IntRange(drop.i(), drop.h()));
        this.f50252b = a() - iH;
        if (drop.g() == LoadType.PREPEND) {
            int iD = d();
            this.f50253c = drop.k();
            return new PagingDataEvent.DropPrepend(iH, d(), iD);
        }
        int iF = f();
        this.f50254d = drop.k();
        return new PagingDataEvent.DropAppend(d() + a(), iH, drop.k(), iF);
    }

    private final int h(IntRange intRange) {
        Iterator it = this.f50251a.iterator();
        int size = 0;
        while (it.hasNext()) {
            TransformablePage transformablePage = (TransformablePage) it.next();
            int[] iArrE = transformablePage.e();
            int length = iArrE.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (intRange.p(iArrE[i3])) {
                    size += transformablePage.b().size();
                    it.remove();
                    break;
                }
                i3++;
            }
        }
        return size;
    }

    private final int i(List list) {
        Iterator<T> it = list.iterator();
        int size = 0;
        while (it.hasNext()) {
            size += ((TransformablePage) it.next()).b().size();
        }
        return size;
    }

    private final int k() {
        Integer numMinOrNull = ArraysKt.minOrNull(((TransformablePage) CollectionsKt.first(this.f50251a)).e());
        Intrinsics.checkNotNull(numMinOrNull);
        return numMinOrNull.intValue();
    }

    private final int l() {
        Integer numMaxOrNull = ArraysKt.maxOrNull(((TransformablePage) CollectionsKt.last(this.f50251a)).e());
        Intrinsics.checkNotNull(numMaxOrNull);
        return numMaxOrNull.intValue();
    }

    private final PagingDataEvent n(PageEvent.Insert insert) {
        int i3 = i(insert.l());
        int i4 = WhenMappings.f50255a[insert.j().ordinal()];
        if (i4 == 1) {
            throw new IllegalStateException("Paging received a refresh event in the middle of an actively loading generation\nof PagingData. If you see this exception, it is most likely a bug in the library.\nPlease file a bug so we can fix it at:\nhttps://issuetracker.google.com/issues/new?component=413106");
        }
        if (i4 == 2) {
            int iD = d();
            this.f50251a.addAll(0, insert.l());
            this.f50252b = a() + i3;
            this.f50253c = insert.n();
            List listL = insert.l();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = listL.iterator();
            while (it.hasNext()) {
                CollectionsKt.addAll(arrayList, ((TransformablePage) it.next()).b());
            }
            return new PagingDataEvent.Prepend(arrayList, d(), iD);
        }
        if (i4 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        int iF = f();
        int iA = a();
        List list = this.f50251a;
        list.addAll(list.size(), insert.l());
        this.f50252b = a() + i3;
        this.f50254d = insert.m();
        int iD2 = d() + iA;
        List listL2 = insert.l();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it2 = listL2.iterator();
        while (it2.hasNext()) {
            CollectionsKt.addAll(arrayList2, ((TransformablePage) it2.next()).b());
        }
        return new PagingDataEvent.Append(iD2, arrayList2, f(), iF);
    }

    @Override // androidx.paging.PlaceholderPaddedList
    public int a() {
        return this.f50252b;
    }

    public final ViewportHint.Access c(int i3) {
        int i4 = 0;
        int iD = i3 - d();
        while (iD >= ((TransformablePage) this.f50251a.get(i4)).b().size() && i4 < CollectionsKt.getLastIndex(this.f50251a)) {
            iD -= ((TransformablePage) this.f50251a.get(i4)).b().size();
            i4++;
        }
        return ((TransformablePage) this.f50251a.get(i4)).f(iD, i3 - d(), ((getSize() - i3) - f()) - 1, k(), l());
    }

    @Override // androidx.paging.PlaceholderPaddedList
    public int d() {
        return this.f50253c;
    }

    @Override // androidx.paging.PlaceholderPaddedList
    public int f() {
        return this.f50254d;
    }

    @Override // androidx.paging.PlaceholderPaddedList
    public Object getItem(int i3) {
        int size = this.f50251a.size();
        int i4 = 0;
        while (i4 < size) {
            int size2 = ((TransformablePage) this.f50251a.get(i4)).b().size();
            if (size2 > i3) {
                break;
            }
            i3 -= size2;
            i4++;
        }
        return ((TransformablePage) this.f50251a.get(i4)).b().get(i3);
    }

    @Override // androidx.paging.PlaceholderPaddedList
    public int getSize() {
        return d() + a() + f();
    }

    public final Object j(int i3) {
        e(i3);
        int iD = i3 - d();
        if (iD < 0 || iD >= a()) {
            return null;
        }
        return getItem(iD);
    }

    public final ViewportHint.Initial m() {
        int iA = a() / 2;
        return new ViewportHint.Initial(iA, iA, k(), l());
    }

    public final PagingDataEvent o(PageEvent pageEvent) {
        Intrinsics.checkNotNullParameter(pageEvent, "pageEvent");
        if (pageEvent instanceof PageEvent.Insert) {
            return n((PageEvent.Insert) pageEvent);
        }
        if (pageEvent instanceof PageEvent.Drop) {
            return g((PageEvent.Drop) pageEvent);
        }
        throw new IllegalStateException("Paging received an event to process StaticList or LoadStateUpdate while\nprocessing Inserts and Drops. If you see this exception, it is most\nlikely a bug in the library. Please file a bug so we can fix it at:\nhttps://issuetracker.google.com/issues/new?component=413106");
    }

    public final ItemSnapshotList p() {
        int iD = d();
        int iF = f();
        List list = this.f50251a;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, ((TransformablePage) it.next()).b());
        }
        return new ItemSnapshotList(iD, iF, arrayList);
    }

    public String toString() {
        int iA = a();
        ArrayList arrayList = new ArrayList(iA);
        for (int i3 = 0; i3 < iA; i3++) {
            arrayList.add(getItem(i3));
        }
        return "[(" + d() + " placeholders), " + CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, null, 63, null) + ", (" + f() + " placeholders)]";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PageStore(PageEvent.Insert insertEvent) {
        this(insertEvent.l(), insertEvent.n(), insertEvent.m());
        Intrinsics.checkNotNullParameter(insertEvent, "insertEvent");
    }
}
