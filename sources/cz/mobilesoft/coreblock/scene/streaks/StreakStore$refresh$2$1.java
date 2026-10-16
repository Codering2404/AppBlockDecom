package cz.mobilesoft.coreblock.scene.streaks;

import cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator;
import java.time.LocalDate;
import java.time.ZoneId;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.streaks.StreakStore$refresh$2$1", f = "StreakStore.kt", l = {144}, m = "invokeSuspend", v = 1)
final class StreakStore$refresh$2$1 extends SuspendLambda implements Function2<LocalDate, Continuation<? super StreakEvaluator.DayEvaluation>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f120579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f120580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ StreakStore f120581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f120582d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ZoneId f120583f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreakStore$refresh$2$1(StreakStore streakStore, long j3, ZoneId zoneId, Continuation continuation) {
        super(2, continuation);
        this.f120581c = streakStore;
        this.f120582d = j3;
        this.f120583f = zoneId;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        StreakStore$refresh$2$1 streakStore$refresh$2$1 = new StreakStore$refresh$2$1(this.f120581c, this.f120582d, this.f120583f, continuation);
        streakStore$refresh$2$1.f120580b = obj;
        return streakStore$refresh$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(LocalDate localDate, Continuation continuation) {
        return ((StreakStore$refresh$2$1) create(localDate, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        LocalDate localDate = (LocalDate) this.f120580b;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f120579a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        StreakEvaluator streakEvaluator = this.f120581c.f120520c;
        long j3 = this.f120582d;
        ZoneId zoneId = this.f120583f;
        this.f120580b = SpillingKt.a(localDate);
        this.f120579a = 1;
        Object objB = streakEvaluator.b(localDate, j3, zoneId, this);
        return objB == objF ? objF : objB;
    }
}
