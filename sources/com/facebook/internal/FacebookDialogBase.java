package com.facebook.internal;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookDialog;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public abstract class FacebookDialogBase<CONTENT, RESULT> implements FacebookDialog<CONTENT, RESULT> {
    private static final String TAG = "FacebookDialog";
    private final Activity activity;
    private CallbackManager callbackManager;
    private final FragmentWrapper fragmentWrapper;
    private List<? extends FacebookDialogBase<CONTENT, RESULT>.ModeHandler> modeHandlers;
    private int requestCodeField;
    public static final Companion Companion = new Companion(null);
    public static final Object BASE_AUTOMATIC_MODE = new Object();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public abstract class ModeHandler {
        private Object mode = FacebookDialogBase.BASE_AUTOMATIC_MODE;

        public ModeHandler() {
        }

        public abstract boolean canShow(CONTENT content, boolean z2);

        public abstract AppCall createAppCall(CONTENT content);

        public Object getMode() {
            return this.mode;
        }

        public void setMode(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "<set-?>");
            this.mode = obj;
        }
    }

    protected FacebookDialogBase(Activity activity, int i3) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.fragmentWrapper = null;
        this.requestCodeField = i3;
        this.callbackManager = null;
    }

    private final List<FacebookDialogBase<CONTENT, RESULT>.ModeHandler> cachedModeHandlers() {
        if (this.modeHandlers == null) {
            this.modeHandlers = getOrderedModeHandlers();
        }
        List<? extends FacebookDialogBase<CONTENT, RESULT>.ModeHandler> list = this.modeHandlers;
        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.List<com.facebook.internal.FacebookDialogBase.ModeHandler<CONTENT of com.facebook.internal.FacebookDialogBase, RESULT of com.facebook.internal.FacebookDialogBase>>");
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppCall createAppCallForMode(CONTENT content, Object obj) {
        AppCall appCallCreateAppCall;
        boolean z2 = obj == BASE_AUTOMATIC_MODE;
        Iterator<FacebookDialogBase<CONTENT, RESULT>.ModeHandler> it = cachedModeHandlers().iterator();
        while (true) {
            if (!it.hasNext()) {
                appCallCreateAppCall = null;
                break;
            }
            FacebookDialogBase<CONTENT, RESULT>.ModeHandler next = it.next();
            if (z2 || Utility.areObjectsEqual(next.getMode(), obj)) {
                if (next.canShow(content, true)) {
                    try {
                        appCallCreateAppCall = next.createAppCall(content);
                        break;
                    } catch (FacebookException e3) {
                        AppCall appCallCreateBaseAppCall = createBaseAppCall();
                        DialogPresenter.setupAppCallForValidationError(appCallCreateBaseAppCall, e3);
                        appCallCreateAppCall = appCallCreateBaseAppCall;
                    }
                }
            }
        }
        if (appCallCreateAppCall != null) {
            return appCallCreateAppCall;
        }
        AppCall appCallCreateBaseAppCall2 = createBaseAppCall();
        DialogPresenter.setupAppCallForCannotShowError(appCallCreateBaseAppCall2);
        return appCallCreateBaseAppCall2;
    }

    private final void memorizeCallbackManager(CallbackManager callbackManager) {
        CallbackManager callbackManager2 = this.callbackManager;
        if (callbackManager2 == null) {
            this.callbackManager = callbackManager;
        } else if (callbackManager2 != callbackManager) {
            Log.w(TAG, "You're registering a callback on a Facebook dialog with two different callback managers. It's almost wrong and may cause unexpected results. Only the first callback manager will be used for handling activity result with androidx.");
        }
    }

    @Override // com.facebook.FacebookDialog
    public boolean canShow(CONTENT content) {
        return canShowImpl(content, BASE_AUTOMATIC_MODE);
    }

    protected boolean canShowImpl(CONTENT content, Object mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        boolean z2 = mode == BASE_AUTOMATIC_MODE;
        for (FacebookDialogBase<CONTENT, RESULT>.ModeHandler modeHandler : cachedModeHandlers()) {
            if (z2 || Utility.areObjectsEqual(modeHandler.getMode(), mode)) {
                if (modeHandler.canShow(content, false)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected final ActivityResultContract<CONTENT, CallbackManager.ActivityResultParameters> createActivityResultContractForShowingDialog(final CallbackManager callbackManager, final Object mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        return new ActivityResultContract<CONTENT, CallbackManager.ActivityResultParameters>(this) { // from class: com.facebook.internal.FacebookDialogBase.createActivityResultContractForShowingDialog.1
            final /* synthetic */ FacebookDialogBase<CONTENT, RESULT> this$0;

            {
                this.this$0 = this;
            }

            @Override // androidx.activity.result.contract.ActivityResultContract
            public Intent createIntent(Context context, CONTENT content) {
                Intrinsics.checkNotNullParameter(context, "context");
                AppCall appCallCreateAppCallForMode = this.this$0.createAppCallForMode(content, mode);
                Intent requestIntent = appCallCreateAppCallForMode != null ? appCallCreateAppCallForMode.getRequestIntent() : null;
                if (requestIntent != null) {
                    appCallCreateAppCallForMode.setPending();
                    return requestIntent;
                }
                throw new FacebookException("Content " + content + " is not supported");
            }

            @Override // androidx.activity.result.contract.ActivityResultContract
            public CallbackManager.ActivityResultParameters parseResult(int i3, Intent intent) {
                CallbackManager callbackManager2 = callbackManager;
                if (callbackManager2 != null) {
                    callbackManager2.onActivityResult(this.this$0.getRequestCode(), i3, intent);
                }
                return new CallbackManager.ActivityResultParameters(this.this$0.getRequestCode(), i3, intent);
            }
        };
    }

    protected abstract AppCall createBaseAppCall();

    /* JADX INFO: Access modifiers changed from: protected */
    public final Activity getActivityContext() {
        Activity activity = this.activity;
        if (activity != null) {
            return activity;
        }
        FragmentWrapper fragmentWrapper = this.fragmentWrapper;
        if (fragmentWrapper != null) {
            return fragmentWrapper.getActivity();
        }
        return null;
    }

    public final CallbackManager getCallbackManager$facebook_common_release() {
        return this.callbackManager;
    }

    protected abstract List<FacebookDialogBase<CONTENT, RESULT>.ModeHandler> getOrderedModeHandlers();

    public final int getRequestCode() {
        return this.requestCodeField;
    }

    @Override // com.facebook.FacebookDialog
    public void registerCallback(CallbackManager callbackManager, FacebookCallback<RESULT> callback) {
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!(callbackManager instanceof CallbackManagerImpl)) {
            throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
        }
        memorizeCallbackManager(callbackManager);
        registerCallbackImpl((CallbackManagerImpl) callbackManager, callback);
    }

    protected abstract void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, FacebookCallback<RESULT> facebookCallback);

    public final void setCallbackManager(CallbackManager callbackManager) {
        this.callbackManager = callbackManager;
    }

    public final void setCallbackManager$facebook_common_release(CallbackManager callbackManager) {
        this.callbackManager = callbackManager;
    }

    public final void setRequestCode(int i3) {
        if (!FacebookSdk.isFacebookRequestCode(i3)) {
            this.requestCodeField = i3;
            return;
        }
        throw new IllegalArgumentException(("Request code " + i3 + " cannot be within the range reserved by the Facebook SDK.").toString());
    }

    @Override // com.facebook.FacebookDialog
    public void show(CONTENT content) {
        showImpl(content, BASE_AUTOMATIC_MODE);
    }

    protected void showImpl(CONTENT content, Object mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        AppCall appCallCreateAppCallForMode = createAppCallForMode(content, mode);
        if (appCallCreateAppCallForMode == null) {
            Log.e(TAG, "No code path should ever result in a null appCall");
            if (FacebookSdk.isDebugEnabled()) {
                throw new IllegalStateException("No code path should ever result in a null appCall");
            }
            return;
        }
        if (getActivityContext() instanceof ActivityResultRegistryOwner) {
            ComponentCallbacks2 activityContext = getActivityContext();
            Intrinsics.checkNotNull(activityContext, "null cannot be cast to non-null type androidx.activity.result.ActivityResultRegistryOwner");
            ActivityResultRegistry activityResultRegistry = ((ActivityResultRegistryOwner) activityContext).getActivityResultRegistry();
            Intrinsics.checkNotNullExpressionValue(activityResultRegistry, "registryOwner.activityResultRegistry");
            DialogPresenter.present(appCallCreateAppCallForMode, activityResultRegistry, this.callbackManager);
            appCallCreateAppCallForMode.setPending();
            return;
        }
        FragmentWrapper fragmentWrapper = this.fragmentWrapper;
        if (fragmentWrapper != null) {
            DialogPresenter.present(appCallCreateAppCallForMode, fragmentWrapper);
            return;
        }
        Activity activity = this.activity;
        if (activity != null) {
            DialogPresenter.present(appCallCreateAppCallForMode, activity);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void startActivityForResult(android.content.Intent r4, int r5) {
        /*
            r3 = this;
            java.lang.String r0 = "intent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.app.Activity r0 = r3.getActivityContext()
            boolean r1 = r0 instanceof androidx.activity.result.ActivityResultRegistryOwner
            if (r1 == 0) goto L1e
            androidx.activity.result.ActivityResultRegistryOwner r0 = (androidx.activity.result.ActivityResultRegistryOwner) r0
            androidx.activity.result.ActivityResultRegistry r0 = r0.getActivityResultRegistry()
            java.lang.String r1 = "activity as ActivityResu…r).activityResultRegistry"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.facebook.CallbackManager r1 = r3.callbackManager
            com.facebook.internal.DialogPresenter.startActivityForResultWithAndroidX(r0, r1, r4, r5)
            goto L2b
        L1e:
            if (r0 == 0) goto L24
            r0.startActivityForResult(r4, r5)
            goto L2b
        L24:
            com.facebook.internal.FragmentWrapper r0 = r3.fragmentWrapper
            if (r0 == 0) goto L2d
            r0.startActivityForResult(r4, r5)
        L2b:
            r4 = 0
            goto L2f
        L2d:
            java.lang.String r4 = "Failed to find Activity or Fragment to startActivityForResult "
        L2f:
            if (r4 == 0) goto L46
            com.facebook.internal.Logger$Companion r5 = com.facebook.internal.Logger.Companion
            com.facebook.LoggingBehavior r0 = com.facebook.LoggingBehavior.DEVELOPER_ERRORS
            java.lang.Class r1 = r3.getClass()
            java.lang.String r1 = r1.getName()
            java.lang.String r2 = "this.javaClass.name"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r2 = 6
            r5.log(r0, r2, r1, r4)
        L46:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.FacebookDialogBase.startActivityForResult(android.content.Intent, int):void");
    }

    @Override // com.facebook.FacebookDialog
    public ActivityResultContract<CONTENT, CallbackManager.ActivityResultParameters> createActivityResultContractForShowingDialog(CallbackManager callbackManager) {
        return createActivityResultContractForShowingDialog(callbackManager, BASE_AUTOMATIC_MODE);
    }

    @Override // com.facebook.FacebookDialog
    public void registerCallback(CallbackManager callbackManager, FacebookCallback<RESULT> callback, int i3) {
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(callback, "callback");
        memorizeCallbackManager(callbackManager);
        setRequestCode(i3);
        registerCallback(callbackManager, callback);
    }

    protected FacebookDialogBase(FragmentWrapper fragmentWrapper, int i3) {
        Intrinsics.checkNotNullParameter(fragmentWrapper, "fragmentWrapper");
        this.fragmentWrapper = fragmentWrapper;
        this.activity = null;
        this.requestCodeField = i3;
        if (fragmentWrapper.getActivity() == null) {
            throw new IllegalArgumentException("Cannot use a fragment that is not attached to an activity");
        }
    }

    protected FacebookDialogBase(int i3) {
        this.requestCodeField = i3;
        this.activity = null;
        this.fragmentWrapper = null;
    }
}
