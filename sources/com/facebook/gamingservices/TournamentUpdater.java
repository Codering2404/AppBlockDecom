package com.facebook.gamingservices;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.bolts.TaskCompletionSource;
import com.facebook.internal.ServerProtocol;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class TournamentUpdater {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void update$lambda$0(TaskCompletionSource task, GraphResponse response) {
        Intrinsics.checkNotNullParameter(task, "$task");
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.getError() != null) {
            FacebookRequestError error = response.getError();
            if ((error != null ? error.getException() : null) == null) {
                task.setError(new GraphAPIException("Graph API Error"));
                return;
            } else {
                FacebookRequestError error2 = response.getError();
                task.setError(error2 != null ? error2.getException() : null);
                return;
            }
        }
        JSONObject jSONObject = response.getJSONObject();
        String strOptString = jSONObject != null ? jSONObject.optString(GraphResponse.SUCCESS_KEY) : null;
        if (strOptString == null || strOptString.length() == 0) {
            task.setError(new GraphAPIException("Graph API Error"));
        } else {
            task.setResult(Boolean.valueOf(strOptString.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)));
        }
    }

    public final TaskCompletionSource<Boolean> update(Tournament tournament, Number score) {
        Intrinsics.checkNotNullParameter(tournament, "tournament");
        Intrinsics.checkNotNullParameter(score, "score");
        return update(tournament.identifier, score);
    }

    public final TaskCompletionSource<Boolean> update(String identifier, Number score) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(score, "score");
        AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
        if (currentAccessToken == null || currentAccessToken.isExpired()) {
            throw new FacebookException("Attempted to fetch tournament with an invalid access token");
        }
        if (currentAccessToken.getGraphDomain() == null || !Intrinsics.areEqual(FacebookSdk.GAMING, currentAccessToken.getGraphDomain())) {
            throw new FacebookException("User is not using gaming login");
        }
        final TaskCompletionSource<Boolean> taskCompletionSource = new TaskCompletionSource<>();
        Bundle bundle = new Bundle();
        bundle.putInt("score", score.intValue());
        new GraphRequest(currentAccessToken, identifier + "/update_score", bundle, HttpMethod.POST, new GraphRequest.Callback() { // from class: com.facebook.gamingservices.j
            @Override // com.facebook.GraphRequest.Callback
            public final void onCompleted(GraphResponse graphResponse) {
                TournamentUpdater.update$lambda$0(taskCompletionSource, graphResponse);
            }
        }, null, 32, null).executeAsync();
        return taskCompletionSource;
    }
}
