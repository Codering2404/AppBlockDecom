package cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.SnackbarHostState;
import androidx.compose.runtime.MutableState;
import cz.mobilesoft.coreblock.enums.Permission;
import cz.mobilesoft.coreblock.enums.PermissionAccessibilityReason;
import cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewCommand;
import cz.mobilesoft.coreblock.scene.permission.PermissionActivity;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.util.helperextension.DialogHelper;
import cz.mobilesoft.coreblock.util.permissions.PermissionDTO;
import cz.mobilesoft.coreblock.util.runnability.DeviceAdminHelper;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesScreenKt$CommandProcessor$1$1", f = "BlockingPreferencesScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class BlockingPreferencesScreenKt$CommandProcessor$1$1 extends SuspendLambda implements Function2<BlockingPreferencesViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f108054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f108055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f108056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Context f108057d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ManagedActivityResultLauncher f108058f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ MutableState f108059g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ ScaffoldState f108060h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ ManagedActivityResultLauncher f108061i;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesScreenKt$CommandProcessor$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesScreenKt$CommandProcessor$1$1$1", f = "BlockingPreferencesScreen.kt", l = {348}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108062a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ScaffoldState f108063b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ BlockingPreferencesViewCommand f108064c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ScaffoldState scaffoldState, BlockingPreferencesViewCommand blockingPreferencesViewCommand, Continuation continuation) {
            super(2, continuation);
            this.f108063b = scaffoldState;
            this.f108064c = blockingPreferencesViewCommand;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f108063b, this.f108064c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108062a;
            if (i3 == 0) {
                ResultKt.b(obj);
                SnackbarHostState snackbarHostStateB = this.f108063b.b();
                String strA = ((BlockingPreferencesViewCommand.ShowSnackBar) this.f108064c).a();
                this.f108062a = 1;
                if (SnackbarHostState.e(snackbarHostStateB, strA, null, null, this, 6, null) == objF) {
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

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BlockingPreferencesScreenKt$CommandProcessor$1$1(CoroutineScope coroutineScope, Context context, ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState, ScaffoldState scaffoldState, ManagedActivityResultLauncher managedActivityResultLauncher2, Continuation continuation) {
        super(2, continuation);
        this.f108056c = coroutineScope;
        this.f108057d = context;
        this.f108058f = managedActivityResultLauncher;
        this.f108059g = mutableState;
        this.f108060h = scaffoldState;
        this.f108061i = managedActivityResultLauncher2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(Activity activity, DialogInterface dialogInterface, int i3) {
        AnswersHelper.f128199a.H5();
        DeviceAdminHelper.i(activity);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        BlockingPreferencesScreenKt$CommandProcessor$1$1 blockingPreferencesScreenKt$CommandProcessor$1$1 = new BlockingPreferencesScreenKt$CommandProcessor$1$1(this.f108056c, this.f108057d, this.f108058f, this.f108059g, this.f108060h, this.f108061i, continuation);
        blockingPreferencesScreenKt$CommandProcessor$1$1.f108055b = obj;
        return blockingPreferencesScreenKt$CommandProcessor$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        BlockingPreferencesViewCommand blockingPreferencesViewCommand = (BlockingPreferencesViewCommand) this.f108055b;
        IntrinsicsKt.f();
        if (this.f108054a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (blockingPreferencesViewCommand instanceof BlockingPreferencesViewCommand.ShowSnackBar) {
            BuildersKt__Builders_commonKt.d(this.f108056c, null, null, new AnonymousClass1(this.f108060h, blockingPreferencesViewCommand, null), 3, null);
        } else if (Intrinsics.areEqual(blockingPreferencesViewCommand, BlockingPreferencesViewCommand.ShowDeviceAdmin.f108067a)) {
            Activity activityB = ContextExtKt.b(this.f108057d);
            if (activityB != null) {
                DeviceAdminHelper.g(this.f108061i, activityB);
            }
        } else if (Intrinsics.areEqual(blockingPreferencesViewCommand, BlockingPreferencesViewCommand.RemoveDeviceAdminPermission.f108065a)) {
            final Activity activityB2 = ContextExtKt.b(this.f108057d);
            if (activityB2 != null) {
                DialogHelper.j(activityB2, new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.f0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        BlockingPreferencesScreenKt$CommandProcessor$1$1.z(activityB2, dialogInterface, i3);
                    }
                }, new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.g0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        BlockingPreferencesScreenKt$CommandProcessor$1$1.A(dialogInterface, i3);
                    }
                });
            }
        } else if (Intrinsics.areEqual(blockingPreferencesViewCommand, BlockingPreferencesViewCommand.ShowPopupAccessibilityPermission.f108068a)) {
            this.f108058f.b(PermissionActivity.Companion.b(PermissionActivity.f111772j, this.f108057d, CollectionsKt.listOf(new PermissionDTO(new Permission.ACCESSIBILITY(PermissionAccessibilityReason.FloatingWindows.f97006a, false, 2, null), false, false, 6, null)), false, false, false, null, null, 124, null));
        } else {
            if (!(blockingPreferencesViewCommand instanceof BlockingPreferencesViewCommand.ShowAvailableSettingsConfirmation)) {
                throw new NoWhenBranchMatchedException();
            }
            this.f108059g.setValue(((BlockingPreferencesViewCommand.ShowAvailableSettingsConfirmation) blockingPreferencesViewCommand).a());
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public final Object invoke(BlockingPreferencesViewCommand blockingPreferencesViewCommand, Continuation continuation) {
        return ((BlockingPreferencesScreenKt$CommandProcessor$1$1) create(blockingPreferencesViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(DialogInterface dialogInterface, int i3) {
    }
}
