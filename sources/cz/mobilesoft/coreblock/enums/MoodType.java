package cz.mobilesoft.coreblock.enums;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
public final class MoodType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MoodType[] $VALUES;
    public static final Companion Companion;
    private static final Lazy<Map<Integer, MoodType>> allById$delegate;
    private final int id;
    private final int nameRes;
    public static final MoodType VeryDistracted = new MoodType("VeryDistracted", 0, 0, R.string.lk);
    public static final MoodType SomewhatDistracted = new MoodType("SomewhatDistracted", 1, 1, R.string.jk);
    public static final MoodType Neutral = new MoodType("Neutral", 2, 2, R.string.gk);
    public static final MoodType SomewhatInControl = new MoodType("SomewhatInControl", 3, 3, R.string.kk);
    public static final MoodType InControl = new MoodType("InControl", 4, 4, R.string.fk);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Map a() {
            return (Map) MoodType.allById$delegate.getValue();
        }

        public final MoodType b(int i3) {
            MoodType moodType = (MoodType) a().get(Integer.valueOf(i3));
            return moodType == null ? MoodType.Neutral : moodType;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Converter {
        public final MoodType a(int i3) {
            return MoodType.Companion.b(i3);
        }

        public final int b(MoodType moodType) {
            Intrinsics.checkNotNullParameter(moodType, "moodType");
            return moodType.getId();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f96990a;

        static {
            int[] iArr = new int[MoodType.values().length];
            try {
                iArr[MoodType.VeryDistracted.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MoodType.SomewhatDistracted.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MoodType.Neutral.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MoodType.SomewhatInControl.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MoodType.InControl.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f96990a = iArr;
        }
    }

    private static final /* synthetic */ MoodType[] $values() {
        return new MoodType[]{VeryDistracted, SomewhatDistracted, Neutral, SomewhatInControl, InControl};
    }

    static {
        MoodType[] moodTypeArr$values = $values();
        $VALUES = moodTypeArr$values;
        $ENTRIES = EnumEntriesKt.a(moodTypeArr$values);
        Companion = new Companion(null);
        allById$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.enums.r
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MoodType.allById_delegate$lambda$0();
            }
        });
    }

    private MoodType(String str, int i3, int i4, int i5) {
        this.id = i4;
        this.nameRes = i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map allById_delegate$lambda$0() {
        EnumEntries<MoodType> entries = getEntries();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entries, 10)), 16));
        for (MoodType moodType : entries) {
            linkedHashMap.put(Integer.valueOf(moodType.id), moodType);
        }
        return linkedHashMap;
    }

    @JvmStatic
    public static final MoodType getById(int i3) {
        return Companion.b(i3);
    }

    public static EnumEntries<MoodType> getEntries() {
        return $ENTRIES;
    }

    public static MoodType valueOf(String str) {
        return (MoodType) Enum.valueOf(MoodType.class, str);
    }

    public static MoodType[] values() {
        return (MoodType[]) $VALUES.clone();
    }

    public final long getColor(Composer composer, int i3) {
        long jU;
        if (ComposerKt.M()) {
            ComposerKt.U(936863611, i3, -1, "cz.mobilesoft.coreblock.enums.MoodType.<get-color> (MoodType.kt:21)");
        }
        int i4 = WhenMappings.f96990a[ordinal()];
        if (i4 == 1) {
            composer.a0(-1617198707);
            jU = ComposeColorsKt.j(composer, 0).U();
            composer.U();
        } else if (i4 == 2) {
            composer.a0(-1617196655);
            jU = ComposeColorsKt.j(composer, 0).S();
            composer.U();
        } else if (i4 == 3) {
            composer.a0(-1617194842);
            jU = ComposeColorsKt.j(composer, 0).R();
            composer.U();
        } else if (i4 == 4) {
            composer.a0(-1617193040);
            jU = ComposeColorsKt.j(composer, 0).T();
            composer.U();
        } else {
            if (i4 != 5) {
                composer.a0(-1617200168);
                composer.U();
                throw new NoWhenBranchMatchedException();
            }
            composer.a0(-1617191192);
            jU = ComposeColorsKt.j(composer, 0).Q();
            composer.U();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jU;
    }

    public final int getId() {
        return this.id;
    }

    public final int getNameRes() {
        return this.nameRes;
    }
}
