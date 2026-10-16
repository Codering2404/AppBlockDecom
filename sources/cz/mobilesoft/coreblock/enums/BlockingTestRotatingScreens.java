package cz.mobilesoft.coreblock.enums;

import cz.mobilesoft.coreblock.LockieApplication;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
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
public final class BlockingTestRotatingScreens {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BlockingTestRotatingScreens[] $VALUES;
    public static final BlockingTestRotatingScreens CloseEyes;
    public static final Companion Companion;
    public static final BlockingTestRotatingScreens DeepWork;
    public static final BlockingTestRotatingScreens Hug;
    public static final BlockingTestRotatingScreens Reading;
    public static final BlockingTestRotatingScreens Study;
    private static final Lazy<List<BlockingTestRotatingScreens>> lockScreens$delegate;
    private final LockScreenColor backgroundColor;
    private final Integer customMessage;
    private final ScheduleEmoji emoji;
    private final int profileName;
    private final int title;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final List a() {
            return (List) BlockingTestRotatingScreens.lockScreens$delegate.getValue();
        }

        public final BlockingTestRotatingScreens b() {
            BlockingTestRotatingScreens blockingTestRotatingScreens = (BlockingTestRotatingScreens) a().remove(0);
            a().add(blockingTestRotatingScreens);
            return blockingTestRotatingScreens;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ BlockingTestRotatingScreens[] $values() {
        return new BlockingTestRotatingScreens[]{Hug, CloseEyes, DeepWork, Reading, Study};
    }

    static {
        int i3 = R.string.J3;
        int i4 = R.string.Ej;
        ScheduleEmoji scheduleEmoji = ScheduleEmoji.Heart;
        LockScreenColor lockScreenColor = LockScreenColor.DarkBlue;
        Hug = new BlockingTestRotatingScreens("Hug", 0, i3, null, i4, scheduleEmoji, lockScreenColor);
        CloseEyes = new BlockingTestRotatingScreens("CloseEyes", 1, R.string.P7, Integer.valueOf(R.string.Xw), R.string.e3, ScheduleEmoji.Bed, LockScreenColor.PurpleVariant2);
        DeepWork = new BlockingTestRotatingScreens("DeepWork", 2, R.string.TE, Integer.valueOf(R.string.Cv), R.string.m9, ScheduleEmoji.Checkmark, LockScreenColor.GreenVariant);
        Reading = new BlockingTestRotatingScreens("Reading", 3, R.string.D4, null, R.string.Jj, ScheduleEmoji.BooksTwo, lockScreenColor);
        Study = new BlockingTestRotatingScreens("Study", 4, R.string.Rd, Integer.valueOf(R.string.O7), R.string.XB, ScheduleEmoji.School, LockScreenColor.PurpleVariant1);
        BlockingTestRotatingScreens[] blockingTestRotatingScreensArr$values = $values();
        $VALUES = blockingTestRotatingScreensArr$values;
        $ENTRIES = EnumEntriesKt.a(blockingTestRotatingScreensArr$values);
        Companion = new Companion(null);
        lockScreens$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.enums.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BlockingTestRotatingScreens.lockScreens_delegate$lambda$0();
            }
        });
    }

    private BlockingTestRotatingScreens(String str, int i3, int i4, Integer num, int i5, ScheduleEmoji scheduleEmoji, LockScreenColor lockScreenColor) {
        this.title = i4;
        this.customMessage = num;
        this.profileName = i5;
        this.emoji = scheduleEmoji;
        this.backgroundColor = lockScreenColor;
    }

    public static EnumEntries<BlockingTestRotatingScreens> getEntries() {
        return $ENTRIES;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List lockScreens_delegate$lambda$0() {
        return CollectionsKt.toMutableList((Collection) getEntries());
    }

    public static BlockingTestRotatingScreens valueOf(String str) {
        return (BlockingTestRotatingScreens) Enum.valueOf(BlockingTestRotatingScreens.class, str);
    }

    public static BlockingTestRotatingScreens[] values() {
        return (BlockingTestRotatingScreens[]) $VALUES.clone();
    }

    public final LockScreenColor getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getBlockedAppText() {
        String string = LockieApplication.g().getString(R.string.CH, CollectionsKt.random(CollectionsKt.listOf((Object[]) new String[]{"YouTube", "Instagram", "TikTok", "Messenger", "Threads"}), Random.f140182a));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public final String getCounterText() {
        IntRange intRange = new IntRange(2, 8);
        Random.Default r12 = Random.f140182a;
        int iW = RangesKt.w(intRange, r12);
        String string = LockieApplication.g().getString(R.string.c4, Integer.valueOf(iW), Integer.valueOf(RangesKt.w(new IntRange(iW, 69), r12)));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public final Integer getCustomMessage() {
        return this.customMessage;
    }

    public final ScheduleEmoji getEmoji() {
        return this.emoji;
    }

    public final int getProfileName() {
        return this.profileName;
    }

    public final int getTitle() {
        return this.title;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity toCustomBlockingScreenEntity() {
        /*
            r19 = this;
            r0 = r19
            android.content.Context r1 = cz.mobilesoft.coreblock.LockieApplication.g()
            int r2 = cz.mobilesoft.coreblock.R.string.W3
            int r3 = r0.profileName
            java.lang.String r3 = r1.getString(r3)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "\""
            r4.append(r5)
            r4.append(r3)
            r4.append(r5)
            java.lang.String r3 = r4.toString()
            java.lang.Object[] r3 = new java.lang.Object[]{r3}
            java.lang.String r2 = r1.getString(r2, r3)
            java.lang.String r3 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.lang.Integer r4 = r0.customMessage
            if (r4 == 0) goto L49
            int r4 = r4.intValue()
            java.lang.String r4 = r1.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r3)
            java.lang.String r5 = "\n\n"
            java.lang.String r4 = cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt.p(r4, r2, r5)
            if (r4 != 0) goto L47
            goto L49
        L47:
            r14 = r4
            goto L4a
        L49:
            r14 = r2
        L4a:
            cz.mobilesoft.coreblock.storage.room.entity.core.ConfigType r7 = cz.mobilesoft.coreblock.storage.room.entity.core.ConfigType.CUSTOM
            int r2 = r0.title
            java.lang.String r13 = r1.getString(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r3)
            cz.mobilesoft.coreblock.enums.ScheduleEmoji r1 = r0.emoji
            int r12 = r1.getId()
            cz.mobilesoft.coreblock.enums.LockScreenColor r1 = r0.backgroundColor
            java.lang.String r16 = r1.getHex()
            cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity r5 = new cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity
            r17 = 573(0x23d, float:8.03E-43)
            r18 = 0
            r6 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r15 = 0
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.enums.BlockingTestRotatingScreens.toCustomBlockingScreenEntity():cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity");
    }
}
