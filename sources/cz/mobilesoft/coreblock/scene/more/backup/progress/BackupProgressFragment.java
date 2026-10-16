package cz.mobilesoft.coreblock.scene.more.backup.progress;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.compose.animation.core.Xrg.muQRKXGtpOhe;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.fragment.BaseScrollViewFragment;
import cz.mobilesoft.coreblock.databinding.FragmentBackupProgressBinding;
import cz.mobilesoft.coreblock.repository.BackupsRepository;
import cz.mobilesoft.coreblock.scene.more.backup.dto.BackupInfoDTO;
import cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressFragment;
import cz.mobilesoft.coreblock.util.FailedWithError;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.Success;
import cz.mobilesoft.coreblock.util.ViewModelState;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.DialogHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt;
import cz.mobilesoft.coreblock.util.view.ViewHelperExtKt;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.qualifier.Qualifier;

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
public final class BackupProgressFragment extends BaseScrollViewFragment<FragmentBackupProgressBinding> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Companion f106454i = new Companion(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f106455j = 8;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f106456d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f106457f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f106458g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f106459h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BackupProgressFragment a(BackupProgressType progressType, long j3) {
            Intrinsics.checkNotNullParameter(progressType, "progressType");
            BackupProgressFragment backupProgressFragment = new BackupProgressFragment();
            backupProgressFragment.setArguments(BundleKt.b(TuplesKt.a("SCREEN_TYPE", progressType), TuplesKt.a("BACKUP_ID", Long.valueOf(j3))));
            return backupProgressFragment;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f106460a;

        static {
            int[] iArr = new int[BackupProgressType.values().length];
            try {
                iArr[BackupProgressType.SEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BackupProgressType.DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BackupProgressType.DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f106460a = iArr;
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressFragment$onViewCreated$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressFragment$onViewCreated$1", f = "BackupProgressFragment.kt", l = {74, 75, 89}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f106461a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressFragment$onViewCreated$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressFragment$onViewCreated$1$1", f = "BackupProgressFragment.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class C02811 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f106463a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ BackupProgressFragment f106464b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02811(BackupProgressFragment backupProgressFragment, Continuation continuation) {
                super(2, continuation);
                this.f106464b = backupProgressFragment;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit y(BackupProgressFragment backupProgressFragment) {
                backupProgressFragment.V().c1(true);
                return Unit.f139807a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit z(BackupProgressFragment backupProgressFragment) {
                FragmentActivity activity = backupProgressFragment.getActivity();
                if (activity != null) {
                    activity.finish();
                }
                return Unit.f139807a;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new C02811(this.f106464b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.f();
                if (this.f106463a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                FragmentActivity activity = this.f106464b.getActivity();
                if (activity != null) {
                    int i3 = R.string.W2;
                    Integer numD = Boxing.d(R.string.V2);
                    int i4 = R.string.l8;
                    final BackupProgressFragment backupProgressFragment = this.f106464b;
                    Function0 function0 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.backup.progress.l
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BackupProgressFragment.AnonymousClass1.C02811.y(backupProgressFragment);
                        }
                    };
                    final BackupProgressFragment backupProgressFragment2 = this.f106464b;
                    DialogHelperExtKt.A(activity, i3, numD, i4, 0, function0, new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.backup.progress.m
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BackupProgressFragment.AnonymousClass1.C02811.z(backupProgressFragment2);
                        }
                    }, false, 72, null);
                }
                return Unit.f139807a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((C02811) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressFragment$onViewCreated$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressFragment$onViewCreated$1$2", f = "BackupProgressFragment.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f106465a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ BackupProgressFragment f106466b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(BackupProgressFragment backupProgressFragment, Continuation continuation) {
                super(2, continuation);
                this.f106466b = backupProgressFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new AnonymousClass2(this.f106466b, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.f();
                if (this.f106465a == 0) {
                    ResultKt.b(obj);
                    BackupProgressViewModel.d1(this.f106466b.V(), false, 1, null);
                    return Unit.f139807a;
                }
                throw new IllegalStateException(muQRKXGtpOhe.DQPehXJrBXB);
            }
        }

        AnonymousClass1(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return BackupProgressFragment.this.new AnonymousClass1(continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x004e, code lost:
        
            if (kotlinx.coroutines.BuildersKt.g(r6, r2, r5) == r0) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0062, code lost:
        
            if (kotlinx.coroutines.BuildersKt.g(r6, r3, r5) == r0) goto L22;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r5.f106461a
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L22
                if (r1 == r4) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                goto L1a
            L12:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1a:
                kotlin.ResultKt.b(r6)
                goto L65
            L1e:
                kotlin.ResultKt.b(r6)
                goto L34
            L22:
                kotlin.ResultKt.b(r6)
                cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressFragment r6 = cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressFragment.this
                cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressViewModel r6 = cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressFragment.R(r6)
                r5.f106461a = r4
                java.lang.Object r6 = r6.b1(r5)
                if (r6 != r0) goto L34
                goto L64
            L34:
                java.lang.Boolean r6 = (java.lang.Boolean) r6
                boolean r6 = r6.booleanValue()
                r1 = 0
                if (r6 == 0) goto L51
                kotlinx.coroutines.MainCoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.c()
                cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressFragment$onViewCreated$1$1 r2 = new cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressFragment$onViewCreated$1$1
                cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressFragment r4 = cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressFragment.this
                r2.<init>(r4, r1)
                r5.f106461a = r3
                java.lang.Object r6 = kotlinx.coroutines.BuildersKt.g(r6, r2, r5)
                if (r6 != r0) goto L65
                goto L64
            L51:
                kotlinx.coroutines.MainCoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.c()
                cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressFragment$onViewCreated$1$2 r3 = new cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressFragment$onViewCreated$1$2
                cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressFragment r4 = cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressFragment.this
                r3.<init>(r4, r1)
                r5.f106461a = r2
                java.lang.Object r6 = kotlinx.coroutines.BuildersKt.g(r6, r3, r5)
                if (r6 != r0) goto L65
            L64:
                return r0
            L65:
                kotlin.Unit r6 = kotlin.Unit.f139807a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressFragment.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    public BackupProgressFragment() {
        final Function0<FragmentActivity> function0 = new Function0<FragmentActivity>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressFragment$special$$inlined$sharedViewModel$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final FragmentActivity invoke() {
                FragmentActivity fragmentActivityRequireActivity = this.requireActivity();
                Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
                return fragmentActivityRequireActivity;
            }
        };
        final Qualifier qualifier = null;
        final Function0 function02 = null;
        final Function0 function03 = null;
        this.f106456d = LazyKt.a(LazyThreadSafetyMode.f139763c, new Function0<BackupProgressViewModel>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressFragment$special$$inlined$sharedViewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final ViewModel invoke() {
                CreationExtras defaultViewModelCreationExtras;
                Fragment fragment = this;
                Qualifier qualifier2 = qualifier;
                Function0 function04 = function0;
                Function0 function05 = function02;
                Function0 function06 = function03;
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) function04.invoke()).getViewModelStore();
                if (function05 == null || (defaultViewModelCreationExtras = (CreationExtras) function05.invoke()) == null) {
                    defaultViewModelCreationExtras = fragment.getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                }
                return GetViewModelKt.b(Reflection.b(BackupProgressViewModel.class), viewModelStore, null, defaultViewModelCreationExtras, qualifier2, AndroidKoinScopeExtKt.a(fragment), function06, 4, null);
            }
        });
        this.f106457f = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.backup.progress.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(BackupProgressFragment.g0(this.f106553a));
            }
        });
        this.f106458g = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.backup.progress.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BackupProgressFragment.h0(this.f106554a);
            }
        });
        this.f106459h = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.backup.progress.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(BackupProgressFragment.S(this.f106555a));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long S(BackupProgressFragment backupProgressFragment) {
        return backupProgressFragment.requireArguments().getLong("BACKUP_ID");
    }

    private final long T() {
        return ((Number) this.f106459h.getValue()).longValue();
    }

    private final BackupProgressType U() {
        return (BackupProgressType) this.f106458g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BackupProgressViewModel V() {
        return (BackupProgressViewModel) this.f106456d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(BackupProgressFragment backupProgressFragment, FragmentBackupProgressBinding fragmentBackupProgressBinding, ViewModelState viewModelState) {
        Intrinsics.checkNotNullParameter(viewModelState, "viewModelState");
        if (viewModelState instanceof Loading) {
            backupProgressFragment.l0(fragmentBackupProgressBinding);
        } else if (viewModelState instanceof FailedWithError) {
            String string = backupProgressFragment.getString(R.string.XE);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            backupProgressFragment.j0(fragmentBackupProgressBinding, string, ((FailedWithError) viewModelState).d());
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(BackupProgressFragment backupProgressFragment, FragmentBackupProgressBinding fragmentBackupProgressBinding, float f3) {
        if (f3 < 1.0f) {
            backupProgressFragment.p0(fragmentBackupProgressBinding, f3);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(BackupProgressFragment backupProgressFragment, FragmentBackupProgressBinding fragmentBackupProgressBinding, ViewModelState viewModelState, BackupInfoDTO backupInfoDTO) {
        Intrinsics.checkNotNullParameter(viewModelState, "viewModelState");
        if ((viewModelState instanceof Success) && backupInfoDTO != null) {
            f0(backupProgressFragment, null, 1, null);
            String string = backupProgressFragment.getString(R.string.T2);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            n0(backupProgressFragment, fragmentBackupProgressBinding, backupInfoDTO, string, null, null, 12, null);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a0(BackupProgressFragment backupProgressFragment, FragmentBackupProgressBinding fragmentBackupProgressBinding, ViewModelState viewModelState, BackupsRepository.BackupRestoreSuccessDTO backupRestoreSuccessDTO) {
        Intrinsics.checkNotNullParameter(viewModelState, "viewModelState");
        if ((viewModelState instanceof Success) && backupRestoreSuccessDTO != null) {
            int iE = backupRestoreSuccessDTO.e() - backupRestoreSuccessDTO.d();
            String quantityString = iE > 0 ? backupProgressFragment.getResources().getQuantityString(R.plurals.f95745f, iE, Integer.valueOf(iE)) : null;
            backupProgressFragment.e0(backupRestoreSuccessDTO);
            String string = backupProgressFragment.getString(R.string.Fs);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            backupProgressFragment.m0(fragmentBackupProgressBinding, null, string, quantityString, backupRestoreSuccessDTO);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(BackupProgressFragment backupProgressFragment, FragmentBackupProgressBinding fragmentBackupProgressBinding, ViewModelState viewModelState) {
        Intrinsics.checkNotNullParameter(viewModelState, "viewModelState");
        if (viewModelState instanceof Success) {
            f0(backupProgressFragment, null, 1, null);
            String string = backupProgressFragment.getString(R.string.u9);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            n0(backupProgressFragment, fragmentBackupProgressBinding, null, string, null, null, 12, null);
        }
        return Unit.f139807a;
    }

    private final void d0() {
        int i3 = WhenMappings.f106460a[U().ordinal()];
        if (i3 == 1) {
            AnswersHelper.f128199a.J0();
        } else if (i3 == 2) {
            AnswersHelper.f128199a.O0();
        } else {
            if (i3 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            AnswersHelper.f128199a.B0();
        }
    }

    private final void e0(BackupsRepository.BackupRestoreSuccessDTO backupRestoreSuccessDTO) {
        int i3 = WhenMappings.f106460a[U().ordinal()];
        if (i3 == 1) {
            AnswersHelper.f128199a.K0();
        } else if (i3 == 2) {
            AnswersHelper.f128199a.P0(backupRestoreSuccessDTO);
        } else {
            if (i3 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            AnswersHelper.f128199a.C0();
        }
    }

    static /* synthetic */ void f0(BackupProgressFragment backupProgressFragment, BackupsRepository.BackupRestoreSuccessDTO backupRestoreSuccessDTO, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            backupRestoreSuccessDTO = null;
        }
        backupProgressFragment.e0(backupRestoreSuccessDTO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int g0(BackupProgressFragment backupProgressFragment) {
        return ContextCompat.getColor(backupProgressFragment.requireContext(), R.color.f95446a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BackupProgressType h0(BackupProgressFragment backupProgressFragment) {
        Serializable serializable = backupProgressFragment.requireArguments().getSerializable("SCREEN_TYPE");
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressType");
        return (BackupProgressType) serializable;
    }

    private final void j0(FragmentBackupProgressBinding fragmentBackupProgressBinding, String str, String str2) {
        TextView titleTextView = fragmentBackupProgressBinding.f96628h;
        Intrinsics.checkNotNullExpressionValue(titleTextView, "titleTextView");
        titleTextView.setVisibility(8);
        TextView percentTextView = fragmentBackupProgressBinding.f96625e;
        Intrinsics.checkNotNullExpressionValue(percentTextView, "percentTextView");
        percentTextView.setVisibility(8);
        ImageView checkImageView = fragmentBackupProgressBinding.f96622b;
        Intrinsics.checkNotNullExpressionValue(checkImageView, "checkImageView");
        checkImageView.setVisibility(8);
        CircularProgressIndicator progressBar = fragmentBackupProgressBinding.f96626f;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        progressBar.setVisibility(8);
        Button okButton = fragmentBackupProgressBinding.f96624d;
        Intrinsics.checkNotNullExpressionValue(okButton, "okButton");
        okButton.setVisibility(8);
        TextView messageTextView = fragmentBackupProgressBinding.f96623c;
        Intrinsics.checkNotNullExpressionValue(messageTextView, "messageTextView");
        messageTextView.setVisibility(8);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            DialogHelperExtKt.K(activity, str, str2, false, new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.backup.progress.k
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BackupProgressFragment.k0(this.f106559a);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k0(BackupProgressFragment backupProgressFragment) {
        FragmentActivity activity = backupProgressFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
        return Unit.f139807a;
    }

    private final void l0(FragmentBackupProgressBinding fragmentBackupProgressBinding) {
        int i3;
        TextView textView = fragmentBackupProgressBinding.f96628h;
        int i4 = WhenMappings.f106460a[U().ordinal()];
        if (i4 == 1) {
            i3 = R.string.S2;
        } else if (i4 == 2) {
            i3 = R.string.Hs;
        } else {
            if (i4 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            i3 = R.string.w9;
        }
        textView.setText(i3);
        p0(fragmentBackupProgressBinding, ((Number) V().W0().getValue()).floatValue());
        TextView titleTextView = fragmentBackupProgressBinding.f96628h;
        Intrinsics.checkNotNullExpressionValue(titleTextView, "titleTextView");
        titleTextView.setVisibility(0);
        TextView percentTextView = fragmentBackupProgressBinding.f96625e;
        Intrinsics.checkNotNullExpressionValue(percentTextView, "percentTextView");
        percentTextView.setVisibility(0);
        ImageView checkImageView = fragmentBackupProgressBinding.f96622b;
        Intrinsics.checkNotNullExpressionValue(checkImageView, "checkImageView");
        checkImageView.setVisibility(8);
        CircularProgressIndicator progressBar = fragmentBackupProgressBinding.f96626f;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        progressBar.setVisibility(0);
        Button okButton = fragmentBackupProgressBinding.f96624d;
        Intrinsics.checkNotNullExpressionValue(okButton, "okButton");
        okButton.setVisibility(8);
        TextView messageTextView = fragmentBackupProgressBinding.f96623c;
        Intrinsics.checkNotNullExpressionValue(messageTextView, "messageTextView");
        messageTextView.setVisibility(8);
    }

    private final void m0(FragmentBackupProgressBinding fragmentBackupProgressBinding, final BackupInfoDTO backupInfoDTO, String str, String str2, final BackupsRepository.BackupRestoreSuccessDTO backupRestoreSuccessDTO) {
        TextView titleTextView = fragmentBackupProgressBinding.f96628h;
        Intrinsics.checkNotNullExpressionValue(titleTextView, "titleTextView");
        titleTextView.setVisibility(0);
        TextView percentTextView = fragmentBackupProgressBinding.f96625e;
        Intrinsics.checkNotNullExpressionValue(percentTextView, "percentTextView");
        percentTextView.setVisibility(8);
        ImageView checkImageView = fragmentBackupProgressBinding.f96622b;
        Intrinsics.checkNotNullExpressionValue(checkImageView, "checkImageView");
        checkImageView.setVisibility(0);
        fragmentBackupProgressBinding.f96626f.setVisibility(4);
        Button okButton = fragmentBackupProgressBinding.f96624d;
        Intrinsics.checkNotNullExpressionValue(okButton, "okButton");
        okButton.setVisibility(0);
        TextView titleTextView2 = fragmentBackupProgressBinding.f96628h;
        Intrinsics.checkNotNullExpressionValue(titleTextView2, "titleTextView");
        titleTextView2.setVisibility(0);
        fragmentBackupProgressBinding.f96628h.setText(str);
        if ((backupRestoreSuccessDTO != null ? backupRestoreSuccessDTO.c() : null) != null) {
            TextView messageTextView = fragmentBackupProgressBinding.f96623c;
            Intrinsics.checkNotNullExpressionValue(messageTextView, "messageTextView");
            messageTextView.setVisibility(0);
            fragmentBackupProgressBinding.f96623c.setText(getString(R.string.Yb));
        } else if (str2 == null || str2.length() == 0) {
            TextView messageTextView2 = fragmentBackupProgressBinding.f96623c;
            Intrinsics.checkNotNullExpressionValue(messageTextView2, "messageTextView");
            messageTextView2.setVisibility(8);
        } else {
            TextView messageTextView3 = fragmentBackupProgressBinding.f96623c;
            Intrinsics.checkNotNullExpressionValue(messageTextView3, "messageTextView");
            messageTextView3.setVisibility(0);
            TextView messageTextView4 = fragmentBackupProgressBinding.f96623c;
            Intrinsics.checkNotNullExpressionValue(messageTextView4, "messageTextView");
            ViewHelperExtKt.m(messageTextView4, str2, false, 2, null);
        }
        fragmentBackupProgressBinding.f96624d.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.more.backup.progress.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BackupProgressFragment.o0(this.f106556a, backupRestoreSuccessDTO, backupInfoDTO, view);
            }
        });
        ImageView checkImageView2 = fragmentBackupProgressBinding.f96622b;
        Intrinsics.checkNotNullExpressionValue(checkImageView2, "checkImageView");
        ViewHelperExtKt.b(checkImageView2);
    }

    static /* synthetic */ void n0(BackupProgressFragment backupProgressFragment, FragmentBackupProgressBinding fragmentBackupProgressBinding, BackupInfoDTO backupInfoDTO, String str, String str2, BackupsRepository.BackupRestoreSuccessDTO backupRestoreSuccessDTO, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            backupInfoDTO = null;
        }
        if ((i3 & 4) != 0) {
            str2 = null;
        }
        if ((i3 & 8) != 0) {
            backupRestoreSuccessDTO = null;
        }
        backupProgressFragment.m0(fragmentBackupProgressBinding, backupInfoDTO, str, str2, backupRestoreSuccessDTO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(BackupProgressFragment backupProgressFragment, BackupsRepository.BackupRestoreSuccessDTO backupRestoreSuccessDTO, BackupInfoDTO backupInfoDTO, View view) {
        backupProgressFragment.d0();
        if ((backupRestoreSuccessDTO != null ? backupRestoreSuccessDTO.c() : null) != null) {
            backupProgressFragment.V().e1(backupRestoreSuccessDTO.c().intValue());
            return;
        }
        FragmentActivity activity = backupProgressFragment.getActivity();
        if (activity != null) {
            Intent intent = new Intent();
            if (backupInfoDTO != null) {
                intent.putExtra("BACKUP_INFO", backupInfoDTO);
            }
            activity.setResult(-1, intent);
            activity.finish();
        }
    }

    private final void p0(FragmentBackupProgressBinding fragmentBackupProgressBinding, float f3) {
        double d3 = ((double) f3) * 100.0d;
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        String str = String.format(Locale.getDefault(), "%d%%", Arrays.copyOf(new Object[]{Integer.valueOf(MathKt.c(d3))}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new TextAppearanceSpan(getContext(), R.style.f95873h), spannableString.length() - 1, spannableString.length(), 33);
        fragmentBackupProgressBinding.f96625e.setText(spannableString);
        fragmentBackupProgressBinding.f96626f.setCurrentProgress(d3);
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public void x(final FragmentBackupProgressBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        super.x(binding);
        FlowsExtKt.c(this, V().X0(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.backup.progress.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BackupProgressFragment.X(this.f106543a, binding, (ViewModelState) obj);
            }
        });
        FlowsExtKt.c(this, V().W0(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.backup.progress.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BackupProgressFragment.Y(this.f106545a, binding, ((Float) obj).floatValue());
            }
        });
        int i3 = WhenMappings.f106460a[U().ordinal()];
        if (i3 == 1) {
            FlowsExtKt.a(this, V().X0(), V().V0(), new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.backup.progress.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BackupProgressFragment.Z(this.f106547a, binding, (ViewModelState) obj, (BackupInfoDTO) obj2);
                }
            });
        } else if (i3 == 2) {
            FlowsExtKt.a(this, V().X0(), V().Y0(), new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.backup.progress.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BackupProgressFragment.a0(this.f106549a, binding, (ViewModelState) obj, (BackupsRepository.BackupRestoreSuccessDTO) obj2);
                }
            });
        } else {
            if (i3 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            FlowsExtKt.c(this, V().X0(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.backup.progress.f
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BackupProgressFragment.b0(this.f106551a, binding, (ViewModelState) obj);
                }
            });
        }
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseScrollViewFragment, cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
    public void y(FragmentBackupProgressBinding binding, View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(view, "view");
        super.y(binding, view, bundle);
        binding.f96626f.setMaxProgress(100.0d);
        binding.f96626f.setProgressGap(1.1d);
        binding.f96626f.setAnimationDuration(100);
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public FragmentBackupProgressBinding z(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentBackupProgressBinding fragmentBackupProgressBindingC = FragmentBackupProgressBinding.c(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(fragmentBackupProgressBindingC, "inflate(...)");
        return fragmentBackupProgressBindingC;
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        if (bundle == null) {
            int i3 = WhenMappings.f106460a[U().ordinal()];
            if (i3 == 1) {
                CoroutinesHelperExtKt.d(new AnonymousClass1(null));
            } else if (i3 == 2) {
                V().U0(T());
            } else {
                if (i3 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                V().T0();
            }
        }
    }
}
