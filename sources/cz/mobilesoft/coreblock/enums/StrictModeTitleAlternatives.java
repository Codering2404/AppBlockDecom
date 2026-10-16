package cz.mobilesoft.coreblock.enums;

import cz.mobilesoft.coreblock.R;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
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
public final class StrictModeTitleAlternatives {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ StrictModeTitleAlternatives[] $VALUES;
    public static final Companion Companion;
    private static final Lazy<List<StrictModeTitleAlternatives>> strings$delegate;
    private final int title;
    public static final StrictModeTitleAlternatives Main = new StrictModeTitleAlternatives("Main", 0, R.string.QD);
    public static final StrictModeTitleAlternatives First = new StrictModeTitleAlternatives("First", 1, R.string.Ax);
    public static final StrictModeTitleAlternatives Second = new StrictModeTitleAlternatives("Second", 2, R.string.Bx);
    public static final StrictModeTitleAlternatives Third = new StrictModeTitleAlternatives("Third", 3, R.string.Cx);
    public static final StrictModeTitleAlternatives Fourth = new StrictModeTitleAlternatives("Fourth", 4, R.string.Dx);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final List b() {
            return (List) StrictModeTitleAlternatives.strings$delegate.getValue();
        }

        public final int a() {
            StrictModeTitleAlternatives strictModeTitleAlternatives = (StrictModeTitleAlternatives) b().remove(0);
            b().add(strictModeTitleAlternatives);
            return strictModeTitleAlternatives.getTitle();
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ StrictModeTitleAlternatives[] $values() {
        return new StrictModeTitleAlternatives[]{Main, First, Second, Third, Fourth};
    }

    static {
        StrictModeTitleAlternatives[] strictModeTitleAlternativesArr$values = $values();
        $VALUES = strictModeTitleAlternativesArr$values;
        $ENTRIES = EnumEntriesKt.a(strictModeTitleAlternativesArr$values);
        Companion = new Companion(null);
        strings$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.enums.y0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StrictModeTitleAlternatives.strings_delegate$lambda$0();
            }
        });
    }

    private StrictModeTitleAlternatives(String str, int i3, int i4) {
        this.title = i4;
    }

    public static EnumEntries<StrictModeTitleAlternatives> getEntries() {
        return $ENTRIES;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List strings_delegate$lambda$0() {
        return CollectionsKt.toMutableList((Collection) getEntries());
    }

    public static StrictModeTitleAlternatives valueOf(String str) {
        return (StrictModeTitleAlternatives) Enum.valueOf(StrictModeTitleAlternatives.class, str);
    }

    public static StrictModeTitleAlternatives[] values() {
        return (StrictModeTitleAlternatives[]) $VALUES.clone();
    }

    public final int getTitle() {
        return this.title;
    }
}
