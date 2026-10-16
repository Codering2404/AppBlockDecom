package cz.mobilesoft.coreblock.scene.more.academy.course;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.RequestManager;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.fragment.BaseRecyclerViewFragment;
import cz.mobilesoft.coreblock.databinding.FragmentAcademyCoursesBinding;
import cz.mobilesoft.coreblock.databinding.LayoutEmptyBinding;
import cz.mobilesoft.coreblock.enums.SignInEntryPoint;
import cz.mobilesoft.coreblock.enums.StrictModeTitleAlternatives;
import cz.mobilesoft.coreblock.repository.AcademyRepository;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.more.academy.CourseCardView;
import cz.mobilesoft.coreblock.scene.more.academy.course.AcademyCoursesFragment;
import cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonsActivity;
import cz.mobilesoft.coreblock.scene.more.signin.SignInActivity;
import cz.mobilesoft.coreblock.scene.more.signin.SignInConfig;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.NetworkHelperKt;
import cz.mobilesoft.coreblock.util.SessionManager;
import cz.mobilesoft.coreblock.util.ViewModelState;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.DialogHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt;
import cz.mobilesoft.coreblock.util.helperextension.LiveDataExtKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelper;
import cz.mobilesoft.coreblock.util.view.ViewHelperExtKt;
import cz.mobilesoft.coreblock.view.MaterialProgressButton;
import cz.mobilesoft.coreblock.view.transformation.SvgSoftwareLayerSetter;
import cz.mobilesoft.coreblock.view.viewholder.HintViewHolder;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
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
public final class AcademyCoursesFragment extends BaseRecyclerViewFragment<FragmentAcademyCoursesBinding> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Companion f106133j = new Companion(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f106134k = 8;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MenuItem f106135c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MenuItem f106136d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f106137f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private CoursesAdapter f106138g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f106139h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f106140i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AcademyCoursesFragment a() {
            return new AcademyCoursesFragment();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class CoursesAdapter extends ListAdapter<CourseCardView.CourseDTO, ViewHolder> {
        public CoursesAdapter() {
            super(new DiffUtil.ItemCallback<CourseCardView.CourseDTO>() { // from class: cz.mobilesoft.coreblock.scene.more.academy.course.AcademyCoursesFragment.CoursesAdapter.1
                @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
                /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
                public boolean a(CourseCardView.CourseDTO oldItem, CourseCardView.CourseDTO newItem) {
                    Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                    Intrinsics.checkNotNullParameter(newItem, "newItem");
                    return Intrinsics.areEqual(oldItem, newItem);
                }

                @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
                /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
                public boolean b(CourseCardView.CourseDTO oldItem, CourseCardView.CourseDTO newItem) {
                    Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                    Intrinsics.checkNotNullParameter(newItem, "newItem");
                    return oldItem.b() == newItem.b();
                }
            });
            setHasStableIds(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit m(CourseCardView.CourseDTO courseDTO, CourseCardView courseCardView, RequestManager glideSafe) {
            Intrinsics.checkNotNullParameter(glideSafe, "$this$glideSafe");
            NetworkHelperKt.e(glideSafe, courseDTO.a(), 0, 0, 6, null).H0(new SvgSoftwareLayerSetter()).F0(courseCardView.getBinding().f96765b);
            return Unit.f139807a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(CourseCardView.CourseDTO courseDTO, View view) {
            Context context = view.getContext();
            AcademyLessonsActivity.Companion companion = AcademyLessonsActivity.f106269t;
            Context context2 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            context.startActivity(companion.a(context2, courseDTO.b()));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i3) {
            if (i3 == super.getItemCount()) {
                return -1L;
            }
            return ((CourseCardView.CourseDTO) g(i3)).b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i3) {
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(ViewHolder holder, int i3) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            View view = holder.itemView;
            if (view instanceof CourseCardView) {
                Intrinsics.checkNotNull(view, "null cannot be cast to non-null type cz.mobilesoft.coreblock.scene.more.academy.CourseCardView");
                final CourseCardView courseCardView = (CourseCardView) view;
                final CourseCardView.CourseDTO courseDTO = (CourseCardView.CourseDTO) g(i3);
                courseCardView.setCourse(courseDTO);
                courseCardView.setState(courseDTO.g() == CourseCardView.CourseCardState.LOCKED ? CourseCardView.CourseCardState.Companion.a(courseDTO.e()) : courseDTO.g());
                ViewHelperExtKt.f(AcademyCoursesFragment.this.getActivity(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.academy.course.l
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AcademyCoursesFragment.CoursesAdapter.m(courseDTO, courseCardView, (RequestManager) obj);
                    }
                });
                courseCardView.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.more.academy.course.m
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        AcademyCoursesFragment.CoursesAdapter.n(courseDTO, view2);
                    }
                });
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public ViewHolder onCreateViewHolder(ViewGroup parent, int i3) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            FragmentActivity fragmentActivityRequireActivity = AcademyCoursesFragment.this.requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
            CourseCardView courseCardView = new CourseCardView(fragmentActivityRequireActivity, null, 2, 0 == true ? 1 : 0);
            ViewHelperExtKt.y(courseCardView);
            return new ViewHolder(courseCardView);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.academy.course.AcademyCoursesFragment$onOptionsItemSelected$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.academy.course.AcademyCoursesFragment$onOptionsItemSelected$1", f = "AcademyCoursesFragment.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f106142a;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit q(AcademyCoursesFragment academyCoursesFragment) {
            AnswersHelper.f128199a.I2(SignInEntryPoint.ACADEMY);
            academyCoursesFragment.O().J0();
            return Unit.f139807a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return AcademyCoursesFragment.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f106142a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            if (AcademyCoursesFragment.this.N().n()) {
                ViewHelperExtKt.u(AcademyCoursesFragment.this, StrictModeTitleAlternatives.Companion.a());
            } else {
                AnswersHelper.f128199a.H2(SignInEntryPoint.ACADEMY);
                FragmentActivity activity = AcademyCoursesFragment.this.getActivity();
                if (activity != null) {
                    int i3 = R.string.es;
                    Integer numD = Boxing.d(R.string.ds);
                    int i4 = R.string.tx;
                    final AcademyCoursesFragment academyCoursesFragment = AcademyCoursesFragment.this;
                    DialogHelperExtKt.A(activity, i3, numD, i4, 0, new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.academy.course.n
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return AcademyCoursesFragment.AnonymousClass1.q(academyCoursesFragment);
                        }
                    }, null, false, 104, null);
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
    public AcademyCoursesFragment() {
        final Function0<FragmentActivity> function0 = new Function0<FragmentActivity>() { // from class: cz.mobilesoft.coreblock.scene.more.academy.course.AcademyCoursesFragment$special$$inlined$sharedViewModel$default$1
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
        this.f106137f = LazyKt.a(LazyThreadSafetyMode.f139763c, new Function0<AcademyCoursesViewModel>() { // from class: cz.mobilesoft.coreblock.scene.more.academy.course.AcademyCoursesFragment$special$$inlined$sharedViewModel$default$2
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
                return GetViewModelKt.b(Reflection.b(AcademyCoursesViewModel.class), viewModelStore, null, defaultViewModelCreationExtras, qualifier2, AndroidKoinScopeExtKt.a(fragment), function06, 4, null);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f139761a;
        final Qualifier qualifier2 = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f106139h = LazyKt.a(lazyThreadSafetyMode, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.scene.more.academy.course.AcademyCoursesFragment$special$$inlined$inject$default$1
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
        this.f106140i = LazyKt.a(lazyThreadSafetyMode, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.scene.more.academy.course.AcademyCoursesFragment$special$$inlined$inject$default$2
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

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeRepository N() {
        return (StrictModeRepository) this.f106140i.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AcademyCoursesViewModel O() {
        return (AcademyCoursesViewModel) this.f106137f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(FragmentAcademyCoursesBinding fragmentAcademyCoursesBinding, ViewModelState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        fragmentAcademyCoursesBinding.f96572c.f96785h.setInProgress(it instanceof Loading);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(FragmentAcademyCoursesBinding fragmentAcademyCoursesBinding, AcademyCoursesFragment academyCoursesFragment, List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        NestedScrollView contentScrollView = fragmentAcademyCoursesBinding.f96571b;
        Intrinsics.checkNotNullExpressionValue(contentScrollView, "contentScrollView");
        contentScrollView.setVisibility(!it.isEmpty() ? 0 : 8);
        ConstraintLayout empty = fragmentAcademyCoursesBinding.f96572c.f96779b;
        Intrinsics.checkNotNullExpressionValue(empty, "empty");
        empty.setVisibility(it.isEmpty() ? 0 : 8);
        CoursesAdapter coursesAdapter = academyCoursesFragment.f106138g;
        if (coursesAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            coursesAdapter = null;
        }
        coursesAdapter.i(it);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(AcademyCoursesFragment academyCoursesFragment, SessionManager.SignInState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        academyCoursesFragment.X(it instanceof SessionManager.SignedIn);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(final FragmentAcademyCoursesBinding fragmentAcademyCoursesBinding, final View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        fragmentAcademyCoursesBinding.f96571b.post(new Runnable() { // from class: cz.mobilesoft.coreblock.scene.more.academy.course.k
            @Override // java.lang.Runnable
            public final void run() {
                AcademyCoursesFragment.V(fragmentAcademyCoursesBinding, it);
            }
        });
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(FragmentAcademyCoursesBinding fragmentAcademyCoursesBinding, View view) {
        fragmentAcademyCoursesBinding.f96571b.V(0, ((int) view.getY()) + view.getBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(View view) {
        AcademyRepository.q(null, 1, null);
    }

    private final void X(boolean z2) {
        MenuItem menuItem = this.f106136d;
        if (menuItem != null) {
            menuItem.setVisible(z2);
        }
        MenuItem menuItem2 = this.f106135c;
        if (menuItem2 != null) {
            menuItem2.setVisible(!z2);
        }
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseRecyclerViewFragment
    public RecyclerView A() {
        RecyclerView recyclerView = ((FragmentAcademyCoursesBinding) w()).f96574e;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        return recyclerView;
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public void x(final FragmentAcademyCoursesBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        super.x(binding);
        LiveDataExtKt.c(this, AcademyRepository.f97249a.l(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.academy.course.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AcademyCoursesFragment.Q(binding, (ViewModelState) obj);
            }
        });
        FlowsExtKt.c(this, O().I0(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.academy.course.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AcademyCoursesFragment.R(binding, this, (List) obj);
            }
        });
        FlowsExtKt.c(this, SessionManager.f127910a.l(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.academy.course.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AcademyCoursesFragment.S(this.f106181a, (SessionManager.SignInState) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public void y(final FragmentAcademyCoursesBinding binding, View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(view, "view");
        super.y(binding, view, bundle);
        this.f106138g = new CoursesAdapter();
        RecyclerView recyclerViewA = A();
        CoursesAdapter coursesAdapter = this.f106138g;
        if (coursesAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            coursesAdapter = null;
        }
        recyclerViewA.setAdapter(coursesAdapter);
        ViewHelperExtKt.h(A());
        LinearLayout linearLayout = binding.f96573d;
        LinearLayout hintContainer = binding.f96573d;
        Intrinsics.checkNotNullExpressionValue(hintContainer, "hintContainer");
        String string = requireContext().getString(R.string.Qf);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = requireContext().getString(R.string.f95770b);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        linearLayout.addView(new HintViewHolder(hintContainer, string, string2, null, null, null, 56, null).e());
        LinearLayout linearLayout2 = binding.f96573d;
        LinearLayout hintContainer2 = binding.f96573d;
        Intrinsics.checkNotNullExpressionValue(hintContainer2, "hintContainer");
        String string3 = requireContext().getString(R.string.f95779d);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        linearLayout2.addView(new HintViewHolder(hintContainer2, string3, StringHelper.h(requireContext().getString(R.string.f95774c)), null, new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.academy.course.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AcademyCoursesFragment.U(binding, (View) obj);
            }
        }, null, 40, null).e());
        LayoutEmptyBinding layoutEmptyBinding = binding.f96572c;
        layoutEmptyBinding.f96781d.setText(R.string.Pk);
        layoutEmptyBinding.f96780c.setText(R.string.Ok);
        MaterialProgressButton tryAgainButton = layoutEmptyBinding.f96785h;
        Intrinsics.checkNotNullExpressionValue(tryAgainButton, "tryAgainButton");
        tryAgainButton.setVisibility(0);
        layoutEmptyBinding.f96785h.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.more.academy.course.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AcademyCoursesFragment.W(view2);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
    public FragmentAcademyCoursesBinding z(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentAcademyCoursesBinding fragmentAcademyCoursesBindingC = FragmentAcademyCoursesBinding.c(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(fragmentAcademyCoursesBindingC, "inflate(...)");
        return fragmentAcademyCoursesBindingC;
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
        inflater.inflate(R.menu.f95734b, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        int itemId = item.getItemId();
        if (itemId != R.id.f95597c) {
            if (itemId != R.id.f95601d) {
                return super.onOptionsItemSelected(item);
            }
            BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), null, null, new AnonymousClass1(null), 3, null);
            return true;
        }
        AnswersHelper.f128199a.I();
        SignInActivity.Companion companion = SignInActivity.f110366h;
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        startActivity(companion.a(fragmentActivityRequireActivity, new SignInConfig(SignInEntryPoint.ACADEMY, null, false, false, true, false, false, false, false, false, null, 2030, null)));
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        this.f106135c = menu.findItem(R.id.f95597c);
        this.f106136d = menu.findItem(R.id.f95601d);
        MenuItem menuItem = this.f106135c;
        if (menuItem != null) {
            SpannableString spannableString = new SpannableString(menuItem.getTitle());
            spannableString.setSpan(new TextAppearanceSpan(getActivity(), R.style.f95871f), 0, spannableString.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(requireActivity(), R.color.f95446a)), 0, spannableString.length(), 33);
            menuItem.setTitle(spannableString);
        }
        X(SessionManager.f127910a.r());
    }
}
