package cz.mobilesoft.coreblock.scene.sharing.render;

import android.content.ClipData;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.core.content.FileProvider;
import com.facebook.internal.NativeProtocol;
import cz.mobilesoft.coreblock.scene.sharing.intents.ShareableAppInfo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class SocialShareManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SocialShareManager f119513a = new SocialShareManager();

    private SocialShareManager() {
    }

    private final void g(Context context, Uri uri, ShareableAppInfo shareableAppInfo) {
        Object objB;
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/png");
        intent.putExtra("android.intent.extra.STREAM", uri);
        intent.setClipData(ClipData.newUri(context.getContentResolver(), "social-share-image", uri));
        intent.addFlags(1);
        intent.setClassName(shareableAppInfo.d(), shareableAppInfo.a());
        try {
            Result.Companion companion = Result.f139772b;
            objB = Result.b(context.getPackageManager().resolveActivity(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f139772b;
            objB = Result.b(ResultKt.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        if (((ResolveInfo) objB) != null) {
            context.startActivity(intent);
            return;
        }
        throw new IllegalStateException("Unable to resolve share activity " + shareableAppInfo.d() + "/" + shareableAppInfo.a());
    }

    private final void h(Context context, Uri uri) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/png");
        intent.putExtra("android.intent.extra.STREAM", uri);
        intent.setClipData(ClipData.newUri(context.getContentResolver(), "social-share-image", uri));
        intent.addFlags(1);
        context.startActivity(Intent.createChooser(intent, "Share image"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Uri i(Context context, Bitmap bitmap) {
        File file = new File(context.getCacheDir(), "social_shares");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, "social_share_" + System.currentTimeMillis() + ".png");
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            CloseableKt.a(fileOutputStream, null);
            Uri uriH = FileProvider.h(context, context.getPackageName() + ".FileProvider", file2);
            Intrinsics.checkNotNullExpressionValue(uriH, "getUriForFile(...)");
            return uriH;
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Uri j(Context context, Bitmap bitmap) throws FileNotFoundException {
        if (Build.VERSION.SDK_INT < 29) {
            throw new IllegalStateException("Downloads saving is only supported on Android 10+");
        }
        String str = "social_share_" + System.currentTimeMillis() + ".png";
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", str);
        contentValues.put("mime_type", "image/png");
        contentValues.put("relative_path", Environment.DIRECTORY_DOWNLOADS);
        contentValues.put("is_pending", (Integer) 1);
        ContentResolver contentResolver = context.getContentResolver();
        Uri uriInsert = contentResolver.insert(MediaStore.Files.getContentUri("external"), contentValues);
        if (uriInsert == null) {
            throw new IllegalStateException("Failed to create Downloads media item");
        }
        OutputStream outputStreamOpenOutputStream = contentResolver.openOutputStream(uriInsert);
        if (outputStreamOpenOutputStream == null) {
            throw new IllegalStateException("Failed to open Downloads output stream");
        }
        try {
            if (!bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStreamOpenOutputStream)) {
                throw new IllegalStateException("Bitmap compression failed");
            }
            Unit unit = Unit.f139807a;
            CloseableKt.a(outputStreamOpenOutputStream, null);
            contentValues.clear();
            contentValues.put("is_pending", (Integer) 0);
            contentResolver.update(uriInsert, contentValues, null, null);
            return uriInsert;
        } finally {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ff, code lost:
    
        if (r0 != r2) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(android.content.Context r17, android.view.View r18, cz.mobilesoft.coreblock.scene.sharing.images.SocialShareTemplate r19, cz.mobilesoft.coreblock.scene.sharing.dto.SocialsSharePayload r20, java.lang.String r21, kotlin.coroutines.Continuation r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 357
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.sharing.render.SocialShareManager.c(android.content.Context, android.view.View, cz.mobilesoft.coreblock.scene.sharing.images.SocialShareTemplate, cz.mobilesoft.coreblock.scene.sharing.dto.SocialsSharePayload, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(android.content.Context r18, android.view.View r19, cz.mobilesoft.coreblock.scene.sharing.images.SocialShareTemplate r20, cz.mobilesoft.coreblock.scene.sharing.dto.SocialsSharePayload r21, cz.mobilesoft.coreblock.scene.sharing.intents.ShareableAppInfo r22, java.lang.String r23, kotlin.coroutines.Continuation r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.sharing.render.SocialShareManager.e(android.content.Context, android.view.View, cz.mobilesoft.coreblock.scene.sharing.images.SocialShareTemplate, cz.mobilesoft.coreblock.scene.sharing.dto.SocialsSharePayload, cz.mobilesoft.coreblock.scene.sharing.intents.ShareableAppInfo, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object f(android.content.Context r15, android.view.View r16, cz.mobilesoft.coreblock.scene.sharing.images.SocialShareTemplate r17, cz.mobilesoft.coreblock.scene.sharing.dto.SocialsSharePayload r18, java.lang.String r19, kotlin.coroutines.Continuation r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.sharing.render.SocialShareManager.f(android.content.Context, android.view.View, cz.mobilesoft.coreblock.scene.sharing.images.SocialShareTemplate, cz.mobilesoft.coreblock.scene.sharing.dto.SocialsSharePayload, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0100, code lost:
    
        if (r0 != r2) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d(android.content.Context r17, android.view.View r18, cz.mobilesoft.coreblock.scene.sharing.images.SocialShareTemplate r19, cz.mobilesoft.coreblock.scene.sharing.dto.SocialsSharePayload r20, java.lang.String r21, kotlin.coroutines.Continuation r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.sharing.render.SocialShareManager.d(android.content.Context, android.view.View, cz.mobilesoft.coreblock.scene.sharing.images.SocialShareTemplate, cz.mobilesoft.coreblock.scene.sharing.dto.SocialsSharePayload, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
