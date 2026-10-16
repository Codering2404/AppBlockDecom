package cz.mobilesoft.coreblock.activity.rating;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AlertDialog;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.activity.rating.RatingDialogEvent;
import cz.mobilesoft.coreblock.activity.rating.RatingFlowEvent;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.storage.datastore.RatingDataStore;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.util.ExternalLinksHelper;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.runnability.RunnabilityHelper;
import cz.mobilesoft.coreblock.view.compose.ComposeDialogsKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class RatingDialogActivity extends BaseComposeActivity implements KoinComponent {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Companion f95979p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f95980q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final Lazy f95981r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final Lazy f95982s;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f95983f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f95984g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f95985h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f95986i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private OnRatingDialogClosedListener f95987j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ReviewManager f95988k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ReviewInfo f95989l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private RatingDialogType f95990m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private RatingTriggerSource f95991n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f95992o;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion implements KoinComponent {

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class Launch {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final RatingDialogType f95993a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final boolean f95994b;

            public Launch(RatingDialogType type, boolean z2) {
                Intrinsics.checkNotNullParameter(type, "type");
                this.f95993a = type;
                this.f95994b = z2;
            }

            public final RatingDialogType a() {
                return this.f95993a;
            }

            public final boolean b() {
                return this.f95994b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Launch)) {
                    return false;
                }
                Launch launch = (Launch) obj;
                return this.f95993a == launch.f95993a && this.f95994b == launch.f95994b;
            }

            public int hashCode() {
                return (this.f95993a.hashCode() * 31) + Boolean.hashCode(this.f95994b);
            }

            public String toString() {
                return "Launch(type=" + this.f95993a + ", isLovedItRetry=" + this.f95994b + ")";
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class RatingFlowNavItem {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ RatingFlowNavItem[] $VALUES;
            public static final RatingFlowNavItem RatingOnboarding = new RatingFlowNavItem("RatingOnboarding", 0, "rating_onboarding");
            public static final RatingFlowNavItem RatingReview = new RatingFlowNavItem("RatingReview", 1, "rating_review");
            private final String route;

            private static final /* synthetic */ RatingFlowNavItem[] $values() {
                return new RatingFlowNavItem[]{RatingOnboarding, RatingReview};
            }

            static {
                RatingFlowNavItem[] ratingFlowNavItemArr$values = $values();
                $VALUES = ratingFlowNavItemArr$values;
                $ENTRIES = EnumEntriesKt.a(ratingFlowNavItemArr$values);
            }

            private RatingFlowNavItem(String str, int i3, String str2) {
                this.route = str2;
            }

            public static EnumEntries<RatingFlowNavItem> getEntries() {
                return $ENTRIES;
            }

            public static RatingFlowNavItem valueOf(String str) {
                return (RatingFlowNavItem) Enum.valueOf(RatingFlowNavItem.class, str);
            }

            public static RatingFlowNavItem[] values() {
                return (RatingFlowNavItem[]) $VALUES.clone();
            }

            public final String getRoute() {
                return this.route;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final /* synthetic */ class WhenMappings {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f95995a;

            static {
                int[] iArr = new int[LovedItRetryDecision.values().length];
                try {
                    iArr[LovedItRetryDecision.NotPending.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[LovedItRetryDecision.Retry.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[LovedItRetryDecision.Wait.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f95995a = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DevDataStore e() {
            return (DevDataStore) RatingDialogActivity.f95982s.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final RatingDataStore f() {
            return (RatingDataStore) RatingDialogActivity.f95981r.getValue();
        }

        private final ResultReceiver g(final OnRatingDialogClosedListener onRatingDialogClosedListener) {
            if (onRatingDialogClosedListener == null) {
                return null;
            }
            return new ResultReceiver() { // from class: cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity$Companion$getResultReceiver$1
                {
                    super(null);
                }

                @Override // android.os.ResultReceiver
                protected void onReceiveResult(int i3, Bundle resultData) {
                    Intrinsics.checkNotNullParameter(resultData, "resultData");
                    onRatingDialogClosedListener.a(resultData.getBoolean("OUTSIDE_NAVIGATION"));
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00bb, code lost:
        
            if (r14.W0(r0) == r1) goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00d4, code lost:
        
            if (r14 == r1) goto L52;
         */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0087  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x008d  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00a6  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00c6  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object h(kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 224
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity.Companion.h(kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void k(Context context, OnRatingDialogClosedListener onRatingDialogClosedListener, boolean z2, RatingDialogType ratingDialogType, RatingTriggerSource ratingTriggerSource, boolean z3) {
            Intent intent = new Intent(context, (Class<?>) RatingDialogActivity.class);
            intent.putExtra("RECEIVER", g(onRatingDialogClosedListener));
            intent.putExtra("extra_rating_dialog_type", ratingDialogType.name());
            intent.putExtra("extra_rating_trigger_source", ratingTriggerSource.name());
            intent.putExtra("extra_is_loved_it_retry", z3);
            if (!z2) {
                intent.setFlags(268468224);
            }
            context.startActivity(intent);
        }

        static /* synthetic */ void l(Companion companion, Context context, OnRatingDialogClosedListener onRatingDialogClosedListener, boolean z2, RatingDialogType ratingDialogType, RatingTriggerSource ratingTriggerSource, boolean z3, int i3, Object obj) {
            if ((i3 & 32) != 0) {
                z3 = false;
            }
            companion.k(context, onRatingDialogClosedListener, z2, ratingDialogType, ratingTriggerSource, z3);
        }

        public final void i(Context context, boolean z2, RatingTriggerSource source, OnRatingDialogClosedListener onRatingDialogClosedListener) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(source, "source");
            CoroutineScope applicationScope = LockieApplication.f95365k;
            Intrinsics.checkNotNullExpressionValue(applicationScope, "applicationScope");
            BuildersKt__Builders_commonKt.d(applicationScope, Dispatchers.c(), null, new RatingDialogActivity$Companion$show$1(context, onRatingDialogClosedListener, z2, source, null), 2, null);
        }

        public final void j(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            CoroutineScope applicationScope = LockieApplication.f95365k;
            Intrinsics.checkNotNullExpressionValue(applicationScope, "applicationScope");
            BuildersKt__Builders_commonKt.d(applicationScope, Dispatchers.c(), null, new RatingDialogActivity$Companion$showPreview$1(context, null), 2, null);
        }

        @Override // org.koin.core.component.KoinComponent
        public /* bridge */ Koin r0() {
            return KoinComponent.DefaultImpls.a(this);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface OnRatingDialogClosedListener {
        void a(boolean z2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f96029a;

        static {
            int[] iArr = new int[RatingDialogType.values().length];
            try {
                iArr[RatingDialogType.RatingFlow.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RatingDialogType.Native.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RatingDialogType.SimpleDialog.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RatingDialogType.RatingDialog.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f96029a = iArr;
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity$onCreate$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity$onCreate$3", f = "RatingDialogActivity.kt", l = {279}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f96042a;

        AnonymousClass3(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return RatingDialogActivity.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f96042a;
            if (i3 == 0) {
                ResultKt.b(obj);
                RatingDataStore ratingDataStoreC1 = RatingDialogActivity.this.c1();
                this.f96042a = 1;
                if (ratingDataStoreC1.g0(this) == objF) {
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

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        final Companion companion = new Companion(null);
        f95979p = companion;
        f95980q = 8;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        final Object[] objArr2 = 0 == true ? 1 : 0;
        f95981r = LazyKt.a(lazyThreadSafetyModeB, new Function0<RatingDataStore>() { // from class: cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = companion;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(RatingDataStore.class), objArr, objArr2);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr3 = 0 == true ? 1 : 0;
        final Object[] objArr4 = 0 == true ? 1 : 0;
        f95982s = LazyKt.a(lazyThreadSafetyModeB2, new Function0<DevDataStore>() { // from class: cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = companion;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DevDataStore.class), objArr3, objArr4);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RatingDialogActivity() {
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f95983f = LazyKt.a(lazyThreadSafetyModeB, new Function0<RatingDataStore>() { // from class: cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(RatingDataStore.class), qualifier, objArr);
            }
        });
        final Function0 function0 = new Function0() { // from class: cz.mobilesoft.coreblock.activity.rating.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RatingDialogActivity.Z0(this.f96205a);
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f139763c;
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f95984g = LazyKt.a(lazyThreadSafetyMode, new Function0<RatingDialogViewModel>() { // from class: cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity$special$$inlined$viewModel$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final ViewModel invoke() {
                CreationExtras defaultViewModelCreationExtras;
                ComponentActivity componentActivity = this;
                Qualifier qualifier2 = objArr2;
                Function0 function02 = objArr3;
                Function0 function03 = function0;
                ViewModelStore viewModelStore = componentActivity.getViewModelStore();
                if (function02 == null || (defaultViewModelCreationExtras = (CreationExtras) function02.invoke()) == null) {
                    defaultViewModelCreationExtras = componentActivity.getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                }
                CreationExtras creationExtras = defaultViewModelCreationExtras;
                Scope scopeA = AndroidKoinScopeExtKt.a(componentActivity);
                KClass kClassB = Reflection.b(RatingDialogViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                return GetViewModelKt.b(kClassB, viewModelStore, null, creationExtras, qualifier2, scopeA, function03, 4, null);
            }
        });
        final Function0 function02 = new Function0() { // from class: cz.mobilesoft.coreblock.activity.rating.q
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RatingDialogActivity.a1(this.f96235a);
            }
        };
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f95985h = LazyKt.a(lazyThreadSafetyMode, new Function0<RatingFlowViewModel>() { // from class: cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final ViewModel invoke() {
                CreationExtras defaultViewModelCreationExtras;
                ComponentActivity componentActivity = this;
                Qualifier qualifier2 = objArr4;
                Function0 function03 = objArr5;
                Function0 function04 = function02;
                ViewModelStore viewModelStore = componentActivity.getViewModelStore();
                if (function03 == null || (defaultViewModelCreationExtras = (CreationExtras) function03.invoke()) == null) {
                    defaultViewModelCreationExtras = componentActivity.getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                }
                CreationExtras creationExtras = defaultViewModelCreationExtras;
                Scope scopeA = AndroidKoinScopeExtKt.a(componentActivity);
                KClass kClassB = Reflection.b(RatingFlowViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                return GetViewModelKt.b(kClassB, viewModelStore, null, creationExtras, qualifier2, scopeA, function04, 4, null);
            }
        });
    }

    private final void B0(final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-2000659001);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(function1) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(this) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2000659001, i4, -1, "cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity.DialogCommandProcessor (RatingDialogActivity.kt:192)");
            }
            RatingDialogViewModel ratingDialogViewModelD1 = d1();
            boolean zI = composerK.I(this) | ((i4 & 14) == 4);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new RatingDialogActivity$DialogCommandProcessor$1$1(this, function1, null);
                composerK.w(objG);
            }
            FlowExtKt.g(ratingDialogViewModelD1, null, (Function2) objG, composerK, 0, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.activity.rating.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RatingDialogActivity.C0(this.f96209a, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C0(RatingDialogActivity ratingDialogActivity, Function1 function1, int i3, Composer composer, int i4) {
        ratingDialogActivity.B0(function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void D0(final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(508069025);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(function1) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(this) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(508069025, i4, -1, "cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity.FlowCommandProcessor (RatingDialogActivity.kt:215)");
            }
            RatingFlowViewModel ratingFlowViewModelE1 = e1();
            boolean zI = composerK.I(this) | ((i4 & 14) == 4);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new RatingDialogActivity$FlowCommandProcessor$1$1(this, function1, null);
                composerK.w(objG);
            }
            FlowExtKt.g(ratingFlowViewModelE1, null, (Function2) objG, composerK, 0, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.activity.rating.y
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RatingDialogActivity.E0(this.f96266a, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(RatingDialogActivity ratingDialogActivity, Function1 function1, int i3, Composer composer, int i4) {
        ratingDialogActivity.D0(function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void F0(final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(510367122);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(function1) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(510367122, i4, -1, "cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity.PlayStoreDialogContent (RatingDialogActivity.kt:426)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.TRUE, null, 2, null);
                composerK.w(objG);
            }
            MutableState mutableState = (MutableState) objG;
            boolean z2 = (i4 & 14) == 4;
            Object objG2 = composerK.G();
            if (z2 || objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.activity.rating.l
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RatingDialogActivity.G0(function1);
                    }
                };
                composerK.w(objG2);
            }
            ComposeDialogsKt.z0(mutableState, null, null, (Function0) objG2, ComposableLambdaKt.e(-1982492141, true, new Function3() { // from class: cz.mobilesoft.coreblock.activity.rating.m
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return RatingDialogActivity.H0(function1, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 24582, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.activity.rating.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RatingDialogActivity.K0(this.f96227a, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G0(Function1 function1) {
        function1.invoke(RatingDialogEvent.OnPlayStoreDialogDismissed.f96076a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(final Function1 function1, BoxScope CustomDialog, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(CustomDialog, "$this$CustomDialog");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1982492141, i3, -1, "cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity.PlayStoreDialogContent.<anonymous> (RatingDialogActivity.kt:434)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierI = PaddingKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(16));
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.g(), composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierI);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A);
            } else {
                composer.v();
            }
            Composer composerA = Updater.a(composer);
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            TextKt.c(StringResources_androidKt.c(R.string.zr, new Object[]{StringResources_androidKt.b(R.string.f95790f1, composer, 0)}, composer, 0), null, ComposeColorsKt.j(composer, 0).L(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).g(), composer, 0, 0, 65530);
            TextKt.c(StringResources_androidKt.b(R.string.Ar, composer, 0), PaddingKt.m(companion, 0.0f, Dp.g(12), 0.0f, 0.0f, 13, null), ComposeColorsKt.j(composer, 0).O(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 48, 0, 65528);
            Modifier modifierH = SizeKt.h(PaddingKt.m(companion, 0.0f, Dp.g(24), 0.0f, 0.0f, 13, null), 0.0f, 1, null);
            FlatButtonColors.Primary primary = FlatButtonColors.Primary.f131166a;
            String strB = StringResources_androidKt.b(R.string.Br, composer, 0);
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.activity.rating.o
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RatingDialogActivity.I0(function1);
                    }
                };
                composer.w(objG);
            }
            FlatButtonsKt.u(modifierH, 0.0f, 0.0f, null, primary, null, strB, null, 0L, null, null, false, false, (Function0) objG, composer, 24582, 0, 8110);
            Modifier modifierH2 = SizeKt.h(PaddingKt.m(companion, 0.0f, Dp.g(8), 0.0f, 0.0f, 13, null), 0.0f, 1, null);
            FlatButtonColors.Secondary secondary = FlatButtonColors.Secondary.f131167a;
            String strB2 = StringResources_androidKt.b(R.string.yr, composer, 0);
            boolean Z2 = composer.Z(function1);
            Object objG2 = composer.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.activity.rating.p
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RatingDialogActivity.J0(function1);
                    }
                };
                composer.w(objG2);
            }
            FlatButtonsKt.u(modifierH2, 0.0f, 0.0f, null, secondary, null, strB2, null, 0L, null, null, false, false, (Function0) objG2, composer, 24582, 0, 8110);
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I0(Function1 function1) {
        function1.invoke(RatingDialogEvent.OnPlayStoreButtonClicked.f96075a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J0(Function1 function1) {
        function1.invoke(RatingDialogEvent.OnPlayStoreDialogDismissed.f96076a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K0(RatingDialogActivity ratingDialogActivity, Function1 function1, int i3, Composer composer, int i4) {
        ratingDialogActivity.F0(function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L0(RatingDialogActivity ratingDialogActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        ratingDialogActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y0(OnRatingDialogClosedListener onRatingDialogClosedListener, boolean z2) {
        finish();
        if (onRatingDialogClosedListener != null) {
            onRatingDialogClosedListener.a(z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder Z0(RatingDialogActivity ratingDialogActivity) {
        RatingTriggerSource ratingTriggerSource = ratingDialogActivity.f95991n;
        if (ratingTriggerSource == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resolvedTriggerSource");
            ratingTriggerSource = null;
        }
        return ParametersHolderKt.b(ratingTriggerSource, Boolean.valueOf(ratingDialogActivity.f95992o));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder a1(RatingDialogActivity ratingDialogActivity) {
        RatingTriggerSource ratingTriggerSource = ratingDialogActivity.f95991n;
        if (ratingTriggerSource == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resolvedTriggerSource");
            ratingTriggerSource = null;
        }
        return ParametersHolderKt.b(ratingTriggerSource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RatingDataStore c1() {
        return (RatingDataStore) this.f95983f.getValue();
    }

    private final RatingDialogViewModel d1() {
        return (RatingDialogViewModel) this.f95984g.getValue();
    }

    private final RatingFlowViewModel e1() {
        return (RatingFlowViewModel) this.f95985h.getValue();
    }

    private final void f1(final Function1 function1, final Function1 function12) {
        ReviewInfo reviewInfo = this.f95989l;
        if (reviewInfo == null) {
            if (function1 != null) {
                function1.invoke(new RatingDialogEvent.OnReviewFlowFinished(false));
            }
            if (function12 != null) {
                function12.invoke(new RatingFlowEvent.OnReviewFlowFinished(false));
                return;
            }
            return;
        }
        ReviewManager reviewManager = this.f95988k;
        if (reviewManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reviewManager");
            reviewManager = null;
        }
        reviewManager.b(this, reviewInfo).addOnCompleteListener(new OnCompleteListener() { // from class: cz.mobilesoft.coreblock.activity.rating.v
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                RatingDialogActivity.h1(function1, function12, task);
            }
        });
    }

    static /* synthetic */ void g1(RatingDialogActivity ratingDialogActivity, Function1 function1, Function1 function12, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function1 = null;
        }
        if ((i3 & 2) != 0) {
            function12 = null;
        }
        ratingDialogActivity.f1(function1, function12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(Function1 function1, Function1 function12, Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (function1 != null) {
            function1.invoke(new RatingDialogEvent.OnReviewFlowFinished(task.isSuccessful()));
        }
        if (function12 != null) {
            function12.invoke(new RatingFlowEvent.OnReviewFlowFinished(task.isSuccessful()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(12:0|2|(2:4|(1:6)(1:7))(0)|8|(1:52)|(1:(1:(6:12|49|13|51|45|46)(2:19|20))(1:21))(9:22|(1:24)|25|(1:27)|33|(1:35)(1:36)|37|47|38)|30|(1:33)|(0)(0)|37|47|38) */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a0, code lost:
    
        if (r12 == r1) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00dc, code lost:
    
        if (kotlinx.coroutines.TimeoutKt.c(5000, r12, r0) != r1) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00de, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00df, code lost:
    
        r10 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e0, code lost:
    
        r9 = r11;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object i1(kotlin.jvm.functions.Function1 r9, kotlin.jvm.functions.Function0 r10, kotlin.jvm.functions.Function0 r11, kotlin.coroutines.Continuation r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity.i1(kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(ResultReceiver resultReceiver, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("OUTSIDE_NAVIGATION", z2);
        resultReceiver.send(942, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k1() {
        ExternalLinksHelper.f(ExternalLinksHelper.f127866a, this, false, new Function0() { // from class: cz.mobilesoft.coreblock.activity.rating.u
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RatingDialogActivity.l1(this.f96246a);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l1(RatingDialogActivity ratingDialogActivity) {
        ratingDialogActivity.m1();
        return Unit.f139807a;
    }

    private final void m1() {
        CoroutineScope applicationScope = LockieApplication.f95365k;
        Intrinsics.checkNotNullExpressionValue(applicationScope, "applicationScope");
        BuildersKt__Builders_commonKt.d(applicationScope, null, null, new RatingDialogActivity$setNeverShowRatingDialog$1(this, null), 3, null);
    }

    private final void n1(final Function1 function1, final Function1 function12) {
        AlertDialog alertDialogA = new MaterialAlertDialogBuilder(this).D(R.string.zc).L(R.string.Qv, new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.activity.rating.r
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                RatingDialogActivity.p1(function1, function12, dialogInterface, i3);
            }
        }).G(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.activity.rating.s
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                RatingDialogActivity.q1(function1, function12, dialogInterface, i3);
            }
        }).J(new DialogInterface.OnCancelListener() { // from class: cz.mobilesoft.coreblock.activity.rating.t
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                RatingDialogActivity.r1(function1, function12, dialogInterface);
            }
        }).a();
        Intrinsics.checkNotNullExpressionValue(alertDialogA, "create(...)");
        alertDialogA.setCanceledOnTouchOutside(false);
        alertDialogA.show();
    }

    static /* synthetic */ void o1(RatingDialogActivity ratingDialogActivity, Function1 function1, Function1 function12, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function1 = null;
        }
        if ((i3 & 2) != 0) {
            function12 = null;
        }
        ratingDialogActivity.n1(function1, function12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p1(Function1 function1, Function1 function12, DialogInterface dialogInterface, int i3) {
        if (function1 != null) {
            function1.invoke(RatingDialogEvent.OnFeedbackSendClicked.f96073a);
        }
        if (function12 != null) {
            function12.invoke(RatingFlowEvent.OnFeedbackSendClicked.f96127a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q1(Function1 function1, Function1 function12, DialogInterface dialogInterface, int i3) {
        if (function1 != null) {
            function1.invoke(RatingDialogEvent.OnFeedbackDismissed.f96072a);
        }
        if (function12 != null) {
            function12.invoke(RatingFlowEvent.OnFeedbackDismissed.f96126a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r1(Function1 function1, Function1 function12, DialogInterface dialogInterface) {
        if (function1 != null) {
            function1.invoke(RatingDialogEvent.OnFeedbackDismissed.f96072a);
        }
        if (function12 != null) {
            function12.invoke(RatingFlowEvent.OnFeedbackDismissed.f96126a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s1() {
        RunnabilityHelper.V(this, 0, null, false, null, true, "rating_dialog", 30, null);
    }

    protected long b1() {
        return Color.f25715b.j();
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Object obj;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(-856054040);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(this) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-856054040, i4, -1, "cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity.RootCompose (RatingDialogActivity.kt:285)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = this.f95990m;
                if (objG == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("resolvedRatingDialogType");
                    objG = null;
                }
                composerK.w(objG);
            }
            int i5 = WhenMappings.f96029a[((RatingDialogType) objG).ordinal()];
            if (i5 == 1) {
                composerK.a0(810131657);
                RatingFlowState ratingFlowState = (RatingFlowState) FlowExtKt.m(e1(), composerK, 0);
                Function1 function1N = FlowExtKt.n(e1(), composerK, 0);
                Unit unit = Unit.f139807a;
                boolean zI = composerK.I(this) | composerK.Z(function1N);
                Object objG2 = composerK.G();
                if (zI || objG2 == companion.a()) {
                    obj = null;
                    objG2 = new RatingDialogActivity$RootCompose$1$1(this, function1N, null);
                    composerK.w(objG2);
                } else {
                    obj = null;
                }
                EffectsKt.g(unit, (Function2) objG2, composerK, 6);
                D0(function1N, composerK, i4 & 112);
                Modifier modifierD = BackgroundKt.d(SizeKt.f(Modifier.b8, 0.0f, 1, obj), Color.f25715b.j(), null, 2, null);
                MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
                int iA = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU = composerK.u();
                Modifier modifierF = ComposedModifierKt.f(composerK, modifierD);
                ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
                Function0 function0A = companion2.a();
                if (composerK.m() == null) {
                    ComposablesKt.c();
                }
                composerK.L();
                if (composerK.i()) {
                    composerK.P(function0A);
                } else {
                    composerK.v();
                }
                Composer composerA = Updater.a(composerK);
                Updater.e(composerA, measurePolicyG, companion2.e());
                Updater.e(composerA, compositionLocalMapU, companion2.g());
                Function2 function2B = companion2.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF, companion2.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                if (ratingFlowState.e()) {
                    composerK.a0(-1436970427);
                    RatingFlowScreenKt.C(function1N, ratingFlowState.d(), ratingFlowState.c(), composerK, 0, 0);
                } else {
                    composerK.a0(-1451153640);
                }
                composerK.U();
                composerK.y();
                composerK.U();
            } else if (i5 == 2) {
                composerK.a0(811443639);
                Function1 function1N2 = FlowExtKt.n(d1(), composerK, 0);
                Unit unit2 = Unit.f139807a;
                boolean zI2 = composerK.I(this) | composerK.Z(function1N2);
                Object objG3 = composerK.G();
                if (zI2 || objG3 == companion.a()) {
                    objG3 = new RatingDialogActivity$RootCompose$3$1(this, function1N2, null);
                    composerK.w(objG3);
                }
                EffectsKt.g(unit2, (Function2) objG3, composerK, 6);
                B0(function1N2, composerK, i4 & 112);
                composerK.U();
            } else if (i5 == 3) {
                composerK.a0(812323481);
                RatingDialogState ratingDialogState = (RatingDialogState) FlowExtKt.m(d1(), composerK, 0);
                Function1 function1N3 = FlowExtKt.n(d1(), composerK, 0);
                Unit unit3 = Unit.f139807a;
                boolean Z = composerK.Z(function1N3);
                Object objG4 = composerK.G();
                if (Z || objG4 == companion.a()) {
                    objG4 = new RatingDialogActivity$RootCompose$4$1(function1N3, null);
                    composerK.w(objG4);
                }
                EffectsKt.g(unit3, (Function2) objG4, composerK, 6);
                int i6 = i4 & 112;
                B0(function1N3, composerK, i6);
                Modifier.Companion companion3 = Modifier.b8;
                Modifier modifierD2 = BackgroundKt.d(SizeKt.f(companion3, 0.0f, 1, null), Color.f25715b.j(), null, 2, null);
                Alignment.Companion companion4 = Alignment.f25072a;
                MeasurePolicy measurePolicyG2 = BoxKt.g(companion4.o(), false);
                int iA2 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU2 = composerK.u();
                Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierD2);
                ComposeUiNode.Companion companion5 = ComposeUiNode.f8;
                Function0 function0A2 = companion5.a();
                if (composerK.m() == null) {
                    ComposablesKt.c();
                }
                composerK.L();
                if (composerK.i()) {
                    composerK.P(function0A2);
                } else {
                    composerK.v();
                }
                Composer composerA2 = Updater.a(composerK);
                Updater.e(composerA2, measurePolicyG2, companion5.e());
                Updater.e(composerA2, compositionLocalMapU2, companion5.g());
                Function2 function2B2 = companion5.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF2, companion5.f());
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.f6642a;
                if (ratingDialogState.b()) {
                    composerK.a0(1268171655);
                    Modifier modifierD3 = BackgroundKt.d(SizeKt.f(companion3, 0.0f, 1, null), ComposeColorsKt.j(composerK, 0).d0(), null, 2, null);
                    MeasurePolicy measurePolicyG3 = BoxKt.g(companion4.o(), false);
                    int iA3 = ComposablesKt.a(composerK, 0);
                    CompositionLocalMap compositionLocalMapU3 = composerK.u();
                    Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierD3);
                    Function0 function0A3 = companion5.a();
                    if (composerK.m() == null) {
                        ComposablesKt.c();
                    }
                    composerK.L();
                    if (composerK.i()) {
                        composerK.P(function0A3);
                    } else {
                        composerK.v();
                    }
                    Composer composerA3 = Updater.a(composerK);
                    Updater.e(composerA3, measurePolicyG3, companion5.e());
                    Updater.e(composerA3, compositionLocalMapU3, companion5.g());
                    Function2 function2B3 = companion5.b();
                    if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                        composerA3.w(Integer.valueOf(iA3));
                        composerA3.p(Integer.valueOf(iA3), function2B3);
                    }
                    Updater.e(composerA3, modifierF3, companion5.f());
                    F0(function1N3, composerK, i6);
                    composerK.y();
                } else {
                    composerK.a0(1252063776);
                }
                composerK.U();
                composerK.y();
                composerK.U();
            } else {
                if (i5 != 4) {
                    composerK.a0(1965797082);
                    composerK.U();
                    throw new NoWhenBranchMatchedException();
                }
                composerK.a0(813394128);
                RatingDialogState ratingDialogState2 = (RatingDialogState) FlowExtKt.m(d1(), composerK, 0);
                Function1 function1N4 = FlowExtKt.n(d1(), composerK, 0);
                Unit unit4 = Unit.f139807a;
                boolean zI3 = composerK.I(this) | composerK.Z(function1N4);
                Object objG5 = composerK.G();
                if (zI3 || objG5 == companion.a()) {
                    objG5 = new RatingDialogActivity$RootCompose$6$1(this, function1N4, null);
                    composerK.w(objG5);
                }
                EffectsKt.g(unit4, (Function2) objG5, composerK, 6);
                B0(function1N4, composerK, i4 & 112);
                Modifier.Companion companion6 = Modifier.b8;
                Modifier modifierD4 = BackgroundKt.d(SizeKt.f(companion6, 0.0f, 1, null), Color.f25715b.j(), null, 2, null);
                Alignment.Companion companion7 = Alignment.f25072a;
                MeasurePolicy measurePolicyG4 = BoxKt.g(companion7.o(), false);
                int iA4 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU4 = composerK.u();
                Modifier modifierF4 = ComposedModifierKt.f(composerK, modifierD4);
                ComposeUiNode.Companion companion8 = ComposeUiNode.f8;
                Function0 function0A4 = companion8.a();
                if (composerK.m() == null) {
                    ComposablesKt.c();
                }
                composerK.L();
                if (composerK.i()) {
                    composerK.P(function0A4);
                } else {
                    composerK.v();
                }
                Composer composerA4 = Updater.a(composerK);
                Updater.e(composerA4, measurePolicyG4, companion8.e());
                Updater.e(composerA4, compositionLocalMapU4, companion8.g());
                Function2 function2B4 = companion8.b();
                if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                    composerA4.w(Integer.valueOf(iA4));
                    composerA4.p(Integer.valueOf(iA4), function2B4);
                }
                Updater.e(composerA4, modifierF4, companion8.f());
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.f6642a;
                if (ratingDialogState2.b()) {
                    composerK.a0(1437315337);
                    Modifier modifierD5 = BackgroundKt.d(SizeKt.f(companion6, 0.0f, 1, null), ComposeColorsKt.j(composerK, 0).d0(), null, 2, null);
                    MeasurePolicy measurePolicyG5 = BoxKt.g(companion7.o(), false);
                    int iA5 = ComposablesKt.a(composerK, 0);
                    CompositionLocalMap compositionLocalMapU5 = composerK.u();
                    Modifier modifierF5 = ComposedModifierKt.f(composerK, modifierD5);
                    Function0 function0A5 = companion8.a();
                    if (composerK.m() == null) {
                        ComposablesKt.c();
                    }
                    composerK.L();
                    if (composerK.i()) {
                        composerK.P(function0A5);
                    } else {
                        composerK.v();
                    }
                    Composer composerA5 = Updater.a(composerK);
                    Updater.e(composerA5, measurePolicyG5, companion8.e());
                    Updater.e(composerA5, compositionLocalMapU5, companion8.g());
                    Function2 function2B5 = companion8.b();
                    if (composerA5.i() || !Intrinsics.areEqual(composerA5.G(), Integer.valueOf(iA5))) {
                        composerA5.w(Integer.valueOf(iA5));
                        composerA5.p(Integer.valueOf(iA5), function2B5);
                    }
                    Updater.e(composerA5, modifierF5, companion8.f());
                    RatingDialogContentKt.g(function1N4, composerK, 0);
                    composerK.y();
                } else {
                    composerK.a0(1419879263);
                }
                composerK.U();
                composerK.y();
                composerK.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.activity.rating.x
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return RatingDialogActivity.L0(this.f96261a, paddingValues, i3, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public /* bridge */ /* synthetic */ Color d0() {
        return Color.n(b1());
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    protected boolean f0() {
        return this.f95986i;
    }

    @Override // android.app.Activity
    public void finish() {
        if (isTaskRoot()) {
            super.finishAndRemoveTask();
        } else {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0062  */
    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r11) {
        /*
            r10 = this;
            android.content.Intent r0 = r10.getIntent()
            java.lang.String r1 = "getIntent(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 33
            r3 = 0
            java.lang.String r4 = "RECEIVER"
            if (r1 < r2) goto L1b
            java.lang.Class<android.os.ResultReceiver> r1 = android.os.ResultReceiver.class
            java.lang.Object r0 = a0.a.a(r0, r4, r1)
            android.os.Parcelable r0 = (android.os.Parcelable) r0
            goto L26
        L1b:
            android.os.Parcelable r0 = r0.getParcelableExtra(r4)
            boolean r1 = r0 instanceof android.os.ResultReceiver
            if (r1 != 0) goto L24
            r0 = r3
        L24:
            android.os.ResultReceiver r0 = (android.os.ResultReceiver) r0
        L26:
            android.os.ResultReceiver r0 = (android.os.ResultReceiver) r0
            if (r0 == 0) goto L31
            cz.mobilesoft.coreblock.activity.rating.w r1 = new cz.mobilesoft.coreblock.activity.rating.w
            r1.<init>()
            r10.f95987j = r1
        L31:
            android.content.Intent r0 = r10.getIntent()
            java.lang.String r1 = "extra_rating_dialog_type"
            java.lang.String r0 = r0.getStringExtra(r1)
            if (r0 == 0) goto L62
            kotlin.enums.EnumEntries r1 = cz.mobilesoft.coreblock.activity.rating.RatingDialogType.getEntries()
            java.util.Iterator r1 = r1.iterator()
        L45:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L5d
            java.lang.Object r2 = r1.next()
            r4 = r2
            cz.mobilesoft.coreblock.activity.rating.RatingDialogType r4 = (cz.mobilesoft.coreblock.activity.rating.RatingDialogType) r4
            java.lang.String r4 = r4.name()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r0)
            if (r4 == 0) goto L45
            goto L5e
        L5d:
            r2 = r3
        L5e:
            cz.mobilesoft.coreblock.activity.rating.RatingDialogType r2 = (cz.mobilesoft.coreblock.activity.rating.RatingDialogType) r2
            if (r2 != 0) goto L64
        L62:
            cz.mobilesoft.coreblock.activity.rating.RatingDialogType r2 = cz.mobilesoft.coreblock.activity.rating.RatingDialogType.Native
        L64:
            r10.f95990m = r2
            cz.mobilesoft.coreblock.activity.rating.RatingTriggerSource$Companion r0 = cz.mobilesoft.coreblock.activity.rating.RatingTriggerSource.Companion
            android.content.Intent r1 = r10.getIntent()
            java.lang.String r2 = "extra_rating_trigger_source"
            java.lang.String r1 = r1.getStringExtra(r2)
            cz.mobilesoft.coreblock.activity.rating.RatingTriggerSource r0 = r0.a(r1)
            r10.f95991n = r0
            android.content.Intent r0 = r10.getIntent()
            java.lang.String r1 = "extra_is_loved_it_retry"
            r2 = 0
            boolean r0 = r0.getBooleanExtra(r1, r2)
            r10.f95992o = r0
            if (r11 != 0) goto La8
            cz.mobilesoft.coreblock.activity.rating.RatingTriggerSource r0 = r10.f95991n
            if (r0 != 0) goto L91
            java.lang.String r0 = "resolvedTriggerSource"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = r3
        L91:
            cz.mobilesoft.coreblock.activity.rating.RatingTriggerSource r1 = cz.mobilesoft.coreblock.activity.rating.RatingTriggerSource.WeeklyReport
            if (r0 != r1) goto La8
            kotlinx.coroutines.CoroutineScope r4 = cz.mobilesoft.coreblock.LockieApplication.f95365k
            java.lang.String r0 = "applicationScope"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity$onCreate$3 r7 = new cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity$onCreate$3
            r7.<init>(r3)
            r8 = 3
            r9 = 0
            r5 = 0
            r6 = 0
            kotlinx.coroutines.BuildersKt.d(r4, r5, r6, r7, r8, r9)
        La8:
            super.onCreate(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity.onCreate(android.os.Bundle):void");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
