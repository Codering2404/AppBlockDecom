package cz.mobilesoft.coreblock.util.monetization;

import com.facebook.internal.AnalyticsEvents;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class PaywallEngine {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PaywallEngine[] $VALUES;
    public static final Companion Companion;
    private final String id;
    public static final PaywallEngine Superwall = new PaywallEngine("Superwall", 0, "superwall");
    public static final PaywallEngine RcHosted = new PaywallEngine("RcHosted", 1, "rc_hosted");
    public static final PaywallEngine Native = new PaywallEngine("Native", 2, AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PaywallEngine a(String str) {
            String string;
            PaywallEngine paywallEngine = null;
            if (str == null || (string = StringsKt.t1(str).toString()) == null) {
                return null;
            }
            Iterator<PaywallEngine> it = PaywallEngine.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PaywallEngine next = it.next();
                if (StringsKt.F(next.getId(), string, true)) {
                    paywallEngine = next;
                    break;
                }
            }
            return paywallEngine;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ PaywallEngine[] $values() {
        return new PaywallEngine[]{Superwall, RcHosted, Native};
    }

    static {
        PaywallEngine[] paywallEngineArr$values = $values();
        $VALUES = paywallEngineArr$values;
        $ENTRIES = EnumEntriesKt.a(paywallEngineArr$values);
        Companion = new Companion(null);
    }

    private PaywallEngine(String str, int i3, String str2) {
        this.id = str2;
    }

    public static EnumEntries<PaywallEngine> getEntries() {
        return $ENTRIES;
    }

    public static PaywallEngine valueOf(String str) {
        return (PaywallEngine) Enum.valueOf(PaywallEngine.class, str);
    }

    public static PaywallEngine[] values() {
        return (PaywallEngine[]) $VALUES.clone();
    }

    public final String getId() {
        return this.id;
    }
}
