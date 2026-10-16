package cz.mobilesoft.coreblock.enums;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class StrictModeDeactivationTime {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ StrictModeDeactivationTime[] $VALUES;
    public static final Companion Companion;
    public static final StrictModeDeactivationTime Time15;
    public static final StrictModeDeactivationTime Time30;

    /* JADX INFO: renamed from: default, reason: not valid java name */
    private static final StrictModeDeactivationTime f40default;
    private final long timeInMinutes;
    public static final StrictModeDeactivationTime Time5 = new StrictModeDeactivationTime("Time5", 0, 5);
    public static final StrictModeDeactivationTime Time10 = new StrictModeDeactivationTime("Time10", 1, 10);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final StrictModeDeactivationTime a(long j3) {
            StrictModeDeactivationTime next;
            Iterator<StrictModeDeactivationTime> it = StrictModeDeactivationTime.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.getTimeInMinutes() == j3) {
                    break;
                }
            }
            StrictModeDeactivationTime strictModeDeactivationTime = next;
            return strictModeDeactivationTime == null ? b() : strictModeDeactivationTime;
        }

        public final StrictModeDeactivationTime b() {
            return StrictModeDeactivationTime.f40default;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ StrictModeDeactivationTime[] $values() {
        return new StrictModeDeactivationTime[]{Time5, Time10, Time15, Time30};
    }

    static {
        StrictModeDeactivationTime strictModeDeactivationTime = new StrictModeDeactivationTime("Time15", 2, 15L);
        Time15 = strictModeDeactivationTime;
        Time30 = new StrictModeDeactivationTime("Time30", 3, 30L);
        StrictModeDeactivationTime[] strictModeDeactivationTimeArr$values = $values();
        $VALUES = strictModeDeactivationTimeArr$values;
        $ENTRIES = EnumEntriesKt.a(strictModeDeactivationTimeArr$values);
        Companion = new Companion(null);
        f40default = strictModeDeactivationTime;
    }

    private StrictModeDeactivationTime(String str, int i3, long j3) {
        this.timeInMinutes = j3;
    }

    public static EnumEntries<StrictModeDeactivationTime> getEntries() {
        return $ENTRIES;
    }

    public static StrictModeDeactivationTime valueOf(String str) {
        return (StrictModeDeactivationTime) Enum.valueOf(StrictModeDeactivationTime.class, str);
    }

    public static StrictModeDeactivationTime[] values() {
        return (StrictModeDeactivationTime[]) $VALUES.clone();
    }

    public final long getTimeInMinutes() {
        return this.timeInMinutes;
    }
}
