package com.facebook.bolts;

import android.net.Uri;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public final class AppLink {
    private final Uri sourceUrl;
    private final List<Target> targets;
    private final Uri webUrl;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Target {
        private final String appName;
        private final String className;
        private final String packageName;
        private final Uri url;

        public Target(String packageName, String className, Uri url, String appName) {
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            Intrinsics.checkNotNullParameter(className, "className");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(appName, "appName");
            this.packageName = packageName;
            this.className = className;
            this.url = url;
            this.appName = appName;
        }

        public final String getAppName() {
            return this.appName;
        }

        public final String getClassName() {
            return this.className;
        }

        public final String getPackageName() {
            return this.packageName;
        }

        public final Uri getUrl() {
            return this.url;
        }
    }

    public AppLink(Uri sourceUrl, List<Target> list, Uri webUrl) {
        Intrinsics.checkNotNullParameter(sourceUrl, "sourceUrl");
        Intrinsics.checkNotNullParameter(webUrl, "webUrl");
        this.sourceUrl = sourceUrl;
        this.webUrl = webUrl;
        this.targets = list == null ? CollectionsKt.emptyList() : list;
    }

    public final Uri getSourceUrl() {
        return this.sourceUrl;
    }

    public final List<Target> getTargets() {
        List<Target> listUnmodifiableList = Collections.unmodifiableList(this.targets);
        Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(field)");
        return listUnmodifiableList;
    }

    public final Uri getWebUrl() {
        return this.webUrl;
    }
}
