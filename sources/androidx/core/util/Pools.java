package androidx.core.util;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class Pools {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Pool<T> {
        Object a();

        boolean b(Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class SimplePool<T> implements Pool<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object[] f34352a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f34353b;

        public SimplePool(int i3) {
            if (i3 <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f34352a = new Object[i3];
        }

        private final boolean c(Object obj) {
            int i3 = this.f34353b;
            for (int i4 = 0; i4 < i3; i4++) {
                if (this.f34352a[i4] == obj) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.core.util.Pools.Pool
        public Object a() {
            int i3 = this.f34353b;
            if (i3 <= 0) {
                return null;
            }
            int i4 = i3 - 1;
            Object obj = this.f34352a[i4];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
            this.f34352a[i4] = null;
            this.f34353b--;
            return obj;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean b(Object instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            if (c(instance)) {
                throw new IllegalStateException("Already in the pool!");
            }
            int i3 = this.f34353b;
            Object[] objArr = this.f34352a;
            if (i3 >= objArr.length) {
                return false;
            }
            objArr[i3] = instance;
            this.f34353b = i3 + 1;
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class SynchronizedPool<T> extends SimplePool<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Object f34354c;

        public SynchronizedPool(int i3) {
            super(i3);
            this.f34354c = new Object();
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public Object a() {
            Object objA;
            synchronized (this.f34354c) {
                objA = super.a();
            }
            return objA;
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public boolean b(Object instance) {
            boolean zB;
            Intrinsics.checkNotNullParameter(instance, "instance");
            synchronized (this.f34354c) {
                zB = super.b(instance);
            }
            return zB;
        }
    }
}
