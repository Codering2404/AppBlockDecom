package cz.mobilesoft.coreblock.scene.more.settings.timenudge;

import android.content.Context;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsViewCommand;
import cz.mobilesoft.coreblock.scene.permission.PermissionActivity;
import cz.mobilesoft.coreblock.scene.timenudge.select.TimeNudgeSelectActivity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsScreenKt$CommandProcessor$1$1", f = "TimeNudgeSettingsScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class TimeNudgeSettingsScreenKt$CommandProcessor$1$1 extends SuspendLambda implements Function2<TimeNudgeSettingsViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f110272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f110273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f110274c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TimeNudgeSettingsScreenKt$CommandProcessor$1$1(Context context, Continuation continuation) {
        super(2, continuation);
        this.f110274c = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        TimeNudgeSettingsScreenKt$CommandProcessor$1$1 timeNudgeSettingsScreenKt$CommandProcessor$1$1 = new TimeNudgeSettingsScreenKt$CommandProcessor$1$1(this.f110274c, continuation);
        timeNudgeSettingsScreenKt$CommandProcessor$1$1.f110273b = obj;
        return timeNudgeSettingsScreenKt$CommandProcessor$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(TimeNudgeSettingsViewCommand timeNudgeSettingsViewCommand, Continuation continuation) {
        return ((TimeNudgeSettingsScreenKt$CommandProcessor$1$1) create(timeNudgeSettingsViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        TimeNudgeSettingsViewCommand timeNudgeSettingsViewCommand = (TimeNudgeSettingsViewCommand) this.f110273b;
        IntrinsicsKt.f();
        if (this.f110272a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (timeNudgeSettingsViewCommand instanceof TimeNudgeSettingsViewCommand.OpenAppPicker) {
            Context context = this.f110274c;
            context.startActivity(TimeNudgeSelectActivity.f122938g.a(context, new ArrayList(((TimeNudgeSettingsViewCommand.OpenAppPicker) timeNudgeSettingsViewCommand).a())));
        } else {
            if (!(timeNudgeSettingsViewCommand instanceof TimeNudgeSettingsViewCommand.RequestPermissions)) {
                throw new NoWhenBranchMatchedException();
            }
            Context context2 = this.f110274c;
            context2.startActivity(PermissionActivity.Companion.b(PermissionActivity.f111772j, context2, ((TimeNudgeSettingsViewCommand.RequestPermissions) timeNudgeSettingsViewCommand).a(), false, false, false, null, Boxing.d(R.string.jD), 60, null));
        }
        return Unit.f139807a;
    }
}
