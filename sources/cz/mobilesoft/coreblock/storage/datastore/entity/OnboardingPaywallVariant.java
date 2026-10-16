package cz.mobilesoft.coreblock.storage.datastore.entity;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class OnboardingPaywallVariant {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ OnboardingPaywallVariant[] $VALUES;
    public static final Companion Companion;
    public static final OnboardingPaywallVariant Native;
    public static final OnboardingPaywallVariant RevenueCat;
    public static final OnboardingPaywallVariant Superwall;
    private static final OnboardingPaywallVariant defaultVariant;
    private final String id;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final OnboardingPaywallVariant a(String id) {
            OnboardingPaywallVariant next;
            Intrinsics.checkNotNullParameter(id, "id");
            Iterator<OnboardingPaywallVariant> it = OnboardingPaywallVariant.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (StringsKt.F(next.getId(), StringsKt.t1(id).toString(), true)) {
                    break;
                }
            }
            OnboardingPaywallVariant onboardingPaywallVariant = next;
            return onboardingPaywallVariant == null ? b() : onboardingPaywallVariant;
        }

        public final OnboardingPaywallVariant b() {
            return OnboardingPaywallVariant.defaultVariant;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ OnboardingPaywallVariant[] $values() {
        return new OnboardingPaywallVariant[]{Native, RevenueCat, Superwall};
    }

    static {
        OnboardingPaywallVariant onboardingPaywallVariant = new OnboardingPaywallVariant("Native", 0, "A");
        Native = onboardingPaywallVariant;
        RevenueCat = new OnboardingPaywallVariant("RevenueCat", 1, "B");
        Superwall = new OnboardingPaywallVariant("Superwall", 2, "C");
        OnboardingPaywallVariant[] onboardingPaywallVariantArr$values = $values();
        $VALUES = onboardingPaywallVariantArr$values;
        $ENTRIES = EnumEntriesKt.a(onboardingPaywallVariantArr$values);
        Companion = new Companion(null);
        defaultVariant = onboardingPaywallVariant;
    }

    private OnboardingPaywallVariant(String str, int i3, String str2) {
        this.id = str2;
    }

    public static EnumEntries<OnboardingPaywallVariant> getEntries() {
        return $ENTRIES;
    }

    public static OnboardingPaywallVariant valueOf(String str) {
        return (OnboardingPaywallVariant) Enum.valueOf(OnboardingPaywallVariant.class, str);
    }

    public static OnboardingPaywallVariant[] values() {
        return (OnboardingPaywallVariant[]) $VALUES.clone();
    }

    public final String getId() {
        return this.id;
    }
}
