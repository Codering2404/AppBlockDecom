package cz.mobilesoft.coreblock.scene.schedule.customcombination;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.SnackbarData;
import androidx.compose.material.SnackbarDuration;
import androidx.compose.material.SnackbarHostState;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.tasks.OnSuccessListener;
import cz.mobilesoft.coreblock.enums.Permission;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.scene.permission.PermissionActivity;
import cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenNavigation;
import cz.mobilesoft.coreblock.scene.schedule.condition.wifi.SharedWifiConditionEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionScreenNavigation;
import cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.customcombination.CustomCombinationScreenNavigation;
import cz.mobilesoft.coreblock.scene.schedule.customcombination.CustomCombinationViewCommand;
import cz.mobilesoft.coreblock.scene.schedule.customcombination.CustomCombinationViewEvent;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.customcombination.CustomCombinationScreenKt$CommandProcessor$2$1", f = "CustomCombinationScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class CustomCombinationScreenKt$CommandProcessor$2$1 extends SuspendLambda implements Function2<CustomCombinationViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f116239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f116240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ScaffoldState f116241c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f116242d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ NavHostController f116243f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Context f116244g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ ManagedActivityResultLauncher f116245h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ ManagedActivityResultLauncher f116246i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ Function1 f116247j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ Function1 f116248k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ ManagedActivityResultLauncher f116249l;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.customcombination.CustomCombinationScreenKt$CommandProcessor$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.customcombination.CustomCombinationScreenKt$CommandProcessor$2$1$1", f = "CustomCombinationScreen.kt", l = {239}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f116250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ScaffoldState f116251b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ CustomCombinationViewCommand f116252c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ScaffoldState scaffoldState, CustomCombinationViewCommand customCombinationViewCommand, Continuation continuation) {
            super(2, continuation);
            this.f116251b = scaffoldState;
            this.f116252c = customCombinationViewCommand;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f116251b, this.f116252c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f116250a;
            if (i3 == 0) {
                ResultKt.b(obj);
                SnackbarHostState snackbarHostStateB = this.f116251b.b();
                String strA = ((CustomCombinationViewCommand.ShowSnackbar) this.f116252c).a();
                SnackbarDuration snackbarDuration = SnackbarDuration.Short;
                this.f116250a = 1;
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

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f116253a;

        static {
            int[] iArr = new int[ProfileType.values().length];
            try {
                iArr[ProfileType.WIFI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProfileType.LOCATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f116253a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CustomCombinationScreenKt$CommandProcessor$2$1(ScaffoldState scaffoldState, CoroutineScope coroutineScope, NavHostController navHostController, Context context, ManagedActivityResultLauncher managedActivityResultLauncher, ManagedActivityResultLauncher managedActivityResultLauncher2, Function1 function1, Function1 function12, ManagedActivityResultLauncher managedActivityResultLauncher3, Continuation continuation) {
        super(2, continuation);
        this.f116241c = scaffoldState;
        this.f116242d = coroutineScope;
        this.f116243f = navHostController;
        this.f116244g = context;
        this.f116245h = managedActivityResultLauncher;
        this.f116246i = managedActivityResultLauncher2;
        this.f116247j = function1;
        this.f116248k = function12;
        this.f116249l = managedActivityResultLauncher3;
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
        function1.invoke(new CustomCombinationViewEvent.CustomCombinationWifiConditionViewEvent(new WifiConditionViewEvent.OnSharedWifiConditionEvent(SharedWifiConditionEvent.OnLocationServicesEnabled.f115991a)));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        CustomCombinationScreenKt$CommandProcessor$2$1 customCombinationScreenKt$CommandProcessor$2$1 = new CustomCombinationScreenKt$CommandProcessor$2$1(this.f116241c, this.f116242d, this.f116243f, this.f116244g, this.f116245h, this.f116246i, this.f116247j, this.f116248k, this.f116249l, continuation);
        customCombinationScreenKt$CommandProcessor$2$1.f116240b = obj;
        return customCombinationScreenKt$CommandProcessor$2$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        CustomCombinationViewCommand customCombinationViewCommand = (CustomCombinationViewCommand) this.f116240b;
        IntrinsicsKt.f();
        if (this.f116239a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (customCombinationViewCommand instanceof CustomCombinationViewCommand.ShowSnackbar) {
            SnackbarData snackbarDataB = this.f116241c.b().b();
            if (snackbarDataB != null) {
                snackbarDataB.dismiss();
            }
            BuildersKt__Builders_commonKt.d(this.f116242d, null, null, new AnonymousClass1(this.f116241c, customCombinationViewCommand, null), 3, null);
        } else if (customCombinationViewCommand instanceof CustomCombinationViewCommand.NavigateToMain) {
            Boxing.a(NavController.T(this.f116243f, CustomCombinationScreenNavigation.CustomCombination.INSTANCE, false, false, 4, null));
        } else if (customCombinationViewCommand instanceof CustomCombinationViewCommand.CloseScreen) {
            Activity activityB = ContextExtKt.b(this.f116244g);
            if (activityB != null) {
                activityB.finish();
            }
        } else if (customCombinationViewCommand instanceof CustomCombinationViewCommand.OpenCondition) {
            int i3 = WhenMappings.f116253a[((CustomCombinationViewCommand.OpenCondition) customCombinationViewCommand).a().ordinal()];
            if (i3 == 1) {
                NavController.O(this.f116243f, WifiConditionScreenNavigation.WifiSelection.INSTANCE, null, null, 6, null);
            } else if (i3 == 2) {
                NavController.O(this.f116243f, new LocationConditionScreenNavigation.LocationSelection(false), null, null, 6, null);
            }
        } else if (Intrinsics.areEqual(customCombinationViewCommand, CustomCombinationViewCommand.CheckLocationServicesAvailable.f116263a)) {
            Activity activityB2 = ContextExtKt.b(this.f116244g);
            final Function1 function1 = this.f116248k;
            OnSuccessListener onSuccessListener = new OnSuccessListener() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.n0
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj2) {
                    CustomCombinationScreenKt$CommandProcessor$2$1.z(function1, (LocationSettingsResponse) obj2);
                }
            };
            final ManagedActivityResultLauncher managedActivityResultLauncher = this.f116249l;
            LocationHelperExtKt.b(activityB2, onSuccessListener, new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.o0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return CustomCombinationScreenKt$CommandProcessor$2$1.A(managedActivityResultLauncher, (ResolvableApiException) obj2);
                }
            });
        } else if (Intrinsics.areEqual(customCombinationViewCommand, CustomCombinationViewCommand.RequestLocationPermissions.f116267a)) {
            this.f116245h.b(PermissionActivity.Companion.b(PermissionActivity.f111772j, this.f116244g, CollectionsKt.listOf(new PermissionDTO(Permission.LOCATION.f96999d, false, false, 6, null)), true, false, false, Boxing.a(true), null, 88, null));
        } else if (customCombinationViewCommand instanceof CustomCombinationViewCommand.RequestManifestPermissions) {
            this.f116246i.b(((CustomCombinationViewCommand.RequestManifestPermissions) customCombinationViewCommand).a().toArray(new String[0]));
        } else {
            if (!(customCombinationViewCommand instanceof CustomCombinationViewCommand.SaveChanges)) {
                throw new NoWhenBranchMatchedException();
            }
            this.f116247j.invoke(((CustomCombinationViewCommand.SaveChanges) customCombinationViewCommand).a());
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public final Object invoke(CustomCombinationViewCommand customCombinationViewCommand, Continuation continuation) {
        return ((CustomCombinationScreenKt$CommandProcessor$2$1) create(customCombinationViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }
}
