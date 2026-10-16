package cz.mobilesoft.coreblock.scene.streaks.milestone;

import android.app.Application;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.scene.streaks.StreakDates;
import cz.mobilesoft.coreblock.scene.streaks.StreakDay;
import cz.mobilesoft.coreblock.scene.streaks.StreakDayStatus;
import cz.mobilesoft.coreblock.scene.streaks.StreakState;
import cz.mobilesoft.coreblock.scene.streaks.StreakStore;
import cz.mobilesoft.coreblock.scene.streaks.StreakWeekDayStatus;
import cz.mobilesoft.coreblock.scene.streaks.milestone.StreakMilestoneViewModel;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
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
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
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
public final class StreakMilestoneViewModel extends BaseStatefulViewModel<StreakMilestoneViewState, StreakMilestoneViewEvent, StreakMilestoneViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final int f120950o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f120951p;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.streaks.milestone.StreakMilestoneViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.streaks.milestone.StreakMilestoneViewModel$1", f = "StreakMilestoneViewModel.kt", l = {34}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f120952a;

        AnonymousClass1(Continuation continuation) {
            super(1, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final StreakMilestoneViewState q(StreakMilestoneViewModel streakMilestoneViewModel, LocalDate localDate, StreakState streakState, StreakMilestoneViewState streakMilestoneViewState) {
            return streakMilestoneViewState.a(false, streakMilestoneViewState.d(), streakMilestoneViewModel.V0(streakState.b(), localDate), Integer.valueOf(streakMilestoneViewModel.X0(localDate)));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return StreakMilestoneViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            AnonymousClass1 anonymousClass1;
            Object objF = IntrinsicsKt.f();
            int i3 = this.f120952a;
            if (i3 == 0) {
                ResultKt.b(obj);
                StreakStore streakStoreW0 = StreakMilestoneViewModel.this.W0();
                this.f120952a = 1;
                anonymousClass1 = this;
                obj = StreakStore.f(streakStoreW0, 0L, null, anonymousClass1, 3, null);
                if (obj == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                anonymousClass1 = this;
            }
            final StreakState streakState = (StreakState) obj;
            final LocalDate localDateG = StreakDates.g(StreakDates.f120261a, TimeHelperExt.f128663a.f(), null, 2, null);
            final StreakMilestoneViewModel streakMilestoneViewModel = StreakMilestoneViewModel.this;
            streakMilestoneViewModel.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.streaks.milestone.q
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return StreakMilestoneViewModel.AnonymousClass1.q(streakMilestoneViewModel, localDateG, streakState, (StreakMilestoneViewState) obj2);
                }
            });
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class EntriesMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f120954a = EnumEntriesKt.a(DayOfWeek.values());
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f120955a;

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
            f120955a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StreakMilestoneViewModel(Application application, int i3) {
        super(application, new StreakMilestoneViewState(false, i3, null, null, 13, null));
        Intrinsics.checkNotNullParameter(application, "application");
        this.f120950o = i3;
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f120951p = LazyKt.a(lazyThreadSafetyModeB, new Function0<StreakStore>() { // from class: cz.mobilesoft.coreblock.scene.streaks.milestone.StreakMilestoneViewModel$special$$inlined$inject$default$1
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
        AnswersHelper.f128199a.b7();
        G0(new AnonymousClass1(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List V0(List list, LocalDate localDate) {
        StreakWeekDayStatus streakWeekDayStatusY0;
        List list2 = list;
        ArrayList arrayList = new ArrayList();
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            LocalDate localDateH = StreakDates.f120261a.h(((StreakDay) it.next()).a());
            if (localDateH != null) {
                arrayList.add(localDateH);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            if (((LocalDate) obj).isBefore(localDate)) {
                arrayList2.add(obj);
            }
        }
        LocalDate localDateMinusDays = (LocalDate) CollectionsKt.maxOrNull((Iterable) arrayList2);
        if (localDateMinusDays == null) {
            localDateMinusDays = localDate.minusDays(1L);
        }
        LocalDate localDateMinusDays2 = localDateMinusDays.minusDays(localDateMinusDays.getDayOfWeek().getValue() - DayOfWeek.MONDAY.getValue());
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list2, 10)), 16));
        for (Object obj2 : list2) {
            linkedHashMap.put(((StreakDay) obj2).a(), obj2);
        }
        IntRange indices = CollectionsKt.getIndices(EntriesMappings.f120954a);
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(indices, 10));
        Iterator<Integer> it2 = indices.iterator();
        while (it2.hasNext()) {
            LocalDate localDatePlusDays = localDateMinusDays2.plusDays(((IntIterator) it2).nextInt());
            StreakDates streakDates = StreakDates.f120261a;
            Intrinsics.checkNotNull(localDatePlusDays);
            String strC = streakDates.c(localDatePlusDays);
            if (localDatePlusDays.isAfter(localDateMinusDays)) {
                streakWeekDayStatusY0 = StreakWeekDayStatus.Future;
            } else {
                StreakDay streakDay = (StreakDay) linkedHashMap.get(strC);
                streakWeekDayStatusY0 = Y0(streakDay != null ? streakDay.b() : null);
            }
            arrayList3.add(streakWeekDayStatusY0);
        }
        return arrayList3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StreakStore W0() {
        return (StreakStore) this.f120951p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int X0(LocalDate localDate) {
        return localDate.minusDays(1L).getDayOfWeek().getValue() - DayOfWeek.MONDAY.getValue();
    }

    private final StreakWeekDayStatus Y0(StreakDayStatus streakDayStatus) {
        int i3 = streakDayStatus == null ? -1 : WhenMappings.f120955a[streakDayStatus.ordinal()];
        if (i3 != -1) {
            if (i3 == 1) {
                return StreakWeekDayStatus.Obtained;
            }
            if (i3 == 2) {
                return StreakWeekDayStatus.Rest;
            }
            if (i3 == 3) {
                return StreakWeekDayStatus.Lost;
            }
            if (i3 != 4) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return StreakWeekDayStatus.Inactive;
    }
}
