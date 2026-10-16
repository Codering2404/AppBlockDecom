package cz.mobilesoft.coreblock.scene.more.backup;

import android.content.ComponentCallbacks;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.fragment.BaseFragment;
import cz.mobilesoft.coreblock.databinding.FragmentBackupMainBinding;
import cz.mobilesoft.coreblock.enums.SignInEntryPoint;
import cz.mobilesoft.coreblock.enums.StrictModeTitleAlternatives;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.more.backup.BackupEmptyFragment;
import cz.mobilesoft.coreblock.scene.more.backup.BackupMainFragment;
import cz.mobilesoft.coreblock.scene.more.backup.dto.BackupInfoDTO;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.Canceled;
import cz.mobilesoft.coreblock.util.FailedWithError;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.Success;
import cz.mobilesoft.coreblock.util.ViewModelState;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.DialogHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt;
import cz.mobilesoft.coreblock.util.view.ViewHelperExtKt;
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
public final class BackupMainFragment extends BaseFragment<FragmentBackupMainBinding> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f106369f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f106370g = 8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f106371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f106372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f106373d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BackupMainFragment a() {
            return new BackupMainFragment();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.backup.BackupMainFragment$onOptionsItemSelected$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.backup.BackupMainFragment$onOptionsItemSelected$1", f = "BackupMainFragment.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f106374a;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit y(final BackupMainFragment backupMainFragment) {
            AnswersHelper.f128199a.I2(SignInEntryPoint.BACKUP);
            backupMainFragment.E().O0(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.backup.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BackupMainFragment.AnonymousClass1.z(backupMainFragment, ((Boolean) obj).booleanValue(), (String) obj2);
                }
            });
            return Unit.f139807a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit z(BackupMainFragment backupMainFragment, boolean z2, String str) {
            FragmentActivity activity = backupMainFragment.getActivity();
            if (activity != null) {
                activity.finish();
            }
            return Unit.f139807a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return BackupMainFragment.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f106374a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            if (BackupMainFragment.this.D().n()) {
                ViewHelperExtKt.u(BackupMainFragment.this, StrictModeTitleAlternatives.Companion.a());
            } else {
                AnswersHelper.f128199a.H2(SignInEntryPoint.BACKUP);
                FragmentActivity activity = BackupMainFragment.this.getActivity();
                if (activity != null) {
                    int i3 = R.string.es;
                    int i4 = R.string.tx;
                    final BackupMainFragment backupMainFragment = BackupMainFragment.this;
                    DialogHelperExtKt.A(activity, i3, null, i4, 0, new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.backup.f
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BackupMainFragment.AnonymousClass1.y(backupMainFragment);
                        }
                    }, null, false, 106, null);
                }
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BackupMainFragment() {
        final Function0<FragmentActivity> function0 = new Function0<FragmentActivity>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.BackupMainFragment$special$$inlined$sharedViewModel$default$1
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
        this.f106371b = LazyKt.a(LazyThreadSafetyMode.f139763c, new Function0<BackupMainViewModel>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.BackupMainFragment$special$$inlined$sharedViewModel$default$2
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
                return GetViewModelKt.b(Reflection.b(BackupMainViewModel.class), viewModelStore, null, defaultViewModelCreationExtras, qualifier2, AndroidKoinScopeExtKt.a(fragment), function06, 4, null);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f139761a;
        final Qualifier qualifier2 = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f106372c = LazyKt.a(lazyThreadSafetyMode, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.BackupMainFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(ProfileDao.class), qualifier2, objArr);
            }
        });
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f106373d = LazyKt.a(lazyThreadSafetyMode, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.BackupMainFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(StrictModeRepository.class), objArr2, objArr3);
            }
        });
    }

    private final Fragment C() {
        return getChildFragmentManager().m0(R.id.f95667u0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeRepository D() {
        return (StrictModeRepository) this.f106373d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(FragmentBackupMainBinding fragmentBackupMainBinding, BackupMainFragment backupMainFragment, ViewModelState state, BackupInfoDTO backupInfoDTO) {
        Intrinsics.checkNotNullParameter(state, "state");
        ProgressBar progressBar = fragmentBackupMainBinding.f96610c;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        boolean z2 = state instanceof Loading;
        progressBar.setVisibility(z2 ? 0 : 8);
        FragmentContainerView fragmentContainer = fragmentBackupMainBinding.f96609b;
        Intrinsics.checkNotNullExpressionValue(fragmentContainer, "fragmentContainer");
        fragmentContainer.setVisibility(z2 ? 8 : 0);
        boolean z3 = state instanceof FailedWithError;
        if ((z3 || (state instanceof Canceled)) && !(backupMainFragment.C() instanceof BackupEmptyFragment)) {
            AnswersHelper.f128199a.D0();
            BackupEmptyFragment.Companion companion = BackupEmptyFragment.f106355g;
            if (!z3) {
                state = null;
            }
            Intrinsics.checkNotNull(state, "null cannot be cast to non-null type cz.mobilesoft.coreblock.util.FailedWithError");
            backupMainFragment.J(companion.a((FailedWithError) state));
        } else if (state instanceof Success) {
            if (backupInfoDTO != null) {
                if (!(backupMainFragment.C() instanceof BackupOverviewFragment)) {
                    backupMainFragment.J(BackupOverviewFragment.f106416h.a());
                }
            } else if (!(backupMainFragment.C() instanceof BackupCreateFragment)) {
                backupMainFragment.J(BackupCreateFragment.f106353g.a());
            }
        }
        return Unit.f139807a;
    }

    private final void J(Fragment fragment) {
        getChildFragmentManager().q().s(R.id.f95667u0, fragment).j();
    }

    public final BackupMainViewModel E() {
        return (BackupMainViewModel) this.f106371b.getValue();
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public void x(final FragmentBackupMainBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        super.x(binding);
        FlowsExtKt.a(this, E().M0(), E().L0(), new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.backup.e
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return BackupMainFragment.G(binding, this, (ViewModelState) obj, (BackupInfoDTO) obj2);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public void y(FragmentBackupMainBinding binding, View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(view, "view");
        super.y(binding, view, bundle);
        if (bundle == null) {
            PrefManager.f126839a.y2(false);
            E().K0();
        }
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public FragmentBackupMainBinding z(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentBackupMainBinding fragmentBackupMainBindingC = FragmentBackupMainBinding.c(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(fragmentBackupMainBindingC, "inflate(...)");
        return fragmentBackupMainBindingC;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        inflater.inflate(R.menu.f95735c, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() != R.id.f95601d) {
            return super.onOptionsItemSelected(item);
        }
        BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), null, null, new AnonymousClass1(null), 3, null);
        return true;
    }
}
