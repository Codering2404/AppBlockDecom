package cz.mobilesoft.coreblock.util.permissions;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.security.advancedprotection.AdvancedProtectionManager;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.runnability.RunnabilityHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class AdvancedProtectionHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AdvancedProtectionHelper f128991a = new AdvancedProtectionHelper();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List f128992b = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.a("com.google.android.gms.settings.ADVANCED_PROTECTION", "com.google.android.gms"), TuplesKt.a("com.google.android.gms.settings.ADVANCED_PROTECTION_APPS", "com.google.android.gms"), TuplesKt.a("android.settings.SECURITY_SETTINGS", null), TuplesKt.a("android.settings.PRIVACY_SETTINGS", null), TuplesKt.a("android.settings.SETTINGS", null)});

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f128993c = 8;

    private AdvancedProtectionHelper() {
    }

    public final boolean a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return RunnabilityHelper.f129617a.v() && b(context);
    }

    public final boolean b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!c()) {
            return false;
        }
        try {
            AdvancedProtectionManager advancedProtectionManagerA = b.a(context.getSystemService(a.a()));
            if (advancedProtectionManagerA != null) {
                return advancedProtectionManagerA.isAdvancedProtectionEnabled();
            }
            return false;
        } catch (Exception e3) {
            CrashHelper.j(e3);
            return false;
        }
    }

    public final boolean c() {
        return Build.VERSION.SDK_INT >= 36;
    }

    public final void d(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        for (Pair pair : f128992b) {
            String str = (String) pair.a();
            Intent intentAddFlags = new Intent(str).setPackage((String) pair.b()).addFlags(268435456);
            Intrinsics.checkNotNullExpressionValue(intentAddFlags, "addFlags(...)");
            if (intentAddFlags.resolveActivity(context.getPackageManager()) != null) {
                try {
                    context.startActivity(intentAddFlags);
                    return;
                } catch (Exception e3) {
                    CrashHelper.j(e3);
                }
            }
        }
    }
}
