package cz.mobilesoft.coreblock.scene.more.academy.lesson;

import cz.mobilesoft.coreblock.rest.response.CourseStateResponse;
import cz.mobilesoft.coreblock.rest.response.LessonStateResponse;
import cz.mobilesoft.coreblock.scene.more.academy.AcademyCourseState;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonViewModel$finishLesson$1", f = "AcademyLessonViewModel.kt", l = {53, 60, 62}, m = "invokeSuspend", v = 1)
final class AcademyLessonViewModel$finishLesson$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f106240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f106241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f106242c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f106243d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ AcademyLessonViewModel f106244f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Function1 f106245g;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonViewModel$finishLesson$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonViewModel$finishLesson$1$1", f = "AcademyLessonViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f106246a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1 f106247b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f106248c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ AcademyLessonViewModel f106249d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Function1 function1, List list, AcademyLessonViewModel academyLessonViewModel, Continuation continuation) {
            super(2, continuation);
            this.f106247b = function1;
            this.f106248c = list;
            this.f106249d = academyLessonViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f106247b, this.f106248c, this.f106249d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f106246a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            Function1 function1 = this.f106247b;
            List list = this.f106248c;
            AcademyLessonViewModel academyLessonViewModel = this.f106249d;
            boolean z2 = false;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator it = list.iterator();
                loop0: while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    CourseStateResponse courseStateResponse = (CourseStateResponse) it.next();
                    if (courseStateResponse.getState() == AcademyCourseState.COMPLETE) {
                        List<LessonStateResponse> lessons = courseStateResponse.getLessons();
                        if (!(lessons instanceof Collection) || !lessons.isEmpty()) {
                            Iterator<T> it2 = lessons.iterator();
                            while (it2.hasNext()) {
                                if (((LessonStateResponse) it2.next()).getId() == academyLessonViewModel.K0()) {
                                    z2 = true;
                                    break loop0;
                                }
                            }
                        }
                    }
                }
            }
            function1.invoke(Boxing.a(z2));
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AcademyLessonViewModel$finishLesson$1(AcademyLessonViewModel academyLessonViewModel, Function1 function1, Continuation continuation) {
        super(1, continuation);
        this.f106244f = academyLessonViewModel;
        this.f106245g = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new AcademyLessonViewModel$finishLesson$1(this.f106244f, this.f106245g, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00c1  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 271
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonViewModel$finishLesson$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((AcademyLessonViewModel$finishLesson$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
