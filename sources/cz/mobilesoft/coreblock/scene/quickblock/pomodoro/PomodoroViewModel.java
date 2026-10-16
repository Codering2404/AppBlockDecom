package cz.mobilesoft.coreblock.scene.quickblock.pomodoro;

import android.app.Application;
import android.os.Parcel;
import android.os.Parcelable;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.repository.QuickBlockRepository;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.email_consent.ConsentHelper;
import cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroViewEvent;
import cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroViewModel;
import cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroViewState;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.SessionDataStore;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.PomodoroSessionDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao;
import cz.mobilesoft.coreblock.storage.room.entity.core.PomodoroHistory;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PomodoroViewModel extends BaseStatefulViewModel<PomodoroViewState, PomodoroViewEvent, PomodoroViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f114068o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f114069p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f114070q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f114071r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Lazy f114072s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Lazy f114073t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Lazy f114074u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Lazy f114075v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f114076w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long f114077x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f114078y;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroViewModel$1", f = "PomodoroViewModel.kt", l = {49}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f114079a;

        AnonymousClass1(Continuation continuation) {
            super(1, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final PomodoroViewState q(PomodoroHistory pomodoroHistory, List list, PomodoroViewState pomodoroViewState) {
            return PomodoroViewState.b(pomodoroViewState, 0L, new PomodoroViewState.PomodoroConfiguration.Focus(pomodoroHistory.d()), new PomodoroViewState.PomodoroConfiguration.Break(pomodoroHistory.c()), new PomodoroViewState.PomodoroConfiguration.Sessions(pomodoroHistory.f()), list, 1, null);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return PomodoroViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f114079a;
            if (i3 == 0) {
                ResultKt.b(obj);
                PomodoroHistoryDao pomodoroHistoryDaoI1 = PomodoroViewModel.this.i1();
                this.f114079a = 1;
                obj = pomodoroHistoryDaoI1.Q(this);
                if (obj == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            PomodoroViewModel pomodoroViewModel = PomodoroViewModel.this;
            final List list = (List) obj;
            if (!list.isEmpty()) {
                final PomodoroHistory pomodoroHistory = (PomodoroHistory) CollectionsKt.first(list);
                pomodoroViewModel.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.f0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return PomodoroViewModel.AnonymousClass1.q(pomodoroHistory, list, (PomodoroViewState) obj2);
                    }
                });
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PomodoroDto implements Parcelable {
        public static final Parcelable.Creator<PomodoroDto> CREATOR = new Creator();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f114081d = 8;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f114082a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f114083b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f114084c;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Creator implements Parcelable.Creator<PomodoroDto> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final PomodoroDto createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new PomodoroDto(parcel.readLong(), parcel.readLong(), parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final PomodoroDto[] newArray(int i3) {
                return new PomodoroDto[i3];
            }
        }

        public PomodoroDto(long j3, long j4, int i3) {
            this.f114082a = j3;
            this.f114083b = j4;
            this.f114084c = i3;
        }

        public final long c() {
            return this.f114083b;
        }

        public final long d() {
            return this.f114082a;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final int e() {
            return this.f114084c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PomodoroDto)) {
                return false;
            }
            PomodoroDto pomodoroDto = (PomodoroDto) obj;
            return this.f114082a == pomodoroDto.f114082a && this.f114083b == pomodoroDto.f114083b && this.f114084c == pomodoroDto.f114084c;
        }

        public int hashCode() {
            return (((Long.hashCode(this.f114082a) * 31) + Long.hashCode(this.f114083b)) * 31) + Integer.hashCode(this.f114084c);
        }

        public String toString() {
            return "PomodoroDto(focusTime=" + this.f114082a + ", breakTime=" + this.f114083b + ", sessions=" + this.f114084c + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int i3) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeLong(this.f114082a);
            dest.writeLong(this.f114083b);
            dest.writeInt(this.f114084c);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PomodoroViewModel(Application application) {
        super(application, new PomodoroViewState(0L, null, null, null, null, 31, null));
        Intrinsics.checkNotNullParameter(application, "application");
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f114068o = LazyKt.a(lazyThreadSafetyModeB, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeRepository.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f114069p = LazyKt.a(lazyThreadSafetyModeB2, new Function0<PomodoroHistoryDao>() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PomodoroHistoryDao.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f114070q = LazyKt.a(lazyThreadSafetyModeB3, new Function0<PomodoroSessionDao>() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroViewModel$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PomodoroSessionDao.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f114071r = LazyKt.a(lazyThreadSafetyModeB4, new Function0<QuickBlockRepository>() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroViewModel$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(QuickBlockRepository.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        this.f114072s = LazyKt.a(lazyThreadSafetyModeB5, new Function0<DevDataStore>() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroViewModel$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DevDataStore.class), objArr8, objArr9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB6 = koinPlatformTools.b();
        final Object[] objArr10 = 0 == true ? 1 : 0;
        final Object[] objArr11 = 0 == true ? 1 : 0;
        this.f114073t = LazyKt.a(lazyThreadSafetyModeB6, new Function0<SessionDataStore>() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroViewModel$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(SessionDataStore.class), objArr10, objArr11);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB7 = koinPlatformTools.b();
        final Object[] objArr12 = 0 == true ? 1 : 0;
        final Object[] objArr13 = 0 == true ? 1 : 0;
        this.f114074u = LazyKt.a(lazyThreadSafetyModeB7, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroViewModel$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), objArr12, objArr13);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB8 = koinPlatformTools.b();
        final Object[] objArr14 = 0 == true ? 1 : 0;
        final Object[] objArr15 = 0 == true ? 1 : 0;
        this.f114075v = LazyKt.a(lazyThreadSafetyModeB8, new Function0<ConsentHelper>() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroViewModel$special$$inlined$inject$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ConsentHelper.class), objArr14, objArr15);
            }
        });
        G0(new AnonymousClass1(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d1(kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroViewModel.d1(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void e1(long j3, long j4, int i3) {
        G0(new PomodoroViewModel$checkPermissionsOrStart$1(this, j3, j4, i3, null));
    }

    private final void f1(long j3, long j4, int i3) {
        if (!l1()) {
            e1(j3, j4, i3);
            return;
        }
        this.f114076w = j3;
        this.f114077x = j4;
        this.f114078y = i3;
        G0(new PomodoroViewModel$checkStrictMode$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConsentHelper g1() {
        return (ConsentHelper) this.f114075v.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DevDataStore h1() {
        return (DevDataStore) this.f114072s.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PomodoroHistoryDao i1() {
        return (PomodoroHistoryDao) this.f114069p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PomodoroSessionDao j1() {
        return (PomodoroSessionDao) this.f114070q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QuickBlockRepository k1() {
        return (QuickBlockRepository) this.f114071r.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PomodoroViewState n1(PomodoroViewEvent pomodoroViewEvent, PomodoroViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return PomodoroViewState.b(updateState, 0L, null, null, updateState.g().c(((PomodoroViewEvent.SetPomodoroSessions) pomodoroViewEvent).a()), null, 23, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PomodoroViewState o1(PomodoroViewEvent pomodoroViewEvent, PomodoroViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return PomodoroViewState.b(updateState, 0L, updateState.e().c(((PomodoroViewEvent.SetPomodoroFocus) pomodoroViewEvent).a()), null, null, null, 29, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PomodoroViewState p1(PomodoroViewEvent pomodoroViewEvent, PomodoroViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return PomodoroViewState.b(updateState, 0L, null, updateState.d().c(((PomodoroViewEvent.SetPomodoroBreak) pomodoroViewEvent).a()), null, null, 27, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q1(long j3, long j4, int i3) {
        G0(new PomodoroViewModel$startPomodoro$1(this, j3, j4, i3, null));
    }

    private final StrictModeRepository t0() {
        return (StrictModeRepository) this.f114068o.getValue();
    }

    public final boolean l1() {
        return t0().n();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: m1, reason: merged with bridge method [inline-methods] */
    public void O0(final PomodoroViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof PomodoroViewEvent.SetPomodoroSessions) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.c0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PomodoroViewModel.n1(event, (PomodoroViewState) obj);
                }
            });
            return;
        }
        if (event instanceof PomodoroViewEvent.SetPomodoroFocus) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.d0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PomodoroViewModel.o1(event, (PomodoroViewState) obj);
                }
            });
            return;
        }
        if (event instanceof PomodoroViewEvent.SetPomodoroBreak) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.e0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PomodoroViewModel.p1(event, (PomodoroViewState) obj);
                }
            });
            return;
        }
        if (Intrinsics.areEqual(event, PomodoroViewEvent.StartPomodoro.f114067a)) {
            PomodoroViewState pomodoroViewState = (PomodoroViewState) I0();
            f1(pomodoroViewState.e().d(), pomodoroViewState.d().d(), pomodoroViewState.g().d());
            return;
        }
        if (event instanceof PomodoroViewEvent.OnHistorySelected) {
            PomodoroViewEvent.OnHistorySelected onHistorySelected = (PomodoroViewEvent.OnHistorySelected) event;
            f1(onHistorySelected.a().d(), onHistorySelected.a().c(), onHistorySelected.a().f());
        } else if (Intrinsics.areEqual(event, PomodoroViewEvent.OnStrictModeConfirmedClicked.f114063a)) {
            e1(this.f114076w, this.f114077x, this.f114078y);
        } else {
            if (!(event instanceof PomodoroViewEvent.OnPermissionsGranted)) {
                throw new NoWhenBranchMatchedException();
            }
            PomodoroViewEvent.OnPermissionsGranted onPermissionsGranted = (PomodoroViewEvent.OnPermissionsGranted) event;
            q1(onPermissionsGranted.a().d(), onPermissionsGranted.a().c(), onPermissionsGranted.a().e());
        }
    }
}
