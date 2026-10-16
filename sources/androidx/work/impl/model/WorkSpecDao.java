package androidx.work.impl.model;

import androidx.lifecycle.LiveData;
import androidx.work.Data;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import java.util.List;
import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public interface WorkSpecDao {
    boolean A();

    List B();

    int C(String str);

    List D(String str);

    LiveData E(List list);

    int F(String str);

    int G();

    void H(String str, int i3);

    List I(List list);

    void a(String str, int i3);

    void b(WorkSpec workSpec);

    void c(String str);

    void d();

    void e(String str);

    List f(long j3);

    void g(WorkSpec workSpec);

    List h();

    List i(String str);

    WorkSpec.WorkInfoPojo j(String str);

    WorkInfo.State k(String str);

    WorkSpec l(String str);

    int m(String str);

    List n(String str);

    List o(String str);

    List p(String str);

    List q(int i3);

    int r();

    int s(String str, long j3);

    List t(String str);

    List u(int i3);

    int v(WorkInfo.State state, String str);

    void w(String str, Data data);

    void x(String str, long j3);

    List y();

    List z();
}
