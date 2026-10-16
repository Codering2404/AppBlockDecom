package com.revenuecat.purchases.strings;

import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class IdentityStrings {
    public static final String ALIAS_OLD_USER_ID_TO_CURRENT_SUCCESSFUL = "Successfully aliased old user ID %s to current user ID %s.";
    public static final String CONFIGURING_WITH_PREVIEW_MODE_USER_ID = "Configuring with UI preview mode user ID";
    public static final String EMPTY_APP_USER_ID_WILL_BECOME_ANONYMOUS = "Identifying with empty App User ID will be treated as anonymous.";
    public static final String IDENTIFYING_APP_USER_ID = "Identifying App User ID: %s";
    public static final IdentityStrings INSTANCE = new IdentityStrings();
    public static final String INVALIDATING_CACHED_ETAG_CACHE = "Detected unverified cached CustomerInfo but verification is enabled. Invalidating Etag cache.";
    public static final String LOGGING_IN = "Logging in from %s -> %s";
    public static final String LOG_IN_ERROR_MISSING_APP_USER_ID = "Error logging in: appUserID can't be null, empty or blank";
    public static final String LOG_IN_SUCCESSFUL = "Logged in successfully as %s. Created: %s";
    public static final String LOG_OUT_CALLED_ON_ANONYMOUS_USER = "Called logOut but the current user is anonymous";
    public static final String LOG_OUT_SUCCESSFUL = "Logged out successfully";
    public static final String OPERATION_NOT_SUPPORTED_IN_PREVIEW_MODE = "Operation not supported in UI preview mode";
    public static final String SETTING_NEW_ANON_ID = "Setting new anonymous App User ID - %s";
    public static final String SWITCHING_USER = "Switching to user %s.";
    public static final String SWITCHING_USER_SAME_APP_USER_ID = "switchUser called with the same appUserID as the current user %s. This has no effect.";

    private IdentityStrings() {
    }
}
