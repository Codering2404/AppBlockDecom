package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.internal.Utility;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhotoContent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
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
public final class LegacyNativeDialogParameters {
    public static final LegacyNativeDialogParameters INSTANCE = new LegacyNativeDialogParameters();

    private LegacyNativeDialogParameters() {
    }

    @JvmStatic
    public static final Bundle create(UUID callId, ShareContent<?, ?> shareContent, boolean z2) {
        Intrinsics.checkNotNullParameter(callId, "callId");
        Intrinsics.checkNotNullParameter(shareContent, "shareContent");
        if (shareContent instanceof ShareLinkContent) {
            return INSTANCE.create((ShareLinkContent) shareContent, z2);
        }
        if (!(shareContent instanceof SharePhotoContent)) {
            return null;
        }
        SharePhotoContent sharePhotoContent = (SharePhotoContent) shareContent;
        List<String> photoUrls = ShareInternalUtility.getPhotoUrls(sharePhotoContent, callId);
        if (photoUrls == null) {
            photoUrls = CollectionsKt.emptyList();
        }
        return INSTANCE.create(sharePhotoContent, photoUrls, z2);
    }

    private final Bundle createBaseParameters(ShareContent<?, ?> shareContent, boolean z2) {
        Bundle bundle = new Bundle();
        Utility.putUri(bundle, ShareConstants.LEGACY_LINK, shareContent.getContentUrl());
        Utility.putNonEmptyString(bundle, ShareConstants.LEGACY_PLACE_TAG, shareContent.getPlaceId());
        Utility.putNonEmptyString(bundle, ShareConstants.LEGACY_REF, shareContent.getRef());
        bundle.putBoolean(ShareConstants.LEGACY_DATA_FAILURES_FATAL, z2);
        List<String> peopleIds = shareContent.getPeopleIds();
        if (peopleIds != null && !peopleIds.isEmpty()) {
            bundle.putStringArrayList(ShareConstants.LEGACY_FRIEND_TAGS, new ArrayList<>(peopleIds));
        }
        return bundle;
    }

    private final Bundle create(ShareLinkContent shareLinkContent, boolean z2) {
        return createBaseParameters(shareLinkContent, z2);
    }

    private final Bundle create(SharePhotoContent sharePhotoContent, List<String> list, boolean z2) {
        Bundle bundleCreateBaseParameters = createBaseParameters(sharePhotoContent, z2);
        bundleCreateBaseParameters.putStringArrayList(ShareConstants.LEGACY_PHOTOS, new ArrayList<>(list));
        return bundleCreateBaseParameters;
    }
}
