package androidx.compose.ui.window;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class SecureFlagPolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SecureFlagPolicy f30288a = new SecureFlagPolicy("Inherit", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SecureFlagPolicy f30289b = new SecureFlagPolicy("SecureOn", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SecureFlagPolicy f30290c = new SecureFlagPolicy("SecureOff", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ SecureFlagPolicy[] f30291d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ EnumEntries f30292f;

    static {
        SecureFlagPolicy[] secureFlagPolicyArrA = a();
        f30291d = secureFlagPolicyArrA;
        f30292f = EnumEntriesKt.a(secureFlagPolicyArrA);
    }

    private SecureFlagPolicy(String str, int i3) {
    }

    private static final /* synthetic */ SecureFlagPolicy[] a() {
        return new SecureFlagPolicy[]{f30288a, f30289b, f30290c};
    }

    public static SecureFlagPolicy valueOf(String str) {
        return (SecureFlagPolicy) Enum.valueOf(SecureFlagPolicy.class, str);
    }

    public static SecureFlagPolicy[] values() {
        return (SecureFlagPolicy[]) f30291d.clone();
    }
}
