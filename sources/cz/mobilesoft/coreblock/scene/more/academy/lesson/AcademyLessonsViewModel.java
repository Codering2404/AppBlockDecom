package cz.mobilesoft.coreblock.scene.more.academy.lesson;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import cz.mobilesoft.coreblock.repository.AcademyRepository;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.scene.more.academy.BaseAcademyLessonsViewModel;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.Success;
import cz.mobilesoft.coreblock.util.ViewModelState;
import java.util.List;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

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
public final class AcademyLessonsViewModel extends BaseAcademyLessonsViewModel {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f106286j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f106287k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final MutableLiveData f106288l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Observer f106289m;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonsViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonsViewModel$1", f = "AcademyLessonsViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f106290a;

        AnonymousClass1(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f106290a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            PrefManager.f126839a.g2(true);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LessonsDTO {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f106291a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f106292b;

        public LessonsDTO(List lessons, int i3) {
            Intrinsics.checkNotNullParameter(lessons, "lessons");
            this.f106291a = lessons;
            this.f106292b = i3;
        }

        public final int a() {
            return this.f106292b;
        }

        public final List b() {
            return this.f106291a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LessonsDTO)) {
                return false;
            }
            LessonsDTO lessonsDTO = (LessonsDTO) obj;
            return Intrinsics.areEqual(this.f106291a, lessonsDTO.f106291a) && this.f106292b == lessonsDTO.f106292b;
        }

        public int hashCode() {
            return (this.f106291a.hashCode() * 31) + Integer.hashCode(this.f106292b);
        }

        public String toString() {
            return "LessonsDTO(lessons=" + this.f106291a + ", completedCount=" + this.f106292b + ")";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AcademyLessonsViewModel(Application application, long j3) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.f106286j = j3;
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f106287k = LazyKt.a(lazyThreadSafetyModeB, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonsViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), qualifier, objArr);
            }
        });
        this.f106288l = new MutableLiveData();
        Observer observer = new Observer() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.i0
            @Override // androidx.lifecycle.Observer
            public final void a(Object obj) {
                AcademyLessonsViewModel.Q0(this.f106333a, (ViewModelState) obj);
            }
        };
        this.f106289m = observer;
        R0();
        AcademyRepository.f97249a.l().k(observer);
        G0(new AnonymousClass1(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(AcademyLessonsViewModel academyLessonsViewModel, ViewModelState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (Intrinsics.areEqual(it, Success.f128020a)) {
            academyLessonsViewModel.R0();
        }
    }

    public final long N0() {
        return this.f106286j;
    }

    public final LiveData O0() {
        return this.f106288l;
    }

    public final PremiumRepositoryV2 P0() {
        return (PremiumRepositoryV2) this.f106287k.getValue();
    }

    public final void R0() {
        G0(new AcademyLessonsViewModel$reloadLessons$1(this, null));
    }

    public final void S0(long j3) {
        this.f106286j = j3;
    }

    public final void T0(long j3) {
        G0(new AcademyLessonsViewModel$setCourseInfoForLessonId$1(j3, this, null));
    }

    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseViewModel, androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        AcademyRepository.f97249a.l().o(this.f106289m);
    }
}
