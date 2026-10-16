package cz.mobilesoft.coreblock.scene.schedule.condition.wifi;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.SnackbarData;
import androidx.compose.material.SnackbarDuration;
import androidx.compose.material.SnackbarHostState;
import androidx.compose.runtime.MutableState;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.tasks.OnSuccessListener;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import cz.mobilesoft.coreblock.enums.Permission;
import cz.mobilesoft.coreblock.scene.permission.PermissionActivity;
import cz.mobilesoft.coreblock.scene.schedule.condition.wifi.SharedWifiConditionEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionViewCommand;
import cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionViewEvent;
import cz.mobilesoft.coreblock.util.LocationHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.util.permissions.PermissionDTO;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionScreenKt$CommandProcessor$2$1", f = "WifiConditionScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class WifiConditionScreenKt$CommandProcessor$2$1 extends SuspendLambda implements Function2<WifiConditionViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f116009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f116010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function1 f116011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function0 f116012d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableState f116013f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ ScaffoldState f116014g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f116015h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ Context f116016i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ ManagedActivityResultLauncher f116017j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ ManagedActivityResultLauncher f116018k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ Function1 f116019l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final /* synthetic */ ManagedActivityResultLauncher f116020m;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionScreenKt$CommandProcessor$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionScreenKt$CommandProcessor$2$1$1", f = "WifiConditionScreen.kt", l = {RCHTTPStatusCodes.NOT_MODIFIED}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f116021a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ScaffoldState f116022b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ WifiConditionViewCommand f116023c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ScaffoldState scaffoldState, WifiConditionViewCommand wifiConditionViewCommand, Continuation continuation) {
            super(2, continuation);
            this.f116022b = scaffoldState;
            this.f116023c = wifiConditionViewCommand;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f116022b, this.f116023c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f116021a;
            if (i3 == 0) {
                ResultKt.b(obj);
                SnackbarHostState snackbarHostStateB = this.f116022b.b();
                String strA = ((WifiConditionViewCommand.ShowSnackbar) this.f116023c).a();
                SnackbarDuration snackbarDuration = SnackbarDuration.Short;
                this.f116021a = 1;
                if (SnackbarHostState.e(snackbarHostStateB, strA, null, snackbarDuration, this, 2, null) == objF) {
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
    WifiConditionScreenKt$CommandProcessor$2$1(Function1 function1, Function0 function0, MutableState mutableState, ScaffoldState scaffoldState, CoroutineScope coroutineScope, Context context, ManagedActivityResultLauncher managedActivityResultLauncher, ManagedActivityResultLauncher managedActivityResultLauncher2, Function1 function12, ManagedActivityResultLauncher managedActivityResultLauncher3, Continuation continuation) {
        super(2, continuation);
        this.f116011c = function1;
        this.f116012d = function0;
        this.f116013f = mutableState;
        this.f116014g = scaffoldState;
        this.f116015h = coroutineScope;
        this.f116016i = context;
        this.f116017j = managedActivityResultLauncher;
        this.f116018k = managedActivityResultLauncher2;
        this.f116019l = function12;
        this.f116020m = managedActivityResultLauncher3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(ManagedActivityResultLauncher managedActivityResultLauncher, ResolvableApiException resolvableApiException) {
        PendingIntent pendingIntentA = resolvableApiException.a();
        Intrinsics.checkNotNullExpressionValue(pendingIntentA, "getResolution(...)");
        managedActivityResultLauncher.b(new IntentSenderRequest.Builder(pendingIntentA).a());
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(Function1 function1, LocationSettingsResponse locationSettingsResponse) {
        function1.invoke(new WifiConditionViewEvent.OnSharedWifiConditionEvent(SharedWifiConditionEvent.OnLocationServicesEnabled.f115991a));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        WifiConditionScreenKt$CommandProcessor$2$1 wifiConditionScreenKt$CommandProcessor$2$1 = new WifiConditionScreenKt$CommandProcessor$2$1(this.f116011c, this.f116012d, this.f116013f, this.f116014g, this.f116015h, this.f116016i, this.f116017j, this.f116018k, this.f116019l, this.f116020m, continuation);
        wifiConditionScreenKt$CommandProcessor$2$1.f116010b = obj;
        return wifiConditionScreenKt$CommandProcessor$2$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        WifiConditionViewCommand wifiConditionViewCommand = (WifiConditionViewCommand) this.f116010b;
        IntrinsicsKt.f();
        if (this.f116009a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (wifiConditionViewCommand instanceof WifiConditionViewCommand.SaveChanges) {
            this.f116011c.invoke(((WifiConditionViewCommand.SaveChanges) wifiConditionViewCommand).a());
        } else if (Intrinsics.areEqual(wifiConditionViewCommand, WifiConditionViewCommand.CloseScreen.f116035a)) {
            this.f116012d.invoke();
        } else if (Intrinsics.areEqual(wifiConditionViewCommand, WifiConditionViewCommand.ShowUnsavedChangesDialog.f116040a)) {
            this.f116013f.setValue(Boxing.a(true));
        } else if (wifiConditionViewCommand instanceof WifiConditionViewCommand.ShowSnackbar) {
            SnackbarData snackbarDataB = this.f116014g.b().b();
            if (snackbarDataB != null) {
                snackbarDataB.dismiss();
            }
            BuildersKt__Builders_commonKt.d(this.f116015h, null, null, new AnonymousClass1(this.f116014g, wifiConditionViewCommand, null), 3, null);
        } else if (Intrinsics.areEqual(wifiConditionViewCommand, WifiConditionViewCommand.CheckLocationServicesAvailable.f116034a)) {
            Activity activityB = ContextExtKt.b(this.f116016i);
            final Function1 function1 = this.f116019l;
            OnSuccessListener onSuccessListener = new OnSuccessListener() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.h1
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj2) {
                    WifiConditionScreenKt$CommandProcessor$2$1.z(function1, (LocationSettingsResponse) obj2);
                }
            };
            final ManagedActivityResultLauncher managedActivityResultLauncher = this.f116020m;
            LocationHelperExtKt.b(activityB, onSuccessListener, new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.i1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return WifiConditionScreenKt$CommandProcessor$2$1.A(managedActivityResultLauncher, (ResolvableApiException) obj2);
                }
            });
        } else if (Intrinsics.areEqual(wifiConditionViewCommand, WifiConditionViewCommand.RequestLocationPermissions.f116036a)) {
            this.f116017j.b(PermissionActivity.Companion.b(PermissionActivity.f111772j, this.f116016i, CollectionsKt.listOf(new PermissionDTO(Permission.LOCATION.f96999d, false, false, 6, null)), true, false, false, Boxing.a(true), null, 88, null));
        } else {
            if (!(wifiConditionViewCommand instanceof WifiConditionViewCommand.RequestManifestPermissions)) {
                throw new NoWhenBranchMatchedException();
            }
            this.f116018k.b(((WifiConditionViewCommand.RequestManifestPermissions) wifiConditionViewCommand).a().toArray(new String[0]));
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public final Object invoke(WifiConditionViewCommand wifiConditionViewCommand, Continuation continuation) {
        return ((WifiConditionScreenKt$CommandProcessor$2$1) create(wifiConditionViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }
}
