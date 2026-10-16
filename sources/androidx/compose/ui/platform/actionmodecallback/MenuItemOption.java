package androidx.compose.ui.platform.actionmodecallback;

import android.R;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class MenuItemOption {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MenuItemOption f28341c = new MenuItemOption("Copy", 0, 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final MenuItemOption f28342d = new MenuItemOption("Paste", 1, 1);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final MenuItemOption f28343f = new MenuItemOption("Cut", 2, 2);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final MenuItemOption f28344g = new MenuItemOption("SelectAll", 3, 3);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final MenuItemOption f28345h = new MenuItemOption("Autofill", 4, 4);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ MenuItemOption[] f28346i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ EnumEntries f28347j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f28348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f28349b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f28350a;

        static {
            int[] iArr = new int[MenuItemOption.values().length];
            try {
                iArr[MenuItemOption.f28341c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MenuItemOption.f28342d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MenuItemOption.f28343f.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MenuItemOption.f28344g.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MenuItemOption.f28345h.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f28350a = iArr;
        }
    }

    static {
        MenuItemOption[] menuItemOptionArrA = a();
        f28346i = menuItemOptionArrA;
        f28347j = EnumEntriesKt.a(menuItemOptionArrA);
    }

    private MenuItemOption(String str, int i3, int i4) {
        this.f28348a = i4;
        this.f28349b = i4;
    }

    private static final /* synthetic */ MenuItemOption[] a() {
        return new MenuItemOption[]{f28341c, f28342d, f28343f, f28344g, f28345h};
    }

    public static MenuItemOption valueOf(String str) {
        return (MenuItemOption) Enum.valueOf(MenuItemOption.class, str);
    }

    public static MenuItemOption[] values() {
        return (MenuItemOption[]) f28346i.clone();
    }

    public final int b() {
        return this.f28348a;
    }

    public final int c() {
        return this.f28349b;
    }

    public final int d() {
        int i3 = WhenMappings.f28350a[ordinal()];
        if (i3 == 1) {
            return R.string.copy;
        }
        if (i3 == 2) {
            return R.string.paste;
        }
        if (i3 == 3) {
            return R.string.cut;
        }
        if (i3 == 4) {
            return R.string.selectAll;
        }
        if (i3 == 5) {
            return R.string.autofill;
        }
        throw new NoWhenBranchMatchedException();
    }
}
