package com.superwall.sdk.storage.core_data;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.superwall.sdk.storage.core_data.entities.ManagedEventDataDao;
import com.superwall.sdk.storage.core_data.entities.ManagedTriggerRuleOccurrenceDao;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class SuperwallDatabase extends RoomDatabase {
    public static final Companion Companion = new Companion(null);
    private static volatile SuperwallDatabase INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SuperwallDatabase getDatabase(Context context) {
            SuperwallDatabase superwallDatabase;
            Intrinsics.checkNotNullParameter(context, "context");
            SuperwallDatabase superwallDatabase2 = SuperwallDatabase.INSTANCE;
            if (superwallDatabase2 != null) {
                return superwallDatabase2;
            }
            synchronized (this) {
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                superwallDatabase = (SuperwallDatabase) Room.a(applicationContext, SuperwallDatabase.class, "superwall_database").d();
                SuperwallDatabase.INSTANCE = superwallDatabase;
            }
            return superwallDatabase;
        }

        private Companion() {
        }
    }

    public abstract ManagedEventDataDao managedEventDataDao();

    public abstract ManagedTriggerRuleOccurrenceDao managedTriggerRuleOccurrenceDao();
}
