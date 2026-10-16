package com.superwall.supercel;

import java.util.ArrayList;
import java.util.Map;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public interface Disposable {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final void destroy(Object... args) {
            Intrinsics.checkNotNullParameter(args, "args");
            for (Object obj : args) {
                if (obj instanceof Disposable) {
                    ((Disposable) obj).destroy();
                } else if (obj instanceof ArrayList) {
                    ArrayList arrayList = (ArrayList) obj;
                    int size = arrayList.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        Object obj2 = arrayList.get(i3);
                        if (obj2 instanceof Disposable) {
                            ((Disposable) obj2).destroy();
                        }
                    }
                } else if (obj instanceof Map) {
                    for (Object obj3 : ((Map) obj).values()) {
                        if (obj3 instanceof Disposable) {
                            ((Disposable) obj3).destroy();
                        }
                    }
                } else if (obj instanceof Iterable) {
                    for (Object obj4 : (Iterable) obj) {
                        if (obj4 instanceof Disposable) {
                            ((Disposable) obj4).destroy();
                        }
                    }
                }
            }
        }
    }

    void destroy();
}
