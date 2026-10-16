package com.facebook.gamingservices.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.HttpMethod;
import com.facebook.internal.Utility;
import java.io.File;
import java.io.FileNotFoundException;
import kotlin.Metadata;
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
public final class GamingMediaUploader {
    public static final GamingMediaUploader INSTANCE = new GamingMediaUploader();
    private static final String photoUploadEdge = "me/photos";

    private GamingMediaUploader() {
    }

    @JvmStatic
    public static final GraphRequestAsyncTask uploadToGamingServices(String str, Bitmap imageBitmap, Bundle bundle, GraphRequest.Callback callback) {
        Intrinsics.checkNotNullParameter(imageBitmap, "imageBitmap");
        return GraphRequest.Companion.newUploadPhotoRequest(AccessToken.Companion.getCurrentAccessToken(), "me/photos", imageBitmap, str, bundle, callback).executeAsync();
    }

    @JvmStatic
    public static final GraphRequestAsyncTask uploadToGamingServices(String str, File imageFile, Bundle bundle, GraphRequest.Callback callback) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(imageFile, "imageFile");
        return GraphRequest.Companion.newUploadPhotoRequest(AccessToken.Companion.getCurrentAccessToken(), "me/photos", imageFile, str, bundle, callback).executeAsync();
    }

    @JvmStatic
    public static final GraphRequestAsyncTask uploadToGamingServices(String str, Uri imageUri, Bundle bundle, GraphRequest.Callback callback) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(imageUri, "imageUri");
        if (!Utility.isFileUri(imageUri) && !Utility.isContentUri(imageUri)) {
            Bundle bundle2 = new Bundle();
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            bundle2.putString("url", imageUri.toString());
            if (str != null && str.length() != 0) {
                bundle2.putString("caption", str);
            }
            return new GraphRequest(AccessToken.Companion.getCurrentAccessToken(), "me/photos", bundle2, HttpMethod.POST, callback, null, 32, null).executeAsync();
        }
        return GraphRequest.Companion.newUploadPhotoRequest(AccessToken.Companion.getCurrentAccessToken(), "me/photos", imageUri, str, bundle, callback).executeAsync();
    }
}
