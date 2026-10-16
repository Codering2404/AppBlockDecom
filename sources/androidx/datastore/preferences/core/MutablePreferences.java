package androidx.datastore.preferences.core;

import androidx.datastore.preferences.core.Preferences;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
public final class MutablePreferences extends Preferences {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f35939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f35940b;

    public /* synthetic */ MutablePreferences(Map map, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new LinkedHashMap() : map, (i3 & 2) != 0 ? true : z2);
    }

    @Override // androidx.datastore.preferences.core.Preferences
    public Map a() {
        Pair pair;
        Set<Map.Entry> setEntrySet = this.f35939a.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
        for (Map.Entry entry : setEntrySet) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                Object key = entry.getKey();
                byte[] bArr = (byte[]) value;
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(this, size)");
                pair = new Pair(key, bArrCopyOf);
            } else {
                pair = new Pair(entry.getKey(), entry.getValue());
            }
            linkedHashMap.put(pair.e(), pair.f());
        }
        return Actual_jvmAndroidKt.b(linkedHashMap);
    }

    @Override // androidx.datastore.preferences.core.Preferences
    public boolean b(Preferences.Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.f35939a.containsKey(key);
    }

    @Override // androidx.datastore.preferences.core.Preferences
    public Object c(Preferences.Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = this.f35939a.get(key);
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(this, size)");
        return bArrCopyOf;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.datastore.preferences.core.MutablePreferences
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            androidx.datastore.preferences.core.MutablePreferences r6 = (androidx.datastore.preferences.core.MutablePreferences) r6
            java.util.Map r0 = r6.f35939a
            java.util.Map r2 = r5.f35939a
            r3 = 1
            if (r0 != r2) goto L10
            return r3
        L10:
            int r0 = r0.size()
            java.util.Map r2 = r5.f35939a
            int r2 = r2.size()
            if (r0 == r2) goto L1d
            return r1
        L1d:
            java.util.Map r6 = r6.f35939a
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L26
            return r3
        L26:
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L2e:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L67
            java.lang.Object r0 = r6.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.util.Map r2 = r5.f35939a
            java.lang.Object r4 = r0.getKey()
            java.lang.Object r2 = r2.get(r4)
            if (r2 == 0) goto L63
            java.lang.Object r0 = r0.getValue()
            boolean r4 = r0 instanceof byte[]
            if (r4 == 0) goto L5e
            boolean r4 = r2 instanceof byte[]
            if (r4 == 0) goto L63
            byte[] r0 = (byte[]) r0
            byte[] r2 = (byte[]) r2
            boolean r0 = java.util.Arrays.equals(r0, r2)
            if (r0 == 0) goto L63
            r0 = r3
            goto L64
        L5e:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
            goto L64
        L63:
            r0 = r1
        L64:
            if (r0 != 0) goto L2e
            return r1
        L67:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.core.MutablePreferences.equals(java.lang.Object):boolean");
    }

    public final void f() {
        if (this.f35940b.a()) {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.");
        }
    }

    public final void g() {
        f();
        this.f35939a.clear();
    }

    public final void h() {
        this.f35940b.b(true);
    }

    public int hashCode() {
        Iterator it = this.f35939a.entrySet().iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object value = ((Map.Entry) it.next()).getValue();
            iHashCode += value instanceof byte[] ? Arrays.hashCode((byte[]) value) : value.hashCode();
        }
        return iHashCode;
    }

    public final void i(Preferences.Pair... pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        f();
        for (Preferences.Pair pair : pairs) {
            l(pair.a(), pair.b());
        }
    }

    public final Object j(Preferences.Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        f();
        return this.f35939a.remove(key);
    }

    public final void k(Preferences.Key key, Object obj) {
        Intrinsics.checkNotNullParameter(key, "key");
        l(key, obj);
    }

    public final void l(Preferences.Key key, Object obj) {
        Intrinsics.checkNotNullParameter(key, "key");
        f();
        if (obj == null) {
            j(key);
            return;
        }
        if (obj instanceof Set) {
            this.f35939a.put(key, Actual_jvmAndroidKt.a((Set) obj));
            return;
        }
        if (!(obj instanceof byte[])) {
            this.f35939a.put(key, obj);
            return;
        }
        Map map = this.f35939a;
        byte[] bArr = (byte[]) obj;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(this, size)");
        map.put(key, bArrCopyOf);
    }

    public String toString() {
        return CollectionsKt.joinToString$default(this.f35939a.entrySet(), ",\n", "{\n", "\n}", 0, null, new Function1<Map.Entry<Preferences.Key<?>, Object>, CharSequence>() { // from class: androidx.datastore.preferences.core.MutablePreferences.toString.1
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final CharSequence invoke(Map.Entry entry) {
                Intrinsics.checkNotNullParameter(entry, "entry");
                Object value = entry.getValue();
                return "  " + ((Preferences.Key) entry.getKey()).a() + " = " + (value instanceof byte[] ? ArraysKt.joinToString$default((byte[]) value, (CharSequence) ", ", (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null) : String.valueOf(entry.getValue()));
            }
        }, 24, null);
    }

    public MutablePreferences(Map preferencesMap, boolean z2) {
        Intrinsics.checkNotNullParameter(preferencesMap, "preferencesMap");
        this.f35939a = preferencesMap;
        this.f35940b = new AtomicBoolean(z2);
    }
}
