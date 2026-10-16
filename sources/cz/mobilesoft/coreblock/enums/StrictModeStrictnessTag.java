package cz.mobilesoft.coreblock.enums;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class StrictModeStrictnessTag {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ StrictModeStrictnessTag[] $VALUES;
    private final int title;
    public static final StrictModeStrictnessTag Easy = new StrictModeStrictnessTag("Easy", 0, R.string.Jc);
    public static final StrictModeStrictnessTag Medium = new StrictModeStrictnessTag("Medium", 1, R.string.Kj);
    public static final StrictModeStrictnessTag Hard = new StrictModeStrictnessTag("Hard", 2, R.string.sf);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f97049a;

        static {
            int[] iArr = new int[StrictModeStrictnessTag.values().length];
            try {
                iArr[StrictModeStrictnessTag.Easy.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StrictModeStrictnessTag.Medium.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StrictModeStrictnessTag.Hard.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f97049a = iArr;
        }
    }

    private static final /* synthetic */ StrictModeStrictnessTag[] $values() {
        return new StrictModeStrictnessTag[]{Easy, Medium, Hard};
    }

    static {
        StrictModeStrictnessTag[] strictModeStrictnessTagArr$values = $values();
        $VALUES = strictModeStrictnessTagArr$values;
        $ENTRIES = EnumEntriesKt.a(strictModeStrictnessTagArr$values);
    }

    private StrictModeStrictnessTag(String str, int i3, int i4) {
        this.title = i4;
    }

    public static EnumEntries<StrictModeStrictnessTag> getEntries() {
        return $ENTRIES;
    }

    public static StrictModeStrictnessTag valueOf(String str) {
        return (StrictModeStrictnessTag) Enum.valueOf(StrictModeStrictnessTag.class, str);
    }

    public static StrictModeStrictnessTag[] values() {
        return (StrictModeStrictnessTag[]) $VALUES.clone();
    }

    public final long getColor(Composer composer, int i3) {
        long jA;
        if (ComposerKt.M()) {
            ComposerKt.U(-1898248096, i3, -1, "cz.mobilesoft.coreblock.enums.StrictModeStrictnessTag.<get-color> (StrictModeAccessMethod.kt:20)");
        }
        int i4 = WhenMappings.f97049a[ordinal()];
        if (i4 == 1) {
            composer.a0(1144682757);
            jA = ComposeColorsKt.j(composer, 0).A();
            composer.U();
        } else if (i4 == 2) {
            composer.a0(1144683878);
            jA = ComposeColorsKt.j(composer, 0).b();
            composer.U();
        } else {
            if (i4 != 3) {
                composer.a0(1144681566);
                composer.U();
                throw new NoWhenBranchMatchedException();
            }
            composer.a0(1144684966);
            jA = ComposeColorsKt.j(composer, 0).a0();
            composer.U();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jA;
    }

    public final int getTitle() {
        return this.title;
    }
}
