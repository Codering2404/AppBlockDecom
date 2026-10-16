package com.facebook.stetho.inspector.database;

import android.database.sqlite.SQLiteException;
import com.facebook.stetho.inspector.protocol.module.BaseDatabaseDriver;
import com.facebook.stetho.inspector.protocol.module.Database;
import com.facebook.stetho.inspector.protocol.module.DatabaseDescriptor;
import com.facebook.stetho.inspector.protocol.module.DatabaseDriver2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class DatabaseDriver2Adapter extends DatabaseDriver2<StringDatabaseDescriptor> {
    private final Database.DatabaseDriver mLegacy;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class StringDatabaseDescriptor implements DatabaseDescriptor {
        public final String name;

        public StringDatabaseDescriptor(String str) {
            this.name = str;
        }

        @Override // com.facebook.stetho.inspector.protocol.module.DatabaseDescriptor
        public String name() {
            return this.name;
        }
    }

    public DatabaseDriver2Adapter(Database.DatabaseDriver databaseDriver) {
        super(databaseDriver.getContext());
        this.mLegacy = databaseDriver;
    }

    @Override // com.facebook.stetho.inspector.protocol.module.BaseDatabaseDriver
    public List<StringDatabaseDescriptor> getDatabaseNames() {
        List<String> databaseNames = this.mLegacy.getDatabaseNames();
        ArrayList arrayList = new ArrayList(databaseNames.size());
        Iterator<String> it = databaseNames.iterator();
        while (it.hasNext()) {
            arrayList.add(new StringDatabaseDescriptor(it.next().toString()));
        }
        return arrayList;
    }

    @Override // com.facebook.stetho.inspector.protocol.module.BaseDatabaseDriver
    public Database.ExecuteSQLResponse executeSQL(StringDatabaseDescriptor stringDatabaseDescriptor, String str, BaseDatabaseDriver.ExecuteResultHandler executeResultHandler) throws SQLiteException {
        return this.mLegacy.executeSQL(stringDatabaseDescriptor.name, str, executeResultHandler);
    }

    @Override // com.facebook.stetho.inspector.protocol.module.BaseDatabaseDriver
    public List<String> getTableNames(StringDatabaseDescriptor stringDatabaseDescriptor) {
        return this.mLegacy.getTableNames(stringDatabaseDescriptor.name);
    }
}
