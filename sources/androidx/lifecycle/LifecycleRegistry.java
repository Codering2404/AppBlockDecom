package androidx.lifecycle;

import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

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
public class LifecycleRegistry extends Lifecycle {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Companion f39977j = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f39978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private FastSafeIterableMap f39979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Lifecycle.State f39980c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final WeakReference f39981d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f39982e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f39983f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f39984g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ArrayList f39985h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MutableStateFlow f39986i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Lifecycle.State a(Lifecycle.State state1, Lifecycle.State state) {
            Intrinsics.checkNotNullParameter(state1, "state1");
            return (state == null || state.compareTo(state1) >= 0) ? state1 : state;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ObserverWithState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Lifecycle.State f39987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private LifecycleEventObserver f39988b;

        public ObserverWithState(LifecycleObserver lifecycleObserver, Lifecycle.State initialState) {
            Intrinsics.checkNotNullParameter(initialState, "initialState");
            Intrinsics.checkNotNull(lifecycleObserver);
            this.f39988b = Lifecycling.f(lifecycleObserver);
            this.f39987a = initialState;
        }

        public final void a(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            Intrinsics.checkNotNullParameter(event, "event");
            Lifecycle.State stateC = event.c();
            this.f39987a = LifecycleRegistry.f39977j.a(this.f39987a, stateC);
            LifecycleEventObserver lifecycleEventObserver = this.f39988b;
            Intrinsics.checkNotNull(lifecycleOwner);
            lifecycleEventObserver.j(lifecycleOwner, event);
            this.f39987a = stateC;
        }

        public final Lifecycle.State b() {
            return this.f39987a;
        }
    }

    private LifecycleRegistry(LifecycleOwner lifecycleOwner, boolean z2) {
        this.f39978a = z2;
        this.f39979b = new FastSafeIterableMap();
        Lifecycle.State state = Lifecycle.State.f39948b;
        this.f39980c = state;
        this.f39985h = new ArrayList();
        this.f39981d = new WeakReference(lifecycleOwner);
        this.f39986i = StateFlowKt.a(state);
    }

    private final void c(LifecycleOwner lifecycleOwner) {
        Iterator itDescendingIterator = this.f39979b.descendingIterator();
        Intrinsics.checkNotNullExpressionValue(itDescendingIterator, "descendingIterator(...)");
        while (itDescendingIterator.hasNext() && !this.f39984g) {
            Map.Entry entry = (Map.Entry) itDescendingIterator.next();
            Intrinsics.checkNotNull(entry);
            LifecycleObserver lifecycleObserver = (LifecycleObserver) entry.getKey();
            ObserverWithState observerWithState = (ObserverWithState) entry.getValue();
            while (observerWithState.b().compareTo(this.f39980c) > 0 && !this.f39984g && this.f39979b.contains(lifecycleObserver)) {
                Lifecycle.Event eventA = Lifecycle.Event.Companion.a(observerWithState.b());
                if (eventA == null) {
                    throw new IllegalStateException("no event down from " + observerWithState.b());
                }
                k(eventA.c());
                observerWithState.a(lifecycleOwner, eventA);
                j();
            }
        }
    }

    private final Lifecycle.State d(LifecycleObserver lifecycleObserver) {
        ObserverWithState observerWithState;
        Map.Entry entryL = this.f39979b.l(lifecycleObserver);
        Lifecycle.State state = null;
        Lifecycle.State stateB = (entryL == null || (observerWithState = (ObserverWithState) entryL.getValue()) == null) ? null : observerWithState.b();
        if (!this.f39985h.isEmpty()) {
            state = (Lifecycle.State) this.f39985h.get(r0.size() - 1);
        }
        Companion companion = f39977j;
        return companion.a(companion.a(this.f39980c, stateB), state);
    }

    private final void e(String str) {
        if (!this.f39978a || LifecycleRegistry_androidKt.a()) {
            return;
        }
        throw new IllegalStateException(("Method " + str + " must be called on the main thread").toString());
    }

    private final void f(LifecycleOwner lifecycleOwner) {
        SafeIterableMap.IteratorWithAdditions iteratorWithAdditionsD = this.f39979b.d();
        Intrinsics.checkNotNullExpressionValue(iteratorWithAdditionsD, "iteratorWithAdditions(...)");
        while (iteratorWithAdditionsD.hasNext() && !this.f39984g) {
            Map.Entry next = iteratorWithAdditionsD.next();
            LifecycleObserver lifecycleObserver = (LifecycleObserver) next.getKey();
            ObserverWithState observerWithState = (ObserverWithState) next.getValue();
            while (observerWithState.b().compareTo(this.f39980c) < 0 && !this.f39984g && this.f39979b.contains(lifecycleObserver)) {
                k(observerWithState.b());
                Lifecycle.Event eventB = Lifecycle.Event.Companion.b(observerWithState.b());
                if (eventB == null) {
                    throw new IllegalStateException("no event up from " + observerWithState.b());
                }
                observerWithState.a(lifecycleOwner, eventB);
                j();
            }
        }
    }

    private final boolean h() {
        if (this.f39979b.size() == 0) {
            return true;
        }
        Map.Entry entryA = this.f39979b.a();
        Intrinsics.checkNotNull(entryA);
        Lifecycle.State stateB = ((ObserverWithState) entryA.getValue()).b();
        Map.Entry entryE = this.f39979b.e();
        Intrinsics.checkNotNull(entryE);
        Lifecycle.State stateB2 = ((ObserverWithState) entryE.getValue()).b();
        return stateB == stateB2 && this.f39980c == stateB2;
    }

    private final void i(Lifecycle.State state) {
        if (this.f39980c == state) {
            return;
        }
        LifecycleRegistryKt.a((LifecycleOwner) this.f39981d.get(), this.f39980c, state);
        this.f39980c = state;
        if (this.f39983f || this.f39982e != 0) {
            this.f39984g = true;
            return;
        }
        this.f39983f = true;
        m();
        this.f39983f = false;
        if (this.f39980c == Lifecycle.State.f39947a) {
            this.f39979b = new FastSafeIterableMap();
        }
    }

    private final void j() {
        this.f39985h.remove(r0.size() - 1);
    }

    private final void k(Lifecycle.State state) {
        this.f39985h.add(state);
    }

    private final void m() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this.f39981d.get();
        if (lifecycleOwner == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
        }
        while (!h()) {
            this.f39984g = false;
            Lifecycle.State state = this.f39980c;
            Map.Entry entryA = this.f39979b.a();
            Intrinsics.checkNotNull(entryA);
            if (state.compareTo(((ObserverWithState) entryA.getValue()).b()) < 0) {
                c(lifecycleOwner);
            }
            Map.Entry entryE = this.f39979b.e();
            if (!this.f39984g && entryE != null && this.f39980c.compareTo(((ObserverWithState) entryE.getValue()).b()) > 0) {
                f(lifecycleOwner);
            }
        }
        this.f39984g = false;
        this.f39986i.setValue(getCurrentState());
    }

    @Override // androidx.lifecycle.Lifecycle
    public void addObserver(LifecycleObserver observer) {
        LifecycleOwner lifecycleOwner;
        Intrinsics.checkNotNullParameter(observer, "observer");
        e("addObserver");
        Lifecycle.State state = this.f39980c;
        Lifecycle.State state2 = Lifecycle.State.f39947a;
        if (state != state2) {
            state2 = Lifecycle.State.f39948b;
        }
        ObserverWithState observerWithState = new ObserverWithState(observer, state2);
        if (((ObserverWithState) this.f39979b.g(observer, observerWithState)) == null && (lifecycleOwner = (LifecycleOwner) this.f39981d.get()) != null) {
            boolean z2 = this.f39982e != 0 || this.f39983f;
            Lifecycle.State stateD = d(observer);
            this.f39982e++;
            while (observerWithState.b().compareTo(stateD) < 0 && this.f39979b.contains(observer)) {
                k(observerWithState.b());
                Lifecycle.Event eventB = Lifecycle.Event.Companion.b(observerWithState.b());
                if (eventB == null) {
                    throw new IllegalStateException("no event up from " + observerWithState.b());
                }
                observerWithState.a(lifecycleOwner, eventB);
                j();
                stateD = d(observer);
            }
            if (!z2) {
                m();
            }
            this.f39982e--;
        }
    }

    public void g(Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        e("handleLifecycleEvent");
        i(event.c());
    }

    @Override // androidx.lifecycle.Lifecycle
    public Lifecycle.State getCurrentState() {
        return this.f39980c;
    }

    @Override // androidx.lifecycle.Lifecycle
    public StateFlow getCurrentStateFlow() {
        return FlowKt.c(this.f39986i);
    }

    public void l(Lifecycle.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        e("setCurrentState");
        i(state);
    }

    @Override // androidx.lifecycle.Lifecycle
    public void removeObserver(LifecycleObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        e("removeObserver");
        this.f39979b.h(observer);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LifecycleRegistry(LifecycleOwner provider) {
        this(provider, true);
        Intrinsics.checkNotNullParameter(provider, "provider");
    }
}
