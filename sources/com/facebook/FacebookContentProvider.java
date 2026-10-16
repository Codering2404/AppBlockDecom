package com.facebook;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.util.Pair;
import com.facebook.internal.NativeAppCallAttachmentStore;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
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
public final class FacebookContentProvider extends ContentProvider {
    public static final String ATTACHMENT_URL_BASE = "content://com.facebook.app.FacebookContentProvider";
    public static final String INVALID_FILE_NAME = "..";
    public static final Companion Companion = new Companion(null);
    public static final String TAG = FacebookContentProvider.class.getName();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final String getAttachmentUrl(String str, UUID callId, String str2) {
            Intrinsics.checkNotNullParameter(callId, "callId");
            StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
            String str3 = String.format("%s%s/%s/%s", Arrays.copyOf(new Object[]{FacebookContentProvider.ATTACHMENT_URL_BASE, str, callId.toString(), str2}, 4));
            Intrinsics.checkNotNullExpressionValue(str3, "format(format, *args)");
            return str3;
        }

        public Companion() {
        }
    }

    @JvmStatic
    public static final String getAttachmentUrl(String str, UUID uuid, String str2) {
        return Companion.getAttachmentUrl(str, uuid, str2);
    }

    private final Pair<UUID, String> parseCallIdAndAttachmentName(Uri uri) {
        try {
            String path = uri.getPath();
            if (path == null) {
                throw new IllegalStateException("Required value was null.");
            }
            Intrinsics.checkNotNullExpressionValue(path, "checkNotNull(uri.path)");
            String strSubstring = path.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
            String[] strArr = (String[]) StringsKt.V0(strSubstring, new String[]{"/"}, false, 0, 6, null).toArray(new String[0]);
            String str = strArr[0];
            String str2 = strArr[1];
            if (INVALID_FILE_NAME.contentEquals(str) || INVALID_FILE_NAME.contentEquals(str2)) {
                throw new Exception();
            }
            return new Pair<>(UUID.fromString(str), str2);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String mode) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Pair<UUID, String> callIdAndAttachmentName = parseCallIdAndAttachmentName(uri);
        if (callIdAndAttachmentName == null) {
            throw new FileNotFoundException();
        }
        try {
            File fileOpenAttachment = NativeAppCallAttachmentStore.openAttachment((UUID) callIdAndAttachmentName.first, (String) callIdAndAttachmentName.second);
            if (fileOpenAttachment != null) {
                return ParcelFileDescriptor.open(fileOpenAttachment, 268435456);
            }
            throw new FileNotFoundException();
        } catch (FileNotFoundException e3) {
            Log.e(TAG, "Got unexpected exception:" + e3);
            throw e3;
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return 0;
    }
}
