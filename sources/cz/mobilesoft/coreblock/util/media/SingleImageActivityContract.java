package cz.mobilesoft.coreblock.util.media;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.contract.ActivityResultContract;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

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
public final class SingleImageActivityContract extends ActivityResultContract<Unit, Uri> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f128864a = 8;

    @Override // androidx.activity.result.contract.ActivityResultContract
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Uri parseResult(int i3, Intent intent) {
        if (i3 != -1) {
            intent = null;
        }
        if (intent != null) {
            return intent.getData();
        }
        return null;
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    public Intent createIntent(Context context, Unit unit) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (MediaUtil.f128857a.h()) {
            return new Intent("android.provider.action.PICK_IMAGES");
        }
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.setType("image/*");
        return intent;
    }
}
