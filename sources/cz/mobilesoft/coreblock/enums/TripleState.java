package cz.mobilesoft.coreblock.enums;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class TripleState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TripleState[] $VALUES;
    public static final Companion Companion;
    public static final TripleState True = new TripleState("True", 0);
    public static final TripleState False = new TripleState("False", 1);
    public static final TripleState Unset = new TripleState("Unset", 2);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TripleState a(String value) {
            TripleState next;
            Intrinsics.checkNotNullParameter(value, "value");
            Iterator<TripleState> it = TripleState.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics.areEqual(next.name(), value)) {
                    break;
                }
            }
            TripleState tripleState = next;
            return tripleState == null ? TripleState.Unset : tripleState;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ TripleState[] $values() {
        return new TripleState[]{True, False, Unset};
    }

    static {
        TripleState[] tripleStateArr$values = $values();
        $VALUES = tripleStateArr$values;
        $ENTRIES = EnumEntriesKt.a(tripleStateArr$values);
        Companion = new Companion(null);
    }

    private TripleState(String str, int i3) {
    }

    public static EnumEntries<TripleState> getEntries() {
        return $ENTRIES;
    }

    public static TripleState valueOf(String str) {
        return (TripleState) Enum.valueOf(TripleState.class, str);
    }

    public static TripleState[] values() {
        return (TripleState[]) $VALUES.clone();
    }
}
