package cz.mobilesoft.coreblock.scene.more.academy.lesson;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.viewmodel.BaseViewModel;
import cz.mobilesoft.coreblock.repository.AcademyRepository;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.storage.room.academy.AcademyLessonWithCourse;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.helperextension.NumberExtKt;
import cz.mobilesoft.coreblock.util.monetization.AccessPolicyKt;
import cz.mobilesoft.coreblock.util.monetization.Capability;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class AcademyLessonViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f106235i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Lazy f106236j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private AcademyLessonWithCourse f106237k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Flow f106238l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final MutableLiveData f106239m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AcademyLessonViewModel(Application application, long j3) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.f106235i = j3;
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f106236j = LazyKt.a(lazyThreadSafetyModeB, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonViewModel$special$$inlined$inject$default$1
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
        final Flow flowO = AcademyRepository.f97249a.j().o(j3);
        this.f106238l = new Flow<AcademyLessonWithCourse>() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonViewModel$special$$inlined$map$1

            /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonViewModel$special$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ FlowCollector f106259a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ AcademyLessonViewModel f106260b;

                /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonViewModel$special$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata
                @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonViewModel$special$$inlined$map$1$2", f = "AcademyLessonViewModel.kt", l = {50}, m = "emit", v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f106261a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f106262b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    Object f106263c;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    Object f106265f;

                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                    Object f106266g;

                    /* JADX INFO: renamed from: h, reason: collision with root package name */
                    Object f106267h;

                    /* JADX INFO: renamed from: i, reason: collision with root package name */
                    int f106268i;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f106261a = obj;
                        this.f106262b |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, AcademyLessonViewModel academyLessonViewModel) {
                    this.f106259a = flowCollector;
                    this.f106260b = academyLessonViewModel;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonViewModel$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonViewModel$special$$inlined$map$1$2$1 r0 = (cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonViewModel$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f106262b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f106262b = r1
                        goto L18
                    L13:
                        cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonViewModel$special$$inlined$map$1$2$1 r0 = new cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonViewModel$special$$inlined$map$1$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.f106261a
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r2 = r0.f106262b
                        r3 = 1
                        if (r2 == 0) goto L39
                        if (r2 != r3) goto L31
                        java.lang.Object r6 = r0.f106267h
                        kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
                        java.lang.Object r6 = r0.f106265f
                        cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonViewModel$special$$inlined$map$1$2$1 r6 = (cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonViewModel$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r6
                        kotlin.ResultKt.b(r7)
                        goto L6a
                    L31:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L39:
                        kotlin.ResultKt.b(r7)
                        kotlinx.coroutines.flow.FlowCollector r7 = r5.f106259a
                        r2 = r6
                        cz.mobilesoft.coreblock.storage.room.academy.AcademyLessonWithCourse r2 = (cz.mobilesoft.coreblock.storage.room.academy.AcademyLessonWithCourse) r2
                        cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonViewModel r4 = r5.f106260b
                        r4.Q0(r2)
                        java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
                        r0.f106263c = r4
                        java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
                        r0.f106265f = r4
                        java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
                        r0.f106266g = r6
                        java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
                        r0.f106267h = r6
                        r6 = 0
                        r0.f106268i = r6
                        r0.f106262b = r3
                        java.lang.Object r6 = r7.emit(r2, r0)
                        if (r6 != r1) goto L6a
                        return r1
                    L6a:
                        kotlin.Unit r6 = kotlin.Unit.f139807a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonViewModel$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = flowO.collect(new AnonymousClass2(flowCollector, this), continuation);
                return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
            }
        };
        this.f106239m = new MutableLiveData();
    }

    public final void I0(Function1 onSuccess) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        H0(new AcademyLessonViewModel$finishLesson$1(this, onSuccess, null));
    }

    public final MutableLiveData J0() {
        return this.f106239m;
    }

    public final long K0() {
        return this.f106235i;
    }

    public final AcademyLessonWithCourse L0() {
        return this.f106237k;
    }

    public final Flow M0() {
        return this.f106238l;
    }

    public final PremiumRepositoryV2 N0() {
        return (PremiumRepositoryV2) this.f106236j.getValue();
    }

    public final boolean O0() {
        AcademyLessonWithCourse academyLessonWithCourse = this.f106237k;
        return (academyLessonWithCourse == null || academyLessonWithCourse.b().g() != PrefManager.f126839a.g0() - 1 || AccessPolicyKt.a(N0().J(), Capability.PremiumAccess)) ? false : true;
    }

    public final String P0(String content, Context context) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(context, "context");
        return "<html><head><style type=\"text/css\">@font-face { font-family: 'inter';font-weight: normal;src: url('file:///android_res/font/inter_regular.ttf'); }@font-face { font-family: 'inter';font-weight: 600;src: url('file:///android_res/font/inter_bold.ttf'); }a { color: " + NumberExtKt.b(R.color.f95446a, context, false, 2, null) + "; }img {max-width: 100%; height: auto !important; width: auto !important; }body {font-family: inter;line-height: 1.5;margin: 0;padding: 0;color: " + NumberExtKt.b(R.color.f95456k, context, false, 2, null) + ";background-color: " + NumberExtKt.b(R.color.f95448c, context, false, 2, null) + "}</style></head><body>" + content + "</body></html>";
    }

    public final void Q0(AcademyLessonWithCourse academyLessonWithCourse) {
        this.f106237k = academyLessonWithCourse;
    }
}
