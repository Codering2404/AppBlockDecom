package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
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
public abstract class Lifecycle {
    private AtomicReference<Object> internalScopeRef = new AtomicReference<>(null);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Event {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Event[] $VALUES;
        public static final Companion Companion;
        public static final Event ON_CREATE = new Event("ON_CREATE", 0);
        public static final Event ON_START = new Event("ON_START", 1);
        public static final Event ON_RESUME = new Event("ON_RESUME", 2);
        public static final Event ON_PAUSE = new Event("ON_PAUSE", 3);
        public static final Event ON_STOP = new Event("ON_STOP", 4);
        public static final Event ON_DESTROY = new Event("ON_DESTROY", 5);
        public static final Event ON_ANY = new Event("ON_ANY", 6);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public /* synthetic */ class WhenMappings {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f39945a;

                static {
                    int[] iArr = new int[State.values().length];
                    try {
                        iArr[State.f39949c.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[State.f39950d.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[State.f39951f.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[State.f39947a.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[State.f39948b.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    f39945a = iArr;
                }
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Event a(State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                int i3 = WhenMappings.f39945a[state.ordinal()];
                if (i3 == 1) {
                    return Event.ON_DESTROY;
                }
                if (i3 == 2) {
                    return Event.ON_STOP;
                }
                if (i3 != 3) {
                    return null;
                }
                return Event.ON_PAUSE;
            }

            public final Event b(State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                int i3 = WhenMappings.f39945a[state.ordinal()];
                if (i3 == 1) {
                    return Event.ON_START;
                }
                if (i3 == 2) {
                    return Event.ON_RESUME;
                }
                if (i3 != 5) {
                    return null;
                }
                return Event.ON_CREATE;
            }

            public final Event c(State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                int i3 = WhenMappings.f39945a[state.ordinal()];
                if (i3 == 1) {
                    return Event.ON_CREATE;
                }
                if (i3 == 2) {
                    return Event.ON_START;
                }
                if (i3 != 3) {
                    return null;
                }
                return Event.ON_RESUME;
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public /* synthetic */ class WhenMappings {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f39946a;

            static {
                int[] iArr = new int[Event.values().length];
                try {
                    iArr[Event.ON_CREATE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Event.ON_STOP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Event.ON_START.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Event.ON_PAUSE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[Event.ON_RESUME.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[Event.ON_DESTROY.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[Event.ON_ANY.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                f39946a = iArr;
            }
        }

        static {
            Event[] eventArrA = a();
            $VALUES = eventArrA;
            $ENTRIES = EnumEntriesKt.a(eventArrA);
            Companion = new Companion(null);
        }

        private Event(String str, int i3) {
        }

        private static final /* synthetic */ Event[] a() {
            return new Event[]{ON_CREATE, ON_START, ON_RESUME, ON_PAUSE, ON_STOP, ON_DESTROY, ON_ANY};
        }

        public static final Event b(State state) {
            return Companion.a(state);
        }

        public static final Event d(State state) {
            return Companion.c(state);
        }

        public static Event valueOf(String str) {
            return (Event) Enum.valueOf(Event.class, str);
        }

        public static Event[] values() {
            return (Event[]) $VALUES.clone();
        }

        public final State c() {
            switch (WhenMappings.f39946a[ordinal()]) {
                case 1:
                case 2:
                    return State.f39949c;
                case 3:
                case 4:
                    return State.f39950d;
                case 5:
                    return State.f39951f;
                case 6:
                    return State.f39947a;
                case 7:
                    throw new IllegalArgumentException(this + " has no target state");
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class State {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final State f39947a = new State("DESTROYED", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final State f39948b = new State("INITIALIZED", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final State f39949c = new State("CREATED", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final State f39950d = new State("STARTED", 3);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final State f39951f = new State("RESUMED", 4);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final /* synthetic */ State[] f39952g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final /* synthetic */ EnumEntries f39953h;

        static {
            State[] stateArrA = a();
            f39952g = stateArrA;
            f39953h = EnumEntriesKt.a(stateArrA);
        }

        private State(String str, int i3) {
        }

        private static final /* synthetic */ State[] a() {
            return new State[]{f39947a, f39948b, f39949c, f39950d, f39951f};
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) f39952g.clone();
        }

        public final boolean b(State state) {
            Intrinsics.checkNotNullParameter(state, "state");
            return compareTo(state) >= 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(MutableStateFlow mutableStateFlow, LifecycleOwner lifecycleOwner, Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        mutableStateFlow.setValue(event.c());
    }

    public abstract void addObserver(LifecycleObserver lifecycleObserver);

    public abstract State getCurrentState();

    public StateFlow<State> getCurrentStateFlow() {
        final MutableStateFlow mutableStateFlowA = StateFlowKt.a(getCurrentState());
        addObserver(new LifecycleEventObserver() { // from class: androidx.lifecycle.e
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void j(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                Lifecycle.b(mutableStateFlowA, lifecycleOwner, event);
            }
        });
        return FlowKt.c(mutableStateFlowA);
    }

    public final AtomicReference<Object> getInternalScopeRef() {
        return this.internalScopeRef;
    }

    public abstract void removeObserver(LifecycleObserver lifecycleObserver);

    public final void setInternalScopeRef(AtomicReference<Object> atomicReference) {
        Intrinsics.checkNotNullParameter(atomicReference, "<set-?>");
        this.internalScopeRef = atomicReference;
    }
}
