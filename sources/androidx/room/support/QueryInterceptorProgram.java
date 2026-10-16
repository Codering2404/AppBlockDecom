package androidx.room.support;

import androidx.sqlite.db.SupportSQLiteProgram;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
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
public final class QueryInterceptorProgram implements SupportSQLiteProgram {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f52831a = new ArrayList();

    private final void b(int i3, Object obj) {
        int size;
        int i4 = i3 - 1;
        if (i4 >= this.f52831a.size() && (size = this.f52831a.size()) <= i4) {
            while (true) {
                this.f52831a.add(null);
                if (size == i4) {
                    break;
                } else {
                    size++;
                }
            }
        }
        this.f52831a.set(i4, obj);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void A(int i3, long j3) {
        b(i3, Long.valueOf(j3));
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void B(int i3, byte[] value) {
        Intrinsics.checkNotNullParameter(value, "value");
        b(i3, value);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void D(int i3) {
        b(i3, null);
    }

    public final List a() {
        return this.f52831a;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void s1(int i3, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        b(i3, value);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void t(int i3, double d3) {
        b(i3, Double.valueOf(d3));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
