package coil.memory;

import android.graphics.Bitmap;
import coil.memory.MemoryCache;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class RealWeakMemoryCache implements WeakMemoryCache {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f55969c = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashMap f55970a = new LinkedHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f55971b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class InternalValue {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f55972a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final WeakReference f55973b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Map f55974c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f55975d;

        public InternalValue(int i3, WeakReference weakReference, Map map, int i4) {
            this.f55972a = i3;
            this.f55973b = weakReference;
            this.f55974c = map;
            this.f55975d = i4;
        }

        public final WeakReference a() {
            return this.f55973b;
        }

        public final Map b() {
            return this.f55974c;
        }

        public final int c() {
            return this.f55972a;
        }

        public final int d() {
            return this.f55975d;
        }
    }

    private final void e() {
        int i3 = this.f55971b;
        this.f55971b = i3 + 1;
        if (i3 >= 10) {
            d();
        }
    }

    @Override // coil.memory.WeakMemoryCache
    public synchronized void a(int i3) {
        if (i3 >= 10 && i3 != 20) {
            d();
        }
    }

    @Override // coil.memory.WeakMemoryCache
    public synchronized MemoryCache.Value b(MemoryCache.Key key) {
        try {
            ArrayList arrayList = (ArrayList) this.f55970a.get(key);
            MemoryCache.Value value = null;
            if (arrayList == null) {
                return null;
            }
            int size = arrayList.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    break;
                }
                InternalValue internalValue = (InternalValue) arrayList.get(i3);
                Bitmap bitmap = (Bitmap) internalValue.a().get();
                MemoryCache.Value value2 = bitmap != null ? new MemoryCache.Value(bitmap, internalValue.b()) : null;
                if (value2 != null) {
                    value = value2;
                    break;
                }
                i3++;
            }
            e();
            return value;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // coil.memory.WeakMemoryCache
    public synchronized void c(MemoryCache.Key key, Bitmap bitmap, Map map, int i3) {
        try {
            LinkedHashMap linkedHashMap = this.f55970a;
            Object arrayList = linkedHashMap.get(key);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(key, arrayList);
            }
            ArrayList arrayList2 = (ArrayList) arrayList;
            int iIdentityHashCode = System.identityHashCode(bitmap);
            InternalValue internalValue = new InternalValue(iIdentityHashCode, new WeakReference(bitmap), map, i3);
            int size = arrayList2.size();
            int i4 = 0;
            while (true) {
                if (i4 >= size) {
                    arrayList2.add(internalValue);
                    break;
                }
                InternalValue internalValue2 = (InternalValue) arrayList2.get(i4);
                if (i3 < internalValue2.d()) {
                    i4++;
                } else if (internalValue2.c() == iIdentityHashCode && internalValue2.a().get() == bitmap) {
                    arrayList2.set(i4, internalValue);
                } else {
                    arrayList2.add(i4, internalValue);
                }
            }
            e();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void d() {
        WeakReference weakReferenceA;
        this.f55971b = 0;
        Iterator it = this.f55970a.values().iterator();
        while (it.hasNext()) {
            ArrayList arrayList = (ArrayList) it.next();
            if (arrayList.size() <= 1) {
                InternalValue internalValue = (InternalValue) CollectionsKt.firstOrNull((List) arrayList);
                if (((internalValue == null || (weakReferenceA = internalValue.a()) == null) ? null : (Bitmap) weakReferenceA.get()) == null) {
                    it.remove();
                }
            } else {
                int size = arrayList.size();
                int i3 = 0;
                for (int i4 = 0; i4 < size; i4++) {
                    int i5 = i4 - i3;
                    if (((InternalValue) arrayList.get(i5)).a().get() == null) {
                        arrayList.remove(i5);
                        i3++;
                    }
                }
                if (arrayList.isEmpty()) {
                    it.remove();
                }
            }
        }
    }
}
