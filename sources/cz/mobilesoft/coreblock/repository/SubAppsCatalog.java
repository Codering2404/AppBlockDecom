package cz.mobilesoft.coreblock.repository;

import cz.mobilesoft.coreblock.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

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
public final class SubAppsCatalog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SubAppsCatalog f98385a = new SubAppsCatalog();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List f98386b = CollectionsKt.listOf((Object[]) new SubApp[]{new SubApp("YoutubeShorts", R.string.KH, "com.google.android.youtube", "yt_shorts", CollectionsKt.listOf(":id/reel_player_page_container")), new SubApp("SnapchatStories", R.string.Uz, "com.snapchat.android", "snap_stories", CollectionsKt.listOf(":id/df_large_story")), new SubApp("SnapchatSpotlight", R.string.Tz, "com.snapchat.android", "snap_spotlight", CollectionsKt.listOf((Object[]) new String[]{":id/spotlight_attribution_title", ":id/spotlight_container", ":id/favorite"})), new SubApp("InstagramReels", R.string.Hh, "com.instagram.android", "ig_reels", CollectionsKt.listOf(":id/comment_count")), new SubApp("InstagramStories", R.string.Ih, "com.instagram.android", "ig_stories", CollectionsKt.listOf(":id/reel_viewer_timestamp")), new SubApp("WhatsAppChannels", R.string.jH, "com.whatsapp", "whatsapp_channels", CollectionsKt.listOf((Object[]) new String[]{":id/newsletter_quick_forwarding_pill_container_key", ":id/follow_channel_button"})), new SubApp("WhatsAppStatus", R.string.kH, "com.whatsapp", "whatsapp_status", CollectionsKt.listOf((Object[]) new String[]{":id/status_playback_image", ":id/status_playback_video"}))});

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f98387c = 8;

    private SubAppsCatalog() {
    }

    public final List a() {
        return f98386b;
    }
}
