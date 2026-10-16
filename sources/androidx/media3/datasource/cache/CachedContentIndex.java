package androidx.media3.datasource.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.AtomicFile;
import androidx.media3.common.util.Util;
import androidx.media3.database.DatabaseIOException;
import androidx.media3.database.DatabaseProvider;
import androidx.media3.database.VersionTable;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class CachedContentIndex {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap f42077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SparseArray f42078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SparseBooleanArray f42079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SparseBooleanArray f42080d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Storage f42081e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Storage f42082f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class DatabaseStorage implements Storage {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final String[] f42083e = {"id", "key", "metadata"};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DatabaseProvider f42084a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final SparseArray f42085b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f42086c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f42087d;

        private void i(SQLiteDatabase sQLiteDatabase, CachedContent cachedContent) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            CachedContentIndex.r(cachedContent.d(), new DataOutputStream(byteArrayOutputStream));
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Integer.valueOf(cachedContent.f42070a));
            contentValues.put("key", cachedContent.f42071b);
            contentValues.put("metadata", byteArray);
            sQLiteDatabase.replaceOrThrow((String) Assertions.e(this.f42087d), null, contentValues);
        }

        private static void j(DatabaseProvider databaseProvider, String str) throws DatabaseIOException {
            try {
                String strN = n(str);
                SQLiteDatabase writableDatabase = databaseProvider.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    VersionTable.c(writableDatabase, 1, str);
                    l(writableDatabase, strN);
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e3) {
                throw new DatabaseIOException(e3);
            }
        }

        private void k(SQLiteDatabase sQLiteDatabase, int i3) {
            sQLiteDatabase.delete((String) Assertions.e(this.f42087d), "id = ?", new String[]{Integer.toString(i3)});
        }

        private static void l(SQLiteDatabase sQLiteDatabase, String str) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        }

        private Cursor m() {
            return this.f42084a.getReadableDatabase().query((String) Assertions.e(this.f42087d), f42083e, null, null, null, null, null);
        }

        private static String n(String str) {
            return "ExoPlayerCacheIndex" + str;
        }

        private void o(SQLiteDatabase sQLiteDatabase) throws DatabaseIOException {
            VersionTable.d(sQLiteDatabase, 1, (String) Assertions.e(this.f42086c), 1);
            l(sQLiteDatabase, (String) Assertions.e(this.f42087d));
            sQLiteDatabase.execSQL("CREATE TABLE " + this.f42087d + " (id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)");
        }

        @Override // androidx.media3.datasource.cache.CachedContentIndex.Storage
        public boolean a() throws DatabaseIOException {
            try {
                return VersionTable.b(this.f42084a.getReadableDatabase(), 1, (String) Assertions.e(this.f42086c)) != -1;
            } catch (SQLException e3) {
                throw new DatabaseIOException(e3);
            }
        }

        @Override // androidx.media3.datasource.cache.CachedContentIndex.Storage
        public void b(HashMap map) throws DatabaseIOException {
            if (this.f42085b.size() == 0) {
                return;
            }
            try {
                SQLiteDatabase writableDatabase = this.f42084a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                for (int i3 = 0; i3 < this.f42085b.size(); i3++) {
                    try {
                        CachedContent cachedContent = (CachedContent) this.f42085b.valueAt(i3);
                        if (cachedContent == null) {
                            k(writableDatabase, this.f42085b.keyAt(i3));
                        } else {
                            i(writableDatabase, cachedContent);
                        }
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                }
                writableDatabase.setTransactionSuccessful();
                this.f42085b.clear();
                writableDatabase.endTransaction();
            } catch (SQLException e3) {
                throw new DatabaseIOException(e3);
            }
        }

        @Override // androidx.media3.datasource.cache.CachedContentIndex.Storage
        public void c(long j3) {
            String hexString = Long.toHexString(j3);
            this.f42086c = hexString;
            this.f42087d = n(hexString);
        }

        @Override // androidx.media3.datasource.cache.CachedContentIndex.Storage
        public void d(CachedContent cachedContent, boolean z2) {
            if (z2) {
                this.f42085b.delete(cachedContent.f42070a);
            } else {
                this.f42085b.put(cachedContent.f42070a, null);
            }
        }

        @Override // androidx.media3.datasource.cache.CachedContentIndex.Storage
        public void e(HashMap map) throws DatabaseIOException {
            try {
                SQLiteDatabase writableDatabase = this.f42084a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    o(writableDatabase);
                    Iterator it = map.values().iterator();
                    while (it.hasNext()) {
                        i(writableDatabase, (CachedContent) it.next());
                    }
                    writableDatabase.setTransactionSuccessful();
                    this.f42085b.clear();
                    writableDatabase.endTransaction();
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            } catch (SQLException e3) {
                throw new DatabaseIOException(e3);
            }
        }

        @Override // androidx.media3.datasource.cache.CachedContentIndex.Storage
        public void f(CachedContent cachedContent) {
            this.f42085b.put(cachedContent.f42070a, cachedContent);
        }

        @Override // androidx.media3.datasource.cache.CachedContentIndex.Storage
        public void g(HashMap map, SparseArray sparseArray) throws DatabaseIOException {
            Assertions.g(this.f42085b.size() == 0);
            try {
                if (VersionTable.b(this.f42084a.getReadableDatabase(), 1, (String) Assertions.e(this.f42086c)) != 1) {
                    SQLiteDatabase writableDatabase = this.f42084a.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        o(writableDatabase);
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                }
                Cursor cursorM = m();
                while (cursorM.moveToNext()) {
                    try {
                        CachedContent cachedContent = new CachedContent(cursorM.getInt(0), (String) Assertions.e(cursorM.getString(1)), CachedContentIndex.o(new DataInputStream(new ByteArrayInputStream(cursorM.getBlob(2)))));
                        map.put(cachedContent.f42071b, cachedContent);
                        sparseArray.put(cachedContent.f42070a, cachedContent.f42071b);
                    } finally {
                    }
                }
                cursorM.close();
            } catch (SQLiteException e3) {
                map.clear();
                sparseArray.clear();
                throw new DatabaseIOException(e3);
            }
        }

        @Override // androidx.media3.datasource.cache.CachedContentIndex.Storage
        public void h() throws DatabaseIOException {
            j(this.f42084a, (String) Assertions.e(this.f42086c));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface Storage {
        boolean a();

        void b(HashMap map);

        void c(long j3);

        void d(CachedContent cachedContent, boolean z2);

        void e(HashMap map);

        void f(CachedContent cachedContent);

        void g(HashMap map, SparseArray sparseArray);

        void h();
    }

    private CachedContent c(String str) {
        int iJ = j(this.f42078b);
        CachedContent cachedContent = new CachedContent(iJ, str);
        this.f42077a.put(str, cachedContent);
        this.f42078b.put(iJ, str);
        this.f42080d.put(iJ, true);
        this.f42081e.f(cachedContent);
        return cachedContent;
    }

    static int j(SparseArray sparseArray) {
        int size = sparseArray.size();
        int i3 = 0;
        int iKeyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (iKeyAt >= 0) {
            return iKeyAt;
        }
        while (i3 < size && i3 == sparseArray.keyAt(i3)) {
            i3++;
        }
        return i3;
    }

    public static boolean m(String str) {
        return str.startsWith("cached_content_index.exi");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static DefaultContentMetadata o(DataInputStream dataInputStream) throws IOException {
        int i3 = dataInputStream.readInt();
        HashMap map = new HashMap();
        for (int i4 = 0; i4 < i3; i4++) {
            String utf = dataInputStream.readUTF();
            int i5 = dataInputStream.readInt();
            if (i5 < 0) {
                throw new IOException("Invalid value size: " + i5);
            }
            int iMin = Math.min(i5, 10485760);
            byte[] bArrCopyOf = Util.f41614f;
            int i6 = 0;
            while (i6 != i5) {
                int i7 = i6 + iMin;
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, i7);
                dataInputStream.readFully(bArrCopyOf, i6, iMin);
                iMin = Math.min(i5 - i7, 10485760);
                i6 = i7;
            }
            map.put(utf, bArrCopyOf);
        }
        return new DefaultContentMetadata(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(DefaultContentMetadata defaultContentMetadata, DataOutputStream dataOutputStream) throws IOException {
        Set<Map.Entry> setH = defaultContentMetadata.h();
        dataOutputStream.writeInt(setH.size());
        for (Map.Entry entry : setH) {
            dataOutputStream.writeUTF((String) entry.getKey());
            byte[] bArr = (byte[]) entry.getValue();
            dataOutputStream.writeInt(bArr.length);
            dataOutputStream.write(bArr);
        }
    }

    public void d(String str, ContentMetadataMutations contentMetadataMutations) {
        CachedContent cachedContentK = k(str);
        if (cachedContentK.b(contentMetadataMutations)) {
            this.f42081e.f(cachedContentK);
        }
    }

    public int e(String str) {
        return k(str).f42070a;
    }

    public CachedContent f(String str) {
        return (CachedContent) this.f42077a.get(str);
    }

    public Collection g() {
        return Collections.unmodifiableCollection(this.f42077a.values());
    }

    public ContentMetadata h(String str) {
        CachedContent cachedContentF = f(str);
        return cachedContentF != null ? cachedContentF.d() : DefaultContentMetadata.f42097c;
    }

    public String i(int i3) {
        return (String) this.f42078b.get(i3);
    }

    public CachedContent k(String str) {
        CachedContent cachedContent = (CachedContent) this.f42077a.get(str);
        return cachedContent == null ? c(str) : cachedContent;
    }

    public void l(long j3) {
        Storage storage;
        this.f42081e.c(j3);
        Storage storage2 = this.f42082f;
        if (storage2 != null) {
            storage2.c(j3);
        }
        if (this.f42081e.a() || (storage = this.f42082f) == null || !storage.a()) {
            this.f42081e.g(this.f42077a, this.f42078b);
        } else {
            this.f42082f.g(this.f42077a, this.f42078b);
            this.f42081e.e(this.f42077a);
        }
        Storage storage3 = this.f42082f;
        if (storage3 != null) {
            storage3.h();
            this.f42082f = null;
        }
    }

    public void n(String str) {
        CachedContent cachedContent = (CachedContent) this.f42077a.get(str);
        if (cachedContent != null && cachedContent.g() && cachedContent.i()) {
            this.f42077a.remove(str);
            int i3 = cachedContent.f42070a;
            boolean z2 = this.f42080d.get(i3);
            this.f42081e.d(cachedContent, z2);
            if (z2) {
                this.f42078b.remove(i3);
                this.f42080d.delete(i3);
            } else {
                this.f42078b.put(i3, null);
                this.f42079c.put(i3, true);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void p() {
        UnmodifiableIterator it = ImmutableSet.u(this.f42077a.keySet()).iterator();
        while (it.hasNext()) {
            n((String) it.next());
        }
    }

    public void q() {
        this.f42081e.b(this.f42077a);
        int size = this.f42079c.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f42078b.remove(this.f42079c.keyAt(i3));
        }
        this.f42079c.clear();
        this.f42080d.clear();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class LegacyStorage implements Storage {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f42088a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Cipher f42089b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final SecretKeySpec f42090c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final SecureRandom f42091d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final AtomicFile f42092e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f42093f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private ReusableBufferedOutputStream f42094g;

        private int i(CachedContent cachedContent, int i3) {
            int i4;
            int iHashCode;
            int iHashCode2 = (cachedContent.f42070a * 31) + cachedContent.f42071b.hashCode();
            if (i3 < 2) {
                long jB = ContentMetadata.b(cachedContent.d());
                i4 = iHashCode2 * 31;
                iHashCode = (int) (jB ^ (jB >>> 32));
            } else {
                i4 = iHashCode2 * 31;
                iHashCode = cachedContent.d().hashCode();
            }
            return i4 + iHashCode;
        }

        private CachedContent j(int i3, DataInputStream dataInputStream) throws IOException {
            DefaultContentMetadata defaultContentMetadataO;
            int i4 = dataInputStream.readInt();
            String utf = dataInputStream.readUTF();
            if (i3 < 2) {
                long j3 = dataInputStream.readLong();
                ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
                ContentMetadataMutations.g(contentMetadataMutations, j3);
                defaultContentMetadataO = DefaultContentMetadata.f42097c.g(contentMetadataMutations);
            } else {
                defaultContentMetadataO = CachedContentIndex.o(dataInputStream);
            }
            return new CachedContent(i4, utf, defaultContentMetadataO);
        }

        private boolean k(HashMap map, SparseArray sparseArray) throws Throwable {
            BufferedInputStream bufferedInputStream;
            DataInputStream dataInputStream;
            if (!this.f42092e.c()) {
                return true;
            }
            DataInputStream dataInputStream2 = null;
            try {
                bufferedInputStream = new BufferedInputStream(this.f42092e.d());
                dataInputStream = new DataInputStream(bufferedInputStream);
            } catch (IOException unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                int i3 = dataInputStream.readInt();
                if (i3 >= 0 && i3 <= 2) {
                    if ((dataInputStream.readInt() & 1) != 0) {
                        if (this.f42089b == null) {
                            Util.o(dataInputStream);
                            return false;
                        }
                        byte[] bArr = new byte[16];
                        dataInputStream.readFully(bArr);
                        try {
                            this.f42089b.init(2, (Key) Util.k(this.f42090c), new IvParameterSpec(bArr));
                            dataInputStream = new DataInputStream(new CipherInputStream(bufferedInputStream, this.f42089b));
                        } catch (InvalidAlgorithmParameterException e3) {
                            e = e3;
                            throw new IllegalStateException(e);
                        } catch (InvalidKeyException e4) {
                            e = e4;
                            throw new IllegalStateException(e);
                        }
                    } else if (this.f42088a) {
                        this.f42093f = true;
                    }
                    int i4 = dataInputStream.readInt();
                    int i5 = 0;
                    for (int i6 = 0; i6 < i4; i6++) {
                        CachedContent cachedContentJ = j(i3, dataInputStream);
                        map.put(cachedContentJ.f42071b, cachedContentJ);
                        sparseArray.put(cachedContentJ.f42070a, cachedContentJ.f42071b);
                        i5 += i(cachedContentJ, i3);
                    }
                    int i7 = dataInputStream.readInt();
                    boolean z2 = dataInputStream.read() == -1;
                    if (i7 == i5 && z2) {
                        Util.o(dataInputStream);
                        return true;
                    }
                    Util.o(dataInputStream);
                    return false;
                }
                Util.o(dataInputStream);
                return false;
            } catch (IOException unused2) {
                dataInputStream2 = dataInputStream;
                if (dataInputStream2 != null) {
                    Util.o(dataInputStream2);
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                dataInputStream2 = dataInputStream;
                if (dataInputStream2 != null) {
                    Util.o(dataInputStream2);
                }
                throw th;
            }
        }

        private void l(CachedContent cachedContent, DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeInt(cachedContent.f42070a);
            dataOutputStream.writeUTF(cachedContent.f42071b);
            CachedContentIndex.r(cachedContent.d(), dataOutputStream);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        private void m(HashMap map) throws Throwable {
            ReusableBufferedOutputStream reusableBufferedOutputStream;
            DataOutputStream dataOutputStream;
            DataOutputStream dataOutputStream2 = null;
            try {
                OutputStream outputStreamF = this.f42092e.f();
                ReusableBufferedOutputStream reusableBufferedOutputStream2 = this.f42094g;
                if (reusableBufferedOutputStream2 == null) {
                    this.f42094g = new ReusableBufferedOutputStream(outputStreamF);
                } else {
                    reusableBufferedOutputStream2.a(outputStreamF);
                }
                reusableBufferedOutputStream = this.f42094g;
                dataOutputStream = new DataOutputStream(reusableBufferedOutputStream);
            } catch (Throwable th) {
                th = th;
            }
            try {
                dataOutputStream.writeInt(2);
                dataOutputStream.writeInt(this.f42088a ? 1 : 0);
                if (this.f42088a) {
                    byte[] bArr = new byte[16];
                    ((SecureRandom) Util.k(this.f42091d)).nextBytes(bArr);
                    dataOutputStream.write(bArr);
                    try {
                        ((Cipher) Util.k(this.f42089b)).init(1, (Key) Util.k(this.f42090c), new IvParameterSpec(bArr));
                        dataOutputStream.flush();
                        dataOutputStream = new DataOutputStream(new CipherOutputStream(reusableBufferedOutputStream, this.f42089b));
                    } catch (InvalidAlgorithmParameterException e3) {
                        e = e3;
                        throw new IllegalStateException(e);
                    } catch (InvalidKeyException e4) {
                        e = e4;
                        throw new IllegalStateException(e);
                    }
                }
                dataOutputStream.writeInt(map.size());
                int i3 = 0;
                for (CachedContent cachedContent : map.values()) {
                    l(cachedContent, dataOutputStream);
                    i3 += i(cachedContent, 2);
                }
                dataOutputStream.writeInt(i3);
                this.f42092e.b(dataOutputStream);
                Util.o(null);
            } catch (Throwable th2) {
                th = th2;
                dataOutputStream2 = dataOutputStream;
                Util.o(dataOutputStream2);
                throw th;
            }
        }

        @Override // androidx.media3.datasource.cache.CachedContentIndex.Storage
        public boolean a() {
            return this.f42092e.c();
        }

        @Override // androidx.media3.datasource.cache.CachedContentIndex.Storage
        public void b(HashMap map) throws Throwable {
            if (this.f42093f) {
                e(map);
            }
        }

        @Override // androidx.media3.datasource.cache.CachedContentIndex.Storage
        public void d(CachedContent cachedContent, boolean z2) {
            this.f42093f = true;
        }

        @Override // androidx.media3.datasource.cache.CachedContentIndex.Storage
        public void e(HashMap map) throws Throwable {
            m(map);
            this.f42093f = false;
        }

        @Override // androidx.media3.datasource.cache.CachedContentIndex.Storage
        public void f(CachedContent cachedContent) {
            this.f42093f = true;
        }

        @Override // androidx.media3.datasource.cache.CachedContentIndex.Storage
        public void g(HashMap map, SparseArray sparseArray) {
            Assertions.g(!this.f42093f);
            if (k(map, sparseArray)) {
                return;
            }
            map.clear();
            sparseArray.clear();
            this.f42092e.a();
        }

        @Override // androidx.media3.datasource.cache.CachedContentIndex.Storage
        public void h() {
            this.f42092e.a();
        }

        @Override // androidx.media3.datasource.cache.CachedContentIndex.Storage
        public void c(long j3) {
        }
    }
}
