package androidx.compose.foundation.lazy.layout;

import android.os.Trace;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.time.Duration;
import kotlin.time.TimeSource;

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
public final class PrefetchHandleProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LazyLayoutItemContentFactory f8261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SubcomposeLayoutState f8262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PrefetchScheduler f8263c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class HandleAndRequestImpl implements LazyLayoutPrefetchState.PrefetchHandle, PrefetchRequest {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f8264a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f8265b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final PrefetchMetrics f8266c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private SubcomposeLayoutState.PrecomposedSlotHandle f8267d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f8268e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f8269f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f8270g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private NestedPrefetchController f8271h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f8272i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f8273j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private long f8274k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private long f8275l;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        private final class NestedPrefetchController {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final List f8277a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final List[] f8278b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private int f8279c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f8280d;

            public NestedPrefetchController(List list) {
                this.f8277a = list;
                this.f8278b = new List[list.size()];
                if (list.isEmpty()) {
                    InlineClassHelperKt.a("NestedPrefetchController shouldn't be created with no states");
                }
            }

            public final boolean a(PrefetchRequestScope prefetchRequestScope) {
                if (this.f8279c >= this.f8277a.size()) {
                    return false;
                }
                if (HandleAndRequestImpl.this.f8269f) {
                    InlineClassHelperKt.c("Should not execute nested prefetch on canceled request");
                }
                Trace.beginSection("compose:lazy:prefetch:nested");
                while (this.f8279c < this.f8277a.size()) {
                    try {
                        if (this.f8278b[this.f8279c] == null) {
                            if (prefetchRequestScope.a() <= 0) {
                                Trace.endSection();
                                return true;
                            }
                            List[] listArr = this.f8278b;
                            int i3 = this.f8279c;
                            listArr[i3] = ((LazyLayoutPrefetchState) this.f8277a.get(i3)).b();
                        }
                        List list = this.f8278b[this.f8279c];
                        Intrinsics.checkNotNull(list);
                        while (this.f8280d < list.size()) {
                            if (((PrefetchRequest) list.get(this.f8280d)).b(prefetchRequestScope)) {
                                Trace.endSection();
                                return true;
                            }
                            this.f8280d++;
                        }
                        this.f8280d = 0;
                        this.f8279c++;
                    } catch (Throwable th) {
                        Trace.endSection();
                        throw th;
                    }
                }
                Unit unit = Unit.f139807a;
                Trace.endSection();
                return false;
            }
        }

        public /* synthetic */ HandleAndRequestImpl(PrefetchHandleProvider prefetchHandleProvider, int i3, long j3, PrefetchMetrics prefetchMetrics, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, j3, prefetchMetrics);
        }

        private final boolean d() {
            return this.f8267d != null;
        }

        private final void e(LazyLayoutItemProvider lazyLayoutItemProvider, Object obj) {
            if (!(this.f8267d == null)) {
                InlineClassHelperKt.a("Request was already composed!");
            }
            Object objD = lazyLayoutItemProvider.d(this.f8264a);
            this.f8267d = PrefetchHandleProvider.this.f8262b.i(objD, PrefetchHandleProvider.this.f8261a.b(this.f8264a, objD, obj));
        }

        private final void f(long j3) {
            if (this.f8269f) {
                InlineClassHelperKt.a("Callers should check whether the request is still valid before calling performMeasure()");
            }
            if (this.f8268e) {
                InlineClassHelperKt.a("Request was already measured!");
            }
            this.f8268e = true;
            SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = this.f8267d;
            if (precomposedSlotHandle == null) {
                InlineClassHelperKt.b("performComposition() must be called before performMeasure()");
                throw new KotlinNothingValueException();
            }
            int iD = precomposedSlotHandle.d();
            for (int i3 = 0; i3 < iD; i3++) {
                precomposedSlotHandle.b(i3, j3);
            }
        }

        private final void g(long j3) {
            this.f8273j = j3;
            this.f8275l = TimeSource.Monotonic.f140667a.a();
            this.f8274k = 0L;
        }

        private final NestedPrefetchController h() {
            SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = this.f8267d;
            if (precomposedSlotHandle == null) {
                InlineClassHelperKt.b("Should precompose before resolving nested prefetch states");
                throw new KotlinNothingValueException();
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            precomposedSlotHandle.a("androidx.compose.foundation.lazy.layout.TraversablePrefetchStateNode", new Function1<TraversableNode, TraversableNode.Companion.TraverseDescendantsAction>() { // from class: androidx.compose.foundation.lazy.layout.PrefetchHandleProvider$HandleAndRequestImpl$resolveNestedPrefetchStates$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final TraversableNode.Companion.TraverseDescendantsAction invoke(TraversableNode traversableNode) {
                    Intrinsics.checkNotNull(traversableNode, "null cannot be cast to non-null type androidx.compose.foundation.lazy.layout.TraversablePrefetchStateNode");
                    LazyLayoutPrefetchState lazyLayoutPrefetchStateM2 = ((TraversablePrefetchStateNode) traversableNode).m2();
                    Ref.ObjectRef objectRef2 = objectRef;
                    List listMutableListOf = (List) objectRef2.f140144a;
                    if (listMutableListOf != null) {
                        listMutableListOf.add(lazyLayoutPrefetchStateM2);
                    } else {
                        listMutableListOf = CollectionsKt.mutableListOf(lazyLayoutPrefetchStateM2);
                    }
                    objectRef2.f140144a = listMutableListOf;
                    return TraversableNode.Companion.TraverseDescendantsAction.f27642b;
                }
            });
            List list = (List) objectRef.f140144a;
            if (list != null) {
                return new NestedPrefetchController(list);
            }
            return null;
        }

        private final boolean i(long j3, long j4) {
            return (this.f8272i && j3 > 0) || j4 < j3;
        }

        private final void j() {
            long jA = TimeSource.Monotonic.f140667a.a();
            long jR = Duration.r(TimeSource.Monotonic.ValueTimeMark.e(jA, this.f8275l));
            this.f8274k = jR;
            this.f8273j -= jR;
            this.f8275l = jA;
        }

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchHandle
        public void a() {
            this.f8272i = true;
        }

        @Override // androidx.compose.foundation.lazy.layout.PrefetchRequest
        public boolean b(PrefetchRequestScope prefetchRequestScope) {
            LazyLayoutItemProvider lazyLayoutItemProvider = (LazyLayoutItemProvider) PrefetchHandleProvider.this.f8261a.d().invoke();
            if (!this.f8269f) {
                int iA = lazyLayoutItemProvider.a();
                int i3 = this.f8264a;
                if (i3 >= 0 && i3 < iA) {
                    Object objF = lazyLayoutItemProvider.f(i3);
                    g(prefetchRequestScope.a());
                    if (!d()) {
                        if (!i(this.f8273j, this.f8266c.b(objF))) {
                            return true;
                        }
                        Trace.beginSection("compose:lazy:prefetch:compose");
                        try {
                            e(lazyLayoutItemProvider, objF);
                            Unit unit = Unit.f139807a;
                            Trace.endSection();
                            j();
                            this.f8266c.d(objF, this.f8274k);
                        } finally {
                        }
                    }
                    if (!this.f8272i) {
                        if (!this.f8270g) {
                            if (this.f8273j <= 0) {
                                return true;
                            }
                            Trace.beginSection("compose:lazy:prefetch:resolve-nested");
                            try {
                                this.f8271h = h();
                                this.f8270g = true;
                                Unit unit2 = Unit.f139807a;
                            } finally {
                            }
                        }
                        NestedPrefetchController nestedPrefetchController = this.f8271h;
                        if (nestedPrefetchController != null ? nestedPrefetchController.a(prefetchRequestScope) : false) {
                            return true;
                        }
                        j();
                    }
                    if (!this.f8268e && !Constraints.p(this.f8265b)) {
                        if (!i(this.f8273j, this.f8266c.c(objF))) {
                            return true;
                        }
                        Trace.beginSection("compose:lazy:prefetch:measure");
                        try {
                            f(this.f8265b);
                            Unit unit3 = Unit.f139807a;
                            Trace.endSection();
                            j();
                            this.f8266c.e(objF, this.f8274k);
                        } finally {
                        }
                    }
                }
            }
            return false;
        }

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchHandle
        public void cancel() {
            if (this.f8269f) {
                return;
            }
            this.f8269f = true;
            SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = this.f8267d;
            if (precomposedSlotHandle != null) {
                precomposedSlotHandle.dispose();
            }
            this.f8267d = null;
        }

        public String toString() {
            return "HandleAndRequestImpl { index = " + this.f8264a + ", constraints = " + ((Object) Constraints.q(this.f8265b)) + ", isComposed = " + d() + ", isMeasured = " + this.f8268e + ", isCanceled = " + this.f8269f + " }";
        }

        private HandleAndRequestImpl(int i3, long j3, PrefetchMetrics prefetchMetrics) {
            this.f8264a = i3;
            this.f8265b = j3;
            this.f8266c = prefetchMetrics;
            this.f8275l = TimeSource.Monotonic.f140667a.a();
        }
    }

    public PrefetchHandleProvider(LazyLayoutItemContentFactory lazyLayoutItemContentFactory, SubcomposeLayoutState subcomposeLayoutState, PrefetchScheduler prefetchScheduler) {
        this.f8261a = lazyLayoutItemContentFactory;
        this.f8262b = subcomposeLayoutState;
        this.f8263c = prefetchScheduler;
    }

    public final PrefetchRequest c(int i3, long j3, PrefetchMetrics prefetchMetrics) {
        return new HandleAndRequestImpl(this, i3, j3, prefetchMetrics, null);
    }

    public final LazyLayoutPrefetchState.PrefetchHandle d(int i3, long j3, PrefetchMetrics prefetchMetrics) {
        HandleAndRequestImpl handleAndRequestImpl = new HandleAndRequestImpl(this, i3, j3, prefetchMetrics, null);
        this.f8263c.a(handleAndRequestImpl);
        return handleAndRequestImpl;
    }
}
