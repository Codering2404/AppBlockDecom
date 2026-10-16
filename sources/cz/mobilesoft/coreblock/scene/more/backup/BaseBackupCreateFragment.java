package cz.mobilesoft.coreblock.scene.more.backup;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.viewbinding.ViewBinding;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.fragment.BaseScrollViewFragment;
import cz.mobilesoft.coreblock.scene.more.backup.dto.BackupInfoDTO;
import cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressActivity;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.util.helperextension.DialogHelperExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public abstract class BaseBackupCreateFragment<Binding extends ViewBinding> extends BaseScrollViewFragment<Binding> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f106422d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ActivityResultLauncher f106423f;

    public BaseBackupCreateFragment() {
        final Function0<FragmentActivity> function0 = new Function0<FragmentActivity>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.BaseBackupCreateFragment$special$$inlined$sharedViewModel$default$1
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
        this.f106422d = LazyKt.a(LazyThreadSafetyMode.f139763c, new Function0<BackupMainViewModel>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.BaseBackupCreateFragment$special$$inlined$sharedViewModel$default$2
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
        ActivityResultLauncher<I> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: cz.mobilesoft.coreblock.scene.more.backup.t
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                BaseBackupCreateFragment.J(this.f106564a, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.f106423f = activityResultLauncherRegisterForActivityResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(BaseBackupCreateFragment baseBackupCreateFragment, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.d() == -1) {
            Intent intentC = result.c();
            BackupInfoDTO backupInfoDTO = (BackupInfoDTO) (intentC != null ? intentC.getSerializableExtra("BACKUP_INFO") : null);
            if (backupInfoDTO == null) {
                baseBackupCreateFragment.M().K0();
            } else {
                baseBackupCreateFragment.M().N0(backupInfoDTO);
            }
        }
    }

    private final void N() {
        BackupProgressActivity.Companion companion = BackupProgressActivity.f106450v;
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        ContextExtKt.g(this.f106423f, companion.c(fragmentActivityRequireActivity));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(BaseBackupCreateFragment baseBackupCreateFragment) {
        AnswersHelper.f128199a.F0();
        baseBackupCreateFragment.N();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q() {
        AnswersHelper.f128199a.G0();
        return Unit.f139807a;
    }

    public final ActivityResultLauncher L() {
        return this.f106423f;
    }

    public final BackupMainViewModel M() {
        return (BackupMainViewModel) this.f106422d.getValue();
    }

    public final void O() {
        if (M().L0().getValue() == null) {
            AnswersHelper.f128199a.H0();
            N();
            return;
        }
        AnswersHelper.f128199a.I0();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            DialogHelperExtKt.A(activity, R.string.E8, Integer.valueOf(R.string.D8), R.string.vc, 0, new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.backup.u
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BaseBackupCreateFragment.P(this.f106565a);
                }
            }, new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.backup.v
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BaseBackupCreateFragment.Q();
                }
            }, false, 72, null);
        }
    }
}
