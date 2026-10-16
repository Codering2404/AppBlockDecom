package androidx.room;

import androidx.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class RoomSQLiteQuery implements SupportSQLiteQuery, SupportSQLiteProgram {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Companion f52354j = new Companion(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final TreeMap f52355k = new TreeMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f52356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile String f52357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long[] f52358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double[] f52359d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String[] f52360f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final byte[][] f52361g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int[] f52362h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f52363i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention
    public @interface Binding {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RoomSQLiteQuery a(String query, int i3) {
            Intrinsics.checkNotNullParameter(query, "query");
            TreeMap treeMap = RoomSQLiteQuery.f52355k;
            synchronized (treeMap) {
                Map.Entry entryCeilingEntry = treeMap.ceilingEntry(Integer.valueOf(i3));
                if (entryCeilingEntry == null) {
                    Unit unit = Unit.f139807a;
                    RoomSQLiteQuery roomSQLiteQuery = new RoomSQLiteQuery(i3, null);
                    roomSQLiteQuery.l(query, i3);
                    return roomSQLiteQuery;
                }
                treeMap.remove(entryCeilingEntry.getKey());
                RoomSQLiteQuery roomSQLiteQuery2 = (RoomSQLiteQuery) entryCeilingEntry.getValue();
                roomSQLiteQuery2.l(query, i3);
                Intrinsics.checkNotNull(roomSQLiteQuery2);
                return roomSQLiteQuery2;
            }
        }

        public final RoomSQLiteQuery b(SupportSQLiteQuery supportSQLiteQuery) {
            Intrinsics.checkNotNullParameter(supportSQLiteQuery, "supportSQLiteQuery");
            final RoomSQLiteQuery roomSQLiteQueryA = a(supportSQLiteQuery.b(), supportSQLiteQuery.a());
            supportSQLiteQuery.c(new SupportSQLiteProgram() { // from class: androidx.room.RoomSQLiteQuery$Companion$copyFrom$1
                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void A(int i3, long j3) {
                    roomSQLiteQueryA.A(i3, j3);
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void B(int i3, byte[] value) {
                    Intrinsics.checkNotNullParameter(value, "value");
                    roomSQLiteQueryA.B(i3, value);
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void D(int i3) {
                    roomSQLiteQueryA.D(i3);
                }

                @Override // java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    roomSQLiteQueryA.close();
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void s1(int i3, String value) {
                    Intrinsics.checkNotNullParameter(value, "value");
                    roomSQLiteQueryA.s1(i3, value);
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void t(int i3, double d3) {
                    roomSQLiteQueryA.t(i3, d3);
                }
            });
            return roomSQLiteQueryA;
        }

        public final void c() {
            TreeMap treeMap = RoomSQLiteQuery.f52355k;
            if (treeMap.size() <= 15) {
                return;
            }
            int size = treeMap.size() - 10;
            Iterator it = treeMap.descendingKeySet().iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (true) {
                int i3 = size - 1;
                if (size <= 0) {
                    return;
                }
                it.next();
                it.remove();
                size = i3;
            }
        }

        private Companion() {
        }
    }

    public /* synthetic */ RoomSQLiteQuery(int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3);
    }

    public static final RoomSQLiteQuery i(String str, int i3) {
        return f52354j.a(str, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(RoomSQLiteQuery roomSQLiteQuery, SQLiteStatement it) {
        Intrinsics.checkNotNullParameter(it, "it");
        roomSQLiteQuery.j(it);
        return Unit.f139807a;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void A(int i3, long j3) {
        this.f52362h[i3] = 2;
        this.f52358c[i3] = j3;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void B(int i3, byte[] value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f52362h[i3] = 5;
        this.f52361g[i3] = value;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void D(int i3) {
        this.f52362h[i3] = 1;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public int a() {
        return this.f52363i;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public String b() {
        String str = this.f52357b;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Required value was null.");
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void c(SupportSQLiteProgram statement) {
        Intrinsics.checkNotNullParameter(statement, "statement");
        int iA = a();
        if (1 > iA) {
            return;
        }
        int i3 = 1;
        while (true) {
            int i4 = this.f52362h[i3];
            if (i4 == 1) {
                statement.D(i3);
            } else if (i4 == 2) {
                statement.A(i3, this.f52358c[i3]);
            } else if (i4 == 3) {
                statement.t(i3, this.f52359d[i3]);
            } else if (i4 == 4) {
                String str = this.f52360f[i3];
                if (str == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                statement.s1(i3, str);
            } else if (i4 == 5) {
                byte[] bArr = this.f52361g[i3];
                if (bArr == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                statement.B(i3, bArr);
            }
            if (i3 == iA) {
                return;
            } else {
                i3++;
            }
        }
    }

    public final void j(SQLiteStatement statement) {
        Intrinsics.checkNotNullParameter(statement, "statement");
        int iA = a();
        if (1 > iA) {
            return;
        }
        int i3 = 1;
        while (true) {
            int i4 = this.f52362h[i3];
            if (i4 == 1) {
                statement.D(i3);
            } else if (i4 == 2) {
                statement.A(i3, this.f52358c[i3]);
            } else if (i4 == 3) {
                statement.t(i3, this.f52359d[i3]);
            } else if (i4 == 4) {
                String str = this.f52360f[i3];
                if (str == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                statement.p0(i3, str);
            } else if (i4 == 5) {
                byte[] bArr = this.f52361g[i3];
                if (bArr == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                statement.B(i3, bArr);
            }
            if (i3 == iA) {
                return;
            } else {
                i3++;
            }
        }
    }

    public final void k(RoomSQLiteQuery other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iA = other.a() + 1;
        System.arraycopy(other.f52362h, 0, this.f52362h, 0, iA);
        System.arraycopy(other.f52358c, 0, this.f52358c, 0, iA);
        System.arraycopy(other.f52360f, 0, this.f52360f, 0, iA);
        System.arraycopy(other.f52361g, 0, this.f52361g, 0, iA);
        System.arraycopy(other.f52359d, 0, this.f52359d, 0, iA);
    }

    public final void l(String query, int i3) {
        Intrinsics.checkNotNullParameter(query, "query");
        this.f52357b = query;
        this.f52363i = i3;
    }

    public final void m() {
        TreeMap treeMap = f52355k;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.f52356a), this);
            f52354j.c();
            Unit unit = Unit.f139807a;
        }
    }

    public final RoomRawQuery n() {
        return new RoomRawQuery(b(), new Function1() { // from class: androidx.room.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RoomSQLiteQuery.r(this.f52658a, (SQLiteStatement) obj);
            }
        });
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void s1(int i3, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f52362h[i3] = 4;
        this.f52360f[i3] = value;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void t(int i3, double d3) {
        this.f52362h[i3] = 3;
        this.f52359d[i3] = d3;
    }

    private RoomSQLiteQuery(int i3) {
        this.f52356a = i3;
        int i4 = i3 + 1;
        this.f52362h = new int[i4];
        this.f52358c = new long[i4];
        this.f52359d = new double[i4];
        this.f52360f = new String[i4];
        this.f52361g = new byte[i4][];
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
