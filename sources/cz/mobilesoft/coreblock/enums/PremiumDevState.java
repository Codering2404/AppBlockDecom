package cz.mobilesoft.coreblock.enums;

import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefConverter;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PremiumDevState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PremiumDevState[] $VALUES;
    public static final Companion Companion;
    private final int id;
    private final PremiumState state;
    private final int title;
    public static final PremiumDevState REAL_STATE = new PremiumDevState("REAL_STATE", 0, 0, null, R.string.Na);
    public static final PremiumDevState NONE = new PremiumDevState("NONE", 1, 1, PremiumState.None.INSTANCE, R.string.Ia);
    public static final PremiumDevState OLD_FULL = new PremiumDevState("OLD_FULL", 2, 2, PremiumState.OldFull.INSTANCE, R.string.Ja);
    public static final PremiumDevState SUBSCRIPTION = new PremiumDevState("SUBSCRIPTION", 3, 3, PremiumState.Subscription.Yearly.INSTANCE, R.string.Ka);
    public static final PremiumDevState LIFETIME = new PremiumDevState("LIFETIME", 4, 4, PremiumState.Lifetime.INSTANCE, R.string.Ha);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PremiumDevState a(Integer num) {
            PremiumDevState next;
            Iterator<PremiumDevState> it = PremiumDevState.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                int id = next.getId();
                if (num != null && id == num.intValue()) {
                    break;
                }
            }
            PremiumDevState premiumDevState = next;
            return premiumDevState == null ? PremiumDevState.REAL_STATE : premiumDevState;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Converter implements PrefConverter<PremiumDevState, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Converter f97018a = new Converter();

        private Converter() {
        }

        public PremiumDevState a(int i3) {
            return PremiumDevState.Companion.a(Integer.valueOf(i3));
        }

        @Override // cz.mobilesoft.coreblock.storage.sharedprefs.PrefConverter
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer getId(PremiumDevState value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return Integer.valueOf(value.getId());
        }
    }

    private static final /* synthetic */ PremiumDevState[] $values() {
        return new PremiumDevState[]{REAL_STATE, NONE, OLD_FULL, SUBSCRIPTION, LIFETIME};
    }

    static {
        PremiumDevState[] premiumDevStateArr$values = $values();
        $VALUES = premiumDevStateArr$values;
        $ENTRIES = EnumEntriesKt.a(premiumDevStateArr$values);
        Companion = new Companion(null);
    }

    private PremiumDevState(String str, int i3, int i4, PremiumState premiumState, int i5) {
        this.id = i4;
        this.state = premiumState;
        this.title = i5;
    }

    public static EnumEntries<PremiumDevState> getEntries() {
        return $ENTRIES;
    }

    public static PremiumDevState valueOf(String str) {
        return (PremiumDevState) Enum.valueOf(PremiumDevState.class, str);
    }

    public static PremiumDevState[] values() {
        return (PremiumDevState[]) $VALUES.clone();
    }

    public final int getId() {
        return this.id;
    }

    public final PremiumState getState() {
        return this.state;
    }

    @Override // java.lang.Enum
    public String toString() {
        String strValueOf;
        String string = LockieApplication.g().getString(this.title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        if (string.length() <= 0) {
            return string;
        }
        StringBuilder sb = new StringBuilder();
        char cCharAt = string.charAt(0);
        if (Character.isLowerCase(cCharAt)) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            strValueOf = CharsKt.d(cCharAt, locale);
        } else {
            strValueOf = String.valueOf(cCharAt);
        }
        sb.append((Object) strValueOf);
        String strSubstring = string.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        sb.append(strSubstring);
        return sb.toString();
    }
}
