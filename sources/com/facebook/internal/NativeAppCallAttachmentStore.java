package com.facebook.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import com.applovin.sdk.AppLovinEventTypes;
import com.facebook.FacebookContentProvider;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.share.internal.ShareConstants;
import com.facebook.stetho.common.Utf8Charset;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public final class NativeAppCallAttachmentStore {
    public static final String ATTACHMENTS_DIR_NAME = "com.facebook.NativeAppCallAttachmentStore.files";
    public static final NativeAppCallAttachmentStore INSTANCE = new NativeAppCallAttachmentStore();
    private static final String TAG = NativeAppCallAttachmentStore.class.getName();
    private static File attachmentsDirectory;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Attachment {
        private final String attachmentName;
        private final String attachmentUrl;
        private final Bitmap bitmap;
        private final UUID callId;
        private boolean isContentUri;
        private final Uri originalUri;
        private boolean shouldCreateFile;

        public Attachment(UUID callId, Bitmap bitmap, Uri uri) {
            Intrinsics.checkNotNullParameter(callId, "callId");
            this.callId = callId;
            this.bitmap = bitmap;
            this.originalUri = uri;
            if (uri != null) {
                String scheme = uri.getScheme();
                if (StringsKt.F(AppLovinEventTypes.USER_VIEWED_CONTENT, scheme, true)) {
                    this.isContentUri = true;
                    String authority = uri.getAuthority();
                    this.shouldCreateFile = (authority == null || StringsKt.U(authority, ShareConstants.WEB_DIALOG_PARAM_MEDIA, false, 2, null)) ? false : true;
                } else if (StringsKt.F("file", uri.getScheme(), true)) {
                    this.shouldCreateFile = true;
                } else if (!Utility.isWebUri(uri)) {
                    throw new FacebookException("Unsupported scheme for media Uri : " + scheme);
                }
            } else {
                if (bitmap == null) {
                    throw new FacebookException("Cannot share media without a bitmap or Uri set");
                }
                this.shouldCreateFile = true;
            }
            String string = this.shouldCreateFile ? UUID.randomUUID().toString() : null;
            this.attachmentName = string;
            this.attachmentUrl = !this.shouldCreateFile ? String.valueOf(uri) : FacebookContentProvider.Companion.getAttachmentUrl(FacebookSdk.getApplicationId(), callId, string);
        }

        public final String getAttachmentName() {
            return this.attachmentName;
        }

        public final String getAttachmentUrl() {
            return this.attachmentUrl;
        }

        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        public final UUID getCallId() {
            return this.callId;
        }

        public final Uri getOriginalUri() {
            return this.originalUri;
        }

        public final boolean getShouldCreateFile() {
            return this.shouldCreateFile;
        }

        public final boolean isContentUri() {
            return this.isContentUri;
        }

        public final void setContentUri(boolean z2) {
            this.isContentUri = z2;
        }

        public final void setShouldCreateFile(boolean z2) {
            this.shouldCreateFile = z2;
        }
    }

    private NativeAppCallAttachmentStore() {
    }

    @JvmStatic
    public static final void addAttachments(Collection<Attachment> collection) throws FacebookException {
        File attachmentFile;
        if (collection == null || collection.isEmpty()) {
            return;
        }
        if (attachmentsDirectory == null) {
            cleanupAllAttachments();
        }
        ensureAttachmentsDirectoryExists();
        ArrayList arrayList = new ArrayList();
        try {
            for (Attachment attachment : collection) {
                if (attachment.getShouldCreateFile() && (attachmentFile = getAttachmentFile(attachment.getCallId(), attachment.getAttachmentName(), true)) != null) {
                    arrayList.add(attachmentFile);
                    if (attachment.getBitmap() != null) {
                        INSTANCE.processAttachmentBitmap(attachment.getBitmap(), attachmentFile);
                    } else if (attachment.getOriginalUri() != null) {
                        INSTANCE.processAttachmentFile(attachment.getOriginalUri(), attachment.isContentUri(), attachmentFile);
                    }
                }
            }
        } catch (IOException e3) {
            Log.e(TAG, "Got unexpected exception:" + e3);
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                File file = (File) obj;
                if (file != null) {
                    try {
                        file.delete();
                    } catch (Exception unused) {
                    }
                }
            }
            throw new FacebookException(e3);
        }
    }

    @JvmStatic
    public static final void cleanupAllAttachments() {
        File attachmentsDirectory2 = getAttachmentsDirectory();
        if (attachmentsDirectory2 != null) {
            FilesKt.p(attachmentsDirectory2);
        }
    }

    @JvmStatic
    public static final void cleanupAttachmentsForCall(UUID callId) {
        Intrinsics.checkNotNullParameter(callId, "callId");
        File attachmentsDirectoryForCall = getAttachmentsDirectoryForCall(callId, false);
        if (attachmentsDirectoryForCall != null) {
            FilesKt.p(attachmentsDirectoryForCall);
        }
    }

    @JvmStatic
    public static final Attachment createAttachment(UUID callId, Bitmap attachmentBitmap) {
        Intrinsics.checkNotNullParameter(callId, "callId");
        Intrinsics.checkNotNullParameter(attachmentBitmap, "attachmentBitmap");
        return new Attachment(callId, attachmentBitmap, null);
    }

    @JvmStatic
    public static final File ensureAttachmentsDirectoryExists() {
        File attachmentsDirectory2 = getAttachmentsDirectory();
        if (attachmentsDirectory2 != null) {
            attachmentsDirectory2.mkdirs();
        }
        return attachmentsDirectory2;
    }

    @JvmStatic
    public static final File getAttachmentFile(UUID callId, String str, boolean z2) throws IOException {
        Intrinsics.checkNotNullParameter(callId, "callId");
        File attachmentsDirectoryForCall = getAttachmentsDirectoryForCall(callId, z2);
        if (attachmentsDirectoryForCall == null) {
            return null;
        }
        try {
            return new File(attachmentsDirectoryForCall, URLEncoder.encode(str, Utf8Charset.NAME));
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    @JvmStatic
    public static final synchronized File getAttachmentsDirectory() {
        try {
            if (attachmentsDirectory == null) {
                attachmentsDirectory = new File(FacebookSdk.getApplicationContext().getCacheDir(), ATTACHMENTS_DIR_NAME);
            }
        } catch (Throwable th) {
            throw th;
        }
        return attachmentsDirectory;
    }

    @JvmStatic
    public static final File getAttachmentsDirectoryForCall(UUID callId, boolean z2) {
        Intrinsics.checkNotNullParameter(callId, "callId");
        if (attachmentsDirectory == null) {
            return null;
        }
        File file = new File(attachmentsDirectory, callId.toString());
        if (z2 && !file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    @JvmStatic
    public static final File openAttachment(UUID uuid, String str) throws FileNotFoundException {
        if (Utility.isNullOrEmpty(str) || uuid == null) {
            throw new FileNotFoundException();
        }
        try {
            return getAttachmentFile(uuid, str, false);
        } catch (IOException unused) {
            throw new FileNotFoundException();
        }
    }

    private final void processAttachmentBitmap(Bitmap bitmap, File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
        } finally {
            Utility.closeQuietly(fileOutputStream);
        }
    }

    private final void processAttachmentFile(Uri uri, boolean z2, File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            Utility.copyAndCloseInputStream(!z2 ? new FileInputStream(uri.getPath()) : FacebookSdk.getApplicationContext().getContentResolver().openInputStream(uri), fileOutputStream);
            Utility.closeQuietly(fileOutputStream);
        } catch (Throwable th) {
            Utility.closeQuietly(fileOutputStream);
            throw th;
        }
    }

    @JvmStatic
    public static final Attachment createAttachment(UUID callId, Uri attachmentUri) {
        Intrinsics.checkNotNullParameter(callId, "callId");
        Intrinsics.checkNotNullParameter(attachmentUri, "attachmentUri");
        return new Attachment(callId, null, attachmentUri);
    }
}
