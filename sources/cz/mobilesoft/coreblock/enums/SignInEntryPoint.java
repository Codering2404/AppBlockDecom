package cz.mobilesoft.coreblock.enums;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class SignInEntryPoint {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SignInEntryPoint[] $VALUES;
    private final String eventPrefix;
    public static final SignInEntryPoint UNKNOWN = new SignInEntryPoint("UNKNOWN", 0, null, 1, null);
    public static final SignInEntryPoint ACADEMY = new SignInEntryPoint("ACADEMY", 1, "academy");
    public static final SignInEntryPoint BACKUP = new SignInEntryPoint("BACKUP", 2, "backup");
    public static final SignInEntryPoint MORE = new SignInEntryPoint("MORE", 3, "more");
    public static final SignInEntryPoint REDEEM = new SignInEntryPoint("REDEEM", 4, "redeem");
    public static final SignInEntryPoint ONBOARDING = new SignInEntryPoint("ONBOARDING", 5, "onboarding");
    public static final SignInEntryPoint DIALOG = new SignInEntryPoint("DIALOG", 6, "dialog");
    public static final SignInEntryPoint RESTORE = new SignInEntryPoint("RESTORE", 7, "restore");
    public static final SignInEntryPoint SM_APPROVAL = new SignInEntryPoint("SM_APPROVAL", 8, "sm_approval");
    public static final SignInEntryPoint PREMIUM = new SignInEntryPoint("PREMIUM", 9, "premium");
    public static final SignInEntryPoint STARTUP = new SignInEntryPoint("STARTUP", 10, "startup");
    public static final SignInEntryPoint DEEPLINK = new SignInEntryPoint("DEEPLINK", 11, SDKConstants.PARAM_TOURNAMENTS_DEEPLINK);

    private static final /* synthetic */ SignInEntryPoint[] $values() {
        return new SignInEntryPoint[]{UNKNOWN, ACADEMY, BACKUP, MORE, REDEEM, ONBOARDING, DIALOG, RESTORE, SM_APPROVAL, PREMIUM, STARTUP, DEEPLINK};
    }

    static {
        SignInEntryPoint[] signInEntryPointArr$values = $values();
        $VALUES = signInEntryPointArr$values;
        $ENTRIES = EnumEntriesKt.a(signInEntryPointArr$values);
    }

    private SignInEntryPoint(String str, int i3, String str2) {
        this.eventPrefix = str2;
    }

    public static EnumEntries<SignInEntryPoint> getEntries() {
        return $ENTRIES;
    }

    public static SignInEntryPoint valueOf(String str) {
        return (SignInEntryPoint) Enum.valueOf(SignInEntryPoint.class, str);
    }

    public static SignInEntryPoint[] values() {
        return (SignInEntryPoint[]) $VALUES.clone();
    }

    public final String getEventPrefix() {
        return this.eventPrefix;
    }

    /* synthetic */ SignInEntryPoint(String str, int i3, String str2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, (i4 & 1) != 0 ? "" : str2);
    }
}
