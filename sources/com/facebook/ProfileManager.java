package com.facebook;

import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.internal.Utility;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class ProfileManager {
    public static final String ACTION_CURRENT_PROFILE_CHANGED = "com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED";
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_NEW_PROFILE = "com.facebook.sdk.EXTRA_NEW_PROFILE";
    public static final String EXTRA_OLD_PROFILE = "com.facebook.sdk.EXTRA_OLD_PROFILE";
    public static volatile ProfileManager instance;
    public Profile currentProfileField;
    public final LocalBroadcastManager localBroadcastManager;
    public final ProfileCache profileCache;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final synchronized ProfileManager getInstance() {
            ProfileManager profileManager;
            try {
                if (ProfileManager.instance == null) {
                    LocalBroadcastManager localBroadcastManagerB = LocalBroadcastManager.b(FacebookSdk.getApplicationContext());
                    Intrinsics.checkNotNullExpressionValue(localBroadcastManagerB, "getInstance(applicationContext)");
                    ProfileManager.instance = new ProfileManager(localBroadcastManagerB, new ProfileCache());
                }
                profileManager = ProfileManager.instance;
                if (profileManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("instance");
                    profileManager = null;
                }
            } catch (Throwable th) {
                throw th;
            }
            return profileManager;
        }

        public Companion() {
        }
    }

    public ProfileManager(LocalBroadcastManager localBroadcastManager, ProfileCache profileCache) {
        Intrinsics.checkNotNullParameter(localBroadcastManager, "localBroadcastManager");
        Intrinsics.checkNotNullParameter(profileCache, "profileCache");
        this.localBroadcastManager = localBroadcastManager;
        this.profileCache = profileCache;
    }

    @JvmStatic
    public static final synchronized ProfileManager getInstance() {
        return Companion.getInstance();
    }

    private final void sendCurrentProfileChangedBroadcast(Profile profile, Profile profile2) {
        Intent intent = new Intent(ACTION_CURRENT_PROFILE_CHANGED);
        intent.putExtra(EXTRA_OLD_PROFILE, profile);
        intent.putExtra(EXTRA_NEW_PROFILE, profile2);
        this.localBroadcastManager.d(intent);
    }

    public final Profile getCurrentProfile() {
        return this.currentProfileField;
    }

    public final boolean loadCurrentProfile() {
        Profile profileLoad = this.profileCache.load();
        if (profileLoad == null) {
            return false;
        }
        setCurrentProfile(profileLoad, false);
        return true;
    }

    public final void setCurrentProfile(Profile profile) {
        setCurrentProfile(profile, true);
    }

    private final void setCurrentProfile(Profile profile, boolean z2) {
        Profile profile2 = this.currentProfileField;
        this.currentProfileField = profile;
        if (z2) {
            if (profile != null) {
                this.profileCache.save(profile);
            } else {
                this.profileCache.clear();
            }
        }
        if (Utility.areObjectsEqual(profile2, profile)) {
            return;
        }
        sendCurrentProfileChangedBroadcast(profile2, profile);
    }
}
