package cz.mobilesoft.coreblock.repository;

import cz.mobilesoft.coreblock.scene.quickblock.QuickBlockProfileDTO;
import cz.mobilesoft.coreblock.storage.room.dao.PomodoroSessionDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.PomodoroSession;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.QuickBlockRepository$skipPomodoroBreak$1", f = "QuickBlockRepository.kt", l = {274}, m = "invokeSuspend", v = 1)
final class QuickBlockRepository$skipPomodoroBreak$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f97898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f97899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f97900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f97901d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f97902f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f97903g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ QuickBlockRepository f97904h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    QuickBlockRepository$skipPomodoroBreak$1(QuickBlockRepository quickBlockRepository, Continuation continuation) {
        super(2, continuation);
        this.f97904h = quickBlockRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new QuickBlockRepository$skipPomodoroBreak$1(this.f97904h, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        PomodoroSession pomodoroSessionG;
        QuickBlockRepository quickBlockRepository;
        PomodoroSession pomodoroSession;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f97903g;
        if (i3 == 0) {
            ResultKt.b(obj);
            QuickBlockProfileDTO quickBlockProfileDTOQ = this.f97904h.q();
            if (quickBlockProfileDTOQ != null && (pomodoroSessionG = quickBlockProfileDTOQ.g()) != null) {
                quickBlockRepository = this.f97904h;
                long jD = pomodoroSessionG.d() - pomodoroSessionG.r();
                PomodoroSession pomodoroSessionB = PomodoroSession.b(pomodoroSessionG, 0L, 0L, 0L, 0L, 0L, 0, false, 0L, jD, 255, null);
                PomodoroSessionDao pomodoroSessionDaoO = quickBlockRepository.o();
                this.f97898a = quickBlockRepository;
                this.f97899b = SpillingKt.a(pomodoroSessionG);
                this.f97900c = pomodoroSessionB;
                this.f97901d = 0;
                this.f97902f = jD;
                this.f97903g = 1;
                if (pomodoroSessionDaoO.p(pomodoroSessionB, this) == objF) {
                    return objF;
                }
                pomodoroSession = pomodoroSessionB;
            }
            return Unit.f139807a;
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        pomodoroSession = (PomodoroSession) this.f97900c;
        quickBlockRepository = (QuickBlockRepository) this.f97898a;
        ResultKt.b(obj);
        quickBlockRepository.L(pomodoroSession, true);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((QuickBlockRepository$skipPomodoroBreak$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
