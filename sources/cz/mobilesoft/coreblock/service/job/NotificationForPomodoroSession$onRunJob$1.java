package cz.mobilesoft.coreblock.service.job;

import android.content.Context;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.PomodoroSession;
import cz.mobilesoft.widgets.AppBlockWidgetState;
import cz.mobilesoft.widgets.quickblock.QuickBlockWidgetReceiver;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.service.job.NotificationForPomodoroSession$onRunJob$1", f = "NotificationForPomodoroSession.kt", l = {31}, m = "invokeSuspend", v = 1)
final class NotificationForPomodoroSession$onRunJob$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f123361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f123362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f123363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f123364d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NotificationForPomodoroSession$onRunJob$1(String str, int i3, long j3, Continuation continuation) {
        super(1, continuation);
        this.f123362b = str;
        this.f123363c = i3;
        this.f123364d = j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppBlockWidgetState q(String str, int i3, long j3, AppBlockWidgetState appBlockWidgetState) {
        return AppBlockWidgetState.e(appBlockWidgetState, new AppBlockWidgetState.QuickBlockWidgetState.Blocking.Pomodoro(new AppBlockWidgetState.QuickBlockWidgetState.Blocking.Pomodoro.PomodoroSession(Intrinsics.areEqual(str, PomodoroSession.SessionMode.f126444b.a()), i3 + 1, j3)), null, false, 0, 14, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new NotificationForPomodoroSession$onRunJob$1(this.f123362b, this.f123363c, this.f123364d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f123361a;
        if (i3 == 0) {
            ResultKt.b(obj);
            QuickBlockWidgetReceiver.Companion companion = QuickBlockWidgetReceiver.f134085h;
            Context contextG = LockieApplication.g();
            Intrinsics.checkNotNullExpressionValue(contextG, "getContext(...)");
            final String str = this.f123362b;
            final int i4 = this.f123363c;
            final long j3 = this.f123364d;
            Function1 function1 = new Function1() { // from class: cz.mobilesoft.coreblock.service.job.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return NotificationForPomodoroSession$onRunJob$1.q(str, i4, j3, (AppBlockWidgetState) obj2);
                }
            };
            this.f123361a = 1;
            if (companion.a(contextG, function1, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((NotificationForPomodoroSession$onRunJob$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
