package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
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
public final class NativeDialogParameters {
    public static final NativeDialogParameters INSTANCE = new NativeDialogParameters();

    private NativeDialogParameters() {
    }

    @JvmStatic
    public static final Bundle create(UUID callId, ShareContent<?, ?> shareContent, boolean z2) {
        Intrinsics.checkNotNullParameter(callId, "callId");
        Intrinsics.checkNotNullParameter(shareContent, "shareContent");
        if (shareContent instanceof ShareLinkContent) {
            return INSTANCE.create((ShareLinkContent) shareContent, z2);
        }
        if (shareContent instanceof SharePhotoContent) {
            SharePhotoContent sharePhotoContent = (SharePhotoContent) shareContent;
            List<String> photoUrls = ShareInternalUtility.getPhotoUrls(sharePhotoContent, callId);
            if (photoUrls == null) {
                photoUrls = CollectionsKt.emptyList();
            }
            return INSTANCE.create(sharePhotoContent, photoUrls, z2);
        }
        if (shareContent instanceof ShareVideoContent) {
            ShareVideoContent shareVideoContent = (ShareVideoContent) shareContent;
            return INSTANCE.create(shareVideoContent, ShareInternalUtility.getVideoUrl(shareVideoContent, callId), z2);
        }
        if (shareContent instanceof ShareMediaContent) {
            ShareMediaContent shareMediaContent = (ShareMediaContent) shareContent;
            List<Bundle> mediaInfos = ShareInternalUtility.getMediaInfos(shareMediaContent, callId);
            if (mediaInfos == null) {
                mediaInfos = CollectionsKt.emptyList();
            }
            return INSTANCE.create(shareMediaContent, mediaInfos, z2);
        }
        if (shareContent instanceof ShareCameraEffectContent) {
            ShareCameraEffectContent shareCameraEffectContent = (ShareCameraEffectContent) shareContent;
            return INSTANCE.create(shareCameraEffectContent, ShareInternalUtility.getTextureUrlBundle(shareCameraEffectContent, callId), z2);
        }
        if (!(shareContent instanceof ShareStoryContent)) {
            return null;
        }
        ShareStoryContent shareStoryContent = (ShareStoryContent) shareContent;
        return INSTANCE.create(shareStoryContent, ShareInternalUtility.getBackgroundAssetMediaInfo(shareStoryContent, callId), ShareInternalUtility.getStickerUrl(shareStoryContent, callId), z2);
    }

    private final Bundle createBaseParameters(ShareContent<?, ?> shareContent, boolean z2) {
        Bundle bundle = new Bundle();
        Utility.putUri(bundle, ShareConstants.CONTENT_URL, shareContent.getContentUrl());
        Utility.putNonEmptyString(bundle, ShareConstants.PLACE_ID, shareContent.getPlaceId());
        Utility.putNonEmptyString(bundle, ShareConstants.PAGE_ID, shareContent.getPageId());
        Utility.putNonEmptyString(bundle, ShareConstants.REF, shareContent.getRef());
        Utility.putNonEmptyString(bundle, ShareConstants.REF, shareContent.getRef());
        bundle.putBoolean(ShareConstants.DATA_FAILURES_FATAL, z2);
        List<String> peopleIds = shareContent.getPeopleIds();
        if (peopleIds != null && !peopleIds.isEmpty()) {
            bundle.putStringArrayList(ShareConstants.PEOPLE_IDS, new ArrayList<>(peopleIds));
        }
        ShareHashtag shareHashtag = shareContent.getShareHashtag();
        Utility.putNonEmptyString(bundle, ShareConstants.HASHTAG, shareHashtag != null ? shareHashtag.getHashtag() : null);
        return bundle;
    }

    private final Bundle create(ShareCameraEffectContent shareCameraEffectContent, Bundle bundle, boolean z2) {
        Bundle bundleCreateBaseParameters = createBaseParameters(shareCameraEffectContent, z2);
        Utility.putNonEmptyString(bundleCreateBaseParameters, ShareConstants.EFFECT_ID, shareCameraEffectContent.getEffectId());
        if (bundle != null) {
            bundleCreateBaseParameters.putBundle(ShareConstants.EFFECT_TEXTURES, bundle);
        }
        try {
            JSONObject jSONObjectConvertToJSON = CameraEffectJSONUtility.convertToJSON(shareCameraEffectContent.getArguments());
            if (jSONObjectConvertToJSON == null) {
                return bundleCreateBaseParameters;
            }
            Utility.putNonEmptyString(bundleCreateBaseParameters, ShareConstants.EFFECT_ARGS, jSONObjectConvertToJSON.toString());
            return bundleCreateBaseParameters;
        } catch (JSONException e3) {
            throw new FacebookException("Unable to create a JSON Object from the provided CameraEffectArguments: " + e3.getMessage());
        }
    }

    private final Bundle create(ShareLinkContent shareLinkContent, boolean z2) {
        Bundle bundleCreateBaseParameters = createBaseParameters(shareLinkContent, z2);
        Utility.putNonEmptyString(bundleCreateBaseParameters, ShareConstants.QUOTE, shareLinkContent.getQuote());
        Utility.putUri(bundleCreateBaseParameters, ShareConstants.MESSENGER_URL, shareLinkContent.getContentUrl());
        Utility.putUri(bundleCreateBaseParameters, ShareConstants.TARGET_DISPLAY, shareLinkContent.getContentUrl());
        return bundleCreateBaseParameters;
    }

    private final Bundle create(SharePhotoContent sharePhotoContent, List<String> list, boolean z2) {
        Bundle bundleCreateBaseParameters = createBaseParameters(sharePhotoContent, z2);
        bundleCreateBaseParameters.putStringArrayList(ShareConstants.PHOTOS, new ArrayList<>(list));
        return bundleCreateBaseParameters;
    }

    private final Bundle create(ShareVideoContent shareVideoContent, String str, boolean z2) {
        Bundle bundleCreateBaseParameters = createBaseParameters(shareVideoContent, z2);
        Utility.putNonEmptyString(bundleCreateBaseParameters, ShareConstants.TITLE, shareVideoContent.getContentTitle());
        Utility.putNonEmptyString(bundleCreateBaseParameters, ShareConstants.DESCRIPTION, shareVideoContent.getContentDescription());
        Utility.putNonEmptyString(bundleCreateBaseParameters, ShareConstants.VIDEO_URL, str);
        return bundleCreateBaseParameters;
    }

    private final Bundle create(ShareMediaContent shareMediaContent, List<Bundle> list, boolean z2) {
        Bundle bundleCreateBaseParameters = createBaseParameters(shareMediaContent, z2);
        bundleCreateBaseParameters.putParcelableArrayList(ShareConstants.MEDIA, new ArrayList<>(list));
        return bundleCreateBaseParameters;
    }

    private final Bundle create(ShareStoryContent shareStoryContent, Bundle bundle, Bundle bundle2, boolean z2) {
        Bundle bundleCreateBaseParameters = createBaseParameters(shareStoryContent, z2);
        if (bundle != null) {
            bundleCreateBaseParameters.putParcelable(ShareConstants.STORY_BG_ASSET, bundle);
        }
        if (bundle2 != null) {
            bundleCreateBaseParameters.putParcelable(ShareConstants.STORY_INTERACTIVE_ASSET_URI, bundle2);
        }
        List<String> backgroundColorList = shareStoryContent.getBackgroundColorList();
        if (backgroundColorList != null && !backgroundColorList.isEmpty()) {
            bundleCreateBaseParameters.putStringArrayList(ShareConstants.STORY_INTERACTIVE_COLOR_LIST, new ArrayList<>(backgroundColorList));
        }
        Utility.putNonEmptyString(bundleCreateBaseParameters, ShareConstants.STORY_DEEP_LINK_URL, shareStoryContent.getAttributionLink());
        return bundleCreateBaseParameters;
    }
}
