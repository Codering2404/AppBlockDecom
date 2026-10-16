package cz.mobilesoft.coreblock.scene.more.backup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.fragment.BaseScrollViewFragment;
import cz.mobilesoft.coreblock.databinding.LayoutEmptyBinding;
import cz.mobilesoft.coreblock.rest.exception.GeneralApiException;
import cz.mobilesoft.coreblock.util.FailedWithError;
import cz.mobilesoft.coreblock.util.ViewModelState;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt;
import cz.mobilesoft.coreblock.view.MaterialProgressButton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class BackupEmptyFragment extends BaseScrollViewFragment<LayoutEmptyBinding> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f106355g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f106356h = 8;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final FailedWithError f106357d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f106358f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BackupEmptyFragment a(FailedWithError failedWithError) {
            return new BackupEmptyFragment(failedWithError);
        }

        private Companion() {
        }
    }

    public BackupEmptyFragment(FailedWithError failedWithError) {
        this.f106357d = failedWithError;
        final Function0<FragmentActivity> function0 = new Function0<FragmentActivity>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.BackupEmptyFragment$special$$inlined$sharedViewModel$default$1
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
        this.f106358f = LazyKt.a(LazyThreadSafetyMode.f139763c, new Function0<BackupMainViewModel>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.BackupEmptyFragment$special$$inlined$sharedViewModel$default$2
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
    }

    private final BackupMainViewModel I() {
        return (BackupMainViewModel) this.f106358f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(LayoutEmptyBinding layoutEmptyBinding, ViewModelState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        layoutEmptyBinding.f96780c.setText(it instanceof FailedWithError ? ((FailedWithError) it).d() : GeneralApiException.Companion.a());
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(BackupEmptyFragment backupEmptyFragment, View view) {
        AnswersHelper.f128199a.E0();
        backupEmptyFragment.I().K0();
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public void x(final LayoutEmptyBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        super.x(binding);
        FlowsExtKt.c(this, I().M0(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.backup.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BackupEmptyFragment.L(binding, (ViewModelState) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseScrollViewFragment, cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public void y(LayoutEmptyBinding binding, View view, Bundle bundle) {
        String string;
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(view, "view");
        super.y(binding, view, bundle);
        binding.f96782e.setImageResource(R.drawable.J7);
        TextView textView = binding.f96781d;
        FailedWithError failedWithError = this.f106357d;
        if (failedWithError == null || (string = failedWithError.d()) == null) {
            string = getString(R.string.Vz);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        }
        textView.setText(string);
        MaterialProgressButton tryAgainButton = binding.f96785h;
        Intrinsics.checkNotNullExpressionValue(tryAgainButton, "tryAgainButton");
        tryAgainButton.setVisibility(0);
        binding.f96785h.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.more.backup.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BackupEmptyFragment.N(this.f106432a, view2);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public LayoutEmptyBinding z(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        LayoutEmptyBinding layoutEmptyBindingC = LayoutEmptyBinding.c(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(layoutEmptyBindingC, "inflate(...)");
        return layoutEmptyBindingC;
    }
}
