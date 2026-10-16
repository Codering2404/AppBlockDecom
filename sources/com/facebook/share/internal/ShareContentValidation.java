package com.facebook.share.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareMessengerActionButton;
import com.facebook.share.model.ShareMessengerURLActionButton;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import cz.mobilesoft.coreblock.scene.permission.permissions.success.lbR.YgVrd;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

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
public final class ShareContentValidation {
    public static final ShareContentValidation INSTANCE = new ShareContentValidation();
    private static final Validator webShareValidator = new WebShareValidator();
    private static final Validator defaultValidator = new Validator();
    private static final Validator apiValidator = new ApiValidator();
    private static final Validator storyValidator = new StoryShareValidator();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class ApiValidator extends Validator {
        @Override // com.facebook.share.internal.ShareContentValidation.Validator
        public void validate(SharePhoto photo) {
            Intrinsics.checkNotNullParameter(photo, "photo");
            ShareContentValidation.INSTANCE.validatePhotoForApi(photo, this);
        }

        @Override // com.facebook.share.internal.ShareContentValidation.Validator
        public void validate(ShareVideoContent videoContent) {
            Intrinsics.checkNotNullParameter(videoContent, "videoContent");
            if (!Utility.isNullOrEmpty(videoContent.getPlaceId())) {
                throw new FacebookException("Cannot share video content with place IDs using the share api");
            }
            if (!Utility.isNullOrEmpty(videoContent.getPeopleIds())) {
                throw new FacebookException("Cannot share video content with people IDs using the share api");
            }
            if (!Utility.isNullOrEmpty(videoContent.getRef())) {
                throw new FacebookException("Cannot share video content with referrer URL using the share api");
            }
        }

        @Override // com.facebook.share.internal.ShareContentValidation.Validator
        public void validate(ShareMediaContent mediaContent) {
            Intrinsics.checkNotNullParameter(mediaContent, "mediaContent");
            throw new FacebookException("Cannot share ShareMediaContent using the share api");
        }

        @Override // com.facebook.share.internal.ShareContentValidation.Validator
        public void validate(ShareLinkContent linkContent) {
            Intrinsics.checkNotNullParameter(linkContent, "linkContent");
            if (!Utility.isNullOrEmpty(linkContent.getQuote())) {
                throw new FacebookException("Cannot share link content with quote using the share api");
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class StoryShareValidator extends Validator {
        @Override // com.facebook.share.internal.ShareContentValidation.Validator
        public void validate(ShareStoryContent shareStoryContent) {
            ShareContentValidation.INSTANCE.validateStoryContent(shareStoryContent, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class Validator {
        public void validate(ShareLinkContent linkContent) {
            Intrinsics.checkNotNullParameter(linkContent, "linkContent");
            ShareContentValidation.INSTANCE.validateLinkContent(linkContent, this);
        }

        public void validate(SharePhotoContent photoContent) {
            Intrinsics.checkNotNullParameter(photoContent, "photoContent");
            ShareContentValidation.INSTANCE.validatePhotoContent(photoContent, this);
        }

        public void validate(ShareVideoContent videoContent) {
            Intrinsics.checkNotNullParameter(videoContent, "videoContent");
            ShareContentValidation.INSTANCE.validateVideoContent(videoContent, this);
        }

        public void validate(ShareMediaContent mediaContent) {
            Intrinsics.checkNotNullParameter(mediaContent, "mediaContent");
            ShareContentValidation.INSTANCE.validateMediaContent(mediaContent, this);
        }

        public void validate(ShareCameraEffectContent cameraEffectContent) {
            Intrinsics.checkNotNullParameter(cameraEffectContent, "cameraEffectContent");
            ShareContentValidation.INSTANCE.validateCameraEffectContent(cameraEffectContent);
        }

        public void validate(SharePhoto photo) {
            Intrinsics.checkNotNullParameter(photo, "photo");
            ShareContentValidation.INSTANCE.validatePhotoForNativeDialog(photo, this);
        }

        public void validate(ShareVideo shareVideo) {
            ShareContentValidation.INSTANCE.validateVideo(shareVideo, this);
        }

        public void validate(ShareMedia<?, ?> medium) {
            Intrinsics.checkNotNullParameter(medium, "medium");
            ShareContentValidation.validateMedium(medium, this);
        }

        public void validate(ShareStoryContent shareStoryContent) {
            ShareContentValidation.INSTANCE.validateStoryContent(shareStoryContent, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class WebShareValidator extends Validator {
        @Override // com.facebook.share.internal.ShareContentValidation.Validator
        public void validate(ShareVideoContent videoContent) {
            Intrinsics.checkNotNullParameter(videoContent, "videoContent");
            throw new FacebookException("Cannot share ShareVideoContent via web sharing dialogs");
        }

        @Override // com.facebook.share.internal.ShareContentValidation.Validator
        public void validate(ShareMediaContent mediaContent) {
            Intrinsics.checkNotNullParameter(mediaContent, "mediaContent");
            throw new FacebookException("Cannot share ShareMediaContent via web sharing dialogs");
        }

        @Override // com.facebook.share.internal.ShareContentValidation.Validator
        public void validate(SharePhoto photo) {
            Intrinsics.checkNotNullParameter(photo, "photo");
            ShareContentValidation.INSTANCE.validatePhotoForWebDialog(photo, this);
        }
    }

    private ShareContentValidation() {
    }

    private final void validate(ShareContent<?, ?> shareContent, Validator validator) throws FacebookException {
        if (shareContent == null) {
            throw new FacebookException("Must provide non-null content to share");
        }
        if (shareContent instanceof ShareLinkContent) {
            validator.validate((ShareLinkContent) shareContent);
            return;
        }
        if (shareContent instanceof SharePhotoContent) {
            validator.validate((SharePhotoContent) shareContent);
            return;
        }
        if (shareContent instanceof ShareVideoContent) {
            validator.validate((ShareVideoContent) shareContent);
            return;
        }
        if (shareContent instanceof ShareMediaContent) {
            validator.validate((ShareMediaContent) shareContent);
        } else if (shareContent instanceof ShareCameraEffectContent) {
            validator.validate((ShareCameraEffectContent) shareContent);
        } else if (shareContent instanceof ShareStoryContent) {
            validator.validate((ShareStoryContent) shareContent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validateCameraEffectContent(ShareCameraEffectContent shareCameraEffectContent) {
        if (Utility.isNullOrEmpty(shareCameraEffectContent.getEffectId())) {
            throw new FacebookException("Must specify a non-empty effectId");
        }
    }

    @JvmStatic
    public static final void validateForApiShare(ShareContent<?, ?> shareContent) {
        INSTANCE.validate(shareContent, apiValidator);
    }

    @JvmStatic
    public static final void validateForMessage(ShareContent<?, ?> shareContent) {
        INSTANCE.validate(shareContent, defaultValidator);
    }

    @JvmStatic
    public static final void validateForNativeShare(ShareContent<?, ?> shareContent) {
        INSTANCE.validate(shareContent, defaultValidator);
    }

    @JvmStatic
    public static final void validateForStoryShare(ShareContent<?, ?> shareContent) {
        INSTANCE.validate(shareContent, storyValidator);
    }

    @JvmStatic
    public static final void validateForWebShare(ShareContent<?, ?> shareContent) {
        INSTANCE.validate(shareContent, webShareValidator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validateLinkContent(ShareLinkContent shareLinkContent, Validator validator) {
        Uri contentUrl = shareLinkContent.getContentUrl();
        if (contentUrl != null && !Utility.isWebUri(contentUrl)) {
            throw new FacebookException("Content Url must be an http:// or https:// url");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validateMediaContent(ShareMediaContent shareMediaContent, Validator validator) {
        List<ShareMedia<?, ?>> media = shareMediaContent.getMedia();
        if (media == null || media.isEmpty()) {
            throw new FacebookException("Must specify at least one medium in ShareMediaContent.");
        }
        if (media.size() <= 6) {
            Iterator<ShareMedia<?, ?>> it = media.iterator();
            while (it.hasNext()) {
                validator.validate(it.next());
            }
        } else {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
            String str = String.format(Locale.ROOT, "Cannot add more than %d media.", Arrays.copyOf(new Object[]{6}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
            throw new FacebookException(str);
        }
    }

    @JvmStatic
    public static final void validateMedium(ShareMedia<?, ?> medium, Validator validator) {
        Intrinsics.checkNotNullParameter(medium, "medium");
        Intrinsics.checkNotNullParameter(validator, "validator");
        if (medium instanceof SharePhoto) {
            validator.validate((SharePhoto) medium);
        } else {
            if (medium instanceof ShareVideo) {
                validator.validate((ShareVideo) medium);
                return;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
            String str = String.format(Locale.ROOT, "Invalid media type: %s", Arrays.copyOf(new Object[]{medium.getClass().getSimpleName()}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
            throw new FacebookException(str);
        }
    }

    private final void validatePhoto(SharePhoto sharePhoto) {
        if (sharePhoto == null) {
            throw new FacebookException("Cannot share a null SharePhoto");
        }
        Bitmap bitmap = sharePhoto.getBitmap();
        Uri imageUrl = sharePhoto.getImageUrl();
        if (bitmap == null && imageUrl == null) {
            throw new FacebookException("SharePhoto does not have a Bitmap or ImageUrl specified");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validatePhotoContent(SharePhotoContent sharePhotoContent, Validator validator) {
        List<SharePhoto> photos = sharePhotoContent.getPhotos();
        if (photos == null || photos.isEmpty()) {
            throw new FacebookException("Must specify at least one Photo in SharePhotoContent.");
        }
        if (photos.size() <= 6) {
            Iterator<SharePhoto> it = photos.iterator();
            while (it.hasNext()) {
                validator.validate(it.next());
            }
        } else {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
            String str = String.format(Locale.ROOT, "Cannot add more than %d photos.", Arrays.copyOf(new Object[]{6}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
            throw new FacebookException(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validatePhotoForApi(SharePhoto sharePhoto, Validator validator) {
        validatePhoto(sharePhoto);
        Bitmap bitmap = sharePhoto.getBitmap();
        Uri imageUrl = sharePhoto.getImageUrl();
        if (bitmap == null && Utility.isWebUri(imageUrl)) {
            throw new FacebookException("Cannot set the ImageUrl of a SharePhoto to the Uri of an image on the web when sharing SharePhotoContent");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validatePhotoForNativeDialog(SharePhoto sharePhoto, Validator validator) {
        validatePhotoForApi(sharePhoto, validator);
        if (sharePhoto.getBitmap() == null && Utility.isWebUri(sharePhoto.getImageUrl())) {
            return;
        }
        Validate.hasContentProvider(FacebookSdk.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validatePhotoForWebDialog(SharePhoto sharePhoto, Validator validator) {
        validatePhoto(sharePhoto);
    }

    private final void validateShareMessengerActionButton(ShareMessengerActionButton shareMessengerActionButton) {
        if (shareMessengerActionButton == null) {
            return;
        }
        if (Utility.isNullOrEmpty(shareMessengerActionButton.getTitle())) {
            throw new FacebookException("Must specify title for ShareMessengerActionButton");
        }
        if (shareMessengerActionButton instanceof ShareMessengerURLActionButton) {
            validateShareMessengerURLActionButton((ShareMessengerURLActionButton) shareMessengerActionButton);
        }
    }

    private final void validateShareMessengerURLActionButton(ShareMessengerURLActionButton shareMessengerURLActionButton) {
        if (shareMessengerURLActionButton.getUrl() == null) {
            throw new FacebookException("Must specify url for ShareMessengerURLActionButton");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validateVideo(ShareVideo shareVideo, Validator validator) {
        if (shareVideo == null) {
            throw new FacebookException("Cannot share a null ShareVideo");
        }
        Uri localUrl = shareVideo.getLocalUrl();
        if (localUrl == null) {
            throw new FacebookException("ShareVideo does not have a LocalUrl specified");
        }
        if (!Utility.isContentUri(localUrl) && !Utility.isFileUri(localUrl)) {
            throw new FacebookException("ShareVideo must reference a video that is on the device");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validateVideoContent(ShareVideoContent shareVideoContent, Validator validator) {
        validator.validate(shareVideoContent.getVideo());
        SharePhoto previewPhoto = shareVideoContent.getPreviewPhoto();
        if (previewPhoto != null) {
            validator.validate(previewPhoto);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validateStoryContent(ShareStoryContent shareStoryContent, Validator validator) {
        if (shareStoryContent == null || (shareStoryContent.getBackgroundAsset() == null && shareStoryContent.getStickerAsset() == null)) {
            throw new FacebookException(YgVrd.yHPcmZniqnpPro);
        }
        if (shareStoryContent.getBackgroundAsset() != null) {
            validator.validate(shareStoryContent.getBackgroundAsset());
        }
        if (shareStoryContent.getStickerAsset() != null) {
            validator.validate(shareStoryContent.getStickerAsset());
        }
    }
}
