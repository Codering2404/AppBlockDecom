package com.facebook.gamingservices.internal;

import android.net.Uri;
import android.os.Bundle;
import androidx.media3.exoplayer.audio.wRw.CbYNFSEGaQj;
import com.facebook.gamingservices.TournamentConfig;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.time.Instant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class TournamentShareDialogURIBuilder {
    public static final TournamentShareDialogURIBuilder INSTANCE = new TournamentShareDialogURIBuilder();
    public static final String authority = "fb.gg";
    public static final String me = "me";
    public static final String scheme = "https";
    public static final String tournament = "instant_tournament";

    private TournamentShareDialogURIBuilder() {
    }

    public final Bundle bundleForCreating$facebook_gamingservices_release(TournamentConfig config, Number score, String appID) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(appID, "appID");
        Bundle bundle = new Bundle();
        bundle.putString(SDKConstants.PARAM_TOURNAMENTS_DEEPLINK, SDKConstants.PARAM_TOURNAMENTS);
        bundle.putString("app_id", appID);
        bundle.putString("score", score.toString());
        TournamentSortOrder sortOrder = config.getSortOrder();
        if (sortOrder != null) {
            bundle.putString(SDKConstants.PARAM_TOURNAMENTS_SORT_ORDER, sortOrder.toString());
        }
        TournamentScoreType scoreType = config.getScoreType();
        if (scoreType != null) {
            bundle.putString(SDKConstants.PARAM_TOURNAMENTS_SCORE_FORMAT, scoreType.toString());
        }
        String title = config.getTitle();
        if (title != null) {
            bundle.putString(SDKConstants.PARAM_TOURNAMENTS_TITLE, title.toString());
        }
        String payload = config.getPayload();
        if (payload != null) {
            bundle.putString(SDKConstants.PARAM_TOURNAMENTS_PAYLOAD, payload.toString());
        }
        Instant endTime = config.getEndTime();
        if (endTime != null) {
            bundle.putString(SDKConstants.PARAM_TOURNAMENTS_END_TIME, String.valueOf((int) endTime.getEpochSecond()));
        }
        return bundle;
    }

    public final Uri uriForCreating$facebook_gamingservices_release(TournamentConfig config, Number score, String appID) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(appID, "appID");
        Uri.Builder builderAppendQueryParameter = new Uri.Builder().scheme("https").authority("fb.gg").appendPath("me").appendPath(tournament).appendPath(appID).appendQueryParameter("score", score.toString());
        Instant endTime = config.getEndTime();
        if (endTime != null) {
            builderAppendQueryParameter.appendQueryParameter(SDKConstants.PARAM_TOURNAMENTS_END_TIME, endTime.toString());
        }
        TournamentSortOrder sortOrder = config.getSortOrder();
        if (sortOrder != null) {
            builderAppendQueryParameter.appendQueryParameter(SDKConstants.PARAM_TOURNAMENTS_SORT_ORDER, sortOrder.toString());
        }
        TournamentScoreType scoreType = config.getScoreType();
        if (scoreType != null) {
            builderAppendQueryParameter.appendQueryParameter(SDKConstants.PARAM_TOURNAMENTS_SCORE_FORMAT, scoreType.toString());
        }
        String title = config.getTitle();
        if (title != null) {
            builderAppendQueryParameter.appendQueryParameter(SDKConstants.PARAM_TOURNAMENTS_TITLE, title);
        }
        String payload = config.getPayload();
        if (payload != null) {
            builderAppendQueryParameter.appendQueryParameter(SDKConstants.PARAM_TOURNAMENTS_PAYLOAD, payload);
        }
        Uri uriBuild = builderAppendQueryParameter.build();
        Intrinsics.checkNotNullExpressionValue(uriBuild, "builder.build()");
        return uriBuild;
    }

    public final Uri uriForUpdating$facebook_gamingservices_release(String tournamentID, Number score, String appID) {
        Intrinsics.checkNotNullParameter(tournamentID, "tournamentID");
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(appID, "appID");
        Uri uriBuild = new Uri.Builder().scheme("https").authority("fb.gg").appendPath("me").appendPath(tournament).appendPath(appID).appendQueryParameter(SDKConstants.PARAM_TOURNAMENTS_ID, tournamentID).appendQueryParameter("score", score.toString()).build();
        Intrinsics.checkNotNullExpressionValue(uriBuild, "Builder()\n        .schem…tring())\n        .build()");
        return uriBuild;
    }

    public final Bundle bundleForUpdating$facebook_gamingservices_release(String tournamentID, Number score, String appID) {
        Intrinsics.checkNotNullParameter(tournamentID, "tournamentID");
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(appID, "appID");
        Bundle bundle = new Bundle();
        bundle.putString(SDKConstants.PARAM_TOURNAMENTS_DEEPLINK, SDKConstants.PARAM_TOURNAMENTS);
        bundle.putString(CbYNFSEGaQj.WhWI, appID);
        bundle.putString("score", score.toString());
        bundle.putString(SDKConstants.PARAM_TOURNAMENTS_ID, tournamentID);
        return bundle;
    }
}
