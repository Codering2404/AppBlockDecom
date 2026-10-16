package cz.mobilesoft.coreblock.scene.more.academy.course;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.exoplayer.audio.wRw.CbYNFSEGaQj;
import com.bumptech.glide.RequestManager;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.fragment.BaseFragment;
import cz.mobilesoft.coreblock.databinding.FragmentAcademyCourseFinishedBinding;
import cz.mobilesoft.coreblock.storage.room.academy.AcademyCourseWithLessons;
import cz.mobilesoft.coreblock.storage.room.entity.core.AcademyCourseEntity;
import cz.mobilesoft.coreblock.util.NetworkHelperKt;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.LiveDataExtKt;
import cz.mobilesoft.coreblock.util.view.ViewHelperExtKt;
import cz.mobilesoft.coreblock.view.transformation.SvgSoftwareLayerSetter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.experimental.kJ.HcgZcEUYo;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import nl.dionsegijn.konfetti.KonfettiView;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
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
public final class AcademyCourseFinishedFragment extends BaseFragment<FragmentAcademyCourseFinishedBinding> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f106120c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f106121d = 8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f106122b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AcademyCourseFinishedFragment a(long j3) {
            AcademyCourseFinishedFragment academyCourseFinishedFragment = new AcademyCourseFinishedFragment();
            academyCourseFinishedFragment.setArguments(BundleKt.b(TuplesKt.a(HcgZcEUYo.UfDaQBDrhVVg, Long.valueOf(j3))));
            return academyCourseFinishedFragment;
        }
    }

    public AcademyCourseFinishedFragment() {
        final Function0 function0 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.academy.course.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AcademyCourseFinishedFragment.N(this.f106174a);
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: cz.mobilesoft.coreblock.scene.more.academy.course.AcademyCourseFinishedFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Fragment invoke() {
                return this;
            }
        };
        final Qualifier qualifier = null;
        final Function0 function03 = null;
        this.f106122b = LazyKt.a(LazyThreadSafetyMode.f139763c, new Function0<AcademyCourseFinishedViewModel>() { // from class: cz.mobilesoft.coreblock.scene.more.academy.course.AcademyCourseFinishedFragment$special$$inlined$viewModel$default$2
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
                Function0 function04 = function02;
                Function0 function05 = function03;
                Function0 function06 = function0;
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) function04.invoke()).getViewModelStore();
                if (function05 == null || (defaultViewModelCreationExtras = (CreationExtras) function05.invoke()) == null) {
                    defaultViewModelCreationExtras = fragment.getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                }
                return GetViewModelKt.b(Reflection.b(AcademyCourseFinishedViewModel.class), viewModelStore, null, defaultViewModelCreationExtras, qualifier2, AndroidKoinScopeExtKt.a(fragment), function06, 4, null);
            }
        });
    }

    private final AcademyCourseFinishedViewModel F() {
        return (AcademyCourseFinishedViewModel) this.f106122b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(AcademyCourseFinishedFragment academyCourseFinishedFragment, final FragmentAcademyCourseFinishedBinding fragmentAcademyCourseFinishedBinding, AcademyCourseWithLessons academyCourseWithLessons) {
        final AcademyCourseEntity academyCourseEntityA;
        if (academyCourseWithLessons != null && (academyCourseEntityA = academyCourseWithLessons.a()) != null) {
            ViewHelperExtKt.f(academyCourseFinishedFragment.getActivity(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.academy.course.e
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AcademyCourseFinishedFragment.I(academyCourseEntityA, fragmentAcademyCourseFinishedBinding, (RequestManager) obj);
                }
            });
            TextView text1 = fragmentAcademyCourseFinishedBinding.f96568j;
            Intrinsics.checkNotNullExpressionValue(text1, "text1");
            String string = academyCourseFinishedFragment.getString(R.string.F7, academyCourseEntityA.f());
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            ViewHelperExtKt.m(text1, string, false, 2, null);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(AcademyCourseEntity academyCourseEntity, FragmentAcademyCourseFinishedBinding fragmentAcademyCourseFinishedBinding, RequestManager glideSafe) {
        Intrinsics.checkNotNullParameter(glideSafe, "$this$glideSafe");
        NetworkHelperKt.e(glideSafe, academyCourseEntity.b(), 0, 0, 6, null).H0(new SvgSoftwareLayerSetter()).F0(fragmentAcademyCourseFinishedBinding.f96564f);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(AcademyCourseFinishedFragment academyCourseFinishedFragment, View view) {
        AnswersHelper.f128199a.y();
        FragmentActivity activity = academyCourseFinishedFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(AcademyCourseFinishedFragment academyCourseFinishedFragment, View view) {
        AnswersHelper.f128199a.x();
        FragmentActivity activity = academyCourseFinishedFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public void y(final FragmentAcademyCourseFinishedBinding binding, View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(view, "view");
        super.y(binding, view, bundle);
        KonfettiView confettiView = binding.f96562d;
        Intrinsics.checkNotNullExpressionValue(confettiView, "confettiView");
        ViewHelperExtKt.c(confettiView);
        LiveDataExtKt.c(this, F().I0(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.academy.course.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AcademyCourseFinishedFragment.H(this.f106170a, binding, (AcademyCourseWithLessons) obj);
            }
        });
        binding.f96563e.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.more.academy.course.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AcademyCourseFinishedFragment.J(this.f106172a, view2);
            }
        });
        binding.f96561c.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.more.academy.course.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AcademyCourseFinishedFragment.L(this.f106173a, view2);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public FragmentAcademyCourseFinishedBinding z(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentAcademyCourseFinishedBinding fragmentAcademyCourseFinishedBindingC = FragmentAcademyCourseFinishedBinding.c(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(fragmentAcademyCourseFinishedBindingC, "inflate(...)");
        return fragmentAcademyCourseFinishedBindingC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder N(AcademyCourseFinishedFragment academyCourseFinishedFragment) {
        Long lValueOf;
        Bundle arguments = academyCourseFinishedFragment.getArguments();
        if (arguments != null) {
            lValueOf = Long.valueOf(arguments.getLong(CbYNFSEGaQj.erzxChKYNJ, -1L));
        } else {
            lValueOf = null;
        }
        return ParametersHolderKt.b(lValueOf);
    }
}
