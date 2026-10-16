package cz.mobilesoft.coreblock.scene.more.guestpassshare;

import cz.mobilesoft.coreblock.R;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class GuestPassShareBottomButtonState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ GuestPassShareBottomButtonState[] $VALUES;
    private final Integer iconRes;
    private final int text;
    public static final GuestPassShareBottomButtonState ShareReferralLink = new GuestPassShareBottomButtonState("ShareReferralLink", 0, R.string.Iw, Integer.valueOf(R.drawable.l5));
    public static final GuestPassShareBottomButtonState ActivateGuestPass = new GuestPassShareBottomButtonState("ActivateGuestPass", 1, R.string.f95848u, null);
    public static final GuestPassShareBottomButtonState LetsGo = new GuestPassShareBottomButtonState("LetsGo", 2, R.string.Ep, null);
    public static final GuestPassShareBottomButtonState Thanks = new GuestPassShareBottomButtonState("Thanks", 3, R.string.N7, null);

    private static final /* synthetic */ GuestPassShareBottomButtonState[] $values() {
        return new GuestPassShareBottomButtonState[]{ShareReferralLink, ActivateGuestPass, LetsGo, Thanks};
    }

    static {
        GuestPassShareBottomButtonState[] guestPassShareBottomButtonStateArr$values = $values();
        $VALUES = guestPassShareBottomButtonStateArr$values;
        $ENTRIES = EnumEntriesKt.a(guestPassShareBottomButtonStateArr$values);
    }

    private GuestPassShareBottomButtonState(String str, int i3, int i4, Integer num) {
        this.text = i4;
        this.iconRes = num;
    }

    public static EnumEntries<GuestPassShareBottomButtonState> getEntries() {
        return $ENTRIES;
    }

    public static GuestPassShareBottomButtonState valueOf(String str) {
        return (GuestPassShareBottomButtonState) Enum.valueOf(GuestPassShareBottomButtonState.class, str);
    }

    public static GuestPassShareBottomButtonState[] values() {
        return (GuestPassShareBottomButtonState[]) $VALUES.clone();
    }

    public final Integer getIconRes() {
        return this.iconRes;
    }

    public final int getText() {
        return this.text;
    }
}
