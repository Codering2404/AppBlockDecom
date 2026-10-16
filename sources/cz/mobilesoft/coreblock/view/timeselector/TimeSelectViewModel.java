package cz.mobilesoft.coreblock.view.timeselector;

import android.app.Application;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import cz.mobilesoft.coreblock.view.timeselector.TimeSelectEvent;
import cz.mobilesoft.coreblock.view.timeselector.TimeSelectViewState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
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
public final class TimeSelectViewModel extends BaseStatefulViewModel<TimeSelectViewState, TimeSelectEvent, TimeSelectCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final int f133346o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final long f133347p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f133348q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Job f133349r;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.view.timeselector.TimeSelectViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.view.timeselector.TimeSelectViewModel$1", f = "TimeSelectViewModel.kt", l = {44}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f133350a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f133351b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f133352c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f133353d;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f133355g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f133356h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z2, long j3, Continuation continuation) {
            super(2, continuation);
            this.f133355g = z2;
            this.f133356h = j3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final TimeSelectViewState q(Ref.LongRef longRef, TimeSelectViewModel timeSelectViewModel, TimeSelectViewState timeSelectViewState) {
            long j3 = longRef.f140143a;
            TimeHelperExt timeHelperExt = TimeHelperExt.f128663a;
            String strJ = TimeHelperExt.j(timeHelperExt, timeSelectViewModel.A0(), timeHelperExt.f() + longRef.f140143a, false, false, 12, null);
            Map mapC = timeSelectViewState.c();
            ArrayList arrayList = new ArrayList(mapC.size());
            Iterator it = mapC.entrySet().iterator();
            while (it.hasNext()) {
                TimeSelectViewState.TimeType timeType = (TimeSelectViewState.TimeType) ((Map.Entry) it.next()).getKey();
                int valueInMillis = (int) (longRef.f140143a / timeType.getValueInMillis());
                longRef.f140143a -= ((long) valueInMillis) * timeType.getValueInMillis();
                arrayList.add(TuplesKt.a(timeType, Integer.valueOf(valueInMillis)));
            }
            return TimeSelectViewState.b(timeSelectViewState, j3, 0L, MapsKt.toMap(arrayList), null, false, 0L, strJ, 58, null);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return TimeSelectViewModel.this.new AnonymousClass1(this.f133355g, this.f133356h, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x007d  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r9.f133353d
                r2 = 1
                if (r1 == 0) goto L23
                if (r1 != r2) goto L1b
                java.lang.Object r0 = r9.f133352c
                kotlin.jvm.internal.Ref$LongRef r0 = (kotlin.jvm.internal.Ref.LongRef) r0
                java.lang.Object r1 = r9.f133351b
                kotlin.jvm.internal.Ref$LongRef r1 = (kotlin.jvm.internal.Ref.LongRef) r1
                java.lang.Object r2 = r9.f133350a
                cz.mobilesoft.coreblock.view.timeselector.TimeSelectViewState r2 = (cz.mobilesoft.coreblock.view.timeselector.TimeSelectViewState) r2
                kotlin.ResultKt.b(r10)
                goto L6f
            L1b:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L23:
                kotlin.ResultKt.b(r10)
                cz.mobilesoft.coreblock.view.timeselector.TimeSelectViewModel r10 = cz.mobilesoft.coreblock.view.timeselector.TimeSelectViewModel.this
                cz.mobilesoft.coreblock.view.timeselector.TimeSelectViewState r10 = cz.mobilesoft.coreblock.view.timeselector.TimeSelectViewModel.T0(r10)
                kotlin.jvm.internal.Ref$LongRef r1 = new kotlin.jvm.internal.Ref$LongRef
                r1.<init>()
                long r3 = r10.d()
                java.lang.Long r3 = kotlin.coroutines.jvm.internal.Boxing.e(r3)
                boolean r4 = r9.f133355g
                long r5 = r3.longValue()
                if (r4 != 0) goto L49
                r7 = 0
                int r4 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r4 <= 0) goto L48
                goto L49
            L48:
                r3 = 0
            L49:
                if (r3 == 0) goto L51
                long r2 = r3.longValue()
                r10 = r1
                goto L77
            L51:
                cz.mobilesoft.coreblock.view.timeselector.TimeSelectViewModel r3 = cz.mobilesoft.coreblock.view.timeselector.TimeSelectViewModel.this
                cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore r3 = cz.mobilesoft.coreblock.view.timeselector.TimeSelectViewModel.V0(r3)
                kotlinx.coroutines.flow.Flow r3 = r3.z0()
                java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)
                r9.f133350a = r10
                r9.f133351b = r1
                r9.f133352c = r1
                r9.f133353d = r2
                java.lang.Object r10 = kotlinx.coroutines.flow.FlowKt.D(r3, r9)
                if (r10 != r0) goto L6e
                return r0
            L6e:
                r0 = r1
            L6f:
                java.lang.Number r10 = (java.lang.Number) r10
                long r2 = r10.longValue()
                r10 = r1
                r1 = r0
            L77:
                r1.f140143a = r2
                boolean r0 = r9.f133355g
                if (r0 == 0) goto L84
                cz.mobilesoft.coreblock.view.timeselector.TimeSelectViewModel r0 = cz.mobilesoft.coreblock.view.timeselector.TimeSelectViewModel.this
                long r1 = r9.f133356h
                cz.mobilesoft.coreblock.view.timeselector.TimeSelectViewModel.X0(r0, r1)
            L84:
                cz.mobilesoft.coreblock.view.timeselector.TimeSelectViewModel r0 = cz.mobilesoft.coreblock.view.timeselector.TimeSelectViewModel.this
                cz.mobilesoft.coreblock.view.timeselector.x r1 = new cz.mobilesoft.coreblock.view.timeselector.x
                r1.<init>()
                cz.mobilesoft.coreblock.view.timeselector.TimeSelectViewModel.Y0(r0, r1)
                kotlin.Unit r10 = kotlin.Unit.f139807a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.timeselector.TimeSelectViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TimeSelectViewModel(Application application, long j3, boolean z2) {
        super(application, new TimeSelectViewState(z2 ? 0L : j3, z2 ? j3 : 0L, null, null, z2, 0L, null, 108, null));
        Intrinsics.checkNotNullParameter(application, "application");
        this.f133346o = 99;
        this.f133347p = 8553600000L;
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f133348q = LazyKt.a(lazyThreadSafetyModeB, new Function0<StrictModeDataStore>() { // from class: cz.mobilesoft.coreblock.view.timeselector.TimeSelectViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeDataStore.class), qualifier, objArr);
            }
        });
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass1(z2, j3, null), 3, null);
    }

    public static final /* synthetic */ TimeSelectViewState T0(TimeSelectViewModel timeSelectViewModel) {
        return (TimeSelectViewState) timeSelectViewModel.I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeDataStore Z0() {
        return (StrictModeDataStore) this.f133348q.getValue();
    }

    private final void a1() {
        TimeSelectViewState timeSelectViewState = (TimeSelectViewState) I0();
        TimeSelectViewState.TimeType timeTypeE = timeSelectViewState.e();
        Integer num = (Integer) timeSelectViewState.c().get(timeTypeE);
        int iIntValue = num != null ? num.intValue() : 0;
        g1(timeTypeE, iIntValue >= 10 ? iIntValue / 10 : 0);
    }

    private final void b1() {
        g1(((TimeSelectViewState) I0()).e(), 0);
    }

    private final void d1(int i3) {
        TimeSelectViewState timeSelectViewState = (TimeSelectViewState) I0();
        TimeSelectViewState.TimeType timeTypeE = timeSelectViewState.e();
        Integer num = (Integer) timeSelectViewState.c().get(timeTypeE);
        int iIntValue = num != null ? (num.intValue() * 10) + i3 : 0;
        if (iIntValue > timeTypeE.getMaximumValue()) {
            return;
        }
        Map mapC = timeSelectViewState.c();
        ArrayList arrayList = new ArrayList(mapC.size());
        for (Map.Entry entry : mapC.entrySet()) {
            TimeSelectViewState.TimeType timeType = (TimeSelectViewState.TimeType) entry.getKey();
            arrayList.add(Long.valueOf(timeType == timeTypeE ? 0L : timeType.getValueInMillis() * ((long) ((Number) entry.getValue()).intValue())));
        }
        if (CollectionsKt.sumOfLong(arrayList) + (((long) iIntValue) * timeTypeE.getValueInMillis()) > this.f133347p) {
            G0(new TimeSelectViewModel$onNumberClicked$1(this, null));
        } else {
            g1(timeTypeE, iIntValue);
        }
    }

    private final void e1(final TimeSelectViewState.TimeType timeType) {
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.view.timeselector.w
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TimeSelectViewModel.f1(timeType, (TimeSelectViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TimeSelectViewState f1(TimeSelectViewState.TimeType timeType, TimeSelectViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return TimeSelectViewState.b(updateState, 0L, 0L, null, timeType, false, 0L, null, 119, null);
    }

    private final void g1(final TimeSelectViewState.TimeType timeType, final int i3) {
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.view.timeselector.v
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TimeSelectViewModel.h1(this.f133447a, i3, timeType, (TimeSelectViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TimeSelectViewState h1(TimeSelectViewModel timeSelectViewModel, int i3, TimeSelectViewState.TimeType timeType, TimeSelectViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        Map mutableMap = MapsKt.toMutableMap(updateState.c());
        mutableMap.put(timeType, Integer.valueOf(i3));
        Unit unit = Unit.f139807a;
        TimeHelperExt timeHelperExt = TimeHelperExt.f128663a;
        return TimeSelectViewState.b(updateState, 0L, 0L, mutableMap, null, false, 0L, TimeHelperExt.j(timeHelperExt, timeSelectViewModel.A0(), (((long) i3) * timeType.getValueInMillis()) + timeHelperExt.f(), false, false, 12, null), 59, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i1(long j3) {
        Flow flowA = TimeHelperExt.f128663a.a(j3, 500L);
        Job job = this.f133349r;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        this.f133349r = FlowKt.Q(FlowKt.V(FlowKt.g(flowA), new TimeSelectViewModel$updateCountdown$1(this, null)), B0());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: c1, reason: merged with bridge method [inline-methods] */
    public void O0(TimeSelectEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof TimeSelectEvent.OnNumberClicked) {
            d1(((TimeSelectEvent.OnNumberClicked) event).a());
            return;
        }
        if (event instanceof TimeSelectEvent.OnDoubleZeroesClicked) {
            b1();
        } else if (event instanceof TimeSelectEvent.OnBackspaceClicked) {
            a1();
        } else {
            if (!(event instanceof TimeSelectEvent.OnTimeTypeClicked)) {
                throw new NoWhenBranchMatchedException();
            }
            e1(((TimeSelectEvent.OnTimeTypeClicked) event).a());
        }
    }
}
