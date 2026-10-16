package cz.mobilesoft.coreblock.scene.more.academy.course;

import android.app.Application;
import cz.mobilesoft.coreblock.base.viewmodel.BaseViewModel;
import cz.mobilesoft.coreblock.repository.AcademyRepository;
import cz.mobilesoft.coreblock.scene.more.academy.CourseCardView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

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
public final class AcademyCoursesViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Flow f106156i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AcademyCoursesViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        final Flow all = AcademyRepository.f97249a.h().getAll();
        this.f106156i = new Flow<List<? extends CourseCardView.CourseDTO>>() { // from class: cz.mobilesoft.coreblock.scene.more.academy.course.AcademyCoursesViewModel$special$$inlined$map$1

            /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.academy.course.AcademyCoursesViewModel$special$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ FlowCollector f106161a;

                /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.academy.course.AcademyCoursesViewModel$special$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata
                @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.academy.course.AcademyCoursesViewModel$special$$inlined$map$1$2", f = "AcademyCoursesViewModel.kt", l = {50}, m = "emit", v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f106162a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f106163b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    Object f106164c;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    Object f106166f;

                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                    Object f106167g;

                    /* JADX INFO: renamed from: h, reason: collision with root package name */
                    Object f106168h;

                    /* JADX INFO: renamed from: i, reason: collision with root package name */
                    int f106169i;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f106162a = obj;
                        this.f106163b |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f106161a = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r12, kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
                    /*
                        r11 = this;
                        boolean r0 = r13 instanceof cz.mobilesoft.coreblock.scene.more.academy.course.AcademyCoursesViewModel$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r13
                        cz.mobilesoft.coreblock.scene.more.academy.course.AcademyCoursesViewModel$special$$inlined$map$1$2$1 r0 = (cz.mobilesoft.coreblock.scene.more.academy.course.AcademyCoursesViewModel$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f106163b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f106163b = r1
                        goto L18
                    L13:
                        cz.mobilesoft.coreblock.scene.more.academy.course.AcademyCoursesViewModel$special$$inlined$map$1$2$1 r0 = new cz.mobilesoft.coreblock.scene.more.academy.course.AcademyCoursesViewModel$special$$inlined$map$1$2$1
                        r0.<init>(r13)
                    L18:
                        java.lang.Object r13 = r0.f106162a
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r2 = r0.f106163b
                        r3 = 1
                        if (r2 == 0) goto L3a
                        if (r2 != r3) goto L32
                        java.lang.Object r12 = r0.f106168h
                        kotlinx.coroutines.flow.FlowCollector r12 = (kotlinx.coroutines.flow.FlowCollector) r12
                        java.lang.Object r12 = r0.f106166f
                        cz.mobilesoft.coreblock.scene.more.academy.course.AcademyCoursesViewModel$special$$inlined$map$1$2$1 r12 = (cz.mobilesoft.coreblock.scene.more.academy.course.AcademyCoursesViewModel$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r12
                        kotlin.ResultKt.b(r13)
                        goto Lb8
                    L32:
                        java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                        java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                        r12.<init>(r13)
                        throw r12
                    L3a:
                        kotlin.ResultKt.b(r13)
                        kotlinx.coroutines.flow.FlowCollector r13 = r11.f106161a
                        r2 = r12
                        java.util.List r2 = (java.util.List) r2
                        java.lang.Iterable r2 = (java.lang.Iterable) r2
                        r4 = 2
                        kotlin.jvm.functions.Function1[] r4 = new kotlin.jvm.functions.Function1[r4]
                        cz.mobilesoft.coreblock.scene.more.academy.course.AcademyCoursesViewModel$coursesFlow$1$1 r5 = cz.mobilesoft.coreblock.scene.more.academy.course.AcademyCoursesViewModel$coursesFlow$1$1.f106157a
                        r6 = 0
                        r4[r6] = r5
                        cz.mobilesoft.coreblock.scene.more.academy.course.AcademyCoursesViewModel$coursesFlow$1$2 r5 = cz.mobilesoft.coreblock.scene.more.academy.course.AcademyCoursesViewModel$coursesFlow$1$2.f106158a
                        r4[r3] = r5
                        java.util.Comparator r4 = kotlin.comparisons.ComparisonsKt.b(r4)
                        java.util.List r2 = kotlin.collections.CollectionsKt.sortedWith(r2, r4)
                        java.lang.Iterable r2 = (java.lang.Iterable) r2
                        java.util.ArrayList r4 = new java.util.ArrayList
                        r5 = 10
                        int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r5)
                        r4.<init>(r5)
                        java.util.Iterator r2 = r2.iterator()
                    L69:
                        boolean r5 = r2.hasNext()
                        if (r5 == 0) goto L95
                        java.lang.Object r5 = r2.next()
                        cz.mobilesoft.coreblock.storage.room.academy.AcademyCourseWithLessons r5 = (cz.mobilesoft.coreblock.storage.room.academy.AcademyCourseWithLessons) r5
                        cz.mobilesoft.coreblock.scene.more.academy.CourseCardView$CourseDTO$Companion r7 = cz.mobilesoft.coreblock.scene.more.academy.CourseCardView.CourseDTO.f106077h
                        cz.mobilesoft.coreblock.storage.room.entity.core.AcademyCourseEntity r8 = r5.a()
                        java.util.List r9 = r5.c()
                        cz.mobilesoft.coreblock.scene.more.academy.CourseCardView$CourseCardState$Companion r10 = cz.mobilesoft.coreblock.scene.more.academy.CourseCardView.CourseCardState.Companion
                        cz.mobilesoft.coreblock.storage.room.entity.core.AcademyCourseEntity r5 = r5.a()
                        cz.mobilesoft.coreblock.scene.more.academy.AcademyCourseState r5 = r5.a()
                        cz.mobilesoft.coreblock.scene.more.academy.CourseCardView$CourseCardState r5 = r10.a(r5)
                        cz.mobilesoft.coreblock.scene.more.academy.CourseCardView$CourseDTO r5 = r7.a(r8, r9, r5)
                        r4.add(r5)
                        goto L69
                    L95:
                        java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r12)
                        r0.f106164c = r2
                        java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
                        r0.f106166f = r2
                        java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.a(r12)
                        r0.f106167g = r12
                        java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.a(r13)
                        r0.f106168h = r12
                        r0.f106169i = r6
                        r0.f106163b = r3
                        java.lang.Object r12 = r13.emit(r4, r0)
                        if (r12 != r1) goto Lb8
                        return r1
                    Lb8:
                        kotlin.Unit r12 = kotlin.Unit.f139807a
                        return r12
                    */
                    throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.academy.course.AcademyCoursesViewModel$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = all.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
            }
        };
    }

    public final Flow I0() {
        return this.f106156i;
    }

    public final void J0() {
        G0(new AcademyCoursesViewModel$signOut$1(null));
    }
}
