package com.facebook.bolts;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public final class AggregateException extends Exception {
    public static final Companion Companion = new Companion(null);
    private static final long serialVersionUID = 1;
    private final List<Throwable> innerThrowables;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public AggregateException(String str, List<? extends Throwable> list) {
        super(str, (list == null || list.isEmpty()) ? null : list.get(0));
        List<Throwable> listUnmodifiableList = Collections.unmodifiableList(list == null ? CollectionsKt.emptyList() : list);
        Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(innerThrowables ?: emptyList())");
        this.innerThrowables = listUnmodifiableList;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream err) {
        Intrinsics.checkNotNullParameter(err, "err");
        super.printStackTrace(err);
        int i3 = -1;
        for (Throwable th : this.innerThrowables) {
            err.append("\n");
            err.append("  Inner throwable #");
            i3++;
            err.append((CharSequence) String.valueOf(i3));
            err.append(": ");
            if (th != null) {
                th.printStackTrace(err);
            }
            err.append("\n");
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter err) {
        Intrinsics.checkNotNullParameter(err, "err");
        super.printStackTrace(err);
        int i3 = -1;
        for (Throwable th : this.innerThrowables) {
            err.append("\n");
            err.append("  Inner throwable #");
            i3++;
            err.append((CharSequence) String.valueOf(i3));
            err.append(": ");
            if (th != null) {
                th.printStackTrace(err);
            }
            err.append("\n");
        }
    }
}
