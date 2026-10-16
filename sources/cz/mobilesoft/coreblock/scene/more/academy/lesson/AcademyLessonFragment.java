package cz.mobilesoft.coreblock.scene.more.academy.lesson;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.facebook.stetho.common.Utf8Charset;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.fragment.BaseScrollViewFragment;
import cz.mobilesoft.coreblock.databinding.FragmentAcademyLessonBinding;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.repository.AcademyRepository;
import cz.mobilesoft.coreblock.rest.RestClient;
import cz.mobilesoft.coreblock.scene.more.academy.AcademyLessonState;
import cz.mobilesoft.coreblock.scene.more.academy.course.AcademyCourseFinishedActivity;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.storage.room.academy.AcademyLessonWithCourse;
import cz.mobilesoft.coreblock.storage.room.entity.core.AcademyLessonEntity;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.ExternalLinksHelper;
import cz.mobilesoft.coreblock.util.FailedWithError;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.ViewModelState;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.DialogHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt;
import cz.mobilesoft.coreblock.util.helperextension.LiveDataExtKt;
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
import kotlin.text.StringsKt;
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
public final class AcademyLessonFragment extends BaseScrollViewFragment<FragmentAcademyLessonBinding> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f106219h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f106220i = 8;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f106221d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f106222f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f106223g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AcademyLessonFragment a() {
            return new AcademyLessonFragment();
        }

        private Companion() {
        }
    }

    public AcademyLessonFragment() {
        final Function0 function0 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.p
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AcademyLessonFragment.e0(this.f106341a);
            }
        };
        final Function0<FragmentActivity> function02 = new Function0<FragmentActivity>() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonFragment$special$$inlined$sharedViewModel$default$1
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
        final Function0 function03 = null;
        this.f106222f = LazyKt.a(LazyThreadSafetyMode.f139763c, new Function0<AcademyLessonViewModel>() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonFragment$special$$inlined$sharedViewModel$default$2
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
                return GetViewModelKt.b(Reflection.b(AcademyLessonViewModel.class), viewModelStore, null, defaultViewModelCreationExtras, qualifier2, AndroidKoinScopeExtKt.a(fragment), function06, 4, null);
            }
        });
    }

    private final void N(Activity activity) {
        activity.setResult(-1);
        activity.finish();
    }

    private final AcademyLessonViewModel P() {
        return (AcademyLessonViewModel) this.f106222f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(AcademyLessonFragment academyLessonFragment, ViewModelState viewModelState) {
        FragmentActivity activity;
        academyLessonFragment.b0(viewModelState instanceof Loading);
        if ((viewModelState instanceof FailedWithError) && (activity = academyLessonFragment.getActivity()) != null) {
            String string = academyLessonFragment.getString(R.string.XE);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            DialogHelperExtKt.L(activity, string, ((FailedWithError) viewModelState).d(), false, null, 12, null);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(AcademyLessonFragment academyLessonFragment, FragmentAcademyLessonBinding fragmentAcademyLessonBinding, AcademyLessonWithCourse academyLessonWithCourse) {
        if (academyLessonWithCourse != null) {
            try {
                academyLessonFragment.d0(academyLessonWithCourse);
            } catch (NullPointerException e3) {
                e3.printStackTrace();
                CrashHelper.j(e3);
                AcademyRepository.q(null, 1, null);
                FragmentActivity activity = academyLessonFragment.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
            fragmentAcademyLessonBinding.f96578d.setTitle(academyLessonWithCourse.b().h());
            fragmentAcademyLessonBinding.f96582h.setTitle(academyLessonWithCourse.b().h());
        }
        return Unit.f139807a;
    }

    private final void T() {
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        AppCompatActivity appCompatActivity = (AppCompatActivity) fragmentActivityRequireActivity;
        appCompatActivity.setSupportActionBar(((FragmentAcademyLessonBinding) w()).f96582h);
        ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.t(true);
            supportActionBar.x(R.drawable.G0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(final AcademyLessonFragment academyLessonFragment, View view) {
        AcademyLessonEntity academyLessonEntityB;
        AcademyLessonWithCourse academyLessonWithCourseL0 = academyLessonFragment.P().L0();
        if (academyLessonWithCourseL0 != null && (academyLessonEntityB = academyLessonWithCourseL0.b()) != null) {
            AnswersHelper.f128199a.B(academyLessonEntityB.b(), academyLessonEntityB.g());
        }
        academyLessonFragment.P().I0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.r
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AcademyLessonFragment.W(this.f106343a, ((Boolean) obj).booleanValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(AcademyLessonFragment academyLessonFragment, boolean z2) {
        AcademyLessonEntity academyLessonEntityB;
        FragmentActivity activity = academyLessonFragment.getActivity();
        if (activity != null) {
            if (z2) {
                AcademyLessonWithCourse academyLessonWithCourseL0 = academyLessonFragment.P().L0();
                if (academyLessonWithCourseL0 != null && (academyLessonEntityB = academyLessonWithCourseL0.b()) != null) {
                    long jB = academyLessonEntityB.b();
                    AnswersHelper.f128199a.z();
                    academyLessonFragment.startActivity(AcademyCourseFinishedActivity.f106118t.a(activity, jB));
                }
                academyLessonFragment.N(activity);
            } else if (academyLessonFragment.P().O0()) {
                if (Intrinsics.areEqual(academyLessonFragment.P().N0().J(), PremiumState.OldFull.INSTANCE)) {
                    Paywall paywall = Paywall.f113165a;
                    String string = academyLessonFragment.getString(R.string.pe);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    academyLessonFragment.startActivity(Paywall.c(paywall, activity, new PaywallTarget.OneTimeToSub(string), "academy", "academy_lesson", false, false, false, null, 240, null));
                } else {
                    AnswersHelper.f128199a.D();
                    academyLessonFragment.startActivity(Paywall.c(Paywall.f113165a, activity, new PaywallTarget.LimitScreen(PremiumFeature.ACADEMY), "academy", "academy_lesson", false, false, false, null, 240, null));
                }
                academyLessonFragment.N(activity);
            } else {
                academyLessonFragment.N(activity);
            }
        }
        return Unit.f139807a;
    }

    private final void X() {
        ((FragmentAcademyLessonBinding) w()).f96583i.setLayerType(0, null);
        ((FragmentAcademyLessonBinding) w()).f96583i.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.q
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                AcademyLessonFragment.Y(this.f106342a);
            }
        });
        ((FragmentAcademyLessonBinding) w()).f96583i.setWebViewClient(new WebViewClient() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonFragment$initWebView$2
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                Uri url;
                if (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null) {
                    return true;
                }
                AcademyLessonFragment academyLessonFragment = this.f106224a;
                String string = url.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                String strQ = StringsKt.Q(string, RestClient.f98457a.w(), "", false, 4, null);
                if (!StringsKt.U(strQ, "https://", false, 2, null) && !StringsKt.U(strQ, "http://", false, 2, null)) {
                    strQ = "https://" + strQ;
                }
                ExternalLinksHelper externalLinksHelper = ExternalLinksHelper.f127866a;
                Context contextRequireContext = academyLessonFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                externalLinksHelper.c(contextRequireContext, Uri.parse(strQ));
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(AcademyLessonFragment academyLessonFragment) {
        if (((FragmentAcademyLessonBinding) academyLessonFragment.w()).f96583i.getHeight() <= 0 || academyLessonFragment.f106221d) {
            return;
        }
        academyLessonFragment.Z();
    }

    private final void Z() {
        this.f106221d = true;
        c0(P().L0());
    }

    private final void b0(boolean z2) {
        ((FragmentAcademyLessonBinding) w()).f96579e.setInProgress(z2);
    }

    private final void c0(AcademyLessonWithCourse academyLessonWithCourse) {
        AcademyLessonEntity academyLessonEntityB;
        MaterialProgressButton finishButton = ((FragmentAcademyLessonBinding) w()).f96579e;
        Intrinsics.checkNotNullExpressionValue(finishButton, "finishButton");
        finishButton.setVisibility(((academyLessonWithCourse == null || (academyLessonEntityB = academyLessonWithCourse.b()) == null) ? null : academyLessonEntityB.f()) != AcademyLessonState.COMPLETE && this.f106221d ? 0 : 8);
    }

    private final void d0(AcademyLessonWithCourse academyLessonWithCourse) {
        FragmentAcademyLessonBinding fragmentAcademyLessonBinding = (FragmentAcademyLessonBinding) w();
        this.f106223g = false;
        c0(academyLessonWithCourse);
        fragmentAcademyLessonBinding.f96581g.setText(getString(R.string.Ki, academyLessonWithCourse.a().f(), Integer.valueOf(academyLessonWithCourse.b().g() + 1)));
        WebView webView = fragmentAcademyLessonBinding.f96583i;
        String strW = RestClient.f98457a.w();
        AcademyLessonViewModel academyLessonViewModelP = P();
        String strA = academyLessonWithCourse.b().a();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        webView.loadDataWithBaseURL(strW, academyLessonViewModelP.P0(strA, contextRequireContext), "text/html", Utf8Charset.NAME, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder e0(AcademyLessonFragment academyLessonFragment) {
        return ParametersHolderKt.b(Long.valueOf(academyLessonFragment.requireActivity().getIntent().getLongExtra("LESSON_ID", -1L)));
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseScrollViewFragment
    public void F(View view) {
        super.F(view);
        if (view == null || view.canScrollVertically(1)) {
            return;
        }
        this.f106223g = true;
    }

    public final boolean O() {
        return this.f106223g;
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public void x(final FragmentAcademyLessonBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        super.x(binding);
        LiveDataExtKt.c(this, P().J0(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AcademyLessonFragment.R(this.f106338a, (ViewModelState) obj);
            }
        });
        FlowsExtKt.c(this, P().M0(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AcademyLessonFragment.S(this.f106339a, binding, (AcademyLessonWithCourse) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseScrollViewFragment, cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public void y(FragmentAcademyLessonBinding binding, View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(view, "view");
        super.y(binding, view, bundle);
        binding.f96579e.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AcademyLessonFragment.V(this.f106337a, view2);
            }
        });
        T();
        X();
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public FragmentAcademyLessonBinding z(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentAcademyLessonBinding fragmentAcademyLessonBindingC = FragmentAcademyLessonBinding.c(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(fragmentAcademyLessonBindingC, "inflate(...)");
        return fragmentAcademyLessonBindingC;
    }
}
