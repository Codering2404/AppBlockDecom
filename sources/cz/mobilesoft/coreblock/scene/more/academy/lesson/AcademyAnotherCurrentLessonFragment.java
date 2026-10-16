package cz.mobilesoft.coreblock.scene.more.academy.lesson;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bumptech.glide.RequestManager;
import cz.mobilesoft.coreblock.base.fragment.BaseFragment;
import cz.mobilesoft.coreblock.databinding.FragmentAcademyAnotherCurrentLessonBinding;
import cz.mobilesoft.coreblock.scene.more.academy.AcademyLessonState;
import cz.mobilesoft.coreblock.storage.room.academy.AcademyLessonWithCourse;
import cz.mobilesoft.coreblock.util.NetworkHelperKt;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.view.ViewHelperExtKt;
import cz.mobilesoft.coreblock.view.transformation.SvgSoftwareLayerSetter;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
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
public final class AcademyAnotherCurrentLessonFragment extends BaseFragment<FragmentAcademyAnotherCurrentLessonBinding> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f106194c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f106195d = 8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f106196b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AcademyAnotherCurrentLessonFragment a(long j3, long j4) {
            AcademyAnotherCurrentLessonFragment academyAnotherCurrentLessonFragment = new AcademyAnotherCurrentLessonFragment();
            academyAnotherCurrentLessonFragment.setArguments(BundleKt.b(TuplesKt.a("LESSON_ID", TuplesKt.a(Long.valueOf(j3), Long.valueOf(j4)))));
            return academyAnotherCurrentLessonFragment;
        }

        private Companion() {
        }
    }

    public AcademyAnotherCurrentLessonFragment() {
        final Function0 function0 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AcademyAnotherCurrentLessonFragment.S(this.f106323a);
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyAnotherCurrentLessonFragment$special$$inlined$viewModel$default$1
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
        this.f106196b = LazyKt.a(LazyThreadSafetyMode.f139763c, new Function0<AcademyAnotherCurrentLessonViewModel>() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyAnotherCurrentLessonFragment$special$$inlined$viewModel$default$2
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
                return GetViewModelKt.b(Reflection.b(AcademyAnotherCurrentLessonViewModel.class), viewModelStore, null, defaultViewModelCreationExtras, qualifier2, AndroidKoinScopeExtKt.a(fragment), function06, 4, null);
            }
        });
    }

    private final void G(long j3, AcademyLessonState academyLessonState) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Intent intent = new Intent();
            intent.putExtra("LESSON_ID", j3);
            intent.putExtra("LESSON_STATE", academyLessonState);
            activity.setResult(-1, intent);
            activity.finish();
        }
    }

    private final AcademyAnotherCurrentLessonViewModel H() {
        return (AcademyAnotherCurrentLessonViewModel) this.f106196b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(AcademyAnotherCurrentLessonFragment academyAnotherCurrentLessonFragment, FragmentAcademyAnotherCurrentLessonBinding fragmentAcademyAnotherCurrentLessonBinding, AcademyLessonWithCourse academyLessonWithCourse) {
        ImageView currentImageView = fragmentAcademyAnotherCurrentLessonBinding.f96550c;
        Intrinsics.checkNotNullExpressionValue(currentImageView, "currentImageView");
        academyAnotherCurrentLessonFragment.P(academyLessonWithCourse, currentImageView);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(AcademyAnotherCurrentLessonFragment academyAnotherCurrentLessonFragment, FragmentAcademyAnotherCurrentLessonBinding fragmentAcademyAnotherCurrentLessonBinding, AcademyLessonWithCourse academyLessonWithCourse) {
        ImageView newImageView = fragmentAcademyAnotherCurrentLessonBinding.f96552e;
        Intrinsics.checkNotNullExpressionValue(newImageView, "newImageView");
        academyAnotherCurrentLessonFragment.P(academyLessonWithCourse, newImageView);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(AcademyAnotherCurrentLessonFragment academyAnotherCurrentLessonFragment, View view) {
        AnswersHelper.f128199a.K();
        academyAnotherCurrentLessonFragment.G(academyAnotherCurrentLessonFragment.H().L0(), AcademyLessonState.AVAILABLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(AcademyAnotherCurrentLessonFragment academyAnotherCurrentLessonFragment, View view) {
        AnswersHelper.f128199a.A();
        academyAnotherCurrentLessonFragment.G(academyAnotherCurrentLessonFragment.H().J0(), AcademyLessonState.CURRENT);
    }

    private final void P(final AcademyLessonWithCourse academyLessonWithCourse, final ImageView imageView) {
        if (academyLessonWithCourse != null) {
            ViewHelperExtKt.f(getActivity(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.f
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AcademyAnotherCurrentLessonFragment.Q(academyLessonWithCourse, imageView, (RequestManager) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(AcademyLessonWithCourse academyLessonWithCourse, ImageView imageView, RequestManager glideSafe) {
        Intrinsics.checkNotNullParameter(glideSafe, "$this$glideSafe");
        NetworkHelperKt.e(glideSafe, academyLessonWithCourse.a().b(), 0, 0, 6, null).H0(new SvgSoftwareLayerSetter()).F0(imageView);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder S(AcademyAnotherCurrentLessonFragment academyAnotherCurrentLessonFragment) {
        Bundle arguments = academyAnotherCurrentLessonFragment.getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("LESSON_ID") : null;
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type kotlin.Pair<kotlin.Long, kotlin.Long>");
        Pair pair = (Pair) serializable;
        return ParametersHolderKt.b(Long.valueOf(((Number) pair.a()).longValue()), Long.valueOf(((Number) pair.b()).longValue()));
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public void x(final FragmentAcademyAnotherCurrentLessonBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        super.x(binding);
        H().I0().j(getViewLifecycleOwner(), new AcademyAnotherCurrentLessonFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AcademyAnotherCurrentLessonFragment.J(this.f106310a, binding, (AcademyLessonWithCourse) obj);
            }
        }));
        H().K0().j(getViewLifecycleOwner(), new AcademyAnotherCurrentLessonFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AcademyAnotherCurrentLessonFragment.L(this.f106313a, binding, (AcademyLessonWithCourse) obj);
            }
        }));
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public void y(FragmentAcademyAnotherCurrentLessonBinding binding, View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(view, "view");
        super.y(binding, view, bundle);
        binding.f96556i.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AcademyAnotherCurrentLessonFragment.N(this.f106317a, view2);
            }
        });
        binding.f96549b.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AcademyAnotherCurrentLessonFragment.O(this.f106320a, view2);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public FragmentAcademyAnotherCurrentLessonBinding z(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentAcademyAnotherCurrentLessonBinding fragmentAcademyAnotherCurrentLessonBindingC = FragmentAcademyAnotherCurrentLessonBinding.c(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(fragmentAcademyAnotherCurrentLessonBindingC, "inflate(...)");
        return fragmentAcademyAnotherCurrentLessonBindingC;
    }
}
