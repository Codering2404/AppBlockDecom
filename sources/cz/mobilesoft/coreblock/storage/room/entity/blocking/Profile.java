package cz.mobilesoft.coreblock.storage.room.entity.blocking;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.DayFlags;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.enums.ScheduleEmoji;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.io.Serializable;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class Profile implements Serializable {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Companion f126450y = new Companion(null);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f126451z = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f126452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f126453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f126454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f126455d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f126456f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f126457g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f126458h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f126459i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f126460j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f126461k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f126462l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f126463m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f126464n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f126465o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f126466p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private PausedUntil f126467q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private BlockingMode f126468r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private ScheduleEmoji f126469s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f126470t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f126471u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f126472v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f126473w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private AllowlistWebBrowsingMode f126474x;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AllowlistWebBrowsingMode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AllowlistWebBrowsingMode[] $VALUES;
        public static final Companion Companion;
        private final int id;
        public static final AllowlistWebBrowsingMode Allowed = new AllowlistWebBrowsingMode("Allowed", 0, 0);
        public static final AllowlistWebBrowsingMode NotAllowed = new AllowlistWebBrowsingMode("NotAllowed", 1, 1);
        public static final AllowlistWebBrowsingMode SelectedSites = new AllowlistWebBrowsingMode("SelectedSites", 2, 2);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final AllowlistWebBrowsingMode a(int i3) {
                AllowlistWebBrowsingMode next;
                Iterator<AllowlistWebBrowsingMode> it = AllowlistWebBrowsingMode.getEntries().iterator();
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
                AllowlistWebBrowsingMode allowlistWebBrowsingMode = next;
                return allowlistWebBrowsingMode == null ? AllowlistWebBrowsingMode.Allowed : allowlistWebBrowsingMode;
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Converter {
            public final AllowlistWebBrowsingMode a(int i3) {
                return AllowlistWebBrowsingMode.Companion.a(i3);
            }

            public final int b(AllowlistWebBrowsingMode mode) {
                Intrinsics.checkNotNullParameter(mode, "mode");
                return mode.getId();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final /* synthetic */ class WhenMappings {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f126475a;

            static {
                int[] iArr = new int[AllowlistWebBrowsingMode.values().length];
                try {
                    iArr[AllowlistWebBrowsingMode.Allowed.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AllowlistWebBrowsingMode.NotAllowed.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[AllowlistWebBrowsingMode.SelectedSites.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f126475a = iArr;
            }
        }

        private static final /* synthetic */ AllowlistWebBrowsingMode[] $values() {
            return new AllowlistWebBrowsingMode[]{Allowed, NotAllowed, SelectedSites};
        }

        static {
            AllowlistWebBrowsingMode[] allowlistWebBrowsingModeArr$values = $values();
            $VALUES = allowlistWebBrowsingModeArr$values;
            $ENTRIES = EnumEntriesKt.a(allowlistWebBrowsingModeArr$values);
            Companion = new Companion(null);
        }

        private AllowlistWebBrowsingMode(String str, int i3, int i4) {
            this.id = i4;
        }

        public static EnumEntries<AllowlistWebBrowsingMode> getEntries() {
            return $ENTRIES;
        }

        public static AllowlistWebBrowsingMode valueOf(String str) {
            return (AllowlistWebBrowsingMode) Enum.valueOf(AllowlistWebBrowsingMode.class, str);
        }

        public static AllowlistWebBrowsingMode[] values() {
            return (AllowlistWebBrowsingMode[]) $VALUES.clone();
        }

        public final int getId() {
            return this.id;
        }

        public final int getLabel() {
            int i3 = WhenMappings.f126475a[ordinal()];
            if (i3 == 1) {
                return R.string.f95864z0;
            }
            if (i3 == 2) {
                return R.string.il;
            }
            if (i3 == 3) {
                return R.string.Nv;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class BlockingMode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ BlockingMode[] $VALUES;
        public static final Companion Companion;
        private final int id;
        public static final BlockingMode Blocklist = new BlockingMode("Blocklist", 0, 0);
        public static final BlockingMode Allowlist = new BlockingMode("Allowlist", 1, 1);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final BlockingMode a(int i3) {
                BlockingMode blockingMode;
                BlockingMode[] blockingModeArrValues = BlockingMode.values();
                int length = blockingModeArrValues.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length) {
                        blockingMode = null;
                        break;
                    }
                    blockingMode = blockingModeArrValues[i4];
                    if (blockingMode.getId() == i3) {
                        break;
                    }
                    i4++;
                }
                return blockingMode == null ? BlockingMode.Blocklist : blockingMode;
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Converter {
            public final BlockingMode a(int i3) {
                return BlockingMode.Companion.a(i3);
            }

            public final int b(BlockingMode type) {
                Intrinsics.checkNotNullParameter(type, "type");
                return type.getId();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final /* synthetic */ class WhenMappings {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f126476a;

            static {
                int[] iArr = new int[BlockingMode.values().length];
                try {
                    iArr[BlockingMode.Blocklist.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[BlockingMode.Allowlist.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f126476a = iArr;
            }
        }

        private static final /* synthetic */ BlockingMode[] $values() {
            return new BlockingMode[]{Blocklist, Allowlist};
        }

        static {
            BlockingMode[] blockingModeArr$values = $values();
            $VALUES = blockingModeArr$values;
            $ENTRIES = EnumEntriesKt.a(blockingModeArr$values);
            Companion = new Companion(null);
        }

        private BlockingMode(String str, int i3, int i4) {
            this.id = i4;
        }

        public static EnumEntries<BlockingMode> getEntries() {
            return $ENTRIES;
        }

        public static BlockingMode valueOf(String str) {
            return (BlockingMode) Enum.valueOf(BlockingMode.class, str);
        }

        public static BlockingMode[] values() {
            return (BlockingMode[]) $VALUES.clone();
        }

        public final int getIconRes() {
            int i3 = WhenMappings.f126476a[ordinal()];
            if (i3 == 1) {
                return R.drawable.f95507e1;
            }
            if (i3 == 2) {
                return R.drawable.f95573w0;
            }
            throw new NoWhenBranchMatchedException();
        }

        public final int getId() {
            return this.id;
        }

        public final int getTitleRes() {
            int i3 = WhenMappings.f126476a[ordinal()];
            if (i3 == 1) {
                return R.string.A4;
            }
            if (i3 == 2) {
                return R.string.A0;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class PausedUntil implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f126477a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Converter {
            public final PausedUntil a(long j3) {
                return j3 == 0 ? NotPaused.f126480b : j3 == -1 ? DisabledByUser.f126479b : j3 == -2 ? DisabledByPremium.f126478b : new Time(j3);
            }

            public final long b(PausedUntil pausedUntil) {
                Intrinsics.checkNotNullParameter(pausedUntil, "pausedUntil");
                if (pausedUntil instanceof Time) {
                    return pausedUntil.a();
                }
                if (Intrinsics.areEqual(pausedUntil, DisabledByUser.f126479b)) {
                    return -1L;
                }
                return Intrinsics.areEqual(pausedUntil, DisabledByPremium.f126478b) ? -2L : 0L;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class DisabledByPremium extends PausedUntil {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final DisabledByPremium f126478b = new DisabledByPremium();

            private DisabledByPremium() {
                super(-2L, null);
            }

            private final Object readResolve() {
                return f126478b;
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof DisabledByPremium);
            }

            public int hashCode() {
                return 1629446750;
            }

            public String toString() {
                return "DisabledByPremium";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class DisabledByUser extends PausedUntil {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final DisabledByUser f126479b = new DisabledByUser();

            private DisabledByUser() {
                super(-1L, null);
            }

            private final Object readResolve() {
                return f126479b;
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof DisabledByUser);
            }

            public int hashCode() {
                return -1282331356;
            }

            public String toString() {
                return "DisabledByUser";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class NotPaused extends PausedUntil {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final NotPaused f126480b = new NotPaused();

            private NotPaused() {
                super(0L, null);
            }

            private final Object readResolve() {
                return f126480b;
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof NotPaused);
            }

            public int hashCode() {
                return -1445726373;
            }

            public String toString() {
                return "NotPaused";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Time extends PausedUntil {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final long f126481b;

            public Time(long j3) {
                super(j3, null);
                this.f126481b = j3;
            }

            public final long b() {
                return this.f126481b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Time) && this.f126481b == ((Time) obj).f126481b;
            }

            public int hashCode() {
                return Long.hashCode(this.f126481b);
            }

            public String toString() {
                return "Time(until=" + this.f126481b + ")";
            }
        }

        public /* synthetic */ PausedUntil(long j3, DefaultConstructorMarker defaultConstructorMarker) {
            this(j3);
        }

        public final long a() {
            return this.f126477a;
        }

        private PausedUntil(long j3) {
            this.f126477a = j3;
        }
    }

    public Profile(long j3, String title, int i3, int i4, int i5, int i6, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, long j4, long j5, long j6, long j7, PausedUntil pausedUntil, BlockingMode blockingMode, ScheduleEmoji emoji, boolean z7, boolean z8, boolean z9, int i7, AllowlistWebBrowsingMode webBrowsingMode) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(pausedUntil, "pausedUntil");
        Intrinsics.checkNotNullParameter(blockingMode, "blockingMode");
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        Intrinsics.checkNotNullParameter(webBrowsingMode, "webBrowsingMode");
        this.f126452a = j3;
        this.f126453b = title;
        this.f126454c = i3;
        this.f126455d = i4;
        this.f126456f = i5;
        this.f126457g = i6;
        this.f126458h = z2;
        this.f126459i = z3;
        this.f126460j = z4;
        this.f126461k = z5;
        this.f126462l = z6;
        this.f126463m = j4;
        this.f126464n = j5;
        this.f126465o = j6;
        this.f126466p = j7;
        this.f126467q = pausedUntil;
        this.f126468r = blockingMode;
        this.f126469s = emoji;
        this.f126470t = z7;
        this.f126471u = z8;
        this.f126472v = z9;
        this.f126473w = i7;
        this.f126474x = webBrowsingMode;
    }

    public static /* synthetic */ Profile h(Profile profile, long j3, String str, int i3, int i4, int i5, int i6, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, long j4, long j5, long j6, long j7, PausedUntil pausedUntil, BlockingMode blockingMode, ScheduleEmoji scheduleEmoji, boolean z7, boolean z8, boolean z9, int i7, AllowlistWebBrowsingMode allowlistWebBrowsingMode, int i8, Object obj) {
        AllowlistWebBrowsingMode allowlistWebBrowsingMode2;
        int i9;
        long j8 = (i8 & 1) != 0 ? profile.f126452a : j3;
        String str2 = (i8 & 2) != 0 ? profile.f126453b : str;
        int i10 = (i8 & 4) != 0 ? profile.f126454c : i3;
        int i11 = (i8 & 8) != 0 ? profile.f126455d : i4;
        int i12 = (i8 & 16) != 0 ? profile.f126456f : i5;
        int i13 = (i8 & 32) != 0 ? profile.f126457g : i6;
        boolean z10 = (i8 & 64) != 0 ? profile.f126458h : z2;
        boolean z11 = (i8 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? profile.f126459i : z3;
        boolean z12 = (i8 & Function.MAX_NARGS) != 0 ? profile.f126460j : z4;
        boolean z13 = (i8 & 512) != 0 ? profile.f126461k : z5;
        boolean z14 = (i8 & 1024) != 0 ? profile.f126462l : z6;
        long j9 = (i8 & 2048) != 0 ? profile.f126463m : j4;
        long j10 = j8;
        long j11 = (i8 & 4096) != 0 ? profile.f126464n : j5;
        long j12 = (i8 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? profile.f126465o : j6;
        long j13 = (i8 & 16384) != 0 ? profile.f126466p : j7;
        PausedUntil pausedUntil2 = (i8 & 32768) != 0 ? profile.f126467q : pausedUntil;
        BlockingMode blockingMode2 = (i8 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? profile.f126468r : blockingMode;
        ScheduleEmoji scheduleEmoji2 = (i8 & 131072) != 0 ? profile.f126469s : scheduleEmoji;
        boolean z15 = (i8 & 262144) != 0 ? profile.f126470t : z7;
        boolean z16 = (i8 & 524288) != 0 ? profile.f126471u : z8;
        boolean z17 = (i8 & 1048576) != 0 ? profile.f126472v : z9;
        int i14 = (i8 & 2097152) != 0 ? profile.f126473w : i7;
        if ((i8 & 4194304) != 0) {
            i9 = i14;
            allowlistWebBrowsingMode2 = profile.f126474x;
        } else {
            allowlistWebBrowsingMode2 = allowlistWebBrowsingMode;
            i9 = i14;
        }
        return profile.g(j10, str2, i10, i11, i12, i13, z10, z11, z12, z13, z14, j9, j11, j12, j13, pausedUntil2, blockingMode2, scheduleEmoji2, z15, z16, z17, i9, allowlistWebBrowsingMode2);
    }

    public final String A() {
        return this.f126453b;
    }

    public final ProfileType B() {
        return C(false);
    }

    public final ProfileType C(boolean z2) {
        return ProfileType.Companion.a(this.f126454c, z2);
    }

    public final int D(boolean z2) {
        int iBitCount = Integer.bitCount(this.f126454c);
        return (z2 || !S()) ? iBitCount : iBitCount - 1;
    }

    public final int E() {
        return this.f126454c;
    }

    public final AllowlistWebBrowsingMode F() {
        return this.f126474x;
    }

    public final boolean G() {
        return (P() || Q()) && !H();
    }

    public final boolean H() {
        return J() || this.f126467q.a() > TimeHelperExt.f128663a.f();
    }

    public final boolean I(DayFlags dayFlags) {
        Intrinsics.checkNotNullParameter(dayFlags, "dayFlags");
        return (dayFlags.getValue() & this.f126457g) > 0;
    }

    public final boolean J() {
        PausedUntil pausedUntil = this.f126467q;
        return (pausedUntil instanceof PausedUntil.DisabledByUser) || (pausedUntil instanceof PausedUntil.DisabledByPremium);
    }

    public final boolean K() {
        return this.f126461k;
    }

    public final boolean L() {
        return this.f126462l;
    }

    public final boolean M(boolean z2) {
        return z2 && this.f126466p < TimeHelperExt.f128663a.f();
    }

    public final boolean N(int i3) {
        return (i3 & this.f126455d) != 0;
    }

    public final boolean P() {
        int i3 = this.f126456f;
        if (i3 != 0) {
            return i3 == 1 && (this.f126455d & this.f126454c) > 0;
        }
        int i4 = this.f126454c;
        ProfileType profileType = ProfileType.STRICT_MODE;
        return (i4 == profileType.mask() || ((this.f126454c & (~ProfileType.TIME.mask())) & (~profileType.mask())) != 0) && this.f126455d == this.f126454c;
    }

    public final boolean Q() {
        return this.f126464n > TimeHelperExt.f128663a.f();
    }

    public final boolean R() {
        return this.f126454c == 64;
    }

    public final boolean S() {
        return (this.f126454c & ProfileType.STRICT_MODE.mask()) != 0;
    }

    public final boolean T(int i3) {
        return (i3 & this.f126454c) != 0;
    }

    public final boolean U(ProfileType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return T(type.mask());
    }

    public final void V(boolean z2) {
        this.f126460j = z2;
    }

    public final void W(boolean z2) {
        this.f126471u = z2;
    }

    public final void X(boolean z2) {
        this.f126472v = z2;
    }

    public final void Y(boolean z2) {
        this.f126459i = z2;
    }

    public final void Z(boolean z2) {
        this.f126458h = z2;
    }

    public final void a(int i3) {
        this.f126455d = i3 | this.f126455d;
    }

    public final void a0(boolean z2) {
        this.f126470t = z2;
    }

    public final void b(int i3) {
        this.f126454c = i3 | this.f126454c;
    }

    public final void b0(BlockingMode blockingMode) {
        Intrinsics.checkNotNullParameter(blockingMode, "<set-?>");
        this.f126468r = blockingMode;
    }

    public final void c(ProfileType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        b(type.mask());
    }

    public final void c0(int i3) {
        this.f126457g = i3;
    }

    public final void d(int i3) {
        this.f126455d = (~i3) & this.f126455d;
    }

    public final void d0(ScheduleEmoji scheduleEmoji) {
        Intrinsics.checkNotNullParameter(scheduleEmoji, "<set-?>");
        this.f126469s = scheduleEmoji;
    }

    public final void e(int i3) {
        this.f126454c &= ~i3;
        d(i3);
    }

    public final void e0() {
        this.f126466p = TimeHelperExt.f128663a.f() + 60000;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Profile)) {
            return false;
        }
        Profile profile = (Profile) obj;
        return this.f126452a == profile.f126452a && Intrinsics.areEqual(this.f126453b, profile.f126453b) && this.f126454c == profile.f126454c && this.f126455d == profile.f126455d && this.f126456f == profile.f126456f && this.f126457g == profile.f126457g && this.f126458h == profile.f126458h && this.f126459i == profile.f126459i && this.f126460j == profile.f126460j && this.f126461k == profile.f126461k && this.f126462l == profile.f126462l && this.f126463m == profile.f126463m && this.f126464n == profile.f126464n && this.f126465o == profile.f126465o && this.f126466p == profile.f126466p && Intrinsics.areEqual(this.f126467q, profile.f126467q) && this.f126468r == profile.f126468r && this.f126469s == profile.f126469s && this.f126470t == profile.f126470t && this.f126471u == profile.f126471u && this.f126472v == profile.f126472v && this.f126473w == profile.f126473w && this.f126474x == profile.f126474x;
    }

    public final void f(ProfileType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        e(type.mask());
    }

    public final void f0(long j3) {
        this.f126452a = j3;
    }

    public final Profile g(long j3, String title, int i3, int i4, int i5, int i6, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, long j4, long j5, long j6, long j7, PausedUntil pausedUntil, BlockingMode blockingMode, ScheduleEmoji emoji, boolean z7, boolean z8, boolean z9, int i7, AllowlistWebBrowsingMode webBrowsingMode) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(pausedUntil, "pausedUntil");
        Intrinsics.checkNotNullParameter(blockingMode, "blockingMode");
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        Intrinsics.checkNotNullParameter(webBrowsingMode, "webBrowsingMode");
        return new Profile(j3, title, i3, i4, i5, i6, z2, z3, z4, z5, z6, j4, j5, j6, j7, pausedUntil, blockingMode, emoji, z7, z8, z9, i7, webBrowsingMode);
    }

    public final void h0(long j3) {
        this.f126463m = j3;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((Long.hashCode(this.f126452a) * 31) + this.f126453b.hashCode()) * 31) + Integer.hashCode(this.f126454c)) * 31) + Integer.hashCode(this.f126455d)) * 31) + Integer.hashCode(this.f126456f)) * 31) + Integer.hashCode(this.f126457g)) * 31) + Boolean.hashCode(this.f126458h)) * 31) + Boolean.hashCode(this.f126459i)) * 31) + Boolean.hashCode(this.f126460j)) * 31) + Boolean.hashCode(this.f126461k)) * 31) + Boolean.hashCode(this.f126462l)) * 31) + Long.hashCode(this.f126463m)) * 31) + Long.hashCode(this.f126464n)) * 31) + Long.hashCode(this.f126465o)) * 31) + Long.hashCode(this.f126466p)) * 31) + this.f126467q.hashCode()) * 31) + this.f126468r.hashCode()) * 31) + this.f126469s.hashCode()) * 31) + Boolean.hashCode(this.f126470t)) * 31) + Boolean.hashCode(this.f126471u)) * 31) + Boolean.hashCode(this.f126472v)) * 31) + Integer.hashCode(this.f126473w)) * 31) + this.f126474x.hashCode();
    }

    public final boolean i() {
        return this.f126460j;
    }

    public final void i0(long j3) {
        this.f126466p = j3;
    }

    public final boolean j() {
        return this.f126471u;
    }

    public final void j0(boolean z2) {
        this.f126462l = z2;
    }

    public final boolean k() {
        return this.f126472v;
    }

    public final void k0(long j3) {
        this.f126465o = j3;
    }

    public final boolean l() {
        return this.f126459i;
    }

    public final void l0(int i3) {
        this.f126455d = i3;
    }

    public final boolean m() {
        return this.f126458h;
    }

    public final void m0(long j3) {
        this.f126464n = j3;
    }

    public final boolean n() {
        return this.f126470t;
    }

    public final void n0(int i3) {
        this.f126456f = i3;
    }

    public final BlockingMode o() {
        return this.f126468r;
    }

    public final void o0(PausedUntil pausedUntil) {
        Intrinsics.checkNotNullParameter(pausedUntil, "<set-?>");
        this.f126467q = pausedUntil;
    }

    public final int p() {
        return this.f126457g;
    }

    public final void p0(int i3) {
        this.f126473w = i3;
    }

    public final ScheduleEmoji q() {
        return this.f126469s;
    }

    public final void q0(boolean z2) {
        if (z2) {
            int i3 = this.f126454c;
            ProfileType profileType = ProfileType.STRICT_MODE;
            this.f126454c = i3 | profileType.mask();
            this.f126455d |= profileType.mask();
            return;
        }
        int i4 = this.f126454c;
        ProfileType profileType2 = ProfileType.STRICT_MODE;
        this.f126454c = i4 & (~profileType2.mask());
        this.f126455d &= ~profileType2.mask();
    }

    public final long r() {
        return this.f126452a;
    }

    public final void r0(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f126453b = str;
    }

    public final long s() {
        return this.f126463m;
    }

    public final void s0(ProfileType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (type == ProfileType.COMBINED) {
            throw new IllegalArgumentException("Cannot set type to ProfileType.COMBINED, use setTypeCombinations() and setOperator() instead!");
        }
        this.f126454c = type.mask();
        this.f126455d = 0;
        this.f126456f = 0;
    }

    public final long t() {
        return this.f126466p;
    }

    public final void t0(int i3) {
        this.f126454c = i3;
    }

    public String toString() {
        return "Profile(id=" + this.f126452a + ", title='" + this.f126453b + "', typeCombinations=" + this.f126454c + ", onConditions=" + this.f126455d + ", operator=" + this.f126456f + ", dayFlags=" + this.f126457g + ", blockNotifications=" + this.f126458h + ", blockLaunch=" + this.f126459i + ", addNewApplications=" + this.f126460j + ", isEnabled=" + this.f126461k + ", isLocked=" + this.f126462l + ", lastStartTime=" + this.f126463m + ", onUntil=" + this.f126464n + ", lockedUntil=" + this.f126465o + ", lockAt=" + this.f126466p + ", pausedUntil=" + this.f126467q + ", blockingMode=" + this.f126468r + ", emoji=" + this.f126469s + ", blockUnsupportedBrowsers=" + this.f126470t + ", blockAdultContent=" + this.f126471u + ", blockInAppPurchases=" + this.f126472v + ")";
    }

    public final long u() {
        return this.f126465o;
    }

    public final void u0(AllowlistWebBrowsingMode allowlistWebBrowsingMode) {
        Intrinsics.checkNotNullParameter(allowlistWebBrowsingMode, "<set-?>");
        this.f126474x = allowlistWebBrowsingMode;
    }

    public final int v() {
        return this.f126455d;
    }

    public final void v0(long j3) {
        this.f126464n = j3;
        if (j3 != 0) {
            this.f126463m = TimeHelperExt.f128663a.f();
        }
    }

    public final long w() {
        return this.f126464n;
    }

    public final int x() {
        return this.f126456f;
    }

    public final PausedUntil y() {
        return this.f126467q;
    }

    public final int z() {
        return this.f126473w;
    }

    public /* synthetic */ Profile(long j3, String str, int i3, int i4, int i5, int i6, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, long j4, long j5, long j6, long j7, PausedUntil pausedUntil, BlockingMode blockingMode, ScheduleEmoji scheduleEmoji, boolean z7, boolean z8, boolean z9, int i7, AllowlistWebBrowsingMode allowlistWebBrowsingMode, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? 0L : j3, (i8 & 2) != 0 ? "" : str, (i8 & 4) != 0 ? 0 : i3, (i8 & 8) != 0 ? 0 : i4, (i8 & 16) != 0 ? 0 : i5, (i8 & 32) != 0 ? DayFlags.Companion.a() : i6, (i8 & 64) != 0 ? true : z2, (i8 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0 ? z3 : true, (i8 & Function.MAX_NARGS) != 0 ? false : z4, (i8 & 512) != 0 ? false : z5, (i8 & 1024) != 0 ? false : z6, (i8 & 2048) != 0 ? 0L : j4, (i8 & 4096) != 0 ? 0L : j5, (i8 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? 0L : j6, (i8 & 16384) != 0 ? 0L : j7, (32768 & i8) != 0 ? PausedUntil.NotPaused.f126480b : pausedUntil, (i8 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? BlockingMode.Blocklist : blockingMode, (i8 & 131072) != 0 ? ScheduleEmoji.NoIcon : scheduleEmoji, (i8 & 262144) != 0 ? false : z7, (i8 & 524288) != 0 ? false : z8, (i8 & 1048576) != 0 ? false : z9, (i8 & 2097152) != 0 ? 0 : i7, (i8 & 4194304) != 0 ? AllowlistWebBrowsingMode.Allowed : allowlistWebBrowsingMode);
    }
}
