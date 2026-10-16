package cz.mobilesoft.coreblock.scene.sharing.intents;

import com.facebook.messenger.MessengerUtils;
import cz.mobilesoft.coreblock.scene.sharing.intents.ShareIntentTarget;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ShareIntentTargetsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List f119455a = CollectionsKt.listOf((Object[]) new ShareIntentTarget[]{new ShareIntentTarget.PackageFirst("com.instagram.android"), new ShareIntentTarget.ActivityExact("com.instagram.android", "com.instagram.share.handleractivity.StoryShareHandlerActivity"), new ShareIntentTarget.PackageFirst("com.whatsapp"), new ShareIntentTarget.PackageFirst("com.snapchat.android"), ShareIntentTarget.DefaultSms.f119453a, new ShareIntentTarget.PackageFirst("com.linkedin.android"), new ShareIntentTarget.PackageFirst(MessengerUtils.PACKAGE_NAME), new ShareIntentTarget.PackageFirst("com.twitter.android"), new ShareIntentTarget.PackageFirst("com.discord"), new ShareIntentTarget.PackageFirst("org.telegram.messenger"), new ShareIntentTarget.PackageFirst("com.pinterest"), new ShareIntentTarget.PackageFirst("com.zhiliaoapp.musically"), new ShareIntentTarget.PackageFirst("com.google.android.gm")});

    public static final List a() {
        return f119455a;
    }
}
