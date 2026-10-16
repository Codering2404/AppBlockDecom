package cz.mobilesoft.coreblock.scene.timenudge;

import android.app.Application;
import android.content.Context;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.usecase.timenudge.GetTimeNudgeAppsUseCase;
import cz.mobilesoft.coreblock.util.UsageAccessHelper;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
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
public final class TimeNudgeViewModel extends BaseStatefulViewModel<TimeNudgeViewState, TimeNudgeViewEvent, TimeNudgeViewCommand> {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final Companion f122868p = new Companion(null);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f122869q = 8;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f122870o;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.timenudge.TimeNudgeViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.timenudge.TimeNudgeViewModel$1", f = "TimeNudgeViewModel.kt", l = {41, 51, 56, 58}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f122871a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f122872b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f122873c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f122874d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        long f122875f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        double f122876g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f122877h;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.timenudge.TimeNudgeViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.timenudge.TimeNudgeViewModel$1$1", f = "TimeNudgeViewModel.kt", l = {42}, m = "invokeSuspend", v = 1)
        static final class C03031 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f122879a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ TimeNudgeViewModel f122880b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03031(TimeNudgeViewModel timeNudgeViewModel, Continuation continuation) {
                super(2, continuation);
                this.f122880b = timeNudgeViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new C03031(this.f122880b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = IntrinsicsKt.f();
                int i3 = this.f122879a;
                if (i3 != 0) {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    return obj;
                }
                ResultKt.b(obj);
                UsageAccessHelper usageAccessHelper = UsageAccessHelper.f128032a;
                Context contextA0 = this.f122880b.A0();
                this.f122879a = 1;
                Object objP = usageAccessHelper.p(contextA0, this);
                return objP == objF ? objF : objP;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((C03031) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final TimeNudgeViewState q(double d3, double d4, List list, TimeNudgeViewState timeNudgeViewState) {
            return timeNudgeViewState.a(false, (long) d3, (long) d4, list);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return TimeNudgeViewModel.this.new AnonymousClass1(continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x00de  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00e3  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x010a  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0116  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x014f  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0156  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r22) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 360
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.timenudge.TimeNudgeViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TimeNudgeViewModel(Application app) {
        super(app, new TimeNudgeViewState(false, 0L, 0L, null, 15, null));
        Intrinsics.checkNotNullParameter(app, "app");
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f122870o = LazyKt.a(lazyThreadSafetyModeB, new Function0<GetTimeNudgeAppsUseCase>() { // from class: cz.mobilesoft.coreblock.scene.timenudge.TimeNudgeViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(GetTimeNudgeAppsUseCase.class), qualifier, objArr);
            }
        });
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GetTimeNudgeAppsUseCase T0() {
        return (GetTimeNudgeAppsUseCase) this.f122870o.getValue();
    }
}
