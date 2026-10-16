package androidx.compose.foundation.text.selection;

import androidx.collection.LongObjectMap;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SelectionRegistrarImpl implements SelectionRegistrar {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Companion f11484m = new Companion(null);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f11485n = 8;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Saver f11486o = SaverKt.a(new Function2<SaverScope, SelectionRegistrarImpl, Long>() { // from class: androidx.compose.foundation.text.selection.SelectionRegistrarImpl$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Long invoke(SaverScope saverScope, SelectionRegistrarImpl selectionRegistrarImpl) {
            return Long.valueOf(selectionRegistrarImpl.f11490d.get());
        }
    }, new Function1<Long, SelectionRegistrarImpl>() { // from class: androidx.compose.foundation.text.selection.SelectionRegistrarImpl$Companion$Saver$2
        public final SelectionRegistrarImpl c(long j3) {
            return new SelectionRegistrarImpl(j3, null);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return c(((Number) obj).longValue());
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f11487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f11488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableLongObjectMap f11489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AtomicLong f11490d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Function1 f11491e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Function4 f11492f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Function2 f11493g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Function6 f11494h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Function0 f11495i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Function1 f11496j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Function1 f11497k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final MutableState f11498l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Saver a() {
            return SelectionRegistrarImpl.f11486o;
        }

        private Companion() {
        }
    }

    public /* synthetic */ SelectionRegistrarImpl(long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int x(Function2 function2, Object obj, Object obj2) {
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public long a() {
        long andIncrement = this.f11490d.getAndIncrement();
        while (andIncrement == 0) {
            andIncrement = this.f11490d.getAndIncrement();
        }
        return andIncrement;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public LongObjectMap b() {
        return (LongObjectMap) this.f11498l.getValue();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public void c(long j3) {
        this.f11487a = false;
        Function1 function1 = this.f11491e;
        if (function1 != null) {
            function1.invoke(Long.valueOf(j3));
        }
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public void d(Selectable selectable) {
        if (this.f11489c.a(selectable.j())) {
            this.f11488b.remove(selectable);
            this.f11489c.o(selectable.j());
            Function1 function1 = this.f11497k;
            if (function1 != null) {
                function1.invoke(Long.valueOf(selectable.j()));
            }
        }
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public void e(long j3) {
        Function1 function1 = this.f11496j;
        if (function1 != null) {
            function1.invoke(Long.valueOf(j3));
        }
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public boolean f(LayoutCoordinates layoutCoordinates, long j3, long j4, boolean z2, SelectionAdjustment selectionAdjustment, boolean z3) {
        Function6 function6 = this.f11494h;
        if (function6 != null) {
            return ((Boolean) function6.k(Boolean.valueOf(z3), layoutCoordinates, Offset.d(j3), Offset.d(j4), Boolean.valueOf(z2), selectionAdjustment)).booleanValue();
        }
        return true;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public void g() {
        Function0 function0 = this.f11495i;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public Selectable h(Selectable selectable) {
        if (!(selectable.j() != 0)) {
            InlineClassHelperKt.a("The selectable contains an invalid id: " + selectable.j());
        }
        if (this.f11489c.a(selectable.j())) {
            InlineClassHelperKt.a("Another selectable with the id: " + selectable + ".selectableId has already subscribed.");
        }
        this.f11489c.r(selectable.j(), selectable);
        this.f11488b.add(selectable);
        this.f11487a = false;
        return selectable;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public void i(LayoutCoordinates layoutCoordinates, long j3, SelectionAdjustment selectionAdjustment, boolean z2) {
        Function4 function4 = this.f11492f;
        if (function4 != null) {
            function4.invoke(Boolean.valueOf(z2), layoutCoordinates, Offset.d(j3), selectionAdjustment);
        }
    }

    public final LongObjectMap m() {
        return this.f11489c;
    }

    public final List n() {
        return this.f11488b;
    }

    public final void o(Function1 function1) {
        this.f11497k = function1;
    }

    public final void p(Function1 function1) {
        this.f11491e = function1;
    }

    public final void q(Function1 function1) {
        this.f11496j = function1;
    }

    public final void r(Function6 function6) {
        this.f11494h = function6;
    }

    public final void s(Function0 function0) {
        this.f11495i = function0;
    }

    public final void t(Function2 function2) {
        this.f11493g = function2;
    }

    public final void u(Function4 function4) {
        this.f11492f = function4;
    }

    public void v(LongObjectMap longObjectMap) {
        this.f11498l.setValue(longObjectMap);
    }

    public final List w(final LayoutCoordinates layoutCoordinates) {
        if (!this.f11487a) {
            List list = this.f11488b;
            final Function2<Selectable, Selectable, Integer> function2 = new Function2<Selectable, Selectable, Integer>() { // from class: androidx.compose.foundation.text.selection.SelectionRegistrarImpl$sort$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final Integer invoke(Selectable selectable, Selectable selectable2) {
                    LayoutCoordinates layoutCoordinatesZ = selectable.z();
                    LayoutCoordinates layoutCoordinatesZ2 = selectable2.z();
                    long jS = layoutCoordinatesZ != null ? layoutCoordinates.S(layoutCoordinatesZ, Offset.f25596b.c()) : Offset.f25596b.c();
                    long jS2 = layoutCoordinatesZ2 != null ? layoutCoordinates.S(layoutCoordinatesZ2, Offset.f25596b.c()) : Offset.f25596b.c();
                    int i3 = (int) (jS & 4294967295L);
                    int i4 = (int) (4294967295L & jS2);
                    return Integer.valueOf(Float.intBitsToFloat(i3) == Float.intBitsToFloat(i4) ? ComparisonsKt.d(Float.valueOf(Float.intBitsToFloat((int) (jS >> 32))), Float.valueOf(Float.intBitsToFloat((int) (jS2 >> 32)))) : ComparisonsKt.d(Float.valueOf(Float.intBitsToFloat(i3)), Float.valueOf(Float.intBitsToFloat(i4))));
                }
            };
            CollectionsKt.sortWith(list, new Comparator() { // from class: androidx.compose.foundation.text.selection.f
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return SelectionRegistrarImpl.x(function2, obj, obj2);
                }
            });
            this.f11487a = true;
        }
        return n();
    }

    private SelectionRegistrarImpl(long j3) {
        this.f11488b = new ArrayList();
        this.f11489c = LongObjectMapKt.c();
        this.f11490d = new AtomicLong(j3);
        this.f11498l = SnapshotStateKt__SnapshotStateKt.e(LongObjectMapKt.a(), null, 2, null);
    }

    public SelectionRegistrarImpl() {
        this(1L);
    }
}
