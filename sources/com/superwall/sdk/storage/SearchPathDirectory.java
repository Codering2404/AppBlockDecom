package com.superwall.sdk.storage;

import android.content.Context;
import java.io.File;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class SearchPathDirectory {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SearchPathDirectory[] $VALUES;
    public static final SearchPathDirectory CACHE = new SearchPathDirectory("CACHE", 0);
    public static final SearchPathDirectory USER_SPECIFIC_DOCUMENTS = new SearchPathDirectory("USER_SPECIFIC_DOCUMENTS", 1);
    public static final SearchPathDirectory APP_SPECIFIC_DOCUMENTS = new SearchPathDirectory("APP_SPECIFIC_DOCUMENTS", 2);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SearchPathDirectory.values().length];
            try {
                iArr[SearchPathDirectory.CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SearchPathDirectory.USER_SPECIFIC_DOCUMENTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SearchPathDirectory.APP_SPECIFIC_DOCUMENTS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ SearchPathDirectory[] $values() {
        return new SearchPathDirectory[]{CACHE, USER_SPECIFIC_DOCUMENTS, APP_SPECIFIC_DOCUMENTS};
    }

    static {
        SearchPathDirectory[] searchPathDirectoryArr$values = $values();
        $VALUES = searchPathDirectoryArr$values;
        $ENTRIES = EnumEntriesKt.a(searchPathDirectoryArr$values);
    }

    private SearchPathDirectory(String str, int i3) {
    }

    public static EnumEntries<SearchPathDirectory> getEntries() {
        return $ENTRIES;
    }

    public static SearchPathDirectory valueOf(String str) {
        return (SearchPathDirectory) Enum.valueOf(SearchPathDirectory.class, str);
    }

    public static SearchPathDirectory[] values() {
        return (SearchPathDirectory[]) $VALUES.clone();
    }

    public final File fileDirectory(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i3 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i3 == 1) {
            File cacheDir = context.getCacheDir();
            Intrinsics.checkNotNullExpressionValue(cacheDir, "getCacheDir(...)");
            return cacheDir;
        }
        if (i3 == 2) {
            File dir = context.getDir("user_specific_document_dir", 0);
            Intrinsics.checkNotNullExpressionValue(dir, "getDir(...)");
            return dir;
        }
        if (i3 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        File dir2 = context.getDir("app_specific_document_dir", 0);
        Intrinsics.checkNotNullExpressionValue(dir2, "getDir(...)");
        return dir2;
    }
}
