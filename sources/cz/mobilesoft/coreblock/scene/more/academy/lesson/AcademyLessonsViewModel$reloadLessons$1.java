package cz.mobilesoft.coreblock.scene.more.academy.lesson;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonsViewModel$reloadLessons$1", f = "AcademyLessonsViewModel.kt", l = {53, 74, 84}, m = "invokeSuspend", v = 1)
final class AcademyLessonsViewModel$reloadLessons$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f106293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f106294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f106295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f106296d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f106297f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f106298g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f106299h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f106300i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f106301j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f106302k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ AcademyLessonsViewModel f106303l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AcademyLessonsViewModel$reloadLessons$1(AcademyLessonsViewModel academyLessonsViewModel, Continuation continuation) {
        super(1, continuation);
        this.f106303l = academyLessonsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new AcademyLessonsViewModel$reloadLessons$1(this.f106303l, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01c7 A[EDGE_INSN: B:137:0x01c7->B:65:0x01c7 BREAK  A[LOOP:4: B:46:0x0179->B:139:?]] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02a6  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 787
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonsViewModel$reloadLessons$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((AcademyLessonsViewModel$reloadLessons$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
