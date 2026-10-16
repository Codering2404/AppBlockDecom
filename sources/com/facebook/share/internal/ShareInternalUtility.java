package com.facebook.share.internal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Pair;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.share.Sharer;
import com.facebook.share.model.CameraEffectTextures;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class ShareInternalUtility {
    public static final ShareInternalUtility INSTANCE = new ShareInternalUtility();
    public static final String MY_STAGING_RESOURCES = "me/staging_resources";
    public static final String STAGING_PARAM = "file";

    private ShareInternalUtility() {
    }

    private final AppCall getAppCallFromActivityResult(int i3, int i4, Intent intent) {
        UUID callIdFromIntent = NativeProtocol.getCallIdFromIntent(intent);
        if (callIdFromIntent == null) {
            return null;
        }
        return AppCall.Companion.finishPendingCall(callIdFromIntent, i3);
    }

    private final NativeAppCallAttachmentStore.Attachment getAttachment(UUID uuid, ShareMedia<?, ?> shareMedia) {
        Uri localUrl;
        Bitmap bitmap;
        if (shareMedia instanceof SharePhoto) {
            SharePhoto sharePhoto = (SharePhoto) shareMedia;
            bitmap = sharePhoto.getBitmap();
            localUrl = sharePhoto.getImageUrl();
        } else if (shareMedia instanceof ShareVideo) {
            localUrl = ((ShareVideo) shareMedia).getLocalUrl();
            bitmap = null;
        } else {
            localUrl = null;
            bitmap = null;
        }
        return getAttachment(uuid, localUrl, bitmap);
    }

    @JvmStatic
    public static final Bundle getBackgroundAssetMediaInfo(ShareStoryContent shareStoryContent, UUID appCallId) {
        Intrinsics.checkNotNullParameter(appCallId, "appCallId");
        Bundle bundle = null;
        if (shareStoryContent != null && shareStoryContent.getBackgroundAsset() != null) {
            ShareMedia<?, ?> backgroundAsset = shareStoryContent.getBackgroundAsset();
            NativeAppCallAttachmentStore.Attachment attachment = INSTANCE.getAttachment(appCallId, backgroundAsset);
            if (attachment == null) {
                return null;
            }
            bundle = new Bundle();
            bundle.putString("type", backgroundAsset.getMediaType().name());
            bundle.putString(ShareConstants.MEDIA_URI, attachment.getAttachmentUrl());
            String uriExtension = getUriExtension(attachment.getOriginalUri());
            if (uriExtension != null) {
                Utility.putNonEmptyString(bundle, ShareConstants.MEDIA_EXTENSION, uriExtension);
            }
            NativeAppCallAttachmentStore.addAttachments(CollectionsKt.listOf(attachment));
        }
        return bundle;
    }

    @JvmStatic
    public static final Pair<String, String> getFieldNameAndNamespaceFromFullName(String fullName) {
        String strSubstring;
        String strSubstring2;
        int i3;
        Intrinsics.checkNotNullParameter(fullName, "fullName");
        int iM0 = StringsKt.m0(fullName, ':', 0, false, 6, null);
        if (iM0 == -1 || fullName.length() <= (i3 = iM0 + 1)) {
            strSubstring = null;
            strSubstring2 = fullName;
        } else {
            strSubstring = fullName.substring(0, iM0);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            strSubstring2 = fullName.substring(i3);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
        }
        return new Pair<>(strSubstring, strSubstring2);
    }

    @JvmStatic
    public static final List<Bundle> getMediaInfos(ShareMediaContent shareMediaContent, UUID appCallId) {
        List<ShareMedia<?, ?>> media;
        Bundle bundle;
        Intrinsics.checkNotNullParameter(appCallId, "appCallId");
        if (shareMediaContent == null || (media = shareMediaContent.getMedia()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (ShareMedia<?, ?> shareMedia : media) {
            NativeAppCallAttachmentStore.Attachment attachment = INSTANCE.getAttachment(appCallId, shareMedia);
            if (attachment == null) {
                bundle = null;
            } else {
                arrayList.add(attachment);
                bundle = new Bundle();
                bundle.putString("type", shareMedia.getMediaType().name());
                bundle.putString(ShareConstants.MEDIA_URI, attachment.getAttachmentUrl());
            }
            if (bundle != null) {
                arrayList2.add(bundle);
            }
        }
        NativeAppCallAttachmentStore.addAttachments(arrayList);
        return arrayList2;
    }

    @JvmStatic
    public static final String getNativeDialogCompletionGesture(Bundle result) {
        Intrinsics.checkNotNullParameter(result, "result");
        return result.containsKey(NativeProtocol.RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY) ? result.getString(NativeProtocol.RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY) : result.getString(NativeProtocol.EXTRA_DIALOG_COMPLETION_GESTURE_KEY);
    }

    @JvmStatic
    public static final List<String> getPhotoUrls(SharePhotoContent sharePhotoContent, UUID appCallId) {
        List<SharePhoto> photos;
        Intrinsics.checkNotNullParameter(appCallId, "appCallId");
        if (sharePhotoContent == null || (photos = sharePhotoContent.getPhotos()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = photos.iterator();
        while (it.hasNext()) {
            NativeAppCallAttachmentStore.Attachment attachment = INSTANCE.getAttachment(appCallId, (SharePhoto) it.next());
            if (attachment != null) {
                arrayList.add(attachment);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            arrayList2.add(((NativeAppCallAttachmentStore.Attachment) obj).getAttachmentUrl());
        }
        NativeAppCallAttachmentStore.addAttachments(arrayList);
        return arrayList2;
    }

    @JvmStatic
    public static final String getShareDialogPostId(Bundle result) {
        Intrinsics.checkNotNullParameter(result, "result");
        return result.containsKey(ShareConstants.RESULT_POST_ID) ? result.getString(ShareConstants.RESULT_POST_ID) : result.containsKey(ShareConstants.EXTRA_RESULT_POST_ID) ? result.getString(ShareConstants.EXTRA_RESULT_POST_ID) : result.getString(ShareConstants.WEB_DIALOG_RESULT_PARAM_POST_ID);
    }

    @JvmStatic
    public static final ResultProcessor getShareResultProcessor(FacebookCallback<Sharer.Result> facebookCallback) {
        return new ResultProcessor(facebookCallback) { // from class: com.facebook.share.internal.ShareInternalUtility.getShareResultProcessor.1
            final /* synthetic */ FacebookCallback<Sharer.Result> $callback;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(facebookCallback);
                this.$callback = facebookCallback;
            }

            @Override // com.facebook.share.internal.ResultProcessor
            public void onCancel(AppCall appCall) {
                Intrinsics.checkNotNullParameter(appCall, "appCall");
                ShareInternalUtility.invokeOnCancelCallback(this.$callback);
            }

            @Override // com.facebook.share.internal.ResultProcessor
            public void onError(AppCall appCall, FacebookException error) {
                Intrinsics.checkNotNullParameter(appCall, "appCall");
                Intrinsics.checkNotNullParameter(error, "error");
                ShareInternalUtility.invokeOnErrorCallback(this.$callback, error);
            }

            @Override // com.facebook.share.internal.ResultProcessor
            public void onSuccess(AppCall appCall, Bundle bundle) {
                Intrinsics.checkNotNullParameter(appCall, "appCall");
                if (bundle != null) {
                    String nativeDialogCompletionGesture = ShareInternalUtility.getNativeDialogCompletionGesture(bundle);
                    if (nativeDialogCompletionGesture == null || StringsKt.F("post", nativeDialogCompletionGesture, true)) {
                        ShareInternalUtility.invokeOnSuccessCallback(this.$callback, ShareInternalUtility.getShareDialogPostId(bundle));
                    } else if (StringsKt.F("cancel", nativeDialogCompletionGesture, true)) {
                        ShareInternalUtility.invokeOnCancelCallback(this.$callback);
                    } else {
                        ShareInternalUtility.invokeOnErrorCallback(this.$callback, new FacebookException(NativeProtocol.ERROR_UNKNOWN_ERROR));
                    }
                }
            }
        };
    }

    @JvmStatic
    public static final Bundle getStickerUrl(ShareStoryContent shareStoryContent, UUID appCallId) {
        Intrinsics.checkNotNullParameter(appCallId, "appCallId");
        if (shareStoryContent == null || shareStoryContent.getStickerAsset() == null) {
            return null;
        }
        new ArrayList().add(shareStoryContent.getStickerAsset());
        NativeAppCallAttachmentStore.Attachment attachment = INSTANCE.getAttachment(appCallId, shareStoryContent.getStickerAsset());
        if (attachment == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString(ShareConstants.MEDIA_URI, attachment.getAttachmentUrl());
        String uriExtension = getUriExtension(attachment.getOriginalUri());
        if (uriExtension != null) {
            Utility.putNonEmptyString(bundle, ShareConstants.MEDIA_EXTENSION, uriExtension);
        }
        NativeAppCallAttachmentStore.addAttachments(CollectionsKt.listOf(attachment));
        return bundle;
    }

    @JvmStatic
    public static final Bundle getTextureUrlBundle(ShareCameraEffectContent shareCameraEffectContent, UUID appCallId) {
        CameraEffectTextures textures;
        Intrinsics.checkNotNullParameter(appCallId, "appCallId");
        if (shareCameraEffectContent == null || (textures = shareCameraEffectContent.getTextures()) == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        for (String str : textures.keySet()) {
            NativeAppCallAttachmentStore.Attachment attachment = INSTANCE.getAttachment(appCallId, textures.getTextureUri(str), textures.getTextureBitmap(str));
            if (attachment != null) {
                arrayList.add(attachment);
                bundle.putString(str, attachment.getAttachmentUrl());
            }
        }
        NativeAppCallAttachmentStore.addAttachments(arrayList);
        return bundle;
    }

    @JvmStatic
    public static final String getUriExtension(Uri uri) {
        if (uri == null) {
            return null;
        }
        String string = uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "uri.toString()");
        int iT0 = StringsKt.t0(string, '.', 0, false, 6, null);
        if (iT0 == -1) {
            return null;
        }
        String strSubstring = string.substring(iT0);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    @JvmStatic
    public static final String getVideoUrl(ShareVideoContent shareVideoContent, UUID appCallId) {
        ShareVideo video;
        Uri localUrl;
        Intrinsics.checkNotNullParameter(appCallId, "appCallId");
        if (shareVideoContent == null || (video = shareVideoContent.getVideo()) == null || (localUrl = video.getLocalUrl()) == null) {
            return null;
        }
        NativeAppCallAttachmentStore.Attachment attachmentCreateAttachment = NativeAppCallAttachmentStore.createAttachment(appCallId, localUrl);
        NativeAppCallAttachmentStore.addAttachments(CollectionsKt.listOf(attachmentCreateAttachment));
        return attachmentCreateAttachment.getAttachmentUrl();
    }

    @JvmStatic
    public static final boolean handleActivityResult(int i3, int i4, Intent intent, ResultProcessor resultProcessor) {
        AppCall appCallFromActivityResult = INSTANCE.getAppCallFromActivityResult(i3, i4, intent);
        if (appCallFromActivityResult == null) {
            return false;
        }
        NativeAppCallAttachmentStore.cleanupAttachmentsForCall(appCallFromActivityResult.getCallId());
        if (resultProcessor == null) {
            return true;
        }
        FacebookException exceptionFromErrorData = intent != null ? NativeProtocol.getExceptionFromErrorData(NativeProtocol.getErrorDataFromResultIntent(intent)) : null;
        if (exceptionFromErrorData == null) {
            resultProcessor.onSuccess(appCallFromActivityResult, intent != null ? NativeProtocol.getSuccessResultsFromIntent(intent) : null);
        } else if (exceptionFromErrorData instanceof FacebookOperationCanceledException) {
            resultProcessor.onCancel(appCallFromActivityResult);
        } else {
            resultProcessor.onError(appCallFromActivityResult, exceptionFromErrorData);
        }
        return true;
    }

    @JvmStatic
    public static final void invokeCallbackWithError(FacebookCallback<Sharer.Result> facebookCallback, String str) {
        invokeOnErrorCallback(facebookCallback, str);
    }

    @JvmStatic
    public static final void invokeCallbackWithException(FacebookCallback<Sharer.Result> facebookCallback, Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (exception instanceof FacebookException) {
            invokeOnErrorCallback(facebookCallback, (FacebookException) exception);
            return;
        }
        invokeCallbackWithError(facebookCallback, "Error preparing share content: " + exception.getLocalizedMessage());
    }

    @JvmStatic
    public static final void invokeCallbackWithResults(FacebookCallback<Sharer.Result> facebookCallback, String str, GraphResponse graphResponse) {
        Intrinsics.checkNotNullParameter(graphResponse, "graphResponse");
        FacebookRequestError error = graphResponse.getError();
        if (error == null) {
            invokeOnSuccessCallback(facebookCallback, str);
            return;
        }
        String errorMessage = error.getErrorMessage();
        if (Utility.isNullOrEmpty(errorMessage)) {
            errorMessage = "Unexpected error sharing.";
        }
        invokeOnErrorCallback(facebookCallback, graphResponse, errorMessage);
    }

    @JvmStatic
    public static final void invokeOnCancelCallback(FacebookCallback<Sharer.Result> facebookCallback) {
        INSTANCE.logShareResult(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED, null);
        if (facebookCallback != null) {
            facebookCallback.onCancel();
        }
    }

    @JvmStatic
    public static final void invokeOnErrorCallback(FacebookCallback<Sharer.Result> facebookCallback, GraphResponse graphResponse, String str) {
        INSTANCE.logShareResult("error", str);
        if (facebookCallback != null) {
            facebookCallback.onError(new FacebookGraphResponseException(graphResponse, str));
        }
    }

    @JvmStatic
    public static final void invokeOnSuccessCallback(FacebookCallback<Sharer.Result> facebookCallback, String str) {
        INSTANCE.logShareResult(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED, null);
        if (facebookCallback != null) {
            facebookCallback.onSuccess(new Sharer.Result(str));
        }
    }

    private final void logShareResult(String str, String str2) {
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(FacebookSdk.getApplicationContext());
        Bundle bundle = new Bundle();
        bundle.putString(AnalyticsEvents.PARAMETER_SHARE_OUTCOME, str);
        if (str2 != null) {
            bundle.putString("error_message", str2);
        }
        internalAppEventsLogger.logEventImplicitly(AnalyticsEvents.EVENT_SHARE_RESULT, bundle);
    }

    @JvmStatic
    public static final GraphRequest newUploadStagingResourceWithImageRequest(AccessToken accessToken, Bitmap bitmap, GraphRequest.Callback callback) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("file", bitmap);
        return new GraphRequest(accessToken, MY_STAGING_RESOURCES, bundle, HttpMethod.POST, callback, null, 32, null);
    }

    @JvmStatic
    public static final void registerSharerCallback(final int i3, CallbackManager callbackManager, final FacebookCallback<Sharer.Result> facebookCallback) {
        if (!(callbackManager instanceof CallbackManagerImpl)) {
            throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
        }
        ((CallbackManagerImpl) callbackManager).registerCallback(i3, new CallbackManagerImpl.Callback() { // from class: com.facebook.share.internal.a
            @Override // com.facebook.internal.CallbackManagerImpl.Callback
            public final boolean onActivityResult(int i4, Intent intent) {
                return ShareInternalUtility.registerSharerCallback$lambda$1(i3, facebookCallback, i4, intent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean registerSharerCallback$lambda$1(int i3, FacebookCallback facebookCallback, int i4, Intent intent) {
        return handleActivityResult(i3, i4, intent, getShareResultProcessor(facebookCallback));
    }

    @JvmStatic
    public static final void registerStaticShareCallback(final int i3) {
        CallbackManagerImpl.Companion.registerStaticCallback(i3, new CallbackManagerImpl.Callback() { // from class: com.facebook.share.internal.b
            @Override // com.facebook.internal.CallbackManagerImpl.Callback
            public final boolean onActivityResult(int i4, Intent intent) {
                return ShareInternalUtility.registerStaticShareCallback$lambda$0(i3, i4, intent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean registerStaticShareCallback$lambda$0(int i3, int i4, Intent intent) {
        return handleActivityResult(i3, i4, intent, getShareResultProcessor(null));
    }

    @JvmStatic
    public static final JSONArray removeNamespacesFromOGJsonArray(JSONArray jsonArray, boolean z2) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
        JSONArray jSONArray = new JSONArray();
        int length = jsonArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            Object objRemoveNamespacesFromOGJsonObject = jsonArray.get(i3);
            if (objRemoveNamespacesFromOGJsonObject instanceof JSONArray) {
                objRemoveNamespacesFromOGJsonObject = removeNamespacesFromOGJsonArray((JSONArray) objRemoveNamespacesFromOGJsonObject, z2);
            } else if (objRemoveNamespacesFromOGJsonObject instanceof JSONObject) {
                objRemoveNamespacesFromOGJsonObject = removeNamespacesFromOGJsonObject((JSONObject) objRemoveNamespacesFromOGJsonObject, z2);
            }
            jSONArray.put(objRemoveNamespacesFromOGJsonObject);
        }
        return jSONArray;
    }

    @JvmStatic
    public static final JSONObject removeNamespacesFromOGJsonObject(JSONObject jSONObject, boolean z2) {
        if (jSONObject == null) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            JSONArray jSONArrayNames = jSONObject.names();
            if (jSONArrayNames == null) {
                return null;
            }
            int length = jSONArrayNames.length();
            for (int i3 = 0; i3 < length; i3++) {
                String key = jSONArrayNames.getString(i3);
                Object objRemoveNamespacesFromOGJsonArray = jSONObject.get(key);
                if (objRemoveNamespacesFromOGJsonArray instanceof JSONObject) {
                    objRemoveNamespacesFromOGJsonArray = removeNamespacesFromOGJsonObject((JSONObject) objRemoveNamespacesFromOGJsonArray, true);
                } else if (objRemoveNamespacesFromOGJsonArray instanceof JSONArray) {
                    objRemoveNamespacesFromOGJsonArray = removeNamespacesFromOGJsonArray((JSONArray) objRemoveNamespacesFromOGJsonArray, true);
                }
                Intrinsics.checkNotNullExpressionValue(key, "key");
                Pair<String, String> fieldNameAndNamespaceFromFullName = getFieldNameAndNamespaceFromFullName(key);
                String str = (String) fieldNameAndNamespaceFromFullName.first;
                String str2 = (String) fieldNameAndNamespaceFromFullName.second;
                if (z2) {
                    if (str != null && Intrinsics.areEqual(str, DeviceRequestsHelper.SDK_HEADER)) {
                        jSONObject2.put(key, objRemoveNamespacesFromOGJsonArray);
                    } else if (str == null || Intrinsics.areEqual(str, "og")) {
                        jSONObject2.put(str2, objRemoveNamespacesFromOGJsonArray);
                    } else {
                        jSONObject3.put(str2, objRemoveNamespacesFromOGJsonArray);
                    }
                } else if (str == null || !Intrinsics.areEqual(str, "fb")) {
                    jSONObject2.put(str2, objRemoveNamespacesFromOGJsonArray);
                } else {
                    jSONObject2.put(key, objRemoveNamespacesFromOGJsonArray);
                }
            }
            if (jSONObject3.length() > 0) {
                jSONObject2.put("data", jSONObject3);
            }
            return jSONObject2;
        } catch (JSONException unused) {
            throw new FacebookException("Failed to create json object from share content");
        }
    }

    @JvmStatic
    public static final void invokeOnErrorCallback(FacebookCallback<Sharer.Result> facebookCallback, String str) {
        INSTANCE.logShareResult("error", str);
        if (facebookCallback != null) {
            facebookCallback.onError(new FacebookException(str));
        }
    }

    @JvmStatic
    public static final GraphRequest newUploadStagingResourceWithImageRequest(AccessToken accessToken, File file, GraphRequest.Callback callback) throws FileNotFoundException {
        GraphRequest.ParcelableResourceWithMimeType parcelableResourceWithMimeType = new GraphRequest.ParcelableResourceWithMimeType(ParcelFileDescriptor.open(file, 268435456), "image/png");
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("file", parcelableResourceWithMimeType);
        return new GraphRequest(accessToken, MY_STAGING_RESOURCES, bundle, HttpMethod.POST, callback, null, 32, null);
    }

    @JvmStatic
    public static final void invokeOnErrorCallback(FacebookCallback<Sharer.Result> facebookCallback, FacebookException ex) {
        Intrinsics.checkNotNullParameter(ex, "ex");
        INSTANCE.logShareResult("error", ex.getMessage());
        if (facebookCallback != null) {
            facebookCallback.onError(ex);
        }
    }

    private final NativeAppCallAttachmentStore.Attachment getAttachment(UUID uuid, Uri uri, Bitmap bitmap) {
        if (bitmap != null) {
            return NativeAppCallAttachmentStore.createAttachment(uuid, bitmap);
        }
        if (uri != null) {
            return NativeAppCallAttachmentStore.createAttachment(uuid, uri);
        }
        return null;
    }

    @JvmStatic
    public static final GraphRequest newUploadStagingResourceWithImageRequest(AccessToken accessToken, Uri imageUri, GraphRequest.Callback callback) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(imageUri, "imageUri");
        String path = imageUri.getPath();
        if (Utility.isFileUri(imageUri) && path != null) {
            return newUploadStagingResourceWithImageRequest(accessToken, new File(path), callback);
        }
        if (Utility.isContentUri(imageUri)) {
            GraphRequest.ParcelableResourceWithMimeType parcelableResourceWithMimeType = new GraphRequest.ParcelableResourceWithMimeType(imageUri, "image/png");
            Bundle bundle = new Bundle(1);
            bundle.putParcelable("file", parcelableResourceWithMimeType);
            return new GraphRequest(accessToken, MY_STAGING_RESOURCES, bundle, HttpMethod.POST, callback, null, 32, null);
        }
        throw new FacebookException("The image Uri must be either a file:// or content:// Uri");
    }
}
