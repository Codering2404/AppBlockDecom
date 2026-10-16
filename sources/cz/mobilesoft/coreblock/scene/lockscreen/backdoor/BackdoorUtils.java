package cz.mobilesoft.coreblock.scene.lockscreen.backdoor;

import android.util.Log;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
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
public final class BackdoorUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BackdoorUtils f105650a = new BackdoorUtils();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class UnlockType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ UnlockType[] $VALUES;
        public static final UnlockType StrictMode = new UnlockType("StrictMode", 0);
        public static final UnlockType AppPin = new UnlockType("AppPin", 1);

        private static final /* synthetic */ UnlockType[] $values() {
            return new UnlockType[]{StrictMode, AppPin};
        }

        static {
            UnlockType[] unlockTypeArr$values = $values();
            $VALUES = unlockTypeArr$values;
            $ENTRIES = EnumEntriesKt.a(unlockTypeArr$values);
        }

        private UnlockType(String str, int i3) {
        }

        public static EnumEntries<UnlockType> getEntries() {
            return $ENTRIES;
        }

        public static UnlockType valueOf(String str) {
            return (UnlockType) Enum.valueOf(UnlockType.class, str);
        }

        public static UnlockType[] values() {
            return (UnlockType[]) $VALUES.clone();
        }
    }

    private BackdoorUtils() {
    }

    public static /* synthetic */ void c(BackdoorUtils backdoorUtils, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = UnlockType.getEntries();
        }
        backdoorUtils.b(list);
    }

    public final int a(int i3, int i4, long j3) {
        int i5;
        if ((i4 < 3 && i3 == 0) || (5 <= i4 && i4 < 7 && i3 == 1)) {
            i5 = i4 + 1;
        } else if (i4 == 7 && i3 == 2) {
            i5 = i4 + 1;
            c(this, null, 1, null);
        } else {
            i5 = ((((long) 20000) + j3 < System.currentTimeMillis() || j3 + ((long) 30000) > System.currentTimeMillis()) && i4 == 3 && i3 == 1) ? i4 + 2 : 0;
        }
        Log.d(BackdoorUtils.class.getName(), "count: " + i5 + " order: " + i3);
        return i5;
    }

    public final void b(List unlockTypes) {
        Intrinsics.checkNotNullParameter(unlockTypes, "unlockTypes");
        CoroutinesHelperExtKt.d(new BackdoorUtils$unlock$1(unlockTypes, null));
    }
}
