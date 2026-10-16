package androidx.work.impl;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import androidx.work.Clock;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.PreferenceDao;
import androidx.work.impl.model.RawWorkInfoDao;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import java.util.concurrent.Executor;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public abstract class WorkDatabase extends RoomDatabase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f54663a = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final SupportSQLiteOpenHelper c(Context context, SupportSQLiteOpenHelper.Configuration configuration) {
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            SupportSQLiteOpenHelper.Configuration.Builder builderA = SupportSQLiteOpenHelper.Configuration.f53168f.a(context);
            builderA.d(configuration.f53170b).c(configuration.f53171c).e(true).a(true);
            return new FrameworkSQLiteOpenHelperFactory().a(builderA.b());
        }

        public final WorkDatabase b(final Context context, Executor queryExecutor, Clock clock, boolean z2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(queryExecutor, "queryExecutor");
            Intrinsics.checkNotNullParameter(clock, "clock");
            return (WorkDatabase) (z2 ? Room.b(context, WorkDatabase.class).c() : Room.a(context, WorkDatabase.class, "androidx.work.workdb").g(new SupportSQLiteOpenHelper.Factory() { // from class: androidx.work.impl.f
                @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
                public final SupportSQLiteOpenHelper a(SupportSQLiteOpenHelper.Configuration configuration) {
                    return WorkDatabase.Companion.c(context, configuration);
                }
            })).h(queryExecutor).a(new CleanupCallback(clock)).b(Migration_1_2.f54628c).b(new RescheduleMigration(context, 2, 3)).b(Migration_3_4.f54629c).b(Migration_4_5.f54630c).b(new RescheduleMigration(context, 5, 6)).b(Migration_6_7.f54631c).b(Migration_7_8.f54632c).b(Migration_8_9.f54633c).b(new WorkMigration9To10(context)).b(new RescheduleMigration(context, 10, 11)).b(Migration_11_12.f54624c).b(Migration_12_13.f54625c).b(Migration_15_16.f54626c).b(Migration_16_17.f54627c).f().d();
        }

        private Companion() {
        }
    }

    public abstract DependencyDao n();

    public abstract PreferenceDao o();

    public abstract RawWorkInfoDao p();

    public abstract SystemIdInfoDao q();

    public abstract WorkNameDao r();

    public abstract WorkProgressDao s();

    public abstract WorkSpecDao t();

    public abstract WorkTagDao u();
}
