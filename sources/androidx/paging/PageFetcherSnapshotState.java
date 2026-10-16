package androidx.paging;

import androidx.paging.LoadState;
import androidx.paging.PageEvent;
import androidx.paging.PagingSource;
import androidx.paging.ViewportHint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

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
public final class PageFetcherSnapshotState<Key, Value> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PagingConfig f50216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f50217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f50218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f50219d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f50220e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f50221f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f50222g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f50223h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Channel f50224i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Channel f50225j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Map f50226k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private MutableLoadStateCollection f50227l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Holder<Key, Value> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PagingConfig f50228a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Mutex f50229b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final PageFetcherSnapshotState f50230c;

        public Holder(PagingConfig config) {
            Intrinsics.checkNotNullParameter(config, "config");
            this.f50228a = config;
            this.f50229b = MutexKt.b(false, 1, null);
            this.f50230c = new PageFetcherSnapshotState(config, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object c(kotlin.jvm.functions.Function1 r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
            /*
                r5 = this;
                boolean r0 = r7 instanceof androidx.paging.PageFetcherSnapshotState$Holder$withLock$1
                if (r0 == 0) goto L13
                r0 = r7
                androidx.paging.PageFetcherSnapshotState$Holder$withLock$1 r0 = (androidx.paging.PageFetcherSnapshotState$Holder$withLock$1) r0
                int r1 = r0.f50236g
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f50236g = r1
                goto L18
            L13:
                androidx.paging.PageFetcherSnapshotState$Holder$withLock$1 r0 = new androidx.paging.PageFetcherSnapshotState$Holder$withLock$1
                r0.<init>(r5, r7)
            L18:
                java.lang.Object r7 = r0.f50234d
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.f50236g
                r3 = 1
                r4 = 0
                if (r2 == 0) goto L40
                if (r2 != r3) goto L38
                java.lang.Object r6 = r0.f50233c
                kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
                java.lang.Object r1 = r0.f50232b
                kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
                java.lang.Object r0 = r0.f50231a
                androidx.paging.PageFetcherSnapshotState$Holder r0 = (androidx.paging.PageFetcherSnapshotState.Holder) r0
                kotlin.ResultKt.b(r7)
                r7 = r6
                r6 = r1
                goto L57
            L38:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L40:
                kotlin.ResultKt.b(r7)
                kotlinx.coroutines.sync.Mutex r7 = a(r5)
                r0.f50231a = r5
                r0.f50232b = r6
                r0.f50233c = r7
                r0.f50236g = r3
                java.lang.Object r0 = r7.f(r4, r0)
                if (r0 != r1) goto L56
                return r1
            L56:
                r0 = r5
            L57:
                androidx.paging.PageFetcherSnapshotState r0 = b(r0)     // Catch: java.lang.Throwable -> L69
                java.lang.Object r6 = r6.invoke(r0)     // Catch: java.lang.Throwable -> L69
                kotlin.jvm.internal.InlineMarker.b(r3)
                r7.i(r4)
                kotlin.jvm.internal.InlineMarker.a(r3)
                return r6
            L69:
                r6 = move-exception
                kotlin.jvm.internal.InlineMarker.b(r3)
                r7.i(r4)
                kotlin.jvm.internal.InlineMarker.a(r3)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshotState.Holder.c(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f50237a;

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
            f50237a = iArr;
        }
    }

    public /* synthetic */ PageFetcherSnapshotState(PagingConfig pagingConfig, DefaultConstructorMarker defaultConstructorMarker) {
        this(pagingConfig);
    }

    public final Flow e() {
        return FlowKt.W(FlowKt.r(this.f50225j), new PageFetcherSnapshotState$consumeAppendGenerationIdAsFlow$1(this, null));
    }

    public final Flow f() {
        return FlowKt.W(FlowKt.r(this.f50224i), new PageFetcherSnapshotState$consumePrependGenerationIdAsFlow$1(this, null));
    }

    public final PagingState g(ViewportHint.Access access) {
        Integer numValueOf;
        List list = CollectionsKt.toList(this.f50218c);
        if (access != null) {
            int iO = o();
            int i3 = -this.f50219d;
            int lastIndex = CollectionsKt.getLastIndex(this.f50218c) - this.f50219d;
            int iG = access.g();
            int i4 = i3;
            while (i4 < iG) {
                iO += i4 > lastIndex ? this.f50216a.f50306a : ((PagingSource.LoadResult.Page) this.f50218c.get(this.f50219d + i4)).b().size();
                i4++;
            }
            int iF = iO + access.f();
            if (access.g() < i3) {
                iF -= this.f50216a.f50306a;
            }
            numValueOf = Integer.valueOf(iF);
        } else {
            numValueOf = null;
        }
        return new PagingState(list, numValueOf, this.f50216a, o());
    }

    public final void h(PageEvent.Drop event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.j() > this.f50218c.size()) {
            throw new IllegalStateException(("invalid drop count. have " + this.f50218c.size() + " but wanted to drop " + event.j()).toString());
        }
        this.f50226k.remove(event.g());
        this.f50227l.c(event.g(), LoadState.NotLoading.f49893b.b());
        int i3 = WhenMappings.f50237a[event.g().ordinal()];
        if (i3 == 2) {
            int iJ = event.j();
            for (int i4 = 0; i4 < iJ; i4++) {
                this.f50217b.remove(0);
            }
            this.f50219d -= event.j();
            t(event.k());
            int i5 = this.f50222g + 1;
            this.f50222g = i5;
            this.f50224i.h(Integer.valueOf(i5));
            return;
        }
        if (i3 != 3) {
            throw new IllegalArgumentException("cannot drop " + event.g());
        }
        int iJ2 = event.j();
        for (int i6 = 0; i6 < iJ2; i6++) {
            this.f50217b.remove(this.f50218c.size() - 1);
        }
        s(event.k());
        int i7 = this.f50223h + 1;
        this.f50223h = i7;
        this.f50225j.h(Integer.valueOf(i7));
    }

    public final PageEvent.Drop i(LoadType loadType, ViewportHint hint) {
        int size;
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(hint, "hint");
        if (this.f50216a.f50310e == Integer.MAX_VALUE || this.f50218c.size() <= 2 || q() <= this.f50216a.f50310e) {
            return null;
        }
        if (loadType == LoadType.REFRESH) {
            throw new IllegalArgumentException(("Drop LoadType must be PREPEND or APPEND, but got " + loadType).toString());
        }
        int iO = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < this.f50218c.size() && q() - i4 > this.f50216a.f50310e) {
            int[] iArr = WhenMappings.f50237a;
            if (iArr[loadType.ordinal()] == 2) {
                size = ((PagingSource.LoadResult.Page) this.f50218c.get(i3)).b().size();
            } else {
                List list = this.f50218c;
                size = ((PagingSource.LoadResult.Page) list.get(CollectionsKt.getLastIndex(list) - i3)).b().size();
            }
            if (((iArr[loadType.ordinal()] == 2 ? hint.d() : hint.c()) - i4) - size < this.f50216a.f50307b) {
                break;
            }
            i4 += size;
            i3++;
        }
        if (i3 == 0) {
            return null;
        }
        int[] iArr2 = WhenMappings.f50237a;
        int lastIndex = iArr2[loadType.ordinal()] == 2 ? -this.f50219d : (CollectionsKt.getLastIndex(this.f50218c) - this.f50219d) - (i3 - 1);
        int lastIndex2 = iArr2[loadType.ordinal()] == 2 ? (i3 - 1) - this.f50219d : CollectionsKt.getLastIndex(this.f50218c) - this.f50219d;
        if (this.f50216a.f50308c) {
            iO = (loadType == LoadType.PREPEND ? o() : n()) + i4;
        }
        return new PageEvent.Drop(loadType, lastIndex, lastIndex2, iO);
    }

    public final int j(LoadType loadType) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        int i3 = WhenMappings.f50237a[loadType.ordinal()];
        if (i3 == 1) {
            throw new IllegalArgumentException("Cannot get loadId for loadType: REFRESH");
        }
        if (i3 == 2) {
            return this.f50222g;
        }
        if (i3 == 3) {
            return this.f50223h;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Map k() {
        return this.f50226k;
    }

    public final int l() {
        return this.f50219d;
    }

    public final List m() {
        return this.f50218c;
    }

    public final int n() {
        if (this.f50216a.f50308c) {
            return this.f50221f;
        }
        return 0;
    }

    public final int o() {
        if (this.f50216a.f50308c) {
            return this.f50220e;
        }
        return 0;
    }

    public final MutableLoadStateCollection p() {
        return this.f50227l;
    }

    public final int q() {
        Iterator it = this.f50218c.iterator();
        int size = 0;
        while (it.hasNext()) {
            size += ((PagingSource.LoadResult.Page) it.next()).b().size();
        }
        return size;
    }

    public final boolean r(int i3, LoadType loadType, PagingSource.LoadResult.Page page) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(page, "page");
        int i4 = WhenMappings.f50237a[loadType.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 == 3) {
                    if (this.f50218c.isEmpty()) {
                        throw new IllegalStateException("should've received an init before append");
                    }
                    if (i3 != this.f50223h) {
                        return false;
                    }
                    this.f50217b.add(page);
                    s(page.d() == Integer.MIN_VALUE ? RangesKt.f(n() - page.b().size(), 0) : page.d());
                    this.f50226k.remove(LoadType.APPEND);
                }
            } else {
                if (this.f50218c.isEmpty()) {
                    throw new IllegalStateException("should've received an init before prepend");
                }
                if (i3 != this.f50222g) {
                    return false;
                }
                this.f50217b.add(0, page);
                this.f50219d++;
                t(page.e() == Integer.MIN_VALUE ? RangesKt.f(o() - page.b().size(), 0) : page.e());
                this.f50226k.remove(LoadType.PREPEND);
            }
        } else {
            if (!this.f50218c.isEmpty()) {
                throw new IllegalStateException("cannot receive multiple init calls");
            }
            if (i3 != 0) {
                throw new IllegalStateException("init loadId must be the initial value, 0");
            }
            this.f50217b.add(page);
            this.f50219d = 0;
            s(page.d());
            t(page.e());
        }
        return true;
    }

    public final void s(int i3) {
        if (i3 == Integer.MIN_VALUE) {
            i3 = 0;
        }
        this.f50221f = i3;
    }

    public final void t(int i3) {
        if (i3 == Integer.MIN_VALUE) {
            i3 = 0;
        }
        this.f50220e = i3;
    }

    public final PageEvent u(PagingSource.LoadResult.Page page, LoadType loadType) {
        Intrinsics.checkNotNullParameter(page, "<this>");
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        int[] iArr = WhenMappings.f50237a;
        int i3 = iArr[loadType.ordinal()];
        int size = 0;
        if (i3 != 1) {
            if (i3 == 2) {
                size = 0 - this.f50219d;
            } else {
                if (i3 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                size = (this.f50218c.size() - this.f50219d) - 1;
            }
        }
        List listListOf = CollectionsKt.listOf(new TransformablePage(size, page.b()));
        int i4 = iArr[loadType.ordinal()];
        if (i4 == 1) {
            return PageEvent.Insert.f49947g.c(listListOf, o(), n(), this.f50227l.d(), null);
        }
        if (i4 == 2) {
            return PageEvent.Insert.f49947g.b(listListOf, o(), this.f50227l.d(), null);
        }
        if (i4 == 3) {
            return PageEvent.Insert.f49947g.a(listListOf, n(), this.f50227l.d(), null);
        }
        throw new NoWhenBranchMatchedException();
    }

    private PageFetcherSnapshotState(PagingConfig pagingConfig) {
        this.f50216a = pagingConfig;
        ArrayList arrayList = new ArrayList();
        this.f50217b = arrayList;
        this.f50218c = arrayList;
        this.f50224i = ChannelKt.b(-1, null, null, 6, null);
        this.f50225j = ChannelKt.b(-1, null, null, 6, null);
        this.f50226k = new LinkedHashMap();
        MutableLoadStateCollection mutableLoadStateCollection = new MutableLoadStateCollection();
        mutableLoadStateCollection.c(LoadType.REFRESH, LoadState.Loading.f49892b);
        this.f50227l = mutableLoadStateCollection;
    }
}
