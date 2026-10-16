package cz.mobilesoft.coreblock.scene.more.settings.notification;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import androidx.compose.material.ScaffoldState;
import cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewCommand;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.util.helperextension.DialogHelper;
import cz.mobilesoft.coreblock.util.notifications.NotificationChannelHelper;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsScreenKt$CommandProcessor$1$1", f = "NotificationSettingsScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class NotificationSettingsScreenKt$CommandProcessor$1$1 extends SuspendLambda implements Function2<NotificationSettingsViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f109963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f109964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f109965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f109966d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ScaffoldState f109967f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NotificationSettingsScreenKt$CommandProcessor$1$1(Context context, CoroutineScope coroutineScope, ScaffoldState scaffoldState, Continuation continuation) {
        super(2, continuation);
        this.f109965c = context;
        this.f109966d = coroutineScope;
        this.f109967f = scaffoldState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(Context context, NotificationSettingsViewCommand notificationSettingsViewCommand, CoroutineScope coroutineScope, Activity activity, ScaffoldState scaffoldState, DialogInterface dialogInterface, int i3) {
        if (((NotificationSettingsViewCommand.ShowBlockedAppsNotificationChannelDialog) notificationSettingsViewCommand).a()) {
            BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new NotificationSettingsScreenKt$CommandProcessor$1$1$1$1$1$1(scaffoldState, context, null), 3, null);
        } else {
            NotificationChannelHelper.c(activity);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        NotificationSettingsScreenKt$CommandProcessor$1$1 notificationSettingsScreenKt$CommandProcessor$1$1 = new NotificationSettingsScreenKt$CommandProcessor$1$1(this.f109965c, this.f109966d, this.f109967f, continuation);
        notificationSettingsScreenKt$CommandProcessor$1$1.f109964b = obj;
        return notificationSettingsScreenKt$CommandProcessor$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        final NotificationSettingsViewCommand notificationSettingsViewCommand = (NotificationSettingsViewCommand) this.f109964b;
        IntrinsicsKt.f();
        if (this.f109963a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (!(notificationSettingsViewCommand instanceof NotificationSettingsViewCommand.ShowBlockedAppsNotificationChannelDialog)) {
            throw new NoWhenBranchMatchedException();
        }
        final Activity activityB = ContextExtKt.b(this.f109965c);
        if (activityB != null) {
            final Context context = this.f109965c;
            final CoroutineScope coroutineScope = this.f109966d;
            final ScaffoldState scaffoldState = this.f109967f;
            DialogHelper.l(activityB, false, new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.f1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    NotificationSettingsScreenKt$CommandProcessor$1$1.y(context, notificationSettingsViewCommand, coroutineScope, activityB, scaffoldState, dialogInterface, i3);
                }
            });
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public final Object invoke(NotificationSettingsViewCommand notificationSettingsViewCommand, Continuation continuation) {
        return ((NotificationSettingsScreenKt$CommandProcessor$1$1) create(notificationSettingsViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }
}
