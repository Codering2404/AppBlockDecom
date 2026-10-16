package androidx.room;

import androidx.room.InvalidationTracker;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public final class ObserverWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InvalidationTracker.Observer f52243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f52244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String[] f52245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set f52246d;

    public ObserverWrapper(InvalidationTracker.Observer observer, int[] tableIds, String[] tableNames) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        Intrinsics.checkNotNullParameter(tableIds, "tableIds");
        Intrinsics.checkNotNullParameter(tableNames, "tableNames");
        this.f52243a = observer;
        this.f52244b = tableIds;
        this.f52245c = tableNames;
        if (tableIds.length != tableNames.length) {
            throw new IllegalStateException("Check failed.");
        }
        this.f52246d = !(tableNames.length == 0) ? SetsKt.setOf(tableNames[0]) : SetsKt.emptySet();
    }

    public final InvalidationTracker.Observer a() {
        return this.f52243a;
    }

    public final int[] b() {
        return this.f52244b;
    }

    public final void c(Set invalidatedTablesIds) {
        Set setEmptySet;
        Intrinsics.checkNotNullParameter(invalidatedTablesIds, "invalidatedTablesIds");
        int[] iArr = this.f52244b;
        int length = iArr.length;
        if (length != 0) {
            int i3 = 0;
            if (length != 1) {
                Set setCreateSetBuilder = SetsKt.createSetBuilder();
                int[] iArr2 = this.f52244b;
                int length2 = iArr2.length;
                int i4 = 0;
                while (i3 < length2) {
                    int i5 = i4 + 1;
                    if (invalidatedTablesIds.contains(Integer.valueOf(iArr2[i3]))) {
                        setCreateSetBuilder.add(this.f52245c[i4]);
                    }
                    i3++;
                    i4 = i5;
                }
                setEmptySet = SetsKt.build(setCreateSetBuilder);
            } else {
                setEmptySet = invalidatedTablesIds.contains(Integer.valueOf(iArr[0])) ? this.f52246d : SetsKt.emptySet();
            }
        } else {
            setEmptySet = SetsKt.emptySet();
        }
        if (setEmptySet.isEmpty()) {
            return;
        }
        this.f52243a.c(setEmptySet);
    }

    public final void d(Set invalidatedTablesNames) {
        Set setEmptySet;
        Intrinsics.checkNotNullParameter(invalidatedTablesNames, "invalidatedTablesNames");
        int length = this.f52245c.length;
        if (length == 0) {
            setEmptySet = SetsKt.emptySet();
        } else if (length != 1) {
            Set setCreateSetBuilder = SetsKt.createSetBuilder();
            Iterator it = invalidatedTablesNames.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                String[] strArr = this.f52245c;
                int length2 = strArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 < length2) {
                        String str2 = strArr[i3];
                        if (StringsKt.F(str2, str, true)) {
                            setCreateSetBuilder.add(str2);
                            break;
                        }
                        i3++;
                    }
                }
            }
            setEmptySet = SetsKt.build(setCreateSetBuilder);
        } else {
            Set set = invalidatedTablesNames;
            if ((set instanceof Collection) && set.isEmpty()) {
                setEmptySet = SetsKt.emptySet();
            } else {
                Iterator it2 = set.iterator();
                while (it2.hasNext()) {
                    if (StringsKt.F((String) it2.next(), this.f52245c[0], true)) {
                        setEmptySet = this.f52246d;
                        break;
                    }
                }
                setEmptySet = SetsKt.emptySet();
            }
        }
        if (setEmptySet.isEmpty()) {
            return;
        }
        this.f52243a.c(setEmptySet);
    }
}
