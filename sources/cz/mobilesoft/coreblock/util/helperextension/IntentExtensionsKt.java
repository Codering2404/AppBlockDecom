package cz.mobilesoft.coreblock.util.helperextension;

import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.scene.lockscreen.LockScreenIntentState;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import kotlin.Metadata;
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
public final class IntentExtensionsKt {
    public static final LockScreenIntentState a(Intent intent) {
        Parcelable parcelable;
        Parcelable parcelable2;
        Intrinsics.checkNotNullParameter(intent, "<this>");
        String stringExtra = intent.getStringExtra("PACKAGE_NAME");
        long longExtra = intent.getLongExtra("BLOCK_UNTIL", -1L);
        Long lValueOf = longExtra == -1 ? null : Long.valueOf(longExtra);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 33) {
            parcelable = (Parcelable) intent.getParcelableExtra("PROFILE_TYPE", ProfileType.class);
        } else {
            Parcelable parcelableExtra = intent.getParcelableExtra("PROFILE_TYPE");
            if (!(parcelableExtra instanceof ProfileType)) {
                parcelableExtra = null;
            }
            parcelable = (ProfileType) parcelableExtra;
        }
        ProfileType profileType = (ProfileType) parcelable;
        if (i3 >= 33) {
            parcelable2 = (Parcelable) intent.getParcelableExtra("USAGE_PERIOD_TYPE", UsageLimit.PeriodType.class);
        } else {
            Parcelable parcelableExtra2 = intent.getParcelableExtra("USAGE_PERIOD_TYPE");
            parcelable2 = (UsageLimit.PeriodType) (parcelableExtra2 instanceof UsageLimit.PeriodType ? parcelableExtra2 : null);
        }
        String stringExtra2 = intent.getStringExtra(ShareConstants.TITLE);
        Intrinsics.checkNotNull(stringExtra2, "null cannot be cast to non-null type kotlin.String");
        return new LockScreenIntentState(stringExtra, lValueOf, profileType, (UsageLimit.PeriodType) parcelable2, stringExtra2, 0L, 32, null);
    }

    public static final void b(Intent intent, String key, Parcelable value) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        intent.putExtra(key, value);
    }
}
