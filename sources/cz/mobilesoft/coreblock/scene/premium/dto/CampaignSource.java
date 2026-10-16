package cz.mobilesoft.coreblock.scene.premium.dto;

import java.util.Iterator;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class CampaignSource {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CampaignSource[] $VALUES;
    public static final Companion Companion;
    private final int id;
    public static final CampaignSource None = new CampaignSource("None", 0, 0);
    public static final CampaignSource Notification = new CampaignSource("Notification", 1, 1);
    public static final CampaignSource DeepLink = new CampaignSource("DeepLink", 2, 2);
    public static final CampaignSource Server = new CampaignSource("Server", 3, 3);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CampaignSource a(int i3) {
            CampaignSource next;
            Iterator<CampaignSource> it = CampaignSource.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.getId() == i3) {
                    break;
                }
            }
            CampaignSource campaignSource = next;
            return campaignSource == null ? CampaignSource.None : campaignSource;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ CampaignSource[] $values() {
        return new CampaignSource[]{None, Notification, DeepLink, Server};
    }

    static {
        CampaignSource[] campaignSourceArr$values = $values();
        $VALUES = campaignSourceArr$values;
        $ENTRIES = EnumEntriesKt.a(campaignSourceArr$values);
        Companion = new Companion(null);
    }

    private CampaignSource(String str, int i3, int i4) {
        this.id = i4;
    }

    public static EnumEntries<CampaignSource> getEntries() {
        return $ENTRIES;
    }

    public static CampaignSource valueOf(String str) {
        return (CampaignSource) Enum.valueOf(CampaignSource.class, str);
    }

    public static CampaignSource[] values() {
        return (CampaignSource[]) $VALUES.clone();
    }

    public final int getId() {
        return this.id;
    }
}
