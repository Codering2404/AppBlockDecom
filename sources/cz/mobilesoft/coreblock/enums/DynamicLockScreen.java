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
public final class DynamicLockScreen {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DynamicLockScreen[] $VALUES;
    public static final Companion Companion;
    private static final Lazy<List<DynamicLockScreen>> lockScreens$delegate;
    private final int emojiResId;
    private final int titleResId;
    public static final DynamicLockScreen Procrastination = new DynamicLockScreen("Procrastination", 0, R.string.L3, R.drawable.s9);
    public static final DynamicLockScreen Napping = new DynamicLockScreen("Napping", 1, R.string.z3, R.drawable.xa);
    public static final DynamicLockScreen Victory = new DynamicLockScreen("Victory", 2, R.string.O3, R.drawable.ob);
    public static final DynamicLockScreen RockNRoll = new DynamicLockScreen("RockNRoll", 3, R.string.M3, R.drawable.M8);
    public static final DynamicLockScreen StayFocused = new DynamicLockScreen("StayFocused", 4, R.string.N3, R.drawable.u8);
    public static final DynamicLockScreen Goals = new DynamicLockScreen("Goals", 5, R.string.D3, R.drawable.H9);
    public static final DynamicLockScreen Awesome = new DynamicLockScreen("Awesome", 6, R.string.A3, R.drawable.f95515g1);
    public static final DynamicLockScreen Focus = new DynamicLockScreen("Focus", 7, R.string.C3, R.drawable.f95575x);
    public static final DynamicLockScreen WrongTurn = new DynamicLockScreen("WrongTurn", 8, R.string.P3, R.drawable.L8);
    public static final DynamicLockScreen ProcrastinationBlocked = new DynamicLockScreen("ProcrastinationBlocked", 9, R.string.K3, R.drawable.L);
    public static final DynamicLockScreen Nope = new DynamicLockScreen("Nope", 10, R.string.F3, R.drawable.r8);
    public static final DynamicLockScreen Champ = new DynamicLockScreen("Champ", 11, R.string.B3, R.drawable.F9);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final List a() {
            return (List) DynamicLockScreen.lockScreens$delegate.getValue();
        }

        public final DynamicLockScreen b() {
            DynamicLockScreen dynamicLockScreen = (DynamicLockScreen) a().remove(0);
            a().add(dynamicLockScreen);
            return dynamicLockScreen;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ DynamicLockScreen[] $values() {
        return new DynamicLockScreen[]{Procrastination, Napping, Victory, RockNRoll, StayFocused, Goals, Awesome, Focus, WrongTurn, ProcrastinationBlocked, Nope, Champ};
    }

    static {
        DynamicLockScreen[] dynamicLockScreenArr$values = $values();
        $VALUES = dynamicLockScreenArr$values;
        $ENTRIES = EnumEntriesKt.a(dynamicLockScreenArr$values);
        Companion = new Companion(null);
        lockScreens$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.enums.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DynamicLockScreen.lockScreens_delegate$lambda$0();
            }
        });
    }

    private DynamicLockScreen(String str, int i3, int i4, int i5) {
        this.titleResId = i4;
        this.emojiResId = i5;
    }

    public static EnumEntries<DynamicLockScreen> getEntries() {
        return $ENTRIES;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List lockScreens_delegate$lambda$0() {
        return CollectionsKt.toMutableList((Collection) getEntries());
    }

    public static DynamicLockScreen valueOf(String str) {
        return (DynamicLockScreen) Enum.valueOf(DynamicLockScreen.class, str);
    }

    public static DynamicLockScreen[] values() {
        return (DynamicLockScreen[]) $VALUES.clone();
    }

    public final int getEmojiResId() {
        return this.emojiResId;
    }

    public final int getTitleResId() {
        return this.titleResId;
    }
}
