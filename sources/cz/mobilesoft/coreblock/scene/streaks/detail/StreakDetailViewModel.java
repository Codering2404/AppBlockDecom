package cz.mobilesoft.coreblock.scene.streaks.detail;

import android.app.Application;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.scene.streaks.StreakDates;
import cz.mobilesoft.coreblock.scene.streaks.StreakDay;
import cz.mobilesoft.coreblock.scene.streaks.StreakDayStatus;
import cz.mobilesoft.coreblock.scene.streaks.StreakLine;
import cz.mobilesoft.coreblock.scene.streaks.StreakState;
import cz.mobilesoft.coreblock.scene.streaks.StreakStats;
import cz.mobilesoft.coreblock.scene.streaks.StreakStore;
import cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailViewEvent;
import cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailViewState;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
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
public final class StreakDetailViewModel extends BaseStatefulViewModel<StreakDetailViewState, StreakDetailViewEvent, StreakDetailViewCommand> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final Companion f120692r = new Companion(null);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f120693s = 8;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f120694o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f120695p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final DateTimeFormatter f120696q;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailViewModel$1", f = "StreakDetailViewModel.kt", l = {42}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f120697a;

        AnonymousClass1(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return StreakDetailViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f120697a;
            if (i3 == 0) {
                ResultKt.b(obj);
                StreakStore streakStoreD1 = StreakDetailViewModel.this.d1();
                this.f120697a = 1;
                if (StreakStore.n(streakStoreD1, 0L, null, this, 3, null) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailViewModel$2", f = "StreakDetailViewModel.kt", l = {46}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f120699a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailViewModel$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ StreakDetailViewModel f120701a;

            AnonymousClass1(StreakDetailViewModel streakDetailViewModel) {
                this.f120701a = streakDetailViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final StreakDetailViewState f(StreakDetailViewModel streakDetailViewModel, StreakState streakState, boolean z2, StreakDetailViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return streakDetailViewModel.j1(updateState, streakState, z2);
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(final cz.mobilesoft.coreblock.scene.streaks.StreakState r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailViewModel$2$1$emit$1
                    if (r0 == 0) goto L13
                    r0 = r6
                    cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailViewModel$2$1$emit$1 r0 = (cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailViewModel$2$1$emit$1) r0
                    int r1 = r0.f120705d
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f120705d = r1
                    goto L18
                L13:
                    cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailViewModel$2$1$emit$1 r0 = new cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailViewModel$2$1$emit$1
                    r0.<init>(r4, r6)
                L18:
                    java.lang.Object r6 = r0.f120703b
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                    int r2 = r0.f120705d
                    r3 = 1
                    if (r2 == 0) goto L35
                    if (r2 != r3) goto L2d
                    java.lang.Object r5 = r0.f120702a
                    cz.mobilesoft.coreblock.scene.streaks.StreakState r5 = (cz.mobilesoft.coreblock.scene.streaks.StreakState) r5
                    kotlin.ResultKt.b(r6)
                    goto L4a
                L2d:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L35:
                    kotlin.ResultKt.b(r6)
                    cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailViewModel r6 = r4.f120701a
                    cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r6 = cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailViewModel.U0(r6)
                    r0.f120702a = r5
                    r0.f120705d = r3
                    r2 = 0
                    java.lang.Object r6 = r6.s0(r2, r2, r0)
                    if (r6 != r1) goto L4a
                    return r1
                L4a:
                    java.util.Collection r6 = (java.util.Collection) r6
                    boolean r6 = r6.isEmpty()
                    r6 = r6 ^ r3
                    cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailViewModel r0 = r4.f120701a
                    cz.mobilesoft.coreblock.scene.streaks.detail.z0 r1 = new cz.mobilesoft.coreblock.scene.streaks.detail.z0
                    r1.<init>()
                    cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailViewModel.Y0(r0, r1)
                    kotlin.Unit r5 = kotlin.Unit.f139807a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailViewModel.AnonymousClass2.AnonymousClass1.emit(cz.mobilesoft.coreblock.scene.streaks.StreakState, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        AnonymousClass2(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return StreakDetailViewModel.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f120699a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowG = StreakDetailViewModel.this.d1().g();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(StreakDetailViewModel.this);
                this.f120699a = 1;
                if (flowG.collect(anonymousClass1, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class EntriesMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f120706a = EnumEntriesKt.a(DayOfWeek.values());
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f120707a;

        static {
            int[] iArr = new int[StreakDayStatus.values().length];
            try {
                iArr[StreakDayStatus.OBTAINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StreakDayStatus.REST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StreakDayStatus.LOST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[StreakDayStatus.INACTIVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f120707a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StreakDetailViewModel(Application application) {
        super(application, new StreakDetailViewState(false, null, null, null, 0, null, false, 127, null));
        Intrinsics.checkNotNullParameter(application, "application");
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f120694o = LazyKt.a(lazyThreadSafetyModeB, new Function0<StreakStore>() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StreakStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f120695p = LazyKt.a(lazyThreadSafetyModeB2, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ProfileDao.class), objArr2, objArr3);
            }
        });
        DateTimeFormatter dateTimeFormatterOfPattern = DateTimeFormatter.ofPattern("LLLL yyyy", Locale.getDefault());
        Intrinsics.checkNotNullExpressionValue(dateTimeFormatterOfPattern, "ofPattern(...)");
        this.f120696q = dateTimeFormatterOfPattern;
        G0(new AnonymousClass1(null));
        G0(new AnonymousClass2(null));
    }

    private final Set Z0(List list, StreakLine streakLine, LocalDate localDate, boolean z2) {
        Set set;
        if (streakLine == null) {
            set = SetsKt.emptySet();
        } else {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                StreakDay streakDay = (StreakDay) obj;
                if (streakDay.a().compareTo(streakLine.c()) >= 0 && streakDay.a().compareTo(streakLine.a()) <= 0 && (streakDay.b() == StreakDayStatus.OBTAINED || streakDay.b() == StreakDayStatus.REST)) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj2 = arrayList.get(i3);
                i3++;
                arrayList2.add(((StreakDay) obj2).a());
            }
            set = CollectionsKt.toSet(arrayList2);
        }
        return z2 ? set : SetsKt.plus((Set<? extends String>) set, StreakDates.f120261a.c(localDate));
    }

    private final List a1(YearMonth yearMonth, LocalDate localDate, Map map, Set set, boolean z2) {
        IntRange intRangeB = RangesKt.B(0, yearMonth.atDay(1).getDayOfWeek().getValue() - DayOfWeek.MONDAY.getValue());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeB, 10));
        Iterator<Integer> it = intRangeB.iterator();
        while (it.hasNext()) {
            arrayList.add(StreakDetailViewState.DayCell.f120725f.a(((IntIterator) it).nextInt()));
        }
        IntRange intRange = new IntRange(1, yearMonth.lengthOfMonth());
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
        Iterator<Integer> it2 = intRange.iterator();
        while (it2.hasNext()) {
            LocalDate localDateAtDay = yearMonth.atDay(((IntIterator) it2).nextInt());
            StreakDates streakDates = StreakDates.f120261a;
            Intrinsics.checkNotNull(localDateAtDay);
            String strC = streakDates.c(localDateAtDay);
            StreakDay streakDay = (StreakDay) map.get(strC);
            boolean zAreEqual = Intrinsics.areEqual(localDateAtDay, localDate);
            boolean zContains = set.contains(strC);
            arrayList2.add(new StreakDetailViewState.DayCell(strC, localDateAtDay, zAreEqual ? z2 ? StreakDetailViewState.DisplayStatus.TodayLost : StreakDetailViewState.DisplayStatus.TodayPossible : streakDay != null ? b1(streakDay.b(), zContains) : localDateAtDay.isAfter(localDate) ? StreakDetailViewState.DisplayStatus.Future : StreakDetailViewState.DisplayStatus.Missing, zAreEqual, zContains));
        }
        return CollectionsKt.plus((Collection) arrayList, (Iterable) arrayList2);
    }

    private final StreakDetailViewState.DisplayStatus b1(StreakDayStatus streakDayStatus, boolean z2) {
        int i3 = WhenMappings.f120707a[streakDayStatus.ordinal()];
        if (i3 == 1) {
            return StreakDetailViewState.DisplayStatus.Obtained;
        }
        if (i3 == 2) {
            return z2 ? StreakDetailViewState.DisplayStatus.Rest : StreakDetailViewState.DisplayStatus.Inactive;
        }
        if (i3 == 3 || i3 == 4) {
            return StreakDetailViewState.DisplayStatus.Inactive;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileDao c1() {
        return (ProfileDao) this.f120695p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StreakStore d1() {
        return (StreakStore) this.f120694o.getValue();
    }

    private final List e1(LocalDate localDate) {
        YearMonth yearMonthFrom = YearMonth.from(localDate);
        IntProgression intProgressionV = RangesKt.v(11, 0);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intProgressionV, 10));
        Iterator<Integer> it = intProgressionV.iterator();
        while (it.hasNext()) {
            arrayList.add(yearMonthFrom.minusMonths(((IntIterator) it).nextInt()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StreakDetailViewState g1(StreakDetailViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return updateState.c() ? StreakDetailViewState.b(updateState, false, null, null, null, updateState.g() - 1, null, false, 111, null) : updateState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StreakDetailViewState h1(StreakDetailViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return updateState.d() ? StreakDetailViewState.b(updateState, false, null, null, null, updateState.g() + 1, null, false, 111, null) : updateState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StreakDetailViewState i1(StreakDetailViewEvent streakDetailViewEvent, StreakDetailViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return StreakDetailViewState.b(updateState, false, null, null, null, RangesKt.p(((StreakDetailViewEvent.OnMonthSelected) streakDetailViewEvent).a(), 0, RangesKt.f(CollectionsKt.getLastIndex(updateState.e()), 0)), null, false, 111, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StreakDetailViewState j1(StreakDetailViewState streakDetailViewState, StreakState streakState, boolean z2) {
        LocalDate localDateG = StreakDates.g(StreakDates.f120261a, TimeHelperExt.f128663a.f(), null, 2, null);
        StreakLine streakLineA = streakState.a();
        boolean zF = streakState.f();
        Set setZ0 = Z0(streakState.b(), streakLineA, localDateG, zF);
        List<YearMonth> listE1 = e1(localDateG);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listE1, 10));
        for (YearMonth yearMonth : listE1) {
            String string = yearMonth.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            String str = yearMonth.atDay(1).format(this.f120696q);
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            List listB = streakState.b();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listB, 10)), 16));
            for (Object obj : listB) {
                linkedHashMap.put(((StreakDay) obj).a(), obj);
            }
            arrayList.add(new StreakDetailViewState.MonthPage(string, str, a1(yearMonth, localDateG, linkedHashMap, setZ0, zF)));
        }
        StreakDetailViewState.SummaryState active = streakLineA != null ? new StreakDetailViewState.SummaryState.Active(streakLineA.b()) : streakState.c().isEmpty() ? StreakDetailViewState.SummaryState.NeverStarted.f120737a : StreakDetailViewState.SummaryState.InactiveHistory.f120736a;
        return streakDetailViewState.a(false, active, new StreakStats(streakState.d().b(), streakState.d().a(), streakState.d().c()), arrayList, streakDetailViewState.e().isEmpty() ? RangesKt.f(CollectionsKt.getLastIndex(arrayList), 0) : RangesKt.p(streakDetailViewState.g(), 0, RangesKt.f(CollectionsKt.getLastIndex(arrayList), 0)), k1(), (active instanceof StreakDetailViewState.SummaryState.NeverStarted) && !z2);
    }

    private final List k1() {
        EnumEntries enumEntries = EntriesMappings.f120706a;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(enumEntries, 10));
        Iterator<E> it = enumEntries.iterator();
        while (it.hasNext()) {
            arrayList.add(((DayOfWeek) it.next()).getDisplayName(TextStyle.NARROW_STANDALONE, Locale.getDefault()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: f1, reason: merged with bridge method [inline-methods] */
    public void O0(final StreakDetailViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, StreakDetailViewEvent.OnPreviousMonthClicked.f120691a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.w0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StreakDetailViewModel.g1((StreakDetailViewState) obj);
                }
            });
            return;
        }
        if (Intrinsics.areEqual(event, StreakDetailViewEvent.OnNextMonthClicked.f120690a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.x0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StreakDetailViewModel.h1((StreakDetailViewState) obj);
                }
            });
            return;
        }
        if (event instanceof StreakDetailViewEvent.OnMonthSelected) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.y0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StreakDetailViewModel.i1(event, (StreakDetailViewState) obj);
                }
            });
        } else if (Intrinsics.areEqual(event, StreakDetailViewEvent.OnBetaBadgeClicked.f120687a)) {
            G0(new StreakDetailViewModel$onEvent$4(this, null));
        } else {
            if (!Intrinsics.areEqual(event, StreakDetailViewEvent.OnCreateBlockingClicked.f120688a)) {
                throw new NoWhenBranchMatchedException();
            }
            G0(new StreakDetailViewModel$onEvent$5(this, null));
        }
    }
}
