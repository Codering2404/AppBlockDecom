package com.revenuecat.purchases.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Base64;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
public final class UtilsKt {
    public static final boolean getCanUsePaywallUI() {
        return true;
    }

    public static final Locale getLocale(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return context.getResources().getConfiguration().getLocales().get(0);
    }

    public static final String getPlayServicesVersionName(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return packageVersionName(context, "com.google.android.gms");
    }

    public static final String getPlayStoreVersionName(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return packageVersionName(context, "com.android.vending");
    }

    public static final String getVersionName(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
    }

    public static final boolean isDeviceProtectedStorageCompat(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return context.isDeviceProtectedStorage();
    }

    private static final String packageVersionName(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static final String sha1(String str) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(str, "<this>");
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        Charset charset = Charsets.f140510b;
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] bArrEncode = Base64.encode(messageDigest.digest(bytes), 2);
        Intrinsics.checkNotNullExpressionValue(bArrEncode, "encode(it, Base64.NO_WRAP)");
        return new String(bArrEncode, charset);
    }

    public static final String sha256(String str) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(str, "<this>");
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        Charset charset = Charsets.f140510b;
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] bArrEncode = Base64.encode(messageDigest.digest(bytes), 2);
        Intrinsics.checkNotNullExpressionValue(bArrEncode, "encode(it, Base64.NO_WRAP)");
        return new String(bArrEncode, charset);
    }
}
