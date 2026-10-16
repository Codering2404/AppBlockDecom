package cz.mobilesoft.coreblock.enums;

import androidx.compose.ui.graphics.ColorKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
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
public final class ScheduleEmoji implements SelectableIcon {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ScheduleEmoji[] $VALUES;
    public static final ScheduleEmoji Accounting;

    @Deprecated
    public static final ScheduleEmoji Alarm;
    public static final ScheduleEmoji AppBLock;
    public static final ScheduleEmoji Apple;
    public static final ScheduleEmoji Bank;
    public static final ScheduleEmoji Basketball;
    public static final ScheduleEmoji Bat;
    public static final ScheduleEmoji Beach;
    public static final ScheduleEmoji BeachBall;
    public static final ScheduleEmoji Bear;
    public static final ScheduleEmoji Bed;
    public static final ScheduleEmoji Bicycle;
    public static final ScheduleEmoji BlockApp;
    public static final ScheduleEmoji BookShelf;
    public static final ScheduleEmoji Books;
    public static final ScheduleEmoji BooksTwo;
    public static final ScheduleEmoji Brain;
    public static final ScheduleEmoji Briefcase;
    public static final ScheduleEmoji Calendar;
    public static final ScheduleEmoji Car;
    public static final ScheduleEmoji Cat;
    public static final ScheduleEmoji Certificate;
    public static final ScheduleEmoji Chart;
    public static final ScheduleEmoji Chat;
    public static final ScheduleEmoji Checkmark;
    public static final ScheduleEmoji Cheesecake;
    public static final ScheduleEmoji Classroom;
    public static final ScheduleEmoji Cleaning;
    public static final ScheduleEmoji Clock;
    public static final ScheduleEmoji Coding;
    public static final ScheduleEmoji CoinWallet;
    public static final ScheduleEmoji ColorPalette;
    public static final Companion Companion;
    public static final ScheduleEmoji Confetti;
    public static final ScheduleEmoji Corn;
    public static final ScheduleEmoji Counter;
    public static final ScheduleEmoji Countryside;

    @Deprecated
    public static final ScheduleEmoji CrossMark;
    public static final ScheduleEmoji CustomBlockingAppIcon;
    public static final ScheduleEmoji Cutlery;
    public static final ScheduleEmoji Discount;
    public static final ScheduleEmoji DogBone;
    public static final ScheduleEmoji Dumbbell;
    public static final ScheduleEmoji Factory;
    public static final ScheduleEmoji Feet;
    public static final ScheduleEmoji Finish;
    public static final ScheduleEmoji FireExtinguisher;
    public static final ScheduleEmoji Football;
    public static final ScheduleEmoji Forest;
    public static final ScheduleEmoji Game;
    public static final ScheduleEmoji Gas;
    public static final ScheduleEmoji GiveLove;
    public static final ScheduleEmoji Goal;
    public static final ScheduleEmoji Guitar;
    public static final ScheduleEmoji HandHeart;
    public static final ScheduleEmoji Headphones;
    public static final ScheduleEmoji Heart;
    public static final ScheduleEmoji Home;
    public static final ScheduleEmoji Hourglass;
    public static final ScheduleEmoji Idea;
    public static final ScheduleEmoji Journal;
    public static final ScheduleEmoji Laptop;
    public static final ScheduleEmoji Leaf;
    public static final ScheduleEmoji Location;
    public static final ScheduleEmoji Lock;
    public static final ScheduleEmoji Lotus;
    public static final ScheduleEmoji Luck;
    public static final ScheduleEmoji Map;
    public static final ScheduleEmoji Math;
    public static final ScheduleEmoji Meditation;
    public static final ScheduleEmoji Megaphone;
    public static final ScheduleEmoji MinusMark;
    public static final ScheduleEmoji MoneyMouth;
    public static final ScheduleEmoji Mountains;
    public static final ScheduleEmoji Music;
    public static final ScheduleEmoji News;
    public static final ScheduleEmoji Night;
    public static final ScheduleEmoji NoIcon = new ScheduleEmoji("NoIcon", 0, -1, null, false, null, null, 28, null);
    public static final ScheduleEmoji NoSee;
    public static final ScheduleEmoji OkHand;
    public static final ScheduleEmoji Pen;
    public static final ScheduleEmoji Pizza;
    public static final ScheduleEmoji Plane;
    public static final ScheduleEmoji Playground;
    public static final ScheduleEmoji Poo;
    public static final ScheduleEmoji Puzzle;
    public static final ScheduleEmoji PuzzlePieces;
    public static final ScheduleEmoji Restrict;
    public static final ScheduleEmoji Rocket;

    @Deprecated
    public static final ScheduleEmoji RoundLock;
    public static final ScheduleEmoji RuckSack;
    public static final ScheduleEmoji Ruler;
    public static final ScheduleEmoji Sakura;
    public static final ScheduleEmoji SalatBowl;
    public static final ScheduleEmoji School;
    public static final ScheduleEmoji SchoolBuilding;
    public static final ScheduleEmoji Shield;
    public static final ScheduleEmoji Shopaholic;
    public static final ScheduleEmoji ShushingFace;
    public static final ScheduleEmoji Skull;
    public static final ScheduleEmoji Sleep;

    @Deprecated
    public static final ScheduleEmoji Sleeping;
    public static final ScheduleEmoji SnowFlake;
    public static final ScheduleEmoji Sofa;
    public static final ScheduleEmoji Star;
    public static final ScheduleEmoji Stars;
    public static final ScheduleEmoji Stones;
    public static final ScheduleEmoji Stop;
    public static final ScheduleEmoji Strawberry;
    public static final ScheduleEmoji Stroller;
    public static final ScheduleEmoji Sunshade;
    public static final ScheduleEmoji Thinking;
    public static final ScheduleEmoji Timer;
    public static final ScheduleEmoji Tools;
    public static final ScheduleEmoji Trophy;
    public static final ScheduleEmoji Video;
    public static final ScheduleEmoji Web;
    public static final ScheduleEmoji Wifi;
    public static final ScheduleEmoji Writing;
    public static final ScheduleEmoji XmasGift;
    public static final ScheduleEmoji XmasTree;
    private static final Lazy<Map<Integer, ScheduleEmoji>> baseEmojis$delegate;
    private static final Lazy<Map<Integer, ScheduleEmoji>> emojisWithCustomIcon$delegate;
    private static final Lazy<Map<Integer, ScheduleEmoji>> emptyViewEmojis$delegate;
    private static final Map<Integer, Integer> legacyIdToCanonicalId;
    private static final Set<Integer> legacyIds;
    private final SelectableIconCategory category;
    private final EmojiColor color;
    private final Integer iconResId;
    private final int id;
    private final boolean isPremium;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ScheduleEmoji a(ScheduleEmoji emoji) {
            Intrinsics.checkNotNullParameter(emoji, "emoji");
            ScheduleEmoji scheduleEmojiD = d(emoji.getId());
            return scheduleEmojiD == null ? emoji : scheduleEmojiD;
        }

        public final int b(int i3) {
            Integer num = (Integer) ScheduleEmoji.legacyIdToCanonicalId.get(Integer.valueOf(i3));
            return num != null ? num.intValue() : i3;
        }

        public final Map c() {
            return (Map) ScheduleEmoji.baseEmojis$delegate.getValue();
        }

        public final ScheduleEmoji d(int i3) {
            return (ScheduleEmoji) g().get(Integer.valueOf(b(i3)));
        }

        public final ScheduleEmoji e(Profile profile) {
            Intrinsics.checkNotNullParameter(profile, "profile");
            return profile.U(ProfileType.COMBINED) ? ScheduleEmoji.AppBLock : profile.U(ProfileType.LOCATION) ? ScheduleEmoji.Location : profile.U(ProfileType.WIFI) ? ScheduleEmoji.Wifi : profile.U(ProfileType.USAGE_LIMIT) ? ScheduleEmoji.Hourglass : profile.U(ProfileType.LAUNCH_COUNT) ? ScheduleEmoji.Counter : ScheduleEmoji.Clock;
        }

        public final ScheduleEmoji f(int i3) {
            return ProfileType.LOCATION.isSetTo(i3) ? ScheduleEmoji.Location : ProfileType.WIFI.isSetTo(i3) ? ScheduleEmoji.Wifi : ProfileType.USAGE_LIMIT.isSetTo(i3) ? ScheduleEmoji.Hourglass : ProfileType.LAUNCH_COUNT.isSetTo(i3) ? ScheduleEmoji.Counter : ScheduleEmoji.Clock;
        }

        public final Map g() {
            return (Map) ScheduleEmoji.emojisWithCustomIcon$delegate.getValue();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Converter {
        public final ScheduleEmoji a(int i3) {
            return ScheduleEmoji.Companion.d(i3);
        }

        public final int b(ScheduleEmoji type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return ScheduleEmoji.Companion.b(type.getId());
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class EmojiColor {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ EmojiColor[] $VALUES;
        private final long color;
        public static final EmojiColor Brown500 = new EmojiColor("Brown500", 0, ColorKt.d(4285149974L));
        public static final EmojiColor CherryBlossomPink500 = new EmojiColor("CherryBlossomPink500", 1, ColorKt.d(4292438159L));
        public static final EmojiColor Coral500 = new EmojiColor("Coral500", 2, ColorKt.d(4292492856L));
        public static final EmojiColor DeepBlue500 = new EmojiColor("DeepBlue500", 3, ColorKt.d(4280365773L));
        public static final EmojiColor FireOrange500 = new EmojiColor("FireOrange500", 4, ColorKt.d(4292627749L));
        public static final EmojiColor FlamencoPink500 = new EmojiColor("FlamencoPink500", 5, ColorKt.d(4291504984L));
        public static final EmojiColor Lila500 = new EmojiColor("Lila500", 6, ColorKt.d(4289531083L));
        public static final EmojiColor StonePurple500 = new EmojiColor("StonePurple500", 7, ColorKt.d(4283518841L));
        public static final EmojiColor Yellow500 = new EmojiColor("Yellow500", 8, ColorKt.d(4293173504L));
        public static final EmojiColor DarkGreen = new EmojiColor("DarkGreen", 9, ColorKt.d(4279671095L));
        public static final EmojiColor DeepBlue = new EmojiColor("DeepBlue", 10, ColorKt.d(4279924952L));
        public static final EmojiColor DeepPurple = new EmojiColor("DeepPurple", 11, ColorKt.d(4285737682L));

        private static final /* synthetic */ EmojiColor[] $values() {
            return new EmojiColor[]{Brown500, CherryBlossomPink500, Coral500, DeepBlue500, FireOrange500, FlamencoPink500, Lila500, StonePurple500, Yellow500, DarkGreen, DeepBlue, DeepPurple};
        }

        static {
            EmojiColor[] emojiColorArr$values = $values();
            $VALUES = emojiColorArr$values;
            $ENTRIES = EnumEntriesKt.a(emojiColorArr$values);
        }

        private EmojiColor(String str, int i3, long j3) {
            this.color = j3;
        }

        public static EnumEntries<EmojiColor> getEntries() {
            return $ENTRIES;
        }

        public static EmojiColor valueOf(String str) {
            return (EmojiColor) Enum.valueOf(EmojiColor.class, str);
        }

        public static EmojiColor[] values() {
            return (EmojiColor[]) $VALUES.clone();
        }

        /* JADX INFO: renamed from: getColor-0d7_KjU, reason: not valid java name */
        public final long m1358getColor0d7_KjU() {
            return this.color;
        }
    }

    private static final /* synthetic */ ScheduleEmoji[] $values() {
        return new ScheduleEmoji[]{NoIcon, CustomBlockingAppIcon, AppBLock, Clock, School, SchoolBuilding, Laptop, Home, Playground, Books, Calendar, BookShelf, Classroom, Location, Lock, Hourglass, Sleep, Tools, Car, Dumbbell, Basketball, Gas, BeachBall, Pizza, DogBone, Heart, Accounting, Forest, Bat, Bicycle, Pen, Journal, Cat, RuckSack, Skull, Briefcase, Strawberry, Poo, Star, ShushingFace, Idea, Sakura, Stones, Leaf, Game, Shopaholic, Cheesecake, MoneyMouth, CoinWallet, Corn, Goal, News, Night, Web, Chat, Beach, Math, Wifi, Rocket, Map, Timer, FireExtinguisher, Discount, Confetti, XmasTree, XmasGift, SnowFlake, Checkmark, Finish, Guitar, OkHand, Restrict, Trophy, MinusMark, Shield, Stop, Thinking, Counter, BlockApp, Brain, Coding, Puzzle, Ruler, Factory, ColorPalette, Headphones, SalatBowl, Luck, Lotus, Bed, Meditation, GiveLove, Bear, Feet, HandHeart, Stroller, PuzzlePieces, BooksTwo, Apple, Chart, Writing, Certificate, Bank, Countryside, Plane, Mountains, Music, Sofa, Cleaning, Video, Football, Stars, NoSee, Megaphone, Cutlery, Sunshade, Sleeping, Alarm, RoundLock, CrossMark};
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        boolean z2 = false;
        CustomBlockingAppIcon = new ScheduleEmoji("CustomBlockingAppIcon", 1, -2, Integer.valueOf(R.drawable.f95509f), z2, null == true ? 1 : 0, null, 28, defaultConstructorMarker);
        int i3 = R.drawable.O8;
        EmojiColor emojiColor = EmojiColor.DeepBlue;
        SelectableIconCategory selectableIconCategory = SelectableIconCategory.Basic;
        AppBLock = new ScheduleEmoji("AppBLock", 2, 78, Integer.valueOf(i3), z2, selectableIconCategory, emojiColor, 4, defaultConstructorMarker);
        int i4 = R.drawable.o9;
        EmojiColor emojiColor2 = EmojiColor.StonePurple500;
        int i5 = 4;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        boolean z3 = false;
        ScheduleEmoji scheduleEmoji = new ScheduleEmoji("Clock", 3, 0, Integer.valueOf(i4), z3, selectableIconCategory, emojiColor2, i5, defaultConstructorMarker2);
        Clock = scheduleEmoji;
        int i6 = R.drawable.ra;
        EmojiColor emojiColor3 = EmojiColor.DeepPurple;
        SelectableIconCategory selectableIconCategory2 = SelectableIconCategory.SchoolAndStudy;
        boolean z4 = false;
        School = new ScheduleEmoji("School", 4, 1, Integer.valueOf(i6), z4, selectableIconCategory2, emojiColor3, 4, null);
        int i7 = 4;
        DefaultConstructorMarker defaultConstructorMarker3 = null;
        SchoolBuilding = new ScheduleEmoji("SchoolBuilding", 5, 2, Integer.valueOf(R.drawable.sa), z2, selectableIconCategory2, emojiColor, i7, defaultConstructorMarker3);
        int i8 = R.drawable.O9;
        SelectableIconCategory selectableIconCategory3 = SelectableIconCategory.WorkAndFocus;
        Laptop = new ScheduleEmoji("Laptop", 6, 3, Integer.valueOf(i8), z2, selectableIconCategory3, emojiColor, i7, defaultConstructorMarker3);
        int i9 = R.drawable.K9;
        EmojiColor emojiColor4 = EmojiColor.Coral500;
        SelectableIconCategory selectableIconCategory4 = SelectableIconCategory.FamilyAndKids;
        boolean z5 = false;
        Home = new ScheduleEmoji("Home", 7, 4, Integer.valueOf(i9), z5, selectableIconCategory4, emojiColor4, 4, null);
        Playground = new ScheduleEmoji("Playground", 8, 5, Integer.valueOf(R.drawable.ia), z2, selectableIconCategory4, emojiColor, i7, defaultConstructorMarker3);
        int i10 = R.drawable.b9;
        EmojiColor emojiColor5 = EmojiColor.Lila500;
        int i11 = 4;
        DefaultConstructorMarker defaultConstructorMarker4 = null;
        boolean z6 = false;
        Books = new ScheduleEmoji("Books", 9, 7, Integer.valueOf(i10), z6, selectableIconCategory2, emojiColor5, i11, defaultConstructorMarker4);
        Calendar = new ScheduleEmoji("Calendar", 10, 8, Integer.valueOf(R.drawable.f9), z2, selectableIconCategory3, emojiColor, i7, defaultConstructorMarker3);
        BookShelf = new ScheduleEmoji("BookShelf", 11, 9, Integer.valueOf(R.drawable.a9), z6, selectableIconCategory2, emojiColor5, i11, defaultConstructorMarker4);
        int i12 = R.drawable.m9;
        EmojiColor emojiColor6 = EmojiColor.DeepBlue500;
        int i13 = 4;
        DefaultConstructorMarker defaultConstructorMarker5 = null;
        boolean z7 = false;
        Classroom = new ScheduleEmoji("Classroom", 12, 10, Integer.valueOf(i12), z7, selectableIconCategory3, emojiColor6, i13, defaultConstructorMarker5);
        Location = new ScheduleEmoji("Location", 13, 11, Integer.valueOf(R.drawable.Q9), z3, selectableIconCategory, emojiColor4, i5, defaultConstructorMarker2);
        int i14 = R.drawable.R9;
        EmojiColor emojiColor7 = EmojiColor.Yellow500;
        SelectableIconCategory selectableIconCategory5 = SelectableIconCategory.Blocking;
        int i15 = 4;
        DefaultConstructorMarker defaultConstructorMarker6 = null;
        boolean z8 = false;
        ScheduleEmoji scheduleEmoji2 = new ScheduleEmoji("Lock", 14, 12, Integer.valueOf(i14), z8, selectableIconCategory5, emojiColor7, i15, defaultConstructorMarker6);
        Lock = scheduleEmoji2;
        int i16 = 4;
        DefaultConstructorMarker defaultConstructorMarker7 = null;
        Hourglass = new ScheduleEmoji("Hourglass", 15, 13, Integer.valueOf(R.drawable.L9), z2, selectableIconCategory, emojiColor, i16, defaultConstructorMarker7);
        int i17 = R.drawable.xa;
        SelectableIconCategory selectableIconCategory6 = SelectableIconCategory.Wellbeing;
        boolean z9 = false;
        ScheduleEmoji scheduleEmoji3 = new ScheduleEmoji("Sleep", 16, 14, Integer.valueOf(i17), z9, selectableIconCategory6, emojiColor5, 4, null);
        Sleep = scheduleEmoji3;
        int i18 = R.drawable.Ja;
        EmojiColor emojiColor8 = EmojiColor.FireOrange500;
        Tools = new ScheduleEmoji("Tools", 17, 15, Integer.valueOf(i18), z7, selectableIconCategory3, emojiColor8, i13, defaultConstructorMarker5);
        int i19 = R.drawable.g9;
        SelectableIconCategory selectableIconCategory7 = SelectableIconCategory.Activities;
        Car = new ScheduleEmoji("Car", 18, 16, Integer.valueOf(i19), z2, selectableIconCategory7, emojiColor, i16, defaultConstructorMarker7);
        Dumbbell = new ScheduleEmoji("Dumbbell", 19, 17, Integer.valueOf(R.drawable.y9), z2, selectableIconCategory7, emojiColor, i16, defaultConstructorMarker7);
        int i20 = 4;
        DefaultConstructorMarker defaultConstructorMarker8 = null;
        boolean z10 = false;
        Basketball = new ScheduleEmoji("Basketball", 20, 18, Integer.valueOf(R.drawable.R8), z10, selectableIconCategory7, emojiColor8, i20, defaultConstructorMarker8);
        int i21 = R.drawable.F9;
        SelectableIconCategory selectableIconCategory8 = SelectableIconCategory.Others;
        Gas = new ScheduleEmoji("Gas", 21, 19, Integer.valueOf(i21), z2, selectableIconCategory8, emojiColor, i16, defaultConstructorMarker7);
        BeachBall = new ScheduleEmoji("BeachBall", 22, 20, Integer.valueOf(R.drawable.U8), z2, selectableIconCategory4, emojiColor, i16, defaultConstructorMarker7);
        int i22 = R.drawable.ga;
        EmojiColor emojiColor9 = EmojiColor.FlamencoPink500;
        Pizza = new ScheduleEmoji("Pizza", 23, 21, Integer.valueOf(i22), z10, selectableIconCategory7, emojiColor9, i20, defaultConstructorMarker8);
        DogBone = new ScheduleEmoji("DogBone", 24, 22, Integer.valueOf(R.drawable.Z8), z8, selectableIconCategory7, emojiColor7, i15, defaultConstructorMarker6);
        int i23 = 4;
        DefaultConstructorMarker defaultConstructorMarker9 = null;
        boolean z11 = false;
        Heart = new ScheduleEmoji("Heart", 25, 23, Integer.valueOf(R.drawable.f95515g1), z11, selectableIconCategory4, emojiColor6, i23, defaultConstructorMarker9);
        Accounting = new ScheduleEmoji("Accounting", 26, 24, Integer.valueOf(R.drawable.N8), z2, selectableIconCategory3, emojiColor, i16, defaultConstructorMarker7);
        int i24 = R.drawable.D9;
        EmojiColor emojiColor10 = EmojiColor.DarkGreen;
        Forest = new ScheduleEmoji("Forest", 27, 25, Integer.valueOf(i24), z10, selectableIconCategory7, emojiColor10, i20, defaultConstructorMarker8);
        int i25 = 4;
        DefaultConstructorMarker defaultConstructorMarker10 = null;
        boolean z12 = false;
        Bat = new ScheduleEmoji("Bat", 28, 26, Integer.valueOf(R.drawable.S8), z12, selectableIconCategory8, emojiColor2, i25, defaultConstructorMarker10);
        int i26 = 4;
        DefaultConstructorMarker defaultConstructorMarker11 = null;
        Bicycle = new ScheduleEmoji("Bicycle", 29, 27, Integer.valueOf(R.drawable.X8), z5, selectableIconCategory7, emojiColor4, i26, defaultConstructorMarker11);
        Pen = new ScheduleEmoji("Pen", 30, 28, Integer.valueOf(R.drawable.fa), z5, selectableIconCategory7, emojiColor4, i26, defaultConstructorMarker11);
        int i27 = 4;
        DefaultConstructorMarker defaultConstructorMarker12 = null;
        boolean z13 = false;
        Journal = new ScheduleEmoji("Journal", 31, 29, Integer.valueOf(R.drawable.N9), z13, selectableIconCategory6, emojiColor8, i27, defaultConstructorMarker12);
        Cat = new ScheduleEmoji("Cat", 32, 30, Integer.valueOf(R.drawable.h9), z11, selectableIconCategory4, emojiColor7, i23, defaultConstructorMarker9);
        int i28 = R.drawable.na;
        EmojiColor emojiColor11 = EmojiColor.Brown500;
        RuckSack = new ScheduleEmoji("RuckSack", 33, 31, Integer.valueOf(i28), z6, selectableIconCategory2, emojiColor11, 4, null);
        Skull = new ScheduleEmoji("Skull", 34, 32, Integer.valueOf(R.drawable.wa), z12, selectableIconCategory8, emojiColor2, i25, defaultConstructorMarker10);
        int i29 = 4;
        DefaultConstructorMarker defaultConstructorMarker13 = null;
        Briefcase = new ScheduleEmoji("Briefcase", 35, 33, Integer.valueOf(R.drawable.e9), z7, selectableIconCategory3, emojiColor8, i29, defaultConstructorMarker13);
        Strawberry = new ScheduleEmoji("Strawberry", 36, 34, Integer.valueOf(R.drawable.Ea), z13, selectableIconCategory6, emojiColor9, i27, defaultConstructorMarker12);
        int i30 = 4;
        DefaultConstructorMarker defaultConstructorMarker14 = null;
        boolean z14 = false;
        Poo = new ScheduleEmoji("Poo", 37, 35, Integer.valueOf(R.drawable.ja), z14, selectableIconCategory8, emojiColor11, i30, defaultConstructorMarker14);
        Star = new ScheduleEmoji("Star", 38, 36, Integer.valueOf(R.drawable.Aa), z8, selectableIconCategory5, emojiColor7, i15, defaultConstructorMarker6);
        ShushingFace = new ScheduleEmoji("ShushingFace", 39, 37, Integer.valueOf(R.drawable.va), z8, selectableIconCategory6, emojiColor7, i15, defaultConstructorMarker6);
        Idea = new ScheduleEmoji("Idea", 40, 38, Integer.valueOf(R.drawable.M9), z7, selectableIconCategory3, emojiColor7, i29, defaultConstructorMarker13);
        String str = "Sakura";
        int i31 = 41;
        int i32 = 39;
        Sakura = new ScheduleEmoji(str, i31, i32, Integer.valueOf(R.drawable.pa), z13, selectableIconCategory6, EmojiColor.CherryBlossomPink500, i27, defaultConstructorMarker12);
        Stones = new ScheduleEmoji("Stones", 42, 40, Integer.valueOf(R.drawable.Ca), z12, selectableIconCategory6, emojiColor2, i25, defaultConstructorMarker10);
        Leaf = new ScheduleEmoji("Leaf", 43, 41, Integer.valueOf(R.drawable.P9), z13, selectableIconCategory6, emojiColor10, i27, defaultConstructorMarker12);
        Game = new ScheduleEmoji("Game", 44, 42, Integer.valueOf(R.drawable.E9), z2, selectableIconCategory7, emojiColor, i16, defaultConstructorMarker7);
        int i33 = 4;
        DefaultConstructorMarker defaultConstructorMarker15 = null;
        Shopaholic = new ScheduleEmoji("Shopaholic", 45, 43, Integer.valueOf(R.drawable.ua), z10, selectableIconCategory7, emojiColor9, i33, defaultConstructorMarker15);
        Cheesecake = new ScheduleEmoji("Cheesecake", 46, 44, Integer.valueOf(R.drawable.l9), z10, selectableIconCategory7, emojiColor9, i33, defaultConstructorMarker15);
        MoneyMouth = new ScheduleEmoji("MoneyMouth", 47, 45, Integer.valueOf(R.drawable.Z9), z14, selectableIconCategory8, emojiColor10, i30, defaultConstructorMarker14);
        CoinWallet = new ScheduleEmoji("CoinWallet", 48, 46, Integer.valueOf(R.drawable.q9), z10, selectableIconCategory7, emojiColor8, 4, null);
        Corn = new ScheduleEmoji("Corn", 49, 47, Integer.valueOf(R.drawable.t9), z14, selectableIconCategory8, emojiColor10, i30, defaultConstructorMarker14);
        Goal = new ScheduleEmoji("Goal", 50, 48, Integer.valueOf(R.drawable.H9), z2, selectableIconCategory3, emojiColor, i16, defaultConstructorMarker7);
        News = new ScheduleEmoji("News", 51, 49, Integer.valueOf(R.drawable.ca), z2, selectableIconCategory8, emojiColor, i16, defaultConstructorMarker7);
        int i34 = 4;
        DefaultConstructorMarker defaultConstructorMarker16 = null;
        Night = new ScheduleEmoji("Night", 52, 50, Integer.valueOf(R.drawable.da), z4, selectableIconCategory6, emojiColor3, i34, defaultConstructorMarker16);
        Web = new ScheduleEmoji("Web", 53, 51, Integer.valueOf(R.drawable.La), false, selectableIconCategory8, emojiColor6, 4, null);
        Chat = new ScheduleEmoji("Chat", 54, 52, Integer.valueOf(R.drawable.k9), z7, selectableIconCategory3, emojiColor6, i29, defaultConstructorMarker13);
        int i35 = 4;
        DefaultConstructorMarker defaultConstructorMarker17 = null;
        Beach = new ScheduleEmoji("Beach", 55, 53, Integer.valueOf(R.drawable.T8), z10, selectableIconCategory7, emojiColor10, i35, defaultConstructorMarker17);
        Math = new ScheduleEmoji("Math", 56, 54, Integer.valueOf(R.drawable.V9), z2, selectableIconCategory3, emojiColor, i16, defaultConstructorMarker7);
        Wifi = new ScheduleEmoji("Wifi", 57, 55, Integer.valueOf(R.drawable.Ma), z3, selectableIconCategory, emojiColor6, 4, null);
        int i36 = 4;
        DefaultConstructorMarker defaultConstructorMarker18 = null;
        Rocket = new ScheduleEmoji("Rocket", 58, 56, Integer.valueOf(R.drawable.ma), z2, selectableIconCategory3, emojiColor, i36, defaultConstructorMarker18);
        int i37 = 4;
        DefaultConstructorMarker defaultConstructorMarker19 = null;
        Map = new ScheduleEmoji("Map", 59, 57, Integer.valueOf(R.drawable.U9), z5, selectableIconCategory8, emojiColor4, i37, defaultConstructorMarker19);
        Timer = new ScheduleEmoji("Timer", 60, 59, Integer.valueOf(R.drawable.Ia), z12, selectableIconCategory3, emojiColor2, i25, defaultConstructorMarker10);
        FireExtinguisher = new ScheduleEmoji("FireExtinguisher", 61, 60, Integer.valueOf(R.drawable.B9), z5, selectableIconCategory8, emojiColor4, i37, defaultConstructorMarker19);
        Discount = new ScheduleEmoji("Discount", 62, 61, Integer.valueOf(R.drawable.x9), z10, selectableIconCategory7, emojiColor9, i35, defaultConstructorMarker17);
        Confetti = new ScheduleEmoji("Confetti", 63, 62, Integer.valueOf(R.drawable.s9), z10, selectableIconCategory8, emojiColor8, i35, defaultConstructorMarker17);
        XmasTree = new ScheduleEmoji("XmasTree", 64, 63, Integer.valueOf(R.drawable.Pa), z14, selectableIconCategory8, emojiColor10, i30, defaultConstructorMarker14);
        XmasGift = new ScheduleEmoji("XmasGift", 65, 64, Integer.valueOf(R.drawable.Oa), z5, selectableIconCategory8, emojiColor4, i37, defaultConstructorMarker19);
        SnowFlake = new ScheduleEmoji("SnowFlake", 66, 65, Integer.valueOf(R.drawable.ya), z2, selectableIconCategory8, emojiColor, i36, defaultConstructorMarker18);
        Checkmark = new ScheduleEmoji("Checkmark", 67, 66, Integer.valueOf(R.drawable.f95575x), z7, selectableIconCategory3, emojiColor10, 4, null);
        Finish = new ScheduleEmoji("Finish", 68, 67, Integer.valueOf(R.drawable.L), z12, selectableIconCategory7, emojiColor2, i25, defaultConstructorMarker10);
        Guitar = new ScheduleEmoji("Guitar", 69, 68, Integer.valueOf(R.drawable.M8), z5, selectableIconCategory7, emojiColor4, i37, defaultConstructorMarker19);
        OkHand = new ScheduleEmoji("OkHand", 70, 70, Integer.valueOf(R.drawable.u8), z7, selectableIconCategory3, emojiColor8, 4, null);
        Restrict = new ScheduleEmoji("Restrict", 71, 71, Integer.valueOf(R.drawable.L8), z5, selectableIconCategory5, emojiColor4, i37, defaultConstructorMarker19);
        Trophy = new ScheduleEmoji("Trophy", 72, 72, Integer.valueOf(R.drawable.ob), z8, selectableIconCategory8, emojiColor7, i15, defaultConstructorMarker6);
        int i38 = R.drawable.Y9;
        ScheduleEmoji scheduleEmoji4 = new ScheduleEmoji("MinusMark", 73, 74, Integer.valueOf(i38), z5, selectableIconCategory5, emojiColor4, i37, defaultConstructorMarker19);
        MinusMark = scheduleEmoji4;
        Shield = new ScheduleEmoji("Shield", 74, 76, Integer.valueOf(R.drawable.ta), z8, selectableIconCategory5, emojiColor7, i15, defaultConstructorMarker6);
        Stop = new ScheduleEmoji("Stop", 75, 77, Integer.valueOf(R.drawable.Da), z5, selectableIconCategory5, emojiColor4, i37, defaultConstructorMarker19);
        Thinking = new ScheduleEmoji("Thinking", 76, 79, Integer.valueOf(R.drawable.Ha), z4, selectableIconCategory6, emojiColor3, i34, defaultConstructorMarker16);
        Counter = new ScheduleEmoji("Counter", 77, 80, Integer.valueOf(R.drawable.u9), z3, selectableIconCategory, emojiColor2, 4, null);
        int i39 = 4;
        DefaultConstructorMarker defaultConstructorMarker20 = null;
        BlockApp = new ScheduleEmoji("BlockApp", 78, 100, Integer.valueOf(R.drawable.Y8), z2, selectableIconCategory5, emojiColor, i39, defaultConstructorMarker20);
        int i40 = 4;
        DefaultConstructorMarker defaultConstructorMarker21 = null;
        Brain = new ScheduleEmoji("Brain", 79, 101, Integer.valueOf(R.drawable.d9), z7, selectableIconCategory3, emojiColor4, i40, defaultConstructorMarker21);
        Coding = new ScheduleEmoji("Coding", 80, 102, Integer.valueOf(R.drawable.p9), z2, selectableIconCategory3, emojiColor, i39, defaultConstructorMarker20);
        Puzzle = new ScheduleEmoji("Puzzle", 81, 103, Integer.valueOf(R.drawable.ka), z4, selectableIconCategory3, emojiColor3, i34, defaultConstructorMarker16);
        Ruler = new ScheduleEmoji("Ruler", 82, 104, Integer.valueOf(R.drawable.oa), z2, selectableIconCategory3, emojiColor, i39, defaultConstructorMarker20);
        Factory = new ScheduleEmoji("Factory", 83, 105, Integer.valueOf(R.drawable.z9), z7, selectableIconCategory3, emojiColor4, i40, defaultConstructorMarker21);
        ColorPalette = new ScheduleEmoji("ColorPalette", 84, 106, Integer.valueOf(R.drawable.r9), z2, selectableIconCategory3, emojiColor, i39, defaultConstructorMarker20);
        Headphones = new ScheduleEmoji("Headphones", 85, 107, Integer.valueOf(R.drawable.J9), z7, selectableIconCategory3, emojiColor4, i40, defaultConstructorMarker21);
        SalatBowl = new ScheduleEmoji("SalatBowl", 86, 108, Integer.valueOf(R.drawable.qa), z2, selectableIconCategory6, emojiColor, i39, defaultConstructorMarker20);
        Luck = new ScheduleEmoji("Luck", 87, 109, Integer.valueOf(R.drawable.T9), z13, selectableIconCategory6, emojiColor10, i27, defaultConstructorMarker12);
        Lotus = new ScheduleEmoji("Lotus", 88, 110, Integer.valueOf(R.drawable.S9), z13, selectableIconCategory6, emojiColor9, i27, defaultConstructorMarker12);
        Bed = new ScheduleEmoji("Bed", 89, 111, Integer.valueOf(R.drawable.W8), z4, selectableIconCategory6, emojiColor3, i34, defaultConstructorMarker16);
        Meditation = new ScheduleEmoji("Meditation", 90, 112, Integer.valueOf(R.drawable.W9), z8, selectableIconCategory6, emojiColor7, i15, defaultConstructorMarker6);
        GiveLove = new ScheduleEmoji("GiveLove", 91, 113, Integer.valueOf(R.drawable.G9), z2, selectableIconCategory6, emojiColor, i39, defaultConstructorMarker20);
        Bear = new ScheduleEmoji("Bear", 92, 114, Integer.valueOf(R.drawable.V8), z11, selectableIconCategory4, emojiColor11, i23, defaultConstructorMarker9);
        Feet = new ScheduleEmoji("Feet", 93, 115, Integer.valueOf(R.drawable.A9), z11, selectableIconCategory4, emojiColor7, i23, defaultConstructorMarker9);
        int i41 = 4;
        DefaultConstructorMarker defaultConstructorMarker22 = null;
        HandHeart = new ScheduleEmoji("HandHeart", 94, 116, Integer.valueOf(R.drawable.I9), z5, selectableIconCategory4, emojiColor4, i41, defaultConstructorMarker22);
        Stroller = new ScheduleEmoji("Stroller", 95, 117, Integer.valueOf(R.drawable.Fa), z5, selectableIconCategory4, emojiColor4, i41, defaultConstructorMarker22);
        PuzzlePieces = new ScheduleEmoji("PuzzlePieces", 96, 118, Integer.valueOf(R.drawable.la), z2, selectableIconCategory4, emojiColor, i39, defaultConstructorMarker20);
        BooksTwo = new ScheduleEmoji("BooksTwo", 97, 119, Integer.valueOf(R.drawable.c9), z4, selectableIconCategory2, emojiColor3, i34, defaultConstructorMarker16);
        int i42 = 4;
        DefaultConstructorMarker defaultConstructorMarker23 = null;
        Apple = new ScheduleEmoji("Apple", 98, 120, Integer.valueOf(R.drawable.P8), z6, selectableIconCategory2, emojiColor4, i42, defaultConstructorMarker23);
        Chart = new ScheduleEmoji("Chart", 99, 121, Integer.valueOf(R.drawable.j9), z6, selectableIconCategory2, emojiColor10, i42, defaultConstructorMarker23);
        Writing = new ScheduleEmoji("Writing", 100, 122, Integer.valueOf(R.drawable.Na), z6, selectableIconCategory2, emojiColor4, i42, defaultConstructorMarker23);
        Certificate = new ScheduleEmoji("Certificate", 101, 123, Integer.valueOf(R.drawable.i9), z2, selectableIconCategory2, emojiColor, i39, defaultConstructorMarker20);
        Bank = new ScheduleEmoji("Bank", 102, 124, Integer.valueOf(R.drawable.Q8), z6, selectableIconCategory2, emojiColor7, i42, defaultConstructorMarker23);
        int i43 = 4;
        DefaultConstructorMarker defaultConstructorMarker24 = null;
        Countryside = new ScheduleEmoji("Countryside", 103, 125, Integer.valueOf(R.drawable.v9), z10, selectableIconCategory7, emojiColor10, i43, defaultConstructorMarker24);
        Plane = new ScheduleEmoji("Plane", 104, 126, Integer.valueOf(R.drawable.ha), z2, selectableIconCategory7, emojiColor, i39, defaultConstructorMarker20);
        Mountains = new ScheduleEmoji("Mountains", 105, 127, Integer.valueOf(R.drawable.aa), z2, selectableIconCategory7, emojiColor, i39, defaultConstructorMarker20);
        Music = new ScheduleEmoji("Music", 106, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, Integer.valueOf(R.drawable.ba), z5, selectableIconCategory7, emojiColor4, i41, defaultConstructorMarker22);
        int i44 = 4;
        DefaultConstructorMarker defaultConstructorMarker25 = null;
        Sofa = new ScheduleEmoji("Sofa", 107, 129, Integer.valueOf(R.drawable.za), z9, selectableIconCategory7, emojiColor5, i44, defaultConstructorMarker25);
        Cleaning = new ScheduleEmoji("Cleaning", 108, 130, Integer.valueOf(R.drawable.n9), z9, selectableIconCategory7, emojiColor5, i44, defaultConstructorMarker25);
        Video = new ScheduleEmoji("Video", 109, 131, Integer.valueOf(R.drawable.Ka), z2, selectableIconCategory7, emojiColor, i39, defaultConstructorMarker20);
        Football = new ScheduleEmoji("Football", 110, 132, Integer.valueOf(R.drawable.C9), z10, selectableIconCategory7, emojiColor10, i43, defaultConstructorMarker24);
        Stars = new ScheduleEmoji("Stars", 111, 133, Integer.valueOf(R.drawable.Ba), z2, selectableIconCategory8, emojiColor, i39, defaultConstructorMarker20);
        NoSee = new ScheduleEmoji("NoSee", 112, 134, Integer.valueOf(R.drawable.ea), z14, selectableIconCategory8, emojiColor11, i30, defaultConstructorMarker14);
        Megaphone = new ScheduleEmoji("Megaphone", 113, 135, Integer.valueOf(R.drawable.X9), z2, selectableIconCategory8, emojiColor, i39, defaultConstructorMarker20);
        Cutlery = new ScheduleEmoji("Cutlery", 114, 136, Integer.valueOf(R.drawable.w9), z2, selectableIconCategory7, emojiColor, i39, defaultConstructorMarker20);
        Sunshade = new ScheduleEmoji("Sunshade", 115, 137, Integer.valueOf(R.drawable.Ga), z2, selectableIconCategory7, emojiColor, i39, defaultConstructorMarker20);
        Sleeping = new ScheduleEmoji("Sleeping", 116, 6, Integer.valueOf(i17), z9, null, emojiColor5, 12, defaultConstructorMarker25);
        Alarm = new ScheduleEmoji("Alarm", 117, 58, Integer.valueOf(i4), z12, null, emojiColor2, 12, defaultConstructorMarker10);
        RoundLock = new ScheduleEmoji("RoundLock", 118, 69, Integer.valueOf(i14), z8, null, emojiColor7, 12, defaultConstructorMarker6);
        CrossMark = new ScheduleEmoji("CrossMark", 119, 73, Integer.valueOf(i38), z5, null, emojiColor4, 12, defaultConstructorMarker22);
        ScheduleEmoji[] scheduleEmojiArr$values = $values();
        $VALUES = scheduleEmojiArr$values;
        $ENTRIES = EnumEntriesKt.a(scheduleEmojiArr$values);
        Companion = new Companion(null);
        Map<Integer, Integer> mapMapOf = MapsKt.mapOf(TuplesKt.a(6, Integer.valueOf(scheduleEmoji3.getId())), TuplesKt.a(58, Integer.valueOf(scheduleEmoji.getId())), TuplesKt.a(69, Integer.valueOf(scheduleEmoji2.getId())), TuplesKt.a(73, Integer.valueOf(scheduleEmoji4.getId())));
        legacyIdToCanonicalId = mapMapOf;
        legacyIds = mapMapOf.keySet();
        baseEmojis$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.enums.q0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScheduleEmoji.baseEmojis_delegate$lambda$0();
            }
        });
        emojisWithCustomIcon$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.enums.r0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScheduleEmoji.emojisWithCustomIcon_delegate$lambda$0();
            }
        });
        emptyViewEmojis$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.enums.s0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScheduleEmoji.emptyViewEmojis_delegate$lambda$0();
            }
        });
    }

    private ScheduleEmoji(String str, int i3, int i4, Integer num, boolean z2, SelectableIconCategory selectableIconCategory, EmojiColor emojiColor) {
        this.id = i4;
        this.iconResId = num;
        this.isPremium = z2;
        this.category = selectableIconCategory;
        this.color = emojiColor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map baseEmojis_delegate$lambda$0() {
        EnumEntries<ScheduleEmoji> entries = getEntries();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entries, 10)), 16));
        for (ScheduleEmoji scheduleEmoji : entries) {
            linkedHashMap.put(Integer.valueOf(scheduleEmoji.getId()), scheduleEmoji);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (entry.getValue() != CustomBlockingAppIcon && !legacyIds.contains(entry.getKey())) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map emojisWithCustomIcon_delegate$lambda$0() {
        EnumEntries<ScheduleEmoji> entries = getEntries();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entries, 10)), 16));
        for (ScheduleEmoji scheduleEmoji : entries) {
            linkedHashMap.put(Integer.valueOf(scheduleEmoji.getId()), scheduleEmoji);
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map emptyViewEmojis_delegate$lambda$0() {
        List listListOf = CollectionsKt.listOf((Object[]) new ScheduleEmoji[]{Heart, Home, School, Clock, Books, Location, Laptop, Sleep, ShushingFace, Calendar});
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listListOf, 10)), 16));
        for (Object obj : listListOf) {
            linkedHashMap.put(Integer.valueOf(((ScheduleEmoji) obj).getId()), obj);
        }
        return linkedHashMap;
    }

    public static EnumEntries<ScheduleEmoji> getEntries() {
        return $ENTRIES;
    }

    public static ScheduleEmoji valueOf(String str) {
        return (ScheduleEmoji) Enum.valueOf(ScheduleEmoji.class, str);
    }

    public static ScheduleEmoji[] values() {
        return (ScheduleEmoji[]) $VALUES.clone();
    }

    @Override // cz.mobilesoft.coreblock.enums.SelectableIcon
    public SelectableIconCategory getCategory() {
        return this.category;
    }

    public final EmojiColor getColor() {
        return this.color;
    }

    @Override // cz.mobilesoft.coreblock.enums.SelectableIcon
    public Integer getIconResId() {
        return this.iconResId;
    }

    @Override // cz.mobilesoft.coreblock.enums.SelectableItem
    public int getId() {
        return this.id;
    }

    @Override // cz.mobilesoft.coreblock.enums.SelectableItem
    public boolean isPremium() {
        return this.isPremium;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    /* synthetic */ ScheduleEmoji(java.lang.String r9, int r10, int r11, java.lang.Integer r12, boolean r13, cz.mobilesoft.coreblock.enums.SelectableIconCategory r14, cz.mobilesoft.coreblock.enums.ScheduleEmoji.EmojiColor r15, int r16, kotlin.jvm.internal.DefaultConstructorMarker r17) {
        /*
            r8 = this;
            r0 = r16 & 4
            if (r0 == 0) goto L5
            r13 = 0
        L5:
            r5 = r13
            r13 = r16 & 8
            r0 = 0
            if (r13 == 0) goto Ld
            r6 = r0
            goto Le
        Ld:
            r6 = r14
        Le:
            r13 = r16 & 16
            if (r13 == 0) goto L19
            r7 = r0
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r0 = r8
            goto L1f
        L19:
            r7 = r15
            r0 = r8
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
        L1f:
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.enums.ScheduleEmoji.<init>(java.lang.String, int, int, java.lang.Integer, boolean, cz.mobilesoft.coreblock.enums.SelectableIconCategory, cz.mobilesoft.coreblock.enums.ScheduleEmoji$EmojiColor, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
