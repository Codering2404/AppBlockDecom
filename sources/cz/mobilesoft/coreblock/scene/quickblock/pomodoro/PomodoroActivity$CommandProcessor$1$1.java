package cz.mobilesoft.coreblock.scene.quickblock.pomodoro;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import cz.mobilesoft.coreblock.enums.Permission;
import cz.mobilesoft.coreblock.scene.email_consent.EmailCommunicationConsentActivity;
import cz.mobilesoft.coreblock.scene.permission.PermissionActivity;
import cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroViewCommand;
import cz.mobilesoft.coreblock.util.permissions.PermissionDTO;
import cz.mobilesoft.coreblock.view.compose.ActivityLauncher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroActivity$CommandProcessor$1$1", f = "PomodoroActivity.kt", l = {}, m = "invokeSuspend", v = 1)
final class PomodoroActivity$CommandProcessor$1$1 extends SuspendLambda implements Function2<PomodoroViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f114050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f114051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f114052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ PomodoroActivity f114053d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableState f114054f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ ActivityLauncher f114055g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ boolean f114056h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PomodoroActivity$CommandProcessor$1$1(Context context, PomodoroActivity pomodoroActivity, MutableState mutableState, ActivityLauncher activityLauncher, boolean z2, Continuation continuation) {
        super(2, continuation);
        this.f114052c = context;
        this.f114053d = pomodoroActivity;
        this.f114054f = mutableState;
        this.f114055g = activityLauncher;
        this.f114056h = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        PomodoroActivity$CommandProcessor$1$1 pomodoroActivity$CommandProcessor$1$1 = new PomodoroActivity$CommandProcessor$1$1(this.f114052c, this.f114053d, this.f114054f, this.f114055g, this.f114056h, continuation);
        pomodoroActivity$CommandProcessor$1$1.f114051b = obj;
        return pomodoroActivity$CommandProcessor$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(PomodoroViewCommand pomodoroViewCommand, Continuation continuation) {
        return ((PomodoroActivity$CommandProcessor$1$1) create(pomodoroViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        PomodoroViewCommand pomodoroViewCommand = (PomodoroViewCommand) this.f114051b;
        IntrinsicsKt.f();
        if (this.f114050a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (pomodoroViewCommand instanceof PomodoroViewCommand.StartPomodoro) {
            if (((PomodoroViewCommand.StartPomodoro) pomodoroViewCommand).a()) {
                Context context = this.f114052c;
                context.startActivity(EmailCommunicationConsentActivity.f101711g.a(context, "pomodoro"));
            }
            this.f114053d.finish();
        } else if (pomodoroViewCommand instanceof PomodoroViewCommand.ShowStrictModeDialog) {
            this.f114054f.setValue(Boxing.a(true));
        } else {
            if (!(pomodoroViewCommand instanceof PomodoroViewCommand.ShowPermissionsBeforeStart)) {
                throw new NoWhenBranchMatchedException();
            }
            PomodoroViewCommand.ShowPermissionsBeforeStart showPermissionsBeforeStart = (PomodoroViewCommand.ShowPermissionsBeforeStart) pomodoroViewCommand;
            this.f114055g.a().setValue(showPermissionsBeforeStart.b());
            PermissionActivity.Companion companion = PermissionActivity.f111772j;
            Context context2 = this.f114052c;
            List listA = showPermissionsBeforeStart.a();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listA, 10));
            Iterator it = listA.iterator();
            while (it.hasNext()) {
                arrayList.add(new PermissionDTO((Permission) it.next(), false, false, 6, null));
            }
            this.f114055g.b().b(PermissionActivity.Companion.b(companion, context2, arrayList, false, this.f114056h, false, null, null, 116, null));
        }
        return Unit.f139807a;
    }
}
