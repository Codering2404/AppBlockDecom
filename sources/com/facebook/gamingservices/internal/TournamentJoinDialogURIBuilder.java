package com.facebook.gamingservices.internal;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
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
public final class TournamentJoinDialogURIBuilder {
    public static final TournamentJoinDialogURIBuilder INSTANCE = new TournamentJoinDialogURIBuilder();

    private TournamentJoinDialogURIBuilder() {
    }

    private final Uri.Builder baseUriBuilder() {
        Uri.Builder builderAppendPath = new Uri.Builder().scheme("https").authority(FacebookSdk.getFacebookGamingDomain()).appendPath("dialog").appendPath("join_tournament");
        Intrinsics.checkNotNullExpressionValue(builderAppendPath, "Builder()\n              …ndPath(\"join_tournament\")");
        return builderAppendPath;
    }

    public static /* synthetic */ Bundle bundle$facebook_gamingservices_release$default(TournamentJoinDialogURIBuilder tournamentJoinDialogURIBuilder, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = null;
        }
        if ((i3 & 4) != 0) {
            str3 = null;
        }
        return tournamentJoinDialogURIBuilder.bundle$facebook_gamingservices_release(str, str2, str3);
    }

    public static /* synthetic */ Uri uri$facebook_gamingservices_release$default(TournamentJoinDialogURIBuilder tournamentJoinDialogURIBuilder, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        if ((i3 & 2) != 0) {
            str2 = null;
        }
        return tournamentJoinDialogURIBuilder.uri$facebook_gamingservices_release(str, str2);
    }

    public final Bundle bundle$facebook_gamingservices_release(String appID, String str, String str2) {
        Intrinsics.checkNotNullParameter(appID, "appID");
        Bundle bundle = new Bundle();
        bundle.putString(SDKConstants.PARAM_TOURNAMENTS_DEEPLINK, SDKConstants.PARAM_TOURNAMENTS);
        bundle.putString("app_id", appID);
        if (str != null) {
            bundle.putString(SDKConstants.PARAM_TOURNAMENTS_ID, str);
        }
        if (str2 != null) {
            bundle.putString("payload", str2);
        }
        return bundle;
    }

    public final Uri uri$facebook_gamingservices_release(String str, String str2) {
        Uri.Builder builderBaseUriBuilder = baseUriBuilder();
        if (str != null) {
            builderBaseUriBuilder.appendQueryParameter(SDKConstants.PARAM_TOURNAMENTS_ID, str);
        }
        if (str2 != null) {
            builderBaseUriBuilder.appendQueryParameter("payload", str2);
        }
        Uri uriBuild = builderBaseUriBuilder.build();
        Intrinsics.checkNotNullExpressionValue(uriBuild, "builder.build()");
        return uriBuild;
    }
}
