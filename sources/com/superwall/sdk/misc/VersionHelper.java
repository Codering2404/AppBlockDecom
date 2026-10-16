package com.superwall.sdk.misc;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class VersionHelper {
    private final String buildTime;
    private final Context context;
    private final String gitSha;
    private final String sdkVersion;

    public VersionHelper(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.gitSha = readFileFromAssets(context, "git_sha.txt");
        this.buildTime = readFileFromAssets(context, "build_time.txt");
        this.sdkVersion = ConstantsKt.getSDK_VERSION();
    }

    private final String readFileFromAssets(Context context, String str) {
        try {
            InputStream inputStreamOpen = context.getAssets().open(str);
            Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(...)");
            byte[] bArr = new byte[inputStreamOpen.available()];
            inputStreamOpen.read(bArr);
            inputStreamOpen.close();
            return new String(bArr, Charsets.f140510b);
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public final String getBuildTime() {
        return this.buildTime;
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getGitSha() {
        return this.gitSha;
    }

    public final String getSdkVersion() {
        return this.sdkVersion;
    }
}
