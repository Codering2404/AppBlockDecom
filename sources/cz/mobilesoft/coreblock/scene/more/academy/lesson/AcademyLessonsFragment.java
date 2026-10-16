package cz.mobilesoft.coreblock.scene.more.academy.lesson;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.RequestManager;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.adapter.BaseListAdapter;
import cz.mobilesoft.coreblock.base.fragment.BaseScrollViewFragment;
import cz.mobilesoft.coreblock.databinding.FragmentAcademyLessonsBinding;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.SignInEntryPoint;
import cz.mobilesoft.coreblock.scene.more.academy.AcademyCourseState;
import cz.mobilesoft.coreblock.scene.more.academy.AcademyLessonState;
import cz.mobilesoft.coreblock.scene.more.academy.LessonCardView;
import cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyAnotherCurrentLessonActivity;
import cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonActivity;
import cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonsFragment;
import cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonsViewModel;
import cz.mobilesoft.coreblock.scene.more.signin.SignInActivity;
import cz.mobilesoft.coreblock.scene.more.signin.SignInConfig;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.storage.room.entity.core.AcademyLessonEntity;
import cz.mobilesoft.coreblock.util.FailedWithError;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.NetworkHelperKt;
import cz.mobilesoft.coreblock.util.SessionManager;
import cz.mobilesoft.coreblock.util.ViewModelState;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.util.helperextension.DialogHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.LiveDataExtKt;
import cz.mobilesoft.coreblock.util.view.ViewHelperExtKt;
import cz.mobilesoft.coreblock.view.transformation.SvgSoftwareLayerSetter;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
public final class AcademyLessonsFragment extends BaseScrollViewFragment<FragmentAcademyLessonsBinding> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Companion f106271j = new Companion(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f106272k = 8;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f106273d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f106274f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f106275g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ActivityResultLauncher f106276h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ActivityResultLauncher f106277i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AcademyLessonsFragment a(long j3) {
            AcademyLessonsFragment academyLessonsFragment = new AcademyLessonsFragment();
            academyLessonsFragment.setArguments(BundleKt.b(TuplesKt.a("COURSE_ID", Long.valueOf(j3))));
            return academyLessonsFragment;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class LessonsAdapter extends BaseListAdapter<LessonCardView.LessonDTO> {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final /* synthetic */ class WhenMappings {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f106279a;

            static {
                int[] iArr = new int[LessonCardView.LessonCardState.values().length];
                try {
                    iArr[LessonCardView.LessonCardState.COMPLETE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[LessonCardView.LessonCardState.CURRENT.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[LessonCardView.LessonCardState.LOCKED.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f106279a = iArr;
            }
        }

        public LessonsAdapter() {
            super(-1, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.e0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Boolean.valueOf(AcademyLessonsFragment.LessonsAdapter.q((LessonCardView.LessonDTO) obj, (LessonCardView.LessonDTO) obj2));
                }
            }, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.f0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Boolean.valueOf(AcademyLessonsFragment.LessonsAdapter.r((LessonCardView.LessonDTO) obj, (LessonCardView.LessonDTO) obj2));
                }
            });
            setHasStableIds(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean q(LessonCardView.LessonDTO old, LessonCardView.LessonDTO lessonDTO) {
            Intrinsics.checkNotNullParameter(old, "old");
            Intrinsics.checkNotNullParameter(lessonDTO, "new");
            return old.b() == lessonDTO.b();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean r(LessonCardView.LessonDTO old, LessonCardView.LessonDTO lessonDTO) {
            Intrinsics.checkNotNullParameter(old, "old");
            Intrinsics.checkNotNullParameter(lessonDTO, "new");
            return Intrinsics.areEqual(old, lessonDTO);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit t(View view, LessonCardView.LessonDTO lessonDTO, int i3, AcademyLessonsFragment academyLessonsFragment) {
            int i4 = WhenMappings.f106279a[((LessonCardView) view).getState().ordinal()];
            if (i4 == 1) {
                AnswersHelper.f128199a.w(lessonDTO.a().b(), i3);
                AcademyLessonActivity.Companion companion = AcademyLessonActivity.f106211v;
                FragmentActivity fragmentActivityRequireActivity = academyLessonsFragment.requireActivity();
                Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
                academyLessonsFragment.startActivity(companion.a(fragmentActivityRequireActivity, lessonDTO.b()));
            } else if (i4 != 2) {
                if (i4 == 3) {
                    if (Intrinsics.areEqual(academyLessonsFragment.b0().P0().J(), PremiumState.OldFull.INSTANCE)) {
                        Paywall paywall = Paywall.f113165a;
                        FragmentActivity fragmentActivityRequireActivity2 = academyLessonsFragment.requireActivity();
                        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity2, "requireActivity(...)");
                        String string = academyLessonsFragment.getString(R.string.G7);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        academyLessonsFragment.startActivity(Paywall.c(paywall, fragmentActivityRequireActivity2, new PaywallTarget.OneTimeToSub(string), "academy", "academy_lesson", false, false, false, null, 240, null));
                    } else {
                        Paywall paywall2 = Paywall.f113165a;
                        FragmentActivity fragmentActivityRequireActivity3 = academyLessonsFragment.requireActivity();
                        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity3, "requireActivity(...)");
                        academyLessonsFragment.startActivity(Paywall.c(paywall2, fragmentActivityRequireActivity3, PaywallTarget.Generic.INSTANCE, "academy", "academy_lesson", false, false, false, null, 240, null));
                    }
                }
            } else if (!SessionManager.f127910a.r()) {
                AnswersHelper.f128199a.J(lessonDTO.a().b(), false);
                SignInActivity.Companion companion2 = SignInActivity.f110366h;
                FragmentActivity fragmentActivityRequireActivity4 = academyLessonsFragment.requireActivity();
                Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity4, "requireActivity(...)");
                academyLessonsFragment.startActivity(companion2.a(fragmentActivityRequireActivity4, new SignInConfig(SignInEntryPoint.ACADEMY, Long.valueOf(lessonDTO.b()), false, false, true, false, false, false, false, false, null, 2028, null)));
            } else if (lessonDTO.e() == AcademyLessonState.CURRENT && lessonDTO.a().d() == AcademyCourseState.CURRENT) {
                AnswersHelper.f128199a.C(lessonDTO.a().b(), i3);
                academyLessonsFragment.h0(lessonDTO.b());
            } else {
                if (lessonDTO.a().d() == AcademyCourseState.CURRENT) {
                    AnswersHelper.f128199a.C(lessonDTO.a().b(), i3);
                } else {
                    AnswersHelper.f128199a.J(lessonDTO.a().b(), true);
                }
                academyLessonsFragment.V(lessonDTO.b());
            }
            return Unit.f139807a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit u(AcademyLessonsFragment academyLessonsFragment) {
            academyLessonsFragment.b0().R0();
            return Unit.f139807a;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i3) {
            return ((LessonCardView.LessonDTO) g(i3)).b();
        }

        @Override // cz.mobilesoft.coreblock.base.adapter.BaseListAdapter
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public void j(final View itemView, final LessonCardView.LessonDTO item, final int i3, BaseListAdapter.BaseViewHolderImp viewHolder) {
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            if (itemView instanceof LessonCardView) {
                LessonCardView lessonCardView = (LessonCardView) itemView;
                lessonCardView.setLesson(item);
                lessonCardView.setNumber(Integer.valueOf(i3 + 1));
                final AcademyLessonsFragment academyLessonsFragment = AcademyLessonsFragment.this;
                lessonCardView.setOnButtonClick(new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.g0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AcademyLessonsFragment.LessonsAdapter.t(itemView, item, i3, academyLessonsFragment);
                    }
                });
                final AcademyLessonsFragment academyLessonsFragment2 = AcademyLessonsFragment.this;
                lessonCardView.setOnUnlocked(new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.h0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AcademyLessonsFragment.LessonsAdapter.u(academyLessonsFragment2);
                    }
                });
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // cz.mobilesoft.coreblock.base.adapter.BaseListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        public BaseListAdapter.BaseViewHolderImp onCreateViewHolder(ViewGroup parent, int i3) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            FragmentActivity fragmentActivityRequireActivity = AcademyLessonsFragment.this.requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
            LessonCardView lessonCardView = new LessonCardView(fragmentActivityRequireActivity, null, 2, 0 == true ? 1 : 0);
            ViewHelperExtKt.y(lessonCardView);
            return new BaseListAdapter.BaseViewHolderImp(this, lessonCardView);
        }
    }

    public AcademyLessonsFragment() {
        final Function0 function0 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.w
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AcademyLessonsFragment.p0(this.f106348a);
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonsFragment$special$$inlined$viewModel$default$1
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
        this.f106273d = LazyKt.a(LazyThreadSafetyMode.f139763c, new Function0<AcademyLessonsViewModel>() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonsFragment$special$$inlined$viewModel$default$2
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
                return GetViewModelKt.b(Reflection.b(AcademyLessonsViewModel.class), viewModelStore, null, defaultViewModelCreationExtras, qualifier2, AndroidKoinScopeExtKt.a(fragment), function06, 4, null);
            }
        });
        this.f106274f = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.x
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(AcademyLessonsFragment.Y(this.f106349a));
            }
        });
        this.f106275g = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.y
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AcademyLessonsFragment.X(this.f106350a);
            }
        });
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.z
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                AcademyLessonsFragment.U(this.f106351a, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.f106276h = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.a0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                AcademyLessonsFragment.g0(this.f106312a, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(...)");
        this.f106277i = activityResultLauncherRegisterForActivityResult2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(AcademyLessonsFragment academyLessonsFragment, ActivityResult result) {
        Intent intentC;
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.d() != -1 || (intentC = result.c()) == null) {
            return;
        }
        Long lValueOf = Long.valueOf(intentC.getLongExtra("LESSON_ID", -1L));
        if (lValueOf.longValue() == -1) {
            lValueOf = null;
        }
        if (lValueOf != null) {
            long jLongValue = lValueOf.longValue();
            Serializable serializableExtra = intentC.getSerializableExtra("LESSON_STATE");
            AcademyLessonState academyLessonState = serializableExtra instanceof AcademyLessonState ? (AcademyLessonState) serializableExtra : null;
            if (academyLessonState == null) {
                return;
            }
            if (academyLessonState != AcademyLessonState.CURRENT) {
                academyLessonsFragment.l0(jLongValue);
            } else {
                academyLessonsFragment.b0().T0(jLongValue);
                academyLessonsFragment.h0(jLongValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V(final long j3) {
        b0().I0(j3, new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.b0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AcademyLessonsFragment.W(this.f106315a, j3, (AcademyLessonEntity) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(AcademyLessonsFragment academyLessonsFragment, long j3, AcademyLessonEntity academyLessonEntity) {
        if (academyLessonEntity != null) {
            AnswersHelper.f128199a.v();
            AcademyAnotherCurrentLessonActivity.Companion companion = AcademyAnotherCurrentLessonActivity.f106191u;
            FragmentActivity fragmentActivityRequireActivity = academyLessonsFragment.requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
            ContextExtKt.g(academyLessonsFragment.f106276h, companion.a(fragmentActivityRequireActivity, academyLessonEntity.d(), j3));
        } else {
            academyLessonsFragment.l0(j3);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String X(AcademyLessonsFragment academyLessonsFragment) {
        return "#" + Integer.toHexString(academyLessonsFragment.a0() & 16777215);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int Y(AcademyLessonsFragment academyLessonsFragment) {
        return ContextCompat.getColor(academyLessonsFragment.requireContext(), R.color.f95463r);
    }

    private final String Z() {
        return (String) this.f106275g.getValue();
    }

    private final int a0() {
        return ((Number) this.f106274f.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AcademyLessonsViewModel b0() {
        return (AcademyLessonsViewModel) this.f106273d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d0(AcademyLessonsFragment academyLessonsFragment, ViewModelState viewModelState) {
        academyLessonsFragment.k0(viewModelState instanceof Loading);
        if (viewModelState instanceof FailedWithError) {
            academyLessonsFragment.j0((FailedWithError) viewModelState);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e0(AcademyLessonsFragment academyLessonsFragment, AcademyLessonsViewModel.LessonsDTO it) {
        Intrinsics.checkNotNullParameter(it, "it");
        academyLessonsFragment.n0(it);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(AcademyLessonsFragment academyLessonsFragment, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.d() == -1) {
            academyLessonsFragment.b0().R0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0(long j3) {
        AcademyLessonActivity.Companion companion = AcademyLessonActivity.f106211v;
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        ContextExtKt.g(this.f106277i, companion.a(fragmentActivityRequireActivity, j3));
    }

    private final void j0(FailedWithError failedWithError) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            String string = getString(R.string.XE);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            DialogHelperExtKt.L(activity, string, failedWithError.d(), false, null, 12, null);
        }
    }

    private final void l0(final long j3) {
        b0().K0(j3, new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.c0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AcademyLessonsFragment.m0(this.f106318a, j3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m0(AcademyLessonsFragment academyLessonsFragment, long j3) {
        academyLessonsFragment.h0(j3);
        return Unit.f139807a;
    }

    private final void n0(AcademyLessonsViewModel.LessonsDTO lessonsDTO) {
        final LessonCardView.CourseDTO courseDTOA;
        final FragmentAcademyLessonsBinding fragmentAcademyLessonsBinding = (FragmentAcademyLessonsBinding) w();
        LessonCardView.LessonDTO lessonDTO = (LessonCardView.LessonDTO) CollectionsKt.firstOrNull(lessonsDTO.b());
        if (lessonDTO != null && (courseDTOA = lessonDTO.a()) != null) {
            ViewHelperExtKt.f(getActivity(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.d0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AcademyLessonsFragment.o0(courseDTOA, fragmentAcademyLessonsBinding, (RequestManager) obj);
                }
            });
            fragmentAcademyLessonsBinding.f96601i.setText(courseDTOA.e());
            fragmentAcademyLessonsBinding.f96600h.setText(courseDTOA.c());
        }
        int iA = lessonsDTO.a();
        TextView lessonsCountTextView = fragmentAcademyLessonsBinding.f96595c;
        Intrinsics.checkNotNullExpressionValue(lessonsCountTextView, "lessonsCountTextView");
        String string = getString(R.string.Oi, Z(), Integer.valueOf(iA), Integer.valueOf(lessonsDTO.b().size()));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        int i3 = 0;
        ViewHelperExtKt.m(lessonsCountTextView, string, false, 2, null);
        int i4 = iA * 100;
        Integer numValueOf = Integer.valueOf(lessonsDTO.b().size());
        Integer num = numValueOf.intValue() != 0 ? numValueOf : null;
        int iIntValue = i4 / (num != null ? num.intValue() : 1);
        ProgressBar progressBar = fragmentAcademyLessonsBinding.f96597e;
        if (iIntValue != 0 && iIntValue != 100) {
            i3 = iIntValue + 1;
        }
        progressBar.setSecondaryProgress(i3);
        fragmentAcademyLessonsBinding.f96597e.setProgress(iIntValue);
        RecyclerView.Adapter adapter = fragmentAcademyLessonsBinding.f96598f.getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonsFragment.LessonsAdapter");
        ((LessonsAdapter) adapter).i(lessonsDTO.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(LessonCardView.CourseDTO courseDTO, FragmentAcademyLessonsBinding fragmentAcademyLessonsBinding, RequestManager glideSafe) {
        Intrinsics.checkNotNullParameter(glideSafe, "$this$glideSafe");
        NetworkHelperKt.e(glideSafe, courseDTO.a(), 0, 0, 6, null).H0(new SvgSoftwareLayerSetter()).F0(fragmentAcademyLessonsBinding.f96594b);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder p0(AcademyLessonsFragment academyLessonsFragment) {
        Bundle arguments = academyLessonsFragment.getArguments();
        return ParametersHolderKt.b(arguments != null ? Long.valueOf(arguments.getLong("COURSE_ID", -1L)) : null);
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
    public void x(FragmentAcademyLessonsBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        super.x(binding);
        LiveDataExtKt.c(this, b0().J0(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.u
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AcademyLessonsFragment.d0(this.f106346a, (ViewModelState) obj);
            }
        });
        LiveDataExtKt.c(this, b0().O0(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.v
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AcademyLessonsFragment.e0(this.f106347a, (AcademyLessonsViewModel.LessonsDTO) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseScrollViewFragment, cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
    public void y(FragmentAcademyLessonsBinding binding, View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(view, "view");
        super.y(binding, view, bundle);
        binding.f96598f.setAdapter(new LessonsAdapter());
        RecyclerView recyclerView = binding.f96598f;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        ViewHelperExtKt.h(recyclerView);
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public FragmentAcademyLessonsBinding z(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentAcademyLessonsBinding fragmentAcademyLessonsBindingC = FragmentAcademyLessonsBinding.c(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(fragmentAcademyLessonsBindingC, "inflate(...)");
        return fragmentAcademyLessonsBindingC;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putLong("COURSE_ID", b0().N0());
        super.onSaveInstanceState(outState);
    }

    private final void k0(boolean z2) {
    }
}
