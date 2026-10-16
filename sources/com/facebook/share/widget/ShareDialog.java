package com.facebook.share.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.DialogFeature;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.share.Sharer;
import com.facebook.share.internal.CameraEffectFeature;
import com.facebook.share.internal.LegacyNativeDialogParameters;
import com.facebook.share.internal.NativeDialogParameters;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.internal.ShareDialogFeature;
import com.facebook.share.internal.ShareFeedContent;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.internal.ShareStoryFeature;
import com.facebook.share.internal.WebDialogParameters;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
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
public class ShareDialog extends FacebookDialogBase<ShareContent<?, ?>, Sharer.Result> implements Sharer {
    private static final String FEED_DIALOG = "feed";
    private static final String WEB_OG_SHARE_DIALOG = "share_open_graph";
    public static final String WEB_SHARE_DIALOG = "share";
    private boolean isAutomaticMode;
    private final List<FacebookDialogBase<ShareContent<?, ?>, Sharer.Result>.ModeHandler> orderedModeHandlers;
    private boolean shouldFailOnDataError;
    public static final Companion Companion = new Companion(null);
    private static final String TAG = ShareDialog.class.getSimpleName();
    private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.Share.toRequestCode();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class CameraEffectHandler extends FacebookDialogBase<ShareContent<?, ?>, Sharer.Result>.ModeHandler {
        private Object mode;

        public CameraEffectHandler() {
            super();
            this.mode = Mode.NATIVE;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public Object getMode() {
            return this.mode;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public void setMode(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "<set-?>");
            this.mode = obj;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public boolean canShow(ShareContent<?, ?> content, boolean z2) {
            Intrinsics.checkNotNullParameter(content, "content");
            return (content instanceof ShareCameraEffectContent) && ShareDialog.Companion.canShowNative(content.getClass());
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public AppCall createAppCall(final ShareContent<?, ?> content) {
            Intrinsics.checkNotNullParameter(content, "content");
            ShareContentValidation.validateForNativeShare(content);
            final AppCall appCallCreateBaseAppCall = ShareDialog.this.createBaseAppCall();
            final boolean shouldFailOnDataError = ShareDialog.this.getShouldFailOnDataError();
            DialogFeature feature = ShareDialog.Companion.getFeature(content.getClass());
            if (feature == null) {
                return null;
            }
            DialogPresenter.setupAppCallForNativeDialog(appCallCreateBaseAppCall, new DialogPresenter.ParameterProvider() { // from class: com.facebook.share.widget.ShareDialog$CameraEffectHandler$createAppCall$1
                @Override // com.facebook.internal.DialogPresenter.ParameterProvider
                public Bundle getLegacyParameters() {
                    return LegacyNativeDialogParameters.create(appCallCreateBaseAppCall.getCallId(), content, shouldFailOnDataError);
                }

                @Override // com.facebook.internal.DialogPresenter.ParameterProvider
                public Bundle getParameters() {
                    return NativeDialogParameters.create(appCallCreateBaseAppCall.getCallId(), content, shouldFailOnDataError);
                }
            }, feature);
            return appCallCreateBaseAppCall;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean canShowNative(Class<? extends ShareContent<?, ?>> cls) {
            DialogFeature feature = getFeature(cls);
            return feature != null && DialogPresenter.canPresentNativeDialogWithFeature(feature);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public final boolean canShowWebCheck(ShareContent<?, ?> shareContent) {
            return canShowWebTypeCheck(shareContent.getClass());
        }

        private final boolean canShowWebTypeCheck(Class<? extends ShareContent<?, ?>> cls) {
            if (ShareLinkContent.class.isAssignableFrom(cls)) {
                return true;
            }
            return SharePhotoContent.class.isAssignableFrom(cls) && AccessToken.Companion.isCurrentAccessTokenActive();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DialogFeature getFeature(Class<? extends ShareContent<?, ?>> cls) {
            if (ShareLinkContent.class.isAssignableFrom(cls)) {
                return ShareDialogFeature.SHARE_DIALOG;
            }
            if (SharePhotoContent.class.isAssignableFrom(cls)) {
                return ShareDialogFeature.PHOTOS;
            }
            if (ShareVideoContent.class.isAssignableFrom(cls)) {
                return ShareDialogFeature.VIDEO;
            }
            if (ShareMediaContent.class.isAssignableFrom(cls)) {
                return ShareDialogFeature.MULTIMEDIA;
            }
            if (ShareCameraEffectContent.class.isAssignableFrom(cls)) {
                return CameraEffectFeature.SHARE_CAMERA_EFFECT;
            }
            if (ShareStoryContent.class.isAssignableFrom(cls)) {
                return ShareStoryFeature.SHARE_STORY_ASSET;
            }
            return null;
        }

        @JvmStatic
        public boolean canShow(Class<? extends ShareContent<?, ?>> contentType) {
            Intrinsics.checkNotNullParameter(contentType, "contentType");
            return canShowWebTypeCheck(contentType) || canShowNative(contentType);
        }

        @JvmStatic
        public void show(Activity activity, ShareContent<?, ?> shareContent) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(shareContent, "shareContent");
            new ShareDialog(activity).show(shareContent);
        }

        private Companion() {
        }

        @JvmStatic
        public void show(Fragment fragment, ShareContent<?, ?> shareContent) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(shareContent, "shareContent");
            show(new FragmentWrapper(fragment), shareContent);
        }

        @JvmStatic
        public void show(android.app.Fragment fragment, ShareContent<?, ?> shareContent) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(shareContent, "shareContent");
            show(new FragmentWrapper(fragment), shareContent);
        }

        private final void show(FragmentWrapper fragmentWrapper, ShareContent<?, ?> shareContent) {
            new ShareDialog(fragmentWrapper, 0, 2, null).show(shareContent);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class FeedHandler extends FacebookDialogBase<ShareContent<?, ?>, Sharer.Result>.ModeHandler {
        private Object mode;

        public FeedHandler() {
            super();
            this.mode = Mode.FEED;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public Object getMode() {
            return this.mode;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public void setMode(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "<set-?>");
            this.mode = obj;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public boolean canShow(ShareContent<?, ?> content, boolean z2) {
            Intrinsics.checkNotNullParameter(content, "content");
            return (content instanceof ShareLinkContent) || (content instanceof ShareFeedContent);
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public AppCall createAppCall(ShareContent<?, ?> content) {
            Bundle bundleCreateForFeed;
            Intrinsics.checkNotNullParameter(content, "content");
            ShareDialog shareDialog = ShareDialog.this;
            shareDialog.logDialogShare(shareDialog.getActivityContext(), content, Mode.FEED);
            AppCall appCallCreateBaseAppCall = ShareDialog.this.createBaseAppCall();
            if (content instanceof ShareLinkContent) {
                ShareContentValidation.validateForWebShare(content);
                bundleCreateForFeed = WebDialogParameters.createForFeed((ShareLinkContent) content);
            } else {
                if (!(content instanceof ShareFeedContent)) {
                    return null;
                }
                bundleCreateForFeed = WebDialogParameters.createForFeed((ShareFeedContent) content);
            }
            DialogPresenter.setupAppCallForWebDialog(appCallCreateBaseAppCall, ShareDialog.FEED_DIALOG, bundleCreateForFeed);
            return appCallCreateBaseAppCall;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public enum Mode {
        AUTOMATIC,
        NATIVE,
        WEB,
        FEED
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class NativeHandler extends FacebookDialogBase<ShareContent<?, ?>, Sharer.Result>.ModeHandler {
        private Object mode;

        public NativeHandler() {
            super();
            this.mode = Mode.NATIVE;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public Object getMode() {
            return this.mode;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public void setMode(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "<set-?>");
            this.mode = obj;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0041  */
        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean canShow(com.facebook.share.model.ShareContent<?, ?> r4, boolean r5) {
            /*
                r3 = this;
                java.lang.String r0 = "content"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                boolean r0 = r4 instanceof com.facebook.share.model.ShareCameraEffectContent
                r1 = 0
                if (r0 != 0) goto L51
                boolean r0 = r4 instanceof com.facebook.share.model.ShareStoryContent
                if (r0 == 0) goto Lf
                goto L51
            Lf:
                r0 = 1
                if (r5 != 0) goto L41
                com.facebook.share.model.ShareHashtag r5 = r4.getShareHashtag()
                if (r5 == 0) goto L1f
                com.facebook.share.internal.ShareDialogFeature r5 = com.facebook.share.internal.ShareDialogFeature.HASHTAG
                boolean r5 = com.facebook.internal.DialogPresenter.canPresentNativeDialogWithFeature(r5)
                goto L20
            L1f:
                r5 = r0
            L20:
                boolean r2 = r4 instanceof com.facebook.share.model.ShareLinkContent
                if (r2 == 0) goto L42
                r2 = r4
                com.facebook.share.model.ShareLinkContent r2 = (com.facebook.share.model.ShareLinkContent) r2
                java.lang.String r2 = r2.getQuote()
                if (r2 == 0) goto L42
                int r2 = r2.length()
                if (r2 != 0) goto L34
                goto L42
            L34:
                if (r5 == 0) goto L3f
                com.facebook.share.internal.ShareDialogFeature r5 = com.facebook.share.internal.ShareDialogFeature.LINK_SHARE_QUOTES
                boolean r5 = com.facebook.internal.DialogPresenter.canPresentNativeDialogWithFeature(r5)
                if (r5 == 0) goto L3f
                goto L41
            L3f:
                r5 = r1
                goto L42
            L41:
                r5 = r0
            L42:
                if (r5 == 0) goto L51
                com.facebook.share.widget.ShareDialog$Companion r5 = com.facebook.share.widget.ShareDialog.Companion
                java.lang.Class r4 = r4.getClass()
                boolean r4 = com.facebook.share.widget.ShareDialog.Companion.access$canShowNative(r5, r4)
                if (r4 == 0) goto L51
                return r0
            L51:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.widget.ShareDialog.NativeHandler.canShow(com.facebook.share.model.ShareContent, boolean):boolean");
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public AppCall createAppCall(final ShareContent<?, ?> content) {
            Intrinsics.checkNotNullParameter(content, "content");
            ShareDialog shareDialog = ShareDialog.this;
            shareDialog.logDialogShare(shareDialog.getActivityContext(), content, Mode.NATIVE);
            ShareContentValidation.validateForNativeShare(content);
            final AppCall appCallCreateBaseAppCall = ShareDialog.this.createBaseAppCall();
            final boolean shouldFailOnDataError = ShareDialog.this.getShouldFailOnDataError();
            DialogFeature feature = ShareDialog.Companion.getFeature(content.getClass());
            if (feature == null) {
                return null;
            }
            DialogPresenter.setupAppCallForNativeDialog(appCallCreateBaseAppCall, new DialogPresenter.ParameterProvider() { // from class: com.facebook.share.widget.ShareDialog$NativeHandler$createAppCall$1
                @Override // com.facebook.internal.DialogPresenter.ParameterProvider
                public Bundle getLegacyParameters() {
                    return LegacyNativeDialogParameters.create(appCallCreateBaseAppCall.getCallId(), content, shouldFailOnDataError);
                }

                @Override // com.facebook.internal.DialogPresenter.ParameterProvider
                public Bundle getParameters() {
                    return NativeDialogParameters.create(appCallCreateBaseAppCall.getCallId(), content, shouldFailOnDataError);
                }
            }, feature);
            return appCallCreateBaseAppCall;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class ShareStoryHandler extends FacebookDialogBase<ShareContent<?, ?>, Sharer.Result>.ModeHandler {
        private Object mode;

        public ShareStoryHandler() {
            super();
            this.mode = Mode.NATIVE;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public Object getMode() {
            return this.mode;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public void setMode(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "<set-?>");
            this.mode = obj;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public boolean canShow(ShareContent<?, ?> content, boolean z2) {
            Intrinsics.checkNotNullParameter(content, "content");
            return (content instanceof ShareStoryContent) && ShareDialog.Companion.canShowNative(content.getClass());
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public AppCall createAppCall(final ShareContent<?, ?> content) {
            Intrinsics.checkNotNullParameter(content, "content");
            ShareContentValidation.validateForStoryShare(content);
            final AppCall appCallCreateBaseAppCall = ShareDialog.this.createBaseAppCall();
            final boolean shouldFailOnDataError = ShareDialog.this.getShouldFailOnDataError();
            DialogFeature feature = ShareDialog.Companion.getFeature(content.getClass());
            if (feature == null) {
                return null;
            }
            DialogPresenter.setupAppCallForNativeDialog(appCallCreateBaseAppCall, new DialogPresenter.ParameterProvider() { // from class: com.facebook.share.widget.ShareDialog$ShareStoryHandler$createAppCall$1
                @Override // com.facebook.internal.DialogPresenter.ParameterProvider
                public Bundle getLegacyParameters() {
                    return LegacyNativeDialogParameters.create(appCallCreateBaseAppCall.getCallId(), content, shouldFailOnDataError);
                }

                @Override // com.facebook.internal.DialogPresenter.ParameterProvider
                public Bundle getParameters() {
                    return NativeDialogParameters.create(appCallCreateBaseAppCall.getCallId(), content, shouldFailOnDataError);
                }
            }, feature);
            return appCallCreateBaseAppCall;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class WebShareHandler extends FacebookDialogBase<ShareContent<?, ?>, Sharer.Result>.ModeHandler {
        private Object mode;

        public WebShareHandler() {
            super();
            this.mode = Mode.WEB;
        }

        private final SharePhotoContent createAndMapAttachments(SharePhotoContent sharePhotoContent, UUID uuid) {
            SharePhotoContent.Builder from = new SharePhotoContent.Builder().readFrom(sharePhotoContent);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = sharePhotoContent.getPhotos().size();
            for (int i3 = 0; i3 < size; i3++) {
                SharePhoto sharePhotoBuild = sharePhotoContent.getPhotos().get(i3);
                Bitmap bitmap = sharePhotoBuild.getBitmap();
                if (bitmap != null) {
                    NativeAppCallAttachmentStore.Attachment attachmentCreateAttachment = NativeAppCallAttachmentStore.createAttachment(uuid, bitmap);
                    sharePhotoBuild = new SharePhoto.Builder().readFrom(sharePhotoBuild).setImageUrl(Uri.parse(attachmentCreateAttachment.getAttachmentUrl())).setBitmap(null).build();
                    arrayList2.add(attachmentCreateAttachment);
                }
                arrayList.add(sharePhotoBuild);
            }
            from.setPhotos(arrayList);
            NativeAppCallAttachmentStore.addAttachments(arrayList2);
            return from.build();
        }

        private final String getActionName(ShareContent<?, ?> shareContent) {
            if ((shareContent instanceof ShareLinkContent) || (shareContent instanceof SharePhotoContent)) {
                return "share";
            }
            return null;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public Object getMode() {
            return this.mode;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public void setMode(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "<set-?>");
            this.mode = obj;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public boolean canShow(ShareContent<?, ?> content, boolean z2) {
            Intrinsics.checkNotNullParameter(content, "content");
            return ShareDialog.Companion.canShowWebCheck(content);
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public AppCall createAppCall(ShareContent<?, ?> content) {
            Bundle bundleCreate;
            Intrinsics.checkNotNullParameter(content, "content");
            ShareDialog shareDialog = ShareDialog.this;
            shareDialog.logDialogShare(shareDialog.getActivityContext(), content, Mode.WEB);
            AppCall appCallCreateBaseAppCall = ShareDialog.this.createBaseAppCall();
            ShareContentValidation.validateForWebShare(content);
            if (content instanceof ShareLinkContent) {
                bundleCreate = WebDialogParameters.create((ShareLinkContent) content);
            } else {
                if (!(content instanceof SharePhotoContent)) {
                    return null;
                }
                bundleCreate = WebDialogParameters.create(createAndMapAttachments((SharePhotoContent) content, appCallCreateBaseAppCall.getCallId()));
            }
            DialogPresenter.setupAppCallForWebDialog(appCallCreateBaseAppCall, getActionName(content), bundleCreate);
            return appCallCreateBaseAppCall;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Mode.values().length];
            try {
                iArr[Mode.AUTOMATIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Mode.WEB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Mode.NATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShareDialog(Activity activity) {
        this(activity, DEFAULT_REQUEST_CODE);
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @JvmStatic
    public static boolean canShow(Class<? extends ShareContent<?, ?>> cls) {
        return Companion.canShow(cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logDialogShare(Context context, ShareContent<?, ?> shareContent, Mode mode) {
        if (this.isAutomaticMode) {
            mode = Mode.AUTOMATIC;
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
        String str = "unknown";
        String str2 = i3 != 1 ? i3 != 2 ? i3 != 3 ? "unknown" : AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE : AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_WEB : AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_AUTOMATIC;
        DialogFeature feature = Companion.getFeature(shareContent.getClass());
        if (feature == ShareDialogFeature.SHARE_DIALOG) {
            str = AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS;
        } else if (feature == ShareDialogFeature.PHOTOS) {
            str = AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO;
        } else if (feature == ShareDialogFeature.VIDEO) {
            str = AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO;
        }
        InternalAppEventsLogger internalAppEventsLoggerCreateInstance = InternalAppEventsLogger.Companion.createInstance(context, FacebookSdk.getApplicationId());
        Bundle bundle = new Bundle();
        bundle.putString("fb_share_dialog_show", str2);
        bundle.putString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_TYPE, str);
        internalAppEventsLoggerCreateInstance.logEventImplicitly("fb_share_dialog_show", bundle);
    }

    @JvmStatic
    public static void show(Activity activity, ShareContent<?, ?> shareContent) {
        Companion.show(activity, shareContent);
    }

    @Override // com.facebook.internal.FacebookDialogBase
    protected AppCall createBaseAppCall() {
        return new AppCall(getRequestCode(), null, 2, null);
    }

    @Override // com.facebook.internal.FacebookDialogBase
    protected List<FacebookDialogBase<ShareContent<?, ?>, Sharer.Result>.ModeHandler> getOrderedModeHandlers() {
        return this.orderedModeHandlers;
    }

    public boolean getShouldFailOnDataError() {
        return this.shouldFailOnDataError;
    }

    @Override // com.facebook.internal.FacebookDialogBase
    protected void registerCallbackImpl(CallbackManagerImpl callbackManager, FacebookCallback<Sharer.Result> callback) {
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ShareInternalUtility.registerSharerCallback(getRequestCode(), callbackManager, callback);
    }

    public void setShouldFailOnDataError(boolean z2) {
        this.shouldFailOnDataError = z2;
    }

    public ShareDialog(int i3) {
        super(i3);
        this.isAutomaticMode = true;
        this.orderedModeHandlers = CollectionsKt.arrayListOf(new NativeHandler(), new FeedHandler(), new WebShareHandler(), new CameraEffectHandler(), new ShareStoryHandler());
        ShareInternalUtility.registerStaticShareCallback(i3);
    }

    @JvmStatic
    public static void show(android.app.Fragment fragment, ShareContent<?, ?> shareContent) {
        Companion.show(fragment, shareContent);
    }

    public boolean canShow(ShareContent<?, ?> content, Mode mode) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Object obj = mode;
        if (mode == Mode.AUTOMATIC) {
            obj = FacebookDialogBase.BASE_AUTOMATIC_MODE;
        }
        return canShowImpl(content, obj);
    }

    @JvmStatic
    public static void show(Fragment fragment, ShareContent<?, ?> shareContent) {
        Companion.show(fragment, shareContent);
    }

    public void show(ShareContent<?, ?> content, Mode mode) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(mode, "mode");
        boolean z2 = mode == Mode.AUTOMATIC;
        this.isAutomaticMode = z2;
        Object obj = mode;
        if (z2) {
            obj = FacebookDialogBase.BASE_AUTOMATIC_MODE;
        }
        showImpl(content, obj);
    }

    public /* synthetic */ ShareDialog(int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? DEFAULT_REQUEST_CODE : i3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShareDialog(Fragment fragment) {
        this(new FragmentWrapper(fragment), 0, 2, null);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShareDialog(android.app.Fragment fragment) {
        this(new FragmentWrapper(fragment), 0, 2, null);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareDialog(Activity activity, int i3) {
        super(activity, i3);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.isAutomaticMode = true;
        this.orderedModeHandlers = CollectionsKt.arrayListOf(new NativeHandler(), new FeedHandler(), new WebShareHandler(), new CameraEffectHandler(), new ShareStoryHandler());
        ShareInternalUtility.registerStaticShareCallback(i3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShareDialog(Fragment fragment, int i3) {
        this(new FragmentWrapper(fragment), i3);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShareDialog(android.app.Fragment fragment, int i3) {
        this(new FragmentWrapper(fragment), i3);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
    }

    public /* synthetic */ ShareDialog(FragmentWrapper fragmentWrapper, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragmentWrapper, (i4 & 2) != 0 ? DEFAULT_REQUEST_CODE : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareDialog(FragmentWrapper fragmentWrapper, int i3) {
        super(fragmentWrapper, i3);
        Intrinsics.checkNotNullParameter(fragmentWrapper, "fragmentWrapper");
        this.isAutomaticMode = true;
        this.orderedModeHandlers = CollectionsKt.arrayListOf(new NativeHandler(), new FeedHandler(), new WebShareHandler(), new CameraEffectHandler(), new ShareStoryHandler());
        ShareInternalUtility.registerStaticShareCallback(i3);
    }
}
