package cz.mobilesoft.coreblock.scene.more.academy.lesson;

import cz.mobilesoft.coreblock.repository.AcademyRepository;
import cz.mobilesoft.coreblock.storage.room.academy.AcademyLessonWithCourse;
import cz.mobilesoft.coreblock.storage.room.dao.core.AcademyLessonDao;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonsViewModel$setCourseInfoForLessonId$1", f = "AcademyLessonsViewModel.kt", l = {45}, m = "invokeSuspend", v = 1)
final class AcademyLessonsViewModel$setCourseInfoForLessonId$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f106304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f106305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ AcademyLessonsViewModel f106306c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AcademyLessonsViewModel$setCourseInfoForLessonId$1(long j3, AcademyLessonsViewModel academyLessonsViewModel, Continuation continuation) {
        super(1, continuation);
        this.f106305b = j3;
        this.f106306c = academyLessonsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new AcademyLessonsViewModel$setCourseInfoForLessonId$1(this.f106305b, this.f106306c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f106304a;
        if (i3 == 0) {
            ResultKt.b(obj);
            AcademyLessonDao academyLessonDaoJ = AcademyRepository.f97249a.j();
            long j3 = this.f106305b;
            this.f106304a = 1;
            obj = academyLessonDaoJ.e(j3, this);
            if (obj == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        AcademyLessonWithCourse academyLessonWithCourse = (AcademyLessonWithCourse) obj;
        if (academyLessonWithCourse == null) {
            return Unit.f139807a;
        }
        this.f106306c.S0(academyLessonWithCourse.b().b());
        this.f106306c.R0();
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((AcademyLessonsViewModel$setCourseInfoForLessonId$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
