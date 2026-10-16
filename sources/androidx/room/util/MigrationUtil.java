package androidx.room.util;

import androidx.room.DatabaseConfiguration;
import androidx.room.RoomDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class MigrationUtil {
    public static final boolean a(RoomDatabase.MigrationContainer migrationContainer, int i3, int i4) {
        Intrinsics.checkNotNullParameter(migrationContainer, "<this>");
        Map mapE = migrationContainer.e();
        if (!mapE.containsKey(Integer.valueOf(i3))) {
            return false;
        }
        Map mapEmptyMap = (Map) mapE.get(Integer.valueOf(i3));
        if (mapEmptyMap == null) {
            mapEmptyMap = MapsKt.emptyMap();
        }
        return mapEmptyMap.containsKey(Integer.valueOf(i4));
    }

    public static final List b(RoomDatabase.MigrationContainer migrationContainer, int i3, int i4) {
        Intrinsics.checkNotNullParameter(migrationContainer, "<this>");
        if (i3 == i4) {
            return CollectionsKt.emptyList();
        }
        return c(migrationContainer, new ArrayList(), i4 > i3, i3, i4);
    }

    private static final List c(RoomDatabase.MigrationContainer migrationContainer, List list, boolean z2, int i3, int i4) {
        int iIntValue;
        boolean z3;
        while (true) {
            if (z2) {
                if (i3 >= i4) {
                    return list;
                }
            } else if (i3 <= i4) {
                return list;
            }
            Pair pairF = z2 ? migrationContainer.f(i3) : migrationContainer.g(i3);
            if (pairF == null) {
                return null;
            }
            Map map = (Map) pairF.a();
            Iterator it = ((Iterable) pairF.b()).iterator();
            while (it.hasNext()) {
                iIntValue = ((Number) it.next()).intValue();
                if (!z2) {
                    if (i4 <= iIntValue && iIntValue < i3) {
                        Object obj = map.get(Integer.valueOf(iIntValue));
                        Intrinsics.checkNotNull(obj);
                        list.add(obj);
                        z3 = true;
                        break;
                    }
                } else if (i3 + 1 <= iIntValue && iIntValue <= i4) {
                    Object obj2 = map.get(Integer.valueOf(iIntValue));
                    Intrinsics.checkNotNull(obj2);
                    list.add(obj2);
                    z3 = true;
                    break;
                }
            }
            iIntValue = i3;
            z3 = false;
            if (!z3) {
                return null;
            }
            i3 = iIntValue;
        }
    }

    public static final boolean d(DatabaseConfiguration databaseConfiguration, int i3, int i4) {
        Intrinsics.checkNotNullParameter(databaseConfiguration, "<this>");
        if (i3 > i4 && databaseConfiguration.f52138l) {
            return false;
        }
        Set setC = databaseConfiguration.c();
        return databaseConfiguration.f52137k && (setC == null || !setC.contains(Integer.valueOf(i3)));
    }
}
