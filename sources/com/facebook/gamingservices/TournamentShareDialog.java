package com.facebook.gamingservices;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.gamingservices.TournamentShareDialog;
import com.facebook.gamingservices.cloudgaming.CloudGameLoginHandler;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.internal.TournamentShareDialogURIBuilder;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;
import java.util.ArrayList;
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
public final class TournamentShareDialog extends FacebookDialogBase<TournamentConfig, Result> {
    public static final Companion Companion = new Companion(null);
    private static final int defaultRequestCode = CallbackManagerImpl.RequestCodeOffset.TournamentShareDialog.toRequestCode();
    private Number score;
    private Tournament tournament;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class AppSwitchHandler extends FacebookDialogBase<TournamentConfig, Result>.ModeHandler {
        public AppSwitchHandler() {
            super();
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public boolean canShow(TournamentConfig tournamentConfig, boolean z2) {
            return true;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public AppCall createAppCall(TournamentConfig tournamentConfig) {
            Uri uriUriForUpdating$facebook_gamingservices_release;
            AppCall appCallCreateBaseAppCall = TournamentShareDialog.this.createBaseAppCall();
            AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
            if (currentAccessToken == null || currentAccessToken.isExpired()) {
                throw new FacebookException("Attempted to share tournament with an invalid access token");
            }
            if (currentAccessToken.getGraphDomain() != null && !Intrinsics.areEqual(FacebookSdk.GAMING, currentAccessToken.getGraphDomain())) {
                throw new FacebookException("Attempted to share tournament without without gaming login");
            }
            Number score = TournamentShareDialog.this.getScore();
            if (score == null) {
                throw new FacebookException("Attempted to share tournament without a score");
            }
            if (tournamentConfig != null) {
                uriUriForUpdating$facebook_gamingservices_release = TournamentShareDialogURIBuilder.INSTANCE.uriForCreating$facebook_gamingservices_release(tournamentConfig, score, currentAccessToken.getApplicationId());
            } else {
                Tournament tournament = TournamentShareDialog.this.getTournament();
                uriUriForUpdating$facebook_gamingservices_release = tournament != null ? TournamentShareDialogURIBuilder.INSTANCE.uriForUpdating$facebook_gamingservices_release(tournament.identifier, score, currentAccessToken.getApplicationId()) : null;
            }
            Intent intent = new Intent("android.intent.action.VIEW", uriUriForUpdating$facebook_gamingservices_release);
            TournamentShareDialog tournamentShareDialog = TournamentShareDialog.this;
            tournamentShareDialog.startActivityForResult(intent, tournamentShareDialog.getRequestCode());
            return appCallCreateBaseAppCall;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class FacebookAppHandler extends FacebookDialogBase<TournamentConfig, Result>.ModeHandler {
        public FacebookAppHandler() {
            super();
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public boolean canShow(TournamentConfig tournamentConfig, boolean z2) {
            PackageManager packageManager = FacebookSdk.getApplicationContext().getPackageManager();
            Intrinsics.checkNotNullExpressionValue(packageManager, "getApplicationContext().packageManager");
            Intent intent = new Intent("com.facebook.games.gaming_services.DEEPLINK");
            intent.setType("text/plain");
            return intent.resolveActivity(packageManager) != null;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public AppCall createAppCall(TournamentConfig tournamentConfig) {
            Bundle bundleBundleForUpdating$facebook_gamingservices_release;
            AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
            AppCall appCallCreateBaseAppCall = TournamentShareDialog.this.createBaseAppCall();
            Intent intent = new Intent("com.facebook.games.gaming_services.DEEPLINK");
            intent.setType("text/plain");
            if (currentAccessToken == null || currentAccessToken.isExpired()) {
                throw new FacebookException("Attempted to share tournament with an invalid access token");
            }
            if (currentAccessToken.getGraphDomain() != null && !Intrinsics.areEqual(FacebookSdk.GAMING, currentAccessToken.getGraphDomain())) {
                throw new FacebookException("Attempted to share tournament while user is not gaming logged in");
            }
            String applicationId = currentAccessToken.getApplicationId();
            Number score = TournamentShareDialog.this.getScore();
            if (score == null) {
                throw new FacebookException("Attempted to share tournament without a score");
            }
            if (tournamentConfig != null) {
                bundleBundleForUpdating$facebook_gamingservices_release = TournamentShareDialogURIBuilder.INSTANCE.bundleForCreating$facebook_gamingservices_release(tournamentConfig, score, applicationId);
            } else {
                Tournament tournament = TournamentShareDialog.this.getTournament();
                bundleBundleForUpdating$facebook_gamingservices_release = tournament != null ? TournamentShareDialogURIBuilder.INSTANCE.bundleForUpdating$facebook_gamingservices_release(tournament.identifier, score, applicationId) : null;
            }
            NativeProtocol.setupProtocolRequestIntent(intent, appCallCreateBaseAppCall.getCallId().toString(), "", NativeProtocol.PROTOCOL_VERSION_20210906, bundleBundleForUpdating$facebook_gamingservices_release);
            appCallCreateBaseAppCall.setRequestIntent(intent);
            return appCallCreateBaseAppCall;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Result {
        private String requestID;
        private String tournamentID;

        public Result(Bundle results) {
            Intrinsics.checkNotNullParameter(results, "results");
            if (results.getString("request") != null) {
                this.requestID = results.getString("request");
            }
            this.tournamentID = results.getString(SDKConstants.PARAM_TOURNAMENTS_ID);
        }

        public final String getRequestID() {
            return this.requestID;
        }

        public final String getTournamentID() {
            return this.tournamentID;
        }

        public final void setRequestID(String str) {
            this.requestID = str;
        }

        public final void setTournamentID(String str) {
            this.tournamentID = str;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TournamentShareDialog(Activity activity) {
        super(activity, defaultRequestCode);
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean registerCallbackImpl$lambda$0(TournamentShareDialog this$0, ResultProcessor resultProcessor, int i3, Intent intent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return ShareInternalUtility.handleActivityResult(this$0.getRequestCode(), i3, intent, resultProcessor);
    }

    @Override // com.facebook.internal.FacebookDialogBase
    protected AppCall createBaseAppCall() {
        return new AppCall(getRequestCode(), null, 2, null);
    }

    @Override // com.facebook.internal.FacebookDialogBase
    protected List<FacebookDialogBase<TournamentConfig, Result>.ModeHandler> getOrderedModeHandlers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FacebookAppHandler());
        arrayList.add(new AppSwitchHandler());
        return arrayList;
    }

    public final Number getScore() {
        return this.score;
    }

    public final Tournament getTournament() {
        return this.tournament;
    }

    @Override // com.facebook.internal.FacebookDialogBase
    protected void registerCallbackImpl(CallbackManagerImpl callbackManager, final FacebookCallback<Result> callback) {
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final ResultProcessor resultProcessor = new ResultProcessor(callback) { // from class: com.facebook.gamingservices.TournamentShareDialog$registerCallbackImpl$resultProcessor$1
            final /* synthetic */ FacebookCallback<TournamentShareDialog.Result> $callback;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(callback);
                this.$callback = callback;
            }

            @Override // com.facebook.share.internal.ResultProcessor
            public void onSuccess(AppCall appCall, Bundle bundle) {
                Intrinsics.checkNotNullParameter(appCall, "appCall");
                if (bundle != null) {
                    if (bundle.getString("error_message") != null) {
                        this.$callback.onError(new FacebookException(bundle.getString("error_message")));
                        return;
                    } else if (bundle.getString(SDKConstants.PARAM_TOURNAMENTS_ID) != null) {
                        this.$callback.onSuccess(new TournamentShareDialog.Result(bundle));
                        return;
                    }
                }
                onCancel(appCall);
            }
        };
        callbackManager.registerCallback(getRequestCode(), new CallbackManagerImpl.Callback() { // from class: com.facebook.gamingservices.i
            @Override // com.facebook.internal.CallbackManagerImpl.Callback
            public final boolean onActivityResult(int i3, Intent intent) {
                return TournamentShareDialog.registerCallbackImpl$lambda$0(this.f68144a, resultProcessor, i3, intent);
            }
        });
    }

    public final void setScore(Number number) {
        this.score = number;
    }

    public final void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public final void show(Number score, TournamentConfig newTournamentConfig) {
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(newTournamentConfig, "newTournamentConfig");
        this.score = score;
        showImpl(newTournamentConfig, FacebookDialogBase.BASE_AUTOMATIC_MODE);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TournamentShareDialog(Fragment fragment) {
        this(new FragmentWrapper(fragment));
        Intrinsics.checkNotNullParameter(fragment, "fragment");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.internal.FacebookDialogBase
    public void showImpl(TournamentConfig tournamentConfig, Object mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        if (CloudGameLoginHandler.isRunningInCloud()) {
            return;
        }
        super.showImpl(tournamentConfig, mode);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TournamentShareDialog(android.app.Fragment fragment) {
        this(new FragmentWrapper(fragment));
        Intrinsics.checkNotNullParameter(fragment, "fragment");
    }

    public final void show(Number score, Tournament tournament) {
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(tournament, "tournament");
        this.score = score;
        this.tournament = tournament;
        showImpl((TournamentConfig) null, FacebookDialogBase.BASE_AUTOMATIC_MODE);
    }

    private TournamentShareDialog(FragmentWrapper fragmentWrapper) {
        super(fragmentWrapper, defaultRequestCode);
    }
}
