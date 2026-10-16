package androidx.compose.ui.text.font;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;

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
public final class FontVariation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FontVariation f29221a = new FontVariation();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Setting {
        boolean a();

        float b(Density density);

        String c();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class SettingFloat implements Setting {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f29222a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f29223b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f29224c;

        public SettingFloat(String str, float f3) {
            this.f29222a = str;
            this.f29223b = f3;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public boolean a() {
            return this.f29224c;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public float b(Density density) {
            return this.f29223b;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public String c() {
            return this.f29222a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SettingFloat)) {
                return false;
            }
            SettingFloat settingFloat = (SettingFloat) obj;
            return Intrinsics.areEqual(c(), settingFloat.c()) && this.f29223b == settingFloat.f29223b;
        }

        public int hashCode() {
            return (c().hashCode() * 31) + Float.hashCode(this.f29223b);
        }

        public String toString() {
            return "FontVariation.Setting(axisName='" + c() + "', value=" + this.f29223b + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class SettingInt implements Setting {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f29225a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f29226b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f29227c;

        public SettingInt(String str, int i3) {
            this.f29225a = str;
            this.f29226b = i3;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public boolean a() {
            return this.f29227c;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public float b(Density density) {
            return this.f29226b;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public String c() {
            return this.f29225a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SettingInt)) {
                return false;
            }
            SettingInt settingInt = (SettingInt) obj;
            return Intrinsics.areEqual(c(), settingInt.c()) && this.f29226b == settingInt.f29226b;
        }

        public int hashCode() {
            return (c().hashCode() * 31) + this.f29226b;
        }

        public String toString() {
            return "FontVariation.Setting(axisName='" + c() + "', value=" + this.f29226b + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class SettingTextUnit implements Setting {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f29228a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f29229b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f29230c;

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public boolean a() {
            return this.f29230c;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public float b(Density density) {
            if (density != null) {
                return TextUnit.h(this.f29229b) * density.K1();
            }
            InlineClassHelperKt.b("density must not be null");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public String c() {
            return this.f29228a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SettingTextUnit)) {
                return false;
            }
            SettingTextUnit settingTextUnit = (SettingTextUnit) obj;
            return Intrinsics.areEqual(c(), settingTextUnit.c()) && TextUnit.e(this.f29229b, settingTextUnit.f29229b);
        }

        public int hashCode() {
            return (c().hashCode() * 31) + TextUnit.i(this.f29229b);
        }

        public String toString() {
            return "FontVariation.Setting(axisName='" + c() + "', value=" + ((Object) TextUnit.l(this.f29229b)) + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Settings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f29231a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f29232b;

        public Settings(Setting... settingArr) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            boolean z2 = false;
            for (Setting setting : settingArr) {
                String strC = setting.c();
                Object arrayList = linkedHashMap.get(strC);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(strC, arrayList);
                }
                ((List) arrayList).add(setting);
            }
            ArrayList arrayList2 = new ArrayList();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                String str = (String) entry.getKey();
                List list = (List) entry.getValue();
                if (list.size() != 1) {
                    throw new IllegalArgumentException(('\'' + str + "' must be unique. Actual [ [" + CollectionsKt.joinToString$default(list, null, null, null, 0, null, null, 63, null) + ']').toString());
                }
                CollectionsKt.addAll(arrayList2, list);
            }
            ArrayList arrayList3 = new ArrayList(arrayList2);
            this.f29231a = arrayList3;
            int size = arrayList3.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    break;
                }
                if (((Setting) arrayList3.get(i3)).a()) {
                    z2 = true;
                    break;
                }
                i3++;
            }
            this.f29232b = z2;
        }

        public final boolean a() {
            return this.f29232b;
        }

        public final List b() {
            return this.f29231a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Settings) && Intrinsics.areEqual(this.f29231a, ((Settings) obj).f29231a);
        }

        public int hashCode() {
            return this.f29231a.hashCode();
        }
    }

    private FontVariation() {
    }

    public final Settings a(FontWeight fontWeight, int i3, Setting... settingArr) {
        SpreadBuilder spreadBuilder = new SpreadBuilder(3);
        spreadBuilder.a(c(fontWeight.n()));
        spreadBuilder.a(b(i3));
        spreadBuilder.b(settingArr);
        return new Settings((Setting[]) spreadBuilder.d(new Setting[spreadBuilder.c()]));
    }

    public final Setting b(float f3) {
        boolean z2 = false;
        if (0.0f <= f3 && f3 <= 1.0f) {
            z2 = true;
        }
        if (!z2) {
            InlineClassHelperKt.a("'ital' must be in 0.0f..1.0f. Actual: " + f3);
        }
        return new SettingFloat("ital", f3);
    }

    public final Setting c(int i3) {
        boolean z2 = false;
        if (1 <= i3 && i3 < 1001) {
            z2 = true;
        }
        if (!z2) {
            InlineClassHelperKt.a("'wght' value must be in [1, 1000]. Actual: " + i3);
        }
        return new SettingInt("wght", i3);
    }
}
