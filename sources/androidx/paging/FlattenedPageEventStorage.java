package androidx.paging;

import androidx.paging.LoadState;
import androidx.paging.PageEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
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
public final class FlattenedPageEventStorage<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f49732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f49733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayDeque f49734c = new ArrayDeque();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableLoadStateCollection f49735d = new MutableLoadStateCollection();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private LoadStates f49736e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f49737f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f49738a;

        static {
            int[] iArr = new int[LoadType.values().length];
            try {
                iArr[LoadType.PREPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadType.APPEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LoadType.REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f49738a = iArr;
        }
    }

    private final void c(PageEvent.Insert insert) {
        this.f49735d.b(insert.o());
        this.f49736e = insert.k();
        int i3 = WhenMappings.f49738a[insert.j().ordinal()];
        if (i3 == 1) {
            this.f49732a = insert.n();
            Iterator<Integer> it = RangesKt.v(insert.l().size() - 1, 0).iterator();
            while (it.hasNext()) {
                this.f49734c.addFirst(insert.l().get(((IntIterator) it).nextInt()));
            }
            return;
        }
        if (i3 == 2) {
            this.f49733b = insert.m();
            this.f49734c.addAll(insert.l());
        } else {
            if (i3 != 3) {
                return;
            }
            this.f49734c.clear();
            this.f49733b = insert.m();
            this.f49732a = insert.n();
            this.f49734c.addAll(insert.l());
        }
    }

    private final void d(PageEvent.LoadStateUpdate loadStateUpdate) {
        this.f49735d.b(loadStateUpdate.h());
        this.f49736e = loadStateUpdate.g();
    }

    private final void e(PageEvent.Drop drop) {
        this.f49735d.c(drop.g(), LoadState.NotLoading.f49893b.b());
        int i3 = WhenMappings.f49738a[drop.g().ordinal()];
        int i4 = 0;
        if (i3 == 1) {
            this.f49732a = drop.k();
            int iJ = drop.j();
            while (i4 < iJ) {
                this.f49734c.removeFirst();
                i4++;
            }
            return;
        }
        if (i3 != 2) {
            throw new IllegalArgumentException("Page drop type must be prepend or append");
        }
        this.f49733b = drop.k();
        int iJ2 = drop.j();
        while (i4 < iJ2) {
            this.f49734c.removeLast();
            i4++;
        }
    }

    private final void f(PageEvent.StaticList staticList) {
        if (staticList.i() != null) {
            this.f49735d.b(staticList.i());
        }
        if (staticList.h() != null) {
            this.f49736e = staticList.h();
        }
        this.f49734c.clear();
        this.f49733b = 0;
        this.f49732a = 0;
        this.f49734c.add(new TransformablePage(0, staticList.g()));
    }

    public final void a(PageEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.f49737f = true;
        if (event instanceof PageEvent.Insert) {
            c((PageEvent.Insert) event);
            return;
        }
        if (event instanceof PageEvent.Drop) {
            e((PageEvent.Drop) event);
        } else if (event instanceof PageEvent.LoadStateUpdate) {
            d((PageEvent.LoadStateUpdate) event);
        } else if (event instanceof PageEvent.StaticList) {
            f((PageEvent.StaticList) event);
        }
    }

    public final List b() {
        if (!this.f49737f) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        LoadStates loadStatesD = this.f49735d.d();
        if (this.f49734c.isEmpty()) {
            arrayList.add(new PageEvent.LoadStateUpdate(loadStatesD, this.f49736e));
            return arrayList;
        }
        arrayList.add(PageEvent.Insert.f49947g.c(CollectionsKt.toList(this.f49734c), this.f49732a, this.f49733b, loadStatesD, this.f49736e));
        return arrayList;
    }
}
