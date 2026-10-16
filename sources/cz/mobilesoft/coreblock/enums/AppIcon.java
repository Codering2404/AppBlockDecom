package cz.mobilesoft.coreblock.enums;

import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
public final class AppIcon implements SelectableIcon {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AppIcon[] $VALUES;
    public static final Companion Companion;
    public static final AppIcon Icon10;
    public static final AppIcon Icon11;
    public static final AppIcon Icon12;
    public static final AppIcon Icon16;
    public static final AppIcon Icon17;
    public static final AppIcon Icon18;
    public static final AppIcon Icon19;
    public static final AppIcon Icon3;
    public static final AppIcon Icon4;
    public static final AppIcon Icon5;
    public static final AppIcon Icon6;
    public static final AppIcon Icon7;
    public static final AppIcon Icon8;
    public static final AppIcon Icon9;
    private static final Lazy<Map<Integer, AppIcon>> icons$delegate;
    private final String componentName;
    private final int iconResId;
    private final int id;
    private final boolean isPremium;
    public static final AppIcon Icon1 = new AppIcon("Icon1", 0, 1, R.drawable.g3, false, "cz.mobilesoft.appblock.MainActivityAlias1");
    public static final AppIcon Icon2 = new AppIcon("Icon2", 1, 2, R.drawable.h3, false, "cz.mobilesoft.appblock.MainActivityAlias2");
    public static final AppIcon Icon13 = new AppIcon("Icon13", 12, 13, R.drawable.Z2, false, "cz.mobilesoft.appblock.MainActivityAlias13");
    public static final AppIcon Icon14 = new AppIcon("Icon14", 13, 14, R.drawable.a3, false, "cz.mobilesoft.appblock.MainActivityAlias14");
    public static final AppIcon Icon15 = new AppIcon("Icon15", 14, 15, R.drawable.b3, false, "cz.mobilesoft.appblock.MainActivityAlias15");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AppIcon a(int i3) {
            AppIcon next;
            Iterator<AppIcon> it = AppIcon.getEntries().iterator();
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
            AppIcon appIcon = next;
            return appIcon == null ? AppIcon.Icon1 : appIcon;
        }

        public final Map b() {
            return (Map) AppIcon.icons$delegate.getValue();
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ AppIcon[] $values() {
        return new AppIcon[]{Icon1, Icon2, Icon3, Icon4, Icon5, Icon6, Icon7, Icon8, Icon9, Icon10, Icon11, Icon12, Icon13, Icon14, Icon15, Icon16, Icon17, Icon18, Icon19};
    }

    private AppIcon(String str, int i3, int i4, int i5, boolean z2, String str2) {
        this.id = i4;
        this.iconResId = i5;
        this.isPremium = z2;
        this.componentName = str2;
    }

    public static EnumEntries<AppIcon> getEntries() {
        return $ENTRIES;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map icons_delegate$lambda$0() {
        List listSortedWith = CollectionsKt.sortedWith(getEntries(), ComparisonsKt.b(new Function1() { // from class: cz.mobilesoft.coreblock.enums.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AppIcon.icons_delegate$lambda$0$0((AppIcon) obj);
            }
        }, new Function1() { // from class: cz.mobilesoft.coreblock.enums.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AppIcon.icons_delegate$lambda$0$1((AppIcon) obj);
            }
        }));
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listSortedWith, 10)), 16));
        for (Object obj : listSortedWith) {
            Integer iconResId = ((AppIcon) obj).getIconResId();
            iconResId.intValue();
            linkedHashMap.put(iconResId, obj);
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable icons_delegate$lambda$0$0(AppIcon it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Boolean.valueOf(it.isPremium());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable icons_delegate$lambda$0$1(AppIcon it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Integer.valueOf(it.getId());
    }

    public static AppIcon valueOf(String str) {
        return (AppIcon) Enum.valueOf(AppIcon.class, str);
    }

    public static AppIcon[] values() {
        return (AppIcon[]) $VALUES.clone();
    }

    @Override // cz.mobilesoft.coreblock.enums.SelectableIcon
    public /* bridge */ SelectableIconCategory getCategory() {
        return super.getCategory();
    }

    public final String getComponentName() {
        return this.componentName;
    }

    @Override // cz.mobilesoft.coreblock.enums.SelectableIcon
    public Integer getIconResId() {
        return Integer.valueOf(this.iconResId);
    }

    @Override // cz.mobilesoft.coreblock.enums.SelectableItem
    public int getId() {
        return this.id;
    }

    @Override // cz.mobilesoft.coreblock.enums.SelectableItem
    public boolean isPremium() {
        return this.isPremium;
    }

    static {
        int i3 = 3;
        Icon3 = new AppIcon("Icon3", 2, i3, R.drawable.i3, false, "cz.mobilesoft.appblock.MainActivityAlias3", 4, null);
        int i4 = 4;
        Icon4 = new AppIcon("Icon4", i3, i4, R.drawable.j3, false, "cz.mobilesoft.appblock.MainActivityAlias4", 4, null);
        int i5 = 5;
        Icon5 = new AppIcon("Icon5", i4, i5, R.drawable.k3, false, "cz.mobilesoft.appblock.MainActivityAlias5", 4, null);
        int i6 = 6;
        Icon6 = new AppIcon("Icon6", i5, i6, R.drawable.l3, false, "cz.mobilesoft.appblock.MainActivityAlias6", 4, null);
        int i7 = 7;
        Icon7 = new AppIcon("Icon7", i6, i7, R.drawable.m3, false, "cz.mobilesoft.appblock.MainActivityAlias7", 4, null);
        int i8 = 8;
        Icon8 = new AppIcon("Icon8", i7, i8, R.drawable.n3, false, "cz.mobilesoft.appblock.MainActivityAlias8", 4, null);
        int i9 = 9;
        Icon9 = new AppIcon("Icon9", i8, i9, R.drawable.o3, false, "cz.mobilesoft.appblock.MainActivityAlias9", 4, null);
        Icon10 = new AppIcon(MrGIhy.DTpwjPHTFtajy, i9, 10, R.drawable.W2, false, "cz.mobilesoft.appblock.MainActivityAlias10", 4, null);
        int i10 = 11;
        Icon11 = new AppIcon("Icon11", 10, i10, R.drawable.X2, false, "cz.mobilesoft.appblock.MainActivityAlias11", 4, null);
        Icon12 = new AppIcon("Icon12", i10, 12, R.drawable.Y2, false, "cz.mobilesoft.appblock.MainActivityAlias12", 4, null);
        int i11 = 16;
        Icon16 = new AppIcon("Icon16", 15, i11, R.drawable.c3, false, "cz.mobilesoft.appblock.MainActivityAlias16", 4, null);
        int i12 = 17;
        Icon17 = new AppIcon("Icon17", i11, i12, R.drawable.d3, false, "cz.mobilesoft.appblock.MainActivityAlias17", 4, null);
        int i13 = 18;
        Icon18 = new AppIcon("Icon18", i12, i13, R.drawable.e3, false, "cz.mobilesoft.appblock.MainActivityAlias18", 4, null);
        Icon19 = new AppIcon("Icon19", i13, 19, R.drawable.f3, false, "cz.mobilesoft.appblock.MainActivityAlias19", 4, null);
        AppIcon[] appIconArr$values = $values();
        $VALUES = appIconArr$values;
        $ENTRIES = EnumEntriesKt.a(appIconArr$values);
        Companion = new Companion(null);
        icons$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.enums.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AppIcon.icons_delegate$lambda$0();
            }
        });
    }

    /* synthetic */ AppIcon(String str, int i3, int i4, int i5, boolean z2, String str2, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, i4, i5, (i6 & 4) != 0 ? true : z2, str2);
    }
}
