package cz.mobilesoft.coreblock.scene.more.academy.lesson;

import android.content.Context;
import android.content.Intent;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import cz.mobilesoft.coreblock.base.activity.BaseEmptyActivitySurface;
import cz.mobilesoft.coreblock.scene.more.academy.AcademyLessonState;
import cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyClosingLessonDialog;
import cz.mobilesoft.coreblock.storage.room.academy.AcademyLessonWithCourse;
import cz.mobilesoft.coreblock.storage.room.entity.core.AcademyLessonEntity;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

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
public final class AcademyLessonActivity extends BaseEmptyActivitySurface {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Companion f106211v = new Companion(null);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f106212w = 8;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Lazy f106213t = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.j
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AcademyLessonActivity.E0(this.f106334a);
        }
    });

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Lazy f106214u;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context, long j3) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) AcademyLessonActivity.class);
            intent.putExtra("LESSON_ID", j3);
            return intent;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AcademyLessonActivity() {
        final Function0 function0 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AcademyLessonActivity.H0(this.f106335a);
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f139763c;
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f106214u = LazyKt.a(lazyThreadSafetyMode, new Function0<AcademyLessonViewModel>() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonActivity$special$$inlined$viewModel$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final ViewModel invoke() {
                CreationExtras defaultViewModelCreationExtras;
                ComponentActivity componentActivity = this;
                Qualifier qualifier2 = qualifier;
                Function0 function02 = objArr;
                Function0 function03 = function0;
                ViewModelStore viewModelStore = componentActivity.getViewModelStore();
                if (function02 == null || (defaultViewModelCreationExtras = (CreationExtras) function02.invoke()) == null) {
                    defaultViewModelCreationExtras = componentActivity.getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                }
                CreationExtras creationExtras = defaultViewModelCreationExtras;
                Scope scopeA = AndroidKoinScopeExtKt.a(componentActivity);
                KClass kClassB = Reflection.b(AcademyLessonViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                return GetViewModelKt.b(kClassB, viewModelStore, null, creationExtras, qualifier2, scopeA, function03, 4, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AcademyLessonFragment E0(AcademyLessonActivity academyLessonActivity) {
        academyLessonActivity.F0();
        return AcademyLessonFragment.f106219h.a();
    }

    private final AcademyLessonViewModel F0() {
        return (AcademyLessonViewModel) this.f106214u.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G0(AcademyLessonActivity academyLessonActivity) {
        super.onBackPressed();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder H0(AcademyLessonActivity academyLessonActivity) {
        return ParametersHolderKt.b(Long.valueOf(academyLessonActivity.getIntent().getLongExtra("LESSON_ID", -1L)));
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseFragmentActivitySurface
    protected Fragment getFragment() {
        return (Fragment) this.f106213t.getValue();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        AcademyLessonEntity academyLessonEntityB;
        AcademyLessonWithCourse academyLessonWithCourseL0 = F0().L0();
        if (((academyLessonWithCourseL0 == null || (academyLessonEntityB = academyLessonWithCourseL0.b()) == null) ? null : academyLessonEntityB.f()) != AcademyLessonState.COMPLETE) {
            Fragment fragment = getFragment();
            Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonFragment");
            if (((AcademyLessonFragment) fragment).O() && PrefManager.f126839a.a1()) {
                AcademyClosingLessonDialog.Companion companion = AcademyClosingLessonDialog.f106208b;
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
                companion.b(supportFragmentManager, new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.l
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AcademyLessonActivity.G0(this.f106336a);
                    }
                });
                return;
            }
        }
        super.onBackPressed();
    }
}
