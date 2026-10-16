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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;
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
public final class TournamentFetcher {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchTournaments$lambda$1(TaskCompletionSource task, GraphResponse response) {
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
        try {
            JSONObject jSONObject = response.getJSONObject();
            if (jSONObject == null) {
                task.setError(new GraphAPIException("Failed to get response"));
                return;
            }
            JSONArray jSONArray = jSONObject.getJSONArray("data");
            if (jSONArray.length() < 1) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
                String str = String.format(Locale.ROOT, "No tournament found", Arrays.copyOf(new Object[]{Integer.valueOf(jSONArray.length()), 1}, 2));
                Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
                task.setError(new GraphAPIException(str));
                return;
            }
            Gson gsonB = new GsonBuilder().b();
            String string = jSONArray.toString();
            Intrinsics.checkNotNullExpressionValue(string, "data.toString()");
            Object objJ = gsonB.j(string, Tournament[].class);
            Intrinsics.checkNotNullExpressionValue(objJ, "gson.fromJson(dataString…<Tournament>::class.java)");
            task.setResult(ArraysKt.toList((Object[]) objJ));
        } catch (JSONException e3) {
            task.setError(e3);
        }
    }

    public final TaskCompletionSource<List<Tournament>> fetchTournaments() {
        final TaskCompletionSource<List<Tournament>> taskCompletionSource = new TaskCompletionSource<>();
        Bundle bundle = new Bundle();
        AccessToken.Companion companion = AccessToken.Companion;
        AccessToken currentAccessToken = companion.getCurrentAccessToken();
        if (currentAccessToken == null || currentAccessToken.isExpired()) {
            throw new FacebookException("Attempted to fetch tournament with an invalid access token");
        }
        if (currentAccessToken.getGraphDomain() == null || !Intrinsics.areEqual(FacebookSdk.GAMING, currentAccessToken.getGraphDomain())) {
            throw new FacebookException("User is not using gaming login");
        }
        GraphRequest graphRequest = new GraphRequest(companion.getCurrentAccessToken(), "me/tournaments", bundle, HttpMethod.GET, new GraphRequest.Callback() { // from class: com.facebook.gamingservices.g
            @Override // com.facebook.GraphRequest.Callback
            public final void onCompleted(GraphResponse graphResponse) {
                TournamentFetcher.fetchTournaments$lambda$1(taskCompletionSource, graphResponse);
            }
        }, null, 32, null);
        graphRequest.setParameters(bundle);
        graphRequest.executeAsync();
        return taskCompletionSource;
    }
}
